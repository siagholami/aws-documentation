# Fixes<a name="lumberyard-v1.2-fixes"></a>

Lumberyard Beta 1.2 includes the following fixes:

**AI**
+ The editor no longer crashes when: 
  + Attempting to grab an AI human in-game in the GameSDK project. This error occurred for AI humans that had a nonexistent grab type specified in the entity settings.
  + Saving CGF files for certain brush objects.

**Asset Processor**
+ Fixed an issue that caused the Asset Processor batch file to hang when attempting to cancel by pressing **Ctrl\+C**.
+ Fixed an issue that prevented Lumberyard Editor from launching if the Asset Processor from a previous build is running in the background.
+ Fixed an issue that caused exported geometry (`CGF` and `i_caf` files) from 3D Studio Max to appear as failed in the Asset Processor.
+ Fixed a bug that caused numerous Asset Processor icons to appear in the system tray after switching projects or closing tasks.
+ Fixed an issue that prevented the Asset Processor from identifying changes to `sys_game_folder` in the `bootstrap.cfg` file.

**Audio**
+ Fixed an issue with undoing operations that caused the **Audio Controls Editor** to crash.

**Cinematics**
+ Fixed an issue that prevented movies or frames in Lumberyard from rendering to the paths with spaces specified in the **Render Output** dialog box in the **Track View** editor.
+ Fixed an issue that caused incorrect sequence ranges to save when toggling between the **Seconds** and **Frames** time units in the **Sequence Properties** dialog box in the **Track View** editor.
+ Fixed an issue that caused the editor to crash when using sequence names over 1,000 characters long.

**Cloud Canvas**
+ Fixed a bug that caused `stackStatusListModel` to erroneously use `columnCount()` rather than the enum `ColumnCount` when filling out a row.
+ Fixed an issue with the mobile analytics client using the default retry strategy that caused long pauses when a network connection is not present.
+ Fixed an issue that caused `lmbr_aws` to crash if the metrics DLL does not exist.
+ Added validation for key name, bucket name, and file name in the **S3 Download** and **Upload** nodes.
+ Fixedthe **Forgot your password** link in the **Login to Amazon Lumberyard** dialog box to display the password assistance page as expected.
+ Fixed other issues, including removing a dangling GridMate GameLift reference from the Multiplayer Gem and removing an unnecessary dependency on IAM within Client Manager.

**FBX Settings**
+ Fixed an issue with importing FBX files that do not have a scene settings file that caused the Asset Processor to erroneously report a failure.
+ Fixed an issue that prevented the entry of characters that would have resulted in a duplicate group name.
+ Fixed an issue that caused the **Scale** property to allow both 0 and negative values when importing assets.
+ Extended the iterators in the scene API with unit tests.

****Flow Graph****
+ Fixed floating point precision issues that caused the flow graph node **Math:Equal** to become unreliable when reporting equality between numerical values.
+ Fixed an issue that caused the flow graph node `Math:EvenOrOdd` to reverse even and odd numbers for the node outputs.
+ Fixed an issue that caused flow graphs, game tokens, track view sequences, and objects to delete when right-clicking the viewport while a level loads.
+ Fixed an issue that caused the editor to crash when attempting to add comments to a new flow graph by using shortcuts (for example, **Right Alt\+F**, **Right Alt\+E**, **Right Alt\+V**, **Right Alt\+O**, or **Right Alt\+D**).
+ Fixed an issue that prevented an automatic refresh when a flow graph component is added to an entity.
+ Fixed an issue that caused the audio component to stop all triggers from executing on the owned proxy upon deactivation.
+ Fixed an issue that prevented the component flow graphs from uninitializing properly.
+ Fixed an issue that caused unusual behavior when selecting **Change Group Name** from the **Global Flow Graphs** menu.

