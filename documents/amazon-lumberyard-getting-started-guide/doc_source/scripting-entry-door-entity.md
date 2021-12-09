# Placing the Door Entity<a name="scripting-entry-door-entity"></a>

Earlier in this series of tutorials you placed a frame and posts, leaving an open doorway\. Now it's time to place a door in that doorway\.

**To place a door**

1. First, you create an empty entity to organize all your entry door entities\. To do this, right\-click in your viewport just outside one of your maze doors \(but not inside of it\)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-entity-create1.png)

   Name the entity **EntryDoor\_Parent**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-entity-create.png)

1. To add the door: In the **Asset Browser**, navigate to `Objects\GSG\` and drag `GSG_Maze_Door.fbx` into the viewport\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-entity-mazedoor.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-entity-mazedoor1.png)

1. Use the **Move** tool to align the door in the open doorway so that it looks like the door is closed\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-entry-door-entity-closed.png)

1. To keep your entities organized, drag **gsg\_maze\_door** onto **EntryDoor\_Parent**\.

   **EntryDoor\_Parent** now has **gsg\_maze\_door** as a child\.

Next: [Adding Physics and Mesh Collider Components](scripting-entry-door-components.md)