# Creating the Trigger Volume<a name="scripting-entry-door-trigger"></a>

A trigger area is an invisible cube that you can set to trigger an action when a gameplay character enters and exits an area\. You create a box\-shaped trigger area and then move it to just outside of the maze door\.

**To create a trigger area**

1. In the **Entity Outliner**, right\-click the **EntryDoor\_Parent** entity, and then select **Create child entity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-trigger-child.png)

1. In the **Entity Inspector**, rename this new entity **EntryDoor\_Trigger**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-trigger-rename.png)

1. Ensure that the **EntryDoor\_Trigger** is selected in the **Entity Outliner**\. In the **Entity Inspector**, click **Add Component**\. Under **Scripting**, select **Trigger Area**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-trigger-triggerarea.png)

1. When adding any component that requires another component to function properly, the **Entity Inspector** displays a message: "This component is missing a required component service and has been disabled\." To properly use the **Trigger Area** component, you must also add a shape component\. 

   Click **Add Required Component**, and then click **Box Shape**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-trigger-required.png)

1. Set the box shape's **Dimensions** to **X**: **4\.00** m, **Y**: **4\.00** m, **Z**: **5\.00** m\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-trigger-dimensions.png)

1. Use the **Move** tool to adjust the position of the box\-shaped trigger area so that it is just outside of the door\. Align its edge with the inside edge of the door\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-align.png)

   When the player walks toward the door and into the trigger area, the entry trigger action occurs—in this case, the door opens\. The player then walks through the door, exiting the trigger volume, causing the exit trigger action—the door closes\. This trigger area currently has no triggers set up; you do this in the next section\.

Next: [Adding Entry and Exit Scripts](scripting-entry-door-scripts.md)