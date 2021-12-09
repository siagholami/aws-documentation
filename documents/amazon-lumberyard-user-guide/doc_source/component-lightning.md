# Lightning<a name="component-lightning"></a>

****  
This feature is in [preview](https://docs.aws.amazon.com/lumberyard/latest/userguide/ly-glos-chap.html#preview) release and is subject to change\. 

You can use the **Lightning** component to create a single lightning bolt effect\. In Lumberyard Editor, you can add the **Lightning** component to entities and trigger them later from Lua or Script Canvas\. For best results, use the **Lightning** component as part of a dynamic slice along with a spawning system\. After the **Lightning** component finishes its effect, the entity is automatically destroyed\. This makes it easier for you to spawn entities with a **Lightning** component, without needing manually to manage the lifetime of each entity\.

**Note**  
To enable the **Lightning** component, you must enable the Lightning gem\. For more information, see [Lightning Arc Gem](gems-system-gem-lightning-arc.md)\.

The **Lightning** component does not produce visual effects on its own\. The component schedules timings with a specified set of entities\. You can use the following components to create the lightning bolt effect:
+  **[Particle](component-particle.md)** component emitter to create the lightning bolt\.
+ A **Light** component for the dynamic lighting and shadowing\. You can use any of the light components, but the **[Point Light](component-point-light.md)** component is recommended\.
+ **[Sky Highlight](component-sky-highlight.md)** component for the bright flash in the sky\.
+ **[Audio Trigger](component-audio-trigger.md)** and **[Audio Proxy](component-audio-proxy.md)** components for the rumbling of thunder\.
+ The **Lightning** component to manage the lifetimes and intensities of the other entities to create a flash of lightning\.

**Example**  
The **Lightning** component randomly spawns in a small area\.  

![\[Add the Lightning component to your entity to enable lightning effects in your level.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/shared-lightning-component-animation-example.gif)

**Contents**
+ [Lightning Component Properties](#component-lightning-properties)
  + [Lightning Bolt](#component-lightning-bolt)
  + [SkyHighlight](#component-lightning-skyhighlight-)
  + [Light](#component-lightning-light-)
  + [Audio](#component-lightning-audio-)
+ [EBus Request Bus Interface](#component-lightning-ebus-request)
  + [StartEffect](#lightning-ebus-start-effect)
  + [SetStartOnActivate](#lightning-ebus-set-start-on-activate)
  + [GetStartOnActivate](#lightning-ebus-get-start-on-activate)
  + [SetRelativeToPlayer](#lightning-ebus-set-relative-to-player)
  + [GetRelativeToPlayer](#lightning-ebus-get-relative-to-player)
  + [SetLightningParticleEntity](#lightning-ebus-set-lightning-particle-entity)
  + [GetLightningParticleEntity](#lightning-ebus-get-lightning-particle-entity)
  + [SetLightEntity](#lightning-ebus-set-light-entity)
  + [GetLightEntity](#lightning-ebus-get-light-entity)
  + [SetSkyHighlightEntity](#lightning-ebus-set-sky-high-light-entity)
  + [GetSkyHighlightEntity](#lightning-ebus-get-sky-high-light-entity)
  + [SetAudioEntity](#lightning-ebus-set-audio-entity)
  + [GetAudioEntity](#lightning-ebus-get-audio-entity)
  + [SetSpeedOfSoundScale](#lightning-ebus-set-speed-of-sound-scale)
  + [GetSpeedOfSoundScale](#lightning-ebus-get-speed-of-sound-scale)
  + [SetLightRadiusVariation](#lightning-ebus-set-light-radius-variation)
  + [GetLightRadiusVariation](#lightning-ebus-get-light-radius-variation)
  + [SetLightIntensityVariation](#lightning-ebus-set-light-intensity-variation)
  + [GetLightIntensityVariation](#lightning-ebus-get-light-intensity-variation)
  + [SetParticleSizeVariation](#lightning-ebus-set-particle-size-variation)
  + [GetParticleSizeVariation](#lightning-ebus-get-particle-size-variation)
  + [SetLightningDuration](#lightning-ebus-set-lightning-duration)
  + [GetLightningDuration](#lightning-ebus-get-lightning-duration)
  + [Request Bus Example Script](#lightning-ebus-example-script)

## Lightning Component Properties<a name="component-lightning-properties"></a>

The **Lightning** component has the following properties:

**Start on Activate**  
Specifies whether lightning effects start when the **Light** component activates\.

**Relative to Player**  
Specifies whether the lightning effects are relative to the current active camera\. 

**Duration**  
Amount of time in seconds that the lightning strike lasts\.  
The particle effect lasts for the specified duration; the lighting effects can flash multiple times depending on how quickly the light intensity disappears\.

### Lightning Bolt<a name="component-lightning-bolt"></a>

The **Lightning** component has the following lightning bolt options:

**Particle Entity**  
\(Optional\) An entity with a **[Particle](component-particle.md)** component that creates a lightning bolt effect\. This particle can be emitted multiple times depending on the duration of the effect\.

**Size Variation**  
Specifies how much of the particle entity's global size parameter is randomly modified\. For more information, see [SetParticleSizeVariation](#lightning-ebus-set-particle-size-variation)\.

### SkyHighlight<a name="component-lightning-skyhighlight-"></a>

The **Lightning** component has following sky highlight options:

**Sky Highlight Entity**  
\(Optional\) An entity with a **Sky Highlight** component that creates a flash of light in the sky\. The properties of the **Sky Highlight** component are respected\.

### Light<a name="component-lightning-light-"></a>

The **Lightning** component has following light options:

**Light Entity**  
\(Optional\) An entity with a **Light** component that creates dynamic lightning\. The properties of the **Light** component are the same, but its intensity and radius are modified\.   
\(**[Point Light](component-point-light.md) is recommended\)**

**Radius Variation**  
Specifies how much the light's radius is randomly modified\. For more information, see [SetLightRadiusVariation](#lightning-ebus-set-light-radius-variation)\.

**Intensity Variation**  
Specifies how much the light's intensity is randomly modified\. For more information, see [SetLightIntensityVariation](#lightning-ebus-set-light-intensity-variation)\.

### Audio<a name="component-lightning-audio-"></a>

The **Lightning** component has following audio options:

**Audio Entity**  
An entity with the **[Audio Trigger](component-audio-trigger.md)** and **[Audio Proxy](component-audio-proxy.md)** components attached\. These components are required if you want to enable audio\. You can also add an optional **[Audio Rtpc](component-audio-rtpc.md)** component\. The audio components plays the audio, depending on the distance away from the listener\.

**Speed of Sound Scale**  
Specifies how long it takes for audio to arrive at the listener, in seconds\. For more information, see [SetSpeedOfSoundScale](#lightning-ebus-set-speed-of-sound-scale)\.

## EBus Request Bus Interface<a name="component-lightning-ebus-request"></a>

Use the following request functions with the EBus interface to communicate with other components of your game\. You can use this EBus to communicate to an entity with a **Lightning** component attached\. The EBus is available at game run time and editing and can be accessed from C\+\+, Lua, and the **Script Canvas** editor\.

For more information about using the event bus \(EBus\) interface, see [Working with the Event Bus \(EBus\) system](ebus-intro.md)\.

### StartEffect<a name="lightning-ebus-start-effect"></a>

Enables the lightning effect\.

**Parameters**  
None

**Return**  
None

**Scriptable**  
Yes

### SetStartOnActivate<a name="lightning-ebus-set-start-on-activate"></a>

Specify if the lightning effect starts when the **Lightning** component activates\.

**Note**  
This function is useful only during edit time\.

**Parameters**  
Type: Boolean

**Return**  
None

**Scriptable**  
Yes

### GetStartOnActivate<a name="lightning-ebus-get-start-on-activate"></a>

Returns `true` if the lightning effect starts when the **Lightning** component activates\.

**Parameters**  
None

**Return**  
Type: Boolean

**Scriptable**  
Yes

### SetRelativeToPlayer<a name="lightning-ebus-set-relative-to-player"></a>

Specify if the start of the lightning effect is relative to the player camera\.

**Parameters**  
Type: Boolean

**Return**  
None

**Scriptable**  
Yes

### GetRelativeToPlayer<a name="lightning-ebus-get-relative-to-player"></a>

Returns `true` if the start of the lightning effect is relative to the player camera\.

**Parameters**  
Type: Boolean

**Return**  
None

**Scriptable**  
Yes

### SetLightningParticleEntity<a name="lightning-ebus-set-lightning-particle-entity"></a>

Sets the entity that contains the **[Particle](component-particle.md)** component that is used for the lightning particle\.

The entity is destroyed when the effect finishes\.

**Parameters**  
Type: `AZ::EntityId`

**Return**  
None

**Scriptable**  
Yes

### GetLightningParticleEntity<a name="lightning-ebus-get-lightning-particle-entity"></a>

Returns the entity that contains the **[Particle](component-particle.md)** component\.

**Parameters**  
None

**Return**  
Type: `AZ::EntityId`

**Scriptable**  
Yes

### SetLightEntity<a name="lightning-ebus-set-light-entity"></a>

Sets the entity that contains the **Light** component, which is used for lightning effects\.

The entity is destroyed when the effect finishes\.

**Parameters**  
Type: `AZ::EntityId`

**Return**  
None

**Scriptable**  
Yes

### GetLightEntity<a name="lightning-ebus-get-light-entity"></a>

Returns the entity that contains the **Light** component\.

**Parameters**  
None

**Return**  
Type: `AZ::EntityId`

**Scriptable**  
Yes

### SetSkyHighlightEntity<a name="lightning-ebus-set-sky-high-light-entity"></a>

Sets the entity that has the **Sky Highlight** component for this effect\.

The entity is destroyed when the effect finishes\.

**Parameters**  
None

**Return**  
Type: `AZ::EntityId`

**Scriptable**  
Yes

### GetSkyHighlightEntity<a name="lightning-ebus-get-sky-high-light-entity"></a>

Returns the entity that has the **Sky Highlight** component\.

**Parameters**  
None

**Return**  
Type: `AZ::EntityId`

**Scriptable**  
Yes

### SetAudioEntity<a name="lightning-ebus-set-audio-entity"></a>

Sets the entity that has the audio component for this effect\.

To enable audio, the entity must have the **[Audio Trigger](component-audio-trigger.md)** and **[Audio Proxy](component-audio-proxy.md)** components and an optional **[Audio Rtpc](component-audio-rtpc.md)** component\. If an audio component is missing, the lightning effect may not work as expected\.

The entity is destroyed when the effect finishes\.

**Parameters**  
Type: `AZ::EntityId`

**Return**  
None

**Scriptable**  
Yes

### GetAudioEntity<a name="lightning-ebus-get-audio-entity"></a>

Returns the entity that has the audio component\.

**Parameters**  
None

**Return**  
Type: `AZ::EntityId`

**Scriptable**  
Yes

### SetSpeedOfSoundScale<a name="lightning-ebus-set-speed-of-sound-scale"></a>

Sets the speed of sound scale for this effect\. You can use this parameter if want the audio to take more or less time to reach the player and you don't want to move your lightning effect\.

**Note**  
Sound travels at 340\.29 meters per second\. A value of `0.5` makes sound from this effect take half as much time to reach the player\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetSpeedOfSoundScale<a name="lightning-ebus-get-speed-of-sound-scale"></a>

Returns the speed of sound scale for this effect\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetLightRadiusVariation<a name="lightning-ebus-set-light-radius-variation"></a>

Sets the amount of random variation to apply to the light's radius\.

This variation is a percentage of the light's radius\. A value of `0.2` means that between –20% and 20% of the light's radius value is added back to the light's radius\.

For example, the light radius is `5.0`, and variation is `0.2`; this means that the range of the light radius is: 5\.0 \+/– \(5\.0 \* 0\.2\) or 5\.0 \+/– 20% of 5\.0\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetLightRadiusVariation<a name="lightning-ebus-get-light-radius-variation"></a>

Returns the amount of random variation to apply to the light's radius\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetLightIntensityVariation<a name="lightning-ebus-set-light-intensity-variation"></a>

Sets the amount of random variation to apply the **Light** component's diffuse and specular multipliers\.

The **Light** component calculates the light intensity based on the duration of the lightning effect\. This value is a percentage of that light intensity value\. A value of `0.2` means that between –20% and 20% of the light intensity value is added back to the light's diffuse and specular multipliers\. 

For example, the light intensity is `10.0`, and variation is `0.3`; this means that the range of the light radius is: 10\.0 \+/– \(10\.0 \* 0\.3\) or 10\.0 \+/– 30% of 10\.0\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetLightIntensityVariation<a name="lightning-ebus-get-light-intensity-variation"></a>

Returns the amount of random variation to apply the light's diffuse and specular multipliers\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetParticleSizeVariation<a name="lightning-ebus-set-particle-size-variation"></a>

Sets the amount of random variation to apply to the particle's size\.

This variation is a percentage of the **[Particle](component-particle.md)** component's **Global size scale** parameter\. A value of `0.2` means that between –20% and 20% of the particle's global size value is added back to the size of the emitted particles\.

For example, the particle size is `1.0`, and variation is `0.5`; the range of the light radius is: 1\.0 \+/– \(1\.0 \* 0\.5\) or 1\.0 \+/– 50% of 1\.0\.

**Parameters**  
Type: Float

**Return**  
None

**Scriptable**  
Yes

### GetParticleSizeVariation<a name="lightning-ebus-get-particle-size-variation"></a>

Returns the amount of random variation to apply to the particle's size\.

**Parameters**  
None

**Return**  
Type: Float

**Scriptable**  
Yes

### SetLightningDuration<a name="lightning-ebus-set-lightning-duration"></a>

Sets how long the lightning strike lasts, in seconds\. This value determines how long the lightning particle effect lasts\. During this time, the sky highlight and light can continue to flash\.

**Parameters**  
Type: Double

**Return**  
None

**Scriptable**  
Yes

### GetLightningDuration<a name="lightning-ebus-get-lightning-duration"></a>

Returns how long the lightning strike lasts, in seconds\.

**Parameters**  
None

**Return**  
Type: Double

**Scriptable**  
Yes

### Request Bus Example Script<a name="lightning-ebus-example-script"></a>

```
function example:OnActivate()
    LightningComponentRequestBus.Event.StartEffect(self.entityId)
end
```