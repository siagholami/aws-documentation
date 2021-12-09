# Parenting Entities<a name="placing-entities-parenting"></a>

You can organize your entities by grouping them together beneath another entity\. This is called parenting\. The top entity is called the parent entity, and any entities grouped beneath it are called child entities\. You can view the parent\-child relationship in the **Entity Outliner**\. Grouping or parenting your entities helps to keep your level organized\.

In this tutorial, you use the **Entity Outliner** to group together the three entities that you created in the previous tutorial\.

**To group entities**

1. Create a new, empty component: In your viewport, near the bottom center of the doorway entity, right\-click an empty area and then choose **Create entity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-parenting.png)

1. Select the new entity in the **Entity Outliner**\.

   In the **Entity Inspector**, rename this new entity to **Doorway\_parent**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-parenting-rename.png)

1. In the **Entity Outliner**, select the doorway and two tower entities\. Then drag the selection onto the **Doorway\_parent** entity\.

   The **Doorway\_parent** entity is now the parent of the doorway and two tower entities, which are now child entities\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-parenting-outliner.png)

1. Press **Ctrl\+S** to save your level\.

You have parented the three entities\. When you move, scale, and rotate the parent entity, the gate pieces are moved, scaled, and rotated as well\. You can, however, still select the individual entities and move them independently\. 

[Next: 4: Using Slices to Build the Maze](using-slices.md)