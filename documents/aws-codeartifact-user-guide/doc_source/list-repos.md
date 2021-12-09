# List repositories<a name="list-repos"></a>

Use the commands in this topic to list repositories in an AWS account or domain\.

## List repositories in an AWS account<a name="listing-repositories-in-an-aws-account"></a>

Use this command to list all of the repositories in your AWS account\.

```
aws codeartifact list-repositories
```

Sample output:

```
{
    "repositories": [
        {
            "name": "repo1",
            "administratorAccount": "123456789012",
            "domainName": "example-domain",
            "domainOwner": "123456789012",
            "arn": "arn:aws:codeartifact:region-id:123456789012:repository/example-domain/repo1",
            "description": "Description of repo1"
        },
        {
            "name": "repo2",
            "administratorAccount": "123456789012",
            "domainName": "example-domain",
            "domainOwner": "123456789012",
            "arn": "arn:aws:codeartifact:region-id:123456789012:repository/example-domain/repo2",
            "description": "Description of repo2"    
            
        },
        {
            "name": "repo3",
            "administratorAccount": "123456789012",
            "domainName": "example-domain2",
            "domainOwner": "123456789012",
            "arn": "arn:aws:codeartifact:region-id:123456789012:repository/example-domain2/repo3",
            "description": "Description of repo3"
            
        }
    ]
}
```

 You can paginate the response from `list-repositories` using the `--max-results` and `--next-token` parameters\. For `--max-results`, specify an integer from 1 to 1000 to specify the number of results returned in a single page\. Its default is 50\. To return subsequent pages, run `list-repositories` again and pass the `nextToken` value received in the previous command output to `--next-token`\. When the `--next-token` option is not used, the first page of results is always returned\. 

## List repositories in the domain<a name="listing-repositories-in-the-domain"></a>

Use `list-repositories-in-domain` to get a list of all the repositories in a domain\.

```
aws codeartifact list-repositories-in-domain --domain example-domain --domain-owner 123456789012 --max-results 3
```

The output shows that some of the repositories are owned by different AWS accounts\.

```
{
    "repositories": [
        {
            "name": "repo1",
            "administratorAccount": "123456789012",
            "domainName": "example-domain",
            "domainOwner": "123456789012",  
            "arn": "arn:aws:codeartifact:region-id:123456789012:repository/example-domain/repo1",
            "description": "Description of repo1"
        },
        {
            "name": "repo2",
            "administratorAccount": "123456789012",
            "domainName": "example-domain",
            "domainOwner": "123456789012",
            "arn": "arn:aws:codeartifact:region-id:123456789012:repository/example-domain/repo2",
            "description": "Description of repo2"            
        },
        {
            "name": "repo3",
            "administratorAccount": "123456789012",
            "domainName": "example-domain",
            "domainOwner": "123456789012",
            "arn": "arn:aws:codeartifact:region-id:123456789012:repository/example-domain/repo3",
            "description": "Description of repo3"            
        }
    ]
}
```

 You can paginate the response from `list-repositories-in-domain` using the `--max-results` and `--next-token` parameters\. For `--max-results`, specify an integer from 1 to 1000 to specify the number of results returned in a single page\. Its default is 50\. To return subsequent pages, run `list-repositories-in-domain` again and pass the `nextToken` value received in the previous command output to `--next-token`\. When the `--next-token` option is not used, the first page of results is always returned\. 

To output the repository names in a more compact list, try the following command\.

```
aws codeartifact list-repositories-in-domain --domain example-domain --domain-owner domain-owner-id \
  --query 'repositories[*].[name]' --output text
```

Sample output:

```
repo1
repo2
repo3
```

The following example outputs the account ID in addition to the repository name\.

```
aws codeartifact list-repositories-in-domain --domain example-domain --domain-owner domain-owner-id  \
  --query 'repositories[*].[name,administratorAccount]' --output text
```

Sample output:

```
repo1 710221105108
repo2 710221105108
repo3 532996949307
```