# Placing Crates and Configuring Physics<a name="physics-placecrates"></a>

You use the **Asset Browser** to find the barrel and crates\. You drag them into your viewport and then add the **Mesh Collider** and **Rigid Body Physics** components to each, and then configure their density\. 

**To place crates and barrels**

1. In the **Asset Browser**, navigate to `StarterGame\Objects\ManMade\Props\Barrel`\. Drag `am_barrel_01.cgf` into the viewport\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-placecrates-assetbrowser.png)

1. In the **Entity Outliner**, select the barrel that you just placed\.

   In the **Entity Inspector**, in the **Transform** component's **Scale** box, set **Z** to **\.75**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-placecrates-transform.png)

1. In the **Asset Browser**, navigate to `StarterGame\Objects\ManMade\Props\Crate`\. Drag `am_crate_01.cfg` into the viewport\.

   Also drag `am_crate_long_01_group.cfg` into the viewport\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-placecrates-crates.png)

1. Add a **Mesh Collider** component and a **Rigid Body Physics** component to each of the barrel and crates you just placed\. And then set the **Rigid Body Physics** property **Density** to **15**\.

   To do this, perform the following for each of the three barrel and crates:

   1. In the **Entity Outliner**, select the barrel or crates\.

   1. In the **Entity Inspector**, click **Add Component**\. Select **Mesh Collider**\.

   1. In the **Entity Inspector**, click **Add Component**\. Select **Rigid Body Physics**\.

   1. In the **Entity Inspector**, in the **Rigid Body Physics** component, set the **Density \(kg/cubic meter\)** property to a value between **15** and **25**\.

      The **Density** value defines the object's weight and affects how much it rolls when struck by the player or weapon fire\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/physics-placecrates-density.png)

[Next: Stacking the Crates and Barrels to Make a Wall](physics-organize.md)