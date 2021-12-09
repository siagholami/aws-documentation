# Creating Embedded Dashboards with the Amazon QuickSight SDK<a name="embedded-dashboards-setup"></a>

This section helps you understand the process for creating embedded dashboards and using the `GetDashboardEmbedURL` API to get an embedded URL and authorization code\. In general, embedding a dashboard in your web page or app involves the following steps\. 

Before you can embed content, you need a subscription to Amazon QuickSight Enterprise edition in the AWS account you plan to use to embed dashboards\. If your app also resides in AWS, the app and the Amazon QuickSight subscription should be in the same AWS account\. 

Set up your data sources and create the visualizations you want to share, then publish them into one or more dashboards that you can embed into your app\.

1. Add the domain of the web app where you want to embed the dashboard to the list of domains that are approved for embedding\. 

   An Amazon QuickSight admin can view or edit the list of approved domains\. For more information, see [Adding Domains for Embedded Dashboard Users](approve-domain-for-dashboard-embedding.md)\.

1. Set up permissions for users:
   + Verify that you have an AWS Identity and Access Management \(IAM\) role that specifically allows access to the dashboard's Amazon Resource Name \(ARN\)\. An AWS administrator can create an IAM role with the correct policy attached\. For more information, see [IAM Policy Actions for Embedding Dashboards with Amazon QuickSight ](set-iam-policy.md#iam-policy-actions-for-embedded-dashboards)\. 
   + Verify that your users get authenticated through IAM, SAML, or WebIdentity\. Authentication methods are configured by an AWS administrator, and then added to Amazon QuickSight by an Amazon QuickSight admin\. 
   + Verify that the author of the analysis published the dashboard and shared it with the users or groups who want to use it\.

1.   Use the Amazon QuickSight JavaScript SDK to create a URL to embed in your webpage on the server\.   

