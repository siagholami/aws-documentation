# Using the Particle System to Add Steam<a name="enhancing-working"></a>

The particle system employs a large number of tiny sprites, 3D models, or other graphic objects to simulate certain kinds of fuzzy phenomena\. Examples include highly chaotic systems, natural phenomena, or processes caused by chemical reactions\. These types of particles are difficult to recreate with conventional rendering techniques\.

In this tutorial, you place pipes and use the particle system to add steam erupting from cracks in those pipes\. 

**To place pipes and add steam effects**

1. To add pipes to your maze, in the **Asset Browser**, navigate to `StarterGame/Objects/ManMade/Airship/`\. 

   Drag `am_air_pipes_straight_02.cgf` into the viewport\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-1.png)

1. Use the **Move** tool to position the pipe in the upper half of the inner maze walls, similar to the following image\.

   You may need to scale the pipes [on the Y axis](understanding-manipulating-scaling.md#understanding-scaling-oneaxis) to make them long enough to span the space between the walls\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-2.jpg)

1. Next, create an entity to add steam erupting from the pipes\. Right\-click in the **Perspective** viewport and choose **Create entity**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-3.png)

1. In the **Entity Inspector**, click **Add component**\. Under **Rendering**, click the **Particle** component\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-particle-component.png)

1. In the **Particle** component's properties, next to the **Particle effects library**, click the browse \(**…**\) button\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-4.png)

   In the **Pick Particle** dialog box, navigate to `StarterGame/libs/particles/`\. 

   Select `ambientfx.xml` and click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-5.png)

1. In the **Entity Inspector**, in the **Particle** component's properties, for **Emitters** select **Damage\.SteamDamage** from the particles list\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-6.png)

1. Use the **Move** tool to align the steam particle entity so that it appears to shoot from one of the pipes\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/enhancing-working-7.jpg)

[Next: Adding Ambient Particles](enhancing-adding-ambient-particles.md)