**Gems**
+ Fixed a crash issue when shutting down the Gem Registry.
+ Fixed a shutdown crash issue in the Game Effect and Lightning Arc Gems.
+ Fixed an issue with deploying Monolithic builds for game projects that include Gems.
+ Fixed an issue with building tests for a new Gem that resulted in a failure and Uber file error.
+ Fixed an issue with release configuration failing on launch, resulting in a "Failed to load Gems project" error message.

****Geppetto****
+ Fixed an issue that prevented the animations list in **Geppetto** to remain in sync and display properly.
+ Fixed an issue that erroneously allowed invalid values (0 and negative numbers) for the scale when importing an FBX.
+ Fixed an issue in which the editor crashed when importing a new `i_caf` file with blendshapes.
+ Removed deprecated CGA files fom the character tree list.
+ Removed unsupported formats such as SKEL and DCGA from the skeleton file type list.
+ Fixed an issue in which the Resource Compiler crashed due to the system allocator from the Resource Compiler scene and scene API.

**Lumberyard Editor**
+ Fixed an issue that caused level slice to persist slice references across editor level sessions.
+ Fixed an issue that prevented scripts from successfully reloading in the editor for entity objects.
+ Fixed an issue that prevented the Camera Sample level's dynamic fly-by camera angle from functioning correctly when the **Cycle balloon cameras** button is pressed.
+ Fixed various stability issues with loading meshes.
+ Fixed an issue that caused the animation component to send multiple `OnAnimationStopped` events.
+ Fixed an issue with live-lock during loading if a level includes a certain number of mesh assets.
+ Fixed an issue that prevented the **Component Palette** window from unregistering from the plugin and closing properly.
+ Fixed an issue with invalid bound on an object when instantiating component entities from a slice, resulting in the object being off at the origin and breaking selection in the editor.
+ Fixed an issue that prevented values to be set when rotating a designer object on the y-axis to 90 or -90 and beyond.
+ Fixed an issue that prevented the use of spaces in the Lumberyard installation path.
+ The editor no longer crashes when: 
  + Selecting a mesh file in PreviewModelCtrl.
  + Attempting to push entity changes to a slice.
  + Reloading slices and the flow graph wrapper accesses deleted objects.
  + Using proximity triggers that activated only once in profile.
  + Dragging an asset from the file browser into the viewport when a level is not loaded.
  + Cloning a game token.
  + Modifying the level library before loading a level.

**Lumberyard Setup Assistant**
+ Changed the default SDK requirements for running a game. If you want to compile game code only, you can now run a Waf configuration step. The Codejock Xtreme Toolkit Pro, which is included with Lumberyard, is now marked as required.
+ Fixed various issues, including updates to text, icons, and page functionality.

**3DS Max Exporter**
+ Fixed the issue of the editor crashing when setting up an AnimObject that uses a character and animation exported from 3D Studio Max.
+ Fixed an issue that misaligned the skin and bones after exporting from 3D Studio Max and assembling in **Geppetto**.

**Mannequin**
+ Fixed an issue that prevented the **Transition Editor** from saving changes to procedural clips.
+ Fixed an issue that prevented the Mannequin sequence file from saving properly.
+ Fixed an issue that caused Maya 2015 to crash when using the user defined properties (UDP) tool.

**Mobile**
+ Fixed an issue that caused textures compressed by the Resource Compiler with `colorspace=*,[auto|sRGB]` to crash when loaded on iOS.
+ Fixed an issue that prevented skinned character shadows from working correctly in the GMEM render path.

**Networking**
+ Fixed a buffer overflow vulnerability in `CarrierThread::ProcessIncomingDatagram` when receiving incoming datagrams.
+ Fixed a buffer overflow vulnerability in `CarrierThread::ReadAckData()` when receiving malformed system ack messages, preventing a denial of service.
+ Fixed a crash in the object stream when skipping unreflected root node in binary mode.
+ Fixed a bug that prevented game code from receiving the SignIn system event.
+ Fixed a bug that prevented RPCs from being called for proxies when multiple chunks were bound to a replica.
+ Fixed a bug for processing unknown chunk types.
+ Fixed an issue that caused existing players to disconnect and the server to crash if the number of players attempting to connect exceeded the maximum number of players allowed, as specified by the `sv_maxplayers` value.

