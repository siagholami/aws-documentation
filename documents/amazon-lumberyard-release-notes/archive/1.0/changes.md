# Improvements and Changes<a name="lumberyard-v1.0-changes"></a>

Updates to Lumberyard systems and functionality include:

**AI System**
+ Added the console variable `ai_NavGenThreadJobs` to allow for control over the number of threads the navigation system can use to process meshes.
+ You can now change the associated entity ID for the observer and observable parameters.
+ TPS debug draw mode now also works with the agent debug target.
+ The movement system can now display the queued movement requests for actors.
+ Added an event log to the behavior tree to show recent event history.

**Audio**
+ Lumberyard's audio implementation now uses Audiokinetic Wwise LTX.
+ You can now position the audio listener between the camera and player character.
+ You can use `s_DrawAudioDebug` for the debug draw audio listener.
+ With the improvements to audio and the **Audio Controls Editor**, you can position the audio listener closer to the player and make audio events report the start of playback.
+ The Audio Controls Browser is now called the **Audio Controls Editor** and includes support for localized soundbanks with the same name as global soundbanks and added default controls.
+ You can now load Wwise controls from subfolders.
+ The SDL Mixer implementation now supports the ability to stop events.

**AZCode Generation**

A code generation preview solution is located in `/Code/Framework/AZCore/Build/CodeGenPreview` and provides the following:
+ You can find templates for generating code for reflection, EBus, serialization, and components.
+ Visual Studio is integrated for preview.
+ You'll find native component versus generated component unit tests in `/CodeGenPreview/AzCoreTests`.

**Character and Animation**
+ **Geppetto**
  + You can preview animations with any frame rate; previously this was limited to animations exported at 30 frames per second.
  + **Geppetto** has been updated to work with the new asset pipeline.
+ Animation system
  + You can now play blend spaces on any animation layer, and blend spaces can now include additive or override animations.
  + Splice animations in blend spaces is no longer supported.
  + The abstract animation event player interface (`IAnimEventPlayer`) plays animation events. The default animation event is `audio_trigger`.
  + The **Reset Character** button resets the character to its original position and stops playing animations.
+ Mannequin
  + The Mannequin system uses a new procedural clip format, and everything is now exposed through the serialization framework. You don't need `Scripts\Mannequin\ProcDefs.xml`; conversion is automatically done using the `Scripts\Mannequin\ProcClipConversion.xml` file.
  + You can now right-click an animation clip to edit the source asset or find all transitions that refer to that clip.
  + You can now filter transitions based on animation names in the **Transitions** browser pane of the **Mannequin Editor**.
  + You can now temporarily disable scopes or individual layers.
  + Copying and pasting sets of fragments is now supported in the **Fragments** browser pane of the **Mannequin Editor**.
  + A new **List Used Animations** tool is available as well as a **Re-export** feature, which loads all mannequin files and attempts to save them.
  + You can use the console variable `mn_override_preview_file` to override the default preview file used by the editor.
  + You can copy and paste layers in clips, fragment IDs, and commands in the **Fragments** browser's context menu.
  + New LuaCallback ProcLayer can receive a string and four floats as parameters.

**Cinematics and **Track View****
+ The contrast of the text in the **Track View Animation** browser has been increased to improve readability when you use the dark skin.
+ Disabling a screen fader on a director node in the **Track View** editor now clears the fader effect.
+ Changes to `.abc` and `.cbc` Alembic files and their compilation parameters are now automatically detected, recompiled, and hot loaded in Lumberyard Editor and games.
+ A new default **GeomCache**-loaded `.cax` file has been added to remove warnings and include materials.
+ The **Edit on Spot** context menu entry for Boolean values has been disabled because there are no parameters to set for a Boolean type. The Boolean type simply toggles the value at the keyframe.
+ Improvements to the UI include adjusting colors for readability in the dark skin theme, renaming **Graph** to **Curve Editor**, and renaming **Dope Sheet** to **Track Timeline**.