1. Integrate the [Amazon QuickSight JavaScript SDK](https://aws.amazon.com/tools/) into your app\. You can then embed the dashboard and integrate it with your webpage using the JavaScript SDK\.

You can go directly to the examples in the sections listed below, if you want to jump in immediately\.

**Topics**
+ [HTML Example](embedded-dashboards-example-html.md)
+ [Java Example](embedded-dashboards-example-java.md)
+ [JavaScript \(Node\.js\) Example](embedded-dashboards-example-javascript.md)
+ [Python3 Example](embedded-dashboards-example-python.md)
+ [\.NET/C\# Example](embedded-dashboards-example-csharp.md)

The remainder of this section provides further details on using the API operation\. For more information, see [Amazon QuickSight API Reference](https://docs.aws.amazon.com/quicksight/index.html?id=docs_gateway)\. 

`GetDashboardEmbedURL` takes the following parameters:
+ `awsAccountId` — AWS account ID that contains the dashboard you are embedding
+ `dashboardId` — The ID for the dashboard, also added to IAM policy
+ `identityType` — Authentication type \(Currently, only `IAM` is supported\.\)
+ `sessionLifeTimeInMinutes` — How many minutes the session is valid
+ `undoRedoDisabled` — Remove the undo/redo button on embedded dashboard
+ `resetDisabled` \- Remove the reset button on embedded dashboard

You need the following SDK files:
+ [http://s3\-us\-west\-2\.amazonaws\.com/quicksight\-ams\-sdk\-files/AWSQuickSightJavaClient\-1\.11\.x\.jar](http://s3-us-west-2.amazonaws.com/quicksight-ams-sdk-files/AWSQuickSightJavaClient-1.11.x.jar)
+ [http://s3\-us\-west\-2\.amazonaws\.com/quicksight\-ams\-sdk\-files/botocore\-1\.12\.35\.tar\.gz](http://s3-us-west-2.amazonaws.com/quicksight-ams-sdk-files/botocore-1.12.35.tar.gz)
+ [http://s3\-us\-west\-2\.amazonaws\.com/quicksight\-ams\-sdk\-files/nuget\.zip](http://s3-us-west-2.amazonaws.com/quicksight-ams-sdk-files/nuget.zip)

The following example shows the AWS CLI commands and the order to run them in\. You can use the API operations for these in your own code\. There are several examples in this section\.

```
CLI Basic Example

/* Assume the role with permissions enabled for actions: quickSight:RegisterUser and quicksight:GetDashboardEmbedURL */
/* You can use assume-role, assume-role-with-web-identity, or assume-role-with-saml */
aws sts assume-role 
	--role-arn "arn:aws:iam::111122223333:role/embedding_quicksight_dashboard_role" 
	--role-session-name embeddingsession

/* If the user does not exist in QuickSight, register the user */
aws quicksight register-user 
	--aws-account-id 111122223333 
	--namespace default 
	--identity-type IAM 
	--iam-arn "arn:aws:iam::111122223333:role/embedding_quicksight_dashboard_role" 
	--user-role READER 
	--session-name "embeddingsession" 
	--email user123@example.com 
	--region us-east-1
	
/* Get the URL for the embedded dashboard, to be used in a server-side call*/
aws quicksight get-dashboard-embed-url 
	--aws-account-id 111122223333 
	--dashboard-id 1a1ac2b2-3fc3-4b44-5e5d-c6db6778df89 
	--identity-type IAM
```

The following shows an example response from `get-dashboard-embed-url`:

```
{
    "Status": "200",
    "EmbedUrl": "https: //spaceneedle-alpha.amazon.com/embed/620bef10822743fab329fb3751187d2d&hellip...long_URL_including_auth_code",
    "RequestId": "7bee030e-f191-45c4-97fe-d9faf0e03713"
}
```

Use the following procedure to assume the role, register the user, and get your embedded dashboard URL\.

1. Set up permissions for dashboard users\. They should do the following:
   + Be authenticated through IAM, SAML, or WebIdentity\.
   + Assume a role that gives them access to the dashboard through Amazon QuickSight\.
   + Be one of the users the dashboard is shared with\.

   Each user who views the dashboard embedded in your application must have permission to access the dashboard\. You can provision users ahead of time manually or by using API operations, or provision them just\-in\-time as they access your application\. You can permission users individually, or use the groups API to create and manage user groups for sharing\. 

   Each user who accesses a dashboard must assume a role that gives them Amazon QuickSight access and permissions to the dashboard\. To achieve this, create a role in your AWS account that has an associated policy that provides reader permissions to any user who assumes it\. Add **quicksight:RegisterUser** permissions to ensure that the reader can only access Amazon QuickSight in a read\-only fashion, and not have access to any other data or creation capability\. You also need to provide the role with permissions to retrieve dashboards by using **quicksight:GetDashboardEmbedUrl**\.

   To assume the role, choose one of the following AWS Security Token Service \(AWS STS\) API operations:
   + [https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) — Use this when you are using an IAM identity to assume the role\.
   + [https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRoleWithWebIdentity.html](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRoleWithWebIdentity.html) — Use this when you are using a web identity provider to authenticate your user\. 
   + [https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRoleWithSAML.html](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRoleWithSAML.html) — Use this when you are using SAML to authenticate your users\.

   At the time of assuming the role, also ensure that you are passing a unique session ID for each user \(for example, email address\)\. The combination of the role name and the session \(`rolename/rolesessionname`\) is treated as the unique user name in Amazon QuickSight\. An example is `EmbeddedQuickSightReader/username@example.com` or `QuickSightEmbed/QSviewer`\. By doing this, you can ensure appropriate permissions per user\. It also prevents any throttling of user access\. Throttling is a security feature that prevents the same user from accessing Amazon QuickSightfrom multiple locations\.

   If you get an `ExpiredToken` error when calling the `AssumeRole` operation, this is because the previous `SESSION TOKEN` is still in the environment variables\. Clear this by setting the following variables:
   + *AWS\_ACCESS\_KEY\_ID* 
   + *AWS\_SECRET\_ACCESS\_KEY* 
   + *AWS\_SESSION\_TOKEN* 

   If you didn't previously provision the user in Amazon QuickSight, call the `RegisterUser` API to federate the user into the role\. You can then add the user to the correct user group by using the group management API operations to make the dashboard available to the user\. 

1. An Amazon QuickSight admin must add the domain of the web app you want to embed the dashboard into the list of domains that are approved for embedding\. There is an option to add subdomains as part of a domain\. You can add up to 100 domains to the allowlist\. For more information, see [Adding Domains for Embedded Dashboard Users](approve-domain-for-dashboard-embedding.md)\.

1. Call the `GetDashboardEmbedUrl` API to get the URL that you can embed in your dashboard\. This URL is valid for 5 minutes, and the resulting session is valid for 10 hours\. The API provides the URL with an auth\_code that enables a single\-signon session\. 

   Use the Amazon QuickSight embedding SDK \(JavaScript\) to embed the dashboard\. This allows you to control parameters within the dashboard and receive callbacks in terms of page load completion and errors\. Currently, we support server\-side calls only\. 

   Embed this dashboard in your webpage by using the Amazon QuickSight JavaScript SDK or by adding this URL into an iframe\. If you add it to an iframe, you must encode the URL\. If you set a fixed height and width number \(in pixels\) Amazon QuickSight uses those and doesn't change your visual as your window resizes\. If you set a relative percent height and width, Amazon QuickSight will provide a responsive layout that is modified as your window size changes\. 

**Topics**
+ [HTML Example](embedded-dashboards-example-html.md)
+ [Java Example](embedded-dashboards-example-java.md)
+ [JavaScript \(Node\.js\) Example](embedded-dashboards-example-javascript.md)
+ [Python3 Example](embedded-dashboards-example-python.md)
+ [\.NET/C\# Example](embedded-dashboards-example-csharp.md)
