# Fixes<a name="lumberyard-v1.1-fixes"></a>

Lumberyard Beta 1.1 includes the following fixes:

**Asset Processor**
+ Fixed an issue that caused the Asset Processor batch to quit before the queue was emptied.
+ Fixed an issue that caused the Asset Processor batch to crash and tear down `AZ::Environment`.
+ Fixed an issue with the Asset Processor batch error message that prevented control from returning to the parent process.
+ Fixed an issue that prevented the Asset Processor from quitting immediately.
+ Fixed a virtual file system (VFS) issue that caused the Asset Processor to crash.
+ Fixed an issue with premature processing of files that caused failures in the Asset Processor.
+ Modified the Asset Processor to run in the background until it is accessed from the application.
+ Updated Lumberyard Launcher (now called Setup Assistant) so that it no longer crashes when opening the Samples Project launcher before the Asset Processor.

**Audio**
+ Fixed a bug with the Perforce plugin that prevented files from being marked for deletion when deleting audio libraries in the **Audio Controls Editor**.
+ Fixed a bug that prevented `OcclusionObstructionCalculationType` values from being set correctly.
+ Fixed a bug that prevented audio area shapes from setting the correct `OcclusionObstructionCalculationType` on initialization.
+ Fixed an issue with serialization of switch states in the **Audio Controls Editor** that caused duplication of states.
+ Fixed an issue with audio entities that caused looping sounds to play continuously across levels loading.

**Cinematics**
+ Fixed an issue in the **Track View** editor that prevented the **Add/Delete Nodes** and **Add/Delete/Modify Track Events** functionality from properly marking a layer as requiring a save.
+ Fixed an issue in the **Render Output** dialog box that caused frames for sequences with the parameter **Out of Range** set to **Constant** to render continuously.
+ Fixed an issue in the **Track View** editor that incorrectly displayed muting of nonmutable tracks.

**Cloud Canvas**
+ Removed the **Apply** flag from the Cloud Canvas nodes `ConfigureProxy` and `SetDefaultRegion`.
+ Removed duplicate **Success** ports from the nodes that inherit from `BaseMaglevFlowNode`, including the Cloud Canvas nodes `SetConfigurationVariable` and `GetConfigurationVariable`.
+ Updated the Amazon DynamoDB scan node to use the same StringLabel call as the Query.
+ Updated the feature template default value of DynamoDB tables to 1 for read/write capacity. Table values for the Don't Die project are set to 2 using the override in the `project-settings.json` file.
+ Updated the regular expression backslashes to \\\\ in the `SNSSubscribe` flow node.
+ Fixed a memory deallocation issue that caused the editor to crash or assert on shutdown.
+ Reworked the AWS C\+\+ SDK integration into Lumberyard to avoid using the concept of "features," which created unnecessary inclusions during compilation and linking.
+ Debugged the `SNSParseMessage` flow node to notify success and error, and adhere to current patterns with an explicit activation port and a single error port. SQS Poller now activates success on message receipt.
+ Fixed an issue with the `CBreakPointsTreeCtrl` not properly unregistering itself from the flow graph debugger that caused a crash bug when adding a breakpoint to a flow node.
+ Fixed an issue in **Flow Graph** that caused input and output nodes to reverse, causing erroneous collisions. This occurred when loading and checking for duplicate links.

****Flow Graph****
+ Removed an invalid flow graph that appeared when loading a new level during the editing of a flow graph.
+ Fixed the context menu in the tree view so that it now accurately represents the available actions.
+ Fixed an issue in which the **Delete** key deleted the selected node while you were editing comments or renaming nodes.

**Gems**
+ Caused all gems, including code, to be included when you deploy monolithic builds.
+ Removed an incorrect dependency from the Rain Gem in EmptyTemplate.
+ Various improvements to the Gems System's build system includes: 
  + Refactoring the Gem Manager to validate a project's gems dependency when using `lmbr_waf configure` instead of during runtime.
  + Adding validations for file format versions.
  + Adding error handling for badly formed UUID strings.

