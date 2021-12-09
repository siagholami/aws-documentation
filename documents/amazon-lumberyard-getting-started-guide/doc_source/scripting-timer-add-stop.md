# Adding and Configuring the Timer's Stop Trigger<a name="scripting-timer-add-stop"></a>

To set up the timer's stop trigger, you do the following:
+ Create a child entity under **TimerParent** and name it **TimerStop**\.
+ To **TimerStop**, add and configure a **Box Shape**, a **Trigger Area**, and a **Lua Script** component\.
+ Adjust the position of the **TimerStop** entity so that it is at the maze's exit\.

**To create the **TimerStop** child entity**

1. In the **Entity Outliner**, right\-click **TimerParent** and select **Create child entity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-stop-createchild.png)

1. In the **Entity Inspector**, rename the new child entity **TimerStop**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-stop-rename.png)

**To add and configure the box shape component**

1. In the **Entity Outliner**, select the **TimerStop** entity\.

1. In the **Entity Inspector**, click **Add Component**\.

   Select the **Box Shape** component\.

1. In the **Box Shape** component properties, set the **Dimensions** as follows:
   + **X**: **1\.00**
   + **Y**: **5\.00**
   + **Z**: **5\.00**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-stop-box.png)

**To add and configure the trigger area component**

1. In the **Entity Outliner**, select the **TimerStop** entity\.

1. In the **Entity Inspector**, click **Add Component**\.

   Select the **Trigger Area** component\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-stop-trigger.png)

**To add and configure the Lua Script components**

1. In the **Entity Outliner**, select the **TimerStop** entity\.

1. In the **Entity Inspector**, click **Add Component**\.

   Select **Lua Script**\.

1. Click **Browse** \(**\.\.\.**\) next to the **Script** box\. Navigate to `StarterGame\Scripts\Triggers` and select `TriggerEvent.lua`\. Click **OK**\.

1. In the **Lua Script** component's **EventName** property, enter **TimerStop**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-stop-eventname.png)

1. Under **Recipients**, next to the **Entity** box, click the picker icon ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/picker.png)\.

   In the **Entity Outliner**, select the **TimerStart** entity\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-stop-eventname-1.png)

**To adjust the position of the timer's stop trigger**

1. In the **Entity Outliner**, select the **TimerStop** entity\.

1. In the viewport, use the **Move** tool to adjust the position of **TimerStop** so that it is at the maze's exit door\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-stop-position.png)

1. Press **Ctrl\+S** to save your level\.

1. Press **Ctrl\+G** to play your level\.

   The timer should start when you enter the level\. Collect the pickup item\. The timer should stop when you exit the level\.

   Press **Esc** to quit\.

[Next: 7: Applying Physics to Stacked Crates](physics.md)