# Improvements and Changes<a name="lumberyard-v1.6-changes"></a>

Updates to Lumberyard systems and functionality include:

**Asset Processor**
+ The reaction time of the Asset Processor has been improved by eliminating an initial 100ms grace time imposed on file change detection. The grace time is no longer necessary.
+ The Asset Processor now creates a dedicated directory called `AssetProcessorTemp` in the Lumberyard SDK root folder for temporary files. This allows you to more easily locate the temporary files created by the Asset Processor.
+ The Asset Processor now saves information about individual jobs into the `\Bin64\logs\joblogs` directory. This allows you to more easily locate the job log files. You can also double-click a failed job to display the log files.

**Audio**
+ The wscript for the CryAudioImplWwise engine module has been improved to make it easier to change the Wwise SDK version in the `SetupAssistantConfig.json` file.
+ Lumberyard 1.6 includes the Audio Translation Layer (ATL) controls that you can create by following the Audio tutorials. The tutorials have been updated to include information about how to remove these controls if you intend to follow the tutorial steps.
+ The SamplesProject Wwise LTX project has been updated to version 2016.1.1.5823.

**AzTestScanner**
+ AzTest and AzTestScanner now support building and running unit tests on macOS.
+ AzTestScanner now includes two new flags to search for and include gems and game projects when scanning with whitelists.
+ AzTest now includes convenience macros to enable tests in executable files.
+ The CryUnitTest framework is no longer included with the engine. If you use CRY\_UNIT\_TEST or similar macros for your tests, you must migrate to AzTest.
+ Test builds now use test configurations. For example, test builds now use a command such as `build_win_x64_debug_test` where `debug_test` is the new configuration. Previously a command such as `build_win_x64_test_debug` was used.
+ You can now use `lmbr_waf.bat` and the `run_tests` command to call the AzTestScanner.
+ Use the AzTestScanner to run unit tests; the UnitTestLauncher is no longer available.
+ Various updates include fixes to tests and more modules enabled for testing.

**Character and Animation**
+ The Mannequin tool now persists clip choice when actions are installed or duration is queried. This allows the information to be synchronized between the client and the server.
+ The Maya validation system now validates only the objects that are being exported. This can reduce the export time for large scenes.

**Cinematics**
+ The **Track View** editor **Render Output** dialog now includes an **Active View Resolution** option to use the resolution of the active viewport.
+ The **Track View** editor **Render Output** dialog now includes a **Disable Debug Info** option that disables `r_DisplayInfo` debug information when rendering.

**Cloud Canvas**
+ iOS game clients can now access Cloud Canvas functionalities.

**Components**
+ The Static Mesh, Skinned Mesh, Decal, Light, Particle, and Lens Flare components now match the functionality of their legacy CryEntity counterparts.
+ The Trigger Area component now supports tag-based filtering. The Trigger Area component cannot use the tag component for second pass filtering. You can specify that required tags must be on an entity to activate the trigger. You can also specify that excluded tags must not be on an entity to activate the trigger.
+ The Tag component includes EBus events that notify you about changes to the OnTagAdded and OnTagRemoved tags.
+ The Camera component now supports VR devices. We recommend using the Camera component for your view needs and the CameraRequestBus for obtaining and setting camera properties.
+ Parametric blend parameters are now calculated for characters using the SimpleAnimation and Mannequin components. This enables you to use blend spaces with these components.
+ The SimpleAnimation component now supports animation-driven root motion as a flag. You can also toggle animation-driven root motion from C\+\+ script in the code or in the Lua-based character controllers.
+ **Shapes** has been moved from **Shared**, **Shapes** to **Shapes** in the **Component Palette**.
+ The Navigation component has been moved from **Game** to **AI** in the **Component Palette**.
+ Obsolete functionality, including **Target entities** and **Actions**, has been removed from the Trigger Area component. The Trigger Area component can no longer activate or deactivate entities. This functionality can be scripted in Lua instead. The **Activation**, **Triggered** menu now includes two options: **Specific entities** and **All entities**.
+ Added components include a Behavior Tree component and a Constraint component.
+ The component entity workflow now includes a **Layout** option in the **Layouts** drop-down menu. The layout options include **Outliner**, **Viewport**, and **Inspector**.

