# Actions<a name="animation-editor-actions"></a>

You can use actions to trigger parameter value changes when an animation graph state or transition reaches a specified state\.

You can set the **Parameter Action** on the following:

**State**  

**Set actions to trigger upon:**
+ Entering a state – Action triggers when the state is fully blended into the node and is no longer in transition
+ Exiting a state – Action triggers when the state is fully blended out of the node and the node is no longer active

**Transition**  

**Set actions to trigger upon:**
+ Entering a transition – Action triggers immediately upon starting a transition
+ Exiting a state – Action triggers when a transition is fully blended to the target state

## Adding Actions to a State<a name="adding-action-to-state"></a>

Add an action to a state to achieve a parameter value change that triggers after the state is either fully blended into the node or fully blended out of the node\.

**To add an action to a state**

1. In the **Animation Editor**, open or create an animation graph\.

1. Select a node\.  
![\[Select a node.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/char-animation-editor-actions-node.png)

1. In the **Attributes** panel, click **Add action** and then **Parameter Action**\.  
![\[To add a Parameter Action, click Add action and then Parameter Action.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/char-animation-editor-actions-addaction-node.png)

1. In the **Attributes** panel, under **Parameter Action**, select a **Trigger Mode**\. You can select one of the following options:
   + **On Enter** – Executes a **State** action when the state is fully blended into the node and is no longer in transition
   + **On Exit** – Executes a **State** action when the state is fully blended out of the node and the node is no longer active  
![\[For the Trigger Mode, select On Enter or On Exit.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/char-animation-editor-actions-triggermode.png)

1. Choose **Select parameter** and select your preferred parameter\.

   The selected parameter name replaces the text in the **Select parameter** box\.  
![\[Choose Select parameter and select a parameter. The parameter name replaces the text in the Select parameter box.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/char-animation-editor-actions-selectaction.png)

1. To turn the action on, set the **Trigger Value** to `1`\.

## Adding Actions to a Transition<a name="adding-action-to-transition"></a>

Add an action to a transition to achieve a parameter value change that triggers either when the transition starts or when the transition is fully blended to the target state\.

**To add an action to a transition**

1. In the **Animation Editor**, open or create an animation graph\.

1. Select a transition\.  
![\[Select a transition.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/char-animation-editor-actions-transition.png)

1. In the **Attributes** panel, click **Add action** and then **Parameter Action**\.  
![\[To add a Parameter Action, click Add action and then Parameter Action.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/char-animation-editor-actions-addaction-transition.png)

   The following options trigger the change on a servant graph but with different inputs to the servant graph's parameter:
   + **Servant Parameter Action** – A constant value is provided
   + **Symbolic Servant Parameter Action** – A user\-selected value is provided

1. In the **Attributes** panel, under **Parameter Action**, select a **Trigger Mode**\. You can select one of the following options:
   + **On Enter** – Executes the action immediately upon starting a transition
   + **On Exit** – Executes the action when a transition is fully blended to the target state  
![\[For the Trigger Mode, select On Enter or On Exit.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/char-animation-editor-actions-triggermode.png)

1. Choose **Select parameter** and select your preferred parameter\.

   The selected parameter name replaces the text in the **Select parameter** box\.  
![\[Choose Select parameter and select a parameter. The parameter name replaces the text in the Select parameter box.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/char-animation-editor-actions-selectaction.png)

1. To turn the action on, set the **Trigger Value** to `1`\.
**Note**  
When you set a trigger on a transition, a square appears on the transition line, which represents the action\.  

![\[Visual representation of an action set on a transition.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/actor-animation/char-animation-editor-actions-square.png)