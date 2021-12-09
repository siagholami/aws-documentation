# Port a solution<a name="porting-assistant-port"></a>

To port a solution, follow these steps:

1. From the main page of the assessment tool, select **Assessed solutions** from the left navigation pane\. 

1. On the **Assessed Solutions** page, select a solutions file\. You will be directed to the**Assessment overview** page\.

1. Under the **Projects** tab, select the project you want to port\. Choose **Port project**\. The Porting Assistant will ask how you want to save your ported project\. Select whether you want to copy the ported project to a new location or modify the project in place\. 

   After you select the destination folder and choose **Save**, or select to modify the project file in place, you will be directed to the **Port projects** page\. 

1. Under **Port settings**, select a target framework version from the dropdown list and choose **Port**\.

1. Porting Assistant begins to port the new solution, and you will be directed to the **Assessment overview** page\. The status of the port appears at the top of the page\. You can view the port status of a package by selecting it on the **Assessment overview** page and looking at the **Port status** in the overview section\.

**Important**  
When you port a solution, your code is not refactored\. Your packages are upgraded to their latest compatible version and relevant project reference files are updated to the format compatible with \.NET Core\. Additional source code changes may be required\. If there are additional unresolved incompatibilities that require code changes, the project might not build after porting \. 