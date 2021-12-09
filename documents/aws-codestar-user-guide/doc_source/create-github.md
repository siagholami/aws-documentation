# Create a GitHub Repository<a name="create-github"></a>

You create a GitHub repository by defining it in your toolchain template\. Make sure that you have already created a location for a ZIP file containing your source code, so the code can be uploaded to the repository\. Also, you must have already created a personal access token in GitHub so that AWS can connect to GitHub on your behalf\. In addition to the personal access token for GitHub, you also must have `s3.GetObject` permission for the `Code` object you pass in\.

To specify a public GitHub repository, add code like the following to your toolchain template in AWS CloudFormation\.

```
    GitHubRepo:
    Condition: CreateGitHubRepo
    Description: GitHub repository for application source code
    Properties:
      Code:
        S3:
          Bucket: MyCodeS3Bucket
          Key: MyCodeS3BucketKey
      EnableIssues: true
      IsPrivate: false
      RepositoryAccessToken: MyGitHubPersonalAccessToken
      RepositoryDescription: MyAppCodeRepository
      RepositoryName: MyAppSource
      RepositoryOwner: MyGitHubUserName
    Type: AWS::CodeStar::GitHubRepository
```

This code specifies the following information:
+ The location of the code you want to include, which must be an Amazon S3 bucket\.
+ Whether you want to enable issues on the GitHub repository\.
+ Whether the GitHub repository is private\.
+ The GitHub personal access token you created\.
+ A description, name, and owner for the repository you are creating\.

For complete details about what information to specify, see [AWS::CodeStar::GitHubRepository](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-codestar-githubrepository.html) in the *AWS CloudFormation User Guide*\. 