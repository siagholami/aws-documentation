# Improvements<a name="lumberyard-v1.24-improvements-changes"></a>

Lumberyard Beta 1\.24 provides a number of additional improvements\. Check 'em out\!

## Asset Bundler<a name="asset-bundler-changes-v1.24"></a>
+ Added \-\-skip option to assetLists command to allow quickly excluding a dependency tree from a `.assetList` file\.
+ Improved performance when creating asset bundles on the Mac platform\.

## Asset Pipeline and Processor<a name="asset-pipeline-changes-v1.24"></a>
+ Changing only `.assetinfo` files now causes the **Asset Processor** to rebuild assets in batch mode\.
+ The **Asset Processor** now removes empty folders from the cache, if all of the files within those folders have also been removed by the **Asset Processor**\.
+ Platform status in the **Asset Processor** platform configuration file is now correctly parsed\. Previously, platforms could only be disabled by commenting them out or removing them\. Now, you can mark them as disabled as well\. This is commonly done in `AssetProcessorPlatformConfig.ini` in the engine root under `\Platforms`\. 
+ Dynamic slice jobs have a job dependency on jobs for referenced slices, so that they are always rebuilt when the fingerprint or the content of those slices change\. Previously this was a dependency on reference slices, and not their jobs\. 
+ The missing dependency scanner's default scan iteration per\-line has been raised so that more complex files can be handled\. 
+ The `Lua Builder` no longer emits all uses of the phrases **requires** or **reloadScript** as product dependencies\. Now, it only uses them when they are used to require or reload another script\. 

## EMotionFX \(EMFX\)<a name="emfx-changes-v1.24"></a>
+ **The processing of actor assets is about 8x faster now\!**
+  Saving an animation graph will not reset the view to the root state machine anymore\. Animation graphs are now saved and loaded directly to and from the source asset folder\. 
+  We no longer generate oriented bounding boxes per\-joint\. We have removed this since it was significantly slowing down the generation of actor files and was not used by anything at the moment\. 
+  We have removed the **Optimize Triangle List** option in the mesh modifier in the FBX \(`.fbx`\) settings\. The implementation of this functionality was out of date\.
+  Entity with an actor component can now be selected based on the mesh in the Lumberyard viewport\. 
+  The Rin and Jack sample assets have been updated so that the motion FBX \(`.fbx`\) files do not generate actors anymore\. We also cleaned up the graphs a little and made some other minor tweaks\. 
+  When you click the time line while playing a motion, it now will pause the motion, so you can scrub without having to pause first\. 
+  The **Animation Editor** viewports won't update when you play the game with CTRL\+G\. This prevents the animation editor from taking too much performance away from the game itself\. 
+ Morph targets that have no deformations in them still export, as sometimes this is desired behavior\. 
+  We created shared / helper classes and refactored automated tests related to animation graphs that use unique pointers\. 
+  We added a threshold for the **Smoothing** node\. Now the smooth node blending will snap to the destination value when it approaches the threshold value\. 
+  **HubNode** cannot be set as an entry node anymore\. This is done to ensure every node will start with a correct pose\. 

## Project Configurator<a name="project-configurator-changes-v1.24"></a>
+ We've added a **Rebuild Project** button for your convenience\. Now you can add code\-based gems, then rebuild a project right from **Project Configurator**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/1-24/configurator-rebuild-project.png)
+ The **Advanced Settings** option in each project has been split into **Advanced Game Settings** and **Advanced Editor Settings**, providing direct access to each\. Previously, the choice was made in a drop\-down field\.

## Samples<a name="samples-changes-v1.24"></a>
+ The **Dynamic Vegetation Sample** and **N\.E\.M\.O\.** projects that are available as separate downloads have been updated to work with 1\.24 to support the new **Legacy Terrain Gem**\. 

## Script Canvas<a name="script-canvas-changes-v1.24"></a>
+ **Some general optimizations were done on the runtime execution, leading to a performance increase of around *20*% for certain workflows, such as the **Math** and **Equality** operators\. **
+ Script Canvas has a new dependency on the **Expression Evaluation** gem\. This gem must be enabled for any project that uses Script Canvas\. 
+ The **Allow Node Nudging On Splice** global preference has been re\-named to **Allow Node Nudging** to reflect its broader use\. 
+ **Breaking Change**: **Quaternion** node fields have been reordered\. Previously, the pins on the **Quaternion** nodes appeared as Pitch \(P\), Yaw \(Y\), and Roll \(R\)\. These fields have been reordered to Pitch \(P\), Roll \(R\), and Yaw \(Y\)\. 

## Support<a name="support-changes-v1.24"></a>
+ **Microsoft Visual Studio 2019** is now supported as an IDE for use with the Amazon Lumberyard engine and tools\! [Download the free Visual Studio 2019 Community Edition from Microsoft here](https://visualstudio.microsoft.com/vs/community/)\.

## User Interface<a name="ui-changes-v1.24"></a>
+ We added the ability to force focus on a UI element through code by adding a public `Focus()` method to `UICanvas::TextInput`\. 
+ Load screens were refactored to support more than just **LyShine** canvases\. Multi\-threaded load screens are now supported, enabling the load screens to render hitch\-free while levels load\. 
+ The LyShine Gem no longer has a hardcoded file load to an asset in the UiBasics Gem\. This allows the LyShine Gem to be used without the UiBasics Gem now\.

## Video Playback<a name="video-playback-changes-v1.24"></a>
+ **A new video playback gem, **VideoPlaybackBink**, was added to support Bink by RAD Game Tools\.** The new **VideoPlaybackBink** gem can be used to display Bink movies on textures and even on loading screens\. 

  **Note: **A Bink license is needed to gain access to this gem\. Please contact RAD Game Tools for information on how to license Bink\. 

  For more details, [read the **VideoPlaybackBink** gem documentation](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-videoplayback-bink.html)\.
+ The generic packaging scripts have been updated to pack video files in an uncompressed pak \(`.pak`\) file\. This is important for compression efficiency and playback performance\. If you're using your own custom packaging scripts, you should update them to do the same\. Refer to the generic packaging script as an example and look for the `video_pak` entries: `dev/Code/Tools/RC/Config/rc/RCJob_Generic_MakePaks.xml`\.

## Virtual Reality<a name="vr-changes-v1.24"></a>
+ We removed unused Python code files\.