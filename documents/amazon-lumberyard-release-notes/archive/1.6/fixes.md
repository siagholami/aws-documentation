# Fixes<a name="lumberyard-v1.6-fixes"></a>

Lumberyard Beta 1.6 includes the following fixes:

**Asset Processor**
+ The Asset Processor now retains the specified proxy IP between sessions.
+ The Asset Processor no longer deletes built assets for a specific operating system when you build assets for a different operating system.
+ Double-clicking a failed job now displays the log files and information.
+ Replacing an asset file with a new version of the file using a drag-and-drop copy method now works properly.

**Az Code Generator**
+ The Az Code Generator parser now properly handles parentheses in strings and single quotation marks.
+ The parser now properly handles list type values and supports multiple base classes, runtime type information (RTTI) types, and similar constructs.

**Character and Animation**
+ Geppetto:
  + Fixed an issue where read-only qualities would temporarily display as editable in the right pane.
  + Fixed an issue where the first save of a CHRPARAMS file did not update the file on disk and reverted the UI to the previous state.
  + Fixed a repeating warning that occurred when invalid blendspace indices were added in Geppetto.

**Cinematics**
+ The **Track View** editor no longer allows the addition of `AZ::Entity` entities, which are not supported. Support for legacy entities remains unchanged.

**Cloud Canvas**
+ The BaseLambdaFlowNode files have been removed from Lumberyard.
+ The Cloud Canvas Resource Manager no longer returns an access violation error when attempting to right-click a lambda resource under the `project-template.json` file.
+ The Cloud Canvas Resource Manager now displays all created deployments in the **Create Deployment** window.
+ The keyboard shortcuts for search (**Ctrl\+F**) and save (**Ctrl\+S**) now work properly.
+ Setting up a default deployment now works as expected.
+ Creating a new deployment now works as expected.
+ Creating a new project stack now works as expected.
+ Creating a deployment with user-created resources now works as expected.
+ All versions of Darwin now compile as expected.
+ Levels now successfully load on macOS.
+ File type and encoding issues with Python files have been fixed to prevent integration errors.
+ The Don't Die sample level now launches correctly.
+ The Don't Die sample level no longer displays an errant message while in game mode.
+ When attempting to create a deployment without an active project, an error message now displays to indicate the project stack does not exist.
+ ConsumerTests now report the expected attribute values in the `SendSimpleEvent`.
+ When adding a resource group with an unauthorized non-admin account, the resource group is now displayed in the UI.
+ The **Add Resource** dialog box in the Cloud Canvas Resource Manager now validates the name of the resource to ensure it adheres to naming conventions.
+ Creating a new project stack without creating a deployment no longer produces an assert.
+ The Credentials Manager now displays an error if an AWS secret key, AWS access key, or profile name are not provided when adding a profile.
+ The project stack name can now accept up to 20 characters.
+ Cloud Canvas resource mappings are now updated more frequently.
+ More informative error messages are now displayed if resource mapping is not properly configured.
+ Detailed delete information is no longer displayed if a deployment is incomplete or not loaded in the UI.
+ Creating an S3 bucket resource now works as expected.
+ The `AttributeComparisonType` input for the `ScanTable` node now uses a drop-down list from which to select options.
+ The output ports for the `DynamoDBGet` node now use their correct data types. `DataOut` outputs a string type attribute. `NumberOut` outputs a number type attribute. `BoolOut` outputs a bool type attribute.

**Component Entity System**
+ The Script component now correctly indexes arrays that are defined in the property grid (indexed from 1, per Lua convention).
+ `OnSpawned` has been removed from the Lua API for the Spawner component. Lumberyard does not reflect `AZStd::vector` to script.
+ Each entity in the spawned slice now calls `OnEntitySpawned` to `SpawnerComponentNotificationBus` for the Spawner component.
+ GameEntityContextRequestBus has a new function to destroy entities from script. Note that deleting an entity does not delete the entities in its transform hierarchy. 

  ```
  deleteentityexample =
  {
  Properties =
  {
  EntityToDelete = { entity= "" , description= "Entity that will be deleted." },
  },
  }
  
  function deleteentityexample:OnActivate()
  local gameEntityRequestBus = GameEntityContextRequestBusSender(); gameEntityRequestBus:DestroyGameEntityById(self.Properties.EntityToDelet
  e) end
  ```
+ The **Create Component Entity** context menu has been removed when a level is not open.
+ Dragging a component onto the entity outliner—but not on an actual entity—no longer results in an invalid entity error.
+ Component entities no longer disappear after resizing terrain.
+ Components now serialize their persistent ID, ensuring that values are propagated through slices.
+ When parent and child entities are placed, the child's translation is no longer affected after entering and exiting game mode.
+ All components now display icons instead of Replace Me textures.
+ The Trigger Area components that were created in Lumberyard 1.5 now work properly in Lumberyard 1.6.
+ The array property UI now displays to allow you to specify entities for a Trigger Area component on an entity.

**FBX Settings**
+ The editor no longer crashes on shutdown if the FBX Settings is actively reporting Asset Processor progress.
+ A potential hash collision no longer occurs when adding nodes to the scene graph.
+ The editing functionality now works properly when the `PropertyVisibility_ShowOnly_Children` is set on the root element of a `ReflectedPropertyEditor`.

