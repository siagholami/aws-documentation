# Lumberyard Release Notes – Beta 1.1 (March 2016)<a name="lumberyard-v1.1"></a>

Lumberyard Beta 1.1 introduces hundreds of new features and improvements. Special thanks to our forum community and everyone who has sent feedback and suggestions to lumberyard-feedback@amazon.com. We love hearing from our fans and addressing your feedback.

**Topics**
+ [Highlights](#lumberyard-v1.1-highlights)
+ [Preview Systems and Tools](lumberyard-v1.1-preview-systems.md)
+ [Improvements and Changes](lumberyard-v1.1-changes.md)
+ [Fixes](lumberyard-v1.1-fixes.md)
+ [Known Issues](lumberyard-v1.1-known-issues.md)

## Highlights<a name="lumberyard-v1.1-highlights"></a>

### Lumberyard Installer – Quickly and easily download and install Lumberyard<a name="lumberyard-v1.1-highlights-installer"></a>

The Lumberyard Installer provides a simpler way for you to download and install Lumberyard. After you specify the install location, the Lumberyard Installer extracts the Lumberyard zip file and adds shortcuts for Lumberyard Launcher and Lumberyard Editor in the **Start** menu. If you have an existing Lumberyard project, we recommend installing Lumberyard Beta 1.1 in a new directory. For more information, see [Downloading Lumberyard](https://docs.aws.amazon.com/lumberyard/latest/userguide/setting-up-downloading-lumberyard.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/installer_01.png)

### New Gems to extend functionality<a name="lumberyard-v1.1-highlights-gems"></a>

The following Gems were added: 
+ *Allegorithmic Substance* – Provides integration and editor support for Allegorithmic's comprehensive texture and material authoring software, Substance.
+ *Gestures* – Provides a framework for gesture-based input, including click or tap, drag, hold, pinch, rotate, and swipe. All gestures can be used with touch or mouse input, and include Flow Graph nodes that can be used to create custom gestures for your game.
+ *Process Life Management* – Pauses your game when your game becomes constrained or minimized, and displays a screen overlay to ask the user to provide input before the game is unpaused.
+ *Starting Point Camera* – Provides an implementation of the camera rig component, including behaviors such as acquiring a target and following a target from a distance and/or angle.
+ *Starting Point Input* – Provides a starting point for game input based on the Input Management Framework so that you can bind inputs to game events or create your own events.
+ *Starting Point Movement* – Enables you to control the movement of component entities in your game.

### Substance Editor – Procedurally import and modify materials<a name="lumberyard-v1.1-highlights-substance-editor"></a>

The Substance Editor allows you to import procedural materials that are created using Allegorithmic's Substance Designer. Additional functionality includes the ability to modify substance material properties and visualize properties on objects in real time, and generate and export static textures from substance materials. For more information, see [Working with Substances](https://docs.aws.amazon.com/lumberyard/latest/userguide/mat-substances.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/substance_editor02_brickwall.png)

### Twitch ChatPlay – New voting functionality<a name="lumberyard-v1.1-highlights-twitch-chatplay"></a>

The Twitch ChatPlay voting functionality makes it easier for you to set up polls, surveys, and votes using native C\+\+ or the Flow Graph editor. You can use the following new nodes located in the Flow Graph editor under **Twitch**, **ChatPlay**, **Voting**: 
+ *Vote* – Controls Twitch ChatPlay vote operations for a specific vote. You can specify the name of the vote, which Twitch ChatPlay channel to connect to the vote, and whether or not the vote exists and can be voted for.
+ *Option* – Controls Twitch ChatPlay vote operations for a specific option on a specific vote. You can specify the name of the vote, the name of the voting option, and whether or not the option exists and can be voted for.
+ *HighScores* – Controls the top four voting options. You can specify to query the high scores, the name of the vote, and reset the vote count to zero.
+ *Score* – Reports the vote scores for a single voting option. You can specify the query score for an option, the name of the vote, the name of the voting option, and reset the vote count to zero.

Sample graph that allows votes on one of two options:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/flow_graph_chatplay_voting.png)

For more information, see [Twitch ChatPlay System](https://docs.aws.amazon.com/lumberyard/latest/userguide/chatplay-intro.html).

### Twitch Join JoinIn Samples<a name="lumberyard-v1.1-highlights-twitch-join"></a>

The Twitch JoinIn sample now uses the Multiplayer Project to walk you through setting up and configuring Twitch JoinIn, allowing a Twitch broadcaster to invite targeted invitees into a game session.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/JoinIn.png)

### Amazon GameLift – Autoscaling and expanded game server availability<a name="lumberyard-v1.1-highlights-gamelift"></a>

Amazon GameLift, which previously launched for two regions in North America, now provides optimal game server performance for players in Europe (region: eu-west-1; endpoint: gamelift.eu-west-1.amazonaws.com) and Japan (region: ap-northeast-1; endpoint: gamelift.ap-northeast-1.amazonaws.com).

The new autoscaling feature allows you to set up Amazon GameLift to dynamically manage your server fleet capacity so that your capacity can more closely follow the demand curve for your game. You can set up autoscaling for a fleet by setting up scaling rules based on metrics such as CPU utilization, game session count, and player count. For example, a scaling rule might say, "If the number of idle instances exceeds 20 for longer than 15 minutes, scale down by 10." Amazon GameLift's autoscaling features use the robust AWS Auto Scaling service.

For more information, see the [Amazon GameLift Developer Guide](https://docs.aws.amazon.com/gamelift/latest/developerguide/).