# Fixes<a name="lumberyard-v1.13-fixes"></a>

Lumberyard Beta 1.13 resolves earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [AI](#ai-fixes-v1.13)
+ [Animation Editor](#animation-editor-fixes-v1.13)
+ [Android](#android-fixes-v1.13)
+ [Asset Pipeline](#asset-pipeline-fixes-v1.13)
+ [Cloud Canvas](#cloud-canvas-fixes-v1.13)
+ [Component Entity System](#component-entity-system-fixes-v1.13)
+ [iOS](#ios-fixes-v1.13)
+ [Lmbr.exe](#lmbr.exe-fixes-v1.13)
+ [Lumberyard Editor](#lumberyard-editor-fixes-v1.13)
+ [Lumberyard Setup Assistant](#lumberyard-setup-assistant-fixes-v1.13)
+ [macOS](#macos-fixes-v1.13)
+ [Physics](#physics-fixes-v1.13)
+ [Project Configurator](#project-configurator-fixes-v1.13)
+ [Scripting](#scripting-fixes-v1.13)
+ [Starter Game](#starter-game-fixes-v1.13)
+ [Terrain](#terrain-fixes-v1.13)
+ [Track View](#track-view-fixes-v1.13)
+ [Miscellaneous](#miscellaneous-fixes-v1.13)

## AI<a name="ai-fixes-v1.13"></a>

The editor no longer stops working if you attempt to modify the `Navigation.xml` file using improper values.

## Animation Editor<a name="animation-editor-fixes-v1.13"></a>

The Animation Editor has the following fixes:
+ The editor no longer stops working when you select the **Character** layout.
+ The editor no longer stops working if you attempt to close multiple instances of a tool pane.
+ Error messages now display as expected.
+ Saving animation graphs now works properly.
+ You can now run integration tests on the `profile_test` configuration while the **EMotionFX** gem is enabled for your project. Previously the **Animation Editor** would not initialize.
+ Animations in the **Blend Space 1D** and **Blend Space 2D** nodes now restart properly. Previously the animations would loop.
+ In the Advanced\_RinLocomotion level, the Rin character now moves properly. Previously the animation graph was set up so that she turned left when she should have continued moving forward when switching from an idle state.
+ When you save a motion set, it now remains the selected option in the **Motion Set** drop-down menu.
+ In the Simple\_RinLocomotion level, the Rin character now runs as expected when you press and hold the right trigger.
+ When you add event tracks to the **Time View** pane, the window no longer resizes vertically.
+ You can now close the **Animation Editor** window prior to closing the **Preferences** window. Previously this sequence prevented you from opening the **Preferences** window again.
+ You no longer need to select an animation graph in order to save a workspace.
+ If you attempt to play a motion without an actor file open, you will now see a descriptive error message.
+ If you include multiple event presets with the same name in your motion event presets configuration file, all preset names now appear in the **Animation Editor**. Previously the duplicate names did not appear.
+ When you create `.actor` files from `.fbx` files, the files now successfully import.
+ The **Smoothing** node no longer outputs unexpected values when the interpolation speed is set to 0.
+ You can no longer erroneously attach a component to itself. Previously an entity with the **Actor** component could target itself as the attachment.
+ The translation gizmo now shows the correct values. Previously the gizmo always showed 0,0,0.

## Android<a name="android-fixes-v1.13"></a>

Modified assets are now copied as expected when deploying to a device.

## Asset Pipeline<a name="asset-pipeline-fixes-v1.13"></a>

The Asset Pipeline has the following fixes:
+ The asset builder `.dll` no longer stops working when more than one builder `.dll` has been loaded.
+ The event log now shows the correct job IDs.
+ The **Asset Processor** can now receive keyboard input on macOS.
+ The **Asset Processor** no longer returns an error message when you enable a gem for your project.
+ Any files that were not processed successfully now remain in the **Asset Browser** for you to process again.
+ The **Resource Compiler** no longer stops working when you save a non-power of 2 `.tif` file with incompatible presets.

## Cloud Canvas<a name="cloud-canvas-fixes-v1.13"></a>

Cloud Canvas has the following fixes:
+ You can now delete deployments as expected on the CustomServiceAPI.
+ The AWS Behavior Examples level now displays text that is consistent with the Lumberyard tools.
+ If you attempt to disable a gem that is not enabled, you will now see information about the gem's state.
+ You can no longer use the command line tool to erroneously create a gem with the same name as an existing gem. Gem names must be unique.
+ You can no longer add a leaderboard with an invalid name.

**Cloud Gem Portal**
+ If you use Firefox, you can now remove intents from bots as expected.
+ You can now search for player names as expected.
+ You can no longer type alphabetic characters into the hours (HH) or minutes (MM) fields.
+ The refresh icon now works as expected.
+ A confirmation dialog box now appears when you attempt to delete multiple speech lines.
+ If you use the Text-to-Speech cloud gem, applying an Any filter without selecting any tags will now return all results.

**Resource Manager**
+ A file that is checked out now automatically refreshes so that you can edit the file as expected.
+ Resources are now added as expected after checking out the `resource-template.json` file.
+ If you use Perforce and it is misconfigured, you will now see an error report if the **Resource Manager** cannot complete an operation.

## Component Entity System<a name="component-entity-system-fixes-v1.13"></a>

The component entity system has the following fixes:
+ The **Minimum spec** parameter now works properly for the **Water Volume** component.
+ When you rotate an entity, the manipulator lines now rotate with the manipulator arrows as expected.
+ The editor no longer stops working if you have invalid slice files.
+ If you undo a change to a child entity, the entity will no longer move higher in the list in the **Entity Outliner**.
+ Dragging a parent-child hierarchy onto an entity no longer breaks the original parent-child hierarchy.
+ Root entities no longer have "(Entity not found)" as the parent entity.
+ In the **Entity Inspector**, you can now see the **Push to slice** menu option when you right-click a component.
+ In the **Entity Outliner**, you can now move parent and child entities under a root entity without breaking the existing hierarchy.
+ The filtering feature in the **Entity Outliner** now works as expected.
+ In the **Entity Outliner**, the following filter options now work as expected:
  + Behavior Tree
  + Navigation
  + Motion Parameter Smoothing
  + Audio Proxy
  + Camera Rig
  + Fly Camera Input
  + Input
  + Simple State
  + Spawner
  + Network Binding
  + Character Physics
  + Mesh Collider
  + Primitive Collider
  + Ragdoll
  + UI Canvas Asset Ref
  + UI Canvas Proxy Ref
  + UI Canvas on Mesh
+ In the **Entity Outliner**, choosing **Clear** now removes all filters as expected.
+ You can no longer use the percentage (%) character in entity names.
+ The editor no longer stops working if you revert changes to a slice that includes containers, such as vectors or lists.
+ When you clear an asset reference from the property grid, the asset no longer loses the assigned type.
+ The editor no longer stops working if you attempt to open the legacy outliner when component entities are in your level.
+ You can now use the arrow keys to increase the Z values on the coordinates bar. This can now be done when you select parent or world coordinates while rotating multiple entities.
+ You can no longer create multiple slices using invalid hierarchies or if slice names are missing.
+ The editor no longer stops working when you edit the **Surface Cell Size** and **Sleep Threshold** parameters for the **Water Volume** component.
+ Lens flare components no longer reset to the first flare in the library when you switch from game mode to edit mode.
+ Geometry cache components no longer experience rendering issues after you modify the **Max View Distance** parameter.
+ Geometry caches no longer play on start only.
+ When using the **Infinite Ocean** component, the view below the 0 Z coordinate is now properly obscured and the ocean appears darker based on the depth of the ocean.

## iOS<a name="ios-fixes-v1.13"></a>

iOS has the following fixes:
+ Gamepads are no longer assigned an incorrect index.
+ The Multiplayer Sample map no longer experiences rendering issues that affect how the level displays.

## Lmbr.exe<a name="lmbr.exe-fixes-v1.13"></a>

The `Lmbr.exe` command line tool has the following fixes:
+ The `Lmbr.exe` tool no longer stops working if the `user_settings.options` file is invalid.
+ You can now use the `Lmbr.exe` tool to switch projects, even without Perforce installed and configured.
+ You can now use the `Lmbr.exe` tool to create an external game project and launch the editor.

## Lumberyard Editor<a name="lumberyard-editor-fixes-v1.13"></a>

Lumberyard Editor has the following fixes:
+ When you save a level, it is now added to the **Open Recent** list.
+ If you attempt to import a `.crate` file using the **File Importer**, you will now see feedback if the import was unsuccessful.
+ Entries are no longer clipped in the **Asset Editor** for input bindings.
+ The **Tools**, **Lua Editor** menu option now launches the **Lua Editor** as expected.
+ You can now interact with the DDS preview overlays in the **Rollup Bar**. Previously the hovering overlay disappeared if you moved the pointer off the control that displayed the overlay.
+ Camera lists in the **Rollup Bar** now refresh properly when you create a new camera.
+ When you double-click a title bar, the window now maximizes and minimizes properly.
+ Setting the Windows taskbar to auto-hide no longer causes unexpected interactions with Lumberyard windows.
+ The reset functionality now works properly for certain sliders in the **Rollup Bar**. This includes the fog view distance, sun shadows clip plane range, and moon latitude.
+ The Python command `general.unload_all_plugins()` has been removed. This command is not supported.
+ The **Animation Editor (EMotion FX)** no longer erroneously displays a double title bar.
+ The editor no longer stops working when you open an animation using the legacy animation system.
+ If you right-click the title bar on the welcome screen, the correct menu options now display.
+ The editor no longer stops working if you create a level path that is 260 characters.
+ If you undock panes from the **Particle Editor**, the undocked panes no longer remain open after you close the **Particle Editor**.
+ The editor now continues loading a level, even if Lumberyard is not the active application on Windows.
+ The window pane size has been improved when loading Lumberyard Editor for the first time on a new computer.
+ You can now open multiple error report files in Excel without receiving a warning message.
+ You should no longer experience issues using Synergy peripherals to control Lumberyard Editor.
+ If you right-click the title bar on the **Import Assets** window, the correct menu options now display.
+ The cursor no longer defaults to the end of the event name field when you edit the input bindings.
+ The **Game**, **AI**, **View Agent Type** menu option has been updated to clarify that the suboption is the agent type to visualize with the AI debugger.
+ The editor no longer stops working when you modify a material in the code and then exit game mode.
+ Material files (`.mtl`) no longer disappear after you use the **Material Editor**.
+ To resolve material conflicts, `.fbx` files now write a `.dccmtl` file to cache instead of a `.mtl` file.
+ The editor no longer stops working when you use the **Add Vegetation Object** menu to add an entity to the viewport.
+ You can now set fog volume attributes, such as density, with more precision. This allows you to better refine the look of fog volume.
+ You can now set time of day parameters, such as fog density and shadow bias, with more precision.
+ The editor no longer stops working if vegetation painting occurs outside of the heightmap boundary.
+ The editor can now launch successfully when the default project is set to CloudGemSamples.
+ The editor no longer stops working when you choose **Undo Checkout** in the **Dialog Editor** after renaming a dialog.
+ A graphical artifact has been fixed. The artifact occurred when the sky reflection was incorrect and volumetric fog was enabled.
+ A race condition has been fixed. The race condition created a flashing red texture or the editor to crash if volumetric fog was enabled.
+ The editor no longer stops working if you place the camera manager (`camera_manager.slice`) in the viewport and then press **Ctrl\+G** to enter game mode.

## Lumberyard Setup Assistant<a name="lumberyard-setup-assistant-fixes-v1.13"></a>

Lumberyard Setup Assistant has the following fixes:
+ The Setup Assistant no longer stops working on macOS when you select **Compile for Android devices** or **Compile for iOS devices**.
+ The installation path for the Android SDK executable now displays correctly.

## macOS<a name="macos-fixes-v1.13"></a>

macOS has the following fixes:
+ The opening cinematic for the Starter Game sample now displays properly on macOS.
+ A stack overflow crash no longer occurs when running a profile on macOS.
+ Gamepads are no longer assigned an incorrect index.

## Physics<a name="physics-fixes-v1.13"></a>

The physics system has the following fixes:
+ The PhysX Mesh tooltips now adjust according to the screen size.
+ The editor no longer crashes when you use triangular meshes on dynamic PhysX rigid bodies.

## Project Configurator<a name="project-configurator-fixes-v1.13"></a>

The Project Configurator has the following fixes:
+ Choosing **Advanced Settings** now opens the advanced configuration window as expected.
+ The application no longer stops working if you change the configuration from **Editor** to **Game** in the advanced configuration window.
+ You are now notified if a gem is missing for a particular sample project or level, and directed to the **Project Configurator** to enable the gem.

## Scripting<a name="scripting-fixes-v1.13"></a>

Scripting has the following fixes:
+ The LuaIDE process now ends immediately when the Lua Editor closes.
+ The editor no longer stops working when you remove a spline variable node.
+ Nodes that are added to a blank canvas no longer appear erroneously outside of the viewport.
+ The **Set Color Chart** node is no longer missing an **Out** pin.
+ You can now access the `SetColorChart` function in Lua. Previously you could only access this function in **Script Canvas**.

## Starter Game<a name="starter-game-fixes-v1.13"></a>

The Starter Game sample has the following fixes:
+ You can now toggle the grenade launcher after acquisition.
+ The player no longer freezes after activating the first array.
+ The player no longer triggers the hard landing animation after each jump.
+ Duplicate entity IDs that caused asserts have been removed from the Starter Game sample.

## Terrain<a name="terrain-fixes-v1.13"></a>

The terrain tools have the following fixes:
+ The **Terrain Texture Layers Editor** menu option now opens the correct tool. Previously this menu option opened the **Terrain Editor** tool.
+ The editor no longer stops working when you open the **Export/Import Megaterrain** tool with a large amount of tiles.
+ The editor no longer stops working when you change the unit size and a level is not loaded.
+ Terrain texture files now load properly when you create a new level.
+ You can now use the slider to set the maximum value for the **Outside Radius** and **Inside Radius** parameters.
+ In the **Terrain Texture Layers Editor**, the menu bar no longer disappears when you resize the window to the minimum height.
+ An assertion fail error no longer occurs when you set the depth value to 0 for decals that have a projection type set to **On Terrain and Static Objects**.

## Track View<a name="track-view-fixes-v1.13"></a>

The **Track View** editor has the following fixes:
+ The editor no longer stops working when you delete a sequence.
+ The editor no longer stops working when you do the following: create an object entity sequence (legacy) that contains a **Director** node, undo the create action, redo the create action, and then select the sequence.
+ Animation splines are no longer removed from the viewport when you associate animated entities with new parent entities.
+ The viewport now updates properly to display sequences at higher resolutions.

## Miscellaneous<a name="miscellaneous-fixes-v1.13"></a>

Lumberyard has the following miscellaneous fixes:
+ The `DestroyEntity` method that takes entity IDs has been renamed to `DestroyEntityById`.
+ `IRenderAuxGeom::Draw2dLabel` no longer uses undefined color data.
+ `AZStd::list::list(std::initializer_list<T> list)` now properly sets the `m_numElements` member variable to 0.