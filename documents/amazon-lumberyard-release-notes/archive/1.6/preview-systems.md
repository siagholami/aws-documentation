# Preview Systems and Tools<a name="lumberyard-v1.6-preview-systems"></a>

The following systems are a preview of new features on which we are especially interested in feedback. Please [submit feedback on our forums](http://gamedev.amazon.com/forums) or by sending an email to lumberyard-feedback@amazon.com.

**Topics**
+ [FBX Settings – UV Selection for Static Meshes](#lumberyard-v1.6-preview-system-fbx-importer)
+ [Mobile Support – Build Games for iOS and Android Devices](#lumberyard-v1.6-preview-system-mobile)
+ [macOS Support – Use Metal for Rendering](#lumberyard-v1.6-preview-system-osx)
+ [New UI Editor Components and Features](#lumberyard-v1.6-preview-system-ui-system)

## FBX Settings – UV Selection for Static Meshes<a name="lumberyard-v1.6-preview-system-fbx-importer"></a>

Lumberyard 1.6 adds the following features for the FBX Settings:
+ The ability to choose which UV map to use in the **Mesh (Advanced)** rule for static meshes.
+ The ability to generate material library files (MTL) that do not lose the data added by the Material Editor.
+ A stack-based log content system that allows you to add scoped context objects using the `AZ_TraceContext` macro in your code. This prints the key-value pairs if an error, warning, or assert is triggered with all stack context values that are still in scope.

For more information, see [Working with the FBX Settings](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-fbx-importer.html).

## Mobile Support – Build Games for iOS and Android Devices<a name="lumberyard-v1.6-preview-system-mobile"></a>

You can use Lumberyard to build games for iOS devices (iPhone 5s, iPhone 6s, iPhone 6s Plus, iPad Air 2, and iPad Pro) and Android devices (Nvidia Shield, Samsung Galaxy Note 5, and Motorola Nexus 6). Added features include:
+ Support on iOS for computer shaders. For example, down-sampling and sun shafts use computer shaders.
+ Support for OpenGL ES 3.0 and fixed-point rendering pass to allow your game to run on devices that don't support floating point render targets.
+ Support for Android N.
+ An In-App Purchasing Gem that provides support for iOS and Android app stores. Supported types of purchase include consumables, non-consumables, and subscriptions.

For more information, see [Mobile Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/mobile-support-intro.html).

## macOS Support – Use Metal for Rendering<a name="lumberyard-v1.6-preview-system-osx"></a>

Initial support for using Metal as the rendering API has been added. To use the metal renderer, you must update the `r_driver` option in the `system_osx_pc.cfg` file to set the value to **Metal**. If you use monolithic builds, you must also update the `user_settings.options` file to set the `mac_build_renderer` option to **Metal**. For more information, see [macOS Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/osx-intro.html).

## New UI Editor Components and Features<a name="lumberyard-v1.6-preview-system-ui-system"></a>

The UI Editor allows you to build, visualize, and customize user interface elements such as menus, buttons, and the heads-up display (HUD). Added components and features include:
+ The **ScrollBar** component allows you to add scroll bars to scroll boxes and other custom components.
+ The **Text** component supports markup so that a single text string can contain changes in font, style, and color.
+ Component entities can now automatically load UI canvases when the level starts.
+ Canvases can now be placed on 3D meshes in a level, with interaction supported by using ray casts.
+ The snap-to-grid feature enables values to snap to user-defined spacings when moving or rotating elements.
+ The related fonts for normal, bold, and italic can now be grouped as a font family.

For more information, see [UI System](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-intro.html).