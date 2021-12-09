# Preview Systems and Tools<a name="lumberyard-v1.1-preview-systems"></a>

We are especially interested in getting your feedback on the following features and systems, a preview of which is now available in Lumberyard 1.1. Please [submit feedback on our forums](http://gamedev.amazon.com/forums) or by sending an email to lumberyard-feedback@amazon.com.

**Topics**
+ [Cloud Canvas Resource Manager – Easily manage your AWS resources from Lumberyard Editor](#lumberyard-v1.1-cloud-canvas)
+ [component entity system – Configure and manage game entities](#lumberyard-v1.1-component-entity-system)
+ [FBX Settings – Import meshes quickly and seamlessly](#lumberyard-v1.1-fbx-importer)
+ [Mobile support – Build games for iOS and Android devices](#lumberyard-v1.1-mobile)

## Cloud Canvas Resource Manager – Easily manage your AWS resources from Lumberyard Editor<a name="lumberyard-v1.1-cloud-canvas"></a>

The Cloud Canvas Resource Manager lets you manage AWS resources directly in Lumberyard Editor. You can initialize a Lumberyard project with Cloud Canvas functionality, manage deployments and features, and update the contents of your AWS project using the GUI. Using a simple, text-based interface, you can preview the CloudFormation templates that define the AWS resources for your game.

To try out the Cloud Canvas Resource Manager, edit the `editor.cfg` file (located in the `\lumberyard\dev` directory) and set `enable_cloud_canvas_resource_manager_ui` to 1. Save the configuration file and relaunch Lumberyard Editor. For more information, see [Cloud Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-intro.html).

## component entity system – Configure and manage game entities<a name="lumberyard-v1.1-component-entity-system"></a>

The component entity system provides a flexible and intuitive way to configure and manage game entities. Complex entity behaviors can be constructed by adding individual components. The component entity system employs reflection, serialization, message-passing using the event bus, and the ability to edit component objects in Lumberyard Editor. Added features and functionality include: 
+ Runtime asset management architecture with fully asynchronous loading and safe event-based reference patterns.
+ Suite of engine components: attachments, triggers, audio, cameras, physics, colliders, meshes, lights, particles, decals, lens flares, Lua scripts, AI navigation, and animation.
+ User interfaces for the following: 
  + Entity Inspector for editing live properties.
  + Entity Outliner for searching scenes, viewing hierarchies, and previewing slice and component information.
  + Component Palette with drag-and-drop support to the viewport or Entity Inspector.
  + File Browser with asset drag-and-drop support to the viewport, Entity Inspector, or component asset fields.
  + Contextual menus for creating and managing slices.
+ Slice system for managing hierarchical entity arrangements (cascading prefabs), with support for pushing and pulling changes to any level of the hierarchy.

For more information, see [Component Entity System](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/component_palette.png)

## FBX Settings – Import meshes quickly and seamlessly<a name="lumberyard-v1.1-fbx-importer"></a>

The new FBX Settings enables you to import single static FBX meshes and single materials into Lumberyard. Future releases will add support for skeletons, skinned meshes, animations, material data, and custom data formats. For more information, see [FBX Importer](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-fbx-importer.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/fbx_importer.png)

## Mobile support – Build games for iOS and Android devices<a name="lumberyard-v1.1-mobile"></a>

You can now use Lumberyard to build games for iOS devices using the A8 GPUs, including iPhone 5s, iPhone 6s, iPhone 6s Plus, iPad Air 2, and iPad Pro. In addition, GMEM and Metal enable you to use Lumberyard to create high fidelity visuals using the latest rendering techniques. GMEM brings deferred rendering to iOS, and by using Metal to talk directly to the hardware, you can push more data to the GPU. To build games for iOS, Lumberyard requires Xcode 7 and the iOS v9.0 SDK or later.

Lumberyard also includes support for the Android nVidia Shield, which requires Visual Studio 2015 for debugging and the SDK-19 (Kit Kat) or later.

Lumberyard includes two Android-supported sample projects and four iOS-supported sample projects that you can use to learn how to build assets, build shaders using the Remote Shader Compiler, and build the Lumberyard runtime (Android) or iOS app using the build tools.

For more information, see [Android Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/android-intro.html) or [iOS Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/ios-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/i_Pad_01.jpg)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/i_Pad_03.jpg)