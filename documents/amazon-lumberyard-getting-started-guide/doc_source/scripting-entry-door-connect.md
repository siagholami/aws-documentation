# Defining the Door as the Target<a name="scripting-entry-door-connect"></a>

The Lua scripts that you added in the previous section don't yet have a target to act upon\. You need to specify the door as the target of the script's actions\.

**To define the door as the Lua script target**

1. In the **Entity Outliner**,select **EntryDoor\_Trigger**\.

   In the **Entity Inspector**, in the second Lua Script component—the one with the **EventName** as **OpenEntryDoor**—click the picker icon ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/picker.png) next to the **Target** box\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-connect-picker.png)

1. In the **Entity Outliner**, select **gsg\_maze\_door**\. This fills the **Target** in the **Lua Script** component with the entity that you selected \(**gsg\_maze\_door**\)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-connect-picker-mazedoor.png)

1. Repeat the previous step for the third Lua script—the one with the **EventName** as **CloseEntryDoor**\.

   Your two **Lua Script** components now look like the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-connect-picker-final.png)

1. Press **Ctrl\+S** to save your level\.

1. Press **Ctrl\+G** to play your level\.

   Test your trigger area and triggers by approaching the door\. The door should open when you enter the trigger area and close when you leave it\.

   You may need to fine\-tune the positions to ensure that the door is opening to the position you want\.

   Press **Esc** to quit\.

Next: [Adding Door Sounds](scripting-entry-door-sounds.md)