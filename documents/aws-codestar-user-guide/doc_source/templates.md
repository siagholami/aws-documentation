# AWS CodeStar Project Templates<a name="templates"></a>

AWS CodeStar project templates allow you to start with a sample application and deploy it using AWS resources created to support your development project\. When you choose an AWS CodeStar project template, the application type, programming language, and compute platform are provisioned for you\. After you create projects with web applications, web services, Alexa skills, and static web pages, you can replace the sample application with your own\.

After AWS CodeStar creates your project, you can modify the AWS resources that support delivery of your application\. AWS CodeStar works with AWS CloudFormation to allow you to use code to create support services and servers/serverless platforms in the cloud\. AWS CloudFormation allows you to model your entire infrastructure in a text file\. 

**Topics**
+ [AWS CodeStar Project Files and Resources](#templates-whatis)
+ [Get Started: Choose a Project Template](#templates-choose-template)
+ [How to Make Changes to Your AWS CodeStar Project](#update-project)

## AWS CodeStar Project Files and Resources<a name="templates-whatis"></a>

An AWS CodeStar project is a combination of source code and the resources created to deploy the code\. The collection of resources that help you build, release, and deploy your code are called *toolchain resources*\. At project creation, an AWS CloudFormation template provisions your toolchain resources in a continuous integration/continuous deployment \(CI/CD\) pipeline\.

You can use AWS CodeStar to create projects in two ways, depending on your experience level with AWS resource creation: 
+ When you use the console to create a project, AWS CodeStar creates your toolchain resources, including your repository, and populates your repository with sample application code and project files\. Use the console to quickly set up sample projects based on a set of preconfigured project options\. 
+ When you use the CLI to create a project, you provide the AWS CloudFormation template that creates your toolchain resources and the application source code\. Use the CLI to allow AWS CodeStar to create your project from your template and then populate your repository with your sample code\.

An AWS CodeStar project provides a single point of management\. You can use the **Create project** wizard in the console to set up a sample project\. You can then use it as a collaboration platform for managing permissions and resources for your team\. For more information, see [What Is AWS CodeStar?](welcome.md)\. When you use the console to create a project, your source code is provided as sample code, and your CI/CD toolchain resources are created for you 

When you create a project in the console, AWS CodeStar provisions the following resources:
+ A code repository in GitHub or CodeCommit\.
+ In the project repository, a `README.md` file that provides details of files and directories\.
+ In the project repository, a `template.yml` file that stores the deﬁnition for your application's runtime stack\. You use this file to add or modify project resources that are not toolchain resources, such as AWS resources used for notifications, database support, monitoring, and tracing\.
+ AWS services and resources created in connection with your pipeline, such as the Amazon S3 artifact bucket, Amazon CloudWatch Events, and related service roles\.
+ A working sample application with full source code and a public HTTP endpoint\.
+ An AWS compute resource, based on the AWS CodeStar project template type:
  + A Lambda function\. 
  + An Amazon EC2 instance\. 
  + An AWS Elastic Beanstalk environment\. 
+ Starting December 6, 2018 PDT:
  + A permissions boundary, which is a specialized IAM policy for controlling access to project resources\. The permissions boundary is attached by default to roles in the sample project\. For more information, see [IAM Permissions Boundary for Worker Roles](access-permissions-proj.md#access-permissions-proj-pb-worker)\.
  + An AWS CloudFormation IAM role for creating project resources using AWS CloudFormation that includes permissions for all AWS CloudFormation supported resources, including IAM roles\.
  + A toolchain IAM role\.
  + Execution roles for Lambda defined in the application stack, which you can modify\.
+ Before December 6, 2018 PDT:
  + An AWS CloudFormation IAM role for creating project resources with support for a limited set of AWS CloudFormation resources\.
  + An IAM role for creating a CodePipeline resource\.
  + An IAM role for creating an CodeBuild resource\.
  + An IAM role for creating a CodeDeploy resource, if applicable to your project type\.
  + An IAM role for creating the Amazon EC2 web app, if applicable to your project type\.
  + An IAM role for creating a CloudWatch Events resource\.
  + An execution role for Lambda that is dynamically modified to include a partial set of resources\.

The project also includes an interactive dashboard that shows status, links to team management, links to setup instructions for IDEs or your repository, and a commit history of source code changes in the repository\. You can also select tools for connecting to external issue tracking tools, such as Jira\.

## Get Started: Choose a Project Template<a name="templates-choose-template"></a>

When you choose an AWS CodeStar project in the console, you are choosing from a set of preconfigured options with sample code and resources to get you started quickly\. These options are called *project templates*\. Each AWS CodeStar project template consists of an application type, programming language, and compute platform\. The combination you select determines the project template\.

### Choose a Template Application Type<a name="templates-choose-template-application"></a>

Each template configures one of the following application types:
+ **Web service**

   A web service is used for tasks that run in the background, such as calling APIs\. After AWS CodeStar creates your sample web service project, you can choose the endpoint URL to see Hello World output, but the primary use of this application type is not as a user interface \(UI\)\. The AWS CodeStar project templates in this category support development in Ruby, Java, ASP\.NET, PHP, Node\.js, and more\.
+ **Web application**

   A web application features a UI\. After AWS CodeStar creates your sample web application project, you can choose the endpoint URL to see an interactive web application\. The AWS CodeStar project templates in this category support development in Ruby, Java, ASP\.NET, PHP, Node\.js, and more\.
+ **Static web page **

  Choose this template if you want a project for an HTML website\. The AWS CodeStar project templates in this category support development in HTML5\.
+ **Alexa skill**

  Choose this template if you want a project for an Alexa skill with an AWS Lambda function\. When you create the skill project, AWS CodeStar returns an Amazon Resource Name \(ARN\) that you can use as a service endpoint\. For more information, see [Host a Custom Skill as an AWS Lambda Function](https://developer.amazon.com/docs/custom-skills/host-a-custom-skill-as-an-aws-lambda-function.html)\.
**Note**  
Lambda functions for Alexa skills are supported in the US East \(N\. Virginia\), US West \(Oregon\), EU \(Ireland\), and Asia Pacific \(Tokyo\) Regions only\.
+ **Config rule**

   Choose this template if you want a project for an AWS Config rule that lets you automate rules across AWS resources in your account\. The function returns an ARN that you can use as a service endpoint for your rule\.

### Choose a Template Programming Language<a name="templates-choose-template-language"></a>

When you choose a project template, you select a programming language, such as Ruby, Java, ASP\.NET, PHP, Node\.js, and more\.

### Choose a Template Compute Platform<a name="templates-choose-template-platform"></a>

Each template configures one of the following compute platform types:
+ When you choose an AWS Elastic Beanstalk project, you deploy to an AWS Elastic Beanstalk environment on Amazon Elastic Compute Cloud instances in the cloud\.
+ When you choose an Amazon EC2 project, AWS CodeStar creates Linux EC2 instances to host your application in the cloud\. Your project team members can access the instances, and your team uses the key pair you provide to SSH into your Amazon EC2 instances\. AWS CodeStar also has a managed SSH that uses team member permissions to manage key pair connections\.
+ When you choose AWS Lambda, AWS CodeStar creates a serverless environment accessed through Amazon API Gateway, with no instances or servers to maintain\.

## How to Make Changes to Your AWS CodeStar Project<a name="update-project"></a>

You can update your project by modifying: 
+ Sample code and programming language resources for your application\.
+ Resources that make up the infrastructure where your application is stored and deployed \(operating systems, support applications and services, deployment parameters, and the cloud compute platform\)\. You can modify application resources in the `template.yml` file\. This is the AWS CloudFormation file that models your application's runtime environment\.

**Note**  
If you are working with an Alexa Skills AWS CodeStar project, you cannot make changes to the skill outside of the AWS CodeStar source repository \(CodeCommit or GitHub\)\. If you edit the skill in the Alexa developer portal, the change might not be visible in the source repository and the two versions will be out of sync\.

### Change Application Source Code and Push Changes<a name="update-project-application"></a>

To modify sample source code, scripts, and other application source files, edit files in your source repository by:
+ Using the Edit mode in CodeCommit or GitHub\.
+ Opening the project in an IDE, such as AWS Cloud9\.
+  Cloning the repository locally and then committing and pushing your changes\. For information, see [Step 5: Commit a Change](getting-started.md#getting-started-commit)\.

### Change Application Resources with the Template\.yml File<a name="update-project-application-template"></a>

Instead of manually modifying an infrastructure resource, use AWS CloudFormation to model and deploy your application's runtime resources\.

You can modify or add an application resource, such as a Lambda function, in your runtime stack by editing the `template.yml` file in your project repository\. You can add any resource that is available as an AWS CloudFormation resource\.

To change the code or settings of an AWS Lambda function, see [Add a Resource to a Project](customize-project-template.md)\.

Modify the `template.yml` file in your project's repository to add the type of AWS CloudFormation resources that are application resources\. When you add an application resource to the `Resources` section of the `template.yml` file, AWS CloudFormation and AWS CodeStar create the resource for you\. For a list of AWS CloudFormation resources and their required properties, see [AWS Resource Types Reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-template-resource-type-ref.html)\. For more information, see this example in [Step 1: Edit the CloudFormation Worker Role in IAM](customize-project-template.md#customize-project-template-sqs-2)\.

AWS CodeStar allows you to implement best practices by configuring and modeling your application's runtime environment\.

#### How to Manage Permissions to Change Application Resources<a name="update-project-application-permissions"></a>

 When you use AWS CloudFormation to add runtime application resources, such as a Lambda function, the AWS CloudFormation worker role can use the permissions it already has\. For some runtime application resources, you must manually adjust the AWS CloudFormation worker role's permissions before you edit the `template.yml` file\.

For an example of changing the AWS CloudFormation worker role's permissions, see [Step 5: Add Resource Permissions with an Inline Policy](customize-project-template.md#customize-project-template-sqs-5)\.

### <a name="update-project-toolchain-template"></a>

#### <a name="update-project-toolchain-permissions"></a>