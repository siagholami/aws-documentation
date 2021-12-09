# Lumberyard Release Notes – Beta 1.15 (July 2018)<a name="lumberyard-v1.15"></a>

Lumberyard Beta 1.15 adds over 200 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community, whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-15/).

**Topics**
+ [Highlights](#lumberyard-v1.15-highlights)
+ [Improvements and Changes](lumberyard-v1.15-improvements-changes.md)
+ [Fixes](lumberyard-v1.15-fixes.md)
+ [Known Issues](lumberyard-v1.15-known-issues.md)

## Highlights<a name="lumberyard-v1.15-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.15.

**Topics**
+ [River and Road Components for the Component Entity System](#lumberyard-v1.15-highlights-river-road-component-entity-system)
+ [New Cloud Gems for Cloud Canvas](#lumberyard-v1.15-highlights-cloud-gems-cloud-canvas)
+ [New Tutorial: 5 Time-saving Cloud Gems](#lumberyard-v1.15-highlights-tutorials-cloud-gems)
+ [Blend Nodes for the Animation Editor](#lumberyard-v1.15-highlights-animation-editor-emfx-nodes)
+ [Shader Compiler Support for macOS](#lumberyard-v1.15-highlights-macos-shader-compiler-support)
+ [Support for Latest Audiokinetic Wwise SDK and Authoring Tool](#lumberyard-v1.15-highlights-audio-wwise-sdk-support)
+ [Support for Visual Studio 2017](#lumberyard-v1.15-highlights-visual-studio-2017-support)
+ [SDK Compatibility](#lumberyard-v1.15-highlights-compatible-sdk-versions)
+ [New Amazon GameLift Features](#lumberyard-v1.15-highlights-amazon-gamelift)

### River and Road Components for the Component Entity System<a name="lumberyard-v1.15-highlights-river-road-component-entity-system"></a>

Lumberyard 1.15 adds the following components:
+ **River** – Use this component to carve riverbeds into the terrain and fill the riverbeds with moving water. The **River** component uses 2D materials to create the illusion of flowing water. Optimally, you should use this component to create flat rivers along level terrain. For more information, see the [River](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-river.html) component in the *Amazon Lumberyard User Guide*.  
![\[Example animated gif of the River component in Lumberyard Editor.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-component-river.gif)
+ **Road** – Use this component to create paths in the terrain. You can create roads that follow the curvature of existing terrain by applying a texture over the terrain texture. You can also use the **Align heightmap** feature with the **Road** component to shape the terrain to the height and curvature of the road you placed. For more information, see the [Road](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-road.html) component in the *Amazon Lumberyard User Guide*.  
![\[Example image of a path created by the Road component in Lumberyard Editor.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-erasing-road-vegetation-3.png)

### New Cloud Gems for Cloud Canvas<a name="lumberyard-v1.15-highlights-cloud-gems-cloud-canvas"></a>

Lumberyard 1.15 introduces the following cloud gems:

**Metrics, Analytics, and Heatmaps**  
You can use this cloud gem to collect event-driven data on player behaviors for analysis or to trigger event actions. This gem follows a serverless, microservice architecture and deploys an event ingestion pipeline, query engine, telemetry dashboard, and heatmaps.

**Defect Reporter**  
You can use this cloud gem to allow QA engineers, testers, and players to tag locations and assets in-game to report defects. The Defect Reporter captures player and session data at the time of submission, attaches a screenshot to the report, and prompts the player for additional information. You can review and query submissions in the Defect Reporter Cloud Gem Portal plugin. Raw data is stored in Amazon S3, so you can import the data with standard data warehousing and analytics tools.

**Compute Farm**  
This cloud gem uses Amazon Elastic Compute Cloud (Amazon EC2) and a divide-and-conquer algorithm to increase the speed of computationally-intensive tasks. An example is included to show how you can use the gem to sort the words in a dictionary. You can customize the example to perform tasks such as [generating large world terrain](https://aws.amazon.com/blogs/gametech/terrain-gen-in-mins/) or static light maps.

**Web Communicator**  
You can use this gem to notify game clients and servers of important events. AWS IoT is used to send notifications to connected game clients or servers, rather than the game clients or servers polling for updates. With [cross-gem communication](https://aws.amazon.com/blogs/gametech/terrain-gen-in-mins/), you can use the Web Communicator Cloud Gem in combination with other cloud gems. For example, you can use the Player Account Cloud Gem to remove the scores of players who are banned from the Leaderboard Cloud Gem, or the Dynamic Content Cloud Gem to notify game clients when new content is available.

For more information about Cloud Canvas and these cloud gems, see [Implementing Connected Features with Cloud Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-intro.html) and [Cloud Gems](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cloud-gems-intro.html) in the *Amazon Lumberyard User Guide*.

### New Tutorial: 5 Time-saving Cloud Gems<a name="lumberyard-v1.15-highlights-tutorials-cloud-gems"></a>

### Blend Nodes for the Animation Editor<a name="lumberyard-v1.15-highlights-animation-editor-emfx-nodes"></a>

The **EMotion FX Animation Editor** helps artists build and animate complex character behavior. The **Animation Editor** includes visual tools to set up hierarchical state machines, logic, and advanced hierarchical blend trees.

Lumberyard 1.15 adds the following nodes:
+ **Hub** node – Reduces the complexity of transitions by acting as a pass-through node. The **Hub** node outputs the pose of the node that transitioned into the **Hub** node.
+ **Blend Two Additive** node – Blends a base pose and an additive pose, for example Pose2 on top of the Pose1 input.
+ **Pose Subtract** node – Subtracts one pose from another, for example Pose2 from Pose1.
+ **Blend Two** node – Maintains previous functionality, but no longer supports **Additive Blend** mode.
+ **Blend Two (Legacy)** node – Provides backward compatibility for legacy functionality.

![\[New blend nodes in the Anim Graph Palette in the Lumberyard Animation Editor.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/animation-editor-blend-nodes.png)

The **Animation Editor** also supports saving assets in binary or text-based formats. This allows you to more easily merge your data.

For more information, see [Animation Editor (EMotion FX)](https://docs.aws.amazon.com/lumberyard/latest/userguide/animation-editor-introduction.html) in the *Amazon Lumberyard User Guide*.

### Shader Compiler Support for macOS<a name="lumberyard-v1.15-highlights-macos-shader-compiler-support"></a>

You are no longer required to use a Windows-based computer to generate Metal shaders for iOS and macOS. Lumberyard 1.15 adds a shader cross-compiler that is based on the Microsoft DirectX Shader Compiler and supported on Windows and macOS. The shader cross-compiler converts high-level shading language (HLSL) shaders to Metal.

You can enable or disable the shader compiler by setting the `r_ShadersUseLLVMDirectXCompiler` console variable in the `system_ios_ios.cfg` file. iOS and macOS now use this shader compiler by default.

The remote shader compiler (CrySCompileServer) has the following updates:
+ macOS is now supported.
+ The shader request protocol now specifies the compiler to use and the target OS. This prevents collisions between the cached shaders that are requested for different compilers or operating systems.
+ Shader requests are now received for the new shader compiler to generate Metal shaders.
+ The remote shader compiler can now detect its path. This allows the remote shader compiler to run from locations other than the local path.
+ The `config.ini` file now includes the following options:
  + `PrintCommands=1` – Prints the commands that the remote shader compiler uses to generate shaders.
  + `PrintWarnings=1` – Prints the compilation warnings that the remote shader compiler receives when shaders are generated.

### Support for Latest Audiokinetic Wwise SDK and Authoring Tool<a name="lumberyard-v1.15-highlights-audio-wwise-sdk-support"></a>

Lumberyard supports Audiokinetic Wave Works Interactive Sound Engine (Wwise), an audio pipeline solution with which you can create compelling soundscapes for your game. Lumberyard 1.15 supports Wwise SDK version 2017.2.4.6590. Setup instructions are available on the **Install optional SDKs** page in the **Lumberyard Setup Assistant**.

Lumberyard also supports a free, compact version called Wwise LTX. Lumberyard 1.15 includes a new version of the Wwise LTX Authoring Tool that you can install from the **Install software** page in the **Lumberyard Setup Assistant**.

Lumberyard is backwards compatible with Wwise SDK version 2016.x.x.

For more information, see [Adding Audio and Sound Effects](https://docs.aws.amazon.com/lumberyard/latest/userguide/audio-intro.html) in the *Amazon Lumberyard User Guide*.

### Support for Visual Studio 2017<a name="lumberyard-v1.15-highlights-visual-studio-2017-support"></a>

Lumberyard 1.15 supports Visual Studio 2017 version 15.7.4.

Beginning with Visual Studio 2017, Microsoft now releases updates on a more frequent cadence (in some cases, weekly). Lumberyard is tested with the latest version of Visual Studio available during the release cycle.

You can use the Lumberyard Setup Assistant to configure Visual Studio 2017, Visual Studio 2015, or both versions. You must select at least one version in order to install the appropriate Visual Studio redistributables. Waf generates a Visual Studio solution that you can manage with the `user_settings.options` file. This file is located in the `\dev\_WAF_` directory. The Visual Studio version field in the file is automatically updated with the version that you install. If you install both versions, the file uses Visual Studio 2015 as the default value.

For more information, see [System Requirements](https://docs.aws.amazon.com/lumberyard/latest/userguide/setting-up-system-requirements.html) and [Running Lumberyard Setup Assistant](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-launcher-using.html) in the *Amazon Lumberyard User Guide*.

### SDK Compatibility<a name="lumberyard-v1.15-highlights-compatible-sdk-versions"></a>

Lumberyard 1.15 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.4.34
+ Amazon GameLift Server SDK version 3.2.1

### New Amazon GameLift Features<a name="lumberyard-v1.15-highlights-amazon-gamelift"></a>

Stay up to date with the latest release information at [AWS Release Notes for Amazon GameLift](https://aws.amazon.com/releasenotes/Amazon-GameLift?browse=1).