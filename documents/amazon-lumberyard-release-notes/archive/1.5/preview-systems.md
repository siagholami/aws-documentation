# Preview Systems and Tools<a name="lumberyard-v1.5-preview-systems"></a>

We are especially interested in your comments on the following feature previews. Please [submit feedback on our forums](http://gamedev.amazon.com/forums) or send an email to lumberyard-feedback@amazon.com.

**Topics**
+ [Mobile Support – Android Studio and Clang Compiler](#lumberyard-v1.5-preview-mobile-support)
+ [Particle Editor Adds Custom Attribute Panels, Trail Particles, and GPU Particles](#lumberyard-v1.5-preview-particle-editor)
+ [New Components Added to the Component Entity System](#lumberyard-v1.5-preview-component-entity-components)
+ [System Entity Editor – Customize System Components](#lumberyard-v1.5-preview-system-entity-editor)

## Mobile Support – Android Studio and Clang Compiler<a name="lumberyard-v1.5-preview-mobile-support"></a>

Lumberyard Beta 1.5 adds the following features for mobile support: 
+ Support for the Clang compiler to generate a working build. You must have installed Android NDK r11 or later and Android SDK-21 or later. We recommend that you switch to Clang before support for the GNU Compiler Collection (GCC) is deprecated.
+ Ability to automatically generate Android Studio projects using a Waf build option, so you are no longer required to manually regenerate a project.
+ Ability for the Lumberyard Setup Assistant to detect your operating system and display relevant options only.

For more information, see [Mobile Support](https://docs.aws.amazon.com/lumberyard/latest/userguide/mobile-support-intro.html).

## Particle Editor Adds Custom Attribute Panels, Trail Particles, and GPU Particles<a name="lumberyard-v1.5-preview-particle-editor"></a>

The Particle Effects system allows you to create and simulate visual effects such as explosions, fire, and sparks. This advanced system includes playback controls, a gradient editor, a color picker, and color libraries. Added features and functionality include: 
+ Custom attribute panels that allow you to customize your workflow and create a set of your most commonly used attributes. Drag and drop these attributes into a new pane and save the custom pane to share between you and your team.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/particle_editor_custom_attributes.JPG)
+ Trail particles, which are an emitter type and allow you to lock UV anchor points to a stream and set the fade length of the trail when in motion.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/particle_editor_trails_menu.jpg)
+ Level of detail (LOD) that adds finite control for you to optimize your effects at various distances from the camera.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/particle_editor_LODs.jpg)
+ GPU particles that allow you to spawn millions of particles from one emitter in the count attribute, with performance depending on your hardware specifications. In addition, GPU particles can now cast and receive shadows.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/particle_editor_shadows_menu.jpg)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/particle_editor_GPU_shadows.gif)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/particle_editor_shadows.png)
+ Glow and normal maps that you can add directly to the particle without creating a unique material first.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/particle_editor_glow_normal_maps.jpg)

For more information, see [Particle Effects System](https://docs.aws.amazon.com/lumberyard/latest/userguide/particle-intro.html).

## New Components Added to the Component Entity System<a name="lumberyard-v1.5-preview-component-entity-components"></a>

Lumberyard Beta 1.5 adds the following new components to the component entity system:
+ Generic primitive shape components that can serve the shape needs of any component: 
  + Box
  + Sphere
  + Cylinder
  + Capsule
+ Primitive collider component – In combination with the primitive shape components, the primitive collider component provides physics colliders that are shaped like primitives, as defined by a corresponding shape component.
+ Ragdoll component – The ragdoll component provides the ability to configure and trigger ragdoll for the associated entity.
+ Filtering and tagging component – The filtering and tagging component allows the association of zero or more tags with an entity and responds to tag-related queries.
+ Skinned mesh component and static mesh component (previously the mesh component): 
  + Skinned mesh component – The skinned mesh component provides facilities to render skinned meshes. This component is required by all animation components.
  + Static mesh component – The static mesh component provides facilities to render static meshes only.
+ Audio components – The following components allow you to interact with the audio translation layer:
  + The trigger component executes triggers and plays and stops sounds.
  + The Rtpc component sets RTPCs and drives game variables to the audio system.
  + The switch component sets **SwitchStates** to vary behaviors in audio playback.
  + The environment component sets environment amounts to apply effects such as reverbs.
+ The character physics component provides a way to add physical behavior to an entity and configure simulation characteristics. Character physics is used with character entities such as a player and enemies.

For more information, see [Component Entity System](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-intro.html) and [Component Reference](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-components.html).

## System Entity Editor – Customize System Components<a name="lumberyard-v1.5-preview-system-entity-editor"></a>

Lumberyard Beta 1.5 introduces a new tool called System Entity Editor that allows you to customize your game project with system components. The System Entity Editor simplifies the process by allowing you to use the editor to modify low level settings, such as memory and file input or output, rather than requiring you to manually edit the `.xml` or `.cfg` files. For more information, see System Entity Editor.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/system_entity_editor.png)