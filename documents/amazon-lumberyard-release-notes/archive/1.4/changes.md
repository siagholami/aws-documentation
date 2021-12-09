# Improvements and Changes<a name="lumberyard-v1.4-changes"></a>

Lumberyard 1.4 includes the following systems and functionality updates:

**Character and Animation**
+ Geppetto
  + Perforce is now fully integrated, which includes the ability for you to add and save files.
  + The time required for CAF live reloading and importing has been reduced.
  + When the first animevent is added on a character's animation, an ANIMEVENTS file is automatically generated and added to the character's animation list.
+ FBX Settings
  + FBX files now have an improved loading time.
  + The CgfExporter class has been refactored to improve code robustness and support customization.

**Cinematics**
+ The **Track View** editor now supports multiple **Comment** nodes for **Director** or **Sequence**.
+ The **Render Output** dialog box now supports `.tiff` files.
+ The **Render Output** dialog box now supports rendering images with an existing alpha channel, making it easier to composite images with external compositing software.

**Cloud Canvas**
+ AWS Python SDK (Boto3) 1.2.1 is now located in the `\Tools\AWSPythonSDK` directory and is always present. Previously it was a junction point created by the Lumberyard Setup Assistant (located in the `\Code\SDKs\AWSPythonSDK` directory).
+ Python is now located in the `\Tools\Python` directory and is always present. Previously it was a junction point created by the Lumberyard Setup Assistant (located in the `\Code\SDKs\Python`, `\Code\Sandbox\SDKs\Python`, and `\Code\Tools\SDKs\Python` directories.
+ AWS Native (C\+\+) SDK has been upgraded to version 0.12.16.
+ Lumberyard Editor and all tools now use Python 2.7.11.

**GameLift**
+ GameLift fleets can now run more than one server process on each Amazon EC2 instance. With this change you can now configure a fleet to run multiple processes of the same game server on an instance, run multiple different game servers on an instance, or both. This improvement gives you greater control over how you use your GameLift resource, may help decrease gaming hosting costs, and give you better response time when scaling up for new players. The following changes were made to support multiple processes:
  + In the AWS SDK/CLI for GameLift:
    + `CreateFleet()` has a new parameter, `RuntimeConfiguration`, which contains the configuration for one or more server processes. This parameter replaces the parameters `ServerLaunchParameters` and `ServerLaunchPath`. In addition, the `CreateFleet()` parameter `EC2InboundPermissions` now has a slightly different function; to support multiple processes, each server process now specifies its own port number, on launch, and it must fall in the range specified with this fleet parameter.
    + New API actions: `DescribeRuntimeConfiguration` and `UpdateRuntimeConfiguration`.
    + New data structures: `RuntimeConfiguration` and `ServerProcess`. A `RuntimeConfiguration` object has a collection of server process configurations for a fleet. A `ServerProcess` object identifies the launch path and parameters for a server executable in the build, and specifies how many of this server process should run concurrently.
    + The data structures `GameSession` and `PlayerSession` now include the port number for a game server process.
    + The data structure `FleetUtilization` now includes `ActiveServerProcessCount`.
  + In the GameLift Server SDK:
    + `ProcessReady()` and `ProcessReadyAsync()` have new parameters to support multiple processes including port number and log parameters. In addition, parameters are now in a `ProcessParameters` structure and are passed by reference.
  + In the Amazon GameLift console:
    + The page for creating a new fleet now requires a runtime configuration setting, to include at least one server process configuration.
    + You can no longer specify the location of log files for a fleet. Paths for game session logs should now be passed to GameLift by each server process in the `ProcessReady()` call. If you need to specify log paths for a fleet, use the AWS CLI command `CreateFleet()`.
    + The fleet detail page now shows the number of active servers as well as instances and game sessions. There is also a new **Capacity allocation** tab, which lists all the server process configurations in the fleet's runtime configuration.
    + The fleet detail page, **Metrics** tab, now includes statistics on server processes across the fleet, including the number currently active, activations, terminations, etc.
+ The following changes were made to support the new health checks feature:
  + In the GameLift Server SDK: `ProcessReady()` and `ProcessReadyAsync()` now take the name of an optional health check callback function (`onHealthCheck()`). Implement this function as needed to return a health status for the process.
  + In the Amazon GameLift console, the fleet detail page, **Metrics** tab, includes health statistics for server processes across the fleet, including the number of healthy processes and the percentage of total active processes that are healthy.
+ In the GameLift Server SDK, the new API action `GetSdkVersion()` retrieves the current SDK version as a string.
+ In the GameLift Server SDK, in `ActivateGameSession()`, the maxPlayers parameter has been removed. Maximum players for a game session is set in the client request for a game session (see the GameLift API `CreateGameSession()`).
+ A game build uploaded to GameLift no longer requires an `install.bat` file.

**Gems**
+ Using `lmbr.exe` to create gems now results in error messages when appropriate. For example, an error message will display when you attempt to enable a gem that does not exist.
+ Existing and new gems now use IMPLEMENT\_AZ\_TEST\_SCANNER\_HOOK. Previously, gems used GEM\_IMPLEMENT\_TEST\_RUNNER. We recommend that you update user-generated gems to use IMPLEMENT\_AZ\_TEST\_SCANNER\_HOOK and `AzTest.h`.

**Lumberyard Editor**
+ If an in-game camera is not configured when entering game mode, the editor camera is used. Press **Esc** to return to edit mode with the camera settings that were used before entering game mode.
+ The editor now supports relative path names for input files when in batch mode. For example, relative path names are supported when exporting all levels using a batch file.
+ Performance has been improved for Lumberyard Editor when the Material Editor is open.
+ The following keyboard shortcuts are now supported for terrain, vegetation, and hole brushes:   
**Modify Terrain**    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/lumberyard-v1.4-changes.html)  
**Layer Paint**    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/lumberyard-v1.4-changes.html)  
**Vegetation Paint**    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/lumberyard-v1.4-changes.html)  
**Hole Paint**    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/lumberyard-v1.4-changes.html)

