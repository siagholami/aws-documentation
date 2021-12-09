# What Is AWS Migration Hub?<a name="whatishub"></a>

AWS Migration Hub provides a single place to discover your existing servers, plan migrations, and track the status of each application migration\. The AWS Migration Hub provides visibility into your application portfolio and streamlines planning and tracking\. You can see the status of the servers and databases that make up each of the applications you are migrating, regardless of which migration tool you are using\.

AWS Migration Hub gives you the choice to start migrating right away and group servers while migration is underway, or to first discover servers and then group them into applications\. Either way, you can migrate each server in an application and track progress from each tool in the AWS Migration Hub\. It supports migration status updates from the following AWS services: AWS Database Migration Service, AWS Server Migration Service, and [CloudEndure Migration](https://aws.amazon.com/cloudendure)\. It also supports migration status updates from the following partner tools: [ATADATA ATAmotion](https://aws.amazon.com/migration-hub/partners/) and [RiverMeadow Migration SaaS](https://aws.amazon.com/migration-hub/partners/)\.

For more information, open the AWS Migration Hub console at [https://console\.aws\.amazon\.com/migrationhub/](https://console.aws.amazon.com/migrationhub/), and in the navigation pane under **Migrate**, choose **Tools**\. *Note that you must first have an AWS account and credentials for access to the Migration Hub console \- see* [Setting Up](setting-up.md)\.

## Are You a First\-Time User of AWS Migration Hub?<a name="welcome-first-time-user"></a>

On your first use of the AWS Migration Hub console, you’ll be prompted to select a Migration Hub home region where your data will be stored\. You can choose a home region on the **Settings** page of the console\. After you select a home region, you are redirected automatically to the console in that AWS Region\. You must make a selection before you can perform any write action from the console, SDK, or CLI interfaces\.

 If you are a first\-time user of AWS Migration Hub, we recommend that you read the following sections in order:
+  [Getting Started](getting-started.md) 
+  [Home Region](home-region.md) 
+  [Walkthroughs](walkthroughs.md) 

To learn about sending status to or querying status from AWS Migration Hub using the AWS SDK or AWS CLI, see:
+  [AWS Migration Hub API](api-reference.md) 
+  [AWS Migration Hub Home Region API](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/Welcome.html) 

 Remember that only your migration tracking data is stored in your home region\. You can migrate into any AWS Region supported by your migration tool\.

If you have a tool that you want to integrate with [AWS Migration Hub](http://console.aws.amazon.com/migrationhub/home), contact us by choosing **Feedback** in the lower left\-hand corner of the footer in the AWS Migration Hub console\. For all support issues, contact us [here](https://aws.amazon.com/contact-us/)\.