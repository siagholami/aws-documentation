# Saving Slice Changes<a name="using-slices-modify-push"></a>

If you modify one of the lamps you just placed, you can save the changes to all of the lamp slice instances\. This means, for example, that you can make one of the lamps larger; when you save that change, all the other placed lamps become larger as well\.

**To change the lamp's size and save the changes**

1. In the **Entity Outliner**, select one of the lamp slices\. Click the arrow icon to expand the parent entity\. This displays the entities in the slice\. In this lamp slice, there is only one entity\. Select the entity **gsg\_maze\_floodlight**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-slices-modify-push-select.png)

1. In the **Entity Inspector**, change the **Scale** values:
   + **x**: **1\.25**
   + **y**: **1\.25**
   + **z**: **1\.25**  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-slices-modify-push-scale.png)

1. In the **Entity Outliner**, select the parent node **Lamp**\. Right\-click, point to **Save slice overrides** and then choose **maze\_lamp\.slice**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/placing-slices-modify-push-push.png)

   Observe how all of the lamps are updated to the new scale\. The editor has saved this update to the slice, and all slice instances are automatically updated to reflect those changes\.

1. Press **Ctrl\+S** to save your level\.

1. Press **Ctrl\+G** to play your level\.

   Press **Esc** to quit\.

[Next: 5: Adding Enemy AI Characters](ai.md)