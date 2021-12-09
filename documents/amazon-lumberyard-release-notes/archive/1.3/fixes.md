# Fixes<a name="lumberyard-v1.3-fixes"></a>

Lumberyard Beta 1.3 and 1.3.0.1 include the following fixes:

## Lumberyard Beta 1.3.0.1<a name="lumberyard-v1.3.0.1-fixes"></a>

Lumberyard Beta 1.3.0.1 includes the following fixes:

**Lumberyard Editor**
+ Fixed two crashes in the editor when: 
  + You create a particle in the Particle Editor and select a texture or material from the Asset Browser.
  + You select textures after reopening the Asset Browser.
+ Known issue: Multi-selecting particles is not functional.

## Lumberyard Beta 1.3<a name="lumberyard-v1.3.0-fixes"></a>

Lumberyard Beta 1.3 includes the following fixes:

**Asset Processor**
+ Fixed an issue that prevented the Asset Processor from rebuilding folders that were renamed or moved to the Recycle Bin.
+ Fixed an erroneous message and the comparison function in the Asset Processor that caused jobs with a **Crashed** status to remain in the GUI.
+ Fixed a timing issue that caused the Asset Processor to communicate a few initial messages, resulting in the editor locking up while waiting.
+ Fixed an issue that prevented the Asset Processor from automatically reprocessing animations with a **Crashed** status when a skeleton list is added to Geppetto.
+ The game client must now wait for the Asset Processor to communicate that it is ready before the game can listen for messages about changed assets.
+ Increased the path size limit for scanning files changes in the Asset Processor.

**Character and Animation**
+ Geppetto:
  + Fixed an issue that caused an asterisk to incorrectly display next to assets that had been successfully saved.
  + Fixed an issue that resulted in user-specified playback rate being ignored after pausing and unpausing an animation.
  + Fixed various playback issues that occurred when adding and removing segment animevents.
  + Fixed an issue that caused a window to appear outside of the usable area, freezing the editor.
+ Mannequin:
  + Fixed an issue that caused multiple crashes when using Mannequin with no preview loaded.
  + Moved the clone keys functionality from **Shift** \+ click to the right-click menu.
  + The **InPlaceMovement** debug option now works properly.
  + You can now select zero blend time None clips.
  + Forced joint alignment in the editor so that weapons can attach properly.
  + You can no longer left-click twice for a new clip. Moved the new clip functionality to the right-click menu.
  + The proper variable name now renders for `crcstring2`.
  + None clip naming is now dynamically changed based on the blend time.
  + Fixed an issue with improper dynamic naming for procedural clips.
  + Added an option to force time warping if the animation was auto-updated.
  + You can now alias procedural clips to help with easier renaming.
  + Updated animFilter to search for procedural layer types.
  + If parameters only show under certain conditions, changing the conditions will now update the GUI.
+ Asset Processor – Fixed an issue that prevented animations from being processed from paths containing whitespace.
+ 3D Studio Max:
  + Fixed various issues with material editing in 3D Studio Max.
  + Fixed an issue that caused animations exported from Max files to contain multiple animation ranges.

**Cinematics**
+ Fixed an issue in the **Track View** editor that caused sound keys to play back when the play head was after the keyframe.
+ Fixed an issue that prevented screen fade textures from working properly in game launchers.
+ Fixed an issue with boolean tracks that prevented the property value from setting correctly when a sequence was loaded or started in certain cases.
+ Fixed an issue that erroneously allowed an entity's script property tracks to be added multiple times.
+ Fixed an issue that prevented the frame rate button icon from being legible in **Light Skin** mode.
+ Removed the deprecated **Ambient** track from **Material Nodes** in the **Track View** editor.

**Cloud Canvas**
+ Fixed an issue that prevented all components required by Cloud Canvas to install when selecting only **Run the Lumberyard Editor and tools** in the Lumberyard Setup Assistant.

**Flow Graph**
+ Fixed an issue that caused flow graphs to be deleted if you click **Undo** after deleting a component entity that has flow graphs.
+ Fixed an issue with the output ports being reversed for the `Math:EvenOrOdd` node. Odd numbers now generate an **Odd** output activation, and even numbers now generate an **Even** output activation.
+ Fixed an issue that caused the flow graph node `Math:Equals` to lose the properties stored on the input pin.
+ Fixed an issue that caused the editor to crash on shutdown when the Flow Graph editor was open.
+ Fixed an issue that caused entity assignments to be cleared when copying and pasting an entity with a flow graph.
+ Fixed an issue that caused multiple game side flow graphs to be created and executed.
+ The **Enable Debugging** and **Disable Debugging** context menu options in the Flow Graph editor now work properly.

