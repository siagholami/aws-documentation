# Adding a Second AI Character<a name="ai-second-ai"></a>

With the same procedures you used to place the first AI character, you can place a second enemy AI that takes a slightly different path as it patrols the maze\.

**To add a second AI character**

1. In the **Entity Outliner**, select and right\-click **AiSpawnpoint01**\. Choose **Duplicate**\. Name the duplicated spawn point **Spawnpoint02**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-second-ai-duplicate.png)

1. In the viewport, move the new spawn point to a location near the L shape of your waypoints, as shown in the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-second-ai-spawn.png)

1. Create three new entities to use as waypoints\. Name them **Waypoint04**, **Waypoint05**, and **Waypoint06**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-second-ai-waypoint.png)

1. In the **Entity Outliner**, select **Spawnpoint02**\. 

   In the **Entity Inspector**, in the **Waypoints** component, clear all the existing waypoints by clicking the square icon next to the **Waypoints** setting\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-second-ai-clear.png)

1. Next to **Waypoints**, click the **\+** icon\. Add the following waypoints in this sequence:
   + **Waypoint04**
   + **Waypoint05**
   + **Waypoint06**
   + **Waypoint05**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-second-ai-newpoints.png)

1. Press **Ctrl\+S** to save your level\.

[Next: Organizing Your AI Entities](ai-organize.md)