**FBX Settings**
+ The FBX Settings UI now uses the ReflectedPropertyEditor framework, which allows you to more easily extend the tool by creating your own groups and rules.
+ An EBus-based export process allows you to extend system behavior to populate custom data formats or manipulate the data during export.
+ Custom file serialization for SceneManifest has been transitioned to `AZ::Serialization`. The SceneManifest file extension has been changed from `.scenesettings` to `.assetinfo`. This will require legacy data to be reimported.
+ In the Reflected Property Editor, **PropertyRowWidgets** will now reclaim the unused space if an empty label is provided, returning the space to the editing widget.
+ Various updates include visually improving the error reporting and improving the logging coverage.

**GameLift**
+ Game session IDs are now formatted as follows: `arn:aws:gamelift:region::gamesession/fleet-fleet ID/ID string`. The *ID string* value is supplied either by a game client when creating a new game session or, if none is supplied, it is auto-generated by GameLift. See [GameSession](https://docs.aws.amazon.com/gamelift/latest/apireference/API_GameSession.html) and [CreateGameSession](https://docs.aws.amazon.com/gamelift/latest/apireference/API_CreateGameSession.html) in the *Amazon GameLift API Reference*.
+ All functionality that was previously in a separate GameLift Client API has now been incorporated into the AWS SDK. See [Amazon GameLift SDKs](https://docs.aws.amazon.com/gamelift/latest/developerguide/gamelift-supported.html) in the *Amazon GameLift Developer Guide*.

**GridMate**
+ The way that GridMate handles session services has been refactored to enable multiple session services to co-exist. Previously only a single session service could be active and all requests were made through a generalized interface. The generalized interface has been removed and now EBuses must be used to communicate with each session service.

  These changes may require you to migrate built-in services to the new methods or to update any custom services that you have created. For more information, see [Migrating Lumberyard Projects](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-migrating.html). For more information about GridMate, see [Networking System](https://docs.aws.amazon.com/lumberyard/latest/userguide/network-intro.html).

**Lens Flare Editor**
+ The Lens Flare Editor includes new default parameters and default textures. For example, flares are now visible when they are first created.
+ The viewport now displays a grid so a flare can be visualized in space.
+ You can now use the middle mouse button to pan the camera.

**Lumberyard Editor**
+ The default size for the **Asset Editor** window has been increased.
+ The **Undo** and **Redo** options for entities belonging to slice instances have been optimized.

**Lumberyard Setup Assistant**
+ The Lumberyard Setup Assistant executable is now signed.
+ The required SDKs and optional SDKs are now separated on two pages.
+ The refresh button on the SDK pages is now a system check button. The refresh button functionality remains unchanged on the other pages in the Lumberyard Setup Assistant.
+ Two new icons display SDK status. The yellow check mark indicates a validation is being performed. The down arrow indicates that SDK acquisition is being performed.
+ You can now hover over an SDK status icon to view a tooltip with additional information. The percentage complete now displays for any operation such as a validation or an acquisition.
+ SDKs must now include the `source` field. Lumberyard Setup Assistant uses the `source` field to determine where the contents of an SDK are located. For example, `"source": "path/to/root/of/sdk/relative/to/3rd/party"`.
+ SDK definitions now support a list of dependencies on other SDKs. When the Lumberyard Setup Assistant determines the required SDKs based on the current capabilities, it includes any dependent SDKs due to matching tags.

**Mobile**
+ Android: 
  + Clang is now the default compiler for Android projects. GNU Compiler Collection (GCC) is deprecated but still supported.
  + Specifying the Android tool chain is no longer required during the `configure` command. This allows you to configure once and then build Android using Clang or GCC, without needing to run the `configure` command again.
  + The minimum supported version of the Android NDK has been changed from 10d to 11.
+ iOS: Xcode 8 is now supported for iOS development.

**Networking**
+ The Lua Script component is now able to use network binding, which allows easier use in multiplayer games.
+ RPCs for RMIs is now split into (to) server and (to) client versions. The server versions do not propagate the RPC downstream. The client versions use ClientRMITraits, which can be modified to allow or disallow being called from clients.
+ The OnMemberLoadedMap and OnActorReceived RPCs now rely on built-in source peer ID so it cannot be spoofed by clients.
+ EntityReplica and GameContextReplica have additional checks to prevent them from being created by malicious clients. This is done by preventing proxy creation on the server.
+ A ReplicationSecurityOptions structure enables extra checks in the replica system and prevents object migration from breaking.
+ Non-authoritative RPC requests can be disabled per RPC by using the RPC trait `s_allowNonAuthoritativeRequests`.
+ `ReplicaManager::_Unmarshal()` can restrict the source of replica updates and other commands for improved security, and stop unmarshalling if an error occurs.
+ Spoofed upstream requests are prevented from including dataset updates.
+ RPC unmarshalling have additional checks to discard invalid RPCs and improve security.
+ RPC requestor m\_sourcePeer can only be set by trusted sources (server); otherwise, it is always derived by the receiver and not specified by the sender.
+ Guards were added against null chunks throughout the replica code. This helps to prevent crashes and undesired behavior.
+ The bandwidth overhead of SpawnParams for legacy game objects has been reduced.
+ Legacy script server properties are now reflected individually rather than as a block of data. This helps to minimize the amount of data sent on change.
+ Auto-search has been removed from GameliftLobby and MultiplayerLobby.

**UI Editor**
+ The **Zoom** and the **Pan** options now zoom around the mouse position and support the space bar to pan around the screen.
+ The current angle in degrees is now displayed in the viewport when rotating.
+ When UI elements are created or pasted the editor now generates locally unique names.
+ The Image component can now display a render target. This is useful for implementing a movie player, for example.
+ The interactable components now have UI canvas actions for hover start, hover end, pressed, and released.
+ Some of the UI canvases for FeatureTests were improved visually.

**Virtual Reality**
+ The IHMDController object is now in its own EBus.
+ The IHMDDevice object has been removed and replaced with HMDDeviceBus. This replaces the entire VR system with an EBus solution that is more modular and allows support for device-specific functionality such as the OpenVR playspace.
+ The HMDInitBus object has been added for all HMD gems to connect to at startup.
+ HMD gems are now sorted based on a sort key defined by the gem. This allows you to define the order that the devices are tested during initialization.
+ VR devices now connect to the HMDInitBus object on startup. When a valid device is found, the device connects to the HMDDeviceBus for use by the engine runtime.
+ The `VRCommon.h` file stores all of the data structures used by the VR system.
+ VR now supports Lua, which allows you to perform all functionality that was previously done using flow graph.
+ The HMDFramework Gem contains the HMDDebugger and other HMD systems and excludes vendor-specific HMD implementations.
+ The Camera component now supports VR.

**Waf Build System**
+ The Waf error messaging has been improved for instances when your project in the bootstrap file does not match the actual project that is being compiled. This issue can be caused by a typo.
+ The Waf performance has been improved when copying files, including deployment to console.

**Miscellaneous**
+ Az Code Generator binaries are now provided for the three host operating systems: win\_x64, darwin\_x64, and linux\_x64.
+ Canonical types provided in the AzCG intermediate format are now supported.
+ By taking advantage of multiple cores, the shader compiler server and shader compilation now has improved performance on most operating systems.
+ Enum values can now be reflected once to the **EditContext**. Previously enum values were reflected at each data member of the enum type. This improvement can make it easier to create drop-down lists based on enums in the editor.
+ Based on customer feedback, containers reflected to the **EditContext** can now be edited by default. To disable this feature, add a **ContainerCanBeModified** attribute and set the value to **false**.
+ A new UI helps to facilitate pushing of multiple fields and entities to any location in the valid slice hierarchy.
+ You can now visually opt in or opt out of individual additions, removals, and changes of entity or component data during a slice push.
+ The asset system has been turned into components and removed from the CrySystem module. New system components encapsulate interactions between an application and the Asset Processor. These new components have been moved into the Amazon framework to help remove an application's dependency on the CrySystem module.
+ Lumberyard now supports high DPI displays such as the Razer. This impacts Windows 8.1 and Windows 10, if the logical DPI value is set to a value other than 1.