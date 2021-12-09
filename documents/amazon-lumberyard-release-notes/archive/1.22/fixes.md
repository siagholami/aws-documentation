# Amazon Lumberyard Release Notes: Fixes for 1.22 (December 2019)

Lumberyard Beta 1.22 resolves earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [Asset Pipeline](#pipeline-fixes-v1.22)
+ [Build](#build-fixes-v1.22)
+ [Dynamic Vegetation](#vegetation-fixes-v1.22)
+ [Editor](#editor-fixes-v1.22)
+ [Graphics](#graphics-fixes-v1.22)
+ [Script Canvas](#scriptcanvas-fixes-v1.22)
+ [Miscellaneous](#misc-fixes-v1.22)

## Asset Pipeline<a name="pipeline-fixes-v1.22"></a>
+ Fixed a race condition in TestAssetBuilder where clean builds sometimes (not always) failed on some (not all) test assets. 
+ Fixed an issue in TestAssetBuilder where assets were failing to process if a subfolder was renamed while the Asset Processor was running.

## Dynamic Vegetation<a name="vegetation-fixes-v1.22"></a>

+ Fixed "Show Per Instance Visualization" not functioning properly on Vegetation Debugger Component.

## Build<a name="build-fixes-v1.22"></a>
+ Fixed an issue where modifying the ADDITIONAL_COPYRIGHT_TABLE in WAF would not update the copyright information and could make the build fail.

## Editor<a name="editor-fixes-v1.22"></a>
+ Entities will not respect the lock/unlock status of their parent layers if a grandparant layers' lock/unlock state changes.

+ Fixed a crash that occured when dragging a slice from the slice favorite menu onto an instance of itself.

+ Fixed a crash that occured when deleting a folder from the slice favorites menu.

+ Fixed a crash that occured when attempting to save the deletion of an entity to a slice from the Save Slice Overrides (Advanced)... menu

+ Fixed a crash that occured when duplicating entities many times.

+ Fixed an editor crash that occured after changing Perforce settings.

+ Fixed a bug that caused the editor to freeze when selecting two entities with an Actor component and setting the target entity to the second entity.

+ Fixed a crash that occured when duplicating an entity after editing a component property while the component property field is still active.

+ Fixed a crash that occured when a component property is changed and game mode is immediately launched.

+ Fixed a crash that occured when returning from game mode as dynamic slices are being cleaned up.

+ Fixed a crash that occured after entering game mode before P4V finishes updating a modified asset.

+ Improved the performance of undo operations for entity manipulation. Translating 25 entities and pressing undo used to take ~15 seconds and now takes ~4.5 seconds.

+ Fixed a performance issue that caused the editor to lag every time a slice was selected in the Entity Outliner. Selection of a 10k slice entity hierarchy used to take ~3 seconds and now takes ~200ms. 

+ Selecting entities is now faster. Selection/deselection of all entities in a 20k level was 374 seconds and is now less than 10 (53x faster).

+ Entering Game Mode while an Entity Outliner filter is active is now faster. Entering Game Mode in a level with 20K entities while a filter is applied in the Entity Outliner used to take 5m 48s, and now takes 3.18s.

+ Fixed a bug that caused an slice entity to deparent from a layer after revert overrides is used.

+ It is now possible to scale entities with a Look At component.

+ The slice favorites editor now has an option to import a slice from a right click menu.

![Import Slice](/coming-release/media/LY_Import%20Slice.gif)

+ The slice favorites gem is now enabled by default.

+ Exposed a new option in the Editor Settings called "Slice file location" which allows a user to change the default location that slices are saved.

+ Fixed a bug that caused an entity to become invisible after dragging an asset to the entity from the Asset Browser and then pressing undo.

+ Fixed a bug that occurred when searching for a component and clicking in the entity inspector that led to an unintended text field to appear.

+ Creating a child entity of a layer will now properly add the entity relative to the camera and terrain rather than placing the entity at 0,0,0.

+  Fixed a bug that caused the entity inspector to open the Add Component menu, rather than the new level dialog, when no entity was selected.

+  Fixed a bug that caused the entity inspector to scroll to the bottom of the component list after clearing an asset reference field.

+  Fixed a bug that was causing some components to display the number of components already on the entity in the Add Component menu.

+  Fixed a bug that caused the Align object to surface option from not being able to be disabled if enabled, then immediately disabled.

+  Fixed a bug that prevented the “move component to top” option in the entity inspector from working when an entity contained more than 31 components.

+  Made it so the list of overrides doesn’t display an override count if there is only 1 override to save in the save slice overrides menu.

+  Now displays “no results found” if a search result in the entity outliner doesn’t return an entity.

+  Users can now interact with asset reference property fields. You can click in a field, change the reference text, and see a list of assets that match the string and asset type appropriate for the field.

![LY_asset_reference_property_fields](/coming-release/media/LY_asset_reference_property_fields.gif)

+  Removed an invalid console warning that occurred when saving a layer after the first time the layer is saved.

+ Removed the dialog telling customers that LY is already running if the customer tries to launch a second instance of the editor.

+  Pasting a second environment probe on an entity no longer crashes the editor.

+  Fixed a bug that caused locked layers to not lock entity selection in the viewport after returning from game mode.

+  Entering rename mode but not renaming a layer no longer marks the layer as dirty.

+  There is now a “find layer in Asset Browser” option from a layer in the Entity Outliner.


![LY_Find_Layer](/coming-release/media/LY_Find_Layer.gif)


+  Fixed a bug that caused the editing of some properties in a pinned entity inspector to not update the unselected entity the pinned panel was pinned from.

+  Fixed a bug that caused a level to perform as though changes had occurred if the level was immediately closed after opening it.

+  Fixed a bug that resulted in a new component being created if an asset was dragged from the Asset Browser directly to a component asset reference field.

+  Added a warning when attempting to save a layer with the same name as a layer that already exists in the levels layer folder, but does not exist in the level.

+  Fixed a bug that resulted in a crash when you removed an asset reference from a component and tried to save the asset.

+  Fixed a bug that failed to set the “Save as binary” property correctly after using the Recover layer option.

+  Fixed an issue displaying slice overrides in the outliner after unsuccessful slice push operations.

## Graphics<a name="graphics-fixes-v1.22"></a>
+  Fixed a bug where particles with diffuse backlighting were drawn incorrectly due to an error in the vertex normal calculation.


## Script Canvas<a name="scriptcanvas-fixes-v1.22"></a>	

+ Fixed editor crash after saving the automatically generated graph.

+ Fixed editor crash when performing Shake to Desplice on a wildcard node with its string input parameter overridden.	

+ Fixed undo changing the amount of inputs of the Repeater node. 	

+ Fixed editor crash when collapsing a Group node created recently via Group Current Selection button while other nodes are present on the canvas. 	

+ Fixed editor crash when trying to use Script Events method that was deleted.	

+ Fixed crash upon undoing a collapse of a Group node freshly created via the Group Current Selection button. 	

+ Fixed collapsing and deleting an empty Group node created via Group Current Selection crashes the Editor.	

+ Fixed editor crash when saving or discarding a script with a group/comment created with the toolbar buttons. 

## Miscellaneous<a name="misc-fixes-v1.22"></a>

+ Workspaces saved before January 2018 that had a pre-activated animation graph will not automatically activate the anim graph with the latest version. Activate and re-save the workspace to correct.

+ Prior to release 1.22, transitions blended their playspeeds based on the current weight of the transition whether the sync was enabled or disabled.  In release 1.22, when syncing is disabled, the non-synced transitions now keep the source playspeed, which is the playspeed from the state it originated from until reaching the target state. The playspeed of the parent state machine will switch from the source playspeed to target state playspeed as soon as the transition is done.  When syncing is enabled, the transitions blend their playspeeds based on the current weight of the transition.

+ Starting with version 1.22, range based motion events will trigger event starts only when the time crosses the event start and land inside the range based event. In previous versions this range based motion event scenario would trigger event starts AND active events.

+ Fixed a bug that resulted in a crash due to a race condition in the streaming engine.

+ Fixed a bug that resulted in a crash when a dedicated server using the CloudGemFramework failed to assume a server identity.

+ Fixed an issue where TrackView timelines did not draw time scale text.

+ Added functionality to the MultiplayerSample to copy and install a missing root certificate for use on GameLift Linux servers.

+ Fixed a bug where some cvars declared with DeclareConstIntCVar were uninitialized value in release builds. <a href="https://github.com/aws/lumberyard/pull/421" target="blank">Pull request 421</a>

+ Fixed an issue found through static analysis where identical sub-expressions were used.  <a href="https://github.com/aws/lumberyard/pull/216" target="blank">Pull request 216</a>

+ Fixed an issue found through static analysis related to commas in conditional statements.  <a href="https://github.com/aws/lumberyard/pull/204" target="blank">Pull request 204</a>

+ Fixed an issue in GameObjectSystem and VehicleSystem where an array overrun might occur.  <a href="https://github.com/aws/lumberyard/pull/203" target="blank">Pull request 203</a>

+ Fixed an issue found through static analysis related to variables with the same name being redeclared.  <a href="https://github.com/aws/lumberyard/pull/202" target="blank">Pull request 202</a>

+ Added missing insert method to AzCore deque class that is present in standard.  <a href="https://github.com/aws/lumberyard/pull/112" target="blank">Pull request 112</a>



