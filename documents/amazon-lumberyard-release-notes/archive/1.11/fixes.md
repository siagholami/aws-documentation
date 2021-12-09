# Fixes<a name="lumberyard-v1.11-fixes"></a>

Lumberyard Beta 1.11 and 1.11.1 resolves earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [Lumberyard Beta 1.11.1](#lumberyard-v1.11.1-fixes)
+ [Android](#android-fixes-v1.11)
+ [Asset Browser](#asset-browser-fixes-v1.11)
+ [Asset Pipeline](#asset-pipeline-fixes-v1.11)
+ [Asset Processor](#asset-processor-fixes-v1.11)
+ [Component Entity System](#component-entity-system-fixes-v1.11)
+ [Console](#console-fixes-v1.11)
+ [FBX Settings](#fbx-settings-fixes-v1.11)
+ [Graphics](#graphics-fixes-v1.11)
+ [Lumberyard Editor](#lumberyard-editor-fixes-v1.11)
+ [Lumberyard Setup Assistant](#lumberyard-setup-assistant-fixes-v1.11)
+ [macOS](#macos-fixes-v1.11)
+ [Mannequin](#mannequin-fixes-v1.11)
+ [Material Editor](#material-editor-fixes-v1.11)
+ [Networking](#networking-fixes-v1.11)
+ [Particle System](#particle-system-fixes-v1.11)
+ [Perforce Source Control](#perforce-source-control-fixes-v1.11)
+ [Project Configurator](#project-configurator-fixes-v1.11)
+ [Time of Day](#time-of-day-fixes-v1.11)
+ [UI Editor](#ui-editor-fixes-v1.11)
+ [Miscellaneous](#miscellaneous-fixes-v1.11)

## Lumberyard Beta 1.11.1<a name="lumberyard-v1.11.1-fixes"></a>

Lumberyard Beta 1.11.1 includes the following fixes:

**Animation Editor**
+ Capturing motion extraction height now works properly. To enable this feature, in the **Animation Editor**, in the **Motions** pane, select the **Capture Height Changes** check box.
+ The editor no longer crashes when you assign an `.actor` file to an **Actor** component in the **Entity Inspector**.
+ The editor no longer crashes when you select a deleted node in the animation graph by pressing the forward and backward ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/anim-graph-navigation-arrows.png) arrow buttons.
+ Undocking the **Actor Manager** pane and setting the **Excluded from Bounds** feature now work properly.

**Game Builds**
+ Creating a release build now works properly.

**Gems**
+ Custom Qt components can now be created from the **Editor** gem.

**Graphics**
+ If you use a material with a UV offset in Lumberyard 1.11, the texture is no longer offset. The texture now moves in the same direction as previous versions of Lumberyard.

**Lumberyard Editor**
+ Error messages no longer display if you attempt to launch the editor when the **Lua Editor** is already open.
+ Adding a **Particle Physics** entity (legacy) in the viewport no longer results in an error.
+ The editor no longer stops working if you attempt to create a slice and then undo the action.

**macOS**
+ The Multiplayer sample no longer stops working when running in debug mode.

**Script Canvas**
+ Using local variable types that have more than one output pin and can output individual properties now works properly. The numeric outputs now return color components (RGBA) in the console log.
+ The editor no longer stops working if you highlight the text in a **Comment** node, deselect the node, and then select the node again.

**Starter Game**
+ The Starter Game sample now has the **EMotionFX** gem enabled, which enables you to use the **Animation Editor**. You can also choose to use the legacy animation tools (**Geppetto** and **Mannequin**).

**Terrain Editor**
+ The **Terrain Editor** no longer stops working when you open a different level, select a different edit tool, or restart the editor.

**Visual Studio Support**
+ If you install Lumberyard without a version of Visual Studio installed, you no longer see a warning that `MSVCP120.DLL` was not found.

**Miscellaneous**
+ Unit tests now work properly.

## Android<a name="android-fixes-v1.11"></a>

Android has the following fixes:
+ The Android NDK r15 is now supported.
+ If you switch NDK versions, an implicit configure is now triggered and the NDK rebuilds correctly.
+ The system allocator no longer throws a startup assert.

## Asset Browser<a name="asset-browser-fixes-v1.11"></a>

Asset Browser has the following fixes:
+ You can now drag assets from the Asset Browser to the Entity Inspector.
+ The Asset Browser no longer adds `.fbx` assets as **Decal** components in the viewport.
+ The Asset Browser properly displays `.fbx` and `.cgf` files in the object preview.

## Asset Pipeline<a name="asset-pipeline-fixes-v1.11"></a>

The Asset Pipeline has the following fixes:
+ Asserts, errors, and warnings are now properly tracked when `.fbx` files are processed.
+ The nodes in `.fbx` files that previously had no names or names that conflicted are now corrected automatically.
+ Various issues with materials that are generated from `.fbx` files have been fixed. This includes situations where opacity was set to 0.
+ The Resource Compiler can now properly process folders with a period in the name.
+ The Resource Compiler no longer erroneously sends a warning on shut down about queued functions.
+ The FBX log now displays data correctly.
+ The editor no longer crashes when you delete meshes in the FBX Settings.
+ You can now import `.fbx` assets with vertex colors from 3ds Max.
+ When you add a group in the FBX Settings, the **Update** button is now enabled as expected.

## Asset Processor<a name="asset-processor-fixes-v1.11"></a>

Asset Processor has the following fixes:
+ Asset Processor now rebuilds dynamic slices that contain a component whose definition has changed in code, such as added properties, renamed properties, changed version number, and so on.
+ Asset Processor now scales appropriately on super high resolution displays.
+ The Asset Processor no longer crashes when you close a logging tab while a write operation is in progress.
+ The editor no longer shows the "Asset processor has disconnected" message during operations like gem activation.
+ The editor no longer crashes when you launch the Asset Processor from another engine build.
+ The AssetProcessorBatch no longer hangs during compilation.
+ The Asset Processor no longer returns an error if you close it during a connection operation to a Lumberyard application as a proxy.
+ The Asset Processor now displays the correct status when it processes big slices.
+ Deadlocks, freezes, and pauses in the Asset Processor (executable and batch) are now fixed.
+ The Asset Processor no longer crashes when you use the `cloud-gem create` command in the CLI.
+ The Asset Processor log view now works properly.
+ The Asset Processor now processes dynamic cascaded slices when pushing changes for the original slice.
+ The Asset Processor no longer fails and restarts due to an `.assetinfo` file.

## Component Entity System<a name="component-entity-system-fixes-v1.11"></a>

The component entity system has the following fixes:
+ When **Snap to Grid** is enabled, a new entity that you create in the viewport now snaps to the grid.
+ You can now remove two entities in the same parent hierarchy chain without affecting other entities. Previously, doing so would move the lowest child to an incorrect location in the level.
+ Change notifications now work properly when you set an element to `ShowChildrenOnly` in the Entity Inspector.
+ When you enable `highlight on hover`, component entities now show the appropriate highlight.
+ Improved stability for sorting entities and components within nested slices.

## Console<a name="console-fixes-v1.11"></a>
+ The **Console** window that appears when switching to game mode now displays a blank command line. Previously, it included the grave accent or apostrophe key that was used to open it, leading to erroneous entries.
+ The **Console** is now read-only.
+ Pressing tilde ( \~ ) now brings up the box to enter a console command.
+ You can now clear the **Console** of all text.
+ The editor no longer crashes when you enter commands rapidly and repeatedly in the **Console**.
+ **Console** panel now maintains its size when you dock it on the top or bottom.
+ Variable `r_HDRDolby` no longer allows you to set a value in a range outside of its bounds. Previously, doing so caused glitches in the viewport. 

## FBX Settings<a name="fbx-settings-fixes-v1.11"></a>

FBX settings have the following fixes:
+ The FBX log window now displays large blocks of text properly.

## Graphics<a name="graphics-fixes-v1.11"></a>

Graphics have the following fixes:
+ Console setting e\_screenshot 1 now produces high quality screenshot.
+ The time of day's current time, start time, and stop time are now aligned to be the same between the editor and the launcher.
+ The editor no longer crashes when you undo adding a lens flare after renaming a **Lens Flare** library and assigning it to an entity.
+ The editor no longer crashes when you change the Multi Ghost count using the slider in the **Lens Flare** editor.

## Lumberyard Editor<a name="lumberyard-editor-fixes-v1.11"></a>

Lumberyard Editor has the following fixes:
+ The editor no longer crashes after you delete the penultimate customized toolbar.
+ The **Save As** command is now disabled when no level is open.
+ The **Save Level As** dialog box now defaults its active focus to the **Level Name** field. Previously, it focused by default on the **Filter** field.
+ The editor no longer crashes when you add objects from the Rollup Bar to the viewport when viewport type is set to top, front, left, or map.
+ Expanding floating windows to maximum in Windows 10 now respects available screen space and does not expand beneath the task bar.
+ The **Modify**, **Resize Terrain** dialog now displays by default in the center of the screen. Previously, it displayed at the top left.
+ The **Script Help** window's **Example** column now expands to show its full contents.
+ Context menus for the perspective bar's **FOV**, **Ratio**, and **Resolution** now appear in the proper area when running Lumberyard on two monitors.
+ The **Configure Toolbox Macros** dialog no longer allows you to store macros with empty names. It also now requires clicking **OK** to confirm the list of macros.
+ The navigational rotation sensitivity of the **Perspective** viewport when you right-click in it is reduced. This means that you can open the context menu without inadvertently changing the view.
+ You can now easily remove customized commands that you added to the toolbar.
+ You can now navigate to the **Open Level** window by keyboard and then open a level by pressing **Enter**.
+ The editor now retains the maximized state when you open the level again.
+ The editor now preserves floating, multi-tool windows when you relaunch the editor.
+ The **F** key to freeze selected objects is operational.
+ The editor's **Game Mode** no longer allows you to toggle between single player and multi player mode.
+ The editor no longer allows you to create a new level with a name that exceeds 260 characters.
+ The editor now accepts **Enter** key as it would the **OK** button in simple dialog boxes that prompt for text values.
+ Pressing **Tab** while in Perspective viewport's **Custom Ratio** and **Custom Resolution** dialog boxes now advances through the available fields.
+ Pressing **Z** to zoom when more than one perspective view is open now works properly when you activate the viewport window with any action in them to update the zoom.
+ The editor no longer crashes during game mode when you enter certain keystroke combinations.
+ Undocked panes no longer become hidden when you move the main editor window.
+ Multiple perspective view layouts are now saved between sessions.
+ Cameras in the View menu are now sorted alphabetically.
+ The editor now remains stable when you create a level name consisting of 100 symbols.
+ The editor no longer launches an additional `editor.exe` when you click **No** on the "Start another editor.exe?" prompt.
+ The editor no longer crashes after you move a key just slightly inside the **Curve Editor**.
+ Single line edit boxes now highlight in red and display a tool tip if you enter invalid characters.
+ The editor functions no longer freeze when you perform operations in very large levels.
+ The editor no longer crashes when you load a recent level while the **Sun Trajectory** tool is calculating.
+ The editor no longer crashes when you import or export vegetation in **Database View** and then create a new level.
+ Improved stability and workflow for object and terrain tools while in terrain editing mode.
+ Desktop scaling on high resolution displays no longer interferes with move, rotate, and transform events.
+ Perspective viewport's toolbar text is no longer rendered unreadable by scaling issues.
+ Resolution in the viewport is no longer affected when you change scaling settings in Windows 10 on high resolution displays.
+ Scaling on a high resolution display no longer renders the welcome screen dialog too large.
+ Tools now appropriately display and set floating point values with a period rather than a comma for numerical locale settings.
+ Toolbar layout is now saved between sessions.
+ The `editor.exe` process now shuts down properly when you close the Editor.
+ The editor no longer crashes when you select previously linked legacy entities.
+ Improvements to **Asset Importer** dialog boxes:
  + 'File already exists' dialog box is now a separate dialog that presents a tree view of the files. This dialog box also has the following improvements:
    + Files are not selectable
    + Folder hierarchy is entirely expanded
    + Icons appropriate to files and folders are displayed
  + The page that prompts you to select the target directory has the following improvements:
    + Appears in its own dialog window
    + **View** button links to Asset Processor log
+ Different sized floating panes now snap appropriately.
+ The snapping of floating panes in Windows 10 now functions appropriately.
+ Holding down **Ctrl** while dragging now prevents both docking and snapping of the panes. Previously, it prevented only docking.
+ When you attempt to save a layout with an existing name, the option to enter a new name is now functional. Previously, choosing to enter a new name simply returned you to the layout screen.
+ The **Time of Day** editor's **Freeze/Unfreeze** button is now labeled by its actual function, **Snap to value grid**.
+ The **Time of Day** editor's **Unify/Break Tangent Handles** button is now labeled by its actual function, **Snap to time grid**.
+ **Script Terminal** now uses contrasting text. Previously, the text matched the background too closely, making it difficult to read.
+ When you switch projects, the Editor no longer prompts you to save changes if you have not made any changes.
+ Lumberyard now detects the brightness multiplier in the level data and corrects the brightness values in the terrain texture data. Previously, terrain that was created in Lumberyard 1.8 or earlier appeared too bright in newer versions of Lumberyard.
+ The **Move** tool no longer provides jerky movements if the mouse is far from the drag axis.
+ Dragging `.fbx` files to the viewport no longer results in decals being spawned.
+ Meshes no longer disappear from a level.
+ In the Database View, loading a library twice no longer results in an error.
+ The editor no longer crashes when you attempt to use the **Export Mapping** feature.
+ The editor no longer crashes when exporting a level.
+ Assets now properly display in the Material Editor and **Perspective** viewport.
+ In the Lens Flare Editor and the Database View, the **Overwrite** and **Cancel** buttons now work properly when adding elements to a library.
+ The editor no longer crashes without user feedback when serialization or reflection does not succeed during startup.

## Lumberyard Setup Assistant<a name="lumberyard-setup-assistant-fixes-v1.11"></a>

Lumberyard Setup Assistant has the following fixes:
+ Text now scales appropriately on super high resolution displays.
+ SDKs are no longer incorrectly marked as valid if moving downloaded assets was unsuccessful.
+ The status now refreshes properly when the plugin page is updated.
+ The Lumberyard Setup Assistant no longer crashes when shutting down.
+ The Lumberyard Setup Assistant now generates the correct value for the key when initially generating the `user_settings.options` file.
+ The `SetupAssistantBatch` no longer writes an empty value for `msvs_version` in the `user_settings.options` file if both vc capabilities are selected.

## macOS<a name="macos-fixes-v1.11"></a>

macOS has the following fixes:
+ The CPU Trail particle now renders correctly on all operating systems (Windows, macOS, and iOS).
+ Basic lights and shadows now render correctly in the VisAreaBasic map.
+ The volumetric scattering screen effect now transitions smoothly between states.
+ The water droplets screen effect now renders correctly and does not distort.
+ The water flow screen effect now renders correctly and does not stop.
+ Hair now renders correctly on the HumanFeatureHair map.
+ Render capability was added for dual source blending support.
+ The volumetric scattering map now works properly and displays the volumetric scattering effect.
+ Shadows are now fixed for macOS.
+ Pressing keyboard keys on macOS using the Metal renderer no longer produces a beeping sound.
+ When you want to move or resize the XCode window, the mouse pointer now stays active only within the window. Other controls are now constrained.
+ The GeometryBeam and TerrainAndWater maps now render correctly and with the appropriate render setting.

## Mannequin<a name="mannequin-fixes-v1.11"></a>

The Mannequin system has the following fixes:
+ The **Tools**, **List Used Animations** command now displays the appropriate previews.
+ You can now deselect an `.adb` file in order to create a sibling in the root directory.

## Material Editor<a name="material-editor-fixes-v1.11"></a>

The Material Editor has the following fixes:
+ Photoshop can now load a texture that you open from the **Material Editor**.
+ Toolbar buttons now display intuitive enabled and disabled states.
+ You can now copy and paste properties successfully between materials.
+ Property changes to materials are now preserved when switching between materials.
+ **Material Editor** no longer crashes when you switch projects while the large material preview window is open.
+ **Material Editor** no longer opens a **Save** dialog when you attempt to copy and paste options between properties.
+ The Water Volume shader is no longer missing the probe and realtime reflections.
+ The Material Editor performance is no longer impacted if there is a scene with a large number of meshes without default materials.

## Networking<a name="networking-fixes-v1.11"></a>

The networking system has the following fixes:
+ RPCs are now marshaled as expected.
+ `NetworkBindingHandlerBus` is now partially reflected to the behavior context so you can access it from Script Canvas and Lua.
+ Networked, root slice entities are now removed on level load as expected.
+ Duplicated or bad packets no longer cause a disconnect.
+ GridMate now filters duplicate entity IDs.

## Particle System<a name="particle-system-fixes-v1.11"></a>

The particle system has the following fixes:
+ The editor no longer crashes when you move a child emitter of a child emitter (a grandchild emitter) to a new empty library.*Replace this listitem*
+ The editor no longer crashes when you attempt to perform a new action in **Particle Editor** while it is still executing the previous action.

## Perforce Source Control<a name="perforce-source-control-fixes-v1.11"></a>

Perforce source control has the following fixes:
+ The Perforce checkout window displayed when you save a level now displays information in a readable manner.
+ The appearance of the Perforce plugin settings window now matches the general Lumberyard appearance.
+ Checking out a material from Perforce in **Material Editor** now functions properly. Previously, this action caused a freeze and crash.
+ Editor no longer attempts to add non-existent long file names to Perforce.
+ GPU particle initialization no longer crashes when using a Null renderer while the `Particle_Technical_Sample` map is loaded.

## Project Configurator<a name="project-configurator-fixes-v1.11"></a>

The Project Configurator has the following fixes:
+ Text now scales appropriately on super high resolution displays.
+ Sortable columns on the **Gems** page now signal that they are clickable by changing the mouse pointer icon when you hover on them.
+ The Project Configurator no longer crashes if the `ProjectTemplates` directory is missing.
+ Setting a default project in the Project Configurator now works properly despite an unexpected working directory.
+ The System Entity Editor (the Project Configurator's advanced settings) now loads the exact DLLs that are required for the selected configuration. There is no longer a bias for editor modules.
+ In the Project Configurator, gems are now ordered according to their dependency graph. This prevents potential issues if a gem fails to initialize because a gem it depends on hasn't initialized yet.
+ When you create a new project in the Project Configurator, the gems that you enable are now added to the project's solution file. When you run `lmbr_waf configure`, only the lumberyard\_sdk solution is updated. If you want to update the game-specific solution file, you must run `lmbr.exe` with the following parameters: `lmbr.exe projects create_vs_solution <project name>`

## Time of Day<a name="time-of-day-fixes-v1.11"></a>

The time of day system has the following fixes:
+ To allow more artistic flexibility, the maximum value for the following Night Sky parameters has increased from 0.1 to 1.0:
  + Horizon color multiplier
  + Zenith color multiplier
  + Moon color multiplier
  + Moon inner corona color multiplier
  + Moon outer corona color multiplier
+ The **Time of Day** UI is now better guarded against crashes around interpolate calls.

## UI Editor<a name="ui-editor-fixes-v1.11"></a>

The UI Editor has the following fixes:
+ LyShine is now using delta time.
+ If you have multiple components that are the same type, removing one no longer removes the wrong component.
+ The editor no longer crashes if you load 20\+ UI canvas files and attempt to access the hierarchy context menus.
+ You can no longer erroneously navigate the main menu vertically when using the slider on the **Settings** screen in the `uieditor_lua_sample` map.
+ If you hide the **Animation List Play** toolbar, you no longer need to restart the UI Editor to display the toolbar again.
+ The **TextInput** password field now works correctly with non-ASCII input.
+ The editor no longer crashes because of in-world canvases when you switch levels in a game.
+ Changing the element size no longer affects word wrapping.
+ The Cloud Canvas cursor no longer remains onscreen after you exit gameplay.
+ Icons no longer disappear from the UI Editor and reappear in the Lumberyard Editor viewport.
+ The **Component** button is now functional in the `LyShineFeatures` map in the profile build.
+ The UI is only rendered to the appropriate tile when using **e\_screenshot**.
+ You can now add an element from the slice library.

## Miscellaneous<a name="miscellaneous-fixes-v1.11"></a>

Lumberyard has the following miscellaneous fixes:
+ Python script batch export now works properly.
+ Improved Python command for opening levels deeper than the base level. Now you can use `general.open_level(foldername\levelname)`. Previously, you had to enter `general.open_level("levels\foldername\levelname\levelname.cry`.
+ The unimplemented `GetString()` function was removed from `Crc32` in game templates.
+ Ebus `Light.Event.Set*` no longer turns a light on when its properties are updated. Previously, updating the properties for `Light.Event.Set*` in game also triggered `Light.Event.Turnon`, which meant a light that a player intentionally turned off would be turned back on without player action.
+ In the HTTP Requestor Gem, the `HttpRequestManager` thread now shuts down in a timely manner.
+ The Profiler can now attach to applications that are extended from `Application.cpp`.
+ A potential deadlock and memory churn in memory pool usage tracking for `ParticleObjectPool` has been fixed.
+ The Lua editor no longer crashes if you attempt to save a Lua script as a new script.
+ When you create a slice, the slice is now also added to source control.
+ When a file that's marked for deletion in Perforce is modified in the editor, the file is automatically updated in Perforce and marked for editing.
+ The TypeId/Uuid system that RTTI uses now initializes in a thread-safe way under Visual Studio 2013.
+ The binary `SkipElement` in `ObjectStream` now correctly skips in the following ways:
  + If stream version is greater than 1, specialized type IDs are written into the stream. They are skipped when skipping elements.
  + If element size is greater than 7, the size is encoded after the flags in the stream. The skip code failed to consider the flag bytes that were already read when the code read additional size from the stream.
+ When there is more than one required gem, the cyclic dependency no longer causes an infinite recursion when processing gems during the `lmbr_waf configure` steps.