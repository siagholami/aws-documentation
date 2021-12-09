# AWS CodeArtifact authentication and tokens<a name="tokens-authentication"></a>

CodeArtifact requires users to authenticate with the service in order to publish or consume package versions\. You must authenticate to the CodeArtifact service by creating an authorization token using your AWS credentials\. In order to create an authorization token, you must have the correct permissions\. For more information on CodeArtifact permissions, see [Overview of managing access permissions to your AWS CodeArtifact resources](auth-and-access-control-iam-access-control-identity-based.md)\.

To fetch an authorization token from CodeArtifact, you must call the [GetAuthorizationToken API](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_GetAuthorizationToken.html)\. Using the AWS CLI, you can call `GetAuthorizationToken` with the `login` or `get-authorization-token` command\.
+ `aws codeartifact login` \(npm, pip, and twine\): This command makes it easy to configure common package managers to use CodeArtifact in a single step\. Calling `login` fetches a token with `GetAuthorizationToken` and configures your package manager with the token and correct CodeArtifact repository endpoint\.
+ `aws codeartifact get-authorization-token`: For package managers not supported by `login`, you can call `get-authorization-token` directly and then configure your package manager with the token as required, for example, by adding it to a configuration file or storing it an environment variable\.

CodeArtifact authorization tokens are valid for a default period of 12 hours\. Tokens can be configured with a lifetime between 15 minutes and 12 hours\. When the lifetime expires, you must fetch another token\. The token lifetime begins after `login` or `get-authorization-token` is called\.

If `login` or `get-authorization-token` is called while assuming a role, you can configure the lifetime of the token to be equal to the remaining time in the session duration of the role by setting the value of `--duration-seconds` \(for `login`\) or `--durationSeconds` \(for `get-authorization-token`\) to `0`\. Otherwise, the token lifetime is independent of the maximum session duration of the role\. For example, suppose that you call `sts assume-role` and specify a session duration of 15 minutes, and then call `login` to fetch an CodeArtifact authorization token\. In this case, the token is valid for the full 12\-hour period even though this is longer than the 15\-minute session duration\. For information about controlling session duration, see [Using IAM Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use.html) in the *IAM User Guide*\.

## Tokens created with the `login` command<a name="auth-token-login"></a>

The `aws codeartifact login` command will fetch a token with `GetAuthorizationToken` and configure your package manager with the token and correct CodeArtifact repository endpoint\.

The following table describes the parameters for the `login` command\.


****  

