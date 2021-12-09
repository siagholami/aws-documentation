# Known Issues<a name="lumberyard-v1.6-known-issues"></a>

The following issues are known in Lumberyard Beta 1.6:
+ The following issues are known for high DPI display support:
  + Lumberyard now supports high DPI displays. Most elements in Lumberyard Editor will render at a reasonable size; however, some elements may still render too small. For example, some elements of the **Rollup Bar** render too small on high DPI displays.
  + Lumberyard supports whole number scale factors only. If the DPI is set to 1.5, the value will be rounded to 2. This will display most elements 0.5 times larger than expected.
  + When using Lumberyard Editor on a high DPI display, the mouse input for a UI canvas does not work properly. To work around this issue, close the editor, lower the resolution (for example, 1920 x 1080), and then restart the editor.
+ Installation paths for the `3rdParty` directory cannot exceed the designated length. If you exceed the length limit, you will receive a notification.
+ The `3rdParty` directory cannot be changed while software is being downloaded. You can cancel the download or wait for it to complete.
+ If you set Windows environment variables (user or system), those values will override the settings in configuration files for programs such as Perforce, Autodesk Maya, and Lumberyard. This may cause issues when using these programs. We recommend that you do not set environment variables for these programs; instead you should use the settings in configuration files for these programs.
+ The following issues are known for the Lumberyard Setup Assistant:
  + The Lumberyard Setup Assistant might fail to run if `msvcr120.dll` is not present. You can resolve this issue by installing the [Visual C\+\+ Redistributable Packages](http://www.microsoft.com/en-us/download/details.aspx?id=40784) for Visual Studio 2013.
  + Only one active instance of Lumberyard Setup Assistant is supported. Do not attempt to run multiple instances.
  + The Lumberyard Setup Assistant does not properly detect Python 3.x during the setup process. This issue does not impact compiling or using Lumberyard Editor.
  + If you follow the onscreen installation instructions, the Lumberyard Setup Assistant does not properly detect Android NDK, Revision 11 or later. To resolve this issue, manually locate any of the subdirectories for `ndkpath/build`. For example, you can use any subdirectory of the build directory, such as `ndkpath/build/awk`.
  + You cannot download SDKs using the `SetupAssistantBatch.exe` file.
  + You can use the Lumberyard Setup Assistant to download SDKs that are required for Windows development using Visual Studio 2013 on Windows only. 
  + The progress percentage may change if you cancel a download.
+ The following issues are known when installing Wwise LTX:
  + An installation error may result in the following message: "Microsoft Visual C\+\+ 2008: Failed to execute the package: Fatal error during installation."

    To resolve this issue, do any of the following:
    + Click **Try Again** for the installer to attempt to install the package again.
    + Click **Cancel**. Run the `vc2008redist_x86.exe` and `vc2008redist_x64.exe` installers (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/`), and then run the installer again.
    + Click **Cancel**. Turn off any antivirus software that is running on your computer, and then run the installer again.
  + An access denied error may occur when using the **Extract** option in the Wwise LTX setup. To resolve this issue, manually run the installer (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/Wwise_v2015.2_LTX_Setup.exe`) as Administrator.
+ Lumberyard now supports Wwise 2016.1.1. If you attempt to use Wwise 2014 or Wwise 2015 with Lumberyard, you will encounter linker errors. To continue using an earlier version of Wwise, you can use the workaround described in the `wscript_wwise2015.readme.txt` file (located in the `\dev\Code\CryEngine\CrySoundSystem\implementations\CryAudioImplWwise` directory). 
+ If you are using a Mac: 
  + You must install third-party SDKs in the `3rdParty` directory.
  + On macOS, renaming the root directory of a Lumberyard build will break all symbolic links that were created during setup. This prevents the build from compiling for iOS. To resolve this issue, you can undo renaming the root directory or you can manually delete all symbolic links that were created and then run the Lumberyard Setup Assistant again.
  + A PC is still required to run the shader compiler when running a level for the first time. 
  + FeatureTests and SamplesProject are the only projects currently supported and must be run using Xcode. 
  + The TouchRayCast map in FeatureTests does not print text when you hover the mouse over each object. 
  + The frost effect does not render properly. 
  + The water flow effect does not work properly and, depending on the location and angle of the camera, disappears or stops animating. 
  + At certain view angles, the camera\_sample skybox renders day and night phases simultaneously.
  + Az Code Generator parsing lacks STL support.
  + Compiling may result in the following error: Argument list too long. To work around this issue, use the `--use-uber-files=True` command line option when you invoke lmbr\_waf build commands. Alternatively, you can edit the `user_settings.options` file (located in the `\dev` directory) to set the `use_uber_files` value to **True**.
+ The following issues are known if you use Perforce: 
  + Some editor UIs will interact with your Perforce server. If the connection to your server is poor or you are experiencing other connection issues, the editor UI may briefly hitch during the connection attempt.
  + If Perforce is disabled and not configured and you attempt to delete a global flow graph module, an issue exists that causes the Flow Graph editor to display checkout dialog boxes. Although Perforce is disabled and not configured, you must click **Yes** and check out the file in order to delete it.
  + RequestEdit incorrectly reports success as false for the following statuses:
    + CheckedOutByOther
    + CheckedOutByYou
    + MarkedForAdd

    This issue can also occur when you change the editor to offline mode.
+ The following issues are known for the asset pipeline: 
  + If you switch branches, you must restart the Asset Processor.
  + Only asset types that have an implementation in the engine can live reload.
  + The Asset Processor reports all processing operations that failed with a **Crashed** status.
  + When using the asset importer, an access violation may occur when attempting to save.
+ Occasionally a CAF file might fail to move or copy from the source folder to the destination folder. To resolve this issue, rebuild by using the `AssetProcessorBatch.exe` file.
+ The game mode (**Ctrl\+G**) functionality does not work as expected after creating a new level. To resolve this issue, you can save the new level immediately after creation and then reopen the level from the **File** menu in Lumberyard Editor.
+ The CGA and ANM data types are deprecated.
+ You can use area objects to create three dimensional zones in a level that are then used to trigger events. If a player is detected within the trigger volume of an area object, the trigger is activated. Area triggers that use the **AreaSolid** object type as the trigger detection volume do not work properly. You can use the **Shape** object type instead.
+ You must re-export all levels before they will run in a game executable. Lumberyard includes a Python script that automates this process for game projects that have several levels. You can run the script from a command line window at your development root folder: `Bin64\Editor.exe /BatchMode /runpython "drive letter and Lumberyard path\dev\Editor\Scripts\export_all_levels.py"`
+ You cannot use a single name for multiple levels that are located in different project subfolders. Doing so will prevent these levels from launching properly in the game launcher executable.
+ The following issues are known for Lumberyard Editor: 
  + The editor fails to start when building in debug/profile with the **editor and plugins** configuration. You can build using the **all** configuration instead.
  + The editor stops responding on exit if the system clock is inaccurate.
  + The GameSDK project displays several "Invalid geometric mean face area for node…" error messages when loading the Woodland level. You can ignore these non-fatal error messages.
  + The LOD Generation system does not work correctly and generates objects with distorted textures.
  + When using a system with an AMD graphics card, certain dynamic Global Illumination features are disabled by default, which disables indirect sun bounces. Enabling the `e_svoTI_GsmShiftBack` console variable causes the system to crash.
  + Using the Waterfall shader as a submaterial may cause the renderer to crash. You can resolve this issue by using a material that does not have submaterials for any mesh that requires the Waterfall shader.
  + The editor crashes if you attempt to do the following: create a new project in the Project Configurator, set the project as the default, enable all gems, and build the project using `lmbr_waf.bat configure` and `lmbr_waf.bat build_win_x64_profile -p all`. Specifically, the editor crashes if you enable both the **GameLift** Gem and **Multiplayer** Gem. To resolve this issue, do not use both gems in the same project.
  + The editor crashes if you extract the GameSDK package, configure the project as default, and launch the editor. This is caused by an incompatibility issue with the GameSDK package. To resolve this issue, ensure you are using the latest packages.
  + The editor randomly crashes if you attempt to use the Waterfall shader as a submaterial. When using the Waterfall shader, ensure the material does not have submaterials.
  + Floating windows cannot dock multiple windows.
  + When dialog boxes are docked together and then undocked, some dialog boxes do not appear in the foreground, despite being the active window.
  + If you attempt to generate a level without terrain, the **Generate Terrain** button in the **Terrain** menu will not function.
  + If you attempt to create a new level while Lumberyard Editor (`Editor.exe`) is maximized, the editor will minimize into windowed mode.
+ The following issues are known for the Geppetto tool: 
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
+ The following issues are known for the FBX Settings:
  + Adding a physics proxy rule to or removing one from a mesh group may cause `.cgf` assets to display incorrectly or prevent `.cgf` assets from rendering. To work around this issue, close and reopen Lumberyard Editor.
  + Errors that are generated by the Asset Processor are not displayed in the FBX Settings. To view these errors, open the Asset Processor from the Windows tray and double-click the failed job.
  + If source control is enabled and you change a file, it will be marked for add/edit in Perforce. Subsequent changes to the file will fail due to an error in the source control library. To work around this issue, revert changes before making any new changes, or check in changes before making any new changes. This allows you to make changes to previously changed files that have not been checked in.
  + The FBX Settings does not properly load all of the settings that are saved in an `fbx.assetinfo` file. To work around this issue, use a text editor to manually adjust the order of the settings.
+ If a physics proxy rule is removed from a mesh group, you must do one of the following to remove the physics proxy material: 
  + Use the FBX Settings to create the existing `.mtl` file again.
  + Use the Material Editor to edit the existing `.mtl` file.
+ The following issues are known for the Mannequin tool: 
  + The Transition Editor does not currently save any changes made.
  + The Mannequin Editor appears very small when you open it for the first time.
+ Physics meshes do not live reload properly for CGF files when a change occurs on disk. To work around this issue, you can manually reload by clicking **Tools**, **Reload Scripts**, **Reload All Scripts** in Lumberyard Editor.
+ In the Maya Exporter, if an MTL file is marked as read-only, the **Export Materials** button will not export the material group again. Instead, a message will display that says, "0 material file(s) written." To prevent the message from displaying, you can manually check out MTL files before exporting again.
+ In the Maya Lumberyard Tool, the UDP editing tool breaks if changes are made to the LY\_MAYA\_SCRIPT\_PATH. To customize tools, you should add your own environment variable rather than changing this package variable.
+ When using the 3ds Max plugin, you might receive a runtime error if you have an object selected with the CrySkin modifier and you right-click to dismiss the menu.
+ The following issues are known for the 3D Studio Max tools: 
  + Absolute paths are saved in MTL files that are created using the material editing tools in Max.
  + Rotations that are applied on the root bone of a skeleton will not load in Lumberyard. You will not receive an error message; however, to prevent this issue do not apply rotations to the root bone of a skeleton in Max.
  + To ensure Max exports correctly, you must save your `.max` file before changing the **Custom Export Path** field.
+ The Pendula Row simulations may experience unpredictable behavior when loaded into the runtime.
+ The `OnSpawned()` method for SpawnerComponentNotificationBus passes a C\+\+ container to Lua, which causes an error.
+ The **Affects Navmesh** check box for the Static Mesh component does not affect nav mesh generation.
+ If you switch between mass and density on a Physics component, you must enter and exit game mode or enable AI/Physics mode for the change to take effect.
+ The following issues are known for the Trigger Area component:
  + In AI/Physics mode, the Trigger Area component is triggered by the editor's flying camera.
  + The target entities and associated actions section of the Trigger Area component is being deprecated. We recommend that you use Lua instead.
  + If you have a trigger area and a moving entity enters the area, an event fires. If you have a stationary entity and a moving trigger area envelops the entity, an event will not trigger.
+ In the Terrain Editor, the **Flatten** and **Pick Height** tools only allow integer values, even if a level has decimal values in the terrain. Attempting to use decimal values will not work. For example, you cannot flatten to a height of 32.4. You must specify 32 or 33. **Pick Height** will also return height values of 32 when clicking a location that is 32.4 in actual height.
+ The following issues are known for the Material Editor: 
  + The Material Editor item tree displays a verbose path when you create a new material. You can resolve this issue by refreshing the item tree.
+ In the Particle Editor, the following keyboard shortcuts do not work properly: 
  + Rename (**Ctrl\+R**)
  + Open in New Tab (**Ctrl\+O**)
  + Copy (**Ctrl\+C**)
  + Paste (**Ctrl\+V**)
  + Export Library (**Ctrl\+Shift\+E**)

  The Directory shortcuts in the **Import** window do not work as well.
+ The following issues are known for the UI Editor: 
  + In the **Hierarchy** pane, when you drag a set of selected elements onto another to change the parent, the order will change to the order in which you selected the elements. To work around this issue, press **Ctrl\+X**, select the new parent, and then press **Ctrl\+Shift\+V**. You can also select the elements in the order in which to add them to the new parent by pressing **Shift** and clicking to select the elements. To select the elements in the existing order, press **Ctrl** and click to select the elements.
+ The following issues are known for the **Track View** editor: 
  + The left mouse button drag box marquee for selecting multiple keyframes does not work.
  + If you start Lumberyard Editor with the **Track View** editor docked as an editor pane, the **Key Properties** subpane within the **Track View** editor becomes permanently disabled. This prevents you from editing keys with the **Track View** editor. To resolve this issue, undock the **Track View** editor and then restart Lumberyard Editor.
+ The following issues are known for gems: 
  + When creating a new gem using the Project Configurator, a malformed file prevents tests from being built when using a test build configuration. To resolve this issue, modify the `gem_name_test.waf_files` file to use the name `gem_name_tests.waf_files`. For example, a new gem called MyGem with a file name `mygem_test.waf_files` would now be `mygem_tests.waf_files`.
  + An error message displays when creating a new gem and building the unit test configuration. To resolve this issue, edit the `GemName_tests.waf_files` files (located in the `dev\Gems\GemName\Code` directory) to replace **auto** with **none**. This allows you to compile the test profile spec for your gems.
+ The Resource Compiler may occasionally crash when processing textures, such as cubemaps. Lumberyard Editor will automatically resolve this issue by recompiling the affected asset.
+ Occlusion/obstruction might only work for SoundObstructionType MultiRays. Setting audio entities to use SingleRay does not work correctly to draw an occlusion ray.
+ The following issues are known for flow graph: 
  + The `Game:Stop` node does not trigger on exit from game mode as expected. If you use the `Game:Stop` node to clean up flow graph activities that use ongoing resources, these activities may remain active.
  + The `Material:EntityMaterialParams` node does not apply changes made to the material parameters for an entity.
  + The `Material:MaterialParams` node does not allow any parameters to be selected.
+ In the SamplesProject, Example 7 in the Trigger\_Sample map does not work. The door trigger does not open as expected.
+ The following issues are known for the Legacy Sample: 
  + If you are using the heavy machine gun, animation may not display correctly when you enter third-person view in game mode.
  + In a debug build, you might see errors and warnings when loading maps, for example the Woodland map.
+ Reloading the Audio Controls Editor after creating new controls without saving (thereby discarding your changes) can prevent the Wwise controls from returning to the unassigned state. If you discard your changes using this method, we recommend that you restart the Audio Controls Editor to prevent further issues.
+ Hosting or connecting to servers in the MultiplayerLobby in the MultiplayerProject does not work on macOS.
+ The following maps in FeatureTests do not work properly on iOS and macOS:
  + HumanFeatureEyes
  + HumanFeatureHair
  + HumanFeatureSkin
  + GeometryBeam
+ The following issues are known for iOS support: 
  + Running a debug build with **Metal validation** enabled causes a fatal assert. To resolve this issue, either run a profile build or disable **Metal validation**. For more information, see [iOS Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/ios-intro.html).
  + Textures with `colorspace=*,[auto|sRGB]` (see `Bin64\rc\rc.ini`) that are compressed by the Resource Compiler may crash when loaded on iOS devices. To resolve this issue, create an `.exportsettings` file with the same name, including the original extension, and add this file to the same folder as the source texture. For example, you can create `source.tif` and `source.tif.exportsettings`. Ensure the `.exportsettings` files contain the line `/preset=ReferenceImage`. This tells the Resource Compiler not to the compress the texture.
  + Release builds are not supported.
  + It is possible that, when deploying a debug build with a Virtual File System (VFS) configuration for iOS, the engine can take up to 20 minutes to initialize.
    + For debug builds, we recommend using a standard asset deployment.
    + For utilizing a VFS workflow, we recommend using it with Profile builds until the issue is resolved.
  + Compiling may result in the following error: Argument list too long. To work around this issue, use the `--use-uber-files=True` command line option when you invoke lmbr\_waf build commands. Alternatively, you can edit the `user_settings.options` file (located in the `\dev` directory) to set the `use_uber_files` value to **True**.
+ The following issues are known for Android support: 
  + Release builds are not supported.
  + Live reloading over VFS is not working properly.
  + If you want to use Clang and target API-19 devices, we recommend that you target API-19 in the Android manifest (located in the `dev\Code\Launcher\AndroidLauncher\ProjectBuilder` directory). This allows you to work around the API version limitation. The Android manifest is set for API-19 by default:

    ```
    <!-- This is the platform API where NativeActivity was introduced. -->
    <uses-sdk android:minSdkVersion="19" />
    ```
  + Allowing a level with physics simulation to extensively run on an Android device can cause the game to assert or crash in debug, or freeze the game in profile.
+ The following issues are known for using Lumberyard with Android Studio: 
  + In order for debugging to work properly, libraries are packaged with debug symbols in the APK. This can cause long durations for the APK package and installation process due to the size of the APK (approximately 650-700 MB).
  + To work around issues that may result when a project is regenerated while open in Android Studio, you can do the following: 
    + Ignore the **Configure project** dialog box that appears in the upper right corner of the main window.
    + Close Android Studio and reopen the project. You can also close Android Studio and import the project.
  + You must run Android Studio as Administrator.
+ The following issues are known for FeatureTests: 
  + If you are using the WeatherCloudBasic map in FeatureTests, the visual effect does not render properly on macOS, iOS, or Android.
  + If you are using the KeyboardBasic map, the project does not render properly on macOS.
  + If you are using the Decals map, one of the decals is missing, and another decal is projecting incorrectly.
+ When developing for console, the current project is specified in the `bootstrap.cfg` file. If multiple projects are enabled in the `user_settings.options` file, you must specify the current project as the first project in the enabled projects list in the `user_settings.options` file.
+ Shutting down `CrySimpleManagedThread` objects produces a false positive "runaway thread" error for `dyad` and `httprequestmanager`. 
+ The following issues are known for Twitch ChatPlay and Twitch JoinIn: 
  + The Twitch IRC group server list that is used for Whispers is hardcoded (see `ChatPlayCVars.cpp`).
  + The Twitch JoinIn CreateLink flow node hardcodes the protocol that is used for the JoinIn link `game:`. We recommend that you do not use the game protocol in any end-user applications. The generic name may cause conflicts with other applications.
  + Twitch ChatPlay is no longer compatible with Lumberyard version 1.5 or earlier. To work around this issue, you can do one of the following:
    + Upgrade to Lumberyard version 1.6.
    + Merge the changes made to Twitch ChatPlay and the TwitchAPI in Lumberyard version 1.6 into your existing projects.
+ The following issues are known for Cloud Canvas:
  + Pressing **Ctrl\+F** in Cloud Canvas's Resource Manager opens the **Editor Unfreeze All** window rather than the expected **Search** window. To open the **Search** window, click **Edit**, **Search**.
  + If you upload Cloud Canvas resources and then attempt to run your game in Lumberyard Editor, the game fails to run and gives the error `MissingAuthenticationTokenException`. This is caused by a bug in which the resource map does not update when you create a new Cloud Canvas stack or change resources.

    A related issue occurs when you use the Cloud Canvas Resource Manager to add a resource. Adding the resource succeeds, but the resource mapping silently fails. When you run the game in Lumberyard Editor, the resource is not available.

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
+ If you attempt to build an existing project with the new Waf build system code base, projects that use the function `Path` in the wscript files may encounter Waf build errors. To resolve this issue, update the wscript files to use `bld.Path` instead.
+ When attempting to build Lumberyard with Incredibuild, builds running in parallel may occasionally fail due to missing moc files. You can retry the build or modify the `profile.xml` file (located in the `\Code\Tools\waf-1.7.3` directory) to set **AllowRemote** to **false** for the moc tool:

  ```
  <Tool Filename="moc" AllowIntercept="false" AllowRemote="false" AllowPredictedBatch="true" DeriveCaptionFrom="lastparam"/>
  ```
+ The `lmbr_test.cmd` tool uses a Python SDK location that may not work if you use a new version of Lumberyard. To resolve this issue, you can edit `lmbr_test.cmd` to use the following values: 
  + Change `SET SDKS_DIR=%CMD_DIR%\Code\SDKs` to `SET SDKS_DIR=%CMD_DIR%\Tools`
  + Change `SET PYTHON=%PYTHON_DIR\x64\python.exe` to `SET PYTHON=%PYTHON_DIR\python.cmd`
+ The Builder SDK is in preview, which means that you can create builders that are functional but the API may change subtly while it is finalized. Builders do not have access to common buses such as the asset bus; therefore, the only supported builders are ones that operate solely on given data and that output data directly. Builders that must make external asset calls or calls into game engine code are not supported.
+ Using gloss maps on imported Substances does not properly configure the gloss map. To work around this issue, if you plan to use a gloss map in the alpha channel of your Substance's normal map, manually export the normal map, and then connect it to your material like you normally would, but without using the Substance Editor to connect the normal map.
+ Lumberyard's VR features are not functional if you are using the OSVR HDK headset on a Windows 7 PC with an NVIDIA graphics card.
+ The `SamplesProjectLauncher.exe` remains running in the Task Manager after quitting.
+ Copying a lens flare element from one library and pasting it into another library produces scale and visibility issues for the copied lens flare elements. To work around this issue, copy the XML code from the source library into the target library—however, the issue persists when adding new flares and elements thereafter. 
+ The viewport context menu item **Convert to Procedural Object** is missing, and its process cannot be accomplished by a workaround method.
+ If a camera is placed at 0,0,0 on a map, nothing in the scene will render while the camera is the active view. This includes the level, debug text, UI, and dev console. There is currently no workaround if you encounter a black screen.
+ `CryEngineNonRCModule` has been removed. If you are upgrading your projects from Lumberyard 1.4 or earlier, you must update all references of `CryEngineNonRCModule` to `CryEngineModule` in your wscript files.
+ The **ProjectOnStaticObjects** projection type for decals was removed, which impacts content that was created using Lumberyard 1.4 or earlier. Content that contains decals may have altered values for the projection type, thus changing the expected projection behavior. For example, **ProjectOnStaticObjects** may have been changed to **ProjectOnTerrain**. To work around this issue, you can run the following script to update the content that is affected by this change:

  [Decal Projection Python Script](https://forums.awsgametech.com/uploads/short-url/wMjFT26YHbn698fSQ1CYXKhG9kl.zip) (zip file)

  For more information, see [Static Decal Projection Issue Fix](https://forums.awsgametech.com/t/static-decal-projection-issue-fix/1803) in the forums.
**Note**  
The script does not differentiate between affected decals (created using Lumberyard 1.4 or earlier) and unaffected decals (created using Lumberyard 1.5 or later), so it should not be used on mixed source levels.