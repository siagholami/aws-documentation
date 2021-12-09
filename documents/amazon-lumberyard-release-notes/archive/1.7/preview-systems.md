# Preview Systems and Tools<a name="lumberyard-v1.7-preview-systems"></a>

The following systems are a preview of new features on which we are especially interested in feedback. Please [submit feedback on our forums](http://gamedev.amazon.com/forums) or by sending an email to lumberyard-feedback@amazon.com.

**Topics**
+ [New Asset Browser Replaces File Browser](#lumberyard-v1.7-preview-system-asset-browser)
+ [New FBX Settings Features](#lumberyard-v1.7-preview-system-fbx-importer)
+ [Mobile Support – Improved Methods to Deploy Builds](#lumberyard-v1.7-preview-system-mobile-support)
+ [New UI Editor Components and Features](#lumberyard-v1.7-preview-system-ui-editor)

## New Asset Browser Replaces File Browser<a name="lumberyard-v1.7-preview-system-asset-browser"></a>

The **Asset Browser** displays all project assets in a source folder and file view to enable quick access and interaction. Source assets are also displayed with their products. For example, an `.fbx` file would appear with its meshes and animations. The **Asset Browser** also includes other features:
+ Drag-and-drop interaction
+ Right-click context menus for each asset
+ Asset name filtering

You can use the **Asset Browser** with other editor components—such as the viewport, **Entity Outliner**, and **Entity Inspector**—to improve your development workflow. It replaces the original **File Browser**.

To open the **Asset Browser**, click **View**, **Open View Pane**, **Asset Browser**. You can dock the **Asset Browser** window to Lumberyard Editor.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/asset_browser_preview.png)

## New FBX Settings Features<a name="lumberyard-v1.7-preview-system-fbx-importer"></a>

Lumberyard 1.7 introduces the following new features for the **FBX Settings**:
+ Level of detail (LOD) rule for static and skinned meshes

  Use this rule to define different geometry for the runtime LOD system based on distance from the camera. As a result, you will have greater control over the performance characteristics of your meshes in-game.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/skin_lod.png)
+ Default processing of `.fbx` files

  When an `.fbx` file is first loaded into the **FBX Settings**, a default set of groups and rules is generated that reflects the data in the file. This process reduces the number of steps that are required from you to set up most files. This process is also used for new `.fbx` files that have no manifest based on what would have been the default settings. For simple `.fbx` files that have a single asset, no user action is required.
+ EBus-based importing

  The process of importing an `.fbx` file to the Lumberyard `SceneGraph` format has been refactored. The `.fbx` file is now imported analogously to the export through an EBus, which pushes import contexts representing different phases of processing a discrete piece of FBX data. Importers are written to perform specific processing steps in response to specific import contexts and list on the EBus. This allows you to create custom importing steps to define data for the runtime systems to use.

For more information, see [Working with the FBX Settings](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-fbx-importer.html).

## Mobile Support – Improved Methods to Deploy Builds<a name="lumberyard-v1.7-preview-system-mobile-support"></a>

You can use Lumberyard to build games for iOS devices (iPhone 5s, iPhone 6s, iPhone 6s Plus, iPad Air 2, and iPad Pro) and Android devices (Nvidia Shield, Samsung Galaxy Note 5, and Motorola Nexus 6). Added features include:
+ Support for deploying builds to Android devices directly from Lumberyard Editor by using the **Deployment Tool**. You no longer need to use the command line tools. For more information, see [Building Android Games Using the Lumberyard Editor Deployment Tool Plugin](https://docs.aws.amazon.com/lumberyard/latest/userguide/android-game-building.html#android-game-building-deployment-tool).  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/deployment_tool.png)
+ OBB expansion for Android has been added, which allows you to ship games that are larger than 100 MB.
+ Support for using the AppDetective script to deploy iOS and Android builds to the AWS Device Farm. You can test your Lumberyard game across a range of devices in the Device Farm rather than hosting a PC on a public IP address. For more information, see [Using the AppDetective to Test Your Build on the AWS Device Farm](https://docs.aws.amazon.com/lumberyard/latest/userguide/ios-android-appdetective.html).

## New UI Editor Components and Features<a name="lumberyard-v1.7-preview-system-ui-editor"></a>

With the **UI Editor** you can build, visualize, and customize user interface elements such as menus, buttons, and the heads-up display (HUD). Added components and features include:
+ Use the **UiTooltip** and **UiTooltipDisplay** components to add tooltips to an interactive element on your UI canvas.
+ Configure the number of character slots in a font texture. You can select a different font for each language.

For more information, see [UI System](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-intro.html).