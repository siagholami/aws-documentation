# Fixes<a name="lumberyard-v1.15-fixes"></a>

Lumberyard Beta 1.15 resolves earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [AI](#ai-fixes-v1.15)
+ [Android Studio](#android-studio-fixes-v1.15)
+ [Animation Editor](#animation-editor-fixes-v1.15)
+ [Asset Browser](#asset-browser-fixes-v1.15)
+ [Asset Processor](#asset-processor-fixes-v1.15)
+ [Cloud Canvas](#cloud-canvas-fixes-v1.15)
+ [Component Entity System](#component-entity-system-fixes-v1.15)
+ [Graphics](#graphics-fixes-v1.15)
+ [Lmbr.exe](#lmbr.exe-fixes-v1.15)
+ [Lumberyard Editor](#lumberyard-editor-fixes-v1.15)
+ [Lumberyard Setup Assistant](#lumberyard-setup-assistant-fixes-v1.15)
+ [macOS](#macos-fixes-v1.15)
+ [Mobile](#mobile-fixes-v1.15)
+ [Networking](#networking-fixes-v1.15)
+ [Script Canvas](#script-canvas-fixes-v1.15)
+ [Starter Game](#starter-game-fixes-v1.15)
+ [UI Editor](#ui-editor-fixes-v1.15)
+ [Miscellaneous](#miscellaneous-fixes-v1.15)

## AI<a name="ai-fixes-v1.15"></a>

The **Navigation Area** component no longer destroys and recreates navigation areas while the level is loading.

## Android Studio<a name="android-studio-fixes-v1.15"></a>

Android Studio has the following fixes:
+ Assets are now deployed properly from the Android Studio solution to the Android device.
+ Android Studio builds now use the same Java version as standalone Waf builds.

## Animation Editor<a name="animation-editor-fixes-v1.15"></a>

The **Animation Editor** has the following fixes:
+ If all layouts are removed, the **Animation Editor** uses the **AnimGraph** layout as the default.
+ You can now create actors from bone data only and without an animation frame.
+ When you toggle the visibility control for a slice on an actor entity in the **Entity Outliner**, the actor no longer renders in the viewport.
+ Lumberyard Editor no longer stops working when you attempt to record an **Animation Graph** animation for 10 minutes or longer.
+ The changes that you make in the following locations are now saved:
  + **Edit**, **Preferences**, **General**, **Render plugin properties**
  + **Edit**, **Preferences**, **General**, **Select Color**
+ The **File**, **Reset** option now selects the appropriate options based on the elements in the workspace.
+ Lumberyard Editor no longer stops working when you select an empty **Anim Graph** window without an animation graph file loaded, and then press the **Backspace** key.
+ You can now use **Animation Editor** with external game projects.
+ Lumberyard Editor no longer stops working when you save motion sets that contain undefined motions.
+ The animation graph simulation in the Advanced\_RinLocomotion sample level now synchronizes correctly.
+ Lumberyard Editor no longer stops working when you add all meshes in the **Collision Mesh Setup** window. To add all meshes, follow these steps:

  1. In the **Animation Editor**, in the **Actor Manager** pane, click the folder icon.

  1. In the **Pick EMotion FX Actor** window, select your actor file and then click **OK**.

  1. In the **Actor Manager** pane, under **Actor Properties**, click the setup button for **Collision Mesh Setup**.

  1. In the **Collision Mesh Setup** window, right-click an actor list item and then select **Add all towards root to selection**.
+ The **Auto Load Last Workspace** option now opens the previously used workspace.
+ The following options were removed because they are not supported in Lumberyard: **Hide Scale Actor Data**, **Scale Motion Data**, **Scale Anim Graph Data**, and **Collision Mesh Setup**.
+ You can now use the **Transform**, **Rotation**, and **Scale** tools in all camera view types (front, back, left, and right).
+ You can now use the **Rotation** tool and its gizmos in the preview window and in the top and bottom camera view type.
+ You can now select child motion sets from the **AnimGraph** component.
+ When you hide an actor asset in the **Entity Outliner**, the model no longer appears in the viewport.
+ The **Setup Phonemes** feature has been removed. You cannot add a phoneme to a phoneme set.
+ When you create multiple event presets, you must specify unique names for each event preset.
+ If you attempt to play a motion without an actor file open, you will now see an error with more information.
+ When you add a motion to a motion set and then save, the **Motion Set** drop-down list now shows the saved motion set.
+ The **Time View** window no longer expands indefinitely when you add event tracks.
+ You will no longer see erroneous messages about activation when you load a workspace.
+ When you clear (disable) the **Draw character** check box for an **Actor** component in the **Entity Inspector**, the character no longer appears in game mode.
+ The **Morph Targets** pane no longer clears when you switch panes.
+ You must enable the CryLegacyAnimation gem to use the **Ragdoll** component and other legacy **CryAnimation** components.
+ The Jump and Forage motions are no longer included in the motion set for the Simple\_JackLocomotion level.
+ You can no longer erroneously drag `.animgraph` assets to the viewport.
+ **Animation Editor** windows no longer have a double border.

## Asset Browser<a name="asset-browser-fixes-v1.15"></a>

Geometry data is no longer missing when you use the **Export Selected Objects** option.

## Asset Processor<a name="asset-processor-fixes-v1.15"></a>

Asset Processor has the following fixes:
+ Asset Processor can now process slices that contain an **Infinite Ocean** component.
+ The **Actor** tab now shows in the `.fbx` settings after Asset Processor processes an `.fbx` file.
+ Asset Processor can now process the `rinActor.fbx` file.
+ Asset Processor no longer attempts to rebuild assets multiple times.
+ Error messages no longer appear when Asset Processor restarts and gems start loading.
+ The `i_caf` files now compile properly.

## Cloud Canvas<a name="cloud-canvas-fixes-v1.15"></a>

Cloud Canvas has the following fixes:
+ The documentation link in the `lmbr_aws` output has been updated to the correct URL.
+ You can now use the **Clear Content** and **Delete Pak** buttons to clear a file of dynamic content.
+ The Text-to-Speech map and gem now work in all supported regions.
+ You will no longer see an error when you create or delete a deployment stack.
+ The process to create project stacks now begins immediately in the Cloud Canvas Resource Manager.
+ The Cloud Canvas Resource Manager no longer stops working when you attempt to add multiple AWS resources such as a DynamoDB table, Lambda function, Amazon S3 bucket, Amazon SNS topic, or Amazon SQS queue.
+ The Cloud Gem Portal now works as expected when you create deployments with different resource groups. Previously the dashboard and Cloud Gems would not load.
+ Messages in the Cloud Gem Portal now remain active for up to 12 hours after the end date, relative to the player's time zone.

## Component Entity System<a name="component-entity-system-fixes-v1.15"></a>

The component entity system has the following fixes:
+ When adjusting the width, the **Entity Inspector** is now resized consistently.
+ The **Delete** keyboard shortcut now works in the **Entity Outliner**.
+ The rotation of the original object is now maintained when you press the **Alt** key while using the **Align to Object** option. If you want to change the rotation of the original object to match the target, you can use the **Align to Object** option without pressing the **Alt** key.
+ The context menu options now work properly when you right-click a component in the **Entity Inspector**.
+ You can now create dynamic slices from an entity that has a **Camera** component.
+ Entities are no longer spawned at inaccurate positions.
+ The **Transform** component can now handle transform jitter.
+ You can no longer add or edit **Flow Graph** components unless you enable legacy tools. For more information, see [CryEntity Removal Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-cryentity-removal-gem.html) in the *Amazon Lumberyard User Guide*.
+ When converted to the component entity system, the legacy physical brush now retains physics information.
+ Lumberyard Editor no longer stops working if a **Netbinding** component cannot be found.

## Graphics<a name="graphics-fixes-v1.15"></a>

The graphics system has the following fixes:
+ You can now make an opaque material be transparent at runtime.
+ The `r_MeasureOverdraw` console variable now works properly for the overdraw debug render mode.
+ You can now use the `r_WaterReflections` console variable to toggle water reflections.
+ Divide-by-zero no longer stops working when you use supersampling and set the renderer width or height to **0**.

## Lmbr.exe<a name="lmbr.exe-fixes-v1.15"></a>

Error messages no longer appear when you execute available commands.

## Lumberyard Editor<a name="lumberyard-editor-fixes-v1.15"></a>

Lumberyard Editor has the following fixes:
+ The deprecated **Cover** parameter has been removed from the **Generation** window in the **Terrain Editor**.
+ Lumberyard Editor no longer stops working when you double-click **Assign Splat Map** in the **Terrain Texture Layers** tool and a layer is not selected.
+ The vegetation system now uses LOD 4 and LOD 5 correctly. Previously the vegetation system used LOD 0 and LOD 1, which impacted performance.
+ Lumberyard Editor no longer stops working if you use the `r_ShowRenderTarget` console variable to view a temporary render target, and then exit game mode.
+ Lumberyard Editor no longer stops working when you update vertex and index buffers.
+ Lumberyard Editor no longer stops working when you write to a constant buffer and attempt to map a sub-resource.
+ Lumberyard Editor no longer stops working when you delete the unnamed macro in the **Configure ToolBox Macros** window. To configure your macros, choose **Game**, **Debugging**, **Configure ToolBox Macros**.
+ The **Entity Outliner** is no longer in preview mode. The Preview label has been removed from the title bar.
+ The **Select Current Layer** button no longer appears in the editor toolbar. To use this option, you must enable the CryLegacy gem.
+ Lumberyard Editor no longer stops working when you set the `r_Stats` console variable to **1**.
+ You can now use `AzQtComponents` to explicitly set the Windows SDK version to use. This will reduce compiler issues for certain projects.
+ The news feed in the **Welcome to Lumberyard** window no longer interferes with the ability to close the window.
+ Lumberyard Editor no longer stops working when you exit game mode on the StarterGame map.
+ The **Console** log no longer erroneously reports hardware changes.
+ Lumberyard Editor no longer stops working when you repeatedly press the **Esc** key to close the **Legacy Entities Detected** window. This issue occurred when opening the Fur\_Technical\_Sample and Advanced\_RinLocomotion levels.
+ New projects are no longer missing the `grey.dds` file, which is located in the `/lumberyard_version/dev/Engine/EngineAssets/Textures` directory.
+ The **Ctrl\+Z** keyboard shortcut now works properly.
+ You can now reset the viewport to the default view.
+ Lumberyard Editor no longer stops working when you exit the **Select Color** window for the color picker tool.
+ Error messages no longer appear when you load a level that is missing assets from the **Welcome to Lumberyard** window.
+ Keyboard shortcuts now work as expected. Previously they did not work in the editor if the **UI Editor** or **Script Canvas** editor were open. They also did not work in the **Material Editor**.
+ The **Console** window now shows more detailed error messages for missing scripts.
+ The editor title bar no longer shows the level name after you close a level.

## Lumberyard Setup Assistant<a name="lumberyard-setup-assistant-fixes-v1.15"></a>

The Lumberyard Setup Assistant has the following fixes:
+ The MBCS MFC Library for Visual Studio 2015 is no longer required to use Lumberyard.
+ You can click **Install all** on the **Install required SDKs** tab to download and install all required SDKs.

## macOS<a name="macos-fixes-v1.15"></a>

macOS has the following fixes:
+ Lumberyard Editor no longer stops working when you change the layout to one that has more than one viewport.
+ All **Animation Editor** tools and windows on macOS now work as expected.

## Mobile<a name="mobile-fixes-v1.15"></a>

Orientation changes that are based on sensor data now work correctly on Android and iOS devices.

## Networking<a name="networking-fixes-v1.15"></a>

The networking system has the following fixes:
+ GridMate packets are now stamped with the time that the change occurred.
+ Amazon GameLift now accepts eight clients as expected.
+ Multiple clients can now connect to a MultiplayerSample host (dedicated server or launcher) and play the game without any issues.
+ The `MultiplayerSampleLauncher_Server.exe` no longer stops working when you enter the `mpdisconnect` command in the server launcher while two or more clients are connected.
+ `GridMember::OnKick` no longer stops working if a kick message is received when the host has already closed the session.
+ The client can now find and connect to a server, even if no default value is provided.
+ The `LightningArcComponentNotificationBus` now notifies only the entity that had an effect triggered.

## Script Canvas<a name="script-canvas-fixes-v1.15"></a>

Script Canvas has the following fixes:
+ The source pin text for the following nodes is now corrected: **Get Forward**, **Get Right**, and **Get Up**.
+ The **Script Canvas** editor no longer stops working when you quickly move the pointer between editable property fields.
+ The **On Graph Start** node now executes the **On Entity Activated** node.
+ The backtracing system in Lua has been updated to prevent system tick events from being sent during startup. Previously the tickbus would start ticking early. If a UI element, such as a dialog box, popped up then the half-initialized systems would begin to receive tick events.
+ You will no longer see an error when you use the same Script Canvas reference to spawn multiple entities.
+ A default value is now selected for Script Canvas variables that have drop-down lists.
+ Lumberyard Editor no longer stops working when you use the Cloud Canvas **Get** nodes.
+ The door now closes correctly in the ScriptCanvas\_Basic\_Sample level.
+ The **Open Recent** list now includes Script Canvas graphs that were opened from a Script Canvas component.
+ You can now batch convert folders with assets other than `.scriptcanvas` files.
+ Levels now remain stable even when a particle effect reference in Lua is triggered before a level is unloaded.
+ The console now shows a message if a **Set Variable** node does not have a data connection.
+ When you right-click a Script Canvas node and choose **Delete Node**, the node information is now removed from the **Node Inspector**.
+ The **Script Canvas** editor no longer stops working when you save your graph.
+ The `AZ_EBUS_BEHAVIOR_BINDER_WITH_DOC` macro now applies pin labels to a node.
+ The **Get** and **Set** nodes now have property fields that you can edit.
+ The **Set** nodes now pass their values and elements as output on the right side of the node.
+ Lumberyard Editor no longer stops working when you edit the vector, entity ID, or quaternion values for Script Canvas nodes.
+ The **Node Inspector** no longer shows two collapsible titles for the node information.
+ The **View** menu now shows the visible status of the **Variable Manager**.
+ If you attempt to edit a Lua file that is not checked out, you will now be prompted to check out the file before you can edit.
+ The **Script Canvas** editor no longer stops working after using it for hours.
+ **Math** nodes are now grouped together in the **Node Palette**.
+ Lumberyard Editor no longer stops working when you add or undo numerous comment nodes.
+ Lua assets are now checked out properly from Perforce.

## Starter Game<a name="starter-game-fixes-v1.15"></a>

The Starter Game level has the following fixes:
+ Legacy designer objects have been converted to Lumberyard entities.
+ You can now run the Starter Game level on macOS with XCode in debug mode.
+ The Starter Game level no longer stops working when you perform tight turns, such as motion turns or tight weaving turns.
+ The legacy animation tools are enabled by default.
+ Lumberyard Editor no longer stops working when you exit game mode after seeing the **Mission: Failed** screen.

## UI Editor<a name="ui-editor-fixes-v1.15"></a>

The UI Editor has the following fixes:
+ The character spacing units for the **UiText** component has been corrected to 1/1000 of ems, where 1 em is equal to font size. This fix affects any **UiText** component that uses the **Character Spacing** setting.
+ When `UiSpawnerComponent::OnEntityContextSliceInstantiated` is executed, you will now receive a notification for each slice that is spawned.
+ The UI slider now rounds to the next step as expected.
+ You can now load levels that have UI canvases that render to texture. The `CreateDepthSurface` method has been updated to use the correct thread for render context. The `FX_CreateDepthSurface` member has also been removed.

## Miscellaneous<a name="miscellaneous-fixes-v1.15"></a>

Lumberyard has the following miscellaneous fixes:
+ Memory leaks were fixed for the `terrain_node_compile.cpp` and `terrain_sector.h` files.
+ The `export_all_levels` Python script now works.
+ The resource compiler no longer stops working when you add or modify the **Blend Shapes Modifier**.
+ Deserializing a vector now clears previous elements.
+ You can now build win\_x64\_vs2017\_profile and win\_x64\_vs2015\_profile\_test as expected.
+ The `lmbr_create.log` file is now created after you build an external game project.
+ The `AssetCatalog::GetDirectProductDependencies` test now returns the correct dependencies for the queried product only.
+ When you add an external layer from the **Layers** tab in the **Rollup Bar**, a `devassets` folder no longer appears erroneously in the `dev` directory.
+ Clicking the **x** button in the dedicated server window now shuts down the engine cleanly.