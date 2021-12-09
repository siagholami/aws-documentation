# Improvements and Changes<a name="lumberyard-v1.9-changes"></a>

Updates to Lumberyard systems and functionality include:

**Amazon GameLift**
+ If you use queues with player latency data to place new game sessions in the best available region, you can now add player latency policies. Without player latency policies, Amazon GameLift places game sessions in regions with the lowest average latency reported by all players. A player latency policy sets a cap on latency allowed for any individual player, regardless of the group average.

**Asset Browser**
+ Various updates to the **Asset Browser** include an improved user experience, ability to preview your selection, improved search, and icons for each component.
+ The **Asset Browser** replaces the legacy **File Browser**.

**Asset Builder**
+ You can now use the BuilderSDK API to declare dependencies for a source file on other files. These other files are not required to be source files that are consumed by a builder. You can use any file within the project folders.

**Audio**
+ The `IAudioSystem` and `IAudioSystemImplementation` interfaces now use EBus.
  + The audio manager request type `SET_AUDIO_IMPL` has been removed.
  + The audio manager request types `INIT_AUDIO_IMPL` and `RELEASE_AUDIO_IMPL` have been added.
  + If normal initialization fails, a `NULL` audio system is used as a fallback. This may happen if you are running a dedicated server.
  + The `AudioSystemImplementation` pointer has been removed from **Audio Translation Layer** (ATL) managers.
  + The `IAudioSystemImplementation` interface includes the following updates:
    + `Init` is now called `Initialize`.
    + `OnLoseFocus` is now called `OnAudioSystemLoseFocus`.
    + `OnGetFocus` is now called `OnAudioSystemGetFocus`.
    + `MuteAll` is now called `OnAudioSystemMuteAll`.
    + `UnmuteAll` is now called `OnAudioSystemUnmuteAll`.
    + The two versions of `RegisterAudioObject` are now consolidated into a single version.
    + `AudioSystemImplementationComponent` replaces the `IAudioSystemImplementation` interface. `AudioSystemImplementationComponent` handles two EBus interfaces: `AudioSystemImplementationNotifications` and `AudioSystemImplementationRequests`.
    + All calls to the `IAudioSystemImplementation` interface are now converted to EBus calls.
  + The `IAudioSystem` interface includes the following updates:
    + The `gEnv pAudioSystem` now points to a deprecated object and will be removed in a future release. If legacy code calls functions on this pointer, you will receive a warning to switch to the EBus calling convention.
    + `GetAudioTriggerID` now returns the ID instead of a boolean. The ID reference is no longer an argument.
    + `GetAudioControlName` is now called `GetAudioSwitchStateName`. The first parameter has been removed.
    + Blocking requests are now routed to `PushRequestBlocking` instead of `PushRequest`. The code asserts if the `eARF_EXECUTE_BLOCKING` flag is set in the request. The request does not use `PushRequestBlocking`.
    + Requests that are initiated from a non-main thread (for example, all thread-safe requests) are now routed to `PushRequestThreadSafe` instead of `PushRequest`. The code asserts if the `eARF_THREAD_SAFE_PUSH` flag is set in the request. The request does not use `PushRequestThreadSafe`.
    + `Release` replaces `ShutDown` in `CAudioSystem`.
+ The **Audio System Implementation** module now has a refactored initialization and release.
+ The **Audio System** module now has a refactored initialization and release.
+ The internal processing of audio requests to the audio system has been refactored.
+ The use of AzCore in the audio modules has been improved.
+ Audio functionality has been updated on the following legacy entities: **RigidBodyLight**, **DestroyableLight**, and **DestroyableObject**.
+ You can now reset RTPCs to the default values and clear RTPCs from an audio proxy.
+ In **Mannequin**, the audio proc layers now default the `StopTrigger` to `do_nothing`.
+ The ATL XML tag and attribute names are now consolidated to a single definition.
+ Audio is now enabled in the BeachCity\_NightTime level.
+ The **Audio Controls Editor** (ACE) includes the following updates:
  + The Visual Studio filter **EditorAudioControlsEditor** is now called **AudioControlsEditor**.
  + ACE common files are no longer included in the implementation projects (for example, Editor Wwise).
  + You can now press **Esc** or click the empty area in the ATL controls pane in order to clear the current selection. This allows you to create root-level folders more easily.

