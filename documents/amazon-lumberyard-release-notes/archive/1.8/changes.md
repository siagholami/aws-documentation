# Improvements and Changes<a name="lumberyard-v1.8-changes"></a>

Updates to Lumberyard systems and functionality include:

**Audio**
+ The ATL control selector in the audio component suite is now supported, which allows you to select the appropriate control rather than entering it manually.

**Component Entity System and Components**
+ Limb IK and Aim IK are now supported.
+ A new bus (C\+\+ or scripting) is now exposed for driving Aim IK.
+ The **Camera** component in the **Camera Gem** has a new class ID. An **Editor Camera** component has also been added.
+ The **EventActionBinding** component has been deprecated. You can access the same behaviors using scripts in the **StartingPointMovement Gem**.
+ The **CameraTarget** component has been deprecated. Two new target acquiring behaviors for the camera rig allow targeting by entity reference or tag.
+ A single entity can now have only one **Camera** component.
+ The **Perspective** context menus now work with entities (`AZ::Entity`) and camera components. The camera properties (FOV, near/far clip planes, etc.) are used with an entity that has a camera component attached. With movement enabled, the camera transform updates as you move and look around the level. You can clear a camera option by clicking an already-selected camera in the **Perspective** context menu.

**FBX Settings**
+ Root motion extraction is now computed for imported animations.
+ The FBX Settings now supports skins, skeletons, and animations.

**Gems**
+ Browser:
  + The Project Configurator now labels gems that contain only assets, and gems that contain code and assets.
  + A warning message has been updated to indicate that recompiling is only required if you toggle code and asset settings for a gem. You do not need to recompile if you toggle an asset-only gem.
  + A warning message displays if you enter the gem browser and the project references a gem that does not exist on disk. Saving your project will remove the reference to the missing gem.
  + A warning message displays if you toggle on or off a gem that includes code and your environment is not set up to compile code. The warning message provides instructions to finish enabling the gem.
  + Gem descriptions no longer overlap with the **View in directory** text link.
  + Gems are now expanded by default, displaying the descriptions.
  + The help button is now functional and redirects to the [Gems](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gems.html) help page.
  + Pressing **Ctrl\+F** moves the cursor to the search field.
+ Creation:
  + The gem creation interface allows you to select whether a gem will be asset-only or support code and assets.
  + You can now write a gem summary during the gem creation process. To edit summaries for existing gems, you must manually edit the `gem.json` file for the gem.
  + If you have not enabled the **Compile game code** capability in the Lumberyard Setup Assistant, the gem creation interface will default to an **Assets Only** gem type. If you select the **Code and Assets** gem type, a warning message will appear stating that you must enable the **Compile game code** capability in order to finish setting up and to use your gem.
  + Error messages now display next to the relevant field, occur instantly when an error is made, and clear once the error is resolved.
  + A new help button in the gem creation interface redirects to the [Gems](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gems.html) help page.
  + Gems that you create are automatically enabled for your current project. You must click **Save** in the Project Configurator to save these changes.
  + The hint for the **Gem name** input field has been updated to reflect the naming standards. Gem names must not contain spaces.

**Geppetto**
+ The Live Reload feature now supports `.chrparams` files.

**Lua**
+ When an error occurs in Lua, the stack trace no longer truncates the file name.
+ Properties in Lua now include containers of entity references that can be resized.
+ You can now use the Lua IDE to view variables inside a table.
+ When adding properties to a Lua script that is referenced by a dynamic slice (without pushing the new property), referencing that property now results in a more useful warning message.
+ The default Lua caching methods have been switched to weak references, including EBus references to the attached table.

**Mannequin**
+ You can now edit the **Time** field in the animation clip properties.
+ You can now add selections in bulk by dragging and dropping from Geppetto to the **Mannequin Fragments** panel.
+ You can now edit the time code display to jump directly to the time in the animation rather than scrubbing the time controls.
+ The **File** menu now lists the most recently used previews.
+ The last viewed preview now auto-loads when opening the Mannequin editor.
+ The **Context** menu now includes several actions from the **Fragments** panel.
+ Multi-selection actions are now supported.

**Maya**
+ The Maya plugin now supports Maya 2017.

**Mobile**
+ For both Android and iOS, startup banners have been added to display whether or not VFS or internal storage is configured for serving game files. This can help prevent misconfiguration and confusion about the location of files.

**Networking**
+ The Multiplayer sample is now supported for Android, iOS, and Linux.
+ MultiplayerLobby now supports console-specific services and error messages.
+ Out-of-order processing is now supported by separating replica marshal and unmarshal steps in order to reduce latency.
+ The default listening port is now set to 30090 for all operating systems.

