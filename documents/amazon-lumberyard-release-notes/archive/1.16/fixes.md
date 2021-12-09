# Fixes<a name="lumberyard-v1.16-fixes"></a>

Lumberyard Beta 1.16 resolves earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [Animation Editor](#animation-editor-fixes-v1.16)
+ [Asset Browser](#asset-browser-fixes-v1.16)
+ [Cinematics](#cinematics-fixes-v1.16)
+ [Cloud Canvas](#cloud-canvas-fixes-v1.16)
+ [Component Entity System](#component-entity-system-fixes-v1.16)
+ [GitHub Pull Requests](#github-pull-requests-fixes-v1.16)
+ [Graphics](#graphics-fixes-v1.16)
+ [Lumberyard Editor](#lumberyard-editor-fixes-v1.16)
+ [Lumberyard Setup Assistant](#lumberyard-setup-assistant-fixes-v1.16)
+ [Networking](#networking-fixes-v1.16)
+ [Starter Game](#starter-game-fixes-v1.16)
+ [UI Editor](#ui-editor-fixes-v1.16)
+ [Miscellaneous](#miscellaneous-fixes-v1.16)

## Animation Editor<a name="animation-editor-fixes-v1.16"></a>

The **Animation Editor** has the following fixes:
+ Lumberyard Editor no longer stops working when you change an anim graph's parameter's type from **Group** to another type, that has at least one parameter assigned to it.
+ Lumberyard Editor no longer stops working when you press **Ctrl** \+ **Z** while dragging a connector from a recently created node.
+ Lumberyard Editor no longer stops working when you change a motion set to the **Select a motion set** option with the connector selected in an anim graph.
+ Lumberyard Editor no longer stops working when you change the **Sync Mode** value from **Disabled** within the **Blend Space** node.
+ Lumberyard Editor no longer stops working when you click on a 2D **Blend Space** node.
+ Lumberyard Editor no longer stops working after you add motions with a value of `0.0` for the **X** and **Y** parameters while the anim graph is active.
+ Lumberyard Editor no longer stops working when you open a workspace with an anim graph file that is saved outside of the game project's folder.
+ Lumberyard Editor no longer stops working when you browse the action history during recording after you load a motion set and create an anim graph.
+ Lumberyard Editor no longer stops working when you drag a motion from the **Action History** tab while the motion set is loading.
+ Lumberyard Editor no longer stops working while loading an anim graph file after you choose **Activate anim graph** in the **Action History** tab.
+ Lumberyard Editor no longer stops working when you open an actor file, choose the record button, and then load a second actor file.
+ Lumberyard Editor no longer stops working when you press and hold **Ctrl** \+ **Shift** and then click inside an anim graph.
+ Lumberyard Editor no longer stops working when you load an actor, enable wireframe rendering, and then enable or disable render options.
+ Lumberyard Editor no longer stops working when you specify a motion set with a hierarchy for the **Anim Graph** component.
+ Lumberyard Editor no longer stops working when you select a motion set and keep clicking the **\+** icon to add multiple motion sets.
+ When opening the actor files, `jack_idle_ZUp.fbx` and `jackbind_zup.fbx`, the actors appear correctly with full body and standing straight.
+ Build errors for `FbxTangentStreamImporter.cpp` and `FbxBitangentStreamImporter.cpp` no longer appear.
+ Morph targets no longer trigger simultaneously on multiple actor instances.
+ Memory consumption and HPHA allocator memory fragmentation is reduced.
+ Input delay produced by tick ordering between animations and physics is reduced.
+ Blending motions appear correctly with the **Full Clip Based Sync** option enabled.
+ In the **Vector3** gizmo parameter, the **Make Default Value** option now correctly resets the parameter value.
+ The same normal map used for a skinned (actor) and static (mesh) object now appear correctly.
+ While recording, the value for the **Weight** parameter in a node retains the value that you specify. The value no longer fluctuates during recording. 

## Asset Browser<a name="asset-browser-fixes-v1.16"></a>

The **Asset Browser** has the following fixes:
+ Folders and assets that you delete no longer appear in the **Asset Browser**.

## Cinematics<a name="cinematics-fixes-v1.16"></a>

The cinematics system has the following fixes:
+ Lumberyard Editor no longer stops working when you import a legacy camera entity to the **Track View** editor timeline.
+ Lumberyard Editor no longer stops working if you right-click and choose **Delete** for a sequence that refers to itself.
+ Lumberyard Editor no longer stops working if you edit the keyframe for **Motion** track in a track view sequence and then press **Ctrl \+ Z** and **Ctrl \+ Shift \+ Z** to undo and redo the change.
+ Lumberyard Editor no longer stops working if you change parameters in the **Edit Sequences Properties** dialog box and then press **Ctrl \+ Z** and **Ctrl \+ Shift \+ Z** to undo and redo the change.
+ Lumberyard Editor no longer stops working when Batch is cleared or removed during rendering in the **Track View** editor.
+ Lumberyard Editor no longer stops working when you try to delete a track view sequence in game mode. The **Track View** editor can only be accessed in editor mode.
+ Character animations in a track view sequence no longer start from a t-pose when playing the animation.
+ For a **Motion** track, the **Time Scale** property in a keyframe now correctly plays the animation speed that you specify.
+ Only one **Simple Motion** component can be added to an entity.
+ Improved performance in Lumberyard Editor when importing a complex FBX camera animation into a track view sequence.
+ Unit tests no longer hang at shutdown.
+ When you add a component entity to a track view sequence, replacing a component with an incompatible component no longer causes data loss.
+ In game mode, the effect of the **NearClipDistance** track no longer ends right after the last key. It remains active until the end of the sequence.
+ In the **Track View** editor, specifying a second **Director** node as the active director no longer uses the first **Director** node's tracks. The **Director** node that is active will use the tracks specified.
+ You can now blend animations in the a track view sequence with the **Blend In Time** and **Blend Out Time** properties.
+ When you right-click a track view sequence, the **Import FBX File** and **Export FBX File** menu options are removed.
+ The **Track View** editor no longer adds default values to existing tracks when you create a single **Position**, **Rotation**, or **Scale** track from a **Transform** component.
+ In the **Track View** editor, a warning dialog box appears if you set the **Render Output** to a custom resolution of 8000x8000.
+ The last frame in a track view sequence renders correctly from the correct camera if the sequence has more than one **Director** node.
+ The color picker in the **Track View** editor now updates in real time when you choose a color.
+ Disabling the **DepthOfField** node now disables the effect immediately while the sequence is selected.
+ Moving multiple keys together in the **Track View** editor timeline now move correctly as a group.
+ The **Audio Trigger** component attached to an entity now plays correctly in a track view sequence that has a **Motion** track.
+ In the **Track View** editor, the first key added to the **Curve Editor** no longer disappears when you move or add another key to the same track.
+ In the **Track View** editor, key selection no longer switches back to a previously selected key in the **Curve Editor**.
+ You can add entities with the same name to a track view sequence. Entities appear in the sequence with incremented names (for example, **Entity1**, **Entity1-2**, **Entity 1-3** and so on).
+ When you reload a level, a track view sequence with two **Director** nodes opens with the correct **Director** node that is active. The sequence no longer defaults to the first node.
+ Duplicate sub-expressions of the – operator have been removed from the `EntityNode.cpp` file.
+ Entities referenced by a track view sequence in a slice no longer have their tracks temporarily disconnected after pushing changes to the slice.
+ Pressing **Ctrl \+ Z** to undo the creation of a **Comment** node will undo the action instead of the two previous actions.
+ The **Sequence Camera** button in the play speed options of the **Track View** editor is moved to the **Viewport Camera Selector** menu.
+ When you disable nodes and track view sequences, the changes are visible in the viewport.
+ Disabled components on an entity are also disabled from the corresponding node in a track view sequence.

## Cloud Canvas<a name="cloud-canvas-fixes-v1.16"></a>

Cloud Canvas has the following fixes:
+  On the Defect Reporter Cloud Gem Portal **Client Configuration** tab, the **Text** field type no longer accepts a negative value for the **Character Limit** property. 
+ On the Game Metrics Cloud Gem Portal **REST Explorer** tab, the input boxes now align correctly when **/dashboard/\{facetid\}** is selected for **Path** and **Post** is selected for **Verb**.
+ When the **CloudGemMetric** resource group is disabled in Resource Manager, `CloudGemSamplesLauncher.exe` is run, and a level is opened in Lumberyard Editor, a CrySystem Initialization Failed message no longer appears in the game launcher user interface.
+ On the Game Metrics Cloud Gem Portal **REST Explorer** tab, certain path and verb combinations no longer cause type undefined errors in the console or error logs.
+  In the In Game Survey Cloud Gem Portal, pressing the **Export to CSV** option on the **Individual Responses** tab now causes the response to be exported successfully.
+ In the In Game Survey Cloud Gem Portal, slider type survey questions no longer accept characters other than non-negative numbers or non-negative numbers and a single decimal point in the **Minimum Value** or **Maximum Value** fields. 
+ In the Leaderboard Cloud Gem Portal, the **Reservoir Sample Size** setting now saves correctly.
+ In the Text to Speech Cloud Gem Portal, when a new speech line that includes an ampersand (&) or less than (<) character is saved and **Preview** is pressed, an error message no longer displays.
+ All messages sent from the Web Communicator Cloud Gem Portal **REST Explorer** tab now appear in the channel activity logs.
+ POST messages from the Web Communicator Cloud Gem Portal **REST Explorer** tab that are sent using the path 

  `/cloud/send/send/{cognito_id}` no longer display an error and are sent correctly.
+ When five or more profiles are loaded into Credentials Manager and the default profile is changed, a delay no longer occurs in marking the new profile as the default.
+ The `cleanup.cmd` script now ignores global resources if the `--region` parameter is specified. If both the `--region` parameter and the `--delete-global-resources` parameter are specified, global resources such as IAM roles and Amazon S3 buckets are deleted.
+ `CloudGemSamplesLauncher.exe` no longer stops working after you switch levels in Lumberyard Editor.
+ When special characters (\! @ \# $ % & ( ) \[ \]) are passed to `AZ_Warning` (for example, `AZ_Warning("CloudGemFramework", false, "%");`), Lumberyard Editor no longer crashes with the error Invalid parameter detected in CRT function. 

## Component Entity System<a name="component-entity-system-fixes-v1.16"></a>

The component entity system has the following fixes:
+ In the **Simple Motion** component, the **Preview in Editor** property is disabled by default in the viewport.
+ Lumberyard Editor no longer stops working when you try to add an entry to `ReflectedPropertyEditor` when the container is at maximum capacity.
+ Lumberyard Editor no longer stops working when you use shortcuts while using the manipulator to change a shape component, such as a box or spline.
+ The **Spawner** component no longer displays errors in the console when you cancel a slice instantiation by entering and exiting gameplay mode.
+ Components that were missing help icons now point to their documentation page.
+ The **Random Timed Spawner** component now correctly spawns slices in different locations when you specify a **Spawn Delay** time.

## GitHub Pull Requests<a name="github-pull-requests-fixes-v1.16"></a>

The following fixes are based on GitHub pull requests:
+ Based on the pull request from **tkgdhughes**, AZ CameraFramework memory leaks has been fixed. Allocators have been specified and functionality was added to clean up the behaviors that are instantiated by the editor and serialization system.
+ Based on the pull request from **tkgdhughes**, `SharedMemory::IsMapped` has been implemented.
+ Based on a pull request from **tkgdhughes**, fixes a GridMate carrier crash:
  + Fixed DTLS handshake errors.
  + Fixed Multiplayer Sample Component re-use errors.
  + Fixed several crash and assert errors in the networking system, and changed some asserts to errors.
  + Removed UI components from dedicated server to prevent crash.
  + Added nullptr checks in Session management to prevent crash.
  + Fixed issue of WAF throwing a exception when the `show_option_dialog` is used.
  + Fixed race condition between interest chunk descriptor registration/client replica proxy creation.
+ Based on the pull request from **ximura**, GridMate supports removing registered members for voice chat.
+ Based on a pull request from **SSPkrolik**, changing the RGB text values at the top of the color picker in the **Particle Editor** now updates the color correctly.

## Graphics<a name="graphics-fixes-v1.16"></a>

The graphics system has the following fixes:
+ Temporal antialiasing (TAA) sharpening was applied when antialiasing was disabled. Closed TAA sharpening was applied to all antialiasing modes including when antialiasing was disabled. The `r_antialiasingTAASharpening` console variable now only changes the sharpening for TAA (`r_antialiasingMode=3`) and the new `r_antialiasingNonTAASharpening` console variable changes sharpening for all other antialiasing modes (`r_antialiasingMode= 0 – 2`). The new `r_antialiasingNonTAASharpening` console variable defaults to `0`.
+ Shadow caster bounds are now recalculated per light instead of once.
+ `Material.LoadByName` works correctly in Lua.
+ Entities that are near an entity with the **Infinite Ocean** component attached now reflect in the ocean.

## Lumberyard Editor<a name="lumberyard-editor-fixes-v1.16"></a>

Lumberyard Editor has the following fixes:
+ The error report now displays the correct object with every error message.
+ The **FBX Settings** tool no longer stops working when the **Select nodes** dialog box is open and then the **FBX Settings** tool is docked to the Lumberyard Editor.
+ The **Asset Editor** no longer stops working when you edit an `.inputbindings` file that has many **Input Event Groups**.
+ The `/threads` option has been removed from the Resource Compiler.
+ When you choose **File**, **Edit Project**, **Switch Projects or Configure Gems**, Lumberyard Editor now correctly closes and launches the Project Configurator.
+ Using `lmbr.exe`, you can create an external project that has the same name as a project in your engine root directory.
+ Lumberyard Editor no longer stops working when you choose **File**, **Edit Project**, **Deployment Tool** when Android is not configured.
+ In the Project Configurator, for the System Entity Editor, the **Add required components** dialog box is now cropped to fit the screen. You can scroll to view all the components.
+ Performance is improved when you drag an entity's **Transform** component gizmo around the viewport that has many entities.
+ LmbrCentral no longer shows tests are failing when HPHA memory checks are enabled.
+ Memory leaks were fixed in LmbrCentral.
+ When the **Restore Viewport Camera on Game Mode** setting is disabled, the viewport camera's x and y positions and rotations are not restored after switching from game mode to edit mode.
+ When editing a level in Lumberyard Editor, only one frame calculation occurs per system tick.
+ Lumberyard Editor no longer stops working when you undo and redo multiple actions with the **Terrain Tool** and then select an entity.
+ Lumberyard Editor no longer randomly stops working after launching. 
+ Lumberyard Editor no longer stops working when you open a texture file (`.tif`, `.png`, `.jpg`) in the **Asset Browser** with the Resource Compiler.
+ Lumberyard Editor no longer stops working when you create or open a level while the **Layers** panel is open and Perforce is enabled.
+ The setting that you specify for the **Restore Viewport Camera on Game Mode Exit** option no longer reverts when you exit gameplay mode.
+ Attributes in `.met` files generated from a custom build now indicate a custom build.
+ `Editor.exe` no longer keeps running after Lumberyard Editor is closed when switching between gameplay and editor mode on a level with many entities.

## Lumberyard Setup Assistant<a name="lumberyard-setup-assistant-fixes-v1.16"></a>

The Lumberyard Setup Assistant has the following fixes:
+ You can run `setupassistantbatch.exe` to update the `msvs_version` in the `user_settings.options` file.

## Networking<a name="networking-fixes-v1.16"></a>

The networking system has the following fixes:
+ In the Multiplayer Sample, when you connect LAN MPS clients, replicas are correctly constructed and the console doesn't display log spam.
+ In the Multiplayer Sample, memory leaks have been fixed.

## Starter Game<a name="starter-game-fixes-v1.16"></a>

The Starter Game level has the following fixes:
+ Lumberyard Editor no longer stops working when a slice made of each entity is then instantiated in a new level and you then switch to gameplay mode.
+ Lumberyard Editor no longer stops working when you launch the StarterGame level for the first time.
+ The weapon projectile now appears correctly when firing.
+ Starter Game, Multiplayer Sample and Cloud Gem Samples launchers no longer silently stop working when you load a level.
+ For the **Transform** component, non-static transform warnings for parent entities no longer appear in the console when you switch to gameplay mode.
+ Enemies appear correctly and are not longer missing when you switch to gameplay mode.
+ AI now correctly spawns on the Starter Game and Getting Started Guide levels.
+ The **StarterGameLauncher** application no longer stops working after you launch it in release mode.
+ The errors for the missing `Lens_flare1.dds` and `grey.dds` texture files no longer appear in the console when you launch the StarterGame level for the first time.
+ Error pop-up windows no longer appear when you open the Getting Started Guide (GSG) levels.
+ Lumberyard Editor no longer stops working after you enable the `r_AlphaBlendLayerCount` console variable and you have a Nvidia graphics card.
+ Stack trace errors for `ListenToGlobal` and `Property Delay` no longer appear in the console after you defeat the robot holding the blue card.
+ An XML parser warning no longer appears in the console when interacting with the Time of Day example.
+ The `CameraBus` warning for `SetFov` no longer appears in the console when you switch to gameplay mode in the StarterGame level.
+ Rendering warnings for `ScreenFader` no longer appear in the console when you load the StarterGame level in Lumberyard Editor.
+ Serialize stack errors no longer appear in the console when you load the StarterGame level in Lumberyard Editor.
+ Jack no longer appears stuck after completing a jump animation in gameplay mode.
+ Soundbanks are updated to support Wwise LTX 2017.2.2.
+ River foam appears correctly near the edges of the water. 
+ The grenade launcher projectile now correctly fires through the center of the crosshair.
+ An object that displayed the `defaultparticle.dds` file in gameplay mode now appears correctly.
+ In areas where Jack is not standing, the lighting and colors of those areas now appear correctly.
+ Orphan nodes for **Point Light** and **Transform** components no longer appear in the **IntroSequence**.
+ Jack now moves correctly when aiming and moving backwards at the same time.
+ When you instantiate the `CommsArray_jumpUpgrade.slice`, `Interior_auto_doors.slice` or `gun.slice` into a level, the entity now appears in the location of the viewport that you specified.
+ When you instantiate the `building_lrg.slice` and `build_sml.slice` into a level, the entity appears correctly above the terrain.
+ Jack no longer gets stuck in an infinite falling motion when between two crates.
+ Jack's feet now move correctly while firing the weapon and rotating the camera.

## UI Editor<a name="ui-editor-fixes-v1.16"></a>

The **UI Editor** has the following fixes:
+ Lumberyard Editor no longer stops working when you switch to a UI canvas with a slice in which the child element was deleted and pushed to slice in another canvas.
+ Lumberyard Editor no longer stops working when you change languages in the **UI Editor** using the `NotoSans.fontfamily` file.
+ Lua scripts used in a UI canvas are now fully loaded before the canvas activates.

## Miscellaneous<a name="miscellaneous-fixes-v1.16"></a>

Lumberyard has the following miscellaneous fixes:
+ When running a game with the Lua stack checker enabled in the `ScriptContext.h` file, the Lua stack checker no longer displays the incorrect count in the `Properties_NewIndex` net binding.
+ The AZ Code Generator no longer stops working when you specify the same name and description in a custom Script Canvas node.