**Cloud Canvas**
+ You can now generate default versions of the content in `{game}\AWS Directory` to use for customizing the project or setting up a test scenario.
+ Login with Google and OpenID are now supported Amazon Cognito providers.
+ The project template can now define one or more deployments.
+ You can now designate a deployment as the default deployment.
+ Various updates to the Lambda flow graph include adding a `BaseLambdaFlowGraph` interface, implementing `BaseLambdaFlowNode` into `Math:Add` and `Math:Sub`, adding functions in `BaseLambdaFlowNode` to help with generating the JS code, and adding a new Lambda `ModuleType` and updated references to `ModuleTypes` for Lambda.

**Empty Template**
+ The project templates now use the latest version of the EmptyTemplate projects.
+ The EmptyTemplate project now has the `StdAfx` header file.
+ The stubs for `Actor` and `EmptyTemplateGameRules` have moved to `IGameObjectExtension`.
+ All stubs from `EditorGame` have moved to `IEditorGame`, so that you can optionally override `OnAfterLevelLoad` and `OnBeforeLevelLoad`.
+ The stubs for `GameStartup` have moved to `IGameStartup`.
+ The stubs for `EmptyTemplateGame` have moved to `IGame`, `IGameFrameworkListener`, `ISystemEventListener`, and `ILevelSystemListener`.

****Flow Graph****
+ You can specify a number of frames for the **FrameDelay** flow graph node instead of using the default of `1`. This node configures the number of frames to delay before passing a signal.
+ The changes listed below impact these node classes: **Image**, **Input**, **Interpol**, **Inventory**, **Iterator**, **Logic**, **Material**, **Math**, **Mission**, **Module**, **Movement**, **Multiplayer**, and **Physics**:
  + Node and port names now follow standards to ensure consistency across classes. Each node name includes the node class and the node name (for example, `Entity:SetPosition`). Each port name is an input or output port (for example, **Value** or **Result**).
  + Node name migration is handled automatically at level load time. You can locate this file at `\dev\Engine\Libs\FlowNodes\Substitutions.xml`.
  + Flow graph nodes now use new activation patterns: **Activate**, **Enable/Disable**, and **Automatic**. **Activate** allows you to trigger the node by sending input that updates the output. **Enable/Disable** allows you to activate a node once to repeatedly update itself until instructed to stop. **Automatic** allows you to trigger an output based on inputs available at that time.
  + Node descriptions and tooltips now better reflect their functionality.
+ **Game:Start** and **Game:Stop** nodes now work as expected.
+ Organization in the **Flow Graph** window has been improved to help you more easily find the appropriate category for your flow graph.
+ A new **Group** tool replaces the **Blackbox** tool and allows you to group nodes in a flow graph into a convenient container that can be collapsed and expanded.
+ Added the following nodes:
  + **Environment:SkyMaterialSwitch**
  + **FindEntityByName**
  + **Physics:Constraint**
  + **Physics:CameraProxy**
  + **ActionMapManager**
+ Added the outputs **IsInWater** and **IsHeadUnderWater** for the node **ActorSensor**.
+ Added an input to force updates for the node **Time:RealTime**.
+ Added an input to allow you to choose the entity axis that should point to the target for the node **EntityFaceAt**.
+ You can now execute flow graphs from the command line.
+ Added numerous nodes and functionality to perform feature tests, check results, and log the results to a specific file.
+ Flow graph enums now use **IN\_SOCKET** and **OUT\_SOCKET** instead of **IN** and **OUT**, respectively.

**Gems System and Gems**
+ You can now change boids models without relaunching the editor.
+ You will now see **Misc Distance Clouds** in the **Rollup Bar** only when the Cloud Gem is enabled.
+ Gem-declared entity types are no longer missing flow graph nodes.
+ The Lightning Arc Gem now reflects recent changes to the CryEngine components.
+ AZ modules now use `export_{include | defines}` instead of features.
+ Autogenerated Waf files for gems now include an **auto** section.
+ The autogenerated boilerplate for new gems is now contained in a namespace, which helps with conforming to standards and establishing naming conventions.
+ Failure to load a gem now generates a fatal error instead of a warning.
+ The Movement Gem now has a flow graph node with which you can mock up movement controllers.
+ The AWS Gem is now added to Samples Project.
+ Gem names now have a 64-character limit.
+ The Gems catalog now shows display (friendly) names for the gems.
+ The `gems.json` file now behaves as an opt-out instead of an opt-in.
+ You can now use a flow graph–based controller that uses the player capsule system.

