# Adding Lua Script Components<a name="scripting-timer-add-lua"></a>

You add three more components, all **Lua Script** components, to the **TimerStart** entity\. You then add the following scripts and make the following changes:
+ Lua Script component \#1:
  + **Script** – `Timer.lua`
  + **TimerElementName** – **Timer**
+ Lua Script component \#2:
  + **Script** – `TriggerEvent.lua`
  + **EventName** – **TimerStart**
+ Lua Script component \#3:
  + **Script** – `TriggerEvent.lua`
  + **EventName** – **TimerStop**

You then use the **Move** tool to adjust the **TimerStart** entity's position in the viewport so that it is just inside the maze entrance\.

**To add and configure Lua Script components**

1. In the **Entity Outliner**, select the **TimerStart** entity\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-components-timerstart.png)

1. In the **Entity Inspector**, click **Add Component**\.

   Select **Lua Script**\.

   Repeat twice more so that you have a total of three **Lua Script** components on the **TimerStart** entity\.

1. On the first **Lua Script** component, do the following:
   + Click **Browse** \(**\.\.\.**\) next to the **Script** box\. Navigate to `StarterGame\Scripts\General` and select `Timer.lua`\.
   + In the **TimerElementName** property, enter **Timer**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-lua-lua1.png)

1. On the second **Lua Script** component:
   + Click **Browse** \(**\.\.\.**\) next to the **Script** box\. Navigate to `StarterGame\Scripts\Triggers` and select `TriggerEvent.lua`\.
   + In the **EventName** property, enter **TimerStart**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-lua-lua2.png)

1. On the third **Lua Script** component:
   + Click **Browse** \(**\.\.\.**\) next to the **Script** box\. Navigate to `StarterGame\Scripts\Triggers` and select `TriggerEvent.lua`\.
   + In the **EventName** property, enter **TimerStop**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-lua-lua3.png)

1. In the viewport, use the **Move** tool to adjust the position of the **TimerStart** entity so that it is just inside the maze entrance\. That way, the timer starts when the player enters the maze\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-lua-move.png)

1. Press **Ctrl\+S** to save your level\.

Next, you add and configure a similar set of entities and components at the maze's exit to trigger the timer to stop\.

[Next: Adding and Configuring the Timer's Stop Trigger](scripting-timer-add-stop.md)