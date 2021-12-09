# Fixes<a name="lumberyard-v1.17-fixes"></a>

Lumberyard Beta 1.17 resolves earlier problems. Choose a topic area to learn more about the related fixes.

**Topics**
+ [Cinematics](#cinematics-fixes-v1.17)
+ [Slices](#slices-fixes-v1.17)
+ [UI Editor](#ui-editor-fixes-v1.17)

## Cinematics<a name="cinematics-fixes-v1.17"></a>

The cinematics system has the following fixes:
+ The **Track View** editor no longer stops working when you use the redo and undo functionality.
+ The redo and undo functionality now works properly in the **Curve Editor**.
+ The up and down buttons now work properly in the **Key Properties** dialog box.
+ You can no longer erroneously use quotation marks in the file prefix. Previously this prevented the Render Output tool from generating screenshots and videos.
+ The **Simple Motion** component is now removed when you remove the **Actor** component from an entity.
+ The Render Output tool is now disabled when you're in game mode.
+ You can now extend or shorten a looped motion track.
+ Keys on a compound track now report values for subtracks.
+ When you deselect a sequence, it no longer erroneously appears in the **Sequence** drop-down list.

## Slices<a name="slices-fixes-v1.17"></a>

Slices have the following fixes:
+ Duplicating slice instance entities is now more stable.
+ Various performance improvements include serializing slices, decreasing the slice save time, and increasing system reliability.
+ Slices now have improved container serialization.
+ The zoom to selection functionality (keyboard shortcut **Z**) is now unified between the **Entity Outliner** and the viewport.
+ You can now save slices that have splines with deleted points.
+ Cubemap assets now save properly to nested slices.
+ You can now create an instance from a nested slice within a slice.
+ Component dependency sorting no longer misidentifies objects as being incompatible when a component provides the same service twice.
+ You no longer need to restart the editor to view changes to nested slices.
+ Entering a rotation value in one of the axis fields no longer modifies all of the axes in the viewport.
+ Material and texture asset reference fields are now detectable as an override when you modify these fields from the source slice data.
+ The **Thumbnailer** component is now self-compatible.

## UI Editor<a name="ui-editor-fixes-v1.17"></a>

You can now push a new slice instance into a UI slice.