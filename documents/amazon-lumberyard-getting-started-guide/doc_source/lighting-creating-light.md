# Creating a Light Source<a name="lighting-creating-light"></a>

Currently, the lamps in the level don't cast any light\. To fix this, you create a light source for the lamps in the maze\. 

1. In the **Perspective Viewport**, navigate near any lamp post in your level\. Right\-click and choose **Create entity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--1.png)

1. In the **Entity Inspector**, name the new entity **lamplight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--2.png)

1. Still in the **Entity Inspector**, click **Add Component**\. Under **Rendering**, click **Projector Light**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--3.png)

   You will notice that components also exist for an [area light](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-area-light.html) and a [point light](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-point-light.html), but for this tutorial you use a projection light\.

1. In the **Perspective Viewport**, use the **Rotate** tool to rotate the lamp light entity so it points down **Y: 90\.00 degrees\.**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--4.png)

1. Use the **Move** tool to position the lamp light entity under one of the lamp posts\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--5.png)

1. In the **Entity Inspector**, use the following settings for the **Projector Light** properties:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--6.png)
   + **Color**: R:**162**, G:**198**, B:**255**
   + **Diffuse Multiplier:** **15**
   + **Specular Multiplier:** **3**
   + **Max Distance:** **20**
   + **Attenuation bulb size:** **0\.5**
   + **FOV**: **80**

   Experiment with these settings to find a brightness, color, and size that you like\. Your lamp post should look similar to the image below\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--7.png)

1. Now that the light is positioned and set under the lamp, you can move the light entity into the **Lamp** slice and then save this change to the slice\. 

   In the **Entity Outliner**, drag the **lamplight** entity into the **Lamp** parent slice that you have been working near\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--8.png)

1. Now that the **lamplight** is in one of the lamp entities, under the **LampParent **group, right\-click the lamp entity and choose **Save slice overrides**, **maze\_lamp\.slice**\. This saves your changes to the source slice\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--9.png)

1. All the lamp posts in your scene should now be casting light\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting--11.png)

1. Press **Ctrl\+S** to save your level\.

1. Press **Ctrl\+G** to play your level\. When you are ready to exit, press **Esc**\.

[Next: 11: Setting up the UI](ui.md)