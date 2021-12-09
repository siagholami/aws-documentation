# 3: Gathering Your Building Blocks<a name="gathering-building-blocks"></a>

In this tutorial, you use component entities and slices to begin building the maze\. In a later tutorial, you use Lumberyard's component entity system to place game elements such as [meshes](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#mesh), lights, sounds, trigger areas, cameras, and more\. This is a key workflow in Lumberyard\. The slices system is Lumberyard's version of what other game engines call *prefabs*\. You can use slices, which are easily updated, to quickly develop your project\. 

When placing entities, you typically begin with an empty entity\. You then add components to it to define the appearance, behavior, and properties of that entity\. 

The component entity system is Lumberyard's approach to composing complex entities out of simpler entities\.

You can add components to an entity to build the behavior you want\. You can then edit component settings in the editor and create scripts to change and extend the behavior of an entity\.

When you group or nest entities, you can save the group as a slice\. This creates a `.slice` file within your game project directory\. You can use Lumberyard's **Asset Browser** to drag that slice into your level\. This is called instantiating a slice\. You can do this as many times as you want\. You can also nest slices within other slices to create more complex slices\.

When you make changes to a slice instance, you can save those changes to all instances of that slice in your project\. However, you can also customize any part of any slice instance \(except the source slice\) and keep the customization in just that instance\.

Lumberyard uses components to allow system\-level features of the engine to be extended by writing new core components\. For example, the character manager component gives animated characters a tick for each frame and acts as a bridge between the physics and animation systems\. Components are a critical feature in Lumberyard's modular game engine architecture\.

**Topics**
+ [Creating an Entity](placing-entities-creating-doorway.md)
+ [Adding a Mesh Component](placing-entities-static-mesh.md)
+ [Adding Collider and Physics Components](placing-entities-adding-colliders.md)
+ [Using the Asset Browser to Create an Entity](placing-entities-asset-browser.md)
+ [Duplicating an Entity](placing-entities-duplicating.md)
+ [Parenting Entities](placing-entities-parenting.md)

[Next: Creating an Entity](placing-entities-creating-doorway.md)