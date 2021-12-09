# Setting up the AI Trigger Area<a name="ai-trigger-area"></a>

**To set up the AI trigger area**

1. In the **Asset Browser**, navigate to `\StarterGame\Slices`\. Drag `Debug_manager.slice` into the viewport\.

   This slice manages some of the AI script's functional behavior\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-debug.png)

1. In the viewport, right\-click the center of the maze and choose **Create entity**\.

   This action creates an empty entity\. In the **Entity Inspector**, name this entity **AiTrigger**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-create.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-name.png)

1. In the **Entity Inspector**, click **Add Component**\. Under the **Shape** category, choose the **Box Shape** component\.
**Tip**  
To find the **Box Shape** component quickly, enter **box** in the **Search** bar\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-box.png)

1. In the **Entity Inspector**, in the **Box Shape** component, set the box's **Dimensions** to **X**: **38**, **Y**: **38**, **Z**: **10**\.

   The AI is restricted to these dimensions, which approximate the size of the maze\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-dimensions.png)

1. Use the Move tool to center the box so that it fits around the maze wall\.
**Tip**  
If the box does not appear in the viewport, click the **?** icon in the upper\-right corner of your viewport\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-triggerarea.png)

1. With the **AiTrigger** entity still selected, in the **Entity Inspector**, click **Add Component**\. Under **Scripting**, choose **Trigger Area**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-trigger-area.png)

1. In the **Trigger Area** component, under **Tag Filters**, click **\+** next to **Required tags**\.

   In the box labeled **\[0\]**, enter **PlayerCharacter**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-tag.png)

1. In the **Entity Inspector**, click **Add Component**\. Under **Scripting**, click **Lua Script**\.

1. In the **Lua Script** component, next to the **Script** box, click \(**\.\.\.**\) to browse for a script file\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-script.png)

   Navigate to `\StarterGame\Scipts\AI`\. Select **AISpawnTrigger\.lua**\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-aispawntrigger.png)

1. In the **Lua Script** component, under **Properties**, in the **AiSpawnGroup** box, enter **Group0**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-aispawngroup.png)

   When the player enters the trigger area defined by this entity's shape, the AI scripts in the group are activated\. When the player leaves the trigger area, the AI scripts are deactivated\.

   Your **Entity Inspector** should look like the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/ai-trigger-area-done.png)

1. Press **Ctrl\+S** to save your level\.

**Note**  
During gameplay, the player controller must start outside the maze trigger area and then enter it in order to activate the AI characters\. If the game starts inside the trigger area, the player controller must leave and then reenter to trigger the AI\.

[Next: Defining the AI Navigation Area](ai-navigation-area.md)