**Lens Flare Editor**
+ Reloading the level library no longer results in an error.
+ Reloading the same library multiple times in a row no longer results in an error.
+ Zooming out from the lens flare now fades the flare if it was affected by the distance fade factor.

**Lumberyard Editor**
+ The editor no longer crashes when undocking panels, closing, and then reopening the Particle Editor.
+ The editor no longer crashes when switching between multiple cameras in a map.
+ Pressing the **Esc** key now exits out of the brush tool for vegetation.
+ Selecting vegetation now snaps to the selected object in the vegetation rollup bar.
+ The viewport is no longer affected by the arrow keys when you navigate through the entity properties on the rollup bar.
+ Floating windows no longer display when you place a particle in the viewport and the rollup bar is closed when Lumberyard launches.
+ Keyboard shortcuts now work as expected across different floating windows.
+ The **Debug Views**, **View Modes**, and **Environment Modes** options have been added back to the customized tools options.
+ The **Convert to Procedural Object** option has been restored on prefabs.
+ Performance is no longer impacted when there are a few hundred slices in a level.

**Mobile**
+ The Lumberyard Setup Assistant now properly detects Android NDK revision 11 or later. You can also manually locate any of the subdirectories for `ndkpath\build`.
+ The shader compiler no longer produces errors if the shader compiler has spaces in its path.
+ The HumanFeatureHair map in the FeatureTests project now works as expected.
+ The decals in the Decals map in the FeatureTests project now render properly on Android devices.

**Networking**
+ The Network Profiler no longer experiences random crashes.
+ Legacy RMI calls of type `eRMI_ToOwningClient` are now executed only for the entity's owner.
+ Receiving a `SM_CONNECT_ACK` system message to a server without calling `SM_CONNECT_REQUEST` no longer results in a crash.

**macOS**
+ The TouchRayCast map in FeatureTests now prints text when you hover over each object.
+ The KeyboardBasic map in FeatureTests now renders properly on macOS.
+ The ability to connect to servers in MultiplayerLobby and MultiplayerProject now works on macOS.
+ The visual effect in the WeatherCloudBasic map in FeatureTests now renders properly on macOS using the OpenGL renderer.

**Twitch ChatPlay**
+ Twitch features have been updated for compatibility with Twitch's latest API. Twitch ChatPlay and Broadcast API now sends the required client ID header or authorization header.
+ The Twitch ChatPlay and Twitch API features now require a console variable to be set with your application's client ID to function correctly. The console variable for Twitch ChatPlay is `chatPlay_ClientID`. The console variable for Twitch API is `broadcast_ClientID`. You can set both values to the same client ID. To generate your client ID, register your application with Twitch by clicking **Settings**, **Connections**, **Register your application**.

**UI Editor**
+ The `LyShineDebug.cpp` code can now be copied outside of the LyShine DLL and compiled.
+ The editor no longer crashes when using the **Delete** key to delete an entire UI element.
+ The UI Animation editor no longer crashes when attempting to use the curve editor tool bar menu and a sequence isn't selected.
+ Textures with a prepended slash now render in release mode as expected.

**Virtual Reality**
+ Text rendering in 3D UI canvases has been fixed.
+ Text rendering has been optimized by minimizing graphics context switches.
+ Console rendering for VR has been optimized by minimizing context switches.
+ The FOV calculation in the Oculus Gem has been fixed so that objects now appear correctly sized.
+ The Camera component now uses the main IViewSystem to allow the Camera component to work with VR.

**Miscellaneous**
+ Lumberyard now runs as expected on a machine with more than 16 logical cores. **Thank you, Vijay D., for submitting this fix\!**
+ The net binding sync enabled flag now works properly. **Thank you to our anonymous customer for submitting this fix\!**
+ Tiling artifacts have been fixed in minimap generation.
+ The default maximum height for the Camera Height property in the minimap tool has been changed from 99 to 9999.
+ A crash bug has been fixed for terrain texture import.
+ Exported terrain heightmap rotation is no longer off by 180 degrees for the PGM format.
+ Monitor, scopes, and sketch shaders have been restored.
+ The `e_TexelDensity = 2` property now renders properly.
+ High resolution screenshots are functional again.
+ The `e_MergedMeshInstanceDistShadows` property independently controls shadow LOD.
+ A bug has been fixed for occlusion volumes.
+ A NaN artifact has been fixed when rendering water reflections of a vegetation shader with volumetric fog enabled.
+ A sun trajectory visual in the terrain lighting tool has been fixed to point in the correct direction.
+ Waf now reviews the correct QT libraries and does not prevent any builds from occurring.
+ The OpenSSL DLL files are now updated to version 1.0.2.8.
+ Executing the `LuaCompiler` command no longer results in a path resolution issue.
+ The order of deletion for the legacy Lua system has been fixed and members that were not previously initialized are now initialized.
+ `AZ::u32` and `Crc32` return values are now supported for ChangeNotify callbacks.
+ When instantiating a dynamic slice and meshes in the slice are not memory-resident, mesh asset loading no longer experiences occasional instability.
+ Owned entities in GameEntityContext no longer result in edge case issues in a network game.
+ In the new CodeGen system when tagging a class, you can now have more than one base class for the system to ingest and more than one class for the system to ignore.
+ Containers can now be edited by default.
+ The input name field provides multiple options for the event generator.