**Lumberyard Editor**
+ Fixed an issue with the **Audio Resource** selector dialog that prevented the filter field from displaying results by expanding folders that contain matches.
+ Fixed an issue that caused the editor's performance to slow down when a large quantity of materials was open in the Material Editor.
+ Fixed an issue that caused the database view window to appear blank and the controls to disappear when pressing the **Esc** key.
+ The **Goto Selection** option in the **Display** menu now works as expected.
+ In the Material Editor, the buttons that appear next to each material name now open the source asset as expected.
+ The editor no longer crashes when: 
  + Attempting to clone a game token.
  + Selecting a mesh file.
  + Attempting to input a long name for a new level.

**Lumberyard Setup Assistant**
+ Fixed an issue with the inline text links not working properly on the **Install Software** page.

**Mobile**
+ Fixed an issue that prevented the Android NDK r11\+ from being detected when using Lumberyard Setup Assistant.
+ Fixed an issue with adding a connection in the Asset Processor for VFS with an Android device that prevented the connection from establishing properly.
+ Fixed an issue that prevented Android from deploying if Lumberyard is in a directory with spaces in the name.
+ Fixed various compiler issues for Clang 7.3.
+ Fixed an issue that prevented VFS mode functions from working properly for iOS.
+ Fixed an issue that prevented Mac xcode projects from generating if there were spaces in the directory names.
+ The Asset Processor now works properly on Mac computers with shared cache folders.

**Networking**
+ Fixed an issue that caused the client to crash when using the console command `mpstop`.
+ Fixed an issue that prevented GridMate from shutting down when changing maps.

**Particle Editor**
+ The **TIFF** button now opens the correct texture file.
+ You can now rename particles by clicking **Edit**, **Rename** in the menu bar.
+ You can now use size attributes finer than 0.01.
+ Removed a non-existent feature that the Particle Editor plugin references.
+ The editor no longer crashes when a particle library is added to a level but not saved in the Particle Editor.
+ Fixed an issue that impacted Lumberyard Editor performance when the LOD Generator was open.
+ Fixed an issue in the SpecularBRDF() where glancing view angles returned NaN (not a number) errors, causing screen tiles to intermittently render black.

**Sample Projects and Levels**
+ Fixed an issue that caused text artifacts to remain onscreen after text transitions in the Camera Sample and Don't Die levels.
+ Fixed an issue with the Camera Sample level that prevented the dynamic fly-by camera angle from functioning correctly when the **Cycle balloon cameras** button is used.

**Slices**
+ If you delete a slice, any slices that depend on it will no longer fail to load.
+ If you select multiple component entities and modify one axis, all entities will now align on that modified axis. All other axes remain unchanged.
+ When creating a slice in a level with other entities, an erroneous prompt about other referenced entities no longer displays.
+ When creating a new instance of a slice, all entities are now unselected to ensure only slice entities are selected after the instance is created.
+ Fixed bookkeeping of ID maps during slice instantiation, if a dependent slice asset changes significantly (e.g. entities added or removed).
+ Fixed an ID remap issue that caused new entities pushed to an existing slice to remap to the wrong entity ID in the target asset.
+ Fixed an issue with copying and pasting slices that created ghost copies of some components on all instances of the slice.
+ Removed redundant and unnecessary updates to `PreemptiveUndoCache`, which was costly for slice reference captures.

**Twitch ChatPlay**
+ Updated the Twitch ChatPlay default **Group Server** list to reflect Twitch's recent API changes.
+ Fixed a false positive runaway thread issue with CrySimpleManagedThread.

**UI Editor**
+ Fixed an issue that caused the UI Editor to become unresponsive after loading 20\+ UI canvas files.
+ Fixed an issue that prevented the undo/redo functionality from working properly for changes made to an element's visibility using the eye icon.
+ Fixed an issue that caused the default canvas size to display zoomed out on open.

**Cinematics**
+ Fixed an issue in the **Track View** editor that caused sound keys to play back when the play head was after the keyframe.
+ Fixed an issue that prevented screen fade textures from working properly in game launchers.
+ Fixed an issue with boolean tracks that prevented the property value from being set correctly when a sequence was loaded or started in certain cases.
+ Fixed an issue that erroneously allowed an entity's script property tracks to be added multiple times.
+ Fixed an issue that prevented the frame rate button icon from being legible in **Light Skin** mode.
+ Removed the deprecated **Ambient** track from **Material Nodes** in the **Track View** editor.

