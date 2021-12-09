# Known Issues<a name="lumberyard-v1.9-known-issues"></a>

The following issues are known in Lumberyard Beta 1.9:

**3D Studio Max Tools and Plugin**
+ When using the 3ds Max plugin, you might receive a runtime error if you have an object selected with the CrySkin modifier and you right-click to dismiss the menu.
+ The following issues are known for the 3D Studio Max tools: 
  + Absolute paths are saved in MTL files that are created using the material editing tools in Max.
  + Rotations that are applied on the root bone of a skeleton will not load in Lumberyard. You will not receive an error message; however, to prevent this issue do not apply rotations to the root bone of a skeleton in Max.
  + To ensure Max exports correctly, you must save your `.max` file before changing the **Custom Export Path** field.

**3rdParty Directory**
+ Installation paths for the `3rdParty` directory cannot exceed the designated length. If you exceed the length limit, you will receive a notification.
+ The `3rdParty` directory cannot be changed while software is being downloaded. You can cancel the download or wait for it to complete.

**Android Support**
+ The AWS SDK does not initialize correctly on Android, which prevents projects with the AWS Gem enabled from running correctly.
+ API-19 is not currently supported.
+ An issue with the Lumberyard folder name can cause Android release builds to fail and prevent the APK from launching properly. To prevent this issue, ensure the installation directory does not contain a period (.) character.
+ The Android Launcher crashes when deployed to GLES 3.0 devices. To work around this issue, deploy to a GLES 3.1 or higher device.
+ Canvases are not rendered in the UiIn3DWorld map on Android.
+ Release builds are not functional. To work around this issue, use a profile build to generate optimized code.

**Area Objects and Triggers**
+ You can use area objects to create three dimensional zones in a level that are then used to trigger events. If a player is detected within the trigger volume of an area object, the trigger is activated. Area triggers that use the **AreaSolid** object type as the trigger detection volume do not work properly. You can use the **Shape** object type instead.

**Asset Pipeline**
+ If you switch branches, you must restart the Asset Processor.
+ Only asset types that have an implementation in the engine can live reload.
+ The Asset Processor reports all processing operations that failed with a **Crashed** status.
+ When using the asset importer, an access violation may occur when attempting to save.
+ Occasionally a CAF file might fail to move or copy from the source folder to the destination folder. To resolve this issue, rebuild by using the `AssetProcessorBatch.exe` file.
+ Searching for multiple space-delimited keywords in the Asset Browser exponentially degrades performance as the number of search terms increases.
+ An issue may prevent you from launching the editor after deleting the cache while the Asset Processor is running. To work around this issue, restart the Asset Processor and then relaunch the editor.

**Audio**
+ Sound obstruction does not run when you toggle **AI/Physics** mode.

**Audiokinetic Wwise and Wwise LTX**
+ The following issues are known when installing Wwise LTX:
  + An installation error may result in the following message: "Microsoft Visual C\+\+ 2008: Failed to execute the package: Fatal error during installation."

    To resolve this issue, do any of the following:
    + Click **Try Again** for the installer to attempt to install the package again.
    + Click **Cancel**. Run the `vc2008redist_x86.exe` and `vc2008redist_x64.exe` installers (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/`), and then run the installer again.
    + Click **Cancel**. Turn off any antivirus software that is running on your computer, and then run the installer again.
  + An access denied error may occur when using the **Extract** option in the Wwise LTX setup. To resolve this issue, manually run the installer (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/Wwise_v2015.2_LTX_Setup.exe`) as Administrator.
+ Lumberyard now supports Wwise 2016.1.1. If you attempt to use Wwise 2014 or Wwise 2015 with Lumberyard, you will encounter linker errors. To continue using an earlier version of Wwise, you can use the workaround described in the `wscript_wwise2015.readme.txt` file (located in the `\dev\Code\CryEngine\CrySoundSystem\implementations\CryAudioImplWwise` directory). 
+ Video playback is not yet capable of rendering audio. To work around this issue, use Wwise to play your video's audio separately.
+ Reloading the Audio Controls Editor after creating new controls without saving (thereby discarding your changes) can prevent the Wwise controls from returning to the unassigned state. If you discard your changes using this method, we recommend that you restart the Audio Controls Editor to prevent further issues.

