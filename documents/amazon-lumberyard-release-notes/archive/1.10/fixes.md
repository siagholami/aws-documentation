# Fixes<a name="lumberyard-v1.10-fixes"></a>

Lumberyard Beta 1.10 includes the following fixes:

**Android**
+ Release builds now work correctly for GCC and Clang builds.
+ The Rain sample works correctly on Android devices.
+ Shadow cascades now function correctly on Android devices.
+ Ocean water no longer appears too dark on Android devices.
+ Intermittent failures no longer occur when using the 'deploy' command on some devices.
+ Various updates include rendering fixes for shadows, lighting, and postprocessing effects on OpenGL and Metal.

**Asset Browser**
+ **Asset Browser** no longer has a minimum size to which it can be resized.
+ **Asset Browser** no longer stops working when deleting multiple entries for large projects.
+ Asset type filters in **Asset Browser** are now ordered alphabetically.
+ The editor no longer stops working when selecting previously opened model thumbnails in a new **Asset Browser** session.
+ Object preview for `.fbx` and `.cgf` files now functions properly.
+ Removed 'save thumbnail report' option from legacy **Asset Browser**.
+ **Asset Browser** update speed has been optimized.
+ **Asset Browser** speed while editor runs in debug mode is now normal.
+ Source assets that have the same name and extension as their product are now combined and shown as one entry.
+ Saving an edited asset in **Asset Browser** no longer causes the editor to crash.
+ Search function can now process multiple search terms without impeded performance.
+ Source files without products now appear in **Asset Browser**.
+ The **Open in Explorer/Finder** functionality doesn't use the desktop as a secondary option in some situations.
+ **Asset Browser** now shows accurate file sizes for files less than 1 KB.
+ **Asset Browser** now saves and correctly displays folders' open or closed states when a new session is started. 
+ Assets deleted from a project directory are removed from **Asset Browser** and no longer require restarting the editor. 

**Asset Pipeline**
+ The editor no longer stops working when running `AssetProcessorBatch`.
+ The function that detects invalid characters in file names now works properly.
+ `AssetProcessorBatch` now propagates the `gamefolder` parameter to the resource compiler.

**Asset Processor**
+ When opening the editor, the **Asset Processor** window now sorts to the background so that you can see the **Welcome to Lumberyard** window.
+ The **Asset Processor** no longer stops working when processing UICanvas files with a deleted cache.
+ The read-only `Bin64vcXXX` directory no longer causes **Asset Processor** to crash.
+ **Asset Processor** search now works properly when searching for already-processed assets in response to a status request.
+ Improvements were made to the **Asset Processor** job thread processing.
+ **Asset Processor** now terminates appropriately when building.
+ **Asset Processor** is no longer a bottleneck in **Material** browser performance.
+ **Asset Processor** no longer fails to copy dynamic slice files from its temporary directory into the cache.
+ Modifying source files while running **Asset Processor** no longer duplicates pending jobs. 

**Audio**
+ Popup dialog boxes in the **Audio Controls Editor** now appear in the appropriate location.
+ If you press the spacebar while editing the name of a trigger in the **Audio Controls Editor**, the trigger no longer executes.
+ Obstruction rays are now cast in **AI/Physics** mode.
+ Switch-Rtpc connections no longer show a constant value of 0 in the **Audio Controls Editor**.
+ Audiokinetic Wwise errors about non-normalized vectors have been fixed.
+ Link errors for Audiokinetic Wwise 2015 and earlier have been fixed on Android.

**Cinematics**
+ When you set the end frame in the **Render Output** dialog box, the start frame no longer clamps erroneously.
+ When you add an ambient track to an area light component, the track's state is now reflective of the ambient flag's current state. For example, the ambient track will not appear active if the ambient flag is false.
+ `Resume()` is no longer erroneously called each time `Stop()` is called in code for a sequence.
+ The editor no longer stops working when you copy a single, numerical track without any keys.
+ You can now use the sequence camera as the viewport camera. Previously a legacy camera entity was required to use the sequence camera.
+ You can now rename a sequence using the **Sequence Properties** dialog box.
+ The redo functionality now works as expected when renaming a sequence.

