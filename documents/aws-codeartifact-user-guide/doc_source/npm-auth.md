# Authentication with npm<a name="npm-auth"></a>

After you create a repository in CodeArtifact, you can use the `npm` client to install and publish packages\.

 Use the CodeArtifact `login` command to fetch credentials for use with npm\.

**Note**  
If you are accessing a repository in a domain that you own, you don't need to include `--domain-owner`\. For more information, see [Cross\-account domains](domain-overview.md#domain-overview-cross-account)\.

```
aws codeartifact login --tool npm --domain my-domain --domain-owner domain-owner-id --repository my-repo
```

This command makes the following changes to your `~/.npmrc` file:
+ Adds an authorization token after fetching it from CodeArtifact using your AWS credentials\.
+ Sets the npm registry to the repository specified by the `--repository` option\.
+ Adds `"always-auth=true"` so the authorization token is sent for every `npm` command\.

The default authorization period after calling `login` is 12 hours, and `login` must be called to periodically refresh the token\. For more information about the authorization token created with the `login` command, see [Tokens created with the `login` command](tokens-authentication.md#auth-token-login)\.

## Verify npm authentication and authorization<a name="verifying-npm-authentication-and-authorization"></a>

Invoking the `npm ping` command is an easy way to verify the following:
+ You have correctly configured your credentials so that you can authenticate to an CodeArtifact repository\.
+ The authorization configuration grants you the `ReadFromRepository` permission\.

The output from a successful invocation of `npm ping` looks like the following\.

```
$ npm -d ping
npm info it worked if it ends with ok
npm info using npm@6.4.1
npm info using node@v9.5.0
npm info attempt registry request try #1 at 4:30:59 PM
npm http request GET https://<domain>.d.codeartifact.us-west-2.amazonaws.com/npm/shared/-/ping?write=true
npm http 200 https:///npm/shared/-/ping?write=true
Ping success: {}
npm timing npm Completed in 716ms
npm info ok
```

The `-d` option causes `npm` to print additional debug information, including the repository URL\. This information makes it easy to confirm that `npm` is configured to use the repository you expect\.

## Configuring npm without using the login command<a name="configuring-npm-without-using-the-login-command"></a>

Use `npm config` to set the CodeArtifact registry endpoint\.

```
npm config set registry=https://my-domain-123456789012.d.codeartifact.region.amazonaws.com/npm/my-repo/
```

With the domain you are using for `my-domain`, a domain owner ID of `123456789012`, and a repository name of `my-repo`\.

**Important**  
The registry URL must end with a forward slash \(/\)\. Otherwise, you cannot connect to the repository\.

Use the following command to add the auth token returned by `get-authorization-token`, using the same domain and repository\.

```
npm config set //my-domain-123456789012.d.codeartifact.region.amazonaws.com/npm/my-repo/:_authToken eyJ2ZX...
```

 To make `npm` always pass the auth token to CodeArtifact, even for `GET` requests, set the `always-auth` configuration variable with `npm config`\. 

```
npm config set //my-domain-123456789012.d.codeartifact.region.amazonaws.com/npm/my-repo/:always-auth=true
```

## Run npm commands<a name="running-npm-commands"></a>

After you configure the npm client, you can run `npm` commands\. Assuming that a package is present in your repository or one of its upstream repositories, you can install it with `npm install`\. For example, use the following to install the `lodash` package\.

```
npm install lodash
```

Use the following command to publish a new npm package to an CodeArtifact repository\.

```
npm publish
```

For information about how to create npm packages, see [Creating Node\.js Modules](https://docs.npmjs.com/getting-started/creating-node-modules) on the npm documentation website\. For a list of npm commands supported by CodeArtifact, see [npm Command Support](npm-commands.md)\. 