**Audio Components EBus**
+ The following audio components EBus have been renamed for consistency across components:
  + **AudioTriggerComponentRequestsBus** renamed to **AudioTriggerComponentRequestBus**
  + **AudioTriggerComponentNotificationsBus** renamed to **AudioTriggerComponentNotificationBus**
  + **AudioRtpcComponentRequestsBus** renamed to **AudioRtpcComponentRequestBus**
  + **AudioSwitchComponentRequestsBus** renamed to **AudioSwitchComponentRequestBus**
  + **AudioEnvironmentComponentRequestsBus** renamed to **AudioEnvironmentComponentRequestBus**
  + **AudioProxyComponentRequestsBus** renamed to **AudioProxyComponentRequestBus**

  If you use the old EBus names in Lua or native C\+\+, you must update your code to use the new EBus names. This applies if you manipulate or call into the audio components from code.

**Audio Proxy Component**
+ The **Audio Proxy** component is meant to be a silent partner component for other audio components. All audio components depend on the **Audio Proxy** component. In order to use this component, you must manually add it to a new component entity.

**Builder SDK**
+ The Builder SDK is in preview, which means that you can create builders that are functional but the API may change subtly while it is finalized. Builders do not have access to common buses such as the asset bus; therefore, the only supported builders are ones that operate solely on given data and that output data directly. Builders that must make external asset calls or calls into game engine code are not supported.

**Cloud Canvas**
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

**Component Entity System**
+ The blend time key property on camera keys on a Director track does not work for **Camera** components.
+ Component entity sequences do not work with slices.
+ Component animation may not appear smooth in some circumstances.
+ The **Camera** component's **FrustumWidth** and **FrustumHeight** properties have no effect.
+ Renaming a component entity and then using **Undo** or **Redo** undoes the step before the rename.
+ Adding folders under components can lead to multiple issues, such as the components and tracks in the folder being unusable.
+ Component entities can be dragged into the **Track View** editor as children of other component entities.
+ The offset functionality does not work when you use the move or rotate tool on component entities with a track view animation on it. On legacy nodes, an offset is applied to all keys on the animation. This functionality does not work on component entities.
+ Transform animation paths are not drawn for component entities in the viewport.
+ Legacy cameras can be added to component entity sequences.
+ All component tracks are considered as "Others" in the **Custom Track Colors** dialog box.
+ When using component entity cameras, viewing through sequence cameras does not work when entering and exiting **AI/Physics** mode.
+ In the **Track View** editor node browser, the **Expand**, **Expand Entities** and **Collapse**, **Collapse Entities** functionality does not work on component entities.
+ The **Copy** and **Paste** functionality does not work to copy and paste component entities between sequences.
+ When adding an ambient track to a **Light** component entity, an initial keyframe does not appear as expected at time=0, which would disable the ambient flag initially to match the default value on the light.
+ Disabling a component entity node does not disable child components.
+ Auto-recording does not work for component entities.

**CryEngineNonRCModule**
+ `CryEngineNonRCModule` has been removed. If you are upgrading your projects from Lumberyard 1.4 or earlier, you must update all references of `CryEngineNonRCModule` to `CryEngineModule` in your wscript files.

**Data Types**
+ The CGA and ANM data types are deprecated.

**Decal Component**
+ The **Decal** component's visual representation has been updated to follow the entity's transform position. Now when you use a **Decal** component and move the object in-game, the location of the decal is updated. This update may introduce performance issues when several decals in the game frequently update their position.

**FBX Settings**
+ Adding a physics proxy rule to or removing one from a mesh group may cause `.cgf` assets to display incorrectly or prevent `.cgf` assets from rendering. To work around this issue, close and reopen Lumberyard Editor.
+ Errors that are generated by the Asset Processor are not displayed in the FBX Settings. To view these errors, open the Asset Processor from the Windows tray and double-click the failed job.
+ If source control is enabled and you change a file, it will be marked for add/edit in Perforce. Subsequent changes to the file will fail due to an error in the source control library. To work around this issue, revert changes before making any new changes, or check in changes before making any new changes. This allows you to make changes to previously changed files that have not been checked in.
+ The FBX Settings does not properly load all of the settings that are saved in an `fbx.assetinfo` file. To work around this issue, use a text editor to manually adjust the order of the settings.
+ The root bone must be at the identity in order to import skeletons and animation using the FBX Settings.
+ Creating new character files (`.cdf`) incorrectly produces an error and prevents the mesh from drawing. To work around this issue, load a different `.cdf` file and the new `.cdf` file will then load properly.
+ After you change the settings for an `.fbx` file, the referenced materials are incorrectly reported as broken until the material is updated. This occurs the first time you change the file's settings.

