# Adding Collider and Physics Components<a name="placing-entities-adding-colliders"></a>

Characters can interact with entities only when entities have a collider component and a physics component\. Collider components add an outline to your entity in a shape that characters can collide with\. Physics components engage Lumberyard's physics system\. Together, these components give entities their interactive qualities\.

## Adding a Mesh Collider<a name="placing-entities-adding-colliders-mesh"></a>

The collider components add an outline to your entity in a shape that characters can collide with\. Lumberyard includes two types of collider components:
+ **Mesh Collider** – Collision outline comes from the mesh asset defined in the **Mesh** component\.
+ **Primitive Collider** – Collision outline comes from a shape component \(cube, sphere, cylinder, and so on\)\.

In this tutorial, you add the **Mesh Collider** component to your doorway\.

**To add a mesh collider component**
+ In the **Entity Inspector**, click **Add Component**\.

  Under **Physics**, select **Mesh Collider**\.
**Tip**  
To quickly find a component, enter its name into the **Search** bar\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-adding-colliders-mesh.png)

## Adding Static Physics<a name="placing-entities-adding-colliders-physics"></a>

The physics component engages Lumberyard's physics system\. Lumberyard includes two types of physics components:
+ **Static Physics** – Properties for objects that require collision information but are not designed to move, such as a building\.
+ **Rigid Body Physics** – Properties for objects that can be moved by physics\-implemented motion events, such as a ball intended to roll or a wall intended to fall over\. 

In this tutorial, you add the **Static Physics** component to your doorway\.

**To add a physics component**
+ In the **Entity Inspector**, click **Add Component**\.

  Under **Physics**, select **Static Physics**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-adding-colliders-physics.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-entities-collider-physics.png)

  Press **Ctrl\+G** to play the game\.

  Observe that your character can now collide with the doorway\.

[Next: Using Asset Browser to Create an Entity](placing-entities-asset-browser.md)