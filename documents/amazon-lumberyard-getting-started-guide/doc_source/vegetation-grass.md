# Adding Shrubs and Grass<a name="vegetation-grass"></a>

The grass texture that you added to your terrain provides a good base color and texture but gives little realism\. Painting in shrubs and grasses adds movement, responsiveness, and variation that cannot be achieved with texture alone\.

**To add shrubs and grasses**

1. In Lumberyard Editor, choose **Tools**, **Terrain Tool**\.

1. In the **Terrain Tool**, choose **Vegetation**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-trees-terraintab.png)

1. To paint different types of grasses and shrubs into the scene with one stroke, you must set up a new category\.

   To do this, under **Vegetation**, click the **Add Vegetation Category** icon\.

   In the **New Category** box, enter **Grass**\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-grass-add.png)

1. Select the **Grass** object category that you just created, and then click the **Add Vegetation Object** ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/add-vegetation-object.png) icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-grass-category.png)

1. In the **Pick Geometry** dialog box, navigate to `StarterGame\Objects\Natural\Vegetation`\. Hold down **Ctrl** while selecting the following vegetation objects:
   + `am_grass_01_plain_group.cgf`
   + `am_grass_tuft_04_group.cgf`
   + `am_groundcover_01_group.cgf`
   + `am_river_weed.cgf`  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-grass-select.png)

1. To modify the settings for the placement of the shrubs and grasses, select the group **Grass**\.

   Unlike with trees, you want the player to run through the grass and shrubs without colliding with its geometry\. Select the **AutoMerged** check box\. With this setting enabled, the player can run through the grass and affect its movement\.

   Enabling this setting also makes the **Bending** property ineffective for this group\. Instead, the settings for **Stiffness**, **Damping**, and **Variance** now affect the movement of the objects\. In this tutorial, the default settings are acceptable, so leave them at default\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-grass-automerge.png)

   Just as you did with the trees, modify size, rotation, and density settings using the following values, or experiment with your own settings:
   + **Size**: **1\.25**

     Sets the base size for the objects that you place\.
   + **\+\-SizeVar**: **0\.2**

     Varies the size of each object \(larger or smaller\) by up to this amount\.
   + **RandomRotation**: **Selected**

     Rotates the objects in random directions\.

1. Modify the **Density** setting for each of the different grasses using the following values, or experiment with your own\. To do this, click each of the grasses in the group to set the **Density** settings individually\.
   + **am\_grass\_01\_plain\_group**: **16**
   + **am\_grass\_tuft\_04\_group**: **10**
   + **am\_groundcover\_01\_group**: **12**
   + **am\_river\_weed**: **8**

1. Select the **Grass** category\.

   Set your **Brush Radius** to **8**\.

   Paint shrubs and grasses into your scene\.
**Note**  
It is easy to paint too much grass into a scene, which may cause a lag in performance\. Focus primarily around the area that the player walks through\. The amount of grass should be similar to the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-grass-density.png)

1. To check the frame rate in the current scene, repeatedly click the "i" icon in the upper right corner of the viewport until the FPS message and additional render data appear\. Ideally, the FPS rate should be over 30 frames per second\. If it is below this, you may have too much information in the scene\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-grass-fps.png)

1. For these types of grasses, set the **AlignToTerrainCoefficient** to **1\.0** to make the objects align to the terrain\.

   The **AlignToTerrainCoefficient** controls the alignment of the object with regards to the terrain it is on\. A value of **0** makes the objects ignore the terrain's angle where it is placed\. A value of **1**, however, causes the objects to align themselves to the slope of the terrain\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-grass-coefficient.png)

   For example, the following image shows the **AlignToTerrainCoefficient** set to **0**\. Notice how the grasses point skyward even though they are on a steep slope\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-grass-notaligned.png)

   The following image shows the **AlignToTerrainCoefficient** set to **1**\. Notice how the grasses appear to grow perpendicular to the slope, which appears more natural\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-grass-aligned.png)

[Next: Inserting Rocks and Undergrowth](vegetation-rocks.md)