****Geppetto****
+ Fixed an issue with updating the animation filter for a `chrparams` file that prevented the file browser list in the tool from repopulating.
+ Fixed the **Show in Explorer** context menu option.
+ Fixed an issue that prevented the file explorer view from being updated when you add an `i_caf`.
+ Fixed an issue that allowed the skeleton alias assignment for an `i_caf` to be cleared during asset processing.
+ Fixed an issue that prevented gems assets from being added to the file explorer view.
+ Fixed an issue that caused Lumberyard Editor to crash when navigating above the engine root in the file browser.

**Lumberyard Editor**
+ Fixed an issue with FBX export from Lumberyard Editor that was silently failing.
+ Fixed an issue in the **Terrain Texture Layers** window that prevented the Rollup Bar from detecting any name changes to the layers.
+ The editor no longer crashes: 
  + When launching a project for the first time and closing Lumberyard Editor.
  + When selecting files from other branches in the **Recent Files** list.
  + On exit if you are creating a new level using a newly created project.
  + When clicking **Smooth Terrain** in the Terrain Editor, due to memory overwrites.
  + When opening the Database View.
  + After executing **Move Area** twice with the **Hold** option.
  + When attempting to set Source LOD without setting Source CGF first.
  + When using certain console commands.
  + In debug when configuring layout to multiple viewports.
  + When changing objects in an auto-merged vegetation group.
  + When enabling self-shadowing terrain.
  + When creating a new entity.
+ Fixed an issue that caused levels to save in an incorrect location.
+ Fixed an issue that prevented placing comments in the 3D view.
+ Fixed an issue that prevented recently opened levels from appearing in the **File** menu.
+ Fixed an issue that caused objects to scale inappropriately when tabbing through XYZ text boxes.
+ Fixed an issue that prevented XYZ text boxes from being updated when an object in the scene is moved, scaled, or rotated.
+ Fixed an issue that prevented uniform scaling when you manually typed a scale value for an object that is set to lock the XYZ values.
+ Fixed an issue with the initial loading of the Camera\_Sample level that caused balloons to fly into the sky while the sphere that they were attached to remained stationary.
+ Fixed an issue that caused the environment probe swatch preview to not work correctly.
+ Fixed an issue that caused the environment probe preview option to render as black.
+ Fixed an issue with opening the **Sun Trajectory** pane that caused the sun position to automatically move.
+ Fixed an issue with opening the **Texture Browser** that caused extended hangs and multiple files to not be found.
+ Fixed an issue that prevented small textures (32x32 or less) from reloading correctly and caused the textures to appear black.

