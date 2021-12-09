# Adding Open and Close Scripts<a name="scripting-entry-door-scripts"></a>

You need to add three Lua scripts to the trigger entity that you created\. To do this, you add the **Lua Script** component three times and then select the script for each component\.

The first script that you add \(`TriggerEvent.lua`\) tells the trigger area what events to execute when a player enters and exits the area\.

The second and third scripts that you add \(`MoveObject.lua`\) define those events specified in the first script, and link them to a script that moves the door\. The `OpenExitDoor` script moves the Z position of the door so that it disappears up into the structure\. The `CloseExitDoor` script moves the Z position back to its original, closed position\.

**To add Lua scripts to your trigger entity**

1. In the **Entity Outliner**, select the **EntryDoor\_Trigger** entity\.

1. In the **Entity Inspector**, click **Add Component**\. Under **Scripting**, select **Lua Script**\.

   Repeat this two more times so that the **EntryDoor\_Trigger** has a total of three **Lua Script** components\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-scripts-lua.png)

1. In the first **Lua Script** component, next to the **Script** box, click **Browse** \(**\.\.\.**\)\.

   Navigate to `StarterGame\Scripts\Triggers`\. Select `TriggerEvent.lua`\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-scripts-script.png)

   A list of options appears below the **Properties** heading in the **Lua Script** component\.

   For now, you'll configure the **EventNameExit** and **EventName** properties with names that you'll later define with the `MoveObject.lua` script\. These can be any name you like; they just have to match the event names you configure in a later step\.

1. Set the following options:
   + **EventName** – Type **OpenEntryDoor**
   + **EventNameExit** – Type **CloseEntryDoor**
   + **TriggerOnExit** – Selected
   + **TriggerOnEnter** – Selected
   + **TriggerOncePerEntity** – Unselected

   These settings configure the named events to be triggered upon entry and exit\. 

   The **TriggerOncePerEntity**, when selected, sets that trigger volume to trigger just once by that entity, in this case the player character\. Some game events may require this based on design\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-scripts-settings.png)

1. Next, you'll add the script that moves the door into its open position\.

   In the second **Lua Script** component, click **Browse** \(**\.\.\.**\)\. Navigate to `StarterGame\Scripts\General`\. Select `MoveObject.lua`\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-scripts-moveobject.png)

   A list of options appears below the **Properties** heading in the **Lua Script** component\.

1. As stated previously, the **EventName** can be any name you like, though it must match the **EventName** in the `TriggerEvent.lua` property\.

   Set the following options:
   + **EventName** – Type **OpenEntryDoor**
   + **PositionOffset** – Change **Z** to **3\.00**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-scripts-moveobject-props.png)

   When the **OpenEntryDoor** event is triggered, this script moves the **Target**, which you define as the door in the next tutorial\. The target is moved to an open position, which is determined by the relative offset that is specified by the **PositionOffset** values\.

1. In the third **Lua Script** component, add the same `MoveObject.lua` script as you did for the previous **Lua Script** component\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-scripts-moveobject.png)

   A list of options appears below the **Properties** heading in the **Lua Script** component\.

1. Set the following options:
   + **EventName** – Type **CloseEntryDoor**
   + **PositionOffset** – Set **X**, **Y**, and **Z** to **0\.00**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-scripts-moveobject-props-2.png)

   This script moves the **Target** back to its original, closed position when the **CloseEntryDoor** event is triggered\.

Next: [Defining the Door as the Target](scripting-entry-door-connect.md)