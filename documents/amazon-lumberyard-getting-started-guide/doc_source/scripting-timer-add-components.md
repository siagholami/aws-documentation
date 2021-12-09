# Adding Components to TimerStart<a name="scripting-timer-add-components"></a>

You add the following three components to **TimerStart** and configure them:
+ **Box Shape** – Gives the trigger area its shape and volume
+ **Trigger Area** – Works in tandem with the box shape to create a trigger
+ **UI Canvas Asset Ref** – Associates a prebuilt UI canvas with the **TimerStart** entity to display the timer

**To add and configure the box shape component**

1. In the **Entity Outliner**, select the **TimerStart** entity\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-components-timerstart.png)

1. In the **Entity Inspector**, click **Add Component**\.

   Select the **Box Shape** component\.

1. In the **Box Shape** component properties, set the **Dimensions** as follows:
   + **X** : **1\.00**
   + **Y** : **5\.00**
   + **Z** : **5\.00**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-components-box.png)

**To add and configure the trigger area component**

1. In the **Entity Outliner**, select the **TimerStart** entity\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-components-timerstart.png)

1. In the **Entity Inspector**, click **Add Component**\.

   Select the **Trigger Area** component\.

**To add and configure the UI canvas asset ref component**

1. In the **Entity Outliner**, select the **TimerStart** entity\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-components-timerstart.png)

1. In the **Entity Inspector**, click **Add Component**\.

   Select the **UI Canvas Asset Ref** component\.

1. In the **UI Canvas Asset Ref** properties, click **Browse** \(**\.\.\.**\) and navigate to `StarterGame\UI\Canvases\`\.

   Select `gsg_maze_timer.uicanvas`\. Click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-timer-add-components-uicanvas.png)

Next, you add three **Lua Script** components to the same entity, **TimerStart**\.

[Next: Adding Lua Script Components](scripting-timer-add-lua.md)