# Creating Texture Layers<a name="vegetation-texturelayers"></a>

To set the stage for painting pavement, grass, dirt, and rocks, you first create the texture layers\. Think of this as choosing the consistency and texture of the paint\.

You use the **Terrain Texture Layers** tool to create your texture layers\. You also use the **Material Editor** to assign the appropriate textures to those layers\.

**To create texture layers**

1. In Lumberyard Editor, choose **Tools**, **Other**, **Terrain Texture Layers**\.

   The **Terrain Texture Layers** editor displays the **Default** layer\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-texturelayers-editordefault.png)

1. To create four more layers, in the **Layer Tasks** panel, click **Add Layer** four times\.

   Click in the **Layer** column name and rename the four new layers with the following names:
   + **Grass**
   + **Dirt**
   + **Rocks**
   + **HexGround**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-texturelayers-rename.png)

Next, you assign materials to each of the four texture layers you created\. In this next procedure, you work with both the **Terrain Texture Layers** editor and the **Material Editor**, switching between the two editors to complete the tasks\.

**To assign materials to texture layers**

1. Open the **Material Editor** by pressing **M** or, from the main menu choose **Tools**, **Material Editor**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-texturelayers-material.png)

1. In the **Terrain Texture Layers** editor, select the **Dirt** layer\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-texturelayers-texture.png)

1. In the **Material Editor**, in the left panel, navigate to `StarterGame\Materials\Natural\Terrain`\.

   Select `am_mud2.mtl`\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-texturelayers-mud2.png)

1. Return again to the **Terrain Texture Layers** editor\. 

   The **Dirt** layer should still be selected\. In the upper left panel, **Layer Tasks**, click **Assign Material**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-texturelayers-assign.png)

   You have just assigned the **am\_mud2\.mtl** material to the **Dirt** layer\.

1. Repeat the preceding steps for the other three layers, assigning the following materials:
   + **Grass** layer – `am_grass1.mtl` material\.
   + **Rocks** layer – `am_mud1.mtl` material\.
   + **HexGround** layer – `am_path_hexagon.mtl` material\.

   When you have assigned the materials to the layers, your **Terrain Texture Layers** editor looks like the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-texturelayers-final.png)

[Next: Painting Pavement, Grass, Dirt, and Rocks](vegetation-paint.md)