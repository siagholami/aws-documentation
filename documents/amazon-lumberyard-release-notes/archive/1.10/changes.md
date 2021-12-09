# Improvements and Changes<a name="lumberyard-v1.10-changes"></a>

Updates to Lumberyard systems and functionality include the following:

**Amazon GameLift**
+ **Improved console UI for fleet capacity scaling** – Update a fleet's scaling settings from the fleet's **Scaling** tab, which features improved visibility and usability.
+ **New metrics added to automatic scaling** – You can now set up scaling policies based on the following metrics: *PercentIdleInstances*, *AvailableGameSessions*, and *PercentAvailableGameSessions*. Depending on your game, percentage metrics can offer greater flexibility and accuracy when managing capacity levels.
+ **Game session packing** – Amazon GameLift has improved its ability to tightly pack game sessions into active server instances, which maximizes the use of server instances that are already hosting game sessions. As a result, the metric *IdleInstances* better reflects the amount of unused capacity, and automatic scaling polices that are tied to resource usage can more effectively respond to player demand.

**Asset Browser**
+ The **Asset Browser** now displays a quantity for the file sizes.
+ The **Asset Browser** includes performance improvements for populating assets.

**Asset Processor**
+ If the **Asset Processor** terminates for any reason while Lumberyard Editor is running, you will now see a prompt to restart the **Asset Processor**.
+ The **Asset Processor** includes performance improvements for the startup process.
+ You will now see the **Asset Processor** main UI and the startup phase before plugins are loaded.
+ Slices and UI slices now emit dependency information. This allows the **Asset Processor** to reprocess the slices if the files they depend on are updated.
+ Gems are now loaded in the **Asset Processor**, making their functionality available to Builder-SDK builders.
+ The overall startup time for the **Asset Processor** has improved because it no longer needs to copy itself and builders or restart.
+ In the **Asset Processor**, the heuristic search for an asset by path has been expanded. Previously the heuristic search applied to in-queue assets only. Now the heuristic search also applies to compiled assets.
+ The **Asset Processor** batch file now uses the asset system communication layer. This allows asset queries, such as source file name resolution, inside builders and the `RC.exe` legacy pipeline.

**Audio**
+ Lumberyard now supports Audiokinetic Wwise version 2016.2.2.6022 or earlier.
+ The CrySoundSystem initialization speed has been improved for faster startup.
+ The **Audio Controls Editor** now has more visible text colors.
+ The audio thread has been ported to `AZStd::thread`.
+ The audio allocators have been ported to `AZ::SystemAllocators`.
+ The header guards have been removed.

**Cloud Canvas**
+ Cloud Gem Portal:
  + The default home page is now the **Cloud Gems** page.
  + The **Pagination** component no longer requires passing in the data model.
  + The following components have been added: **Tooltip**, **Subnav Tab**, and **Search**.
  + Modals can now accept server-side response validation of forms.
  + Modal logic now supports development mode.
  + The **Message of the Day Gem** now supports ante meridiem (AM) and post meridiem (PM).
  + Breadcrumbs are now updated correctly.
  + Browser support has been improved by adding the woff and woff2 fonts.
  + Various UX improvements help to improve iteration times and to increase development speed through reuse.
  + During development, any changes to the HTML URL triggers a hot reload of the typescript.
+ The **Cloud Gem** includes UX improvements to the dynamic content editor.
+ The **Cloud Gem** includes the following performance updates for the leaderboard:
  + Improved rank estimation, including using the most recent score for specified players. This includes unprocessed scores.
  + Improved score processing time.
+ The CloudGemSamples project now uses the new modular gem project structure.

**Code Changes**
+ Material lifetime has been updated in order to address stability issues. As a result, any code or classes that store an `IMaterial*` in C\+\+ are no longer valid. You must convert any code that acquires and stores an `IMaterial*` to `_smart_ptr<IMaterial>`.

**Component Entity System**
+ You can now use the **Simple Animation** component to hold the last keyframe at the end of an animation.

