# Adding Door Sounds<a name="scripting-entry-door-sounds"></a>

You add two **Lua Script** components and two audio components to the **EntryDoor\_Trigger** entity to trigger sounds of a door opening and closing\.

**To add the Lua Script component for door sounds**

1.  In the **Entity Outliner**, select **EntryDoor\_Trigger**\. 

   In the **Entity Inspector**, click **Add Component**, and then add the **Lua Script** component\. Repeat this step to add a second **Lua Script** component\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-sounds-addscript.png)

1. In the first **Lua Script** component, click **Browse** \(**\.\.\.**\) next to the **Script** box\.

   Navigate to `StarterGame\Scripts\Triggers` and select `TriggerEventAudioReceiver.lua`\. Click **OK**\.

1.  In the properties that appear, set the following values: 
   + **EventName** – Type **OpenEntryDoor**
   + **Sound** – Type **Play\_AMZ\_sfx\_spfx\_ship\_door\_open**
   + **TriggerOnce** – Clear the check box  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-sounds-open.png)

1. In the second Lua Script component, click **Browse** \(**\.\.\.**\) next to the **Script** box\.

   Navigate to `StarterGame\Scripts\Triggers` and select `TriggerEventAudioReceiver.lua`\. Click **OK**\.

1.  In the properties that appear, set the following values: 
   + **EventName** – Type **CloseEntryDoor**
   + **Sounds** – Type **Play\_AMZ\_sfx\_spfx\_ship\_door\_close**
   + **TriggerOnce** – Clear the check box  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-sounds-close.png)

Now you add two audio components: **Audio Proxy** and **Audio Trigger**\. The **Audio Proxy** component is required on any entity that uses audio\. The **Audio Trigger** component triggers the audio\.

**To add the audio components**

1. In the **Entity Outliner**, select the **EntryDoor\_Trigger** entity\.

1.  In the **Entity Inspector**, click **Add Component**\. Under **Audio**, select **Audio Proxy**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-sounds-audioproxy.png)

1.  Click **Add Component** again\. Under **Audio**, select **Audio Trigger**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-sounds-audiotrigger.png)

   Your two **Lua Script** components and your two audio components should look like the following\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-sounds-final.png)

1. Press **Ctrl\+S** to save your level\.

1. Press **Ctrl\+G** to play your level\. When you approach the door, you should hear the door opening and closing in concert with those actions\.

   Press **Esc** to quit\.

[Next: Adding the Exit Door](scripting-exit-door.md)