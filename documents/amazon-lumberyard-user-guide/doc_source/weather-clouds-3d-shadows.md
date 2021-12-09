# Adding 3D Cloud Shadows<a name="weather-clouds-3d-shadows"></a>

****  
This topic references tools and features that are [legacy](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#legacy)\. If you want to use legacy tools in Lumberyard Editor, disable the [CryEntity Removal gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-cryentity-removal-gem.html) using the [Project Configurator](https://docs.aws.amazon.com/lumberyard/latest/userguide/configurator-intro.html) or the [command line](https://docs.aws.amazon.com/lumberyard/latest/userguide/lmbr-exe.html)\. To learn more about legacy features, see the [Lumberyard Legacy Reference](https://d3bqhfbip4ze4a.cloudfront.net/lumberyard-legacy.pdf)\.

3D clouds don't actually cast real\-time shadows\. Instead a moveable texture is imposed on the entire level, creating the illusion that the clouds cast shadows\.

**Example 3D Cloud Shadows**  

![\[Example 3D clouds with shadows in Lumberyard.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/weather/weather-clouds-3d-shadows-1.gif)

**To add 3D cloud shadows**

1. In the **Rollup Bar**, under **Terrain**, click **Environment**\. 

1. Under **CloudShadows**, click **Cloud shadow texture** and the folder icon\.

1. In **Preview**, select an asset\.  
![\[Example of an appropriate shadow asset.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/weather/weather-clouds-3d-shadows-3.png)

1. Drag the shadow to the desired location in your level\. 

1. Under **CloudShadows**, adjust the following parameters:
   + **Cloud shadow speed** – Sets the speed that shadows move across the terrain\.
   + **Cloud shadow tiling** – Sets the tiling multiplier of the shadow texture\. 
   + **Cloud shadow brightness** – Sets the brightness level of the shadow\.
   + **Cloud shadow invert** – Enables inverting of the cloud shadow texture\.   
![\[Example CloudShadows parameters to create shadows for clouds.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/weather/weather-clouds-3d-shadows-2.png)