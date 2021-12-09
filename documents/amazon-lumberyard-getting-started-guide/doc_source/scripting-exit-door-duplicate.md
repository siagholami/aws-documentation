# Duplicating and Renaming the Door Entity<a name="scripting-exit-door-duplicate"></a>

Because you have already performed the tasks of setting up the entry door, there is no need to do it all again from the beginning to create your exit door\. Instead, you'll duplicate the existing entry door and then modify its name and properties\.

**To duplicate and rename the door entity**

1.  In the **Entity Outliner**, select **EntryDoor\_Parent**\. To duplicate it, press **Ctrl\+D**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-duplicate.png)

1.  Use the **Move** tool to move the duplicated door entity to the other side of the maze\. Align the door in the opening of the exit doorway\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-align.png)

1. In the **Entity Outliner**, select the duplicated entity\. In the **Entity Inspector**, rename it **ExitDoor\_Parent**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/scripting-exit-door-parent.png)

1. Press **Ctrl\+S** to save your level\.

[Next: Adding Lua Scripts to Exit Door](scripting-exit-door-lua.md)