# List package versions<a name="list-packages-versions"></a>

Use the `list-package-versions` command in CodeArtifact to get a list of all of the versions of a package name in a repository\.

```
aws codeartifact list-package-versions --package kind-of --domain my-domain --domain-owner domain-owner-id \
--repository my-repository --format npm
```

Sample output:

```
{
  "defaultDisplayVersion": "1.0.1",
  "format": "npm",
  "package": "kind-of",
  "versions": [
      {
          "version": "1.0.1",
          "revision": "REVISION-SAMPLE-1-C7F4S5E9B772FC",
          "status": "Published"
      },
      {
          "version": "1.0.0",
          "revision": "REVISION-SAMPLE-2-C752BEEF6D2CFC",
          "status": "Published"
      },
      {
          "version": "0.1.2",
          "revision": "REVISION-SAMPLE-3-654S65A5C5E1FC",
          "status": "Published"
      },
      {
          "version": "0.1.1",
          "revision": "REVISION-SAMPLE-1-C7F4S5E9B772FC"",
          "status": "Published"
      },
      {
          "version": "0.1.0",
          "revision": "REVISION-SAMPLE-4-AF669139B772FC",
          "status": "Published"
      }        
  ]
}
```

You can add the `--status` parameter to the `list-package-versions` call to filter the results based on package version status\. For more information on package version status, see [Package version status](packages-overview.md#package-version-status)\. 

 You can paginate the response from `list-package-versions` using the `--max-results` and `--next-token` parameters\. For `--max-results`, specify an integer from 1 to 1000 to specify the number of results returned in a single page\. Its default is 50\. To return subsequent pages, run `list-package-versions` again and pass the `nextToken` value received in the previous command output to `--next-token`\. When the `--next-token` option is not used, the first page of results is always returned\. 

 The `list-package-versions` command does not list package versions in upstream repositories\. However, references to package versions in an upstream repository that were copied to your repository during a package version request are listed\. For more information, see [Working with upstream repositories in CodeArtifact](repos-upstream.md)\. 

## Sort versions<a name="list-package-versions-sorting"></a>

 `list-package-versions` can output versions sorted in descending order based on publish time \(the most\-recently published versions are listed first\)\. Use the `--sort-by` parameter with a value of `PUBLISH_TIME`, as follows\.

```
aws codeartifact list-package-versions --domain my-domain --domain-owner domain-owner-id --repository my-repository  \
--format npm --package webpack --max-results 5 --sort-by PUBLISH_TIME
```

 Sample output: 

```
{

  "defaultDisplayVersion": "4.41.2",
  "format": "npm",
  "package": "webpack",
  "versions": [
      { 
        "version": "5.0.0-beta.7", 
        "revision": "REVISION-SAMPLE-1-C7F4S5E9B772FC",
        "status": "Published"
      },
      { 
        "version": "5.0.0-beta.6", 
        "revision": "REVISION-SAMPLE-2-C752BEEF6D2CFC",
        "status": "Published" 
      },
      { 
        "version": "5.0.0-beta.5", 
        "revision": "REVISION-SAMPLE-3-654S65A5C5E1FC",
        "status": "Published"
      },
      { 
        "version": "5.0.0-beta.4", 
        "revision": "REVISION-SAMPLE-4-AF669139B772FC",
        "status": "Published"
      },
      { 
        "version": "5.0.0-beta.3", 
        "revision": "REVISION-SAMPLE-5-C752BEE9B772FC",
        "status": "Published"
      }
  ],
  "nextToken": "eyJsaXN0UGF...."
}
```

## Default display version<a name="list-package-versions-default-version"></a>

 The return value for `defaultDisplayVersion` depends on the package format: 
+  For Maven and PyPI packages, it's the most recently published package version\. 
+  For npm packages, it's the version referenced by the `latest` tag\. If the `latest` tag is not set, it's the most recently published package version\. 

## Format output<a name="list-package-versions-format-output"></a>

 You can use parameters that are available to all AWS CLI commands to make the `list-package-versions` response compact and more readable\. Use the `--query` parameter to specify the format of each returned package version\. Use `--output` parameter to format the response as plain text\. 

```
aws codeartifact list-package-versions --package my-package-name --domain my-domain --domain-owner domain-owner-id \
--repository my-repo --format npm --output text --query 'versions[*].[version]'
```

Sample output:

```
0.1.1
0.1.2
0.1.0
3.0.0
```

 For more information, see [Controlling Command Output from the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-usage-output.html) in the *AWS Command Line Interface User Guide*\. 