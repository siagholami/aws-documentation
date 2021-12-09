# Creating an Entity<a name="placing-entities-creating-doorway"></a>

In this tutorial, you create and name a new entity\. You'll name this entity 'doorway' and, in the next tutorials, add components to it that make it look like a doorway and give it collision data\.

**To create a doorway entity**

1. First, you create a new, empty entity\. To do this, in Lumberyard's perspective viewport, right\-click and choose **Create entity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-create-new.png)

   This action creates an empty entity, which means it currently has no components\.

   You can view your new empty entity in the **Entity Outliner**, which lists all entities in the level\. Its default placement is to the left of the viewport\. In the **Entity Outliner**, you should see the **PlayerSlice** that you placed in an earlier tutorial\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-empty.png)

1. Click **Entity1** to select your entity\.

1. Next, you name the entity\. To do this, you modify entity properties in the **Entity Inspector**, which is located by default to the right of the viewport\.

   For **Name**, `replace the **Entity1** text with **doorway**\.

   The **Entity Inspector** lists the components on the currently selected entity\. Every entity by default has a transform component, which defines the entity's position, rotation, and size\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-doorway.png)

1. Press **Ctrl\+S** to save your level\.

[Next: Adding a Mesh Component](placing-entities-static-mesh.md)