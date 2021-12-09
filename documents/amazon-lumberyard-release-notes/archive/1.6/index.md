# Lumberyard Release Notes – Beta 1.6 (November 2016)<a name="lumberyard-v1.6"></a>

With Lumberyard Beta 1.6, we continue to add new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our developer community. Without your participation in the forums, your messages, and your bug reports, Lumberyard 1.6 wouldn't be as strong as it is. Keep sending your feedback to lumberyard-feedback@amazon.com. If you haven't spoken up on the [forums](https://forums.awsgametech.com/) yet, we would love to have you. You can also keep up with new changes on [our blog](https://aws.amazon.com/blogs/gametech/) and leave comments to let us know what you think.

**Topics**
+ [Highlights](#lumberyard-v1.6-highlights)
+ [Preview Systems and Tools](lumberyard-v1.6-preview-systems.md)
+ [Improvements and Changes](lumberyard-v1.6-changes.md)
+ [Fixes](lumberyard-v1.6-fixes.md)
+ [Known Issues](lumberyard-v1.6-known-issues.md)

## Highlights<a name="lumberyard-v1.6-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.6.

**Topics**
+ [Download Third-Party SDKs Using Lumberyard Setup Assistant](#lumberyard-v1.6-highlights-setup-assistant)
+ [New Sample Level Demonstrates Particle Effects](#lumberyard-v1.6-highlights-sample-level)
+ [Create Overlay of Stats and Events for a Game Stream](#lumberyard-v1.6-highlights-metastream-gem)
+ [New Amazon GameLift Features](#lumberyard-v1.6-highlights-gamelift)
+ [Multiple Deployments of Cloud Canvas Resources](#lumberyard-v1.6-highlights-cloud-canvas)
+ [Supported Version of Audiokinetic Wwise LTX and Wwise Updated](#lumberyard-v1.6-highlights-audio)

### Download Third-Party SDKs Using Lumberyard Setup Assistant<a name="lumberyard-v1.6-highlights-setup-assistant"></a>

Lumberyard 1.6 introduces the ability to download third-party SDKs using the Lumberyard Setup Assistant. The Lumberyard download size is much smaller because you can now download only the third-party SDKs that you need. For example, if you do not intend to compile the engine or your game, you do not need to download any third-party SDKs. If you intend to compile only your game, you can save nearly 2GB of space for third-party SDKs. In addition, you can now reuse third-party SDKs between Lumberyard releases. If you are upgrading Lumberyard, you only need to download new or updated software.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/setup_assistant_thirdparty_sdks.png)

For more information about the Lumberyard Setup Assistant, see [Using Lumberyard Setup Assistant to Set Up Your Development Environment](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-launcher-intro.html).

### New Sample Level Demonstrates Particle Effects<a name="lumberyard-v1.6-highlights-sample-level"></a>

The Particles Technical Sample level demonstrates how to create particle systems and effects by changing various attributes in the Particle Editor. The sample level includes 10 particle samples that illustrate how to manipulate the particles using two physics entities, flow graph nodes, and entity links. For more information, see [Samples Project](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-project-samples.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/particles_technical_sample_001.png)

### Create Overlay of Stats and Events for a Game Stream<a name="lumberyard-v1.6-highlights-metastream-gem"></a>

Twitch Metastream lets streamers customize their game streams with overlays of statistics and events from the game session. Streamers can use any web authoring tool to create custom HTML5 pages to control the information, graphics, layout, and behavior of each unique overlay. To get started, you can add the Metastream Gem to your project in the Project Configurator, and enable the gem with an in-game setting. You can expose statistics and events by adding a single line of code for each event you want streamers to access. Lumberyard 1.6 includes a Metastream sample that demonstrates how to access the simple API and display the stats on an HTML page so they can be overlaid on a broadcast.

The following example shows how a streamer used a Metastream overlay to highlight the strengths and weaknesses of each character:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/metastream_example.png)

For more information, see [Metastream Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-metastream.html).

### New Amazon GameLift Features<a name="lumberyard-v1.6-highlights-gamelift"></a>

The following features have been added for GameLift:
+ Game owners can now deploy and operate 64-bit game servers to run on the [Amazon Linux](https://aws.amazon.com/amazon-linux-ami/) operating system as well as on [Windows Server](https://aws.amazon.com/windows/products/ec2/server2012r2/). For more information, see [Uploading a Game Build](https://docs.aws.amazon.com/gamelift/latest/developerguide/gamelift-build-intro.html) in the *Amazon GameLift Developer Guide*.
+ Game owners can now control how many GameLift computing resources an individual player can consume when creating new game sessions. The new resource creation limit policy controls how many game sessions that a player can create over a span of time. For example, a policy might state that "players can create up to 10 game sessions over 60 minutes." See [Handling Capacity and Utilization](https://docs.aws.amazon.com/gamelift/latest/developerguide/gamelift-howitworks.html#gamelift-howitworks-capacity) in the *Amazon GameLift Developer Guide*.

### Multiple Deployments of Cloud Canvas Resources<a name="lumberyard-v1.6-highlights-cloud-canvas"></a>

When developing a game, it can be useful to have different deployments of Cloud Canvas resources for different purposes. For example, you may need one deployment for customers that includes your launch-ready game and release data. You may also need another deployment for internal development that includes changes to the resources or data. By keeping this information separated in multiple deployments of Cloud Canvas resources, you can ensure that resource or data changes don't impact the current game client that customers are using.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/cloud_canvas_deployment_selection.PNG)

For more information, see [Working with Deployments](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-ui-rm-deployments.html).

### Supported Version of Audiokinetic Wwise LTX and Wwise Updated<a name="lumberyard-v1.6-highlights-audio"></a>

Lumberyard 1.6 now supports Audiokinetic Wwise LTX version 2016.1.1.5823. This version includes a WwiseLauncher application that provides a dashboard for you to manage your Wwise installations and projects. You can uninstall previous versions of Wwise LTX and then use the Lumberyard Setup Assistant to install the updated version of the authoring tool.

The full version of Audiokinetic Wwise has also been updated to version 2016.1.1.5823. You can use the WwiseLauncher to download and install the updated version of Wwise.

For more information, see [Audio System](https://docs.aws.amazon.com/lumberyard/latest/userguide/audio-intro.html).