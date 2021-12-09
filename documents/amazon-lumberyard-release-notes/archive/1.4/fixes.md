# Fixes<a name="lumberyard-v1.4-fixes"></a>

Lumberyard Beta 1.4 and 1.4.0.1 include the following fixes:

## Lumberyard Beta 1.4.0.1<a name="lumberyard-v1.4.0.1-fixes"></a>
+ Fixed a permissions issue with usage metrics uploads.

## Lumberyard Beta 1.4<a name="lumberyard-v1.4.0-fixes"></a>

**Character and Animation**
+ Geppetto:
  + Fixes to side-by-side compression view include: 
    + Adding support for side-by-side compression view.
    + Fixing synchronization between compressed and uncompressed animations.
    + Fixing size reporting for animations in side-by-side compression view.
  + Fixes to saving data include: 
    + Preventing data loss when closing Lumberyard Editor with unsaved changes in Geppetto. If you have unsaved changes in Geppetto when you attempt to close Lumberyard Editor, you will now be prompted to save your changes. Previously unsaved changes were lost.
    + Fixing an error that claimed an ANIMEVENTS file failed to save when a character had no ANIMEVENTS file specified in its animation list.
  + Fixes to discovering files include: 
    + Fixing a path failure when animation filters had spaces in their paths, and these paths were provided to the animation list for a character.
  + Fixes to animation playback include: 
    + Fixing a visual stuttering issue that occurred the first time an animation was selected from the explorer view.
+ Mannequin:
  + Fixes to numerous stability issues in workflows that previously caused the editor to crash.

**Cinematics**
+ Fixed an issue in the **Track View** editor that prevented the **Blend time** property from blending the position and view of two cameras.
+ Fixed an issue that caused entity property updates in the Rollup Bar to not display correctly for a camera's **FoV** and **NearZ** properties.
+ Fixed an issue that caused sequence `.xml` files to introduce new track default values erroneously.
+ Fixed an issue that prevented **Light Animation Set** sequences from updating when they are created.
+ Fixed an issue that prevented referencing event keys from updating when track view events were renamed.
+ Fixed an issue with importing a camera's FoV in the **Track View** editor that prevented it from using the correct vertical FoV. Previously the camera used the incorrect horizontal FoV.
+ Removed the deprecated file formats `.bmp` and `.hdr` from the **Render Output** dialog box in the **Track View** editor.
+ Removed the **Import FBX File** and **Export FBX File** menu items for **Sequence** and **Director** nodes in the **Track View** editor. This functionality is unnecessary because FBX does not have the capacity to store these node types.

**Cloud Canvas**
+ When starting a game inside Lumberyard Editor, you no longer need to activate a Cloud Canvas ApplyConfiguration flow node or call the Client Manager ApplyConfiguration C\+\+ API before using AWS flow nodes. This action is now automatically completed each time you press **Ctrl\+G**. ApplyConfiguration is still automatically completed when starting release builds of the game.
+ Various improvements and fixes to the Cloud Canvas Resource Manager user experience include: 
  + Navigating by clicking on resource names in the status tables.
  + Highlighting stack status tree nodes when hovering over upload buttons.
  + Displaying a progress icon on a tree node when a stack operation is in progress.
  + Displaying an error message when a `.json` file is malformed.
  + Copying log output to the clipboard.
  + Providing error messages in logs when Cloud Canvas configuration is incorrect.
+ Error-level log messages have been added for all AWS flow node failures.

**Component Entity System**
+ Fixed an issue that caused the client to crash when attempting to delete an entity after modifying the data for a placed entity.
+ You can now add a component by double-clicking a component in the component palette.
+ The mesh component now has a **LodRatio** setting, which allows you to adjust the range at which the level of detail switches. Lowering the value will increase the range.

**Gems**
+ Fixed an issue where gems were erroneously created with existing gem names.
+ Fixed an issue that prevented images from appearing in the texture directory when a project is built with new gems enabled.
+ Fixed an issue that prevented builds from generating test files for new gems.

**Lumberyard Editor**
+ Fixed an issue that prevented the editor from updating to the time of day changes made using the **Track View** editor or console variables.
+ Fixed an issue that prevented a camera entity's NearZ property from being set in the Rollup Bar while looking through the camera in the viewport.
+ Fixed an issue where the 3D engine render camera was a frame behind the camera used to update the engine.
+ Fixed a linker error when linking squish as a static library.
+ Fixed an issue that prevented environment probes from displaying the correct texture preview.
+ All references to **Splat Masks** in code and displayed text for terrain has been changed to **Splat Maps**.
+ Fixed an issue that prevented options from displaying properly in the **Editor Settings** submenus.
+ Fixed an issue that prevented an entity assignment from displaying properly when the editor is restarted.
+ Fixed an issue that prevented objects in the viewport from being selected and modified after opening two or more **Objects** sections in the **Rollup Bar**.
+ The **Layer Settings** dialog box is now titled **Layer Settings**. Previously it was given a generic name of **Editor**.
+ The texture browser has been removed and no longer appears when you click **View**, **Open View Pane** in the editor.
+ Fixed an issue that caused the preview box to overlap with other UI elements in the editor.
+ Fixed an issue with the terrain tools **Flatten** and **Pick Height** that prevented decimal height values from being used.
+ Fixed a text background color issue with the **Dark Skin** option in the editor that caused text in the **Module** and **Command** fields in the **Script Help** dialog box to be unreadable if the field was not selected.
+ Fixed an issue that caused the editor to accept input even when the editor was not in focus.
+ The editor now properly detects Intel GPUs.
+ When you click **File**, **Global Preferences** in the editor, the following text has changed: 
  + **Configure** is now called **Graphics Performance**.
  + **Very High** is now called **PC – Very High**.
  + **High** is now called **PC – High**.
  + **Medium** is now called **PC – Medium**.
  + **Low** is now called **PC – Low**.
