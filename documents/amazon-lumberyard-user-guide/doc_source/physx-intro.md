# Simulating physics behavior with the PhysX system<a name="physx-intro"></a>

****  
This feature is in [preview](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#preview) release and is subject to change\. 

Lumberyard's PhysX system acts upon entities to create realistic physical effects such as collision detection and rigid body dynamics simulation\. To use the PhysX system, install the [PhysX SDK](https://developer.nvidia.com/gameworks-physx-overview) using the [Lumberyard Setup Assistant](lumberyard-launcher-using.md)\.

**Note**  
 Lumberyard's PhysX system does not interact with [Physics \(Legacy\)](component-components.md#component-entity-physics-legacy) component entities or the legacy [Physics](https://docs.aws.amazon.com/lumberyard/latest/legacyreference/physics-intro.html)\.

**Topics**
+ [PhysX Gems](#physx-intro-gems)
+ [PhysX Components](#physx-intro-physx-components)
+ [PhysX Configuration](#physx-intro-configuration)
+ [PhysX Materials](#physx-intro-materials)
+ [PhysX Debugging](#physx-intro-debugging)
+ [Configuring the PhysX System](physx-configuration.md)
+ [Physics materials](physx-materials.md)
+ [PhysX Scene Queries](physx-scene-queries.md)
+ [Debugging PhysX](debugging-physx.md)
+ [PhysX Best Practices](physx-best-practices.md)

## PhysX Gems<a name="physx-intro-gems"></a>

The PhysX system uses the following gems, which you can [enable](gems-system-using-project-configurator.md) in the Project Configurator:
+ **[PhysX](gems-system-gem-physx.md)** – Provides integration for the [NVIDIA PhysX SDK](https://developer.nvidia.com/physx-sdk) into Lumberyard\. The integration provided includes a suite of components, configuration via the editor, Script Canvas integration, PhysX Visual Debugger integration, and a simplified API abstraction layer for games\. 

  For more information, see [PhysX](gems-system-gem-physx.md)\.
+ **[PhysX Characters](gems-system-gem-physx-characters.md)** – Provides integration for character controllers and ragdolls\. To enable the PhysX Characters gem, you must first enable the [PhysX](gems-system-gem-physx.md) gem\.

  For more information, see [PhysX Characters](gems-system-gem-physx-characters.md)\.
+ **[PhysX Debug](gems-system-gem-physx-debug.md)** – Provides debug visualizations of PhysX scene geometry that you can enable with console commands and other tools\.

  For more information, see [PhysX Debug](gems-system-gem-physx-debug.md)\.

## PhysX Components<a name="physx-intro-physx-components"></a>

The **PhysX** gem has the following components, which you can [add](component-working-adding.md) to entities by using the [**Entity Inspector**](component-entity-inspector.md):
+ **[PhysX Collider](component-physx-collider.md)** – Enables physics objects to collide with other physics objects\. An entity that does not have a **PhysX Rigid Body Physics** component is a **static** collider, while an entity with the component is a **dynamic** collider\.
+ **[PhysX Force Region](component-physx-force-region.md)** – Enables an entity to specify a region that applies physical force to entities\. For each physics simulation frame, the component applies force to entities that are in the bounds of the region\.
+ **[PhysX Rigid Body](component-physx-rigid-body-physics.md)** – Enables an entity to be simulated by physics\. Rigid body mode can be **kinematic** or **dynamic**\. Dynamic rigid bodies respond to collision events with other rigid bodies\. Kinematic rigid bodies are not affected by outside forces and gravity; their motion is driven by scripting\.
+ **[PhysX Terrain](component-physx-terrain.md)** – Implements physical interaction with the terrain\. It exports terrain and saves it as an asset that loads at runtime\. 

The **PhysX Characters** gem has the following components:
+ **[PhysX Character Controller](component-physx-character-controller.md)** – Implements basic character interactions with the physical world\. For example, it can control interactions with slopes and steps, manage interactions with other characters, and prevent characters from walking through walls or passing through terrain\.
+ **[PhysX Ragdoll](component-physx-ragdoll.md)** – Enables animation of certain character behaviors\. The physical representation is usually a hierarchical collection of rigid bodies with simple shapes connected by joints\.

## PhysX Configuration<a name="physx-intro-configuration"></a>

Use the **PhysX Configuration** window in Lumberyard Editor to configure global settings, collision layers, collision groups, and PhysX Visual Debugger settings\.

For more information, see [Configuring the PhysX System](physx-configuration.md)\.

## PhysX Materials<a name="physx-intro-materials"></a>

PhysX materials allow simulation properties to be configured by entity\. Materials customize how an object reacts when it hits a surface and control qualities like friction and bounciness\. You use the **Asset Editor** to create a material library, assign the library to a collider, and then select a specific material from the library for the collider\. 

For more information, see [Physics materials](physx-materials.md)\.

## PhysX Debugging<a name="physx-intro-debugging"></a>

To verify the implementation of interactions in the simulated world, the following tools are available\.
+ **PhysX Debug gem** – The PhysX Debug gem is recommended if you are a developer or technical artist\. You can use this tool to view the physics world in real time in Lumberyard Editor's editor mode or game mode\. To activate the tool, you use console commands or an immediate mode graphical user interface \(ImGui\)\. The tool displays PhysX debug lines within the editor and game modes\.

  For more information, see [PhysX Debug](gems-system-gem-physx-debug.md)\.
+ **PhysX Visual Debugger** – The [PhysX Visual Debugger \(PVD\)](https://developer.nvidia.com/physx-visual-debugger) is a third party tool provided by NVIDIA that is useful for deep inspection of the PhysX world\. Lumberyard can connect PhysX worlds and scenes to a running PVD application instance\. You can use the PVD to step through your simulation and examine various properties at your own pace in detail\. 

  For information on configuring Lumberyard's connection to PVD, see [Debugger Configuration](physx-configuration-debugger.md)\. 

For more information, see [Debugging PhysX](debugging-physx.md)\.