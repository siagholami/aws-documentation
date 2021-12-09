# Preview Systems and Tools<a name="lumberyard-v1.4-preview-systems"></a>

The following systems are a preview of new features on which we are especially interested in feedback. Please [submit feedback on our forums](http://gamedev.amazon.com/forums) or by sending an email to lumberyard-feedback@amazon.com.

**Topics**
+ [FBX Importer – Physics Mesh Support](#lumberyard-v1.4-preview-fbx-importer)
+ [Mobile Support – Android Studio and Compute Shaders on iOS](#lumberyard-v1.4-preview-mobile)
+ [Networking – Profiler Tool Gathers Usage Statistics](#lumberyard-v1.4-preview-networking)
+ [Component Entity System – New Components](#lumberyard-v1.4-preview-component-entity)
+ [Lua IDE – Lua Editor and Debugger Tools](#lumberyard-v1.4-preview-lua-ide)

## FBX Importer – Physics Mesh Support<a name="lumberyard-v1.4-preview-fbx-importer"></a>

Lumberyard Beta 1.4 provides the ability to add a physics proxy rule when you import a `.cgf` file from the FBX Settings. You can select a mesh from the file to use as a collision mesh for the generated `.cgf` file. Currently only merged meshes are supported. For more information, see [Working with the FBX Settings](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-fbx-importer.html).

## Mobile Support – Android Studio and Compute Shaders on iOS<a name="lumberyard-v1.4-preview-mobile"></a>

Lumberyard Beta 1.4 adds the following preview features for mobile support: 
+ Ability to generate Android Studio projects using the lmbr\_waf command line tool so that you can use Android Studio on Windows or Mac to build and debug Android devices.
+ Support for reduced resolution rendering for Android, similar to iOS, as an optimization to the renderer.
+ Support for compute shaders on iOS in Metal so you can write compute shaders and execute them on iOS.

For more information, see [Mobile Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/mobile-support-intro.html).

## Networking – Profiler Tool Gathers Usage Statistics<a name="lumberyard-v1.4-preview-networking"></a>

Lumberyard Beta 1.4 introduces the following networking updates: 
+ The GameLift SDK has been updated to version 3.0.6, which allows multiple server processes to run on the same EC2 instance.
+ The **Profiler** tool gathers usage statistics and provides a high level overview of collected data in a single graph. With this tool you can search for anomalies across a body of data or filter down to specific threads to isolate particular systems. Collected data includes how long particular sections of code were executing, the number of times the code was executed, and who called the method. Please check back for a link to the technical documentation in the *Amazon Lumberyard User Guide*.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/profiler-tool.png)

## Component Entity System – New Components<a name="lumberyard-v1.4-preview-component-entity"></a>

Lumberyard Beta 1.4 adds the following components to the component entity system: 
+ Mannequin and Mannequin scope – Allows an entity to be animated by the Mannequin system.
+ Spawner – Facilitates spawning of a `*.dynamicslice` file (selected at design time or provided at run time) at an entity's location with an optional offset.
+ Input – Creates input bindings from the file browser.
+ Simple state – Allows you to activate and deactivate component entities.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/components-r6.png)

For more information, see [Component Entity System](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-intro.html) in the *Amazon Lumberyard User Guide* and [Component Entity System](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-system-intro.html) in the *Amazon Lumberyard User Guide*.

## Lua IDE – Lua Editor and Debugger Tools<a name="lumberyard-v1.4-preview-lua-ide"></a>

The Lua editor/debugger is an integrated development environment (IDE) that supports Lua script authoring and debugging. Its functionality and design is comparable to Microsoft Visual Studio, and it can be used to create or extend games using Lua. The Lua IDE supports legacy and AZ Lua scripts. For more information, see [Lua Scripting](https://docs.aws.amazon.com/lumberyard/latest/userguide/lua-scripting-intro.html).