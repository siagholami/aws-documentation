# Adding Patrol Waypoints<a name="ai-patrol-waypoints"></a>

A spawned AI character needs a defined path to walk along as it patrols the maze\. To define the path, you place waypoints\. 

**To add AI waypoints**

1. In the viewport, in the center of the maze near the spawn point entity that you created earlier, right\-click and choose **Create Entity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-patrol-waypoints-create.png)

1. In the **Entity Inspector**, name the entity **Waypoint01**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-patrol-waypoints-name.png)

1. A short distance down the walkway from where you created your first waypoint, create another entity\. Name it **Waypoint02**\.

1. Create a third waypoint a short distance down a path perpendicular to the first two waypoints, so that the path between the three points forms an L shape\. Name the waypoint **Waypoint03**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-patrol-waypoints-lshape.png)

1. In the **Entity Outliner**, select the **AiSpawnpoint01** entity you created earlier\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-patrol-waypoints-spawnpoint.png)

1. In the **Entity Inspector**, click **Add Component**\. Under **AI**, click **Waypoints**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-patrol-waypoints-waypoint.png)

1. In the **Waypoints** properties, the **Sentry?** and **Lazy Sentry?** check boxes should be unselected\. This allows the AI to patrol between waypoints\.

   The **Sentry?** property, when selected, causes the AI to stand in a fixed position, periodically turning to face different directions\.

   The **Lazy Sentry?** property, when selected, causes the AI to look only in the direction it faced when it was spawned\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-patrol-waypoints-sentry.png)

1. In the **Waypoints** properties, add four **Waypoints** elements by clicking **\+** four times\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-patrol-waypoints-elements.png)

1. Use the pick icon ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/picker.png) to select a waypoint for each of your waypoint elements\.

   To do this, click the pick icon and then select the waypoint element in the viewport\.

   Select the waypoints for the elements in the following order: **Waypoint01**, **Waypoint02**, **Waypoint03**, **Waypoint02**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-patrol-waypoints-sequence.png)

   This sequence causes the AI to walk from **Waypoint01** to **Waypoint02** to **Waypoint03**, and then back to **Waypoint02**\. In the next sequence, it begins at **Waypoint01**\.
**Note**  
Not setting waypoints causes the enemy to operate in sentry mode\. This means that he stands at his spawn point and turn occasionally\.  
When an AI spawns, it faces the in **X** direction \(as opposed to the Y or Z direction\)\.

1. Press **Ctrl\+S** to save your level\.

[Next: Adding a Second AI Character](ai-second-ai.md)