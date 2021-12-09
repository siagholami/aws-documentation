# Using Amazon QuickSight with the AWS SDKs<a name="quicksight-sdks"></a>

Using Amazon QuickSight, you can manage some aspects of your deployment by using the AWS SDKs\. You can use one of the AWS SDKs to access an API that's tailored to the programming language or platform that you're using\. For more information, see [AWS SDKs](http://aws.amazon.com/tools/#SDKs)\.

The first release of API operations for Amazon QuickSight introduces embedding and user and group management capabilities\. You can use the `get-dashboard-embed-url` API operation to obtain an authenticated dashboard URL that can be embedded in application domains that are on the allow list for Amazon QuickSight dashboard embedding\. You can use the user API operations to programmatically expand and manage your Amazon QuickSight deployments\. You can use the group API operations for easier permissions management for resources within Amazon QuickSight\. 

Amazon QuickSight supports SDKs for the following: 
+ User and group provisioning and management
+ Embedded dashboards and provisioning of their users \(Enterprise edition only\)

For more information, see [Amazon QuickSight API Reference](https://docs.aws.amazon.com/quicksight/index.html?id=docs_gateway)\. 

**Topics**
+ [Permissions for Using Amazon QuickSight from the AWS SDKs](permissions-for-using-sdks.md)
+ [Amazon QuickSight and the AWS CLI](quicksight-cli.md)
+ [Amazon QuickSight Java SDK](quicksight-sdk-java.md)
+ [Amazon QuickSight JavaScript \(Node\.js\) SDK](quicksight-sdk-javascript.md)
+ [Amazon QuickSight Python3 SDK](quicksight-sdk-python.md)
+ [Amazon QuickSight \.NET/C\# SDK](quicksight-sdk-csharp.md)
+ [Terminology](quicksight-developer-terminology.md)