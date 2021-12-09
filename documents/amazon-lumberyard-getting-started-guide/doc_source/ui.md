# 11: Setting Up the UI<a name="ui"></a>

In this tutorial, you'll set up your game's UI\. To do this, you'll use a prebuilt slice to set up a title screen and a "mission complete" screen\.

**To set up the game UI**

1. In the **Asset Browser**, navigate to `StarterGame\Slices\GSG`\.

   Drag `maze_ui.slice` into the viewport\.

1. Align the slice for this level's purposes\. To do this, make sure either the **maze\_wall\_exterior** or **maze\_wall\_interior** parent entity is visible\.

   In the viewport or the **Entity Outliner**, select `UI_Maze_Slice`\.

   Click the **Align to Object** icon ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/align-to-object.png), and then click either **maze\_wall\_exterior** or **maze\_wall\_interior**\.

1. Set the **CameraManager**'s starting camera to the UI slice's camera\. To do this:
   + A – In the **Entity Outliner**, select **CameraManager**\.
   + B – In **Entity Inspector**, under **Lua Script \- CameraManager**, next to the **InitialCamera** box, click the picker icon ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/picker.png)\.
   + C – In **Entity Outliner**, under **UI\_Maze\_Slice**, choose **MazeCameraStartScreen** \(C\)\.
   + D – In **Entity Inspector**, under **Lua Script \- CameraManager**, in the **InitialCameraTag** box, enter **MazeCameraStartScreen** \(D\)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/exporting-maze-camera-start.png)

   To see the title screen and test your camera, press **Ctrl\+G** to play the game\.

   Press **Esc** to quit\.

1. Move the title screen camera to a position that you like for the start of the game\. To do this, in the **Entity Outliner**, expand the **UI\_Maze\_Slice** parent entity\.

   Select the **MazeCameraStartScreen** entity\.

   In the upper left of the viewport, right\-click the **Perspective** title bar\. Choose **Camera**, **MazeCameraStartScreen**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/exporting-mazecamera.png)

   Notice that your view changes when you click this option\. That's because you are now viewing the level through this particular entity\.

   Using viewport navigation tools, position the camera with the view that you want the player to see when starting the game\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/exporting-entity.png)

1. When you have the view that you want, switch back to the default camera\. To do this, right\-click the viewport \(**Perspective**\) title bar and choose **Camera**, **Default Camera**\.

1. Press **Ctrl\+S** to save your level\.

1. Press **Ctrl\+G** to play your level\. Notice that the start screen camera view starts where you positioned it, and then switches to the third person player camera when you press a key to start\.

   Press **Esc** to quit\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ui-runner.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ui-complete.png)

[Next: 12: Exporting Your Game](exporting.md)