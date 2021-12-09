# Creating and Simulating a PhysX Ragdoll<a name="animation-editor-creating-and-simulating-physx-ragdoll"></a>

****  
This feature is in [preview](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#preview) release and is subject to change\. 

A ragdoll is a physical representation of a character in the animation system that you can use to simulate behavior, such as hit reactions and character death\. The physical representation consists of a hierarchy of rigid bodies with simple shapes that are connected by joints\. The animation system and the PhysX system work together to simulate the realistic behaviors\. While the ragdoll setup occurs in the animation system, the PhysX system is responsible for how a character moves based on environmental interactions and external forces\. For example, you can set up your ragdoll so that the character will rotate as it collapses when you apply force to the character's outer shoulder area\.

To use the **[PhysX Ragdoll](component-physx-ragdoll.md)**, add it to an entity in Lumberyard Editor\. You can then follow the procedures below to create and control the physical representation of the ragdoll\.

**Important**  
You can enable the ragdoll to interact physically with the terrain\. To do so, add a **[PhysX Terrain](component-physx-terrain.md)** component to an entity in the level\.
The **PhysX Character Controller** component currently doesn't support the **PhysX Ragdoll** component\.

This topic will teach you how to do the following:
+ [Set up a ragdoll\.](#animation-editor-setting-up-a-ragdoll)
+ [Add the ragdoll to an animation graph\.](#setting-up-a-ragdoll-creating-an-animation-graph)
+ [Simulate a ragdoll in Lumberyard Editor\.](#setting-up-a-ragdoll-simulating-the-ragdoll-in-game-mode)

## Setting Up a Ragdoll<a name="animation-editor-setting-up-a-ragdoll"></a>

When you set up a ragdoll, you do the following:
+ [Define joints for the ragdoll\.](#setting-up-a-ragdoll-selecting-joints)
+ [Add ragdoll colliders\.](#setting-up-a-ragdoll-adding-a-collider)
+ [Create joint limits\.](#setting-up-a-ragdoll-creating-a-joint-limit)

In addition, your actor must have a motion extraction node that is a root node\. Your ragdoll must have a root node that is a direct parent of the motion extraction node\. For example, the Rin character uses `root` for its motion extraction node\. For the ragdoll root node, the Rin character uses `'C_pelvis_JNT`, which is a child node of `root`\.

### Step 1: Define Joints for the Ragdoll<a name="setting-up-a-ragdoll-selecting-joints"></a>

Do the following to select the joints for your ragdoll\.

**To select joints for the ragdoll**

1. In Lumberyard Editor, choose **Tools**, **Animation Editor**\.

1. In the **Animation Editor**, on the right side of the menu bar, choose **Physics** from the drop\-down list\. This changes the layout\.

1. Choose **File**, **Open Actor** and select your actor\.

1. In the **Skeleton Outliner**, multi\-select the joints that you want to include in your ragdoll\.

1. Right\-click one of the selected joints and then choose **Ragdoll**, **Add to ragdoll**\.
**Note**  
You can add joints to the ragdoll at any time\.  
![\[Add a selected joint to the ragdoll in the Skeleton Outliner in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-skeleton-outliner-add-to-ragdoll.png)

1. Click the filter icon next to the search text box, and select **Ragdoll joints and colliders**\. This shows only the joints in the ragdoll and not the full animation skeleton\.  
![\[Use the Ragdoll joints and colliders filter to show only joints in the ragdoll in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-skeleton-outliner-ragdoll-joints-colliders-filter.png)

   The **Skeleton Outliner** displays icons to indicate that:
   + A joint is part of the ragdoll
   + A joint holds ragdoll colliders
   + A joint holds hit detection colliders  
![\[Icons in the Skeleton Outliner show how joints are related to the ragdoll, ragdoll colliders, and hit detection colliders\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-skeleton-outliner-joint-icons.png)

1. In the **OpenGL Render window**, use the render options to show or hide the ragdoll colliders \(rendered in orange\), ragdoll joint limits, and the hit detection colliders \(rendered in blue\)\.
**Note**  
If your ragdoll colliders and hit detection colliders are the same size, you may need to hide the colliders that you are not working on\.  
![\[Use the render options in the OpenGL Render window to show or hide ragdoll colliders and joint limits and hit detection colliders\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-skeleton-opengl-render-window-render-options.png)

1. On the **Ragdoll** tab, you can view and modify the ragdoll properties for the selected joint\. For example, the rigid body mass, sleeping threshold, and colliders\.  
![\[View and modify ragdoll properties for a selected joint on the Ragdoll tab in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-skeleton-ragdoll-tab-properties.png)

### Step 2: Add Ragdoll Colliders<a name="setting-up-a-ragdoll-adding-a-collider"></a>

The ragdoll automatically suppresses collisions between joints that are adjacent in the skeleton\. This means that adjacent colliders can overlap, but a pair of colliders that are not adjacent should not intersect\. If the pair of colliders intersects, they'll collide when the ragdoll is simulated\.

In the following example, the collider for the second spine joint \(highlighted\) can intersect with the first or third spine joint\. The first and third spine joints, however, should not intersect\.

![\[Example that shows how the collider for the second spine joint intersects with the first or third spine joint\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-collider-spine-joints-example.png)

**To add a ragdoll collider**

1. In the **Animation Editor**, on the **Ragdoll** tab, click **Add ragdoll collider** and then choose **Add box**, **Add capsule**, or **Add sphere**\.  
![\[Add a ragdoll collider shape (box, capsule, or sphere) on the Ragdoll tab in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/add-ragdoll-collider-options.png)

1. On the **Ragdoll** tab, do the following in the collider properties:

   1. Set the **Offset** and **Rotation** to move the collider to the correct location\. The **Offset** and **Rotation** are relative to the joint transform\.

   1. Adjust the collider dimensions \(for example, set the **Height** and **Radius** for a **Capsule**\) to resize the collider\.  
![\[Set the Offset, Rotation, Height, and Radius properties for the collider on the Ragdoll tab in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-collider-options-offset-rotation-height-radius.png)

1. Choose **File**, **Save Selected Actors**\. This saves the ragdoll data to the `.assetinfo` file for the character\. The Asset Processor then bakes the ragdoll data into the `.actor` file\.

### Step 3: Create a Joint Limit<a name="setting-up-a-ragdoll-creating-a-joint-limit"></a>

Joint limits are enabled for every joint in your ragdoll\. This allows you to edit the joints and ensure they're set up correctly\.

The following image shows joint limits that are set up correctly\.

![\[Example that shows joint limits that are set up correctly\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-collider-joint-limits-example.png)

**To create a joint limit**

1. In the **Animation Editor**, in the **OpenGL Render Window**, adjust the child local rotation so that the red axis points along the bone\.

1. Adjust the parent local rotation so that the red axis appears inside the swing cone\.

1. Adjust the twist limit value so that the line appears inside the wedge\.  
![\[Example that shows the line for the twist limit value in the wedge\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-joint-limit-twist-limit-value.png)

## Adding Your Ragdoll to an Animation Graph<a name="setting-up-a-ragdoll-creating-an-animation-graph"></a>

When you create an animation graph to control the ragdoll simulation of your character, you do the following:
+ Prepare the actor asset\.
+ Adjust the animation graph to enable the ragdoll\.
+ Preview 

The animation graph controls the ragdoll simulation of your character\. When your character transitions into a blend tree that has a ragdoll node, the ragdoll automatically activates and simulates in game mode in Lumberyard Editor\. When your character transitions out of that state, the ragdoll deactivates\. The ragdoll node outputs a bind pose in the Animation Editor\.

**To create an animation graph to transition from running state to ragdoll state**

1. In the **Animation Editor**, on the right side of the menu bar, choose **AnimGraph** from the drop\-down list\. This changes the layout\.  
![\[Change the Animation Editor layout by choosing AnimGraph from the drop-down list\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-animation-editor-layout-option-animgraph.png)

1. In the **Anim Graph** pane, click the **\+** icon to create a new animation graph\.

1. Right\-click the grid and then choose **Create Node**, **Sources**, **Motion**\. Alternatively, in the **Anim Graph Palette**, on the **Sources** tab, drag **Motion** into the animation graph\.  
![\[Add a Motion node to the animation graph from the context menu or the Anim Graph Palette in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-anim-graph-context-menu-motion-node.png)

1. Select the **Motion** node in the animation graph\.

1. In the **Attributes** pane, do the following:

   1. For **Name**, enter a name for your motion\. For example, **Run**\.

   1. Click **Select motions**\. In the **Motion Selection** window, select a motion and then click **OK**\.

1. Right\-click the grid and then choose **Create Node**, **Sources**, **Blend Tree**\. Alternatively, in the **Anim Graph Palette**, on the **Sources** tab, drag **Blend Tree** into the animation graph\.  
![\[Add a Blend Tree node to the animation graph from the context menu or the Anim Graph Palette in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-anim-graph-palette-blend-tree.png)

1. Select the **Blend Tree** node in the animation graph\.

1. In the **Attributes** pane, enter a name for your blend tree\. For example, **Ragdoll**\.

1. In the animation graph, connect the **Motion** node to the **Blend Tree** node\. For example, connect the **Run** node to the **Ragdoll** node\.  
![\[Connect the Motion node to the Blend Tree node in the animation graph in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-animation-graph-connect-motion-and-ragdoll-nodes.png)

1. Double\-click the **Blend Tree** node\.

1. Right\-click the grid and then choose **Create Node**, **Sources**, **Ragdoll**\. Alternatively, in the **Anim Graph Palette**, on the **Sources** tab, drag **Ragdoll** into the animation graph\.

1. Connect the **Output Pose** for the **Ragdoll** node to the **Input Pose** for the **Final Node** node\.

1. At the root of the animation graph, select the transition line that starts from the **Motion** node and connects to the **Blend Tree** node\. For example, select the transition line that connects the **Run** node to the **Ragdoll** node\.  
![\[Select the transition line that connects the Motion node to the Blend Tree node in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-animation-graph-transition-line.png)

   1. In the **Attributes** pane, click **Add condition** and then choose **Time Condition**\.

   1. Under **Time Condition**, set the **Countdown Time**\.  
![\[Add a Time Condition from the Attributes pane in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-animation-graph-add-time-condition.png)

1. In the animation graph, click the **Motion** node for a preview\.

## Simulating Your Ragdoll<a name="setting-up-a-ragdoll-simulating-the-ragdoll-in-game-mode"></a>

Once you've created your ragdoll and animation graph, you can simulate the ragdoll in game mode in Lumberyard Editor\.

**To simulate your ragdoll**

1. In Lumberyard Editor, right\-click the viewport and choose **Create entity**\.

1. In the **Entity Inspector**, for **Name**, enter **Ragdoll**\.

1. Add an **Actor** component:

   1. Click **Add Component**, **Actor**\.

   1. In the **Actor** component, for **Actor asset**, click the browse \(**\.\.\.**\) button\.

   1. In the **Pick EMotion FX Actor** window, select the actor for which you set up the ragdoll and then click **OK**\.  
![\[Select the actor for which you set up the ragdoll from the Pick EMotion FX Actor window in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-simulation-pick-ragdoll-actor.png)

1. Add an **Anim Graph** component:

   1. Click **Add Component**, **Anim Graph**\.

   1. In the **Anim Graph** component, for **Motion set asset**, click the browse \(**\.\.\.**\) button\.

   1. In the **Pick EMotion FX Motion Set** window, select your motion set and then click **OK**\.  
![\[Select a motion set from the Pick EMotion FX Motion Set window in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-simulation-pick-motion-set.png)

   1. In the **Anim Graph** component, for **Anim graph**, click the browse \(**\.\.\.**\) button\.

   1. In the **Pick EMotion FX Anim Graph** window, select your animation graph and then click **OK**\.  
![\[Select an animation graph from the Pick EMotion FX Anim Graph window in the Animation Editor\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/ragdoll-simulation-pick-animation-graph.png)

1. Click **Add Component**, **PhysX Ragdoll**\.

1. To start the level and simulate your ragdoll, press **Ctrl\+G**\.