# Lumberyard Release Notes – Beta 1.11 (September 2017)<a name="lumberyard-v1.11"></a>

Lumberyard Beta 1.11 adds over 400 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community, whose suggestions help us make a better product every release. Since launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-11/).

**Topics**
+ [Highlights](#lumberyard-v1.11-highlights)
+ [Improvements and Changes](lumberyard-v1.11-improvements-changes.md)
+ [Fixes](lumberyard-v1.11-fixes.md)
+ [Known Issues](lumberyard-v1.11-known-issues.md)

## Highlights<a name="lumberyard-v1.11-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.11.

**Topics**
+ [New Animation Editor for Lumberyard and Animation Sample Levels](#lumberyard-v1.11-highlights-animation-editor)
+ [Use Script Canvas to Script Game Logic and Behaviors](#lumberyard-v1.11-highlights-script-canvas)
+ [New High Quality Shadow Component](#lumberyard-v1.11-highlights-high-quality-shadow)
+ [New Graphics Scripting Gem](#lumberyard-v1.11-highlights-graphics-scripting-gem)
+ [Use Toon Shading to Create Non-Photorealistic Rendering Effects](#lumberyard-v1.11-highlights-toon-shading)
+ [New Cloud Canvas Features](#lumberyard-v1.11-highlights-cloud-canvas)
+ [Starter Game is the Default Project in Lumberyard Editor](#lumberyard-v1.11-highlights-starter-game-default)
+ [Create Game Projects from a Default Template or Empty Template](#lumberyard-v1.11-highlights-project-configurator-templates)
+ [Use the Simple Level to Learn How to Manipulate Objects](#lumberyard-v1.11-highlights-simple-level)
+ [Use the Microphone Gem to Capture Audio](#lumberyard-v1.11-highlights-microphone-gem)
+ [Easily Transition from CryEntity to the Lumberyard Component Entity System](#lumberyard-v1.11-highlights-component-entity-system)
+ [New Features and Improvements for the Component Entity System](#lumberyard-v1.11-highlights-component-entity-system-components)
+ [Easily Import Your Assets into Lumberyard](#lumberyard-v1.11-highlights-asset-importer)
+ [Use the Viewport Camera Selector to Position Your Camera](#lumberyard-v1.11-highlights-camera-view)
+ [Support for Linear Skinning Added to Geppetto](#lumberyard-v1.11-highlights-geppetto-linear-skinning)
+ [New UI Editor Features](#lumberyard-v1.11-highlights-ui-editor)
+ [New Amazon GameLift Features](#lumberyard-v1.11-highlights-amazon-gamelift)
+ [SDK Compatibility](#lumberyard-v1.11-highlights-compatible-sdk-versions)

### New Animation Editor for Lumberyard and Animation Sample Levels<a name="lumberyard-v1.11-highlights-animation-editor"></a>

Lumberyard 1.11 introduces the preview release of the EMotion FX Animation Editor, a new tool that helps artists build and animate complex character behavior. The Animation Editor includes visual tools to set up hierarchical state machines, logic, and advanced hierarchical blend trees. It also includes tools to create transition conditions, blend spaces, sync tracking, motion events, mirrored animation, and controllers (link IKs and LookAt). For more information, see [Animation Editor](https://docs.aws.amazon.com/lumberyard/latest/userguide/animation-editor-introduction.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/animation-editor-render-window.png)

Two new animation sample levels help demonstrate how the Animation Editor uses actors, motion sets, and animation graphs, along with Lumberyard component entities. You can access the sample levels in the `\dev\SamplesProject\Levels\Samples` directory.

**Advanced\_RinLocomotion**  
This level showcases the Rin character in a mini environment. Playable animations include idle, walk, run, and multiple attacks. The assets for this level are in the `\dev\SamplesProject\AnimationSamples\Advanced_RinLocomotion` directory. For more information, see [Advanced\_RinLocomotion Sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/animation-editor-rin-locomotion-sample.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/animation-editor-sample-level-rinlocomotion.png)

**Simple\_JackLocomotion**  
This level allows you to control Jack the robot. Playable animations include walk, run, and navigate. The assets for this level are in the `\dev\SamplesProject\AnimationSamples\Simple_JackLocomotion` directory. For more information, see [Simple\_JackLocomotion](https://docs.aws.amazon.com/lumberyard/latest/userguide/animation-editor-jack-locomotion-sample.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/animation-editor-sample-level-jacklocomotion.png)

### Use Script Canvas to Script Game Logic and Behaviors<a name="lumberyard-v1.11-highlights-script-canvas"></a>

Lumberyard 1.11 introduces the preview release of Script Canvas, a new visual scripting system that replaces Flow Graph. Script Canvas enables you to script game logic and behaviors using the component entity system. Script Canvas offers an approachable and easy to read environment to author behaviors using the same framework as Lua and C\+\+ and built to take advantage of the modularity, performance, and flexibility of the component entity system.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/script-canvas-x-axis-movement.png)

We're just getting started. We plan to make scripts easier to read, nodes simpler, and the language more efficient. But to build a great visual scripting option, we want your feedback. Tell us what you like, what's missing, and what workflows are getting in the way of efficient script creation. You can report bugs or join the discussion on our [forums](https://forums.awsgametech.com).

For more information, see [Script Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/creating-gameplay.html) and [Script Canvas Basic Sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/script-canvas-basic-sample.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-tank-script-canvas-example.gif)

### New High Quality Shadow Component<a name="lumberyard-v1.11-highlights-high-quality-shadow"></a>

You can use the High Quality Shadow component to give an entity its own shadow map and control over quality refinement. This allows you to create quality shadows for close-ups of your characters or hero props, and for game cinematics.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/HQShadow.gif)

### New Graphics Scripting Gem<a name="lumberyard-v1.11-highlights-graphics-scripting-gem"></a>

The Graphics Scripting Gem provides the ability to use graphics features in your scripts. With the gem enabled, you can use Script Canvas or Lua to write scripts to control features such as full screen effects, color correction, environment settings, shadow calculations, and more. For more information, see [Graphics Scripting Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-graphics-scripting.html) in the *Amazon Lumberyard User Guide*.

### Use Toon Shading to Create Non-Photorealistic Rendering Effects<a name="lumberyard-v1.11-highlights-toon-shading"></a>

Toon shading is a feature that enables you to create non-photorealistic rendering effects for your game. Instead of using a shade gradient, toon shading uses less shading color to make 3D graphics appear flat. You can use toon shading to create a comic book or cartoon style for your game. The toon look is most effective with content and textures authored with flat colors and less detail.

Lumberyard's toon shading feature projects the scene luminance into a lookup table, which controls the smoothness of shading on the surface to achieve the desired look.

For more information, see [Toon Shading](https://docs.aws.amazon.com/lumberyard/latest/userguide/graphics-rendering-toon-shading.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/Toon_StarterGame.gif)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/Toon_Bistro.gif)

### New Cloud Canvas Features<a name="lumberyard-v1.11-highlights-cloud-canvas"></a>

Lumberyard 1.11 introduces the following Cloud Canvas features:

**Speech Recognition Cloud Gem Preview**  
You can use the Speech Recognition Cloud Gem to add speech recognition and natural language processing to your Lumberyard game. The Speech Recognition Cloud Gem uses the Amazon Lex service, which recognizes the intent of spoken user input so that your game can react accordingly. Your users can use natural language and do not need to memorize or use specific phrases to initiate commands. For more information, see [Speech Recognition Cloud Gem Preview](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cloud-gem-speech-recognition-intro.html) in the *Amazon Lumberyard User Guide*.

**Text-to-Speech Cloud Gem**  
You can use the Text-to-Speech (TTS) Cloud Gem to enhance your gameplay and workflows with synthesized speech. The Cloud Canvas Text-to-Speech (TTS) Cloud Gem uses Amazon Polly, which is a text-to-speech service that turns text into lifelike speech. Amazon Polly offers dozens of lifelike voices in a variety of languages. The service also creates lip synchronization from the text that you provide. For more information, see [Text to Speech Cloud Gem (Using Amazon Polly)](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cloud-gem-text-to-speech-intro.html) in the *Amazon Lumberyard User Guide*.

**In-Game Survey Cloud Gem**  
You can use the In-Game Survey Cloud Gem and the Cloud Gem Portal to create surveys for your game and test them in the InGameSurveySample. Your players can see active surveys and submit answers to them. You can view survey results and manage your surveys in the Cloud Gem Portal. For more information, see [In-Game Survey Cloud Gem Portal](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cloud-gem-in-game-survey.html) in the *Amazon Lumberyard User Guide*.

**Rest API Explorer**  
The Cloud Gem Portal includes a Rest API explorer that enables you to invoke the APIs for your cloud gems for debugging and testing purposes.

**Game Server Role and Permissions**  
The Cloud Gem Framework includes a Game Server role that complements the existing Player and Admin roles. You can use the Game Server role to invoke and restrict dedicated server cloud gem APIs.

### Starter Game is the Default Project in Lumberyard Editor<a name="lumberyard-v1.11-highlights-starter-game-default"></a>

Starter Game is the default project when you launch Lumberyard Editor. You can use the Starter Game sample to see how Lumberyard systems work together to make a game. Starter Game is a small, third-person game that is built with the Lumberyard component entity system. In addition to component entities, Starter Game demonstrates bipedal locomotion, voxel-based global illumination, the time of day system, and more. For more information, see [Starter Game Sample](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-level-starter-game.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/starter-game-1.jpg)

### Create Game Projects from a Default Template or Empty Template<a name="lumberyard-v1.11-highlights-project-configurator-templates"></a>

Lumberyard includes **Empty** and **Default** templates that you can use as a starting point when you create your game project in the Project Configurator.
+ Empty template – The Empty template includes the minimum required for the editor to load and run the game project. Two gems, LyShine and Maestro, provide access to the in-game UI system and the cinematics functionality, respectively.
+ Default template – The Default template builds on the Empty template by enabling over a dozen gems to provide basic features for game development. For a list of gems that are enabled with the Default template, choose **Enable Gems** for your project in the Project Configurator.

For more information, see [Creating and Launching Game Projects](https://docs.aws.amazon.com/lumberyard/latest/userguide/configurator-projects.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/project-template-options.png)

### Use the Simple Level to Learn How to Manipulate Objects<a name="lumberyard-v1.11-highlights-simple-level"></a>

The Default template includes a Simple level, which is a starting point for you to manipulate objects in the editor and experiment with other assets in a neutral, gray environment. The Simple level includes a camera, a single light, an environment probe for reflections, and primitive objects with physics enabled. The objects are provided by the Primitive Assets Gem. For more information, see [Primitive Asset Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-primitive-assets.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/project-template-default-simple-level.png)

### Use the Microphone Gem to Capture Audio<a name="lumberyard-v1.11-highlights-microphone-gem"></a>

The Microphone Gem is a dependency for the Cloud Canvas Speech Recognition Gem. When you enable the Cloud Canvas Speech Recognition Gem in the Project Configurator, the Microphone Gem is also automatically added. The Microphone Gem connects to a hardware recording device and enables you to capture an audio signal. Once set up, the Microphone Gem connects to the device at application startup. Capturing starts when you start a capturing session and stops when you end the capturing session. For more information, see [Microphone Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-microphone.html) in the *Amazon Lumberyard User Guide*.

### Easily Transition from CryEntity to the Lumberyard Component Entity System<a name="lumberyard-v1.11-highlights-component-entity-system"></a>

Lumberyard 1.11 provides the following to help you transition from using CryEntity to the component entity workflow in Lumberyard:

**CryEntity Removal Gem**  
When you enable this gem, Lumberyard Editor displays only the features and tools that use the new component entity system. The following legacy features are disabled:
+ Database View
+ Flow Graph
+ Object Selector
+ Layer Editor
+ Rollup Bar
+ Asset Browser

For more information, see [CryEntity Removal Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-cryentity-removal-gem.html) in the *Amazon Lumberyard User Guide*.

**Legacy Converter**  
The Legacy Converter converts the legacy entities in your level to the corresponding component entity in the component entity system. For more information, see [Converting Entities with the Legacy Converter](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-data-converter.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/legacy-converter-conversion.PNG)

### New Features and Improvements for the Component Entity System<a name="lumberyard-v1.11-highlights-component-entity-system-components"></a>

Lumberyard 1.11 introduces new features and improvements to the component entity system.
+ You can now access the documentation for a component by clicking the help button in the component title bar. This launches a web browser and loads the corresponding help page.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/component-help-button.png)

  If you want to link to your own documentation for a custom component, you can add the `HelpPageURL` attribute to your component reflection. The following example demonstrates how to use the `HelpPageURL` attribute:

  ```
  Attribute(AZ::Edit::Attributes::HelpPageURL, "https://docs.aws.amazon.com/lumberyard/latest/userguide/component-comment.html"))
  ```
+ The Entity Outliner now supports reordering entities. You can select and move entities to change the sort order, or you can right-click an entity and choose from the menu options to move the entity up or down in the list.
+ You can determine if an entity is automatically active when the level loads. In the Entity Inspector, choose the **Start Active** check box.
+ You can customize the order that components and scripts receive `OnTick()` events by overriding the `GetTickOrder()` function.
+ You can use scripts to add certain components to entities and configure their properties before activation.

For more information, see the [Component Entity System](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-intro.html) in the *Amazon Lumberyard User Guide*.

### Easily Import Your Assets into Lumberyard<a name="lumberyard-v1.11-highlights-asset-importer"></a>

You can use the Asset Importer to easily import assets into your Lumberyard game project. In Lumberyard Editor, choose **File**, **Import**. You can specify the destination folder and whether to copy or move files. We recommend copying your files. When the Asset Processor finishes processing your files, they appear in the Asset Browser.

### Use the Viewport Camera Selector to Position Your Camera<a name="lumberyard-v1.11-highlights-camera-view"></a>

You can use the **Viewport Camera Selector** to quickly position and orient a camera in your game. You can choose between all in-game cameras and the editor camera. When you possess the camera, the editor controls will allow you to manipulate the camera. For more information, see [Changing the Camera View](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-editor-viewport.html#lumberyard-editor-viewport-camera) in the *Amazon Lumberyard User Guide*.

### Support for Linear Skinning Added to Geppetto<a name="lumberyard-v1.11-highlights-geppetto-linear-skinning"></a>

Lumberyard 1.11 adds support for traditional linear skinning methods on the Actor component in Geppetto. You can choose linear skinning or dual quaternion to achieve the preferred deformation results.
+ Linear skinning – Provides more predictable deformations but may produce unintended effects for rolling limbs with extra bones. Characters that use linear skinning may require more bones for similar quality deformation in problem areas.
+ Dual quaternion – Supports rolling limbs with less deformation artifacts but can often result in bulges in the latissimus dorsi when the arms are raised.

If you chose dual quaternion when creating your skinned mesh, the mesh displays as linear skinning only in the **Animation Editor OpenGL Render Window**. In the main Lumberyard Editor window, dual quaternion is the default skinning method for any Actor component entity that you create.

### New UI Editor Features<a name="lumberyard-v1.11-highlights-ui-editor"></a>

Lumberyard 1.11 introduces the following UI Editor features:
+ Loading screens – Display a UI canvas, including animation, during game loading and loading between levels.
+ Dropdowns – The Dropdown component enables an element to behave like a drop-down menu. The DropdownOption component enables an element to behave like an option in the drop-down menu.
+ Radio buttons – Enables an element to behave like a radio button.
+ Layout fitters – Automatically resizes an element to fit the content.

For more information, see [UI Components](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-components.html) in the *Amazon Lumberyard User Guide*.

### New Amazon GameLift Features<a name="lumberyard-v1.11-highlights-amazon-gamelift"></a>

Stay up to date with the latest release information at [AWS Release Notes for Amazon GameLift](https://aws.amazon.com/releasenotes/Amazon-GameLift?browse=1).

### SDK Compatibility<a name="lumberyard-v1.11-highlights-compatible-sdk-versions"></a>

Lumberyard 1.11 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.1.13
+ Amazon GameLift Server SDK version 3.1.5