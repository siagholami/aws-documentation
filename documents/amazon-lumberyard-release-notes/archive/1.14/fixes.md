# Fixes<a name="lumberyard-v1.14-fixes"></a>

Lumberyard Beta 1.14 and 1.14.0.1 include the following fixes:

## Lumberyard Beta 1.14.0.1<a name="lumberyard-v1.14.0.1-fixes"></a>

Lumberyard Beta 1.14.0.1 includes the following fixes:

**Asset Processor**
+ The Asset Processor will again autodetect the number of CPUs to use. Previously, the Asset Processor was set to use a fixed value of 10 cores.

**Lumberyard Editor**
+ Closing the **Login to Amazon Lumberyard** window no longer causes the editor to stop working.

## Lumberyard Beta 1.14<a name="lumberyard-v1.14.0-fixes"></a>

Lumberyard Beta 1.14 resolves earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [Animation Editor](#animation-editor-fixes-v1.14)
+ [Asset Browser](#asset-browser-fixes-v1.14)
+ [Asset Processor](#asset-processor-fixes-v1.14)
+ [Cloud Canvas](#cloud-canvas-fixes-v1.14)
+ [Component Entity System](#component-entity-system-fixes-v1.14)
+ [Gems](#gems-fixes-v1.14)
+ [Geppetto](#geppetto-fixes-v1.14)
+ [GitHub Pull Requests](#github-pull-requests-fixes-v1.14)
+ [Lua IDE](#lua-ide-fixes-v1.14)
+ [Lumberyard Editor](#lumberyard-editor-fixes-v1.14)
+ [Mannequin](#lumberyard-mannequin-fixes-v1.14)
+ [Material Editor](#material-editor-fixes-v1.14)
+ [Particle Editor](#particle-editor-fixes-v1.14)
+ [Project Configurator](#project-configurator-fixes-v1.14)
+ [Rollup Bar](#rollupbar-fixes-v1.14)
+ [Scene Settings](#scene-settings-fixes-v1.14)
+ [Scripting](#scripting-fixes-v1.14)
+ [Starter Game](#starter-game-fixes-v1.14)
+ [Track View Editor](#track-view-editor-fixes-v1.14)
+ [UI Editor](#ui-editor-fixes-v1.14)
+ [Miscellaneous](#miscellaneous-fixes-v1.14)

### Animation Editor<a name="animation-editor-fixes-v1.14"></a>

The **Animation Editor** has the following fixes:
+ If you remove all layouts from the **Animation Editor**, the **Anim Graph** layout is used by default.
+ Actors are now created if there is bone data but no animation frame.
+ When you hide a slice with an actor entity, the actor now hides properly. You can toggle the visibility control in the **Entity Outliner**.
+ The editor no longer stops working when you record an animation graph animation.
+ The editor no longer stops working when you exit game mode from the Starter Game level.
+ Changes that you make in the **Render Plugin Properties** section and on the **Color** tab are now saved properly. You can access these settings by choosing **Edit**, **Preferences** in the **Animation Editor**.
+ You will no longer see all workspace options in the **Reset** menu. As expected, only the elements that are currently available in the workspace will show.
+ The editor no longer stops working when you select a graph field in an empty **Anim Graph** window and then press **Backspace**.
+ You can now use the **Animation Editor** for external game projects.
+ The editor no longer stops working when you save a motion set that has an undefined motion.
+ The Advanced\_RinLocomotion sample level no longer experiences synchronization issues.
+ The editor no longer stops working when you do the following: load an actor in the **Actor Manager**, open the **Collision Mesh Setup** window, right-click the actor, and then choose **Add all towards root to selection**.
+ The **Auto Load Last Workspace** setting now works properly. To access this setting, choose **File**, **Open Workspace**.
+ The following settings have been removed: **Hide Scale Actor Data**, **Scale Motion Data**, **Scale Anim Graph Data**, and **Collision Mesh Setup**.
+ The preview window now shows gizmos for all tools— including transform, rotation, and scale— for all camera view types.
+ Rotation gizmos no longer lose focus in the preview window for the **Top** and **Bottom** camera view types.
+ You can now select child motion sets as expected.
+ The **Actor** tab now appears in the `.fbx` file settings as expected.
+ When you hide an entity in the **Entity Outliner**, the actor model no longer appears in the viewport.
+ If you add event presets with the same name to the motion event presets configuration file, all presets now appear in the **Animation Editor**. Previously only the first event preset with the same name would appear.
+ An error message appears if you attempt to play a motion without first opening an actor file.
+ When you save a motion set, the assigned motion set for the animation graph now remains in the **Motion Set** drop-down menu.
+ The **Time View** window no longer resizes vertically when you add event tracks.
+ Loading a workspace no longer produces activation errors.
+ When you disable the **Draw character** setting, the character no longer appears in game mode.
+ The **Morph Targets** pane no longer erroneously clears when switching between tabs.
+ The **Jump** and **Forage** event groups have been removed from the motion set and input for the Simple\_JackLocomotion sample level.
+ You can no longer drag animation graphs (`.animgraph`) from the **Asset Browser** to the viewport.
+ The Animation Editor floating window no longer displays two title bars.

### Asset Browser<a name="asset-browser-fixes-v1.14"></a>

The **Asset Browser** has the following fixes:
+ Typing an event name to edit an `inputbindings asset` appears correctly.

### Asset Processor<a name="asset-processor-fixes-v1.14"></a>

Asset Processor has the following fixes:
+ The **Job ID** no longer appears in Asset Processor.
+ Asset Builder DLLs no longer stop working when more than one `builder.dll` file has been loaded.
+ The icon in the Asset Processor window now matches the icon in the taskbar.
+ Keyboard input now works correctly for macOS.
+ If the Asset Processor is running and it detects that you are building its DLL files (such as `CrySystem.dll`, `AssetProcessor.exe`, builders, or gem DLLs), the Asset Processor will now close automatically. This prevents compilation errors. The Asset Processor will restart when you launch Lumberyard Editor or a game launcher.

### Cloud Canvas<a name="cloud-canvas-fixes-v1.14"></a>

Cloud Canvas has the following fixes:
+ The PlayerAccountSample map no longer stops working when you sign in, create a new user, change or forget your password without mapping files on iOS, Android, or macOS devices.
+ TheTexttoSpeechSample level opens correctly in Lumberyard Setup Assistant.
+ In the Dynamic Content Manager, adding files to an existing pak file correctly shows the expected file changes.
+ AWS CloudFormation resources have a timeout property specified.
+ Lumberyard Editor opens correctly when you set the default game project to CloudGemSamples.

**Cloud Gem Portal**
+ You can now delete old versions of bots, intents, and slots in the Speech Recognition Gem.
+ The Message of the Day gem now correctly displays a message for the time schedule that you specify.
+ You can now add a player name when you create an account in Cloud Gem Portal.
+ Typing special characters for Text to Speech character created invalid names. Special characters can't be used for character names.
+ In the Dynamic Content Manager, adding files to an existing pak file correctly contains the expected files.

**Resource Manager**
+ File statuses now update automatically.

### Component Entity System<a name="component-entity-system-fixes-v1.14"></a>

The component entity system has the following fixes:
+ AABB and shape math has been fixed for shape components.
+ The **Shape** component has improved rendering.
+ The mouse wheel is no longer counted twice when editing spin boxes.
+ The `SetParent` method no longer causes Lumberyard Editor to stop working when you set an entity as a parent.
+ Lumberyard Editor no longer stop working when a **Spawner** component spawns an entity which spawns a particle.
+ Drop-down menus appear correctly in the **Input** component.
+ Lumberyard Editor no longer stops working if you enter game mode or AI/Physics with an invalid child entity specified for a **Compound Shape** component.
+ Opening the asset picker from a component's asset reference property correctly displays the asset's location.
+ Newly created **Camera** (legacy and component entities) appear correctly in the drop-down menu for the camera ComboBox.
+ Dynamic slices have the correct component dependencies.
+ Lumberyard Editor no longer stops working when an entity with a **Spawner** component that spawns itself is activated.
+ Changes made to component values for an entity correctly display in both the **Pinned Entity Inspector** and the **Entity Inspector**.
+ New tag entries push correctly to nested slice **Tag** components.

### Gems<a name="gems-fixes-v1.14"></a>

Gems have the following fixes:
+ The File Importer displays an error message if a `.crate` file cannot be import.

### Geppetto<a name="geppetto-fixes-v1.14"></a>

Geppetto has the following fixes:
+ Geppetto no longer stops working if you create a sequence with an animObject and set a keyframe in the **Animation Track**, and then click the folder icon.

### GitHub Pull Requests<a name="github-pull-requests-fixes-v1.14"></a>

The following fixes are based on GitHub pull requests:
+ Based on the pull request from **lucaslg**, the power of two `'²'` character (code 178) has been added. This is used to toggle the console in AZERTY layout to the ignore condition for adding characters to the console.
+ Based on the pull request from **Nocturnals**, support for Alembic vertex geoscope has been added.
+ Based on the pull request from **alex-leleka**, shadows no longer shift if total illumination is active and the `e_GI` console variable is set to **0**.

### Lua IDE<a name="lua-ide-fixes-v1.14"></a>

The Lua IDE and editor have the following fixes:
+ Double-clicking an error in the results now shows the proper line.
+ The Lua IDE no longer provides extraneous information in the logs.
+ Closing the Lua editor no longer ends the Lua IDE process instantly.
+ Lua Editor now opens correctly from Lumberyard Editor. 

### Lumberyard Editor<a name="lumberyard-editor-fixes-v1.14"></a>

Lumberyard Editor has the following fixes:
+ Merged meshes no longer result in missing vegetation or warning messages about exceeding maximum vertices.
+ When exporting and then importing an `.xml` file from the **Time of Day Editor**, set calculations are no longer one minute ahead.
+ When you press **Ctrl** and click the terrain, the terrain texture layer is now selected.
+ When playing back videos, the OnPlaybackFinished event is now triggered as expected.
+ When you create a material in the **Material Editor**, it now appears in the left navigation pane.
+ Black reflection in the ocean has been fixed. Previously an issue occurred when volumetric fog was enabled and the `s_ptexVolumetricFog` texture became unbound, but not removed from the `s_TexStages` array of bound resources.
+ The editor no longer stops working when you set the `r_Height` and `r_Width` console variables to **0**. You will now see an error log that states the `r_Height` and `r_Width` console variables have been set to the nearest valid value.
+ The Clone Object Tool no longer causes the editor to stop working when you enter game mode.
+ Issues with Perforce connected to Lumberyard Editor are fixed.
+ The editor no longer stops working when you click **Graphics Settings**.
+ The editor no longer stops working if you open a game project that doesn't have the required gems enabled. A message now points you to enable the missing gems in the Project Configurator.
+ You can no longer create multiple custom toolbars with the same name.
+ Icons in the custom toolbar are now highlighted correctly when you pause on them.
+ The **New Folder** button works correctly when you save a level under a new name or location.
+ Editor buttons display tooltips correctly when you pause on them.
+ Pressing **Z** to lock on a selected lock entity works correctly.
+ The console window displays the correct string format in the error report.
+ The editor no longer crashes when you push a change to a cascaded slice.
+ The undo feature works correctly with the color picker.
+ Parameter slices are correctly adjusted for default values.
+ The Window taskbar with the auto-hide option enabled is now accessible when the editor is in full screen mode.
+ The editor dialog windows no longer jump to the top-left corner of the screen when you restore the window from a maximum view (even if the window cannot be maximized).
+ Dragging assets from the **Asset Browser** to the viewport no longer causes an error in the `Ebus.h` file.
+ The left panes in the editor now display the same size when you start the editor for the first time and when you restore the default layout.
+ Right-clicking an error report and choosing **Open in Excel** opens correctly.
+ Creating a level automatically loads into the viewport.
+ The editor correctly displays a message that you must close the editor before you can switch projects.
+ The drop-down menu appears correctly when you right-click the title bar.
+ Creating a level no longer causes the editor to stop working if the level name has too many characters.
+ The editor opens correctly if you already have a previous version of Lumberyard's Asset Processor running.
+ `Lmbr.exe` switches projects correctly when Perforce is not configured.
+ The editor no longer stops working when you undo a check out action on a renamed dialog in Perforce.
+ The Terrain Texture Layers button on the toolbar correctly opens the **Terrain Textures Layers Editor**.
+ Dragging a file into the viewport and right-clicking correctly displays the **Import Asset** dialog box.
+ The editor no longer stops working if you create a project with `lmbr.exe`.
+ The search box in the **Entity Outliner** no longer clears your selected entity.
+ **Entity Outliner** filters clear when you load another level.
+ The editor no longer stops working if you attempt to make a change in game mode.
+ The editor no longer stops working after loading a level and then changing levels.

### Mannequin<a name="lumberyard-mannequin-fixes-v1.14"></a>

Mannequin has the following fixes:
+ The **New ID** window displays the correct name when you click **New Fragment ID**.

### Material Editor<a name="material-editor-fixes-v1.14"></a>

The **Material Editor** has the following fixes:
+ You can right-click a material's parameters and choose **Copy All** to copy all parameters for the material or choose **Copy Section** to copy a specific parameter section.
+ Lumberyard Editor no longer stops working when the **Realtime Reflection** parameter changes for the `waterfall_volume.mtl` and `woodland_canyon_river.mtl` files.

### Particle Editor<a name="particle-editor-fixes-v1.14"></a>

The **Particle Editor** has the following fixes:
+ Undocked tabs close after you close the **Particle Editor**.
+ Lumberyard Editor no longer stops working if you attempt to close it while there are unsaved changes in the **Particle Editor**.
+ Particle textures no longer flicker or render darker if you reopen Lumberyard Editor and the level without first closing the **Particle Editor**.
+ Lumberyard Editor no longer stops working if you attempt to dock a window to the editor while the **Particle Editor** is loading.

### Project Configurator<a name="project-configurator-fixes-v1.14"></a>

The Project Configurator has the following fixes:
+ If you enabled your own gems for your game project, Lumberyard Setup Assistant no longer stops working when you click **Advanced Settings**.
+ `Lyzard.exe` no longer stops working when you change the configuration for your game project.
+ `crcfix.exe` no longer stops working when you create a project.

### Rollup Bar<a name="rollupbar-fixes-v1.14"></a>

The Rollup Bar has the following fixes:
+ The preview for a `.dds` file overlay displays correctly.

### Scene Settings<a name="scene-settings-fixes-v1.14"></a>

The resource compiler no longer stops working when you add or modify a blend shapes modifier.

### Scripting<a name="scripting-fixes-v1.14"></a>

Scripting has the following fixes:
+ The **Rotate by Euler** node now has the correct transformation and no longer applies scale to an object.
+ Node jittering no longer occurs when you hover over block comments.
+ **Rotation** has been renamed to **Quaternion**.

### Starter Game<a name="starter-game-fixes-v1.14"></a>

Lumberyard Editor no longer stops working when you switch maps in the Starter Game level.

### Track View Editor<a name="track-view-editor-fixes-v1.14"></a>

The Track View editor has the following fixes:
+ The editor no longer stops working if you delete a node from a component entity sequence and then attempt to change the value of a key in the deleted node.
+ The editor no longer stops working if you press **Undo** and **Redo** after moving a pasted key.
+ The editor no longer stops working if you do the following: select the **Move** and **Scale** keys, change the time length of a sequence, save the slice overrides, and then undo the changes.
+ The **UI Editor** viewport is no longer captured in sequence renders.
+ Keyframe values are now updated properly when animated entities are given a new parent.
+ The editor no longer stops working if you delete a sequence while **AI/Physics** mode is enabled.
+ You can no longer add legacy entities, such as **GeomCache**, to component entity sequences.
+ You will now see a save prompt after adding a track view event and reloading the level.
+ Warning windows in the **Track View** editor now have a maximum size.
+ When you use the **Render Output** tool, the number of frames that are output now matches your settings.
+ When you change a render parameter, the **Update** button in the **Render Output** tool becomes active as expected.
+ The **Render Output** tool now exports the correct frames in a frame range.
+ The **Render Output** tool now shows a warning if you attempt to create a video and do not have FFMPEG set up properly.
+ The **Move** and **Scale** keys now affect even keys on the timeline as expected. Previously only odd keys were moved and scaled.
+ After you select a component node in a sequence, you can select tracks from the **Tracks** toolbar.
+ You can now change the type of fog volume in the **Track View** editor.
+ The **SequenceAgent** component no longer remains on entities after they are removed from a sequence.
+ The frame rate for the track view render output is no longer a fixed value of 60 fps.
+ The brightness level of the **Light** component with a color track is now the same in both game mode and the preview.
+ The Asset Processor no longer stops working if you animate **CAnimEnvironmentNode** in the **Track View** editor.
+ The changes that you make to material nodes in the **Track View** editor now match the behavior of the nodes that you changed in the **Material Editor**.
+ When you set a color key in the **Track View** editor, that color is now properly translated to the track view RGB settings.
+ Track view node effects are no longer active after you delete a node or create a new level.
+ The editor no longer stops working if you enter game mode or switch levels.
+ Sequence data for environment probes is no longer corrupted when saving.

### UI Editor<a name="ui-editor-fixes-v1.14"></a>

The UI Editor has the following fixes:
+ Flipbook animations now finish at the last sprite.
+ Read-only fields that are not editable appear correctly.

### Miscellaneous<a name="miscellaneous-fixes-v1.14"></a>

Lumberyard has the following miscellaneous fixes:
+ The AZ\_EBUS\_BEHAVIOR\_BINDER\_WITH\_DOC macro now applies names properly.
+ Asset Processor correctly displays the output on top of other windows.
+ `AZStd::vector(size_type)` constructor no longer requires the copy construction for type.
+ `AssetDatabase` no longer sends `AssetReady` events for assets that have already been spawned.
+ `AZStd::list` constructor now initializes member variable `m_numElements`.
+ Slices no longer randomly fail to compile when multiple platforms are being processed at the same time.
+ The Python command `general.unload_all_plugins()` has been removed.
+ The Resource Compiler no longer stops working when you click **Zoom in** or **Zoom out** after opening a non-power-of-two (NPOT) file with the **Opacity** parameter set.
+ You can modify your materials without needing to delete the `.mtl` files or the `fbx.assetinfo` files.