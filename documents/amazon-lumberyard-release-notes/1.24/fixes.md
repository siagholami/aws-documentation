# Fixes and API Deprecations<a name="lumberyard-v1.24-fixes"></a>

Lumberyard Beta 1\.24 resolves earlier customer issues, and updates supported versions for libraries, APIs, and tools\. Choose a topic area to learn more about the related fixes\.

## Bug Fixes<a name="fixes-v1.24"></a>

### Asset Bundler<a name="asset-bundler-fixes-v1.24"></a>
+ Fixed a bug where the **Auxiliary Content** packaging script wasn't properly packaging `gems.json`\. 
+ Fixed a bug where updates to the asset catalog from pak contents were not always processed in the correct order without using the FLAGS\_OVERRIDE\_PAK option when calling OpenPack\. 
+  The [https://docs.aws.amazon.com/lumberyard/latest/userguide/asset-bundler-missing-dependency-scanner.html](https://docs.aws.amazon.com/lumberyard/latest/userguide/asset-bundler-missing-dependency-scanner.html) no longer emits an error on complex regexes\. 
+ Fixed a bug where **Asset Bundler** would fail to create bundles while the **Asset Processor** was active\. 
+ Fixed a bug where comparison rules files could not be created using `AssetBundlerBatch.exe`\. 
+ Fixed mipmaps being incorrectly included as seed assets in seed files shipped with Lumberyard\. This should have no direct impact since it's adjusting for a change in how the **Asset Bundler** handles dependencies for textures and their mipmaps\. As a best practice, do not include mipmaps as seeds, because they are dependencies of the base texture\. As a result, mipmap count may change based on texture settings and platform\. 

### Asset Pipeline and Processor<a name="asset-pipeline-fixes-v1.24"></a>
+ Fixed an issue that would cause incomplete registration of **Builders** if a non\-**Builder** DLL was encountered\. 
+ Fixed an issue where chained `JobDependencyType::Order`s did not respect the ordering after the first dependency is encountered\. 
+ Fixed issue where the **Asset Processor** would allow an editor from a different project to connect without erroring, which could cause non\-obvious problems\. 
+ Fixed issue with metadata files \(like `.assetinfo`\) not triggering an asset to be reprocessed when changes are made while **Asset Processor** is not running 
+ Fixed issue with how **Asset Processor** handles deleted folders\.
+ Fixed issue with how **Asset Processor** handles of deleted or renamed folders while processing files in that folder\.
+ Fixed a crash bug in **Asset Browser** thumbnail drawing logic\.
+ Fixed an issue with the **Dynamic Content Gem** timing out on expired URLs during long downloads\.
+ Fixed an issue where the destination path was not updating when using **enablescm** with the **Asset Relocator**\.
+ Fixed an issue with the **natvis** file being included multiple times in a Visual Studio solution \(`.sln`\) file\.
+ Fixed a bug where the **Asset Processor** was writing to `AssetCatalog.xml` after each processed asset\. Now it only writes to this file when it goes idle\.

### Audio<a name="audio-fixes-v1.24"></a>
+ Fixed a crash in I/O when playing a looping sound that had streaming enabled in Wwise\.
+ The deprecated **Audio Controls Editor** DLL has been removed\.

### Cloud Canvas<a name="cloud-canvas-fixes-v1.24"></a>
+ Fixed issues related to to Mac and Dynamic Content tools for iOS development\. 
+ Fixed an issue where the Windows command\-line scripts \(\.cmd\) rely on the deprecated **AWSPythonSDK**\.

  **Note:**This may be a breaking change if you use `cleanup.cmd`\. 
+ Fixed an issue where importing a resource from an asset list results in an error\.

### Cloud Gem Framework<a name="cloud-gem-portal-v1.24"></a>

The Cloud Gem Framework gem has the following fixes:
+  Security improvements made to packages used in CloudGemPortal\. If your project uses Cloud Gems, update your project and any deployments to ensure that these critical fixes are applied\. 

### EBus<a name="ebus-fixes-v1.24"></a>
+ An assert has been added when an EBus with a non\-null mutex and at least one virtual functional call is destroyed without disconnecting\.

  **Note:** You will need to disconnect from any EBus that matches these conditions before destroying them\. This has always been true, but now you get an assert message if you haven't done so\.

### Editor<a name="editor-fixes-v1.24"></a>
+ Fixed a crash when trying to change the settings for a slice file that had not yet been processed by the **Asset Processor**\. 
+ Fixed issue where filtering audio parameter values by typing "\*" freezes the **Editor**\.
+ Fixed a rare crash during startup in **BootProfiler**\.
+ Fixed an issue caused by `EditorVisibilityRequestBus` functions not being deprecated properly\. The deprecated functions are now delegated to the `EditorEntityInfoRequestBus`\. 

### EMotionFX \(EMFX\)<a name="emfx-fixes-v1.24"></a>
+ Fixed a crash that could occur if an attached **Actor** is deleted before the parent\. 
+ Fixed a Lua script\-related warning in the **Rin **sample\. 
+ Fixed an issue where the `TopDownUpdate()` method could be called more than once in some cases because it internally recursed using the wrong method\. 
+ Fixed an issue where scrubbing through the recorder could output incorrect poses on the character for some frames\. 
+ Removed an old outliner window from the **Animation Editor** layouts\. This is used to trigger warnings in the log\. 
+ Removed the weight port in the **Simulated Object Animation Graph** node and replaced it with a Boolean state\. We determined that blending the results in and out did not play well with physics simulations\. 
+ Fixed an issue where in rare cases the motion extraction \(root motion\) could cause a character entity to teleport when switching between states\. 
+ Fixed an issue where copy and paste of the **BlendN** node and its source nodes set incorrect values when adding new connections\. The node's parameters are now correctly updated or cleared on paste\. 
+ Fixed an issue where deleting a large number of node groups may cause a crash\. 
+ Fixed a potential crash when deleting a parameter that is assigned to an action and saving the animation graph, then attempting to sign another parameter to the same action\. 
+ Fixed a potential crash in the **Editor** when deleting two actor instance while one of the instances has been modified\. 
+ Fixed a problem with the **Game Controller** window that might cause a crash\. 
+ Fixed a problem where a parameter group can be assigned to itself when selecting multiple parameters and groups together\. 
+ Improved some code with the animation graph model and animation graph editing\. Animation graph editing is more stable and reliable\. 
+ Fixed a potential crash when resetting an empty workspace\. 
+ Activating the graph from the reference graph will now correctly activate the parent graph\. 
+ Animation graph parameters will be cleared when clearing the selected animation graph file in the animation graph component\. 
+ Fixed some motion asset\-related issues for **StarterGame**\. 
+ The **Ragdoll Strength** and **Ragdoll** nodes will now show the correct bone names\. If only one joint is selected, the UI now shows the joint name instead of "1 joint is selected"\. 
+ Fixed an issue that occurred where saving an edited animation graph that references another graph can cause that other graph to disappear from the animation graph panel\. 
+ The contents of parameter pane will still be visible when multiple actor instances are selected\. 
+ Parameters and parameter groups no longer share the same name\. Old assets with a shared parameter and parameter group can still be loaded, but we recommend changing the name on at least one of the two\. 
+ Fixed some issues with parameter masks\. Now, a parameter mask won't be reset after you edit the parameter or edit the animation graph\. 
+ Fixed an issue where it's possible to create invalid connection through the **Undo** and **Redo** operations\. 
+ Fixed a crash that can happen when setting a child reference node to a graph with a parent reference node\. 
+ The first joint of simulated object can no longer be unpinned through a bulk edit operation\. Since the first joint will always be pinned, we also removed the pin option for the first joint of simulated object to avoid confusion\. 
+ **Undo** operations that remove transition conditions now re\-add the conditions in the correct order\. 
+ **Undo** operations that remove a tag/float parameter now restore the tags/parameter in a tag/parameter transition condition\. 
+ Fixed a potential crash that occurred when triggering state actions upon entering that state\. 
+ Fixed an exploding ragdoll bug that happened when the ragdoll root node was not the first node in the ragdoll configuration\. 
+ The **Activate Ragdoll** node now checks if the simulated mask contains the ragdoll root node and only applies motion extraction in that case\. 
+ Fixed a potential crash when removing motions after saving the modified motions\. 
+ Fixed a bug in the search filter of the animation graph parameter window\. 
+ Fixed hit detection/ragdoll and cloth colliders that were created with zero size due to the OBBs having a zero size\. 
+ Fixed a potential crash after recording an animation graph in the **Animation Editor** and then enabling **AI/Physics** mode in the **Editor**\. 
+ Fixed a bug in the animation graph asset builder related to reference animation graphs\. 
+ Fixed the alignment options in the animation graph window's context menu so they now work correctly\. 
+ Deleting an event track in the time view is now registered in the action history and can be undone\. 
+ The motion event preset file is now automatically checked out when saving it\. 

### Graphics<a name="graphics-fixes-v1.24"></a>
+ Fixed a crash when `e_shadowsCascadesDebug` was enabled on a device with GMEM enabled\. 
+ Fixed an issue where some textures were being evaluated incorrectly during loading and streaming\. 
+ Fixed an issue where some failures were not returning correctly in DX12\. 
+ Fixed an issue where some DirectX comparisons were incorrectly using binary comparison instead of Boolean\. 

### Mobile<a name="mobile-fixes-v1.24"></a>
+ Fixed Android and iOS so that textures exported with linear color space render properly\. 
+ Fixed an issue where a higher precedence operator was changing the result of comparisons\. 

### Physics<a name="physics-fixes-v1.24"></a>
+ Fixed an issue where physics configuration files do not load in release builds\. A symptom of the bug is that materials set in PhysX collider components will not be loaded in release builds\. 
+ Fixed an issue where objects with the PhysX Rigid Body component are affected by gravity when they are activated despite Start asleep option being enabled\. 
+ Fixed an issue where PhysX Scene Query nodes broke existing scripts\. 
+ Fixed an issue where the Debug Arrow is not seen if a force Region is attached to shape collider component\. 
+ Fixed an issue where the PhysX Collider Shape wouldn't update in the Editor Perspective\. 
+ Fixed an issue where the Capsule Shape can have a height set less than the radius of the Capsule Shape with no effect\. 
+ Fixed an issue where the height of Polygon Shape can be set to a negative value\. 
+ Fixed a crash when pressing \[Esc\] after changing and selecting a value in the Editor\. 
+ Fixed an issue in the Cloth component where changing Wind settings caused a visual glitch during camera movement\. 
+ Fixed an issue with PhysX Force Regions where linear damping with high values applied to entities caused them to erratically shift up and down and then rocket upwards at a high velocity\. 
+ Fixed a PhysX Collider issue where offset values were not correctly applied in the Lumberyard Editor\. 
+ Fixed a Linux Server issue where PhysX Gems enabled on Ubuntu 18\.04\.2 LTS caused an immediate shutdown\. 
+ Fixed an issue where performing an action after referencing the Compound Shape component to itself via the viewport results in hitting an assert\. 
+ Fixed an issue where Colliders don't use the correct scale in Game mode\. 
+ Fixed an issue from Lumberyard v1\.22 where a CryPhysics mesh does not respect scale\. 
+ Fixed an inconsistency in the Global Configuration values implementation\. 
+ Fixed an issue with PhysX Force Regions where very high density values for simple drag force caused an error\. 
+ Fixed an issue where building the NVIDIA Cloth gem with Visual Studio 2019 fails\. 
+ Fixed a crash observed when switching to a new level in the Samples Project\. 
+ Fixed an issue where AI/Physics button is broken with regards to previously defined Physics behaviors\.
+ Fixed an issue where an EBus custom connection policy passed invalid arguments to ConnectionPolicy::Disconnect\(\)
+ Fixed an issue where the PhysXSamples Quadcopter body/collider was not in sync with render mesh\. 
+ Fixed an issue where the PhysX Gem SystemComponent didn't update a default material library asset reference if it was reloaded\. 
+ Added an assert on the destruction of the PhysXColliderComponent in the Editor and MeshColliderComponent in\-game\. 
+ Fixed an issue where calling EditContext::UIElement with the UIHandlers::CheckBox type didn't actually display a checkbox in the editor\. 
+ Fixed a crash that occurs when creating a new level from an already open level\. 
+ Fixed the rigid body pose transform so it updates correctly if the associated entity is moved when physics is disabled and then re\-enabled\. 
+ Fixed Script Canvas PhysX Scene queries so they do not show warnings with an empty collision group\. 
+ Fixed an issue where PhysX Scene Query nodes break existing scripts\. 
+ Fixed an issue where a Physics Material property is not correctly exported to Release configuration\. 
+ Fixed an issue where objects with the PhysX Rigid Body component are affected by gravity when they are activated despite the "Start asleep" option being enabled\.
+ Fixed an issue where PVD is not disabled in release build\.

### Script Canvas<a name="script-canvas-fixes-v1.24"></a>
+ **Tag Component** `AddTags` now properly applies tags\.
+ Closing the **Editor** no longer displays an assert error\.
+ Newly created **Script Events** in the **Asset Editor** with one or more events no longer throws errors in the **Console** when saving\.
+ The **Lua Editor** no longer freezes when replacing all text with the wrap option enabled\.
+ Added validation to prevent multiple **Script Events** with the same name, which previously caused the **Script Event** method to be performed twice\.
+ Fixed behavior when saving **Script Canvas** bookmarks that contain numbers\.
+ Fixed issue where **Script Canvas** nodes would become corrupted after performing **Undo** and **Redo** actions of showing and hiding unused node slots using keyboard shortcuts\.
+ Saving a script canvas with a node with an extended text field now maintains the text field size\.
+ **Script Event** return values are properly handled\.
+ If you are zoomed out, when double\-clicking on an error/warning, the **Canvas View** will no longer zoom in\.
+ Fixed node coupling when using an **EBus** node\.
+ Fixed behavior when comparing floating point values\.
+ Removed the **Color Negate** node\.
+ Fixed the behavior of the right\-click **Edit Script Canvas** menu\.

### Slices<a name="slices-fixes-v1.24"></a>
+ Changed the way the **Select slice root >** option works to prevent very deeply nested slices from filling the screen\. The right\-click option has been reworked to match **Entity Outliner** navigation with the arrow keys: 
  + **Ctrl\+Up** selects the first slice root above the selection in the list\. 
  + **Ctrl\+Down** selects the first root below the selection\.

   The controls are now relative to the list rather than the hierarchy\.
+ When making changes to an existing slices, saving will no longer reorder the associated IDs\.
+ When saving slices, a warning is no longer displayed in the **Console** about `SetRotation` being deprecated\.

### Waf Build System<a name="waf-fixes-v1.24"></a>
+ Fixed an issue with Visual Studio 16\.6\.0 where some projects would fail to build\.
+ Fixed an issue where user modules that are not explicitly included in the spec were not added to generated Android Studio projects\.
+ Fixed an issue when generating a debug dedicated build when the **Scene Logging Example** gem is enabled\.
+ Fixed an issue when generating a build without precompiled headers\.

### UI \(LyShine\)<a name="ui-fixes-v1.24"></a>
+ Fixed a bug allowing dynamic scroll boxes to reference themselves causing infinite spawning\. 
+ Fixed a bug where elements destroying themselves caused a crash\.
+ Fixed crash when using `nullptrs` with **UI Anchors**, **UI Offsets**, or **UI Padding** nodes\.

## Deprecated APIs<a name="api-deprecations-v1.24"></a>

The following APIs have been deprecated in Lumberyard Beta v1\.24:
+ **The following APIs are deprecated in `PhysX::ColliderComponentRequestBus`:**
  + `GetShapeConfigFromEntity()`: Use `GetShapeConfigurations()` instead\. This method returns a vector that contains a `{ColliderConfiguration, ShapeConfiguration}` pair for each shape\.
  + `GetColliderConfig()`: Use `GetShapeConfigurations()` instead\. This method returns a vector   
  

    that contains a `{ColliderConfiguration, ShapeConfiguration}` pair for each shape\.
  + `GetShape()`: Use `GetShapes()` instead\. This method returns a vector of `Shape` pointers\.
  + `GetNativePointer()`: Use `GetShapes()` instead\. This method returns a vector of `Shape` pointers which can be iterated through, and `GetNativePointer()` can be called on each `Shape`\.
+ **The following APIs in `I3DEngine::Terrain` have been deprecated**:

  ```
  virtual float GetTerrainElevation(float x, float y, int nSID = DEFAULT_SID) = 0;
  virtual float GetTerrainZ(int x, int y) = 0;
  virtual float GetTerrainSlope(int x, int y) = 0;
  virtual int GetTerrainSurfaceId(int x, int y) = 0;
  virtual bool GetTerrainHole(int x, int y) = 0;
  virtual Vec3 GetTerrainSurfaceNormal(Vec3 vPos) = 0;
  virtual int GetHeightMapUnitSize() = 0;
  virtual int GetTerrainSize() = 0;
  virtual int GetTerrainSectorSize() = 0;
  virtual bool IsTerrainActive() = 0;
  ```

  All terrain\-related API services are now available via `AzFramework::Terrain::TerrainDataRequestBus`\.
+ **The following APIs from `ColliderComponentRequestBus` have been deprecated:**
  + `IsStaticRigidBody()`
  + `GetStaticRigidBody()`

  Please use the new runtime component `StaticRigidBodyComponent` instead\.
+ **The following `PhysX::SystemRequests` APIs are deprecated:**
  + `PhysX::SystemRequests::CookTriangleMeshToMemory()`
  + `PhysX::SystemRequests::CookTriangleMeshToFile()`
  + `PhysX::SystemRequests::CookConvexMeshToMemory()`
  + `PhysX::SystemRequests::CookConvexMeshToFile()`

  They are moved to the PhysX::SystemRequestsBus class:
  + `PhysX::SystemRequestsBus::CookTriangleMeshToMemory()`
  + `PhysX::SystemRequestsBus::CookTriangleMeshToFile()`
  + `PhysX::SystemRequestsBus::CookConvexMeshToMemory()`
  + `PhysX::SystemRequestsBus::CookConvexMeshToFile()`
+ **The following APIs in the `RayCastWorldSpace` class \(defined in `WorldNodes.h`\) have been deprecated:**

  ```
  RayCastLocalSpace()
  RayCastMultipleLocalSpace()
  OverlapSphere()
  OverlapBox()
  OverlapCapsule()
  OverlapQuery()
  ShapecastQuery()
  SphereCast()
  BoxCast()
  CapsuleCast()
  ```
+ **The following macros for legacy compilers have been deprecated**:

  ```
  AZ_STATIC_ASSERT
  AZSTD_STATIC_ASSERT_BOOL_CAST
  AZ_HAS_NULLPTR_T
  AZSTD_UNDERLAYING_TYPE
  AZ_HAS_INITIALIZERS_LIST
  AZ_HAS_TEMPLATE_ALIAS
  AZ_DELETE_METHOD = delete
  AZ_DEFAULT_METHOD = default
  AZ_RESTRICT __restrict
  AZ_FUNCTORALLOCATOR_CONSTEXPR constexpr
  ```
+ **Other API changes:**
  + The following APIs will be changed to use `AZ::EntityId` instead of `AZ::Entity*` in a future release:
    + `EditorEntityContextRequests::CreateEditorEntity()` 
    + `EditorEntityContextRequests::CreateEditorEntityWithId()`
    + `EntityCompositionRequests::AddExistingComponentsToEntity()`

     Since you can't overload a method by return type only, we have created companion methods that you can use and avoid a breaking change:
    + `EditorEntityContextRequests::CreateNewEditorEntity()`
    + `EditorEntityContextRequests::CreateNewEditorEntityWithId()`
    + `EntityCompositionRequests::AddExistingComponentsToEntityById()`

    These methods perform the same actions, only they return an `AZ::EntityId` instead of an `AZ::Entity*`\. 
  + Due to changes to how **Layers** impact the visibility of **Editor Entities** in the Viewport, calling `GetCurrentVisibility()` or `SetCurrentVisibility()` will often lead to contradictory results\. As a result, we are deprecating them\.

    Instead, call `EditorEntityInfoRequests::IsVisible()` to check entity visibility\. To set entity visibility, call `EditorEntityHelpers::SetEntityVisibility()`\. You can also listen for `EditorEntityVisibilityNotifications::OnEntityVisibilityChanged` and track the state internally\.