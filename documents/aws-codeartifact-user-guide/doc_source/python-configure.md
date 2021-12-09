# Configure clients with the login command<a name="python-configure"></a>

After you create a repository, you can use the `pip` client to install packages and the `twine` client to publish packages\.

First, configure your AWS credentials for use with the AWS CLI, as described in [Getting started with CodeArtifact](getting-started.md)\. Then, use the CodeArtifact `login` command to fetch credentials for use with `pip` or `twine`\.

**Note**  
If you are accessing a repository in a domain that you own, you don't need to include `--domain-owner`\. For more information, see [Cross\-account domains](domain-overview.md#domain-overview-cross-account)\.

```
aws codeartifact login --tool pip | twine --domain my-domain --domain-owner domain-owner-id --repository my-repo
```

 `login` fetches an authorization token from CodeArtifact using your AWS credentials\. 

Depending on the value of the `--tool` option, the login command will:
+ Configure `pip` for use with CodeArtifact by editing `~/.config/pip/pip.conf` to set the `index-url` to the repository specified by the `--repository` option\.
+ Configure `twine` for use with CodeArtifact by editing `~/.pypirc` to create an `index-server` section for the repository specified by the `--repository` option\.

The default authorization period after calling `login` is 12 hours, and `login` must be called to periodically refresh the token\. For more information about the authorization token created with the `login` command, see [Tokens created with the `login` command](tokens-authentication.md#auth-token-login)\.