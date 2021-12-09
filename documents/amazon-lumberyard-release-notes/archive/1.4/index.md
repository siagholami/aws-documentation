# Lumberyard Release Notes – Beta 1.4 (August 2016)<a name="lumberyard-v1.4"></a>

With Lumberyard Beta 1.4, we continue to add new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our developer community. Without your participation in the forums, your messages, and your bug reports, Lumberyard 1.4 wouldn't be as strong as it is. Keep sending your feedback to lumberyard-feedback@amazon.com. If you haven't spoken up on the [forums](https://forums.awsgametech.com/) yet, we would love to have you. You can also keep up with new changes on [our blog](https://aws.amazon.com/blogs/gametech) and leave comments to let us know what you think.

**Topics**
+ [Highlights](#lumberyard-v1.4-highlights)
+ [Preview Systems and Tools](lumberyard-v1.4-preview-systems.md)
+ [Improvements and Changes](lumberyard-v1.4-changes.md)
+ [Fixes](lumberyard-v1.4-fixes.md)
+ [Known Issues](lumberyard-v1.4-known-issues.md)

## Highlights<a name="lumberyard-v1.4-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.4.

**Topics**
+ [News Messages Now Appear in Lumberyard Editor](#lumberyard-v1.4-highlights-news-messages)
+ [New Gem Samples Demonstrate Environment Special Effects](#lumberyard-v1.4-highlights-gem-samples)
+ [New Decal Sample File Demonstrates Using Decals in a Level](#lumberyard-v1.4-highlights-decals-sample)
+ [Use Lua Scripting to Control a Mannequin Controller for a Character](#lumberyard-v1.4-highlights-lua-mannequin)
+ [Live Reload Skin Files Automatically in Lumberyard Editor](#lumberyard-v1.4-highlights-skin-live-reloading)
+ [Use Gems to Define Cloud Canvas Resource Manager Resource Groups](#lumberyard-v1.4-highlights-cloud-canvas)
+ [New Functionality in the VR Controller Level](#lumberyard-v1.4-highlights-vr-controller)
+ [Preview Your UI Canvas to See How Interactive Components Change States](#lumberyard-v1.4-highlights-ui-editor)
+ [GridMate Supports Encrypted Connections](#lumberyard-v1.4-highlights-networking)
+ [Amazon GameLift Now Tracks the Health of Each Game Server Process](#lumberyard-v1.4-highlights-gamelift)

### News Messages Now Appear in Lumberyard Editor<a name="lumberyard-v1.4-highlights-news-messages"></a>

Each time you launch Lumberyard Editor, you now see review news, blog posts, release notes, and more in the **Welcome to Lumberyard Editor** dialog box. You can disable the news messages by clicking **File**, **Global Preferences**, **Editor Settings** in the editor and deselecting **Show Welcome to Lumberyard at startup**.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/editor-news-messages.png)

### New Gem Samples Demonstrate Environment Special Effects<a name="lumberyard-v1.4-highlights-gem-samples"></a>

New gem samples include Rain, Snow, Lightning Arc, Clouds, and Game Effects System. You can enable these gems in the Project Configurator.
+ The rain sample uses the Rain, Clouds, and LightningArc gems to demonstrate how to use rain as an environment special effects in a level. For more information, see [Rain Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-rain.html).  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-gem-sample-rain.gif)
+ The snow sample uses the Snow and Clouds gems to demonstrate how to use the Snow entity as an environment special effects in a level. For more information, see [Snow Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-snow.html).  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-gem-sample-snow.gif)
+ The lightning arc sample uses the LightningArc gem to demonstrate the various prescripted arc types. For more information, see [Lightning Arc Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-lightning-arc.html).  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-gem-sample-lightning-arc-example-animation.gif)

### New Decal Sample File Demonstrates Using Decals in a Level<a name="lumberyard-v1.4-highlights-decals-sample"></a>

A new sample file called Decal\_Sample demonstrates how to use decals in a level file. The map uses a road surface and applies decals for crosswalks, turn lanes, and skid marks to show a method for altering surfaces with decal textures. You can access the Decal\_Sample level by clicking **File**, **Open**, **Levels**, **Samples** in Lumberyard Editor. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/decal_screenshot_01.jpg)

### Use Lua Scripting to Control a Mannequin Controller for a Character<a name="lumberyard-v1.4-highlights-lua-mannequin"></a>

Lumberyard Beta 1.4 provides a new API with which you can control a mannequin controller for a character through Lua scripting. The sample Lua-based state machine (located in the `\Components\Controllable_Chicken` demo level) demonstrates how to use mannequin controller.

### Live Reload Skin Files Automatically in Lumberyard Editor<a name="lumberyard-v1.4-highlights-skin-live-reloading"></a>

Lumberyard Beta 1.4 supports automatic live reloading of skin files in Lumberyard Editor, editor game mode, and PC games, when the files change on disk. This helps you to more easily iterate on these assets.

### Use Gems to Define Cloud Canvas Resource Manager Resource Groups<a name="lumberyard-v1.4-highlights-cloud-canvas"></a>

Lumberyard Beta 1.4 introduces two updates for Cloud Canvas: 
+ You can now use gems to define Cloud Canvas Resource Manager resource groups.
+ The lmbr\_aws command line tool now supports an `import-resource` command that creates definitions from existing AWS resources in a Cloud Canvas Resource Manager resource group. You can use the `list-importable-resources` command to list the available resources for importing.

For more information about resource groups, see [Working with Resource Groups](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-ui-rm-resource-groups.html).

### New Functionality in the VR Controller Level<a name="lumberyard-v1.4-highlights-vr-controller"></a>

Lumberyard Beta 1.4 provides a VR\_BoxGarden\_Sample level in SamplesProject that includes a motion controller setup and input event scripting example. Other new features include the following: 
+ Ability to see the size of your space identified by your room space's settings.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/vr-controller01.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/vr-controller02.gif)
+ Ability to use the controllers to shoot down boxes in the sky.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/VR_BoxGarden_Sample.gif)

You can preview the level in Lumberyard Editor, or you can load the level on a VR device using a standalone launcher. To load the level on a VR device using a standalone launcher, enable the console variables in the `level.cfg` file (located in the `\dev\SamplesProject\Levels\Samples\VR_BoxGarden_Sample` directory). 

### Preview Your UI Canvas to See How Interactive Components Change States<a name="lumberyard-v1.4-highlights-ui-editor"></a>

Lumberyard Beta 1.4 provides a new preview mode in the **UI Editor** so that you can preview your canvas at different screen resolutions and see how interactive components change states without needing to implement code or flow graphs to load your canvas in game. In addition, UI canvases now support mouse-free keyboard and gamepad operation for navigation between elements and interaction with elements. For more information, see [Previewing Canvases](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-previewing-canvas.html).

### GridMate Supports Encrypted Connections<a name="lumberyard-v1.4-highlights-networking"></a>

Encrypted GridMate connections using OpenSSL datagram transport layer security (DTLS) is now supported. This type of connection helps to prevent eavesdropping, tampering, or message forgery. For more information, see [Networking System](https://docs.aws.amazon.com/lumberyard/latest/userguide/network-intro.html).

### Amazon GameLift Now Tracks the Health of Each Game Server Process<a name="lumberyard-v1.4-highlights-gamelift"></a>

Amazon GameLift now tracks the health of each game server process in a fleet and automatically terminates and restarts any process that has been reported as unhealthy for three consecutive minutes. By default Amazon GameLift assumes a process is healthy unless it fails to respond to a request for health status. Alternatively, you can implement a customized health check process that lets you define when a process is healthy or unhealthy. For more information, see the [Amazon GameLift Developer Guide](https://docs.aws.amazon.com/gamelift/latest/developerguide/).