# Improvements and Changes<a name="lumberyard-v1.12-improvements-changes"></a>

Lumberyard Beta 1.12 provides improvements and changes to Lumberyard systems and functionality. Choose a topic area to learn more.

**Topics**
+ [Android](#android-improvements-changes-v1.12)
+ [Asset Pipeline](#asset-pipeline-improvements-changes-v1.12)
+ [Audio](#audio-improvements-changes-v1.12)
+ [Cloud Canvas](#cloud-canvas-improvements-changes-v1.12)
+ [Component Entity System](#component-entity-system-improvements-changes-v1.12)
+ [Documentation](#documentation-improvements-changes-v1.12)
+ [Gems](#gems-improvements-changes-v1.12)
+ [Lmbr.exe](#lmbr-exe-improvements-changes-v1.12)
+ [Lumberyard Editor](#lumberyard-editor-improvements-changes-v1.12)
+ [Lyzard.exe](#lyzard-exe-improvements-changes-v1.12)
+ [macOS](#macOS-improvements-changes-v1.12)
+ [Mobile](#mobile-improvements-changes-v1.12)
+ [Networking](#networking-improvements-changes-v1.12)
+ [Physics (Legacy)](#particle-system-improvements-changes-v1.12)
+ [Project Configurator](#project-configurator-improvements-changes-v1.12)
+ [Script Canvas](#script-canvas-improvements-changes-v1.12)
+ [Starter Game](#starter-game-improvements-changes-v1.12)
+ [Track View](#track-view-improvements-changes-v1.12)
+ [UI Editor](#ui-canvas-editor-improvements-changes-v1.12)
+ [Virtual Reality](#virtual-reality-improvements-changes-v1.12)
+ [Miscellaneous](#miscellaneous-improvements-changes-v1.12)

## Android<a name="android-improvements-changes-v1.12"></a>

Android has the following improvements and changes:
+ When you pack assets into an Android Package Kit (APK) file, the load times have decreased from minutes to seconds.
+ The GNU Compiler Collection (GCC) toolchain is deprecated and disabled. GCC will be removed in a future version.
+ Simple DirectMedia Layer (SDL) is no longer required to build and run Android applications.
+ Enable `JNI_SIGNATURE_VALIDATION` to ensure Android debug builds work correctly.
+ Android now builds and runs with the Unit Testing framework.
+ Support has been added for ARMv8 (64-bit).
+ Support has been added for Android 8.0 Oreo.

## Asset Pipeline<a name="asset-pipeline-improvements-changes-v1.12"></a>

The asset pipeline has the following improvements and changes:

**Asset Browser**
+ Processed assets have a basic control that distinguishes them as processed assets and not as assets on disk.
+ Use new APIs to customize interactive behavior for your custom assets.
+ Double-click an asset field in the **Entity Inspector** to open the file in the default editor. You can then double-click the assigned scripts, materials, and other files to quickly open and edit the file.

**Asset Processor**
+ To reduce the number of unnecessary `.actor` files that are created when you add `.fbx` files, the **Asset Processor** no longer generates an `.actor` file if the `.fbx` file has an animation.
+ You can now specify new operating systems and tag them in the `AssetProcessorPlatformConfig.ini` file with specific attributes.
+ BuilderSDK builders make content decisions based on the platforms and tags that are present and enabled in a build.
+ You can define build options with tags, such as renderer or mobile, instead of using operating system names.
+ Reporting has been improved for asset processing.
+ AssetBuilderSDK builders run in an external executable file, which prevents builders from crashing the **Asset Processor** and allows builders to run in parallel without concern for thread safety.

## Audio<a name="audio-improvements-changes-v1.12"></a>

The audio system has the following improvements and changes:
+ Error logging has been improved when you encounter duplicate Audio Translation Layer (ATL) switches and Real-Time Parameter Controls (RTPC).
+ The **File Cache Manager** code has been cleaned up.
+ The **Audio Trigger** component has added an obstruction ray casting type. This allows you to specify **Ignore**, **Single Ray**, or **Multi Ray** obstruction ray casting.
+ The `pAudioSystem` pointer under `gEnv` is deprecated and has been removed. You can now interact with the audio system through EBus.

## Cloud Canvas<a name="cloud-canvas-improvements-changes-v1.12"></a>

Cloud Canvas has the following improvements and changes:

**Text-to-Speech Cloud Gem**
+ Amazon Polly is accessible worldwide from the following AWS regions: Asia Pacific (Mumbai), Asia Pacific (Seoul), Asia Pacific (Singapore), Asia Pacific (Sydney), Asia Pacific (Tokyo), Canada (Central), EU (Frankfurt), EU (Ireland), EU (London), South America (São Paulo), US East (N. Virginia), US East (Ohio), and US West (Northern California). You must deploy your stack in one of these regions to use Amazon Polly. For more information about supported regions, see the [AWS Region Table](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/).

## Component Entity System<a name="component-entity-system-improvements-changes-v1.12"></a>

The component entity system has the following improvements and changes:
+ You can now specify whether an entity is active by default upon game start. To do so, choose an entity in the viewport and then select the **Start Active** check box in the **Entity Inspector**.
+ The search and filter functionality in the **Entity Outliner** has been updated, including changes to the user interface.
+ To remove ambiguity, one of the `DestroyEntity` methods was renamed to `DestroyEntityById`.
+ Various component entities were created to replace legacy entities for graphics features. These component entities include **Rain**, **Snow**, **Lightning**, and **GeomCache**.
+ The editor no longer stops working if you add the **Light** and **High Quality Shadow** components to the same entity and then disable the light visibility.
+ The **CryEntity Converter** now converts additional legacy components to new component entities.
+ Use the visibility toggle to display shape components in the editor, even if the shape components are not selected.
+ You can now search for components or field names in the **Entity Inspector**.

## Documentation<a name="documentation-improvements-changes-v1.12"></a>

You can now search the Lumberyard documentation in the editor.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/lumberyard-editor-documentation-search-option.png)

## Gems<a name="gems-improvements-changes-v1.12"></a>

Gems have the following improvements and changes:
+ New projects have the CryEntity Removal gem enabled by default. With this gem enabled, Lumberyard Editor displays only the features and tools that use the new component entity system. The following legacy features are disabled:
  + **Database View**
  + **Flow Graph**
  + **Object Selector**
  + **Layer Editor**
  + **Rollup Bar**
  + **Asset Browser**

  You can use the following replacement workflows:
  + To replicate the **Rollup Bar** functionality, use the [https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-inspector.html](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-inspector.html) to add components to an entity.
  + [Slices](https://docs.aws.amazon.com/lumberyard/latest/userguide/dynamic-slices.html) replace **Rollup Bar** prefabs.
  + The **Rollup Bar** **Terrain** tab is now located in the **Tools**, **Terrain Tool** menu.
  + The **Database View** **Vegetation** tab is now located in the **Tools**, **Vegetation Editor** menu.
  + The [https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-outliner.html](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-outliner.html) replaces the **Object Selector**.
  + [https://docs.aws.amazon.com/lumberyard/latest/userguide/creating-gameplay.html](https://docs.aws.amazon.com/lumberyard/latest/userguide/creating-gameplay.html) replaces **Flow Graph**.
  + The **Layer Editor** is deprecated.

  For more information, see [CryEntity Removal Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-cryentity-removal-gem.html) in the Amazon Lumberyard User Guide.
+ The Tornado gem is deprecated and has been removed from Lumberyard.
+ The Scene Processing gem allows you to configure soft naming conventions in the **Project Configurator** advanced settings.

## Lmbr.exe<a name="lmbr-exe-improvements-changes-v1.12"></a>

The `Lmbr.exe` command line tool has the following improvements and changes:
+ You can use the `lmbr thirdpartysdks setup` command to download third-party SDKs. This allows you to further automate your setup process.
+ The following modules were added: `ThirdPartySDKs`, `Packages`, and `Setup`.
+ If you use the `lmbr projects create -template` argument, the help messaging has been improved to clarify that the argument needs a directory name.

## Lumberyard Editor<a name="lumberyard-editor-improvements-changes-v1.12"></a>

Lumberyard Editor has the following improvements and changes:
+ The **Dialog Editor** is now deprecated.
+ Ocean rendering has been improved to reduce visible tessellation and LOD artifacts.
+ Various improvements to level creation include the following:
  + White sun color has been added to the default time of day curves between 11:00 am and 1:30 pm.
  + The default time is now set to 1:30 pm.
  + An environment probe called `default_level_probe` is now created by default. The probe has xy values that are derived from the terrain size values that you define.
  + The default camera is now placed closer to the ground.
+ The default environment probe no longer adds an off-color tint around the edge of the terrain.
+ The **Orthographic Camera** view was removed from the **Viewport Type** menu in Lumberyard Editor.
+ Use the **Texture Manager** to load system and default textures.
+ The **Asset Editor** is now accessible from the **Tools** menu.

## Lyzard.exe<a name="lyzard-exe-improvements-changes-v1.12"></a>

Window geometry values are now saved in the correct location in the registry.

## macOS<a name="macOS-improvements-changes-v1.12"></a>

macOS has the following improvements and changes:
+ Simple DirectMedia Layer (SDL) has been removed and is no longer a required or used third-party library.
+ Instanced rendering has been enabled.
+ To improve performance, you can enable distance-based, cached, shadow updates.

## Mobile<a name="mobile-improvements-changes-v1.12"></a>

Android and iOS have the following improvements and changes:
+ Android and iOS builds are now smaller. An empty project is \~20 Mb on Android and \~25 Mb on iOS.
+ Substance is now supported for Android and iOS.
+ Support for multiple spec configuration has been added. This allows you to customize rendering features based on the device.

## Networking<a name="networking-improvements-changes-v1.12"></a>

Networking has the following improvements and changes:
+ The GameLift client service now uses the `describeGameSessions` API instead of the `GameLift FleetAttributes` API. The `GameLift FleetAttributes` API is not supported on the local GameLift server package.
+ Use the debug/profile only console variable to configure the GameLift client to work with the local GameLift server.
+ The **Net Binding** component is now activated first on an entity.

## Physics (Legacy)<a name="particle-system-improvements-changes-v1.12"></a>

The legacy physics system has the following improvements and changes:
+ The following physics buses in `LmbrCentral::Physics` are deprecated and will be removed in a future version:
  + `ColliderComponentBus`
  + `ConstraintComponentBus`
  + `PhysicsComponentBus`
  + `PhysicsSystemComponentBus`
  + `RagdollPhysicsBus`

  Use the equivalent buses in `AzFramework::Physics` instead.
+ The following functions have moved from `PhysicsComponentBus` to `LmbrCentral::CryPhysicsComponentRequestBus`:
  + `GetWaterDamping`
  + `SetWaterDamping`
  + `GetWaterDensity`
  + `SetWaterDensity`
  + `GetWaterResistance`
  + `SetWaterResistance`
  + `GetAcceleration`
  + `GetAngularAcceleration`
  + `GetDensity`
  + `SetDensity`

  The legacy bus functions will be removed in a future version.
+ The following `PhysicsComponentBus` functions are deprecated and will be removed in a future version:
  + `AddAngularImpulseAtPoint`

    Use `AddAngularImpulse` and `AddImpulse` instead.
  + `GetDamping`

    Use `GetLinearDamping` and `GetAngularDamping` instead.
  + `SetDamping`

    Use `SetLinearDamping` and `SetAngularDamping` instead.
  + `GetMinEnergy`

    Use `GetSleepThreshold` instead.
  + `SetMinEnergy`

    Use `SetSleepThreshold` instead.

## Project Configurator<a name="project-configurator-improvements-changes-v1.12"></a>

The **Project Configurator** no longer stops working if you choose **Enable Gems** for a project that does not have a `gems.json` file.

## Script Canvas<a name="script-canvas-improvements-changes-v1.12"></a>

Script Canvas has the following improvements and changes:
+ Graphics features that were available in the **Flow Graph** editor are now available in the **Script Canvas** editor.
+ The following **Script Canvas** nodes replace legacy nodes:
  + The **Enable Blur** node replaces the **EffectFilterBlur** node.
  + The **Enable Color Correction** node replaces the **EffectColorCorrection** node.
  + The **Enable Depth of Field** node replaces the **EffectDepthOfField** node.
  + The **Enable Water Droplets** node replaces the **EffectWaterDroplets** node.

  You must manually update your scripts to use these new nodes.
+ You can now fade in/out environment probes during component state changes. Particles use an appropriate environment probe.
+ The **MaterialOwnerBus** now has additional **Material ID** parameters for the `SetParams` and `GetParams` functions. The **MaterialHandle** now has an additional `FindSubMaterial` function.
+ Material owners now have `SetParamVector3` and `GetParamVector3` functions.
+ The **Lerp** and **LerpInverse** math utilities have been added to use in scripts.
+ Auto-completion has been added to the search feature in the **Node Palette**.
+ You can now serialize the `AZStd::tuple` type in the serialization context.
+ The Boolean button is now a check box.
+ The tooltip for a tab now shows the canvas file path.
+ Pressing **Z** in the viewport now frames the selection into view. If no selection is active, the entire canvas is framed into view.
+ Scrolling through the **Node Palette** is now smoother.

## Starter Game<a name="starter-game-improvements-changes-v1.12"></a>

Starter Game has the following improvements and changes:
+ A crouch player action has been added.
+ Four new caves highlight the following render effects:
  + Cave 1 – Order-independent transparency (OIT)
  + Cave 2 – Specular anti-aliasing (SAA)
  + Cave 3 – Temporal anti-aliasing (TAA)
  + Cave 4 – Time of day (TOD)

  You can access these caves by interacting with a console in the start area.
+ Two examples of **Script Canvas** implementation were added.
+ Starter Game is now supported on macOS.
+ Various improvements include polishing the lighting and scripting.

## Track View<a name="track-view-improvements-changes-v1.12"></a>

The **Track View** editor has the following improvements and changes:
+ Support for sequences within slices has been improved.
+ When you create a new sequence, the default focus for the pointer is now on the **New sequence name** text box.

## UI Editor<a name="ui-canvas-editor-improvements-changes-v1.12"></a>

The UI Editor has the following improvements and changes:
+ Hot loading of UI canvases is now supported. This allows you to edit a UI canvas and save those changes, and the changes appear in the game without you restarting the game or reloading the UI canvas.
+ The UI Features level in SamplesProject now includes sample canvases that demonstrate how to use the **UiSpawner** component and UI localization features.

## Virtual Reality<a name="virtual-reality-improvements-changes-v1.12"></a>

The Virtual Reality Samples Project has been updated to use the component entity system, **Script Canvas**, and Lua. Previously the samples project used **Flow Graph** and legacy entities.

## Miscellaneous<a name="miscellaneous-improvements-changes-v1.12"></a>

Lumberyard has the following miscellaneous fixes:
+ The default precompiled header now follows a `modulename_precompiled.h` naming convention. Previously the default precompiled header was called `StdAfx.h`.
+ The `BroadcastProfile` and `AllEvents` profile wildcards now work properly.