**Character and Animation**
+ The animation runtime is now tolerant of skeletons with non-identity root bones. This applies to skeletons imported using the **FBX Settings** or exported from Max or Maya.
+ Live reloading of `.chrparams` files is now supported on consoles.
+ You can now place and use `i_caf` and `.animsettings` files in gems.
+ PRow attachments now support the **World Space Damping** parameter. This allows you to control, per 3D axis, how much of the character's world space motion affects the simulation. For example, you can tune loose attachments—such as hair or strips of cloth—to reduce how far they trail behind a fast-moving character. You can configure the **World Space Damping** parameter in the PRow attachments configuration UI in **Geppetto**.

**Cinematics**
+ To help with visibility and troubleshooting, several significant **Track View** editor error and warning messages now display in a dialog box. Previously these error and warning messages appeared in the console window.
+ Autorecording is now supported for use with component entities.
+ Component entities now have viewport track gizmos for rotation and position.
+ Component entities now support position and rotation offsets when you use the move or rotation modes and recording is disabled.
+ You can no longer add folders (group nodes) as children of component entity nodes.
+ **FrustumHeight** and **FrustumWidth Track** are no longer supported and have been removed from the component cameras.
+ Component entities are no longer compatible with the legacy layering system. They are now merged to the main layer when loading a level.
+ The **Add New Sequence** dialog box no longer includes the option to create a new layer.

**Cloud Canvas**
+ In order to support SSL on the AWS Native SDK's HTTP Client on Android (cURL), we now automatically copy a certificate bundle to user storage on startup and set the AWS Native SDK to use it. If you need to enable HTTPS endpoints in your game project, you can use the certificate file that is included with the CloudGemSamples level as a template. The certificate should reside in the `<GameFolder>/certs/aws/cacert.pem` directory. This feature is enabled on Android by default. You can configure the feature using `CloudCanvasCommonSystemComponent::DoesPlatformUseRootCAFile()`.
+ The **Dynamic Content Manager** includes the following updates:
  + General improvements to the UI for OS support, Cloud Canvas error statistics, and general user experience issues
  + Ability to assign an operating system to files in the file watcher and to `PAK` files, allowing the files to target specific operating systems such as Windows, Mac, iOS, or Android
+ The **Cloud Gem Portal** includes the following updates:
  + **Player Account Cloud Gem** plugin
  + Improvements to the user experience
  + Improvements to the **Cloud Gem** development iteration time
  + Pagination for the **Message of the Day** plugin
  + Pagination for the **Leaderboard** plugin
+ Cloud Canvas now supports the AWS native SDK version 1.0.74.
+ Lumberyard includes Python version 2.7.12.

**Component Entity System**
+ When you hover over an entity, a green bounding box now appears around the entity.
+ When you select an entity, it is highlighted in red. All of its transform children are highlighted in orange.

**FBX Settings**
+ The **FBX Settings** now supports z-up axis and y-up axis world coordinate systems.
+ You can now access the **FBX Settings** window from the **Asset Browser**. To do so, right-click the file and select **Edit Import Settings**.
+ Hard coded joint orientation requirements are no longer required.
+ Default and bone group compression settings are now exposed in the FBX import settings.

**Gems**
+ Gems now have an optional Lumberyard version constraint that allows them to be dependent on engine versions. This will not prevent you from adding gems to your project if the gem has a version dependency that differs from your installed engine version.

**Lumberyard Editor**
+ The editor docking system includes the following updates:
  + An improved title bar style for arranging floating windows
  + Ability to reorder tabbed panes
  + An improved context menu for docked or tabbed panes that includes options to undock groups of panes or close specific tabs
  + Inability for windows to go missing
+ If the **AI/Physics** mode is enabled, you can no longer save the level. This prevents the editor from experiencing any issues. 
+ The **Decal** map is now the **Emittance Multiplier**, and the **Detail Decal** option has been removed. This better reflects the proper usage of the map.
+ The **Trail Fading** textures have been removed from the **Trail Emitter** type.

**Lumberyard Setup Assistant**
+ After installing Lumberyard, you can now access the editor in a single step by running the **Lumberyard Setup Assistant**.
+ The verification functionality now determines if the C\+\+ compiler is installed in the Visual Studio 2015 folder.
+ The Lumberyard Setup Assistant batch file now displays a warning if you have not set any compilers and you have chosen compile capabilities.
+ The path length for the `3rdParty` folder has decreased from 54 characters to 44.

**macOS Support**
+ If you want to use the Metal renderer, you must update the `system_osx_pc.cfg` file to set `sys_spec` to **11**.
+ `Lmbr` and `Lyzard` are now available in the `dev/LmbrSetup/Mac` directory.

