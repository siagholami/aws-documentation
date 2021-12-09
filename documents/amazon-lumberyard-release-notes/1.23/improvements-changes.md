# Amazon Lumberyard Release Notes: Improvements and Changes in Beta 1.23 (February 2020)

Lumberyard Beta 1.23 provides improvements and changes to Lumberyard systems and functionality.

## Asset Management (Slices)

We've made some changes to the Slice asset file format and created a Slice Upgrade Pipeline that, once enabled, allows the Asset Processor to automatically convert your slices to the new format. This new slice file format allows for more granular management of the component assets in the slice.

Looking to try out the new slice file format? Read on!

**How do I use the Slice Upgrade Pipeline?**

1. Make sure that the source slice file is set as writable on your local file system.

   (If you're using git, you can ignore this step.) If you're using Perforce, recursively check out all the slice files that you want to upgrade by running the following Perforce command:

```
  p4 edit ...\*.slice
```

  * If you have read-only slices not tracked by Perforce, you need to change them to read-write manually.

2. Enable Deep Slice Resaving in the Slice Builder settings file. The settings file is SliceBuilderSettings.json. It's located in your installation root's /dev directory. Open the file and change the setting EnableSliceConversion to . By default, this option is disabled.

3. If you have already run the v1.23 asset processor prior to making this change, restart the Asset Processor application. This triggers a full rescan of assets from the Asset Processor's Tools tab.

**When do I use the Slice Upgrade Pipeline?**

Use it when:

+ Adding a slice that was saved using an older version of the slice file format.

+ Installing a new version or build of Lumberyard that makes changes to the slice file format.

+ The Asset Processor logs indicate that your project has slices that require an upgrade. If so, the log displays a warning similar to the following:

 ```
 This slice file is out of date: {slice-file-path-here}
                            
 To enable automatic upgrades:
                            
 In the settings file SliceBuilderSettings.json, Set EnableSliceConversion to true and restart the Asset Processor
 ```

**Note**
This pipeline is not currently intended to update your slices when changing your component serialization. To get that update, use the Resave All Slices command in the Lumberyard Editor File menu.

Read more about how the [new slice format works](https://docs.aws.amazon.com/lumberyard/latest/userguide/dynamic-slices-overview-anatomy.html), how to [use the new format for slice component versioning](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-system-versioning.html), and [how to upgrade your project to use it](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-slice-upgrade-process.html).

## Editor

+ Lumberyard is now using Qt 5.12! This includes tons of fixes and improvements to general UI functionality and performance throughout the Editor.

## EMFX (Animation)

We've updated EMFX with the following improvements:

+ **General Optimizations**: Performed several optimizations inside the EMotion FX runtime as part of an ongoing effort to improve performance.

  As part of this effort, we no longer use EMotion FX's internal quaternion. We now use the public AZ::Quaternion type, which uses CPU SIMD instructions for acceleration. This means that some of your animation code may also require changes, because it will be working with AZ::Quaternion now for rotations instead of the internal quaternion type and algorithms.

  We also made optimizations to the Pose class and in the animation graph system itself. You do not need to change your code to see these performance benefits.

+ **Skeleton Optimization**: We have added a new FBX settings modifier for Actors, which looks at the skinning information of your mesh data and determines the minimum set of joints that should be enabled to skin the character correctly. This means that if you skin lower level of detail (LOD) levels to less joints (for example, without finger joints), it automatically generates skeleton LOD levels where those joints are disabled. Note that with the modifier on you can still select a list of critical joints, which is always enabled. The modifier also allows joints to be removed automatically for server skeletons. It looks at which joints have hit colliders attached to them, and based on that it will determine the minimum set of required joints. This allows you to quickly generate optimized server assets with highly reduced joint counts. Just like the actor LODs, the auto server skeleton also includes the joints that are in the critical bone list.

At the moment, make sure your animation graphs do not reference joints that get disabled by skeleton LOD.


## Mobile (Graphics)

We improved runtime game performance on mobile devices by changing texture compression to ASTC and reducing the GBuffer size.

+ ASTC texture compression reduces the bits-per-pixel GBuffer usage, and lowers hardware temperatures on mobile devices while improving frame rates. It does this by reducing the required amount of memory bandwidth for loading and decompressing. The GBuffer optimization, with reduced bits-per-pixel usage, also reduces the required memory bandwidth across multiple stages of the rendering pipeline. This also helps with the hardware temperature and frame rate issues.

## Physics

We've got a lot of good stuff for the folks who work with game physics in this release:

### Experimental Release of the NVIDIA Cloth Gem:

 This new Gem allows designers and artists to quickly and easily create, customize, and iterate on cloth simulations. With the NVIDIA Cloth Gem you will be able to add cloth simulation to your characters and environments. Read more about it in the [Amazon Lumberyard docs](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-slice-upgrade-process.html).

+ **Note**: Supported Platforms: PC only. Other platforms untested. No mobile controls have been set up.

**PhysXSamples Gem**: The PhysXSamples Gem houses a collection of sample slices and scripts ranging from introductory feature examples to a fully animated third-person character controller. The purpose of this gem is to become a library of samples for features commonly used in game projects.

Slices in the Gem include:

+ PhysX rigid body slices for box and sphere with one meter unit scale for convenience.

+ RayShapeCollide. This simple slice, when dropped into a level, has interactive samples and scripts that demo all the ways you can "reach out and touch" the world with PhysX. Scripts include:

+ How to use Raycast and Multi-Raycast

+ Shape Cast examples for Sphere, Box, and Capsule

+ How to use OnCollision events

+ How to use OnTrigger enter and exit events

+ FlyController&Camera. This slice includes a simple flying controller and camera slices that users can drop into a level, and which adds the ability to freely fly around the level at run-time. It uses a simple kinematic rigid body and sets an entity's world translation for free movement.

+ Sphere Controllers. Two variations on this slice are included: A simple impulse driven sphere controller, and slightly more complex articulated SphereBot controller. (Welcome back, R0-B robot from Samples Project!). Both slices don't have a camera by default, but can be combined with the Simple_Follow camera rig slice for a third-person experience. Alternatively, users are free to create their own camera rigs and attach them to the slice examples.

+ Quadcopter. This slice uses impulse force powered by the new Post Physics handler to fly around and stabilize hovering. Additional scripts include camera rig behaviors customized for flying and scripts that change the propeller rotation speed based on velocity. This slice can also be combined with the weapon projectile slice which fires rigid body spheres and the rotor wash slice that uses a force volume to interact with rigid bodies in the world. (Recommended that Continuous Collision Detection is turned on in the global physics configuration settings.)

+ Cowboy and Revolver. It's our long-suffering friend and Actor, The Cowboy! Is he doomed to star only in samples? Maybe you can give him purpose as you experiment with these detailed slices. Here, they use the PhysX character controller and actor components together with animation tools and script canvas to drive some gameplay mechanics. The controller in this slice supports both root motion and direct motion for character entity movement. We've also included a customized third-person camera rig and behaviors that use the character speed to dynamically dolly the camera in and out, and also change the camera field of view. While the default character pose assumes a weapon is always in hand, the Revolver gun slice is optional and opens up the possibilities for weapons to be dynamically attached and detached. Unlike the rigid body weapon, the revolver uses ray casts for shooting (hit scanning) and interpolates a tracer round to the target. The Cowboy is ready to take on Lumberyard!


Enable the PhysXSamples Gem in ProjectConfigurator to make the samples available in the game and editor.

+ **Note**: Supported Platforms: PC only. Other platforms untested. No mobile controls have been setup.

### DevTextures Gem

The DevTextures gem is collection of textures used for development and debugging. It includes a variety of grid texture types such as a middle grey checker, UV debugging grids, along with simple shapes like dot and ring.

The purpose of this gem is to become a library for texture assets that are commonly used in projects. Enable the PhysXSamples Gem in ProjectConfigurator to make the samples available in the game and editor.


### Expose get and set operations for collision layers and groups for rigid bodies and characters to Script Canvas

We've added Script Canvas nodes to get, set, and toggle collision layers, collision groups, and also get and set their names. These new nodes enable easy modifications to collision layers and groups using Script Canvas.

Here are the details about each of these new nodes:

**Toggle a collision layer on or off inside the collision group on an entity**

This new node modifies the collision group on a collider. It enables or disables a specific layer inside the collision group on a collider. It only affects the collision group for that particular collider instance, by performing a lookup (based on layer name) into the PhysX configuration window and retrieving the layer. If the layer name cannot be found, the node takes no action and the layer remains unchanged on the collider.

Use the collider tag to target a specific collider when there are multiple colliders on the entity. Only the colliders that have a matching collider tag areupdated. If the collider tag field is left empty, all colliders in the layer are enabled or disabled.

|Pin Name |Type |Description    |
|----------------|--------------------|----------------------------------------|
|Source	         |EntityId	          |The source entity ID to query           |
|Layer Name	     |string	          |The name of the collision layer to toggle  |
|Collider Tag	 |AZCrc32	          |Used to target a specific collider     |
|Enabled	     |boolean	          |Check to enable a layer, leave unchecked to disable a layer |

**Set a collision layer on the collider**

This node performs a lookup into the PhysX configuration window to retrieve the layer using the provided layer name. If the layer name cannot be found, the node takes no action and the layer remains unchanged on the collider. If the layer name is invalid, the following error is displayed in the console:

```
[Warning] (CollisionLayers) - Could not find collision layer: {name-of-layer-here}. Does it exist in the configuration window?
```

Use the collider tag to target a specific collider when there are multiple colliders defined on the entity. Only the colliders that match the supplied collider tag string value will be updated. If it is left empty, all colliders are updated.

|Pin Name |Type |Description    |
|----------------|--------------------|----------------------------------------|
|Source	         |EntityId	          |The source entity ID to query           |
|Layer Name	     |string	          |The name of the collision layer to set  |
|Collider Tag	 |AZCrc32	          |Used to target a specific collider      |

**Set a collision group on a collider**.

This node performs a lookup into the PhysX configuration window to retrieve the group, using the provided group name. If the group name can not be found, the node takes no action and the groupremains unchanged on the collider, and the following error message is displayed in the console:

```
[Warning] (CollisionLayers) - Could not find collision layer: {name-of-layer-here}. Does it exist in the configuration window?
```

Use the collider tag to target a specific collider when there are multiple colliders on the entity. Only the colliders that match the supplied collider tag string value will be updated. If it is left empty, all colliders are updated.


|Pin Name |Type |Description    |
|----------------|--------------------|----------------------------------------|
|Source	         |EntityId	          |The source entity ID to query           |
|Group Name	     |string	          |The name of the collision group to set  |
|Collider Tag	 |AZCrc32	          |Used to target a specific collider      |


You can retrieve Collision Layer and Collision Group names by passing an EntityId value to the new GetCollisionLayerName and GetCollisionGroupName nodes. In both cases, the output is a string that contains the collision layer or collision group names, respectively.

### Tooltips

+ We've added a Tooltip for Ragdoll Component displays iteration counts. This change informs the user that a higher iteration count improves fidelity at the cost of performance.


## UI (LyShine)

+ You can simulate a press and release navigation event in your scripts using **ForceEnterInputEventOnInteractable** on the **UiCanvasBus**. This is useful for automated testing, such as simulating a button click.

## Support (Libraries)

+ Upgraded the Qt library to version 5.12.4.0 (from version 5.6.2.7). This upgrade includes more than two years of bug fixes and new features in the Qt libraries. Refer to [the Qt 5.12 release notes](https://doc.qt.io/qt-5/whatsnew512.html) for more information.

+ You can now build for Android in Visual Studio 2017. This requires the “Mobile Development with C++” workload from the Visual Studio Installer in order to load Android projects within Visual Studio.

## Systems

+ The cvar `SaveLevelStats`, which outputs a .CSV file with level data, has been improved to display the correct values for memory usage.
