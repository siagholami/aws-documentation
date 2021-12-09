# Fixes<a name="lumberyard-v1.7-fixes"></a>

Lumberyard Beta 1.7, 1.7.0.1, and 1.7.0.2 include the following fixes:

## Lumberyard Beta 1.7.0.2<a name="lumberyard-v1.7.0.2-fixes"></a>

Lumberyard Beta 1.7.0.2 includes the following fix:

**Remote Shader Compiler**
+ You can now use a whitelist to specify the IP addresses that are allowed to connect to your remote shader compiler. For more information, see [Creating a Whitelist for the Remote Shader Compiler](https://docs.aws.amazon.com/lumberyard/latest/userguide/mat-shaders-custom-dev-remote-compiler.html#mat-shaders-custom-dev-remote-compiler-whitelist).

## Lumberyard Beta 1.7.0.1<a name="lumberyard-v1.7.0.1-fixes"></a>

Lumberyard Beta 1.7.0.1 includes the following fix:

**Multiplayer Sample Project**
+ The **MultiplayerSample** project requires a `certificates` folder in the `\dev\MultiplayerSample` directory. The Lumberyard Installer now includes the `certificates` folder during the installation process.

## Lumberyard Beta 1.7<a name="lumberyard-v1.7.0-fixes"></a>

Lumberyard Beta 1.7 includes the following fixes:

**Asset Pipeline**
+ The Asset Processor no longer continuously processes a file called `newpreview` in the Material Editor.
+ The editor no longer hangs while waiting for the Asset Processor to process jobs.
+ The method in which asset IDs are stored in the asset catalog and registry has been updated to resolve any issues between legacy and non-canonical assets.

**Audio**
+ The editor no longer crashes when using the `Audio:Trigger` nodes in a Flow Graph component's graph.
+ Level-scoped sound banks are now properly saved by ACE.

**Character and Animation**
+ The extra frame delay between entity and physics transforms has been removed.
+ Epsilon checks in root motion have been fixed, allowing small motions to now propagate.
+ Geppetto:
  + When importing multiple animations at the same time, all animations are now imported properly. Previously only the first animation was imported.
  + Double-clicking a loaded CDF no longer reports false errors the first time that animations are loaded.
  + The keyboard shortcuts for **Undo**, **Delete**, **Copy**, **Filter**, and **Cut and Paste** now work as expected in the **Assets**, **Properties**, and **Scene Parameters** panes.
+ Maya Plugin/Export:
  + Lumberyard Editor no longer crashes when exported or overwritten `.chr` files are open and running animations.
+ Mannequin:
  + The **File** menu has a **New Preview** item that allows you to set up initial files for new Mannequin controller definitions.
+ Hotloading:
  + Skin hotloading no longer experiences issues if the newly loaded skin has a different number of bones than the previous skin.

**Cinematics**
+ The `Material` node in the **Track View** editor now supports the animation **Emissive Intensity** on materials. The **Emission** track was renamed to **Emissive Color** for consistency with the Material Editor.

**Cloud Canvas**
+ In the Don't Die sample level, an error message is now displayed properly when Cloud credentials are not set up and you are attempting to enter game mode.
+ The **Add resource** button no longer remains in the same place.
+ The **Remove resource group** button now works as expected.
+ `lmbr_aws` now recognizes invalid projects in the `bootstrap.cfg` file.
+ In the Credentials Manager, you must enter an AWS key and an AWS secret key when editing a profile.
+ Cloud Canvas Resource Manager:
  + If an AWS call fails, stack update no longer fails with stack trace.
  + The text edit boxes in the **Create Deployment** and **Create Resource Group** windows no longer display black text on a dark background.
  + Newly created resource groups are now selected upon creation.
  + A resource configuration error no longer displays when a deployment is initially created.
  + Lambda functions cannot be created with an invalid string for a handler.
  + Lambda functions cannot be created with an empty handler.
  + Lambda Handler now validates for the maximum length.
  + DynamoDB cannot be created with an invalid hash name.
  + The **Import From** list search is no longer case sensitive.
  + Imported resources cannot have an invalid resource name.
  + Pressing **Enter** now opens folders.

**Component Entity System**
+ Component entities are now properly sorted in activation order in the editor.
+ Scaling an entity with a static mesh component on it now correctly cuts out an area of the navmesh.
+ Entities that are manipulated by the **Navigation** component no longer lose their transform.
+ The **Trigger Area** component is no longer positioned on the previous frame location of the trigger entity.

**Decal Component**
+ The **Decal** component's visual representation has been updated to follow the entity's transform position. Now when you use a **Decal** component and move the object in-game, the location of the decal is updated.

**Dynamic Slices**
+ Spawning a dynamic slice that uses a navigation area and navigation component request bus now moves toward the target entity as expected.
+ Asserts and errors that may occur in certain slice push operations have been fixed.
+ Dynamic slice compilation issues that are related to Gems modules and undesired asset reference expansion have been fixed.
+ Dynamic slices that contain references to level-owned entities now work as expected in game mode (Ctrl\+G).
+ Dynamic slices are now considered critical when processing assets. Dynamic slices include loaders, spawners, and bootstrappers.

**FBX Settings**
+ The combination of a physics rule and a material rule is no longer required to generate physics proxies for static meshes.
+ The `.fbx` files from gems are now available in the FBX Settings.

**Lua**
+ The Lua Editor now detects the end of a block comment and applies syntax color correctly.
+ A malformed property table entry in a component entity Lua script has been fixed.
+ Double garbage collection of the Lua VM has been fixed.
+ The **Open in Lua Editor** button no longer fails to open if there are spaces in the path.
+ The Lua IDE now shuts down cleanly and no longer appears in the Task Manager after shutdown.

**Lumberyard Editor**
+ The editor no longer crashes when:
  + You rename a submaterial while the preview window is minimized.
  + You rename a vegetation category.
  + You modify AI properties in the database view and then close the window.
  + Objects with active pick tools are deleted.
+ You can now apply a material that uses the lightbeam shader onto a projector component.
+ Terrain no longer appears as a black texture when exporting a level.
+ Screenshots now work properly with VFS enabled on PC.
+ The **Show bounding box** feature has been fixed to fit the particle animation as expected.
+ The light projector's FOV is now set to 180 degrees.
+ The samples for the Rain Gem and Snow Gem have been updated to fix color issues with lighting, time of day, and terrain.
+ The profiler now displays in the main viewport only. Previously the profiler would erroneously display in all preview windows.
+ The near plane of a projector light now affects the light projection.
+ The size and scale settings for volumetric fog now work properly.
+ The resource compiler no longer crashes when attempting to process a lens flare component within a slice.
+ Individual diffuse tinting is now supported for the blend materials, allowing you to change the diffuse color of individual materials.
+ You can now append \_TI or \_TI\_DYN tags to a light component entity name. This enables light bounce from the light component entity.
+ Particles now render properly around a player. Previously the emissive multiplier was too high, resulting in black squares rendered instead of particles.
+ You can now choose whether to use a customized cubemap or an autogenerated cubemap. If you choose an autogenerated cubemap, it will not overwrite the customized cubemap.
+ You can now use the **Particle Age** paramter (**Particles**, **Color**, and **Color Age**) to enable a particle to gradually fade out of existence. This applies to the Illum shader when geometry is attached to a particle.
+ You can now select an asset and then press **Shift** while double-clicking the end of the selection (asset multi-select) in the Object Selector tool.
+ In the Object Selector tool, the following options now work as described:
  + **Invert Selection** deselects all selected objects.
  + **Invert Selection Again** reselects all selected objects.
+ The terrain brush now displays a mouse cursor for **Rise/Lower**, **Smooth**, and **Pick Height**.
+ Hovering over a group heading now displays the appropriate tooltip.
+ The UiIn3dWorld level in FeatureTests now works as expected.
+ The Woodland level in GameSDK now loads properly in the editor and without XML file errors.
+ Opening the Sun Trajectory Tool for the first time no longer changes the sun trajectory in the level.
+ Various fixes improve the editor's performance and level the main viewport's performance to the equivalence of the game mode runtime's performance.
+ The following options now provide visual indication of the on/off status: **Angle Snap**, **Grid Snap**, **Snap to Terrain**, **Snap to Objects and Terrain**.
+ Operations in the database browser have been updated so that selecting objects is mirrored in the tree, and entering keywords into the search filter automatically expand the tree to display matching items.
+ In the **Rollup Bar**, the directory browser now remains open to the last directory that you used. Previously the entire directory would collapse upon exit.
+ In the **Rollup Bar**, the brush browser now expands to show the path of the brush that is selected.
+ Assets such as `.tif` files are now displayed as icons. Previously these assets were displayed as folders.
+ You can now change the size of the editor toolbar buttons by clicking **File**, **Global Preferences**, **Editor Settings**. Under **General Settings**, set the **Toolbar Icon Size** to **16**, **24**, or **32**.
+ The mesh now reports its readiness status correctly, allowing ragdoll to physicalize properly.
+ The Particle Editor no longer crashes when changing any attribute values on the **Attributes** tab.

**Lumberyard Setup Assistant**
+ Clang symlinks are now properly generated on Linux.
+ Prealloc files are now deleted if a download fails. Previously these files remained on disk.
+ An issue with the GUI failing to load due to invalid data in the registry has been fixed. The Lumberyard Setup Assistant GUI now loads consistently.
+ The `--nomodifyenvironment` flag is no longer ignored.
+ The Lumberyard Setup Assistant no longer crashes if a corrupt manifest is downloaded for a third-party SDK.
+ The progress bar no longer displays when all operations are complete.
+ Old symlinks and shortcuts are now removed upon launch, ensuring that the latest symlinks are correct for a completed setup.

**Material Editor**
+ The Material Editor no longer asserts or crashes in debug view if the preview window is sized to zero.
+ You can now edit path fields in the material browser. For example, you can edit the **Textures** field to specify a custom-named render target texture.
+ Selecting or editing a terrain material no longer results in an unresponsive Material Editor.
+ The Material Editor no longer crashes when you rename a submaterial while the thumbnail preview is hidden.

**Mobile**
+ Android:
  + Android Studio now uses the stripped libraries when debugging, which results in the same APK as building from the command line.
  + You can run the `configure` command while Android Studio is open. You are no longer required to re-import the project after running the `configure` command.
  + The game no longer asserts or crashes in debug, or freezes the application in profile when an Android device soaks on a level that has a physics simulation running.
  + You are no longer required to run Android Studio support as an Administrator.
  + Android NDK r13\+ libc\+\+ include path issues have been fixed.
  + Release builds are now supported. In order for this feature to work properly, you must modify a header file. For information, see [Building Android Games](https://docs.aws.amazon.com/lumberyard/latest/userguide/android-game-building.html).
  + Release builds are now monolithic.

**Networking**
+ The TargetManagement computer name length inconsistency is now fixed.
+ Component IDs are now propagated from the editor to game components during asset processing.
+ The SecureSocketDriver no longer crashes during shutdown.
+ A memory corruption issue has been fixed when a member is disconnected while being added from handshake.
+ If duplicated member IDs are pushed into the members list, the correct member is now deleted on disconnection.
+ If GridHub detects that its reference executable has been modified, `_copyapp_` is no longer appended repeatedly in the `bin` directory.
+ The `mpdisconnect` console command is no longer erroneously disabled.
+ SamplesProject no longer includes the **GameLift**, **CertificateManager**, and **Multiplayer** gems.
+ ReplicaMarshalNewTask no longer skips orphaned peers and no longer crashes when peers disconnect.

**Perforce Source Control**
+ The Perforce plugin now provides more helpful messaging if you are unable to check out files.
+ When values are updated, they are now updated in both the Perforce plugin and the Perforce component.
+ The source control API has been updated to ensure that the **Request Edit** operation does not falsely report a fail status.
+ The source control API has been updated to ensure that operations, such as **Marked for Add** or **Checked Out by Other**, are completed correctly.
+ The following Perforce plugin options now appear as expected:
  + **Copy Source Control Path to Clipboard**
  + **Check In**
  + **Check Out**
  + **Undo Check Out**
  + **Get Latest Version**
  + **Show History**
  + **Add to Source Control**

**Static Mesh Component**
+ When selecting a static mesh, only `.cgf` files are allowed. When selecting a skinned mesh, only `.cdf` files are allowed.
+ You can now adjust the mesh opacity by clicking **View**, **Open View Pane**, **Entity Inspector**. Click **Add Component** and select **Rendering**, **Static Mesh**. Expand **Options** and change the **Opacity** setting to a value up to 1.0.

**UI Editor**
+ Error reporting for Perforce errors has been improved to provide more descriptive messages.
+ The following UI functionality is now exposed to Lua:
  + Unload a canvas
  + Get/Set enabled state of a canvas
  + Get/Set enabled state of an element
+ When reselecting a UI text input component that is already selected, the virtual keyboard now remains displayed as expected.
+ On iOS, you can now enter extended characters with the keyboard.
+ The following text editing keys now work properly in preview mode:
  + **Del** – Deletes the character to the right of the cursor.
  + **Shift \+ arrow key** – Selects text.
  + **Home** – Moves the cursor to the beginning of the line.
  + **End** – Moves the cursor to the end of the line.
+ There is no longer a maximum font size for the UI text component. Previously the maximum value was 72.
+ Elements now rotate in the correct direction in the viewport, regardless of the scaling on the parent.
+ In the context menu, the placeholder icons for **Cut**, **Copy**, and **Delete** have been removed.
+ Animating base class properties now works as expected.
+ When copying and pasting elements, only the first element of a multiple selection is now considered.
+ When the game is paused, the UI now continues to update as necessary.
+ When a canvas is unloaded, the **Replace Me** texture no longer displays for one or two frames.

**Virtual Reality**
+ The Lumberyard Force Feedback system now allows targeted support of multiple devices. Previously the gamepad was the default.
+ The Flow Graph node flag called **Reset on level unload** now stores multiple values correctly.

**Waf Build System**
+ Waf now verifies the installed version of Microsoft Visual Studio before generating solution files.

**Miscellaneous**
+ Aligned malloc calls are now cross-platform in test environments.
+ The CivetWeb version that Metastream uses to address minor security issues has been updated.
+ HttpRequestManager no longer crashes if the network is disconnected during an Http request.
+ In the `LocalizedStringManager.cpp` file, the `string::npos` usage has been fixed to prevent a continuous loop when attempting to load the string.
+ There is no longer an extra frame delay between entity and physics transforms.
+ Cascaded asset loads with strong dependencies (PRE\_LOAD flag) no longer has the potential to cause live-lock with deep dependency trees.
+ You can now successfully build in release mode. An issue with the Metrics gem previously caused a crash in monolithic mode.
+ All URLS that point to Amazon Web Services endpoints now use HTTPS.