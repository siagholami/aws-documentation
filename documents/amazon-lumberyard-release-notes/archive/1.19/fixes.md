# Fixes<a name="lumberyard-v1.19-fixes"></a>

Lumberyard Beta 1.19 resolves earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [PhysX](#physx-fixes-v1.19)
+ [Script Canvas](#script-canvas-fixes-v1.19)
+ [Miscellaneous](#miscellaneous-fixes-v1.19)

## PhysX<a name="physx-fixes-v1.19"></a>

The PhysX system has the following fixes:
+ The editor no longer stops working when you click the **Asset Editor** icon to add a PhysX material in the **PhysX Collider** component.
+ The **Asset Editor** now correctly shows the option to create a PhysX material.
+ The editor no longer stops working when you drag an FBX file that has a convex collision into the viewport.
+ The editor no longer stops working when you spawn an entity using PhysX nodes in the **Script Canvas** editor.
+ A static slice no longer automatically spawns when a dynamic **PhysX** component is spawned.
+ The editor no longer stops working when you add a second **PhysX Terrain** component to your level.
+ The editor no longer stops working if you add a **PhysX Terrain** component to a level that is 32 km x 32 km or larger.
+ The editor no longer crashes when you enter gameplay mode for the second time while the PhysX Visual Debugger is running.
+ The `PhysX::SystemRequestsBus` is no longer called from background threads.
+ Adding a **Mesh Collider** component to an entity no longer adds a static **Mesh** component to the entity.
+ The serializer no longer displays error messages when children of the `ShapeConfiguration` can't be read from disk.
+ In the **Entity Inspector**, the **PhysX Collider** component no longer appears out of focus when you change its properties.
+ You can no longer create PhysX materials with the same name in the **Asset Editor**.

## Script Canvas<a name="script-canvas-fixes-v1.19"></a>

Script Canvas has the following fixes:
+ Fixed an issue with the divide by zero error in **Division** mode.
+ Slots with default values now display the correct value type. You can now edit the values in the node.
+ Added general node splicing improvements.
+ Added a fix for infinite `BatchConversion`.
+ The error message for the unit test `OSAllocator` is corrected.
+ Node groups no longer enable edit mode on container nodes when you pause on them.
+ Added user feedback for bad data insert.
+ The `m_refCount` no longer stops working when running in debug mode.
+ Added `Get Name` to the sequence bus.
+ Exposed the category grouping.
+ Improved entry flow for container `Wizard Invalid Type`.
+ Fixed error messages for `Connection Reflection`.
+ Fixed an issue with the Script Canvas command-line widget.
+ Fixed an issue where deleted elements weren't properly removed from `Save Data`.
+ Variable references no longer disappear when you save your script.
+ Fixed an issue for unnecessary `EntityId` remapping and an issue when associative containers and slice pushing.
+ Improved the minimum panel size improvements.
+ Added sorted control to graph variables.
+ Added improvements to the interaction with node group frames.
+ Added improvements to the variable usage highlight and finding instances of elements in use.
+ Fixed an issue for `Bad Latent Execution Flow` warnings.
+ Fixed an issue for font settings not applying correctly when loading the graph.
+ Fixed an issue for multiple mouse button interactions.
+ Fixed an issue for the `ExtractProperty` and `ForEach` not working correctly with undo actions.

## Miscellaneous<a name="miscellaneous-fixes-v1.19"></a>

Lumberyard has the following miscellaneous fixes:
+ The `rinActor.mtl` no longer disappears when you drag a slice into a newly created level or load the Advanced\_RinLocomotion level.
+ The **Environment Probe** component now works correctly while you're running the game in the editor.