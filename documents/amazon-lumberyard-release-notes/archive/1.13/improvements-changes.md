# Improvements and Changes<a name="lumberyard-v1.13-improvements-changes"></a>

Lumberyard Beta 1.13 provides improvements and changes to Lumberyard systems and functionality. Choose a topic area to learn more.

**Topics**
+ [Android](#android-improvements-changes-v1.13)
+ [Asset Pipeline](#asset-pipeline-improvements-changes-v1.13)
+ [Cloud Canvas](#cloud-canvas-improvements-changes-v1.13)
+ [Component Entity System](#component-entity-system-improvements-changes-v1.13)
+ [CryEngine IJobManager API](#cryengine-job-manager-improvements-changes-v1.13)
+ [FBX Files](#fbx-files-improvements-changes-v1.13)
+ [Lumberyard Editor](#lumberyard-editor-improvements-changes-v1.13)
+ [Lumberyard Setup Assistant](#lumberyard-setup-assistant-improvements-changes-v1.13)
+ [macOS](#macOS-improvements-changes-v1.13)
+ [Material Editor](#material-editor-improvements-changes-v1.13)
+ [Physics](#particle-system-improvements-changes-v1.13)
+ [Starter Game](#starter-game-improvements-changes-v1.13)
+ [Substance Gem](#substance-gem-improvements-changes-v1.13)
+ [VisArea](#visible-areas-improvements-changes-v1.13)
+ [Miscellaneous](#miscellaneous-improvements-changes-v1.13)

## Android<a name="android-improvements-changes-v1.13"></a>

Android has the following improvements and changes:
+ Android NDK r16 is now supported.
+ In Android Studio, generating a project now creates a Gradle Wrapper to help with versioning issues.

## Asset Pipeline<a name="asset-pipeline-improvements-changes-v1.13"></a>

The asset pipeline has the following improvements and changes:
+ The Source Control API now supports `RequestLatest` to get the latest files, and `RequestRename` to move and rename files. All legacy `ISourceControl` calls (Perforce plugin) for this functionality now use the Source Control API.
+ You can now configure the directory that the **Asset Processor** monitors to be OS-specific. This allows the **Asset Processor** to copy only the relevant assets to the target folder.
+ The Asset Builder SDK now processes the data formats that are exported from `.fbx` files. This excludes legacy file types such as `.cgf`, which are still handled by the resource compiler.
+ The `AssetImportRequest::LoadScene` function is deprecated and has been removed from the SceneAPI.

## Cloud Canvas<a name="cloud-canvas-improvements-changes-v1.13"></a>

Cloud Canvas has the following improvements and changes:

**Text-to-Speech Cloud Gem**
+ You can now use And/Or logic when filtering.
+ You can now sort and filter by character.
+ The `speech_line_definitions.csv` file now includes the MD5 file name.
+ The **Character Advanced** setting now includes a timbre option.
+ The **Character Advanced** setting now includes a language option.
+ When you delete a speech line, the default behavior is no longer to return to the first page.
+ You can now delete multiple speech lines.
+ You can now delete packs.
+ Generated packages now display the correct value for last modified date.
+ Additional Speech Synthesis Markup Language (SSML) types are now supported. This allows you to create more customizable speech lines.
+ The Cloud Gem Portal has improved support for tagging and character, speech line, and file management.

**Speech Recognition Cloud Gem**
+ Microphone support has been added for Android, iOS, and macOS.
+ You can now use the **Voice Recorder System** component for Android, iOS, and macOS. Windows is already supported.

**Cloud Gem Framework**
+ You can now quickly and easily add custom resources to use with your cloud gems. Custom resources allow you to define a handler to enhance the behavior of an `AWS:Service`. For example, the `Custom::DynamoDBTable` resource is a DynamoDB table resource that defines a handler with extra logic to make resource creation and updates more resilient against normal AWS account limits.

## Component Entity System<a name="component-entity-system-improvements-changes-v1.13"></a>

The component entity system has the following improvements and changes:
+ You can now pin the **Entity Inspector** to a particular entity.
+ You can now have multiple **Entity Inspector** windows open simultaneously.

## CryEngine IJobManager API<a name="cryengine-job-manager-improvements-changes-v1.13"></a>

The CryEngine job system and related APIs have been deprecated and will be removed in a future version of Lumberyard. This includes `JobManager::IJobManager`, `JobManager::SJobState`, and `DECLARE_JOB`. Use the `AZ::Job` APIs instead.

## FBX Files<a name="fbx-files-improvements-changes-v1.13"></a>

Lumberyard 1.13 provides a Python script that you can run on your game project to resolve issues with processing and loading `.fbx` material files. The `1.13_assetinfo_updateMaterials.py` script is located in the `/dev/Editor/Scripts/Lumberyard` directory. Run this script to set the **Update Materials** flag to **False** for all `.fbx` files in your project. Materials that are associated with `.fbx` files that are already in your project may not process successfully if the **Update Materials** flag is set to **True**.

## Lumberyard Editor<a name="lumberyard-editor-improvements-changes-v1.13"></a>

Lumberyard Editor has the following improvements and changes:
+ Level names can now begin with numbers. Previously only letters were supported.
+ The **Console** window now displays new lines properly, and the display time has improved.
+ The viewport and editor buttons now have tooltips.
+ You can now create subfolders in the **Save Level As** dialog box. A warning displays if the level name conflicts with an existing folder.
+ The default decimal text box now supports higher-precision decimal values. This is particularly useful for Time of Day parameters.

## Lumberyard Setup Assistant<a name="lumberyard-setup-assistant-improvements-changes-v1.13"></a>

The Lumberyard Setup Assistant has the following improvements and changes:
+ The installation instructions for Visual Studio 2015 now links to the correct topic on the Microsoft website.
+ Visual Studio 2013 now displays a deprecation notice.
+ Memory usage has been improved.

## macOS<a name="macOS-improvements-changes-v1.13"></a>

macOS has the following improvements and changes:
+ OpenGL is no longer supported on macOS, so the `system_osx_gl.cfg` file has been removed from the Lumberyard files.
+ Substance is now supported on macOS.

## Material Editor<a name="material-editor-improvements-changes-v1.13"></a>

The Material Editor has the following improvements and changes:
+ The **Copy All** and **Copy Section** options have been added.
+ You can now use the paste feature without a current selection in the properties list.

## Physics<a name="particle-system-improvements-changes-v1.13"></a>

The physics system has the following improvements and changes:
+ The PhysX Jobs Dispatcher now uses an appropriate amount of worker threads to help improve performance and better use the CPU.
+ The PhysX error logging has been improved to help with debugging issues.
+ The PhysX terrain requests have been moved into `LegacyTerrainRequestBus`. This separates legacy code from the PhysX gem system.

## Starter Game<a name="starter-game-improvements-changes-v1.13"></a>

Starter Game has the following improvements and changes:
+ Some character animations now use the **Animation Editor (EMotion FX)** system.
+ The holster weapon delay has been reduced.

## Substance Gem<a name="substance-gem-improvements-changes-v1.13"></a>

The Substance gem now includes Script Canvas and Lua scripting support for Substance procedural materials.

## VisArea<a name="visible-areas-improvements-changes-v1.13"></a>

The VisArea component has the following improvements and changes:
+ The **VisArea** setting names are now consistently named.
+ The **IgnoreSkyColor** and **IgnoreGI** options have been removed from the **VisArea** and **Portal** components.

## Miscellaneous<a name="miscellaneous-improvements-changes-v1.13"></a>

Lumberyard has the following miscellaneous fixes:
+ In the serialization context, `DataElementNode::GetData` and `SetData` are symmetrical and work as expected with containers. `GetDataHierarchy` is no longer included in the API. You can use `GetData` instead.
+ The `shared_mutex` class has the following improvements:
  + The `shared_mutex` class now matches the standard for read/write lock.
  + The `upgrade_mutex` style of the `shared_mutex` class has been removed.
  + The `shared_spin_mutex` has been renamed to `shared_mutex`.
  + The `shared_spin_mutex` has been aliased to `shared_mutex`.