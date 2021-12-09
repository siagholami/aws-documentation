# Amazon Lumberyard Release Notes: Fixes and Deprecations for 1.23 (February 2020)

Lumberyard Beta 1.23 resolves earlier problems and deprecates features and APIs. 

### EBus

EBus has the following fixes:

+ Fixed an error message which incorrectly called a "setter" a "getter."

### Editor

The Lumberyard Editor has the following fixes:

+ You can no longer add level components when you haven't loaded or created a level.

+ Fixed an issue that could sometimes cause it to be impossible open any material in the Material Editor.

+ You can no longer create a new level while the Editor is generating a terrain texture for an already opened level.

+ Fixed a crash when editing asset settings while running a debug build of the Editor.

+ Fixed a crash caused when a user creates a new level after generating a Terrain Texture in the Editor.

+ Fixed a bug in the Editor that prevented the user from saving their settings in certain situations.

+ Fixed a crash in the Editor's debug build mode when the user attempts to change settings for an unprocessed slice.

+ Fixed a crash in the UI Editor when previewing a canvas that contained a DynamicScrollBox component.

+ Fixed a launch crash in the Editor when a project other the Multiplayer Sample and Samples Project is set as default.

+ Fixed a crash when resizing a shape if Snap To Grid is set to 0 when using the default SamplesProject set as the default project or if the PhysX Gem is enabled.

### Graphics

Graphics has the following fixes:

+ Fixed a crash when verifying texture suffixes for shaders.

+ Fixed a crash on iOS device when updating shader FX params because of shader resources not getting released.

### Physics

Physics has the following fixes:

+ Collision meshes now better match the visible objects in the Editor as they did in Lumberyard Beta v1.21

+ Fixed a bug where the OverlapBox, OverlapSphere and OverlapCapsule Script Canvas nodes returned double the number of results, with half of them invalid. These collision query operations now return the correct number of results.

+ PhysX terrain now correctly updates with respect to the provided heightmap when the Roads and Rivers gem is used.

+ Fixed ragdoll crashes in PhysX with Lumberyard 1.21.2 when multiple ragdolls were simultaneously activated.

+ Fixed a crash in the Editor that occurs at certain times when an AI function is executed after an AI pathfinding entity is created while running in Game Mode or when AI/Physics is enabled.

+ Fixed a crash in the Editor that occurs when the `ai_SmartPathFollower_useAdvancedPathShortcutting_debug` variable is enabled from the console while running in Game Mode or when AI/Physics is enabled.

+ Fixed a crash in Track View after opening a sequence with AI/Physics enabled.

+ Fixed a bug in PhysXSamples Gem where animation .fbx files fail to compile when all gems are enabled.

### Project Configurator

Project Configurator has the following fixes:

+ Fixed an issue where a new project would fail to load on some target platforms.

+ Fixed an issue where cutting a component in the Advanced Settings dialog box would cause a crash.

+ Fixed an issue where arbitrary length checks on path components were causing full path validation checks to fail.

+ Fixed an issue where lmbr CLI would look in the wrong path for SetupAssistantConfig.ini.

+ Updated the gem templates and improved platform abstraction when creating new projects or gems.

### Scripting

Scripting has the following fixes:

+ Fixed crashes from Lumberyard v1.22 that occur when opening and closing the Lua Editor.

+ Fixed a bug in Lua scripting where the AddMethod method on the ScriptEvent class causes a Lua Editor crash when the first supplied argument is of an unexpected type or format.

+ Fixed a crash when executing UI Anchors, UI Offsets, or UI Padding Script Canvas nodes.

### Cloud Gem Framework

The Cloud Gem Framework gem has the following fixes:

+ Security improvements to enforce assumeRole boundaries made to Cognito roles within Cloud Formation and Cloud Canvas configurations.

### Player Accounts

The Player Account gem has the following fixes:

+ Security improvements to enforce assumeRole boundaries made to Cognito roles within Cloud Formation and Cloud Canvas configurations.

## Deprecated APIs

The following APIs have been deprecated in Lumberyard Beta v1.23:

In `PhysX::ColliderComponentRequestBus`:

+ ::GetShapeConfigFromEntity()

  + Use GetShapeConfigurations() instead. This returns a vector which contains a pair for each shape.

+ ::GetColliderConfig()

  + Use GetShapeConfigurations() instead. This returns a vector which contains a pair for each shape.

+ ::GetShape()

  + Use GetShapes() instead. This returns a vector of Shape pointers.

+ ::GetNativePointer()

  + Use GetShapes() instead. This returns a vector of Shape pointers which can be iterated over. Call Shape::GetNativePointer() on each Shape.

In` EditorVisibilityRequestBus`:

+ ::GetCurrentVisibility()

  + Call EditorEntityInfoRequests::IsVisible (or use the utility function IsEntityVisible in EditorEntityHelpers.h) to read an entity's visibility state.

+ ::SetCurrentVisibility()

  + Call SetEntityVisibility() from EditorEntityHelpers.h to set visibility.

  + Optionally, to track entity visibility state internally, listen for the EditorEntityVisibilityNotifications::OnEntityVisibilityChanged event.

In `EditorEntityContextRequests`:

::CreateEditorEntity() and ::CreateEditorEntityWithId()

+ Use these new companion methods instead: CreateNewEditorEntity() and CreateNewEditorEntityWithId().

## Deprecated Features

+ The Flow Graph feature will be deprecated in a future Beta release of Amazon Lumberyard.

## Deprecated Gems
The following gems have been deprecated in Lumberyard Beta v1.23:

+ The Open Source VR (OSVR) gem will no longer be supported.

