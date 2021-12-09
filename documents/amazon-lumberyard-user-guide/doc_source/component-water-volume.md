# Water Volume<a name="component-water-volume"></a>

****  
This feature is in [preview](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#preview) release and is subject to change\. 

You can use the **Water Volume** component to add small and medium bodies of water to your level\. Use the following properties to adjust the water volume's physical attributes, aesthetic, and complex interactions\.

To use the **Water Volume** component, you must enable the Water gem for your game project and then rebuild the project\. For more information, see [Enabling Gems](gems-system-using-project-configurator.md)\.

**Topics**
+ [Water Volume Component Properties](#component-water-volume-properties)
+ [EBus Request Bus Interface](#component-water-volume-request-bus-interface)
+ [Setting up Volume to Spill](#water-volume-setup-spill)
+ [Setting up Wave Simulation](#water-volume-setup-wave-simulation)

## Water Volume Component Properties<a name="component-water-volume-properties"></a>

The **Water Volume** component has the following properties:

**Material**  
Specifies the water material to use\. The material must have the **Water** shader added\.

**Minimum Spec**  
Sets the minimum engine specification for the volume to render\.  
Default: Low

**Surface U Scale**  
Specifies how much to tile the water surface texture on the u\-axis\.  
Default: `1.0`  
Range: `0.0` to `∞` \(infinity\)

**Surface V Scale**  
Specifies how much to tile the water surface texture on the v\-axis\.  
Default: `1.0`  
Range: `0.0` to `∞`

**View Distance Multiplier**  
Adjusts the maximum view distance\. The default value is 1\.0\. To specify a maximum view distance that is 10% further than the default, use 1\.1\.  
Default: `1.0`  
Range: `0.0` to `∞`Fog

**Density**  
Sets the density of the water fog\.  
Default: `0.5`  
Range: `0.0` to `∞`

**Color**  
Sets the color of the water fog\.  
Default: Deep blue \(RGB 0\.005, 0\.01, 0\.02\)

**Color Multiplier**  
Multiplies this value by the **Color** parameter to produce the final fog color\.  
Default: `1.0`  
Range: `0.0` to `∞`

**Color Affected by Sun**  
Determines whether the sky color affects the water's fog color\. This property is useful for outdoor water volumes\.  
Default: True

**Shadowing**  
Specifies how much shadows affect the water's fog color\.  
Default: `0.5`  
Range: `0.0` to `1`

**Cap at Volume Depth**  
Determines whether fog is rendered when the player is under the volume\.  
Default: FalseCaustics

**Enabled**  
Enables water caustics\.  
Default: True

**Intensity**  
Affects the brightness and visibility of caustics\.  
Default: `1.0`  
Range: `0.0` to `∞`

**Tiling**  
Affects the number of caustics that are rendered\.  
Default: `1.0`  
Range: `0.0` to `∞`

**Height**  
Determines how far above the surface caustics are rendered\.  
Default: `0.5`  
Range: `0.0` to `∞`Advanced

**Spillable Volume**  
Specifies the volume quantity that can spill into a container below\.  
Default: `0.0`  
Range: `0.0` to `∞`

**Volume Accuracy**  
Specifies the accuracy of the surface level of the spilled volume\.  
Default: `0.001`  
Range: `0.0` to `∞`

**Extrude Border**  
Specifies the border amount to add to the spilled volume\.  
Default: `0.0`  
Range: `0.0` to `∞`

**Convex Border**  
Determines whether the convex hull of the container should be considered\.  
Default: false

**Object Size Limit**  
Sets the minimum volume that an object must have to affect the water surface\.  
Default: `0.001`  
Range: `0.0` to `∞`Wave Simulation

**Surface Cell Size**  
Specifies the size of wave simulation cells\.  
Default: `0.0`  
Range: `0.0` to `∞`

**Speed**  
Specifies how fast each wave moves\.  
Default: `100.0`  
Range: `0.0` to `∞`

**Dampening**  
Specifies how much dampening force to apply during simulation\.  
Default: `0.2`  
Range: `0.0` to `∞`

**Timestep**  
Specifies the frequency of wave simulation ticks\.  
Default: `0.02`  
Range: `0.0` to `∞`

**Sleep Threshold**  
Sets the lowest velocity for a cell to rest\.  
Default: `0.01`  
Range: `0.0` to `∞`

**Depth Cell Size**  
Specifies the size of the depth cell\.  
Default: `8.0`  
Range: `0.0` to `∞`

**Height Limit**  
Sets the highest and lowest heights that the surface can be deformed\.  
Default: `7.0`  
Range: `0.0` to `∞`

**Force**  
Specifies the strength of the wave force\.  
Default: `10.0`  
Range: `0.0` to `∞`

**Simulation Area Growth**  
Adds space if the water simulation causes expansion\.  
Default: `0.0f`  
Range: `0.0` to `∞`

## EBus Request Bus Interface<a name="component-water-volume-request-bus-interface"></a>

Use the following request functions with the EBus interface to communicate with other components of your game\. You can use this EBus to communicate to an entity with a **Water Volume** component attached\. The EBus is available at game time and editing and can be accessed from C\+\+, Lua, and the **Script Canvas** editor\.

For more information about using the event bus \(EBus\) interface, see [Working with the Event Bus \(EBus\) system](ebus-intro.md)\.

### SetSurfaceUScale<a name="water-volume-ebus-setsurfaceuscale"></a>

Sets how much to tile the surface texture horizontally \(u\-axis of the UV map\)\. The surface texture is often defined as a bump or normal map\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetSurfaceUScale<a name="water-volume-ebus-getsurfaceuscale"></a>

Returns how much to tile the surface texture horizontally \(u\-axis of the UV map\)\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetSurfaceVScale<a name="water-volume-ebus-setsurfacevscale"></a>

Sets how much to tile the surface texture vertically \(v\-axis of the UV map\)\. The surface texture is often defined as a bump or normal map\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetSurfaceVScale<a name="water-volume-ebus-getsurfacevscale"></a>

Returns how much to tile the surface texture vertically\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetFogDensity<a name="water-volume-ebus-setfogdensity"></a>

Sets the density of the underwater fog in the volume\. A lower value produces clearer water, and a higher value produces murkier water\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetFogDensity<a name="water-volume-ebus-getfogdensity"></a>

Returns the fog density in the water volume\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetFogColor<a name="water-volume-ebus-setfogcolor"></a>

Sets the color of the underwater fog in the volume\. The **FogColorMultiplier** parameter modifies the fog color before rendering\.

**Parameters**  
`AZ::Color`

**Return**  
None

**Scriptable**  
Yes

### GetFogColor<a name="water-volume-ebus-getfogcolor"></a>

Returns the color of the underwater fog in the volume\. The **FogColorMultiplier** parameter does not affect the returned value\.

**Parameters**  
None

**Return**  
`AZ::Color`

**Scriptable**  
Yes

### SetFogColorMultiplier<a name="water-volume-ebus-setfogcolormultiplier"></a>

Sets the value to multiply with the **FogColor** parameter before rendering\. A higher value produces brighter underwater fog\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetFogColorMultiplier<a name="water-volume-ebus-getfogcolormultiplier"></a>

Returns the value to multiply with the **FogColor** parameter before rendering\.

**Parameters**  
None

**Return**  
Type: float

**Scriptable**  
Yes

### SetFogColorAffectedBySun<a name="water-volume-ebus-setfogcoloraffectedbysun"></a>

Sets whether the sun affects the underwater fog in the volume\. If true, the **SunColor** value affects the fog color\. You can set the **SunColor** in the **Time of Day Editor**\. For outdoor water volumes, use true\. For indoor water volumes, use false\.

**Parameters**  
Type: Boolean

**Return**  
None

**Scriptable**  
Yes

### GetFogColorAffectedBySun<a name="water-volume-ebus-getfogcoloraffectedbysun"></a>

Returns whether the sun affects the underwater fog in the volume\.

**Parameters**  
None

**Return**  
Type: Boolean

**Scriptable**  
Yes

### SetFogShadowing<a name="water-volume-ebus-setfogshadowing"></a>

Sets the strength of the shadows that fall on the water volume\. If 0\.0, shadows have no effect on the water volume\. If 1\.0, a dark shadow falls on the water volume\. You must set `r_FogShadowsWater` to 1 for the parameter to have any effect\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

**Valid values**  
`0.0` to `1.0`

### GetFogShadowing<a name="water-volume-ebus-getfogshadowing"></a>

Returns the strength of the shadows that fall on the water volume\. Valid values are 0\.0 to 1\.0\. However, this property returns the value for the **FogShadowing** parameter, regardless of the valid range\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetCapFogAtVolumeDepth<a name="water-volume-ebus-setcapfogatvolumedepth"></a>

Sets whether the underwater fog effect caps at the volume depth\. If false, underwater fog renders despite the distance of the camera below the water volume\.

**Parameters**  
Type: Boolean

**Return**  
None

**Scriptable**  
Yes

### GetCapFogAtVolumeDepth<a name="water-volume-ebus-getcapfogatvolumedepth"></a>

Returns whether the underwater fog effect caps at the volume depth\.

**Parameters**  
None

**Return**  
Type: Boolean

**Scriptable**  
Yes

### SetCausticsEnabled<a name="water-volume-ebus-setcausticsenabled"></a>

Sets whether the water volume produces caustics\. You must set `r_WaterVolumeCaustics` to 1 for the water caustic settings to have any effect\. To display caustics, set the water volume to a world height of 1 or higher\.

**Parameters**  
Type: Boolean

**Return**  
None

**Scriptable**  
Yes

### GetCausticsEnabled<a name="water-volume-ebus-getcausticsenabled"></a>

Returns whether the water volume produces caustics\.

**Parameters**  
None

**Return**  
Type: Boolean

**Scriptable**  
Yes

### SetCausticIntensity<a name="water-volume-ebus-setcausticintensity"></a>

Sets the intensity of the caustics for the water volume\. This property scales the normal map when rendering to the caustic map to produce a stronger caustic effect\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetCausticIntensity<a name="water-volume-ebus-getcausticintensity"></a>

Returns the intensity of the caustics for the water volume\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetCausticTiling<a name="water-volume-ebus-setcaustictiling"></a>

Sets a multiplier to use for tiling the water volume's caustics\. This value is multiplied with the tiling that's applied to the surface normals\. You can then scale the caustic tiling separately from the material\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetCausticTiling<a name="water-volume-ebus-getcaustictiling"></a>

Returns the value that is multiplied to the surface's normal tiling during caustic generation\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetCausticHeight<a name="water-volume-ebus-setcausticheight"></a>

Sets the allowable height to cast caustics above the water's surface\. If 0\.0, caustics render only beneath the water's surface\. If you use a value greater than 0, caustics can cast on nearby surfaces that are not in the water volume\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetCausticHeight<a name="water-volume-ebus-getcausticheight"></a>

Returns the allowable height to cast caustics above the water's surface\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetSpillableVolume<a name="water-volume-ebus-setspillablevolume"></a>

Sets how much volume can spill\. Volumes can spill into a container but cannot spill onto terrain\. A higher value allows more of the container volume to fill with water\. If greater than 0, the water volume raycasts onto nearby geometry and attempts to spill into it\. The geometry must have a concave mesh on a mesh component\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetSpillableVolume<a name="water-volume-ebus-getspillablevolume"></a>

Returns how much volume can spill\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetVolumeAccuracy<a name="water-volume-ebus-setvolumeaccuracy"></a>

Sets the accuracy of the water level for the spilled water volume\. The water level for spilled volume is iteratively calculated until the value is within the distance to the water level expected by the water volume\. A higher value requires more iterations to calculate the water level\. If 0\.0, the water level iterations will reach a hard\-coded limit of 100 iterations\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetVolumeAccuracy<a name="water-volume-ebus-getvolumeaccuracy"></a>

Returns the accuracy of the water level for the spilled water volume\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetExtrudeBorder<a name="water-volume-ebus-setextrudeborder"></a>

Sets how much to increase the border of the water volume when spilled\. If 0, wave simulation may cause the open edges of a water volume's surface to be visible\. This is useful for wave simulation\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetExtrudeBorder<a name="water-volume-ebus-getextrudeborder"></a>

Returns how much to increase the border of the water volume when spilled\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetConvexBorder<a name="water-volume-ebus-setconvexborder"></a>

Sets whether the water volume should look for a convex border when spilling\. This is useful if the volume spills into a container that has multiple contours\. Because water volumes don't support multiple contours, this property uses logic to break the volume into multiple volumes that can fit the contoured container\.

**Parameters**  
Type: Boolean

**Return**  
None

**Scriptable**  
Yes

### GetConvexBorder<a name="water-volume-ebus-getconvexborder"></a>

Sets whether the water volume should look for a convex border when spilling\.

**Parameters**  
None

**Return**  
Type: Boolean

**Scriptable**  
Yes

### SetObjectSizeLimit<a name="water-volume-ebus-setobjectsizelimit"></a>

Sets the minimum volume that is required for an object to experience volume displacement\. Objects that have a volume that is smaller than this value will not deform the surface\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetObjectSizeLimit<a name="water-volume-ebus-getobjectsizelimit"></a>

Returns the minimum volume that is required for an object to experience volume displacement\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetWaveSurfaceCellSize<a name="water-volume-ebus-setwavesurfacecellsize"></a>

Sets the size of each wave simulation cell\. The number of wave simulation cells is determined by the size of the volume and the individual size of the cells\. This affects the water surface mesh\.
+ A large water volume with a small cell size produces a high number of cells and a large, complicated surface mesh\. This type of mesh can make it difficult to evaluate wave simulation, unless you tune other parameters\.
+ A small water volume with a large cell size produces a low number of cells and a small, simple surface mesh\.

Use the `p_draw_helpers a_g` console variable to see the tessellated surface mesh\. You may need to move the editor's viewport camera closer to the volume for the mesh to render\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetWaveSurfaceCellSize<a name="water-volume-ebus-getwavesurfacecellsize"></a>

Returns the size of each wave simulation cell\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetWaveSpeed<a name="water-volume-ebus-setwavespeed"></a>

Sets how fast the waves move\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetWaveSpeed<a name="water-volume-ebus-getwavespeed"></a>

Returns how fast the waves move\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetWaveDampening<a name="water-volume-ebus-setwavedampening"></a>

Sets how much to dampen the wave simulation\. A higher value produces waves that lose velocity more quickly\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetWaveDampening<a name="water-volume-ebus-getwavedampening"></a>

Returns how much to dampen the wave simulation\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetWaveTimestep<a name="water-volume-ebus-setwavetimestep"></a>

Sets how often the wave simulation ticks\. A lower value produces frequent simulation ticks, which resolves a simulation quickly\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetWaveTimestep<a name="water-volume-ebus-getwavetimestep"></a>

Returns how often the wave simulation ticks\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetWaveSleepThreshold<a name="water-volume-ebus-setwavesleepthreshold"></a>

Sets the minimum velocity that is required for a cell to sleep\. A cell is at rest and no longer applies force to its neighbors when the velocity reaches this threshold\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetWaveSleepThreshold<a name="water-volume-ebus-getwavesleepthreshold"></a>

Returns the minimum velocity that is required for a cell to sleep\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetWaveDepthCellSize<a name="water-volume-ebus-setwavedepthcellsize"></a>

Sets the size of each depth cell in a wave simulation\. The number of wave simulation cells is determined by the size of the volume and the individual size of the cells\. A smaller cell size produces more depth cells and an intensive wave simulation\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetWaveDepthCellSize<a name="water-volume-ebus-getwavedepthcellsize"></a>

Returns the size of each depth cell in a wave simulation\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetWaveHeightLimit<a name="water-volume-ebus-setwaveheightlimit"></a>

Sets the height and depth limit for generated waves\. A height limit of 3 means the cell deforms up three units and down three units\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetWaveHeightLimit<a name="water-volume-ebus-getwaveheightlimit"></a>

Returns the height and depth limit for generated waves\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetWaveForce<a name="water-volume-ebus-setwaveforce"></a>

Sets the amount of force that wave simulation cells apply to each other\. A low wave force produces high resistance between cells\. A high wave force produces less resistance and transmits more energy between cells\. More transmitted energy results in larger, more pronounced waves\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetWaveForce<a name="water-volume-ebus-getwaveforce"></a>

Returns the amount of force that wave simulation cells apply to one another\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetWaveSimulationAreaGrowth<a name="water-volume-ebus-setwavesimulationareagrowth"></a>

Sets the size boundary to add to a simulation area\. This determines where the water volume simulation can move and grow outside the initial defined area\. Increase the variable to add the size boundary to the simulation area\. The `p_draw_helpers a_gj` console variable draws the wave simulation area as a checkerboard height field\.

**Parameters**  
None

**Return**  
None

**Scriptable**  
Yes

### GetWaveSimulationAreaGrowth<a name="water-volume-ebus-getwavesimulationareagrowth"></a>

Returns the size boundary to add to a simulation area\.

**Parameters**  
None

**Return**  
None

**Scriptable**  
Yes

### Example Water Volume Component Request Bus<a name="water-volume-ebus-example-script"></a>

```
function example:OnActivate
    local waveForce = WaterVolumeComponentRequestBus.Event.GetWaveForce(self.entityId)
    WaterVolumeComponentRequestBus.Event.SetWaveForce(self.entityId, waveForce * 10)
end
```

## Setting up Volume to Spill<a name="water-volume-setup-spill"></a>

You can set water volumes to spill into container volumes\. If the **Spillable Volume** parameter is a value above 0, the volume raycasts down and searches for a suitable container to spill into\. This includes any mesh component with a concavity\. A higher value for the **Spillable Volume** parameter produces a higher water level in the target container\.

The spilled water volume behaves similarly to the source water volume and can simulate waves\. The spilled volume is calculated iteratively, and the **Volume Accuracy** parameter determines the accuracy of the water level\. Spilled water volumes are calculated once and should not incur a per\-frame performance penalty due to volume calculation\.

The following image shows water volume above a pool that does not allow spilling\.

![\[Example Water Volume component with water that does not spill.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/water-volume-pool-no-spill.png)

The following image shows the water volume spilling 100 units into the pool\.

![\[Example Water Volume component with water spilling at 100 units into the pool.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/water-volume-pool-100-units-spill.png)

The following image shows the water volume spilling 1000 units into the pool\.

![\[Example Water Volume component with water spilling at 1000 units into the pool.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/component/water-volume-pool-1000-units-spill.png)

## Setting up Wave Simulation<a name="water-volume-setup-wave-simulation"></a>

You can use wave simulation to create the appearance of the water surface reacting to physical forces\. This feature does not simulate ocean waves\. Because wave simulation is an expensive task, consider the performance impact before you enable this feature\.

To enable wave simulation on a water volume, set the **Surface Cell Size** parameter to a value above 0\. For smaller water volumes, you can use a value of 2 or 3\. A smaller cell size produces more cells and a longer evaluation time for the simulation\.

Even without wave simulation the **Water** shader deforms the surface mesh to make the water appear in motion\.