# Adding a Mesh Component<a name="placing-entities-static-mesh"></a>

In this tutorial, you add a mesh component to the doorway entity and reference a prebuilt `.cgf` file\. The `.cgf` file provides the 3D mesh data that defines what the entity looks like\.

**To add a mesh component**

1. In the **Entity Inspector**, click **Add Component**\.

   Under **Rendering**, select **Mesh**\.
**Tip**  
To quickly find a component, enter its name into the **Search** bar\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-static-mesh.png)

1. Under **Mesh**, next to **Mesh asset**, click the browse \(**…**\) button\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-static-mesh-asset.png)

   In the browser window, navigate to `StarterGame/Objects/GSG`\. Select `GSG_Maze_Doorway.fbx`, and then click **OK**\.

   This file is the 3D mesh that defines the appearance of the entity\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-doorway-mesh.png)

   Your entity now appears as a doorway\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-doorway-mesh-attached.png)

1. Press **Ctrl\+S** to save your level\.

1. Press **Ctrl\+G** to play the game\.

   Observe that your character cannot interact with the doorway entity but instead can pass right through it\. You will add collider and physics components in the next section so that your character can interact with the entity\.

[Next: Adding Collider and Physics Components](placing-entities-adding-colliders.md)