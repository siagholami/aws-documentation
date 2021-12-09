# Analyzing Amazon Macie–Monitored Data by User Activity<a name="macie-users"></a>

The **Users** tab can help you draw a comprehensive picture of all of the data and activity monitored by Macie for a particular selected user\. This topic describes how to search for the users whose activity you want to investigate further in the **Users** tab\. It also describes the views that you can use in this tab to see the selected users' monitored data grouped by various interest points\. Each view provides you with one or more ways of navigating to the Macie console's **Research** tab\. There you can construct and run queries in the query parser and conduct in\-depth investigative research of the data and activity monitored by Macie for the selected users\. 

**Topics**
+ [MacieUniqueID](#macie-users-concepts)
+ [User Categories in Macie](#macie-users-categories)
+ [Investigating Users](#investigate-user)

## MacieUniqueID<a name="macie-users-concepts"></a>

In the context of Macie, a user is the AWS Identity and Access Management \(IAM\) identity that makes a particular request\. Macie uses the AWS CloudTrail `userIdentity` element to distinguish the following user types\. For more information, see [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\. 
+ Root – The request was made with your AWS account credentials\.
+ IAM user – The request was made with the credentials of an IAM user\. 
+ Assumed role – The request was made with temporary security credentials that were obtained with a role via a call to the AWS Security Token Service \(AWS STS\) `AssumeRole` API operation\. 
+ Federated user – The request was made with temporary security credentials that were obtained via a call to the AWS STS `GetFederationToken` API operation\.
+ AWS account – The request was made by another account\. 
+ AWS service – The request was made by an account that belongs to an AWS service\. 

When specifying a user in the Macie console, you must use a special Macie format called `macieUniqueId`\. Examples of specifying a user include searching for a user in the **Users** tab, constructing a query in the **Research** tab, and whitelisting a user in a basic alert with the index of **CloudTrail data**\. The `macieUniqueId` is a combination of the IAM `UserIdentity` element and the `recipientAccountId`\. For more information, see [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html) and the definition of `recipientAccountId` in [CloudTrail Record Contents](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-record-contents.html)\. 

The following examples list various structures of `macieUniqueId`, depending on the user identity type\.


| userIdentity | MacieUniqueId | 
| --- | --- | 
|  <pre>"userIdentity": {<br />    "type": "AssumedRole"<br />    "arn": "arn:aws:sts::123456789012:assumed-role/Accounting-Role/Mary"<br />}</pre>  |  `123456789012:assumed-role/accounting-role`  | 
|  <pre>"userIdentity": {<br />    "type": "IAMUser",<br />    "arn": "arn:aws:iam::123456789012:user/Bob",<br />    "userName": "Bob"<br />}</pre>  |  `123456789012:user:bob`  | 
|  <pre>"userIdentity": {<br />    "type": "FederatedUser"<br />    "arn": "arn:aws:sts::123456789012:federated-user/Alice",<br />    "principalId": "123456789012:Alice",<br />}</pre>  |  `123456789012:federated-user:alice`  | 
|  <pre>"recipientAccountId": "123456789012",<br />"userIdentity": {<br />    "type": "AWSAccount"<br />    "accountId": "ANONYMOUS_PRINCIPAL",<br />}</pre>  |  `123456789012:ANONYMOUS_PRINCIPAL`   | 
|  <pre>"macieUniqueId": "123456789012:root:root",<br />"userIdentity": {<br />    "type": "Root"<br />    "sourceARN": "arn:aws:iam::123456789012:root",<br />}</pre>  |  `123456789012:root:root`  | 
|  <pre>"recipientAccountId": "123456789012",<br />"userIdentity": {<br />    "invokedBy": "codepipeline.amazonaws.com",<br />    "type": "AWSService"<br />}</pre>  |  `123456789012:codepipeline.amazonaws.com`   | 
|  <pre>"recipientAccoundId": "123456789012",<br />"userIdentity": {<br />    "type": "AWSAccount"<br />    "accountId": "987654321098",<br />    "principalId": "AIDABCDEFGHI123456XYZ",<br />}</pre>  |  `123456789012:AIDABCDEFGHI123456XYZ`  | 

## User Categories in Macie<a name="macie-users-categories"></a>

Based on their activity \(API calls\), users in Macie are grouped into the following categories:
+ **Platinum** – These IAM users or roles have a history of making high\-risk API calls indicative of an administrator or root user, such as creating users, authorizing security group ingress, or updating policies\. These accounts should be monitored closely for signs of account compromise\. 
+ **Gold** – These IAM users or roles have a history of making infrastructure\-related API calls indicative of a power user, such as running instances or writing data to Amazon Simple Storage Service \(Amazon S3\)\. These accounts should be monitored closely for signs of account compromise\. 
+ **Silver** – These IAM users or roles have a history of issuing high quantities of medium\-risk API calls, such as `Describe*` and `List*` operations, or read\-only access requests to Amazon S3\.
+ **Bronze** – These IAM users or roles typically execute lower quantities of `Describe*` and `List*` API calls in the AWS environment\.

## Investigating Users<a name="investigate-user"></a>

Follow this procedure to generate a comprehensive picture of all of the data and activity monitored by Macie for the specified user\.

1. In the Macie console's **Users** tab, specify a user name in the **Search** field and press Enter\.
**Note**  
When specifying a user, you must use a special Macie format called **macieUniqueId**: for example, `123456789012:root`, `123456789012:user/Bob`, or `123456789012:assumed-role/Accounting-Role/Mary`, depending on the identity type of the user that you want to whitelist\. For more information, see the definition of *user* in [Concepts and Terminology](macie-concepts.md)\.

1. When the user data is generated, choose the corresponding icon to select any of the following views to display various subsets of this user's data and activity that Macie monitors:
   + [High\-risk CloudTrail events](#user-high-risk-events)
   + [High\-risk CloudTrail errors](#user-high-risk-errors)
   + [Activity location](#user-activity-location)
   + [CloudTrail events](#user-cloudtrail-events)
   + [Activity ISPs](#user-activity-isp)
   + [CloudTrail user identity types](#user-cloudtrail-user-identity-type)

1. If present in the selected view, locate and move the **Minimum risk** slider to the desired value\. The **Minimum risk** slider enables you to view only items with the assigned risk equal to and greater than the selected value\. 

### High\-Risk CloudTrail Events<a name="user-high-risk-events"></a>

This view provides a visual representation of the top 20 \(by assigned risk and based on the value selected on the **Minimum risk** slider\) CloudTrail data and management events that occurred during the last 60 days for the selected user\. Use the available **Daily** or **Weekly** radio buttons to modify the graph to view daily or weekly results\. 

To navigate from this view to the **Research** tab, select \(double\-click\) any square that represents a particular event that you want to investigate further\. The number in parentheses next to the event name represents the number of user sessions \(5\-minute aggregates of CloudTrail data\) that this event is present in\. In the **Research** tab, your selection is automatically translated into a query that appears in the query parser\. For more information, see [Researching Through Data Monitored by Amazon Macie](macie-research.md)\.

### High\-Risk CloudTrail Errors<a name="user-high-risk-errors"></a>

This view provides a visual representation of the top 20 \(by assigned risk and based on the value selected on the **Minimum risk** slider\) CloudTrail errors that occurred during the last 60 days for the selected user\. You can use the available **Daily** or **Weekly** radio buttons to modify the graph to view daily or weekly results\. 

To navigate from this view to the **Research** tab, select \(double\-click\) any square that represents a particular error that you would like to investigate further\. The number in parentheses next to the error name represents the number of user sessions \(5\-minute aggregates of CloudTrail data\) that this error is present in\. In the **Research** tab, your selection is automatically translated into a query that appears in the query parser\. For more information, see [Researching Through Data Monitored by Amazon Macie](macie-research.md)\.

### Activity Location<a name="user-activity-location"></a>

This view includes a map that shows the locations of activity that Macie is monitoring for a selected time period for the specified user\. To view details, use the available time period dropdown \(past 15 days, past 30 days, past 90 days, or past year\) and then choose any location pin\. 

To navigate from this view to the **Research** tab, choose the number of events that appears in a tool tip window for a location pin\. In the **Research** tab, your selection is automatically translated into a query that appears in the query parser\. For more information, see [Researching Through Data Monitored by Amazon Macie](macie-research.md)\. 

### CloudTrail Events<a name="user-cloudtrail-events"></a>

This view provides the complete list of CloudTrail data and management events monitored by Macie for the specified user\. For each event, the total count of the user sessions \(5\-minute integrations of CloudTrail data\) that this event is present in, and the percentage that this total represents of the total number of user sessions is displayed\.

To navigate from this view to the **Research** tab, choose the looking glass icon next to any of the displayed events\. Your selection is automatically translated into a query that appears in the query parser in the **Research** tab\. For more information, see [Researching Through Data Monitored by Amazon Macie](macie-research.md)\. 

### Activity ISPs<a name="user-activity-isp"></a>

This view provides the complete list of CloudTrail data and management events monitored by Macie, grouped by the associated internet service providers \(ISPs\) for the specified user\. For each ISP, the total count of the user sessions \(5\-minute integrations of CloudTrail data\) that this ISP is present in, and the percentage that this total represents of the total number of user sessions is displayed\. 

To navigate from this view to the **Research** tab, choose the looking glass icon next to any of the displayed themes\. Your selection is automatically translated into a query that appears in the query parser in the **Research** tab\. For more information, see [Researching Through Data Monitored by Amazon Macie](macie-research.md)\. 

### CloudTrail User Identity Types<a name="user-cloudtrail-user-identity-type"></a>

This view provides the complete list of CloudTrail data and management events monitored by Macie, grouped by the user identity type for the specified users\. For more information, see the definition for *user* in [Concepts and Terminology](macie-concepts.md) \. For each user identity type, the total count of the user sessions \(5\-minute integrations of CloudTrail data\) that this user identity type is present in, and the percentage that this total represents of the total number of user sessions is displayed\. 

To navigate from this view to the **Research** tab, choose the looking glass icon next to any of the displayed themes\. Your selection is automatically translated into a query that appears in the query parser in the **Research** tab\. For more information, see [Researching Through Data Monitored by Amazon Macie](macie-research.md)\. 