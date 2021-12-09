# Improvements and Changes<a name="lumberyard-v1.14-improvements-changes"></a>

Lumberyard Beta 1.14 provides improvements and changes to Lumberyard systems and functionality. Choose a topic area to learn more.

**Topics**
+ [Android](#android-improvements-changes-v1.14)
+ [Animation Editor](#animation-editor-improvements-changes-v1.14)
+ [Audio](#audio-improvements-changes-v1.14)
+ [Component Entity System](#component-entity-system-improvements-changes-v1.14)
+ [iOS](#ios-improvements-changes-v1.14)
+ [Lumberyard Editor](#lumberyard-editor-improvements-changes-v1.14)
+ [Mobile Support](#mobile-improvements-changes-v1.14)
+ [Script Canvas](#script-canvas-improvements-changes-v1.14)
+ [Visual Studio Support](#visual-studio-support-improvements-changes-v1.14)

## Android<a name="android-improvements-changes-v1.14"></a>

Android has the following improvements and changes:
+ The In-App Purchases demo now uses Script Canvas.
+ The In-App Purchases gem now uses the Google Billing library. The Waf build system downloads this library from the Google Maven repository. You must have Build Tools 23.x or newer to use this feature.
+ The Waf build system now supports AAR files from the Google Maven repository.
+ Lumberyard 1.14 introduces support for the following OpenGL extensions: Framebuffer Fetch and Pixel Local Storage. This helps to increase the rendering speed on devices that support the extensions.

## Animation Editor<a name="animation-editor-improvements-changes-v1.14"></a>

The Animation Editor has the following improvements and changes:
+ A node was added to output a constant float value. You can use this node to output a static value to an input without creating a new parameter.
+ The following outdated preferences were removed:
  + Unit setup window
  + Texture settings in the render plugin preferences
  + Visualization scale in the animation graph plugin

## Audio<a name="audio-improvements-changes-v1.14"></a>

The audio system has the following improvements and changes:
+ You can no longer use the `s_AudioSystemImplementationName` console variable to change the audio system implementation at runtime. You must set this console variable in a configuration file.
+ Support for Wwise SDK version 2015 or earlier is now deprecated. Code that supports these deprecated versions will be removed from future versions of Lumberyard.

## Component Entity System<a name="component-entity-system-improvements-changes-v1.14"></a>

The component entity system has the following improvements and changes:
+ Shape components now have a **Game View** toggle. When enabled, shapes remain visible in game mode. You can use this feature to test trigger volumes, wind volumes, force volumes, and other behaviors that are attached to a shape volume.
+ You can now select entities with shape components from the viewport. To do so, click anywhere within the shape volume. Previously you were required to click the center of a shape volume to select the entity.
+ The CryEntity Converter can convert additional legacy components to the new component entities that were released in Lumberyard 1.14.

## iOS<a name="ios-improvements-changes-v1.14"></a>

Lumberyard 1.14 introduces general performance improvements for developing iOS games.

## Lumberyard Editor<a name="lumberyard-editor-improvements-changes-v1.14"></a>

Lumberyard Editor has the following improvements and changes:
+ Materials that use the **Illum** shader now have improved cheap lighting that takes into consideration the position of the sun. This also creates a properly darker atmosphere at night.
+ Transparent materials that use the **Illum** shader now have a full lighting pass for all objects that use the material. To use this feature, select the **Dynamic Lighting for Transparency** check box under **Shader Generation Params** in the **Material Editor**.
+ You can now use one mouse button (held forward or backward) to move the debug camera.
+ You can now configure the `r_displayInfo` console variable to hide debug camera text.
+ You can now search the settings in the **Global Preferences** window. To access this window in Lumberyard Editor, choose **Edit**, **Editor Settings**, **Global Preferences**.

## Mobile Support<a name="mobile-improvements-changes-v1.14"></a>

Lumberyard 1.14 introduces multi-touch support in the UI.

## Script Canvas<a name="script-canvas-improvements-changes-v1.14"></a>

Script Canvas has the following improvements and changes:
+ Script Canvas now includes the following nodes:
  + **String to Float**
  + **Get Forward**
  + **Get Right**
  + **Get Up**
  + **Print**
  + **Build String**
+ The **Log** node is now deprecated. You can use the **Print** node instead.
+ You can now use profiling tags for performance captures.
+ The save format for Script Canvas has been optimized. This results in file size reductions of Script Canvas assets.
+ The Asset Processor now loads Script Canvas assets. This allows errors to be reported for the assets.
+ You can now open Script Canvas assets from the **Asset Browser**.
+ Script Canvas graphs are now referenced by assets in slices. This prevents slices from being bloated.
+ The **Script Canvas** editor can now render thousands of nodes due to an improvement in the rendering efficiency.
+ Categorization of the **Math** nodes has been fixed.
+ The **Node Palette** now includes new icons.
+ Support has been added for hot loading of style sheets.
+ You can dynamically splice nodes into existing connections by hovering over them for a few seconds.
+ The **Math** library is now more robust and intuitive to use.
+ You can now expose variable properties and values under the assigned Script Canvas component in the **Entity Inspector**.

## Visual Studio Support<a name="visual-studio-support-improvements-changes-v1.14"></a>

Lumberyard has the following changes for Visual Studio support:
+ Visual Studio 2017 version 15.6.6 is now supported.
+ Support for Visual Studio 2013 is now deprecated.

For more information, see the [Highlights](lumberyard-v1.14.md#lumberyard-v1.14-highlights) section of the Lumberyard 1.14 release notes.