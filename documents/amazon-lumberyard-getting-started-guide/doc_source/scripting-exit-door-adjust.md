# Creating a New Trigger Area<a name="scripting-exit-door-adjust"></a>

In the previous tutorial, you removed your exit door's ability to open upon approach\. However, you still want the exit door to close behind the player after exiting\.

To do this, you'll create a new entity to act as the trigger area and place the trigger area on the outside edge of the maze exit door so that it triggers to close after the player exits\.

**To create a new trigger area for the exit door**

1. In the viewport, just outside of the exit door, create a new entity\. To do this, right\-click and choose **Create Entity**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-create.png)

   In the **Entity Inspector**, name it **ExitDoorTrigger**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-exittrigger.png)

1. In **Entity Outliner**, drag **ExitDoorTrigger** into **ExitDoor\_Parent**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-parented.png)

1. Make sure **ExitDoorTrigger** is still selected in **Entity Outliner**\.

   In the **Entity Inspector**, add the following components:
   + **Box Shape**
   + **Trigger Area**
   + **Lua Script**

1. Modify the values of the **Box Shape** component's dimensions to **X**: **4\.00**, **Y**: **8\.00**, **Z**: **5\.00**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-dimensions.png)

1. Use the **Move** tool to position the trigger area so that it is approximately two units outside of the door's exit side\. Your trigger area should look similar to the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-position.png)

1. In the **Entity Inspector**, in the **Lua Script** component, next to **Script**, click the browse \('**…**'\) button\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-browse.png)

   Navigate to `Scripts\Triggers`\. Select `TriggerEvent.lua`\. Click **OK**\.

1. In the **EventName** box, enter **CloseExitDoor**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-closeexitdoor.png)

1. Under **Recipients**, next to **Entity**, click the picker icon ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/picker.png)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-recipient.png)

    In the **Entity Outliner**, select **ExitDoor\_Script**\. This places **ExitDoor\_Script** in the **Entity** box\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-pickers.png)

   This points the new trigger area that you created back to the script that opens or closes the door\.

1. Press **Ctrl\+S** to save your level\.

[Next: Adding a Pickup Item](scripting-pickup.md)