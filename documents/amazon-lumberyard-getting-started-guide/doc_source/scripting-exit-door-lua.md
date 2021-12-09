# Modifying Conditions to Open Exit Door<a name="scripting-exit-door-lua"></a>

To exit the maze, you'll set up a different trigger condition to open the exit door\. Unlike with the entry door, the door should not open when the player approaches it\. The door should open only after the player has collected the hidden pickup item\.

In this tutorial, you'll remove the trigger volume that opens the door when the player approaches\. You'll also prepare your exit door to open only after the player has collected a hidden pickup within the maze\. You'll configure your pickup item and link it to this door in [Adding a Pickup Item](scripting-pickup.md)\.

**To modify the exit door**

1. In the **Entity Outliner**, expand the **ExitDoor\_Parent** group\.

   Select the **EntryDoor\_Trigger** entity and, in the **Entity Inspector**, rename it to **ExitDoor\_Script**\.

1. In the **Entity Outliner**, select **ExitDoor\_Script**\.

   Delete the following components\. To do this, right\-click the component header and click **Remove component**\.
   + **Trigger Area**
   + **Box Shape**
   + **Lua Script** \(the one with the **Script** set as `TriggerEvent`\)

1. Because you copied the entry door, all the script names in the **Entity Inspector** refer to the entry door\. You edit the script names to refer to the exit door\.

   In the **Entity Inspector**, change all the **EventName** settings to reflect "exit" door rather than "entry" door\. Your finished modifications should look similar to the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-final.png)

[Next: Creating a New Trigger Area](scripting-exit-door-adjust.md)