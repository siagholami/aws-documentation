# Adding Decals to the Maze<a name="enhancing-adding-decals"></a>

Decals are special texture planes that you can layer on top of mesh assets to give them detail\. You use the decals to add a door number decal above the maze's entry door\.

1. Open the **Asset Browser** and navigate to `StarterGame/Materials/Decals`\. Select `decal_airship_tail_02.mtl`\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-adding-decals-2.png)

1. Drag `decal_airship_tail_02.mtl` into the **Perspective Viewport** just in front of the maze's entry door\. 

   A *6* appears on the ground, and your entity component automatically has a decal component assigned\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-decal-add.png)

1. In the **Entity Inspector**, rename the decal entity **door\_num\_decal**\.

1. In the **Decal** component's properties, under **Decal Settings**, change the **Projection type** to **On Terrain and Static Objects**\.

   You can use this setting to adjust the projection display settings of the decal based on its position\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-decal-add-2.png)

   Move the **door\_num\_decal** up and down with the **Move** tool to see it fade in and out of the terrain based on distance\. 

1. Next you map the decal to the space above the entry door using the **Align to Surface** tool\. This tool is faster and more precise than the **Move** tool for this purpose\.

   In the **Entity Inspector**, unlock the **DoorWay\_Parent** group if it is currently locked\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-decal-add-3.png)

1. With **door\_num\_decal** still selected, click the **Align to Surface Tool** \(![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/align-to-surface.png)\) on the main toolbar\.

1. By default the **Align to Surface Tool** aligns to the terrain only\. To align instead to the scene's geometry, hold down **Ctrl** and then click the surface above the door in the **DoorWay\_Parent** entity\. The decal snaps to that surface\.

   You can now move and rotate your decal along that surface\. Position it where you like\. 

   You can also adjust the transparency of the decal\. To do this, you can modify the **Decal** component's **Opacity** setting\. Or you can move it away from the surface it's aligned to\.

1. Use the **Scale** tool to adjust the size of the decal\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-decal-add-4.jpg)

1. Press **Ctrl\+S** to save your level\.

You can find more decals, such as scorch and corrosion decals, in the **Asset Browser** in `Game/Materials/Decals`\. Experiment with placing these decals in your maze to give it a damaged and distressed look\. To see an example of how you can use these decals, revisit [Opening the Orientation Level](understanding.md#understanding-opening)\. 

[Next: Using the Particle System to Add Steam](enhancing-working.md)