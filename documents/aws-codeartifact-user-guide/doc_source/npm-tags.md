# npm tag handling<a name="npm-tags"></a>

 npm registries support *tags*, which are string aliases for package versions\. You can use tags to provide an alias instead of version numbers\. For example, you might have a project with multiple streams of development and use a different tag \(for example, `stable`, `beta`, `dev`, `canary`\) for each stream\. For more information, see [dist\-tag](https://docs.npmjs.com/cli/dist-tag) on the npm website\. 

 By default, npm uses the `latest` tag to identify the current version of a package\. `npm install pkg` \(without `@version` or `@tag` specifier\) installs the latest tag\. Typically, projects use the latest tag for stable release versions only\. Other tags are used for unstable or prerelease versions\. 

## Edit tags with the npm client<a name="editing-tags-with-the-npm-client"></a>

 The three `npm dist-tag` commands \(`add`, `rm`, and `ls`\) function identically in CodeArtifact repositories as they do in the [default npm registry](https://registry.npmjs.com/)\.

## npm tags and the CopyPackageVersions API<a name="tags-and-cpv"></a>

When you use the `CopyPackageVersions` API to copy an npm package version, all tags aliasing that version are copied to the destination repository\. When a version that is being copied has a tag that is also present in the destination, the copy operation sets the tag value in the destination repository to match the value in the source repository\.

For example, say both repository S and repository D contain a single version of the `web-helper` package with the latest tag set as shown in this table\.


****  

| Repository | Package name | Package tags | 
| --- | --- | --- | 
|  S  |  `web-helper`  |   *latest* \(alias for version 1\.0\.1\)  | 
|  D  |  `web-helper`  |   *latest* \(alias for version 1\.0\.0\)  | 

 `CopyPackageVersions` is invoked to copy `web-helper` 1\.0\.1 from S to D\. After the operation is complete, the `latest` tag on `web-helper` in repository D aliases 1\.0\.1, not 1\.0\.0\.

If you need to change tags after copying, use the `npm dist-tag` command to modify tags directly in the destination repository\. For more information about the `CopyPackageVersions` API, see [Copying Packages Between Repositories](copy-package.md)\.

## npm tags and upstream repositories<a name="tags-and-upstreams"></a>

When `npm` requests the tags for a package and versions of that package are also present in an upstream repository, CodeArtifact merges the tags before returning them to the client\. For example, a repository named R has an upstream repository named U\. The following table shows the tags for a package named `web-helper` that's present in both repositories\.


****  

| Repository | Package name | Package tags | 
| --- | --- | --- | 
|  R  |  `web-helper`  |   *latest* \(alias for version 1\.0\.0\)  | 
|  U  |  `web-helper`  |   *alpha* \(alias for version 1\.0\.1\)  | 

In this case, when the npm client fetches the tags for the `web-helper` package from repository R, it receives both the *latest* and *alpha* tags\. The versions the tags point to won't change\.

When the same tag is present on the same package in both the upstream and downstream repository, CodeArtifact uses the tag that is present in the *upstream* repository\. For example, suppose that the tags on *webhelper* have been modified to look like the following\.


****  

| Repository | Package name | Package tags | 
| --- | --- | --- | 
|  R  |  `web-helper`  |   *latest* \(alias for version 1\.0\.0\)  | 
|  U  |  `web-helper`  |   *latest* \(alias for version 1\.0\.1\)  | 

In this case, when the npm client fetches the tags for package *web\-helper* from repository R, the *latest* tag will alias the version *1\.0\.1* because that's what's in the upstream repository\. This makes it easy to consume new package versions in an upstream repository that are not yet present in a downstream repository by running `npm update`\.

Using the tag in the upstream repository can be problematic when publishing new versions of a package in a downstream repository\. For example, say that the latest tag on the package *web\-helper* is the same in both R and U\.


****  

| Repository | Package name | Package tags | 
| --- | --- | --- | 
|  R  |  `web-helper`  |   *latest* \(alias for version 1\.0\.1\)  | 
|  U  |  `web-helper`  |   *latest* \(alias for version 1\.0\.1\)  | 

When version 1\.0\.2 is published to R, `npm` updates the *latest* tag to 1\.0\.2\.


****  

| Repository | Package name | Package tags | 
| --- | --- | --- | 
|  R  |  `web-helper`  |   *latest* \(alias for version 1\.0\.2\)  | 
|  U  |  `web-helper`  |   *latest* \(alias for version 1\.0\.1\)  | 

However, the `npm` client never sees this tag value because the value of *latest* in U is 1\.0\.1\. Running `npm install` against repository R immediately after publishing 1\.0\.2 installs 1\.0\.1 instead of the version that was just published\. To install the most recently published version, you must specify the exact package version, as follows\.

```
npm install web-helper@1.0.2
```