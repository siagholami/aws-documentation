# Creating a Level<a name="creating-new-level"></a>

Lumberyard currently works with level files as its primary system for organizing gameplay content\. Each level file contains the level file  along with support files that hold game data, scripts, terrain, and any additional references required for the level file to run in\-game\. 

You start by creating a new level within the Starter Game project, which you are already in if you have followed the tutorial up to this point\.

When you create a level, Lumberyard creates a level file within the project directory\. In this case, that is `dev\StarterGame\Levels\<levelname>`\. Staying in the Starter Game project directory means that you have easy access to all the assets that are associated with the project\. You'll use many of these assets throughout this tutorial series\. Such assets include prebuilt 3D objects, scripts, textures, and much more\.

**To create a new level**

1. You can create a new level in three ways\. Use one of the following methods to create a new level:
   + From the main menu: Choose **File**, **New**\.
   + With hot keys: Press **Ctrl\+N**\.
   + From the **Welcome** window: Click **New Level**\.

1. For **Name**, enter **MyFirstLevel**\.

   Level names can consist of alphanumeric characters\. You cannot use spaces or special characters except hyphen \[ \- \] and underscore \[ \_ \]\.

1. Set **Heightmap Resolution** to **512x512**\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/creating-new-level-new.png)

1. Select the **4096x4096** texture dimension\. This value is in pixels\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/creating-new-level-texture.png)

   You have an empty level with a flat terrain mesh in your level file\. You'll start with this empty file to build your game sample\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/creating-new-level-empty.png)

[Next: Importing a Heightmap](importing-height-map.md)