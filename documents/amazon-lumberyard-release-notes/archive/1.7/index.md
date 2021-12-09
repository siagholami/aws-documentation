# Lumberyard Release Notes – Beta 1.7 (January 2017)<a name="lumberyard-v1.7"></a>

Lumberyard Beta 1.7 adds new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our developer community. Without your participation in the forums, your messages, and your bug reports, Lumberyard 1.7 wouldn't be as strong as it is. Keep sending your feedback to lumberyard-feedback@amazon.com. If you haven't spoken up in the [forums](https://forums.awsgametech.com/) yet, we would love to have you. You can also keep up with new changes by following [our blog](https://aws.amazon.com/blogs/gametech/now-available-lumberyard-beta-1-7/) and leave comments to let us know what you think.

**Topics**
+ [Highlights](#lumberyard-v1.7-highlights)
+ [Preview Systems and Tools](lumberyard-v1.7-preview-systems.md)
+ [Improvements and Changes](lumberyard-v1.7-changes.md)
+ [Fixes](lumberyard-v1.7-fixes.md)
+ [Known Issues](lumberyard-v1.7-known-issues.md)

## Highlights<a name="lumberyard-v1.7-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.7.

**Topics**
+ [Install Visual Studio 2013 and 2015 with Lumberyard Setup Assistant](#lumberyard-v1.7-highlights-setup-assistant)
+ [Multiplayer Sample Project and Spawner Component Example](#lumberyard-v1.7-highlights-examples-samples)
+ [New Audio and Shape Components](#lumberyard-v1.7-highlights-audio-components)
+ [New Video Playback Gem](#lumberyard-v1.7-highlights-video-playback-gem)
+ [New Animation Features](#lumberyard-v1.7-highlights-character-animation)
+ [ScreenFader Added to Post-processing Effects](#lumberyard-v1.7-highlights-postprocessing-effects)
+ [Numerous Cloud Canvas Updates – Cloud Gem Framework, Command Lines, and AWS SDK](#lumberyard-v1.7-highlights-cloud-canvas)
+ [New Amazon GameLift Features](#lumberyard-v1.7-highlights-gamelift)
+ [AZ Test Scanner HTML Report Updated](#lumberyard-v1.7-highlights-aztestscanner)
+ [Virtual Reality Project Sample Demonstrates Building VR Applications](#lumberyard-v1.7-highlights-virtual-reality-project-sample)
+ [Stereoscopic Spherical Video for Virtual Reality](#lumberyard-v1.7-highlights-stereoscopic-video-vr)
+ [Haptic Feedback for Motion Controllers](#lumberyard-v1.7-highlights-force-feedback-system)
+ [Lumberyard Integrates with Perforce](#lumberyard-v1.7-highlights-perforce-plugin)

### Install Visual Studio 2013 and 2015 with Lumberyard Setup Assistant<a name="lumberyard-v1.7-highlights-setup-assistant"></a>

Lumberyard adds support for Microsoft Visual Studio 2015 Update 3 or later. You can use the Lumberyard Setup Assistant to install Visual Studio 2013, Visual Studio 2015, or both versions. You must select at least one version in order to install the appropriate Visual Studio redistributables.

The Lumberyard Setup Assistant provides third-party SDK content that is shared between Visual Studio 2013 and Visual Studio 2015. Only the files for the versions that you select are installed.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/setup_assistant_visual_studio_2013_2015.png)

If you use the configuration file for the Lumberyard Setup Assistant, the following updates have been made to support Visual Studio 2015 and enable OS-aware downloads:
+ Capability definitions now include categories and host systems.
+ SDK definitions now support tracking categories.
+ SDK symlink definitions now support tracking categories.

Waf generates a Visual Studio solution that you can manage with the `user_settings.options` file (located in the `\dev\_WAF_` directory). The Visual Studio version field in this file is automatically updated with the version that you install. If you install both versions, the file uses Visual Studio 2013 as the default value.

For more information, see [Using Lumberyard Setup Assistant to Set Up Your Development Environment](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-launcher-intro.html).

### Multiplayer Sample Project and Spawner Component Example<a name="lumberyard-v1.7-highlights-examples-samples"></a>

Lumberyard 1.7 includes the following new sample projects and examples:

#### Multiplayer Sample (Preview)<a name="lumberyard-v1.7-highlights-examples-multiplayer-sample-preview"></a>

A Multiplayer Sample preview project demonstrates how to build and structure multiplayer games that use the various features of the GridMate networking library. This sample is supported for PC only and offers the following features:
+ Dedicated server split (partial) – Because the clients can also host game sessions for LAN play, a true split is never done when the client has no server code. However, the code is compartmentalized and can be easily split.
+ Client authoritative control
+ Encryption – You can use FileDataSource with self-signed certificates and certificate pinning to encrypt network traffic.
+ RPC traits
+ Custom component net binding
+ Custom type marshalling

As the sample evolves, support for Amazon GameLift, as well as console and mobile development, will be added.

For more information, see [Multiplayer Sample (Preview for 1.7)](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-project-multiplayer-enhanced.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/new_multiplayer_sample.png)

#### Spawner Component Script Sample<a name="lumberyard-v1.7-highlights-examples-spawner-component"></a>

The Spawner Component Script sample demonstrates how to set up a spawner component and drive it using a simple Lua script. It facilitates the spawning of a design-time selected or runtime-provided dynamic slice at an entity's location with an optional offset. The sample includes examples of all of the spawner component's events and notifications. For more information, see [Samples Project – Spawner Component Script Sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-project-samples.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/samples-project-spawner-component.png)

### New Audio and Shape Components<a name="lumberyard-v1.7-highlights-audio-components"></a>

Lumberyard 1.7 adds two audio components and one shape component:
+ **Audio Listener component** – Use this component to add a listener to the component entities. When the **Audio Listener** component is active, it overrides previous (legacy) audio listeners.
+ **Audio Area Environment component** – Use this component to apply an environmental effect to entities that are moving through and around a shape. This affects any sounds that are playing.
+ **Compound Shape component** – Use this component to combine multiple shape components to create a compound shape that behaves as one contiguous shape.

For more information, see the [Component Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html).

### New Video Playback Gem<a name="lumberyard-v1.7-highlights-video-playback-gem"></a>

With the **VideoPlayback Gem** you can play back video files (for example, `.mp4`, `.mkv`, and `.webm`) up to 4K 60fps. The gem uses libavcodec, provided by FFmpeg or LibAV, to decode the video and provide frames to the video playback component. After you enable the **VideoPlayback Gem**, you can add the corresponding component to any entity in your level and specify the video to play. For more information, see the [Lumberyard Gems](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-ref.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/video_playback_component.png)

### New Animation Features<a name="lumberyard-v1.7-highlights-character-animation"></a>

Lumberyard 1.7 introduces the following new features for character and animation:
+ The **Simple Animation** and **Mannequin** components now support animation-driven root motion. This allows for animation-driven characters based on component entities.
+ Component entities now support populating parametric blend values based on physical motion.
+ You can set custom blend parameters from C\+\+ or Lua script through the `CharacterAnimationRequestBus` EBus. This allows runtime manipulation of per-instance blend parameters from C\+\+ or Lua.

For more information, see [Characters and Animation](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-intro.html).

### ScreenFader Added to Post-processing Effects<a name="lumberyard-v1.7-highlights-postprocessing-effects"></a>

`ScreenFader`, which has a similar effect to the Flow Graph node `Image:ScreenFader`, has been added to the post-processing effects group. You can set the following parameters:
+ **Enable** – Determines whether or not the `ScreenFader` is active for the post-processing effect group
+ **FadeInTime** – Time, in seconds, for the screen fader to fade in, once enabled
+ **FadeOutTime** – Time, in seconds, for the screen fader to fade out, once disabled
+ **ScreenCoordinates** – Determines where the screen fader quad is rendered
+ **FadeColor** – Sets the quad color by multiplying the color by the specified texture; if no texture is specified, the quad will be a solid color
+ **TextureName** – Path of the texture to use for the screen fader

The following example demonstrates how to use this effect in an `.xml` file:

```
<PostEffectGroup priority="2" hold="1">
    <Effect name="ScreenFader">
        <Param name="Enable" floatValue="1.0"/>
        <Param name="FadeInTime" floatValue="2.5"/>
        <Param name="FadeOutTime" floatValue="1.0"/>
        <Param name="ScreenCoordinates" vec4Value="0.0,0.0,1.0,1.0"/>
        <Param name="FadeColor" vec4Value="0.2,0.7,0.7,0.5"/>
        <Param name="TextureName" stringValue="textures/StyleTown/_dev_Blue_Light.tif"/>
    </Effect>
</PostEffectGroup>
```

### Numerous Cloud Canvas Updates – Cloud Gem Framework, Command Lines, and AWS SDK<a name="lumberyard-v1.7-highlights-cloud-canvas"></a>

Lumberyard 1.7 introduces numerous updates for Cloud Canvas:
+ The following commands were added for setting resource group parameters:
  + `lmbr_aws list-parameters`
  + `lmbr_aws set-parameters`
  + `lmbr_aws clear-parameters`
+ The following command was added for viewing Lambda function log output: `lmbr_aws get-function-log`

  This data is retrieved from an Amazon CloudWatch log file.

For more information, see [Cloud Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-intro.html).

#### Updated AWS SDK<a name="lumberyard-v1.7-highlights-cloud-canvas-aws-sdk"></a>

The AWS SDK has been upgraded to version 1.024, which removes the `.pdb` files and libraries of the services that are not being used. It also reduces the size of the SDK. Native C\+\+ libraries that are not included in the distribution are still accessible through other Cloud Canvas services, such as the HTTP client.

The Native C\+\+ libraries for Lumberyard 1.7 include the following services:
+ Core
+ Amazon GameLift
+ Amazon DynamoDB
+ AWS Lambda
+ Mobile Analytics
+ IAM
+ Amazon Cognito Identity
+ Amazon S3
+ Amazon SNS
+ Amazon SQS
+ AWS STS

If you need access to the `.pdb` files or libraries that were removed, please [contact Lumberyard support](https://aws.amazon.com/contact-us/).

#### Cloud Gem Framework Gem Executes C\+\+ AWS API Calls<a name="lumberyard-v1.7-highlights-cloud-canvas-cloud-gem-framework"></a>

The Cloud Gem Framework Gem provides C\+\+ classes and EBus interfaces. You can use these to execute C\+\+ AWS API calls through the Lumberyard job execution system. This allows processing of operations in background threads that are managed by the job system. For more information, see [Lumberyard Gems](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-ref.html).

### New Amazon GameLift Features<a name="lumberyard-v1.7-highlights-gamelift"></a>

The following features have been added for GameLift:
+ **Remote access to GameLift instances** – Remotely access individual instances running in an Amazon GameLift fleet. This capability is useful for debugging fleet activation and performance issues and for tracking game server activity in real time. Access Windows instances using a remote desktop protocol (RDP) client, or connect to Linux instances with an SSH client. For more information, see [Connect to Fleet Instances](https://docs.aws.amazon.com/gamelift/latest/developerguide/fleets-remote-access.html).
+ **Expanded region support** – Deploy fleets of game servers closer to your players to further minimize gameplay latency. Use GameLift to deploy fleets in these five additional regions: São Paulo, Mumbai, Seoul, Singapore, and Frankfurt. See the [Region and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#gamelift_region) supported by GameLift and a complete list of [instance types available in each region](https://aws.amazon.com/gamelift/pricing/), with pricing information.

### AZ Test Scanner HTML Report Updated<a name="lumberyard-v1.7-highlights-aztestscanner"></a>

The AZ Test Scanner is a tool for running unit tests that are built into Lumberyard libraries and executables. The scanner produces three types of files, one of which is an `.html` file that contains a summary of the test results from the entire scan, time stamped by default. The `.html` report now also shows disabled tests and includes a color legend. For more information, see [Using AZ Test Scanner](https://docs.aws.amazon.com/lumberyard/latest/userguide/testing-aztestscanner.html).

### Virtual Reality Project Sample Demonstrates Building VR Applications<a name="lumberyard-v1.7-highlights-virtual-reality-project-sample"></a>

The Virtual Reality Project sample is a template that you can use to build virtual reality (VR) applications for any supported device. The sample is configured with the base set of Gems that you need for VR. For information, see [Virtual Reality Project Sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-project-virtual-reality.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/virtual_reality_project_sample.jpg)

### Stereoscopic Spherical Video for Virtual Reality<a name="lumberyard-v1.7-highlights-stereoscopic-video-vr"></a>

The video playback system supports stereoscopic spherical video that you can use in a virtual reality project. Stereoscopic video is achieved with a `StereoTexture` class that extends the basic `Texture` class and overrides the `Apply` method. The **Video Playback** component populates the two textures (left or right) that are applied to the eye that is rendering.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/stereoscopic_video_example.png)

### Haptic Feedback for Motion Controllers<a name="lumberyard-v1.7-highlights-force-feedback-system"></a>

Lumberyard uses a force feedback system for haptic feedback for motion controllers. A new feature lets you specify to which input device to send feedback. You can set the **Input Device Type** parameter in the `Game:ForceFeedbackTriggerTweaker` node to one of the following:
+ Gamepad
+ Joystick
+ Keyboard
+ MotionController
+ MotionSensor
+ Mouse
+ TouchScreen

For more information, see the [Flow Graph Node Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/flowgraph_ref_intro.html).

### Lumberyard Integrates with Perforce<a name="lumberyard-v1.7-highlights-perforce-plugin"></a>

Lumberyard integrates with Perforce as a source control solution. The engine uses the `p4 set` command to configure settings, and the Perforce visual client (P4V) to selectively sync and submit changed assets. You can use the **Perforce Settings** dialog box in Lumberyard Editor to configure how Lumberyard connects to Perforce. For more information, see [Using the Perforce Plugin with Lumberyard](https://docs.aws.amazon.com/lumberyard/latest/userguide/setting-up-lumberyard-perforce-plugin.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/perforce_plugin_settings_dialogbox.jpg)