**Cloud Canvas**
+ AWS logs are no longer written to the root folder with malformed file names.
+ The `lmbr_aws` function `upload-code` no longer fails with an undefined deployment stack ID.
+ The **Credentials Manager** now displays all profiles even if a profile has an invalid secret key.
+ The **Project Configurator** now displays the correct summary for the **Cloud Gem Leaderboard** gem.
+ The Cloud Canvas **System** component no longer causes the editor to crash if there are no `.identities` files.
+ There is no longer a discrepancy in the error messaging between the console and UI when switching to a profile for a different account. Previously this caused error messages to display in the console, but not in the UI.
+ You can now change the light color in Lua as expected. Previously this action failed due to execution on a non-main thread during callback of an HTTP request.
+ Deleting a resource now deletes the parameters that you created.
+ Dynamic content no longer prevents you from creating a deployment successfully when a default deployment doesn't exist.
+ The user pools that you add after creating a deployment are now linked to the identity pool.
+ In the CloudGemSample level, the leaderboard no longer displays the same entry twice.
+ The **Create Deployment** dialog box is now resized to an appropriate size.
+ All Cloud Gem Framework components now have the proper icons displayed.
+ On Android devices, the mouse cursor is no longer visible on all maps in the CloudGemSample level.
+ On iOS devices, users can now sign in as expected on the PlayerAccountSample map.
+ Deleting a service API under certain circumstances no longer fails.
+ The Lumberyard login dialog box no longer remains on top of other windows, preventing you from viewing the windows underneath.
+ Cloud Gem Portal:
  + The Cloud Gem Portal now loads in regions other than us-east-1.
  + The tooltip icons now display correctly for all directions.
  + The favicon no longer appears distorted on dark backgrounds.
  + The favicon now displays correctly on a black themed browser.
  + The player account's last modified date is no longer incorrect.
  + The search methods for a player account are no longer inconsistent.
  + The **Edit Player Account** modal now uses consistent font types.
  + You can now edit an unconfirmed account.
+ Dynamic Content Manager
  + You can now add packages to a specified manifest without receiving erroneous errors.
  + You will now receive user feedback when you create a security key.
  + The **Cancel** button for uploading manifests now works properly.
+ Resource Manager:
  + The UI now loads properly even if **CloudGemFramework** is disabled.
  + The **Create Project** dialog box no longer includes regions that fail to create project stacks.
  + The **Project Stack** dialog box now defaults to the correct region.
  + You can no longer create stacks in unsupported regions.

**Component Entity System**
+ The **Push to Slice** UI now displays actual component names instead of **GenericComponentWrapper** in some cases.
+ You can now remove multiple components using the component context menu.
+ New script properties on entities in a slice now display as overrides. You can push these script properties to a slice.
+ The Lua editor now checks out files from Perforce using the correct capitalization. Previously the paths were lower case.
+ The editor no longer intermittently stops working when a proximity trigger is delegated in an `OnTriggerAreaEntered` event.
+ The `TransformComponent`'s rotation matrix is now reorthogonalized each time `RotateByX/Y/Z` is called. However, `RotateByX/Y/Z` is now deprecated. You can use `RotateAroundLocalX/Y/Z` instead.
+ The slice save path now persists between sessions.
+ When the **Entity Outliner** is in focus, the keyboard shortcuts for translate, rotate, and scale now work properly for selected entities.
+ You can now place decals on new component entities as expected.
+ When you have two entities with a lens flare component and the same lens flare type, you can now change the properties for one entity without affecting the other.

**Environment Probe**
+ The **View Cubemap** preview now renders properly.
+ The default boundaries are now larger.
+ Scenes are no longer affected by environment probes without a cube map. Previously an environment probe without a cube map defaulted to a point light.

**FBX Settings**
+ A mismatch between the first frame of a skinned mesh and the bind pose no longer breaks skinning during animation.
+ The `.fbx` files that don't generate products no longer disappear from the **Asset Browser**.
+ The FBX pipeline now successfully processes animated FBX files when you enable the **Update Materials** option on the **Rigs** tab.
+ FBX conversion no longer fails if file name has been changed.
+ `AZ_TraceContext` calls are now recorded in the `TraceContextStack` in `ResourceCompilerScene`.
+ **Rules** in scene settings are now named **Modifiers**.

