# Defining the AI Navigation Area<a name="ai-navigation-area"></a>

The AI navigation area is the traversable area for the AI characters\. AI characters use this area to find their way through the play space\.

In this tutorial, create and set up the AI navigation area with the **Navigation Area** component\. 

**To define the AI navigation area**

1. In the viewport, right\-click and choose **Create entity**\.

1. In the **Entity Inspector**, enter a name for the entity such as *AiNavigation*\.

1. Choose **Add Component** and add the **Navigation Area** component\. 

1. Under the **Navigation Area** component, click **Add Required Component**\. This adds the **Polygon Prism Shape** component to the entity\.

1. Select the entity in the viewport\.   
**Example**  

   Your entity and its components should look like the following\.  
![\[Example navigation area entity with its components.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-1.png)

1. In the **Entity Inspector**, for the **Navigation Area** component, click the **\+** icon for the **Agent Types** property and then in the drop\-down menu, select **MediumSizedCharacters**\.  
![\[Navigation Area component property.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-2.png)

1. In the **Polygon Prism Shape** component, for **Height**, enter `3.0` meters\.  
![\[Polygon Component Shape component property.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-3.png)

1. In the Lumberyard Editor main menu, choose **Game**, **AI**, **View Agent Type**, **MediumSizedCharacters**\. 

   **MediumSizedCharacters** should be toggled on and appear with a check mark in the **AI** menu\.

   A blue box appears inside the navigation area volume that you created\. The AI characters use this blue region to define the path data, so that they can navigate through the play space\.
**Note**  
If the blue box doesn't appear, toggle off **Visualize Navigation Accessibility**\. To do this, choose **Game**, **AI**, **Visualize Navigation Accessibility**\.  
If the box still doesn't appear, ensure that **Continuous Update** is on\. To do this, choose, **Game**, **AI**, **Continuous Update**\.  
![\[Polygon Component Shape component property.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-4.png)

1. Select the **AiNavigation** entity and in the toolbar, click the **Align to object** icon![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-5.png) , and then click the **maze\_wall\_exterior** or **maze\_wall\_interior** entity in the center of the maze\.  
![\[maze_wall_interior component property.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-6.png)

1. Select the **AiNavigation** entity again\. You should see four red vertices each numbered `0` to `4`\.  
![\[Polygon Component Shape component property.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-7.png)

1. Select and drag each vertex to create a perimeter around the exterior maze wall\.   
**Example**  

   Your volume should look like the following\.  
![\[Select and drag the navigation area vertices so that they form a perimeter around the maze.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-8.png)

1. If you look at the position of the navigation area, you will notice that the navigation area is not touching the ground\. This also means that path information is not defined\. Select the **AiNavigation** entity and lower it to the ground\.   
**Example**  

   A blue path should appear between the maze walls like the following\.  
![\[Blue path ways appear in the navigation area.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-9.png)
**Note**  
If your navigation area fills the entire space, the AI characters can navigate this space but they will also potentially get stuck against the interior walls\. The AI characters will assume that the areas by the wall are a viable path\.  
**Example**    
![\[Navigation area with the viable paths that include the inner wall maze.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-10.png)

1. To fix this, define the navigation area to go around the inner walls\. In the **Entity Inspector**, select and expand the **maze\_wall\_interior** entity, press **Shift** and then select all the child entities in the slice\.  
![\[Select the child entities of the parent slice.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-11.png)

1. In the **Entity Inspector**, for the **Transform** component, select the **Static** property\. This property tells the navigation AI to exclude these areas as a viable path\.  
![\[Select Static so that the child entities are static.\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-navigation-area-12.png)

1. Press **Ctrl\+S** to save your level\.

[Next: Creating AI Spawn Points](ai-spawn-points.md)