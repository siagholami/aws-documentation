# Sharing Dashboards<a name="sharing-a-dashboard"></a>

After you publish a dashboard, you can share it with other users or groups, and choose the level of access to grant them\. You can also choose to share with all users in your Amazon QuickSight subscription\.

After you share a dashboard, you can review the other users or groups that have access to it\. You can also revoke access to the dashboard, or remove yourself from it\.

You can also embed interactive dashboards in websites and apps\. For more information, see [Embedding Amazon QuickSight Dashboards](embedding-dashboards.md)\.

**Topics**
+ [View the Users Sharing the Dashboard](#view-users-dashboard)
+ [Share an Existing Dashboard](#share-a-dashboard)
+ [Revoke Access to a Dashboard](#revoke-access-to-a-dashboard)

## View the Users Sharing the Dashboard<a name="view-users-dashboard"></a>

Use the following procedure to see which users or groups have access to the dashboard\.

1. Open the dashboard and choose **Share** from the application bar\. Then choose **Manage dashboard access**\.

1. Review the users and groups, and their roles and settings\.

   You can search to locate a specific user or group by typing in their name, or any part of their name\. Searching is case\-sensitive, and wildcards are not supported\. Delete the search term to return view all user accounts\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/create-dashboard3.png)

## Share an Existing Dashboard<a name="share-a-dashboard"></a>

Use the following procedure to share a dashboard\. You can use the same procedure to reshare a dashboard to send a new notification email\. However, confirmation emails are not sent to groups\.

1. On the dashboard page, choose **Share** on the application bar\.

1. Do one of the following:
   + Before adding any users, you can check what permissions already exist by choosing **Manage dashboard access**\. Then choose **Add users** to return to this screen\.
   + You have the option to share with all the users in your QS; subscription\. To do this, select the option **Share with all users in this account**\. When you manage dashboard access through the **Managed dashboard sharing** screen, you see that the option **Share with all users in this account** is enabled\. The individual users aren't listed in this screen\.
   + To share with an individual user or group, type the user or group into the search box\. Then choose the user or group from the list that appears\. Only active users and groups appear in the list\.
**Important**  
Users who have access to the dashboard can also see the data used in the analysis\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/create-dashboard2.png)

     To add more users, type in another user or group\. You can remove users or groups by choosing the delete icon near the user that you want to remove\.

1. After you have entered everyone that you want to share with, choose **Share** to confirm your choices\. In the next screen, you can see the user name, email, permission level, user role, and privileges\. You can also remove a user by using the delete icon\.

1. Choose permissions for each user\. Users in the reader role don't have any options for permissions or **Save as** privileges\.
   + **Viewer**

     Viewers can view, filter, and sort the dashboard data\. They can also use any controls or custom URL actions that are on the dashboard\. Any changes they make to the dashboard exist only while they are viewing it, and aren't saved once they close the dashboard\. 
   + **Co\-owner**

     Co\-owners can edit and share the dashboard\. You have the option to provide them with the same permissions to the analysis\. If you want them to also edit and share the data set, you can set that up inside the analysis\. 

   Choose whether to enable a user's privilege to **Save as** to create a new dashboard from a copy of this one\. This privilege grants read\-only access to the data sets, so the user or group can create new analyses from it\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/create-dashboard3.png)

## Revoke Access to a Dashboard<a name="revoke-access-to-a-dashboard"></a>

Use the following procedure to revoke user access to a dashboard\.

1. On the dashboard page, choose **Share** on the application bar\.

1. Choose **Manage dashboard sharing**\.

1. Locate the user you want to remove\. Under **Action**, choose the delete icon for that user\. 