**Gems**
+ When you create a new asset-only gem, a `3rdParty` directory is no longer created for that gem.
+ Registering SceneAPI Reflection function from Gem no longer causes a crash on shutdown.
+ Assets for disabled gems are now removed from the cache.

**Geppetto**
+ The editor no longer stops working if you attempt to set the simulations translational projection type in the **Attachments** pane.
+ The editor no longer stops working if you rapidly click a selected animation after creating a new `.cdf` file.
+ The editor no longer stops working if you attempt to create a new character when another character file is already open.
+ The editor no longer stops working if you move geometry that was added to a face attachment.
+ The **Show in Explorer** option now shows the selected file's location.
+ The **Material** field now successfully opens the asset picker.

**Graphics**
+ The **Simple Physics** and **Rigid Body** collision types are now functional for emitters that use geometry as the particle.
+ Specular light no longer disappears on materials when the smoothness is higher than 220.
+ Energy is now conserved for area lights on smooth materials. Depending on your use of highly smooth surfaces, you may need to adjust the area light multipliers for your project.
+ The **UseTerrainColor** parameter now affects vegetation color as expected.
+ Updating an `.fbx` file automatically processes and reloads the materials that are associated with the entities.
+ **Skinned Mesh** components now support the material eye dropper functionality.
+ Maya exporter now shows in Maya 2017 update 3 interface.