**Documentation**
+ Lumberyard now provides a [Amazon Lumberyard C\+\+ API Reference](https://docs.aws.amazon.com/lumberyard/latest/apireference/), which includes documentation for the base classes of the component entity system. You can use this guide with the [Amazon Lumberyard User Guide](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-system-create-component.html) when you write your own components. The Amazon Lumberyard C\+\+ API Reference is a work in progress and will be expanded to encompass other aspects of Lumberyard.

**FBX Settings**
+ Previously located in the **Tools** menu, the FBX Settings tool can now be opened by right-clicking on an `.fbx` file in the Asset Browser and clicking **Edit Settings**.

**Game Projects**
+ When you create a new game project, the following are automatically created:
  + Game asset folder
  + Game gem – Includes the game-specific code
  + Visual Studio solution file

  Previously a game code folder (located in the `\Code` directory) was created for the game module.

**Gems**
+ You can now use the following command to create a gem that contains only assets: `lmbr.exe gems create gemName -asset-only`
+ The SceneAPI now supports gems. You can use new **Behavior**, **Exporting**, and **Loading** components to customize how `.fbx` files are loaded and processed.

**Geppetto**
+ The following menu options have been removed because they are no longer valid: **Resave AnimSettings** and **Clean Compiled Animations**.
+ Resetting a character now resets both the position and the orientation of the character.
+ You can now select an animation and set it to start at frame 0 but not automatically play.
+ The controls for the viewport camera now operate the same way as Maya camera controls.

**Lumberyard Editor**
+ When you click **File**, **Project Settings**, **Configure Gems** or **Switch Project**, the messaging that displays has improved to be more descriptive.
+ Parallax occlusion mapping (POM) now affects emittance and emissive intensity. POM also takes into consideration texture oscillation. For more information, see [Parallax Mapping](https://docs.aws.amazon.com/lumberyard/latest/userguide/mat-maps-parallax-intro.html).  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-parallax-example.gif)
+ When you launch the editor, a **Welcome to Lumberyard** window appears. This welcome window has been updated to include highlights of what's new in this version of Lumberyard. You can also access links to tutorials and help documentation, and create a new project or open an existing project.

**Lumberyard Setup Assistant**
+ The default IDE is now Visual Studio 2015. Previously the default was Visual Studio 2013.
+ When Visual Studio 2015 is selected, the Lumberyard Setup Assistant verifies that the MBCS MFC Library for Visual Studio 2015 is installed.
+ In the `default_settings.json` file, `msvs_version` is now set to 14.
+ The installer launch button now says **Launch Lumberyard Setup Assistant**.
+ The installer no longer includes a **Close** button on the **Summary** page.
+ The `3rdParty` directory path now allows a longer maximum path length.
+ AGS library files are now in a versioned folder.
+ The capability modules now read category information from the capabilities.

**macOS Support**
+ You can now display CPU profiling data on devices.
+ You can use the Metal driver to ensure that GPU particles work properly.

**Mannequin (Legacy)**
+ Parsing files in the animation database is now more tolerant of corrupted data or an invalid structure.
+ IAction-derived classes are now informed when the installation is canceled.
+ The responsiveness of the action controller has been improved.
+ You can now install proc clips on enter instead of during the first update.
+ You can now change fragments by action during the action installation process.
+ Thanks to customer feedback, we're making dramatic improvements to Lumberyard's animation tools and systems. Future releases will supplant Mannequin with new, easier-to-use tools designed to enable animators to more easily create high-fidelity characters with less engineering support. However, we will continue to support customers using Mannequin for their current games.

**Material Editor**
+ Certain shaders no longer have the shader generation option for the **Environment** field.
+ The UI has been updated to use the Lumberyard asset browser and property grid. This improves editor performance for projects that have a large number of materials.
+ The asset browser reflects how assets are organized on disk. Because submaterials are subsections of a parent multi-material file and not project files, they are no longer included in the material browser hierarchy. You can still select submaterials in the material preview pane. When you right-click a submaterial swatch, the context menu now includes functionality that was previously only accessible from the material browser hierarchy.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/MaterialBrowser.JPG)

**Mobile Support**
+ You can now display CPU profiling data on devices.
+ Android:
  + Android NDK revision 12 is now the minimum supported version.
  + The build settings for GCC and Clang have been consolidated, reducing the work required to update the compiler settings.
  + Java files are no longer compiled each time a build is created. On some machines you may notice a speed increase of two minutes.
  + The JNI helpers are now in a new namespace called JNI. This helps to alleviate confusion between Lumberyard and Android NDK code.
  + You can now independently set the API level for Native and Java code. This allows greater control over device compatibility.
  + You can now set the Android Java SDK and Android build tools versions in `_WAF_\android\android_settings.json` to 'latest'. This tells the build system to automatically detect and use the latest version on your machine.
  + When creating a capture, you can now use profile markers that allow Android's tool called systrace to display Lumberyard's graphic work. You can enable the tool by adding the `#define ANDROID_TRACE_ENABLED`.
  + GPU particles now work properly on Android devices that support compute shaders.
  + Lumberyard automatically detects if a device supports OpenGL 3.0 or 3.1. You no longer need to set the compile time flags for either version.
  + Motion blur is now supported.
+ iOS:
  + Apps are now 8-10% smaller due to added support for dead code stripping in the build settings. If you use Xcode 8.3, we recommend upgrading to 8.3.1 or newer. Earlier versions of Xcode can overinflate the application bundle.
  + GPU particles now work properly on iOS devices.

**Networking**
+ GridMate now supports TCP protocols so you can open a TCP connection.
+ The read and write buffers in GridMate now support bitpacking to reduce network traffic.
+ Optional UDP congestion control provides extra stability in case of overloaded network traffic.
+ Replica update generation now supports optional back-pressure for improved handling of network congestion.
+ `MultiplayerGem: MultiplayerLobbyComponent` is now exposed to scripting, which allows Lua scripters to start networking sessions.
+ `MultiplayerGem: MultiplayerEvents` is now exposed to scripting, which allows Lua scripters to listen to network events.
+ `MultiplayerGem: GridSession` is now exposed to scripting, which allows Lua scripters to set up network session discovery on the LAN.
+ You can now network sync any custom class that is reflected into the behavior context from Lua.
+ Net binding support has been added for Lua tables for limited key types, such as strings, numbers, and entityID.
+ Net binding support has been added for custom classes in Lua.
+ Lumberyard now uses OpenSSL 1.0.2k.
+ The handshake behavior for Client Hello and Hello Verify are now implemented per RFC-6347.
+ An EBus interface has been added that allows transferring of entity network authority.
+ A network optimization for datasets with default constructor values has been added.
+ A compile switch has been added to prevent sending the debug replica name. This helps to reduce bandwidth usage in release builds.
+ GridHub now provides disconnect timeout configuration to prevent disconnection while profiling.
+ 64 replica chunks per replica is now allowed. Previously 32 replica chunks per replica was allowed.
+ The network profiling bus now includes a replica chunk index. This allows you to more easily identify similar chunk types on the same component.
+ MultiplayerSample entities now use `SimpleTransformNetSync` in order to support interpolation.
+ Nullptr handling in the MultiplayerSample user interface has been improved.
+ Various updates include improvements to the network profiler and Linux dedicated server build scripts.

**Particle Editor**
+ Visual effects artists can modify the lighting contribution from environment probes on each CPU emitter. You can modify the **Environment Probe Lighting** attribute that is located in the **Lighting Attributes** section. The default value is 0 for all emitters. Lumberyard 1.10 provides a `particle_env_light_updated.py` script that you can use to batch set the default value on all of your checked out particle libraries. For instructions and the script, go [here](https://dvbcuh49skxb5.cloudfront.net/releases/1.10/particle_env_light_updater.py).
+ When you set an emitter to attract to an external target, you can select a target entity on the particle component. The target entity is what the affect will attract to.

**Particles Sample Level**
+ The Particles Sample level has been removed. For particle reference, you can use the Particles Technical Sample level (located in the `\dev\SamplesProject\Levels\Samples` directory).

**Project Configurator**
+ If Lumberyard Editor is open, you cannot create a project using the Project Configurator. To create a project, close the editor and reopen the Project Configurator.
+ You will now receive an error message if you attempt to create a new project and the `ProjectTemplates` directory is missing.
+ **Enable Gems** and **Advanced Settings** are now underlined when you hover over the links.

**Resource Compiler**
+ The Resource Compiler no longer includes CryPerforce. You can use the new **Source Control** components instead.
+ Slice and UI slice builders have been migrated from the Resource Compiler builders to the AssetBuilderSDK builders.

**Scene Settings**
+ The drop-down list is disabled if the only available option is **Disabled**.
+ You can now undock certain panes in the **Scene Settings** window into their own windows.
+ The title bar now displays the file name of the loaded `.fbx` file.
+ The **Scene Settings** window includes improved messaging for tooltips.
+ **Rules** is now called **Modifiers**.
+ The **FBX Importer** is now called **FBX/Scene Settings**. You can now edit `.fbx` settings by right-clicking an `.fbx` file in the **Asset Browser** and selecting **Edit Settings**.

**Scripting**
+ LmbrCentral has been converted from an AZ module to a gem.
+ The AZFramework Input system is now enabled by default. For more information, see [Input in Amazon Lumberyard](https://docs.aws.amazon.com/lumberyard/latest/userguide/controllers-azframework-input.html).
+ You can now expand the Lua property tables of dynamic types (for example, EntityId) for the **Script** component.
+ `AZ::IO Print` with explicit `va_list` has been renamed to `PrintV` to resolve ambiguity issues. If you use the `AZ::IO Print` function and pass a `va_list` argument, you must now use `PrintV`.
+ The behavior context methods now support argument names. This allows you to use custom names for scripting.
+ `AZStd::any` can now be serialized.
+ You can now serialize templated generic types and store their specialized type ID as part of the object stream.
+ String operations have been reflected to the behavior context. This includes `find`, `substring`, `replace`, `replacebyindex`, `add`, `trimleft`, `trimright`, `tolower`, `toupper`, `join`, and `split`.

**Slices**
+ When creating a slice in a level, all references to entities in that slice are now updated to maintain their reference. Previously, creating a slice would result in broken entity references.
+ The **Push to Slice** tool now displays entity additions and removals according to their transform hierarchy. The **Push to Slice** tool also prevents transactions that break the direct transform hierarchy of these entities.
+ When you create a component entity as a child of another entity, the **Entity Outliner** hierarchy now expands to display the new entity.
+ The **Entity Outliner** performance is now optimized when handling many entities and large slices.
+ A `SliceTransaction` class has been added to manage slice creation and push operations. You can use this customizable API for operations that separate generic and special cases of slice creation and push.
+ Slice-related source code has been renamed as follows:
  + `Prefab` is now called `Slice`.
  + `PrefabAsset` is now called `SliceAsset`.
  + `PrefabReference` is now called `SliceReference`.
  + `PrefabInstance` is now called `SliceInstance`.
+ You can no longer include new component entity objects in legacy prefabs.
+ The functions in the `EntityUtils.h` file have been moved from the `AZ::Utils` namespace to `AZ::EntityUtils`.
+ The **Detach slice entity** context menu action now affects all transform hierarchy descendants.
+ `EntityContext::m_instantiatingSlices` is now called `m_queuedSliceInstantations`. This prevents any naming confusion with derived class member variables.
+ Performance has been improved for saving a slice file (creating and pushing to a slice).

**Starter Game Action Update**
+ The Action Update for Starter Game introduces the following improvements and changes:
  + Improved character response and state transitions
  + Revised naming and project organization that better reflects best practices
  + Components (brushes, entities, particles, etc.) for legacy assets
  + Impact physics and visual feedback for the secondary weapon
  + Environment improvements that use the new player actions and mission scripting

**Stereo Settings**
+ The legacy stereo settings in the **Rollup Bar** have been removed. Stereo rendering for 3D televisions is not supported and these settings were removed to avoid confusion. For VR-specific stereo settings, see [Virtual Reality](https://docs.aws.amazon.com/lumberyard/latest/userguide/virtual-reality.html).

**Track View**
+ The **Track View** editor now supports the ability to animate **Environment Probe Light** components.

**Twitch and Twitch ChatPlay**
+ Twitch has added reflection to the behavior context for Lua.
+ Twitch ChatPlay has added reflection to the behavior context for Lua.
+ To help locate duplicate objects, the behavior context now includes the Uuid in the "Class xxxx is already registered" message.

**UI Editor**
+ The UI sample levels in `SamplesProject` have been updated to use Lua and not the Flow Graph editor.
+ A new level called `UiFeatures` replaces the UI levels that were previously in the `FeatureTests` project. You can use the **LyShineExamples Gem** to access UI canvases, slices, and scripts for the `UiFeatures` level.
+ The default text slice in the **UiBasics Gem** now uses a `.fontfamily`, which allows text markup to work with it.

**Virtual Reality**
+ All virtual reality project samples now have `e_CheckOcclusion` enabled by default. This resolves an issue that occurred when occluding geometry was too close to the camera.
+ Teleport indicators in instantVR slices have been updated to provide better visualization when the ground isn't visible. This allows particles to move as expected when an entity is spawned from a dynamic slice that contains those particles.
+ You no longer need to hold the right mouse button in order to move the view for `hmd_debug_camera`.

**Miscellaneous**
+ System initialization parameters for the root and asset paths have been cleaned up for ease of use.
+ Define `AZ_DEBUG_BUILD`, which controls the ability to debug code, is now applied only to builds in non-optimized ("debug") mode. This can result in performance increases for profile builds.
+ Define `AZ_ENABLE_TRACING` is now applied to debug and profile builds, but not release builds. This can emit trace information in profile builds. Previously this information was absent.