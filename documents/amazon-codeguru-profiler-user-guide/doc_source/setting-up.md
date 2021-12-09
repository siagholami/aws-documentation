# Setting up CodeGuru Profiler<a name="setting-up"></a>

An Amazon CodeGuru Profiler proﬁling group is a group of applications for which data is meant to be aggregated and analyzed together\. To create a proﬁling group, sign in to the AWS Management Console and set permissions for the CodeGuru Profiler proﬁling agent\.

The proﬁling agent collects runtime data from your applications\. Data that the agent collects is analyzed to provide flame graphs and hourly reports with recommendations for how you can optimize your applications\.

You can create a profiling group using your own application or the demo application\. For more information about using the demo application, see [Getting started with CodeGuru Profiler](getting-started.md)\.

Before you can start using CodeGuru Profiler, you must complete the following steps\. 

**Topics**
+ [Step 1: Sign up for AWS](#setting-up-step-1)
+ [Step 2: Create a CodeGuru Profiler profiling group](#setting-up-step-2)
+ [Step 3: Set permissions](#setting-up-step-3)
+ [Step 4: Start CodeGuru Profiler in your application](#setting-up-step-4)

## Step 1: Sign up for AWS<a name="setting-up-step-1"></a>

When you sign up for Amazon Web Services \(AWS\), your AWS account is automatically signed up for all services in AWS, including CodeGuru Profiler\. You're charged only for the services that you use\.

If you have an AWS account already, skip to the next task\. If you don't have an AWS account, use the following procedure to create one\.

**To create an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

## Step 2: Create a CodeGuru Profiler profiling group<a name="setting-up-step-2"></a>

A profiling group can profile one or more applications\. Data is aggregated and displayed based on the whole profiling group\.

For example, if you have a collection of microservices that handle restaurant recommendations, you can collect profile data and identify performance issues across all these microservices in a single profiling group named "Restaurant\-Recommendations"\. 

**To create a profiling group**

1. Sign in to the AWS Management Console, and then open the CodeGuru Profiler console at [https://console\.aws\.amazon\.com/codeguru](https://console.aws.amazon.com/codeguru)\.

1. In the navigation pane on the left, choose **Profiler**, and then choose **Profiling groups**\.

1. On the **Profiling groups** page, choose **Create profiling group**\.

1. Provide a **Name** for the new profiling group\. Choose the compute platform that your applications are running on\. If your applications run on AWS Lambda, choose the **AWS Lambda** option\. Choose **Other** if your applications run on a compute platform other than AWS Lambda, such as Amazon EC2, on\-premises servers, or a different platform\. 

1. Choose **Create profiling group**\.

## Step 3: Set permissions<a name="setting-up-step-3"></a>

The CodeGuru Profiler profiling agent needs permissions to write data to the profiling group\. 

**To set permissions for the new CodeGuru Profiler agent:**

1. Start by choosing **Give access to users and roles**\. Choose the IAM users or roles that can submit profiling data and configure the agent\. 

1. If your applications run on AWS Lambda, choose the role that your AWS Lambda function uses\. 

1. After you grant permissions for a user or role, you don't need to attach IAM policies for agent permissions\.  
![\[Image: Manage user and role permissions to submit profiling data.\]](http://docs.aws.amazon.com/codeguru/latest/profiler-ug/images/manage-permissions.png)

   Use `IAM:ListUsers` and `IAM:ListRoles` permissions to see your users and roles\. Otherwise, you can add a user or Amazon Resource Name \(ARN\) role\. You'll see the following message\.   
![\[Image: Error message on the manage permissions section. Cannot list users and roles.\]](http://docs.aws.amazon.com/codeguru/latest/profiler-ug/images/manage-permissions-error.png)

   Alternatively, you can add a policy like the following to the role that your application uses\. For more information about roles, see [Modifying a role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_manage_modify.html)\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Effect": "Allow",
               "Action": [
                   "codeguru-profiler:ConfigureAgent",
                   "codeguru-profiler:PostAgentProfile"
               ],
               "Resource": "arn:aws:codeguru-profiler:<region>:<accountID>:profilingGroup/<profilingGroupName>"
           }
       ]
   }
   ```

If your application is running in a Region that CodeGuru Profiler doesn't support and if you have the appropriate permissions, you can submit profiling data to one of the supported Regions\. For more information about using CodeGuru Profiler in a Region it doesn't support, see [Working with unsupported Regions](working-with-unsupported-regions.md)\.

## Step 4: Start CodeGuru Profiler in your application<a name="setting-up-step-4"></a>

### Run your application with the profiling agent<a name="setting-up-agent"></a>

Run your application with the CodeGuru Profiler profiling agent\. You can either start the agent as a Java virtual machine \(JVM\) agent, or start it manually with a code change in your application\. To start profiling your application, see [Integrating with Amazon CodeGuru Profiler](integrating-with-codeguru-profiler.md)\.