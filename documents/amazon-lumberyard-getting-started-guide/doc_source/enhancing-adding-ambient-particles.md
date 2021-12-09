# Adding Ambient Particles<a name="enhancing-adding-ambient-particles"></a>

You can use the particle system to add ambient particles floating through the air\. The steps in this procedure are similar to the previous procedure\.

**To add ambient particles to the air**

1. On the outside of the maze, near your player character, right\-click and choose **Create entity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-adding-ambient-particles-1.png)

1. In the **Entity Inspector**, click **Add Component**\. Under **Rendering**, click **Particle**\. 

1. In the **Particle** component's properties, next to the **Particle effects library** box, click the browse \(**…**\) button\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-4.png)

   In the **Pick Particle** dialog box, navigate to `Game/libs/particles/`\. 

   Select `ambientfx.xml` and click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-5.png)

1. In the **Entity Inspector**, in the **Particle** component's properties, for **Emitters** select **FlyingSeeds\.FlyingSeeds** from the particles list\.

   You now see little seeds floating slowly through the air\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-floating-seeds.gif)

1. Duplicate this entity \(**Ctrl\+D**\) and place them in several locations around the level\. 

1. Press **Ctrl\+S** to save your level\.

[Next: Adding a Distance Mesh](enhancing-adding-distance-mesh.md)