| Parameter | Required | Description | 
| --- | --- | --- | 
| `--tool` | Yes | The package manager to authenticate to\. Possible values are `maven`, `npm`, and `pip`\. | 
| `--domain` | Yes | The domain name that the repository belongs to\. | 
| `--domain-owner` | No | The ID of the owner of the domain\. This parameter is required if accessing a domain that is owned by an AWS account that you are not authenticated to\. For more information, see [Cross\-account domains](domain-overview.md#domain-overview-cross-account)\. | 
| `--repository` | Yes | The name of the repository to authenticate to\. | 
| `--duration-seconds` | No | The time, in seconds, that the login information is valid\. The minimum value is 900\* and maximum value is 43200\. | 
| `--dry-run` | No | Only print the commands that would be executed to connect your tool with your repository without making any changes to your configuration\. | 
| \*A value of 0 is also valid when calling `login` while assuming a role\. Calling `login` with `--duration-seconds 0` creates a token with a lifetime equal to the remaining time in the session duration of an assumed role\. | 

The following example shows how to fetch an authorization token with the `login` command\.

```
aws codeartifact login --tool npm | pip | twine --domain my-domain --domain-owner domain-owner-id --repository my-repo
```

For specific guidance on how to use the `login` command with npm, see [Authentication with npm](npm-auth.md)\. For Python, see [Configure clients with the login command](python-configure.md)\.

## Tokens created with the `GetAuthorizationToken` API<a name="get-auth-token-api"></a>

You can call `get-authorization-token` to fetch an authorization token from CodeArtifact\.

```
aws codeartifact get-authorization-token --domain my-domain --domain-owner domain-owner-id --query authorizationToken --output text
```

You can change how long a token is valid using the `--durationSeconds` argument\. The minimum value is 900 and the maximum value is 43200\. The following example creates a token that will last for 1 hour \(3600 seconds\)\. 

```
aws codeartifact get-authorization-token --domain my-domain --domain-owner domain-owner-id --query authorizationToken --output text --durationSeconds 3600
```

If calling `get-authorization-token` while assuming a role the token lifetime is independent of the maximum session duration of the role\. You can configure the token to expire when the assumed role's session duration expires by setting `--durationSeconds` to 0\.

```
aws codeartifact get-authorization-token --domain my-domain --domain-owner domain-owner-id --query authorizationToken --output text --durationSeconds 0
```

See the following documentation for more information:
+ For guidance on tokens and environment variables, see [Pass an auth token using an environment variable](#env-var)\.
+ For Python users, see [Configure pip without the login command](python-configure-without-pip.md) or [Configure twine without the login command](python-configure-twine.md)\.
+ For Maven users, see [Use CodeArtifact with Gradle](maven-gradle.md) or [Use CodeArtifact with mvn](maven-mvn.md)\.
+ For npm users, see [Configuring npm without using the login command](npm-auth.md#configuring-npm-without-using-the-login-command)\.

## Pass an auth token using an environment variable<a name="env-var"></a>

AWS CodeArtifact uses authorization tokens vended by the `GetAuthorizationToken` API to authenticate and authorize requests from build tools such as Maven and Gradle\. For more information on these auth tokens, see [Tokens created with the `GetAuthorizationToken` API](#get-auth-token-api)\.

You can store these auth tokens in an environment variable that can be read by a build tool to obtain the token it needs to fetch packages from an CodeArtifact repository or publish packages to it\. 

For security reasons, this approach is preferable to storing the token in a file where it might be read by other users or processes, or accidentally checked into source control\.

1. Configure your AWS credentials as described in [Install or upgrade and then configure the AWS CLI](get-set-up-install-cli.md)\. 

1. Set the `CODEARTIFACT_TOKEN` environment variable:
**Note**  
In some scenarios, you don't need to include the `--domain-owner` argument\. For more information, see [Cross\-account domains](domain-overview.md#domain-overview-cross-account)\.
   + macOS or Linux:

     ```
     export CODEARTIFACT_TOKEN=`aws codeartifact get-authorization-token --domain my-domain --domain-owner domain-owner-id --query authorizationToken --output text`
     ```
   + Windows \(using default command shell\):

     ```
     for /f %i in ('aws codeartifact get-authorization-token --domain my-domain --domain-owner domain-owner-id --query authorizationToken --output text') do set CODEARTIFACT_TOKEN=%i
     ```
   + Windows PowerShell:

     ```
     $CODEARTIFACT_TOKEN = aws codeartifact get-authorization-token --domain my-domain --domain-owner domain-owner-id --query authorizationToken --output text
     ```

## Revoking CodeArtifact authorization tokens<a name="revoke-access"></a>

 When an authenticated user creates a token to access CodeArtifact resources, that token lasts until its customizable access period has ended\. The default access period is 12 hours\. In some circumstances, you might want to revoke access to a token before the access period has expired\. You can revoke access to CodeArtifact resources by following these instructions\.

 If you created the access token using temporary security credentials, such as *assumed roles* or *federated user access*, you can revoke access by updating an IAM policy to deny access\. For information, see [Disabling Permissions for Temporary Security Credentials](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_disable-perms.html) in the *IAM User Guide*\. 

 If you used long\-term IAM user credentials to create the access token, you must modify the user's policy to deny access, or delete the IAM user\. For more information, see [Changing Permissions for an IAM User](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_change-permissions.html) or [Deleting an IAM User](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_manage.html#id_users_deleting)\. 

 If you used an account root user's credentials to call `GetAuthorizationToken`, you can't invalidate the authorization token before it expires because the root user doesn't have a permissions policy\.