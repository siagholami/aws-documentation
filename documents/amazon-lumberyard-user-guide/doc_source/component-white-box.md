# White Box component<a name="component-white-box"></a>

****  
This feature is an [experimental](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#experimental) release and is subject to change\. 

The **White Box** component is a tool you can use to sketch 3D proxy meshes in Lumberyard Editor\. Add the **White Box** component to an entity, select a primitive shape to use as a basis for your proxy mesh, then enter edit mode to access the tools to quickly rough out a mesh for your entity\. 

![\[White Box component interface.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-A-1.25.gif)

Because **White Box** is implemented as a component, you can create well\-defined entities that accurately represent the size, shape, and function of the final production entity in Lumberyard Editor before investing the time and effort into building finished models for your entity\. Meshes created with **White Box** can be saved to disk as white box mesh assets \(`.wbm`\) and reused in other **White Box** components\. White box meshes can also be exported to `.obj` files and used as a template in a third\-party 3D modeling application to build final production assets\. 

**Topics**
+ [White Box properties](#component-white-box-properties)
+ [White Box edit mode](#component-white-box-edit-mode)

## White Box properties<a name="component-white-box-properties"></a>

![\[White Box component interface.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/ui-white-box-1.25.png)

****Default Shape****  
The default primitive shape of the white box mesh\. From the list you can select a primitive shape, or choose to load a saved white box mesh \(`.wbm`\) asset\. The default primitive size is one meter in world space\.   

**White Box default shapes:**
+ **Cube** 
+ **Tetrahedron** 
+ **Icosahedron** 
+ **Cylinder** 
+ **Sphere** 
+ **Custom Mesh Asset** 
When **Custom Mesh Asset** is selected, a **Mesh Asset** file field appears in the component interface below **Default Shape** that you can use to select a saved white box mesh \(`.wbm`\) asset\. 

****Save as asset****  
Save the proxy mesh to a white box mesh \(`.wbm`\) asset\. You can load the saved \(`.wbm`\) asset in other **White Box** components\. The `.wbm` file functions like an instance, and any changes made to the mesh propagate to all **White Box** components that use the `.wbm` file\.   

![\[White Box .wbm mesh instancing animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-mesh-instancing-1.25.gif)

****Tint****  
Set a tint color for the white box mesh\. Choose the swatch to open a color picker, or enter comma separated red, blue, and green 8\-bit values into the field to set a tint color for the **White Box** component\. 

****Use Texture****  
Enable **Use Texture **to display a checkerboard texture on the white box mesh\. Each square is a half meter in size, and the texture is projected on the local X, Y, and Z axes of the mesh\. This maintains an easy reference for the size of the proxy mesh, regardless of how the entity is oriented in the level\. 

****Visible****  
Enable **Visible** to make the white box mesh visible at runtime\. When you use White Box to create custom invisible collision meshes, disable the **Visible** property to hide the mesh at runtime\. 

****Edit****  
Choose this button to enter edit mode and modify the white box mesh\. For information on editing the white box mesh, see [White Box edit mode](#component-white-box-edit-mode)\. Choose this same button \(labeled **Done**\) to exit edit mode\. 

****Export****  
Export the mesh to a `.obj` file\. The `.obj` file can be loaded into a 3D modeling application and used as a template for creating the production mesh asset for the entity\. 

## White Box edit mode<a name="component-white-box-edit-mode"></a>

In edit mode, you can quickly sketch meshes for your entities in Lumberyard Editor by selecting and dragging the face, edge, and vertex components of the white box mesh\. To begin, add a **White Box** component to an entity, choose a default primitive shape in the **White Box** component interface, and choose **Edit** to enter edit mode\. 

### Move<a name="component-white-box-edit-move"></a>

****Move polygon****  

1. Hover over a polygon\.

1. Hold the left mouse button\.

1. Drag the polygon along its normal\.

![\[White Box move face animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-move-face-1.25.gif)

**Move edge**  

1. Hover over an edge\.

1. Hold the left mouse button\.

1. Drag the edge\.

![\[White Box move edge animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-move-edge-1.25.gif)

### Scale<a name="component-white-box-edit-scale"></a>

****Scale polygon****  

1. Select \(left click\) a polygon\.

1. Hover over one of the polygon's vertices\.

1. Hold the left mouse button\.

1. Drag the vertex toward or away from the center of the selected polygon\.

![\[White Box scale face animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-scale-face-1.25.gif)

****Scale edge****  

1. Select \(left click\) an edge\.

1. Hover over one of the edge's vertices\.

1. Hold the left mouse button\.

1. Drag the vertex along the length of the selected edge\.

![\[White Box scale edge animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-scale-edge-1.25.gif)

****Non\-uniform scale edge****  

1. Select \(left click\) an edge\.

1. Hover over one of the edge's vertices\.

1. Hold **Alt** and drag the vertex along the length of the selected edge\.

![\[White Box scale edge animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-non-uniform-scale-edge-1.25.gif)

### Extrude<a name="component-white-box-edit-extrude"></a>

****Extrude polygon****  

1. Hover over a polygon\.

1. Hold **Ctrl** and left mouse button\.

1. Drag the polygon along its normal\.

![\[White Box extrude face animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-extrude-face-1.25.gif)

****Extrude edge****  

1. Hover over an edge\.

1. Hold **Ctrl** and left mouse button\.

1. Drag the edge\.

![\[White Box extrude edge animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-extrude-edge-1.25.gif)

****Extrude scale****  

1. Select \(left click\) a polygon\.

1. Hover over one of the polygon's vertices\.

1. Hold **Ctrl** and left mouse button\.

1. Drag the vertex toward or away from the center of the selected polygon to scale\.

1. Hover over the selected polygon\.

1. Hold the left mouse button\.

1. Drag the polygon along its normal\.

![\[White Box extrude scale animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-extrude-scale-1.25.gif)

### Hide/Show edge<a name="component-white-box-hide-show-edge"></a>

****Hide an edge****  

1. Select \(left click\) an edge\.

1. Press **H**\.

![\[White Box hide edge animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-hide-edge-1.25.gif)

****Show edge****  

1. Hold **Ctrl** and **Shift** to show edges\.

1. Select \(left click\) an edge to unhide it\.

![\[White Box extrude edge animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-show-edge-1.25.gif)

### Hide/Show vertex<a name="component-white-box-hide-show-vertex"></a>

****Hide a vertex****  

1. Select \(left click\) a vertex\.

1. Press **H**\.

![\[White Box hide edge animation.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/whitebox/white-box-hide-vertex-1.25.gif)

****Show vertex****  

1. Hold **Ctrl** and **Shift** to show hidden vertices\.

1. Select \(left click\) a vertex to unhide it\.