# Placing the Player Character<a name="placing-character-controller"></a>

In this tutorial, you place a player character so that you can move around and explore the level from a player's perspective\. To do this, you drag the character controller slice from the **Asset Browser** into your viewport\. Slices are described in a later tutorial\.

The character controller is Jack the robot, which you played in the previous tutorial in the orientation level\. You also place the camera manager slice, which improves player input controls from the keyboard\. The camera manager slice also helps to manage the switching of additional cameras, which you place later in this tutorial series\. 

**To place the character controller and camera manager**

1. The **Asset Browser** automatically opens in Lumberyard's default layout, in the lower left corner\. If you don't see it, choose **Tools**, **Asset Browser** to open it\.

1. In the **Asset Browser**, navigate to `StarterGame/slices`\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-asset-browser.png)

1. Drag `playerslice_efx.slice` into the viewport\.

   This places the robot character into your level, which you can control\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-small.png)

   Zoom in to view the character in detail\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-zoom.png)

1. Because the character controller is composed of a number of entities, all the helper icons are visible\. To hide these, click the hide helpers toggle in the top right of the viewport\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-toggle.png)

   You can now see the character's details clearly\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-clear.png)

1. To place the camera manager, drag `camera_manager.slice` from the same directory into your viewport\.

   The camera manager is not required to be situated in any particular place in your level\. However, for organizational purposes, you can place it near the player slice for future reference\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-cammanager.png)

1. Specify the camera in the CameraManager Lua Script\. To accomplish this, do the following:

   1. In the Entity Outliner, expand the **PlayerSlice** entity\. This exposes its child entities\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-cammanager-1.png)

   1. In the Entity Outliner, select the **CameraManager** entity\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-cammanager-2.png)

   1. In the Entity Inspector, in the **Lua Script \- CameraManager** component, next to **InitialCamera**, click the target symbol\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-cammanager-3.png)

   1. In the Entity Outliner, in the **PlayerSlice** child entities, click **Camera**\.

      This places the **Camera** entity in the **InitialCamera** slot for the **Lua Script \- CameraManager**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-character-controller-cammanager-4.png)

1. Press **Ctrl\+S** to save your level\.

1. Click **Ctrl\+G** to play the game and explore the terrain\. You can control the character using **W**, **A**, **S**, **D** keyboard controls, and click to shoot\. You can also use a PC game controller if preferred\.

[Next: 3: Gathering your Building Blocks](gathering-building-blocks.md)

**Additional Information**
+ [Component Entity System](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-intro.html)
+ [Component Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html)
+ [Entity Outliner](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-outliner.html)
+ [Entity Inspector](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-inspector.html)
+ [Asset Browser](https://docs.aws.amazon.com/lumberyard/latest/userguide/asset-browser-intro.html)