**Lumberyard Editor**
+ The editor no longer stops working if you attempt to close it when the Amazon login window appears. Previously this occurred if you cleaned the registry when an internet connection was unavailable.
+ Entity properties in the **Rollup Bar** no longer have display issues with scaling.
+ The **ToolBox Macros** menu now expands as expected. You can access this menu from **Tools** in the menu bar.
+ Editor windows now have a minimum size that they can be scaled.
+ Events that are not related to the `Editor.exe` file now have empty project IDs as expected.
+ Number attributes in the **Material Editor** are no longer missing sliders to adjust the values.
+ The **Console Variables** window now uses a color scheme that is easy to read.
+ In the **Console Variables** window, the scroll bar is disabled when you edit a value.
+ When you double-click the border of a floating window, the window no longer docks to the editor window.
+ The debug log in the **Console** window now uses a color scheme that is easy to read.
+ The **Viewport Type** window now closes as expected after you select a viewport type.
+ The **Undock** option (from the right-click context menu) is now disabled for the following tools: **UI Editor**, **Flow Graph** editor, **Track View** editor, **Dialog Editor**, **Lens Flare Editor**, **Smart Object Editor**, **Vehicle Editor**, and **Visual Log Studio**.
+ The **Global Preferences** window is updated to improve readability of all options.
+ Confirmation dialog boxes now display correctly.
+ The editor no longer stops working when you use the constrain-to-mesh functionality.
+ The legacy docking menu no longer appears when you right-click a pane's resizing area.
+ You should no longer see glitches when restoring the default layout.
+ When you close and reopen panes from the **Tools** menu, the panes no longer appear in new positions.
+ The **Goto Coordinates** dialog box now tabs in the correct order: **Enter Position here**, **Angles/Z**, **Close**, **Go To**, **Cancel**, **Position/Z**, **Position/Y**, **Position/X**, **Angles/Y**, and **Angles/X**.
+ When you attempt to dock a floating window to the main editor window, the drop zones now appear correctly.
+ The **Load object** functionality now works properly so you can see the `.grp` file and select it to load.
+ You can now dock the **Particle Editor**, **Flow Graph** editor, **Database View**, and **Mannequin** editor next to the viewport. Previously you couldn't dock these tools if the display size was set to 125% or higher.
+ The **Undock** option is automatically disabled for a single floating pane.
+ You can now open the **Material Editor** from the toolbar icon.
+ You can now set the **Console** background color option (light or dark theme) and the text color updates accordingly so that the text is legible.
+ The **Console** window no longer automatically scrolls when a new message populates.
+ You can now delete entities using the keyboard. Previously this was not possible if the new docking system was enabled and the **Particle Editor**, **Flow Graph** editor, **Database View**, or **Mannequin** editor was docked next to the viewport.
+ The middle mouse button no longer represents a click. You can now release the middle mouse button to pan around and then click another point to create your end point.
+ You can no longer reposition a window by pressing a button on the title bar, such as restore or close.
+ The keyboard shortcuts that you define in the **Customize Keyboard** window are now used for the specified windows or options.
+ The keyboard shortcuts are no longer erroneously permanent. You can modify all keyboard shortcuts in the **Customize Keyboard** window.
+ You can no longer assign the same keyboard shortcut to two different functions at the same time.
+ When you click **Game**, **Terrain**, **Edit Vegetation**, the **Rollup Bar** now appears as expected in the tabbed pane.
+ If you undock a pane from the editor window, the pane now appears undocked when you close and restart the editor.
+ Configuration dialog boxes now appear in front of the editor window as expected.
+ The **Delete Object** confirmation dialog box now displays the correct asset names when you delete more than one asset at once.
+ The **Console Variables** window now opens as expected on Windows 7.
+ The **Console Variables** window has been updated to improve performance.
+ The **Console Variables** window no longer has buttons to add or remove elements. Previously these buttons caused the editor to crash.
+ The title bars for all tools or options now display the correct name.
+ When you click the title bar for an attached dock widget and move the widget around, the translucent window now attaches to the cursor as expected.
+ When you search the viewport, you can now only choose one option.
+ The layout for the **Script Terminal** is now improved and no longer has layout issues.
+ The sort function was removed from the **Script Help**.
+ In the **Time of Day Editor**, the timeline slider now moves to the same location as the value in the key editor.
+ The keyboard shortcut to create a new component entity is now removed.
+ The **Paint Objects** button for **Vegetation** in the **Rollup Bar** is now easier to determine if it is enabled or disabled.
+ When using the move or scale tools, you no longer need to press **Undo** twice.
+ In the **Terrain Texture Layers** pane, the layer list item name is no longer deleted if you double-click the name to modify it.
+ When you select objects in the scene, the objects now appear selected in the **Object Selector**.
+ When you select objects in the scene, the **Object Selector** now accurately displays the number of selected objects.
+ The **Save Changes** dialog box now appears in front and center of the editor window.
+ If you restore the default layout, the panes now have the same width as before.
+ You can now close floating windows and floating tabs as expected.
+ When you choose a color swatch in the **Color Picker**, the hue no longer changes when the saturation changes.
+ An error report no longer appears when you create a new level.
+ The editor no longer stops working if you choose **Cycle Viewports** while in game mode.
+ The editor console no longer removes newline characters.
+ When you create a second new level by pressing **Ctrl\+N**, you can now enter a name as expected.
+ The editor no longer stops working if you modify a field and press **Esc** while the field is still in focus.
+ Mouse navigation now works properly in the 3D preview window.
+ On the **Terrain Modify** tab, the slider for the terrain height now moves correctly.
+ The viewport no longer pans or zooms uncontrollably.
+ The editor is no longer missing stylesheets that cause the editor styles to display incorrectly.
+ The editor no longer stops working when you change levels.
+ The editor no longer stops working when you create a new material.
+ The editor no longer stops working if you attempt to tab out of the editor or switch applications while saving your level.
+ Keyboard shortcuts are no longer functional when the console is open and **AI/Physics** mode is enabled.
+ The drawcall and poly count debug now outputs properly in editor mode.
+ Debug text messages no longer flicker.
+ When you scale objects with transparent materials in a non-uniform way, the light reflection and highlights now behave properly.
+ Terrain seams are no longer visible between sectors at different LODs.
+ The **Terrain Texture Layers** pane no longer causes the **Rollup Bar**, including the **Layer Painter**, to reset.
+ Combination boxes in the **Reflected Property Editor** now replace rather than append values after a refresh.
+ The editor no longer stops working when loading a level while Perforce jobs are still pending in the **Layers List** box.
+ The **New Folder...** icon in the **Save As...** dialog is now functional.
+ The editor no longer stops working when clicking **File**, **Save Level Statistics**.
+ The **Saving Level** dialog box now closes appropriately.
+ The help icon in the Script Terminal now shows correct example Python commands.