**FeatureTests**
+ The following maps in FeatureTests do not work properly on iOS and macOS:
  + HumanFeatureEyes
  + HumanFeatureHair
  + HumanFeatureSkin
  + GeometryBeam
+ If you are using the WeatherCloudBasic map in FeatureTests, the visual effect does not render properly on macOS, iOS, or Android.
+ If you are using the KeyboardBasic map, the project does not render properly on macOS.
+ If you are using the Decals map, one of the decals is missing, and another decal is projecting incorrectly.

**Flow Graph**
+ The `Game:Stop` node does not trigger on exit from game mode as expected. If you use the `Game:Stop` node to clean up flow graph activities that use ongoing resources, these activities may remain active.
+ The `Material:EntityMaterialParams` node does not apply changes made to the material parameters for an entity.
+ The `Material:MaterialParams` node does not allow any parameters to be selected.
+ From the context menu **Add Node**, **UIe**, the submenu is empty. To work around this issue, use the **Components** pane in the Flow Graph editor to add the UIe nodes.

**Game Mode Functionality**
+ The game mode (**Ctrl\+G**) functionality does not work as expected after creating a new level. To resolve this issue, you can save the new level immediately after creation and then reopen the level from the **File** menu in Lumberyard Editor.

**Gems**
+ When creating a new gem using the Project Configurator, a malformed file prevents tests from being built when using a test build configuration. To resolve this issue, modify the `gem_name_test.waf_files` file to use the name `gem_name_tests.waf_files`. For example, a new gem called MyGem with a file name `mygem_test.waf_files` would now be `mygem_tests.waf_files`.
+ An error message displays when creating a new gem and building the unit test configuration. To resolve this issue, edit the `GemName_tests.waf_files` files (located in the `dev\Gems\GemName\Code` directory) to replace **auto** with **none**. This allows you to compile the test profile spec for your gems.
+ If a gem attempts to use the EditorCore library as part of its build, the resource compiler may crash when attempting to build slices. To prevent this issue, do not use the EditorCore library with gems.
+ If you place only an I\_CAF in a gem, you cannot add your own `.animsettings` file. The `.animsettings` file must reside in the gem with the I\_CAF.

**Geppetto**
+ The **Copy Path** and **Show in Explorer** options in the context menu do not work correctly.
+ The **Clean Compiled Animations** option in the **File** menu does not work correctly. You can resolve this issue by navigating to the cache folder in the root engine directory and deleting the folder that contains the CAF files under the current development OS and game project. This action forces a recompile of all animations.
+ The **Color Hue** slider in the **Animation Event Presets** panel does not appear to slide in the UI; however, the value is updated in the **Color Hue** text field and in the viewport.
+ Skeletons exported from 3ds Max that have non-zero rotation values on the root joint, bone, or dummy are not supported.
+ Warnings may display if you switch between characters while animations are playing.
+ CGAs appear in the file browser if they are present in the asset tree; however, you should not use these files because the CGA file format is deprecated.
+ The side-by-side compression viewer compression is temporarily disabled.
+ The **Clean Compiled Animations** functionality is not working.
+ A workflow to create an `.animevents` file for a new character does not yet exist. You must create this file manually and add it to source control.
+ If multiple clips in a bspace use the same parametric value, a repeating error window will be displayed. You can resolve this issue by closing and reopening the editor. 
+ Lumberyard Editor crashes if you create and save a new character definition file (`.cdf`) and then repeatedly click the animation that you selected for the `.cdf` file. To prevent the editor from crashing, do not repeatedly click the animation. This allows the `.cdf` file to generate properly. 
+ If you create a new `.chr` file immediately after opening an existing `.chr` file, Lumberyard Editor may become unresponsive and fail. To prevent failure and potential data loss, be sure to save all changes and restart the editor before creating new `.chr` files.

**Gloss Maps**
+ Using gloss maps on imported Substances does not properly configure the gloss map. To work around this issue, if you plan to use a gloss map in the alpha channel of your Substance's normal map, manually export the normal map, and then connect it to your material like you normally would, but without using the Substance Editor to connect the normal map.