**Lumberyard Launcher (now Setup Assistant)**
+ Improved with various UX updates.
+ Python is now required to run Lumberyard Editor.
+ Removed Clang from the `3rdParty` folder. In order to build the code generation tool, you must download Clang from the [Amazon Lumberyard Downloads](https://aws.amazon.com/lumberyard/downloads/) page.

****Material Editor****
+ Fixed an issue that caused significant reduction in the frame rate in the viewport.
+ Fixed an issue that prevented swatches from being rendered if the **Material Editor** was open when you switch levels.

**Maya Lumberyard Tools**
+ Fixed a bug that prevented Maya from writing MTL files to folder paths that did not already exist.
+ Fixed a bug with upgrading that caused old Maya animation data to update the end frame to a zero value instead of using the original value.

**Networking**
+ Fixed an issue that prevented clients from properly connecting to an Amazon GameLift session.
+ Fixed an issue that caused the second client to crash when running `mphost` on a client machine with another client already hosted.
+ Fixed an issue that caused GridMate to create duplicate GameRules entities when connecting to a server.

****Particle Editor****
+ Fixed an issue that caused the smart file search functionality in the **Import** window to not work properly, even with files stored under the `\Libs\Particles` directory.
+ Fixed an issue that caused an error message when you create an item in the **Particle Editor**.
+ Fixed an issue that caused duplicate presets to be added when you load a gradient library multiple times in the **Gradient Editor**.
+ Fixed an issue with the orient-to-velocity functionality not working correctly.
+ Fixed an issue with the **Particle Editor** window leaking 3 MB each time it is opened and closed.
+ Fixed an issue that prevented an exported particle library from being imported properly. The XML file can now be imported as expected.
+ Fixed an issue that prevented alpha clip from working properly.
+ Fixed an issue that prevented continuous particle emitters with **Remain While Visible** enabled from activating properly.
+ Fixed an issue with renaming particle emitters in the library that disallowed the use of 0 in the name.
+ Removed the **Focus** option from the **File** menu, which did not work.
+ Fixed an issue that prevented empty particle libraries from being saved.
+ Fixed an issue that prevented particle libraries from loading correctly if they were not in the `\Libs\Particles` directory.
+ Fixed an issue that prevented the names of the options under the **View** menu from properly reflecting the state of the pane when the pane is closed through another menu.
+ Fixed an issue that caused an error message to appear when you attempted to import a particle library in **Normal** mode.

**Project Configurator**
+ Improved with various UX updates.
+ Updated the Project Configurator to create a blank `user_settings.options` file if one has not yet been created. For example this happens if you run the Project Configurator before running `lmbr_waf configure`.

**Twitch ChatPlay**
+ Added the new Twitch IRC server selection logic to fix an issue that caused Twitch ChatPlay to function incorrectly for certain high-traffic channels.

****UI Editor****
+ Fixed an issue in which pressing **Ctrl\+Z** caused actions to be undone in both the **UI Editor** and the **Flow Graph** editor.
+ Fixed an issue that caused the **UI Editor** to attempt to undo changes even if there were no changes.
+ Fixed an issue that caused the **Undo** and **Redo** functionality to incorrectly add selected items.
+ Fixed a lag issue with the area selection tool.
+ Fixed a display issue in the sprite **Border Editor** that caused the left and top lines to be nearly invisible.
+ Fixed an issue that allowed prefabs to be saved with bad extensions or locations.
+ Fixed an issue that caused XML reader warnings to display after opening the UiDemo level. The XML reader warnings incorrectly messaged the inability to locate sprite files, which are optional.
+ Fixed the **Ctrl\+drag** and select functionality to work identically in the **UI Editor** and Lumberyard Editor.
+ Modified the **UI Editor** so that sample UI instructions no longer carry over when loading levels back to back.
+ Caused all root level element to appear collapsed when you load canvases.

**Miscellaneous**
+ Adjusted runtime flags to resolve issues when attempting to build a project with `bld.LumberyardApp(…)`. The runtimes are incompatible and result in errors if you use a Lumberyard static library.
+ Fixed a crash in profiling mode.
+ Fixed an issue that prevented a failed texture compile from being recompiled.
+ Fixed silent path adjustments when you work outside of your current project.
+ Fixed an issue with `Path::GamePathToFullPath` returning nonnormalized paths.
+ Fixed an issue that prevented you from entering game mode the first time you created a map.
+ Fixed a Python scripts issue that caused the **Show in Explorer** window to open in the user folder instead of the script location.
+ Fixed an issue that prevented the stereo mode and output UI from setting any values. Previously only console variables could set any values.
+ Fixed an issue that caused the Game SDK Launcher (`GameSDKLauncher.exe`) to crash if the Woodland level was loaded twice in a row.
+ Fixed an issue that caused an ambiguous symbol error when using namespace AZ.
+ Fixed an issue that caused the Debug Editor to crash when you dock a window in the main viewport.
+ Fixed an issue that prevented the grid and axis from being rendered in `OpreviewModelCtrl`.
+ Fixed an issue that caused the following error to appear when a multiplayer client connected to a dedicated server: "\[Error\] some merged meshes failed to prepare properly."