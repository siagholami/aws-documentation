# List package names<a name="list-packages"></a>

Use the `list-packages` command in CodeArtifact to get a list of all the package names in a repository\. This command returns only the package names, not the versions\.

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id --repository my-repo
```

Sample output:

```
{
    "nextToken": "eyJidWNrZXRJZCI6I...",
    "packages": [
        {
            "package": "acorn",
            "format": "npm"
        },
        {
            "package": "acorn-dynamic-import",
            "format": "npm"
        },
        {
            "package": "ajv",
            "format": "npm"
        },
        {
            "package": "ajv-keywords",
            "format": "npm"
        },
        {
            "package": "anymatch",
            "format": "npm"
        },
        {
          "package": "ast",
          "namespace": "webassemblyjs",
          "format": "npm",
          
        }
    ]
}
```

## List npm package names<a name="list-packages-npm"></a>

To list only the names of npm packages, set the value of the `--format` option to `npm`\.

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id --repository my-repo  \
    --format npm
```

To list npm packages in a namespace \(npm *scope*\), use the `--namespace` and `--format` options\.

**Important**  
The value for the `--namespace` option should not include the leading `@`\. To search for the namespace `@types`, set the value to *types*\.

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id --repository my-repo  \
    --format npm --namespace types
```

Sample output:

```
{
    "nextToken": "eyJidWNrZXRJZ...",
    "packages": [
        {
            "package": "3d-bin-packing",
            "namespace": "types",
            "format": "npm"

        },
        {
            "package": "a-big-triangle",
            "namespace": "types",
            "format": "npm"

        },
        {
            "package": "a11y-dialog",
            "namespace": "types",
            "format": "npm"

        }
    ]
}
```

## List Maven package names<a name="list-packages-maven"></a>

To list only the names of Maven packages, set the value of the `--format` option to `maven`\. You must also specify the Maven group in the `--namespace` option\.

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id --repository my-repo  \
    --format maven --namespace org.apache.commons
```

Sample output:

```
{
    "nextToken": "eyJidWNrZXRJZ...",
    "packages": [
        {
            "package": "commons-lang3",
            "namespace": "org.apache.commons",
            "format": "maven"

        },
        {
            "package": "commons-collections4",
            "namespace": "org.apache.commons",
            "format": "maven"

        },
        {
            "package": "commons-compress",
            "namespace": "org.apache.commons",
            "format": "maven"

        }
    ]
}
```

## List Python package names<a name="list-packages-python"></a>

To list only the names of Python packages, set the value of the `--format` option to `python`\.

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id --repository my-repo  \
    --format python
```

## Filter by package name prefix<a name="list-packages-package-prefix"></a>

 To return packages that begin with a specified string, you can use the `--package-prefix` option\. 

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id --repository my-repo  \
    --format npm --package-prefix pat
```

Sample output:

```
{
    "nextToken": "eyJidWNrZXRJZ...",
    "packages": [
        {
            "package": "path",
            "format": "npm"

        },
        {
            "package": "pat-test",
            "format": "npm"

        },
        {
            "package": "patch-math3",
            "format": "npm"

        }
    ]
}
```

## Supported search option combinations<a name="list-packages-option-combinations"></a>

You can use the `--format`, `--namespace`, and `--package-prefix` options in any combination, except that `--namespace` can't be used by itself\. For example, searching for all packages in the `@types` scope requires the `--format` option to be specified\. Using `--namespace` by itself results in an error\. 

 Using none of the three options is also supported by `list-packages` and will return all packages of all formats present in the repository\. 

## Format output<a name="list-packages-format-output"></a>

 You can use parameters that are available to all AWS CLI commands to make the `list-packages` response compact and more readable\. Use the `--query` parameter to specify the format of each returned package version\. Use the `--output` parameter to format the response as plaintext\. 

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id --repository my-repo \
  --output text --query 'packageCoordinateList[*].[packageName]'
```

Sample output:

```
accepts
array-flatten
body-parser
bytes
content-disposition
content-type
cookie
cookie-signature
```

 For more information, see [Controlling command output from the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-usage-output.html) in the *AWS Command Line Interface User Guide*\. 

## Defaults and other options<a name="list-packages-defaults-options"></a>

 By default, the maximum number of results returned by `list-packages` is 100\. You can change this result limit by using the `--max-results` option\.

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id --repository my-repo --max-results 20
```

The maximum allowed value of `--max-results` is 1,000\. To allow listing packages in repositories with more than 1,000 packages, `list-packages` supports pagination using the `nextToken` field in the response\. If the number of packages in the repository is more than the value of `--max-results`, you can pass the value of `nextToken` to another invocation of `list-packages` to get the next page of results\.

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id --repository my-repo \
  --next-token rO0ABXNyAEdjb...
```