**High DPI Display Support**
+ Lumberyard now supports high DPI displays. Most elements in Lumberyard Editor will render at a reasonable size; however, some elements may still render too small. For example, some elements of the **Rollup Bar** render too small on high DPI displays.
+ Lumberyard supports whole number scale factors only. If the DPI is set to 1.5, the value will be rounded to 2. This will display most elements 0.5 times larger than expected.
+ When using Lumberyard Editor on a high DPI display, the mouse input for a UI canvas does not work properly. To work around this issue, close the editor, lower the resolution (for example, 1920 x 1080), and then restart the editor.

**Incredibuild**
+ When attempting to build Lumberyard with Incredibuild, builds running in parallel may occasionally fail due to missing moc files. You can retry the build or modify the `profile.xml` file (located in the `\Code\Tools\waf-1.7.3` directory) to set **AllowRemote** to **false** for the moc tool:

  ```
  <Tool Filename="moc" AllowIntercept="false" AllowRemote="false" AllowPredictedBatch="true" DeriveCaptionFrom="lastparam"/>
  ```

**Installation Paths**
+ An installation path that exceeds 54 characters may result in an error message or installation hang when installing third-party SDKs. To work around this issue, use the default Lumberyard installation path or ensure your installation path is 54 characters or less.
+ An installation path that meets or exceeds 64 characters will cause building Lumberyard to fail. To work around this issue, you can rename the package so that the path to `\dev` is less than 64 characters.
+ Running the `lmbr_waf` command on a path that includes spaces may result in errors and a build failure. To work around this issue, ensure that your installation path does not include spaces.

**iOS Support**
+ Running a debug build with **Metal validation** enabled causes a fatal assert. To resolve this issue, either run a profile build or disable **Metal validation**. For more information, see [iOS Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/ios-intro.html).
+ Textures with `colorspace=*,[auto|sRGB]` (see `Bin64\rc\rc.ini`) that are compressed by the Resource Compiler may crash when loaded on iOS devices. To resolve this issue, create an `.exportsettings` file with the same name, including the original extension, and add this file to the same folder as the source texture. For example, you can create `source.tif` and `source.tif.exportsettings`. Ensure the `.exportsettings` files contain the line `/preset=ReferenceImage`. This tells the Resource Compiler not to the compress the texture.
+ It is possible that, when deploying a debug build with a Virtual File System (VFS) configuration for iOS, the engine can take up to 20 minutes to initialize.
  + For debug builds, we recommend using a standard asset deployment.
  + For a VFS workflow, we recommend using it with profile builds until the issue is resolved.

**Legacy Sample (GameSDK)**
+ In a debug build, you might see errors and warnings when loading maps, for example the Woodland map.

**Lens Flare Elements**
+ Copying a lens flare element from one library and pasting it into another library produces scale and visibility issues for the copied lens flare elements. To work around this issue, copy the XML code from the source library into the target library—however, the issue persists when adding new flares and elements thereafter.
+ When you create a new texture and assign it to a lens flare, the rendered texture may appear blurry or low resolution. This is noticeable in the **Lens Flare Editor** and in gameplay mode. To work around this issue, you must set the **LensOptics** setting for lens flare textures. Navigate to the directory where your texture is saved, right-click the texture, and select **RC Open Image**. In the image dialog box, under **Preset**, select **LensOptics** from the drop-down list. Click **OK**.

