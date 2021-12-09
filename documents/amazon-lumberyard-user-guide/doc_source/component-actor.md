# Actor<a name="component-actor"></a>

****  
This feature is in [preview](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#preview) release and is subject to change\. 

You can use the **Actor** component to create characters for your game\. After you import your character files from your DCC tool into Lumberyard, you can create an entity and add the **Actor** component to it\. For example, you must use an **Actor** component to create a controllable character for your game\.

For the **Actor** component to work properly, you must also add one of the following:
+ **[Simple Motion](component-simple-motion.md)** component – Uses a single motion for your actor\.
+ **[AnimGraph](component-animgraph.md)** component – Uses an animation graph to control your actor's behavior\.

**Topics**
+ [Actor Component Properties](#component-actor-properties)
+ [Using Multiple Skin Attachments for an Actor](component-actor-multiple-skin.md)
+ [Setting Up Actor Entities](component-actor-component-entity-setup.md)

## Actor Component Properties<a name="component-actor-properties"></a>

![\[Actor component properties.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/actor_component_properties.png)

The **Actor** component has the following properties\.


****  

| Property | Description | 
| --- | --- | 
|  **Actor asset**  |  Specifies the actor file that you want to add to your entity\.   | 
|  **LOD Materials**  | Specifies the material that is linked to your actor asset\. | 
|  **Attachment type**  |  The **Actor** component has the following attachment types: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/component-actor.html)  | 
| Draw skeleton |  Determines whether character joints are visible\.   | 
| Draw character |  Determines whether character mesh is visible\.  | 
| Skinning method |  Specifies the skinning method to use for the actor\. You can choose the following options: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/component-actor.html)  | 