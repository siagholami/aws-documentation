# Lumberyard Release Notes – Beta 1.12 (December 2017)<a name="lumberyard-v1.12"></a>

Lumberyard Beta 1.12 adds over 400 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community, whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-12/).

**Topics**
+ [Highlights](#lumberyard-v1.12-highlights)
+ [Improvements and Changes](lumberyard-v1.12-improvements-changes.md)
+ [Fixes](lumberyard-v1.12-fixes.md)
+ [Known Issues](lumberyard-v1.12-known-issues.md)

## Highlights<a name="lumberyard-v1.12-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.12.

**Topics**
+ [Use the Fur Shader to Create Short-Medium Length Fur](#lumberyard-v1.12-highlights-fur-shader)
+ [New Components for the Component Entity System](#lumberyard-v1.12-highlights-component-entity-system-components)
+ [Use the Water Gem to Create Bodies of Water](#lumberyard-v1.12-highlights-water-gem)
+ [Use the Visibility Gem to Create Indoor Areas](#lumberyard-v1.12-highlights-visibility-gem)
+ [New Script Canvas Features](#lumberyard-v1.12-highlights-script-canvas)
+ [New Cloud Canvas Features](#lumberyard-v1.12-highlights-cloud-canvas)
+ [Enable Carrier ACK Feedback](#lumberyard-v1.12-highlights-carrier-ack-feedback)
+ [New UI Editor Features](#lumberyard-v1.12-highlights-ui-editor)
+ [Use the Audio Preload Component for ATL Preloads](#lumberyard-v1.12-highlights-audio-preload-component)
+ [New Amazon GameLift Features](#lumberyard-v1.12-highlights-amazon-gamelift)
+ [SDK Compatibility](#lumberyard-v1.12-highlights-compatible-sdk-versions)

### Use the Fur Shader to Create Short-Medium Length Fur<a name="lumberyard-v1.12-highlights-fur-shader"></a>

With the **Fur** shader you can create real-time rendering of short to medium length fur. You can apply this shader to any mesh and define where fur appears, the length of the fur, how it clumps together, and how nonuniform strands appear across a mesh. You can also use the following features:
+ **Anisotropic specular highlights** – Highlights appear banded perpendicular to the direction of the fur strands.
+ **Subsurface scattering** – Subsurface scattering appears on the silhouette edges of the fur, creating a glow effect when the fur is backlit.

For more information, see [Fur Shader](https://docs.aws.amazon.com/lumberyard/latest/userguide/shader-ref-fur.html) in the *Amazon Lumberyard User Guide*.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shader-ref-fur-6.png)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shader-ref-fur-13.gif)

### New Components for the Component Entity System<a name="lumberyard-v1.12-highlights-component-entity-system-components"></a>

Lumberyard 1.12 adds the following components:
+ **Fog Volume** – Use this component to define ellipsoid or cuboid volumes of localized fog.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/fog-component-example-5.PNG)
+ **Geometry Cache** – Use this component to load Alembic files and script them in your level. This feature is commonly used to create high fidelity geometry animation effects, such as destruction and natural effects.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-geom-cache-example-animation.gif)
+ **Lightning** – Enable the **Lightning** gem and use the **Lightning** component to create individual lightning strikes. You can use this component with the **Random Timed Spawner** component to create lightning storms.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-lightning-component-animation-example.gif)
+ **Lightning Arc** – Enable the Lightning Arc gem and use the **Lightning Arc** component to create arcing energy effects that use targets.  
![\[Add the Lightning Arc component to your entity to create lightning arcs that jump between entities.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-lightning-arc-component-animation-example.gif)
+ **Polygon Prism** – Use this component to define an arbitrarily shaped polygonal volume. You can use this component with the **Water Volume** component to define irregular areas such as ponds and lakes.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/polygon-prism-component-example.png)
+ **Rain** – Enable the **Rain** gem and use the **Rain** component to create falling rain, wet surfaces, and wet ground effects.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-rain-component-animation-example.gif)
+ **Snow** – Enable the **Snow** gem and use the **Snow** component to create falling snow and freezing ground effects.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-snow-component-animation-example.gif)
+ **Spline** – Use this component to author lines and/or curves in the editor.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/spline-component-example.png)

For more information, see the [Component Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html) in the *Amazon Lumberyard User Guide*.

### Use the Water Gem to Create Bodies of Water<a name="lumberyard-v1.12-highlights-water-gem"></a>

The **Water** gem includes the following components:
+ **Infinite Ocean** – Use this component to add or remove a single, infinitely large ocean in your level.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/water-gem-infinite-ocean-example.png)
+ **Water Volume** – Use this component to add multiple, arbitrarily shaped bodies of water in your level.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-water-gem-water-volume-example.png)

The **Water** gem disables the legacy ocean, so you must add the **Infinite Ocean** component for an ocean to appear in your level.

For more information, see the [Component Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html) in the *Amazon Lumberyard User Guide*.

### Use the Visibility Gem to Create Indoor Areas<a name="lumberyard-v1.12-highlights-visibility-gem"></a>

The **Visibility** gem includes the following components:
+ **Occluder Area** – Use this component to create a custom-shaped occlusion plane with four vertices. This component also prevents the engine from rendering everything behind the occluder area, which can help optimize performance in areas where automatic occlusion doesn't work well.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/component-occluderarea.png)
+ **VisArea** – Use this component to manage visibility and culling. This allows a camera to see only objects within the visible area. The **VisArea** component is commonly used for indoor areas. You can use this component with the **Portal** component to create windows between the visible areas, and create areas that are efficient to render.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/component-visarea-4.png)
+ **Portal** – Use this component with the **VisArea** component to create efficient indoor areas. Portals act like windows or doors between visible areas.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/component-portal-5.png)

For more information, see the [Component Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html) in the *Amazon Lumberyard User Guide*.

### New Script Canvas Features<a name="lumberyard-v1.12-highlights-script-canvas"></a>

With Script Canvas you can script game logic and behaviors using the component entity system. Script Canvas offers an approachable and easy-to-read environment to author behaviors that use the same framework as Lua and C\+\+. Script Canvas is built to take advantage of the modularity, performance, and flexibility of the component entity system. Lumberyard 1.12 adds the following Script Canvas features:
+ **Block commenting** – Use block comments to group parts of your graph and tag and/or color code the grouping.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/block-comment-node.png)
+ **Library of math nodes** – New math nodes have improved functionality and are easier to use. The math primitives are handled by value and most math operations are handled natively.

For more information, see [Script Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/creating-gameplay.html) in the *Amazon Lumberyard User Guide*.

### New Cloud Canvas Features<a name="lumberyard-v1.12-highlights-cloud-canvas"></a>

Lumberyard 1.12 introduces the following **Cloud Canvas** features:

**Speech Recognition Cloud Gem**  
You can use the Speech Recognition Cloud Gem to add speech recognition and natural language processing to your Lumberyard game. The Speech Recognition Cloud Gem uses the Amazon Lex service, which recognizes the intent of spoken user input so that your game can react accordingly. Your users can use natural language and do not need to memorize or use specific phrases to initiate commands. Lumberyard 1.12 adds a full set of tools and a workflow that let you create, edit, and manage Lex conversational bots and intents in the Cloud Gem Portal. For more information, see [Speech Recognition Cloud Gem Preview](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cloud-gem-speech-recognition-intro.html) in the *Amazon Lumberyard User Guide*.

**Text-to-Speech Cloud Gem**  
You can use the Text-to-Speech Cloud Gem to enhance your gameplay and workflows with synthesized speech. The Text-to-Speech Cloud Gem uses Amazon Polly, which is a text-to-speech service that turns text into lifelike speech. Amazon Polly offers dozens of lifelike voices in a variety of languages. The service also creates lip synchronization from the text that you provide. You can use the **Animation Editor** to implement animated lip synchronization. For more information, see [Text to Speech Cloud Gem (Using Amazon Polly)](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cloud-gem-text-to-speech-intro.html) in the *Amazon Lumberyard User Guide*.

### Enable Carrier ACK Feedback<a name="lumberyard-v1.12-highlights-carrier-ack-feedback"></a>

In the default GridMate implementation, a change in a dataset causes four unreliable updates and then one reliable update to be sent. This technique can result in many reliable packets on the network. Because reliable packets require ordering, preceding packets cannot be processed until a lost packet is successfully retransmitted. The resulting delay can cause jitter. To avoid this issue, you can enable carrier ACK feedback.

When carrier ACK feedback is enabled, a changed dataset propagates its update unreliably until the receiver sends an ACK to acknowledge that it received the update. Additionally, if a dataset update is acknowledged as received before the grace period specified by `MaxIdleTime`, GridMate saves bandwidth by not sending additional unneeded updates.

For more information, see [Carrier ACK Feedback](https://docs.aws.amazon.com/lumberyard/latest/userguide/network-replicas-data-sets.html#network-replicas-data-sets-carrier-ack-feedback) in the *Amazon Lumberyard User Guide*.

### New UI Editor Features<a name="lumberyard-v1.12-highlights-ui-editor"></a>

Lumberyard 1.12 introduces the following **UI Editor** features:
+ **Sprite sheets and flipbook animations** – Use a sprite index to include multiple images in a texture file and reference that file from the **UI Image** component. You can then use a flipbook animation to animate the image by flipping from one sprite to another.
+ **Image fill types** – The **UI Image** component supports fill types, so you can fill an image linearly or radially. You can use this for bars and dials in the UI.
+ **Script-driven animation** – With the Scripted Entity Tweener gem, you can use Lua to animate virtual properties on component entities. This allows animation script components to reside within a slice and provides more dynamically controlled animations.
+ **Tabbed canvas editing** – The **UI Editor** supports tabs, so you can edit multiple UI canvases and copy and paste between the UI canvases.

For more information, see the [UI Editor](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-intro.html) in the *Amazon Lumberyard User Guide*.

### Use the Audio Preload Component for ATL Preloads<a name="lumberyard-v1.12-highlights-audio-preload-component"></a>

With the **Audio Preload** component, you can load and unload soundbank data (contained in ATL preloads) through component entities. You can specify the loading type:
+ **Automatic** – ATL preloads automatically load when the component activates and unload when the component deactivates.
+ **Manual** – ATL preloads load and unload only if requests are sent to the interface.

For more information, see the [Component Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html) in the *Amazon Lumberyard User Guide*.

### New Amazon GameLift Features<a name="lumberyard-v1.12-highlights-amazon-gamelift"></a>

Stay up to date with the latest release information at [AWS Release Notes for Amazon GameLift](https://aws.amazon.com/releasenotes/Amazon-GameLift?browse=1).

### SDK Compatibility<a name="lumberyard-v1.12-highlights-compatible-sdk-versions"></a>

Lumberyard 1.12 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.1.13
+ Amazon GameLift Server SDK version 3.1.5