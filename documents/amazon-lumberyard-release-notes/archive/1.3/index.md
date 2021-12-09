# Lumberyard Release Notes – Beta 1.3 (June 2016)<a name="lumberyard-v1.3"></a>

With Lumberyard Beta 1.3, we're bringing in hundreds of new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our developer community. Without your participation in the forums, your messages, and your bug reports, Lumberyard 1.3 wouldn't be as strong as it is. Keep sending your feedback to lumberyard-feedback@amazon.com. If you haven't spoken up on the [forums](https://forums.awsgametech.com/) yet, we would love to have you. You can also keep up with new changes on [our blog](https://aws.amazon.com/blogs/gametech) and leave comments to let us know what you think.

**Topics**
+ [Highlights](#lumberyard-v1.3-highlights)
+ [Preview Systems and Tools](lumberyard-v1.3-preview-systems.md)
+ [Improvements and Changes](lumberyard-v1.3-changes.md)
+ [Fixes](lumberyard-v1.3-fixes.md)
+ [Known Issues](lumberyard-v1.3-known-issues.md)

## Highlights<a name="lumberyard-v1.3-highlights"></a>

### Create VR experiences for the Oculus Rift and HTC Vive<a name="lumberyard-v1.3-highlights-vrsupport"></a>

Lumberyard 1.3 now makes development of virtual reality (VR) experiences easy with support for the Oculus Rift and HTC Vive head-mounted displays (HMD) and peripherals, including touch controllers. To get started, you simply enable the Modular Gem in the Project Configurator for the desired device, put on the HMD, and launch the game or press **Ctrl\+G** in the editor. Lumberyard includes the following to allow you to integrate VR: 
+ Preview content in VR from within Lumberyard Editor.
+ A gem that includes all VR functionality, so you pay for VR only if you need VR.
+ Ability to add HMD support by inheriting from a single C\+\+ class and autogenerating a new gem.
+ Performance tuning to reduce latency and increase frame rate.

For more information, see [Virtual Reality](https://docs.aws.amazon.com/lumberyard/latest/userguide/virtual-reality.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/Rin_VR_01.jpg)

### Native support for HDR televisions<a name="lumberyard-v1.3-highlights-hdr"></a>

Lumberyard 1.3 adds native support for HDR televisions, allowing you to create high quality, HDR-authored content with a game engine that takes advantage of the display hardware: 
+ The Lumberyard post-processing stack has been rewritten so that anti-aliasing, motion blur, and depth of field now display properly in HDR space.
+ A PQ curve replaces the gamma curve and is optimized for brighter displays up to 10,000 nits, whereas standard TVs typically maximize at 400 nits.
+ An S curve replaces filmic tone mapping so that artists can control their content in HDR space.
+ Encoding for per-frame metadata enables smart TVs to automatically and smartly adapt to the sent signal. This allows you to create dynamic scene transitions, taking your players from a dark cave to a bright, sun-lit world smoothly.
+ HDR parameters and curves are exposed through console variables, allowing content creators to fine tune HDR settings to better fit their content and stylistic preferences.
+ Support modes for HDR reference monitors, such as the Dolby Maui, and consumer displays allow content creators to see results faster.

### Create slow- or fast-changing fog with volumetric fog<a name="lumberyard-v1.3-highlights-volumetric-fog"></a>

Lumberyard 1.3 improves volumetric fog quality by increasing the temporal stability and reducing flickering and ghosting artifacts. The **DensityNoiseTimeFrequency** parameter in the **FogVolume** entity allows you to adjust the frequency of the density's noise. Low frequencies create slow-changing fog and high frequencies create fast-changing fog. For more information, see [Using Fog Volumes](https://docs.aws.amazon.com/lumberyard/latest/userguide/weather-fog-volumes.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/volumetric_fog.gif)

### Create ambient occlusion in outdoor environments<a name="lumberyard-v1.3-highlights-height-map-ambient-occlusion"></a>

Lumberyard uses experimental sparse voxel-based global illumination (SVOGI), which provides dynamic indirect light bounce from static and dynamic objects, and large scale ambient occlusion and indirect shadows from static geometry.

Height map-based ambient occlusion (AO) allows you to create terrain that is more accurate and detailed in appearance, including shading and depth perception. When used in combination with screen space directional occlusion (SSDO), height map AO provides additional shading cues that enhance the depth perception of a scene. For more information, see [Height Map Ambient Occlusion](https://docs.aws.amazon.com/lumberyard/latest/userguide/mat-shaders-heightmap_ambient_occlusion.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/SVOGI.gif)

### New gather-based depth of field<a name="lumberyard-v1.3-highlights-depth-of-field"></a>

Lumberyard uses gather-based depth of field (DOF) to eliminate edge bleeding artifacts and provide a more efficient technique. To enable or disable this depth of field mode, use `r_depthOfFieldMode`. For more information, see [Rendering Cameras](https://docs.aws.amazon.com/lumberyard/latest/userguide/rendering-graphics-cameras.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/DOF.gif)

### Create terrain with splat masks<a name="lumberyard-v1.3-highlights-splatmasks"></a>

Splat masks are alpha maps that Lumberyard interprets to place textures on specific areas of a level. Similar to a height map, each splat mask contains height outputs that ensure a texture is placed at the appropriate z-axis of a level. In conjunction with terrain generation programs like World Machine, you can use this feature as a starting point for creating content quickly. For more information, see [Importing Splat Maps](https://docs.aws.amazon.com/lumberyard/latest/userguide/terrain-splat-maps.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/terrain-splat-map-2.png)

### View performance statistics using the integrated graphics profiler<a name="lumberyard-v1.3-graphics-profiler"></a>

Lumberyard 1.3 includes an integrated graphics profiler that displays critical performance statistics in real time, allowing you to optimize your visual performance to maximize your game's graphical experience. You can enable the profiler using the `r_profiler 1` console variable, and all information is displayed in an easy-to-read layout. You can display the following: 
+ Frame statics including frame rate, frame time, and other summary stats.
+ CPU and GPU timings for the pipeline stages, G-Buffer, lighting, and post-processing.
+ CPU and GPU timing per graphics subsystem such as water, GI, fog, or particle systems.
+ API-specific statics such as draw call counts, shader counts, triangles, and vertices count.

### Create and manage AWS resources<a name="lumberyard-v1.3-cloud-canvas"></a>

The Cloud Canvas Resource Manager lets you define and manage AWS resources used by your game directly in Lumberyard Editor using a new graphical user interface (GUI). You can have multiple copies of your resources so your development and test teams can work independently. The resources are secured to prevent unauthorized player access and accidental changes to production resources by the development team. To access the GUI, click **AWS**, **Cloud Canvas** from the menu in Lumberyard Editor. The command line tool (`lmbr_aws`) for resource management is still available to use as well. For more information, see [Cloud Canvas Resource Manager](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-ui-rm-overview.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/cloud_canvas_resource_manager.png)

### Static data system for managing game properties via the cloud<a name="lumberyard-v1.3-highlights-dont-die-demo"></a>

The Don't Die demo uses the first iteration of a static data system to manage game properties through the cloud. When you stand up your resources for the Don't Die demo, an S3 bucket called `MainBucket` is created with a `static-data` folder that contains CSV data used by the demo. The `gameproperties.csv` file includes settings for the minimum and maximum asteroid size and ship speed. When the demo starts, a `RequestBucket` flow node is called to check for new data in this folder and download any new data to the client. The data is then loaded by the static data system and queried through `GetStaticData` flow nodes.

### New networking features for better game management and control of bandwidth usage<a name="lumberyard-v1.3-highlights-networking"></a>

Lumberyard 1.3 adds a prioritization system to enable you to set the priorities on replicas and the order of replication to better manage the needs of your game; a bandwidth limiter to provide better control of your bandwidth usage per peer; and functionality to decouple the send frequency of replicas from the update frequency of the engine. For more information, see [Networking System](https://docs.aws.amazon.com/lumberyard/latest/userguide/network-intro.html).

### Lumberyard Command Line Tool<a name="lumberyard-v1.3-highlights-lumberyard-cmdline-tool"></a>

Lumberyard 1.3 includes a new, modular command line tool (`lmbr.exe`) that provides the gems and project management functionality that you previously accessed through the Project Configurator. You can use `lmbr.exe` for automated testing, creating and modifying projects, and creating gems. For more information, see [Using Lmbr.exe](https://docs.aws.amazon.com/lumberyard/latest/userguide/configurator-lmbr.html).

### Statoscope (Legacy)<a name="lumberyard-v1.3-highlights-statoscope"></a>

Lumberyard 1.3 includes Statoscope, a profiling tool that displays per-frame instrumented data. You can use Statoscope to evaluate performance metrics such as overall CPU time spent, track memory usage, and view rendering statistics. For more information, see [Statoscope Profiler](https://docs.aws.amazon.com/lumberyard/latest/userguide/profiling-statoscope-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/profiling-statoscope.png)

### AzTestScanner<a name="lumberyard-v1.3-highlights-aztestscanner"></a>

The AzTestScanner is a tool that you can use to run unit tests built into Lumberyard libraries and executables. It consists of an AzTestRunner executable that loads libraries to test and captures the test results, and an aztest Python module that performs the scanning and reporting funtionality. The AzTestScanner helps to make testing easier by automatically finding libraries and executables to test while providing the flexibility to focus on testing. For more information, see [Using AzTestScanner](https://docs.aws.amazon.com/lumberyard/latest/userguide/testing-aztestscanner.html).