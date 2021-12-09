# The AWS Migration Hub Home Region<a name="home-region"></a>

Your AWS Migration Hub data is stored in your home region for purposes of discovery, planning, and migration tracking\. The status of migrations for your entire portfolio appears in your selected home region\. You can specify a home region from the Migration Hub **Settings** page or from the [Migration Hub Config API](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/Welcome.html)\. After it is set, the Migration Hub home region cannot be changed\.

## Choose a Migration Hub Home Region<a name="select-home-region"></a>

On your first use of the AWS Migration Hub console, select a Migration Hub home region\. If you haven’t selected a home region, you’ll be prompted to make a selection before you can perform any write action from the console, SDK, or CLI\. After you select a home region, you are redirected automatically to the console in that AWS Region\.

You can choose and view your current home region on the AWS Migration Hub **Settings** page\. To navigate to the **Settings** page, choose **Settings** from the left navigation\.

For a list of the available AWS Migration Hub home regions, see [AWS Migration Hub endpoints](https://docs.aws.amazon.com/general/latest/gr/migrationhubn.html) in the *AWS General Reference*\.

The Migration Hub console in your home region gives you detailed visibility into discovery and migration, regardless of whether you are moving applications into one AWS Region or ten\. From your Migration Hub home region, you can track your migration into any AWS Region\.

All of the discovery and migration tracking data sent from AWS tools or partner migration tools is stored and processed in your home region, regardless of the migrating application’s target region\.

 For example, you can select US West \(Oregon\) as your AWS Migration Hub home region, then perform discovery of your datacenters, and analyze and identify your applications\. If you use CloudEndure, for example, to migrate into Oregon and Frankfurt AWS Regions, you can track your CloudEndure migrations at the application level in Migration Hub\. Throughout each step in this example, your migration team uses Migration Hub in one AWS Region only: the home region you selected, which is the US West \(Oregon\) Region\.

## Set a Home Region for Discovery<a name="home-region-with-discovery"></a>

To start discovery and planning, you can deploy data collectors, such as AWS Application Discovery Agent or AWS Agentless Discovery Connector, into your data centers\. These tools send data to the AWS Migration Hub service in your home region, and the information is displayed on your home region console\.

Before you install your data collectors, your home region must be set\. Before collecting data, you must register your collectors in your home region\. If you're using the AWS CLI, you must set up your AWS CLI to use the home region as the default region\. Instructions for how to set your home region in the AWS CLI are provided in the AWS CLI sections of this guide\.

AWS Application Discovery Agent discovers data for many types of hardware, hypervisors, and operating systems including Linux and Windows\. An agent must be installed on each host that is targeted for migration\. For specific information about the data fields that are returned by AWS Application Discovery Agent, see the [AWS Application Discovery Agent](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-agent.html) user guide\.

AWS Agentless Discovery Connector discovers data for VMWare vCenter hosts and systems, using VMWare metadata\. For specific information about the data fields that are returned by AWS Agentless Discovery Connector, see the [AWS Agentless Discovery Connector ](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-connector.html)user guide 

Alternatively, you can import a `.csv` file by means of the [AWS Migration Hub Import](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-import.html) capability\.

## Set a Home Region for Migration Reporting<a name="migration-reporting"></a>

When you’re ready to migrate, use the migration tools that best fit your needs\. Options include AWS Server Migration Service \(AWS SMS\), AWS Database Migration Service \(AWS DMS\), or one of many third\-party tools\. Migrate your servers and applications into any AWS Region, and the migration progress reported by each tool is stored in your home region\. Stored data provides a single discovery and migration planning repository for your entire portfolio, and a single view of your migrations in multiple AWS Regions\.

Authorize your migration tools, such as AWS SMS, to read discovery data from and send migration status to Migration Hub in your home region\. The migration tools read application groupings and send basic identifying information for each resource\. For example, the hostname, IP address, MAC address, and VMware or hypervisor identifiers are sent, along with the resource’s migration status, from the migration’s destination region to the Migration Hub home region\.

## Changing Your Migration Hub Home Region<a name="change-home-region"></a>

After it is set, your Migration Hub home region cannot be changed\. Contact [AWS Support](http://aws.amazon.com/contact-us) for alternatives if you need to change your home region\.

## Working with the Migration Hub Home Region APIs<a name="using-migration-hub-apis"></a>

You can call the AWS Migration Hub, AWS Application Discovery Service, and AWS Migration Hub home region APIs from within your home region *only*\. API calls for write actions \(create, notify, associate, disassociate, import, or put\) originating from outside your home region are rejected, except for the ability to register your agents and connectors\. API calls for read actions \(list, describe, stop, and delete\) are permitted outside of your home region\.

**Note**  
 You can register agents and collectors outside your home region\. However, the `StartDataCollection` API call in AWS Application Discovery Service prevents you from enabling data collection from outside the home region\.

The AWS Migration Hub home region APIs are available specifically for working with your Migration Hub home region\. A general description of each API is provided next\. For specific API usage, see the [AWS Migration Hub Home Region API reference](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/Welcome.html)\.

[CreateHomeRegionControl](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/API_CreateHomeRegionControl.html)

This API sets up the home region\. It applies to the calling account only\.

[GetHomeRegion](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/API_GetHomeRegion.html)

Returns the calling account’s home region, if configured\. This API is used by other AWS services to determine the regional endpoint for calling AWS Application Discovery Service and Migration Hub\.

You must call `GetHomeRegion` at least once before you call any other Application Discovery Service and Migration Hub APIs, to obtain the account's Migration Hub home region\.

[DescribeHomeRegionControls](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/API_DescribeHomeRegionControls.html)

This API permits filtering on the `ControlId`, `HomeRegion`, and `RegionControlScope` fields\.