**Mannequin**
+ You can now drag and drop a fragment from the **Fragments** tab to the track pane in the **Previewer**.
+ You can now drag and drop an animation from **Geppetto** to an animation layer on the timeline.

**Mobile Support**
+ Creating release builds is now multi-OS, so you can use a PC or Mac to generate a release build and the required `PAK` files for an app bundle.
+ Android:
  + Organizational improvements allow you to more easily navigate and look for Java code in `com.amazon.lumberyard` packages.
  + The AWS SDK now works properly.
  + The Android NDK, Revision 14 is now supported.
+ iOS:
  + GPU particles are now supported.

**Project Configurator**
+ To support intuitive functionality, buttons and clickable text now have a hover effect.
+ The **Project Configurator** now creates a log file that is relative to the executable position in the `.exe/log/ProjectConfigurator-timedate.log` directory.

**Slices**
+ Slice creation is now easier\! To create a slice from an entity, you must have one entity that is the transform root. You can create a slice with entities that share a common root. If the common root is not part of the slice or is null, you can optionally create a common root entity that will be used as the root of all entities in that slice.
+ Vertex snapping now works with component entities.
+ You can use the **Primitive Collider** components to specify a physical surface type.
+ You can use the **Editor** components to specify match criteria. This criteria is used to determine which components can be edited as a group when multiple entities are selected. For example, **Script** components only match and can be edited as a group if they point to the same script asset.
+ The **Entity Outliner** has a new appearance and added functionality.
+ Dotted outlines are now used to show the parents of selected entities that are hidden by collapsed hierarchies.
+ The root of slices and cascaded slices are displayed with dark backgrounds in the **Entity Outliner**. This allows you to easily see which entities are inherited from base slices.
+ You can now lock and unlock component entities in the editor. Use the **Entity Outliner** lock icons or the **Edit** menu to lock component entities, making them unselectable in the render viewport and the outliner. Locking entities is useful for "working set" organization and to prevent accidental manipulation of component entities that you're not currently working on.
+ You can now detach component entities from their slices. Use the context menu in the **Entity Outliner** or render viewport to select from two new options: **Detach slice entities** or **Detach slice instances**. Detaching slice entities only detaches the selected component entities. Detaching slice instances detaches all component entities from any slices you have partially or fully selected. Detaching a component entity from its slice severs the link between the entity and the slice. Any future updates to the slice will not propagate to the entity. The detach functionality results in the same behavior as if you copy and pasted an entity, updated all references to that entity with the new version, and deleted the slice instance. The component entity remains unchanged and is no longer linked to the slice. The detach functionality is useful for preventing unwanted future updates, "freezing" an entity with its current configuration, and creating a new slice from detached entities so that the slice stands alone and isn't influenced by other changes.
+ The **Push to Slice** dialog box now has more accurate and descriptive warnings, status messages, and instructions. This is useful if the push-to-slice action cannot complete successfully, for example if the slice asset is read-only on your system.
+ Component icons now draw on top of meshes in the editor render viewport. Previously the component icons intersected the meshes.
+ To help with selection accuracy, component icons are now prioritized over meshes when you attempt to select them in the editor render viewport.
+ Component icons are now aware of parent/self/child selection state so that they don't draw over one another when placed at the same location.
+ For more control over texture drawing, the `EntityDebugDisplayBus::DrawTextureLabel` function now has texture icon display flags.
+ The **Entity Inspector** now organizes components into a stack of component editor card widgets. Each card has a header bar and a property editor that reflects the state and editable parameters for a specific component.
+ If multiple entities are selected, the inspector will only show cards for the common components with similar properties. Any changes to properties will be applied to that component and the counterparts on all selected entities.
+ The component editor header bar now displays contextual information about the component, a button for expanding or collapsing the property editor and notifications, indicator icons if there are warnings related to the component, and a button for displaying a context menu. You can double-click the header to toggle expansion.
+ You can click to select individual component editors. When selected, the header background is highlighted and all user actions in the inspector are based on the selection. Only single selection is supported.
+ You can now reorder (move up or down) components in the inspector. This does not apply to the **Transform** component. To reorder a component, ensure only one entity is selected.
+ The inspector context menu now displays all available user actions, with certain actions disabled based on context. The user actions include: **Add Component**, **Delete Component**, **Cut Component**, **Copy Component**, **Paste Component**, **Move Component Up**, and **Move Component Down**. You can activate the context menu by right-clicking a component editor or left-clicking the menu button in the header.
+ In the inspector, the **Add Component** button has a new mechanism for adding components. When you click **Add Component**, a searchable tree control displays that contains an ordered list of components that you can add. The components are grouped by categories. You can also use the search box to remove categories and display a sorted list of components that match the filter. Highlight items to display a tool tip with a description of the component. Click a component name to add it to the selected entity.
+ The inspector now scrolls to display newly created or pasted components.
+ Component editors now display warning indicators and messages when there are incompatibilities between components or if there is a missing dependency. Notifications appear at the bottom of each affected component editor. For duplicate or incompatible components, the notification provides an option to remove the component. If a component requires another one to function, the notification provides a list of possible components to add.
+ You can now add components that do not yet have their requirements met or are incompatible with existing components on an entity. These components will be disabled until the required components are added and they are no longer incompatible with other components on the entity. This new workflow allows you to add components before required component, for example adding the **Trigger Area** component before adding a **Shape** component.
+ You can now remove from entities the components that are required for other components. This will disable the remaining components that are missing required services. To re-enable the components, add a component that provides the missing services. This new workflow allows you to remove components that provide services without removing the dependent components and losing the properties. For example, removing a **Shape** component will disable a **Trigger Area** component until a new **Shape** component is added.
+ You can now cut, copy, and paste components within entities and between entities. This new workflow disables incompatible components. This does not apply to the **Transform** component.
+ A MultHandlers script has been added to make it easier in Lua to handle multiple connections to the same bus with different bus IDs for any bus type. Implementations for input and gameplay buses are provided.
+ `CRY_SAVEGAME_FILENAME` is now called `LY_SAVEGAME_FILENAME`. `CRY_SAVEGAME_FILE_EXT` is now called `LY_SAVEGAME_FILE_EXT` and changed from `.csf` to `.sav`.
+ You can no longer move component entities to a layer. Previously you could add component entities to a layer, but the component entities would reset to the base layer upon level reload. A new system will replace this functionality for component entities in a future release.
+ `LoadMaterialAutoRef` and `LoadMaterialUnsafeManualRef` replaces `MatMan::LoadMaterial`. `AutoRef` is thread-safe and returns a `smart_ptr`. `ManualRef` returns a raw pointer without altering the material's reference count and is not safe to use outside the main thread.
+ You must manually add **AudioProxyComponent** to any new entities that use audio components. Existing entities with audio components will already have this component.
+ In the editor render viewport, blue display lines that represent the component entity parent-child relationship now draw for selected entities. This helps to clear non-relevant visual information from the viewport.
+ Only one component icon is displayed per component entity in the editor render viewport.
+ The **Flowgraph** component now follows the same workflows for adding and removing components.
+ You can now use the **Flowgraph** component to change the names of flow graphs.
+ If you have a framework gem enabled but do not have an implementation gem enabled, you will now see the name of the class that needs an implementation when you attempt to add those elements.

