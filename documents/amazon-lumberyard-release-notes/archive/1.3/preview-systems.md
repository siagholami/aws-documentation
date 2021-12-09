# Preview Systems and Tools<a name="lumberyard-v1.3-preview-systems"></a>

The following systems are a preview of new features that we are especially interested in getting your feedback on. Please [submit feedback on our forums](http://gamedev.amazon.com/forums) or by sending an email to lumberyard-feedback@amazon.com.

**Topics**
+ [Mobile support – Build games for iOS and Android devices](#lumberyard-v1.3-preview-mobile)
+ [OS X support – Build games for Mac computers](#lumberyard-v1.3-preview-osx)
+ [New UI Editor components](#lumberyard-v1.3-preview-ui-editor)

## Mobile support – Build games for iOS and Android devices<a name="lumberyard-v1.3-preview-mobile"></a>

You can use Lumberyard to build games for iOS devices (iPhone 5s, iPhone 6s, iPhone 6s Plus, iPad Air 2, and iPad Pro) and Android devices (Nvidia Shield, Samsung Galaxy Note 5, and Motorola Nexus 6). Added features and functionality include: 
+ The ability to display virtual thumbsticks when using the FeatureTests sample on all mobile devices.
+ Store deployment tools for Android. You can now create an application to submit to the App Store, including overriding the default app icon, splash screen, orientation, and package name.

For more information, see [Android Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/android-intro.html).

## OS X support – Build games for Mac computers<a name="lumberyard-v1.3-preview-osx"></a>

You can now use Lumberyard to build games for OS X. To build games for OS X, Lumberyard requires Xcode 7 and OS X Yosemite or OS X El Capitan. Lumberyard includes four OS X-supported sample projects that you can use to learn how to build assets, build shaders using the Remote Shader Compiler, and build the OS X app using the build tools. For more information, see [OS X Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/osx-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/osx-lumberyard.jpg)

## New UI Editor components<a name="lumberyard-v1.3-preview-ui-editor"></a>

The UI Editor allows you to build, visualize, and customize user interface elements such as menus, buttons, and the heads-up display (HUD). Added components include: 
+ The **Mask** component allows a UI element to hide the area of a child element that is outside a mask. You can define the mask as the elements rectangle or by using the alpha channel of a texture.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/uiMask.jpg)
+ The **ScrollBox** component allows you to author scroll boxes. Child elements can then be scrolled by user interaction. You can use the **ScrollBox** component in conjunction with the **Mask** component to hide the area of a content element that is outside the scroll box. Scroll boxes and sliders can also include other elements to interact with.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/uiScrollBox_edit3.gif)

For more information, see [UI System](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-intro.html).