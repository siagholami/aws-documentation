# Fixes<a name="lumberyard-v1.0-fixes"></a>

Lumberyard Beta 1.0 includes the following fixes:

**Audio**
+ The editor no longer stops working if the audio logger accesses an invalid console variable pointer.
+ The GameAudio class no longer attempts to parse obsolete audio XMLs.
+ Audio execution is no longer triggered by hidden entities.
+ Audio implementation is now validated before creating an audio proxy.
+ The default value for SDL Mixer events is `start`.
+ The communication handler can now be notified when a sound stops playing so that listeners can receive a sound stop event.
+ The audio module is now shut down last, preventing dangling audio proxy pointers.
+ Increased the Wwise thread stack size to allow for heavy log functions.
+ The `default_controls` directory is not created if controls already exist in the project.
+ Names are now validated before creating a directory.
+ Switches and states are now loaded properly.
+ Fixed an issue that prevented animation events from playing sounds.
+ Icons now properly appear in the Audio Controls Editor.
+ Fixed audio obstruction and occlusion ray casting.
+ Fixed an issue that prevented area shapes in standalone from processing entity movement inside the shape.
+ Fixed an issue that prevented icons in the Audio Controls Editor from displaying correctly.

**Character and Animation**
+ The updated `PakSystem GetLength()` function now correctly processes animations.
+ The **AnimEvent** system can now enable the use of sound events.
+ Inverse kinematics are no longer applied when animations aren't playing.
+ Animations automatically restart when you change flags.
+ `SkeletonEffectManager::IsPlayingAnimation` now checks all animation layers. Previously it only checked the first four layers.
+ The skeleton extension now works with `FacialInstance`.
+ Bone effector rotations now rotate as expected.
+ Aim or look poses can now use skeletons with 255 or more joints.
+ The Character Parameters Editor (CHRPARAMS) no longer stops working when you select the **IK Definition** tab.
+ COMB blend spaces now use the closest blend space if no parameters directly match.
+ Additive animations are now played on upper layers if no base animation is playing.
+ Animation events paths are no longer reset when using skeleton extensions.
+ The AI system features the following fixes:
  + The debug draw mode for the modular behavior tree is now bound to the AI debug target. The console variable `ai_DebugBehaviorVariables` is no longer used.
  + You can now create and return a default path follower (`PathFollower`). You can specify the path follower parameters (`PathFollowerParams`) and path obstacles (`IPathObstacles`).
  + `AIMoveSimulation` now uses the movement system.
  + An input action now triggers debug visualization of an AI agent. This action is mapped to the **/** key.
  + A new base AI extension for the actor is used for game object extensions for the AI-specific actor.
  + Added a modular behavior tree actor extension, which enables the execution of actor behavior. The modular behavior tree also registers and handles actor events, and loads files from the `libs\ai\behavior_trees` folder.
  + You can now start and stop behavior trees using the **Modular Behavior Tree Editor**.
  + The AI movement system now resets on the level unload event.
  + AI characters now appear correctly in the movement system after quick loading.
+ **Mannequin**
  + The editor no longer stops working when you undock panes or move your mouse pointer over the sequence dope sheet.
  + In the **Edit Context** window, a Fragment ID can now appear once.
  + The **Context** menu in the Fragment browser acts upon item click, rather than last selected item.
  + The FragmentID Editor now scans for all XML files, ignoring the rest of the file name. The results list is not case sensitive and lists all matches.
  + The error report now appears correctly when opening a preview file.
  + ProcLayers now properly serializes dataString2.
+ The **Delete Assets** dialog box now works as expected. The dialog box displays assets for you to review and confirm their deletion. You can also add assets to the list or deselect an asset before deleting the remaining selected assets.
+ The camera now orbits around a target as expected.
+ You can now right-click the **Name** field in the skeleton list to remove a skeleton alias.
+ The editor no longer stops working when you right-click the name of a property and choose **Remove**.
+ The editor no longer stops working when using out-of-range entry point values in a blend space file.
+ Fixed an issue that prevented the RC Compiler from compressing skeletal-based animation files (`i_caf`) unless the skeleton list was saved before compression.
+ Fixed an issue that caused validation errors.
+ Fixed an issue that caused UDP settings to generate an unexpected phys mesh.
+ Fixed an issue that caused unexpected rotations for certain animations during blends.
+ Fixed an issue that prevented the game from starting or playing properly when the **Material Editor** was open and a material was selected.
+ Fixed an issue that prevented warning messages from displaying properly.
+ Fixed an issue in the Geppetto tool that prevented blend spaces from rendering correctly.
+ Fixed an issue in the Maya Lumberyard Tools that caused the validator to display an incorrect warning for physics meshes present in skeletons.
+ Fixed an issue in the Maya Lumberyard Tools that caused warnings to display about duplicate object naming when exporting geometry.
+ Fixed an export issue in Autodesk Maya that occurred if a material was renamed and it was part of an existing material group.
+ Fixed an issue in Autodesk 3ds Max that caused the **Show in Explorer** button to navigate to the location of the `.max` file instead of a custom path, if specified.
+ Geppetto now renders as expected.
+ Geppetto no longer stops working if an attachment referenced by another attachment is deleted.
+ Geppetto no longer stops working when certain values are input into the decimal field of a spring ellipsoid attachment.
+ The Mannequin Editor no longer stops working when authoring transitions with no preview loaded.

**Cinematics**
+ Soundtrack keys at the start of a sequence now play reliably on start and loop.
+ You can now customize the track colors as expected.
+ You can now delete keys from the Track View Curve Editor.
+ You can now delete keyframes.
+ The spacebar no longer toggles playback from all the **Track View** editor focus windows.
+ In the **Curve Editor**, unify tangents have been upgraded:
  + Unify tangents are now stable; previously linked, nonflattened tangents exhibited erratic behavior.
  + Unify tangents no longer flatten in/out tangents on the first unify-tangent drag adjustment.

**Cloud Canvas**
+ Removed duplicate player access definitions for uber builds.
+ Removed the `S3EventLogger` node from flow graph.
+ AWS calls within AWS dialog boxes are now fully asynchronous through QT threads and signals (creates, updates, describes, and deletes for Amazon S3, AWS Lambda, Amazon DynamoDB, and Amazon SNS).
+ Region selection now works in the following dialog boxes: Amazon S3, Lambda, DynamoDB, and Amazon SNS.
+ Fixed an issue that prevented the Amazon SNS Editor from opening correctly from the AWS menu in Lumberyard Editor.
+ Unless changes have been made, the **Save** and **Restore Defaults** buttons remain disabled.
+ Log files are now stored in a logs subdirectory (`/Logs`).
+ The SNS subscribe flow node (`SnsSubscribe`) now displays the email protocol option.
+ The editor no longer stops working when attempting to delete AWS credentials.
+ New Lambda functions can now be created as expected.
+ Deleting a bucket from Amazon S3 now works correctly.
+ Scan and query filter requests now properly use expression attribute names, preventing reserved word and character conflicts from occurring.
+ Key-based DynamoDB flow nodes now support key names for each table instead of only accepting hk. `Hk` is still the default value.
+ In the AWS Credentials Manager window, the available users now appear properly in the menu.

**Flow Graph**
+ The editor no longer stops working when you reload an entity script to add a flow node port and then change the port values.
+ The `start` flow node that activates at game start now works properly when using flow graph with the EmptyTemplate project.
+ Modules no longer trigger just one instance.
+ The node **Inventory:EquipPackAdd** now works properly.
+ The flow graph input key now works properly when AI or Physics are enabled.
+ Basic entities that are removed using Flow Graph now reset when exiting game mode.
+ The play state of the node `Animations:PlaySequence` is now updated when the sequence stops.
+ You can now remove a node from the node `RandomTrigger` without breaking the functionality.
+ The editor no longer stops working when switching between the viewport and flow graph.
+ Added a default content type for S3FileUploader. An error message appears if the content type is not specified.
+ Added entries to the `substitutions.xml` file for `GameTokenSet` and `GameTokenCheck`.
+ Added a flow node to set the default region.
+ Added the following flow nodes: `RemoveEntity`, `BoundingBoxVsBoundingBox`, `BoundingBoxVsSphere`, `RotateVec3OnAxis`.
+ Added an optional call to `BaseMaglevFlowNode` for **GetUIName** to display a different name for a node in the UI.
+ Updated the `DynamoDBUpdate` node to allow reserved characters in attribute names.
+ The `Xml::OpenDocument` flow node now supports files that do not end in `.xml`.
+ Fixed issues in Math Trigonometry nodes that prevented nodes from triggering or returned incorrect values.

**Gems System and Gems**
+ The editor no longer stops working when using the Boids Gem to add snakes to a level.
+ Boids now spawn properly.
+ Fixed an issue that caused the Lightning system to stop working.
+ Fixed an issue that prevented tornadoes from placing correctly in a level.
+ Fixed an issue with GameEffects in release.
+ Fixed an issue with the lightning arc that caused memory to leak.
+ Various fixes to the Rain Gem include an issue with glossiness and reflection, mist properties, and the rain shader name.
+ Gems are now identifiable by friendly names instead of just GUIDs.
+ Gems that do no load properly now generate an error message instead of just a warning.
+ The gem-generated wscript file no longer fails on Darwin in macOS.
+ Rain in GameSDK now compiles in release when compiled alongside a project that has the Rain Gem enabled.
+ The GameSDK release build now successfully builds projects that include the Boids Gem.
+ The GameSDK release build now successfully builds projects that include the Snow Gem.
+ The GameSDK release build now successfully builds projects that include the Tornadoes Gem.
+ Release builds are now successful for builds with GameSDK and a project with the GameEffectSystem Gem enabled.
+ Release builds are now successful for builds with GameSDK and a project with the LightningArc Gem enabled.

**Levels and Environment**
+ Removed the **Calculate Terrain Sky** option.
+ Fixed assert in terrain when creating a level with a difference of RGB versus BGR.
+ Fixed an issue with **Generate Terrain Texture** that caused red and blue painted terrain colors to be swapped.
+ Fixed an issue that prevented the terrain layer painter from updating after loading layers from a layer (`.lyr`) file.
+ Fixed an issue that caused shadows to cast even after vegetation was deleted from the terrain.
+ Fixed an issue with skybox that caused clipping and other visual errors.
+ When using the **Refine Terrain Texture Tiles** option under **Terrain**, the first refinement results in 256 x 256 tiles. Subsequent refinement results in 512 x 512 tiles.
+ When using the **Enable Noise** option, the default scale value is now `5` and the default frequency value is now `100`. This allows carving into with noise instead of only allowing noise extrusions.
+ When adding a new layer, the default layer texture is now `grey.dds`.
+ Added a progress bar for changes to the terrain tile resolution.
+ Various fixes include rain occlusion and state caching not working properly when toggling reverse depth.

**Lumberyard Editor**
+ The editor no longer stops working when you select and rotate multiple actor spawn points.
+ Fixed an issue that resulted in a texture and the words "compiling texture" overlaying the level.
+ Fixed an issue that caused the editor to stop working when using the Asset Browser to place an asset into an empty level.
+ Fixed an issue that caused the editor to exit if the Lumberyard Launcher INI file and executable are missing.
+ Fixed a bug in Lumberyard Editor that slowly degraded memory consumption and frame rate when a second rendering context was open.
+ Fixed call back registration logic in the `PropertyCtrl` class to prevent stalls when instantiating large property grids.
+ Fixed `sys_spec_ObjectDetail.cfg` to remove vegetation console variable warnings that displayed when starting the editor.
+ Fixed an issue that caused the editor to stop working on exit if the Lumberyard Launcher INI file is missing.
+ An error message no longer displays after opening the Mannequin Editor multiple times.
+ You can now use the `quit` command to exit the console.
+ A console variable error message no longer displays after opening the Facial Editor multiple times.
+ Square shadows no longer appear around characters in the CrashSite map.
+ The prefab library associated with a procedural prefab now saves prior to library load and conversion.
+ Fixed an issue that caused terrain set to 0 height to change to maximum height after saving and reopening the level.
+ Fixed an issue that caused a right-click menu to appear – and remain static – when you moved the camera near a selected object in rotate mode.
+ Fixed an issue that prevented selection of a sequence when the **Track View** editor window was docked.
+ Fixed an issue that caused AIM group generation in the Resource Compiler to fail and prevented aim/look poses from functioning correctly.
+ Fixed an issue that caused an assertion to fail when attempting to create a new level in Debug.
+ Recovered the GeomCache entity, which is used to store and play back animated geometry.
+ Recovered the CameraSource entity, which is used to determine the reference position from which a scripted camera view looks.
+ Removed an error message in the Texture Compiler that incorrectly stated `ripple#01_24_ddn.dds` does not exist.
+ Removed various unused systems and files, such as OLD\_VOICE\_SYSTEM\_DEPRECATED.
+ The editor no longer stops working in the following situations:
  + Creating a 3D object or editing a vertex, edge, or face
  + Clicking **Generate Textures**
  + Deselecting vegetation rendering in the Rollup Bar without a level loaded
  + Creating a new library and then attempting to undo the action
  + Cloning a group that includes a light you can't see
  + Creating a level without GameDLL
  + Quitting the debug configuration
  + Undoing a solid area
  + Cloning an archetype in the entity library
  + Selecting the wrong skeleton
+ When creating a new level, level data files are now created as expected.
+ Fixed an issue that prevented the editor from saving object primitives (for example, a sphere or box) that were created in a level when the object was the first one created and the object was selected upon exit.
+ Removed various error and warning messages related to opening levels with Perforce enabled or without Perforce installed/configured.
+ The Material Editor now creates materials in the correct folder.
+ The Material Editor no longer includes the **Generate Cubemap** button. You can generate cubemaps by using probes.
+ The static object groups for a vegetation object no longer export to all surface types that have at least one vegetation object with the same static object applied.
+ When in game mode, the mouse pointer now becomes active outside the viewport.
+ Selecting, editing, undoing, or deleting a prefab now works properly.
+ Reloading a library in Flare Editor now works properly.
+ The **Clear Registry Data** option no longer resets shortcuts during runtime.
+ Random objects are no longer deselected when using the group or ungroup options.
+ Shader constants are now refreshed when the values change.
+ Obsolete beam modes are now removed. You can use `r_beams` to toggle beam rendering.
+ Probe generation now uses full SSDO intensity.
+ Gbuffer velocity generation now works properly when tessellation is enabled.
+ Cubemaps are now used for translucency in standard deferred shading.
+ Shadow casting is now disabled based on the console variable `e_ObjShadowCastSpec` rather than using the system specs.
+ You can now use `m_TempMatrices[0][2]` for shadow cascade blending. Use `m_TempMatrices[2][0]` for forward shadows.
+ Modifying an object now updates the static shadow map.
+ Fixed an issue that prevented objects from being hidden if they were linked.
+ The editor no longer stops working when triggering sequences in game mode and then loading a new level.
+ The editor no longer hangs if GeomCache is set to **Play \+ Loop** on a `.cax` with a duration of one frame or less (no perceptible animation).
+ The editor no longer stops working while navigating a level in game mode or standalone mode.
+ The editor no longer stops working when attempting to exit while the UI Editor is still open.
+ Fixed multiple errors and warnings that occurred when loading the Trigger\_Sample map using `Editor.exe`.
+ Fixed the Move tool's reference coordinate system so it defaults to `Local`.
+ You can now use hyphens when naming your level in the **New Level** dialog box.
+ An erroneous message no longer displays if you attempt to create a new level without a name.
+ The editor no longer stops working when animated UVs are used in an alembic cache.
+ The editor no longer stops working when swapping the material for the LightningArc Gem.
+ When entering the start, end, and current times for **Time of Day**, you no longer need to press **Enter** after adding each value to save the values and have them take effect in Lumberyard Editor.
+ Fixed an issue with UseTerrainColor that caused nearby vegetation to have no color.
+ Fixed orientation issues with mega textures and heightmap when loading in BMP format. BMPs are stored inverted, so the mega textures and heightmaps must be flipped for the applied image to appear as seen in the DCC tools.
+ Fixed an issue with the ordering of scaling factors for a reference picture. Previously the X and Y scaling components were switched, resulting in the loss of the scale factor in one dimension. The **width**, **length**, and **depth** variable names have also been renamed.
+ The frame entity (Z-key) now frames entities so the objects are visible.
+ Sun rays visibility is now initialized properly following a level load.
+ Ocean specular now draws correctly when running the game.
+ The `Waterfall.cfx`, `Sketch.cfx`, and `Monitor.cfx` shaders no longer use the deprecated shader constant Ambientop.
+ Resetting the Time of Day settings now sets the values to the default, as if a new level has been created.
+ Material assigned to a designer object that has been exported and then added back into the editor as a brush or entity now loads properly with the object.
+ The **Global illumination** option under **Render Settings** now enables or disables global illumination as expected.
+ Total Illumination v2 now works properly without requiring a level reload.
+ Resolved an issue with the Camera Samples level when loading `SamplesProjectLaunch.exe`.
+ Fixed an issue with updating the vegetation panel that caused vegetation to become invisible.
+ Fixed a texture streaming assert caused by improper atomic initialization.
+ Fixed an issue that caused physics and camera angles from matching with the sample level.
+ The editor no longer stops working when loading a level, using the Modular Behavior Tree Editor, or holding the **Shift** key and moving while verts or edges are selected in CryDesigner.

**Lumberyard Launcher**
+ The **Launch Editor** button now launches Lumberyard Editor.
+ On the **Summary** page, the **Copy to Clipboard** functionality no longer includes markup tags.
+ On the **Required SDKs** page, the **Status** column now automatically expands to display the complete status (Required, Missing, etc.).
+ The launcher now includes descriptions of and instructions for the following SDKs: AMD GPU Services (AGS), Expat XML Parser, Lua, Lmza, Lzss, MD5, and Oculus.
+ The error log now provides more information about the error and why it occurred.
+ Fixed an issue that prevented the editor executable from launching if the file path had a space.
+ Fixed an issue that caused Lumberyard Launcher to start up off screen.
+ Fixed an issue that prevented the Autodesk Maya plugin from installing properly.
+ Fixed an issue that caused the Maya environment to become corrupted if a custom environment variable was used and the Maya environment was installed and uninstalled repeatedly.
+ Fixed a issue caused by an incorrect renderer font system dependency.
+ Fixed a issue when using IRenderAuxGeom.

**Material Editor**
+ New materials are created in a directory outside of the dev root.
+ The material browser now uses paths relative to the engine root directory (`\lumberyard\dev`) instead of the game directory.
+ Selecting the material from an object now works properly.
+ A new ScanDirectories method has been added that returns full file paths.
+ Fixed an issue where files without submaterials that are merged use the relative path to the material as the submaterial name, rather than using the base name of the file as the name.
+ Fixed an issue that prevented materials that are not multi-materials from merging correctly.
+ Removed **Fog** from the **Settings** menu in the **Large Material** preview window. This option was never fully implemented.
+ Merging newly created materials no longer creates a double entry for those materials in the tree pane.
+ Interactions with selected objects and buttons are no longer permanently disabled if nothing is selected when opening the Material Editor.
+ The Material Editor no longer stops working if left open and idle overnight.
+ Fixed an issue that caused selected materials to become deselected when undoing changes in the Material Editor.
+ Fixed an issue that prevented submaterials from deleting properly.

**Materials and Shaders**
+ Materials now finish compiling as expected in the Material Editor.
+ The DistanceClouds shader now factors in changes to the incoming texture matrix, which allows for the support of effects that manipulate the texture coordinates (such as texture rotation and oscillation).
+ The DistanceClouds shader now supports UV wrapping on the diffuse texture, which allows you to repeat textures.
+ The editor no longer stops working if you attempt to perform actions on submaterials or multi-materials.
+ The editor no longer stops working if you attempt to delete lightning objects with different materials. To prevent the renderer from halting, you must also remove any sparks from the deleted Lightning Arc. The renderer attempts to reference the material stored in the deleted Lightning Arc node.
+ Removed the following deprecated materials from `dev\Engine\EngineAssets\Materials\test`: alphaTest, brick, cloak, cloth, cloud, concrete, displacementMap, distanceClouds, eye, eye2, geometrybeam, glass, glow, hair, hair2, humanskin, humanskin2, illum, marble, monitor, metal, particleimposter, particles, ping, referenceimage, scopes, templebeamproc, terrain, tessellation, vegetation, and waterfall.
+ Fixed a typographical error for lighthousetemplebeam and updated the file path for `lighthousetemplebeam.mtl`.
+ Fixed an issue that prevented the **No shadows** flag from working properly with a skeletal mesh. Draw calls to shadow maps are now filtered per materials, and animated objects now respect the option to selectively cast shadows.
+ Fixed an issue that caused the "compiling textures" text displayed in texture swatches to appear mirrored or backwards.

**Maya Lumberyard Tools**
+ Restored \_group node functionality.
+ Fixed an issue with the Export Selected to Alembic functionality.
+ The Auto-Detect Geometry tool no longer detects physics meshes as CGA geometry exports.
+ Fixed an issue that caused the tool window to minimize if the tool button on the shelf was pressed while the tool was open.
+ Fixed various incorrect validator warnings.
+ An error message no longer displays when opening Maya exporter files from a directory location that has spaces in the path.
+ Fixed an issue that caused geometry to export to the file's root directory instead of the assigned export path.
+ Fixed an issue that prevented geometry from exporting if it had a physics mesh associated with the skeleton.
+ Fixed various issues related to file paths (display, browsing, and exporting), persistence when exporting data, and adding geometry as an export target multiple times.

**Networking**
+ Fixed Lua server properties to properly synchronize over the network to clients.
+ Fixed a client-server issue that prevented zombie animations from updating properly on the client side.
+ Fixed an issue that caused the networking dedicated server to stop working when using `sv_gamerules` by guarding the use of `Game::GetCurrentGameRules()` in case it returned null due to the use of unsupported rules.
+ Fixed an issue with the networking dedicated server that caused clients to get lost when reloading the map.
+ Fixed an issue with unbounded array access used to select a channel in the cached iterator.
+ Fixed an issue with game objects not having the correct initial state if the replica data has not changed since being bound.
+ Enabled the local caching of aspect profiles in the CGameObject.
+ Enabled replication of entities without CGameObject.
+ Amazon GameLift's new OnTerminate event is now handled properly.

****Particle Editor****
+ The preview window is now functional and draws the selected particle system.
+ The particle size and alpha settings can be reversed from a zero value.
+ Rotation curves now work for non-3D particles.
+ Geometry particles now scale off of size Y.
+ Emitters are now updated when `e_ParticlesThread` equals `0`.
+ Spherical rendering expansion is now based on the shortest axis, which fixes stretch and aspect issues.
+ Memory is no longer overwritten when particle vertex memory is low.
+ Particle alpha on refractive particles is no longer overwritten.
+ An issue that caused collision and timing issues and prevented child decals from spawning or sticking has been fixed.
+ Soft particles now use an inverse quadratic exponent.
+ Half resolution console variables are now properly obeyed.
+ The menu is now triggered only by left-mouse click. The context menu no longer appears when right-clicking a menu parameter field.
+ In the **Attribute** panel context menus, the **Reset** option is now named **Reset default**.
+ Curves now load properly.
+ The editor no longer stops working if you change a particle with a tail to have zero tail segments.
+ The editor no longer stops working if you delete a particle that has a child.
+ The editor no longer stops working if you create a particle with an invalid name (such as one that uses symbols) and then close the Particle Editor pane. If you create a particle with an invalid name, do not add the particle to the current particle library. This prevents the invalid particle from living invisibly in the particle library.
+ The editor no longer stops working if you attempt to change the **Inheritance** field for a child in a parent-child relationship.
+ Enabled and disabled particles in a library are now properly saved when the library is saved.
+ Fixed an issue that deleted level library particle emitters if the level was saved with unsaved particle changes.
+ Various fixes to the Gradient Editor include the following: The window size now properly resets to the original size; the cursor icon remains as expected when dragging keyframes out of the viewport area; changes to the **Location** text box update the gradient and key triangle.
+ Removed the **Add folder** menu item to temporarily address issues causing the editor to stop working.
+ When duplicating a folder in the library, you can now enter a new folder name at the same level as the duplicated folder.
+ When duplicating an emitter without providing a name, the duplicate is now given the same name as the original emitter and appended with a number. The group name is called **Emitter name**.
+ When resetting a color library to the default, the library name now resets as well.
+ Fixed an issue that prevented the color library creation process from being cancelled.
+ The active particle library is now displayed below the library pane header.
+ Fixed an issue that caused deleted particle emitters to still emit.
+ The editor no longer stops working when adjusting a particle emitter.
+ The editor no longer stops working after renaming multiple particle emitters.
+ The editor no longer stops working when reloading a particle library.
+ The editor no longer stops working when adding child emitters after applying recovery data from a previous failure.
+ The reset functionality for the preview window now resets all settings, including grid color and background color.
+ The emitter name color now indicates enable and disable states.
+ The size and shape of the gizmo now appear fixed regardless of the zoom level in the preview window.
+ The field highlight is now blue instead of black.
+ The **Particle Editor** gizmo now works as expected when you attempt to apply rotation.
+ The visibility state of gizmo is now saved across sessions.
+ The **Remove Library** option is now grayed out when the default library is active.
+ The **Reset to Default** functionality now works correctly in the **Color Picker** and **Gradient Editor**.
+ The name of the currently loaded library is now displayed.
+ The pan location in the preview pane no longer resets when orbiting the camera around the emitter.
+ The **View**, **Show Layout** menu in the Particle Editor now expands correctly.
+ The failure recovery functionality is now level-specific to prevent users from recovering particle libraries from an unrelated level.
+ All menus in the Particle Editor are now partially transparent.
+ You can now save the **Level** library in a particle library.
+ You can no longer type text in the drop-down menus.
+ You can now view added particle emitters in both the new and old editors.
+ You can now rearrange tabbed panels.
+ Failing to create a new particle due to invalid glyphs (such as a space) no longer populates the attributes and preview sections.
+ Creating a child emitter no longer causes the parent to reset to the default emitter.
+ Renaming a new particle with subparticles no longer adds a new particle to the list instead of renaming.
+ Renaming a particle to an item that already exists now appends a unique identifier to the end of the name.
+ Previously the particle count snapped to the maximum slider and you could scroll past the maximum slider by using the arrows. You can no longer use these sliders when entering integers.
+ Fixed an issue with the color picker that caused the view to toggle back to grid view when creating a new library.
+ Fixed an issue that caused data loss and corruption when attempting to add a directory to a particle library.
+ Fixed an issue with loading libraries. The following sequence now works properly: rename an emitter, move to a different directory, drag the newly named emitter from the library into the world editor, save the file, save the library, and load the library.
+ Fixed an issue that prevented the panel width from being adjusted properly.
+ Fixed an issue that caused recovered data from auto-backup to be lost if the editor shut down before the data was saved.
+ Fixed an issue with slow panning in the preview pane.
+ Fixed an issue that deleted an entire emitter when pressing the **Delete** key after editing a number field.
+ Fixed an issue that prevented a child of a newly added emitter from displaying properly. The **Show emitter with children** setting in the previewer now works correctly.
+ Fixed an issue that incorrectly displayed the children of a selected emitter when the **Emitter only** setting was selected in the previewer.
+ Fixed an issue that prevented the level library from loading and activating when a level was loaded if the Particle Editor was already open.
+ Fixed an issue that prevented the Particle Editor from fully exiting when using the quit keyboard shortcut (**Ctrl\+Q**).
+ Fixed an issue with drag and scrolling in the emitter list.
+ Fixed an issue with the playback time that caused changes to the Lifetime value and continuous play selection to be ignored.
+ Fixed an issue that caused the cursor to appear on the right side of the text field when renaming an element in the **Library** panel.
+ Fixed a graphical anomaly when editing the playback speed float field.
+ Various fixes to the emitter attributes include adjustment of the tab parameter traversal and correction of the input select functionality. Double-clicking now highlights the entire float. The emitter attribute panel now provides instructions if no library or an empty library is loaded.
+ Various improvements include truncating materials and texture paths for better readability, making rotation handles easier to grab, and making the data field highlight color consistent.
+ You can now undo a paste of an entire parameter category.
+ The **Undo** and **Redo** context menu options are now available for the parameters.
+ The duplicate emitter function is now case sensitive when searching for a new name for the duplicate emitter, preventing data from being overwritten.
+ Using materials as a particle no longer disables texture tiling.
+ Using a combination of Tessellation, Facing, Speed, and Light Source particles no longer render as large, black squares.
+ Removed black horizontal lines causing visual disturbance in the **Parameter** pane.
+ Fixed an issue that caused the default layout to change to a horizontally aligned configuration when opening and closing the Particle Editor.
+ Fixed an issue that prevented the level library from clearing the modified flag, resulting in prompts to recover unsaved changes that did not exist.
+ Fixed a issue caused by continually scaling a particle emitter in the level that treated particles like light sources.

**Player Identity**
+ Added PlayerAccess Lambda functions to resource management and added the ability for Lambda functions to discover their current configuration bucket and key.
+ Implemented player access control to restrict player access to specific feature resources.
+ The player identity pool from the configured release deployment is now used.
+ Added the following commands to the AWS CLI: `addLoginProvider`, `removeLoginProvider`, `updateLoginProvider`. These commands call into the AWS Key Management Service (AWS KMS) interface and Lambda interface, update the custom resource handler, and add the KMS keys to the project definition.

**Prefabs**
+ Fixed an optimization issue that caused object properties to update slowly when inside prefabs.
+ Fixed an issue that caused a prefab to lag when attempting to copy, move, or delete 10 or more flow graph nodes.
+ Changing an object that is part of a prefab propagates the object and its changes to all prefabs of the same type. Previously prefabs were being destroyed and recreated.
+ Extracting a prefab removes all prefabs of the same type from the level.
+ Copying and pasting nodes removes any entities that are assigned to those nodes.

**Project Configurator**
+ Newly created projects are no longer prevented from appearing properly in the project list.
+ Creating projects no longer results in broken `Projects.json` files.
+ The Project Configurator no longer fails when you attempt to disable a gem that is already disabled.
+ An existing project is no longer erased when you attempt to create a project from a template and use the existing project name.
+ The Project Configurator now builds properly when using lmbr\_waf, and only builds in the Windows profile and debug profiles.
+ The Project Configurator no longer duplicates `enabled_game_projects`.
+ Clicking the GUID in the Project Configurator now opens the correct gem directory.
+ The `Execute` command line functionality now works properly in the SampleProject and EmptyTemplate.
+ Builds now finish successfully even if the Project Configurator fails to find QT dependencies.

**Renderer**
+ An edge case exists where the sun vector aligns precisely with an edge of the far plane, causing all shadow casters to be culled and resulting in no shadows. This issue is now fixed and shadows appear correctly for this edge case.
+ The r16f blend modes and occlusion culling that interpreted FP16 data as FP32 on hardware that doesn’t support FB32 render targets is now fixed.
+ The WaterVolume shader now has minimum values of `0.01` for tiling, detail tiling, and rain ripples tiling to prevent visual artifacts when the value is set to `0`.
+ The tiled shading runtime flag is now enabled only when the console variable is set.
+ You can now use shape parameters instead of `AttenuationBulbSize` for spherical area lights.
+ To skip rendering of transparent objects, `r_UseAlphaBlend` and `r_TransparentPasses` have been replaced.
+ Extended the shadow cast minimum spec flags in the terrain data to support all specs.
+ Fixed an issue with terrain shadow maps. Use `e_GsmCastFromTerrain` and set the value to `1`.
+ Renamed the `surface_flow.tif` file to `surface_flow_ddn.tif` to prevent warning messages from displaying.

**Resource Compiler**
+ The Resource Compiler no longer stops working when attempting to calculate out-of-bounds material roughness. This fix also removes any visual artifacts caused by the error.
+ Lumberyard Editor now compares the modification times for files in a PAK with the files on disk. The editor no longer recompiles a resource if it exists in a PAK file and is newer than the uncompiled resource on disk.

**Resource Management**
+ Added resource management templates for the sample project resources.
+ Added the following CLI dependencies to the `3rdParty` folder: Python and AWS Python SDK.
+ You can configure your Lambda function code in different deployments.
+ You can specify the permissions for a Lambda function by using the same method you use when setting other permissions in Lumberyard templates.
+ You can update the default deployment that appears in Lumberyard Editor under **AWS**, **Active Deployment**.
+ You can specify user permissions for each feature resource or deployment. The resource handler creates, updates, and deletes an IAM role in response to create, update, and delete request types, respectively. The resource handler also adds or removes the identified resources to or from the defined roles for a project.
+ You can use the `Custom::PlayerAccess` resource definitions to specify the resources a player can access and the permissions the player needs to access those resources.
+ Updated Lambda function code to map logical resource names to physical resource names.
+ The command line tool can now be used to do the following:
  + Add or remove the definition of a feature in a project.
  + Add or remove the definition of a deployment in a project.
  + Update individual features and deployments.
  + Prepare the Lambda function code for a feature so that it can be used to create and update the `AWS::Lambda::Function` resources defined in your feature templates.

**Sample Project**
+ A new achievements example demonstrates how to unlock an achievement.
+ A new daily gift example demonstrates how to specify and grant daily quests and gifts, hook up the end date field, and create a game data lookup table.
+ A new message of the day example demonstrates where to store messages and how they are displayed in a game.

****Track View****
+ You can now use FBX to import and export camera animation between Autodesk Maya or Autodesk 3ds Max and Lumberyard Editor.
+ The **Track View** editor no longer stops working when you adjust the Start Time/End Time handles in the Animation Track for an AnimObject and the mouse pointer focus changes windows.
+ Fixed an issue that caused buttons to display outside the **Customize Track Colors** dialog box.
+ The file format is no longer reset when you select different render items in the **Batch Render** dialog box.
+ Values less than 0.25 are now respected when you render frames to disk.
+ The track toolbar no longer incorrectly adds **Track Add** buttons for any node with more than 22 possible tracks.
+ Cameras imported from Autodesk 3ds Max no longer have an extra 90 degree rotation.
+ You can now import Field of View from Autodesk Maya cameras. Maya cameras use FocalLength to represent Field of View.
+ Values now appear in the **Edit on Spot** dialog box when you double-click a keyframe.
+ The play head no longer advances beyond the end of a sequence when you press **Play** or the spacebar while the play head is stopped at the end.
+ The animation track on **AnimObject** no longer prevents the UI limits for keyframe start and end times from being set correctly.
+ The animation loop option on an **AnimObject** no longer ignores the start and end times after the first iteration.
+ The value sliders now work properly.
+ The editor no longer stops working when you add Mannequin keyframes to a Mannequin node without an action controller set.
+ The editor no longer stops working when you use animated UVs in an alembic cache.
+ The editor no longer stops working when working with ComboBoxes and keyframes.
+ Fixed an issue that overwrote start and end times when you select an animation track keyframe on an animObject.
+ Fixed an issue that caused duplicate nodes in a sequence when you delete a sequence and undo that action.

**Twitch ChatPlay**
+ When connecting to Twitch IRC, channel names are no longer case sensitive.
+ Twitch ChatPlay channels now close properly on destruction.
+ Twitch ChatPlay has been updated to ensure no busy waiting occurs during implementation.
+ Uninitialize events are now implemented for the `ChatPlayChannel` and `ChatPlayKeyword` nodes, which uninitialize any held channel and keyword references, respectively.

****UI Editor****
+ The **Recent Files** menu is now project-specific and still appears even when the list of files is empty.
+ **UI Editor** settings are now stored in an `.ini` file format rather than the registry.
+ You can now set the font effect in the **Text** component by using a drop-down list.
+ You can now perform move operations in the **Local** or **View** space by using the coordinate system toolbar.
+ Right-click in the viewport to choose options in the context menu.
+ When using the **Resize** gizmo with multiple selections, only elements without a parent element selected are resized.
+ The **Resize** gizmo now resizes around the pivot point.
+ The anchor icons now appear highlighted to indicate the anchors to drag.
+ To create sharper textures, UI elements are now drawn with vertices snapped to the nearest pixel.
+ Selection boxes on elements are now two pixels wide.
+ Using **Ctrl** \+ click to multiselect now works properly in the viewport.
+ UI canvases now load correctly on iOS.
+ The occasional assert "Unexpected value for m\_interaction type" has been fixed
+ Setting the UI element scale to `0` no longer causes problems.
+ **Property** pane interactions no longer break after you enter and exit game mode.

**Waf Build System**
+ Missing IncrediBuild installations no longer prevent builds from succeeding.
+ Linking in IncrediBuild now works properly. The name of the library being linked now appears. Double-click the library name to go to the log.
+ Executable attributes are now set for `lmbr_waf.sh`.
+ Failure logs now include information that can be used for troubleshooting.
+ Fixed an issue that caused user-defined capabilities in Lumberyard Launcher to be overwritten when running `Waf configure`.
+ Simultaneous link operations are now limited to prevent excessive build and link times.
+ Compiling uber files now works properly.
+ The generation of solution files is no longer prevented when you useLumberyard with Visual Studio 2015.
+ The `Qt.py` Waf script no longer causes erroneous inclusion of BINTEMP in the editor WSCRIPT.
+ Link errors in RC in `win_x64_performance` have been resolved.
+ Configurations that could not be built from the Visual Studio solution have been removed.
+ Performance and release configurations no longer prevent `dedicate_server` and `game_and_engine` from building properly.
+ AISystem and other systems are no longer recompiled needlessly when you build Waf.
+ DLLs are no longer rebuilt without dependent changes. This fix also prevents unnecessary files from copying on each build.
+ Compilation no longer persistently or randomly fails when you use IncrediBuild.
+ The Waf compile no longer fails when you build EmptyTemplate on the first attempt.

**Miscellaneous**
+ The ground plane is no longer clipped in the viewport when you look down using the Fly camera.
+ The viewport object selection context menu no longer prevents the **Reload All Scripts** context menu from working properly.
+ There is no longer a problem with the **Smart Object Editor** missing the `Libs/smartObjects.xml` file when you start it for the first time in a new level.
+ The **Pivot** tool no longer resets to the object origin when you switch tool modes.
+ The mouse scroll wheel now correctly scrolls the window, dialog box, or view that appears under the cursor.
+ Users are no longer prevented from moving items between layers.
+ You can now use the command line to override console variables.
+ The editor no longer stops working when you enable the `e_GsmStats` console variable.
+ Fixed an issue that caused unit tests to stop working.
+ Fixed a Perforce integration issue that impacted performance for the Layer Editor.
+ Fixed an issue that caused RC shell commands to disappear from the menu for PNG files.
+ Fixed an issue that caused a trigger area to be removed from trigger management at run time and disabled objects in that area from interacting with the trigger.
+ The XML parser for Booleans now supports true/false.
+ Fixed an issue with the server browser failing when attempting to join the same server twice. When the search handle is released, DemoServerBrowser now clears cached search results that are invalid.
+ When caching textures, the layer texture searches for `.dds` and `.tif` files.
+ Flow nodes can now be registered multiple times.
+ In Lumberyard Editor, `CLevelSystem::LoadLevel` now calls `C3DEngine::InitLevelForEditor` instead of `C3DEngine::LoadLevel`.
+ In the 3DS Max Lumberyard tools, the **Show in Explorer** button now navigates to the output as expected.
+ The following issues have been resolved: Abnormal shutdown when you load CrashSite, error when generating cubemaps, bug when loading materials from a modpath, Lumberyard Editor stops working when switching to a newly created level, incorrect path in the `PropertyProfiles.cpp` file, incorrect function name (`GetMemoryStatistics`) in the `ScriptBind_Game.h` file, and more.
+ Fixed divide-by-zero when loading maps with 0 sector size or 0 number of sectors.
+ Fixed an issue that caused the editor to stop working when loading a Gem texture in the UI Editor twice.
+ Fixed an issue that caused the camera to be placed at ground-level when running the game in PCLauncher.
+ Fixed an issue that prevented PCLauncher from starting.
+ Fixed an issue with case handling in TextureCompiler.
+ Fixed assert when loading a texture from the file browser.
+ Fixed baseless error reporting when generating cube maps.
+ Fixed various issues caused by:
  + Loading configuration files that were not null terminated
  + Attempting to join the same server twice
  + Linking two entities
  + Opening or creating a level when a level is already open
+ Fixed an issue that resulted from an entity with physics and no render component.
+ Fixed an issue that caused the editor to stop working when examining materials or WaterFogVolume.
+ Fixed an issue that caused the editor to stop working when loading a second map `CHeightMap::GetSurfTypefromUnits()`.
+ Fixed an issue that resulted when particles inherited from a parent that was disabled.
+ Fixed sRGB color issues that caused 2D textures to appear overly dark in-game and in the UI Editor.
+ Fixed FX and sky shader issues that generated errors.
+ Fixed an issue that caused the Assert Filter pipeline in the asset browser to have UI rendering issues.
+ Fixed an issue that prevented some commands from being called in Lumberyard Editor.
+ Fixed issues associated with switching the viewport layout with a selected designer object.
+ Removed all segmented world code.
+ GeomCache entities now play back node transformations (scale, translation, and rotation) from Alembic caches.
+ UV compression artifacts are fixed so that UV coordinates from Alembic caches correctly map 2D textures across a 3D surface.
+ Character instances now render properly in Lumberyard Editor.
+ The engine asset VolumeObject materials no longer appear black and do not produce excessive error output messages.
+ Other various fixes include dedicated server stops on startup, lobby failure, and PAK files causing a release mode failure, and renderer failing in the online lobby with debug build.
+ When creating a new level, the name can include only alphanumeric characters (a-z, A-Z, 0-9).
+ In game mode in Lumberyard Editor, the game camera viewport now syncs with the editor viewport aspect ratio (width and height).
+ The **Terrain Texture Layer** window now appears as expected after selecting a terrain layer.
+ The NavigationSeedPoint now highlights navigation mesh islands as expected.
+ The **Property** panel in the **Material Editor** now renders correctly on startup.
+ The `Group` node in the RPG Sample Launcher now loads correctly.
+ The dedicated server console now closes properly.
+ View space coordinate system transformations now work properly.
+ You can now select entities after deselecting an entity in rotate mode.
+ The **Rotate** tool now draws on the world axis when set to world mode.
+ The editor no longer stops working when rotating a designer object and then selecting another designer object.
+ The **Undo** option now works properly in the Flow Graph Editor.
+ Scripts now receive the appropriate signal when the **Physics** button is selected or the game is running and the scripts are reloaded or newly created.
+ Fixed an issue that caused the **New Level** dialog box to close and not reappear after entering an existing or empty level name.
+ Fixed an issue that resulted in zero available assets displaying in the asset browser.
+ Fixed an issue that caused the mouse pointer to be misplaced after creating an object in designer mode.
+ Fixed an issue that caused viewport labels to appear detached from objects in non-perspective views (Left, Top, or Front).
+ Fixed an issue that prevented importing an exported node that was attached to multiple nodes.
+ Fixed an issue that caused display issues for unlinked nodes in the Flow Graph Editor.
+ Fixed an issue that caused the editor to stop working when deleting a custom action or AI action.
+ Fixed an issue that caused simple comments added to a flow graph and groups created in a flow graph script file to disappear when loading a level.
+ Fixed an issue that caused an assertion failure when opening the Material Editor.
+ Fixed an issue with the `Vec3:Calculate` node that caused the editor to stop working.
+ Removed various files and console variables, including `LightBox.cpp`, `LightBox.h`, `m_vFadeAABB`, `r_DeferredShadingLightBoxDebug`, and `CLightBoxClassDesc`.
+ Removed an assert from `CD3D9Renderer::FX_DrawInstances()` that triggered if a shader received vertex information that did not match the intended layout, and prevented an object from rendering.
+ Fixed RemoveOnTrigger to work as expected, which is to destroy entities inside the proximity trigger volume.
+ Various fixes to shadow and light console variables include: updated tool tips for `e_ShadowsDebug` and `r_DebugLightVolumes`; updated formatting for `D3DShadows.cpp` and `CD3D9Renderer::DrawAllShadowsOnTheScreen`; removed `FX_CreateDeferredQuad` method, `CV_r_debuglights` and `CV_r_ShowLightBounds` console variables, and option from the `e_ShadowsDebug` console variable.
+ Various fixes to Lightbox include: removed light clip bounds feature (use clip boxes to clip lights); deprecated DLF\_LIGHTBOX\_FALLOFF and DLF\_HASCLIPBOUND flags and updated files impacted by the deprecation of DLF\_HASCLIPBOUND; removed bDeferredClipBounds check box and bHasBounds bool; renamed UpdateLightClipbounds to UpdateLightClipVolumes.
+ Implemented unit tests for the Cry Pak archive writing and reading system. Fixed bugs, including an issue that prevented CDR from being read when in read-only mode and an issue with the way zero byte files are handled.
+ Fixed an issue that prevented selected items from refreshing in Object Selector.
+ Fixed an assertion issue that occurred when attempting to add a vegetation object.
+ Fixed an issue that caused the **Layer List** box to lock when using Perforce.
+ Fixed an issue that caused CryAction to stop working when closing the WindowsLauncher.
+ Fixed an issue in AZCodeGenerator that caused an incorrect error condition.
+ Fixed UUID natvis to display the actual UUID instead of four 32-bit values.
+ Fixed `s wchar_t` on non-Windows operating systems.
+ Fixed an issue with clang-based builds that caused unquoted strings in the compiler define directive to be treated as a Unicode escape sequence. For example, directories that start with 'U' in the base Lumberyard path is treated as a Unicode escape sequence unless the compiler define directive uses quotes such as "\\U".
+ Fixed an issue that prevented Google from appearing as an option in the `ConfigureAuthenticatedPlayer` node.
+ Various fixes include updates to **Material Editor**, ReflectedPropertyEditor bug fixes related to groups, and a fix for azvsnprintf macro to allow buffer overrun if the supplied string is larger than the supplied buffer.
+ Fixed an issue that prevented the creation of a new level in a nested folder.
+ Fixed an issue that caused a texture compiling error message to display on startup.
+ Fixed various login issues and updated credentials management to be more user-friendly with Resource Management.
+ Lumberyard registry entries are now in the same location.
+ Various fixes include adding the ability to view and select roles in Lumberyard Editor and having that role determine the AWS interactions allowed in the UI.
+ Newly created levels now load properly and instead displaying a warning message.
+ Lumberyard Editor now recognizes a valid Perforce workspace.
+ The Release Server Only configuration now builds successfully.
+ Failure flags are now properly reset as the textures are loading, which prevents normal maps from having broken texture connections.
+ Textures are now automatically reloaded after compiling.