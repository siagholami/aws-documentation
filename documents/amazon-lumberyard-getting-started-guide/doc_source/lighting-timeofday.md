# Changing the Time of Day<a name="lighting-timeofday"></a>

With the **Time of Day** editor, you can change the sun's position in the sky and set day or night\. 

1. Open the **Time of Day** editor by choosing **Tools**, **Other**, **Time Of Day**\.

1. At the bottom of the editor window is a section called **Timeline**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-1.png)

   Drag the handle to see the sun change positions and lighting\.

   The default setting is 12:00 noon\. In the following image the time is set to 6:00 a\.m\. In the image below that, the time is set to 3:00 p\.m\. Notice the differences in lighting\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-2.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-3.png)

1. For this tutorial, you set the time to 4:30 p\.m\. To do this, under **Time**, for **Current Time**, specify **4:30 PM**\. 

   This gives you a rosy sunset glow for your scene\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-4.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-5.png)

1. Because you changed the time of day, you should re\-render your environment probe map in keeping with best practices\. 

   To do this, in the **Entity Outliner**, select the **EnvironmentProbe** entity\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-6.png)

1. In the **Entity Inspector** on the **Environment Probe** component, under **Cubemap Generation**, next to **Cubemap**, click **Generate**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-7.png)

This ensures that your cubemap is rendered at the right time of day to get the best visual quality\. Small hour to hour increments are not very noticeable in terms of visual differences that occur with cube maps\. However, if you compare a 12:00 p\.m\. \(noon\) map with a 12:00 a\.m\. \(midnight\) map, you notice a significant change in the lighting\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/lighting-8.png)

[Next: Creating a Light Source](lighting-creating-light.md)