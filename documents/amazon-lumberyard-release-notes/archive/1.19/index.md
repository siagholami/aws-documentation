# Lumberyard Release Notes – Beta 1.19 (June 2019)<a name="lumberyard-v1.19"></a>

Lumberyard Beta 1.19 adds over 150 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/lumberyard-beta-1-19-available-now/).

**Topics**
+ [Highlights](#lumberyard-v1.19-highlights)
+ [Improvements and Changes](lumberyard-v1.19-improvements-changes.md)
+ [Fixes](lumberyard-v1.19-fixes.md)
+ [Known Issues](lumberyard-v1.19-known-issues.md)

## Highlights<a name="lumberyard-v1.19-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.19.

**Topics**
+ [Dynamic Vegetation](#lumberyard-v1.19-highlights-dynamic-vegetation)
+ [Script Canvas](#lumberyard-v1.19-highlights-script-canvas)
+ [New Viewport Interaction Model](#lumberyard-v1.19-viewport-interaction-model)
+ [Editing Components in the Viewport](#editing-components-in-the-viewport)

### Dynamic Vegetation<a name="lumberyard-v1.19-highlights-dynamic-vegetation"></a>

Lumberyard 1.19 introduces a new component-entity–based system for authoring procedurally placed vegetation. The vegetation can be loaded and instantiated dynamically and will spawn and despawn as the player moves through the world. You can use the new components to place vegetation assets and customize how they appear. This enables you to create different environments for your game for worlds of any size. 

This feature adds the following benefits:
+ Customize vegetation to fit specific areas of your environment and configure vegetation to grow only on specific surfaces
+ Create complex biomes in one nested slice to apply changes across areas of an entire world
+ Quickly iterate your vegetation settings to preview how your changes appear in your game

![\[Dynamic vegetation example in Lumberyard.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/dynamic-vegetation-intro.png)

To enable dynamic vegetation, you must enable the following gem:
+ Vegetation – Provides the dynamic vegetation system and core vegetation components

The dynamic vegetation system uses the gradient and surface data systems. This gives you more control over where you can place dynamic vegetation in the world.

#### Gradients<a name="lumberyard-v1.19-gradients"></a>

You can use the gradient components to provide curated, controlled, or procedural data that can be sampled at any world space position. For example, you can use the gradient components with dynamic vegetation to randomize the placement of vegetation.

To enable gradients, you must enable the following gems:
+ Gradient Signal – Provides gradient and gradient modifier components to create realistic vegetation
+ Fast Noise Gradient – Provides a **FastNoise Gradient** component to generate procedural noise variations for vegetation

#### Surface Data<a name="lumberyard-v1.19-surface-data"></a>

You can use the surface data components to query any world position and return a list of surface tags (for example, water, terrain, road, dirt, grass) that an entity emits at the location. For example, you can create a river entity and attach a surface tag emitter component to it. Using dynamic vegetation, you can specify the types of vegetation that can and can't appear in a river. 

To enable surface data, you must enable the following gem:
+ Surface Data – Provides surface tag emitter components to include or exclude vegetation

For more information, see [Dynamic Vegetation](https://docs.aws.amazon.com/lumberyard/latest/userguide/dynamic-vegetation-intro.html) in the *Amazon Lumberyard User Guide*.

### Script Canvas<a name="lumberyard-v1.19-highlights-script-canvas"></a>

Lumberyard 1.19 introduces the following features.

#### Creating a Chain of Linked Nodes<a name="script-canvas-chain-linked-nodes"></a>

You can quickly add nodes in succession to a graph by using the chaining feature. Script Canvas automatically links the pins on each new node to the previous node.

![\[Quickly add nodes in succession in the Script Canvas editor.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-script-canvas-working-with-nodes-1.gif)

For more information, see [Adding and Connecting Nodes](https://docs.aws.amazon.com/lumberyard/latest/userguide/script-canvas-working-with-nodes-adding-and-connecting.html) in the *Amazon Lumberyard User Guide*.

#### Grouping Nodes<a name="script-canvas-grouping-nodes"></a>

You can group your nodes to organize parts of a script and reduce its visual complexity. You can also name, nest, color-code, and expand and collapse node groups.

![\[Creating a node group in the Script Canvas editor.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-script-canvas-node-groups-1.gif)

For more information, see [Grouping Nodes](https://docs.aws.amazon.com/lumberyard/latest/userguide/script-canvas-node-groups.html) in the *Amazon Lumberyard User Guide*.

#### Container Support<a name="script-canvas-containers"></a>

Script Canvas now supports arrays and maps, including supporting nodes for accessing data in containers. You can use arrays to provide a dynamic continuous area of memory that can hold storage of a given type.

![\[Script Canvas arrays and maps in Lumberyard Editor\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-script-canvas-containers-2.png)

You can use maps to create containers of key/value pairs. 

![\[Enter information to create a key/value pair map.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-script-canvas-containers-12.png)

For more information, see [Using Containers (Arrays and Maps)](https://docs.aws.amazon.com/lumberyard/latest/userguide/script-canvas-containers.html) in the *Amazon Lumberyard User Guide*.

**Node Alignment Tools**  
In your Script Canvas graphs, you can align selected nodes relative to each other (top, left, bottom, and right).

**Script Events**  
Script Events are a robust, data-driven mechanism for creating cross-script events. You can create events to use in Lua and Script Canvas. You can send events from one script to another. To use Script Events, you must enable the Script Events gem in Project Configurator.

**Script Canvas Debugger**  
Script Canvas now features a runtime debugger. The debugger allows Script Canvas to connect to the game and collect runtime information about graphs. You can run the debugger in the editor or in a standalone launcher.

**Unit Test Manager**  
Support for Script Canvas unit testing has been improved, including a new Script Canvas Testing gem. You can enable this gem for your game project to test Script Canvas and its features. The Unit Test Manager quickly runs unit tests to determine if they pass or fail.

**Script Canvas Statistics (Preview)**  
Script Canvas now provides a way to gain insight into the use of Script Canvas nodes. You can use the **Statistics** dialog to track and locate node usage across an entire project's collection of Script Canvas graphs. This feature helps you better understand the use cases of various nodes and the cost of refactoring or changing functionality.

For more information, see [Creating Gameplay with Script Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/script-canvas-intro.html) in the *Amazon Lumberyard User Guide*.

### New Viewport Interaction Model<a name="lumberyard-v1.19-viewport-interaction-model"></a>

You can enable the new Viewport Interaction Model feature in Lumberyard Editor. This experimental feature is designed to make editing your entities simpler and more intuitive in Lumberyard. 

This feature includes the following improvements:
+ Interacts with entities using manipulators instead of gizmos
+ Adds support for new translation and rotation manipulators
+ Uses a single aggregate manipulator to edit multiple entities at once
+ Simplifies your selection when switching between parent or world space
+ Moves the manipulator independent of your selection
+ Adds support for ditto operations for working with manipulators and entities
+ Enables you to quickly switch between translation and rotation manipulators

![\[Edit your entities in the Viewport Interaction Model for Lumberyard Editor.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/viewport-selection-model-7.gif)

You can enable this feature from the **Preferences** window in Lumberyard Editor.

**Note**  
This feature is experimental and is subject to change. It doesn't support the following:  
Vertex snapping
The **Terrain Editor** and **Track View** editor
Legacy entities (such as terrain and vegetation)
Partial support for the **Material Editor**

For more information, see [Working with the Viewport Interaction Model](https://docs.aws.amazon.com/lumberyard/latest/userguide/working-with-viewport-interaction-model.html) in the *Amazon Lumberyard User Guide*.

### Editing Components in the Viewport<a name="editing-components-in-the-viewport"></a>

In the **Entity Inspector**, you can now choose the **Edit** button for select components. All other components attached to the entity can't be edited. This feature prevents you from accidentally editing other components attached to the entity and makes it easier to edit your components freely in the viewport.

![\[Example Spline component with the Component Mode option enabled and all other components dimmed.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/using-component-mode-4.png)

You can use this feature to do the following:
+ Enter a sandbox to edit only the selected component properties
+ Customize shortcuts for your components
+ Use manipulators to make editing visual data more intuitive
+ Build your own Component Mode for other components

For more information, see [Editing Components in the Viewport](https://docs.aws.amazon.com/lumberyard/latest/userguide/edit-mode-for-components.html) in the *Amazon Lumberyard User Guide*.