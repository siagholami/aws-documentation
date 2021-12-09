# Lumberyard Release Notes – Beta 1.18 (March 2019)<a name="lumberyard-v1.18"></a>

Lumberyard Beta 1.18 adds over 150 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community, whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-18/).

**Topics**
+ [Highlights](#lumberyard-v1.18-highlights)
+ [Improvements and Changes](lumberyard-v1.18-improvements-changes.md)
+ [Fixes](lumberyard-v1.18-fixes.md)
+ [Known Issues](lumberyard-v1.18-known-issues.md)

## Highlights<a name="lumberyard-v1.18-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.18.

**Topics**
+ [Asset Processor Faster Scanning Mode](#lumberyard-v1.18-highlights-fast-analysis-mode)
+ [Edit texture settings for individual images](#lumberyard-v1.18-highlights-texture-settings-editor-image-processing-gem)
+ [Render a scene from a camera to a texture](#lumberyard-v1.18-highlights-render-to-texture-component)
+ [Organize commonly used slices with the slice favorites feature](#lumberyard-v1.18-highlights-slice-favorites)
+ [Use layers to separate content in your level](#lumberyard-v1.18-highlights-layers-system)
+ [Updates to the Lumberyard PhysX system](#lumberyard-v1.18-highlights-physx-system)
+ [New Animation Editor features](#lumberyard-v1.18-highlights-animation-editor-new-features)
+ [New UI Editor features](#lumberyard-v1.18-highlights-ui-editor-new-features)

### Asset Processor Faster Scanning Mode<a name="lumberyard-v1.18-highlights-fast-analysis-mode"></a>

Process assets for your game projects more quickly with Asset Processor's **Faster Scanning Mode**. This mode speeds up Lumberyard's startup scan by disabling checking for cache changes that occurred while Asset Processor was not running. 

![\[Enable Faster Scanning Mode in Asset Processor to process game assets quickly.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-asset-processor-faster-scanning.png)

For more information, see [Enabling Asset Processor's Faster Scanning Mode](https://docs.aws.amazon.com/lumberyard/latest/userguide/asset-processor-faster-scanning.html) in the *Amazon Lumberyard User Guide*.

### Edit texture settings for individual images<a name="lumberyard-v1.18-highlights-texture-settings-editor-image-processing-gem"></a>

Lumberyard 1.18 introduces a new **Image Processing** gem that you must add to all projects. This gem enables access to the ****Texture Settings Editor****. You can use the ****Texture Settings Editor**** to edit the preset and processing options for individual textures, and see a preview of those settings on the texture. This is useful if you are customizing your images for different platforms, such as PC and Android. For example, you can specify compression scheme, mipmap generation parameters, alpha map combinations, and so on for images.

For more information, see the [Image Processing](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-image-processing.html) gem and the [https://docs.aws.amazon.com/lumberyard/latest/userguide/texture-settings-editor.html](https://docs.aws.amazon.com/lumberyard/latest/userguide/texture-settings-editor.html) in the *Amazon Lumberyard User Guide*.

![\[Texture Settings Editor UI in Lumberyard Editor\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/texture-pipeline-editor.png)

### Render a scene from a camera to a texture<a name="lumberyard-v1.18-highlights-render-to-texture-component"></a>

Lumberyard 1.18 introduces a new **Render to Texture** component that you can use to render the scene from a specific camera to a texture. You can use this feature to create rear-view mirrors and security camera screens, and to draw 3D models in the viewport. The **Render to Texture** component supports DirectX 11 for Windows.

For more information, see the **[Render To Texture](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-render-to-texture.html)** component in the *Amazon Lumberyard User Guide*.

![\[Example scene of the Render to Texture component in the Lumberyard Editor\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/RenderToTextureScene.PNG)

### Organize commonly used slices with the slice favorites feature<a name="lumberyard-v1.18-highlights-slice-favorites"></a>

Lumberyard 1.18 adds the ability to save a slice as a favorite. This allows you to more easily access and instantiate the slice into your scene. You can save slice favorites per user and per project, and they appear in the **Slice Favorites** panel.

For more information, see [Slice Favorites](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-slice-favorites.html) in the *Amazon Lumberyard User Guide*.

![\[Slice Favorites panel in Lumberyard Editor\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-component-slices-favorites-animated.gif)

### Use layers to separate content in your level<a name="lumberyard-v1.18-highlights-layers-system"></a>

Use the Lumberyard layer system to organize level data into discrete files. Segmenting level content allows multiple people to work on different parts of a level asynchronously. After you create a layer, you can modify it by adding entities, reorganizing its hierarchy, adding nested layers, renaming the layer, and so on.

For more information, see [Working with Layers](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-outliner-layers.html) in the *Amazon Lumberyard User Guide*.

![\[Amazon Lumberyard layer system\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-saving-layers.png)

### Updates to the Lumberyard PhysX system<a name="lumberyard-v1.18-highlights-physx-system"></a>

The Lumberyard PhysX system acts upon entities to create realistic physical effects, such as collision detection and rigid body dynamics simulation. You can try the preview release of the PhysX system by enabling the PhysX gem in the Project Configurator. You must have Visual Studio 2017 version 15.5.1 or later.

Lumberyard 1.18 integrates the NVIDIA PhysX SDK version 3.4 and introduces new features for the PhysX system.

**Note**  
Lumberyard includes only the Windows package for the PhysX SDK. See the [NVIDIA website](https://developer.nvidia.com/physx-sdk) to download the SDK for your operating system.

For more information, see [Simulating Physics Behavior with the PhysX System](https://docs.aws.amazon.com/lumberyard/latest/userguide/physx-intro.html) in the *Amazon Lumberyard User Guide*.

#### PhysX gem<a name="lumberyard-v1.18-highlights-physx-system-physx-gem-features"></a>

The [PhysX ](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-physx.html) gem includes the following features.

**PhysX Configuration tool**  
Use the **PhysX Configuration** tool to configure PhysX settings for your game project. You can do the following:
+ Configure world settings and editor settings.
+ Create collision layers to group objects of the same type.
+ Create collision groups to define what collision layers collide with.
+ Specify how to interact with the PhysX Visual Debugger (PVD), a third-party application that records your PhysX data from Lumberyard Editor and shows you how your physics effects appear

For more information, see [Configuring the PhysX System](https://docs.aws.amazon.com/lumberyard/latest/userguide/physx-configuration.html) in the *Amazon Lumberyard User Guide*.

**Dynamic and Kinematic Rigid Body Simulation**  
Use the **PhysX Rigid Body Physics** component to define an entity as a rigid object. This means the entity is solid and can move and collide with other PhysX entities. For example, you can add the **PhysX Rigid Body Physics** component to an entity to create a moving and solid entity, such as a projectile.

You can specify two main modes for a **PhysX Rigid Body Physics** component:
+ Dynamic rigid bodies – Fully simulated by Lumberyard and respond to collision events with other rigid bodies
+ Kinematic rigid bodies – Not fully simulated like dynamic rigid bodies; you specify movement using a script

For more information, see the **[PhysX Rigid Body Physics](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-physx-rigid-body-physics.html)** component in the *Amazon Lumberyard User Guide*.

**PhysX Collider component**  
Use the **PhysX Collider** component to provide a shape to your physics object. How the object moves or not depends on the **PhysX Rigid Body Physics** component. If the entity has the **PhysX Collider** component only, Lumberyard treats the entity as a static collider that doesn't move. This can be useful for creating game objects such as a wall or mountain. If the entity also has the **PhysX Rigid Body Physics** component, Lumberyard treats the entity as a dynamic collider. Dynamic colliders mean that the entity can move. For more information, see the **[PhysX Collider](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-physx-collider.html)** component in the *Amazon Lumberyard User Guide*.

**PhysX Terrain component**  
Use the **PhysX Terrain** component to export and save the terrain as an asset that loads at runtime. The **PhysX Terrain** component is required for games in which physics interacts with the terrain. For example, you can create a terrain collider so that your entities can interact with it, such as a barrel that falls to the ground and then rolls to a stop. For more information, see the **[PhysX Terrain](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-physx-terrain.html)** component in the *Amazon Lumberyard User Guide*.

**PhysX collision system**  
Use the PhysX collision system to define collision between objects. The concept of collision layers and collision groups defines collision properties for an object. For more information, see [Collision Layers](https://docs.aws.amazon.com/lumberyard/latest/userguide/physx-configuration-collision-layers.html) and [Collision Groups](https://docs.aws.amazon.com/lumberyard/latest/userguide/physx-configuration-collision-groups.html) in the *Amazon Lumberyard User Guide*.

**PhysX materials**  
Materials customize how an object reacts when it hits a surface and control qualities like friction and bounciness. In Lumberyard, you specify materials for each collider. Materials are stored inside a material library that you create using the **Asset Editor**. You can create one library with all materials for a project or separate libraries for different material types like terrain and gameplay objects. For more information, see [Working with PhysX Materials](https://docs.aws.amazon.com/lumberyard/latest/userguide/physx-materials.html) in the *Amazon Lumberyard User Guide*.

**PhysX scene queries**  
Use physics raycast and shape cast queries to determine whether a specific line segment intersects physics geometry. For example, you might want to determine what object is in front of another object, or test a line of sight. For a shape cast, the line segment is in the form of a desired shape (for example, a sphere). You can use scene queries to find nearby objects using the following methods: raycast, shapecast, or overlap. For more information, see [PhysX Scene Queries](https://docs.aws.amazon.com/lumberyard/latest/userguide/physx-scene-queries.html) in the *Amazon Lumberyard User Guide*.

**PhysX world**  
Physics objects must exist inside a world in order to be simulated. The PhysX gem automatically creates a world inside `ActionGame` with the default ID of `AZPhysicalWorld`. By default, all objects are added to this world and simulated each frame. For more information, see the [PhysX World Programming Notes](https://docs.aws.amazon.com/lumberyard/latest/userguide/physx-configuration-physx-world-programming-notes.html) in the *Amazon Lumberyard User Guide*.

#### PhysX Characters gem<a name="lumberyard-v1.18-highlights-physx-system-physx-characters-gem-features"></a>

The [PhysX Characters](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-physx-characters.html) gem includes the following features.

**PhysX Character Controller component**  
Use the **PhysX Character Controller** component to implement basic character interactions with the physical world. For example, you can prevent characters from walking through walls or passing through terrain. You can also control interactions with slopes and steps and manage interactions with other characters. For more information, see the **[PhysX Character Controller](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-physx-character-controller.html)** component in the *Amazon Lumberyard User Guide*.

**PhysX Ragdoll component**  
Use the **PhysX Ragdoll** component to create a physical representation of your character in the Lumberyard animation system. You can then simulate behaviors such as hit reactions and character death. For more information, see the **[PhysX Ragdoll](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-physx-ragdoll.html)** component and [Creating and Simulating a PhysX Ragdoll](https://docs.aws.amazon.com/lumberyard/latest/userguide/animation-editor-creating-and-simulating-physx-ragdoll.html) in the *Amazon Lumberyard User Guide*.

#### PhysX Debug gem<a name="lumberyard-v1.18-highlights-physx-system-physx-debug-gem-features"></a>

Use the **PhysX Debug** gem to debug visualizations for your PhysX scene geometry, such as the **PhysX Collider** component, **PhysX Rigid Body Physics** component, and so on. The **PhysX** gem also integrates the [NVIDIA PhysX Visual Debugger (PVD)](https://docs.nvidia.com/gameworks/content/gameworkslibrary/physx/guide/Manual/VisualDebugger.html) to provide a graphical view of the PhysX scene, and various tools to visualize the variables of every PhysX object, memory, and timing data.

For more information, see the [PhysX Debug](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-physx-debug.html) gem and [Debugging PhysX](https://docs.aws.amazon.com/lumberyard/latest/userguide/debugging-physx.html) in the *Amazon Lumberyard User Guide*.

### New Animation Editor features<a name="lumberyard-v1.18-highlights-animation-editor-new-features"></a>

Lumberyard 1.18 introduces the following **Animation Editor** features:
+ **Ragdoll** – Add character joints to a ragdoll to simulate behavior, such as hit reactions and character death. The animation system and the PhysX system work together to simulate the realistic behaviors. While the ragdoll setup occurs in the animation system, the PhysX system is responsible for how a character moves based on environmental interactions and external forces.
+ **Animation graph snapshot** – Use the [Anim Graph Net Sync](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-animgraph-netsync.html) component to sync animations cross-network for your multiplayer games.
+ **Actor LOD groups** – Set up multiple levels of detail (LOD) in an actor by using LOD groups. The **Simple LOD Distance** component will automatically detect actor LODs by using the LOD groups that you set up. This helps with runtime performance when actors change the LOD based on camera distance.
+ **Additive motion modifier** – Designate a motion as additive and specify which animation frame to subtract. The default frame to subtract is `0`. Using the additive motion modifier instead of the **Subtract** node can help decrease calculation before runtime.
+ **Reference node** – Reference an animation graph in another animation graph. This allows you to create a master animation graph that has multiple reference nodes, with each node referencing a different animation graph. Multiple users can then work on each animation graph simultaneously.
+ **Motion node** – Play motions randomly based on the motion probability weight that you specify. This allows you to change how frequently an animation plays. You can also turn off root motion and lock a character in place. This allows you to use game code to move a character in-game.
+ **Blend N node** – Adjust the input weight range, which is now customizable. You do not need to specify uniform spacing between input poses, and weights are no longer clamped between `0` to `1`.
+ **GetTransform and SetTransform nodes** – The **GetTransform** node gets the position, rotation, and scale of a character node. The **SetTransform** node changes the position, rotation, and scale of a character's joint. You can use these nodes in conjunction with other math nodes to obtain the preferred position, rotation, and scale of a character joint and then apply those values to another joint.
+ **Math nodes** – Use the following math nodes in your animation graph:
  + **Rotation Math 2** – Perform math operations (**Rotate** or **Inverse Rotate**) on two input rotations.
  + **RotationLimit** – Allow minimum and maximum angle limits for xyz axes, including the twist axis. This lets you limit the rotation of a joint.
  + **Connection of Vector nodes** – Connect output ports to input ports between **Vector 2** to **Vector 3** and between **Vector 3** to **Vector 4**.
+ **State/transition parameter actions** – Use parameter actions to add a transition action parameter to a transition line, state machine, or motion node. The action can change a parameter in the parent or child animation graph. This allows you to more easily change parameters and communicate those changes between animation graphs. For example, if a parent animation graph is a character, you can use an action parameter to sync the character's animation graph reload state with a gun's animation graph reload state.
+ **Parameterized events** – Create custom event classes with a set of parameters as a payload, and then add the events to the motions in the **Animation Editor**. This allows you to use complex parameters to manage events. 

For more information, see [Creating and Animating Characters](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-intro.html) in the *Amazon Lumberyard User Guide*.

### New UI Editor features<a name="lumberyard-v1.18-highlights-ui-editor-new-features"></a>

Lumberyard 1.18 introduces the following **UI Editor** features:
+ **Align tool** – Align the edges or centers of selected UI elements.
+ **Anchor mode** – Move UI elements in the viewport by changing the anchor settings instead of the offsets.
+ **Rulers and guides** – Display rulers and guides in the **UI Editor** viewport to help with positioning elements.
+ **Inline image markup** – Embed images in text strings using test markup.
+ **Overflow handling for text** – Shrink text (uniformly or by width) to fit within the element, or truncate the text with an ellipses (...).
+ **Clickable text links** – Designate part of a text string that can be clicked to perform actions.
+ **Texture atlases** – Combine individual textures into a texture atlas, and then configure a UI canvas to load and unload the texture atlas when the UI canvas loads and unloads. This can help reduce draw calls and compress textures.

For more information, see the [UI Editor](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-intro.html) in the *Amazon Lumberyard User Guide*.