**Particle Editor**
+ A **Particle** component refactor includes more accurate tool tips and names for settings, support for EBus requests, and multiple bug fixes.
+ The **Particle** component now includes particle size X, Y, and random.
+ The **Particle** component now supports enabling and disabling of particle LODs.
+ The **Particle** component now supports tinting the color of your emitters.
+ The **Particle** component no longer allows particle level source selection. All libraries are assigned from XML particle library assets. We recommend that you move all particle level libraries to an XML library. Lumberyard will deprecate the level library in a future release.
+ **Parallax** and **Lighting** now support non-uniform scaling.
+ The legacy terrain color multiplier and high quality texture generation settings have been removed from the new level creation process.

**Physics Component**
+ The **Static Physics** and **Rigid Body Physics** components replace the **Physics** component. Data from previous versions will automatically convert when loaded, but you must save the data for the conversion to be permanent.
+ The **Physics** component automatically detects colliders on a child entity. Previously you were required to manually set which child entities would contribute collision.
+ The `PhysicsSystemRequestBus RayCast` call now returns multiple hits.

**Project Configurator**
+ The **New Project** dialog box now focuses the text input as expected.
+ The **Create Gem** dialog box now focuses on the next or previous fields when you press **Tab** or **Shift\+Tab**.
+ The **Create Gem** dialog box now attempts to create the gem when you press **Enter**.

**Twitch ChatPlay**
+ The connection fallback logic has been improved so that Twitch ChatPlay can fall back to a websocket connection if Twitch ChatPlay cannot connect to the Twitch IRC directly.
+ The Metastream sample level has updated camera and user controls to match the Controllable Chicken level.
+ Twitch ChatPlay can now send whispers over websockets if the direct IRC connection fails.
+ The TwitchChatBasics level now has a flow graph and simple UI to demonstrate how to use the Twitch ChatPlay Whisper functionality.

**UI Editor**
+ You can now edit multi-line text in the **Text Input** component.
+ The UI Editor now supports switching between languages.
+ The following Flow Graph nodes have been added:
  + `UiTransformComponent` nodes to get and set the position and rotation of an element
  + `UiElementComponent` nodes to get the parent and child nodes

**Virtual Reality**
+ The `hmd_debug` console variable is now called `hmd_debug_info`.

**Miscellaneous**
+ The `lmbr.exe` file now accepts a command that returns the current active project.
+ If an asset fails to build, all references to that asset in the editor will display an exclamation point (\!). You can click on the exclamation point to see the asset's build log.
+ The input system has been simplified by handling analog and digital inputs with a single input. The following behaviors have been converted to script: held, pressed, and released.
+ Input now has a context stack that you can manipulate using the `InputRequestBus` in code or script.
+ Input configuration components now have an array of participating contexts. The default context is `""` and is made active when specifically pushed and if the stack is empty.
+ Filtered input is now handled using the `InputEventNotificationBus` and converted into `GameplayNotification` in script.
+ Input bindings now default to keyboard instead of a null device.
+ You can now query descendants of an entity using the TransformBus.
+ The `GameplayNotificationBus` no longer follows a template and now uses `AZStd::any` for its argument.
+ The `GameplayNotificationBus` API has changed to `OnEventBegin`, `OnEventUpdating`, `OnEventEnd`.
+ `AZStd::dynamic_pointer_cast` is now only available if compiler RTTI is enabled.
+ `AZStd::rtti_pointer_cast` is now an extension for casting `shared_ptrs` using objects that have `AZ_RTTI`.
+ `AZStd::reinterpret_pointer_cast` is now added to match the C\+\+11 standard.
+ `AZStd::polymorphic_pointer_cast` is now removed.
+ A new type called `AZStd::any` allows you to store and accept as a parameter any type that is known to `AZ_TYPE_INFO` or `AZ_RTTI`. The new type is used by the `GameplayNotificationBus` and can be passed to and from Lua.
+ The build system is now exposed to compiler flags for stack/buffer overflow protection and address space layout randomization.
+ /GS (MSVC) is now enabled by default on dedicated server and debug targets, and is controllable per target in all configurations.
+ /DYNAMICBASE (MSVC) is now enabled by default on dedicated server targets, and is controllable per target in all configurations.
+ The following command line build parameters have been added:
  + `--use-asan` – Enables /GS on MSVC; use `-fsanitize` for the address on Clang
  + `--use-aslr` – Enables /DYNAMICBASE on MSVC; use `-fsanitize` for memory on Clang
+ The following build target configuration options have been added and can be configured per target/configuration in wscripts:
  + `use_asan`
  + `use_aslr`
+ The `map` command is now supported in release mode.