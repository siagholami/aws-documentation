# Preview Systems and Tools<a name="lumberyard-v1.2-preview-systems"></a>

We are especially interested in your feedback on the following systems, which are a preview of new functionality. Please [submit feedback on our forums](http://gamedev.amazon.com/forums) or by sending an email to lumberyard-feedback@amazon.com.

**Topics**
+ [Mobile Support – Build games for iOS and Android devices](#lumberyard-v1.2-preview-mobile)
+ [Network Binding for Components – Create components that can be bound and synchronized over the network](#lumberyard-v1.2-preview-networking)
+ [Particle Editor – Create more detailed particle effects with lower performance impact](#lumberyard-v1.2-preview-particle-editor)
+ [UI Animation System – Animate properties on UI components](#lumberyard-v1.2-preview-ui-editor)

## Mobile Support – Build games for iOS and Android devices<a name="lumberyard-v1.2-preview-mobile"></a>

You can use Lumberyard to build games for iOS devices (iPhone 5s, iPhone 6s, iPhone 6s Plus, iPad Air 2, and iPad Pro) and Android devices (Nvidia Shield, Samsung Galaxy Note 5, and Motorola Nexus 6). Added features and functionality include: 
+ A FeatureTests sample project (located in the `\lumberyard\dev\FeatureTests` directory) that demonstrates a variety of rendering and touch input features. You can use this sample project to learn how to apply these features to your applications.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/feature_tests.jpg)
+ Configuration variables to restrict render target resolutions so you can adjust the resolution and increase frame rates as needed.
+ Process life management support so your applications can handle operating system messages (for example, phone calls, low power, minimize, and maximize).
+ Ability to pack Android asset files into the APK so you can distribute your applications to other users.
+ Mac OS X version of the Asset Processor, which enables VFS support and allows for faster iteration times during development and testing of your applications.

For more information, see [Android Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/android-intro.html) and [iOS Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/ios-intro.html).

## Network Binding for Components – Create components that can be bound and synchronized over the network<a name="lumberyard-v1.2-preview-networking"></a>

The network binding framework simplifies the process to bind and unbind components to the network. 
+ Implement the NetBindable interface for components that require network synchronization.
+ Add the NetBindingComponent to enable network synchronization for an entity.
+ The NetBindingComponent and NetBindable interface interacts on the entity to create and bind them to the replica chunks.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/network_component.png)

## Particle Editor – Create more detailed particle effects with lower performance impact<a name="lumberyard-v1.2-preview-particle-editor"></a>

The Particle Effects system allows you to create and simulate visual effects such as explosions, fire, and sparks. This advanced system includes playback controls, a gradient editor, a color picker, and color libraries. Added features and functionality include: 
+ Multiple library support for the Particle Editor, including the ability to load, view, search, and modify multiple particle libraries at once. This allows you to easily manage groups of effects in one location.
+ GPU particle rendering, which enables particles to be simulated on the GPU and allows you to spawn more particles than the CPU type. You can create particle effects with more detail without a large performance hit. GPU particles also respect intra-emitter sorting for greater visual quality interactions with each other and the environment.

  The following screenshot shows 7500 particle count in GPU (top) compared to CPU (bottom):  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/GPUvsCPU_7500.png)

For more information, see [Particle Effects System](https://docs.aws.amazon.com/lumberyard/latest/userguide/particle-intro.html).

## UI Animation System – Animate properties on UI components<a name="lumberyard-v1.2-preview-ui-editor"></a>

The UI Animation system allows you to animate certain properties on UI components, including custom UI components. You can access the **UI Animation** window from the **View** menu in the UI Editor. The UI Animation interface is similar to the **Track View** editor, with keyframe animation and track and curve editors. You can save animations with the UI canvas and play them using flow graph or C\+\+.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/ui_animation.png)

Added features and functionality include: 
+ Checkbox UI component and prefab, which allows you to author check box controls in UI canvases. You can also customize the background and on/off graphics.
+ Slider UI component and prefab, which allows you to author slider controls in UI canvases. Sliders work at any orientation, and you can customize the background, track, fill, and manipulator graphics.
+ Ability to specify a reference canvas size in the UI Editor, and support for zoom and pan functionality. The toolbar now provides a list of common device resolutions. You can add resolution presets to this list using a JSON file, or set custom resolutions in the UI Editor.

For more information, see [UI System](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-intro.html).