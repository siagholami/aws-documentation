# Create a Project in AWS CodeStar<a name="how-to-create-project"></a>

You use the AWS CodeStar console to create a project\. If you use a project template, it sets up the required resources for you\. The template also includes sample code that you can use to start coding\. 

To create a project, sign in to the AWS Management Console with an IAM user that has the `AWSCodeStarFullAccess` policy or equivalent permissions\.  For more information, see [Setting Up AWS CodeStar](setting-up.md)\.

**Note**  
You must complete the steps in [Setting Up AWS CodeStar](setting-up.md) before you can complete the procedures in this topic\.

**Topics**
+ [Create a Project in AWS CodeStar \(Console\)](#how-to-create-project-console)
+ [Create a Project in AWS CodeStar \(AWS CLI\)](#how-to-create-project-cli)

## Create a Project in AWS CodeStar \(Console\)<a name="how-to-create-project-console"></a>

Use the AWS CodeStar console to create a project\.<a name="adh-create-project"></a>

**To create a project in AWS CodeStar**

1. Sign in to the AWS Management Console, and then open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

   Make sure that you are signed in to the AWS Region where you want to create the project and its resources\. For example, to create a project in US East \(Ohio\), make sure you have selected that AWS Region\. For information about AWS Regions where AWS CodeStar is available, see [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#codestar_region) in the *AWS General Reference* \.

1. On the **AWS CodeStar** page, choose **Create a new project**\. \(If you are the first user to create a project, choose **Start a project**\.\)

1. On the **Choose a project template** page, choose the project type from the list of AWS CodeStar project templates\. You can use the filter bar to narrow your choices\. For example, for a web application project written in Node\.js to be deployed to Amazon EC2 instances, select the **Web application**, **Node\.js**, and **Amazon EC2** check boxes\. Then choose from the templates available for that set of options\.

   For more information, see [AWS CodeStar Project Templates](templates.md)\.

1. In **Project name**, enter a name for the project, such as *My First Project*\. The ID for the project is derived from this project name, but is limited to 15 characters\. 

   For example, the default ID for a project named *My First Project* is *my\-first\-projec*\. This project ID is the basis for the names of all resources associated with the project\. AWS CodeStar uses this project ID as part of the URL for your code repository and for the names of related security access roles and policies in IAM\. After the project is created, the project ID cannot be changed\. To edit the project ID before you create the project, choose **Edit**\. 

   For information about the limits on project names and project IDs, see [Limits in AWS CodeStar](limits.md)\.
**Note**  
Project IDs must be unique for your AWS account in an AWS Region\. 

1. Choose the repository provider, **AWS CodeCommit** or **GitHub**\. 

1. If you chose **AWS CodeCommit**, for **Repository name**, accept the default AWS CodeCommit repository name, or enter a different one\. Then skip ahead to step 8\.

1. If you chose **GitHub**, choose **Connect with GitHub**\. 

   1. If the **Sign in to GitHub** page is displayed, enter your GitHub user name or email address and password, and then choose **Sign in**\.
**Note**  
You must have a GitHub account to complete this page\. For more information, see [Join GitHub](https://github.com/join) on the GitHub website\.

   1. If the **Two\-factor authentication** page is displayed, for **Authentication code**, enter the code that GitHub sends you, and then choose **Verify**\.

   1. On the **Authorize AWS CodeStar** page, choose **Authorize**\.
**Note**  
When you choose **Authorize**, you allow AWS CodeStar to create a GitHub repository for your personal GitHub account, or for any GitHub organization where you have permissions\. \(A green check in **Organization access** is used to indicate permissions\.\)  
To add a GitHub organization to the **Organization access** list, follow the instructions in [Inviting Users to Join Your Organization](https://help.github.com/articles/inviting-users-to-join-your-organization/) on the GitHub Help website\. After you join the organization, refresh the **Authorize AWS CodeStar** page to see the organization in the list\.   
To get permissions to authorize a GitHub organization that is in the list, but does not have a green check, choose **Grant**\. If you see **Request** instead, choose it, and then follow the instructions in [Approving OAuth Apps for Your Organization](https://help.github.com/articles/approving-oauth-apps-for-your-organization/) on the GitHub Help website\. Refresh the **Authorize AWS CodeStar** page to see the **Grant** button\.

   1. For **Owner**, choose the GitHub organization or your personal GitHub account\.

   1. For **Repository name**, accept the default GitHub repository name, or enter a different one\.

   1. Choose **Public repository** or **Private repository**\.
**Note**  
Depending on your GitHub account type, GitHub might not allow you to create a private repository\. For more information, see [GitHub Pricing](https://github.com/pricing) on the GitHub website\. Also, if you want to use AWS Cloud9 as your development environment, you must choose a public repository\.

   1. \(Optional\) For **Repository description**, enter a description for the GitHub repository\.

1. Choose **Next**\.

1. Review the resources and configuration details\. Choose **Edit Amazon EC2 Configuration** \(where available\) if your project is deployed to Amazon EC2 instances and you want to make changes\. For example, you can choose from available instance types for your project\. 
**Note**  
Different Amazon EC2 instance types provide different levels of computing power and might have different associated costs\. For more information, see [Amazon EC2 Instance Types](https://aws.amazon.com/ec2/instance-types/) and [Amazon EC2 Pricing](https://aws.amazon.com/ec2/pricing/)\.  
If you have more than one virtual private cloud \(VPC\) or multiple subnets created in Amazon Virtual Private Cloud, you can also choose the VPC and subnet to use\. However, if you choose an Amazon EC2 instance type that is not supported on dedicated instances, you cannot choose a VPC whose instance tenancy is set to **Dedicated**\.   
For more information, see [What Is Amazon VPC?](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Introduction.html) and [Dedicated Instance Basics](https://docs.aws.amazon.com/vpc/latest/userguide/dedicated-instance.html#dedicated-howitworks)\.

1. Leave the **AWS CodeStar would like permission to administer AWS resources on your behalf** check box selected\. Otherwise, you cannot create a project\. For more information about the service role, see [AWS CodeStar Service Role Policy and Permissions](access-permissions-service-role.md)\.

   Choose **Next** or **Create project**\. \(The displayed choice depends on your project template\.\) 

1. In **Choose an Amazon EC2 Key Pair**, choose the Amazon EC2 key pair you created in [Step 4: Create an Amazon EC2 Key Pair for AWS CodeStar Projects](setting-up.md#setting-up-create-ec2-key)\. Select **I acknowledge that I have access to the private key file for this key pair**, and then choose **Create project**\.

1. It might take a few minutes to create the project \(including the repository\)\. After your project has a repository, you can use the **Set up tools** page to configure access to it, or you can choose **Skip** and configure access later\. After your project has been created, you can use the links on the **Welcome** tile to configure other items, such as your [user profile in AWS CodeStar](working-with-user-info.md)\. 

While your project is being created, you can [add team members](how-to-add-team-member.md) or [configure access](setting-up-ide.md) to your project repository from the command line or your favorite IDE\. 

## Create a Project in AWS CodeStar \(AWS CLI\)<a name="how-to-create-project-cli"></a>

An AWS CodeStar project is a combination of source code and the resources created to deploy the code\. The collection of resources that help you build, release, and deploy your code are called toolchain resources\. At project creation, an AWS CloudFormation template provisions your toolchain resources in a continuous integration/continuous deployment \(CI/CD\) pipeline\.

When you use the console to create a project, the toolchain template is created for you\. When you use the AWS CLI to create a project, you create the toolchain template that creates your toolchain resources\.

A complete toolchain requires the following recommended resources:

1. A CodeCommit or GitHub repository that contains your source code\.

1. A CodePipeline pipeline that is configured to listen to changes to your repository\.

   1. When you use CodeBuild to run unit or integration tests, we recommend that you add a build stage to your pipeline to create build artifacts\.

   1. We recommend that you add a deployment stage to your pipeline that uses CodeDeploy or AWS CloudFormation to deploy your build artifact and source code to your runtime infrastructure\.
**Note**  
Because CodePipeline requires at least two stages in a pipeline, and the first stage must be the source stage, add a build or deploy stage as the second stage\.

AWS CodeStar toolchains are defined as a [CloudFormation template](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-guide.html)\. 

For a tutorial that walks through this task and sets up sample resources, see [Tutorial: Create a Project in AWS CodeStar with the AWS CLI](cli-tutorial.md)\.

**Prerequisites:**

When you create a project, you provide the following parameters in an input file\. If the following are not provided, AWS CodeStar creates an empty project\.
+ **Source code**\. If this parameter is included in your request, then you must also include a toolchain template\.
  + Your source code must include the application code required to run your project\.
  + Your source code must include any required configuration files, such as a buildspec\.yml for a CodeBuild project or an appspec\.yml for a CodeDeploy deployment\.
  + You can include optional items in your source code such as a README or a template\.yml for non\-toolchain AWS resources\.
+ **Toolchain template**\. Your toolchain template provisions the AWS resources and IAM roles to be managed for your project\.
+ **Source locations**\. If you specify source code and a toolchain template for your project, you must provide a location\. Upload your source files and your toolchain template to the Amazon S3 bucket\. AWS CodeStar retrieves the files and uses them to create the project\.

**Important**  
Make sure you configure the preferred AWS Region in the AWS CLI\. Your project is created in the AWS Region configured in the AWS CLI\.

1. Run the create\-project command and include the `--generate-cli-skeleton` parameter:

   ```
   aws codestar create-project --generate-cli-skeleton
   ```

   JSON\-formatted data appears in the output\. Copy the data to a file \(for example, `input.json`\) in a location on your local computer or instance where the AWS CLI is installed\. Modify the copied data as follows, and save your results\.

   ```
   {
       "name": "project-name", 
       "id": "project-id", 
       "description": "description", 
       "sourceCode": [
           {
               "source": {
                   "s3": {
                       "bucketName": "s3-bucket-name", 
                       "bucketKey": "s3-bucket-object-key"
                   }
               }, 
               "destination": {
                   "codeCommit": {
                       "name": "codecommit-repository-name"
                   }, 
                   "gitHub": {
                       "name": "github-repository-name", 
                       "description": "github-repository-description", 
                       "type": "github-repository-type", 
                       "owner": "github-repository-owner", 
                       "privateRepository": true, 
                       "issuesEnabled": true, 
                       "token": "github-personal-access-token"
                   }
               }
           }
       ], 
       "toolchain": {
           "source": {
               "s3": {
                   "bucketName": "s3-bucket-name", 
                   "bucketKey": "s3-bucket-object-key"
               }
           }, 
           "roleArn": "service-role-arn", 
           "stackParameters": {
               "KeyName": "key-name"
           }
       }, 
       "tags": {
           "KeyName": "key-name"
       }
   }
   ```

   Replace the following:
   + *project\-name*: Required\. The friendly name for this AWS CodeStar project\.
   + *project\-id*: Required\. The project ID for this AWS CodeStar project\.
**Note**  
You must have a unique project ID when you create a project\. You receive an error if you submit an input file with a project ID that already exists\. 
   + *description*: Optional\. The description for this AWS CodeStar project\.
   + *sourceCode*: Optional\. The configuration information for the source code provided for the project\. Currently, only a single `sourceCode` object is supported\. Each `sourceCode` object contains information about the location where source code is retrieved by AWS CodeStar and the destination where the source code is populated\.
     + *source*: Required\. This defines the location where you uploaded your source code\. The only supported source is Amazon S3\. AWS CodeStar retrieves the source code and includes it in the repository after your project is created\.
       + *S3*: Optional\. The Amazon S3 location of your source code\.
         + *bucket\-name*: The bucket that contains your source code\.
         + *bucket\-key*: The bucket prefix and object key that points to the \.zip file that contains your source code \(for example, `src.zip`\)\.
     + *destination*: Optional\. The destination locations where your source code is to be populated when the project is created\. The supported destinations for your source code are CodeCommit and GitHub\.

       You can provide only one of these two options:
       + *codeCommit*: The only required attribute is the name of the CodeCommit repository that should contain your source code\. This repository should be in your toolchain template\.
**Note**  
For CodeCommit, you must provide the name of the repository that you defined in your toolchain stack\. AWS CodeStar initializes this repository with the source code you provided in Amazon S3\.
       + *gitHub*: This object represents information required to create the GitHub repository and seed it with source code\. If you choose a GitHub repository, the following values are required\.
**Note**  
For GitHub, you cannot specify an existing GitHub repository\. AWS CodeStar creates one for you and populates this repository with the source code you uploaded to Amazon S3\. AWS CodeStar uses the following information to create your repository in GitHub\.
         + *name*: Required\. The name of your GitHub repository\. 
         + *description*: Required\. The description of your GitHub repository\. 
         + *type*: Required\. The type of GitHub repository\. Valid values are User or Organization\.
         + *owner*: Required\. The GitHub user name for the owner of your repository\. If the repository should be owned by a GitHub organization, provide the organization name\.
         + *privateRepository*: Required\. Whether you want this repository to be private or public\. Valid values are true or false\.
         + *issuesEnabled*: Required\. Whether you want to enable issues in GitHub with this repository\. Valid values are true or false\.
         + *token*: Required\. This is a personal access token AWS CodeStar uses to access your GitHub account\. This token must contain the following scopes: **repo**, **user**, and **admin:repo\_hook**\. To retrieve a personal access token from GitHub, see [Creating a Personal Access Token for the Command Line](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/) on the GitHub website\.
       + *toolchain*: Information about the CI/CD toolchain to be set up when the project is created\. This includes the location where you uploaded the toolchain template\. The template creates the AWS CloudFormation stack that contains your toolchain resources\. This also includes any parameter overrides for AWS CloudFormation to reference and the role to be used to create the stack\. AWS CodeStar retrieves the template and uses AWS CloudFormation to run the template\.
         + *source*: Required\. The location of your toolchain template\. Amazon S3 is the only supported source location\.
           + *S3*: Optional\. The Amazon S3 location where you uploaded your toolchain template\.
             + *bucket\-name*: The Amazon S3 bucket name\.
             + *bucket\-key*: The bucket prefix and object key that points to the \.yml or \.json file that contains your toolchain template \(for example, `files/toolchain.yml`\)\.
         + *stackParameters*: Optional\. Contains key\-value pairs to be passed to AWS CloudFormation\. These are the parameters, if any, your toolchain template is set up to reference\.
         + *role*: Optional\. The role used to create your toolchain resources in your account\. The role is required as follows:
           + If the role is not provided, AWS CodeStar uses the default service role created for your account if the toolchain is an AWS CodeStar quickstart template\. If the service role doesn't exist in your account, you can create one\. For information, see [Step 2: Create the AWS CodeStar Service Role](setting-up.md#setting-up-create-service-role)\.
           + You must provide the role must if you are uploading and using your own custom toolchain template\. You can create a role based on the AWS CodeStar service role and policy statement\. For an example of this policy statement, see [AWS CodeStar Service Role Policy](adh-policy-examples.md#adh-policy-service-role) \.
       + *tags*: Optional\. The tags attached to your AWS CodeStar project\.
**Note**  
These tags are not attached to the resources contained in the project\.

1. Switch to the directory that contains the file you just saved, and run the create\-project command again\. Include the `--cli-input-json` parameter\.

   ```
   aws codestar create-project --cli-input-json file://input.json
   ```

1. If successful, data similar to the following appears in the output:

   ```
   {
       "id": "project-ID",
       "arn": "arn"
   }
   ```
   + The output contains information about the new project:
     + The `id` value represents the project ID\. 
     + The `arn` value represents the ARN of the project\. 

1. Use the describe\-project command to check the status of your project creation\. Include the `--id` parameter\.

   ```
   aws codestar describe-project --id <project_ID> 
   ```

   Data similar to the following appears in the output:

   ```
   {
       "name": "MyProject",
       "id": "myproject",
       "arn": "arn:aws:codestar:us-east-1:account_ID:project/myproject",
       "description": "",
       "createdTimeStamp": 1539700079.472,
       "stackId": "arn:aws:cloudformation:us-east-1:account_ID:stack/awscodestar-myproject/stack-ID",
       "status": {
           "state": "CreateInProgress"
       }
   }
   ```
   + The output contains information about the new project:
     + The `state` value represents the status of the project creation, such as `CreateInProgress` or `CreateComplete`\.

While your project is being created, you can [add team members](how-to-add-team-member.md) or [configure access](setting-up-ide.md) to your project repository from the command line or your favorite IDE\.