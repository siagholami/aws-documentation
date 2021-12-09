# Improvements and Changes<a name="lumberyard-v1.11-improvements-changes"></a>

Lumberyard Beta 1.11 provides improvements and changes to Lumberyard systems and functionality. Choose a topic area to learn more.

**Topics**
+ [Android](#android-improvements-changes-v1.11)
+ [Asset Pipeline](#asset-pipeline-improvements-changes-v1.11)
+ [Code Changes](#code-improvements-changes-v1.11)
+ [Component Entity System](#component-entity-system-improvements-changes-v1.11)
+ [Empty Template Changes](#empty-template-improvements-changes-v1.11)
+ [FBX Settings](#fbx-settings-improvements-changes-v1.11)
+ [Gems](#gems-improvements-changes-v1.11)
+ [Geppetto and Mannequin](#character-editor-improvements-changes-v1.11)
+ [iOS](#ios-improvements-changes-v1.11)
+ [Lumberyard Editor](#lumberyard-editor-improvements-changes-v1.11)
+ [Lumberyard Setup Assistant](#lumberyard-setup-assistant-improvements-changes-v1.11)
+ [macOS](#macOS-improvements-changes-v1.11)
+ [Mobile](#mobile-improvements-changes-v1.11)
+ [Networking](#networking-improvements-changes-v1.11)
+ [Particle System](#particle-system-improvements-changes-v1.11)
+ [Project Configurator](#project-configurator-improvements-changes-v1.11)
+ [Twitch and Twitch ChatPlay](#twitch-and-chatplay-improvements-changes-v1.11)
+ [UI Editor](#ui-canvas-editor-improvements-changes-v1.11)
+ [Miscellaneous](#miscellaneous-improvements-changes-v1.11)

## Android<a name="android-improvements-changes-v1.11"></a>

Android has the following improvements and changes:
+ The NativeUI Gem allows you to display native dialog boxes on Android. These dialog boxes can contain informational text and buttons. When you enable this gem for a project in debug, asserts will display that allow you to break, ignore the assert instance, or ignore all asserts. Previously the assert printed to the log without prompting.
+ The RAD Telemetry Gem now works on Android so you can license RAD Telemetry for performance profiling and optimization.
+ You can now source AAR files into Waf to use.
+ Support for multiple `AndroidManifest.xml` files has been added.
+ A deploy option for unlocked devices enables you to push only changed native libraries from a command line: `--deploy-android-attempt-libs-only`. If enabled, `deploy_android_executable` will take precedence if modified. If `deploy_android_clean_device` is enabled, the option is ignored.
+ The GCC tool chain has been deprecated and will be removed in a future release.
+ Asset handling on Android is now consistent with other operating systems. For example, you can no longer push to `/sdcard/<game>` or `/storage/sdcard/<game>`. Instead you should use the deploy command, which automatically detects the correct path for your device. You can enable the deploy command in the `user_settings.options` file by setting the mode: `"--deploy-android-asset-mode <mode>" / deploy_android_asset_mode = <mode>`
  + `loose` – Pushes the compiled, loose assets to the device or runs in VFS mode, if set in the bootstrap.
  + `paks` – Generates and pushes the Pak files to the device.
  + `project_settings` – Uses the options that are specified in your game `project.json` file. Release forces this mode.
+ Various fixes and improvements for the build tools include more verbose error messages so you can diagnose the exact cause of an event, and Android-specific tasks running only when required.

## Asset Pipeline<a name="asset-pipeline-improvements-changes-v1.11"></a>

The asset pipeline has the following improvements and changes:
+ Product entries are hidden in the **Asset Browser** if they are the only children of a source and share the same name and extension as the source.
+ Builders in the `RC.exe` can now emit job results from the **Asset Builder** to integrate more deeply with the asset system.

## Code Changes<a name="code-improvements-changes-v1.11"></a>

The following are code improvements and changes:
+ Code-generated paths are now indexed by build type when added to Visual Studio solution files. This allows code-generated `.cpp` and `.h` files to be operated by Intellisense.
+ Code-generated `.cpp` and `.h` files now have debug symbol flags, which enable them to be debugged with symbols.
+ Variable shadowing has been eliminated in the code base. Warnings and errors have been enabled for clean modules.
+ `AZStd::atomic<T>` and associated free functions are now standards compliant to the C\+\+11 standard where we don't alias `std::atomic`.
+ EBuses now support the `LocklessDispatch` flag in its traits. This allows a bus to not lock during message dispatch, which can be a significant parallelization gain. You cannot connect or disconnect during dispatch on these buses. This helps on buses that are application lifetime singletons and will not remove handlers during normal application operations.
+ Each `AZ::Module` now creates its own system entity rather than relying on a single monolithic entity. This may create issues if `AZ::SystemEntityId` is used to address components that are from gems.
+ Attempts to queue a function, event, or broadcast on an EBus with `ref` or `const ref` arguments are caught at compile time. These parameters must be copied so you should pass them by value in this case. If you can guarantee the lifetime of the argument, use a pointer if possible. If you are certain that arguments you pass by reference have their lifetimes managed, add the `EnableQueuedReferences` flag to your bus traits.
+ An assert was added to catch EBus messages that are delivered from multiple threads on an EBus with no mutex. If you hit this assert, do one of the following:
  + Add `MutexType = AZStd::recursive_mutex` to your bus traits.
  + Restrict message sending to a single thread.
+ The maximum length of a log message has been increased from 2048 to 8096.
+ The API has been improved for working with custom view panes:
  + The view options struct has been moved out of the editor code and into AzToolsFramework.
  + The view options struct has been renamed and namespaced.
  + A new templated function has been added to wrap calls to the `EditorRequestsBus`. The new function automatically creates the widget creation factory function.
  + `OpenViewPane` and `CloseViewPane` have been added.
  + `ShowViewPane` is now called `OpenViewPane`.
  + Inline global methods have been added to the AzToolsFramework namespace to wrap calls to the EBus.

  These updates allow the code to be written as follows:

  ```
  #include <AzFramework/API/ApplicationAPI.h>
  
  AzToolsFramework::RegisterViewPane<MyViewPaneWidget>("MyNewPane", "MyCompany's Tools");
  
  Instead of this:
  
  #include <QtViewPane.h> 
  #include <AzFramework/API/ApplicationAPI.h>
  
  AZStd::function<QWidget*()> windowCreationFunc = []()
  
  { return new MyViewPaneWidget(); }
  
  ;
  
  QtViewOptions options; // have to declare this, and it's not namespaced!
  AzToolsFramework::EditorRequests::Bus::Broadcast(&AzToolsFramework::EditorRequests::RegisterViewPane, "MyNewPane", "MyCompany's Tools", options, windowCreationFunc);
  ```

## Component Entity System<a name="component-entity-system-improvements-changes-v1.11"></a>

The component entity system has the following improvements and changes:
+ When you select an entity in the viewport, the hierarchy in the **Entity Outliner** automatically expands to display the current selection.
+ You can now use `ConsoleRequestBus` and call `ExecuteConsoleCommand` to execute console commands from a script.
+ You can now right-click an asset reference in the **Entity Inspector** and copy and paste asset references between components.
+ Various performance improvements to the component entity system include slice loading; slice creation and saving; and entity creation, activation, and deletion. Performance has been improved for large slices (thousands of entities).
+ The **Entity Outliner** was updated with the following:
  + Performance improvements
  + Ability to reorder entities
  + More functional drop zones
  + Updated visuals for slice entities
  + More consistent context menus with added functionality
  + Icons that show when the children of a parent entity are in a mixed state (visible/hidden or locked/unlocked)
+ You can now drag and drop to reorder components in the **Entity Inspector**. New context menu options allow you to quickly save overrides to a slice by right-clicking on an entity in a slice.
+ The Static Mesh component is now called Mesh component. The Mesh component provides an optimized static mesh and dynamic meshes based on the selected options. For the most optimal mesh rendering and processing, you can use a mesh with the static transform enabled. The **Deformable Mesh** option on static meshes supports merged cloth assets vertices to deform while remaining static.
+ The Area Light component now has FOV added to tune the spread.
+ Support has been added to generate multiple bounces on the Environment Probe component and reset the generated cubemap to none. The lighting result becomes insignificant after three bounces.

## Empty Template Changes<a name="empty-template-improvements-changes-v1.11"></a>

The Empty Template has the following changes:
+ Files in the Empty Template are updated to use the `${ProjectName}` markup for replacement during project creation.
+ `Scripts\GameRules\DummyRules.lua` is removed from the Empty Template. Game rules are not required for Lumberyard games to function.
+ The following files are removed from the Empty Template:
  + `Scripts\network\CompressionPolicy.xml`
  + `EntityScheduler.xml`
  + `Scheduler.xml`
+ `Scripts\GameObjectSerializationOrder.xml` is removed from the Empty Template. A warning message about this file as missing is moved to a log file. Lumberyard is moving away from the GameObject system toward the new component entity system. If you want to define the order of serialization for GameObject extensions, create an XML file named `GameObjectSerializationOrder.xml` in your project's scripts folder, and include contents like the following:

  ```
  <?xml version="1.0"?>
  <!-- this defines the serialization order for game object extensions within an entity -->
  <!-- extensions not in the list get the lowest priority (serialized last) -->
  -<extensionsSerializationOrder>
  <Inventory/>
  <Interactor/>
  <Player/>
  <AnimatedCharacter/>
  </extensionsSerializationOrder>
  ```
+ `Scripts\main.lua` is removed from the Empty Template. We recommend that you write your Lua scripts within the new Lumberyard script context, and not the legacy Cry script context. If you want to continue using the Cry script context, you can create a file named `main.lua` in your scripts folder, and it will be loaded automatically by `CCryAction::CompleteInit()`. CryAction will attempt to call `OnInit` on loading the script.
+ `Scripts\physics.lua` is removed from the Empty Template. We recommend that you write your Lua scripts within the new Lumberyard script context, and not the old Cry script context. This file previously contained only commented out notes about the explosion system. 

  ```
  -- This file is (optionally) loaded and executed on C3DEngine::LoadPhysicsData() call.
   
  --------------------------------------
  -- Register explosion and crack shapes
  --------------------------------------
   
  -- RegisterExposionShape params, in this order:
  -- 1) Boolean shape CGF name
  -- 2) Characteristic "size" of the shape: Ideally it should roughly represent the linear dimensions of the hole
  --    Whenever a carving happens, it requests a desired hole size (set in explosion params or surfacetype params), and the shape is scaled by [desired size/characteristic size]
  --    If several shapes are registered with the same id, the one with the size closest to the requested will be selected, and if there are several shapes with this size, one of them will be selected randomly
  -- 3) Breakability index (0-based): Used to identify the breakable material
  -- 4) Shapes relative probability: When several shapes with the same size appear as candidates for carving, they are selected with these relative probabilities
  -- 5) Splinters CGF: Used for trees to add splinters at the place where it broke
  -- 6) Splinters Scale: Splinters CGF is scaled by [break radius * splinters scale], i.e. splinters scale should be roughly [1 / most natural radius for the original CGF size]
  -- 7) Splinters Particle FX name: Is played when a splinters-based constraint breaks and splinters disappear
  -- 
  -- RegisterExposionCrack params, in this order:
  -- 1) Crack shape CGF name (must have 3 helpers that mark the corners, named "1","2","3")
  -- 2) Breakability index (same meaning as for the explosion shapes)
   
  --[[  EXAMPLES
  Physics.RegisterExplosionShape("Objects/default/explosion_shape/tree_broken_shape.cgf", 7, 2, 1, "",0,"");
  Physics.RegisterExplosionShape("Objects/default/explosion_shape/tree_broken_shape2.cgf", 1.3, 3, 1, "",0,"");
  Physics.RegisterExplosionShape("Objects/default/explosion_shape/tree_broken_shape3.cgf", 1.3, 5, 1,
                                 "Objects/default/explosion_shape/trunk_splinters_a.cgf",1.6,"breakable_objects.tree_break.small");
  --]]
  ```
+ `.p4ignore` is removed from the Empty Template. If you are using Perforce, we recommend following the Lumberyard Perforce setup instructions, which includes information about setting up a Perforce ignore file. For more information, see [Using the Perforce Plugin with Lumberyard](https://docs.aws.amazon.com/lumberyard/latest/userguide/setting-up-lumberyard-perforce-plugin.html) in the *Amazon Lumberyard User Guide*.
+ `Config\Input\ActionMaps.xml` is removed from the Empty Template. We recommend that you use Lumberyard's input system. If you want to continue to use action maps, note that they are deprecated. If you want to use them with a new project, you add an `ActionMaps.xml` file to your project's `Config\Input folder`, and start with this data:

  ```
  <profile version="1">
   
    <!-- platforms - Used to define which keys to map for each action based on the platform that is in use -->
    <platforms>
      <PC keyboard="1" xboxpad="1" ps3pad="0" androidkey="0"/>
    </platforms>
   
    <!-- default - Default action key mappings -->
    <actionmap name="default">
    </actionmap>
   
    <actionmap name="player">
      <!-- USER DEFINED -->
   
      <!-- USED INTERNALLY - DO NOT REMOVE -->
      <action name="moveleft" onPress="1" onRelease="1" retriggerable="1" keyboard="a"/>
      <action name="moveright" onPress="1" onRelease="1" retriggerable="1" keyboard="d"/>
      <action name="moveforward" onPress="1" onRelease="1" retriggerable="1" keyboard="w"/>
      <action name="moveback" onPress="1" onRelease="1" retriggerable="1" keyboard="s"/>
      <action name="rotateyaw" keyboard="maxis_x" />
      <action name="rotatepitch" keyboard="maxis_y" />
      <action name="xi_movey" xboxpad="xi_thumbly"/>
      <action name="xi_movex" xboxpad="xi_thumblx"/>
      <action name="xi_rotateyaw" xboxpad="xi_thumbrx"/>
      <action name="xi_rotatepitch" xboxpad="xi_thumbry"/>
    </actionmap>
   
  </profile>
  ```
+ The default profile for the action map system is removed from the Empty Template. Currently, there is no replacement profile system yet, so if you want to use one and do not want to write your own, do the following:

  1. Clone the contents of the LegacyGameInterfaceGem into a new gem or your project.

  1. In `Actor.cpp`, update the call to `SetClientActor` to pass in `true` for the `setupActionMaps` parameter.

  1. Enable the UserLoginDefault Gem.

  1. Add these files with these contents to your project:
     + `libs\config\profiles\default\actionmaps.xml`
     + `libs\config\profiles\default\attributes.xml`
     + `libs\config\profiles\default\profile.xml`
     + `libs\config\defaultprofile.xml`

  1. To complete your game, build a final login system using the UserLoginDefault Gem as a template. This is meant to be a stub interface to allow release builds to function with action maps, and is not a complete user login system. You can use the GameSDK project for reference.
+ The list of default gems has been reduced to the minimum required for a new project to load in Lumberyard Editor, as well as the Windows launcher in both non-monolithic (debug, profile) builds, and as monolithic builds (release).
  + The PBSreferenceMaterials, Camera, PhysicsEntities, UiBasics gems are no longer enabled by default for projects using the Empty Template. These are useful to enable, but not required gems. They are on by default in the Simple Template.
  + The UserLoginDefault Gem is no longer enabled by default for projects using the Empty Template. This gem is associated with the deprecated action map system. In release builds of Lumberyard, game projects using the action map system, a login system is required to track user profiles and controller customization. The UserLoginDefault Gem was a simple implementation meant to allow release builds to function, but is not a complete implementation of a usable user profile system. We recommend that you write your own user profile system for now instead of using this system. If you want to use this system, see the above notes on the profile system.
+ The following gems are enabled by default:
  + LegacyGameInterface – This is a new gem introduced in 1.11 that contains boilerplate implementation for systems that the Lumberyard engine and editor require to launch.
  + CryLegacy – This gem is required to initialize the Game Framework and load the CryAction DLL.
  + LmbrCentral – This gem contains component interfaces for legacy systems.
  + LyShine – This gem is required for the Lumberyard UI system to function, which is required for Lumberyard Editor to load.
  + Your project's gem – The code for game projects is contained in gems now, and your project's gem is enabled by default.
+ For more information about the Empty Template, see [Creating and Launching Game Projects](https://docs.aws.amazon.com/lumberyard/latest/userguide/configurator-projects.html) in the *Amazon Lumberyard User Guide*.

## FBX Settings<a name="fbx-settings-improvements-changes-v1.11"></a>

FBX Settings has the following improvements and changes:
+ If you have an `.fbx` file with multiple skeletons, multiple skeleton groups are not automatically created in the **FBX Settings**. (CryAnimation feature only)
+ The processing and report window for **FBX Settings** has a visual update.
+ Sub IDs for products from `.fbx` files are now stable. Objects no longer disappear when settings are updated. There may be rare instances of sub IDs not being backward compatible. In these instances, you must manually add your products to the world again.

## Gems<a name="gems-improvements-changes-v1.11"></a>

Gems have the following improvements and changes:
+ Gems can now contain more types of code. Gems can also produce zero or more game modules, editor modules, static libraries, and asset builders. To add an editor module, set `EditorModule` to **true** in the `Gem.json` file.
+ A new tutorial gem demonstrates how to extend the SceneAPI.
+ You can now define asset types and processing rules in gems.

## Geppetto and Mannequin<a name="character-editor-improvements-changes-v1.11"></a>

Geppetto and Mannequin have the following improvements and changes:
+ In Lumberyard 1.11, **Geppetto** and **Mannequin** are disabled by default and **Animation Editor** is enabled by default. You can access **Geppetto** and **Mannequin** by enabling the **CryLegacyAnimation Gem** in the **Project Configurator**.

## iOS<a name="ios-improvements-changes-v1.11"></a>

iOS has the following improvements and changes:
+ The NativeUI Gem allows you to display native dialog boxes on iOS. These dialog boxes can contain informational text and buttons. When you enable this gem for a project in debug, asserts will display that allow you to break, ignore the assert instance, or ignore all asserts. Previously the assert printed to the log without prompting.
+ Support has been added for the beta versions of Xcode 9 and iOS 11.

## Lumberyard Editor<a name="lumberyard-editor-improvements-changes-v1.11"></a>

Lumberyard Editor has the following improvements and changes:
+ The speed for importing terrain megatextures and generating terrain textures has improved.
+ The welcome screen now displays up to 12 of the most recently opened levels.
+ To provide better performance for the editor on laptops and minimum spec machines, `sys_MaxFPS` is set to **60** in the `editor.cfg` file. This setting affects editor performance only and does not affect runtime performance. You can change the editor behavior to the default by commenting out `sys_MaxFPS = 60` in the `editor.cfg` file. Lumberyard defaults to `sys_MaxFPS = -1`, which sets the maximum frame rate to be unbounded.
+ Window snapping has been added to help manage multiple windows in the editor. To snap a window in place, move the window close to a stationary window. Snapping works on the top, bottom, left, and right borders of the pane.
+ Emissive lighting with deferred decals is now supported.

## Lumberyard Setup Assistant<a name="lumberyard-setup-assistant-improvements-changes-v1.11"></a>

Lumberyard Setup Assistant has the following improvements and changes:
+ Echo is now turned off when the `SetupAssistant.bat` runs.
+ When you navigate to the following third-party software and plugins, you're now asked for the directory and not the file: Android SDK, Android NDK, and FFmpeg.
+ The installation description for the Visual Studio 2015 C\+\+ Compiler has been updated.
+ A warning displays if you attempt to close the **Lumberyard Setup Assistant** while symlinks are being generated.
+ A warning displays if you attempt to close the **Lumberyard Setup Assistant** while active operations are in progress.
+ A warning displays on the SDKs page if your workspace is unavailable.
+ The **Lumberyard Setup Assistant** is now an executable for macOS.
+ You can now download Qt for Linux in the **Lumberyard Setup Assistant**.

## macOS<a name="macOS-improvements-changes-v1.11"></a>

macOS has the following improvements and changes:
+ Support for Yosemite and OpenGL are deprecated and will be discontinued in Lumberyard 1.12.
+ Metal is now the default renderer on macOS instead of OpenGL.
+ The NativeUI Gem allows you to display native dialog boxes on macOS. These dialog boxes can contain informational text and buttons. When you enable this gem for a project in debug, asserts will display that allow you to break, ignore the assert instance, or ignore all asserts. Previously the assert printed to the log without prompting.

## Mobile<a name="mobile-improvements-changes-v1.11"></a>

Android and iOS builds are now smaller. An empty project is \~20 Mb on Android and \~25 Mb on iOS.

## Networking<a name="networking-improvements-changes-v1.11"></a>

Networking has the following improvements and changes:
+ Transform replication data has been optimized to help reduce bandwidth.
+ The Driller logging system can now write profile output to a file.
+ Special queries from the **Interest Manager** have been optimized and the **Interest Manager** UI has been improved. Documentation will be added for the next release.
+ Multiplayer Sample now uses the **Interest Manager** to support a higher number of asteroids.
+ The GridMate transport layer now has a compression interface and API.
+ The Transform component can now be interpolated (Position, Rotation) on clients. The default value is Linear, but you can easily add your own interpolation algorithms.

## Particle System<a name="particle-system-improvements-changes-v1.11"></a>

The particle system has the following improvements and changes:
+ The parameters for the Particle component are now exposed to the track view system.
+ When you reorder child particles in the particle library, the particles are now rendered according to the updated particle order.

## Project Configurator<a name="project-configurator-improvements-changes-v1.11"></a>

The Project Configurator has the following improvements and changes:
+ You cannot disable a gem that an enabled gem depends on.
+ The Project Configurator scans the `ProjectTemplates` directory for a `templatedefinition.json` file. This file contains information about the template, such as the display name, description, and path for the icon. This file is not used or required if you create projects with the Lyzard SDK or `lmbr.exe`.

## Twitch and Twitch ChatPlay<a name="twitch-and-chatplay-improvements-changes-v1.11"></a>

The Twitch Gem has two new APIs: Commerce APIs and an API to retrieve the Twitch entitlement ID.

## UI Editor<a name="ui-canvas-editor-improvements-changes-v1.11"></a>

The UI Editor has the following improvements and changes:
+ Various changes to the **UI Editor** include improved navigation, an option to automatically activate interactive elements, and the ability to move between interactive elements in a scroll box.
+ The UiText component now includes **Character Spacing** and **Line Spacing** properties.
+ The `LyShineExamplesCppExample.cpp` example (located in the `\Gems\LyShineExamples\Code\Source` directory) demonstrates how to create a UI canvas in C\+\+.
+ The `UiCustomimageComponent.cpp` example (located in the `\Gems\LyShineExamples\Code\Source` directory) demonstrates how to create a custom UI component in C\+\+.
+ You can now detach slice entities and slice instances in the **UI Editor**.
+ The LyShine Gem is now required and automatically enabled when you create a new project.
+ The **Open Canvas** dialog box now defaults to the previous location that a canvas was opened from or saved to.
+ The **Properties** pane now displays the name of the selected element.
+ The Samples Project level called UiFeatures replaces the FeatureTests level called LyShineFeatures. LyShineFeatures has been removed.
+ `GetUiCursorPosition` has been added to `UiCursorBus`.

## Miscellaneous<a name="miscellaneous-improvements-changes-v1.11"></a>

Lumberyard has the following miscellaneous improvements and changes:
+ You can now provide a template name when you create your project with `lmbr.exe` or build your custom interface with the Lyzard SDK. If you don't provide a template, the empty template will be used.
+ You can now use the debug version of Lyzard modules to link against debug binaries.
+ The `prepare_dependencies.bat` now provides more information when Qt libraries are not copied successfully.