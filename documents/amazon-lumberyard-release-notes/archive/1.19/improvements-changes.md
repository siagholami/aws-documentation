# Improvements and Changes<a name="lumberyard-v1.19-improvements-changes"></a>

Lumberyard Beta 1.19 provides improvements and changes to Lumberyard systems and functionality.

**Topics**
+ [Amazon GameLift](#amazon-gamelift-improvements-changes-v1.19)
+ [Animation Editor](#animation-editor-improvements-changes-v1.19)
+ [Asset Editor](#asset-editor-improvements-changes-v1.19)
+ [Audio](#audio-improvements-changes-v1.19)
+ [Cloud Canvas](#cloud-canvas-improvements-changes-v1.19)
+ [Lumberyard Editor](#editor-improvements-changes-v1.19)
+ [Mobile](#mobile-improvements-changes-v1.19)
+ [PhysX System](#lumberyard-v1.19-highlights-physx-system)
+ [Script Canvas](#lumberyard-v1.19-script-canvas)
+ [Starter Game](#lumberyard-v1.19-starter-game-sample)
+ [SDK Compatibility](#lumberyard-v1.19-highlights-compatible-sdk-versions)
+ [Vegetation](#dynamic-vegetation-improvements-changes-v1.19)
+ [Visual Studio 2017](#visual-studio-support-improvements-changes-v1.19)
+ [Miscellaneous](#miscellaneous-improvements-changes-v1.19)

## Amazon GameLift<a name="amazon-gamelift-improvements-changes-v1.19"></a>

Stay up to date with the latest release information at [AWS Release Notes for Amazon GameLift](https://aws.amazon.com/releasenotes/Amazon-GameLift?browse=1).

## Animation Editor<a name="animation-editor-improvements-changes-v1.19"></a>

The **Animation Editor** has the following improvements and changes:
+ You can add a new **FootplantIK** node to a blendtree. You can use the node to plant an actor's feet on the game terrain and automatically adjust the hip of the actor. The node comes with settings to fine-tune the footplant, including foot and hip adjustments.

## Asset Editor<a name="asset-editor-improvements-changes-v1.19"></a>

The **Asset Editor** has the following improvements and changes:
+ You no longer need to create and save an asset file before you make your changes.
+ The auto-save feature was removed for stability.
+ A status panel shows feedback when assets are saved or if there are errors.
+ Added a **Save as** option.
+ Added a **Open Recent** option.

## Audio<a name="audio-improvements-changes-v1.19"></a>

The audio system has the following improvements and changes:
+ You can use the **Multi-position Audio Source** component to play one sound simultaneously from multiple locations.

## Cloud Canvas<a name="cloud-canvas-improvements-changes-v1.19"></a>

The Cloud Canvas system has the following improvements and changes:
+ **Back up and restore** – You can now use a command-line tool to back up Cloud Gem deployment stacks. This command backs up the data in a deployment stack and restores the data to a new deployment stack.
+ **Server authoritative Cloud Gems** – You can now securely call Cloud Gems from a dedicated server instead from the game client. Instead of relying on the game client to provide accurate data, you can get more consistent and reliable data with this feature, as well as reduces the ability of players to cheat. The CloudGemSample leaderboard level has been updated to show how to make server-authoritative calls to Cloud Gems.
+ **Access external resources** – You can now use your existing AWS resources in your Cloud Gems so you don't have to start from scratch. The Cloud Gem service Lambda resources can access AWS resources outside of a gem's resource group.
+ **Cost allocation tags** – The resources in a Cloud Gem are now tagged by default. By enabling cost allocation tags in AWS Cost Explorer, you can see the cost and usage of specific deployments and gems. 
+ **Removed Cloud Gem Portal pre-signed urls** – The Cloud Gem Framework now generates static links for the Cloud Gem Portal. Previously, the Cloud Gem Portal was accessed by pre-signed URLs that expired after 7 days and needed to be regenerated. 
+ **Improved logging and error handling** – To make it easier to debug service calls, you can use the `lmbr_aws` command to display the logs for a specific invocation of a Cloud Gem service API. The command returns the entire request and response to the console.
+ **Use multiple deployments in a build** – You can now specify which Cloud Gem deployment to use from the launcher when the launcher is already running. This is especially useful if you have multiple mapping files during development or want to direct your player traffic to deployments in specific regions. The default behavior is still to use the newest mapping file.

## Lumberyard Editor<a name="editor-improvements-changes-v1.19"></a>

Lumberyard Editor has the following improvements and changes to the **Entity Inspector**:
+ The property editor now supports sliders with nonlinear scale. This is useful for more granular precision at one end of the range and less granular at the other end.
+ The property editor now supports the ability to denote a specific display order for properties.
+ The property editor now supports the ability to add buttons directly as UI elements with handlers without requiring an underlying Boolean variable to be attached.

## Mobile<a name="mobile-improvements-changes-v1.19"></a>

Mobile has the following improvements and changes:
+ Starter Game now supports mobile devices for iOS and Android. 
+ CPU occlusion culling now supports mobile devices for iOS and Android. 
+ Android 32-bit (ARMv7) support has been deprecated. Starting August 1, 2019, Google will require that Android native apps support 64-bit (ARMv7) versions.

## PhysX System<a name="lumberyard-v1.19-highlights-physx-system"></a>

The PhysX system has the following improvements and changes:
+ The PhysX gem description is updated to explain that the PhysX and legacy physics systems are incompatible.
+ The **Collision Layers** and **Groups** tabs in the **PhysX Configuration** tool are now combined into a single **Collision Filtering** tab. 
+ In the **PhysX Collider** component, you can click a button for the **Collision Layer** and **Collides With** properties to open the **Collision Filtering** tab in the **PhysX Configuration** tool.

## Script Canvas<a name="lumberyard-v1.19-script-canvas"></a>

The Script Canvas system has the following improvements and changes:
+ Added support to specify the style for a deprecated node. Nodes that have the deprecated attribute have a custom style.
+ Node groups are animated when you choose to expand or contract them in the graph.
+ Node splicing is improved (one to one mapping) in the graph.
+ You can select and shake a group of nodes to remove its connections to other nodes. By default, this option is disabled.
+ Selecting and dragging a node's output now auto-completes with a recommended node.
+ When you add a node to a graph, this dynamically moves other nodes in the graph.
+ When you right-click the graph to add a node, Script Canvas automatically connects the nodes. 
+ You can cycle through node and variable instances. Select the variable or node name in the palette and press **F7** to scroll backwards or press **F8** to scroll forward through instances.
+ You can select a variable in the **Variable Manager** to highlight all variable nodes on the graph.
+ Text changes to node names and tooltips.
+ Press **Ctrl \+ A** to select all nodes in the graph.
+ Press **Ctrl \+ Left Arrow** to select all nodes to the left of the selected node.
+ Press **Ctrl \+ Right Arrow** to select all nodes to the right of the selected node.
+ Press **Ctrl \+ Up Arrow** to select all connected nodes to the selected node.
+ Press **Shift \+ Left Arrow** to align selected nodes to the left.
+ Press **Shift \+ Right Arrow** to align selected nodes to the right.
+ Press **Shift \+ Up Arrow** to align selected nodes to the top.
+ Press **Shift \+ Down Arrow** to align selected nodes to the bottom.
+ Changed the title for comment nodes.
+ Added support for edge panning while you're dragging a node.
+ Added support for copying and pasting variables from the **Variable Manager**.
+ Added support for the **Remove Unused Variables** option.
+ Added support for the **Clean-up Graph** option. This option also removes unused variables.
+ Added a unit test for **On Graph Start** activation timing.
+ Added unit tests for **Script Events**.
+ Added unit tests for graph-based math and variables.
+ With the release of **Script Events**, the following C\+\+ classes are deprecated: 
  + `GameplayNotificationBus`
  + `GameplayNotificationId`
  + `BehaviorGameplayNotificationBusHandler`
  + `GameplayEventHandlerNode` (legacy)
+ Execution flow is gated when any input slot is signaled.
+ Dragging in an entity reference into the graph now creates an **EntityId** variable with the specified **EntityId** instead of a specialized node.

Script Canvas adds the following nodes:
+ **DrawTest** node
  + Added optional duration
  + Added editor-only flag to prevent certain debug **DrawText** from being shown in launchers
+ String nodes
  + **Split**
  + **Join**
  + **Contains**
  + **Replace**
  + **To Lower**
  + **To Upper**
  + **Starts With**
  + **Ends With**
+ Context-sensitive container nodes
  + **Art**
  + **Back**
  + **Clear**
  + **Erase**
  + **For Each**
  + **Front**
  + **Insert**
  + **Push Back**
  + **Size**
  + **Is Empty**
+ Context-sensitive math nodes
  + **Add**
  + **Multiply**
  + **Divide**
  + **Subtract**
  + **Length** (for vector types)

## Starter Game<a name="lumberyard-v1.19-starter-game-sample"></a>

Added code and asset optimizations to improve compatibility and performance for supported platforms. The Starter Game sample supports the following:
+ Windows
+ macOS
+ iOS
+ Android (for good performance, use devices no older than 2 years with ARMv8 and Adreno GPU)

For more information, see [Starter Game Sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-level-starter-game.html) in the *Amazon Lumberyard User Guide*.

## SDK Compatibility<a name="lumberyard-v1.19-highlights-compatible-sdk-versions"></a>

Lumberyard 1.19 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.4.34.1
+ Amazon GameLift Server SDK version 3.2.1

## Vegetation<a name="dynamic-vegetation-improvements-changes-v1.19"></a>

The vegetation system has the following improvements and changes:
+ Updated the vegetation touch bending authoring and runtime system to provide an artist-friendly workflow. Touch bending is the ability to make individual vegetation instances bend in response to collision forces. You can now author touch bending assets as standard skinned meshes (as opposed to the previous locator nodes or UV coloring) and use the FBX workflow. Touch bending supports the legacy and dynamic vegetation systems. 

  Touch bending supports the legacy CryPhysics and PhysX systems. To enable touch bending for PhysX, you must enable the Touch Bending gem for your project.

## Visual Studio 2017<a name="visual-studio-support-improvements-changes-v1.19"></a>

Lumberyard 1.19 supports Visual Studio 2017 version 15.9.12.

Beginning with Visual Studio 2017, Microsoft now releases updates on a more frequent cadence (in some cases, weekly). Lumberyard is tested with the latest version of Visual Studio available during the release cycle. 

## Miscellaneous<a name="miscellaneous-improvements-changes-v1.19"></a>

Lumberyard has the following are miscellaneous changes:
+ The AZ Test Framework has the following changes:
  + Tests that directly and indirectly called `AZ_Error` no longer display a pop-up message box.
  + Tests that directly and indirectly called `AZ_Assert` and `AZ_Error` now fail unless they tag the test with `AZ_TEST_START_ASSERTTEST` and `AZ_TEST_STOP_ASSERTTEST`. Tests that added their hooks through `AZ_UNIT_TEST_HOOK` don't have this behavior.
  + Test fixtures that inherited from `AllocatorsTestFixture` and `AllocatorsFixture` now fail if the test leaks memory. Leaks are reported to the test output with the `"Memory"` tag, and stack traces are provided for the leaks. 