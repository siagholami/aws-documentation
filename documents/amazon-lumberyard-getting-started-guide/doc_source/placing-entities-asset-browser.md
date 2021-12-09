# Using the Asset Browser to Create an Entity<a name="placing-entities-asset-browser"></a>

You can also use Lumberyard's **Asset Browser** to create an entity in your level\. 

The **Asset Browser** appears by default in Lumberyard's bottom left corner and displays a tree view of the files in your project directory\. You can drag an asset file directly from the asset browser into your viewport\. When you do, Lumberyard automatically adds the **Mesh** component and sets the **Mesh asset** as the file you dragged\. 

This method is slightly faster than adding a mesh component and then specifying the mesh asset\. You must still add the collider and static physics components\.

**To add a post entity using the Asset Browser**

1. The **Asset Browser** is open in Lumberyard's default layout and is located in the lower left corner\. If it is not open, choose **Tools**, **Asset Browser**\.

   In the **Asset Browser**, navigate to `StarterGame/Objects/GSG`\.

   Select `GSG_Maze_Doorway_Post.fbx`, and then drag it into your viewport\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-asset-browser-post.png)

1. Use the [positioning tools](understanding-manipulating-moving.md) to move the post so that it is next to the gate as shown in the following image\.
**Tip**  
[**Snap to Grid**](understanding-manipulating-moving-snapgrid.md) is on by default\. This makes objects snap to points on a grid\. To more precisely place objects, turn off **Snap to Grid**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-asset-browser-post1.png)

1. Ensure that the post entity is selected in the **Entity Outliner**\.

   In the **Entity Inspector**, for **Name**, enter **Entry Tower**\. This renames your entity\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-asset-browser-rename.png)

1. Add the [mesh collider](placing-entities-adding-colliders.md) and [static physics](placing-entities-adding-colliders.md) components, as you learned in a previous procedure\.

   In the next tutorial, you learn how to duplicate an entity\.

1. Press **Ctrl\+S** to save your level\.

[Next: Duplicating an Entity](placing-entities-duplicating.md)