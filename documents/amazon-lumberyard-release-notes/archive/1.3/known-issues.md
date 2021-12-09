# Known Issues<a name="lumberyard-v1.3-known-issues"></a>

The following issues are known in Lumberyard Beta 1.3:
+ If you use Windows 8 or later on a high-dpi monitor, Lumberyard has high-dpi scaling issues that interfere with the usability of the layout and user interface. Selecting **Disable display scaling on high DPI settings** in the `editor.exe` properties window will not fix the issue.

  To resolve this issue, do one of the following: 
  + (Recommended) Set your monitor to a resolution that is not high DPI. On your desktop, right-click and select **Screen resolution**. In the **Screen Resolution** dialog box, select **1920 x 1080** from the **Resolution** drop-down list. Click **OK**. 
  + Keep your current resolution and view the Lumberyard user interface smaller on the screen. Go to **Control Panel**, **Appearance and Personalization**. Under **Display**, click **Make text and other items larger or smaller**. In the **Change the size of all items** window, move the slider scale to the smallest setting to prevent the OS from scaling up. Click **Apply**. Log out of your Windows account and then log back in.
+ Installation paths that contain spaces are not supported. If you install Lumberyard in a path with spaces in the folder name, Lumberyard Editor and the Waf build system do not work properly.
+ The following issues are known for the Lumberyard Setup Assistant:
  + The Lumberyard Setup Assistant might fail to run if `msvcr120.dll` is not present. You can resolve this issue by installing the [Visual C\+\+ Redistributable Packages](http://www.microsoft.com/en-us/download/details.aspx?id=40784) for Visual Studio 2013.
  + The Lumberyard Setup Assistant does not properly detect Python 3.x during the setup process. This issue does not affect compiling or using Lumberyard Editor.
  + If you follow the onscreen installation instructions, the Lumberyard Setup Assistant does not properly detect Android NDK, Revision 11 or later. To resolve this issue, manually locate any of the subdirectories for `ndkpath/build`. For example, you can use any subdirectory of the build directory, such as `ndkpath/build/awk`.
+ When running Lumberyard Editor, you must have access to the `3rdParty\Python` and `3rdParty\AWS\AWSPythonSDK` directories. Lumberyard Setup Assistant automatically creates shortcuts to these directories in the `Code\SDKs` and `Code\Editor\SDKs` directories.
+ The following issues are known when installing Wwise LTX:
  + An installation error may result in the following message: "Microsoft Visual C\+\+ 2008: Failed to execute the package: Fatal error during installation."

    To resolve this issue, do any of the following:
    + Click **Try Again** for the installer to attempt to install the package again.
    + Click **Cancel**. Run the `vc2008redist_x86.exe` and `vc2008redist_x64.exe` installers (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/`), and then run the Wwise LTX installer again.
    + Click **Cancel**. Turn off any antivirus software that is running on your computer, and then run the installer again.
  + An access denied error may occur when using the **Extract** option in the Wwise LTX setup. To resolve this issue, manually run the installer (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/Wwise_v2015.2_LTX_Setup.exe`) as an administrator.
+ If you are using a Mac: 
  + You must install third-party SDKs in the `3rdParty` directory.
  + On OS X, renaming the root directory of a Lumberyard build will break all symbolic links that were created during setup. This prevents the build from compiling in iOS. To resolve this issue, you can undo renaming the root directory or you can manually delete all symbolic links that were created and then run the Lumberyard Setup Assistant again.
  + A PC is still required to run the shader compiler when running a level for the first time. 
  + Feature Tests and Samples Project are the only projects currently supported and must be run using Xcode. 
+ The following issues are known if you use Perforce: 
  + Some editor UIs will interact with your Perforce server. If the connection to your server is poor or you are experiencing other connection issues, the editor UI may briefly hitch during the connection attempt.
  + If Perforce is disabled and not configured and you attempt to delete a global flow graph module, an issue exists that causes the Flow Graph editor to display checkout dialog boxes. Although Perforce is disabled and not configured, you must click **Yes** and check out the file in order to delete it.
+ The following issues are known for the asset pipeline: 
  + If you switch branches, you must restart the Asset Processor.
  + Only asset types that have an implementation in the engine can be reloaded live.
  + The Asset Processor reports all processing operations that failed with a **Crashed** status.
+ Occasionally a `.caf` file might fail to be moved or copied from the source folder to the destination folder. To resolve this issue, use the `AssetProcessorBatch.exe` file to rebuild the character animation.
+ The game mode (**Ctrl\+G**) feature does not work as expected after creating a new level. To resolve this issue, you can save the new level immediately after creation and then reopen the level from the **File** menu in Lumberyard Editor.
+ Support for the CGA and ANM data types have been discontinued.
+ You can use area objects to create 3D zones in a level that are then used to trigger events. If a player is detected within the trigger volume of an area object, the trigger is activated. Area triggers that use the **AreaSolid** object type as the trigger detection volume do not work properly. You can use the **Shape** object type instead.
+ You must reexport all levels before they can run in a game executable. Lumberyard includes a Python script that automates this process for game projects that have several levels. You can run the script from a command line window at your development root folder: `Bin64\Editor.exe /BatchMode /runpython "drive letter and Lumberyard path\dev\Editor\Scripts\export_all_levels.py"`
+ The following issues are known for Lumberyard Editor: 
  + The editor fails to start when building in debug/profile with the **editor and plugins** configuration. You can build using the **all** configuration instead.
  + The editor stops responding on exit if the system clock is inaccurate.
  + The GameSDK project displays several "Invalid geometric mean face area for node…" error messages when loading the Woodland level. You can ignore these nonfatal error messages.
  + The LOD generation system does not work correctly and generates objects with distorted textures.
  + When using a system with an AMD graphics card, certain dynamic global illumination features are disabled by default, which disables indirect sun bounces. Enabling the `e_svoTI_GsmShiftBack` console variable causes the system to crash.
  + Using the Waterfall shader as a submaterial may cause the renderer to crash. To prevent this, use a material that does not have submaterials for any mesh that requires the Waterfall shader.
  + The editor crashes if you attempt to do the following: create a new project in the Project Configurator, set the project as the default, enable all gems, and build the project using `lmbr_waf.bat configure` and `lmbr_waf.bat build_win_x64_profile -p all`. Specifically, the editor crashes if you enable both the **GameLift** gem and **Multiplayer** gem. To resolve this issue, do not use both gems in the same project.
  + The editor crashes if you extract the GameSDK package, configure the project as default, and launch the editor. This is caused by an incompatibility issue with the GameSDK package. To resolve this issue, ensure you are using the latest packages.
  + The editor randomly crashes if you attempt to use the Waterfall shader as a submaterial. When using the Waterfall shader, ensure the material does not have submaterials.
  + Floating windows cannot dock multiple windows.
  + When dialog boxes are docked together and then undocked, some dialog boxes do not appear in the foreground, despite being the active window.
  + If you attempt to generate a level without terrain, the **Generate Terrain** button in the **Terrain** menu will not function.
  + If you attempt to create a new level while Lumberyard Editor (`Editor.exe`) is maximized, the editor will minimize into windowed mode.
+ The following issues are known for the Geppetto tool: 
  + The **Copy Path** and **Show in Explorer** options in the context menu do not work correctly.
  + The **Clean Compiled Animations** option in the **File** menu does not work correctly. You can resolve this issue by navigating to the cache folder in the root engine directory (`\lumberyard\dev`) and deleting the folder that contains the CAF files under the current development OS and game project. This action forces a recompile of all animations.
  + The **Color Hue** slider in the **Animation Event Presets** panel does not appear to slide in the UI; however, the value is updated in the **Color Hue** text field and in the viewport.
  + Skeletons exported from 3ds Max that have non-zero rotation values on the root joint, bone, or dummy are not supported.
  + Warnings may display if you switch between characters while animations are playing.
  + CGAs appear in the file browser if they are present in the asset tree; however, you should not use these files because the CGA file format is deprecated.
  + The side-by-side compression viewer compression is temporarily disabled.
  + The **Clean Compiled Animations** feature is not working.
  + A workflow to create an `.animevents` file for a new character does not yet exist. You must create this file manually and add it to source control.
+ The following issues are known for the Mannequin tool: 
  + The Transition Editor does not currently save any changes made.
  + The Mannequin Editor appears very small when you open it for the first time.
+ In the Maya Exporter, if an MTL file is marked as read only, the **Export Materials** button will not export the material group again. Instead, a message says, "0 material file(s) written." To resolve this issue, manually check out MTL files before exporting again.
+ In the Maya Lumberyard Tool, the UDP editing tool breaks if changes are made to the `LY_MAYA_SCRIPT_PATH`. To customize tools, add your own environment variable rather than changing this package variable.
+ When using the 3ds Max plugin, you might receive a runtime error if you have an object selected with the CrySkin modifier and you right-click to dismiss the menu.
+ The following issues are known for the 3D Studio Max tools: 
  + Absolute paths are saved in MTL files that are created using the material editing tools in Max.
  + Rotations that are applied on the root bone of a skeleton will not load in Lumberyard. You will not receive an error message; however, to prevent this issue do not apply rotations to the root bone of a skeleton in Max.
  + To ensure Max exports correctly, you must save your `.max` file before changing the **Custom Export Path** field.
+ The pendula row simulations may experience unpredictable behavior when loaded into the runtime.
+ In the **Terrain Editor**, the **Flatten** and **Pick Height** tools allow only integer values, even if a level has decimal values in the terrain. Attempting to use decimal values will not work. For example, you cannot flatten to a height of 32.4. You must specify 32 or 33. **Pick Height** also returns height values of 32 when you clicks a location that is 32.4 in actual height.
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
  + The **Properties** pane does not allow changes to multiple selected elements for certain properties, such as anchor values. Changes apply only to the first selected element. To resolve this issue, change an element one at a time.
  + **Ctrl\+Z** does not work to undo changes in the UI Editor if you have made changes anywhere else in Lumberyard Editor. To resolve this issue, use **Undo** from the **Edit** menu.
  + In the **Hierarchy** pane, you cannot drag a set of selected elements onto another to change the parent. This action will reverse their order. To resolve this issue, press **Ctrl\+X**, select the new parent, and then press **Ctrl\+Shift\+V**. Alternatively, you can press **Shift** and click to select the elements, or you can press **Ctrl** and click to select the elements in the existing order. 
+ The following issues are known for the **Track View** editor: 
  + The left mouse button drag box marquee for selecting multiple keyframes does not work.
  + If you start Lumberyard Editor with the **Track View** editor docked as an editor pane, the **Key Properties** subpane within the **Track View** editor becomes permanently disabled. This prevents you from editing keys with the **Track View** editor. To resolve this issue, undock the **Track View** editor and then restart Lumberyard Editor.
+ The following issues are known for gems: 
  + The Multiplayer Gem and the GameLift Gem are incompatible and cannot be used together. The Multiplayer Gem contains everything needed to use Amazon GameLift.
  + When creating a new gem using the Project Configurator, a malformed file prevents tests from being built when using a test build configuration. To resolve this issue, modify the `gem_name_test.waf_files` file to use the name `gem_name_tests.waf_files`. For example, a new gem called MyGem with a file name `mygem_test.waf_files` would now be `mygem_tests.waf_files`.
  + An error message displays when creating a new gem and building the unit test configuration. To resolve this issue, edit the `GemName_tests.waf_files` files (located in the `dev\Gems\GemName\Code` directory) to replace **auto** with **none**. This allows you to compile the test profile spec for your gems.
+ The Resource Compiler may occasionally crash when processing textures, such as cubemaps. Lumberyard Editor automatically resolves this issue by recompiling the affected asset.
+ Occlusion or obstruction might only work for SoundObstructionType MultiRays. Setting audio entities to use SingleRay does not work correctly to draw an occlusion ray.
+ The following issues are known for the Flow Graph: 
  + The `Game:Stop` node does not trigger on exit from game mode as expected. If you use the `Game:Stop` node to clean up flow graph activities that use ongoing resources, these activities may remain active.
  + The `Material:EntityMaterialParams` node does not apply changes made to the material parameters for an entity.
  + The `Material:MaterialParams` node does not allow any parameters to be selected.
+ In the Samples Project, Example 7 in the Trigger\_Sample map does not work. The door trigger does not open as expected.
+ The following issues are known for the Legacy Sample: 
  + If you are using the heavy machine gun, animation may not display correctly when you enter third-person view in game mode.
  + In a debug build, you might see errors and warnings when loading maps, for example the Woodland map.
+ Reloading the **Audio Controls Editor** after you create new controls without saving (thereby discarding your changes) can prevent the Wwise controls from returning to the unassigned state. If you discard your changes using this method, we recommend that you restart the **Audio Controls Editor** to prevent further issues.
+ Hosting or connecting to servers in the MultiplayerLobby in the Multiplayer Project does not work on OS X.
+ The following issues are known for iOS support: 
  + Running a debug build with **Metal validation** enabled causes a fatal assert. To resolve this issue, either run a profile build or disable **Metal validation**. For more information, see [iOS Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/ios-intro.html).
  + Textures with `colorspace=*,[auto|sRGB]` (see `Bin64\rc\rc.ini`) that are compressed by the Resource Compiler may crash when loaded on iOS devices. To resolve this issue, create an `.exportsettings` file with the same name, including the original extension, and add this file to the same folder as the source texture. For example, you can create `source.tif` and `source.tif.exportsettings`. Ensure the `.exportsettings` files contain the line `/preset=ReferenceImage`. This tells the Resource Compiler not to the compress the texture.
  + Release builds are not supported.
+ The following issues are known for Android support: 
  + The Java-based gems are not supported.
  + Release builds are not supported.
  + Live reloading over VFS is not working properly.
+ The following issues are known for FeatureTests: 
  + If you are using the WeatherCloudBasic map in FeatureTests, the visual effect does not render properly on OS X, iOS, or Android.
  + If you are using the KeyboardBasic map, the project does not render properly on OS X.
+ When you are developing for a console, the current project is specified in the `bootstrap.cfg` file. If multiple projects are enabled in the `user_settings.options` file, you must specify the current project as the first project in the enabled projects list in the `user_settings.options` file.
+ Shutting down `CrySimpleManagedThread` objects produces a false positive "runaway thread" error for `dyad` and `httprequestmanager`. 
+ The following issues are known for Twitch ChatPlay and Twitch JoinIn: 
  + The Twitch IRC group server list that is used for Whispers is hardcoded (see `ChatPlayCVars.cpp`).
  + The Twitch JoinIn CreateLink flow node hardcodes the protocol that is used for the JoinIn link `game:`. We recommend that you do not use the game protocol in any end-user applications. The generic name may cause conflicts with other applications.
+ If you upload Cloud Canvas resources and then attempt to run your game in Lumberyard Editor, the game fails to run and gives the error `MissingAuthenticationTokenException`. This is caused by a bug in which the resource map does not update when you create a new Cloud Canvas stack or change resources.

  A related issue occurs when you use the Cloud Canvas Resource Manager to add a resource. Adding the resource succeeds, but the resource mapping silently fails. When you run the game in Lumberyard Editor, the resource is not available.

  To resolve this issue, do the following: 
  + Perform the resource update.
  + Close and then restart Lumberyard Editor.
  + Reload the level.
  + Run the game.

  This issue also affects the standalone Samples Project launcher (located at `dev\Bin64\SamplesProjectLauncher.exe`). After updating your resources, but before running your game, run the following command to create the required resource mapping file so the game can run in the launcher: `lmbr_aws update-mappings --release`
+ If you attempt to build an existing project with the new Waf build system code base, projects that use the function `Path` in the wscript files may encounter Waf build errors. To resolve this issue, update the wscript files to use `bld.Path` instead.
+ If you are upgrading a game project from Lumberyard 1.2 to Lumberyard 1.3 and following the instructions for [Upgrading Your Game Projects](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-upgrading.html#lumberyard-upgrading-game-projects), the procedure has been updated to address a path change. You must now edit the `wscript` file (located in the `\dev\code\project name\Game` directory) to ensure the includes under `#Common` appear as follows:

  ```
  #==============================
  # Common
  #==============================
          includes    = [ '.' ,
                          bld.Path('Code/CryEngine/CryCommon'),
                          bld.Path('Code/CryEngine/CryAction')],
  ```