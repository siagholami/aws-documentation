# Painting Pavement, Grass, Dirt, and Rocks<a name="vegetation-paint"></a>

You now use the terrain texture layers that you created to paint those assigned materials onto your terrain\. To do this, use the **Layer Painter** in the **Terrain Tool**\. After setting a color for a texture, you use that texture to paint your terrain\.

**To paint your terrain**

1. In the Lumberyard Editor main menu, choose **Tools**, **Terrain Tool**\.

1. In the **Terrain Tool**, choose **Layer Painter**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-paint-terrain-tool.png)

1. At the bottom of the panel is the list of the terrain texture layers that you created\. The texture layers contain the texture and the material of the paint, but not the color\.

   To define the color, click **Grass** \(1\), and then click in the colored part of the **Color** box \(2\)\. Select one of the green colors \(3\), and then click **OK**\.

   Click **Save Layer** \(4\) to save this color to the **Grass** layer\.

   Click **Flood** \(5\) to paint the entire landscape with the grass color and texture\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-paint-grassflood.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-paint-flood.png)

1. Now you can paint inside the maze pathways with a hexagon patterned pavement\.

   Select the **HexGround** layer\. Click in the colored part of the **Color** box\. In the **Select Color** dialog box, set the color to the following values and then click **OK**:
   + **Red**: **75**
   + **Green**: **79**
   + **Blue**: **58**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-paint-color.png)

1. To save the color to the layer, click **Save Layer**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-paint-savecolor.png)

1. In the **Layer Painter** tool's **Brush Settings**, set the **Radius** to **2\.50** and the **Detail Intensity** to **0\.50**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-paint-settings.png)

   Modify the brush radius \(size\) to suit the level of detail you want\.

   The detail intensity settings control the brush edge's softness\. A value of **0\.1** create a soft edge, while a value of **1** creates a hard, solid edge\.

1. In the viewport, inside the maze, drag to paint the **HexGround** texture into the maze\. Leave a bit of grass showing around the inside edges\.

    Your maze should look similar to the following image\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-paint-grass.png)

1. Now you set the colors for the other texture layers\.

   For the **Dirt** layer, do the following:
   + Set the color to **Red**: **140**, **Green**: **113**, and **Blue**: **87**\. 
   + Click **Save Layer** to save the color settings\.

   For the **Rocks** layer, do the following:
   + Set the color to **Red**: **126**, **Green**: **115**, and **Blue**: **102**\.
   + Click **Save Layer** to save the color settings\.

1. Paint the maze pathways with the dirt and rock layers, adjusting the radius and detail intensity as necessary\.

   When finished, your maze should look similar to the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-paint-final.png)

1. Press **Ctrl\+S** to save your level\.

[Next: Drawing a Road](vegetation-road.md)