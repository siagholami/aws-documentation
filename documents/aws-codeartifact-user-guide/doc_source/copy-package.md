# Copy packages between repositories<a name="copy-package"></a>

 Use the `copy-package-versions` command in CodeArtifact to copy one or more package versions from a source repository to a destination repository in the same domain\. 

 The following is an example of using this command\.

```
aws codeartifact copy-package-versions --domain my-domain --domain-owner domain-owner-id --source-repository my-repo \
 --destination-repository repo-2 --package my-package --format npm \
 --versions '["6.0.2", "4.0.0"]'
```

The `copy-package-versions` command produces output only for package versions that fail to copy\. 

 Although you can copy multiple versions in a single operation, these must be versions of the same package name\. To copy versions of different package names, you must call `copy-package-versions` for each one\. 

To verify that `copy-package-versions` copied the package versions successfully, use the `list-package-versions` command on the destination repository\.

 To search upstream repositories, set the `--include-from-upstream` parameter to true\. If you use the CodeArtifact SDK, use [CopyPackageVersions](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_CopyPackageVersions.html) and set its [includeFromUpstream](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_CopyPackageVersions.html#codeartifact-CopyPackageVersions-request-includeFromUpstream) to true\. For more information, see [Working with upstream repositories in CodeArtifact](repos-upstream.md)\. 

```
aws codeartifact list-package-versions --domain my-domain --domain-owner domain-owner-id --repository my-repo \
 --format npm --package my-package
```

Example output:

```
{  
  "format": "npm",
  "package": "my-package",
  "versions": [
    {
      "version": "6.0.2",
      "revision": "REVISION-1-SAMPLE-6C81EFF7DA55CC",
      "status": "Published"
    },
    {
      "version": "4.0.0",
      "revision": "REVISION-2-SAMPLE-55C752BEE772FC",
      "status": "Published"
    }
  ]
}
```

## Copy a scoped npm package<a name="copying-a-scoped-npm-package"></a>

 To copy an npm package version in a scope, use the `--namespace` option to specify the scope\.

```
aws codeartifact copy-package-versions  --domain my-domain --domain-owner domain-owner-id --source-repository repo-1 \
 --destination-repository repo-2 --format npm --namespace my-namespace \
 --package my-package --versions '["0.12.2"]'
```

## CopyPackageVersions IAM actions<a name="copypackageversions-iam-actions"></a>

 `copy-package-versions` requires one permission on the source repository and one on the destination repository: 

**source repository**  
The caller must have the `ReadFromRepository` permission on the source repository\.

**destination repository**  
The caller must have the `CopyPackageVersions` permission on destination repository\.

## Versions that already exist in the destination repository<a name="versions-that-already-exist-in-the-destination-repository"></a>

 When a package version is copied to a repository where it already exists, CodeArtifact compares its package assets and package version level metadata in the two repositories\.

 If the package version assets and metadata are identical in the source and destination repositories, a copy is not performed, and the call to `copy-package-versions` returns successfully\. This means that `copy-package-versions` is idempotent\. 

 If the package version assets or metadata differ in the source and destination repositories, `copy-package-versions` fails with a `ResourceExistsException`\. You can use the `--allow-overwrite` parameter to force an overwrite\. 

```
An error occurred (ResourceExistsException) when calling the CopyPackageVersions operation
```

## Specifying a package version revision<a name="specify-package-version-revision"></a>

 A package version revision is a string that specifies a specific set of assets and metadata for a package version\. You can specify a package version revision to return package versions that are in a specific state\. To specify a package version revision, use the `--version-revisions` parameter to pass one or more comma\-separated package version and the package version revision pairs to the `copy-package-versions` command\. 

**Note**  
 You must specify the `--versions` or the `--version-revisions` parameter with `copy-package-versions`\. You cannot specify both\. 

The following example copies packages from the repository `repo-1` to repository `repo-2` if they are npm packages in the `my-namespace` namespace with the version `0.3.2` and revision `REVISION-1-SAMPLE-6C81EFF7DA55CC`\. 

```
aws codeartifact copy-package-versions --domain my-domain --domain-owner domain-owner-id --source-repository repo-1 \
 --destination-repository repo-2 --format npm --namespace my-namespace \
 --package my-package --version-revisions 0.3.2=REVISION-1-SAMPLE-6C81EFF7DA55CC
```

 The following example specifies two package version revisions, each with a different package version\. It copies package versions from repository `repo-1` to repository `repo-2` using the same parameters, except that it also copies revision `REVISION-2-SAMPLE-55C752BEE772FC` of package version `0.3.13`\. 

```
aws codeartifact copy-package-versions --domain my-domain --domain-owner domain-owner-id --source-repository repo-1 \
 --destination-repository repo-2 --format npm --namespace my-namespace \
 --package my-package --version-revisions 0.3.2=REVISION-1-SAMPLE-6C81EFF7DA55CC,0.3.13=REVISION-2-SAMPLE-55C752BEE772FC
```

 To find the revisions of a package version, use the `describe-package-version` or the `list-package-versions` command\. 

 For more information, see [Package version revision](codeartifact-concepts.md#welcome-concepts-package-version-revision) and [CopyPackageVersion](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_CopyPackageVersions.html) in the *CodeArtifact API Reference*\. 

## Copy npm packages<a name="copying-npm-packages"></a>

 For more information about `copy-package-versions` behavior with npm packages, see [npm tags and the CopyPackageVersions API](npm-tags.md#tags-and-cpv)\. 