# Drawing a Road<a name="vegetation-road"></a>

Use the **Road** component to create a worn\-looking footpath that leads to the maze entrance and away from the maze exit\.

In this procedure, you first draw out the meandering line of the road and adjust it to give some variation in the road's height\. You then align the road so that the surrounding landscape slopes up and down to the height variations of the road\. Finally, assign a dirt texture to the road\. 

**To create a path with the Road component**

1. In the viewport, right\-click and choose **Create entity**\.

1. In the **Entity Inspector**, enter a name for the entity such as *Road*\.

1. Choose **Add Component** and choose the **Road** component\. 

1. Under the **Road** component, click **Add Required Component**, and then choose the **Spline** component\.  
**Example**  

   The **Road** entity and its components should look like the following\.  
![\[Entity with a Road and Spline component.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-road-spline-1.png)

1. To extend the length of the road, select and drag the **\[0\]** vertex on the spline towards the entrance of the maze\.

1. Select and drag the **\[3\]** vertex in the opposite direction\.  
**Example**  

   The **Road** entity should look like the following\.  
![\[Select and drag the vertices to create a longer path.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-road-spline-2.png)

1. Add more vertices to the spline so that you can adjust its position and give it a more organic curve\. To add a vertex, select the **Road** entity, press and hold **CTRL**, and then click along the center line of the **Road** component\. Repeat until you have about 10 vertices total\.  
**Example**  

   The **Road** entity should now look like the following\.  
![\[Add more vertices to the Spline component to create a longer path.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-road-spline-3.png)

1. Select and drag the vertices along the ground to form curves, so that the road has a more organic shape along the ground\.   
**Example**  

    The **Road** entity can look like the following\.  
![\[Select and drag the vertices on the Spline component to create elevation for the path.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-road-spline-4.png)

1. Select the **Road** entity, and then select and drag a few of the vertices up or down along the path so they rise just above or below the existing terrain\.   
**Example**  

   Your **Road** entity can look like the following\.  
![\[Road entity with vertices that move up and down.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-road-spline-5.png)

1. In the **Entity Inspector**, for the **Road** component, choose **Align heightmap**\. This automatically adjusts the terrain around path to match its position\. 

   You can add more vertices to the **Spline** component, adjust their position and then choose **Align heightmap** again\.   
**Example**  

   Your **Road** entity should look like the following\.  
![\[Road entity with the vertices aligned to the terrain.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-road-spline-6.png)

1. To change the material for the road, in the **Road** component, for **Road material**, click the \(**…**\) icon\.

1. In the **Pick Material** dialog box, navigate to `StarterGame/Materials/Natural/Road` and select the `am_road_dust_rocks` material file and then choose **OK**\.   
![\[Select a different material file for the component.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-road-spline-7.png)  
**Example**  

   Your path should look like the following\.  
![\[Final path with the new material file applied.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/vegetation-road-spline-8.png)
**Note**  
You can adjust the behavior and appearance of the **Road** component with other properties\. For more information, see the **[Road](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-road.html)** component in the *Amazon Lumberyard User Guide*\.

1. Repeat this procedure to create another path that leads away from the maze's exit\.

1. Press **Ctrl\+S** to save your level\.

[Next: Placing Trees](vegetation-trees.md)