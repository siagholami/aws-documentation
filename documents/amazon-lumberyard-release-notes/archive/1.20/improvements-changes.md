# Improvements and Changes<a name="lumberyard-v1.20-improvements-changes"></a>

Lumberyard Beta 1.20 provides improvements and changes to Lumberyard systems and functionality.

**Topics**
+ [Animation Editor](#animation-improvements-changes-v1.20)
+ [Asset Pipeline](#asset-pipeline-improvements-changes-v1.20)
+ [Audio](#audio-improvements-changes-v1.20)
+ [Debugging](#debugging-improvements-changes-v1.20)
+ [Mobile](#mobile-improvements-changes-v1.20)
+ [PhysX](#physx-improvements-changes-v1.20)
+ [SDK Compatibility](#lumberyard-v1.20-highlights-compatible-sdk-versions)
+ [Miscellaneous](#miscellaneous-improvements-changes-v1.20)

## Animation Editor<a name="animation-improvements-changes-v1.20"></a>

The **Animation Editor** has the following improvements and changes:
+ You can now use motion extraction to move an actor in the game world without having to add a **PhysX Character Controller** component. Adding the **PhysX Character Controller** component is now optional. 
**Note**  
A **PhysX Character Controller** component is still required for the character to interact with entities in the world that have physics.

## Asset Pipeline<a name="asset-pipeline-improvements-changes-v1.20"></a>

The **Asset Pipeline** has the following improvements and changes.

### Shader Serialization Changes<a name="asset-pipeline-improvements-changes-v1.20-shader-serialization-changes"></a>

The function calls to `RT_ParseShader` no longer have to parse all `.cfx` and `.cfi` files to determine shader reflection information at runtime. `r_shadersExport` is now enabled by default in the `ShaderCacheGen.cfg` file. This causes `ShaderCacheGen` to now generate a binary `.fxb` file for each base shader type when you compile shader paks.

`RT_ParseShader` now has a code flow that depends on the value of `r_shadersImport` as follows:
+ `r_shadersImport=0` – All `.cfx` and `.cfi` files are parsed at runtime to determine shader reflection information. This setting is identical to the previous code and data flow in Lumberyard.
+ `r_shadersImport=1` – Imports preparsed shader reflection information from `.fxb` files if they exist for a related `.cfx` file. This skips the expensive parsing of `.cfx` files in `RT_ParseShader`. If an `.fxb` file exists for a shader but an individual permutation is missing, this setting falls back to slow `.cfx` file parsing for that permutation.
+ `r_shadersImport=2` – `.fxb` files are required for all shaders, and no fallback is allowed. Lumberyard doesn't parse `.cfx` or `.cfi` files at runtime.

**Note**  
If `r_shadersAllowCompilation=1` is set and `r_shadersImport=2`, `r_shadersAllowCompilation` takes precedence and turns off `r_shadersImport`. Because compiling new shaders can generate new `.fxb` files, this behavior is by design.
+ `r_shadersImport=3` – (New default) Based on your build configuration, the default setting makes a determination at runtime for how shader loading, parsing, and compiling behave. For Debug or Profile configurations, it compiles shaders. For Performance or Release builds, it runs optimally, as shown by the following equivalents:
  + For Debug or Profile builds, `r_shadersImport=3` uses the same setting as `r_shadersImport=0`.
  + For Performance or Release configurations, `r_shadersImport=3` uses the same setting as `r_shadersImport=1`.

**Workflow Changes**  
You should notice no changes if you use the following standard Lumberyard workflow:
+ For Debug or Profile builds, you generate shader permutations.
+ For Performance or Release builds, you use only precompiled shader pak files,

If you follow a different workflow for Performance and Release builds, be aware of the following points:
+ Performance and Release builds now disable runtime shader compilation by default. If you want to discover shader permutations at runtime in Performance and Release builds, use the `r_shadersImport=0` setting in your platform `system_*_*.cfg` files.
+ If you have custom scripts for building shader pak files, ensure that your scripts add the shader `.fxb` files that `ShaderCacheGen` now generates wherever the scripts include the compiled shader `.cfxb` and `.cfib` files.
+ Debug and Profile builds function identically to how they functioned in previous versions of Lumberyard, irrespective of whether you use loose shaders or shader paks.

## Audio<a name="audio-improvements-changes-v1.20"></a>

The audio system has the following improvements and changes:
+ Hooks for `AK::SoundEngine::Suspend` and `AK::SoundEngine::WakeFromSuspend` for mobile and console developers were added. For more information, see [Handling system-specific events](https://www.audiokinetic.com/library/edge/?source=SDK&id=workingwithsdks__system__calls.html) in the audiokinetic documentation.

## Debugging<a name="debugging-improvements-changes-v1.20"></a>

The `e_memoryProfiling` console variable displays onscreen statistics that show how much GPU memory is being used.

## Mobile<a name="mobile-improvements-changes-v1.20"></a>

You can now add a custom `AndroidManifest.xml` file, which will be merged into the final manifest that goes into the Android Package (APK). 

**To add a custom manifest to a module**

1. Place the custom `AndroidManifest.xml` file in your module. 

1. In the module's wscript file, specify a path to the custom manifest file.  
**Example**  

   ```
   android_manifest_path = [ <path_to_custom_manifest> ]
   ```

For an additional example of how to add a custom manifest, see the [Microphone Gem](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-microphone.html) topic in the *Amazon Lumberyard User Guide*.

## PhysX<a name="physx-improvements-changes-v1.20"></a>
+ The debug **Draw Collider** option for the **PhysX Collider** component is now on by default

## SDK Compatibility<a name="lumberyard-v1.20-highlights-compatible-sdk-versions"></a>

Lumberyard 1.20 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.4.34.3
+ Amazon GameLift Server SDK version 3.2.1

## Miscellaneous<a name="miscellaneous-improvements-changes-v1.20"></a>

The following APIs, systems, and tools are planned to be removed in a future release:
+ `CrySystem` (specifically, APIs that duplicate functionality in AzCore)
+ `CryEntitySystem` and `CryAction`
+ `CryScriptSystem`
+ `CryPhysics`
+ `CryAnimation`
+ `CryInput`
+ `CryAISystem`
+ Boids
+ Editor `CBaseObject `(including Cry prefabs, `CSelectionGroup` and related code)
+ AzCore: `DirectSocket`
+ Tools and Tooling
  + Woodpecker Tool (The Driller Visualizer)
  + Max and Maya Plugins (planned for replacement by FBX Pipeline)
  + Behavior Tree Editor
  + Legacy source control plugin
  + Statoscope integration
  + LiveMocap
  + Editor Plugins:
    + Asset Tagging
    + Editor Animation
    + Legacy Folder and QML view pane
+ PRT Library
+ CryEntityRemoval Gem
+ Legacy Feature Tests (`/dev/Code/FeatureTests/...`)