**Twitch**
+ A new **ChatPlay Gem** includes Twitch ChatPlay, Twitch JoinIn, and Broadcasting API.
+ The Samples Project now includes the **ChatPlay Gem**.
+ To ensure that the Twitch ChatPlay features in **Flow Graph** continue to work, enable the **ChatPlay Gem** in your game project.
+ Metastream is now reflected to the behavior context in order to support Lua and Script Canvas.
+ The `MetastreamRequestBus` has been extended to support `Az::EntityId`.
+ Metastream has been updated to initialize its data cache earlier.
+ The format for CommunityID, ChannelID, FriendID, and Twitch Application ID can now be verified.
+ Twitch notifications are now sent out properly.
+ The Space Yard demo now includes Twitch Fuel.
+ When using Twitch Fuel, the player name now uses the Twitch ID.
+ `HttpRequestGem` replaces `HttpRequest` for Twitch ChatPlay.
+ CryAction no longer includes Twitch ChatPlay, Twitch JoinIn, Broadcasting, and HttpRequest.
+ **Twitch** and **HttpRequest Gems** have been added that include code from `CryAction::httprequestor` and an EBus interface.
+ The MultiplayerProject now supports Twitch and includes the **HttpRequest Gem**.
+ APIs have been added for Twitch Friends and Rich Presence.

**UI Editor**
+ LyShine is now a gem.
+ The method to register custom UI components now uses the same process as non-UI components.

**Virtual Reality**
+ If you are running the sample project from the launcher, you can now switch between levels by using the number keys 1, 2, 3, and 4.
+ To help increase performance, scene space directional occlusion (SSDO) is now turned off by default for content samples.

**Miscellaneous**
+ Function header comments have been added for `Json::ToEscapedString`.