+ The editor no longer crashes when: 
  + Your workspace opens faster than the **Welcome to Lumberyard** dialog box appears.
  + You attempt to dock a view pane on the left or right side of the editor and then fully cover and uncover the viewport.
  + You open the component test called **Controllable\_Chicken**.
  + You reassign a Scripts, Components, or LightFlicker `.lua` script to a script component's asset field. 
  + You attempt to load the **Lua Script** component on a component entity.
  + You dock the **Perspective** viewport at the bottom of the editor window and then attempt to resize the viewport.
  + You resize the viewport to 0.

**Networking**
+ Fixed an issue that caused LAN Search to use only the first matchmaking parameter.
+ Fixed an issue that prevented a transform component's world matrix from properly setting on the proxy when initially created.
+ Fixed an issue with incoming script RMIs being processed during level load that caused the Lua Virtual Machine (LuaVM) to crash. Scripted RMIs are now queued while the level loads.
+ Fixed a cyclic redundancy check (CRC) issue with the starting point camera.

**OS X**
+ The cloud entity now renders properly on OS X. Previously the cloud entity displayed as a tiled image.
+ Ambient occlusion in the FeatureTests project now works properly when cubemaps are exported from the editor.

**Particle Editor**
+ Fixed an issue that prevented particle libraries with members present from being removed.
+ Fixed an issue that caused a folder to disappear when the only particle in the folder was moved or deleted.
+ Fixed an issue that caused an unexpected directory (`\dev\cache\samplesproject\pc\samplesproject`) to display in the texture browser when the default particle is selected again.
+ Fixed an issue that prevented folder shortcuts from displaying the full directory path.
+ Fixed navigation issues that prevented navigating to previously accessed folders.

**Sample Projects and Levels**
+ Fixed an issue with the Legacy Sample where missing DDS sequential files caused glossy rendering for the SDKPlayer hands, heads, and roof tiles.

**Slices**
+ Fixed an issue with the game entity context event bus missing a default destructor implementation. Previously this issue prevented the use of dynamic slices.
+ Fixed an issue that prevented the Asset Processor from handling new slices or dynamic slices properly.
+ Fixed an issue that prevented dynamic slices from being created in a session.
+ Fixed an issue that prevented relative transforms from being maintained between multiple non-child entities in a slice during entity pushes.
+ Fixed an issue that prevented creating a new slice with the same name as one that was manually deleted.

**UI Editor**
+ The FixedPipelineEmu shader no longer treats color tints as SRGB values, which prevented white textures tinted with an RGB color from displaying properly. Textures tinted with an RGB color now display as the specified RGB color value. You must adjust the color tints on existing canvases.
+ You can no longer save a UI prefab that has references to non-children elements.
+ Input events are no longer processed for disabled canvases.
+ The sprite file for a gem texture is now saved to the appropriate directory.
+ The **Edit Sequence** menu in the **UI Animation** editor no longer includes unused settings.
+ The right-click menu in the left pane of the **UI Animation** editor no longer includes the non-functioning options to copy or paste UI elements.
+ The **Properties** pane in the UI Editor now displays the default value of -1 for text input, which means there is no character limit.
+ You can now use the **Move** tool to move a selected element when the cursor is within bounds of the element. Previously this functionality did not work properly if another element was in front of the selected element.
+ Single-click selection now works properly in move mode.
+ For the **Checkbox** component, selecting the **Actions On** check box or deselecting the **Actions Off** check box now works as expected.
+ Fixed an issue that caused an EntityId collision when loading a UI canvas. 
+ The file browser dialog boxes in the UI Editor are now modal.

**Virtual Reality**
+ Fixed an issue that prevented the render profiler from displaying when rendering to a VR device.
+ Fixed an issue that caused the editor to display black instead of the social screen when the VR preview was used for the first time.
+ Fixed an issue that caused stars in the dynamic sky system to lack depth and appear too close to the eye.

**Miscellaneous**
+ The installer now opens the Lumberyard Setup Assistant with the correct working directory.
+ In the Lumberyard Setup Assistant HTTPS links are now used when available.
+ Fixed an issue that caused the Project Configurator to write duplicate projects to the `enabled_game_projects` setting in the `user_settings.options` file.
+ Fixed an issue that caused the Asset Processor to report a failed operation as "Crashed."
+ Fixed an issue that caused a build failure when including `AzTest.h` multiple times in a module.
+ Fixed an issue that prevented parent and child entities from activating when spawned by the spawner component.
+ Fixed an issue that prevented the reflected property editor from displaying containers in groups correctly.
+ The base class elements for serialize and edit context are now correctly grouped and displayed in the property grid.
+ Fixed an issue with the flow graph node `Time:RealTime` that prevented the **seconds** port from reporting 0 at the minute rollover.
+ Removed support for weak functions from AzCore.
+ Fixed an issue where relative path names did not work properly in the editor command line tool for batch exporting.
+ Warnings are no longer shown in the console for the `game.cfg` file.
+ Fixed an issue in the Qt main window where the **Recent Files** menu did not work properly.
+ Fixed an issue with input events that use two analog input devices, such as a mouse and Xbox controller, that caused the input to fail.