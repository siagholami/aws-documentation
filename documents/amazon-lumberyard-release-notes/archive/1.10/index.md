# Lumberyard Release Notes – Beta 1.10 (August 2017)<a name="lumberyard-v1.10"></a>

Lumberyard Beta 1.10 adds over 546 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community, whose suggestions help us make a better product every release. Since launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/now-available-lumberyard-beta-1-10/).

**Topics**
+ [Highlights](#lumberyard-v1.10-highlights)
+ [Improvements and Changes](lumberyard-v1.10-changes.md)
+ [Fixes](lumberyard-v1.10-fixes.md)
+ [Known Issues](lumberyard-v1.10-known-issues.md)

## Highlights<a name="lumberyard-v1.10-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.10.

**Topics**
+ [Starter Game Action Update](#lumberyard-v1.10-highlights-starter-game-action-update)
+ [Reduce Pixelated Edges with Temporal Antialiasing](#lumberyard-v1.10-highlights-temporal-antialiasing)
+ [Use Order-Independent Transparency to Correctly Display Transparent Objects](#lumberyard-v1.10-highlights-order-independent-transparency)
+ [Build DirectX 12 Supported Applications](#lumberyard-v1.10-highlights-directx12)
+ [New Docking System in Lumberyard Editor](#lumberyard-v1.10-highlights-editor-docking-system)
+ [New Cloud Canvas Features](#lumberyard-v1.10-highlights-cloud-canvas)
+ [Improvements for Networking, Cloud Gems, and the Cloud Gem Portal](#lumberyard-v1.10-highlights-networking)
+ [New Features and Improvements for the Component Entity System](#lumberyard-v1.10-highlights-component-entity-system)
+ [New Amazon GameLift Features](#lumberyard-v1.10-highlights-amazon-gamelift)
+ [Asset Processor Displays Real-Time Logging](#lumberyard-v1.10-highlights-asset-processor-logs)
+ [New UI Features – Drag-and-Drop Functionality and Layout Components](#lumberyard-v1.10-highlights-ui-system-features)
+ [Virtual Reality Updates Include NullVR Gem and Tracking Level Node](#lumberyard-v1.10-highlights-vr-updates)
+ [Control the Playback for a Component Entity Sequence](#lumberyard-v1.10-highlights-component-entity-sequence-playback)
+ [SDK Compatibility](#lumberyard-v1.10-highlights-compatible-sdk-versions)

### Starter Game Action Update<a name="lumberyard-v1.10-highlights-starter-game-action-update"></a>

You can use the Starter Game sample to see how Lumberyard systems work together to make a game. Starter Game is a small, third-person game that is built with the Lumberyard component entity system. In addition to component entities, Starter Game demonstrates bipedal locomotion, voxel-based global illumination, the time of day system, and more.

The Action Update for Starter Game introduces over 950 features and improvements, including the following:
+ New player actions, including double-jumping, strafing, falling, and landing
+ Expanded interior areas
+ A campaign arc, complete with a story, cinematics, mission objectives, a compass to point you to your next objective, and a narrative voiceover to guide your mission
+ Enemy spawning and delivery
+ Improved aiming and shooting, with more accurate camera controls
+ More AI variation and responsiveness to player actions
+ Component-based track view setup, scripted for gameplay events
+ Component entities to create and update instanced combat zones
+ Mission progression built with cascading slices

The overall game experience is more polished with snappy gunplay mechanics, rocket jumping, and improved character control. You'll also discover a campaign arc and cinematic cut scenes that detail the story of Jack, the lone survivor of Scout Ship 06.

For more information, see [Starter Game Sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-level-starter-game.html).

### Reduce Pixelated Edges with Temporal Antialiasing<a name="lumberyard-v1.10-highlights-temporal-antialiasing"></a>

Temporal antialiasing is a postprocessing technique that accumulates frames over time to approximate supersampling. Supersampling can reduce jagged, pixelated edges in images. It works by projecting the current frame onto the previous frame and blending samples into an accumulation buffer. The current and history pixel neighborhoods are compared and an acceptance metric based on color and velocity determines if the history sample is still valid. This acceptance heuristic reduces ghosting artifacts in motion. The technique uses subpixel jitter to approximate supersampling even when the camera is static.

Temporal antialiasing is useful for reducing aliasing from the following:
+ Specular highlights and bright pixels, especially when combined with convolution filters such as **Depth of Field** or **Bloom**.
+ Geometric and alpha-tested edges.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-bistro-bar-example.gif)

For more information, see [Temporal Antialiasing and Supersampling](https://docs.aws.amazon.com/lumberyard/latest/userguide/graphics-rendering-anti-aliasing.html) in the *Amazon Lumberyard User Guide*.

### Use Order-Independent Transparency to Correctly Display Transparent Objects<a name="lumberyard-v1.10-highlights-order-independent-transparency"></a>

Order-independent transparency (OIT) corrects the display of transparent objects that are drawn out of order.

OIT is useful when creating the following:
+ **Concave geometry** – When you create concave geometry, such as a glass, wine glass, or glass sculpture, some triangles may cover the same pixels and are drawn on top of each other. OIT solves the out-of-order issues that appear from certain angles.
+ **Intersecting geometry** – When you create intersecting geometry, such as hair planes, some triangles may intersect in separate draws. OIT properly orders the triangles for each pixel.
+ **Transparent objects inside transparent objects** – This includes liquids inside of glasses, holograms, or X-Ray style effects.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-OIT-example-animation.gif)

For more information, see [Order-Independent Transparency](https://docs.aws.amazon.com/lumberyard/latest/userguide/graphics-rendering-order-independent-transparency.html) in the *Amazon Lumberyard User Guide*.

### Build DirectX 12 Supported Applications<a name="lumberyard-v1.10-highlights-directx12"></a>

Lumberyard 1.10 introduces a preview of DirectX 12, which provides the framework for you to build DirectX 12 supported applications.

DirectX 12 is useful for developing applications for the following reasons:
+ Overall GPU performance is slightly faster on Nvidia cards.
+ GPU-bound scenes may see an increase in frame rate.

DirectX 12 and DirectX 11.3 include the following new features:
+ Rasterizer ordered view with order-independent transparency
+ Tiled resources that enable virtual texture development to use on terrain
+ Optimized texture streaming
+ Various rendering techniques such as GI calculations
+ Conservative rasterization to develop and optimize ray tracing or voxel rendering

For more information, see [Building DirectX 12 Supported Applications](https://docs.aws.amazon.com/lumberyard/latest/userguide/graphics-rendering-directx.html) in the *Amazon Lumberyard User Guide*.

### New Docking System in Lumberyard Editor<a name="lumberyard-v1.10-highlights-editor-docking-system"></a>

In previous releases, Lumberyard previewed a new docking solution that aimed to provide greater control, predictability, and flexibility. With Lumberyard 1.10, this revised interface has become the official docking solution for Lumberyard and is now generally available for all Lumberyard customers.

The docking solution has the following features:
+ **Dock targets** – When you move a window over an interface element or the edges of the editor, targets appear for the top, bottom, left, and right quadrants of the pane. Drop the window on a target to split the row or column. You can also drop the window on a target in the middle of a pane to dock the window as a tab.
+ **Dock delay** – When you move a window, a brief delay occurs before a dock target becomes active. This delay helps prevent accidental docking.
+ **Relative docking** – You can dock windows relative to any open pane, whether it is already docked, floating as a tab, or split in a column or row.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/docking1.png)

Setting up your workspace with the tools you need and in the arrangement that you need them is paramount to good workflows. We'd love to hear your feedback on the new docking interface. Visit our [forums](https://forums.awsgametech.com/) to tell us what you like, what you don't like, and what features you want.

### New Cloud Canvas Features<a name="lumberyard-v1.10-highlights-cloud-canvas"></a>

Lumberyard 1.10 introduces the following Cloud Canvas features:
+ AWS functionalities and cloud gem API actions are now exposed to the behavior context and are available in Lua.
+ The Cloud Gem Portal now has the following player account features:
  + Reset password
  + Confirm players
  + Create a user
  + Blacklist players
+ If you are an account holder, you can now log in to the Cloud Gem Portal with a proper login workflow. Previously the login was done with a temporary presigned URL.
+ Cloud gems are now built using versioning, which provides the following benefits:
  + Prevents breaking changes
  + Allows cloud gems to depend on different versions of other gems such as the Cloud Gem Framework

**Important**  
Cloud gems versioning introduces a breaking change. Follow the migration steps outlined in [Updating Projects and Cloud Gems](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cgf-updating-projects-gems.html) in the *Amazon Lumberyard User Guide*.

For more information about the new Cloud Canvas features, see [Cloud Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-intro.html) in the *Amazon Lumberyard User Guide*.

### Improvements for Networking, Cloud Gems, and the Cloud Gem Portal<a name="lumberyard-v1.10-highlights-networking"></a>

Lumberyard 1.10 introduces networking improvements that include bitpacking compression and an interest management system that can help you prioritize network traffic and reduce bandwidth by up to 80%. If you use Cloud Gems, you can now use Lua to make API calls and script AWS functionality. You also have new player account functionality in the Cloud Gem Portal, including the ability to reset passwords, create new users, and blacklist players. For a more detailed list of improvements, see [Networking Improvements and Changes](https://docs.aws.amazon.com/lumberyard/latest/releasenotes/lumberyard-v1.10-changes.html).

### New Features and Improvements for the Component Entity System<a name="lumberyard-v1.10-highlights-component-entity-system"></a>

Lumberyard 1.10 introduces dozens of new features and improvements to the component entity system and slices.
+ The **Create Slice** **Save As** dialog box now suggests a name for your new slice. The suggested name is based on the top-level entity names.
+ You can enable or disable components from the incompatible component warning messages.

**Entity Inspector**
+ Each entity has an entity icon that displays in the viewport and in the Entity Inspector next to the **Name** field.
+ By default the assigned entity icon is the first nontransform component that appears in the Entity Inspector when you select the entity.
+ You can assign a custom entity icon. In the Entity Inspector, click the entity icon and choose **Set custom icon**.
+ You can add custom entity icons to any directory called `Entity Icons`. However, the `Entity Icons` directory must reside in a directory that the Asset Processor monitors.
+ The **Add Component** feature now has better keyboard navigation. You can switch focus between the component tree and search filter box by pressing the up or down arrow keys.
+ You can enable and disable components in the Entity Inspector. Disabled components are read only and do not activate, generate warnings, or export with game data.
+ You can choose entities from the Entity Outliner when you use the entity picker on a property in the Entity Inspector.
+ You can use **Ctrl\+Shift** to select multiple components. Context menu and keyboard actions (cut, copy, paste, delete, enable, disable, etc.) for multiselection work as expected.
+ Pasting components in the Entity Inspector applies to all selected entities.
+ When you paste a component in the Entity Inspector, it is pasted above selected components (if any) or at the bottom of the list.

**Entity Outliner**
+ You can rename entities by pressing **F2**, using the context menu, or clicking the name in the Entity Outliner.
+ You can revert entities and components to their default slices:
  + In the Entity Outliner, right-click a component and choose **Revert component overrides** from the context menu. This reverts any selected components to their default slices.
  + In the Entity Outliner or viewport, right-click a component and choose **Revert overrides**. This reverts any selected entities to their default slices.
+ Drag-and-drop support and rules for reparenting entities have been improved. You can now select one or more entities from anywhere in the hierarchy. Dragging to an empty space parents the selection. Dragging above, below, or between entities makes the selected entities a sibling of the drop target. You cannot drag a selection to an entity that is also selected or to a descendent of a selected entity.
+ Drag-and-drop feedback for reparenting is now updated in real time to show if a drop is allowed.
+ Selection changes occur when you release the mouse. Use this feature to drag unselected entities within and out of the Entity Outliner.

**Nested Slices**
+ You can push slices as additions to existing slices. You can also push to create nested slices. Previously the only option was to use **Create Slice**.
+ You can force a property override on a nested slice to prevent the property from inheriting future changes from the source slice. Previously this was impossible if the value was identical to the source slice.
+ You can choose to create nested slices from only a subset of another slice's entities. Previously if you created a nested slice from another slice instance, all entities from that slice instance was included.

For more information about entities, components, and slices, see [Component Entity System](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-intro.html) in the *Amazon Lumberyard User Guide*.

### New Amazon GameLift Features<a name="lumberyard-v1.10-highlights-amazon-gamelift"></a>

Stay up to date with the latest release information at [AWS Release Notes for Amazon GameLift](https://aws.amazon.com/releasenotes/Amazon-GameLift?browse=1).

**Metrics Support in Amazon CloudWatch**  
You can now use CloudWatch with Amazon GameLift metrics to track game server performance and usage levels. CloudWatch provides a suite of monitoring tools that include customizable dashboards and alarms. Metrics on active fleets, fleet capacity, and queue activity are now accessible in CloudWatch as well as the Amazon GameLift console. Use the **Metric Group** feature to track metrics for a defined groups of fleets (for example, you might create a metric group for all fleets in a region or all fleets deployed with a specific build). For more information, see [Monitor Amazon GameLift with Amazon CloudWatch](https://docs.aws.amazon.com/gamelift/latest/developerguide/monitoring-cloudwatch.html) in the *Amazon GameLift Developer Guide*.

**Fine Tune Your Game Session Activations**  
For game developers who have set up Amazon GameLift to run multiple game server processes per fleet instance, these new settings can help optimize overall performance. This is particularly so with game servers that have a resource-intensive launch process:
+ **Limit concurrent activations** – Set a low limit to protect individual instances from being overloaded with simultaneous activations, which can affect all game servers that are running or activating on the instance.
+ **Set an activation timeout** – Set Amazon GameLift to terminate an activation and free up instance resources if the activation doesn't succeed by the timeout.

### Asset Processor Displays Real-Time Logging<a name="lumberyard-v1.10-highlights-asset-processor-logs"></a>

The Asset Processor now has a **Logs** tab that displays real-time logging. This helps you learn what the Asset Processor is doing and to debug issues. For more information, see [Using the Asset Processor](https://docs.aws.amazon.com/lumberyard/latest/userguide/asset-pipeline-processor.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/asset-browser-logs-tab.png)

### New UI Features – Drag-and-Drop Functionality and Layout Components<a name="lumberyard-v1.10-highlights-ui-system-features"></a>

Lumberyard 1.10 introduces the following **UI Editor** features:
+ The **Ui Draggable** and **Ui Drop Target** components, in conjunction with Lua, provide a flexible drag-and-drop system that you can use in UI canvasses. For more information, see [Interactive Components](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-components-interactive.html) in the *Amazon Lumberyard User Guide*.
+ The **Layout Cell** component allows **Layout Row** and **Layout Column** components to have children that are not uniform in size. Additionally, the layout components have been enhanced. You can dictate the size by using the natural size of the visual components on the child elements, or by adding a **Layout Cell** component to a child element. This means you can now edit the **Scale**, **Pivot**, and **Rotate** properties for children of a layout element. Previously you had to disable these properties. For more information, see [Layout Components](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-components-layout.html) in the *Amazon Lumberyard User Guide*.

### Virtual Reality Updates Include NullVR Gem and Tracking Level Node<a name="lumberyard-v1.10-highlights-vr-updates"></a>

Lumberyard 1.10 includes the following VR updates:

**NullVR Gem Adds Supports for VR Graphics Debugging**  
Enable the NullVR Gem in the Project Configurator so that you can test the virtual reality systems without a VR device attached. This is useful if you want to do light VR debugging or demonstrate content without VR hardware. For more information, see [NullVR Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-nullvr.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/vr-nullvr-gem.png)

**New Tracking Level for VR Devices**  
Use the `VR:SetTrackingLevel` flow graph node to set the tracking level of an attached VR device. You can specify either **Head** or **Floor** to determine how the HMD's origin is calculated for every frame. This is useful for 360 video playback because the HMD is fixed at a camera location and only rotation is allowed. For more information about the flow graph modules that you can use for your virtual reality game, see [Virtual Reality (VR) Nodes](https://docs.aws.amazon.com/lumberyard/latest/userguide/fg-node-ref-virtual-reality.html) in the *Amazon Lumberyard User Guide*.

### Control the Playback for a Component Entity Sequence<a name="lumberyard-v1.10-highlights-component-entity-sequence-playback"></a>

Lumberyard 1.10 provides new EBus request events that you can use to control the playback of a component entity sequence in C\+\+ or Lua. The `SequenceComponentRequestBus` has several new events:
+ `Play`
+ `Pause`
+ `Stop`
+ `Resume`
+ `PlayBetweenTimes`
+ `SetPlaySpeed`
+ `JumpToTime`
+ `JumpToEnd`
+ `JumpToBeginning`
+ `GetCurrentPlayTime`
+ `GetPlaySpeed`

You can also use notification events to respond to playback and event track triggers. The `SequenceComponentNotificationBus` has several new events:
+ `OnStart`
+ `OnStop`
+ `OnPause`
+ `OnResume`
+ `OnAbort`
+ `OnUpdate`
+ `OnTrackEventTriggered`

For more information, refer to the comments for each event in the `SequenceComponentBus.h` header file.

### SDK Compatibility<a name="lumberyard-v1.10-highlights-compatible-sdk-versions"></a>

Lumberyard 1.10 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.0.74
+ Amazon GameLift Server SDK version 3.1.5