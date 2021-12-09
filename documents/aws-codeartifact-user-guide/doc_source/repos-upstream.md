# Working with upstream repositories in CodeArtifact<a name="repos-upstream"></a>

A repository can have other AWS CodeArtifact repositories as *upstream* repositories\. This enables a package manager client to access the packages that are contained in more than one repository using a single repository endpoint\. You can set upstream repositories using the AWS Management Console, the AWS Command Line Interface \(AWS CLI\), or the AWS CodeArtifact API\. 

If an upstream repository has an external connection to a public repository, the repositories that are downstream from it can pull packages from that public repository\. For example, suppose that the repository `my-repo` has an upstream repository named `upstream`, and `upstream` has an external connection to a public npm repository\. In this case, a package manager that is connected to `my-repo` can pull packages from the npm public repository\. 

You can add one or more upstream repositories to an AWS CodeArtifact repository using the AWS Management Console, AWS CLI, or SDK\. To associate a repository with an upstream repository, you must have permission for the `AssociateWithDownstreamRepository` action on the upstream repository\.

For more information, see [Create a repository with an upstream repository](create-repo.md#creating-a-repository-with-an-upstream) and [Add an external connection](external-connection.md)\. 

**Topics**
+ [Add, update, or remove upstream repositories \(console\)](repo-upstream-add-console.md)
+ [Add, update, or remove upstream repositories \(AWS CLI\)](repo-upstream-add-cli.md)
+ [Requesting a package version with upstream repositories](repo-upstream-behavior.md)
+ [Upstream repository priority order](repo-upstream-search-order.md)