**Lumberyard Setup Assistant**
+ You can no longer simultaneously run multiple instances of the Setup Assistant.
+ The Setup Assistant no longer stops working if it attempts to parse a corrupt manifest.
+ The error dialog box can now scale to show more content.
+ The registry key for the `Bin` directory is now updated for batch mode. This fix was also applied to the directory names for Mac and Linux.
+ The Setup Assistant now loads the system default fonts if it's unable to load custom Lumberyard fonts.
+ An erroneous popup dialog box no longer appears when you attempt to uninstall the Autodesk Max plugin.
+ When the P4 plugin is enabled and you run the editor from a directory other than the current P4 workspace, creating a level no longer fails.

**macOS**
+ Normal map sampling on Mac Metal has been fixed to allow correct lighting calculations.
+ Renaming the root directory of a Lumberyard build no longer breaks all symbolic links that were created during setup.
+ Spaces in the directory path no longer prevent macOS from compiling successfully.
+ Vis areas now work properly in the OpenGL renderer.
+ **Asset Processor** on macOS now launches properly.
+ **Asset Processor** on macOS now relaunches properly after you update the bootstrap file.

**Mannequin**
+ You can now more reliably copy and paste clips. This functionality is now more tolerant to errant clicks.
+ When you update a fragment's tag settings, the **FragmentID** tree no longer collapses.
+ The editor no longer stops working if you enable a force feedback clip when game mode is activated.
+ The editor no longer stops working if you set a Lua callback proc clip during an animation.

**Material Editor**
+ You can now specify a render target name for the texture path name.
+ The editor no longer stops working if you choose **Remove all elements**.
+ The **Material Editor** no longer writes to the cache in some situations.

**Networking**
+ SecureSocketDriver has a small patch applied to help prevent potential access violations.
+ When debugging, you will now receive only one report of a main thread timeout. Previously the system showed multiple warning messages.
+ The default **CryAudio Listener** is no longer networked by default.
+ Error reporting for EBus binding now works properly.
+ **Network Profiling** now correctly combines results in the **Overall Results** view.
+ The CPU profiler no longer stops working when you close the window.
+ The server no longer stops working when you launch it in unattended mode.
+ A replica's last snapshot is no longer sent when the replica is destroyed before its first update is synced.
+ `OnNetworkSessionActivated` is no longer called before a session is fully operational.

**Particle System**
+ Changing an emitter shape no longer resets all properties to the default values.
+ Offsetting the inner fraction no longer allows particles to leak to the center.
+ Particle stretching is now applied correctly to GPU particles.
+ GPU particles now support lifetime curve modifiers.
+ GPU particles now support **Pre-Roll**.
+ The **Target Attraction** feature now supports the **Target** property as expected.
+ A maximum count on emitters is now enforced to prevent crashes.
+ The number of emitted particles no longer deviates by one or two particles.
+ You can now rename particles to modify just the case.
+ The values in the **Color Picker** no longer change when you tab between fields.
+ Lighting on particles at large distances now works correctly.
+ Simple physics particles no longer collide with the environment.

**Perforce Source Control**
+ When P4 is enabled, intermittent crashes no longer occur during the creation of a new level and its pending changelist.
+ In **Database View**, clicking **Overwrite** immediately saves the file locally without displaying a Perforce dialog box.
+ When a user is connected to Perforce, it is no longer possible to change currently available ScriptLines without checking them out.
+ Periodic P4 password checks no longer interfere with `rc.exe` write permissions when you save a texture in `crytif` format in Photoshop.
+ Submitting a canvas file to P4 no longer produces an error when the casing of the project name in the Windows path differs from the casing of the project name in P4.
+ After choosing **Save Modified External Layers** and then canceling the save operation, a dialog box stating that the layers have been saved no longer appears. 
+ After clicking the **Save** icon, edited files can now be saved in Perforce instead of only locally.
+ The state of the layer (for example, checked out by another user) is now correctly displayed when using Perforce in the editor.
+ A prompt dialog now appears when you want to save or check out changes to your levels when using Perforce in the editor.
+ The Perforce dialog for **Database View** now closes appropriately.

**Physics**
+ Validation error messages no longer display erroneously when you scale a physics entity that is a child of another entity. This has been fixed for the original entity as well.

