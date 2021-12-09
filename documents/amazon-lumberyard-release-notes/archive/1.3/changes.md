# Improvements and Changes<a name="lumberyard-v1.3-changes"></a>

This release of Lumberyard includes numerous systems and feature updates:

**Audio**
+ Updates to the Wwise LTX installer include adding a Windows SDK component for vc140 and removing an unnecessary FilePackager tool from samples.

**Character and Animation**
+ **FBX Settings**
  + Lumberyard now supports importing multiple FBX meshes as a single CGF mesh and generating material groups that work for a multimesh CGF from the **FBX Settings**.
  + You can now include vertex colors in CGF meshes that are generated through the **FBX Settings** pipeline.
  + You can now set CGF mesh and submesh position and rotation relative to the world or specific nodes in an FBX scene.
  + Progress reporting appears when importing assets using the **FBX Settings**.
  + The node selection experience for choosing meshes in the **FBX Settings** has been improved.
+ Animation Live Reloading
  + Lumberyard now supports full live reloading of CAF animations in **Geppetto** so you can view new animations right away in Lumberyard Editor, game mode, and PC games built using Lumberyard.

**Cloud Canvas**
+ The **Cloud Canvas Resource Manager** concept of **feature** is now called **resource group**.

**Empty Template**
+ The shutdown behavior for games that are created using EmptyTemplate is better.
+ Various functions in IActor now have documentation.
+ The `GameInit()` and `GameShutdown()` style functions are no longer in EmptyTemplate.
+ Unused prototype files are no longer in EmptyTemplate.

**Graphics and Rendering**
+ Improved motion blur quality by using a sophisticated sample weighting scheme that improves the quality of silhouettes. The amount of motion blur is now controlled using real world shutter speed settings, such as 1/125s.
+ Improved smoothness, roughness, and glossiness by using a square function to map values. This allows for more perceptually linear results and the ability to use scanned roughness data.
+ Enhanced the auto-exposure mode that works with EV. You can enable this mode using `r_HDREyeAdaptationMode`.
+ Updated sun intensity to be specified in lux and to ensure that sun color does not influence the intensity. Backwards compatibility is supported and existing values are automatically converted.
+ Reduced the Fresnel shading effect when surface reflectance is below two percent. This is useful for specular occlusion and allows you to manually lower the specular on terrain and vegetation where it can appear too strong.
+ Removed **glow** and replaced the functionality with **emittance** for scene lighting: 
  + Emissive lighting is added onto diffuse and specular lighting for a surface.
  + Emissive color is a multiplier for emissive maps.
  + Gamma control allows an increasing range of values for emittance maps.
  + Materials that previously used **glow** will be automatically converted to **emissive**, which can change the color of the glow.
+ Removed the following obsolete console variables: `r_HDRBrightOffset`, `r_HDRBrightThreshold`, `r_HDRBrightLevel`, `r_HDREyeAdaptationFactor`, `r_HDREyeAdaptationBase`.

**Lumberyard Installer**
+ Updated the welcome text on the first page to make it easier to identify interaction expectations.
+ Renamed the **Close** button on the first page to **Cancel**.

**Lumberyard Setup Assistant**
+ Lumberyard Setup Assistant is now refreshed automatically if you change the third-party directory. Previously, Lumberyard Setup Assistant would require a manual refresh to detect a change to the third-party directory path and installed software.
+ Lumberyard Setup Assistant now closes automatically if you open the Project Configurator or Lumberyard Editor from the **Summary** page.
+ You can now select the text in the software descriptions, making it easier to copy and paste instructions and create directory paths.
+ New descriptive text explains that the Microsoft Foundation Class (MFC) installer does not work if Visual Studio is installed without MFC.
+ Various updates to the user interface include moving the **Browse** button to the software description, removing the **Refresh** button from the **Get started** page, and displaying a green checkmark and **Found** status for optional software that is successfully installed.

**Mobile**
+ Updated the HLSLCrossCompiler to build under Visual Studio 2015.
+ Improved rendering performance by increasing frame rate by 15 percent.
+ Added adaptive scalable texture compression (ASTC), which provides better control of space and quality for your application and better overall quality at higher compression rates as compared to other compressed formats.
+ Removed recursive SDK searching in the Lumberyard Setup Assistant for Android. Be sure to run the Lumberyard Setup Assistant again after installing Lumberyard 1.3 to ensure paths are set up correctly.

**Networking**
+ Network configuration (such as `Port`, `DisconnectDetection`, and `ConnectionTimeout`) is now exposed to the flow nodes.
+ The Multiplayer Gem now includes the functionality required for Amazon GameLift. Do not use both the Multiplayer Gem and the GameLift Gem.

**Project Configurator**
+ The Project Configurator now invokes the command line interface through `lmbr.exe` for project and gem management.
+ The scroll bar no longer returns automatically to the top of the list when you select a gem.
+ Various updates to the user interface include changing the **Enable Gem** button to a link, updating the default images for gems, and updating descriptive and button text throughout the Project Configurator.

