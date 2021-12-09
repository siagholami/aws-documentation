# Upstream repository priority order<a name="repo-upstream-search-order"></a>

 When you request a package version from a repository with one or more upstream repositories, their priority corresponds to the order that they were listed in when calling the `create-repository` or `update-repository` command\. When the requested package version is found, the search stops, even if it didn't search all upstream repositories\. For more information, see [Add, update, or remove upstream repositories \(AWS CLI\)](repo-upstream-add-cli.md)\. 

 Use the `describe-repository` command to see the priority order, as in the following example\.

```
aws codeartifact describe-repository --repository-name my-repo --domain my-domain --domain-owner 123456789012
```

 The result might be the following\. It shows that the upstream repository priority is `upstream-1` first, `upstream-2` second, and `upstream-3` third\. 

```
{
    "repository": {
        "name": "my-repo",
        "administratorAccount": "123456789012",
        "domainName": "my-domain",
        "domainOwner": "123456789012",
        "upstreams": [
            {
                "repositoryName": "upstream-1"
            },
            {
                "repositoryName": "upstream-2"
            },
            {
                "repositoryName": "upstream-3"
            }
        ],
        "externalConnections": []
    }
}
```

## Simple priority order example<a name="upstream-priority-order-simple"></a>

 In the following diagram, the `my-repo` repository has three upstream repositories\. The priority order of the upstream repositories is `upstream-1`, `upstream-2`, `upstream-3`\. 

![\[Simple upstream repository diagram showing my-repo with 3 upstream repositories.\]](http://docs.aws.amazon.com/codeartifact/latest/ug/)![\[Simple upstream repository diagram showing my-repo with 3 upstream repositories.\]](http://docs.aws.amazon.com/codeartifact/latest/ug/)![\[Simple upstream repository diagram showing my-repo with 3 upstream repositories.\]](http://docs.aws.amazon.com/codeartifact/latest/ug/)

 A request for a package version in `my-repo` searches the repositories in the following order until it is found, or until an HTTP 404 `Not Found` response is returned to the client: 

1.  `my-repo` 

1.  `upstream-1` 

1.  `upstream-2` 

1.  `upstream-3` 

If the package version is found, the search stops, even if it didn't look in all upstream repositories\. For example, if the package version is found in `upstream-1`, the search stops and CodeArtifact doesn't look in `upstream-2` or `upstream-3`\. 

 When you use the AWS CLI command `list-package-versions` to list package versions in `my-repo`, it looks only in `my-repo`\. It does not list package versions in upstream repositories\. 

## Complex priority order example<a name="upstream-search-order-complex"></a>

 If an upstream repository has its own upstream repositories, the same logic is used to find a package version before moving to the next upstream repository\. For example, suppose that your `my-repo` repository has two upstream repositories, `A` and `B`\. If repository `A` has upstream repositories, a request for a package version in `my-repo` first looks in `my-repo`, second in `A`, then in the upstream repositories of `A`, and so on\. 

 In the following diagram, the `my-repo` repository contains upstream repositories\. Upstream repository `A` has two upstream repositories, and `D` has one upstream repository\. Upstream repositories at the same level in the diagram appear in their priority order, left to right \(repository `A` has a higher priority order than repository `B`, and repository `C` has a higher priority order than repository `D`\)\. 

![\[A more complex upstream repository diagram with 2 upstream repositories A and B and additional upstream repositories.\]](http://docs.aws.amazon.com/codeartifact/latest/ug/)![\[A more complex upstream repository diagram with 2 upstream repositories A and B and additional upstream repositories.\]](http://docs.aws.amazon.com/codeartifact/latest/ug/)![\[A more complex upstream repository diagram with 2 upstream repositories A and B and additional upstream repositories.\]](http://docs.aws.amazon.com/codeartifact/latest/ug/)

In this example, a request for a package version in `my-repo` looks in the repositories in the following order until it is found, or until a package manager returns an HTTP 404 `Not Found` response to the client: 

1.  `my-repo` 

1.  `A` 

1.  `C` 

1.  `D` 

1.  `E` 

1.  `B` 