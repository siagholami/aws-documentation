# Terrain FAQs<a name="terrain-troubleshoot"></a>

See the following troubleshooting tips to resolve issues for your Lumberyard terrains\.


****  

| Issue | Workaround or Fix | 
| --- | --- | 
|  I expected to create a 2k world, but the **Terrain Editor** shows tiles that are sized 512 in a 2x2 grid\. What does this mean?  |  512 describes the number of megatexels per tile and is the default resolution for new levels in Lumberyard\. With a 2x2 grid, you have a total of four tiles\. If you add up all of the megatexels from all of the tiles, it adds up to 2k \(2048 megatexels\)\. To increase your tiles' resolution, see [Creating High Quality Terrain](terrain-high-quality.md)\.  | 
|  What does the resolution \(512x512, 1024x1024, 2048x2048\) mean in terms of the 2k height and the 16k size of the megaterrain?  |  The heightmap is independent of the megaterrain texture\. The resolution displayed in the **Export/Import Megaterrain Texture** dialog is the color megatexel resolution for that tile\.  | 
|  What is the optimal resolution for imported splat maps?  |  You should match the heightmap resolution for your splat map resolutions\.  | 
|  Why does the visual quality get blurry after generating terrain textures? It seems that sectors start fetching mips at various resolutions, making it difficult to determine what it looks like\.   |  Lumberyard uses a texture pool for terrain textures\. Its default is set to retain 64 textures at any given time, with each texture measuring 256x256\. Consider that a 16k x 16k texture actually contains 5461 individual textures\. By default, Lumberyard doesn't keep enough textures in resident memory at any given time to present a clear image\. You can increase the texture pool size using the `e_TerrainTextureStreamingPoolItemsNum` console variable\. The maximum value is `4096`\.  You can set this console variable in the `level.cfg` or `project.cfg` file\. You must set the console variable in one of these files because the value must be present when the system loads\. Changes made during runtime don't affect this console variable\. For more information, see [Using the Console Window](console-intro.md)\.  | 
|  How are terrain layer materials applied to the terrain? What does the **detail repeat** property do?  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/terrain-troubleshoot.html)  | If you author a terrain detail material as a 2m patch, then set the **TileU** and **TileV** in the material to `0.5`, the terrain covers 2m\. The shader calculates UV coordinates from world space\. Data is passed into the terrain shader that tells it the x\-y offset and scale for the texture UVs\. The shader then uses that to transform the world space coordinate into a UV coordinate\. | 