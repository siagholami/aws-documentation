# Fixes<a name="lumberyard-v1.12-fixes"></a>

Lumberyard Beta 1.12 and 1.12.0.1 resolve earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [Lumberyard Beta 1.12.0.1](#lumberyard-v1.12.0.1-fixes)
+ [GitHub – Customer Contributions](#public-contributions-github-v1.12)
+ [AI](#ai-fixes-v1.12)
+ [Animation Editor](#animation-editor-fixes-v1.12)
+ [Asset Pipeline](#asset-pipeline-fixes-v1.12)
+ [Audio](#audio-fixes-v1.12)
+ [Cloud Canvas](#cloud-canvas-fixes-v1.12)
+ [Component Entity System](#component-entity-system-fixes-v1.12)
+ [Lmbr.exe](#lmbr-exe-fixes-v1.12)
+ [Lumberyard Editor](#lumberyard-editor-fixes-v1.12)
+ [Lumberyard Setup Assistant](#lumberyard-setup-assistant-fixes-v1.12)
+ [macOS](#macos-fixes-v1.12)
+ [Material Editor](#material-editor-fixes-v1.12)
+ [Mobile](#mobile-fixes-v1.12)
+ [Networking](#networking-fixes-v1.12)
+ [Particle System](#particle-system-fixes-v1.12)
+ [Perforce Source Control](#perforce-source-control-fixes-v1.12)
+ [Physics](#physics-fixes-v1.12)
+ [Project Configurator](#project-configurator-fixes-v1.12)
+ [Script Canvas](#script-canvas-fixes-v1.12)
+ [Starter Game](#starter-game-fixes-v1.12)
+ [Substances](#substances-fixes-v1.12)
+ [Track View](#track-view-fixes-v1.12)
+ [Twitch ChatPlay](#twitch-chatplay-fixes-v1.12)
+ [UI Editor](#ui-editor-fixes-v1.12)
+ [Virtual Reality](#virtual-reality-fixes-v1.12)
+ [Miscellaneous](#miscellaneous-fixes-v1.12)

## Lumberyard Beta 1.12.0.1<a name="lumberyard-v1.12.0.1-fixes"></a>

Lumberyard Beta 1.12.0.1 includes the following fixes:
+ Lumberyard 1.12 supports creating your game project directory outside of the Lumberyard engine directory. This approach makes it easier to work with multiple game projects and to upgrade the engine version for your game project. Lumberyard 1.12.0.1 adds an `external_manifest.txt` file that is required for you to create the external game project directory.

**To create an external game project directory**

  1. Run `Lmbr.exe` from the `\lumberyard_version\dev\Tools\LmbrSetup\Win` directory.

  1. In `Lmbr.exe`, run the following command: `lmbr.exe projects create [name] -target-folder [target path] -template [template]`

     Where:
     + *\[name\]* is the name of the game project
     + *\[target path\]* is the location of the project directory
     + *\[template\]* is the template to optionally use for your game project

     If you do not specify a value for *\[template\]*, `EmptyTemplate` is used by default.

     For example, to create a game called MyGame that is based on the Default Template in the `C:\projects\MyGame` directory, enter the following: `lmbr.exe projects create MyGame -target-folder c:\projects\MyGame -template DefaultTemplate`
+ Lumberyard 1.12.0.1 fixes a linker error that prevented external game projects from building successfully.
+ The Lumberyard Setup Assistant now installs all of the necessary third-party SDKs and extensions that are required to successfully build an external project. Previously the necessary glew files were missing.
+ The correct **Asset Processor** is now launched from an external project. Assets are now properly processed and Lumberyard Editor launches without any issues.
+ A missing `FTUE_heightmap_Test.tif` file is now included in the `/lumberyard_version/dev/StarterGame/Textures/Heightmaps` directory.

## GitHub – Customer Contributions<a name="public-contributions-github-v1.12"></a>

The Amazon Lumberyard team thanks the following Git users for their contributions:
+ **alex-leleka** for submitting an error log fix to properly encode and display the asset file name when a missing `.psd` file is reported.
+ **LatzekLat** for submitting a fix to check `project_id` if the value is unassigned.
+ **Leafnsand** for submitting materials for LOD geometry.
+ **marynate** for submitting a change to the encoding of the EBus.h file to UTF-8. This prevents compile errors on Windows with a Chinese, Japanese, and Korean (CJK) code page.

## AI<a name="ai-fixes-v1.12"></a>

AI has the following fixes:
+ Selecting or moving a navigation area no longer results in asserts.
+ Execution no longer fails when you call the `FindPathToEntity()` method immediately after receiving the `OnTraversalComplete()` notification.

## Animation Editor<a name="animation-editor-fixes-v1.12"></a>

The Animation Editor has the following fixes:
+ Stability issues have been addressed.
+ The editor no longer stops working when you move the slider for the **TargetStrength** parameter.
+ Blend space data is no longer removed after you add a motion to a motion set and then save.
+ The attachment component on an actor now works properly in game mode.
+ The **Recorder** feature in the **Animation Editor** stops recording as expected when you close the editor.
+ The editor no longer hangs upon close when you have an entity with an actor component selected.
+ The editor no longer stops working when you delete an animation graph node within a state machine.
+ Blend space nodes now output duration, play time, sync tracks, and more. This information is required to perform synchronizations.
+ The **File** menu now appears and works as expected.

## Asset Pipeline<a name="asset-pipeline-fixes-v1.12"></a>

The Asset Pipeline has the following fixes:

**Asset Browser**
+ Lumberyard Editor no longer becomes unresponsive if you use the **Asset Browser** to open a directory with thousands of assets.
+ The **Origin** rules for **Physics** and **Static Mesh** now function as expected for all assets.
+ When you drag assets into the **Entity Inspector**, the assets are now added as **Mesh** components only. Previously the assets were added as both **Decal** and **Mesh** components.
+ When you drag Lua assets into the **Entity Inspector**, duplicate Lua components are no longer added to the entity.
+ The editor no longer stops working if you drag assets from the **Asset Browser** into the viewport and then undo this action.
+ The directory name for the current project now displays the project name. Previously **Game** was used to represent the current project.
+ The editor no longer stops working if you right-click the **Game** directory in the **Asset Browser**.
+ The context menu now displays the Perforce plugin options. You must enable the **Perforce** component to use this functionality.
+ You can now overwrite the `.inputbindings` files.
+ Generic icons are now displayed for all file types.
+ The hierarchy of expanded and collapsed folders is now maintained if you close and then reopen the tool.
+ You can no longer erroneously drag `.xml` files (or other unsupported file types) into the viewport or **Entity Inspector**.
+ The **Open** option now appears as expected in the **Asset Browser** context menu.
+ The **Asset Browser** now updates properly to reflect the state of the assets.
+ When you right-click an asset type in the **Asset Browser**, the asset file opens in the appropriate editor.

**Asset Editor**
+ The **Asset Editor** now displays information about the open asset.
+ The **Revert** button has been removed from the create input binding asset workflow.
+ The editor no longer displays error messages nor stops working if you attempt to save files that do not exist.

**Asset Processor**
+ The **Asset Processor** no longer stops working if you attempt to import an `.fbx` file with empty materials. Error and warning messages appear instead.
+ The **Asset Processor** can now successfully process `.png` and `.tif` files.
+ The **Asset Processor** no longer stops working if you attempt to process numerous files simultaneously.
+ The **Material Editor** and Lumberyard Editor are no longer unresponsive while the **Asset Processor** is processing assets.
+ Assets are now processed for the specified operating system only.
+ The **Asset Processor** no longer impacts a build finishing successfully.
+ The **Asset Processor** no longer exits silently if there is a duplicate UUID in the serialize context.
+ Assets are now copied and processed as expected.
+ Asset logs now update to remove a failed asset line when the asset is removed from the project.
+ Network traffic no longer affects the **Asset Processor's** ability to process asset files.
+ Error and warning messages can now expand when selected.
+ The editor no longer stops working if the **Asset Processor** is launched from a different build folder.
+ The **Asset Processor** no longer hangs when shutting down.
+ The IP address value in the `bootstrap.cfg` file no longer affects the **Asset Processor's** ability to build assets.
+ Slices are now processed soon after the **Asset Processor** starts.
+ The **Asset Processor** now warns you if disk space is low.

## Audio<a name="audio-fixes-v1.12"></a>

The audio system has the following fixes:
+ Obstruction ray casting is disabled while the **AI/Physics** mode is enabled.
+ Obstruction ray casting is forced on the main thread.
+ Refreshing audio in the editor no longer results in EBus asserts.

## Cloud Canvas<a name="cloud-canvas-fixes-v1.12"></a>

The CloudGemSamplesLauncher now starts properly and without initialization issues.

## Component Entity System<a name="component-entity-system-fixes-v1.12"></a>

The component entity system has the following fixes:
+ Stability improvements have been made for slice and entity manipulations.
+ To simultaneously modify the rotation of multiple entities, use the arrow buttons at the bottom of the viewport.
+ The component card no longer remains gray if you drag the card out of the **Entity Inspector**.
+ Entities that are located in the root of a level no longer display an "Entity not found" message in the **Entity Inspector**.
+ When creating a slice, you can no longer use non-ASCII characters in the file name.
+ The **Light** component can now include the terrain in the shadow casters for the light. This allows terrain to cast shadows with light types other than sun light.
+ The **Particle** component no longer retains objects or effects from a deleted particle library.
+ Lens flare is now visible even when the **Lens Flare** component is not visible in the viewport.

## Lmbr.exe<a name="lmbr-exe-fixes-v1.12"></a>

The `Lmbr.exe` command line tool no longer fails if the `user_settings.options` file is invalid.

## Lumberyard Editor<a name="lumberyard-editor-fixes-v1.12"></a>

Lumberyard Editor has the following fixes:
+ The editor now provides a warning about incompatible gem DLLs.
+ The editor no longer stops working if you attempt to use **Script Terminal** to create cubemaps.
+ Vegetation shadows now respect the minimum specification setting.
+ Various fixes to the vegetation UI include adding tooltips, supporting a large amount of field weeds, and applying a visible difference when setting size presets.
+ Various **Terrain Editor** fixes include adding proper toolbar names, properly loading levels after setting the terrain unit size, and ensuring various functionality works properly.
+ The editor no longer stops working if you use the **Generate Terrain** dialog box to create terrain that is a value other than 1024x1024.
+ The **Modify Terrain** feature works as expected, even when the brush is outside of the map boundary.
+ Terrain splat maps no longer assert when you assign them to new texture layers.
+ Various time of day fixes include updating the track when moving more than one control point, supporting the correct number of decimal places for certain values, and properly displaying parameter values.
+ The **Spline Distributor** tool refreshes when you change its parameters.
+ The **Sun Trajectory** and **Time of Day** tools now preserve the correct default values when you create a new level.
+ The **Sun Trajectory** tool no longer has an inconsistent maximum value for the **Dusk Time** slider.
+ Blend layer smoothness now matches the first layer's smoothness.
+ Memory usage no longer increases continuously when the editor has focus.
+ Allocated memory is now released after a **Ctrl\+G** and **Esc** sequence.
+ Pressing the middle mouse button in the viewport now pans the camera up, down, left, and right.
+ The editor no longer crashes when you open the **Terrain Editor**.
+ The editor refreshes automatically when you focus and defocus.
+ The editor window now retains the layout and window size when you close and then reopen the editor.
+ You can now define the tag selection of a fragment.
+ You can now choose 16, 24, or 32 from the **Toolbar Icon Size** drop-down list.
+ The layout of the **Terrain Editor** has been improved to remove extra space between the variable settings.
+ Opening and scaling windows no longer causes performance issues.
+ The editor no longer stops working if you open several tools in a row.
+ Toolbox macros now work properly.
+ If you customize the toolbar, you can now restore the default settings.
+ If you create a toolbox macro and assign a keyboard shortcut, the keyboard shortcut now works correctly to execute the macro.
+ If you create custom keyboard shortcuts, exporting and importing the settings file now works properly.
+ Scroll bars now adjust to fit the size of the **Console** window.
+ The log feed in the **Console** window now resizes properly.
+ You can no longer use the **Ctrl\+O** and **Ctrl\+N** keyboard shortcuts while actively creating and loading levels.
+ You can now use certain keys, such as **Alt\+C** or **Alt\+M**, to create keyboard shortcuts for toolbox macros.
+ The editor now shows a ready status after objects are created.
+ The File Explorer window no longer displays on top of the taskbar when you drag panes in the editor.
+ Property names in the **Entity Selector** now display in full.
+ Setting an object's height now works properly. You can access this option in the editor by choosing **Modify**, **Set Object(s) Height**.
+ The **FOV** value now displays the value that you specify. Previously the displayed value was offset by 1.
+ Scaling on 4K monitors now works properly so you can interact with existing and new entities from all angles.
+ The mouse cursor now aligns properly regardless of desktop scaling. Previously this issue affected designer objects, component entities, legacy components, and AI navigation mesh.
+ The editor no longer stops working when you import an equipment pack (`.eqp`) file.
+ The editor no longer hangs on "Refreshing assets catalog" status if you attempt to launch the editor without running the Lumberyard Setup Assistant first.
+ The editor no longer stops working if an invalid EditorPlugin DLL is missing.
+ The **Save Level Resources** option now saves material files (`.mtl`) as expected. You can access this option in the editor by choosing **File**, **Save Level Resources**.
+ When you create a new level, the focus is now on the **Name** text box in the **New Level** dialog box.
+ The **Open Recent** menu now displays the levels that you have just created.
+ Moving an object in the viewport now works properly.
+ The **Enter Full Screen Mode** option has been removed from the **View** menu in the editor. This option did not work properly.
+ The **Esc** key now deselects your selection as expected.
+ The editor no longer focuses on the **Save & Close** button after creating a new asset.
+ The editor no longer stops working if you delete the slices folder for a level that contains dynamic slices.
+ You can now save your level as expected after the editor stops working.
+ The editor now provides messaging about launching without proper video drivers.
+ Exported `level.pak` files no longer contain absolute paths.
+ The **Game Token Debugger** option now works as expected in game mode.
+ The editor no longer stops working after you change a deployment.
+ Reloading a level's prefab library no longer produces error messages.

## Lumberyard Setup Assistant<a name="lumberyard-setup-assistant-fixes-v1.12"></a>

Lumberyard Setup Assistant has the following fixes:
+ The plugin page automatically refreshes after you browse for a plugin.
+ The **Lumberyard Setup Assistant** no longer stops working if you choose an invalid Lumberyard location.
+ The **Lumberyard Setup Assistant** no longer stops working if you choose to install Java SE Development Kit (JDK) 9 or newer.
+ The Lumberyard Setup Assistant now launches properly.

## macOS<a name="macos-fixes-v1.12"></a>

The renderer no longer caches unavailable shaders without rebuilding them. The renderer now attempts to recompile unavailable shaders.

## Material Editor<a name="material-editor-fixes-v1.12"></a>

The Material Editor has the following fixes:
+ Hot reloading is now supported in the **Material Editor**.
+ You can now use text fields to edit settings with RGB values.
+ You can now apply filters when searching for materials.
+ You can now save changes to material parameters as expected.
+ The **Material Editor** now displays the parameters for the selected material by default.
+ The editor no longer stops working if you create a material and then delete the material in Perforce.
+ The editor no longer stops working if you set the **Water** shader and modify its properties.
+ Enabling **Depth Fixup** under **Shader Generation Params** no longer makes the materials invisible.
+ Rotating a texture and using tiles now works properly.
+ Various fixes include changes to the default shader parameters, improved gem stability, and exporting textures with the correct default suffixes.
+ The **Water** shader now properly sorts hair and particles.
+ Detail bump tiling now works properly when enabled on the **Illum** and **Vegetation** shaders.

## Mobile<a name="mobile-fixes-v1.12"></a>

The maps in Samples Project now work properly for Android and iOS.

## Networking<a name="networking-fixes-v1.12"></a>

The networking system has the following fixes:
+ Replicated transforms are no longer skewed when the scale is a value other than 1.
+ New clients that join a MultiplayerSample dedicated server now show existing asteroids.
+ An RPC without arguments no longer stops working when the handler (associated `AZ::Component`) is null.
+ The MultiplayerSample no longer produces warning spam in the console, which obscured actual issues.
+ Rounding errors have been fixed when marshaler is passed in small component values for the Vec3 type.
+ Lua IDE detection has been improved to allow installing npcap or connecting multiple network interfaces.
+ Lua IDE connections now work properly.

## Particle System<a name="particle-system-fixes-v1.12"></a>

The particle system has the following fixes:
+ Loading the Particles Technical Sample with the `r_driver` console variable set to `null` no longer prevents GPU initialization from completing successfully.
+ If you delete a particle library, the **Pick Particles** dialog box will no longer allow you to choose the deleted particle library.

## Perforce Source Control<a name="perforce-source-control-fixes-v1.12"></a>

Perforce source control has the following fixes:
+ The editor now launches even if Perforce is unresponsive.
+ The Lumberyard Perforce plugin now executes an fstat function every few minutes or when a file changes.
+ The viewport no longer obstructs the checkout progress bar.
+ Opening multiple levels in the SamplesProject no longer produces Perforce errors and spam.
+ Input bindings are now added automatically to the Lumberyard Auto changelist.

## Physics<a name="physics-fixes-v1.12"></a>

The physics system has the following fixes:
+ Placing legacy constraint entities no longer result in asserts.
+ The legacy option **Simulate Physics on Selected Objects** no longer causes the viewport to become unresponsive.

## Project Configurator<a name="project-configurator-fixes-v1.12"></a>

The Project Configurator has the following fixes:
+ The **Project Configurator** no longer stops working when you switch from game mode to the editor.
+ The **Project Configurator** no longer stops working when you switch between projects.
+ The **Project Configurator** now launches properly.
+ On the **Create a new project** page, your selected template is no longer deselected after scrolling through the list of project templates.
+ Using an ampersand (&) in the template description no longer truncates the text that appears after the ampersand.

## Script Canvas<a name="script-canvas-fixes-v1.12"></a>

Script Canvas has the following fixes:
+ You can now discard changes by closing the graph and choosing not to save changes in the close prompt.
+ The **Undo** and **Redo** features now work properly for newly created graphs.
+ Asserts that occur in EBus handler nodes when the behavior context EBus reflection has been removed have been fixed.
+ Input data is now cleared from previous graph executions and strong references are removed. This improves garbage collection and reduces instability.
+ Long graphs, loops, and recursive graphs will no longer stack overflow. The limit for infinite loop detection is now 1000 and can be programmed.
+ The editor no longer stops working when you create or open an existing asset, modify the asset, and then save your changes.

## Starter Game<a name="starter-game-fixes-v1.12"></a>

You can now edit the nodes on a road entity.

## Substances<a name="substances-fixes-v1.12"></a>

The Substance Editor has the following fixes:
+ If you import a substance `.sbsar` file, the corresponding Lumberyard material that is created uses `.sub` files in the texture maps by default. If a normal map with smoothness in the alpha channel is used, the smoothness map now correctly applies to the material when it is rendered.
+ Normal maps that are generated using the **Substance** plugin are now treated as normal maps in Lumberyard.

## Track View<a name="track-view-fixes-v1.12"></a>

The **Track View** editor has the following fixes:
+ Authoring camera animations while looking through the camera viewport has been fixed.
+ Support for using parented sequence entities has been improved.

## Twitch ChatPlay<a name="twitch-chatplay-fixes-v1.12"></a>

Whispers are now sent correctly to user names that have uppercase letters.

## UI Editor<a name="ui-editor-fixes-v1.12"></a>

The UI Editor has the following fixes:
+ The editor no longer stops working when you unload a UI canvas that uses a font directly and through a font family.
+ Game input is now unresponsive as expected while the game console is invoked.
+ The **UI Spawner** component no longer sends notifications before entities are fully initialized.
+ The **SetState** radio group button no longer sends canvas action notifications.
+ Canvases now successfully process when you copy and paste a slice onto a canvas and then save.

## Virtual Reality<a name="virtual-reality-fixes-v1.12"></a>

The VR\_Xylophone\_Sample level now renders correctly on the HTC Vive headset.

## Miscellaneous<a name="miscellaneous-fixes-v1.12"></a>

Lumberyard has the following miscellaneous fixes:
+ Panorama screenshots now have improved resolution, removed artifacts, and correct blue and red channels.
+ The `r_brightness` and `r_contrast` console variables now work properly.
+ Initialization error messages now include detailed information such as log file paths and game DLL names.
+ The resource compiler no longer stops working if you generate a cubemap, right-click the `.tif` file, and then choose **RC Open Image**.