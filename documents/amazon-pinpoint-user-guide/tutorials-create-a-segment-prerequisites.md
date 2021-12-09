# Prerequisites<a name="tutorials-create-a-segment-prerequisites"></a>

You can use Amazon Pinpoint to create segments based on certain criteria that you define\. These criteria can be things such as the date an endpoint was last active, the device type and operating system, and even custom attributes that are specific to your project\.

Before you create your segment, you should understand some of the terms and concepts involved in creating segments\. You also have to create the base segments that serve as the foundation for the segment you're building\.

## Segmentation Terms<a name="tutorials-create-a-segment-prerequisites-terms"></a>

You should familiarize yourself with several terms and concepts before you start creating segments in Amazon Pinpoint\.

**Segment Group**  
A segment group consists of two parts: base segments and filters\. Base segments are the segments that define the potential population of the segment\. Filters are criteria that you apply on top of the base segments to further refine the segment\. In the Amazon Pinpoint console, you can create up to two segment groups\. Segment groups can be joined together using AND or OR logic\. You can add several different filters within each segment group\.

**Filters**  
Each segment group contains one or more filters\. These filters can be based on channel, endpoint or user attributes\. For instance, if you wanted to send an email campaign, you can create a filter that makes it so that the segment only includes endpoints in the Email channel\. The other filters types \(endpoints and users\) help you futher refine the segment based on the attributes of the user and the user's device\.

**Filter logic**  
When you add more than one filter to a segment group, you can choose how the filters are related to each other\. Filters can be connected by using the following operators:  
+ **All** – When you choose this option, the segment contains only the members of the base segments that meet all of the filter criteria\. For example, if you filter users whose favorite coffee drink is a latte AND whose favorite kind of donut is chocolate, your segment only contains users who meet both criteria\.
+ **Any** – When you choose this option, the segment contains members of the base segments that meet any one of the filter criteria\. For example, if you filter users whose favorite coffee drink is a latte OR whose favorite kind of donut is chocolate, your segment contains users who meet one or both of the criteria\.
+ **None** – When you choose this option, the segment contains only the members of the base segments that don't meet any of the filter criteria\. For example, if you filter users whose favorite coffee drink is NOT a latte, your segment contains users whose favorite coffee drink is every other type of drink except for a latte\.

**Segment group logic**  
If your segment contains two segment groups, you can choose how the two groups are connected\. You can connect segment groups using the following operators:  
+ **AND** – When you choose this option, the segment contains only the members that meet the criteria of both segment groups\.
+ **OR** – When you choose this option, the segment contains the members who meet the criteria in either of the segment groups\.

## Create Your Base Segment<a name="tutorials-create-a-segment-prerequisites-base-segments"></a>

To complete this tutorial, you need to create at least two base segments\. The first base segment includes the entire universe of customers that you might want to contact\. The second segment contains the list of customers that you explicitly don't want to contact \(your blacklist segment\)\.

There are two ways to create segments in Amazon Pinpoint\. The fastest method is to create a spreadsheet that contains the endpoint information for the segment\. For more information about importing segments, see [Importing Segments](segments-importing.md)\.

The other method of creating a segment is to integrate Amazon Pinpoint with your apps, and then create dynamic segments based on the usage data that your apps report to Amazon Pinpoint\. For more information about creating dynamic segments, see [Building Segments](segments-building.md)\. For more information about integrating your apps with Amazon Pinpoint, see [Integrating Amazon Pinpoint with Your Application](https://docs.aws.amazon.com/pinpoint/latest/developerguide/integrate.html) in the *Amazon Pinpoint Developer Guide*\.