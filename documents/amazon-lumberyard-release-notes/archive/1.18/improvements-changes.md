# Improvements and Changes<a name="lumberyard-v1.18-improvements-changes"></a>

Lumberyard Beta 1.18 provides improvements and changes to Lumberyard systems and functionality. Choose a topic area to learn more.

**Topics**
+ [Amazon GameLift](#amazon-gamelift-improvements-changes-v1.18)
+ [Android](#android-improvements-changes-v1.18)
+ [Asset Processor](#asset-processor-improvements-changes-v1.18)
+ [Audio](#audio-improvements-changes-v1.18)
+ [Component Entity System](#components-improvements-changes-v1.18)
+ [Lua](#lua-improvements-changes-v1.18)
+ [Lumberyard Editor](#lumberyard-editor-improvements-changes-v1.18)
+ [Mobile](#mobile-improvements-changes-v1.18)
+ [PhysX System](#lumberyard-v1.18-highlights-physx-system)
+ [SDK Compatibility](#lumberyard-v1.18-highlights-compatible-sdk-versions)
+ [UI Editor](#ui-editor-improvements-changes-v1.18)
+ [Visual Studio 2017](#visual-studio-support-improvements-changes-v1.18)

## Amazon GameLift<a name="amazon-gamelift-improvements-changes-v1.18"></a>

Stay up to date with the latest release information at [AWS Release Notes for Amazon GameLift](https://aws.amazon.com/releasenotes/Amazon-GameLift?browse=1).

## Android<a name="android-improvements-changes-v1.18"></a>

Android has the following improvements and changes:
+ Thermal information for the CPU, GPU, and battery are now available for devices at runtime. You can use this information to profile thermal and battery performance.
+ You can now view temperature information by setting the `r_DisplayInfo` console variable to **2**. This will display debugging information on the screen.
+ Temperature information will not display for devices that don't support thermal information about components.
+ Android NDK r18 and Android NDR r19 are now supported.
+ API level 27 and API level 28 are now supported.
+ Support for handling runtime permission requests has been added.
+ The minimum supported SDK platform is now API level 26.
+ The minimum supported build tools version is 26.0.0.
+ In Android Studio, generating a project now uses the Android Gradle Plugin 3.3.0.
+ Android Studio 3.2 is no longer supported by Lumberyard.

## Asset Processor<a name="asset-processor-improvements-changes-v1.18"></a>

The Asset Processor has the following improvements and changes:
+ The job dependency feature lets you specify how the Asset Processor will process a job:
  + Fingerprint job dependency – Process the job if the fingerprint of another job changes.
  + Order job dependency – Process the job only after another job is done processing.
+ The **Faster Scanning Mode** lets you skip unnecessary analysis work during the startup scan. This can help improve startup time by up to 85% on subsequent runs of the Asset Processor.

## Audio<a name="audio-improvements-changes-v1.18"></a>

The audio system has the following improvements and changes:
+ Lumberyard now supports Audiokinetic Wwise SDK version 2018.1.4.
+ Lumberyard now supports Audiokinetic Wwise LTX version 2018.1.2. You can use the **Lumberyard Setup Assistant** to install the Wwise LTX authoring tool.
+ Lumberyard is now backwards compatible with Audiokinetic Wwise SDK version 2017.x.x. For more information, see the `README.txt` file in the `dev\Code\CryEngine\CrySoundSystem\implementations\CryAudioImplWwise\wwise_backwards_compatibility\` directory.
+ Audiokinetic Wwise SDK version 2016.x.x is now deprecated and no longer supported by Lumberyard.

## Component Entity System<a name="components-improvements-changes-v1.18"></a>

The component entity system has the following improvements and changes:
+ Performance improvements were made for toggling slices in the **Entity Outliner**.
+ **UIElements** are now part of the edit reflection, which allows you to create a UI that isn't backed by class variables on components.
+ You can now copy and paste a **Transform** component from one entity to another. This will overwrite the existing values.
+ You can now delete empty components from an entity. You may see an empty component if you delete a component from code, but the entity still has an instance in a saved level or slice.
+ The **Entity Inspector** now shows component-specific context menu options.
+ For a more logical order of activation, dynamic slices now sort parents before sorting children.
+ You can now set the default behavior to create all slices as dynamic.
+ You can now re-save all slices for your project.
+ The editor response time has been improved when you deselect a large number of entities.
+ Duplicated entities now appear at the top of the **Entity Inspector**. If you have an entity selected, the duplicated entities will appear above the selected entity.
+ In the **Entity Outliner**, filter and search results now include information from the component category.
+ The **Entity Outliner** and the viewport now have an option to open the slice in relationship view.
+ Visualization of entities, slices, and filtering in the **Entity Outliner** have been improved.
+ In the **Entity Inspector**, search results now include property headers.
+ You can now filter the **Entity Outliner** by visibility or locked states.
+ An option was added to enable sticking duplicated entities to the cursor.
+ When you right-click and choose **Find in asset browser**, the **Asset Browser** search box is now cleared.
+ The drop position is now respected when you drag and drop assets from the **Asset Browser** to the **Entity Outliner**.

## Lua<a name="lua-improvements-changes-v1.18"></a>

Lua has the following improvements and changes:
+ The Lua IDE autocomplete dictionary now includes all reflected classes, event buses, and methods.
+ You can now use the Lua IDE watch window to change the values of variables.
+ You can now convert tabs to spaces in the Lua IDE.
+ You can now see the compilation status (success/fail) of the Lua files. Double-click an error to go to the referenced line.
+ `BusIsConnected` is now available through Lua.
+ The Lua VM now resets when you exit game mode in Lumberyard Editor.
+ You can now use the Lua files browser to easily access all Lua assets in your project.
+ You can now double-click a line in the find window to go directly to the line.

## Lumberyard Editor<a name="lumberyard-editor-improvements-changes-v1.18"></a>

The editor now shows any warnings at startup.

## Mobile<a name="mobile-improvements-changes-v1.18"></a>

Mobile has the following improvements and changes:
+ Shader `.pak` files are now generated for release builds without having to pull shaders from the device.
+ You can now update mobile-specific project settings such as app icons, splash screens, package names, and more. To access these settings, press **Ctrl\+Shift\+P** or choose **File**, **Project Settings**, **Project Settings Tool**.

## PhysX System<a name="lumberyard-v1.18-highlights-physx-system"></a>

The PhysX system has the following improvements and changes:
+ The legacy physics system is not compatible with the Lumberyard PhysX system. Using components from both systems is not supported.
+ The Script Canvas nodes appear in the **Physics (PhysX)** category and the **Physics (Legacy)** category, as appropriate.

## SDK Compatibility<a name="lumberyard-v1.18-highlights-compatible-sdk-versions"></a>

Lumberyard 1.18 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.4.34
+ Amazon GameLift Server SDK version 3.2.1

## UI Editor<a name="ui-editor-improvements-changes-v1.18"></a>

The UI Editor has the following improvements and changes:
+ The new `fontsize` attribute provides the following improvements:
  + Streamlines font texture configuration.
  + Rerenders text, which produces a high-quality look.
  + Removes the need for size-specific font XML files, which improves workflow.
+ An image with its **ImageType** set to **Fixed** now displays the original texture size.
+ Element visibility toggling is more efficient and intuitive.
+ The UI Editor now supports the 'pick entity' mode in its hierarchy pane and viewport.
+ You can now cut, copy, and paste components in the **Properties** pane.
+ You can now zoom by typing a value or using up and down arrows in the **Zoom** field.
+ You can now see the screen dimension borders in the **Preview**.
+ A new debug display shows you all information on all loaded canvases.
+ A new console command displays the textures that are being rendered.
+ You can now add a flag to a text component that enables markup.
+ You can now mark a UI element **Editor Only**, which means that the element and its children exist only within the context of the UI Editor. For example, when displaying a UI canvas in game mode or within a launcher, any element marked as **Editor Only** and its children are not displayed.
+ You can now open a **Search** window to search elements for a particular name or component.
+ Font (`.font`) files now support includes to support shared font effects.
+ You can use a new option on the **Sliced** image type to control whether the center and edges of the image are stretched.
+ Improvements to the following features:
  + Scripted Entity Tweener
  + Dynamic Scrollbox
  + Keyboard shortcuts
  + Image Sequence component
  + Flipbook Animation
+ You can now select the option to render target in **Fader**, which prevents child elements from becoming visible through other child elements.
+ The `ImageComponent::SetSpritePathname` now returns `true` if the specified asset exists, and `false` if it does not.
+ You can now set a flag on a UI element to start it as disabled.

## Visual Studio 2017<a name="visual-studio-support-improvements-changes-v1.18"></a>

Lumberyard 1.18 supports Visual Studio 2017 version 15.9.7.

Beginning with Visual Studio 2017, Microsoft now releases updates on a more frequent cadence (in some cases, weekly). Lumberyard is tested with the latest version of Visual Studio available during the release cycle. 