# Stacking the Crates and Barrels to Make a Wall<a name="physics-organize"></a>

First you organize the crate and barrels by placing them into a parent entity and then moving the parent entity to a place in the maze where you build the wall\.

Then you duplicate the crate and barrels and stack them upon each other to create the wall\.

**To parent your crate and barrels**

1. In the viewport, near where you put your crate and barrels, right\-click and choose **Create entity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-organize-new.png)

1. In the **Entity Inspector**, name the new entity **CrateWallParent**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-organize-name.png)

1. In the **Entity Outliner**, drag the barrel and crates entities into **CrateWallParent**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-organize-drag.png)

1. In the viewport, use the **Move** tool to drag **CrateWallParent** to where you want to place your wall within the maze\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-organize-wall.png)

1. In the **Entity Outliner**, right\-click on one of your crates and choose **Duplicate**\. This creates a duplicate of the object on top of the original object\.

   In the viewport, use the **Move** tool to position the duplicated object\.

   Repeat this step to duplicate and position the crate and barrels until you have a wall four layers high that blocks the passageway\.
**Tip**  
You can also duplicate an entity by doing any of the following:  
Right\-clicking it in the viewport and choosing **Duplicate**\.
Selecting the entity and then pressing **Ctrl\+D**\. Use your mouse pointer to position it in the viewport and then click to place\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-organize-four.png)

1. Once you have stacked your wall, use the **Rotate** tool to nudge each object a few degrees along the **Z** rotation to give the wall the look of randomness\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-organize-rotate.png)

   When complete, your level should look similar to the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-organize-done.png)

1. Press **Ctrl\+S** to save your level\.

1. Press **Ctrl\+G** to play your level\.

   Find the stack of crates and shoot at them or run into them\. Notice how the crates fall and roll based on their density settings\.

   Press **Esc** to quit\.

[Next: 8: Sculpting the Terrain](vegetation.md)