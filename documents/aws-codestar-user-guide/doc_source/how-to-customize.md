# Customize an AWS CodeStar Dashboard<a name="how-to-customize"></a>

You can customize your project dashboard by adding, removing, and moving tiles\. You can also customize the team wiki tile to show information about your project\.

**Topics**
+ [Add, Remove, or Move Tiles on Your Dashboard](#how-to-customize-order)
+ [Add a Project Extension to Your Dashboard](#how-to-customize-extensions)
+ [Customize the Team Wiki Tile](#how-to-customize-tile)

## Add, Remove, or Move Tiles on Your Dashboard<a name="how-to-customize-order"></a>

You can change the appearance of your project dashboard by adding, removing, or changing the order and position of tiles on your dashboard\.

To change the appearance of your project dashboard:
+ To add a tile, on the project dashboard, choose **Add tile** and choose the tile from the list\. You can add only one of each type of tile\.
+ To remove a tile, on the project dashboard, choose the ellipsis \(**…**\) on the tile, and then choose **Remove from dashboard**\.
+ To change the position of a tile on the dashboard, drag it to the position where you want it to appear\.

## Add a Project Extension to Your Dashboard<a name="how-to-customize-extensions"></a>

AWS CodeStar includes extensions that add tiles and functionality to your dashboard\. For example, you can configure the JIRA extension to add and configure a JIRA tile for your project dashboard\. 

To add a project extension to your dashboard, on the navigation bar for your project, choose **Extensions**\. Next to the extension you want to add, choose **Show on dashboard**\.

To set up an extension that is displayed on your dashboard, choose the connect button or command on the extension, and then follow instructions to complete setup\.

To remove an extension that is displayed on your dashboard:
+ Choose the ellipsis \(**…**\) on the extension you want to remove, and then choose **Remove from Dashboard**\.
+ On the navigation bar for your project, choose **Extensions**\. Next to the extension you want to remove, choose **Hide from dashboard**\.

## Customize the Team Wiki Tile<a name="how-to-customize-tile"></a>

Each AWS CodeStar project includes a customizable team wiki tile\. You can change the name and contents of this tile\. You can use this customizable tile to share links to team resources or highlight code samples\. Every project team member can view this tile, but only team members who are assigned a contributor or owner role can modify its contents\. This tile supports both plain text and [CommonMark](http://commonmark.org/help/) content, with the following differences:
+ You can highlight programming language syntax in code blocks\. To do this, specify the language, followed by the code\. For example, for JavaScript:

  ```
  ```JavaScript
  var hello = function() {
    console.log("hello world");
  }
  ```
  ```
+ Inline embedding of images is not supported\.

**Note**  
Do not use this tile to store confidential data\.

**To customize a team wiki tile in a project**

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

   Choose the project\.

1. In the project dashboard, choose the ellipsis \(**…**\) for the project information tile, and then choose **Edit**\. 

1. In **Markdown Editor**, in **Title**, enter a new tile name\. In **Markdown content**, add plain text or [CommonMark](http://commonmark.org/help/) content\. For example, you could add a link to your team project wiki or other content\.

   Choose **Save**\.

For a step\-by\-step example, see [Step 4: Customize the Team Wiki Tile and the Project Dashboard](getting-started.md#getting-started-custom)\.