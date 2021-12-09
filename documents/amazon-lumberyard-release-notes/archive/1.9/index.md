# Lumberyard Release Notes – Beta 1.9 (April 2017)<a name="lumberyard-v1.9"></a>

Lumberyard Beta 1.9 adds new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our developer community. Without your participation in the forums, your messages, and your bug reports, Lumberyard 1.9 wouldn't be as strong as it is. Keep sending your feedback to lumberyard-feedback@amazon.com. If you haven't spoken up in the [forums](https://forums.awsgametech.com/) yet, we would love to have you. You can also keep up with new changes by following [our blog](https://aws.amazon.com/blogs/gametech/now-available-lumberyard-beta-1-9/) and leave comments to let us know what you think.

**Topics**
+ [Highlights](#lumberyard-v1.9-highlights)
+ [Improvements and Changes](lumberyard-v1.9-changes.md)
+ [Fixes](lumberyard-v1.9-fixes.md)
+ [Known Issues](lumberyard-v1.9-known-issues.md)

## Highlights<a name="lumberyard-v1.9-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.9.

**Topics**
+ [Choose an Express or Custom Lumberyard Installation](#lumberyard-v1.9-highlights-setup-assistant)
+ [Rate Lumberyard and Provide Feedback](#lumberyard-v1.9-highlights-feedback-tool)
+ [Starter Game Sample](#lumberyard-v1.9-highlights-starter-game-level)
+ [Cloud Canvas Updates: Cloud Gem Player Account and AWS SDK Upgrade Script](#lumberyard-v1.9-highlights-cloud-canvas)
+ [New Features and Improvements for the Particle Editor](#lumberyard-v1.9-highlights-particle-editor)
+ [SpeedTree 8 Comes to Lumberyard](#lumberyard-v1.9-highlights-speedtree-lumberyard)
+ [Blend Layer Updates](#lumberyard-v1.9-highlights-blend-layer)
+ [Test Code Changes with Amazon GameLift Local](#lumberyard-v1.9-highlights-amazon-gamelift)
+ [New Virtual Reality Features](#lumberyard-v1.9-highlights-virtual-reality)
+ [Added Support for Features in the UI System](#lumberyard-v1.9-highlights-ui-system)
+ [Physically Based Shading (PBS) Reference Material Gem](#lumberyard-v1.9-highlights-physically-based-shading-gem)
+ [New Comment Component](#lumberyard-v1.9-highlights-comment-component)

### Choose an Express or Custom Lumberyard Installation<a name="lumberyard-v1.9-highlights-setup-assistant"></a>

When you launch the Lumberyard Setup Assistant, you are offered a choice between an express or custom installation. The express option installs only the required software so that you can quickly launch Lumberyard Editor. Choosing the custom option goes through the original setup experience so that you can install third-party software and SDKs.

If you have a modified setup, you may not see the installation options. For example, the options are not presented if you have selected capabilities that require SDKs or if you do not have a Visual Studio version selected. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/setup_assistant_welcome_screen.png)

### Rate Lumberyard and Provide Feedback<a name="lumberyard-v1.9-highlights-feedback-tool"></a>

We love hearing from our customers, so we've made it easier for you to rate Lumberyard and provide feedback to the Lumberyard team. An in-editor feedback feature allows you to submit your rating and feedback after a few days of using the editor and tools.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/editor_feedback_tool.png)

### Starter Game Sample<a name="lumberyard-v1.9-highlights-starter-game-level"></a>

The **Starter Game** sample allows you to see how Lumberyard systems are used together to make a game. **Starter Game** is a small, third-person game that is built with the Lumberyard component entity system. In addition to component entities, **Starter Game** demonstrates bipedal locomotion, voxel-based global illumination, the time of day system, and more. In this sample, you play as Jack, a robot that has crashed on a distant planet. Jack can explore the world and must defend himself against enemy robots that occupy the planet. You can use Jack or any other assets in the **Starter Game** sample to prototype your own projects. For more information, see [Starter Game Sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-level-starter-game.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/starter-game-1.jpg)

### Cloud Canvas Updates: Cloud Gem Player Account and AWS SDK Upgrade Script<a name="lumberyard-v1.9-highlights-cloud-canvas"></a>

Lumberyard Beta 1.9 introduces the following updates for Cloud Canvas:
+ The **Cloud Gem Player Account** provides a standalone player authentication and management solution that you can customize. For example, you might require a game key when players register or need to store additional metadata for players. You can require a game key by using Amazon Cognito's presignup Lambda trigger, implementing the validation in the Lambda function, and passing the game key along with the signup request.
+ Lumberyard has added an upgrade script that you can use to customize the version or services of the AWS Native SDK that you are using. You can also use the upgrade script to install prebuilds of all services that are included with Lumberyard. Access the upgrade script in the `\Tools\AWSNativeSDK\Upgrader\Upgrade.py` directory.

A couple things to note:
+ If you are changing a version, you must also update the version in the `SetupAssistantConfig.json` file (located in the `\dev` directory).
+ If you are adding services, you must also add the services in the `aws_native_sdk_shared.json` and `aws_native_sdk_static.json` files (located in the `\dev\_WAF_\3rdParty` directory).

For more information, see [Cloud Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-intro.html).

### New Features and Improvements for the Particle Editor<a name="lumberyard-v1.9-highlights-particle-editor"></a>

The **Particle Editor** for Lumberyard Beta 1.9 introduces dozens of new features, usability improvements, and OS support that enable you to create stunning visual effects for your game. This includes the following:
+ Reconfigurable emitter hierarchies
+ GPU features
+ Five new emitter types

Lumberyard is deeply integrated with AAA to small studio teams. As a result, our roadmap is guided by working with our customers. The **Particle Editor** is a prime example of the constant communication and feedback from these customer relationships.

For more information, see [Particle Effects System](https://docs.aws.amazon.com/lumberyard/latest/userguide/particle-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/particles.gif)

### SpeedTree 8 Comes to Lumberyard<a name="lumberyard-v1.9-highlights-speedtree-lumberyard"></a>

SpeedTree 8 for Lumberyard is a procedural vegetation modeling program that takes advantage of the native Lumberyard vegetation tools. You can use SpeedTree 8 for Lumberyard to create and quickly iterate on trees, bushes, exotic alien foliage species, and other plant life. The SpeedTree modeler provides a simple workflow to generate complex foliage and export directly to Lumberyard, allowing you to create faster than ever.

You can download the full-feature version of SpeedTree 8 for Lumberyard [here](https://store.speedtree.com/product/speedtree-for-lumberyard).

For more information, see [Using SpeedTree 8 for Lumberyard](https://docs.aws.amazon.com/lumberyard/latest/userguide/vegetation-speedtree-lumberyard-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-speed-tree-example-animation.gif)

### Blend Layer Updates<a name="lumberyard-v1.9-highlights-blend-layer"></a>

Blend layer 2 now has RGB specular color and a smoothness slider.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-blend-layer-example.png)

### Test Code Changes with Amazon GameLift Local<a name="lumberyard-v1.9-highlights-amazon-gamelift"></a>

This client-side debugging tool emulates a test set of the Amazon GameLift API on your local development machine. It lets you test iterative code changes without needing to upload and run your game server on Amazon GameLift instances. You can use Amazon GameLift Local on Windows and Linux devices to test game clients and servers that use the Amazon GameLift SDKs. Amazon GameLift Local is available in the Server SDK download. For more information, see [Testing Your Integration](https://docs.aws.amazon.com/gamelift/latest/developerguide/integration-testing-local.html).

### New Virtual Reality Features<a name="lumberyard-v1.9-highlights-virtual-reality"></a>

Lumberyard Beta 1.9 adds the following features for virtual reality:
+ The **Virtual Reality Project** sample now includes the following Lua scripts:
  + `teleport` – Uses the left or right controllers and an input event in order to handle teleporting.
  + `controller` – Modifies the transform for the attached entities. This is accomplished by using the transform of the left or right motion controller that is relative to the attached camera.
  + `raycast` – Uses terrain or navigation mesh to perform a ray cast and returns the cast location.
  + `instantvr` – Drives the logic that is used in the instantVR slice.
+ An instantVR slice provides a starting point for you to build VR projects with controller tracking, teleport functionality, and the ability to generate a navigation area.
+ A **VR Islands** level demonstrates how to create and customize a level with the instantVR slice.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/sample-level-vr-islands-4.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/sample-level-vr-islands-1.png)

For more information, see [Virtual Reality](https://docs.aws.amazon.com/lumberyard/latest/userguide/virtual-reality.html) and [VR Islands Level](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-level-vr-islands.html).

### Added Support for Features in the UI System<a name="lumberyard-v1.9-highlights-ui-system"></a>

With the **UI Editor** you can build, visualize, and customize user interface elements such as menus, buttons, and the heads-up display (HUD). Lumberyard Beta 1.9 adds support for the following features in the UI system:

**Lua**
+ All UI system buses are now exposed to Lua.
+ You can now use the **Lua Script** component on UI elements.
+ The UI system bus API operations were updated to use AZ types rather than legacy types. For example, color parameters now use the `AZ::Color` type.
+ Lua scripts now run in the UI preview mode.

**Slices**
+ You can now use slices in the **UI Editor**.
+ The **UI Spawner** component now supports dynamic slices.
+ Slices replace the UI prefabs, which are now deprecated.

**UI Editor**
+ A UI canvas compiler has been added.
+ The editor now supports font kerning.

For more information, see [UI System](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-intro.html).

### Physically Based Shading (PBS) Reference Material Gem<a name="lumberyard-v1.9-highlights-physically-based-shading-gem"></a>

Lumberyard Beta 1.9 includes a collection of 36 physically based referenced materials packed into an Asset Gem. We removed precooked `.dds` files and assets from the `\dev\engine\materials\pbs_reference` directory. In their place, you can now use the source `.tif` files in the Asset Gem. Normal maps are now correct and use `preset=NormalsWithSmoothness`. The Asset Gem is now active by default in the SamplesProject and newly created projects.

### New Comment Component<a name="lumberyard-v1.9-highlights-comment-component"></a>

The **Comment** component allows long-form text comments to be added for component entities. When enabled, the **Comment** component displays a dialog box that expands based on the size of the comment that is entered. For more information, see [Comment Component](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html).