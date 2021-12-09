# Getting Started with AWS Migration Hub<a name="getting-started"></a>

In this section, you can find information about how to get started with AWS Migration Hub\. Included are steps to introduce you to the initial console screens that Migration Hub presents to a new user\.

Before you begin, be sure to set your home region, either from the console or by using commands in the CLI\. The first time you view the Migration Hub console, you'll be prompted to choose a home region\. You can choose and view your current home region on the Migration Hub **Settings** page\. To navigate to the **Settings** page, choose **Settings** in the left navigation\. After the home region is set, it cannot be changed\.

**Topics**
+ [Assumptions](#gs-assumptions)
+ [Access to AWS Migration Hub](#access-via-console-and-api)
+ [Two Ways to Get Started](#gs-the-two-ways)
+ [Perform Discovery and Then Migrate](gs-new-user-discovery.md)
+ [Migrate Without Performing Discovery](gs-new-user-migration.md)

**Note**  
If you are a developer or are interested in sending migration status from a migration tool, script, or custom code, see [AWS Migration Hub API](api-reference.md) and [AWS Migration Hub Home Region API reference](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/Welcome.html)\.  
All Migration Hub and Application Discovery Service API commands must be called from within the home region only, and they require you to call `GetHomeRegion` at least once before you call any other API, to obtain the account's Migration Hub home region\. Calls originating from outside your home region are rejected\.

## Assumptions<a name="gs-assumptions"></a>

For these walkthroughs, we make the following assumptions:
+ You have signed up for AWS\. For more information, see [Setting Up](setting-up.md)
+ You have selected your Migration Hub home region\.

Here's what to expect:
+ Migration Hub monitors the status of your migrations in all AWS Regions, provided that your migration tools are available in each region\. 
+ The migration status of every AWS Region undergoing migration is shown in your home region console\.
+ The migration tools that integrate with Migration Hub store all data about your migration status in Migration Hub\. The data is stored in your selected home region\.
+ The migration tools do not send status unless you have authorized \(that is, connected\) them\.
+ For a list of AWS Regions where you can use Migration Hub, see the [Amazon Web Services General Reference](https://docs.aws.amazon.com/general/latest/gr/rande.html#migrationhub_region)\.
+ For more information about working with your home region, see the section about [Home regions](https://docs.aws.amazon.com/migrationhub/latest/ug/home-region.html)\.

## Access to AWS Migration Hub<a name="access-via-console-and-api"></a>

AWS Migration Hub tracks the status of application migrations on the AWS Migration Hub console in your home region\. The Getting Started section and other sections of this guide use the console to illustrate migration functionality\. Open the AWS Migration Hub console at [https://console\.aws\.amazon\.com/migrationhub/](https://console.aws.amazon.com/migrationhub/)\.

Additionally, you can use the AWS Migration Hub API to track the status of your migrations from other tools or to send custom migration status to AWS Migration Hub\. For more information about the Migration Hub API, see [AWS Migration Hub API](api-reference.md)\. You'll also need to call the `GetHomeRegion` API from the Migration Hub [home region API](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/Welcome.html) when working with Migration Hub programmatically\. 

The AWS SDKs assist you to develop applications that interact with Migration Hub\. The AWS SDKs for Java, \.NET, and PHP wrap the underlying Migration Hub API to simplify your programming tasks\. For information about downloading the SDK libraries, see [Sample Code Libraries](http://aws.amazon.com/code)\.

## Two Ways to Get Started<a name="gs-the-two-ways"></a>

If this is the first time you are using Migration Hub, you will be prompted to choose your home region in the console before beginning either of these workflows\.

To discover detailed information about your servers using AWS discovery tools before migrating, see [Perform Discovery and Then Migrate](gs-new-user-discovery.md) to guide you through the discovery process\.

To start migrating immediately without using AWS discovery tools, see [Migrate Without Performing Discovery](gs-new-user-migration.md) to guide you through starting to migrate and tracking the status in Migration Hub\. You can also perform discovery at a later time if you want to gather server details\.

If you have not sent any data to Migration Hub yet, you will see the new user screen where you will be given the option to choose one of the two migration workflows\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/migrationhub/latest/ug/images/DashNewUser.png)

To begin your migration, choose either **Get started with discovery** or **Get started migrating** and then proceed to the workflow listed in the topics that follow\.

**Topics**
+ Option 1: [Perform Discovery and Then Migrate](gs-new-user-discovery.md)
+ Option 2: [Migrate Without Performing Discovery](gs-new-user-migration.md)