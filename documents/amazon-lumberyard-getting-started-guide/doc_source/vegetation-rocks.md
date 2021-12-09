# Inserting Rocks and Undergrowth<a name="vegetation-rocks"></a>

You can also use the **Vegetation** tool to place individual objects\. This is useful when placing large objects such as boulders, tree stumps, or logs\.

To better focus on a particular vegetation category, you can temporarily hide groups of vegetation objects\. You can also fine\-tune the placement of individual objects within a group\.

**To insert rocks into your landscape**

1. In Lumberyard Editor, choose **Tools**, **Terrain Tool**\.

1. In the **Terrain Tool**, choose **Vegetation**\.

1.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-terraintab.png)

1. Create a new category and name it **Rocks**\.

   To do this, under **Vegetation**, click the **Add Vegetation Category** icon\.

   In the **New Category** box, enter **Rocks**\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-rocks-add.png)

1. Select the **Rocks** object category that you just created, and then click the **Add Vegetation Object** ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/add-vegetation-object.png) icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-rocks-category.png)

1. In the **Pick Geometry** dialog box, navigate to `StarterGame\Objects\Natural\Rocks`\. Hold down **Ctrl** while selecting the following files:
   + `am_rocks_small_01.cgf`
   + `am_rocks_small_02.cgf`
   + `am_rocks_boulder_01.cgf`  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-rocks-select.png)

1. Select only **am\_rocks\_boulder\_01** and modify the following settings, or experiment with your own\.
   + **Size**: **1\.50**
   + **\+\-Sizevar**: **0\.20**
   + **RandomRotation**: **Selected**

1. Click **Paint Objects** to disable it\. The setting is disabled \(1\) when it has no orange border\. An orange border \(2\) indicates that the feature is enabled\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-rocks-unselected.png)

   Hold down **Shift** and click once in the viewport\. This places a single boulder\.

   You can place single objects using any object in the vegetation categories\. This is useful for placing objects with precision\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-rocks-boulder.png)

You can move individual objects that you previously placed\. Because the scene is full of vegetation, it can be difficult to select one particular object\. In the vegetation categories and objects lists, you can hide and unhide groups or individual objects\.

**To select individual objects**

1. To hide the **Grass** and **Rocks** categories, clear their check boxes in the **Vegetation** tool\. This hides all of the grass and rocks in your scene\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-rocks-hide.png)

1. In the **TreeNear\-Aspen\-Oak** category, hide the **am\_oak\_group**\.

   With all categories hidden except **am\_aspen\_01\_group**, your level should look similar to the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-rocks-hidden.png)

1. Make sure **Paint Objects** is still disabled and then click to select one of the trees in the scene\.

   Press **2** on your keyboard to select the Move tool\. Move the tree to different location\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-rocks-move.png)

1. Press **Ctrl\+S** to save your level\.

Using the techniques you learned in this section, use the **Grass** category to add some undergrowth to the maze pathway\. You can do this by setting your **Density** setting to **1** and your **Brush Radius** to **2**, and then painting\. Or you can disable the **Paint Objects** button and then hold down **Shift** to place individual plants\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-rocks-undergrowth.png)

You should now have a lush vegetative environment in your level\. 

\(Optional\) You can move on to the next tutorial, which shows you how to add more details to your landscape\. Or you can proceed to the [Lighting](lighting.md) tutorials\. 

Press **Ctrl\+S** to save your level, and then **Ctrl\+G** to play your level\. Press **Esc** to quit\.

[Next: Customizing Your Landscape \(Optional\)](vegetation-landscape.md)