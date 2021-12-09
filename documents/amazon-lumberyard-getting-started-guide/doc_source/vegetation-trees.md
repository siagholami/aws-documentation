# Placing Trees<a name="vegetation-trees"></a>

You can use the **Terrain Tool** to quickly and easily place any number and combination of mesh objects in your level\.

You use this tool to place vegetation such as trees, shrubs, and grasses around and inside your maze\. 

In the following procedure, you group multiple tree types into a group or category and then paint the trees into your scene\. You also learn how to adjust the tool properties to customize the tree placement\.

**Note**  
Be mindful when placing a large number of mesh objects, as performance can suffer if there is too much vegetation\.

**To paint trees into your scene**

1. In Lumberyard Editor, choose **Tools**, **Terrain Tool**\.

1. In the **Terrain Tool**, choose **Vegetation**\.

1.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-terraintab.png)

1. To paint different types of trees into the scene with one stroke, you must set up a category\.

   To do this, under **Vegetation**, click the **Add Vegetation Category** icon\.

   In the **New Category** box, enter **TreeNear\-Aspen\-Oak**\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-add.png)

1. Click to select the object category that you just created\. Then click the **Add Vegetation Object** ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/add-vegetation-object.png) icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-category.png)

1. In the **Pick Geometry** dialog box, navigate to `StarterGame\Objects\Natural\Vegetation`\.

   Select `am_aspen_01_group.cgf`\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-geometry.png)

1. To add another tree type to this category, click **Add Vegetation Object** ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/add-vegetation-object.png) again\.

   Select `am_oak_group.cgf`\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-oak.png)

1. To paint with all the objects within the category, select the category name \(which is selected by default at this point\)\. You can also choose to paint with specific objects within the category\.

   Set the **Brush Radius** to **5**\.

   Choose **Paint Objects**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-radius.png)

1. In the viewport, drag to place a small grove of trees\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-radius.png)

   With the current settings, notice that the trees are distributed too densely and have little variation between them\.

1. To erase the trees that you just placed, hold down **Ctrl** while dragging over the trees\. Continue until you remove all the trees\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-erase.png)

1. To change the settings for the placement of the trees, select the group **TreeNear\-Aspen\-Oak**\.

   In the properties settings that appear below the group, set the following properties\. Leave all other properties at their default settings\.
   + **Size**: **1\.25**

     Sets the base size for the objects that you place\.
   + **\+\-SizeVar**: **0\.2**

     Varies the size of each object \(larger or smaller\) by up to this amount\.
   + **RandomRotation**: **Selected**

     Rotates the objects in random directions\.
   + **Bending**: **2**

     Sets degree to which wind can affect the object\.
   + **Density**: **20**

     Defines the maximum distance between objects\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-properties.png)

1. Set the **Brush Radius** to **10**\.

   Drag in the viewport to paint the trees into the scene\.
**Note**  
The **Brush Radius** setting cannot be less than half of the **Density** setting\. For example, if you attempt to paint with a brush radius of **9**, nothing happens\. With a **Density** setting of **20**, your **Brush Radius** must be **10** or larger\.

   It can be easy to go overboard and paint an overly dense set of trees\. Try to achieve a density similar to the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-final.png)

1. Press **Ctrl\+S** to save your level\.

1. Press **Ctrl\+G** to play your level\.

[Next: Adding Shrubs and Grass](vegetation-grass.md)