**Particle Editor**
+ Fixed an issue that prevented the **Gradient Editor** from preserving set values.
+ Fixed an issue that caused the delete confirmation dialog box to appear twice when attempting to delete a particle or folder.
+ Fixed an issue that prevented a modified color value from saving to the XML file.
+ The editor no longer crashes: 
  + After editing a particle from an imported library and closing the Particle Editor by clicking **Cancel** in the warning message dialog box.
  + After creating a library and closing the Particle Editor without saving the library.
  + When attempting to hide the **Attribute** panel in the Particle Editor.
  + In debug when configuring the layout to use multiple viewports.
+ Fixed an issue in the particle library version 27 that prevented particles from loading correctly.
+ Fixed an issue that prevented "forward" planar decals from rendering properly in certain projects.
+ Fixed an issue that caused materials cloned with a `.ddna` file to bind an incorrect smoothness or gloss texture.
+ Fixed an issue that caused the sun position and lighting to move when opening the **Sun Trajectory** pane.
+ Fixed the particle orientation so that it now loads correctly in a level.
+ Fixed the environment probe preview option so that is it now rendered correctly.
+ Added support for MIN\_MAG\_MIP\_LINEAR as a shader token, which resolves asserts in debug.

**Project Configurator**
+ Fixed an issue in which a warning message about running `lmbr_waf configure` would disappear after a new project was created. The warning now persists within a single session of the Project Configurator.

**Sample Levels**
+ Fixed an issue that caused a "texture file missing" warning message to appear when opening the Animation\_Basic\_Sample level.
+ Fixed an issue that caused the Animation\_Basic\_Sample level to crash when using the `SamplesProjectLauncher.exe` standalone launcher.

**UI Editor**
+ Fixed the pop-up position of the sprite **Border Editor** and the Anchor Presets widget.
+ Fixed various issues with running a game in the editor and loading a canvas in a game that is already loaded in the **UI Editor**. For example, loading a canvas in-game when it is loaded in the editor results in a copy of the canvas that the game is using.
+ Fixed a bug in the **UITextInput** component that prevented selecting a text range backwards from functioning correctly.
+ Fixed an issue with sliced images where the image rectangle is thinner than the sprite borders, resulting in overlapping borders.
+ Fixed a bug that saved changes when clicking **Cancel** in the sprite **Border Editor**.
+ Fixed a bug that caused the browser to save changes when clicking **Cancel** in the **Changes have been made** dialog box.
+ Fixed an issue that caused the **UI Editor** to become unresponsive when 20\+ canvas files are open in the editor.
+ Reinstated the **Font Effect** property in the **Text** component property pane.
+ Fixed the image texture browser so that it now properly supports the file formats listed in the browser: `.bmp`, `.dds`, `.gif`, `.jpeg`, `.png`, `.tga`, and `.tif`.

**Miscellaneous**
+ Fixed an issue that prevented `AZStd::conditional_variable.wait(…)` from halting a thread.
+ Fixed an issue that prevented the `AZ::Entity` cached shadow from updating.
+ Fixed an issue that caused `AZ::Entities` to vanish when moved from the initial position.
+ Fixed an issue with selecting more than eight entities by adding entries to the dynamic pop-up menu allocation.
+ Fixed an issue that caused the Resource Compiler to connect to Perforce during asset processing, even though the Perforce plugin is disabled in the editor.
+ Fixed an issue in which saving changes in the **Audio Controls Editor** broke the Perforce connection and displayed an error message.
+ Fixed various issues with the CodeGenPreview solution, including updates to AZCore/AZCoreTests and support for proper include paths for rapidxml.