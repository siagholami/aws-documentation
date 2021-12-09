# Placing a Global Environment Probe<a name="lighting-environment-probe"></a>

When you place a global environment probe, the first thing you notice is that the shadows cast by objects look softer and contrast less with the environment\. 

**To place an environment probe**

1. In the viewport near the center of the level, close to the maze, right\-click and choose **Create entity**\.

1. In the **Entity Inspector**, name the entity **EnvironmentProbe**\.

1. In the **Entity Inspector**, click **Add Component**\. Under **Rendering**, click **Environment Probe**\.

1. In the environment probe's settings, modify the following values for the **Area dimensions**\. Area dimensions control the size of the volume where lighting is applied\.
   + **X**: **512**
   + **Y**: **512**
   + **Z**: **300**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-environment-probe-settings.png)

1. Under **Cubemap generation**, click **Generate**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-environment-probe-generate.png)

1. Press **Ctrl\+S** to save your level\.

[Next: Changing the Time of Day](lighting-timeofday.md)