# AWS CodeArtifact Concepts<a name="codeartifact-concepts"></a>

 Here are some concepts and terms to know when you use CodeArtifact\. 

**Topics**
+ [Domain](#welcome-concepts-domain)
+ [Repository](#welcome-concepts-repository)
+ [Package](#welcome-concepts-package)
+ [Package version](#welcome-concepts-package-version)
+ [Package version revision](#welcome-concepts-package-version-revision)
+ [Upstream repository](#welcome-concepts-upstream)
+ [Asset](#welcome-concepts-asset)
+ [Package namespace](#welcome-concepts-package-namespace)

## Domain<a name="welcome-concepts-domain"></a>

Repositories are aggregated into a higher\-level entity known as a *domain*\. All package assets and metadata are stored in the domain, but they are consumed through repositories\. A given package asset, such as a Maven JAR file, is stored once per domain, no matter how many repositories it's present in\. All of the assets and metadata in a domain are encrypted with the same customer master key \(CMK\) stored in AWS Key Management Service \(AWS KMS\)\.

Each repository is a member of a single domain and can't be moved to a different domain\.

The domain allows organizational policy to be applied across multiple repositories, such as which accounts can access repositories in the domain, and which public repositories can be used as sources of packages\.

Although an organization can have multiple domains, we recommend a single production domain that contains all published artifacts so that teams can find and share packages across their organization\.

## Repository<a name="welcome-concepts-repository"></a>

An CodeArtifact *repository* contains a set of [package versions](#welcome-concepts-package-version), each of which maps to a set of [assets](#welcome-concepts-asset)\. Repositories are polyglot—a single repository can contain packages of any supported type\. Each repository exposes endpoints for fetching and publishing packages using tools like the **`npm` ** CLI, the Maven CLI \(**`mvn`**\), and **`pip`**\. You can create up to 1000 repositories per domain\.

## Package<a name="welcome-concepts-package"></a>

A *package* is a bundle of software and the metadata that is required to resolve dependencies and install the software\. AWS CodeArtifact supports [npm](using-npm.md), [PyPI](using-python.md), and [Maven](using-maven.md) package formats\.

In CodeArtifact, a package consists of:
+ A *name* \(for example, `webpack` is the name of a popular npm package\)
+ An optional [namespace](#welcome-concepts-package-namespace) \(for example, `@types` in `@types/node`\)
+ A set of [versions](#welcome-concepts-package-version) \(for example, `1.0.0`, `1.0.1`, `1.0.2`, etc\.\)
+  Package\-level metadata \(for example, npm tags\)

## Package version<a name="welcome-concepts-package-version"></a>

A *package version* identifies the specific version of a package, such as `@types/node 12.6.9`\. The version number format and semantics vary for different package formats\. For example, npm package versions must conform to the [Semantic Versioning specification](https://semver.org/)\. In CodeArtifact, a package version consists of the version identifier, package version level metadata, and a set of assets\.

## Package version revision<a name="welcome-concepts-package-version-revision"></a>

 A *package version revision* is a string that identifies a specific set of assets and metadata for a package version\. Each time a package version is updated, a new package version revision is created\. For example, you might publish a source distribution archive \(**sdist**\) for a Python package version, and later add a Python **wheel** that contains compiled code to the same version\. When you publish the **wheel**, a new package version revision is created\. 

## Upstream repository<a name="welcome-concepts-upstream"></a>

One repository is *upstream* of another when the package versions in it can be accessed from the repository endpoint of the downstream repository, effectively merging the contents of the two repositories from the point of view of a client\. CodeArtifact allows creating an upstream relationship between two repositories\.

## Asset<a name="welcome-concepts-asset"></a>

An *asset* is an individual file stored in CodeArtifact that is associated with a package version, such as an npm `.tgz` file or Maven POM and JAR files\.

## Package namespace<a name="welcome-concepts-package-namespace"></a>

A *package namespace* is a generalization of hierarchical name structures in different package formats that is used to organize packages into logical groups and avoid name collisions\. For example, the npm package `@types/node` has a scope of `@types` and a name of `node`\. There are many other package names in the `@types` scope\. In Maven, namespace corresponds to the groupID concept\. The Maven package `org.apache.logging.log4j:log4j` has a groupID \(namespace\) of `org.apache.logging.log4j` and the name `log4j`\.

Some package formats \(for example, PyPI\), don't have a concept analogous to namespace\. These formats don't provide a way to group package names\. For this reason, it's more difficult to avoid name collisions\.