**Cloud Canvas**
+ Fixed an issue that prevented all components required by Cloud Canvas to be installed when selecting only **Run the Lumberyard Editor and tools** in the Lumberyard Setup Assistant.

****Flow Graph****
+ Fixed an issue that caused flow graphs to be deleted if you click **Undo** after deleting a component entity that has flow graphs.
+ Fixed an issue with the output ports being reversed for the `Math:EvenOrOdd` node. Odd numbers now generate an **Odd** output activation, and even numbers now generate an **Even** output activation.
+ Fixed an issue that caused the flow graph node `Math:Equals` to lose the properties stored on the input pin.
+ Fixed an issue that caused the editor to crash on shutdown when the **Flow Graph** editor was open.
+ Fixed an issue that caused entity assignments to be cleared when copying and pasting an entity with a flow graph.
+ Fixed an issue that caused multiple game side flow graphs to be created and executed.
+ Fixed issues with the **Enable Debugging** and **Disable Debugging** context menu options in the **Flow Graph** editor.

**Lumberyard Editor**
+ Fixed an issue with the **Audio Resource** selector dialog that prevented the filter field from displaying results by expanding folders that contain matches.
+ Fixed an issue that caused the editor's performance to slow down when a large quantity of materials was open in the **Material Editor**.
+ Fixed an issue that caused the database view window to appear blank and the controls to disappear when pressing the **Esc** key.
+ Fixed the **Goto Selection** option in the **Display** menu.
+ Fixed the buttons in the **Material Editor** that appear next to each material name so that they open the source asset as expected.
+ Fixed the problem that caused the editor to crash in these situations:
  + Attempting to clone a game token.
  + Selecting a mesh file.
  + Attempting to input a long name for a new level.

**Mobile**
+ Fixed an issue that prevented the Android NDK r11\+ from being detected when using Lumberyard Setup Assistant.
+ Fixed an issue with adding a connection in the Asset Processor for VFS with an Android device that prevented the connection from establishing properly.
+ Fixed an issue that prevented Android from being deployed if Lumberyard is in a directory with spaces in the name.
+ Fixed various compiler issues for Clang 7.3.
+ Fixed an issue that prevented VFS mode functions from working properly for iOS.
+ Fixed an issue that prevented Mac xcode projects from being generated if there were spaces in the directory names.
+ Ensured that the Asset Processor now works properly on Mac computers with shared cache folders.

**Networking**
+ Fixed an issue that caused the client to crash when you use the console command `mpstop`.
+ Fixed an issue that prevented GridMate from shutting down when changing maps.

****Particle Editor****
+ The **TIFF** button now opens the correct texture file.
+ You can now rename particles by clicking **Edit**, **Rename** in the menu bar.
+ You can now use size attributes finer than 0.01.
+ The **Particle Editor** plugin no references a nonexistent feature.
+ The editor no longer crashes when a particle library is added to a level but not saved in the **Particle Editor**.
+ Lumberyard Editor performance is no longer affected when the LOD Generator is open.
+ In the SpecularBRDF() glancing view angles no longer return NaN (not a number) errors, which previously caused screen tiles to intermittently be rendered as black.

**Sample Projects and Levels**
+ Fixed an issue that caused text artifacts to remain on screen after text transitions in the Camera Sample and Don't Die levels.
+ Fixed an issue with the Camera Sample level that prevented the dynamic fly-by camera angle from functioning correctly when the **Cycle balloon cameras** button is used.

**Slices**
+ If you delete a slice, any slices that depend on it no longer fail to load.
+ If you select multiple component entities and modify one axis, all entities now align on that modified axis. All other axes remain unchanged.
+ When you create a slice in a level with other entities, an erroneous prompt about other referenced entities no longer appears.
+ When you create a new instance of a slice, all entities are now deselected to ensure only slice entities are selected after the instance is created.
+ Bookkeeping of ID maps now works properly during slice instantiation, if a dependent slice asset changes significantly (for example, if entities added or removed).
+ An ID remap no longer causes new entities pushed to an existing slice to remap to the wrong entity ID in the target asset.
+ Copying and pasting slices no longer create ghost copies of some components on all instances of the slice.
+ Removed redundant and unnecessary updates to `PreemptiveUndoCache`, which was costly for slice reference captures.

**Twitch ChatPlay**
+ Updated the Twitch ChatPlay default **Group Server** list to reflect Twitch's recent API changes.
+ Fixed a false positive runaway thread issue with CrySimpleManagedThread.