**Lumberyard Editor**
+ The editor fails to start when building in debug/profile with the **editor and plugins** configuration. You can build using the **all** configuration instead.
+ The editor stops responding on exit if the system clock is inaccurate.
+ The GameSDK project displays several "Invalid geometric mean face area for node…" error messages when loading the Woodland level. You can ignore these non-fatal error messages.
+ The LOD Generation system does not work correctly and generates objects with distorted textures.
+ When using a system with an AMD graphics card, certain dynamic Global Illumination features are disabled by default, which disables indirect sun bounces. Enabling the `e_svoTI_GsmShiftBack` console variable causes the system to crash.
+ Using the Waterfall shader as a submaterial may cause the renderer to crash. You can resolve this issue by using a material that does not have submaterials for any mesh that requires the Waterfall shader.
+ The editor crashes if you extract the GameSDK package, configure the project as default, and launch the editor. This is caused by an incompatibility issue with the GameSDK package. To resolve this issue, ensure you are using the latest packages.
+ The editor randomly crashes if you attempt to use the Waterfall shader as a submaterial. When using the Waterfall shader, ensure the material does not have submaterials.
+ Floating windows cannot dock multiple windows.
+ When dialog boxes are docked together and then undocked, some dialog boxes do not appear in the foreground, despite being the active window.
+ If you attempt to generate a level without terrain, the **Generate Terrain** button in the **Terrain** menu will not function.
+ If you attempt to create a new level while Lumberyard Editor (`Editor.exe`) is maximized, the editor will minimize into windowed mode.
+ The viewport context menu item **Convert to Procedural Object** is missing, and its process cannot be accomplished by a workaround method.
+ Lumberyard Editor crashes if you attempt to load a new level or close the editor while the Sun Trajectory Tool is calculating. To work around this issue, wait for the tool to finish calculating before loading a new level or closing the editor. You can view the progress bar below the viewport.
+ If you make translate and scale changes to a designer object and then attempt to undo your changes, they will be undone out of order with other changes in the level. This can undo extraneous changes in certain situations.
+ When active, the **Use light probes** option disables **Total Illumination** diffuse and specular GI lighting contribution.
+ The CPU particles **SimplePhysics** and **RigidBody** collision types are not functional.
+ The **Dynamic 2D-Map** texture type may cause a crash when added as a texture on certain shaders. **Dynamic 2D-Map** is a deprecated texture type. The **LYShine UI** system and **2D** texture type replace **Dynamic 2D-Map**.

