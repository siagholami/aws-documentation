# Lumberyard Release Notes – Beta 1.0 (February 2016)<a name="lumberyard-v1.0"></a>

**Topics**
+ [Highlights](#lumberyard-v1.0-highlights)
+ [Preview Systems and Tools](lumberyard-v1.0-preview-systems.md)
+ [Improvements and Changes](lumberyard-v1.0-changes.md)
+ [Fixes](lumberyard-v1.0-fixes.md)
+ [Known Issues](lumberyard-v1.0-known-issues.md)

## Highlights<a name="lumberyard-v1.0-highlights"></a>

Lumberyard Beta 1.0 introduces the following features:

### Lumberyard Launcher<a name="highlights-lumberyard-launcher"></a>

Lumberyard Launcher ensures you have the necessary runtime software and SDKs installed to successfully run Lumberyard. The Lumberyard Launcher detects missing components and allows you to install those and other software required for your role on a game team. Run `LumberyardLauncher.exe` from the `lumberyard_version\dev\Bin64` directory.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/lumberyard_launcher.jpg)

### Asset Processor<a name="highlights-asset-processor"></a>

The Asset Processor enables you to open levels immediately while assets stream in rather than waiting for a lengthy build process to complete. It also seamlessly integrates changes to source assets into a project without any action on your part to see the results. The Asset Processor is a background service that runs when you launch Lumberyard Editor. It monitors a configurable set of input folders for changes in source files and automatically generates OS-specific game assets as they change. After the files are processed, game-ready versions of assets in OS-specific folders are created in the Asset Cache. For more information, see [Asset Pipeline](https://docs.aws.amazon.com/lumberyard/latest/userguide/asset-pipeline-intro.html).

### Gems System and Gems<a name="highlights-gems-system-gems"></a>

Lumberyard's Modular Gems system provides a library of prebuilt features that you can use to quickly start new projects or prototype ideas. Modular Gems give you increased control over which technologies to include in your game project. Lumberyard includes 18 functional components that you can add or remove easily, such as weather effects, an ambient creature system, a camera framework, and more. For more information, see [Gems](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gems.html).

### Geppetto Tool and Animation<a name="highlights-geppetto-tool-animation"></a>

Lumberyard's character tool, Geppetto, combines animation, attachments, and physics simulations along with blendspace and animation layering. You can use Geppetto to assemble characters, easily swap out meshes on your characters by using attachments, and create realistic secondary animation with physics simulations. For more information, see [Characters and Animation](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/geppetto.jpg)

### Maya and Max Tools<a name="highlights-maya-max-tools"></a>

Lumberyard provides new exporter toolsets for Autodesk Maya and Autodesk 3D Studio Max 2014, 2015, and 2016. These toolsets allow the export of static and skinned geometry, skeletons, materials, and animation. For more information, see [Maya Export Tools](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-export-maya-lumberyard-tools.html) and [3ds Max Export Tools](https://docs.aws.amazon.com/lumberyard/latest/legacyreference/char-model-export-max.html). 

### Particle Editor<a name="highlights-particle-editor"></a>

Lumberyard introduces an advanced particle effects system that you can use to create and simulate explosions, fire, sparks, and other visual effects. Functionality includes: 
+ Playback controls
+ Gradient editor
+ Color picker
+ Color libraries (palette) for reuse
+ Live particle count
+ Spline playback
+ Ability to change the background and grid color
+ Ability to import mesh for size comparison

For more information, see [Particle Effects System](https://docs.aws.amazon.com/lumberyard/latest/userguide/particle-intro.html).

### Audio<a name="highlights-audio"></a>

Lumberyard includes Wwise LTX, a free version of Audiokinetic's advanced, feature-rich sound engine. With minimal dependency on engineers, sound designers and composers can work independently to author rich soundscapes for your game. Wwise LTX is licensed to you by Audiokinetic, Inc.; license terms are included in the root directory of the download. For more information, see [Audio System](https://docs.aws.amazon.com/lumberyard/latest/userguide/audio-intro.html).

### Networking<a name="highlights-networking"></a>

Lumberyard introduces GridMate, a robust and flexible networking solution designed for different genres of multiplayer games. GridMate is built with a reliable UDP protocol designed for efficient bandwidth and low-latency communication. You can easily synchronize objects over the network with its replica framework, and GridMate's session management integrates with major online console services and lets you handle peer-to-peer and client-server topologies with host migration. For more information, see [Networking System](https://docs.aws.amazon.com/lumberyard/latest/userguide/network-intro.html). 

### Waf Build System<a name="highlights-waf-build-system"></a>

The Waf build automation system allows you to build a game that targets all supported Lumberyard operating systems. Waf is integrated into Visual Studio and generates the solution (`.sln`) files upon running the `configure` command. For more information, see [Waf Build System](https://docs.aws.amazon.com/lumberyard/latest/userguide/waf-intro.html).

### Twitch ChatPlay and Twitch JoinIn<a name="highlights-twitch-chatplay-joinin"></a>

Twitch ChatPlay enables you to build games that let your fans directly influence gameplay from the Twitch chat channel. You can use the Lumberyard flow graph and a C\+\+ API to designate chat commands that trigger live game events. Flow nodes include a Twitch API 'Get' node that pulls information from Twitch channel metadata to trigger in-game effects.

Twitch JoinIn allows broadcasters to invite fans into their game directly from their Twitch broadcast. In one click, a fan can go from the chat channel into the game.

For more information, see [Twitch ChatPlay System](https://docs.aws.amazon.com/lumberyard/latest/userguide/chatplay-intro.html).

### Cloud Canvas<a name="highlights-cloud-canvas"></a>

Lumberyard's Cloud Canvas allows you to build connected gameplay in minutes, using Lumberyard's flow graph and AWS services such as Amazon Cognito, DynamoDB, Lambda, S3, SNS, and SQS. Cloud Canvas includes samples that demonstrate how to create and deploy common online services such as a daily gift or in-game messages. You must have an AWS account to use Cloud Canvas. Sign up for an account at [https://aws.amazon.com/](https://aws.amazon.com/). You can set permissions for individual users, and manage authenticated and anonymous player identity to track users in your game. For more information, see [Cloud Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-intro.html).

### Amazon GameLift<a name="highlights-gamelift"></a>

Lumberyard is integrated with Amazon GameLift, a fully managed service for deploying, operating, and scaling session-based multiplayer game servers in the cloud, with no upfront costs. You must have an AWS account to use Amazon GameLift. Sign up for an account at [https://aws.amazon.com/](https://aws.amazon.com/).

Amazon GameLift is integrated with the following: 
+ Lumberyard engine
+ [AWS Management Console](https://aws.amazon.com/console)
+ [AWS CLI](https://aws.amazon.com/cli)
+ [AWS SDKs](https://aws.amazon.com/tools)

Learn how to use Amazon GameLift by: 
+ Examining the GameLift Gem (an example multiplayer game) in the Lumberyard engine.
+ Reading the [Amazon GameLift Developer Guide](https://docs.aws.amazon.com/gamelift/latest/developerguide/).

### Sample Projects and Levels<a name="highlights-sample-projects-levels"></a>

Lumberyard offers a variety of sample projects, levels, and assets, including the following: 
+ **Samples Project** – Includes gameplay sample levels and content that you will need to follow the Lumberyard tutorials.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/samples_project.png)
+ **Multiplayer Project** – Enables you to evaluate Amazon GameLift and test Lumberyard's multiplayer capabilities.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/multiplayer_project.png)
+ **Legacy Sample** – Legacy CryEngine GameSDK features such as gameplay logic, project setup and implementation logic, and gameplay systems. The Legacy Sample is available as a separate download.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/legacy_sample.png)
+ **Beach City Night** – Free assets that you can use to try Lumberyard or make your own games. The Beach City Night asset collection is available as a separate download.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/beach_city_night_assets.png)
+ **Don't Die** – Game sample that demonstrates Cloud Canvas features.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/dont_die_project.png)
+ **Asset Collection – Woodland** – Free assets for creating levels. The Woodland asset collection is available as a separate download.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/woodland_assets.png)

For more information, see [Sample Projects and Levels](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-projects-levels-intro.html).