**Material Editor**
+ Movement control in the viewport is now similar to the main editor control.
+ Updates to the grid, axis, and default lighting in the preview window now result in better display of specular and normal maps.

**Mobile**
+ Shader packaging scripts have been updated to work with different projects. This change requires minimal modification of the scripts.

**Networking**
+ The `Twitch:API:GET` node now returns more meaningful error messages, allowing you to better troubleshoot.
+ The Trigger Area component is now network enabled.
+ The Multiplayer Gem now includes:
  + A sample Multiplayer Lobby component.
  + Cry Network session code. You must include the Multiplayer Gem in any multiplayer project that uses the Cry Network shim.
  + GameLift flow graph nodes. These nodes are no longer available in the GameLift Gem.
+ GridMate now includes UuidMarshaler to allow universal unique IDs (UUID) to be marshaled.
+ You can now use replica chunks without an active session.

**Particle Editor**
+ You can now move particles and folders between libraries.
+ You can now remove libraries that contain particles.

**Project Configurator**
+ The Project Configurator no longer invokes lmbr.exe; instead it shares code, which improves error messaging.
+ You can now interact more quickly with multiple gems.

**System Requirements**
+ Supported drivers for PC: 
  + Nvidia driver version 368.81 (4095 MB)
  + AMD driver version 16.15.2211 (1517 KB)

**UI Editor**
+ The UI Editor now has source code control integration for UI canvases, prefabs, and sprites.
+ The UI Editor now saves the expanded, visible, and selected states for each element in the UI canvas file. 
+ The UI Editor now remembers the position and size of each dockable sub-window.
+ The **UI Animation** editor is now a dockable pane within the UI Editor window.
+ UI elements can now be locked in the UI Editor so that they cannot be selected in the viewport.
+ When the transform for a UI element is controlled by a parent layout component, the element's transform properties are no longer displayed or editable in the **Properties** pane.
+ The file browser for selecting textures and sprites is now restricted to files in the project and its gems. You can drag files from the **File Browser** view pane.
+ The Text component now supports word wrap and text clipping.
+ The default font for the Text component is now called default-ui.
+ The UiBasics Gem now has additional fonts: Vera Sans, Vera Sans Bold, Vera Sans Italix, and Vera Sans Bold Italic.
+ The FontRendering example in FeatureTests was extended to showcase several fonts.
+ The sprite **Border Editor** now shows border lines more clearly.
+ Added support for editing multiple selected elements for pivots and offsets.
+ Added preliminary support for Lua scripting.
+ Updated the style of the UI prefabs that are included in the UiBasics Gem.
+ Interactable UI components now: 
  + Share a common base class.
  + Override the state of child elements for Hover, Pressed, and Disabled. For example, a button can now change its text color.
  + Have an **Input Enabled** property visible in the editor.
+ Added numerous flow graph nodes to access UI components. For more information, see [UI Flow Graph Nodes](https://docs.aws.amazon.com/lumberyard/latest/userguide/fg-node-ref-ui.html).

**Virtual Reality**
+ The OpenVR and Oculus controller flow graph nodes have been removed and replaced with Lumberyard's new event-based input system.
+ A new flow graph node has been added to provide information about the connected virtual reality (VR) device.
+ Connected devices are now sorted at startup using a sorting metric that is defined in the VR device gems.
+ The render/screen resolution is now automatically sized based on the device's desired render resolution when **output\_to\_hmd** is enabled.
+ You can now use the new console variable `r_ResolutionScale` for resolution scaling.
+ The OpenVR gem has been upgraded to the OpenVR SDK version 1.0.
+ You can use new Dynamic flow graph nodes to expose linear or angular velocities and accelerations for any connected VR devices.
+ SamplesProject now includes a VR\_BoxGarden\_Sample level that demonstrates motion controller setup and input event scripting.
+ The OpenVR playspace is now exposed through flow graph.

**Miscellaneous**
+ The default capabilities in Lumberyard Setup Assistant now include running the editor.
+ The Visual Studio 2013 compiler is now a software dependency for compile capabilities.
+ The startup and scan time for the Asset Processor has been improved.
+ You can now spawn slices at runtime. Create a dynamic slice by right-clicking a slice file in the Asset Browser.
+ Lumberyard engine code now references AzTest for unit testing instead of referring directly to `GoogleTest/GoogleMock`.
+ Various changes to the AzTestScanner include adding whitelist and blacklist functionality, the ability to wait for a debugger flag, and better output optimization.
+ You can now create custom asset types based on `AZ::Data::AssetData` that use automated editing and serialization/reflection. You can use Lumberyard Editor to edit the asset, which is loaded and managed like other AZ assets.
+ For AZ Reflection, the **EditContext** attribute has been refactored so that EnumValue now uses the EnumAttribute method.
+ Global constants now help to make the component reflection usage more discoverable.
+ Various updates to the Input configuration component include allowing input bindings to be edited in the Asset Editor, grouping input handlers by the gameplay event that they generate, and using entity IDs and input event names for input bus ID keys. The default values for the ID components act as wildcards; therefore, the default entity is all entities and the default input name is any input. You can now use Lua and Flow Graph to handle gameplay events that are generated by the raw input handlers.
+ The Texture Browser tool (legacy) has been removed.