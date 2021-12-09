# Known Issues<a name="lumberyard-v1.1-known-issues"></a>

The following issues are known in Lumberyard Beta 1.1:
+ If you use Windows 8 or later on a high-dpi monitor, Lumberyard has high-dpi scaling issues that interfere with the usability of the layout and user interface. Selecting **Disable display scaling on high DPI settings** in the `editor.exe` properties window will not fix the issue.

  To resolve this issue, do one of the following: 
  + (Recommended) Set your monitor to a resolution that is not high DPI. On your desktop, right-click and select **Screen resolution**. In the **Screen Resolution** dialog box, select **1920 x 1080** from the **Resolution** drop-down list. Click **OK**. 
  + Keep your current resolution and view the Lumberyard user interface smaller on the screen. Go to **Control Panel**, **Appearance and Personalization**. Under **Display**, click **Make text and other items larger or smaller**. In the **Change the size of all items** window, move the slider scale to the smallest setting to prevent the OS from scaling up. Click **Apply**. Log out of your Windows account and then log back in.
+ Lumberyard Launcher might fail to run if `msvcr120.dll` is not present. You can resolve this issue by installing the [Visual C\+\+ Redistributable Packages](http://www.microsoft.com/en-us/download/details.aspx?id=40784) for Visual Studio 2013.
+ Installation paths that contain spaces are not supported. If you install Lumberyard in a path with spaces in the folder name, Lumberyard Editor and the Waf build system do not work properly.
+ The following issues are known when installing Wwise LTX: 
  + An installation error may result in the following message: "Microsoft Visual C\+\+ 2008: Failed to execute the package: Fatal error during installation."

    To resolve this issue, do any of the following: 
    + Click **Try Again** for the installer to attempt to install the package again.
    + Click **Cancel**. Run the `vc2008redist_x86.exe` and `vc2008redist_x64.exe` installers (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/`), and then run the Wwise LTX installer again.
    + Click **Cancel**. Turn off any antivirus software that is running on your computer, and then run the installer again.
  + An access denied error may occur when using the **Extract** option in the Wwise LTX setup. To resolve this issue, manually run the installer (located in `dev/Bin64/Redistributables/WwiseLTX/v2015.2_LTX_build_5495/Wwise_v2015.2_LTX_Setup.exe`) as Administrator.
+ If you are using a Mac, you must install third-party SDKs in the `3rdParty` directory.
+ If you use Perforce, some editor UIs will interact with your Perforce server. If the connection to your server is poor or you are experiencing other connection issues, the editor UI may briefly stall during the connection attempt.
+ The following issues are known in the asset pipeline: 
  + If you switch branches, you must restart the Asset Processor.
  + Only asset types that have an implementation in the engine can live reload.
+ Occasionally a `.caf` file might fail to be moved or copied from the source folder to the destination folder. To resolve this issue, use the `AssetProcessorBatch.exe` file to rebuild the animation.
+ The game mode (**Ctrl\+G**) feature does not work as expected after you create a new level. To resolve this issue, you can save the new level immediately after creation and then reopen the level from the **File** menu in Lumberyard Editor.
+ The CGA and ANM data types are deprecated.
+ You can use area objects to create 3D zones in a level that are then used to trigger events. If a player is detected within the trigger volume of an area object, the trigger is activated. Area triggers that use the **AreaSolid** object type as the trigger detection volume do not work properly. You can use the **Shape** object type instead.
+ The following issues are known in Lumberyard Editor: 
  + The editor fails to start when building in debug/profile with the **editor and plugins** configuration. You can build using the **all** configuration instead.
  + The editor stops responding on exit if the system clock is inaccurate.
  + The GameSDK project displays several "Invalid geometric mean face area for node…" error messages when loading the Woodland level. You can ignore these non-fatal error messages.
  + The LOD Generation system does not work correctly and generates objects with distorted textures.
  + When using a system with an AMD graphics card, certain dynamic Global Illumination features are disabled by default, which disables indirect sun bounces. Enabling the `e_svoTI_GsmShiftBack` console variable will cause the system to crash.
  + Using the Waterfall shader as a submaterial may cause the renderer to crash. You can resolve this issue by using a material that does not have submaterials for any mesh that requires the Waterfall shader.
+ The following issues are known in the Geppetto tool: 
  + The **Copy Path** and **Show in Explorer** options in the context menu do not work correctly.
  + The **Clean Compiled Animations** option in the **File** menu does not work correctly. You can resolve this issue by navigating to the cache folder in the root engine directory (`\lumberyard\dev`) and deleting the folder that contains the CAF files under the current development OS and game project. This action forces a recompile of all animations.
  + The **Color Hue** slider in the **Animation Event Presets** panel does not appear to slide in the UI; however, the value is updated in the **Color Hue** text field and in the viewport.
  + Skeletons exported from 3ds Max that have non-zero rotation values on the root joint, bone, or dummy are not supported.
  + Warnings may display if you switch between characters while animations are playing.
  + CGAs appear in the file browser if they are present in the asset tree; however, you should not use these files because the CGA file format is deprecated.
  + The side-by-side compression view is not working.
  + The **Clean Compiled Animations** feature is not working.
  + A workflow to create an `.animevents` file for a new character does not yet exist. You must create this file manually and add it to source control.
+ The following issues are known in the Mannequin tool: 
  + The Transition Editor does not currently save any changes made.
  + The Mannequin Editor appears very small when you open it for the first time.
+ If an MTL file is marked as read-only, the **Export Materials** button will not export the material group again. Instead, a message says, "0 material file(s) written." To resolve this issue, manually check out MTL files before exporting again.
+ In the Maya Lumberyard Tool, the UDP editing tool breaks if changes are made to the LY\_MAYA\_SCRIPT\_PATH. To customize tools, add your own environment variable rather than changing this package variable.
+ When using the 3ds Max plugin, you might receive a runtime error if you have an object selected with the CrySkin modifier and you right-click to dismiss the menu.
+ The following issues are known in the 3D Studio Max tools: 
  + Absolute paths are saved in MTL files that are created using the material editing tools in Max.
  + Rotations that are applied on the root bone of a skeleton will not load in Lumberyard. You will not receive an error message; however, to prevent this issue do not apply rotations to the root bone of a skeleton in Max.
  + To ensure Max exports correctly, you must save your `.max` file before changing the **Custom Export Path** field.
+ The pendula row simulations may experience unpredictable behavior when they are loaded into the runtime.
+ In the **Terrain Editor**, the **Flatten** and **Pick Height** tools allow only integer values, even if a level has decimal values in the terrain. Attempting to use decimal values will not work. For example, you cannot flatten to a height of 32.4. You must specify 32 or 33. **Pick Height** also returns height values of 32 when you click a location that is 32.4 in actual height.
+ The following issues are known in the Material Editor: 
  + The Material Editor item tree displays a verbose path when you create a new material. You can resolve this issue by refreshing the item tree.
+ The following issues are known in the UI Editor: 
  + The Sprite Border Editor in the UI Editor does not work for some textures and shows a size of **0x0**.
  + The **Properties** pane does not allow changes to multiple selected elements.
+ The following issues are known in the **Track View** editor: 
  + The left mouse button drag box marquee for selecting multiple keyframes does not work.
  + If you start Lumberyard Editor with the **Track View** editor docked as an editor pane, the **Key Properties** subpane within the **Track View** editor becomes permanently disabled. This prevents you from editing keys with the **Track View** editor. To resolve this issue, undock the **Track View** editor and then restart Lumberyard Editor.
+ An error message appears when you create a new gem and build the unit test configuration. To resolve this issue, edit the `GemName_tests.waf_files` files (located in `dev\Gems\GemName\Code`) to replace **auto** with **none**. This allows you to compile the test profile spec for your gems.
+ The Resource Compiler may occasionally crash when processing textures, such as cubemaps. Lumberyard Editor automatically resolves this issue by recompiling the affected asset.
+ Occlusion or obstruction might only work for SoundObstructionType MultiRays. Setting audio entities to use SingleRay does not work correctly to draw an occlusion ray.
+ The following issues are known in the flow graph: 
  + The `Game:Stop` node does not trigger on exit from game mode as expected. If you use the `Game:Stop` node to clean up flow graph activities that use ongoing resources, these activities may remain active.
  + The output ports are reversed for the `Math:EvenOrOdd` node. Odd numbers generate an **Even** output activation, and even numbers generate an **Odd** output activation.
  + The `Material:EntityMaterialParams` node does not apply changes made to the material parameters for an entity.
  + The `Material:MaterialParams` node does not allow any parameters to be selected.
+ The following issues are known in the Legacy Sample: 
  + If you are using the heavy machine gun, animation may not display correctly when you enter third-person view in game mode.
  + In a debug build, you might see errors and warnings when loading maps, for example the Woodland map.
+ Reloading the **Audio Controls Editor** after you create new controls without saving (thereby discarding your changes) can prevent the Wwise controls from returning to the unassigned state. If you discard your changes using this method, we recommend that you restart the **Audio Controls Editor** to prevent further issues.
+ The following issues are known for iOS support: 
  + Running a debug build with **Metal validation** enabled causes a fatal assert. To resolve this issue, either run a profile build or disable **Metal validation**. For more information, see [iOS Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/ios-intro.html).
  + Textures with `colorspace=*,[auto|sRGB]` (see `Bin64\rc\rc.ini`) that are compressed by the Resource Compiler may crash when loaded on iOS devices. To resolve this issue, create an `.exportsettings` file with the same name, including the original extension, and add this file to the same folder as the source texture. For example, you can create `source.tif` and `source.tif.exportsettings`. Ensure the `.exportsettings` files contain the line `/preset=ReferenceImage`. This tells the Resource Compiler not to the compress the texture.
+ When developing for Android, the Java-based gems are not supported.
+ The following issues are known in Twitch ChatPlay and Twitch JoinIn: 
  + The Twitch IRC group server list that is used for Whispers is hardcoded (see `ChatPlayCVars.cpp`).
  + The `Twitch JoinIn CreateLink` flow node hardcodes the protocol that is used for the Twitch JoinIn link `game:`. We recommend that you do not use the game protocol in any end-user applications. The generic name may cause conflicts with other applications.