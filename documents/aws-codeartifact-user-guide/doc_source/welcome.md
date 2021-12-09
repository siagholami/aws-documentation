# What is AWS CodeArtifact?<a name="welcome"></a>

 CodeArtifact is a fully managed artifact repository service that makes it easy for organizations to securely store and share software packages used for application development\. You can use CodeArtifact with popular build tools and package managers such as **Maven**, **Gradle**, **npm**, **yarn**, **pip**, and **twine**\. 

 CodeArtifact automatically scales when you ingest or publish new packages to your repositories\. Because it's a fully managed service, the setup and operation of its infrastructure is done for you\. Integration with AWS Key Management Service \(AWS KMS\) secures all assets in a domain with one customer master key \(CMK\) that either you manage or AWS manages for you\. 

 For more information, see [AWS CodeArtifact](https://aws.amazon.com/codeartifact/)\.

## How does CodeArtifact work?<a name="codeartifact-how-does-it-work"></a>

 Your software packages are stored in repositories, and repositories are stored in a domain\. We recommend that you use one production domain for your organization and then add repositories to it\. For example, each repository might be used for a different development team\. Packages in your repositories can then be found, shared, and discovered across your teams\. 

 To add packages to a repository, you can configure it with access to a package manager \(**npm**, **PyPI**, or **Maven**\)\. Then you use the package manager to publish packages to it\. You can also ingest open source packages into a repository by configuring it with an external connection to an open source public repository like npmjs, Maven Central, and PyPI\. For more information, see [Add an external connection](external-connection.md)\. 

 You can make packages in repositories available to another repository\. To do this, configure their repositories as upstream repositories to the other repository\. All package versions that are available to the upstream repositories are also available to the downstream repository\. In addition, all packages that are available to the upstream repositories through an external connection to a public repository are available to the downstream repository\. Simply use one or more of a repository's three endpoints \(one for each package manager format\) to access the available packages\. For more information, see [Working with upstream repositories in CodeArtifact](repos-upstream.md)\. 

## How do I get started with CodeArtifact?<a name="how-do-i-get-started"></a>

 We recommend that you complete the following steps: 

1.  **Learn** more about CodeArtifact by reading the information in [AWS CodeArtifact Concepts](codeartifact-concepts.md)\. 

1.  **Set up** your AWS account, the AWS CLI, and an IAM user by following the steps in [Setting up with AWS CodeArtifact](get-set-up-for-codeartifact.md)\. 

1.  **Use** CodeArtifact by following the instructions in [Getting started with CodeArtifact](getting-started.md)\. 