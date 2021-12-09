# Fixes<a name="lumberyard-v1.21-fixes"></a>

Lumberyard Beta 1.21, 1.21.1, and 1.21.2.0 resolve earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [Asset Editor](#asset-editor-fixes-v1.21)
+ [Asset Pipeline](#asset-pipeline-fixes-v1.21)
+ [Cloud Canvas](#cloud-canvas-fixes-v1.21)
+ [Perforce Integration](#perforce-integration-fixes-v1.21)
+ [PhysX](#physx-fixes-v1.21)
+ [Script Canvas](#script-canvas-fixes-v1.21)
+ [Systems](#system-fixes-v1.21)
+ [Terrain](#terrain-fixes-v1.21)
+ [UI Editor](#UI-editor-fixes-v1.21)

## Asset Editor<a name="asset-editor-fixes-v1.21"></a>

Asset Editor has the following fixes:
+ When you open the **Asset Editor** and expand a material library, your materials now correctly appear with indents.
+ When you modify a parent entity, then undo the changes, those changes now revert correctly. 

## Asset Pipeline<a name="asset-pipeline-fixes-v1.21"></a>

Asset Pipeline has the following fixes:
+ Fixed an issue where a particular sequence of events with slices resulted in Asset Processor failing to reprocess the slice.
+ Fixed an issue where Asset Processor didn't correctly shut down, resulting in increased memory usage when Asset Processor was idle.

## Cloud Canvas<a name="cloud-canvas-fixes-v1.21"></a>

Cloud Canvas has the following fixes:
+ Fixed an issue that prevented users from creating backups of deployments that had Amazon S3 buckets in the US East (N. Virginia) Region.
+ Fixed a crash that occurred when launching an Android app compiled with NDK19 and the CloudGemTextToSpeech gem.
+ Fixed an issue where the login window didn't appear in the CloudGemSamples PlayerAccountSample level when the login token expired.
+ Fixed an issue in macOS, where the CloudGemSamples launcher stopped working when you tried to use the CloudGemWebCommunicator. This occurred when the AWS IoT client failed to subscribe to an invalid topic, which led to multiple SSL read errors.
+ Fixed an issue where the CloudGemWebCommunicator failed to read the certificate storage on iOS devices. This caused MQTT 703 responses.
+ Fixed an issue where the CloudCanvasCommon gem couldn't resolve the root path for root certificates. This led to the `NETWORK_SSL_ROOT_CRT_PARSE_ERROR` in the MQTTClient that is part of the CloudGemWebCommunicator sample.
+ Fixed an issue in the CloudGemAWSScriptBehaviors gem where responses weren't sent on the main thread. This led to missed notifications and logic errors in the Lua script.

## Perforce Integration <a name="perforce-integration-fixes-v1.21"></a>

Perforce no longer initializes by default in the Lumberyard Editor Perforce plugin. To initialize Perforce, set the address of the Perforce server in a P4PORT environment variable, using P4 SET P4PORT, or in a P4CONFIG file.

## PhysX<a name="physx-fixes-v1.21"></a>

The PhysX system has the following fixes:
+ Script Canvas now receives trigger events for PhysX entities.
+ The **PhysX Terrain** component now automatically saves when you make changes to the component.
+ In the **Animation Editor**, the **Collider Configuration** panel now correctly appears and is no longer hidden.
+ The **Editor Terrain** component now correctly handles changes to the terrain using the **Layer Painter** tool.
+ You can now assign different PhysX materials to different layers on the terrain using the **Terrain Texture Layers** tool. Your changes now correctly appear in gameplay mode. 
+ The `terrain.pxheightfield` file now saves to the correct directory when the level that uses this file is in a subdirectory.
+ For the **PhysX Rigid Body Physics** component, when you enter a value above `10` for the **Initial Angular Velocity** property, this change now correctly affects the velocity of the entity.
+ In the **Script Canvas** editor, rigid bodies no longer have a limit on the rotation speed when you use the **Apply Angular Impulse** node.
+ When you load a level in Lumberyard Editor, the EBus `PhysX::SystemRequestsBus` is no longer called from background threads.
+ A warning message now appears in the **Entity Inspector** if you add a legacy **Force Volume** component and **PhysX Collider** component to the same entity. These entities are incompatible because they use different physics systems.
+ For the **PhysX Terrain component**, the **Heightfield asset** property now correctly displays the name of the current terrain when you add the component to an entity in a new level. The `[Warning] (PhysXUtils::CreateTerrain) – Heightfield asset not ready` message no longer appears in the console.
+ For the **PhysX Rigid Body Physics** component, the **Debug Draw COM** property no longer includes trigger shapes. The center of mass now correctly appears at the center of the collider.
+ For the **PhysX Collider** component, some compile errors no longer appear. These errors didn't affect the functionality or behavior of the component.
+ The Linux dedicated server launcher no longer stops working at runtime if there are missing libraries. The Linux dedicated server now correctly finds the shared libraries.

## Script Canvas<a name="script-canvas-fixes-v1.21"></a>

Script Canvas has the following fixes:
+ The **Indexer** node is deprecated due to incomplete implementation. To achieve a single output when a series of inputs is triggered, use the **Any** node.
+ The **Sequencer** node is split into two nodes:
  + To trigger a specific output thread in response to a numeric value, use the **Switch** node.
  + To trigger the output slots in a specific order, use the **Ordered Sequencer** node.
+ Backward compatibility and conversion code related to the original variable implementation from Lumberyard version 1.14 is removed. Script Canvas graphs that rely on this code will now break. To work around this, update on a previous revision and port to the newest release of Lumberyard.

## Systems<a name="system-fixes-v1.21"></a>

Issues were fixed that would cause the recent streaming updates to soft lock in rare situations.

## Terrain<a name="terrain-fixes-v1.21"></a>

The terrain system has the following fixes:
+ Lumberyard Editor no longer stops working when you clear hidden static vegetation instances.
+ The Editor Camera can now fly through areas where the terrain is missing (for example, holes or past the terrain boundaries) even when the **Terrain Camera Collision** is enabled in the editor.
+ When you import terrain splat maps, if there are areas where all the splat maps are black, the terrain will now draw detail layers at that point instead of the highest-priority layer.
+ The editor no longer stops working if you refine terrain texture tiles multiple times and then change the resolution of a single tile.
+ Terrain layer painter masks no longer cause colors or details to bleed outside of the masks when painting or flood filling.
+ Terrain layer coloring can produce visible seams and other artifacts when painting, importing textures, exporting to engine, and so on. For more information, see the [Terrain](lumberyard-v1.21-improvements-changes.md#lumberyard-v1.21-improvements-changes-terrain) improvements and changes.
+ The `cover.ctc` can't be written after you choose **Generate Terrain Texture** or **Game**, **Export to Engine**.
+ Lumberyard Editor no longer hangs when you resize the terrain multiple times.

## UI Editor<a name="UI-editor-fixes-v1.21"></a>

The **UI Editor** has the following fixes:
+ Various fixes for the ScriptedEntityTweener gem, including a fix that prevents the Tweener from deactivating and reactivating elements.
+ Fixed UI dynamic slices from being parented to the wrong element. This can occur when multiple spawners are spawning the same slice.
