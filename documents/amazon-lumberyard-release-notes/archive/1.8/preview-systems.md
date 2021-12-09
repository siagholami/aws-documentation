# Preview Systems and Tools<a name="lumberyard-v1.8-preview-systems"></a>

The following systems are a preview of new features on which we are especially interested in feedback. Please [submit feedback on our forums](http://gamedev.amazon.com/forums) or by sending an email to lumberyard-feedback@amazon.com.

**Topics**
+ [Mobile Support – Access Native Features with JNI Pointer Types](#lumberyard-v1.8-preview-system-mobile-support)
+ [macOS Support – Asset Processor Now Supported](#lumberyard-v1.8-preview-system-macOS)
+ [Support for Dynamic Content in UI Editor Components](#lumberyard-v1.8-preview-system-ui-system)

## Mobile Support – Access Native Features with JNI Pointer Types<a name="lumberyard-v1.8-preview-system-mobile-support"></a>

You can use Lumberyard to build games for iOS devices (iPhone 5s, iPhone 6s, iPhone 6s Plus, iPad Air 2, and iPad Pro) and Android devices (Nvidia Shield, Samsung Galaxy Note 5, Samsung Galaxy S7, and Motorola Nexus 6).

Lumberyard 1.8 adds support for JNI pointer types to be used with new, smart pointer-like objects for Android. An example of the smart pointer-like object is `AZ::Android::JNI::shared_ref and AZ::Android::JNI::scoped_ref`.

This added functionality allows you to access native features without having to manage memory for any objects that are created. For information about developing Lumberyard games for Android or iOS, see [Mobile Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/mobile-support-intro.html).

## macOS Support – Asset Processor Now Supported<a name="lumberyard-v1.8-preview-system-macOS"></a>

macOS now supports the Asset Processor, allowing you to build assets for your iOS, Android, and macOS games directly on your Mac computer. Previously a PC was required to build assets for these operating systems. For information, see [Building Game Assets for macOS Games](https://docs.aws.amazon.com/lumberyard/latest/userguide/osx-assets-building.html).

## Support for Dynamic Content in UI Editor Components<a name="lumberyard-v1.8-preview-system-ui-system"></a>

Use the UI Editor to build, visualize, and customize user interface elements such as menus, buttons, and the heads-up display (HUD). Lumberyard 1.8 adds support for dynamic content in the **ScrollBox** component and **Layout** component. This is helpful if you want to design user interfaces but have not yet identified the number of entries and the data in a list at the time of design. For more information, see [UI System](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-intro.html).