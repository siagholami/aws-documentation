# Improvements and Changes<a name="lumberyard-v1.7-changes"></a>

Updates to Lumberyard systems and functionality include:

**Advance Notice for Change in Lumberyard Beta 1.8**
+ Lumberyard Beta 1.8 will introduce consequential changes to the behavior context. Significant improvements to Lumberyard Editor include replacing the existing script context with a new reflection context. In order to ensure a smooth upgrade experience, we are providing all information, steps, and tools in advance. Details are outlined in our [forums](https://forums.awsgametech.com/).

**Asset Pipeline**
+ The Asset Processor Job API allows you to query the status of particular compile jobs from the editor and other tools. This API now allows you to escalate the jobs that are returned to the top of the build queue for prioritization. If you are developing new assets and editors, you can use this API to query the status of your assets, retrieve log files, and escalate jobs.
+ You can now declare asset types as critical in the `AssetProcessorPlatformConfig.ini` file. This allows the asset types to compile and escalate to the top of the compile queue before the runtime or editor can start running.
+ Dynamic slices are now considered to be critical assets.
+ The priority of copy jobs is honored if present in the `AssetProcessorPlatformConfig.ini` file. This allows you to arrange jobs in order of priority, even during the copy phase.

**Audio**
+ Renamed the following audio components EBus for consistency across components:
  + **AudioTriggerComponentRequestsBus** renamed to **AudioTriggerComponentRequestBus**
  + **AudioTriggerComponentNotificationsBus** renamed to **AudioTriggerComponentNotificationBus**
  + **AudioRtpcComponentRequestsBus** renamed to **AudioRtpcComponentRequestBus**
  + **AudioSwitchComponentRequestsBus** renamed to **AudioSwitchComponentRequestBus**
  + **AudioEnvironmentComponentRequestsBus** renamed to **AudioEnvironmentComponentRequestBus**
  + **AudioProxyComponentRequestsBus** renamed to **AudioProxyComponentRequestBus**

  If you use the old EBus names in Lua or native C++, you must update your code to use the new EBus names. This applies if you manipulate or call into the audio components from code.
+ Fragments that play on a component entity (`AZ::Entity`) are now able to execute audio triggers and particle effects in their ProcClips.
+ A basic set of unit tests have been added to CrySoundSystem, which is part of an effort to increase unit test coverage across Lumberyard.
+ The ability to have another listener override the default has been improved. This does not include full support for multiple active listeners.

**AzCodeGenerator**
+ A new tag format and scoped annotations has been implemented.
+ Profiling has been added to the AZ Code Generator tool to time clang parsing and script execution. For information, see [AZ Code Generator](https://docs.aws.amazon.com/lumberyard/latest/userguide/az-code-gen-intro.html).

**AzTestScanner**
+ The ability to specify multiple whitelist or blacklist files has been added.
+ A new location for the default whitelist and blacklist files has been added. The default blacklist file is also included with the build.
+ The ability to whitelist using spec files has been removed. Whitelisting is no longer enabled by default.
+ The flags that are used to include gems and projects in a whitelist have been removed.

**Cloud Canvas**
+ The Resource Manager now validates input data as you type.
+ The Resource Manager now attempts to remove all content from S3 buckets before they are deleted by a stack update operation.
+ The following commands now have a `--confirm-resource-deletion` option:
  + `update-project-stack`
  + `delete-project-stack`
  + `upload-resources`

**Components**
+ The **Light** component is now separated into four components to allow for more granular control: **Point Light**, **Area Light**, **Projector Light**, and **Environment Probe**.
+ The **Environment Probe** component now includes settings for box projection and attenuation fallout.

**FBX Settings**
+ Numerous improvements to the user interface and workflows include:
  + Support for a recent files list in the tool.
  + Validation for certain text fields.
  + Automatic scroll to the newest group or rule that has been added.
  + A browser that remembers the last browsed path.
  + A confirmation if a user action results in lost changes.
  + A **Reset All** button that returns **Manifest** to the default state.
  + An **Enable Update** button that is available only if there are changed settings.
+ When an `.fbx` file is imported, its asset processor jobs are moved to the top of the job queue.
+ `SceneGraphChildIterator` has been added, which iterates through a node's children.
+ The presentation of error logging has been improved.

**Flow Graph**
+ When you launch the Flow Graph editor, you will now see a dialog that introduces Lumberyard's new visual scripting solution that integrates with the new Component Entity system. We encourage you to use Lua for your scripting needs. For information, see [Lua Scripting](https://docs.aws.amazon.com/lumberyard/latest/userguide/lua-scripting-intro.html).
+ The Flow Graph node `ColorGradient` has been added to CryAction.

**Geppetto**
+ You can now use Geppetto to edit the following information that appears in the skeleton-related `.chrparams` file:
  + Skeleton bones used for defining the bounding box
  + Bounding box extension settings
  + LOD skeleton bone inclusion lists
  + Six IK definitions sections

  This simplifies the process by removing the need for you to manually edit the `.chrparams` file, know the file information, and look up joint names for the skeleton.
+ The performance of the **Live Reload** feature for `.anm`, `.chr`, and `.skin` files has been improved by up to 50%.

**Lua Editor**
+ You can now customize color, font, and syntax highlighting.
+ The debugging status is now more explicitly displayed.
+ The Classes Reference now truncates strings from the right.
+ You can now use the following keyboard shortcuts:
  + Press **Tab** when text is selected to block indent.
  + Press **Shift\+Tab** (with or without text selected) to unindent the text.
+ Previously opened documents are now restored when the editor opens.
+ Read-only files now display a non-blinking cursor to indicate text input.

**Lumberyard Editor**
+ If an object is hit, the object pointer is now cleared. This behavior is similar to if a collision is closer than a previous collision.
+ The following components have updated icons:
  + Tag
  + Net Binding
  + Character Physics
  + Physics Constraint
  + Ragdoll
  + Primitive Collider
  + Behavior Tree
  + Navigation
+ The XYZ axes are now colorized in the property grid for transform component fields.
+ The visualization of entities has been improved in the viewport while in Spacebar helper mode.
+ The Illum shader now has a **Dissolve** functionality.

**Lumberyard Setup Assistant**
+ If available, cached zip files from previous downloads are now used.
+ If available, cached file list information for third-party SDKs are now used.
+ The Lumberyard Setup Assistant, Project Configurator, and `lmbr.exe` are now located in the `\dev\tools\LmbrSetup` directory.
+ The Lumberyard Setup Assistant now handles empty or missing manifests when attempting to download the SDKs.
+ The Lumberyard Setup Assistant better handles override URLs with or without trailing slashes.
+ The Lumberyard Setup Assistant does not reuse content from the cached file list for other Lumberyard versions. This prevents a new Lumberyard installation that reuses an older `3rdParty` folder from using the content from the incorrect Lumberyard version.
+ The Project Configurator now tracks the capabilities you selected and prevents you from attempting a task that you are not set up to complete. For example, you will not be able to create a project until you are set up to compile code.
+ SSL validation has been improved to reject more ciphers that are not trustworthy.
+ Linux libraries are now downloaded separately for Windows users who are setting up Linux.

**Metastream Gem**
+ The console variables `metastream_serverPort` and `metastream_docroot` have been deprecated. You can use the new console variable `metastream_serverOptions` to configure local HTTP server options.
+ The console variable `metastream_enabled` is now read-only and represents the state of the local HTTP server. 0 = disabled \| 1 = enabled.
+ You can now control the local HTTP server using the following:
  + Console commands `metastream_start` and `metastream_stop`
  + In C\+\+, the `MetastreamRequestBus`
+ You can now better manage the data that is added to the Metastream cache. For information, see [Metastream Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-metastream.html).
+ The C\+\+ API now formats your data into JSON strings. Previously you were required to manually format your data.

**Mobile**
+ Android: 
  + You can now add user-generated `.pak` files, such as the shader `.pak` file, to an APK build. This allows you to create games that are fully shippable.
  + You will now see additional logging for GPUs during startup. This can help you diagnose why a specific device is unable to run a build.

**Navigation Component**
+ The **Navigation** component can now physically move physics entities. Supported setups for physics-based movement include:
  + Character physics with a skinned mesh
  + Rigid body physics with a skinned mesh and a shape \+ primitive collider combination
  + Static mesh with a mesh collider

  All entities can still be moved non-physically.
+ Support for path following has been improved.
+ Outdated unit tests have been removed from the `\dev\Code\Engine\LmbrCentral\source\Ai\NavigationComponentTest.cpp` directory.

**Networking**
+ The GameLift integration now uses the AWS Native SDK 1.0.24.
+ The IP addresses and session IDs for clients in a GameLift session are not disclosed for added security.
+ The dedicated server now supports a Linux build to allow for spinning up Linux servers rather than Windows servers. This option can be cheaper and more stable.
+ The ability to normalize data to a specified budget has been added to the Network Profiler main display. By default this is enabled for the Replica Profiler with the old preset value.
+ The Network Profiler now displays usage in an area chart instead of a line graph to increase ease of readability.
+ A new API allows for asynchronous authentication of players on new connections.
+ DTLS cookies are now used during the DTLS handshake to help mitigate IP spoofing attempts.
+ Rate limiters have been added for the number of incoming packets per connection to help prevent DoS attacks.
+ The online services have been refactored so that each OS has its own feature bus and is not limited by least-common-denominator APIs. The LAN online service has been removed because it is no longer needed.
+ The following changes apply to FileDataSource certificate management:
  + Certificates are now expected to be included with game assets in a folder called Certificates.
  + PEM files are now copied by the asset processor. For example, `GameProjectName/certificates/selfsigned.cert.pem` and `GameProjectName/certificates/selfsigned.key.pem`

**Perforce Source Control**
+ To improve the overall user experience with source control operations and Lumberyard, the following updates have been made:
  + Added SSL support to the Perforce plugin and component.
  + Unified settings between the Perforce plugin and component.
  + Added support for specifying character set in the Perforce connection settings window.

**Ragdoll**
+ Ragdoll now supports `PhysicsComponentRequestBus` messages for `AddImpulse` and `SetVelocity`.

**Scripting**
+ You can now destroy entity hierarchies by using the `DestroyGameEntityAndDescendants` method on the `GameEntityContextRequestBus`.
+ The `DestroyGameEntity(AZ::Entity*)` method has been deleted from the `GameEntityContextRequestBus`. You must now use IDs for entity deletions.
+ The **Character Physics** component now supports `GetVelocity`, `AddImpulse`, and `GetMass` through the `PhysicsRequestBus`.
+ The `EntityLookAt` script has been added to allow one entity to face another.

**Slices**
+ Descendants are now automatically included when duplicating, deleting, and pushing entities to slices.
+ Support for pushing entity additions and deletions to existing slices has been improved.
+ Transform management in slices has been simplified, improving robustness and data maintenance.
+ World-space rotation can now be pushed back to slice root entity.
+ The dynamic slice compiler no longer constructs empty containers for assets that do not need to load.
+ The slice compiler now loads gems without creating their system components.

**Twitch ChatPlay**
+ Twitch ChatPlay now supports connecting to the Twitch IRC over websockets.
+ New console variables have been added that allow you to configure how Twitch ChatPlay connects to the Twitch IRC:
  + `chatplay_IRCPorts`
  + `chatplay_IRCSSLPorts`
  + `chatplay_WebsocketPorts`
  + `chatplay_WebsocketSSLPorts`

  You can set these new console variables with comma-delimited, `priority:port` pairs.

**UI Editor**
+ New callbacks and listener C\+\+ interfaces have been added for all UI interactive components.

**Virtual Reality**
+ The Oculus SDK has been updated from 1.5 to 1.9, removing unnecessary files.
+ The OpenVR SDK version has been updated from 1.0.0 to 1.0.3.

**Waf Build System**
+ A new third-party library framework was introduced that manages includes, lib paths, and more in a consolidated location for third-party libraries. The definition for each of the libraries can now be determined specific to the supported operating system. Previously the definition was defined in each of the wscript files. This change cleans up the project definitions significantly.
+ The third-party library framework now handles the logic that determines whether to build the static or dynamic version of a third-party dependency. As a result, the `BuildNativeSDKLibraryList` code has been removed.
+ Certain third-party libraries are now pre-built and delivered during the third-party download process. Previously these libraries were built during the normal build process, adding overhead in dependency and update detection for third-party source files and building of the libraries.
+ You are no longer required to specify a project spec when building non-monolithic targets. The project spec is only required when building monolithic projects, specific projects, and for the Visual Studio Solution Generator. You do not need to specify the project spec if you are building in debug or profile on operating systems that do not automatically create monolithic builds, such as win\_x64 and mac. The default behavior is to build all projects that are marked as supported for the target OS and configuration.
+ For more granular control, you can now configure a `skip` keyword per OS. This allows you to skip processing asset types that are not needed for a particular OS. Lumberyard has exclude patterns that skip file extensions.
+ The `autod` keyword for uselibs has been removed because Qt detection is now handled per OS and per configuration. Previously the `autod` keyword was used because Qt detection was handled globally and both debug and release Qt libraries were configured per OS.
+ The `build_in_dedicated` keyword has been removed because the project description now uses the `configurations` keyword to determine the configuration on which to build a project. Previously the `build_in_dedicated` keyword was used to restrict builds to the dedicated OS.

**Miscellaneous**
+ Optimized debugging is now enabled for Microsoft Visual Studio 2013 to help improve debugging capabilities. This option is enabled by default for Visual Studio 2015.
+ Third-party packages have been removed from the Mac and Console packages for consistency with the PC package functionality. Each package is now available as individual zip files.
+ A new property control has been implemented to handle 32-bit unsigned CRC values (8-digit hex). This property control is useful when you import 32-bit hex CRC values from an external source, such as a custom program that is not part of Lumberyard Editor. The handler's name is CRC and can be used on any 32-bit unsigned integer field.
+ `Bin64` is no longer the target `Bin64` folder for Windows.
+ Lumberyard supports both Microsoft Visual Studio 2013 and 2015 compilers. Even if you are on the same Windows host, the binaries will be different. For consistency, the target folder now represents the target operating system for which you are building. As a result, each Visual Studio compiler will be in a different default folder: `Bin64vs2013` and `Bin64vs2015`.
+ Qt has been upgraded to version 5.6.2, which includes required fixes for dock windows.
+ Using Qt style sheets, new styling has been implemented for Lumberyard Editor. This includes updates to the window frames, title bars, and color schemes.
+ A new AzQtComponents library has been added that includes custom Lumberyard widgets. AzQtComponents can be used as a static or shared (dll) library. Other shared widgets will be merged into this library in the future.
+ You can now use the **Convert to Editor** feature to convert Brush and GeomEntity legacy objects to component entities.
+ The DestroySliceByEntityId API has been added to `GameEntityContextRequestBus`. You can use this API to destroy whole slice instances.
+ The `OnSpawnBegin` and `OnSpawnEnd` events have been added to the **Spawner** component's reflected EBus and Lua script API.
+ `TagGlobalNotificationsBus` has been added to enable notifications when an entity's given tag (bus ID) is added or removed.
+ `AddAngularImpulse` has been added to the `PhysicsComponentBus`.
+ World-space rotation can now be pushed back to slice root entity.
+ Input bindings can now be overridden at runtime and saved to the active profile.
+ You can now edit input bindings by clicking the joystick icon in the **Input** component.