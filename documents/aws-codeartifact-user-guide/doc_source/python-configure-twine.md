# Configure twine without the login command<a name="python-configure-twine"></a>

 If you cannot use the `login` command to configure `twine`, you can use the `~/.pypirc` file or environment variables\. To use the `~/.pypirc` file, add the following entries to it\. The password must be an auth token acquired by the `get-authorization-token` API\.

```
[distutils]
index-servers =
 codeartifact
[codeartifact]
repository = https://my-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/pypi/my-repo/
password = auth-token
username = aws
```

To use environment variables, do the following\.

**Note**  
If you are accessing a repository in a domain that you own, you do not need to include the `--domain-owner`\. For more information, see [Cross\-account domains](domain-overview.md#domain-overview-cross-account)\.

```
export TWINE_USERNAME=aws
export TWINE_PASSWORD=`aws codeartifact get-authorization-token --domain my-domain --domain-owner domain-owner-id --query authorizationToken --output text`
export TWINE_REPOSITORY_URL=`aws codeartifact get-repository-endpoint --domain domain-name --domain-owner domain-owner-id --repository repo-name --format pypi --query repositoryEndpoint --output text`
```