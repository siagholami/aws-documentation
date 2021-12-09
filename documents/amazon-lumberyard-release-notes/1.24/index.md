# Lumberyard Release Notes – Beta 1\.24 \(May 2020\)<a name="lumberyard-v1.24"></a>

Spring has sprung, and it's time for a fresh release of the Amazon Lumberyard beta\! We're very pleased to bring you version 1\.24, which contains many improvements to the Lumberyard engine and tools, particularly around quality of life with Script Canvas, the Editor, and asset management and bundling\. We also fixed over 100 significant bugs as we work to bring more stability to our tools and keep you developing games smoothly\.

Oh, and we added Visual Studio 2019 support\. Yes\!

As we continue to improve Lumberyard, we want to thank everyone in our community whose suggestions help us make a better product every release\. Since the initial launch, we've overhauled over 70% of the original code base, and we're working like crazy to make Lumberyard the best dang game engine out there\. Keep sending feedback to our [forums](https://gamedev.amazon.com/forums/index.html) and to lumberyard\-feedback@amazon\.com\! For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-24/)\.

**Looking to get v1\.24 of Amazon Lumberyard, or interested in giving it a spin? [Download it here](https://aws.amazon.com/lumberyard/downloads/)\.** 

New to Lumberyard? Watch [Learn Lumberyard in 20 Minutes](https://www.youtube.com/watch?v=E1NgI8urJ7o)\!

Already a user? Share your feedback in [the Amazon Lumberyard forums](https://forums.awsgametech.com/)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/1-24-teaser-intro2.png)

**Topics**
+ [Highlights](#lumberyard-v1.24-highlights)
+ [Breaking Changes](#lumberyard-v1.24-breaking-changes)
+ [Deprecations](#lumberyard-v1.24-deprecations)
+ [Support Announcements](#lumberyard-v1.24-coming-changes)
+ [Improvements](lumberyard-v1.24-improvements-changes.md)
+ [Fixes and API Deprecations](lumberyard-v1.24-fixes.md)
+ [Known Issues](lumberyard-v1.24-known-issues.md)

## Highlights<a name="lumberyard-v1.24-highlights"></a>

Here's a sampling of the new features and improvements found in Lumberyard Beta 1\.24\.

### Community Contributions<a name="lumberyardv1.24-highlights-community-contrib"></a>

As we grow our community support, we're going to use this space to call out some of our top community contributors\.

This release, we'd like to direct you to a great new Lumberyard Gem, **C\+\+ Hot Reload**, created by Alvaro Martin \(Promt in the Lumberyard Game Tech forums\), which lets you make changes to your game code and variables and quickly see the effects without having to do a recompile\. This improves iteration times considerably\! Some of the features of the C\+\+ Hot Reload Gem include: 
+ Calculates dependents and dependencies of your files
+ Detects changes when you save a file
+ Generates a mapping of your variables to transfer to the new version
+ Wraps your modified files into a micro DLL
+ Creates a new pointer to your class \(component\)
+ Returns and restores that pointer for every instance you have in the game
+ Reloads and restores pointers for **only** your modified components

Get the **C\+\+ Hot Reload Gem** by cloning [https://github\.com/CppHotReload/Lumberyard](https://github.com/CppHotReload/Lumberyard), copying the `\CppHotReload` folder under the `\dev\Gems` folder in your Lumberyard installation root, and enabling it through the **Project Configurator**\.

 We'd also like to thank the following contributors to our [GitHub codebase](https://github.com/aws/lumberyard): 
+ GitHub user [ximura](https://github.com/ximura), who contributed the following:
  + Support for Ctrl\+V \(Paste\) in XConsole\.
  + Fixed an issue where Metastream used a stale cache after restarting\.
+ GitHub user [SSPkrolik](https://github.com/SSPkrolik), who contributed the following:
  + Fixed an issue where you could not select decals by clicking directly on the helper icon\.
  + Fixed an issue where the r\_stats 6 console command did not show the correct number of shadow draw calls\.
  + Fixed issue in the Particle Editor where changes in the color picker did not change the color\.
  + Fixed an issuer where the designer tool created triangles with flipped normals when using the fill space tool\.
+ GitHub user [tkgdhughes](https://github.com/tkgdhughes), who contributed the following:
  + Fixed various warning and errors related to static analysis\.
  + Fixed incorrect impulse applied to living entity when colliding with an object underfoot\.
  + Added API reflection support to `UiTextComponent::GetTextSize` for access in Script Canvas\.
  + Added parameter to optionally load a canvas if it was not found\.
  + Added ability to play partial UI sequences\.
  + Added cut, copy, and paste functionality\.
  + Enabled the use of the LyShine сursor in XConsole\.
+ GitHub user [rustamserg](https://github.com/rustamserg), who contributed the following:
  + Fixed various issues related to using uninitialized variables found by Valgrind profiler\.
  + Fixed potential self\-dependency and argument unused warnings in WAF\.
  + Fixed various issues related to CRenderMesh lock/unlock mismatches, remote console being disabled on performance builds, network, and compile errors\.
  + Fixed an issue where an empty qtlibs folder was created even if Qt was not available\.
  + Fixed CryAssert messages not logging as warnings properly for the Linux dedicated server configuration\.

**Great work, and our heartfelt thanks for contributing\!** You are making Lumberyard even better with your efforts\. We still have other pull requests we've accepted to fully integrate, so if you've contributed recently, watch this space\.

### Script Canvas<a name="lumberyard-v1.24-highlights-script-canvas"></a>

First up: **Script Canvas** quality of life improvements\! We continue to invest heavily in making **Script Canvas** a great experience for game developers, and this time, we've added improvements to working with node variables and math expressions, among other things\. Check 'em out:
+ **Node variable references**

  Now, any data pin can be converted to a **variable reference** by dragging a variable from the **Variable Manager** directly onto the pin\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/script-canvas-variable-reference-create.gif)

  An input reference performs the same as a **Get** variable node and retrieves the value of the variable at the time of node execution\.

  An output reference performs the same as a **Set** variable node and assigns the output of that slot to the specified variable at the time of node execution\.

  For more options and details, see [Adding Variable References in Script Canvas Nodes](https://docs.aws.amazon.com/lumberyard/latest/userguide/script-canvas-adding-variable-references.html)\. Convert your existing variable nodes into variable references and simplify your graph today\!  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/script-canvas-variable-reference-convert-variable-node.gif)
+ **Variable value changed event**

  A **Variable Notification Bus** node can be added to the graph in order to receive a signal whenever the value of a specified variable is changed\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/variable-manager-create-on-value-changed.gif)
+ **Math Expression node**

  The new **Math Expression** node lets you type in a simple math expression and evaluate it\. This eliminates the need to string together a bunch of math operator nodes in order to form a full equation\. Before, you had to create a node for every operation in an expression, and it looked like this:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/math-expression-node-before.png)

  Now, when using the **Math Expression** node, your work is significantly simplified\! Check it out:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/math-expression-node-after.png)

  **Note:** The Math Expression node allows variables to be used in the input node by using braces: `{}`, similar to the improved **Print** node\. Speaking of the **Print** node\.\.\.
+ **Print and Build String node improvements**

  The Print and Build String nodes now allow you to edit a string, add new variables, and modify the input to the node\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/node-print-build-string.png)

  Note that the order of pins now correlates to the order that they appear in the string, instead of the order in which they were added\. Pretty sweet\.
+ **Expanding string inputs**

  String inputs on a node now stretch and grow to the size of their inputs\. While interacting with the string, the node will grow and nudge other nodes out of the way if nudging is enabled\. See **Allow Node Nudging **in the **Script Canvas Global Preferences**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/string-inputs-nudge.gif)
+ **Hiding unused slots on a node**

  You can now make nodes more compact by hiding unused slots\. Right\-click on the node and select **Hide Unused Slots**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/node-hiding-unused-slots.gif)
+ **Auto\-update of event receiver nodes**

  There are new options for setting the **Source** input pin on EBus event receiver nodes\. In addition to selecting a static entity, you can now specify the target using a **variable reference**\. Whenever the value in the referenced variable changes, the EBus handler will update its **Source ID** to match\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/autoupdate-receiver-node.png)

  This also happens with any data that is passed into the node through a data pin\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/auto-update-receiver-data-pin.png)

  Note that this only works while the node option to **Display Connection Controls** is unchecked\. Once that option is checked, all control of when the bus connects is controlled by the **Connect** and **Disconnect** logic pins\.
+ **HeartBeat timing node**

  The new HeartBeat node sends out a pulse at specified intervals when active\. Use this to coordinate events in your scripts around independent timers and clocks\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/node-heartbeat-timing.png)

But we're just getting started with all the major improvements\. Read on\!

### Visual Studio Support<a name="lumberyard-v1.24-highlights-vs"></a>

**Visual Studio 2019 support with Lumberyard is here\!** All editions of Visual Studio 2019 are supported, along with Visual Studio 2017, of course\. The minimum version required for development is **16\.2\.4**\.

Here's a few specifics:
+ New commands have been added for building vs2019 projects from `lmbr_waf` \(specifically, lmbr\_waf build\_win\_x64\_vs2019\_profile\)\.
+ Visual Studio 2015 through 2019 now share the same runtime redistributable installer\. For convenience, we have included this in `\dev\Tools\Redistributables\Visual Studio 2015-2019`\.
+ You can use the **Lumberyard Setup Assistant** to configure support for Visual Studio 2019, Visual Studio 2017, or both versions\.
+ Additional flexibility has been added to build platform settings and Visual Studio solution \(`.sln`\) file names\.
+ In **Setup Assistant**, the check boxes for each version of Visual Studio modify new flags that enable support for building using a version of Visual Studio \(e\.g\. enable\_win\_x64\_vs2017\)\. These flags are found in the user settings file \(`dev\_WAF_\user_settings.options`\)\. When a version of Visual Studio has been enabled, a solution \(`.sln`\) file will be generated for it by default in the Solutions folder each time lmbr\_waf configure is run\. You can override these settings and more on the command line\. You can also generate the solution files manually by running the command lmbr\_waf msvs, or using the new version\-specific commands lmbr\_waf msvs\_2017 and lmbr\_waf msvs\_2019\.
+ Controlling the generation of specific versions of Visual Studio solution is now handled with version\-specific settings, including `generate_vs2017_projects_automatically` and `generate_vs2019_projects_automatically`\. This replaces the `generate_vs_projects_automatically` setting\.
+ The `visual_studio_solution_name` setting has been replaced with version\-specific settings, including vs2017\_solution\_name and vs2019\_solution\_name\.
+ The default Lumberyard Visual Studio 2017 solution file name has changed to `LumberyardSDK_vs2017.sln` instead of `LumberyardSDK_vs15.sln`\. The default solution for Visual Studio 2019 with Lumberyard is `LumberyardSDK_vs2019.sln`\.
+ The **Cry Shader Compiler Server** file name has been changed from `CrySCompileServer_vc141x64.exe` to `CrySCompileServer.exe`\.
+ The Lumberyard documentation has been updated to include Visual Studio 2019 in any relevant guidance\.

For a complete list of options, see the updated [Waf User Options and Settings](https://docs.aws.amazon.com/lumberyard/latest/userguide/waf-user-options-and-settings.html)\. For more information about Visual Studio support, including specific workload requirements, see [System Requirements](https://docs.aws.amazon.com/lumberyard/latest/userguide/setting-up-system-requirements.html) and [Running Lumberyard Setup Assistant](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-launcher-using.html) in the *Amazon Lumberyard User Guide*\. 

### GameLift Gem<a name="lumberyard-v1.24-highlights-gamelift"></a>

We've added support for GameLift's Flex Match matchmaking system in the **GameLift Gem**\. Flex Match's queuing system provides a highly scalable matchmaking solution for AAA games, and supports automatic or custom backfill options\. 

For more details, [read the updated **GameLift Gem** documentation](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-gamelift.html)\.

### Multiplayer Gem<a name="lumberyard-v1.24-highlights-multiplayer"></a>

In coordination with the update to the GameLift Gem, we've also added Flex Match matchmaking support to the Multiplayer Gem, specifically to support in\-game multiplayer lobbies\. As part of this update, we've added a new field for the queue name and new cvars required for Flex Match configuration\. 

You can use this self\-contained lobby from Lumberyard's component entity system\. To get started, just enable the **Multiplayer Gem** and add the **MultiplayerLobbyComponent** to a component entity in a scene\.

The **MultiplayerLobbyComponent **provides a basic lobby that can perform the following tasks:
+ Search for an active game session
+ Create a visual list of game sessions
+ Join a particular game session
+ Create a game session
+ Name a game session
+ Determine the map to load into
+ Report errors

The **MultiplayerLobbyComponent** supports all of Lumberyard's session services, including **LANSessionService** and **GameLiftSessionService**\.

For more details, read the updated docs:
+ [Multiplayer Lobby Component](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-multiplayer-lobby-component.html)
+ [Multiplayer Gem Cvars](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-multiplayer-cvars.html)

The [instructions for setting up the Multiplayer Sample for GameLift](https://docs.aws.amazon.com/lumberyard/latest/userguide/network-multiplayer-gs-gamelift.html) have also been updated with new information about using the Flex Match matchmaking system\.\.

### Editor<a name="lumberyard-v1.24-highlights-editor"></a>

The **Editor** gets some love this release, including the stabilization of entity IDs and Python bindings support\.
+ **This release includes a top customer request to stabilize entity IDs during slice operations in the Editor**\. Before 1\.24, saving or modifying slices would regenerate entity IDs causing references to entities from scripts or components to become lost\. Slice operations no longer generate new entity IDs\. 
+ **Python bindings support**: We've added two new gems, **EditorPythonBindings** and **QtForPython** \(PySide2\), that will allow feature and game teams to automate the **Editor** using Python\. You can enable them through the **Project Configurator**\. 

  **For more information**, read [Automating the Lumberyard Editor with the Python Editor Bindings gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/editor-automation.html)\.
+ **Entity ID display**: With our work in this release to stabilize entity IDs during slice operations, we have brought back the display of entity IDs in the **Entity Inspector**\. Furthermore, you can now search by entity ID in the **Entity Outliner**\. With these two improvements, you can easily trace console messages, errors, and asserts that call out a specific entity\. 

  Changes to the **Entity Inspector**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/entity-inspector-entity-properties.png)

  \.\.\.and the changes to the **Entity Outliner**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/entity-outliner-search-entity-id.png)

  **For more information**, see the updated topic on [Search and Filter for Entities](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-outliner-entities.html#component-entity-outliner-filtering) in the *Lumberyard User Guide*\.

### Asset Bundler<a name="lumberyard-v1.24-highlights-asset-bundler"></a>

**The Lumberyard Asset Bundler got some serious love with 1\.24\!** Now, managing and packaging large amounts of asset files gets even easier\.
+ We've added support for a default project dependencies file, `${ProjectName}_Dependencies.xml` to the project template, which includes audio control and particle related assets\.
  + This file is created and supported by default in any new project\. Assets referenced in this file will be added as seeds automatically when users create asset lists using the `AssetBundlerBatch.exe` and specify the addDefaultSeedListFiles argument\.
  + You can also copy this file from the project template to any existing project, if migrating from an existing project\. Assets referenced in this file will be added as seeds automatically when users create asset lists using the `AssetBundlerBatch.exe` and specify the addDefaultSeedListFiles argument\.
+ During the asset bundling process, if you try to add a slice file as a seed, you now get a warning message; and if a dynamic slice is available for that slice, the dynamic slice is added instead\. This is because non\-dynamic slices are an editor\-only asset and have no runtime behavior, and using one as a seed does not give the expected results when bundling a game's assets\.
+ Levels no longer emit product dependencies on the global audio control\. Projects have been adjusted to include the global audio control in the project's dependencies\.xml file\. If your project does not yet have a `${ProjectName}_Dependencies.xml` file, one will be generated for you when you use the Asset Bundler\. 
  + If you've created a project dependencies file matching the naming pattern `${ProjectName}_Dependencies.xml`, you will need to add the following lines to it:

    `<Dependency path="libs/particles/preloadlibs.txt" optional="true" />`

    `<Dependency path="libs/gameaudio/wwise/*.xml" optional="false" />`
+ Clouds, enabled via the **Sky Clouds Gem** in `Gems\Clouds` under the engine root, now emit product dependencies\.
+ Snow Textures, enabled via the **Snow Gem** in `Gems\Snow` under the engine root, now emit product dependencies\.
+ **Improved performance of bundling multiple asset lists by nearly 3x though support for multithreading\.**
+ **API update**: The `PerforceComponent::GetBulkFileInfo` implementation now matches `GetFileInfo` functionality\.
+ **API update**: We've added a new API to the `AssetSystemRequestBus` class: `GetUnresolvedProductReferences`\. If you're creating a new asset type and your asset has product dependencies that are not source dependencies, use this API in any builds connected to the **Asset Processor** to track when product dependencies become available\. In this case—**Asset Processor**\-connected builds—an asset may be available and loaded before the product dependencies have been loaded, so any code that interacts with these assets should be written to handle this by calling `GetUnresolvedProductReferences`, and changing all necessary behaviors if any product dependencies aren't ready yet\.
+ **Starter Game** deployment scripts have been updated to use new asset bundling system\. The [Simple Asset Bundling Tutorial](https://docs.aws.amazon.com/lumberyard/latest/userguide/asset-bundler-tutorial-simple.html) documentation has been updated to match this\.
+ `AssetBundlerBatch.exe` reports an error if the platform argument is missing when using addPlatformToSeeds or removePlatformFromSeeds commands\.
+ Engine dependencies system now supports exclusion path to exclude sub\-folders caught by wildcard entries defined in the dependencies files\.
  + Prepending the ':' character to a row in this file will mark it as an exclusion line\. If an asset matches one of the non\-exclusion lines in the dependencies file, it will not be included if it also matches an exclusion line\.
  + If your project already has a `${ProjectName}_Dependencies.xml file`, you should add an exclusion for this file in level folders for Wwise audio data\. See the changes to `dev/ProjectTemplates/DefaultTemplates/${ProjectName}/${ProjectName}_Dependencies.xml` for examples\.
+ Improvements to the level system such that levels inside `.pak` files can now be loaded directly\. Loading of levels also works with bundles created by the new asset bundling system\.
  + There is a known issue associated with this\. See the [Known Issues](lumberyard-v1.24-known-issues.md#asset-pipeline-known-issues-v1.24) section for details\.
+ Added new helper platforms, `ALL` and `ALL_CLIENT`, as new values for the \-\-platform flag in `AssetBundlerBatch.exe`\. These flags enable support for all platforms, including any that may be added in the future\.
+ Added a new Asset Bundler comparison type, IntersectionCount\. Given a list of `AssetFileInfoLists` and a count *N*, a new `AssetFileInfoList` will be created that only contains assets that are present at least *N* times in the input list\.
+ Improved file tagging system to better handle platforms, wildcards, and source product assets better\. All file path patterns without an alias will be considered relative to the asset root folder by default, now\. Users can specify a different root by adding an explicit alias to the pattern\.
+ **lmbr\_waf** commands are no longer case sensitive\.

Whew\! But we're not done yet\. 

### Asset Management and Processing<a name="lumberyard-v1.24-highlights-asset-mgmt"></a>

We've also made a number of improvements to asset processing, including support for command\-line move and delete operations with `AssetProcessorBatch.exe`\. 
+ Asset Processor Batch \(`AssetProcessorBatch.exe`\) now supports asset relocation with the new instructions **\-\-move** and **\-\-delete**\.
  +  Syntax for move operations: *\-\-move=*<FromPath>*,*<ToPath>** 
  +  Syntax for delete operations: *\-\-delete=*<Path>** 
  +  **Example: ** `AssetProcessorBatch.exe` \-\-move \{Path\}/image\.png,\{Path\}/image\.png

    The \-\-move and \-\-delete instructions support the following modifiers:
    +  *confirm*
      + Performs an actual move or delete, modifying files on disk\. Without this modifier, move and delete will only provide a preview of the results of the instruction\.
    +  *leaveEmptyFolders* 
      +  Empty folders are removed by default\. Adding this will keep empty folders after a move/delete\. 
    +  *allowBrokenDependencies*
      +  A move or delete instruction will fail, by default, if it will result in broken dependencies\. This modifier forces the action to proceed despite broken dependencies\. 
    +  *updateReferences*
      + **For the \-\-move instruction only**: Attempts to update files that reference the selected files\. This is a simple find\-and\-replace of the absolute path and UUID/AssetId, and will not work for binary assets like FBX\. 
    +  *enablescm*
      + Source Control Management is disabled by default in Asset Processor Batch\. By setting this modifier, you enable the source control plugin and cause the move/delete commands to check out files for edit/move/delete as appropriate\. 
  + Wildcards \(\*\) are supported for file name matches, but not for directory matches\.
+ **Asset Processor changes**: 
  + The old **Assets** tab of the **Asset Processor** user interface has been renamed to *Job*, and the other tabs of the **Asset Processor** have been reorganized based on usage\.
  + A new **Assets** tab has been added with a UI that shows details about source and product assets for your game\. It only shows assets that have been processed, and will update automatically as each asset is processed\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/asset-tab-1.png)
  + **Source Assets Details:** When you select a source asset in the **Source Assets** tab, it will show you the scanned folder the asset was found in, the GUID for the asset, the products, the outgoing source dependencies, and the incoming source dependencies\.
  + **Product Asset Details:** When you select a product asset in the **Product Assets** tab, it will show you the asset ID, last time the asset was processed, job key, platform, the source asset, the outgoing product dependencies, outgoing unmet path product dependencies, and incoming product dependencies\.
  + You can quickly navigate between assets using the buttons next to related assets\. For example, product assets have a button to jump to the source asset\. There is also a search bar that applies to both the source assets tab and product assets tab\. It searches by file name and path, and supports UUIDs\.
  + If you use the **Go to** button to jump to an asset, the target asset will be included as an override to your search results\. This was intentional to avoid clearing the search, or having an asset jump fail because the asset didn't match the search results\. 
  + Right\-click a *completed* job \(other job types don't work\) to jump to that asset in the **Assets** tab\. 
+ We added a log message when the **Asset Processor** UI status changes to idle\.

  **Note:** If you are working on automation that uses the **Asset Processor**, we recommend using `AssetProcessorBatch.exe` if possible\. If you must automate around the UI, we recommend checking for a lack of updates to the **Asset Catalog** as a way to detect that the **Asset Processor** is idle\. This log is meant for informative purposes only, and not for status checking\.
+ **Asset Pipeline**: We added new the `JobDependencyType`, OrderOnce, to the asset pipeline\. It is similar to the Order job dependency except that the job is only processed if all the dependent jobs have been processed at least once\. 

### UI \(LyShine\)<a name="lumberyard-v1.24-highlights-ui"></a>
+  We added a new `Trigger Mode` property to **UiTooltipDisplayComponent**, which allows a UI developer to select how the tooltip should be triggered\. The three options are: **On Hover**, **On Press**, and **On Click**\. 

  For more details on these options, see the updated [Tooltip Components](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-components-tooltips.html) page\. 
+ We added new Auto Fade properties to **UiScrollBarComponent** which allows the scrollbar to fade to fully transparent when not activated for a certain amount of time\. You can also control Fade Delay and Fade Speed\. Reclaim your visual real estate\!  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/ui-scrollbar-autofade.gif)

### Lumberyard Systems<a name="lumberyard-v1.24-highlights-systems"></a>

We've created some new APIs to support console variables \(cvars\) and functors \(cfuncs\), along with two new messaging models\. These new APIs currently coexist with the existing CryConsole cvars and EBus, so try 'em out in your code\!
+ `AZ::Console` adds a new interface for creating and managing cvars and cfuncs\.

  **For more information**, read [our new API reference topic on AZ::Console](https://docs.aws.amazon.com/lumberyard/latest/userguide/az-console.html)\.
+ `AZ::Event<...>` provides publish/subscribe messaging between game components\.

  **For more information**, read [our new API reference topic on AZ::Event](https://docs.aws.amazon.com/lumberyard/latest/userguide/az-event.html)\.
+ `AZ::Interface<T>` lets you register your code class instances with a Lumberyard system \(such as the renderer or the console\) to access variables and call methods on that system\.

  **For more information**, read [our new API reference topic on AZ::Interface](https://docs.aws.amazon.com/lumberyard/latest/userguide/az-interface.html)\.

### Physics<a name="lumberyard-v1.24-highlights-physics"></a>

We're continuing to move the Lumberyard legacy physics system to an entirely PhysX\-based one\. We also took some time to address a number of customer requests around scene queries\.

**Scene queries:**
+ We enabled scene queries to work in a multi\-threaded environment by enabling multi\-threading for the **Lumberyard PhysX** gem\. This multi\-threading follows best practices as documented on the [NVIDIA PhysX site](https://docs.nvidia.com/gameworks/content/gameworkslibrary/physx/guide/Manual/Threading.html)\.
+ We added the `OnWorldCreated` event when a PhysX scene is initialized\. This allows Lumberyard users to execute custom game logic when the physics simulation world is created\. To use it, connect to the `OnWorldCreated` notification EBus on the physics `SystemNotificationBus` API\.
+ We added new **Script Canvas** nodes for scene queries, such as ray casts, shape casts, and overlaps, with additional **Collision Group** input\. This enables the filtering of objects returned by scene queries, which is a necessary feature in some game scenarios\.

  **Note:** Each PhysX scene query **Script Canvas** node now has a duplicate with the string 'With Group' appended to the name \(see image below\)\. You should replace existing nodes with those post\-fixed with 'With Group' to use collision group filtering\. **Scene query nodes without 'With Group' will be deprecated in a coming release\. **  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/physics-new-scene-query-nodes.png)

**Shape colliders:**
+ We added the new **PhysX Shape Collider Component**\. The **PhysX Shape Collider Component** provides a similar function to the>**[PhysX Collider Component](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-physx-collider.html)**, but it creates the simulation geometry based on the shape definition supplied by a **[Shape Component](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-shapes.html)**, rather than defining the shape itself\. 

  We created this new collider component without an intrinsic shape definition to support the following situations:
  + Some shapes in your game are not supported by the **PhysX Collider Component**, such as the **Polygon Prism Shape**\. 
  + If the shape information defined by a **Shape Component **is used elsewhere in gameplay code—for example to define an audio volume, a fog volume, or any other gameplay\-associated definition that relies on the shape service—and it is desirable to keep the physics geometry synchronized with the gameplay volume\. 
  + If **Shape Components** already exist in your game and there are no plans to migrate them to use **PhysX Collider Components**\.
+ At the request of Lumberyard customers, we moved `RigidStatic` from `BaseCollider` to its own **Static Physics Component**\. With this change, static rigid bodies are moved into their own component: StaticRigidBodyComponent\. This component is spawned by either `EditorColliderComponent` or **EditorShapeColliderComponent** if the **Editor** entity does not have `EditorRigidBodyComponent`\. 

  This improves life for Lumberyard game physics programmers by:
  + Checking if an instance of `BaseColliderComponent` has a static rigid body coupled with it\. 
  + Making it easier to debug when you have multiple `MeshColliderComponent` or `PrimitiveColliderComponent` instances in a single entity, since only one `BaseColliderComponent` can have a coupled static rigid body\. 

**Other improvements:**
+ **NVIDIA Cloth is now supported on Mac, iOS, and Android \(as well as Windows\)**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/1.24-PhysX-ClothGrass_25.gif)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/1.24-PhysX-ChickenLittle_Large.gif)

  **[Check out this video showing off our NVIDIA Cloth physical behaviors](https://youtu.be/waCh5LTHEQ0)**\!
+ **CryDesigner objects now work with PhysX\!**
+  We integrated the V\-HACD library into the **Physics Asset Pipeline**\. This library enables users to decompose meshes into relatively complex parts, and the resulting compound collider should be a fairly faithful representation of the original mesh, while still being usable by a rigid body \(since it contains no triangle meshes\)\. Parts resulting from mesh decomposition are separately processed through the asset pipeline, instead of as a whole\)\. Each part is likely to be better approximated by a convex shape or a primitive than the original mesh, because each part is nearly convex\.

  There are a few known issues with this:
  + Mesh decomposition is only available if the **Export Type** is selected as **Convex** or **Primitive**\.
  + The actual results achieved by the decomposition depend mostly on the V\-HACD library and are out of our control\.
+ Added optimization of physics assets at loading time\. In this case, Lumberyard now automatically fits primitive colliders to FBX assets on behalf of the user\. This can save valuable time as it is no longer necessary to manually fit a primitive collider to an FBX asset used as a render mesh in\-game\. Just like triangle and convex mesh colliders, the primitive colliders are configured through the PhysX asset pipeline and exported as `*.pxmesh` assets\. Lumberyard will initially support sphere, capsule, and box primitives\. The feature has been designed with future extensibility in mind, and new primitive shapes can easily be added\.

### Documentation<a name="lumberyard-v1.24-highlights-docs"></a>

We've added the first iteration of the new [Lumberyard Welcome Guide](https://docs.aws.amazon.com/lumberyard/latest/welcomeguide/wg-welcome.html) to the public documentation\! This is a lightweight guide designed to help new users understand the Lumberyard platform, and get a new installation setup and configured quickly with little friction\. If you're a new user, we'd love your feedback on it, so click that feedback box in the lower right of any page and let us know how we should continue to grow and develop it\!

There will be more changes to the Lumberyard documentation structure and content coming in future releases as we balance new feature documentation with customer feedback and content gap coverage\.

## Breaking Changes<a name="lumberyard-v1.24-breaking-changes"></a>

With Lumberyard 1\.24, we introduced the following breaking changes:

**Script Canvas and EMFX:**
+ **Quaternion \- Create From Angles** node

  Previously, the labels for the data in this node were presented as **Yaw**, **Pitch**, and **Roll**, but this did not reflect how the values were hooked up\. The underlying logic has been fixed and the order of the fields has been changed to match the other quaternion nodes: **Pitch**, **Roll**, and **Yaw**\. 

  **If you're seeing unexpected behavior in your animations under 1\.24, check your node definitions and ensure that you are using the updated ordering of the rotation data values\.**

**Terrain:**
+ We have added a new gem called the **Legacy Terrain Gem**\. New projects will have the **Legacy Terrain Gem** enabled by default\. **If you use Lumberyard terrain in your current project, you will need to enable the **Legacy Terrain Gem** in the **Project Configurator**\. **

  Once you've done that, it will automatically add a **Legacy Terrain Component** to the **Level Inspector** for existing levels and you can add it yourself for new levels to create the terrain\. If you don't want or use terrain, you can leave this gem disabled\. 

  [Read the documentation for the Legacy Terrain Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-legacy-terrain.html)\.

**Physics:**
+ The `Simulation::Update()` method in the Physics API has been broken into two methods: `StartSimulation` and `FinishSimulation`\. We made this change since a single call to Update stalls other logic \(e\.g\. rendering\) until simulation is complete and results are obtained, wasting frame time\. Now, by breaking the call to `Update` into two methods, other operations have a window to execute between `StartSimulation` and `FinishSimulation`\. 

**Python support:**
+ Due to Python 2\.x end of life for 2020, Lumberyard has fully switched to Python 3\.7\.5\. The WAF build scripts have been updated to only run on Python 3\.x\. Older versions of Python have been removed from the Lumberyard install\. **If you have Python 2\.x scripts, you must convert them to 3\.7\.5 or greater to use with Lumberyard 1\.24\.**

**Video playback:**
+ The **VideoPlayback** gem was refactored to use a new framework for all video gems found in the new **VideoPlaybackFramework** gem\. Existing users of the** VideoPlayback **gem will need to add a dependency on the new **VideoPlaybackFramework** gem\. 

## Deprecations<a name="lumberyard-v1.24-deprecations"></a>

With 1\.24, we've deprecated the following features and content:

**Documentation:**
+ We've retired the *Getting Started Guide* due to poor customer feedback and have replaced it with the new [Lumberyard Welcome Guide](https://docs.aws.amazon.com/lumberyard/latest/welcomeguide/wg-welcome.html)\. The content from the Getting Started Guide will be rewritten for the current versions of Lumberyard and added back into the documentation in a coming release\. You can find a link to the last version of it on the [Lumberyard Documentation Archive page](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-documentation-archive.html)\.

  We've archived the *Lumberyard Legacy Guide *and retired it from the online Amazon Lumberyard documentation\. If you're looking for it, [it's available as a downloadable PDF](https://d3bqhfbip4ze4a.cloudfront.net/lumberyard-legacy.pdf)\.

**External Projects**
+ **External Projects** has been deprecated for Lumberyard in v1\.24\. As a workaround, symlink or junction your project into your source tree if you'd like to have it stored elsewhere\.

**Flow Graph**
+ **Flow Graph has been completely removed in version 1\.24 of Lumberyard\.** This legacy feature was disabled for new projects by default in version 1\.12, having been made redundant by [Script Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/script-canvas-intro.html) in version 1\.11\. 

**Gems**
+ The following gems have been deprecated in Lumberyard 1\.24:
  + **NativeUIGem**
  + **UserLoginDefaultGem**
  + **AWSGem** \(previously used for Flow Graph\)

**Setup Assistant**
+ The following features of **Setup Assistant** have been deprecated in Lumberyard 1\.24:
  + The Adobe Photoshop SDK has been removed from the list of optional SDKs available during Lumberyard's installation\. 
  + The Adobe Photoshop CryTiffPlugin has been removed from Lumberyard installation\. Use the **Texture Setting Editor** to enable full support for the CryTiff texture format\.

**Resource Compiler**
+ The **Resource Compiler Image** tool has been deprecated and replaced with a stub\.

**Physics**
+ **Announcement:** **Legacy Physics** is deprecated with 1\.24 and will be removed in a future release in favor of full PhysX support\. If you have dependencies on **Legacy Physics**, please update your entities to use PhysX and your code to use `AzFramework Physics::*` APIs\.

## Support Announcements<a name="lumberyard-v1.24-coming-changes"></a>

The following changes are planned for a forthcoming release of Lumberyard:

**Starter Game**
+ The **StarterGame Project **will be receiving a content update in a future release to demonstrate best practices with Lumberyard such as having all environment assets in FBX format instead of CGF format, using PhysX as the Physics system, and demonstrating game play logic using Script Canvas scripts\.

**Lumberyard UI 2\.0**
+ The **Lumberyard Editor **will be getting some significant changes to its user interface in a coming release\. When we release it, you'll be able to toggle between the old UI and the new for a while\.

  Check out a teaser with this animated GIF\!  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/ui20-comparison.gif)