# Reference Space Model<a name="viewport-interaction-model-reference-space-model"></a>

You can use the Viewport Interaction Model to create reference spaces for your selected entities\. This enables you to customize your selected entities in relation to a reference space\. 

When working with reference spaces, remember the following rules:
+ New selections always default to their local space\.
+ Holding **Shift** dynamically changes the manipulator to operate in the parent's space\. Often, the parent of a selection is also the world\.
+ You can easily access custom spaces by moving the manipulator \(press **Ctrl** and click and drag\) or picking a target entity as a reference space \(press **Alt** and click a target entity\)\.

The Viewport Interaction Model simplifies the mental mode for you and doesn't require you to keep track manually of the last space \(local or world\) that you were using\. You can specify a target and define that target as custom reference spaces\. This new reference space model covers any arbitrary transformation\. 

## Switching Between Local and World Space<a name="viewport-interaction-model-local-parent-world"></a>

You can use the manipulator to switch between local and world space without losing focus of your entity selection in the viewport\.

**To switch between local and world space**

1. In the viewport, select a child entity that has a parent\. Your selection always defaults to local space\.

1. Use the manipulator to modify the entity\.

1. To switch to parent space, press and hold **Shift** and use the manipulator to modify the entity\. 
**Note**  
If you selected an entity that doesn't have a parent, your selection defaults to world space\.
Parent space is the transform that the parent entity has in the hierarchy\. If an entity doesn't have a parent, the entity uses world space instead\.  
**Example**  

   In the following example, the entity moves in the world space because the entire car moves in the viewport\. When you select the child entity \(the tire\), the manipulator switches to the local space for that entity in relation to its parent\.  
![\[Switch between local and parent space in the viewport in Lumberyard.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/viewportinteractionmodel/viewport-selection-model-1.gif)

   The following are shortcuts to work with the reference space mode\.  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/viewport-interaction-model-reference-space-model.html)

## Using Custom Reference Spaces<a name="custom-reference-spaces"></a>

You can adjust the manipulator independent of the entity to create a custom reference space\. You can also pick another target entity as a reference space\. When you specify a reference space, the entities that you select move in relation to that space\.

**To create a custom reference space**

1. In the viewport, select an entity\. 

1. Press and hold **Ctrl** and scroll the middle mouse button to select a manipulator mode, such as translation\.

1. Press and hold **Alt** and click a target entity in the viewport\. This matches the manipulator to the translation or orientation of the target entity\.  
**Example**  

   In the following example, the excavator entity becomes a reference space for the car\. When the manipulator moves the car, the car moves in relation to the reference space\.  
![\[Create a custom reference using another entity as a target in Lumberyard.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/viewportinteractionmodel/viewport-selection-model-4.gif)

1. Use the manipulator to modify the entity\.

   The following are shortcuts for working with custom reference spaces\.  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/viewport-interaction-model-reference-space-model.html)

**Note**  
The manipulator and the custom reference space are context\-based and apply only when you select an entity\. If you don???t select an entity, there???s no manipulator, and you can't create a reference space\. The reference space doesn't persist across selections\. However, if you move the reference space, you can undo that action\.