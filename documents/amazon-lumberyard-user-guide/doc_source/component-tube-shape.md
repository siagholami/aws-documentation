# Tube Shape<a name="component-tube-shape"></a>

****  
This feature is in [preview](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#preview) release and is subject to change\. 

Create tube\-like volumes along a spline by using the **Tube Shape** component\. To create a tube shape, add the **[Spline](component-spline.md)** component to an entity to define its shape\. In the **Tube Shape** component, define a radius to control its volume\. You can specify a different tube radius at each vertex in the spline\.

**Note**  
The **Tube Shape** component requires the **[Spline](component-spline.md)** component\.

**Topics**
+ [Tube Shape Properties](#tube-shape-properties)
+ [EBus Request Bus Interface](#tube-shape-ebus-request-bus-interface)

**Example Tube Shape Component**  

![\[Example Tube Shape component in Lumberyard Editor.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/shared-component-tube-shape-example.png)

## Tube Shape Properties<a name="tube-shape-properties"></a>

![\[The Tube Shape component and its properties in Lumberyard Editor.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/component-tube-shape.png)

The **Tube Shape** component has the following properties\.


****  

| Name | Description | 
| --- | --- | 
|  **Visible**  |  The component always appears in the viewport, even if the entity isn't selected\.  | 
| Game View |  Renders the shape in game mode\. To enter game mode, press **Ctrl \+ G**\.  | 
|  **Shape Color**  |  Specifies the color to render the shape\.  | 
|  **Radius**  |  The radius of the tube\.  | 
|  **Variable Radius**   | Defines the variable radius at each point along the spline\. This value is added to the radius to calculate the final radius of the tube\. | 
|  **Edit**  |  Choose **Edit**, and the component is locked for editing\. For more information, see [Editing Components in the Viewport](edit-mode-for-components.md)\.  | 

## EBus Request Bus Interface<a name="tube-shape-ebus-request-bus-interface"></a>

You can use the event bus \(EBus\) interface to communicate with other components in your game\. For more information, see [Working with the Event Bus \(EBus\) system](ebus-intro.md)\.


****  

| Request Name | Description | Parameter | Return | Scriptable | 
| --- | --- | --- | --- | --- | 
| GetRadius | Returns the radius of the tube\. | Void | Float | Yes  | 
| GetTotalRadius | Returns the total interpolated radius of the tube\. This is the sum of the radius and the variable radius\. | SplineAddress | Float | Yes | 
| GetVariableRadius | Returns the variable radius along the spline\. | Int | Float | Yes | 
| SetRadius | Sets the radius of the tube\. | Float | Void | Yes | 
| SetVariableRadius | Sets the variable radius of the tube at a spline point\. | Int, Float | Void | Yes | 

**Example**  
The following script uses the request bus interface\.  

```
function Script:OnActivate()
    TubeShapeComponentRequestsBus.Event.SetRadius(self.entityId, 5.0);  
end
```