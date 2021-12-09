# Known Issues<a name="lumberyard-v1.0-known-issues"></a>

The following issues are known in Lumberyard Beta 1.0:
+ If you use Windows 8 or later on a high-dpi monitor, Lumberyard has high-dpi scaling issues that interfere with the usability of the layout and user interface. Selecting **Disable display scaling on high DPI settings** in the `editor.exe` properties window will not fix the issue.

  To resolve this issue, do one of the following: 
  + (Recommended) Set your monitor to a resolution that is not high DPI. On your desktop, right-click and select **Screen resolution**. In the **Screen Resolution** dialog box, select **1920 x 1080** from the **Resolution** drop-down list. Click **OK**. 
  + Keep your current resolution and view the Lumberyard user interface smaller on the screen. Go to **Control Panel**, **Appearance and Personalization**. Under **Display**, click **Make text and other items larger or smaller**. In the **Change the size of all items** window, move the slider scale to the smallest setting to prevent the OS from scaling up. Click **Apply**. Log out of your Windows account and then log back in.
+ Lumberyard Launcher might fail to run if `msvcr120.dll` is not present. You can resolve this issue by installing the [Visual C\+\+ Redistributable Packages](http://www.microsoft.com/en-us/download/details.aspx?id=40784) for Visual Studio 2013.
+ Installation paths that contain spaces are not supported. If you install Lumberyard in a path with spaces in the folder name, Lumberyard Editor and the Waf build system will not work properly.
+ If you use Perforce, some editor UIs will interact with your Perforce server. If the connection to your server is poor or you are experiencing other connection issues, the editor UI may briefly hitch during the connection attempt.
+ The following issues are known in the asset pipeline: 
  + If you switch branches, you must restart the Asset Processor.
  + Only asset types that have an implementation in the engine can live reload.
+ Occasionally a CAF file might fail to move or copy from the source folder to the destination folder. To resolve this issue, rebuild by using the `AssetProcessorBatch.exe` file.
+ The game mode (**Ctrl\+G**) functionality does not work as expected after creating a new level. To resolve this issue, you can save the new level immediately after creation and then reopen the level from the **File** menu in Lumberyard Editor.
+ The CGA and ANM data types are deprecated.
+ You can use area objects to create three dimensional zones in a level that are then used to trigger events. If a player is detected within the trigger volume of an area object, the trigger is activated. Area triggers that use the **AreaSolid** object type as the trigger detection volume do not work properly. You can use the **Shape** object type instead.
+ The following issues are known in Lumberyard Editor: 
  + The editor fails to start when building in debug/profile with the **editor and plugins** configuration. You can build using the **all** configuration instead.
  + The editor crashes if you attempt to set the source LOD before setting the source CGF in the LOD Generator.
  + The editor crashes if you use the flow graph node `XML:SaveDocument`.
  + The editor stops responding on exit if the system clock is inaccurate.
  + The **Export Geometry** option in the **File** menu does not work for the FBX file format. The **OBJ Export** option works correctly.
  + The **UseTerrainColor** property in the **Vegetation** tool on the Rollup Bar does not work properly.
+ The following issues are known in the Geppetto tool: 
  + The **Copy Path** and **Show in Explorer** options in the context menu do not work correctly.
  + The **Clean Compiled Animations** option in the **File** menu does not work correctly. You can resolve this issue by navigating to the cache folder in the root engine directory (`\lumberyard\dev`) and deleting the folder that contains the CAF files under the current development OS and game project. This action forces a recompile of all animations.
  + The **Color Hue** slider in the **Animation Event Presets** panel does not appear to slide in the UI; however, the value is updated in the **Color Hue** text field and in the viewport.
  + Skeletons exported from 3ds Max that have non-zero rotation values on the root joint, bone, or dummy are not supported.
+ The following issues are known in the Maya Exporter: 
  + If an MTL file is marked as read-only, the **Export Materials** button will not export the material group again. Instead, a message will display that says, "0 material file(s) written." To prevent the message from displaying, you can manually check out MTL files before exporting again.
  + If a custom path does not exist, the material will not export when you press the **Export Materials** button. Instead, a message will display that says, "0 material file(s) written." To prevent the message from displaying, be sure to create any custom paths before exporting.
+ When using the 3ds Max plugin, you might receive a runtime error if you have an object selected with the CrySkin modifier and you right-click to dismiss the menu.
+ The following issues are known in the Material Editor: 
  + The Material Editor item tree displays a verbose path when you create a new material. You can resolve this issue by refreshing the item tree.
+ The Sprite Border Editor in the **UI Editor** does not work for some textures and shows a size of **0x0**.
+ The following issues are known in the **Track View** editor: 
  + If your sequence has the **Out of Range** parameter set to **Constant** and you attempt to render a sequence to MPEG, the frames will continue to render without stopping at the end of the sequence. If you cancel the render, an MPEG will generate with all frames. To resolve this issue, do not set **Out of Range** to **Constant**.
  + The left mouse button drag box marquee for selecting multiple keyframes does not work.
  + If you start Lumberyard Editor with the **Track View** editor docked as an editor pane, the **Key Properties** subpane within the **Track View** editor becomes permanently disabled. This prevents you from editing keys with the **Track View** editor. To resolve this issue, undock the **Track View** editor and then restart Lumberyard Editor.
+ The Resource Compiler may occasionally crash when processing textures, such as cubemaps. Lumberyard Editor will automatically resolve this issue by recompiling the affected asset.
+ Occlusion/obstruction might only work for SoundObstructionType MultiRays. Setting audio entities to use SingleRay does not work correctly to draw an occlusion ray.
+ The `Game:Stop` node does not trigger on exit from game mode as expected. If you use the `Game:Stop` node to clean up flow graph activities that use ongoing resources, these activities may remain active.
+ The following issues are known in the Legacy Sample: 
  + If you are using the heavy machine gun, animation may not display correctly when you enter third-person view in game mode.
  + In a debug build, you might see errors and warnings when loading maps, for example the Woodland map.
+ In the **BeachCity\_NightTime** level, theater textures are hidden due to an environment probe issue. To resolve this issue and see textures again, deselect **Active** for **EnvironmentProbe\_theater** in the **EnvironmentProbe Properties** pane.