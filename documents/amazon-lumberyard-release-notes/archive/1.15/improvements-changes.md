# Improvements and Changes<a name="lumberyard-v1.15-improvements-changes"></a>

Lumberyard Beta 1.15 provides improvements and changes to Lumberyard systems and functionality. Choose a topic area to learn more.

**Topics**
+ [AI](#ai-improvements-changes-v1.15)
+ [Android](#android-improvements-changes-v1.15)
+ [Animation Editor](#animation-editor-improvements-changes-v1.15)
+ [Asset Processor Batch](#asset-processor-batch-improvements-changes-v1.15)
+ [Audio](#audio-improvements-changes-v1.15)
+ [Cloud Canvas](#cloud-canvas-improvements-changes-v1.15)
+ [Component Entity System](#component-entity-system-improvements-changes-v1.15)
+ [CryEngine IJobManager API](#cryengine-job-manager-api-improvements-changes-v1.15)
+ [Designer Entities](#designer-entities-improvements-changes-v1.15)
+ [Gems](#gems-improvements-changes-v1.15)
+ [Graphics](#graphics-improvements-changes-v1.15)
+ [iOS](#ios-improvements-changes-v1.15)
+ [Legacy Tools](#legacy-tools-ui-improvements-changes-v1.15)
+ [Lumberyard Editor](#lumberyard-editor-improvements-changes-v1.15)
+ [macOS](#macos-improvements-changes-v1.15)
+ [Mobile Support](#mobile-improvements-changes-v1.15)
+ [Networking](#networking-system-improvements-changes-v1.15)
+ [Particle System](#particle-system-improvements-changes-v1.15)
+ [UI Editor](#ui-editor-improvements-changes-v1.15)
+ [Miscellaneous](#miscellaneous-improvements-changes-v1.15)

## AI<a name="ai-improvements-changes-v1.15"></a>

When loading a level, the navigation system no longer logs duplicate warnings about invalid exclusion volumes.

## Android<a name="android-improvements-changes-v1.15"></a>

Android NDK r17 is now supported.

## Animation Editor<a name="animation-editor-improvements-changes-v1.15"></a>

The Animation Editor has the following improvements and changes:
+ The **Retarget Root Node** property was added to the **Actor Properties** pane to help improve the quality of the retargeting system.
+ When characters transition to the **180turn** motion node, the 180 degree turn now completes successfully.
+ The **Extraction** mode now includes options for **Blend**, **Target Only**, and **Source Only**.

## Asset Processor Batch<a name="asset-processor-batch-improvements-changes-v1.15"></a>

The Asset Processor Batch now shows the total processing time. This can help you track performance.

## Audio<a name="audio-improvements-changes-v1.15"></a>

Lumberyard no longer supports Audiokinetic Wwise SDK version 2015.x.x and earlier.

## Cloud Canvas<a name="cloud-canvas-improvements-changes-v1.15"></a>

The Cloud Canvas cleanup tool no longer works out of the box on a clean installation of Lumberyard. To use the tool, do one of the following:
+ First create a project stack.
+ Use the cleanup tool without creating a project stack. For more information, see [Freeing Up AWS Resources](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-administration-aws-resource-cleanup.html#cloud-canvas-administration-aws-resource-cleanup-tool).

## Component Entity System<a name="component-entity-system-improvements-changes-v1.15"></a>

The component entity system has the following improvements and changes:
+ The **Mesh** component now includes a level of detail (LOD) cross-fade dissolve feature that results in a nearly invisible fade between two LODs of the same model.

## CryEngine IJobManager API<a name="cryengine-job-manager-api-improvements-changes-v1.15"></a>

The CryEngine job system and related APIs have been deprecated and removed from Lumberyard. This includes `JobManager::IJobManager`, `JobManager::SJobState`, and `DECLARE_JOB`. Use the `AZ::Job` APIs instead.

## Designer Entities<a name="designer-entities-improvements-changes-v1.15"></a>

Designer entities have been converted to entities with **Mesh** components. This allows you to use these entities after the designer tool is deprecated.

## Gems<a name="gems-improvements-changes-v1.15"></a>

The CryLegacy gem now includes CryAction, CryAISystem, CryAnimation, CryEntitySystem, and CryScriptSystem. The CryLegacy gem is required for game projects that are created in Lumberyard 1.15. CryEntities will be deprecated in a future release.

## Graphics<a name="graphics-improvements-changes-v1.15"></a>

The graphics system has the following improvements and changes:
+ The texture streaming pool size is now based on the amount of available GPU memory. Previously the texture streaming pool size was limited by an arbitrary value.
+ Global illumination now works with mesh components and dynamic slices.

## iOS<a name="ios-improvements-changes-v1.15"></a>

GPU-related optimizations for iOS devices were made to return approximately 2-3 ms across the full frame.

## Legacy Tools<a name="legacy-tools-ui-improvements-changes-v1.15"></a>

Lumberyard 1.15 disables the legacy UI for all game projects by default. Previously the legacy UI was disabled only if the CryEntity Removal gem was enabled.

If the legacy UI is already disabled in your game project, you can do one of the following:
+ Open the level to convert or delete any legacy CryEntities that are in the level.
+ Open the level to enable the legacy UI and retain the legacy CryEntities.
**Note**  
The legacy tools in the legacy UI are deprecated and will be removed in a future version of Lumberyard. These tools include the **Database View**, **Flow Graph** editor, **Object Selector**, **Layer Editor**, legacy **Asset Browser**, and the **Rollup Bar**.
+ Enable the legacy UI by doing the following:

  1. Use the **Project Configurator** to disable the **CryEntity Removal** gem for your project. For more information, see [CryEntity Removal Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-cryentity-removal-gem.html) in the *Amazon Lumberyard User Guide*.

  1. In Lumberyard Editor, choose **Edit**, **Editor Settings**, **Global Preferences**.

  1. In the **Preferences** window, under **General Settings**, select **Enable Legacy UI**.

  1. Click **OK**.

## Lumberyard Editor<a name="lumberyard-editor-improvements-changes-v1.15"></a>

Lumberyard Editor has the following improvements and changes:
+ You can now use the following keyboard shortcuts in Lumberyard Editor:
  + **Q** – Move the camera up in the viewport
  + **E** – Move the camera down in the viewport
+ Lumberyard Editor no longer includes the **Tools**, **Scene Settings** menu option.
+ You can now set your viewport camera preferences in the **Preferences** window. This allows you to specify whether the camera should remain in its current position after exiting game mode. You can access this window in Lumberyard Editor by choosing **Edit**, **Editor Settings**, **Global Preferences**. In the **Preferences** window, under **General Settings**, select or clear **Restore Viewport Camera on Game Mode Exit**.
+ The entity count is now included in the information that is displayed in the viewport.

## macOS<a name="macos-improvements-changes-v1.15"></a>

macOS has the following improvements and changes:
+ Lumberyard for macOS now supports the `r_MultiThreaded` console variable. A thread that is separate from the main thread is used for rendering CPU work. The render thread has been updated to a higher priority.
+ Lumberyard for macOS now supports lens flares.
+ GPU-related Metal optimizations were made to return approximately 2-3 ms across the full frame.

## Mobile Support<a name="mobile-improvements-changes-v1.15"></a>

Android and iOS have the following improvements and changes:
+ Lumberyard 1.15 introduces multi-touch support in the UI.
+ Lumberyard for mobile now supports the `r_MultiThreaded` console variable. A thread that is separate from the main thread is used for rendering CPU work. The render thread has been updated to a higher priority.
+ Lumberyard for mobile now supports lens flares.
+ The minimum app size has been reduced. This is a result of moving legacy systems to the CryLegacy gem.

## Networking<a name="networking-system-improvements-changes-v1.15"></a>

The networking system has the following improvements and changes:
+ The GameLiftLocal server can now run on a VM or remote machine.
+ An `EpsilonThrottler` was added for `AZ::Vector` to filter physics simulation noise that is used in the **Transform** component.
+ `AZ::Component:DependencyArrayType` has changed from an `AZStd::fixed_vector` to a dynamic `AZStd::vector`. There are no changes if you were already using `DependencyArrayType` in your code.
+ Nullptr parameter checks were removed from `InternalMultiplayerEvents::Connect`.
+ The Amazon GameLift connection issues when an ultimate client connects have been fixed.

## Particle System<a name="particle-system-improvements-changes-v1.15"></a>

The particle system has the following improvements and changes:
+ You can now use **Camera Non-Facing Fade** settings to fade out particles based on their angle to the camera.
+ You can now use the **Size Z** setting, along with **Size X** and **Size Y**, to scale custom mesh particles.
+ Fur rendering now supports correct transparency order through order-independent transparency (OIT). This allows any number of fur layers to render on top of each other.
+ The Strength Over Particle Life graphs for rotation rate now correctly adjust the rotation speed.
+ The **Copy**, **Paste**, and **Reset to Default** functionality for curves now works.
+ Onscreen debug statistics for fill rate are now calculated. Previously the fill rate always showed as 0.
+ Beam segments are now aligned and no longer missing.
+ Disabled **Velocity XYZ** settings are now ignored on emitter shapes.
+ Properties are no longer erroneously marked as changed (with an orange highlight) if they weren't changed.

## UI Editor<a name="ui-editor-improvements-changes-v1.15"></a>

The UI Editor has the following improvements and changes:
+ The event buses for the UI systems are now exposed to Script Canvas. This allows you to use Script Canvas to script the UI.
+ The **UiMaskComponent** now supports multiple mask visual components. This allows you to move mask visuals without moving the child elements. You can do this by setting the **Child mask element** property in the **UiText** component.

## Miscellaneous<a name="miscellaneous-improvements-changes-v1.15"></a>

You will no longer receive a misleading warning when you spawn entities with Script Canvas assets.