**Lumberyard Setup Assistant**
+ The Lumberyard Setup Assistant might fail to run if `msvcr120.dll` is not present. You can resolve this issue by installing the [Visual C\+\+ Redistributable Packages](http://www.microsoft.com/en-us/download/details.aspx?id=40784) for Visual Studio 2013.
+ Only one active instance of Lumberyard Setup Assistant is supported. Do not attempt to run multiple instances.
+ The Lumberyard Setup Assistant does not properly detect Python 3.x during the setup process. This can cause Lumberyard Editor to crash during startup due to an environment variable set by Python 3.x. To work around this issue, the Python 3.x home directory environment variable must be removed.
+ If you follow the onscreen installation instructions, the Lumberyard Setup Assistant does not properly detect Android NDK, Revision 11 or later. To resolve this issue, manually locate any of the subdirectories for `ndkpath/build`. For example, you can use any subdirectory of the build directory, such as `ndkpath/build/awk`.
+ You cannot download SDKs using the `SetupAssistantBatch.exe` file.
+ You can use the Lumberyard Setup Assistant to download SDKs that are required for Windows development using Visual Studio 2013 on Windows only. 
+ The progress percentage may change if you cancel a download.
+ The Lumberyard Setup Assistant lists Clang as an optional third-party SDK; however, the `MultiplayerProject_LinuxPacker.bat` file fails without this SDK. To work around this issue, do one of the following:
  + Install Clang from the Lumberyard Setup Assistant.
  + Edit the `MultiplayerProject_LinuxPacker.bat` file to delete: `Clang\3.7\linux_x64 ^` (line 64).
+ When you select **Compile the game code**, the Lumberyard Setup Assistant does not indicate that SDL2 is a required third-party SDK. To work around this issue, do one of the following:
  + Select additional compile capabilities on the **Get started** page.
  + Edit the `SetupAssistantConfig.json` file (located in the `\lumberyard\dev` directory) to include the following for the SDL2 entry:

    ```
    "roles" : ["compilegame", "compileengine", "compileeditor", "compileandroid"],
    ```
+ After a completed installation of the FBX SDK, you may see a Windows dialog box asking if the SDK was installed correctly.

**Lmbr\_test.cmd Tool**
+ The `lmbr_test.cmd` tool uses a Python SDK location that may not work if you use a new version of Lumberyard. To resolve this issue, you can edit `lmbr_test.cmd` to use the following values: 
  + Change `SET SDKS_DIR=%CMD_DIR%\Code\SDKs` to `SET SDKS_DIR=%CMD_DIR%\Tools`
  + Change `SET PYTHON=%PYTHON_DIR\x64\python.exe` to `SET PYTHON=%PYTHON_DIR\python.cmd`

**macOS Support**
+ Do not use spaces when you set the **whitelist** field in the `config.ini` file for the CrySCompileServer. This prevents validation of the IP address from failing.
+ You must install third-party SDKs in the `3rdParty` directory.
+ On macOS, renaming the root directory of a Lumberyard build will break all symbolic links that were created during setup. This prevents the build from compiling for iOS. To resolve this issue, you can undo renaming the root directory or you can manually delete all symbolic links that were created and then run the Lumberyard Setup Assistant again.
+ FeatureTests, SamplesProject, and MultiplayerSample are the only projects currently supported and must be run using Xcode.
+ The frost effect does not render properly.
+ The water flow effect does not work properly and, depending on the location and angle of the camera, disappears or stops animating. 
+ At certain view angles, the camera\_sample skybox renders day and night phases simultaneously.
+ Az Code Generator parsing lacks STL support.
+ macOS cannot compile successfully if there are spaces in the directory path.

**Mannequin**
+ The Transition Editor does not currently save any changes made.
+ The Mannequin Editor appears very small when you open it for the first time.

**Material Editor**
+ The Material Editor item tree displays a verbose path when you create a new material. You can resolve this issue by refreshing the item tree.
+ If you experience high latency on your source control connection, you may also experience slow performance when pressing **Show checked out materials**.
+ The Material Editor displays multiple instances of a material. To work around this issue, click the reload materials button in the Material Editor after loading a level.
+ An issue exists with changing **Vertex Deformation** values. Currently the Material Editor allows you to change the following values in the **Parameters** group: **Level**, **Amplitude**, **Phase**, and **Frequency**. Because the parameter type value is set to None instead of Sin, this can create confusion when you modify values. To work around this issue, ensure the parameter type value is set to Sin. This will allow the **Level**, **Amplitude**, **Phase**, and **Frequency** values to save properly.

**Maya**
+ In the Maya Lumberyard Tool, the UDP editing tool breaks if changes are made to the LY\_MAYA\_SCRIPT\_PATH. To customize tools, you should add your own environment variable rather than changing this package variable.
+ In the Maya Exporter, if an MTL file is marked as read-only, the **Export Materials** button will not export the material group again. Instead, a message will display that says, "0 material file(s) written." To prevent the message from displaying, you can manually check out MTL files before exporting again.
+ An issue with the Maya 2015 plugin may result in an import error message stating that there is no module named `mayaAnimUtilities`. To work around this issue, you can add the path from the `Maya.env` line to the **PYTHONPATH** variable in the system environment variables.

  For example, if this is your path from the `Maya.env` line: `LY_PYTHONPATH=E:\Amazon\Lumberyard\1.6.0.0\dev\Tools\maya\script`

  Add the following to the **PYTHONPATH** variable, using a semicolon to separate paths: `;E:\Amazon\Lumberyard\1.6.0.0\dev\Tools\maya\script`

**Mobile Support**
+ Do not use spaces when you set the **whitelist** field in the `config.ini` file for the CrySCompileServer. This prevents validation of the IP address from failing.

**Particle Editor**
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

**Perforce Source Control**
+ Some editor UIs will interact with your Perforce server. If the connection to your server is poor or you are experiencing other connection issues, the editor UI may briefly hitch during the connection attempt.
+ If Perforce is disabled and not configured and you attempt to delete a global flow graph module, an issue exists that causes the Flow Graph editor to display checkout dialog boxes. Although Perforce is disabled and not configured, you must click **Yes** and check out the file in order to delete it.
+ RequestEdit incorrectly reports success as false for the following statuses:
  + CheckedOutByOther
  + CheckedOutByYou
  + MarkedForAdd

  This issue can also occur when you change the editor to offline mode.

**Physics**
+ If a physics proxy rule is removed from a mesh group, you must do one of the following to remove the physics proxy material: 
  + Use the FBX Settings to create the existing `.mtl` file again.
  + Use the Material Editor to edit the existing `.mtl` file.
+ Physics meshes do not live reload properly for `.cgf` files when a change occurs on disk. To work around this issue, you can manually reload by clicking **Tools**, **Reload Scripts**, **Reload All Scripts** in Lumberyard Editor.
+ If you switch between mass and density on a Physics component, you must enter and exit game mode or enable AI/Physics mode for the change to take effect.

**Procedural Objects**
+ When you create a procedural object from a prefab, an error message displays and created objects disappear from the level. To work around this issue, you can save the level, close Lumberyard Editor, and then relaunch the editor. The objects will render properly in the viewport.

**Profiler**
+ Lumberyard Editor stops working if you attempt to profile your game while it is running in the editor. For more information about this tool, see [Profiler](https://docs.aws.amazon.com/lumberyard/latest/userguide/profiler-intro.html) in the *Amazon Lumberyard User Guide*.

**Resource Compiler**
+ The Resource Compiler may occasionally crash when processing textures, such as cubemaps. Lumberyard Editor will automatically resolve this issue by recompiling the affected asset.
+ The Resource Compiler fails to generate GeomCache files (`.cax`) properly, causing the editor to crash. The Resource Compiler may also deadlock.

**SamplesProject**
+ In the SamplesProject, Example 7 in the Trigger\_Sample map does not work. The door trigger does not open as expected.
+ The `SamplesProjectLauncher.exe` remains running in the Task Manager after quitting.

**Starter Game**
+ Lumberyard Editor intermittently crashes when repeatedly entering or exiting gameplay.
+ When shooting the laser in gameplay mode, you may see a Replace Me texture on one side of the laser beam. The Replace Me texture displays until you shoot again. To work around this issue, restart the game session.

**Static Mesh Component**
+ The **Affects Navmesh** check box for the Static Mesh component does not affect nav mesh generation.

**Slices**
+ An issue with compiling slices may impact the startup time of Lumberyard Editor. This occurs only the first time that you start the editor. This issue will be fixed in a future release.
+ Changes that you make to a slice instance may impact the order of any child elements that are added to the slice instance.

**Terrain Editor**
+ In the Terrain Editor, the **Flatten** and **Pick Height** tools only allow integer values, even if a level has decimal values in the terrain. Attempting to use decimal values will not work. For example, you cannot flatten to a height of 32.4. You must specify 32 or 33. **Pick Height** will also return height values of 32 when clicking a location that is 32.4 in actual height.

**Track View**
+ The left mouse button drag box marquee for selecting multiple keyframes does not work.
+ If you start Lumberyard Editor with the **Track View** editor docked as an editor pane, the **Key Properties** subpane within the **Track View** editor becomes permanently disabled. This prevents you from editing keys with the **Track View** editor. To resolve this issue, undock the **Track View** editor and then restart Lumberyard Editor.
+ If you delete a track view sequence that contains an event node, the editor may crash upon exit or when switching levels. This crash can result in the loss of any component entities that you have added to your level. To work around this issue, you can delete the event node from the sequence first, save the level, and then delete the sequence.
+ If the **Track View** editor is open, the **Sequence Properties** button is disabled when returning to editor mode from game mode.
+ The viewport **Sequence Camera** menu is disabled if there are no legacy cameras in the level.
+ The **Update** button in the **Render Output** dialog box does not work.
+ Changes that you make to a track view component entity sequence are not properly saved if the **Track View** editor window is closed when you attempt to save. To work around this issue, ensure the **Track View** editor window is open before saving your changes to the component entity sequence.

**Trigger Area Component**
+ The following issues are known for the **Trigger Area** component:
  + In **AI/Physics** mode, the **Trigger Area** component is triggered by the editor's flying camera.
  + The target entities and associated actions section of the **Trigger Area** component is being deprecated. We recommend that you use Lua instead.
  + If you have a trigger area and a moving entity enters the area, an event fires. If you have a stationary entity and a moving trigger area envelops the entity, an event will not trigger.
  + Trigger areas are not triggered when a stationary entity is inside the area on game start.
  + Moving trigger areas cannot interact with stationary entities.

**Twitch ChatPlay and Twitch JoinIn**
+ Twitch ChatPlay is no longer compatible with Lumberyard version 1.5 or earlier. To work around this issue, you can do one of the following:
  + Upgrade to Lumberyard version 1.6.
  + Merge the changes made to Twitch ChatPlay and the TwitchAPI in Lumberyard version 1.6 into your existing projects.

**UI Editor**
+ In the **Hierarchy** pane, when you drag a set of selected elements onto another to change the parent, the order will change to the order in which you selected the elements. To work around this issue, press **Ctrl\+X**, select the new parent, and then press **Ctrl\+Shift\+V**. You can also select the elements in the order in which to add them to the new parent by pressing **Shift** and clicking to select the elements. To select the elements in the existing order, press **Ctrl** and click to select the elements.

**Virtual Reality**
+ Lumberyard's VR features are not functional if you are using the OSVR HDK headset on a Windows 7 PC with an NVIDIA graphics card.
+ Tracking performance on an Oculus device varies between level loads.

**Visual Studio Support**
+ Lumberyard has added support for Microsoft Visual Studio 2015 Update 3 or later. By default, the Visual Studio 2015 installation does not include C\+\+ as an installed language. In order to build, you must select **C\+\+**, its child options, and **MFC** during the Visual Studio 2015 installation. To verify your current installation, click **Control Panel**, **Programs and Features**, **Microsoft Visual Studio 2015**. Next, select **Modify** to view or add **C\+\+** and **MFC** support.
+ If you have Visual Studio 2015 installed and want to install the Autodesk FBX SDK, you must install the Visual Studio 2015 version of Autodesk.

**Waf Build System**
+ If you attempt to build an existing project with the new Waf build system code base, projects that use the function `Path` in the wscript files may encounter Waf build errors. To resolve this issue, update the wscript files to use `bld.Path` instead.

**Waterfall Shader**
+ An issue with the [Waterfall shader](https://docs.aws.amazon.com/lumberyard/latest/userguide/shader-ref-waterfall.html) prevents it from moving and animating properly. To work around this issue, you can do either of the following:
  + Use the [Illum shader](https://docs.aws.amazon.com/lumberyard/latest/userguide/shader-ref-illum.html) to create a waterfall effect. For an example, see the [Starter Game sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-level-starter-game.html).
  + In the `Waterfall.cfx` file (located in the `/dev/Engine/Shaders/HWScripts` directory), update `float2 vTranslation = float2(PerFrame_Time.w, 0 );` to use `float2 vTranslation = float2(PerFrame_Time.x, 0 );`.

**Windows Environment Variables**
+ If you set Windows environment variables (user or system), those values will override the settings in configuration files for programs such as Perforce, Autodesk Maya, and Lumberyard. This may cause issues when using these programs. We recommend that you do not set environment variables for these programs; instead you should use the settings in configuration files for these programs.

**Miscellaneous**
+ The `OnSpawned()` method for SpawnerComponentNotificationBus passes a C\+\+ container to Lua, which causes an error.
+ Shutting down `CrySimpleManagedThread` objects produces a false positive "runaway thread" error for `dyad` and `httprequestmanager`. 
+ Occlusion/obstruction might only work for SoundObstructionType MultiRays. Setting audio entities to use SingleRay does not work correctly to draw an occlusion ray.
+ The Pendula Row simulations may experience unpredictable behavior when loaded into the runtime.
+ If a camera is placed at 0,0,0 on a map, nothing in the scene will render while the camera is the active view. This includes the level, debug text, UI, and dev console. There is currently no workaround if you encounter a black screen.
+ You cannot use a single name for multiple levels that are located in different project subfolders. Doing so will prevent these levels from launching properly in the game launcher executable.
+ You must re-export all levels before they will run in a game executable. Lumberyard includes a Python script that automates this process for game projects that have several levels. You can run the script from a command line window at your development root folder: `Bin64\Editor.exe /BatchMode /runpython "drive letter and Lumberyard path\dev\Editor\Scripts\export_all_levels.py"`
+ Executing the following command fails to create a deployment with an alternate stack name: `lmbr_aws create-deployment --stack-name AlternateStack --deployment TestDeployment --confirm-aws-usage`
+ The **ProjectOnStaticObjects** projection type for decals was removed, which impacts content that was created using Lumberyard 1.4 or earlier. Content that contains decals may have altered values for the projection type, thus changing the expected projection behavior. For example, **ProjectOnStaticObjects** may have been changed to **ProjectOnTerrain**. To work around this issue, you can run the following script to update the content that is affected by this change:

  [Decal Projection Python Script](https://forums.awsgametech.com/uploads/short-url/wMjFT26YHbn698fSQ1CYXKhG9kl.zip) (zip file)

  For more information, see [Static Decal Projection Issue Fix](https://forums.awsgametech.com/t/static-decal-projection-issue-fix/1803) in the forums.
**Note**  
The script does not differentiate between affected decals (created using Lumberyard 1.4 or earlier) and unaffected decals (created using Lumberyard 1.5 or later), so it should not be used on mixed source levels.
+ The `GameplayNotificationBus` is not supported in Lua and Flow Graph for float, Vector3, string, and EntityId.
+ If a Lua script is assigned to multiple entities, Lumberyard may report an error when the Lua asset is first loaded in game mode (**Ctrl\+G**). To work around this issue, enter game mode again.
+ In the Lua Editor, methods that are exposed to Lua from notification EBuses are not displayed in the **Classes Reference** section. The methods from request EBuses are displayed.
+ HTTP POST requests ignore what you provide and send an empty body in their payloads.