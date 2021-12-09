# Lumberyard Release Notes – Beta 1.8 (February 2017)<a name="lumberyard-v1.8"></a>

Lumberyard Beta 1.8 adds new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our developer community. Without your participation in the forums, your messages, and your bug reports, Lumberyard 1.8 wouldn't be as strong as it is. Keep sending your feedback to lumberyard-feedback@amazon.com. If you haven't spoken up in the [forums](https://forums.awsgametech.com/) yet, we would love to have you. You can also keep up with new changes by following [our blog](https://aws.amazon.com/blogs/gametech/now-available-lumberyard-beta-1-8/) and leave comments to let us know what you think.

**Topics**
+ [Highlights](#lumberyard-v1.8-highlights)
+ [Preview Systems and Tools](lumberyard-v1.8-preview-systems.md)
+ [Improvements and Changes](lumberyard-v1.8-changes.md)
+ [Fixes](lumberyard-v1.8-fixes.md)
+ [Known Issues](lumberyard-v1.8-known-issues.md)

## Highlights<a name="lumberyard-v1.8-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.8.

**Topics**
+ [Cloud Gems Framework](#lumberyard-v1.8-preview-system-cloud-gem-framework)
+ [Cloud Gem Portal](#lumberyard-v1.8-preview-system-cloud-gem-portal)
+ [New Look for Lumberyard Editor](#lumberyard-v1.8-highlights-lumberyard-editor-reskin)
+ [FBX SDK Installation Files in Lumberyard Setup Assistant](#lumberyard-v1.8-highlights-fbx-sdk-installation)
+ [Multiple UV Support for Meshes](#lumberyard-v1.8-highlights-lumberyard-multi-uv-meshes)
+ [Animate Component Entities in the Track View Editor](#lumberyard-v1.8-highlights-cinematics)
+ [Amazon GameLift – Game Session Queues and Player Data](#lumberyard-v1.8-highlights-amazon-gamelift)
+ [Behavior Context Replaces the Script Context](#lumberyard-v1.8-highlights-behavior-context)
+ [Behavior Context Updates for Component Entity Lua Scripts](#lumberyard-v1.8-highlights-lua-script)
+ [New RAD Telemetry Gem](#lumberyard-v1.8-highlights-rad-telemetry-gem)
+ [New Virtual Reality Features](#lumberyard-v1.8-highlights-virtual-reality)

### Cloud Gems Framework<a name="lumberyard-v1.8-preview-system-cloud-gem-framework"></a>

The Cloud Gems Framework makes it easier for you to build and launch connected game elements, such as dynamic content, leaderboards, and live messages. With the Cloud Gems Framework, you can add a connected feature to your game in as little as 30 minutes.

The Cloud Gem Framework provides the following features to include AWS functionality in your game projects:
+ **Cloud Gem Message of the Day** – Schedule messages that your game can access
+ **Cloud Gem Leaderboard** – Create a leaderboard with player stats that your game can access
+ **Cloud Gem Dynamic Content** – Manage dynamic content updates through AWS
+ Dynamic content manager – Pack, upload, and manage your downloadable content
+ Service API code generation – Generate the API operations that are required to interact with the backend as a player (game client), administrator (Cloud Gem Portal), or website
+ Cloud Canvas security model

For more information, see [Cloud Gems](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cloud-gems-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/cloud_gem_architecture.png)

### Cloud Gem Portal<a name="lumberyard-v1.8-preview-system-cloud-gem-portal"></a>

The Cloud Gems Framework is made up of the Cloud Gem Portal, a web application that lets anyone on your team visually manage Cloud Gems and your cloud features. Examples include scheduling messages, releasing dynamic content, or deleting fraudulent leaderboard scores. Cloud Gems are modular packages that provide everything necessary for you to add that functionality into your project, including backend and client functionality. You can use Cloud Gems out of the box in production. The gems come with full source code so that you can customize their behavior.

The portal is currently supported on Microsoft Edge, Mozilla Firefox, and Google Chrome. You can easily share a link to your Cloud Gem Portal by clicking the share icon in the navigation bar. A session is 60 minutes (3600 seconds), by default. The minimum session length is 15 minutes (900 seconds) and the maximum is 60 minutes. You can override the default duration using the following command: `lmbr_aws cloud-gem-framework cloud-gem-portal --duration-seconds 900`.

For more information, see [Cloud Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/cloud_gem_portal.png)

### New Look for Lumberyard Editor<a name="lumberyard-v1.8-highlights-lumberyard-editor-reskin"></a>

Lumberyard Editor has a new look\! The editor has been reskinned with a more modern interface and an improved design for windows, frames, and controls. The default layout now displays the **Entity Outliner** in the top left panel, the **File Browser** in the bottom left panel, and the **Entity Inspector** in the right panel. The **Rollup Bar** is now tabbed in the right panel.

The editor navigation has also been updated to reduce the steps required to open Lumberyard tools. Previously you were required to click **View**, **Open View Pane**, and then select a tool. Now you can access all tools from the **Tools** menu.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/lumberyard_editor_new_skin.png)

### FBX SDK Installation Files in Lumberyard Setup Assistant<a name="lumberyard-v1.8-highlights-fbx-sdk-installation"></a>

Lumberyard Beta 1.8 includes the installation files for the FBX SDK. You must install the SDK if you want to compile the Lumberyard engine, asset pipeline, and editor. To install the SDK, go to the Lumberyard Setup Assistant. On the **Install required SDKs** page, click **Install SDK** under **Autodesk FBX SDK**. Ensure the installation path is set to your third-party directory.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/fbx_sdk_setup.png)

### Multiple UV Support for Meshes<a name="lumberyard-v1.8-highlights-lumberyard-multi-uv-meshes"></a>

Lumberyard Beta 1.8 adds multiple UV support, allowing up to two UV channels on static meshes and independent texture tiling for layered materials. This new feature allows you to combine two unique UV layouts, tile or animate each layer as desired, and blend with a blend mask. You can enable this feature using a shader generation parameter on shaders that support blend layers.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-multi-uv-support-meshes-example.gif)

The following features were also added:
+ Support for independently tiled texture maps. If you change the tiling, rotation, or oscillation values for the blend layer, detail map, or emittance shader features, these values are modified independently from the rest of the material's tiling, rotation, and oscillation values.
+ Support for second layer specular map and specular color.
+ Support for occlusion map for the Illum shader.
+ Specular antialiasing on the Illum shader.

For more information, see [Using Multiple UV Channels](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-fbx-uv-streams.html).

### Animate Component Entities in the Track View Editor<a name="lumberyard-v1.8-highlights-cinematics"></a>

You can now animate the following component entities with the **Track View** editor:
+ Transform
+ Camera
+ Light (Point, Area, Projector)
+ Skinned Mesh
+ Static Mesh
+ Simple Animation

Reflect the component properties using the behavior context for animation in the **Track View** editor. For more information about these component entities, see the [Component Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html). For more information about animating using the **Track View** editor, see the [Cinematics System](https://docs.aws.amazon.com/lumberyard/latest/userguide/cinematics-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/track_view_animate_components.PNG)

### Amazon GameLift – Game Session Queues and Player Data<a name="lumberyard-v1.8-highlights-amazon-gamelift"></a>

The following features have been added for Amazon GameLift:
+ Use game session placement queues to place new game sessions faster and more efficiently across Amazon GameLift resources. Place game sessions on any of an ordered list of fleets that can span multiple regions. This feature lets you handle increased player demand by spreading it across existing fleets and regions instead of scaling up a single fleet. With game session placements, you can also join one or more players to the game session at the same time. Add information on player-region latency to help Amazon GameLift find the best available fleet to host the new game session for the players. For more information, see [Setting Up Queues](https://docs.aws.amazon.com/gamelift/latest/developerguide/gamelift-sdk-client-queues.html).
+ You can now provide customized player data to a game server when a player joins the game. This feature is useful for delivering information from a game service directly to the game server. Player data may include any information that your game server can interpret, such as team memberships or skill/rank data from a matchmaking service. If your game uses encrypted client/server communication, player data is a good way to deliver a decryption key to the game server. For more information, see [Join a Player to a Game Session](https://docs.aws.amazon.com/gamelift/latest/developerguide/gamelift-sdk-client-api.html#gamelift-sdk-client-api-join).

### Behavior Context Replaces the Script Context<a name="lumberyard-v1.8-highlights-behavior-context"></a>

Lumberyard Beta 1.8 introduces consequential changes to the behavior context. Significant improvements to Lumberyard Editor include replacing the existing script context with a new reflection context. For information about these changes and instructions to migrate your existing projects, see [Migrating Lumberyard Projects](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-migrating-1-8.html) and [Behavior Context](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-system-reflection-behavior-context.html).

### Behavior Context Updates for Component Entity Lua Scripts<a name="lumberyard-v1.8-highlights-lua-script"></a>

Component entity Lua scripts are also impacted by the changes to the behavior context. If you have written or currently use component entity Lua scripts, you must convert them to the new behavior context syntax. For information about these changes and instructions on migrating your existing projects, see [Migrating Lumberyard Projects](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-migrating-1-8.html) and [Writing Lua Scripts for the Component Entity System](https://docs.aws.amazon.com/lumberyard/latest/userguide/lua-scripting-ces.html).

### New RAD Telemetry Gem<a name="lumberyard-v1.8-highlights-rad-telemetry-gem"></a>

Lumberyard Beta 1.8 provides a RAD Telemetry Gem that enables you to use instrumentation-based profiling and performance visualization middleware in your Lumberyard project. You must have a Rad Telemetry license from [RAD Game Tools](http://www.radgametools.com/telemetry.htm). For more information, see [RAD Telemetry Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-rad-telemetry.html).

### New Virtual Reality Features<a name="lumberyard-v1.8-highlights-virtual-reality"></a>

Lumberyard Beta 1.8 adds the following features and functionality for virtual reality:
+ The `AI:RayCastMNM` node allows you to ray cast with the AI navigation mesh.
+ The `StereoRendererbus` with `IsRenderingToHMD` function allows you to identify when the renderer is rendering to the HMD.
+ Use the `VR:Playspace` node to extend play space control on Oculus and Vive.
+ Use the `VR:VRPreviewComponent` node to generate a navigation mesh for VR teleport.
+ Use the **W**, **A**, **S**, and **D** keys with the VR debug camera to move relative to the camera. To enable the VR debug camera, set the `hmd_debug_camera` console variable to 1.

For more information, see [Virtual Reality](https://docs.aws.amazon.com/lumberyard/latest/userguide/virtual-reality.html).