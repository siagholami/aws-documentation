# Lumberyard Release Notes – Beta 1.14 (May 2018)<a name="lumberyard-v1.14"></a>

Lumberyard Beta 1.14 adds over 200 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community, whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-14/).

**Topics**
+ [Highlights](#lumberyard-v1.14-highlights)
+ [Improvements and Changes](lumberyard-v1.14-improvements-changes.md)
+ [Fixes](lumberyard-v1.14-fixes.md)
+ [Known Issues](lumberyard-v1.14-known-issues.md)

## Highlights<a name="lumberyard-v1.14-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.14.

**Topics**
+ [New Components for the Component Entity System](#lumberyard-v1.14-highlights-new-components)
+ [New Script Canvas Features](#lumberyard-v1.14-highlights-script-canvas-features)
+ [Use Morph Targets in the Animation Editor](#lumberyard-v1.14-highlights-animation-editor-morph-targets)
+ [Use Virtual Gamepad Gem to Create Touch Screen Controls](#lumberyard-v1.14-highlights-virtual-gamepad-gem)
+ [New Particle Emitter Component for UI Editor](#lumberyard-v1.14-highlights-ui-editor-particle-emitter-component)
+ [Support for Visual Studio 2017](#lumberyard-v1.14-highlights-visual-studio-2017-support)
+ [New Script Canvas Tutorials](#lumberyard-v1.14-highlights-tutorials)
+ [New Amazon GameLift Features](#lumberyard-v1.14-highlights-amazon-gamelift)
+ [SDK Compatibility](#lumberyard-v1.14-highlights-compatible-sdk-versions)

### New Components for the Component Entity System<a name="lumberyard-v1.14-highlights-new-components"></a>

Lumberyard 1.14 adds the following components:
+ **Wind Volume** – Use this component to create volumes that are affected by wind. Wind can affect vegetation, particles, and physical objects. You can define attributes of the wind volume such as its direction, speed, resistance, and density.  
![\[Example image of the Wind Volume component\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-component-wind-volume-trees.png)
+ **Sky Cloud** – Use this component to create realistic and detailed cloud effects. You can create clouds with either simple, sprite-based shading, or more complex, voxelized 3D volume shading. You can randomly generate common and volumetric clouds in controlled areas, control where clouds generate, and define the area in which clouds can move.  
![\[Example image of the Sky Cloud component\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-gems-system-gem-clouds.png)
+ **Force Volume** – Use this component to apply physical force to objects within a volume. A force will be applied each frame to any object within the bounds of the volume. You can specify the following force types: linear damping, simple drag, local space, spline follow, world space, and point.  
![\[Example image of the Force Volume component\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-component-force-volume-example.png)
+ **Tube Shape** – Use this component to create a tube-like volume along a spline shape. To create a tube shape, you use a **Spline** component to define its volume and specify a radius. You can specify a different radius of the tube at each point in the spline.  
![\[Example image of the Tube Shape component\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-component-tube-shape-example.png)

For more information, see the [Component Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html) in the *Amazon Lumberyard User Guide*.

### New Script Canvas Features<a name="lumberyard-v1.14-highlights-script-canvas-features"></a>

With Script Canvas you can script game logic and behaviors using the component entity system. Script Canvas offers an approachable and easy-to-read environment to author behaviors that use the same framework as Lua and C\+\+. Script Canvas is built to take advantage of the modularity, performance, and flexibility of the component entity system.

Lumberyard 1.14 adds the following Script Canvas features:
+ **Variable Manager** – Use the **Variable Manager** pane to create and manage variables for supported variable types, create get or set variable nodes, and add variables to your Script Canvas graph to declare and initialize them. For more information, see [Managing Script Canvas Variables](https://docs.aws.amazon.com/lumberyard/latest/userguide/script-canvas-managing-variables.html).
+ **Bookmarks** – Add a shortcut to a specific location on your Script Canvas graph. You can then use the **Bookmarks** pane or keyboard shortcuts to move quickly to that location. For more information, see [Adding Bookmarks for Script Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/script-canvas-bookmarks.html).
+ **Batch Conversion Tool** – Use the batch conversion tool to convert all `.scriptcanvas` files that are located in a specified directory and its child directories. For more information, see [Converting Script Canvas Scripts](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-migrating-1-14.html).
+ **Ray Cast Nodes** – Use the ray casting nodes to cast rays between entities and positions in 3D space.

### Use Morph Targets in the Animation Editor<a name="lumberyard-v1.14-highlights-animation-editor-morph-targets"></a>

The EMotion FX Animation Editor helps artists build and animate complex character behavior. The Animation Editor includes visual tools to set up hierarchical state machines, logic, and advanced hierarchical blend trees.

Lumberyard 1.14 adds support for morph targets. A morph target is a deformed mesh that is stored as a series of vertex positions. You can use morph targets to deform a character's face to animate facial expressions or a character's body part to correct undesired deformation of skinning. You can also simulate deformation of clothing on a character.

In the Animation Editor, you can use morph targets by adding one of the following nodes:
+ **Motion** node – Plays morph target animations similar to skeletal animations.
+ **Morph Target** node – Animates morph targets by changing the weight at runtime.

![\[Example image of the morph targets feature\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/hopeMorphTargetsGIFE.gif)

For more information, see [Animation Editor (EMotionFX)](https://docs.aws.amazon.com/lumberyard/latest/userguide/animation-editor-introduction.html) in the *Amazon Lumberyard User Guide*.

### Use Virtual Gamepad Gem to Create Touch Screen Controls<a name="lumberyard-v1.14-highlights-virtual-gamepad-gem"></a>

Use the Virtual Gamepad gem to provide your game's UI with touch screen capabilities on mobile devices. After you enable the Virtual Gamepad gem, you can add the virtual gamepad components to your game's UI in the UI Editor. For more information, see [Virtual Gamepad Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-virtualgamepad.html) in the *Amazon Lumberyard User Guide*.

![\[Example image of the Virtual Gamepad gem\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-gems-system-gem-virtualgamepad-1.png)

### New Particle Emitter Component for UI Editor<a name="lumberyard-v1.14-highlights-ui-editor-particle-emitter-component"></a>

UI components define the properties of a UI element. The **Particle Emitter** component is a new UI component that you can use to emit 2D particles from an element. To see in-game examples of completed canvases with a **Particle Emitter** component, open the UiFeatures level in the SamplesProject project. Enter game mode and then choose **Components**, **Visual Components**, **Particle Emitter**. You can view particle emitter examples that create a variety of spark effects and trail effects.

For more information, see [Visual Components – Particle Emitter](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-components-visual.html#ui-editor-components-visual-particle-emitter) and [UIParticleEmitterComponent](https://docs.aws.amazon.com/lumberyard/latest/userguide/lua-scripting-ces-api-ui-uiparticleemittercomponent.html) in the *Amazon Lumberyard User Guide*.

### Support for Visual Studio 2017<a name="lumberyard-v1.14-highlights-visual-studio-2017-support"></a>

Lumberyard 1.14 adds support for Visual Studio 2017. Beginning with Visual Studio 2017, Microsoft now releases updates on a more frequent cadence (in some cases weekly). Lumberyard is tested with the latest version of Visual Studio available during the release cycle.

You can use the Lumberyard Setup Assistant to configure Visual Studio 2017, Visual Studio 2015, or both versions. You must select at least one version in order to install the appropriate Visual Studio redistributables. Waf generates a Visual Studio solution that you can manage with the `user_settings.options` file (located in the `\dev\_WAF_` directory). The Visual Studio version field in this file is automatically updated with the version that you install. If you install both versions, the file uses Visual Studio 2015 as the default value.

For more information, see [System Requirements](https://docs.aws.amazon.com/lumberyard/latest/userguide/setting-up-system-requirements.html) and [Running Lumberyard Setup Assistant](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-launcher-using.html) in the *Amazon Lumberyard User Guide*.

### New Script Canvas Tutorials<a name="lumberyard-v1.14-highlights-tutorials"></a>

You can use the following video tutorials to learn how to use the Lumberyard visual scripting system for your game project.

#### Script Canvas Tank Demo (ep01) – An Amazon Lumberyard Script Canvas Tour<a name="lumberyard-v1.14-highlights-tutorials-script-canvas-tank-demo"></a>

#### Script Canvas Tank Demo (ep02) – Organizing and Navigating your Script Canvas Graphs with Bookmarks and Comments<a name="lumberyard-v1.14-highlights-tutorials-script-canvas-bookmarks-comments"></a>

#### Script Canvas Tank Demo (ep03) – How to Bind Tank Movement Controls in Script Canvas<a name="lumberyard-v1.14-highlights-tutorials-script-canvas-bind-tank-movement-controls"></a>

#### Script Canvas Tank Demo (ep04) – Adding Tank Shooting Mechanics in Script Canvas<a name="lumberyard-v1.14-highlights-tutorials-script-canvas-tank-shooting-mechanics"></a>

#### Script Canvas Tank Demo (ep05) – Attaching a Camera and Creating Explosive Targets in Script Canvas<a name="lumberyard-v1.14-highlights-tutorials-script-canvas-tank-camera-explosive-targets"></a>

### New Amazon GameLift Features<a name="lumberyard-v1.14-highlights-amazon-gamelift"></a>

Stay up to date with the latest release information at [AWS Release Notes for Amazon GameLift](https://aws.amazon.com/releasenotes/Amazon-GameLift?browse=1).

### SDK Compatibility<a name="lumberyard-v1.14-highlights-compatible-sdk-versions"></a>

Lumberyard 1.14 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.1.13
+ Amazon GameLift Server SDK version 3.1.5