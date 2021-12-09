# Improvements and Changes<a name="lumberyard-v1.21-improvements-changes"></a>

Lumberyard Beta 1.21, 1.21.1, and 1.21.2 provide improvements and changes to Lumberyard systems and functionality.

**Topics**
+ [Animation Editor](#animation-improvements-changes-v1.21)
+ [Audio](#audio-improvements-changes-v1.21)
+ [Console variables](#cvar-improvements-changes-v1.21)
+ [Graph Canvas](#graph-canvas-improvements-changes-v1.21)
+ [Mobile](#mobile-improvements-changes-v1.21)
+ [Networking](#networking-improvements-changes-v1.21)
+ [PhysX](#physx-improvements-changes-v1.21)
+ [Script Canvas](#lumberyard-v1.21-highlights-script-canvas)
+ [SDK Compatibility](#lumberyard-v1.21-compatible-sdk-versions)
+ [Terrain](#lumberyard-v1.21-improvements-changes-terrain)
+ [UI Editor](#UI-editor-improvements-changes-v1.21)
+ [Miscellaneous](#miscellaneous-improvements-changes-v1.21)

## Animation Editor<a name="animation-improvements-changes-v1.21"></a>

The **Animation Editor** has the following improvements and changes:
+ **Parameter Condition Time Requirement Field **– A **Time requirement field** has been added to the **Parameter Condition** for transition lines. The field specifies the minimum length of time in seconds that the parameter condition must evaluate as `True` before the transition occurs. If the parameter condition returns to `False` during the time specified, the transition doesn’t occur. The default is `0.0`, which means that no minimum time is required for the transition to occur.  
**Example**  

  Suppose the value for **Time requirement** is `1`. If **Parameter Condition** is `True`, one second must elapse before the transition occurs. If the parameter condition returns to `False` during the one-second delay, the transition doesn't occur.

## Audio<a name="audio-improvements-changes-v1.21"></a>

Audio has the following improvements and changes.
+ In a future release, the audio modules will be converted into gems. The **Audio Controls Editor** code will be moved from the `Sandbox Plugins` directory into these new gems. This change includes the following modules:
  + CrySoundSystem
  + CryAudioImplWwise

  If you made significant changes to the Lumberyard audio systems, there could be a potential impact on your game project.

## Console variables<a name="cvar-improvements-changes-v1.21"></a>
Change: Added two new Console variables (CVars) - e_LightQuality and e_LightVolumes.

**e_LightQuality**
Light detail quality. Controls whether lights are created or casts shadows based on the minimum spec level set in the light configuration. 1: Creates or casts shadows from lights that have the minimum spec level set to low. 2: Creates or casts shadows from lights that have the minimum spec level set to low or medium. 3: Creates or casts shadows from lights that have the minimum spec level set to low, medium or high. 4: Creates or casts shadows from lights that have the minimum spec level set to low, medium, high or very high.

**e_LightVolumes** 
Allows deferred lighting for registered alpha blended geometry. 0 = Off, 1 = Enabled, 2 = Enabled just for sun light.

**Note:** Manually add these variables to any CVar groups you created. Otherwise dynamic lights may be turned off in your game.

## Graph Canvas<a name="graph-canvas-improvements-changes-v1.21"></a>

Graph Canvas, which is enabled by the Graph Canvas gem, has the following improvements and changes:
+ **Connection Notification Bus Update** – The **OnMoveComplete** event is deprecated and replaced by **OnMoveFinalized**. **OnMoveFinalized** returns a Boolean that indicates whether the connection is valid, whereas **OnMoveComplete** only signalled when the connection was valid. In a future release, **OnMoveComplete** will be removed. In the interim, the default implementation of **OnMoveFnalized** maintains the signalling to **OnMoveComplete**.
+ **Extender slots** – Extender slots enable nodes to dynamically add pins to a node. These pins remain until the end user manually removes them.   
![\[Adding additional slots to a node.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/script-canvas-extender-nodes.gif)

  To add or create extender slots, see the following code example.  
**Example**  

  ```
  // Simplified down from ScriptCanvas's extender slot implementation. See NodeUtils.cpp for the raw implementation.
  AZ::EntityId DisplayExtensionSlot(const AZ::EntityId& graphCanvasNodeId, GraphCanvas::ConnectionType connectionType, const AZStd::string& name, const AZStd::string& toolTip, const AZStd::string& displayGroup, GraphCanvas::ExtenderId extenderId)
  {
      GraphCanvas::ExtenderSlotConfiguration graphCanvasConfiguration;
   
      // Common display code with other slots.
      // Controls the name of the slot, the tool tip, where it's displayed on the node. And what type of connection it should appear as.
      graphCanvasConfiguration.m_name = name;
      graphCanvasConfiguration.m_tooltip = toolTip;
      graphCanvasConfiguration.m_slotGroup = GraphCanvas::SlotGroup(displayGroup);
      graphCanvasConfiguration.m_connectionType = connectionType;
   
      // Extender Specific Configurations
      // This Id is how the slot will make requests to the back-end to add slots for a particular operation(using GraphModelRequest::RequestExtension)
      graphCanvasConfiguration.m_extenderId = extenderId;
   
      AZ::Entity* slotEntity = nullptr;
   
      GraphCanvas::GraphCanvasRequestBus::BroadcastResult(slotEntity, &GraphCanvas::GraphCanvasRequests::CreateSlot, graphCanvasNodeId, graphCanvasConfiguration);
   
      if (slotEntity)
      {
          slotEntity->Init();
          slotEntity->Activate();
   
          GraphCanvas::NodeRequestBus::Event(graphCanvasNodeId, &GraphCanvas::NodeRequests::AddSlot, slotEntity->GetId());
      }
   
      return slotEntity ? slotEntity->GetId() : AZ::EntityId();
  }
  ```  
**Example GraphModelRequests**  

  The `ExtenderSlot` invokes the GraphModelRequests `RequestExtension` method when `ExtenderSlot` needs to create a slot in response to a user's action. The method provides the `NodeId` of the requesting node and the specified `ExtenderId`. The method expects back one of the following:
  + The `SlotId` of the slot that was created.
  + The specific slot associated with that `ExtenderId` in the case of a single extender that adds multiple pins.

  ```
  virtual SlotId RequestExtension(const NodeId& nodeId, const ExtenderId& extenderId)
  {
      AZ_UNUSED(nodeId);
      AZ_UNUSED(extenderId);
      return SlotId();
  }
  ```

## Mobile<a name="mobile-improvements-changes-v1.21"></a>

Mobile has the following improvements and changes:
+ ASTC compression has been enabled by default for Normal maps on Android and iOS. To change the default, you can edit the `dev/Gems/ImageProcessing/Code/Source/ImageBuilderDefaultPresets.settings` file. If your project uses a custom ImageBuilder settings file, you must edit that file to enable ASTC compression for your project's assets. To change the compression technique for any texture file, refer to the `dev/Gems/ImageProcessing/Code/Source/ImageBuilderDefaultPresets.settings` file.

## Networking<a name="networking-improvements-changes-v1.21"></a>

The new Multiplayer Analytics gem enables Lumberyard developers to analyze their networking traffic in realtime while in the game. Using this gem, developers can find bottlenecks in their game traffic and optimize accordingly. You can track the total bandwidth for each network field or for each remote procedure.

## PhysX<a name="physx-improvements-changes-v1.21"></a>

The PhysX system has the following improvements and changes:
+ The **PhysX Configuration** tool now has links to the help documentation. Use these links to learn more about collision filtering.
+ The PhysX colliders now interact with the current CryWater system. You can use PhysX colliders to generate ripple effects.
+ The following functions in Script Canvas are now available:
  + `OverlapSphere`
  + `OverlapBox`
  + `OverlapCapsule`
+ In the **Script Canvas** editor, the **OnCollision** node now supports PhysX. You can use this node to determine the properties and impact on entities when collisions occur, such as the coordinates, force applied, and so on.
+ The following shape cast functions in Script Canvas are now available:
  + `SphereCast`
  + `BoxCast`
  + `CapsuleCast`
+ By default, the Samples Project and Multiplayer Sample projects are enabled with the following gems:
  + PhysX
  + PhysX Characters
  + PhysX Debug
+ The NVIDIA PhysX license files are now included when you download Lumberyard.
+ The NVIDIA PhysX SDK 4.1 now supports generating static and dynamic libraries for all Lumberyard supported platforms. 

## Script Canvas<a name="lumberyard-v1.21-highlights-script-canvas"></a>

Script Canvas has the following improvements and changes.
+ **Dynamically typed slots** – In the **Script Canvas** editor, you can now dynamically connect type slots to each other. Like node groups, any pair of dynamically typed nodes that are linked together now share the same restrictions. This includes any restrictions from the node group. Additionally, the slots always aim to be in the most unrestricted state as possible. Unless a display type gives a set of dynamically typed slots a type, the slots remain untyped.  
**Example**    
![\[Create a dynamically chained node.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/script-canvas-chained-dynamic-types.gif)
+ **Dynamically add slots** – You can add any number of points using a button on nodes that support dynamically added slots. To add a slot, drag a connection to and from the **\+** icon or click the **\+** icon or label.
**Note**  
If you have a custom node and want to add this functionality to them, see the extender nodes section.  
**Example**    
![\[Connect nodes using extender nodes.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/script-canvas-add-operand-button.gif)
+ **Comment and Group Presets** – The **Script Canvas** editor now supports a preset system for comments and groups. Use presets to create and store comment and group settings so you can easily and quickly reuse them to improve consistency between Script Canvas graphs.  
![\[Use presets in the Script Canvas editor.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/script-canvas-preset-comments-groups-1.png)

  To create a preset from a group or comment, right-click the group or comment, and choose **Create Preset From**. Font settings and the main color synchronizes to the preset, and display text is removed from the template.

  Once you create a preset, you can't reconfigure it. However, you can delete the preset and re-add it using the **Presets Editor**. Any changes or updates made to the deleted preset are not saved when you delete and re-add it.

  You can specify one preset as the default for either a node group or comment.   
![\[Delete or reset your group and comment presents.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/script-canvas-preset-comments-groups-2.png)
+ **Disabled Nodes** – You can now disable your selected nodes at edit time. Disabled nodes won't run during runtime or generate warnings or errors when you save a Script Canvas graph. However, disabled nodes still exist in the data and can be interacted with. Disabled nodes appear visually different and any nodes that are connected to it also won't run.

  To enable or disable nodes, right-click the node and choose **Enable** or **Disable**. You can also press **Ctrl\+K\+C** to disable a node or press **Ctrl\+K\+U** to enable a node.  
**Example**    
![\[Delete or reset your group and comment presents.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/script-canvas-disabling-nodes.gif)
+ **New nodes** – The **Script Canvas** editor adds the following nodes:
  + **Repeater** – This node triggers an action output for the specified number of times. You can enter a delay in between each firing of the **Action** pin.
  + **Switch** – This node triggers the output pin specified by the index field. This is similar to how a switch block works in code.
  + **Ordered Sequencer** – This node triggers the available outputs from the `0`th pin to the `N`th pin. The node won't trigger the next pin until the previous execution thread either terminates or reaches a latent node.
+ 

**Additional Script Canvas Improvements**
  + Added a new option so that you can customize how far to zoom in the a Script Canvas graph.
  + Changed the maximum zoom out distance so that the **Script Canvas** editor displays the entire editable graph area.
  + Graph tabs now have a right-click menu with common operators. Press the middle-mouse wheel to close a tab.
  + The **Script Canvas** editor menus are re-factored. This means that they more accurately reflect all available functionality and let you to find the hot keys more easily.
  + The **Script Canvas** editor now remembers what graphs were previously opened in Lumberyard Editor and will reopen them the next time you open the editor.

    To disable this feature in, choose **Settings**, **Global Preferences**, **Remember Open Canvases**.
  + Invalid connections now display a description of why the connection can't be made.
  + When you save a graph, validation errors now display a description that includes the number of warnings Previously. the editor highlighted the errors in the graph.
  + On the **Script Canvas** component, if you click the **Open in Script Canvas Editor** icon for the **Script Canvas Asset** property, this creates a Script Canvas graph. When you save it, the script appears in the **Script Canvas** component that is attached to the entity.

## SDK Compatibility<a name="lumberyard-v1.21-compatible-sdk-versions"></a>

Lumberyard 1.21 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.4.34.3
+ Amazon GameLift Server SDK version 3.2.1

## Terrain<a name="lumberyard-v1.21-improvements-changes-terrain"></a>

The terrain system has the following changes.
+ The terrain color layer has been significantly improved. The changes can potentially impact anyone who created a specific workaround to deal with the terrain seam bug. These changes include the following:

  1. When opening a level in the editor, if **Export to Engine** hasn't been run recently, the level previously displayed seams between terrain sectors for any sector that has had its color edited. Those seams are no longer visible. The display in the editor should match what you see after you choose **Export to Engine**.

  1. When you previously chose **Export to Engine** or **Export Terrain Texture**, the terrain system calculated an averaged pixel color along terrain tile seams. Now, the pixel colors remain consistent with the input textures. This might cause the texture to look slightly differently along the seams if the input textures were authored in a way to try and account for this.

  1. When you used multiple terrain tiles, the pixel calculation math was off by one or more pixels by the end of the terrain. As a result, when you viewed the level in the editor and chose **Export to Engine**, it was possible that the color mappings would shift by one or more pixels across the terrain from how it was previously. The new result accurately represents the inputs. However, this change might cause unexpected results if the inputs were modified to account for this bug.
**Note**  
There can still be some pixel shifting visible along seams that occurs when you edit the terrain color, due to small differences in the UV calculation between edited terrain sectors and the final exported texture. If this causes problems, the workaround is to **Generate Terrain Texture** (or **Export To Engine**) to produce a corrected runtime texture.
+ The `Editor.exe` now supports an optional -`-runpythonargs` command line argument. If used, the string is passed to the python script referenced by the `--runpython` argument.  
**Example**  

  ```
  Editor.exe --runpython import_heightmap.py --runpythonargs "TestLevel test_heightmap.tif"
  ```
+ Added the `ImportHeightmap`, `ExportHeightmap`, and `RefreshTerrain` APIs to `CHeightmap`, and moved the specific load and save per file type functions to private.
+ Added the following Editor Python bindings: 
  + `terrain.get_max_height()`
  + `terrain.set_max_height(float max_height)`
  + `terrain.import_heightmap(string name, bool resize)`
  + `terrain.export_heightmap(string name)`
  + `terrain.get_elevation(float x, float y)`
+ Editor Python bindings now print out help text and autocomplete correctly when used in the Lumberyard Editor console.

## UI Editor<a name="UI-editor-improvements-changes-v1.21"></a>

See the following UI Editor changes to Lumberyard.
+ The **Scale To Device** property on the **Transform2D** component provides more scaling options in addition to the existing **Uniform Scale to Fit** option. 

  Warnings now appear in the **UI Editor** for when a **Scale to Device** property might display undesired results.
+ Added a max width and max height property to the **Layout Cell** component. This lets you specify a maximum size for an element, where a layout component controls the size.

## Miscellaneous<a name="miscellaneous-improvements-changes-v1.21"></a>

See the following miscellaneous changes to Lumberyard.
+ 1.21.2: Asset Editor

When you modify a parent entity, then undo the changes, those changes now revert correctly.

+ The following APIs, systems, and tools are planned to be removed in a future release:
  + AWS gem
  + AzCore: `DirectSocket`
  + Boids
  + CryEntityRemoval gem
  + `CryAISystem`
  + `CryAnimation`
  + `CryEntitySystem` and `CryAction`
  + `CryInput`
  + `CryPhysics`
  + `CryScriptSystem`
  + `CrySystem` (specifically, APIs that duplicate functionality in AzCore)
  + Editor `CBaseObject `(including Cry prefabs, `CSelectionGroup` and related code)
  + Flow Graph
    + All references to Flow Graph from Cloud Canvas gems
  + PRT Library
  + Tools and Tooling
    + Behavior Tree Editor
    + Editor Plugins:
      + Asset Tagging
      + Editor Animation
      + Legacy Folder and QML view pane
    + Legacy source control plugin
    + LiveMocap
    + Max and Maya Plugins (planned for replacement by FBX Pipeline)
    + Statoscope integration
    + Woodpecker Tool (The Driller Visualizer)
+ Removed the third-party library `JANSSON` from the `SetupAssistantConfig.json` and `PackageConfig.json` files. This library contained unused packages that Lumberyard no longer requires. This change doesn't affect the engine or your game project. You don't need to make code changes.
+ The `Disconnect` action is now an asynchronous, non-blocking operation in the CloudGemWebCommunicator sample.
+ Removed the Cry Legacy Feature Tests (`lumberyard_version/dev/Code/FeatureTests`).
+ Removed the Pre C\+\+ 14 Compiler Support.
+ 

**New names for macros that suppress AZ trace messages**  
The following macros for suppressing AZ Trace messages in the AZ Unit Test framework have equivalent macros with new names. The old macros will be removed in a future release.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/lumberyard-v1.21-improvements-changes.html)

  The old macros only suppressed the *AZ\_Error* and *AZ\_Assert* trace messages, but their names implied application termination. The new macros are equivalent in functionality to the old macros but have names that more accurately reflect their functionality.