**Project Configurator**
+ The **Project Configurator** can now detect if Lumberyard Editor is already open. If the editor is already open, the **Project Configurator** provides appropriate messaging and closes automatically.
+ When you set a default project in the **Project Configurator**, Perforce automatically checks out the `bootstrap.cfg` file. This applies if you use Perforce for source control.
+ Duplicate error messages have been removed.
+ The missing gems dialog box can now scale to show more content.
+ An error message displays if you attempt to create a new project and the `ProjectTemplates` directory is missing.
+ An error message displays if a gem is unable to load when the **Project Configurator** launches.

**Resource Compiler**
+ The **Resource Compiler** no longer deletes the 'Path' environment variable that is passed to it during startup.
+ The `.ini` files that the **Resource Compiler** uses now support different line endings.
+ `Rc.exe` can now run successfully whether `rc.ini` is formatted with windows or unix-style line endings.
+ Processes can now be spawned in `RCImageCompiler`. Standard calls to `ProcessWatcher::LaunchProcessAndRetrieveOutput` no longer fail inside the Windows API function `CreateProcessW` with return code 6 (Invalid handle).

**Scripting**
+ Behavior context methods now allow optional results.

**Twitch and Twitch ChatPlay**
+ Various updates includes fixing spelling errors, using AZ types, and applying proper EBus interfaces for Twitch ChatPlay, Channels, and Votes.

**UI Editor**
+ Child elements that are added to a slice instance no longer lose their order when you make changes to the slice instance.
+ The **UiTextComponent** no longer ignores special character processing of the dollar sign ($).
+ Cursor selection now works correctly to select clipped input text.
+ The editor no longer stops working when you attempt to change the width of the text element using markup.
+ The editor no longer stops working when you attempt to remove a non-existent sequence from the **Animation Editor**.
+ The ampersand (&) symbol no longer breaks the **Text** component in the **UI Editor**.
+ The save error dialog box now appears correctly.
+ UI slice files now successfully recompile when changes are pushed to child UI slices.
+ The UIFeatures level in the Samples project now works properly.
+ Changes to UI slice assets can now be saved.

**Virtual Reality**
+ Multiple tracking issues are fixed for the Oculus Rift and HTC Vive headsets.
+ GPU performance is improved for the HTC Vive headset.
+ In the VR\_Xylophone\_Sample level, the spawn point for boxes is now at the controller location.
+ The editor no longer displays material warnings when you open the VR\_BoxGarden\_Sample level.
+ When you rotate the InstantVR slice root or camera, the controller now rotates as expected.
+ The Oculus Touch controller no longer sends duplicate messages when you use the thumbstick.
+ AI nav mesh debugging visualization now appears correctly in VR.
+ The location of teleport particles is fixed in InstantVR slices.
+ Decals now render correctly in VR.
+ Flickering objects due to occlusion issues is no longer an issue in VR scenes.

**Miscellaneous**
+ Conversion of Matrix34 to Dual\_Quat is now marked explicitly to prevent losing precision.
+ Time demos no longer stop working on playback.
+ `Lyzard.exe` now loads gem libraries properly by overriding the `ComponentApplication::ResolveModulePath` function.
+ When you enter `lmbr.exe -help` in a command line window, the "Error:" message is no longer returned.
+ In the `user_settings.options` file, the `bootstrap_tool_param` key now displays only the default capabilities that are relevant to the operating system.
+ The `bootstrap_tool_param` key is now regenerated automatically if it can't be found in the `user_settings.options` file.
+ Folder wildcards in the `glob` configuration option that you add to the `AssetProcessorPlatformConfig.ini` file now work properly.
+ The `glob` parameter in `AssetProcessorPlatformConfig.ini` now processes the full path rather than the relative path.
+ The error `No to_python converter found for C++ type: struct SPyWrappedProperty` no longer occurs for Python commands.
+ **Layer Painter** properties now remain open when selecting the **Texture Layers** icon in the toolbar.
+ The editor no longer stops working when shutting down in `CClassFactory::GetClassesBySystemID()`. 
+ The **Open in Explorer/Finder** functionality doesn't use the desktop as a secondary option in some situations.