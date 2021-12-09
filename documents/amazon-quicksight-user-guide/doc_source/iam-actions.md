# Working with IAM Actions and Permissions for Amazon QuickSight Users<a name="iam-actions"></a>

Amazon QuickSight provides a number of AWS Identity and Access Management \(IAM\) actions that you can use for creating or removing an Amazon QuickSight account\. All Amazon QuickSight actions are prefixed with `quicksight:`, such as `quicksight:Subscribe`\. For information about using Amazon QuickSight actions in an IAM policy, see [Setting Your IAM Policy](set-iam-policy.md)\.

The following list shows the supported Amazon QuickSight actions:
+ **`"quicksight:CreateAdmin"`**

  `CreateAdmin` enables the user to provision Amazon QuickSight administrators, authors, and readers\.
+ **`"quicksight:CreateUser"`**

  `CreateUser` enables the user to provision Amazon QuickSight authors and readers\.
+ **`"quicksight:CreateReader"`**

  `CreateReader` enables the user to provision Amazon QuickSight readers\.
+ **`"quicksight:GetGroupMapping"`**

  `GetGroupMapping` is used only in Amazon QuickSight Enterprise edition accounts\. It enables the user to use Amazon QuickSight to identify and display the Microsoft Active Directory \(Microsoft Active Directory\) directory groups that are mapped to roles in Amazon QuickSight\. 
+ **`"quicksight:GetDashboardEmbedUrl"`**

  `GetDashboardEmbedUrl` allows a dashboard to be invoked as an embedded entity\. 
+ **`"quicksight:SearchDirectoryGroups"`**

  `SearchDirectoryGroups` is used only in Amazon QuickSight Enterprise edition accounts\. It enables the user to use Amazon QuickSight to display your Microsoft Active Directory directory groups so that you can choose which ones to map to roles in Amazon QuickSight\. 
+ **`"quicksight:SetGroupMapping"`**

  SetGroupMapping is used only in Amazon QuickSight Enterprise edition accounts\. It enables the user to use Amazon QuickSight to map the Microsoft Active Directory directory groups that you select to roles in Amazon QuickSight\. 
+ **`"quicksight:Subscribe"`**

  `Subscribe` enables the user to subscribe to Amazon QuickSight\. Enabling this action also allows the user to upgrade the subscription to Enterprise edition\.
+ **`"quicksight:Unsubscribe"`**

  `Unsubscribe` enables the user to unsubscribe from Amazon QuickSight, which permanently deletes all users and their resources from Amazon QuickSight\.