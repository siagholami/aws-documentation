# Improvements and Changes<a name="lumberyard-v1.17-improvements-changes"></a>

Lumberyard Beta 1.17 provides improvements and changes to Lumberyard systems and functionality. Choose a topic area to learn more.

**Topics**
+ [Audio](#audio-improvements-changes-v1.17)
+ [Component Entity System](#components-improvements-changes-v1.17)
+ [Lumberyard Editor](#lumberyard-editor-improvements-changes-v1.17)
+ [SDK Compatibility](#lumberyard-v1.17-highlights-compatible-sdk-versions)
+ [UI Editor](#ui-editor-improvements-changes-v1.17)
+ [Visual Studio 2017](#visual-studio-support-improvements-changes-v1.17)
+ [Miscellaneous](#miscellaneous-improvements-changes-v1.17)

## Audio<a name="audio-improvements-changes-v1.17"></a>

Audiokinetic Wwise SDK version 2016.x.x is now deprecated. This SDK version will no longer be supported in a future version of Lumberyard.

## Component Entity System<a name="components-improvements-changes-v1.17"></a>

The component entity system has the following improvements and changes for slices:
+ The **Entity Outliner** displays entities in orange if they have an override, which makes it easier to find overrides to save. 
+ In Lumberyard Editor, you can now view slice roots in a hierarchy more easily, so that you can see where one slice starts and another begins.
+ You can choose to save all overrides, such as adding and deleting entities, to a slice, If you don't want to save all changes, you can select the overrides that you want in the **Save Slice Overrides (Advanced)** dialog window.
+ You can now use shortcuts to select or deselect all changes from a slice in the **Save Slice Overrides (Advanced)** dialog window, so that you can specify which overrides that you want to save to your slices.
+ When you change the parent of a slice instance entity so that it no longer inherits directly from its current slice root, Lumberyard Editor treats this change as a deletion from its previous hierarchy and an addition to its new hierarchy. You must save the changes for the previous and the new slices for the changes to propagate to all instances of each slice. 
+ You can now save overrides to a nested slice that have been previously saved to a parent slice.
+ More checks have been added to prevent cyclical slice dependencies (such as a slice that contains an instance of itself) so that you can avoid getting into an infinite loop.
+ Slice assets now have an updated icon.
+ In Lumberyard Editor, menus options show if there are overrides for slice hierarchies. This is useful for finding if there are overrides that have been pushed to a parent but not a nested slice.
+ When you save or revert slice overrides, the slice hierarchy no longer collapses in the **Entity Outliner**.
+ You can now right-click an entity and revert all overrides in the **Entity Inspector**.
+ You can now right-click a component property and save overrides for specific component properties or the entire component.
+ In the **Entity Inspector**, the component title and property now appear orange when there are overrides, so that you can identify which specific component and properties have changes,
+ In the **Entity Outliner**, you can now right-click a slice instance and choose to find it in the **Asset Browser**.
+ In the viewport, you can now right-click a slice instance and choose to find it in the **Entity Outliner**.
+ You can now press the shortcut **R** to select the nearest slice root parent from a selection or press **Shift\+R** to select the top-most slice root in the current hierarchy.
+ You can now right-click a slice and then choose to select its slice root in the current slice hierarchy.
+ You can now right-click a slice, and choose whether to detach the selection or the instance. You can use this feature to manage a nested slice hierarchy when more than one slice root inherits directly from more than one slice asset.
+ The **Reset slice instance** option has been consolidated with the **Revert overrides** option.
+ You can now press the shortcut **Alt\+S** to save changes to a slice or press **Ctrl\+Alt\+S** to save all changes for a slice hierarchy.
+ In the **Asset Browser**, you can now right-click a slice asset and choose to open the slice in the **Slice Relationship View Tool**.
+ In the **Global Preferences**, you can choose the **Undo Slice Overrides Saves** option, so that you can undo changes saved to a slice from the **Save Slice Overrides** menus.
+ In the **Global Preferences**, you now choose the **Append numeric values to slices** option to automatically append a number to the end of a slice name.
+ A new error system was implemented to handle missing slices and allows you to remove missing slice dependencies.
+ You can now no longer save a slice outside of a project, gem, or other directory that Asset Processor is not set up to watch.
+ EBuses for `OnBeginSlicePush` and `OnEndSlicePush` have been added.

## Lumberyard Editor<a name="lumberyard-editor-improvements-changes-v1.17"></a>

Lumberyard Editor has the following improvements and changes for the **Entity Outliner**:
+ In the component filter option, you can now search for component names. 
+ The component filter menu now extends to the bottom of the screen to display more results.
+ You can now sort entities alphabetically in ascending or descending order.
+ You can now specify that the **Entity Outliner** automatically scrolls to the entity that you select.
+ You can specify that the **Entity Outliner** automatically expands hierarchies when you select an entity that is part of a collapsed hierarchy.
+ Double-clicking an entity has been improved so that you are less likely to accidentally rename an entity.
+ You can now drag and drop an asset (such as a mesh) to an entity to add the asset and its attached components to an existing entity. If you press and hold **Shift** while dragging and dropping, you will create a child entity.
+ Dragging an entity over a slice hierarchy now requires a 2.5 second hold to open the hierarchy. This makes it easier for you to scroll through entities in the **Entity Outliner** instead of accidentally expanding a hierarchy.
+ When you search for entities in the **Entity Outliner**, the string used to search is highlighted in the results.

Lumberyard Editor has the following improvements and changes for the **Entity Inspector**:
+ You can now set entities as start active, inactive or editor only. This allows an entity to be configured to spawn when the slice or level loads, to wait until a script or code activates the entity, or to exist only in edit mode, You can specify the editor only option to create entities during development, which are not required for gameplay.
+ Searching the **Add Component** menu now includes text for the categories.
+ You can now copy and paste asset references between component property fields.
+ Components have an updated help icon if there is a corresponding help topic that is referenced by the component.
+ When searching for entities in the **Entity Inspector**, the string used to search is highlighted in the results.

## SDK Compatibility<a name="lumberyard-v1.17-highlights-compatible-sdk-versions"></a>

Lumberyard 1.17 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.4.34
+ Amazon GameLift Server SDK version 3.2.1

## UI Editor<a name="ui-editor-improvements-changes-v1.17"></a>

The UI Editor has the following improvements and changes:
+ Slice information now appears in the **Hierarchy** pane:
  + Elements that are from slices now appear blue.
  + Top-level elements of a slice instance now appear bold and blue.
  + Elements that are from a slice instance but not top-level now appear italicized and blue.
+ You can now edit slices in a tabbed view in the UI Editor. To do so, right-click the slice instance of the selected element. You can see the slice without local overrides, and you can save changes from the **File** menu. Previously changes were saved from the **Push to Slice** dialog box.

## Visual Studio 2017<a name="visual-studio-support-improvements-changes-v1.17"></a>

Lumberyard 1.17 supports Visual Studio 2017 version 15.9.2.

Beginning with Visual Studio 2017, Microsoft now releases updates on a more frequent cadence (in some cases, weekly). Lumberyard is tested with the latest version of Visual Studio available during the release cycle. 

## Miscellaneous<a name="miscellaneous-improvements-changes-v1.17"></a>

Lumberyard has the following miscellaneous improvements and changes:
+ The transform gizmo is now easier to select in the viewport.
+ You can now undo and redo entity selection.
+ You can now press the shortcut **Ctrl \+ 6** to toggle follow terrain and snap to objects mode.

  In Lumberyard Editor, the **Game**, **AI**, **Continuous Update** option is now disabled by default.
+ When you undo a duplication, you can now press **Esc** to remove the duplicate.