**UI Editor**
+ Added flow graph nodes called `UI:Canvas:GetEnabled` and `UI:Canvas:SetEnabled` that you can use to enable and disable a canvas. These nodes allow a canvas to load but not be displayed or simulated.
+ Changed anchor values to appear as percentages in the **Properties** pane and viewport.
+ Modified anchor preset behavior so the pivot and offsets are also adjusted. When anchors are together, the pivot changes to match the anchors, the offsets adjust so the pivot is on the anchors, and the element's width and height are preserved. When anchors are apart, the pivot changes to 0.5 and the offsets adjust to 0.
+ Updated component behavior to show invalid components as disabled in the **Add Component** menu. Previously, invalid components were removed.
+ Added support for **paste as sibling** and **paste as child**. Added **paste as child** to the context and edit menus, visible when an element is selected. Renamed **paste** to **paste as sibling**, visible when an element is selected.
+ Added support for editing pivot, offsets, and anchors to multiple selected elements.
+ Reordered the toolbar items into a single, fixed toolbar and added mode buttons over the viewport.
+ Updated the **Anchors** widget in the **Transform2D** properties to display the presets that are embedded in the **Properties** pane rather than in a pop-up dialog box.
+ Updated the **Pivot** property in the **Transform2D** component to use a widget that displays the nine most common presets.
+ Updated the **New Element** toolbar icon to add an element at the top level rather than as a child of the selected element.
+ Modified the new element context menu command in the viewport to add the element at the position where you click the right mouse button.
+ Added access to Lumberyard documentation, tutorials, and forums from the UI Editor **Help** menu. The **Give Us Feedback** action displays a dialog box with an email link to send feedback.
+ Moved **Save As Prefab** from the **Edit** menu to the **File** menu.
+ Renamed **Open...** in the **File** menu to **Open Canvas...**.

**Waf Build System**
+ Updated the system by which the Waf build system consumes QT-related content:
  + Header files that must be moc'd are now detected by a code scanning process. Previously, header files that needed to be moc'd were specified as a keyword called `qt_to_moc`.
  + The moc file pattern is now `moc_filename.cpp` (formerly `filename.moc`).
  + Because moc files are generated in the intermediate, variant-based folder, you must use the full path relative to the project root. For example, the **Editor** project (located in the `\dev\Code\Sandbox\Editor\QtUI` directory)contains a header file called `ColorButton.h` that must be moc'd. In the source for `QtUI\ColorButton.cpp`, the file is included using the project's relative path: `#include QtUI/ColorButton.moc`.
  + QRC processing now includes into an existing source rather than generating a header file. Any QRC file that is processed is now treated as its own compilation unit, without the need to include it as part of another compilation unit.
  + While mostly unchanged, UI file processing now requires using a project's relative path (similar to moc files).
  + QT Linguist files (`.ts`) are not supported.
+ Added a profiling option to Waf builds (`lmbr_waf`), which allows you to determine where optimizations in the build can occur.
+ Removed the `Path` and `Settings` functions from all wscripts. The original Waf solution injected a global `Path` and `Settings` method into each wscript that caused alignment issues when debugging wscript files in Python integrated development environments. Removing the `Path` and `Settings` functions can help with code alignment issues. The exception is the root wscript, which injects necessary methods to load and run wscripts as `.json` files.

**Miscellaneous**
+ Added filtering controls to the Debugger and Asset Processor to allow control of the environment behind your LAN firewall and to prevent those with access to your LAN from remotely controlling the editor.
+ Added a `game.json` spec file (located in the `\dev\_WAF_\specs` directory) that you can use to compile only your game. For more information, see [Building Your Game Project](https://docs.aws.amazon.com/lumberyard/latest/userguide/building-your-lumberyard-game-project.html).
+ Improved the workflow for creating gems with editor plugins by adding an **EditorTargets** field to gem `.json` files. This enables you to declare additional targets that are added to the specs in which the editor appears. 
+ Improved the Asset Processor's performance by ensuring that all jobs are created before storing the results in the SQLLITE database. Lumberyard Editor now displays a pending job count during startup so you can easily see the work that remains before the editor can proceed.
+ Made it easy to obtain the compiled, expanded Qt stylesheet that Lumberyard Editor produces when loading or refreshing the stylesheet. The stylesheet is written to your home directory and allows you to view your widgets and user interfaces in Qt Creator or Qt Designer by specifying command line arguments (`-stylesheet PATH_TO_FILE.qss`).
+ Improved mouse hit detection when manipulating curves in the Time of Day editor.
+ Deprecated the AZCore catalogs.
+ Moved the `TransformComponent.cpp` and `TransformComponent.h` files from AzCore to AzFramework.
+ `HttpRequestManager` now uses `AZStd::thread` instead of `CrySimpleThread`.
+ Added the `isEntityId` parameter to callback functor for `ReplaceEntityIdsAndEntityRefs`.
+ Updated the default setting for `incredibuild_max_cores` to 128, which helps to improve Incredibuild build performance.
+ Added a Lumberyard Editor notification for read-only modules when you attempt to delete a flow graph module. The notification also prompts for checkout if the module is under version control or for removal of the read only flag. If the module cannot be deleted, a fail notification will appear.
+ Added the following macro to use with default implementations of DLL initialize/uninitialize functions: `AZ_DECLARE_MODULE_INITIALIZATION`.
+ Added the following macro to use when the DLL includes an `AZ::Module`:` AZ_DECLARE_MODULE_CLASS`.
+ Added `lmbr.exe` for managing projects and gems from the Project Configurator GUI or the command line. This includes creating projects, setting active projects, enabling or disabling gems, and creating gems. For a list of commands, enter `lmbr.exe -help` in a command line window.
+ Updated the push behavior for slices to no longer push all interim levels of the hierarchy.
+ Blocked the use of incompatible, legacy functionality from the entity editor for AZ entities.
+ Removed the ability of the editor in AI or Physics modes to modify component entities. In addition, the property grid is disabled and all editor gizmos (excluding the selection gizmo) cannot be used. You can still modify legacy entities in AI or Physics modes; however, if you have multi-selected legacy and component entities while transitioning, all gizmos will be changed to selection gizmos. You can multi- or single-select legacy entities only and modify them as needed.