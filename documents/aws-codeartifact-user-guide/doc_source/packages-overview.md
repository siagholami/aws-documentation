# Packages overview<a name="packages-overview"></a>

A *package* in AWS CodeArtifact is a bundle of software and the metadata that is required to resolve dependencies and install the software\. CodeArtifact supports npm, PyPI, and Maven package formats\. This section provides a brief overview of packages, including publishing, permissions, and package version statuses\.

**Topics**
+ [Package publishing](#package-publishing)
+ [Package version status](#package-version-status)

## Package publishing<a name="package-publishing"></a>

 You can publish new versions of any supported package type to an CodeArtifact repository using tools like `npm`, `twine`, `Maven`, and `Gradle`\. 

### Publishing permissions<a name="package-publishing-permissions"></a>

Your AWS Identity and Access Management \(IAM\) user or role must have permissions to publish to the destination repository\. For npm and Python packages, this only requires the `codeartifact:PublishPackageVersion` permission\. For Maven packages, both` codeartifact:PublishPackageVersion` and `codeartifact:PutPackageMetadata` are required\. 

### Overwriting package assets<a name="package-publishing-overwrite-assets"></a>

 You can't republish a package asset that already exists with different content\. For example, suppose that you already published a Maven package with a JAR asset `mypackage-1.0.jar`\. You can't publish that asset again unless the checksum of the old and new assets are identical\. To republish the same asset with new content, delete the package version using the delete\-package\-versions command first\. Trying to republish the same asset name with different content will result in an HTTP 409 conflict error\. 

 For package formats that support multiple assets \(PyPI and Maven\), you can add new assets with different names to an existing package version at any time, assuming that you have the required permissions\. Because npm only supports a single asset per package version, to modify a published package version in any way, you must first delete it using delete\-package\-versions\. 

 If you try to republish an asset that already exists \(for example, `mypackage-1.0.jar`\), and the content of the published asset and the new asset are identical, the operation will succeed because the operation is idempotent\. 

### Publishing and upstream repositories<a name="package-publishing-upstreams"></a>

 CodeArtifact doesn't allow publishing package versions that are present in reachable upstream repositories or public repositories\. For example, suppose that you want to publish a Maven package `com.mycompany.mypackage:1.0` to a repository `myrepo`, and `myrepo` has an upstream repository with an external connection to Maven Central\. If `com.mycompany.mypackage:1.0` is present in the upstream repository or in Maven Central, CodeArtifact rejects any attempt to publish to it in `myrepo` with a 409 conflict error\. This helps prevent scenarios where you might accidentally publish a package with the same name and version as a package in an upstream repository, which can result in unexpected behavior\. 

You can still publish different versions of a package name that exists in an upstream repository\. For example, if `com.mycompany.mypackage:1.0` is present in an upstream repository, but `com.mycompany.mypackage:1.1` is not, you can publish `com.mycompany.mypackage:1.1` to the downstream repository\.

#### Private packages and public repositories<a name="package-publishing-upstreams-direct"></a>

 CodeArtifact does not publish packages stored in CodeArtifact repositories to public repositories such as npmjs\.com or Maven Central\. CodeArtifact imports packages from public repositories to a CodeArtifact repository, but it never moves packages in the other direction\. Packages that you publish to CodeArtifact repositories remain private and are only available to the AWS accounts, roles, and users to which you have granted access\.

### Publishing patched package versions<a name="package-publishing-patched-versions"></a>

 Sometimes you might want to publish a modified package version, potentially one that is available in a public repository\. For example, you might have found a bug in a critical application dependency called `mydep 1.1`, and you need to fix it sooner than the package vendor can review and accept the change\. As described previously, CodeArtifact prevents you from publishing `mydep 1.1` in your CodeArtifact repository if the public repository is reachable from your CodeArtifact repository via upstream repositories and an external connection\.

To work around this, publish the package version to a different CodeArtifact repository where the public repository isn't reachable\. Then use the `copy-package-versions` API to copy the patched version of `mydep 1.1` to the CodeArtifact repository where you will consume it from\. 

## Package version status<a name="package-version-status"></a>

Every package version in CodeArtifact has a status that describes the current state and availability of the package version\. You can change the package version status using both the AWS CLI and the console\. For more information, see [Update package version status](describe-package-version.md#update-package-version-status)\. 

The following are possible values for package version status:
+  **Published**: The package version is successfully published and can be requested using a package manager\. The package version will be included in the output of the [ListPackageVersions API](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_ListPackageVersions.html) and included in package versions lists returned to package managers, for example, in the output of `npm view <package-name> versions`\. All assets of the package version are available from the repository\. 
+  **Unfinished**: The last attempt to publish did not complete\. Currently only Maven package versions can have a status of **Unfinished**\. This can occur when the client uploads one or more assets for a package version but does not publish a `maven-metadata.xml` file for the package that includes that version\. When a package version is **Unfinished**, it will not be included in the default output from the [ListPackageVersions API](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_ListPackageVersions.html)\. 
+  **Unlisted**: The package version's assets are available for download from the repository, but it is not included in the default output of the [ListPackageVersions API](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_ListPackageVersions.html)\. The package version is also not included in the list of versions returned to package managers\. For example, for an npm package, the output of `npm view <package-name> versions` will not include the package version\. This means that npm's dependency resolution logic will not select the package version because the version does not appear in the list of available versions\. However, if the **Unlisted** package version is already referenced in an `npm package-lock.json` file, it can still be downloaded and installed, for example, when running `npm ci`\. 
+  **Archived**: The package version's assets can no longer be downloaded\. The package version will not appear in the default output of the [ListPackageVersions API](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_ListPackageVersions.html), and will not be included in the list of versions returned to package managers\. Because the the assets are not available, consumption of the package version by clients is blocked\. If your application build depends on a version that is updated to **Archived**, the build will break, assuming the package version has not been locally cached\. You cannot use a package manager or build tool to re\-publish an **Archived** package version because it is still present in the repository, but you can change the package version's status back to **Unlisted** or **Published** with the [UpdatePackageVersionsStatus API](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_UpdatePackageVersionsStatus.html)\. 
+  **Disposed**: The package version doesn't appear in listings and the assets cannot be downloaded from the repository\. They key difference between **Disposed** and **Archived** is that with a status of **Disposed**, the assets of the package version will be permanently deleted by CodeArtifact\. For this reason, you cannot move a package version from **Disposed** to **Archived**, **Unlisted**, or **Published**\. The package version can no longer be used because the assets have been deleted\. Once a package version has been marked as **Disposed**, you will no longer be billed for storage of the package assets\. 

 Apart from the states above, a package version can also be deleted with the [DeletePackageVersions API](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_DeletePackageVersions.html)\. Once deleted, a package version is no longer in the repository and you can freely re\-publish that package version using a package manager or build tool\. Once a package version has been deleted, you will no longer be billed for storage of that package version's assets\. 