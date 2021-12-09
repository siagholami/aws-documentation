# Specify AWS Credentials for Your ASP\.NET Core 2 Application<a name="deployment-ecs-specify-credentials"></a>

There are two types of credentials in play when you deploy your application to a Docker container: deployment credentials and instance credentials\.

Deployment credentials are used by the Publish Container to AWS wizard to create the environment in Amazon ECS\. This includes things like tasks, services, IAM roles, a Docker container repository, and if you choose, a load balancer\.

Instance credentials are used by the instance \(including your application\) to access different AWS services\. For example, if your an ASP\.NET Core 2\.0 application reads and writes to Amazon S3 objects, it will need appropriate permissions\. You can provide different credentials using different methods based on the environment\. For example, your ASP\.NET Core 2 application might target *Development* and *Production* environments\. You could use a local Docker instance and credentials for development and a defined role in production\.

## Specifying deployment credentials<a name="tkv-ecs-deploy-creds"></a>

The AWS account you specify in the **Publish Container to AWS** wizard is the AWS account the wizard will use for deployment to Amazon ECS\. The account profile must have permissions to Amazon Elastic Compute Cloud, Amazon Elastic Container Service, and AWS Identity and Access Management\.

If you notice options missing from drop\-down lists, it may be because you lack permissions\. For example, if you created a cluster for your application but do not see it on the **Publish Container to AWS** wizard Cluster page\. If this happens, add the missing permissions and try the wizard again\.

## Specifying development instance credentials<a name="tkv-ecs-dev-creds"></a>

For non\-production environments, you can configure your credentials in the appsettings\.<environment>\.json file\. For example, to configure your credentials in the appsettings\.Development\.json file in Visual Studio 2017:

1. Add the AWSSDK\.Extensions\.NETCore\.Setup NuGet package to your project\.

1. Add AWS settings to appsettings\.Development\.json\. The configuration below sets `Profile` and `Region`\.

   ```
   {
       "AWS": {
           "Profile": "local-test-profile",
           "Region": "us-west-2"
       }
   }
   ```

## Specifying production instance credentials<a name="id1"></a>

For production instances, we recommend you use an IAM role to control what your application \(and the service\) can access\. For example, to configure an IAM role with Amazon ECS as the service principal with permissions to Amazon Simple Storage Service and Amazon DynamoDB from the AWS Management Console:

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane of the IAM console, choose Roles, and then choose Create role\.

1. Choose the **AWS Service** role type, and then choose **EC2 Container Service**\.

1. Choose the **EC2 Container Service Task** use case\. Use cases are defined by the service to include the trust policy that the service requires\. Then choose **Next: Permissions**\.

1. Choose the **AmazonS3FullAccess** and **AmazonDynamoDBFullAccess** permissions policies\. Check the box next to each policy, and then choose **Next: Review**,

1. For **Role name**, type a role name or role name suffix to help you identify the purpose of this role\. Role names must be unique within your AWS account\. They are not distinguished by case\. For example, you cannot create roles named both `PRODROLE` and `prodrole`\. Because various entities might reference the role, you cannot edit the name of the role after it has been created\.

1. \(Optional\) For **Role description**, type a description for the new role\.

1. Review the role and then choose **Create role**\.

You can use this role as the **task role** on the **ECS Task Definition** page of the **Publish Container to AWS** wizard\.

For more information, see [Using Service\-Based Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html)\.