**Levels and Environment**
+ Added a new create dialog so that you can add terrain if it was not created at level creation time.
+ New terrain brush previews show changes to transparency, height, and blurriness.
+ The **Single Flatten** action replaces **Flatten (light)** and **Flatten (heavy)** so you can define the percentage of flattening.

**Lumberyard Editor**
+ New 3D rotation gizmo uses angular representation for the rotation axes.
+ New **Show Last Hidden** action displays the entity that was last hidden during the editing session. Closing or reloading a level clears the list of hide actions. To enable this action, press **Shift\+H** or choose **Edit**, **Show Last Hidden** in the menu bar.
+ Dynamically turn a skin's morph targets on and off.
+ Heightmap Generator includes a new preview panel.
+ Instanced prefab names inherit from the original prefab name (e.g., the first instance of a prefab named "crate" will be named "crate1").
+ Layers in Lumberyard Editor include new source control indicators.
+ 2D viewports are now synced by default.
+ fSize and fAspect are deprecated in the Particle Editor.
+ Smooth Beaches/Coastline functionality has been removed.
+ The **No Skinning** option was removed from the menu, so you can choose from the new light or dark skins.
+ UI improvements include moving the **Open** button for the **Console Variables** dialog box in the **Console** panel, adding dark and light icons to the button, and moving the search box to the top of the **Console Variables** dialog box.
+ If present, toolbar buttons display keyboard mappings (hot keys).
+ Missing PAK files no longer trigger warning messages.
+ Added menu items for AWS and Commerce, so you can easily [sign up for an AWS account](https://aws.amazon.com/) or [publish to Amazon](https://developer.amazon.com/appsandservices/solutions/platforms/mac-pc), respectively.
+ Added tiled-shading support for glass objects, which enables glass to receive direct lighting, shadows, and ambient lighting.
+ Added the ability to approximate light scattering using screen space directional occlusion (SSDO) color bleeding, resulting in balanced ambient occlusion on bright surfaces. You can use this feature by enabling tiled deferred shading and then setting console variable `r_ssdoColorBleeding`.
+ Added minimum and maximum values for elevation and slope in the **Vegetation** panel in Database View.
+ Temporal anti-aliasing now applies projection matrix jittering to produce a more stable image. You can use this feature by enabling console variable `r_AntialiasingMode 3`.
+ The maximum exposure value for distance clouds has been increased in the Material Editor.
+ HDR files are now supported as source images for light probes. Files are automatically converted from longitudinal, latitudinal, and cross maps.
+ Added a **Clear Registry Data** option to the **Tools** menu.
+ Added a scroll bar to the Database View.
+ Added more FOV presets.
+ Added **Edges** display option to render edges on top of a character.
+ Entity scripts and the panel tree browser now automatically refresh when you register new entity classes at runtime.
+ Removed all references to the `.cga` file type. This format is deprecated.

**Lumberyard Launcher**
+ Lumberyard Launcher configuration files are now located in the engine root. During startup, Lumberyard Editor uses this configuration file to determine if Lumberyard Launcher has been previously run.
+ If you are running Lumberyard Editor for the first time and have not yet run Lumberyard Launcher, the launcher will start automatically.
+ Descriptions and instructions have been added for the `zlib` compression library.
+ Blocking operations, such as searching for and reading a file or folder, are now executed on their own threads, resulting in a faster and smoother UI refresh.

****Material Editor****
+ **Diffuse Color** has been renamed **Diffuse Color (Tint)**.
+ The material preview now displays at a higher resolution and with sharper image quality.

**Maya Lumberyard Tools**
+ Instructional text and headings have been added to identify data.
+ The **Auto Add Joints** functionality has been removed from the Physics Mesh tool.
+ You are no longer required to have a group with a `_group` postfix in order to export a single mesh in Maya.
+ Physics materials are identified by including **phys** or **Phys** in the texture name or by setting the attribute `lumberyardPhysMaterial` on the associated material. When you create or update a material group, physics materials will have `ProxyNoDraw` automatically applied if they match the naming standard.
+ The `LumberyardExportNode` is no longer required to be a parent of the geometry it exports. `LumberyardExportNode` now lives under a separate hierarchy and references its export targets.
+ The **Export Validator** help window is no longer shown by default. To display the help window, set the global control `$g_enableValidateHelpWindow` to `true` in the `cryValidate.mel` file.
+ You can now set physicalized options for materials in the Lumberyard tool.
+ The default label was updated from **None** to **No Physics** in the **Physicalized Properties** list.
+ The `cryExportNode` prefix is no longer in the geometry export list displayed in Lumberyard Editor.
+ Backwards compatibility is now available for exporting geometry.
+ You can now export materials using a custom (relative or absolute) path.
+ The **Select** button in the **Geometry** window locates all nodes to be exported and selects them in the scene. If the geometry is in a hierarchy, the top node is selected.
+ A new tool called **Joint Proxy Editor** is now available to automatically create physics meshes for skinned models. You can find this tool within Lumberyard Tool under **Tools**, **Joint Proxy Editor**.
+ Lumberyard now supports Maya 2014.
+ Visual improvements are evident in the workflow, and you will find various improvements to material groups, including naming, feedback, and the creation process.

**Maya Plugin**
+ The plugin can handle export nodes, including `CryExportNodes` that are not at the root.
+ The plugin can handle export nodes that are part of a namespace.
+ The plugin uses proper identification of subfolder exports of skins and geometry.
+ The plugin supports animation layers (**AnimLayers**).
+ You can use the plugin to batch export animations.
+ You can use the plugin to export a skeleton without an extra mesh.

**Networking**
+ Major changes:
  + CryNetwork is no longer included in the code base. You can use GridMate for your networking implementation.
  + Updated the underlying network architecture for CryNetwork and added multiplayer service for online multiplayer game development, providing a reliable UDP layer; session management; and object replication through replicas, data sets, and RPCs.
  + APIs related to matchmaking and other connected services, including CryLobby, are no longer available. Session management is now handled by decoupling the game flow from the network session state, and implementing custom replicas or messaging through direct access to the carrier.
  + The encryption interface is no longer part of `INetwork`. You can access the new API from `CCrySystem::GetCrypto()`.
  + CryAction now controls the `NetworkStallTicker` logic.
  + Action map and local view are now set up as part of the client actor init flow.
  + The following aspects are no longer supported: `eEA_GameClientL`, `eEA_GameClientM`, `eEA_GameClientN`, `eEA_GameServerE`.
+ Minor changes:
  + The `connect` and `disconnect` network console commands have been deprecated.
  + Aspect and RMI functionality is now routed through GridMate replicas.
  + Client RMIs can no longer be sent to specific clients.
  + Client-delegated aspects are now emulated through RPC requests.
  + The following RMI types were removed: URGENT, INDEPENDENT, and FAST.
  + Message checksums are now controlled by ENABLE\_DEBUG\_MESSAGE\_INTEGRITY\_CHECKS \#define so that Debug and Profile builds can connect to each other.
  + Network updates that are visible to the game are now performed in the tick thread, so TO\_GAME and FROM\_GAME are no longer needed.
  + Previously certain global game states were synchronized manually by different parts of the engine. Use `GameContextReplica` to synchronize the global game states.
  + Network binding is now automatic. You no longer need to call `BindToNetwork`.
  + When hosting searchable LAN sessions, `sv_port` and `sv_port + 1` must be available. The session uses `sv_port` and the search listener uses `sv_port +1`.
  + When joining a LAN session, an ephemeral port is used to find the session and the `sv_port` is used to connect to the session.
  + Level loading logic is now included in the level system and the `GameContextReplica` class.
  + GridMate now supports `start_lobby`. `gs_start` is no longer used.
  + `IGameSessionHandler` has been removed. Use `INetworkEventListener` to listen for session events and perform additional operations.
  + Removed `OnOfflineLevelLoaded()` because level loading in single player is no longer a special case.
  + `CCET::SetupActionMap()` and `CCET::SetupLocalView()` are now located in CCryAction.

**Particle Editor**
+ Particle preview playback automatically restarts when you left-click the particle item in the multi-tree.
+ New **fSizeX** and **fSizeY** independently and explicitly control the width and height of particles.
+ New **MaintainAspectRatio** toggle synchronizes subproperties for size.
+ Attach a particle emitter between two bones.
+ New **IgnoreRotation** flag allows emitters to ignore the rotation of the attached bone when determining the orientation.
+ New **NotAttached** flag allows you to spawn an emitter on a bone without attaching to the bone. Subsequent bone translations do not affect the location of the particle emitter.
+ For consistency with drag operations from the Particle Editor, the x-axis automatically rotates 90 degrees when you drop a particle entity into the world from the Rollup Bar.
+ Added **PlaneAlignBlendDistance**.
+ Added a glow map to the particle shader.
+ Added the ability to reduce particle size and lifetime based on the keep density parameter.
+ Moved the particle scale parameter from Material Editor to Particle Editor. This parameter can now make particles softer or harder.
+ You can now use the spherical approximation parameter to choose between standard and spherical tangent calculations.
+ To prevent data loss, users are now warned about unsaved changes to the **Level** library.
+ The curve editors now have a right-click context menu that allow you to delete selected keys.
+ You can now input a value with up to five decimal places for the **Size X** and **Size Y** attributes.

**Post-Effect Groups**

You can customize a number of post-processing effects that are hardcoded in the engine by setting their parameters. For more information, see [Customizing Post-Processing Effects](https://docs.aws.amazon.com/lumberyard/latest/userguide/effect-groups-customizing-intro.html).
+ For more control over post-processing effects, you can create prioritized groups of effect parameters in XML and enable or disable them using a flow graph node or Lua scripting.
+ You can also use effect groups to specify blend curves to smoothly transition between effects.

**Prefabs**
+ You can now properly select and extract a single object from a prefab.
+ You can now add custom pivot points for prefabs. You can also manually move those pivot points using your mouse or by aligning them to prefab objects.
+ The prefab panel now automatically updates the object list when you make any changes.
+ You cannot change prefab properties for multiple prefabs at the same time.
+ You can add level instance count information to selected prefabs in the **Rollup Bar** and **Database View**.

**Project Configurator**
+ The Project Configurator now has an **Open in Editor** button as well as new functionality for the **Save** button so that it’s disabled if no changes were made.
+ Gems are now sorted alphabetically by default.
+ Project names are now limited to 64 characters.
+ The Project Configurator now looks for `bootstrap.cfg` instead of `system.cfg` to work properly with the new asset pipeline.

**Resource Compiler**
+ The Resource Compiler now has signed pixel formats.
+ A `minTextureSize` key is available for upscaling.
+ A `mipgenop` key is now available for filtering using minimum and maximum parameters.
+ The remote console can now use alternate ports if the default port is already in use.
+ Fog density noise is now available for fog volume.
+ You can now apply decal material parameters (**Alpha Multiplier**, **Falloff**, and **Diffuse Opacity**) for deferred decals.
+ An `rc.exe` command line argument sets the upper bound for the UV range across an alembic cache and is used in the compression of UV coordinates. The new default value is `0` (previously `1.0`), which indicates `rc.exe` should set the upper bound for the UV range for each mesh based on the largest UV coordinate detected. This setting will result in optimal UV compression resolution for each mesh.
+ All in-editor GeomCache entities use the new default value of `0`.

**Twitch ChatPlay**
+ You can now explore the TwitchChatBasics level in Samples Project to learn how to use Twitch ChatPlay.

****UI Editor****
+ The grid layout system automatically positions child elements in rows, columns, or grids within the boundary of the parent element. The dynamic layout system uses the following UI components: **LayoutRow**, **LayoutColumn**, and **LayoutGrid**.
+ The **Text** and **TextInput** components now support localized text.
+ The **UI Editor** viewport background now conforms to your **Light Skin** or **Dark Skin** setting on the **View** menu.
+ The UI demo canvas, UI prefabs, and sample textures are now in gems.
+ You can now use the following in the **UI Editor**:
  + **Undo** and **Redo**
  + **Text Input** – Allows for text entry in your game UI
  + **Scale to Device (Transform2d)** – Applies a uniform scale to the UI element based on the ratio of the authored canvas size to the viewport size at runtime
+ You can now draw borders around unselected elements.
+ Various updates to the **UI Editor** interface include displaying the viewport resolution in the toolbar and moving the **New** button from the hierarchy pane to the toolbar.
+ UI canvases and prefabs are now saved using a new serialization system.
+ Changes to the flow graph nodes for the **UI Editor** include updated names and parameters and new nodes for getting and setting text strings on text components.
+ The **Edit** menu now has a **Save as Prefab** option.
+ The **Text Input** component now has a **Password Field** property to support hiding text.
+ Keyboard shortcuts for copy, cut, and paste now work in the viewport.

**Waf Build System**
+ `Crywaf.exe` is now called `lmbr_waf.exe`.
+ Uber files are now automatically generated for most cases and offer the following benefits:
  + Allows tuning of uber file sizes for the compilation environment (e.g. SSD versus HDD or IncrediBuild versus local).
  + Helps simplify the process of creating and maintaining `waf_files` lists.
  + Supports the following uber file keys: `none`, `auto`, and `somefilename.cpp`. Use `none` to support backwards compatibility (equivalent to NoUberFile). Use `auto` to automatically sort and combine files.
  + Supports the **--uber-file-size/uber\_file\_size** setting, which defaults to `300K`.
  + Supports the use of custom file names, forcing the specified files into an uber file of the same name.
+ Isolated the `dep projs` folder to a generated solution name to allow for multiple solutions in the solutions folder.
+ Removed the auto-detect-compiler option, which is replaced by Lumberyard Launcher.

**Miscellaneous**
+ To enable remote access and live reloading of files, you can enable virtual file system in `bootstrap.cfg`. This virtualizes file access rather than making it physical.
+ For enhanced shader debugging, reconfigured shader compiler server dumps OpenGL Shading Language (GLSL) and High-Level Shading Language (HLSL) code when `DumpShaders` is set to `1` in the configuration file (`config.ini`).
+ You can now use QML to develop plugins for Lumberyard Editor.
+ Entity files (`.ent`) in subdirectories are now supported.
+ Debug and FastDebug now build to separate Bin directories than profile and release builds.
+ Dynamic Controller is an exported data track from Maya that is built to drive a variety of runtime systems such as the Blendshape system. Rather than using control bones in the skeleton rig for animator control, Dynamic Controller allows an animator to export floating point tracks using a new `cryFloatExport` node. This exposes key-framed float tracks to the Lumberyard exporter, so that you can have more control without using bloated asset files.
+ You can now ue idle animation desynchronization to offset groups of similarly animated objects so they don't appear to perform the same action at the exact same time.
+ You can now use the following image formats: `.jpg`, `.bmp`, `.png`, and `.tga`.
+ Microsoft Visual Studio 2013 is the supported IDE.
+ CryEngine `CryToolsInstaller.exe` and `SettingsMgr.exe` have been replaced by Lumberyard Launcher.
+ In the Maya plugin, namespaces are now ignored when you search for CryExport nodes.
+ In the Maya and 3ds Max plugins, **CryEngine Exporter** has been renamed to **Lumberyard Exporter**.
+ The DefaultUV texture has been updated with a new image.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/)
+ New BasicEntity and GeometryEntity files are available to place props and noncharacter objects in cinematic scenes.
+ The new AnimObject entity enables an object to play a prebaked animation in game, without the need for skeleton joints or the use of a CDF file.
+ Added support for varying animation frame rate for export from and playback in Autodesk Maya. Supported frame rate for aimIK groups (base animation or aim) is 30 frames per second (fps). Supported frame rates in Maya are 15, 30, 60, 120, and 240 fps. The default frame rate is 30 fps. You can change the frame rate of an asset in Maya by choosing **Windows**, **Settings/Preferences**, **Preferences**, and then selecting the **Settings** category. In the **Working Units** section, select the frame rate from the **Time** drop-down list.
+ Added support for exporting geometry using a custom (relative or absolute) path.
+ Added the `r_texblockOnLoad` console variable, which blocks the game until the Resource Compiler finishes compiling a texture. Valid values: `0=off` \| `1=on`. Default value: `0`.
+ DLL files are now able to safely pass data to other DLL files in a non-release build.
+ Migrated per-instance shader constants to static per-instance buffers outside of the driver layer, which improves performance by decreasing the number of mid-frame buffer updates.
+ The `r_MotionVectors` console variable has been removed. To control object versus camera motion blur, you can now use the `r_MotionBlur` console variable.
+ Added console variable `r_statsMinDrawcalls` to set the minimum value displayed for use with `r_stats 6`.
+ Added console variable `r_ShadowCastingLightsMaxCount` to set the maximum number of shadow casting lights.
+ The LOD system uses the average triangle size to determine when to switch between LOD meshes.
+ The Clip Volumes feature defines geometric shapes that can clip light sources and probes. You can use clip volumes in Lumberyard Editor or by importing from a static mesh.
+ The concept of an entity proxy is no longer used. Classes that previously inherited from `IEntityProxy` now inherit directly from `IComponent`.
+ Actor extension properties now generate a `Get` and `Set` flow node to allow for interacting with these properties. Reflected methods on actor extensions generate a flow node. You can declare reflected methods using the DECLARE\_METHOD macro.
+ The following dialog boxes and widgets are now ported from MFC to Qt: FlowGraph Viewport, Error Report, Measurement System Tool, Python Scripts, Script Terminal, Pak Manager, Generate Terrain Texture, Export/Import Megaterrain Texture, Resize Terrain, SelectionTree Error Report, Asset Resolver, RollupBar/Display, Visual Log Viewer, and Plugin Creation.
+ Gems tests are now included in generated projects.
+ When a spawn point is not available, players now spawn at camera.
+ Textures without a valid TextureCompiling texture are now loaded immediately.
+ PBS material references are now included.
+ The maximum number of bound shader constants has been increased.
+ Removed the following:
  + Crysis references in flow graph
  + Unnecessary CryNetwork and GridMate checks
  + Deprecated instances of `r_ShaderCompilerFolder` in configuration files
  + Deprecated reflection generator
  + Call to a nonexistent Lua script in AIConfig
  + Viewport Point Mode in Lumberyard Editor
+ A new **Light Entities** parameter controls the strength of blurring used to mitigate shadow edge artifacts. Previously this effect was automatically calculated based on the light's field of view when it was used. Exposing the `ShadowBlurStrength` parameter – instead of setting it automatically – allows for greater control over shadow blurring and artifact prevention.
+ Updated the script system to refer to loaded script buffers using the relative file name, excluding the module.
+ Changed Qt windows from QPalette to Stylesheets.
+ Improved the Rotation tool with the following: increased hit test width for the rotation manipulator; removed screen scale issue that broke rotation on 2D viewports; removed view axis rotation in 2D viewports; added align hit testing geometry.
+ Added the console variable `r_deferredDecalsOnDynamicObjects`, which you can use to enable decals projected onto dynamic objects.
+ Updated the DynamoDB nodes to work better with data types. `Put` and `Update` now have a **DataType** field that allows string, number, or bool. `Query` and `Scan` now allow you to set the **AttributeComparisonValueType** that corresponds to the same options. The default values remain `string` in all cases to avoid breaking existing nodes. The `DynamoDBGet` node now has **number** and **bool** outputs. `NumberOut` outputs only when data is retrieved successfully and it was put or updated as a number data type. The **bool** output returns `true` if the data type was a bool and it was set to true; the **bool** output returns `false` for other data types and values.
+ A new version of the AWS SDK for C\+\+ is now available.
+ Created a new method of generating DBAs using the new asset pipeline.
+ Updated the FFmpeg installation instructions in Lumberyard Launcher.
+ Added a tools spec to the Waf build configuration to allow only tools for Lumberyard to be built.
+ OculusSDK is now defined for all operating systems and is installed properly in the `3rdParty` folder during installation.
+ The Resource Compiler is now invoked by the new asset pipeline and the build system instead of the editor.
+ The default value for the console variable `e_GIAmount` is now `0`, which disables LPV unless explicitly enabled.
+ When selecting a custom export target for 3ds Max, the check box is now automatically checked after selecting the path.
+ Various improvements include adding options for third-party configurations, updating scripts to be more modular, and adding `lmbr_waf.bat` for performance improvements.