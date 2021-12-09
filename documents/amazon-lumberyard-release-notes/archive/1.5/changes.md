# Improvements and Changes<a name="lumberyard-v1.5-changes"></a>

This version of Lumberyard includes the following updates to systems and functionality::

**Az Code Generator**
+ Integrated Waf to allow build system control of annotation parsing, template rendering, and source code injection back into the build process.
+ Introduced render templates, which are a set of Python scripts and Jinja2 templates for generating source code via Az Code Generator.
+ Created new render templates for Az modules using AzCore mechanisms, such as AZ\_COMPONENT, Reflect for Serialize, and Reflect for Edit. These allow users to optionally replace the boilerplate code around these mechanisms with easier-to-understand annotations next to the associated code.
+ Added support for user-generated render templates, which can be specified for use via the Waf integration.

**Character and Animation**
+ Updated Mannequin flow graph nodes to work with the Mannequin component. The Mannequin flow graph tutorial (located in the `\dev\SamplesProject\Levels\Component_Tests\Mannequin_FlowGraph` directory) demonstrates possible uses of the Mannequin component functionality.
+ In the **FBX Settings**, clarified the meaning of 32-bit vertex data and updated the tool tip.

**Cloud Canvas**
+ Added support for OS X game clients so that Mac customers can now use Cloud Canvas functionality.
+ Improved the authentication process when launching the Don't Die project. Login and configurable data updates are now processed correctly on first launch.

**Components**
+ Primitive collider components were removed and replaced by shape-plus-collider component combinations. Existing primitive collider components will be replaced by an appropriate shape component that has been configured. In order to use collision capabilities, you must manually add a primitive collider component.
+ Trigger area components no longer specify a box shape for triggering; instead, a shape on the entity is used as the trigger volume. You can now use any shape component as bounds for triggering with trigger area components. Previously only boxes could be used. You must manually add old trigger areas to the new ones.
+ The mesh component is now separated into two components: static mesh component and skinned mesh component.
+ The physics component is now separated into two components: physics component and character physics component.

**Content**
+ Updated sample level demonstrating animating and driving a physical character using controller input and Lua scripting. The sample Lua-based state machine (located in the `\Components\Controllable_Chicken` demo level) leverages the **Mannequin** component, **Character Physics** component, and **Skinned Mesh** component.
+ Added new sample level demonstrating basic animation using flow graph and the **Mannequin** component. This level (located in the `Component_Tests/Mannequin_FlowGraph` demo level) leverages the **Mannequin** component and the **Skinned Mesh** component.

**Gems**
+ Version numbers and the public API on all Lumberyard gems were updated and converted to AZ Modules, allowing better integration with the new Component Entity system. We recommend that custom-built gems be converted to AZ Modules. For instructions on this procedure, see [Migrating Lumberyard Projects](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-migrating.html).
+ If `gems.json` is manually edited, users must run `Bin64\lmbr.exe projects populate-appdescriptors` to update the application descriptor files. For more information, see [Migrating Lumberyard Projects](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-migrating.html).

**Lumberyard Editor**
+ The **Light Skin** option is no longer available in the editor.
+ The editor no longer supports loading a view pane with a floating editor (for example, **UI Editor**, **Particle Editor**, **Flow Graph**, etc.).
+ Selection is now preserved when you enter and exit game mode in the editor.
+ Camera orientation is now preserved when you enter and exit game mode in the editor.
+ Performance has been improved for undo/redo operations on large numbers of component entities in the editor.
+ Property grid indentation logic has been improved.
+ You can now use **Ctrl**\+click on parent elements in the property grid to expand or contract all children.
+ When placed in the editor, slices with multiple root entities can no longer inherit one of the contained entity's rotation.

**Mobile**
+ Android: 
  + Android Studio builds are now signed with the same certification as Waf builds. This allows you to deploy Android games to the Google Play Store.
  + The Waf build system now generates the SDL library. This adds the ability to debug low level library functions.
+ iOS: SDL is no longer a dependency, making it easier to obtain pointers to the view and application controller.

**Networking**
+ Added the console variable `cl_clientPort` that clients can use as a binding port. Modified `JoinSession()` to use `cl_clientPort` and default to the ephemeral port.
+ Added a mechanism to defer updates from replica callbacks.
+ Removed the UnionDataSet feature.
+ Removed the `GetUniqueName()` function, which is no longer used by EBus.
+ Removed the unused member variables `clientPort` and `serverPort` from SGameStartParams.

**Particle Editor**
+ Added the ability to drag emitters between libraries and from one emitter to another.

**UI Editor**
+ A new set of flow graph nodes simplifies the use of **Flow Graph** with the UI system. These nodes use an entity in the level to store the UI canvas path and avoid the need to pass the canvas ID from node to node. These nodes also use UI element names instead of UI element IDs, which makes it easier to identify the referenced flow graph nodes. The new nodes are located in the **Flow Graph** section called **UIe**. The old nodes are still included for backward compatibility.
+ The zoom factor is now displayed in the **UI Editor** toolbar.

**Virtual Reality**
+ Added new Open Source Virtual Reality (OSVR) Gem.
+ Added support for automatic resolution detection of attached head-mounted display (HMD).
+ Upgraded the Oculus Gem to use the Oculus SDK version 1.5.
+ Converted the VR gems into AZ modules.
+ Made shadow maps shareable between the left and right eyes to avoid rendering shadows again.

**Miscellaneous**
+ Various changes to the Lumberyard Setup Assistant include updating the version number, adding tool tips, and improving labels.
+ Performance improvements to the Asset Processor include evaluation and startup time as well as an indication of how much work is required upon startup in the editor.
+ The Asset Catalog now saves faster, leading to faster turnaround times for hot reloading.
+ A new socket layer, AzSock, replaces the legacy CrySock so you don't need to use CrySystem.
+ The test hook IMPLEMENT\_AZ\_TEST\_SCANNER\_HOOK is now available as two separate hooks. AZ\_UNIT\_TEST\_HOOK is used to run unit tests and AZ\_INTEG\_TEST\_HOOK is used to run integration tests. Existing modules and gems now use these hooks. You must update your custom modules and gems to use these hooks.