****UI Editor****
+ Fixed an issue that caused the **UI Editor** to become unresponsive after loading 20\+ UI canvas files.
+ Fixed an issue that prevented the undo and redo feature from working properly for changes made to an element's visibility using the eye icon.
+ Fixed an issue that caused the default canvas size to display zoomed out on open.

**Miscellaneous**
+ Resolved the issue of Visual Studio not detecting gmock macros and includes since gmock headers are no longer included in a Visual Studio solution.
+ Streamlined the game compilation process by adding the `compilegame` tag to the SDKs that are required to compile game code.
+ Fixed an issue that prevented CryAction from unloading properly when closing EmptyTemplate, causing a shutdown crash.
+ Fixed an issue with CryName that caused a memory stomp.
+ Fixed an issue that prevented empty Lua script tables from being instantiated and unique table instances from being created.
+ Fixed an issue that prevented `AZStd::shared_ptr` from compiling in 32-bit mode for the Gem Registry.
+ Fixed an issue that caused a race condition crash when loading more than one `.cgf` file on map load. You can now open multiple files concurrently using `ICryPak::FGetCachedFileData`.
+ Fixed the **Navigation** component so that it now applies the path found in Profile builds.
+ Fixed the Lua debugger so that it can now connect to dedicated servers.
+ Fixed Prefab ID maps to keep them maintained properly during reloading, particularly when the data patch is null.
+ Fixed an issue in which caused the object stream to hang on loading while waiting for the task job if an asset handler has failed.
+ Fixed an issue with using IDH to synchronize containers that occurred in the element removal case.
+ Fixed an issue with unhandled pointer-to-pointer case in IDH compare and copy logic.
+ Completed various updates for `AZ::Outcome` include fixing copying issues when using `AZ::Outcome`, updating `azcore.natvix` to reflect changes in `AZ::Outcome`, and ensuring the underlying OutcomeStorage class is copied correctly.
+ Removed clamping from **Rotation** in the **Transform** component, and set the range in spin boxes to -float\_max to \+float\_max.
+ Fixed an issue with `m_editDataOverrides` logic that prevented pointers-to-pointers from being resolved before invoking user callbacks, resulting in a crash. Because the components container acts as the parent, pointers-to-pointers must be resolved when building a hierarchy from the entity level.
+ Fixed an issue with assets in a data patch stream being stored as text but interpreted by the Asset Serializer as binary, causing asserts during load.
+ Fixed an issue that prevented `FrameworkTests.exe` from testing code from the `AzToolsFramework.lib`.
+ Fixed an issue that prevented `Ed_keepEditorAlive` from working from `.cfg` files.
+ Adjusted the default error dump size for a dedicated server to ensure that the error dump is included in the log file.
+ Fixed an issue in which the editor crashed when you attempt to grab an AI human in-game that has an incorrect grab type specified in the entity properties.
+ Fixed an issue with dragging items such as **Simple Animation** from the component palette to the viewport.
+ Updated the **Lua Script** component to display the properties as expected.
+ Fixed an issue with right-clicking a highlighted (not selected) object and selecting **New Slice** that resulted in an empty slice. The object no longer loses its highlighted status when the context menu is generated and the object is selected. The select/highlight list functionality is now captured when the context menu is created.
+ Ensured that **Remove Component Mesh** now removes the **Mesh** component from multiple selected entities.
+ Prevented component entity properties from being edited when **AI/Physics** is enabled.
+ Added the PNG file rule, which allows `.png` files in the editor folder to be copied.
+ Fixed an issue that prevented the resource compiler's source control functionality from working properly.
+ Fixed support for the PVRTexTool.
+ Fixed an issue with checking the active window that caused the main window to slow down.
+ Removed an include from the interface declaration that forced all editor plugins to use MFC. Editor plugins now have the option to use MFC or not.
+ Removed Python 2.7.8 as a required third-party SDK if you select **Run your game project** or **Run the Lumberyard Editor and tools**.
+ Ensured that the Python script window now displays folders as expected.
+ Fixed an issue with clicking **OK** in the **New Lua Entity** dialog box when you use the Samples Project.
+ Ensured that editing the Vec3 values in game tokens now works properly.
+ Updated the assert dialog box to show the relevant part of the file path text by default.
+ Added an error message box if a level fails to be saves. Previously a message appeared in the log window as a warning.
+ Ensured that minimaps are now saved to the correct folder.
+ Added support for mMultiple in-flight `pCachedFileData` is now supported. Each request creates a cached file data and places it in a lock-protected data structure.
+ The Remote Console now connects to the specified port number to listen for game commands.