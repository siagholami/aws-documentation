# Importing a Megaterrain Texture<a name="importing-mega-terrain"></a>

In this tutorial, you import a megaterrain texture\. A megaterrain texture is a diffuse texture that covers the entire terrain\. This texture is visible from a distance and presents sweeping vistas\. As the camera moves closer to the terrain, the megaterrain texture is replaced by more detailed terrain textures\. 

**Note**  
A missing `FTUE_MegaTexture_02.bmp` file is available to download [here](https://dvbcuh49skxb5.cloudfront.net/releases/1.12/FTUE_MegaTexture_02.bmp)\. Right\-click and save the mega terrain texture file to the `/dev/StarterGame/Textures/Terrain` directory\.

**To import a megaterrain texture**

1. If **Terrain Editor** is not open, open it by choosing **Tools**, **Terrain Editor**\.

1. Choose **Tools**, **Export/Import Megaterrain Texture**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/importing-mega-terrain-tools.png)

1. Beneath **Select Tiles**, click the heightmap image\. The box turns gray\.

   Click **Import**\.
**Note**  
Only one tile exists\. This is a result of setting the initial tesselation, or **Meters per Texel** setting, to **1** when you created the level\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/importing-mega-terrain-tile.png)

1. Navigate to `\dev\StarterGame\Textures\Terrain` and select `FTUE_MegaTexture_02.bmp`\. Click **Open**\.
**Note**  
If you cannot locate this file, see the introduction to this procedure\.

   Lumberyard takes a few moments to generate the texture on the terrain\.

1. Click **Close** in the **Export/Import Megaterrain** window\.

   Close the **Terrain Editor**\.

   Observe that your terrain now has shades of green and brown to represent grass and soil, as well as shadows to give the landscape realism\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/images/importing-mega-terrain.png)

1. Press **Ctrl\+S** to save your level\.

[Next: Placing the Player Character](placing-character-controller.md)