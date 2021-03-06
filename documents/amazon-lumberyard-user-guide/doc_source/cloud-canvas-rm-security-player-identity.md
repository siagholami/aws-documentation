# Player Identity<a name="cloud-canvas-rm-security-player-identity"></a>

A Lumberyard cloud\-connected game must use AWS credentials that grant the desired access when calling AWS APIs \(using either the C\+\+ AWS SDK or the AWS flow nodes\)\. Cloud Canvas uses an [Amazon Cognito identity pool](https://docs.aws.amazon.com/cognito/latest/developerguide/identity-pools.html) to get these credentials\.

Using a Amazon Cognito identity pool has the benefit of providing the game with a unique identity for each individual player\. This identity can be used to associate the player with their saved games, high scores, or any other data stored in DynamoDB tables, Amazon S3 buckets, or other locations\. If you use the Player Account Cloud Gem, this identity is mapped to an account ID that can be used instead\.

Amazon Cognito identity pools support both unauthenticated and authenticated identities\. Unauthenticated identities are associated with a single device such as a PC, tablet, or phone, and have no associated user name or password\.

Authenticated identities are associated with the identity of an player as determined by an external identity provider such as Amazon, Facebook, or Google, or an Amazon Cognito user pool\. This allows Amazon Cognito to provide the game with the same player identity everywhere a player plays a game\. The player's saved games, high scores, and other data effectively follow the player from device to device\.

Cloud Canvas supports both anonymous \(unauthenticated\) and authenticated player identities\. The Player Account Cloud Gem is the easiest way to add authentication\. Authenticated identity support for other providers is more complex and requires additional setup and coding\.

## Anonymous \(Unauthenticated\) Player Login<a name="cloud-canvas-anonymous-unauthenticated-player-login"></a>

In Lumberyard version 1\.11, the identity system that previously existed in an LmbrAWS CryEngine module \(`\dev\Code\CryEngine\CryCommon\LmbrAWS`\) has been converted into a `CloudCanvasPlayerIdentityComponent` \(`\dev\Gems\CloudGemFramework\vN\Code\Source\PlayerIdentity.*`\)\. This component is implemented as a required system component from the CloudGemFramework Gem\. The Cloud Canvas client configuration system is automatically initialized by the following call:

```
EBUS_EVENT_RESULT(appliedConfiguration, CloudGemFramework::CloudCanvasPlayerIdentityBus, ApplyConfiguration)
```

Alternatively, you can use a Cloud Canvas `(AWS):Configuration:ApplyConfiguration` flow node\. An existing anonymous identity is loaded from the local identities cache\. If an anonymous identity is not found in the cache, a new identity is acquired from the pool\. The identity cache is stored in an `.aws/.identities` file in the user's home directory\.

## Authenticated Player Login<a name="cloud-canvas-authenticated-player-login"></a>

In order to understand how to use Cloud Canvas to implement authenticated player identities for your game, you must be familiar with Amazon Cognito's Enhanced \(Simplified\) Authflow\. For information, see the article [Authentication Flow](https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-authentication-flow.html) in the [Amazon Cognito Developer Guide](https://docs.aws.amazon.com/cognito/latest/developerguide/what-is-amazon-cognito.html)\.

The login process for authenticated player identities is more complex than the anonymous player login process\. The Player Account Cloud Gem handles this for Amazon Cognito user pools\. For other providers, this login process requires additional setup beyond what Cloud Canvas provides by default\.

The authenticated player login process takes place automatically when the Cloud Canvas client configuration system is initialized by the following call:

```
EBUS_EVENT_RESULT(appliedConfiguration, CloudGemFramework::CloudCanvasPlayerIdentityBus, ApplyConfiguration)
```

Alternatively, the process can occur by using a Cloud Canvas `(AWS):Configuration:ApplyConfiguration` flow node\. If an authenticated identity is found in the local identities cache, it is loaded and the access token is refreshed if needed using the stored refresh token\. If no existing identity is found, it falls back to using the anonymous identity for AWS calls\.

The code that implements the authenticated login flow can be found in the `\dev\Gems\CloudGemFramework\vN\Code\Source\Identity` directory\. A description of the files follows\.
+ **`ResourceManagementLambdaBasedTokenRetrievalStrategy.cpp`** ??? Implements the token exchange process that calls the `PlayerAccessTokenExchange` Lambda function\.

  ??
+ **`TokenRetrievingPersistentIdentityProvider.cpp`** ??? An implementation of the `PersistentCognitoIdentityProvider` interface that is defined in the AWS SDK\. The implementation uses `ResourceManagementLambdaBasedTokenRetrievalStrategy` instances to implement the token exchange process\.

  ??

### Configuring a Cognito Identity Provider \(Cognito User Pool\)<a name="cloud-canvas-rm-security-player-cognito-user-pool"></a>

Cloud Canvas provides the [Custom::CognitoUserPool](cloud-canvas-custom-resources.md#cloud-canvas-custom-resources-cognito-identity-pool) resource for adding the Amazon Cognito user pools and linking them to a Amazon Cognito identity pool\. The [Player Account Cloud Gem](cloud-canvas-cloud-gem-player-account.md) uses this custom resource\. It also provides an EBus interface so that you can work with the user pool and the sample level that has an in\-game menu\.

### Configuring External Identity Providers<a name="cloud-canvas-configuring-external-identity-providers"></a>

Cloud Canvas does not automate the process of retrieving an auth code from an external identity provider\. This is your responsibility as a game developer\. After retrieving the auth code, make the following call:

```
EBUS_EVENT_RESULT(wasSuccess, CloudGemFramework::CloudCanvasPlayerIdentityBus, Login, const char* authProvider, const char* authCode)
```

External identity providers are configured using the `lmbr_aws` [login\-provider add](cloud-canvas-command-line.md#cloud-canvas-command-line-login-provider-add), [login\-provider update](cloud-canvas-command-line.md#cloud-canvas-command-line-login-provider-update), and [login\-provider remove](cloud-canvas-command-line.md#cloud-canvas-command-line-login-provider-remove) commands\. These commands save the configuration in a `/player-access/auth-settings.json` object in the project's configuration bucket so that the `PlayerAccessTokenExchange` Lambda function can access it\.

**Note**  
You must run `lmbr_aws project update` after running `login-provider add`, `login-provider update`, or `login-provider remove` so that the [PlayerAccessIdentityPool](cloud-canvas-resource-definitions.md#cloud-canvas-deployment-access-template-player-access-identity-pool-resource) resource configuration will be updated to reflect the change\.

### Automatic Token Refresh<a name="cloud-canvas-token-refresh"></a>

When using Amazon Cognito with external identity providers, it is necessary to periodically refresh the token from that provider and then get updated credentials for that token from Amazon Cognito\. Cloud Canvas performs this token refresh process automatically by using the `PlayerAccessTokenExchange` Lambda function\.