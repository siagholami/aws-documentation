# Known Issues<a name="lumberyard-v1.12-known-issues"></a>

Lumberyard Beta 1.12 has the following known issues. Choose a topic area to learn more. 

**Topics**
+ [3D Studio Max Tools and Plugin](#studio-max-tools-and-plugin-known-issues-v1.12)
+ [3rdParty Directory](#third-party-directory-known-issues-v1.12)
+ [Android](#android-known-issues-v1.12)
+ [Android Studio](#android-studio-known-issues-v1.12)
+ [Animation Editor](#animation-editor-known-issues-v1.12)
+ [Area Objects and Triggers](#area-objects-and-triggers-known-issues-v1.12)
+ [Asset Pipeline](#asset-pipeline-known-issues-v1.12)
+ [Audio](#audio-known-issues-v1.12)
+ [Audiokinetic Wwise and Wwise LTX](#audiokinetic-wwise-and-ltx-known-issues-v1.12)
+ [Audio Components EBus](#audio-components-ebus-known-issues-v1.12)
+ [Audio Proxy Component](#audio-proxy-components-known-issues-v1.12)
+ [AZ Test Scanner](#az-test-scanner-known-issues-v.12)
+ [Builder SDK](#builder-sdk-known-issues-v1.12)
+ [Cloud Canvas](#cloud-canvas-known-issues-v1.12)
+ [Cloud Gems](#cloud-gems-known-issues-v1.12)
+ [Cloud Gem Portal](#cloud-gem-portal-known-issues-v1.12)
+ [Component Entity System](#component-entity-system-known-issues-v1.12)
+ [Console Variables](#console-variables-known-issues-v1.12)
+ [CryEngine IJobManager API](#cryengine-job-manager-known-issues-v1.12)
+ [CryEngineNonRCModule](#CryEngineNonRCModule-known-issues-v1.12)
+ [CryEntity](#cryentity-known-issues-v1.12)
+ [Data Types](#data-types-known-issues-v1.12)
+ [Decal Component](#decal-component-known-issues-v1.12)
+ [Dedicated Server](#dedicated-server-known-issues-v1.12)
+ [DirectX 12](#directx-12-known-issues-v1.12)
+ [FBX Settings](#fbx-known-issues-v1.12)
+ [Flow Graph](#flow-graph-known-issues-v1.12)
+ [Game Mode Functionality](#game-mode-functionality-known-issues-v1.12)
+ [Game Projects](#game-project-creation-known-issues-v1.12)
+ [Gems](#gems-known-issues-v1.12)
+ [Geppetto](#character-editor-known-issues-v1.12)
+ [Gloss Maps](#gloss-maps-known-issues-v1.12)
+ [Graphics](#graphics-known-issues-v1.12)
+ [Heightmap File](#missing-heightmap-file-known-issues-v1.12)
+ [High DPI Display Support](#high-dpi-display-support-known-issues-v1.12)
+ [Incredibuild](#incredibuild-known-issues-v1.12)
+ [Installation Paths](#installation-paths-known-issues-v1.12)
+ [iOS](#iOS-known-issues-v1.12)
+ [Legacy Sample (GameSDK)](#legacy-sample-game-sdk-known-issues-v1.12)
+ [Lens Flare Elements](#lens-flare-elements-known-issues-v1.12)
+ [Linux](#linux-known-issues-v1.12)
+ [Lmbr.exe](#lmbr.exe-known-issues-v1.12)
+ [Lumberyard Editor](#lumberyard-editor-known-issues-v1.12)
+ [Lumberyard Setup Assistant](#lumberyard-setup-assistant-known-issues-v1.12)
+ [Lmbr.exe](#lmbr-exe-known-issues-v1.12)
+ [Lmbr\_test.cmd Tool](#lmbr_test.cmd-tool-known-issues-v1.12)
+ [Lyzard.exe](#lyzard.exe-known-issues-v1.12)
+ [macOS](#macOS-known-issues-v1.12)
+ [Mannequin](#mannequin-known-issues-v1.12)
+ [Material Browser](#material-browser-known-issues-v1.12)
+ [Material Editor](#material-editor-known-issues-v1.12)
+ [Maya](#maya-known-issues-v1.12)
+ [Mobile](#mobile-known-issues-v1.12)
+ [Particle Editor](#particle-editor-known-issues-v1.12)
+ [Perforce Source Control](#perforce-source-control-known-issues-v1.12)
+ [Physics](#physics-known-issues-v1.12)
+ [Profiler](#profiler-known-issues-v1.12)
+ [Project Configurator](#project-configurator-known-issues-v1.12)
+ [Remote Shader Compiler](#remote-shader-compiler-known-issues-v1.12)
+ [Resource Compiler](#resource-compiler-known-issues-v1.12)
+ [SamplesProject](#samples-project-known-issues-v1.12)
+ [Script Canvas](#script-canvas-known-issues-v1.12)
+ [Slices](#slices-known-issues-v1.12)
+ [Starter Game](#starter-game-known-issues-v1.12)
+ [Static Mesh Component](#static-mesh-component-known-issues-v1.12)
+ [Substance Editor](#substance-editor-known-issues-v1.12)
+ [Terrain Textures](#terrain-texture-known-issues-v1.12)
+ [Track View](#track-view-known-issues-v1.12)
+ [Trigger Area Component](#trigger-area-component-known-issues-v1.12)
+ [Twitch ChatPlay and Twitch JoinIn](#twitch-chatplay-and-joinin-known-issues-v1.12)
+ [UI Editor](#ui-canvas-editor-known-issues-v1.12)
+ [Virtual Reality](#virtual-reality-known-issues-v1.12)
+ [Visual Studio Support](#visual-studio-support-known-issues-v1.12)
+ [Waf Build System](#waf-build-system-known-issues-v1.12)
+ [Waterfall Shader](#waterfall-shader-known-issue-v1.12)
+ [Windows Environment Variables](#windows-environment-variables-known-issues-v1.12)
+ [Miscellaneous](#miscellaneous-known-issues-v1.12)

## 3D Studio Max Tools and Plugin<a name="studio-max-tools-and-plugin-known-issues-v1.12"></a>

The 3D Studio Max tools and plugin have the following known issues:
+ When using the 3ds Max plugin, you might receive a runtime error if you have an object selected with the CrySkin modifier and you right-click to dismiss the menu.
+ Lumberyard Editor must be running when you use the **Create Material** function in the 3ds Max plugin.
+ Absolute paths are saved in `.mtl` files that are created using the material editing tools in 3ds Max.
+ Rotations that are applied on the root bone of a skeleton will not load in Lumberyard. You will not receive an error message; however, to prevent this issue do not apply rotations to the root bone of a skeleton in 3ds Max.
+ To ensure 3ds Max exports correctly, you must save your `.max` file before changing the **Custom Export Path** field.

## 3rdParty Directory<a name="third-party-directory-known-issues-v1.12"></a>

The `3rdParty` directory has the following known issues:
+ Installation paths for the `3rdParty` directory cannot exceed the designated length. If you exceed the length limit, you will receive a notification.
+ The `3rdParty` directory cannot be changed while software is being downloaded. You can cancel the download or wait for it to complete.

## Android<a name="android-known-issues-v1.12"></a>

Android has the following known issues:
+ Samples Project cannot be built unless you already have the Google Play Billing library installed from a previous version of the Android SDK Manager. To work around this issue, use the **Project Configurator** to disable the IAP gem.
+ Android API-19 is not currently supported.
+ Android NDK r16 is not currently supported. 
+ An issue with the Lumberyard folder name can cause Android release builds to fail and prevent the APK from launching properly. To prevent this issue, ensure the installation directory does not contain a period (.) character.
+ Canvases are not rendered in the UiIn3DWorld map on Android.
+ You may experience issues when you build your game for Android after updating to Lumberyard 1.12. To work around this issue, delete the `BinTemp` directory, configure Lumberyard, and then try to build again.

## Android Studio<a name="android-studio-known-issues-v1.12"></a>

The version of the experimental gradle plugin that is used for project generation is no longer supported. The latest version (`gradle-experimental:0.11.+`) is unusable due to a bug. To work around this issue, use a previous version of the experimental gradle plugin, such as `gradle-experimental:0.9.3`. Use `android_studio.py` (located in the `/lumberyard_version/dev/Tools/build/waf-1.7.13/lmbrwaflib` directory) to update the version. After you import your project, update the gradle wrapper version to 3.3. Do not automatically update to the latest version of the experimental gradle plugin.

## Animation Editor<a name="animation-editor-known-issues-v1.12"></a>

The Animation Editor has the following known issues:
+ The **Save All** and **Save Workspace** options have the same functionality. 
+ Skinned meshes only work with a uniform scale of 1.0 throughout the bone hierarchy.
+ The **Attach To** function in the **Actor** component does not work properly. For example, if you choose **Actor Attachment** as the attachment type, the positional attachment doesn't work properly. To work around this issue, you can use the **Attachment** component to attach to other entities.
+ If a character disappears from the front view in the **Animation Editor** render pane, you can choose the four camera view mode, right-click the character in the viewport, and choose **Reset Transform**.
+ In the **Animation Editor**, small transform animations can occasionally result in missing keyframes. To work around this issue, right-click your `.fbx` file in the **Asset Browser** and choose **Edit Settings**. On the **Motions** tab, for **Add Modifier**, choose **Compression settings**. Change the default values for **Max translation error tolerance** and **Max rotation error tolerance** to **0** and click **Update**.
+ If your `.fbx` file contains only skeletons and bones, an `.actor` file will not be created. To create an `.actor` file, you must include a skinned mesh and corresponding skeletons and bones in your `.fbx` file.
+ The **Asset Processor** may not process assets properly if you enable the CryLegacyAnimation gem and the EMotion FX Animation gem.
+ The **Asset Processor** may not process assets properly if there are multiple bind poses in the `.fbx` files. To work around this issue, use your DCC tool to delete all bind poses except one and then export the `.fbx` files again.

## Area Objects and Triggers<a name="area-objects-and-triggers-known-issues-v1.12"></a>

You can use area objects to create three dimensional zones in a level that are then used to trigger events. If a player is detected within the trigger volume of an area object, the trigger is activated. Area triggers that use the **AreaSolid** object type as the trigger detection volume do not work properly. You can use the **Shape** object type instead.

## Asset Pipeline<a name="asset-pipeline-known-issues-v1.12"></a>

The Asset Pipeline has the following known issues:
+ If you switch branches, you must restart the **Asset Processor**.
+ Only asset types that have an implementation in the engine can live reload.
+ The **Asset Processor** reports all processing operations that failed with a **Crashed** status.
+ When using the asset importer, an access violation may occur when attempting to save.
+ Occasionally a `.caf` file might fail to move or copy from the source folder to the destination folder. To resolve this issue, rebuild by using the `AssetProcessorBatch.exe` file.
+ Searching for multiple space-delimited keywords in the **Asset Browser** exponentially degrades performance as the number of search terms increases.
+ An issue may prevent you from launching the editor after deleting the cache while the **Asset Processor** is running. To work around this issue, restart the **Asset Processor** and then relaunch the editor.
+ The precompiled version of the **Asset Processor** that's included in the `Bin64vs120.Dedicated` directory in the Lumberyard package does not initialize properly. To work around this issue, you must build the profile version of the **Asset Processor** for the dedicated server.
+ The **Asset Processor** may fail to rebuild dynamic slices when a component definition changes in the code. This is a result of the component not being found in the dynamic slice file. The component could have been inherited or is different in the compiled gameplay slice.
+ The **Asset Processor** does not automatically remove jobs for slices and UI canvases that were eventually successful. To work around this issue, restart the **Asset Processor**.

## Audio<a name="audio-known-issues-v1.12"></a>

The audio system has the following known issues:
+ Sound obstruction does not run when you toggle **AI/Physics** mode.
+ The file cache manager has not been ported to the new allocators.
+ An **Audio Controls Editor** popup dialog box erroneously displays in the upper left corner.
+ The editor stops working if `AudioPreloadComponent::Deactivate` loads more than one preload. To work around this issue, ensure `AudioPreloadComponent::Deactivate` loads only one preload.

## Audiokinetic Wwise and Wwise LTX<a name="audiokinetic-wwise-and-ltx-known-issues-v1.12"></a>

Audiokinetic Wwise and Wwise LTX have the following known issues:
+ The following issues are known when installing Wwise LTX:
  + An installation error may result in the following message: "Microsoft Visual C\+\+ 2008: Failed to execute the package: Fatal error during installation."

    To resolve this issue, do any of the following:
    + Click **Try Again** for the installer to attempt to install the package again.
    + Click **Cancel**. Run the `vc2008redist_x86.exe` and `vc2008redist_x64.exe` installers (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/`), and then run the installer again.
    + Click **Cancel**. Turn off any antivirus software that is running on your computer, and then run the installer again.
  + An access denied error may occur when using the **Extract** option in the Wwise LTX setup. To resolve this issue, manually run the installer (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/Wwise_v2015.2_LTX_Setup.exe`) as Administrator.
+ Lumberyard now supports Wwise 2016.1.1. If you attempt to use Wwise 2014 or Wwise 2015 with Lumberyard, you will encounter linker errors. To continue using an earlier version of Wwise, you can use the workaround described in the `wscript_wwise2015.readme.txt` file (located in the `\dev\Code\CryEngine\CrySoundSystem\implementations\CryAudioImplWwise` directory). 
+ Video playback is not yet capable of rendering audio. To work around this issue, use Wwise to play your video's audio separately.
+ Reloading the **Audio Controls Editor** after creating new controls without saving (thereby discarding your changes) can prevent the Wwise controls from returning to the unassigned state. If you discard your changes using this method, we recommend that you restart the **Audio Controls Editor** to prevent further issues.

## Audio Components EBus<a name="audio-components-ebus-known-issues-v1.12"></a>

The audio components Ebus have the following known issues:
+ The following audio components EBus have been renamed for consistency across components:
  + **AudioTriggerComponentRequestsBus** renamed to **AudioTriggerComponentRequestBus**
  + **AudioTriggerComponentNotificationsBus** renamed to **AudioTriggerComponentNotificationBus**
  + **AudioRtpcComponentRequestsBus** renamed to **AudioRtpcComponentRequestBus**
  + **AudioSwitchComponentRequestsBus** renamed to **AudioSwitchComponentRequestBus**
  + **AudioEnvironmentComponentRequestsBus** renamed to **AudioEnvironmentComponentRequestBus**
  + **AudioProxyComponentRequestsBus** renamed to **AudioProxyComponentRequestBus**

  If you use the old EBus names in Lua or native C\+\+, you must update your code to use the new EBus names. This applies if you manipulate or call into the audio components from code.

## Audio Proxy Component<a name="audio-proxy-components-known-issues-v1.12"></a>

The audio proxy component has the following known issues:
+ The **Audio Proxy** component is meant to be a silent partner component for other audio components. All audio components depend on the **Audio Proxy** component. In order to use this component, you must manually add it to a new component entity.

## AZ Test Scanner<a name="az-test-scanner-known-issues-v.12"></a>

To ensure integration tests run properly, you must disable **Animation Editor (EMotion FX)**. In the **Project Configurator**, click **Enable Gems** for your game project. On the **Gems (extensions)** page, clear the **EMotion FX Animation** check box. You must [build your project](https://docs.aws.amazon.com/lumberyard/latest/userguide/building-your-lumberyard-game-project.html).

## Builder SDK<a name="builder-sdk-known-issues-v1.12"></a>

The Builder SDK is in preview, which means that you can create builders that are functional but the API may change subtly while it is finalized. Builders do not have access to common buses such as the asset bus; therefore, the only supported builders are ones that operate solely on given data and that output data directly. Builders that must make external asset calls or calls into game engine code are not supported.

## Cloud Canvas<a name="cloud-canvas-known-issues-v1.12"></a>

Cloud Canvas has the following known issues:
+ Pressing **Ctrl\+F** in Cloud Canvas's Resource Manager opens the **Editor Unfreeze All** window rather than the expected **Search** window. To open the **Search** window, click **Edit**, **Search**.
+ If you upload Cloud Canvas resources and then attempt to run your game in Lumberyard Editor, the game fails to run and gives the error `MissingAuthenticationTokenException`. This is caused by a bug in which the resource map does not update when you create a new Cloud Canvas stack or change resources.
+ A related issue occurs when you use the Cloud Canvas Resource Manager to add a resource. Adding the resource succeeds, but the resource mapping silently fails. When you run the game in Lumberyard Editor, the resource is not available.

  To resolve this issue, do the following:
  + Perform the resource update.
  + Close and then restart Lumberyard Editor.
  + Reload the level.
  + Run the game.

  This issue also affects the standalone Samples Project launcher (located at `dev\Bin64\SamplesProjectLauncher.exe`). After updating your resources, but before running your game, run the following command to create the required resource mapping file so the game can run in the launcher: `lmbr_aws update-mappings --release`
+ You may see a log error that says, "Resource Management based Cognito-Identity pools configured as \[pool name\] has to support anonymous identities." when you attempt to do the following:

  1. Create a new project stack.

  1. Create a deployment.

  1. Press **Ctrl\+G** to run the game from the editor.

  To work around this issue, restart the editor or click **Upload Resources** in the Cloud Canvas Resource Manager and wait for the operation to complete. **Ctrl\+G** should work correctly.
+ Projects with AWS resources managed by the Cloud Canvas Resource Manager and created using previous versions of Lumberyard must be modified to work with Lumberyard 1.7. For information about the required modifications, see [Migrating Lumberyard Projects – Lumberyard 1.7](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-migrating.html).
+ The Cloud Canvas Resource Manager contains a preview of AWS API Gateway support (we call this feature Service APIs). The APIs that you create using this feature are publicly accessible. Future versions of the Cloud Canvas Resource Manager will allow the use of IAM roles to restrict access to these APIs.
+ The dynamic content manager UI appears blank with a non-functional drop-down menu in the following instances:
  + If there isn't a project stack or deployment.
  + If the game project doesn't use the **CloudGemDynamicContent** gem, but the gem is enabled in the solution.
+ Stacks created with a previous version of the Cloud Canvas Resource Manager are not backward compatible. You must create new stacks.
+ We disabled one method for login authentication due to security issues. This method stored the authentication token in a console variable. If you are still using this feature, you can re-enable it using `#define AUTH_TOKEN_CVAR_ENABLED`. Be aware of security risks, for example the console variable content being dumped into a crash dump.

## Cloud Gems<a name="cloud-gems-known-issues-v1.12"></a>

Cloud gems have the following known issues:
+ Cloud Gems are now built using versioning to prevent future breaking changes. Cloud Gem versioning also allows dependencies on different versions of other gems, such as the Cloud Gem Framework. In order to use this new functionality, you must follow the steps outlined in the [Lumberyard 1.10 migration section](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-migrating-1-10.html) of the *Amazon Lumberyard User Guide*.

**Speech Recognition Cloud Gem**
+ This gem is in preview and may have breaking changes in future releases.
+ You cannot use the **Cloud Gem Portal** to delete Amazon Lex bots, intents, and slot types. Use the Amazon Lex console instead.
+ Do the following if you want to update a published bot:
  + Use a bot description file in the **Cloud Gem Portal** and provide the version numbers of the bots, intents, and slot types.
  + Include only bot modifications and new or modified intents with appropriately incremented version numbers. This is required for the update to complete successfully.
  + Alternatively, use the Amazon Lex console to update the published bot.
+ Session attributes are not currently passed through the `PostContent` or `PostText` functions.
+ The `AWS_lmbr` test cleanup scripts do not currently clean up Lex bots, intents, or slot types. A future version of the gem will use the prefixes to clean up Amazon Lex bots, intents, and slot types. However, as shared resources, they will not be deleted if the bots are published or the intents and slot types are in use by any bot or intent.
+ The Microphone gem currently supports Windows only. This limits the use of the Voice Recorder System component to Windows. Future versions of Lumberyard will add microphone support on other operating systems.
+ Amazon Lex is accessible worldwide except from the following AWS region: US East (N. Virginia). For more information about supported regions, see [AWS Region Table](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/).

**Text-to-Speech Cloud Gem**
+ This gem uses a custom Amazon Polly resource that requires a handler in the project stack. This does not apply if you create a new stack. Do the following to add this gem to an existing stack:

  1. Enable the **Text-to-Speech Cloud Gem**.

  1. Restart Lumberyard Editor.

  1. Update the project stack.

  1. Update the deployment stack.

**Gem User Login: Default**
+ This gem is no longer useful and will be deprecated in a future release. Previously release builds required end users to log in for configuration settings like action maps. We have implemented the user login feature to enable quick testing and verification of release builds.

## Cloud Gem Portal<a name="cloud-gem-portal-known-issues-v1.12"></a>

The Cloud Gem Portal has the following known issues:
+ Basic user permissions require S3 PUT, S3 GET, AWS CloudFormation describeStack, and Amazon Cognito read. You can use the following AWS IAM built-in policies for basic users: [AmazonS3FullAccess](https://console.aws.amazon.com/iam/home?region=us-east-1#/policies/arn%3Aaws%3Aiam%3A%3Aaws%3Apolicy%2FAmazonS3FullAccess), [AWSCloudFormationReadOnlyAccess](https://console.aws.amazon.com/iam/home?region=us-east-1#/policies/arn%3Aaws%3Aiam%3A%3Aaws%3Apolicy%2FAWSCloudFormationReadOnlyAccess), and [AmazonCognitoReadOnly](https://console.aws.amazon.com/iam/home?region=us-east-1#/policies/arn%3Aaws%3Aiam%3A%3Aaws%3Apolicy%2FAmazonCognitoReadOnly).
+ If you access the Cloud Gem Portal in Firefox, you cannot use the **x** icon to remove an intent from a bot. No error message displays in the console.

## Component Entity System<a name="component-entity-system-known-issues-v1.12"></a>

Component entity sequences do not work with slices.

## Console Variables<a name="console-variables-known-issues-v1.12"></a>

You cannot edit text-based fields in the [Console Variables](https://docs.aws.amazon.com/lumberyard/latest/userguide/console-intro.html) window. To work around this issue, manually specify the console variable name and the value: `VARIABLE_NAME = new value`. For more information, see [Configuring Console Variables in Configuration Files](https://docs.aws.amazon.com/lumberyard/latest/userguide/console-intro.html#configuring-console-variables-cvars-with-the-configuration-file) in the *Amazon Lumberyard User Guide*.

## CryEngine IJobManager API<a name="cryengine-job-manager-known-issues-v1.12"></a>

The CryEngine job system and related APIs will be deprecated in a future release. This includes `JobManager::IJobManager`, `JobManager::SJobState`, and `DECLARE_JOB`. You can use `AZ::Job` instead.

## CryEngineNonRCModule<a name="CryEngineNonRCModule-known-issues-v1.12"></a>

`CryEngineNonRCModule` has been removed. If you are upgrading your projects from Lumberyard 1.4 or earlier, you must update all references of `CryEngineNonRCModule` to `CryEngineModule` in your wscript files.

## CryEntity<a name="cryentity-known-issues-v1.12"></a>

Lumberyard Editor may freeze if you attempt to use excessively high values for legacy CryEntity parameters, such as road width.

## Data Types<a name="data-types-known-issues-v1.12"></a>

The `.cga` and `.anm` data types are deprecated.

## Decal Component<a name="decal-component-known-issues-v1.12"></a>

The **Decal** component's visual representation has been updated to follow the entity's transform position. Now when you use a **Decal** component and move the object in-game, the location of the decal is updated. This update may introduce performance issues when several decals in the game frequently update their position.

## Dedicated Server<a name="dedicated-server-known-issues-v1.12"></a>

The dedicated server has the following known issues:
+ The **Asset Processor** executable located in the `Bin64vc120.dedicated` and `Bin64vc140.dedicated` directories does not work properly. To work around this issue, do one of the following:
  + Use the precompiled, profile version of the **Asset Processor**. You can find the **Asset Processor** in the `Bin64vc120` or `Bin64vc140` directory.
  + Build the profile version of your game and the **Asset Processor**:

    1. Build the profile version of your game and tools at least once.

    1. Launch the **Asset Processor** from your build location.

    1. Launch your dedicated server.
  + Pre-build the assets for your dedicated server so that the **Asset Processor** isn't required:

    1. Build the profile version of your game and tools at least once. Alternately, you can use the precompiled version of the **Asset Processor**.

    1. Launch the **Asset Processor** executable (or batch version) from your build location.

    1. Edit the `bootstrap.cfg` file to set `wait_for_connect` to **0**.

    1. Launch your dedicated server. The **Asset Processor** will not launch because the assets were prebuilt.

## DirectX 12<a name="directx-12-known-issues-v1.12"></a>

You may receive the following warning when you use `lmbr_waf configure --win-build-renderer=DX12`: "win\_build\_renderer == DX12 but machine can't compile for DX12, reverting to DX11." You can safely ignore this warning, which references the configuration for Android and Visual Studio 2013. DirectX 12 will configure correctly for the Visual Studio 2015 Windows build.

## FBX Settings<a name="fbx-known-issues-v1.12"></a>

FBX settings have the following known issues:
+ Adding a physics proxy rule to or removing one from a mesh group may cause `.cgf` assets to display incorrectly or prevent `.cgf` assets from rendering. To work around this issue, close and reopen Lumberyard Editor.
+ Errors that are generated by the **Asset Processor** are not displayed in the **FBX Settings** on occasion. To view these errors, open the **Asset Processor** from the Windows tray and double-click the failed job.
+ If source control is enabled and you change a file, it will be marked for add/edit in Perforce. Subsequent changes to the file will fail due to an error in the source control library. To work around this issue, revert changes before making any new changes, or check in changes before making any new changes. This allows you to make changes to previously changed files that have not been checked in.
+ After you change the settings for an `.fbx` file, the referenced materials are incorrectly reported as broken until the material is updated. This occurs the first time you change the file's settings.

## Flow Graph<a name="flow-graph-known-issues-v1.12"></a>

The **Flow Graph** system has the following known issues:
+ The `Game:Stop` node does not trigger on exit from game mode as expected. If you use the `Game:Stop` node to clean up flow graph activities that use ongoing resources, these activities may remain active.
+ The `Material:EntityMaterialParams` node does not apply changes made to the material parameters for an entity.
+ The `Material:MaterialParams` node does not allow any parameters to be selected.
+ From the context menu **Add Node**, **UIe**, the submenu is empty. To work around this issue, use the **Components** pane in the **Flow Graph** editor to add the UIe nodes.

## Game Mode Functionality<a name="game-mode-functionality-known-issues-v1.12"></a>

The game mode (**Ctrl\+G**) functionality does not work as expected after creating a new level. To resolve this issue, you can save the new level immediately after creation and then reopen the level from the **File** menu in Lumberyard Editor.

## Game Projects<a name="game-project-creation-known-issues-v1.12"></a>

The following issues impact the creation of external game project directories:
+ A linker error exists that prevents external game projects from building successfully.
+ The `external_manifest.txt` file that is required for you to create an external game project directory is missing.

Until fixes are available, please continue to use the existing project creation workflow. For more information, see [Creating and Launching Game Projects](https://docs.aws.amazon.com/lumberyard/latest/userguide/configurator-projects.html) in the *Amazon Lumberyard User Guide*.

## Gems<a name="gems-known-issues-v1.12"></a>

Gems have the following known issues:
+ When creating a new gem using the **Project Configurator**, a malformed file prevents tests from being built when using a test build configuration. To resolve this issue, modify the `gem_name_test.waf_files` file to use the name `gem_name_tests.waf_files`. For example, a new gem called MyGem with a file name `mygem_test.waf_files` would now be `mygem_tests.waf_files`.
+ An error message displays when creating a new gem and building the unit test configuration. To resolve this issue, edit the `GemName_tests.waf_files` files (located in the `dev\Gems\GemName\Code` directory) to replace **auto** with **none**. This allows you to compile the test profile spec for your gems.
+ If a gem attempts to use the EditorCore library as part of its build, the resource compiler may crash when attempting to build slices. To prevent this issue, do not use the EditorCore library with gems.
+ If you place only an I\_CAF in a gem, you cannot add your own `.animsettings` file. The `.animsettings` file must reside in the gem with the I\_CAF.
+ Lumberyard 1.11 includes preliminary changes that will enable gems to interface with the renderer in limited ways. These changes to export rendering APIs are not fully functional and will continue to evolve. They should not yet be used.

## Geppetto<a name="character-editor-known-issues-v1.12"></a>

The Geppetto system has the following known issues:
+ The **Copy Path** and **Show in Explorer** options in the context menu do not work correctly.
+ The **Clean Compiled Animations** option in the **File** menu does not work correctly. You can resolve this issue by navigating to the cache folder in the root engine directory and deleting the folder that contains the `.caf` files under the current development OS and game project. This action forces a recompile of all animations.
+ The **Color Hue** slider in the **Animation Event Presets** panel does not appear to slide in the UI; however, the value is updated in the **Color Hue** text field and in the viewport.
+ Skeletons exported from 3ds Max that have non-zero rotation values on the root joint, bone, or dummy are not supported.
+ Warnings may display if you switch between characters while animations are playing.
+ Creating new character files (`.cdf`) incorrectly produces an error and prevents the mesh from drawing. To work around this issue, load a different `.cdf` file and the new `.cdf` file will then load properly.
+ CGAs appear in the file browser if they are present in the asset tree; however, you should not use these files because the `.cga` file format is deprecated.
+ The side-by-side compression viewer compression is temporarily disabled.
+ The **Clean Compiled Animations** functionality is not working.
+ A workflow to create an `.animevents` file for a new character does not yet exist. You must create this file manually and add it to source control.
+ If multiple clips in a bspace use the same parametric value, a repeating error window will be displayed. You can resolve this issue by closing and reopening the editor. 
+ If you create a new `.chr` file immediately after opening an existing `.chr` file, Lumberyard Editor may become unresponsive and fail. To prevent failure and potential data loss, be sure to save all changes and restart the editor before creating new `.chr` files.

## Gloss Maps<a name="gloss-maps-known-issues-v1.12"></a>

Using gloss maps on imported Substances does not properly configure the gloss map. To work around this issue, if you plan to use a gloss map in the alpha channel of your Substance's normal map, manually export the normal map, and then connect it to your material like you normally would, but without using the **Substance Editor** to connect the normal map.

## Graphics<a name="graphics-known-issues-v1.12"></a>

Graphics have the following known issues:
+ A crash occurs if you use Null renderer with game launchers (r\_driver=NULL) and content that contains GPU particles.
+ To enable Order Independent Transparency (OIT), you must recompile with Windows 10 SDK installed on a Windows 10 Operating System and use a GPU that supports RasterizerOrderedViews, such as NVidia Maxwell or newer.
+ The **Mesh** component does not voxelize into the SVOTI Global Illumination buffer in order to contribute to lighting.
+ When you use the **Normals** preset, you may see the following message: "The Normalmap\_lowQ preset is not available in RC Open Image." You should continue to use the **Normals** preset for normal maps without smoothness in the alpha.

## Heightmap File<a name="missing-heightmap-file-known-issues-v1.12"></a>

Lumberyard 1.12 is missing a heightmap file that you may need to complete the getting started tutorials and videos. You can download the `FTUE_heightmap_Test.tif` file [here](https://dvbcuh49skxb5.cloudfront.net/releases/1.12/FTUE_heightmap_Test.tif) and save to your `/1.12.0.0/dev/StarterGame/Textures/Heightmaps `directory.

## High DPI Display Support<a name="high-dpi-display-support-known-issues-v1.12"></a>

High DPI display support has the following known issues:
+ Lumberyard now supports high DPI displays. Most elements in Lumberyard Editor will render at a reasonable size; however, some elements may still render too small. For example, some elements of the **Rollup Bar** render too small on high DPI displays.
+ Lumberyard supports whole number scale factors only. If the DPI is set to 1.5, the value will be rounded to 2. This will display most elements 0.5 times larger than expected.
+ When using Lumberyard Editor on a high DPI display, the mouse input for a UI canvas does not work properly. To work around this issue, close the editor, lower the resolution (for example, 1920 x 1080), and then restart the editor.

## Incredibuild<a name="incredibuild-known-issues-v1.12"></a>

When attempting to build Lumberyard with Incredibuild, builds running in parallel may occasionally fail due to missing moc files. You can retry the build or modify the `profile.xml` file (located in the `\Code\Tools\waf-1.7.3` directory) to set **AllowRemote** to **false** for the moc tool:

```
<Tool Filename="moc" AllowIntercept="false" AllowRemote="false" AllowPredictedBatch="true" DeriveCaptionFrom="lastparam"/>
```

## Installation Paths<a name="installation-paths-known-issues-v1.12"></a>

Installation paths have the following known issues:
+ An installation path that exceeds 54 characters may result in an error message or installation hang when installing third-party SDKs. To work around this issue, use the default Lumberyard installation path or ensure your installation path is 54 characters or less.
+ An installation path that meets or exceeds 64 characters will cause building Lumberyard to fail. To work around this issue, you can rename the package so that the path to `\dev` is less than 64 characters.
+ Running the `lmbr_waf` command on a path that includes spaces may result in errors and a build failure. To work around this issue, ensure that your installation path does not include spaces.

## iOS<a name="iOS-known-issues-v1.12"></a>

It is possible that, when deploying a debug build with a Virtual File System (VFS) configuration for iOS, the engine can take up to 20 minutes to initialize.
+ For debug builds, we recommend using a standard asset deployment.
+ For a VFS workflow, we recommend using it with profile builds until the issue is resolved.

## Legacy Sample (GameSDK)<a name="legacy-sample-game-sdk-known-issues-v1.12"></a>

In a debug build, you might see errors and warnings when loading maps, for example the Woodland map.

## Lens Flare Elements<a name="lens-flare-elements-known-issues-v1.12"></a>

Lens flare elements have the following known issues:
+ Copying a lens flare element from one library and pasting it into another library produces scale and visibility issues for the copied lens flare elements. To work around this issue, copy the XML code from the source library into the target library—however, the issue persists when adding new flares and elements thereafter.
+ When you create a new texture and assign it to a lens flare, the rendered texture may appear blurry or low resolution. This is noticeable in the **Lens Flare Editor** and in gameplay mode. To work around this issue, you must set the **LensOptics** setting for lens flare textures. Navigate to the directory where your texture is saved, right-click the texture, and select **RC Open Image**. In the image dialog box, under **Preset**, select **LensOptics** from the drop-down list. Click **OK**.
+ Lumberyard Editor stops working if you use the **Count** slider for the **Multi Ghost** property in the **Lens Flare Editor**. To work around this issue, manually enter the specified number. 

## Linux<a name="linux-known-issues-v1.12"></a>

If you attempt to launch a Linux dedicated server from the `MultiplayerSample_pc_Paks_Dedicated` directory, the server will not launch due to an issue on Linux that prevents `AWS_CPP_SDK_ALL` from copying. To work around this issue, you can copy the Linux `libaws*` and `libcurl.a` AWS Native SDK libraries (located in the `3rdParty` directory) to the appropriate `BinLinux` directory.

## Lmbr.exe<a name="lmbr.exe-known-issues-v1.12"></a>

The `Lmbr.exe` command line tool does not support the `populate-appdescriptors` command for external projects. This prevents Lumberyard Editor from launching successfully if you enable gems for your external project. To work around this issue, you can populate the gem appdescriptors. 

**To populate the gem appdescriptors**

1. Start a command prompt as an administrator.

1. In the command line window, navigate to the `\lumberyard_version\dev` directory.

1. Run the following command to create a folder junction to the external project folder that contains the `project.json` file: `mklink /d ProjectName PathToProjectFile`

   For example, to create a folder junction for StarterGame, run the following command: `mklink /d StarterGame E:\StarterGame\StarterGame\`

1. Run `Lmbr.exe` from the `\lumberyard_version\dev\Tools\LmbrSetup\Win` directory.

1. In `Lmbr.exe`, run the following command to populate appdescriptors for the external project: `lmbr projects populate-appdescriptors`

1. After the appdescriptors are successfully populated, you can delete the folder junction:

   1. On your computer, navigate to the `\lumberyard_version\dev` directory.

   1. Right-click and delete the folder that was created by the `mklink` command.

1. Launch Lumberyard Editor.

For more information, see [Lmbr.exe](https://docs.aws.amazon.com/lumberyard/latest/userguide/lmbr-exe.html).

## Lumberyard Editor<a name="lumberyard-editor-known-issues-v1.12"></a>

Lumberyard Editor has the following known issues:
+ The editor fails to start when building in debug/profile with the **editor and plugins** configuration. You can build using the **all** configuration instead.
+ The editor stops responding on exit if the system clock is inaccurate.
+ The GameSDK project displays several "Invalid geometric mean face area for node…" error messages when loading the Woodland level. You can ignore these non-fatal error messages.
+ The LOD Generation system does not work correctly and generates objects with distorted textures.
+ When using a system with an AMD graphics card, certain dynamic Global Illumination features are disabled by default, which disables indirect sun bounces. Enabling the `e_svoTI_GsmShiftBack` console variable causes the system to crash.
+ Using the **Waterfall** shader as a submaterial may cause the renderer to crash. You can resolve this issue by using a material that does not have submaterials for any mesh that requires the **Waterfall** shader.
+ The editor stops working if you extract the GameSDK package, configure the project as default, and launch the editor. This is caused by an incompatibility issue with the GameSDK package. To resolve this issue, ensure you are using the latest packages.
+ The editor randomly stops working if you attempt to use the **Waterfall** shader as a submaterial. When using the **Waterfall** shader, ensure the material does not have submaterials.
+ Floating windows cannot dock multiple windows.
+ When dialog boxes are docked together and then undocked, some dialog boxes do not appear in the foreground, despite being the active window.
+ Certain tool windows in Lumberyard Editor have panes inside them that can't be docked (for example, the **Particle Editor**, **UI Editor**, and **Track View** editor). When you undock the internal panes of these tools and then move the parent pane, the internal panes disappear. To make the internal panes for **UI Editor** and **Track View** editor visible again, close and reopen the parent tool. To make the internal panes for **Particle Editor** visible again, restart Lumberyard Editor.
+ If you attempt to generate a level without terrain, the **Generate Terrain** button in the **Terrain** menu will not function.
+ If you attempt to create a new level while Lumberyard Editor (`Editor.exe`) is maximized, the editor will minimize into windowed mode.
+ The viewport context menu item **Convert to Procedural Object** is missing, and its process cannot be accomplished by a workaround method.
+ Lumberyard Editor stops working if you attempt to load a new level or close the editor while the **Sun Trajectory Tool** is calculating. To work around this issue, wait for the tool to finish calculating before loading a new level or closing the editor. You can view the progress bar below the viewport.
+ When the viewport type in Lumberyard Editor is set to any type except **Perspective** (for example, **Top**, **Front**, or **Left**) and you add an object from the **RollupBar** to the viewport, Lumberyard Editor stops working.
+ If you make translate and scale changes to a designer object and then attempt to undo your changes, they will be undone out of order with other changes in the level. This can undo extraneous changes in certain situations.
+ When active, the **Use light probes** option disables **Total Illumination** diffuse and specular GI lighting contribution.
+ The CPU particles **SimplePhysics** and **RigidBody** collision types are not functional.
+ The **Dynamic 2D-Map** texture type may cause a crash when added as a texture on certain shaders. **Dynamic 2D-Map** is a deprecated texture type. The **LYShine UI** system and **2D** texture type replace **Dynamic 2D-Map**.
+ If you use merged mesh vegetation, you must re-export the level for the vegetation to appear in a launcher.
+ If you are already running the **Asset Processor** from an earlier version of Lumberyard, attempting to launch and connect to the **Asset Processor** can cause Lumberyard Editor to stop working.
+ You might experience gimbal lock if you attempt to position a component entity camera after selecting **Be this camera** in the **Entity Inspector** and enabling record mode in the **Track View** editor window.
+ Hot keys may not work properly. To resolve this issue, you can restore default key bindings. In Lumberyard Editor, choose **Edit**, **Editor Settings**, **Keyboard Customization**, **Customize Keyboard**. In the **Customize Keyboard** window, click **Restore Defaults**.
+ Lumberyard 1.12 removes the **AI/Physics** button from the bottom toolbar. The **AI/Physics** button toggles physics simulation and AI, allowing you to test physics and AI behavior directly in the editor without entering game mode. This feature will be restored in Lumberyard 1.13.
+ The editor stops working if you place the camera manager (`camera_manager.slice`) in the viewport and then press **Ctrl\+G** to enter game mode.

## Lumberyard Setup Assistant<a name="lumberyard-setup-assistant-known-issues-v1.12"></a>

Lumberyard Setup Assistant has the following known issues:
+ Lumberyard Setup Assistant might fail to run if `msvcr120.dll` is not present. You can resolve this issue by installing the [Visual C\+\+ Redistributable Packages](http://www.microsoft.com/en-us/download/details.aspx?id=40784) for Visual Studio 2013.
+ Only one active instance of Lumberyard Setup Assistant is supported. Do not attempt to run multiple instances.
+ Lumberyard Setup Assistant does not properly detect Python 3.x during the setup process. This can cause Lumberyard Editor to crash during startup due to an environment variable set by Python 3.x. To work around this issue, the Python 3.x home directory environment variable must be removed.
+ If you follow the onscreen installation instructions, Lumberyard Setup Assistant does not properly detect Android NDK, Revision 11 or later. To resolve this issue, manually locate any of the subdirectories for `ndkpath/build`. For example, you can use any subdirectory of the build directory, such as `ndkpath/build/awk`.
+ You cannot download SDKs using the `SetupAssistantBatch.exe` file.
+ You can use Lumberyard Setup Assistant to download SDKs that are required for Windows development using Visual Studio 2013 on Windows only. 
+ The progress percentage may change if you cancel a download.
+ Lumberyard Setup Assistant lists Clang as an optional third-party SDK; however, the `MultiplayerProject_LinuxPacker.bat` file fails without this SDK. To work around this issue, do one of the following:
  + Install Clang from Lumberyard Setup Assistant.
  + Edit the `MultiplayerProject_LinuxPacker.bat` file to delete: `Clang\3.7\linux_x64 ^` (line 64).
+ When you select **Compile the game code**, Lumberyard Setup Assistant does not indicate that SDL2 is a required third-party SDK. To work around this issue, do one of the following:
  + Select additional compile capabilities on the **Get started** page.
  + Edit the `SetupAssistantConfig.json` file (located in the `\lumberyard\dev` directory) to include the following for the SDL2 entry:

    ```
    "roles" : ["compilegame", "compileengine", "compileeditor", "compileandroid"],
    ```
+ After a completed installation of the FBX SDK, you may see a Windows dialog box asking if the SDK was installed correctly.
+ Lumberyard Setup Assistant for Mac erroneously reports a third-party path limit warning.
+ The Lumberyard Setup Assistant does not initialize properly if you open `SetupAssistant.app` on macOS 10.12. This is a result of updated Gatekeeper behavior. To work around this issue, do one of the following:
  + (Recommended) Move `SetupAssistant.app` to a new location and then move it back to the original location. This allows `SetupAssistant.app` to initialize properly. The Lumberyard Setup Assistant must be the only file in the move operation.
  + Run the Lumberyard Setup Assistant using the executable. Follow these steps each time you want to run the Lumberyard Setup Assistant:

    1. In the directory where you installed Lumberyard, right-click **SetupAssistant** and choose **Show Package Content**.

    1. Navigate to **Contents**, **MacOS**, **SetupAssistant**.

    1. Run `SetupAssistant.exe`.

## Lmbr.exe<a name="lmbr-exe-known-issues-v1.12"></a>

You cannot download third-party SDKs using the `lmbr thirdpartysdk setups` command in the `Lmbr.exe` command line tool. To work around this issue, use the [Lumberyard Setup Assistant](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-launcher-using.html) to download third-party SDKs.

Alternatively, you can do the following:

1. Use a text editor to open the `SetupAssistantUserPreferences.ini` file (located in the `/lumberyard_version/dev` directory).
**Note**  
If the `SetupAssistantUserPreferences.ini` file does not exist in the `/dev` directory, run the [Lumberyard Setup Assistant](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-launcher-using.html) or [Lumberyard Setup Assistant Batch](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-launcher-batch-using.html) file to generate the file.

1. Edit the file to include the following:

   ```
   [Downloader]
   manifest_source_url=https://df0vy3vd107il.cloudfront.net/1.12.0.0
   ```

1. Save and close the file.

1. In the `Lmbr.exe` command line tool, run the following command to download third-party SDKs:

   ```
   lmbr thirdpartysdks setup
   ```

## Lmbr\_test.cmd Tool<a name="lmbr_test.cmd-tool-known-issues-v1.12"></a>

The `lmbr_test.cmd` tool uses a Python SDK location that may not work if you use a new version of Lumberyard. To resolve this issue, you can edit `lmbr_test.cmd` to use the following values:
+ Change `SET SDKS_DIR=%CMD_DIR%\Code\SDKs` to `SET SDKS_DIR=%CMD_DIR%\Tools`
+ Change `SET PYTHON=%PYTHON_DIR\x64\python.exe` to `SET PYTHON=%PYTHON_DIR\python.cmd`

## Lyzard.exe<a name="lyzard.exe-known-issues-v1.12"></a>

Existing projects may crash the `Lyzard.exe` application. This is a result of the gem modules that are described in the app descriptor for the game project not being in the correct order based on dependencies. To fix this issue, you must enable gems for your project, which forces the **Project Configurator** to update the app descriptors for the project. You can do this in the **Project Configurator** by choosing **Enable Gems** for your project, enabling a gem, choosing **Save**, disabling the gem, and then choosing **Save**.

## macOS<a name="macOS-known-issues-v1.12"></a>

macOS has the following known issues:
+ Do not use spaces when you set the **whitelist** field in the `config.ini` file for the CrySCompileServer. This prevents validation of the IP address from working.
+ You must install third-party SDKs in the `3rdParty` directory.
+ Starter Game, FeatureTests, SamplesProject, and MultiplayerSample are the only projects currently supported and must be run using Xcode.
+ The frost effect does not render properly.
+ Az Code Generator parsing lacks STL support.
+ Substance is no longer supported on macOS.

## Mannequin<a name="mannequin-known-issues-v1.12"></a>

The **Mannequin** system has the following known issues:
+ The **Transition Editor** does not currently save changes.
+ The **Mannequin Editor** appears very small when you open it for the first time.

## Material Browser<a name="material-browser-known-issues-v1.12"></a>

The material browser has the following known issues:
+ When **Asset Processor** processes an `.fbx` file, Lumberyard automatically generates a default material file (`.mtl`) in the cache folder. The default material file appears under the `.fbx` file in the material browser hierarchy. If you edit the default material file in the **Material Editor**, the file is overwritten. A source file replaces the default material file in the project folder and the `.fbx` and `.mtl` files disappear from the material browser hierarchy.

**To make the material file reappear in the material browser hierarchy**

  1. In the **Material Editor**, in the material browser hierarchy, navigate to the `.fbx` file for which you want to edit the material.

  1. In the preview pane, select the `.mtl` file.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/mtl-file.png)

  1. Under **Material Settings**, for **Shader**, select the shader that you want to modify.

  1. Modify the shader settings to your preferred settings. You'll notice the `.mtl` file disappears from the **Material Editor**.

  1. In Lumberyard Editor, in the **Asset Browser**, navigate to the `.fbx` file. 

  1. Right-click the `.fbx` file and select **Edit Settings**.

  1. In the **FBX Settings** window, under **Material**, select the **Remove unused materials** check box and then click **Update**. In the **File progress** window, click **OK**.

  1. In the **FBX Settings** window, under **Material**, clear the **Remove unused materials** check box and then click **Update**. In the **File progress** window, click **OK**.

  1. Verify that your `.mtl` file appears in the **Material Editor** material browser hierarchy.
+ The search by submaterial option is case-sensitive.
+ The refresh button has been removed. The material browser is dynamic and updates as material files are added to or removed from the project.
+ The following options will not select the material of the current object until the **Material Editor** processes the material in the background:
  + Get properties from the selected object button
  + Material picker/eyedropper button
  + Mtl: button in the **Rollup Bar**

  These buttons will function a few seconds after opening the **Material Editor** for a project with several thousand materials.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/Selection.JPG)

## Material Editor<a name="material-editor-known-issues-v1.12"></a>

The Material Editor has the following known issues:
+ The **Material Editor** item tree displays a verbose path when you create a new material. You can resolve this issue by refreshing the item tree.
+ An issue exists with changing **Vertex Deformation** values. Currently the **Material Editor** allows you to change the following values in the **Parameters** group: **Level**, **Amplitude**, **Phase**, and **Frequency**. Because the parameter type value is set to None instead of Sin, this can create confusion when you modify values. To work around this issue, ensure the parameter type value is set to Sin. This will allow the **Level**, **Amplitude**, **Phase**, and **Frequency** values to save properly.
+ Lumberyard Editor stops working if you attempt to open a new level while the **Large Material Preview** window is open. To work around this issue, close the **Large Material Preview** window before you open a new level.
+ When you select multiple materials, you can only merge the materials. You may have unintended results if you edit parameters or use functions other than merging.

## Maya<a name="maya-known-issues-v1.12"></a>

Maya has the following known issues:
+ In the Maya Lumberyard Tool, the UDP editing tool breaks if changes are made to the LY\_MAYA\_SCRIPT\_PATH. To customize tools, you should add your own environment variable rather than changing this package variable.
+ In the Maya Exporter, if an MTL file is marked as read-only, the **Export Materials** button will not export the material group again. Instead, a message will display that says, "0 material file(s) written." To prevent the message from displaying, you can manually check out MTL files before exporting again.
+ An issue with the Maya 2015 plugin may result in an import error message stating that there is no module named `mayaAnimUtilities`. To work around this issue, you can add the path from the `Maya.env` line to the **PYTHONPATH** variable in the system environment variables.

  For example, if this is your path from the `Maya.env` line: `LY_PYTHONPATH=E:\Amazon\Lumberyard\1.6.0.0\dev\Tools\maya\script`

  Add the following to the **PYTHONPATH** variable, using a semicolon to separate paths: `;E:\Amazon\Lumberyard\1.6.0.0\dev\Tools\maya\script`

## Mobile<a name="mobile-known-issues-v1.12"></a>

Do not use spaces when you set the **whitelist** field in the `config.ini` file for the CrySCompileServer. This prevents validation of the IP address from working.

## Particle Editor<a name="particle-editor-known-issues-v1.12"></a>

The Particle Editor has the following known issues:
+ The following keyboard shortcuts do not work properly:
  + Rename (**Ctrl\+R**)
  + Open in New Tab (**Ctrl\+O**)
  + Copy (**Ctrl\+C**)
  + Paste (**Ctrl\+V**)
  + Export Library (**Ctrl\+Shift\+E**)

  The Directory shortcuts in the **Import** window do not work as well.
+ The **Particle** component does not support modifying the following attributes on GPU emitters: color tint; count scale; speed scale; global size; particle size x, y, and random; and lifetime strength.
+ The GPU particles framebuffer collision may have unexpected results at certain viewing angles.
+ When in a level, GPU particles move at approximately twice the speed of GPU.
+ GPU particles do not respect emitter strength curves related to emitter lifetime.
+ GPU particles are not supported on Android or iOS. 
+ The following attributes are not functional with the **Beam** emitter:
  + Relative Particle Movement
  + Orient To Velocity
  + Particle Life Time
  + Octagonal Shape
  + Size Y
  + Stretch
  + Tail Length
  + Collision (all parameters)
+ Lumberyard Editor stops working if you reorder libraries in the **Particle Editor** while a level is loading.
+ All of the **Attach Types** (**Bounding Box**, **Physics**, and **Render**) that are used to emit particles from geometry behave the same way.

## Perforce Source Control<a name="perforce-source-control-known-issues-v1.12"></a>

Perforce source control has the following known issues:
+ Some editor UIs will interact with your Perforce server. If the connection to your server is poor or you are experiencing other connection issues, the editor UI may briefly hitch during the connection attempt.
+ If Perforce is disabled and not configured and you attempt to delete a global flow graph module, an issue exists that causes the **Flow Graph** editor to display checkout dialog boxes. Although Perforce is disabled and not configured, you must click **Yes** and check out the file in order to delete it.
+ RequestEdit incorrectly reports success as false for the following statuses:
  + CheckedOutByOther
  + CheckedOutByYou
  + MarkedForAdd

  This issue can also occur when you change the editor to offline mode.

## Physics<a name="physics-known-issues-v1.12"></a>

The physics system has the following known issues:
+ If a physics proxy rule is removed from a mesh group, you must do one of the following to remove the physics proxy material:
  + Use the **FBX Settings** to create the existing `.mtl` file again.
  + Use the **Material Editor** to edit the existing `.mtl` file.
+ Physics meshes do not live reload properly for `.cgf` files when a change occurs on disk. To work around this issue, you can manually reload by clicking **Tools**, **Reload Scripts**, **Reload All Scripts** in Lumberyard Editor.
+ If you switch between mass and density on a **Physics** component, you must enter and exit game mode or enable **AI/Physics** mode for the change to take effect.
+ The **PhysX Collider** component is limited to one collision shape. This means you can add only one shape component per entity. The **PhysX Collider** component does not use shapes from child entities.
+ Most features are not yet exposed to the scripting system.

## Profiler<a name="profiler-known-issues-v1.12"></a>

Lumberyard Editor stops working if you attempt to profile your game while it is running in the editor. For more information about this tool, see [Profiler](https://docs.aws.amazon.com/lumberyard/latest/userguide/profiler-intro.html) in the Amazon Lumberyard User Guide.

## Project Configurator<a name="project-configurator-known-issues-v1.12"></a>

You may receive an error message the first time that you attempt to set a default project in the **Project Configurator**. To work around this issue, set the default project again. The second attempt will succeed.

## Remote Shader Compiler<a name="remote-shader-compiler-known-issues-v1.12"></a>

Specifying `192.168.0.1/0` for the whitelist does not currently connect all IP addresses to the remote shader compiler. To work around this issue, specify a value such as `whitelist=1.0.0.0/1,128.0.0.0/1`. For more information, see [Creating a Whitelist for the Remote Shader Compiler](https://docs.aws.amazon.com/lumberyard/latest/userguide/mat-shaders-custom-dev-remote-compiler.html#mat-shaders-custom-dev-remote-compiler-whitelist).

## Resource Compiler<a name="resource-compiler-known-issues-v1.12"></a>

**Resource Compiler** may occasionally crash when processing textures, such as cubemaps. Lumberyard Editor will automatically resolve this issue by recompiling the affected asset.

## SamplesProject<a name="samples-project-known-issues-v1.12"></a>

SamplesProject has the following known issues:
+ In the SamplesProject, Example 7 in the Trigger\_Sample map does not work. The door trigger does not open as expected.
+ The `SamplesProjectLauncher.exe` remains running in the Task Manager after quitting.

## Script Canvas<a name="script-canvas-known-issues-v1.12"></a>

Script Canvas has the following known issues:
+ You can unhide nodes that were not tested. To do so, in Script Canvas, choose **Edit**, **Settings**, **Global Preferences**. In the **Global Preferences** window, select **Show nodes excluded from preview**.
+ Although multiple outbound execution connections are supported, **Script Canvas** does not currently have a way to control node execution. To prevent ambiguity during order execution, when execution order is important, you can use a **Sequencer** node or you can create graphs sequentially.
+ The node library may change in future releases to streamline and simplify graph logic.
+ **Script Canvas** for Lumberyard 1.11 does not include debugging tools.
+ The editor can hang if you enter an excessively long string in the **Node Palette** search bar.
+ When you copy and paste a variable node, the node is renamed on the graph but not in the **Node Outliner**.
+ You cannot edit the property fields for certain **Script Canvas** parameters.
+ **Script Canvas** for Lumberyard 1.11 does not support the following:
  + Data sets/arrays
  + Global variables
  + Exposing variables to the **Script Canvas** component from a graph
+ Entity references to slice entities use the instance entity ID and not the asset entity ID. Only specific slice instance entities are accessible during **Script Canvas** execution.
+ There is no visual feedback of error conditions in graphs. If a graph isn't working as expected, you can check the Lumberyard Editor **Console** pane for warnings or errors that must be fixed.
+ The **Node Inspector** is hidden by default due to several issues with node and slot names, and multiselection. To use advanced functionality on the event nodes, you can choose **View**, **Node Inspector** in **Script Canvas**.
+ Visual positioning of elements within a node may shift when you pause on and off the node.
+ To reset an entity reference on a node, you must right-click twice on the property field for the entity reference.
+ When you select and move multiple nodes, the comments are not moved.
+ Some variables may display a default value of `<Invalid ToString Method>`.
+ You cannot associate error handlers with any node. You can associate error handlers with error nodes or the entire graph.
+ Certain execution paths in graphs that are extremely long, involve loops that execute for several iterations, or involve many resource heavy nodes may cause a stack overflow or prevent memory allocation for the next execution. To work around this issue, add a **Delay** node before the re-entrant execution or loop.
+ Extremely large graphs are not currently supported.
+ Cloud Canvas nodes are not yet functional in **Script Canvas**. If you use Cloud Canvas, you can use Lua or **Flow Graph** for scripting.
+ If an entity within a slice instance references a **Script Canvas** graph, only entities within the slice instance are referenced properly.
+ Entity ID references that are created from a slice instance entity can only reference to that slice instance entity. Other entities from the slice instance are not detected. To reference a different slice instance entity, you must create an entity ID reference.
+ If you directly reference UI entities in a **Script Canvas** graph, the time UI entities are modified when you are in game mode in Lumberyard Editor.

## Slices<a name="slices-known-issues-v1.12"></a>

Slices have the following known issues:
+ Changes that you make to a slice instance may impact the order of any child elements that are added to the slice instance.
+ When you push to a slice, do not attempt to push a new entity and a reference to that entity. If you do, a warning appears and the **Entity Inspector** shows the entity reference as removed. To work around this issue, right-click the parameter in the **Entity Inspector** and select **Reset value**.
+ A slice replication issue exists when a slice is instantiated on clients. For each netbound entity in the slice, a slice is added and non-networked entities are deleted.

## Starter Game<a name="starter-game-known-issues-v1.12"></a>

Starter Game has the following known issues:
+ Lumberyard Editor intermittently crashes when repeatedly entering or exiting gameplay.
+ When shooting the laser in gameplay mode, you may see a Replace Me texture on one side of the laser beam. The Replace Me texture displays until you shoot again. To work around this issue, restart the game session.
+ Starter Game may stop working if order-independent transparency (OIT) is enabled in Lumberyard Editor.

## Static Mesh Component<a name="static-mesh-component-known-issues-v1.12"></a>

The **Affects Navmesh** check box for the **Static Mesh** component does not affect nav mesh generation.

## Substance Editor<a name="substance-editor-known-issues-v1.12"></a>

Lumberyard Editor may become unresponsive and shut down if you attempt to delete or reimport Substance `.sbsar` files that were created in Lumberyard 6.0 or earlier.

## Terrain Textures<a name="terrain-texture-known-issues-v1.12"></a>

Terrain textures have the following known issues:
+ Projects that are created in Lumberyard 1.9 and earlier store and interpret terrain texture data as BGR format. In Lumberyard 1.10, terrain texture data was erroneously updated to store and interpret as RGB format. As a result of this change, any terrain created in Lumberyard 1.9 and earlier was stored as BGR but interpreted as RGB. The red and blue channels were swapped.

  The fix for this issue has the following impact:
  + Any terrain created in Lumberyard 1.10 is stored as RGB and interpreted as BGR.
  + Any terrain created in Lumberyard 1.9 and earlier is stored and interpreted as BGR.

  Because the default terrain texture is grayscale, this issue affects only terrain modified with color data in Lumberyard 1.10. To fix this issue, you can export the megatexture, swap red and blue using a paint program, and reimport the megatexture.
+ A missing `FTUE_MegaTexture_02.bmp` file is now available to download [here](https://dvbcuh49skxb5.cloudfront.net/releases/1.12/FTUE_MegaTexture_02.bmp). Right-click and save the mega terrain texture file to the `/lumberyard_version/dev/StarterGame/Textures/Terrain` directory.

## Track View<a name="track-view-known-issues-v1.12"></a>

The **Track View** editor has the following known issues:
+ The **Update** button in the **Render Output** dialog box does not work.
+ When you animate an **AnimObject** (legacy) or **Simple Animation** component, you must set the animation key's end time to any value other than zero. This allows the **Blend Gap** on the animation key to work properly.
+ Lumberyard Editor stops working if you delete a track view sequence entity from a sequence, and then press **Ctrl\+Z** to undo the delete. To work around this issue, do not add the sequence entity to its own sequence or any other sequence. 
+ To use character animation in track view sequences, you must enable the LegacyCryAnimation gem. This gem is disabled by default.
+ You may see undesired animation data if you allow automatic creation of root nodes when creating slices that contain a sequence entity. To work around this issue, manually group the entities under a single root entity. Then you can create the slice.

## Trigger Area Component<a name="trigger-area-component-known-issues-v1.12"></a>

The **Trigger Area** component has the following known issues:
+ In **AI/Physics** mode, the **Trigger Area** component is triggered by the editor's flying camera.
+ The target entities and associated actions section of the **Trigger Area** component is being deprecated. We recommend that you use Lua instead.
+ If you have a trigger area and a moving entity enters the area, an event fires. If you have a stationary entity and a moving trigger area envelops the entity, an event will not trigger.
+ Trigger areas are not triggered when a stationary entity is inside the area on game start.
+ Moving trigger areas cannot interact with stationary entities.

## Twitch ChatPlay and Twitch JoinIn<a name="twitch-chatplay-and-joinin-known-issues-v1.12"></a>

Twitch ChatPlay is no longer compatible with Lumberyard version 1.5 or earlier. To work around this issue, you can do one of the following:
+ Upgrade to Lumberyard version 1.6.
+ Merge the changes made to Twitch ChatPlay and the TwitchAPI in Lumberyard version 1.6 into your existing projects.

## UI Editor<a name="ui-canvas-editor-known-issues-v1.12"></a>

The UI Editor has the following known issues:
+ In the **Hierarchy** pane, when you drag a set of selected elements onto another to change the parent, the order will change to the order in which you selected the elements. To work around this issue, press **Ctrl\+X**, select the new parent, and then press **Ctrl\+Shift\+V**. You can also select the elements in the order in which to add them to the new parent by pressing **Shift** and clicking to select the elements. To select the elements in the existing order, press **Ctrl** and click to select the elements.
+ If you delete a child element from a slice instance, add a new child element, and then choose **Push to Slice**, the slice asset updates correctly but the slice instance is missing the new child. To work around this issue, delete the child element and push the change prior to adding a new child element and pushing that change.

## Virtual Reality<a name="virtual-reality-known-issues-v1.12"></a>

The virtual reality system has the following known issues:
+ Lumberyard's VR features are not functional if you are using the OSVR HDK headset on a Windows 7 PC with an NVIDIA graphics card.
+ Tracking performance on an Oculus device varies between level loads.
+ If you enable the OSVR gem, the NullVR gem will not initialize in a timely manner and the **VR Preview** button will appear disabled in the editor.
+ An issue with the Starting Point Input gem may cause an error when you start Lumberyard Editor. To work around this issue, do the following:

  1. Start the **Project Configurator**.

  1. In the **Project Configurator**, choose **Enable Gems** for **VirtualRealityProject**.

  1. On the **Gems** page, select **Script Canvas** and then click **Save**.

  1. Build your game project. For more information, see [Building Your Game Project](https://docs.aws.amazon.com/lumberyard/latest/userguide/building-your-lumberyard-game-project.html) in the *Amazon Lumberyard User Guide*

## Visual Studio Support<a name="visual-studio-support-known-issues-v1.12"></a>

Visual studio support has the following known issues:
+ Lumberyard has added support for Microsoft Visual Studio 2015 Update 3 or later. By default, the Visual Studio 2015 installation does not include C\+\+ as an installed language. In order to build, you must select **C\+\+**, its child options, and **MFC** during the Visual Studio 2015 installation. To verify your current installation, click **Control Panel**, **Programs and Features**, **Microsoft Visual Studio 2015**. Next, select **Modify** to view or add **C\+\+** and **MFC** support.
+ If you have Visual Studio 2015 installed and want to install the Autodesk FBX SDK, you must install the Visual Studio 2015 version of Autodesk.
+ Visual Studio 2013 will be deprecated in a future release. Lumberyard will support Visual Studio 2013 until the option is removed from the Lumberyard Setup Assistant.

## Waf Build System<a name="waf-build-system-known-issues-v1.12"></a>

If you attempt to build an existing project with the new Waf build system code base, projects that use the function `Path` in the wscript files may encounter Waf build errors. To resolve this issue, update the wscript files to use `bld.Path` instead.

## Waterfall Shader<a name="waterfall-shader-known-issue-v1.12"></a>

An issue with the [Waterfall shader](https://docs.aws.amazon.com/lumberyard/latest/userguide/shader-ref-waterfall.html) prevents it from moving and animating properly. To work around this issue, you can do either of the following:
+ Use the [Illum shader](https://docs.aws.amazon.com/lumberyard/latest/userguide/shader-ref-illum.html) to create a waterfall effect. For an example, see the [Starter Game sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-level-starter-game.html).
+ In the `Waterfall.cfx` file (located in the `/dev/Engine/Shaders/HWScripts` directory), update `float2 vTranslation = float2(PerFrame_Time.w, 0 );` to use `float2 vTranslation = float2(PerFrame_Time.x, 0 );`.

## Windows Environment Variables<a name="windows-environment-variables-known-issues-v1.12"></a>

If you set Windows environment variables (user or system), those values will override the settings in configuration files for programs such as Perforce, Autodesk Maya, and Lumberyard. This may cause issues when using these programs. We recommend that you do not set environment variables for these programs; instead you should use the settings in configuration files for these programs.

## Miscellaneous<a name="miscellaneous-known-issues-v1.12"></a>

The following are miscellaneous known issues:
+ The `OnSpawned()` method for `SpawnerComponentNotificationBus` passes a C\+\+ container to Lua, which causes an error.
+ Shutting down `CrySimpleManagedThread` objects produces a false positive "runaway thread" error for `dyad` and `httprequestmanager`. 
+ Occlusion/obstruction might only work for SoundObstructionType MultiRays. Setting audio entities to use SingleRay does not work correctly to draw an occlusion ray.
+ The Pendula Row simulations may experience unpredictable behavior when loaded into the runtime.
+ If a camera is placed at 0,0,0 on a map, nothing in the scene will render while the camera is the active view. This includes the level, debug text, UI, and dev console. There is currently no workaround if you encounter a black screen.
+ You cannot use a single name for multiple levels that are located in different project subfolders. Doing so will prevent these levels from launching properly in the game launcher executable.
+ You must re-export all levels before they will run in a game executable. Lumberyard includes a Python script that automates this process for game projects that have several levels. You can run the script from a command line window at your development root folder: `Bin64\Editor.exe /BatchMode /runpython "drive letter and Lumberyard path\dev\Editor\Scripts\export_all_levels.py"`
+ Executing the following command fails to create a deployment with an alternate stack name: 

  lmbr\_aws create-deployment --stack-name AlternateStack --deployment TestDeployment --confirm-aws-usage
+ The **ProjectOnStaticObjects** projection type for decals was removed, which impacts content that was created using Lumberyard 1.4 or earlier. Content that contains decals may have altered values for the projection type, thus changing the expected projection behavior. For example, **ProjectOnStaticObjects** may have been changed to **ProjectOnTerrain**. To work around this issue, you can run the following script to update the content that is affected by this change:

  [Decal Projection Python Script](https://forums.awsgametech.com/uploads/short-url/wMjFT26YHbn698fSQ1CYXKhG9kl.zip) (zip file)

  For more information, see [Static Decal Projection Issue Fix](https://forums.awsgametech.com/t/static-decal-projection-issue-fix/1803) in the forums.
**Note**  
The script does not differentiate between affected decals (created using Lumberyard 1.4 or earlier) and unaffected decals (created using Lumberyard 1.5 or later), so it should not be used on mixed source levels.
+ The `GameplayNotificationBus` is not supported in Lua and Flow Graph for float, Vector3, string, and EntityId.
+ If a Lua script is assigned to multiple entities, Lumberyard may report an error when the Lua asset is first loaded in game mode (**Ctrl\+G**). To work around this issue, enter game mode again.
+ In the Lua Editor, methods that are exposed to Lua from notification EBuses are not displayed in the **Classes Reference** section. The methods from request EBuses are displayed.
+ Material hotloading on entity overrides is not functional.