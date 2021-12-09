# Amazon QuickSight \.NET/C\# SDK<a name="quicksight-sdk-csharp"></a>

Use the following procedure to interact with Amazon QuickSight using C\#\.NET\. This example is constructed on Microsoft Visual for Mac; the instructions can vary slightly based on your IDE and platform\. However, they should be similar\.

1. Unzip the `nuget.zip` file into a folder called `nuget`\.

1. Create a new **Console app** project in Visual Studio\.

1. Under your solution, locate app **Dependencies**, then open the context \(right\-click menu and choose **Add Packages**\.

1. In the sources list, choose **Configure Sources**\.

1. Choose **Add**, and name the source `QuickSightSDK`\. Browse to the `nuget` folder and choose **Add Source**\.

1. Choose **OK**\. Then, with `QuickSightSDK` selected, select all three Amazon QuickSight packages:
   + `AWSSDK.QuickSight`
   + `AWSSDK.Extensions.NETCore.Setup`
   + `AWSSDK.Extensions.CognitoAuthentication`

1. Click **Add Package**\. 

1. Copy and paste the following sample app into your console app editor\.

   ```
   using System;
   using Amazon.QuickSight.Model;
   using Amazon.QuickSight;
   
   namespace DotNetQuickSightSDKTest
   {
       class Program
       {
           private static readonly string AccessKey = "insert_your_access_key";
           private static readonly string SecretAccessKey = "insert_your_secret_key";
           private static readonly string AccountID = "AWS_account_ID";
           private static readonly string Namespace = "default";  // leave this as default
   
           static void Main(string[] args)
           {
               var client = new AmazonQuickSightClient(
                   AccessKey,
                   SecretAccessKey, 
                   Amazon.RegionEndpoint.USEast1);
   
               var listUsersRequest = new ListUsersRequest
               {
                   AwsAccountId = AccountID,
                   Namespace = Namespace
               };
   
               client.ListUsersAsync(listUsersRequest).Result.UserList.ForEach(
                   user => Console.WriteLine(user.Arn)
               );
   
               var listGroupsRequest = new ListGroupsRequest
               {
                   AwsAccountId = AccountID,
                   Namespace = Namespace
               };
   
               client.ListGroupsAsync(listGroupsRequest).Result.GroupList.ForEach(
                   group => Console.WriteLine(group.Arn)
               );
           }
       }
   }
   ```