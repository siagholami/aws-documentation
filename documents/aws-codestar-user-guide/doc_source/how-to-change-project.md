# Change AWS Resources in an AWS CodeStar Project<a name="how-to-change-project"></a>

After you create a project in AWS CodeStar, you can change the default set of AWS resources that AWS CodeStar adds to the project\. 

## Supported Resource Changes<a name="how-to-change-project-supported-actions"></a>

The following table lists the supported changes to default AWS resources in an AWS CodeStar project\.


| Change | Notes | 
| --- | --- | 
| Add a stage to AWS CodePipeline\. | See [Add a Stage to AWS CodePipeline](how-to-change-project-codepipeline.md)\. | 
| Change Elastic Beanstalk environment settings\. | See [Change AWS Elastic Beanstalk Environment Settings](how-to-change-project-beanstalk.md)\. | 
| Change an AWS Lambda function's code or settings, its IAM role, or its API in Amazon API Gateway\. | See [Change an AWS Lambda Function in Source Code](how-to-change-project-lambda.md)\. | 
| Add a resource to an AWS Lambda project and expand permissions to create and access the new resource\. | See [Add a Resource to a Project](customize-project-template.md)\. | 
| Add traffic shifting with CodeDeploy for an AWS Lambda function\. | See [Shift Traffic for an AWS Lambda Project](how-to-modify-serverless-project.md)\. | 
| Add AWS X\-Ray support | See [Enable Tracing for a Project](customize-project-xray.md)\. | 
| Edit the buildspec\.yml file for your project to add a unit test build phase for AWS CodeBuild to run\. | See [Step 7: Add a Unit Test to the Web Service](sam-tutorial.md#sam-tutorial-add-unit-tests) in the Serverless Project tutorial\. | 
| Add your own IAM role to your project\. | See [Add an IAM Role to a Project](add-iam-role.md)\. | 
| Change an IAM role definition\. | For roles defined in the application stack\. You cannot change roles defined in the toolchain or AWS CloudFormation stacks\. | 
| Modify your Lambda project to add an endpoint\. |  | 
| Modify your EC2 project to add an endpoint\. |  | 
| Modify your Elastic Beanstalk project to add an endpoint\. |  | 
| Edit your project to add a Prod stage and endpoint\. | See [Add a Prod Stage and Endpoint to a Project](customize-ec2-multi-endpoints.md)\. | 
| Securely use SSM parameters in an AWS CodeStar project\. | See [Securely Use SSM Parameters in an AWS CodeStar Project](ssm-parameters.md)\. | 

The following changes are not supported\.
+ Switch to a different deployment target \(for example, deploy to AWS Elastic Beanstalk instead of AWS CodeDeploy\)\.
+ Add a friendly web endpoint name\.
+ Change the CodeCommit repository name \(for an AWS CodeStar project connected to CodeCommit\)\.
+ For an AWS CodeStar project connected to GitHub, disconnect the GitHub repository, and then reconnect the repository to that project, or connect any other repository to that project\. You can use the CodePipeline console \(not the AWS CodeStar console\) to disconnect and reconnect to GitHub in a pipeline's **Source** stage\. However, if you reconnect the **Source** stage to a different GitHub repository, in the AWS CodeStar dashboard for the project, the information in the **Application endpoints**, **Commit history**, and **GitHub Issues** tiles might be wrong or out of date\. Disconnecting the GitHub repository does not remove that repository's information from the commit history and GitHub issues tiles in the AWS CodeStar project dashboard\. To remove this information, use the GitHub website to disable access to GitHub from the AWS CodeStar project\. To revoke access, on the GitHub website, use the **Authorized OAuth Apps** section of the settings page for your GitHub account profile\.
+ Disconnect the CodeCommit repository \(for an AWS CodeStar project connected to CodeCommit\) and then reconnect the repository to that project, or connect any other repository to that project\.