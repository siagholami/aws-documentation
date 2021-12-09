# Fixes<a name="lumberyard-v1.9-fixes"></a>

Lumberyard Beta 1.9 and 1.9.0.1 include the following fixes:

## Lumberyard Beta 1.9.0.1<a name="lumberyard-v1.9.0.1-fixes"></a>

Lumberyard Beta 1.9.0.1 includes the following fix:

**Asset Processor**
+ The Asset Processor can now process asset files that are in a directory with any flags set (indexed, compressed, etc.). Lumberyard Editor launches as expected after the Asset Processor finishes processing all files. This fix addresses the following issues:
  + When launching the editor, a pop-up dialog box appears with erroneous messaging about the branch: "An attempt to connect to the game or editor has failed. The game or editor appears to be running from a different folder. Please restart the asset processor from the correct branch."
  + The editor exits the startup process with an "Unable to send asset status" message and then shuts down.
  + The editor cannot complete startup due to the Asset Processor attempting to process old jobs.

## Lumberyard Beta 1.9<a name="lumberyard-v1.9.0-fixes"></a>

Lumberyard Beta 1.9 includes the following fixes:

**Asset Browser**
+ When you filter assets in the **Asset Browser**, you can now scroll to the bottom of the list.
+ The **Asset Browser** now displays both `shapes.cgf` and `shapes.mtl` files for each `.fbx` file.
+ When using the filter option to filter for **Other**, the **Asset Browser** now displays all files that don't match an existing category.
+ When using the filter option to select certain categories, you will now see a **Filtered by** notification below the search bar.
+ You can no longer drag and drop folders inside the **Asset Browser**. Previously this capability resulted in erroneous components being created.
+ When you right-click any file or folder, a context menu now appears.
+ When you right-click any file, the context menu options now work properly.
+ When you right-click an `.fbx` file, the context menu now displays the expected options, such as **Open**, **Open in Explorer**, **Copy Path to Clipboard**, and so on.
+ When you edit the project settings for an `.fbx` file, clicking **Update** now results in the **FBX Settings** processing the change.
+ When using the search option, you can now type in multiple values and the search results will include all files that contain those values. For example, if you enter **a b c** in the search field, the search results will include files that contain the letter a, b, and c.
+ You can now resize the **Asset Browser** window as you would any other window in the editor.
+ The editor no longer crashes when you attempt to drag and drop a `.luac` file from its folder into the **Perspective** viewport.
+ If an asset is not selected, the preview viewport no longer displays a preview image or RGB drop box.
+ Certain `.xml` files, such as the `character_controller.xml` file, are now available in the **Asset Browser**.
+ When using the filter option, clearing the category check box now removes the search results for that category as expected.

**Asset Picker**
+ The asset picker no longer erroneously adds a `.cgf` file if you click **Cancel** in the asset picker dialog box.
+ When using the filter option, the asset picker no longer erroneously displays an empty folder in the search results.
+ You can no longer filter out certain asset types, such as scripts, if you're in the asset picker dialog box for static assets.

**Asset Processor**
+ The **Asset Processor** can now detect if certain folders are deleted from the cache, allowing the editor to launch properly.
+ You can no longer run multiple instances of the **Asset Processor**. An error message displays if you attempt to launch another instance.
+ On startup, the **Asset Processor** now checks the database file for a read-only flag and displays appropriate messaging.
+ The **Asset Processor** can now process iOS assets properly, and the editor no longer loses responsiveness.

**Audio**
+ The `s_PositionUpdateThreshold` console variable now works properly.
+ Connecting a **Switch State** to a **Real-time Parameter Control** (RTPC) now works properly.
+ The editor no longer crashes due to changing the `s_AudioSystemImplementationName` console variable at runtime.
+ The **Audio Controls Editor** now updates as expected, if changes are made to the Wwise project while the **Audio Controls Editor** is closed.
+ You can no longer delete an **Audio Translation Layer** (ATL) control while renaming it.
+ You will no longer lose data if you attempt to save an ATL folder to the root and a folder with the same name already exists in that location.
+ The audio functionality for the **Lightning Arc Gem** now works properly. The audio properties were updated to be ATL controls.
+ In the ATL control selector dialog box, you can no longer interchange **Switches** and **Switch States**.
+ In the ATL control selector dialog box, you can no longer select **Preloads** marked as **Auto-Load**.
+ The size of the ATL control selector dialog box is now fixed.
+ Audio log messages are no longer reported to the editor's **Errors** pane.
+ The audio listener can now move with the debug camera.
+ The renaming logic in the **Dialog Editor** now works correctly to perform a rename operation in Perforce.
+ Discarding changes in the **Audio Controls Editor** no longer leaves a connected status.
+ If you use the **Stop Trigger** field in the **Track View** editor to set looping sounds to play, these sounds can now be stopped.
+ The sound obstruction setting is now respected if you have only **Stop Trigger** set in a **Mannequin** proc layer.
+ An uninitialized variable in the **Audio Listener** component has been fixed. **Thank you, @Gamely on the forums, for submitting this fix\!**

