# Phase 2: Track<a name="migrate-wt-track"></a>

In the track phase, you track the status of migrations\.
+ Track Status of Migrations\.

**Topics**
+ [Track Step 1: Track Status of Migrations](#migrate-wt-track-app-status)

## Track Step 1: Track Status of Migrations<a name="migrate-wt-track-app-status"></a>

**To track an application's migration status**

1. Because you started your migration after you connected \(authorized\) your migration tool\(s\) and also grouped servers as applications in prior steps, your applications will already be present in Migration Hub's dashboard\.

1. In the top pane labeled **Most recently updated applications**, click inside the donut chart labeled with the name of your migrating application\. Doing this displays the application's detail screen\.

   1. If you do not see all of your application's servers listed in the application's details page, it could be because you have not grouped those servers into this application yet\.  See [Updates About My Migrations Don't Appear Inside an Application](troubleshooting.md#migs-do-not-appear-in-app)\.

1.  The first time a migration task is started for a server associated with the application, applications with this status will change to the **in\-progress** status, automatically\. After verifying the in\-progress migration status from the application's detail screen, if the status is still **Not started**, you can manually change it to **In\-progress**\. Choose **Change status** in the upper, right\-hand corner\.

1. Select the radio button next to **In\-progress** in the dialog box\.

1. Choose **Save**\. A green confirmation message appears at the top of the screen, and the status label changes to **In\-progress**\.

1. When the data in the application's detail screen indicates migration has completed, and you've performed testing and verification, change the status from "In\-progress" to "Completed" by choosing **Change status** in the top right corner of the page\.

1. Select the radio button next to **Completed** in the box\.

1. Choose **Save**\. A green confirmation message appears at the top of the screen, and the status label changes to **Completed**\.