**Character and Animation**
+ Geppetto:
  + The **Resave AnimSettings** dialog box no longer erroneously displays zero `.animsettings` files when there are files to save.
  + Animation lists now update after you change the **Animation Set Filter** path.
  + Animation lists no longer collapse after you add a new animation.
  + When you delete a file in Geppetto, the file is now deleted from the hard drive and the Perforce server.
  + To prevent the editor from crashing, you can no longer attach a character to itself at a joint.
  + When you use **Export HTR\+CAF** (Lossy), this option no longer overwrites the source `i_caf` file. Instead, this option now creates an `i_caf` file with an `_Exported` suffix.
  + When the FBX pipeline creates `.chr` files, the accompanying `.chrparams` files now display as expected.
  + Animations no longer fail to play if the `.chr` file is missing from the skeleton list.
  + The **Force Recompile** option has been removed due to outdated functionality.
  + The **Resave AnimSettings** dialog box now displays properly. You can access this functionality by clicking **File**, **Resave AnimSettings**.
+ Mannequin:
  + When using the sdk\_playerpreview3p.xml sample file, the editor no longer crashes when you attempt to load ledgeGrab on the Transitions tab.
  + Sound Obstruction Type now works properly for Stop Trigger.
  + The RandomLookAround and RandomAimAround procedural clip types now behave as expected.
  + The editor is no longer case sensitive when you add default scopes and fragment IDs.
  + The reference joint in Aim or Look setups now function properly. For information, see [Setting up a Skeleton](https://docs.aws.amazon.com/lumberyard/latest/legacyreference/char-ik-aim-skeleton.html).
+ PRow cloth attachments no longer have artifacts when they are part of a multithreaded update.
+ If the instance element is deleted and you select **Reset value**, the **Simple Animation** component now properly resets the animation name property. The animation name property is reverted to the saved slice value.

**Cinematics**
+ **Screen Fader** textures no longer appear upside down.
+ Animated rotations are now interpolated correctly.
+ When editing a color key, the **Color Palette** dialog box now displays as expected.
+ You can no longer erroneously add legacy camera entities to component entity sequences.
+ The **Expand all** and **Collapse all** options now work properly with component entity nodes in the **Track View** editor node browser.
+ The **Copy** and **Paste** options now work properly with component entity nodes in the **Track View** editor node browser.
+ When disabling a component entity node in the **Track View** editor, the component children and tracks are also disabled.
+ The 1/8 playback speed now works properly in all build configurations.
+ You can no longer erroneously create a parent/child relationship with multiple component entity nodes in the **Track View** editor node browser. If you add a node or move an existing entity onto another entity, the entities will be peers.
+ Animation interpolation no longer stutters for small value changes, which results in smooth camera movement.
+ The **Blend** property for the camera key now blends transitions for component entity cameras.
+ Renaming a component entity and then using the **Undo** or **Redo** options no longer disconnects the tracks.
+ The editor no longer crashes if you use the **Reloading All Scripts** command while the **AI/Physics** mode is enabled in a level with a component entity sequence.
+ Camera blending for legacy cameras now works as expected in the editor in game mode.
+ Deleting a component entity node no longer results in orphaned component nodes in a sequence.
+ Component entity sequences now play back on macOS and iOS.
+ Renaming a sequence in the **Track View** editor now works properly for legacy and component entity sequences.
+ If you use the **Scale** gizmo on a **Transform** or **Scale** track, changes are now recorded for component entities.
+ If you use the **Move**, **Rotate**, or **Scale** gizmo, changes in **Record** mode no longer require you to undo twice.
+ If you make changes to a layer in a component entity sequence, an asterisk (**\***) now appears to indicate there are changes to save.
+ The editor no longer crashes if you attempt to exit while the **AI/Physics** mode is enabled and the **Track View** editor is open with an active sequence.
+ The **Key Properties** window has been updated to improve readability of the content.
+ You can now delete a texture by removing the texture from the key.
+ You can now resize the **Track View** editor dialog box as expected.
+ When attempting to add an animation track, a list of animations for the selected entity now appears properly.

**Cloud Canvas**
+ Leaderboard requests are now paginated and include the page count.
+ The **Message of the Day Gem** now supports paginated lists.
+ The **Cloud Canvas Resource Manager** now displays a Lambda function code folder.
+ The **Cloud Canvas Dynamic Content Manager** now displays an error message if you attempt to select a file or folder that isn't in the asset processor cache folder.
+ The **Cloud Canvas Dynamic Content Manager** can now display manifest names that are greater than 56 characters without affecting the gear and platform icons.
+ The **Cloud Canvas Dynamic Content Manager** now displays the full manifest name. Previously the manifest name was cut off if periods were used.
+ Dynamic content downloads now complete successfully over cURL.
+ The **Cloud Gem Framework** no longer crashes if an error response is too large for the logger.
+ The **Cloud Canvas Dynamic Content Manager** now displays a progress bar with progress percentage in the status bar. The status bar also displays the name of the package that is being uploaded.
+ You can now delete a log bucket when you delete a project stack.
+ You can no longer create a leaderboard with a leaderboard ID that uses any of the following invalid characters: **"\~\!@\#$%^&\*()\_"**
+ You can no longer use non-numeric values for the minimum and maximum reportable values in a leaderboard.
+ To simplify date and time validation, Cloud Canvas no longer uses UTC validation.
+ Navigation links now point to the appropriate location. For example, if you click **Gems** in the navigation header, it now goes to the Gems home page.
+ When using the `lmbr_aws list-importable-resources` command with an invalid type, an error message is now returned. Previously the usage was erroneously returned with the error message.
+ Waf now uses the correct library name when printing warnings about missing libraries.
+ Deleting a resource now also deletes the parameters that were created.

**Component Entity System**
+ Component entity wireframe bounds can now draw in 2D render viewports.
+ When disabled, the **Show icons** option now hides component entity icons.
+ You can now delete invisible entities from the **Entity Outliner**.
+ When called from an attached script's `OnActivate` method, the `SimpleAnimationComponentRequestBus StartAnimation` now works as expected.

**FBX Settings**
+ Units are now properly respected in the FBX pipeline.

**Lua**
+ Errors are now sourced correctly with Lua EBus binding.
+ Aggregate EBuses are now supported in Lua.
+ The editor no longer crashes when spawning and destroying entities with Lua script components.

**Lumberyard Editor**
+ The **Erase Terrain** option no longer erases the terrain height if you choose **No**.
+ The editor no longer crashes if you add comments to a shader.
+ The editor no longer crashes if you are running in headless mode. Previously the editor crashed due to an invalid texture ID being removed.
+ The editor no longer crashes if you're using a second normal map and then you remove the emittance map.
+ Decal maps now modulate emissive intensity as expected, even when a blend layer has a DDNA texture.
+ The editor no longer crashes when using the **Substance Editor** to view an imported `.sbsar` file.
+ Point light shadows now cast shadows as expected.
+ All component entities now work properly with vis areas.
+ Using the **Wireframe** viewport mode no longer produces graphical glitches when moving the camera.
+ When entering and exiting game mode, the lens flare no longer reverts to the default flare in the library.
+ Object motion blur now works properly with static mesh components.
+ The editor no longer crashes if you adjust the date and time to \+5 days while the editor is running.
+ The editor no longer crashes if you attempt to configure a game project and add gems using the legacy layout.
+ The editor no longer crashes if you attempt to create a keyboard shortcut and don't assign a value.
+ The editor no longer crashes if you attempt to customize the toolbars.
+ You can now restore the layout to the default view as expected.
+ All buttons in the bottom toolbar are now labeled with icons and/or text as expected.
+ The login window now appears correctly based on the display settings.
+ The editor no longer crashes or hangs if you are using a non-default Windows theme.
+ The editor no longer crashes if you attempt to restart the editor while the **Database View** is open.
+ When you add an `.xml` file, the file now appears in the **Database View** as expected.
+ The following options now have keyboard shortcuts listed in the menu: **Show Quick Access Bar**, **Hide Selection**, **Show Last Hidden**, and **Unhide All**.
+ When you right-click a folder, a context menu now displays with the following options: **View in Explorer**, **Copy Name to Clipboard**, and **Copy Path to Clipboard**.
+ All title bars are now shadowed except for the active window.
+ When you right-click a title bar, a context menu now displays with the following options: **Restore**, **Move**, **Size**, **Minimize**, **Maximize**, and **Close**.
+ A flickering issue no longer exists when moving around floating panes on a second monitor.
+ Graphical glitches no longer appear when moving around floating panes after starting the editor.
+ Graphical glitches no longer appear when right-clicking and dragging a tab in a nested pane.
+ When increasing the width of floating panes, the tabs now maintain their appropriate sizing.
+ You can now rearrange tabs using the left mouse button.
+ When docking to an absolute edge, panes are no longer erroneously duplicated.
+ Graphical glitches no longer appear when docking a window in a new location.
+ Graphical glitches no longer appear when you right-click a tab on a pane.
+ Grab handle indicators (**...**) now exist for all bars that you can grab.
+ Any panes that appear off-screen are now automatically restored to the default layout.
+ Restoring the default layout now works properly.
+ Undocking a tabbed pane now works properly.
+ The **Undock Tab Group** option is now enabled only if there are multiple docked panes.
+ The context menu for docked panes now includes only close and undock options.
+ Graphical glitches no longer appear when docking or undocking panes.
+ You can now resize the editor window using all edges and corners.
+ You can no longer reorder tabs if there is only one tab remaining.
+ The editor no longer crashes when you save statistics for the following sample levels and projects: **GameSDK – Woodland**, **SamplesProject**, **MultiplayerSample**, and **CloudGemSamples**.
+ False errors are no longer reported the first time you open a level or create a new level in the **Debug Editor**.
+ The editor no longer fails to launch due to assets waiting to be processed or allocations on record.
+ Editor-related processes no longer remain running in the background after the editor shuts down.
+ The editor now launches as expected after assets are successfully compiled.
+ The **Rotate** gizmo now has improved selection accuracy.
+ The welcome dialog box no longer has sizing handles.
+ Double-clicking a folder in the **Open Level** dialog box no longer produces errors.
+ The **Switch Projects** option in the **File** menu now works as expected.
+ Resizing undocked windows and panes is now easier due to a wider hover area for the resizing arrow.
+ After you choose a new color for the layer, the color picker button now displays the selected color.
+ You can now use the arrow keys to navigate the viewport and the camera will move as expected.
+ The editor no longer crashes when you compile shaders.
+ The editor no longer crashes when you load a level and then attempt to open a different level from the layers list dialog box.
+ When using the **Modify Terrain** tools, the radius value bars are no longer affected by automatic radius adjustment.
+ The **Sun Trajectory Tool** now opens on the first attempt.

**Lumberyard Setup Assistant**
+ A warning displays if the capabilities that you select in the Lumberyard Setup Assistant do not match the `user_settings.options` file. Previously the `msvs_version` was overwritten in this file.
+ The `-enable` and `-default` options now work properly when used in the `user_settings.options` file.
+ The validation button now works properly to validate installed third-party software and plugins. When validation is complete, the button reactivates and the UI reflects the validation status.
+ If you lose internet connectivity, the Lumberyard Setup Assistant can now automatically resume third-party software downloads when connectivity is restored.
+ The links on the **Summary** page now navigate to the correct pages.

**macOS**
+ You can now launch the **Asset Processor** by double-clicking the file in the Finder window.

**Material Editor**
+ You can now view Alpha and RGBA in texture thumbnails.
+ The **Material Editor** now displays writeable files when you click **Show checked out materials** after enabling the Perforce plugin.
+ The **Material Editor** no longer displays duplicate entries of a material.
+ The **Templbeamproc** shader now works properly and changes are visible on the material.
+ The material settings section has been updated to improve readability of the labels.
+ After clicking **Remove Item**, the delete dialog box no longer appears multiple times.
+ After selecting a texture, the texture name no longer appears transparent nor highlighted with the texture preview.

**Mobile Support**
+ The mobile game UI now scales correctly.
+ As a result of fixed Android configuration errors, you no longer need to delete `BinTemp` when switching between API versions.
+ Particles now render correctly on Android devices.

**Networking**
+ The **Net Binding** component is now restricted to one component per component entity in order to prevent replication issues.

**Particle Editor**
+ The editor no longer crashes when you create a second particle or duplicate an existing particle.
+ When you click **File**, **Import**, the asset picker dialog box now opens as expected so that you can choose your particles.
+ You can now access the context menu in the **Preview** viewport as expected.
+ The import window no longer crops the title and other options.

**Project Configurator**
+ If the active project has been deleted, the **Project Configurator** still launches with a warning to indicate that the project is missing.
+ A warning displays if you attempt to enable and modify gems for a game project and the `Game.xml` and `Editor.xml` files are read-only. This does not apply if you use Perforce integration.
+ The **Project Configurator** now launches as expected, even if the project ID is missing from the `project.json` file.

**Slices**
+ Undoing a slice deletion right after the slice was created no longer places the entity at world 0,0,0.
+ The editor no longer crashes when destroying dynamic slices while exiting game mode.
+ You can now use the context menu in the **Asset Browser** to set (or unset) slice assets in gems as dynamic.
+ The **Push to Slice** dialog box now displays the correct icons for component entities that have changed.
+ The **Set Dynamic Flag** setting is now called **Set Dynamic Slice**.
+ The ability to unset a slice as dynamic now works properly.
+ The editor no longer crashes when you attempt to instantiate a slice.
+ In the **UI Editor**, the asset picker now searches for slices when you attempt to instantiate a slice. Previously it searched for uislices, which will be deprecated in a future release.
+ Dynamic slices now appear in the **Asset Browser** once the **Asset Processor** is complete.

**Substance Editor**
+ The **Substance Editor** no longer crashes when you attempt to view imported `.sbsar` files.

**UI Editor**
+ You can now use the following in-level components in dynamic slices: **UI Canvas Asset Ref**, **UI Canvas Proxy Ref**, and **UI Canvas on Mesh**.
+ When adding text using the **UiTextComponent**, the spacing between numbers is now fixed. This applies even to fonts without a fixed width.
+ The editor no longer crashes when switching between canvases using Lua.
+ The **Image** component no longer samples from the opposite edge of the texture, preventing unwanted lines from appearing.
+ When the **Flow Graph** editor and **UI Editor** are docked together, the menu bars still work as expected.
+ The **End Preview** button is now called **Preview**. You can access this functionality by right-clicking any toolbar and selecting **Preview Toolbar**.

**Virtual Reality**
+ For consistency with other devices, the Oculus device now uses local space for the output of angular velocity and acceleration. Previously it used world space.
+ Implementation for the Oculus device now has improved error checking.
+ The Virtual Reality Project launcher no longer crashes when attempting to load the **VR\_BoxGarden\_Sample** and no VR device is connected and no VR software is running.

**Miscellaneous**
+ Various fixes include issues with the HTTP Requestor tests and loading issues with slices for the editor and game.
+ The editor no longer crashes when reflecting AutoExpand attributes of group ClassElements against member variables.
+ `CObjectManager::FindObject` no longer fails to find objects whose names have changed. Script Terminal `"general.select_object("EntityName")"` no longer fails for assets with changed names.
+ `CBaseObject::SetDrawTextureIconProperties OBJFLAG_SHOW_ICONONTOP` now changes the icon alignment as expected.
+ The **Give Us Feedback** dialog box has been resized to allow all text to be visible without manual resizing.
+ The `RCScene.xml` file is no longer required to load a custom application configuration. Projects can now use an `Editor.xml` file.
+ The editor no longer crashes when you attempt to shut down in `CClassFactory::GetClassesBySystemID()`.
+ In **Script Help**, you can now copy to clipboard the contents of the **Example** column by double-clicking anywhere in the row for a command.
+ The **Export Selected Objects** option now works properly to export `.fbx` files.