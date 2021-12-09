# Amazon Lumberyard Release Notes: Improvements and Changes in Beta 1.22 (December 2019)

Lumberyard Beta 1.22 provides improvements and changes to Lumberyard systems and functionality.

**Topics**
+ [Asset Pipeline](#Pipeline-improvements-changes-v1.22)
+ [Audio](#audio-improvements-changes-v1.22)
+ [AWS Native SDK Updated](#SDK-improvements-changes-v1.22)
+ [Large Worlds](#Worlds-improvements-changes-v1.22)
+ [Mobile](#mobile-improvements-changes-v1.22)
+ [Networking](#network-improvements-changes-v1.22)
+ [Platform](#platform-improvements-changes-v1.22)
+ [PhysX](#physx-improvements-changes-v1.22)
+ [Python Support](#python-improvements-changes-v1.22)
+ [Systems](#systems-improvements-changes-v1.22)
+ [Twitch Commerce SDK](#Twitch-improvements-changes-v1.22)
+ [Visual Studio 2017](#VS-improvements-changes-v1.22)
+ [Miscellaneous](#misc-improvements-changes-v1.22)

## Asset Pipeline<a name="Pipeline-improvements-changes-v1.22"></a>

### New Features

**Asset Bundler** 

A command line tool to bundle game assets for release. The following are additional new features that support Asset Bundling:
+ Asset Validation Gem: Use this Gem to run your game exclusively from Asset Bundles.
+ Product Dependency System: Builders now generate product dependencies, including copy jobs. Product dependencies are the backbone of asset bundling and allow the Asset Bundler to evaluate an asset, and determine all other dependent assets.
+ Missing Dependency Scanner: Use this tool to identify potential missing product dependencies.
+ XML Schema System: A framework for defining dependencies for XML files.
+ Asset Tagging System - File Tagging System: This system provides a way to "tag" an asset as a certain type, such as "editor-only", "shader" or "ignore product dependencies." Tags are then used by the Missing Dependency Scanner and other tools.

**Delta Catalogs** 

.pak files (paks) now contain smaller versions of AssetCatalog.xml that live within a .pak and describe only the files within that pak.  At run time when opening a new pak file through CryPak, the system will automatically search for a delta catalog within the pak and, if found, update the asset registry with the information within that pak file layered over the old data (You can add new assets or update old assets).

### Improvements

**Asset Processor**

+ Asset Processor Timer: The Asset Processor now displays 3 timers: Last Scan, Analysis, and Processing.  Each timer represents the amount of time the Asset Processor spent in each of those three phases.
+ Improved Error File Visibility: Made asset warnings more visible in the Asset Processor.
+ Added folders for platform-specific AssetProcessorPlatformConfig.ini to separate generic vs platform-specific configs.
+ Performance improvements.

**Stale File Load Cleanup** 

+ Removed some unnecessary calls that were loading deprecated files.

**Copy Dependency Builder**

+ Some copy jobs that were previously defined in AssetProcessorPlatformConfig.ini have been removed. In their place, we have a new CopyDependencyBuilder that performs the same copy to the cache. This CopyDependencyBuilder also examines the assets it copies for product dependencies, emitting what it finds.

**Gems version**

Some of the Gems included with Lumberyard have new versions. To update:

+ Populate the app descriptors (see the command on this page https://docs.aws.amazon.com/lumberyard/latest/userguide/az-module-gems.html) to make sure your project continues to work.
+ If populating app descriptors fails for your project, manually edit your project's Gems.json file to reference the new versions of the Gems. 
+ Update your project's Editor.xml and Game.xml (found in the config folder under project root).
  + In the editor.xml file, change the line mentioning Gem.LyShine to: `<Class name="AZStd::string" field="dynamicLibraryPath" value="Gem.LyShine.0fefab3f13364722b2eab3b96ce2bf20.v0.1.0" type="{189CC2ED-FDDE-5680-91D4-9F630A79187F}"/>`
  + In the Game.xml file, update the line referencing the SaveData Gem to: `<Class name="AZStd::string" field="dynamicLibraryPath" value="Gem.SaveData.d96ab03f53d14c9e83f9b4528c8576d7.v0.1.0" type="{189CC2ED-FDDE-5680-91D4-9F630A79187F}"/>`
</Class>

<Class name="DynamicModuleDescriptor" field="element" type="{D2932FA3-9942-4FD2-A703-2E750F57C003}">

## Audio<a name="audio-improvements-changes-v1.22"></a>

### New Features
+ CrySoundSystem and CryAudioImplWwise engine modules have been converted to Gems.
  * CrySoundSystem is now the "Audio System" Gem, found in Gems/AudioSystem.
  * CryAudioImplWwise is now the "Wwise Audio Integration" Gem, found in Gems/AudioEngineWwise.
  * **NOTE:** These Gems are optional.  If your project uses Wwise, run Project Configurator and enable "Audio System" and "Wwise Audio Integration" Gems.

### Improvements
+ Xml parsing in the Audio System Gem now uses RapidXml.

## AWS Native SDK version update<a name="SDK-improvements-changes-v1.22"></a>

+ AWS Native SDK version was updated to 1.7.167.
**Note for Linux users:** If your project or a Gem depends on AWS Native SDK on Linux (such as a Twitch Gem) then debugging or profiling builds requires your Linux configuration to have libssl.so.1.1 and libcrypto.so.1.1 present on your system. Release builds link these libraries staticly. No changes are required to release Linux builds of Lumberyard.

## Large Worlds<a name="Worlds-improvements-changes-v1.22"></a>

**Large Worlds: Legacy Terrain**

+ You can now remove the legacy terrain system from the engine using compile/script flag enable_legacy_terrain in dev/Code/wscript.
+ You can now enable more detailed memory, I/O, and performance metrics for the Legacy Terrain System with cvars e_TerrainPerformanceSecondsPerLog and e_TerrainPerformanceCollectMemoryStats.
+ Removed dependency on Legacy Terrain from several core systems in the engine.

**Large Worlds: Roads**

+ Road meshification is ~4x faster due to improvements in batching, jobification, and time slicing.

## Systems<a name="systems-improvements-changes-v1.22"></a>

### New Features

#### Memory Stomp Detection Tool (Overrun Detection)
When enabled, the Memory Stomp Detection tool provides overrun detection, checking for memory corrupted by reads/writes outside the boundaries of allocated memory.   

The primary sign of what might be a memory stomp is a crash with no obvious explanation, frequently in a low-level system or structure (such as an AZStd:: container) or within the memory allocator (but not an out-of-memory error).

**To enable overrun detection:**

1. Make sure you are building and running for Windows PC or supported console, in a Debug or Profile build. For certain consoles you will need to increase memory to support overrun detection.
1. Open dev/{your-game-project-name}/Config/Game.xml. 
   1. This file will be copied to several places. Edit this copy: dev/{your-game-project-name}/Config/Launch/Game.xml
   1. On consoles you can also edit it directly in the game folder on the console itself.
1. Change useOverrunDetection from false to **true**.

With overrun detection enabled, you can play the game normally. If any system reads or writes outside of memory allocated, the game will crash with a callstack at the point of the invalid read/write.

**Notes:** 
+ There may be times where the game does not crash but instead hard-locks. In this case, pause the debugger and note where it stopped. You should see a message towards the end of the output similar to "Exception thrown: invalid read/write". The wording of this message may vary from platform to platform.

+ If you try to reproduce the problem and encounter another crash, the cause of the crash may not always be the same bug. In most cases, different callstacks will indicate separate bugs, whereas similar callstacks will indicate the same bug.

Additional notes on overrun detection mode:

+ Do **NOT** check in your modified Game.xml!
+ Overrun mode works only on Windows, and supported consoles with additional memory allocated.
+ It is compiled out of Performance and Release modes.
+ The game will run slower, and will take much more memory!
+ The detector doesn't always release memory, and is liable to continue to increase memory consumption as gameplay continues. It should be enough memory to test one or two levels, but, especially on limited platforms, do not expect infinite progression.
  * If you run out of memory, it will crash in either WindowsPlatformAllocator::ReserveBytes or WindowsPlatformAllocator::CommitBytes.
  * Any invalid/read write will include the normal "Exception thrown: invalid read/write" message near the end of the output. If you don't see that message, that also indicates it's not a read/write bug.
+ This mode fundamentally mimics the behavior of GFlags with full page heap verification, but is available with the LY allocators without recompiling anything.


#### Asset Memory Analyzer
The Asset Memory Analyzer is an experimental feature that gives you a breakdown of all memory allocated by the various assets loaded into the game. Use it to get a better understanding of what assets are actually loaded at runtime, and how each asset contributes to memory use.

##### Using the Asset Memory Analyzer

**Enable the driller:**

1. Edit AzCore/Debug/AssetMemoryDriller.h, and ensure AZ_ANALYZE_ASSET_MEMORY is defined (just need to uncomment the line). 
1. If you want to enable analysis in other build types (excluding Release), manually enable memory tracking:
   1. Edit dev/Code/Framework/AzCore/AzCore/Memory/Config.h
   1. Uncomment the line that says #define AZCORE_ENABLE_MEMORY_TRACKING
1. Edit Game.xml located in dev/{your-game-project-name}/Config:
   1. Set the field enableDrilling to true.
   1. Set the field enableAssetMemoryDriller to true.

**View the live analysis in ImGUI:**

If ImGUI is enabled, you can open the analysis window by choosing AssetMemoryAnalyzer → Open from the debug menu.
This opens the Asset Memory Analysis window.

Each recorded asset is displayed, along with the number of allocations and total kilobytes allocated, for both heap and VRAM.
Use the buttons at the top of the window to sort descending on any of the available categories.

Expand individual assets to view both:
+ Individual allocations that belong to an asset, and
+ Sub-assets that were loaded as a consequence of loading this asset.

**Export the analysis to a JSON file:**

Export the analysis to a JSON file in one of the following ways:
+ If ImGUI is enabled, you can choose AssetMemoryAnalyzer → Export JSON from the debug menu.
+ In the console, enter assetmem_export to generate the file.
+ From C++ code, call ExportJSONFile on the AssetMemoryAnalyzerRequestBus, with nullptr as the parameter to generate it to the default location.
  + Example: EBUS_EVENT(AssetMemoryAnalyzerRequestBus, ExportJSONFile, nullptr);
This will generate a file in your @log@ directory (e.g. dev/Cache/{your-game-project-name}/pc/user/log on Windows) titled assetmem-<TIMESTAMP>.json.

**View JSON files in the web viewer:**

Open dev/Gems/AssetMemoryAnalyzer/www/AssetMemoryViewer/index.html in your web browser (Chrome is recommended). On the webpage that opens drag-and-drop your JSON file or click on the target area to browse to it.

This will display the contents of the file in an expandable table. Sort the table by any of the columns. The columns give a breakdown by multiple categories:
+ **Heap Allocations** and **VRAM Allocations**.
+ Local summary (i.e. not including any sub-assets) and Total summary (i.e. including all sub-assets).
+ Number of allocations and kilobytes allocated.

Drill into any of the listed assets to discover:
+ Individual allocations belonging to that asset.
+ Sub-assets that were loaded as a consequence of loading this asset.

**Instrument Code**

**Initial asset loading:**

The AssetMemoryDriller traps allocations (heap and VRAM) that occur during a slice of code execution or "scope" when an asset is active for recording. 

When a system begins loading a new asset, it should use the **AZ_ASSET_NAMED_SCOPE** macro to demarcate the C++ scope in which that asset may be actively making allocations. 

```

#include <AzCore/Debug/AssetMemoryDriller.h>

Foo* LoadMyFooAsset(const char* name)
{
    AZ_ASSET_NAMED_SCOPE("Foo: %s", name);
    Foo* result = aznew Foo(name);  // The call to aznew will be recorded as associated with the asset "Foo: <name>"
    
    return result;  // Once we exit this function, the asset will no longer be in scope, and subsequent allocations will not be recorded
}
```


**Subsequent asset processing:**

Later on, when a system is going to do more work involving an asset, or if the asset is being handed off to a different thread, it should use the **AZ_ASSET_ATTACH_TO_SCOPE** macro with a pointer that was allocated and tracked by the initial asset. This will associate any further allocations with the same asset: 

```
#include <AzCore/Debug/AssetMemoryDriller.h>

void UpdateAllFoos(const AZStd::vector<Foo*>& allFoos)
{
    for (Foo* foo : allFoos)
    {
        AZ_ASSET_ATTACH_TO_SCOPE(foo);  // Subsequent allocations in this scope will associate with any asset that was in scope when foo was allocated
        UpdateFoo(foo);
    }
}

void UpdateFoo(Foo* foo)
{
    aznew Bar;  // This automatically gets recorded with the owning asset for foo
    AZStd::thread doThreadedWork([foo]()
    {
        // Work being done on a different thread means we need to reattach to the owning asset
        AZ_ASSET_ATTACH_TO_SCOPE(foo);
        aznew Bar;  // This will now be recorded under the owning asset for foo
    });
    doThreadedWork.join();
}

```

You can attempt to attach to any pointer that was created while that asset was in scope, *or even any portion of memory that was allocated to it.* For instance, the following code works: 

```
#include <AzCore/Debug/AssetMemoryDriller.h>

struct Baz
{
    int a;
    char* b;
    double c;
}

Baz* CreateBaz(const char* name)
{
    AZ_ASSET_NAMED_SCOPE(name);
    Baz* baz = aznew Baz;  // bar is associated with the named asset
    return baz;
}

void TestScopes()
{
    Baz* baz = CreateBaz("My test baz");
    
    {
        AZ_ASSET_ATTACH_TO_SCOPE(&baz->c);  // This works, even though "c" didn't have its own allocation
        baz->b = aznew char[32];  // This allocation will be recorded under the asset "My test baz"
    }
}
```

What this means is that you don't need an original pointer to an object that was allocated within a scope in order to attach to it, just something "close enough". This makes it possible to attach across systems to objects that have been defined with multiple inheritance.

**Ebus asset processing:**

Ebus handlers can automatically attempt to attach to a scope for each handler receiving an event. This works when the handler itself was allocated as part of an asset.

Some Lumberyard Ebuses already use this feature, such as the TickBus. If you find others that should use it, please add them! (But you should not default to using this EventProcessingPolicy if it is not applicable; see instrumentation considerations below.)

**Instrumentation considerations:**

+ Creating a new named scope requires function calls, an environment lookup, locking a mutex, two hashtable lookups, and thread-local modifications.
+ Attaching to an existing scope requires function calls, an environment lookup, locking a mutex, a lookup in a large red-black tree, and thread-local modifications.

Most of the time this is a relatively small cost, but it is significant enough that you should not use the AZ_ASSET_ATTACH_TO_SCOPE macro (or use the AssetMemoryDrillerEventProcessingPolicy on your Ebus) redundantly, or if it is unlikely to attach to anything.

There is **zero cost to instrumentation** in builds where the AssetMemoryDriller is disabled, i.e. if the AZ_ANALYZE_ASSET_MEMORY macro remains undefined. (This is the default in Performance builds.)


### Improvements
+ Improved memory tracking for VRAM and display of e_MemoryProfiling cvar (LY-104969). Memory usage now is broken down:
  + VRAM
   Texture: Render targets, Assets, Dynamic.
   Buffer: Vertex, Index, Constant, Other.
   + CPU: broken down by main allocators.
+ Restructure of Allocator's class hierarchy; making them more stable to boot ordering (solving some issues in Release/monolithic builds).
+ Memory driller: fixes to dump all allocations to CSV file.
**NOTE**: With any change affecting memory layout, previous memory-related bugs that did not previously cause crashes/issues could now produce unexpected behavior. For example, a memory overrun that previously was not producing any visible/detectable bug, may now produce issues.

+ IMGUI Improvements: Now using the latest version of IMGUI with added support for consoles and controllers.
+ Asserts Framework improvement: Now using only AZ_Assert with 3 levels of the sys_assert CVAR:  0: nothing, 1: log only, 2: dialog when asserts fails on all platforms.

#### Platforms SDK Versions
+ Linux : Ubuntu 16.04 LTS
+ MacOS:
  * XCode 11
  * OSX: Mojave 
  * IOS:  v.13
+ Android : NDK r20 / API 29 

## Mobile<a name="mobile-improvements-changes-v1.22"></a>

+ Added support for Xcode 11. Requires macOS High Sierra or higher.
+ Support for iOS v13 
+ iOS and Android: Optimization for GPU Bandwidth - Eliminate 'Diffuse Accumulation' render target during the Lighting pass which resulted in memory savings of 88 bits per pixel perf frame. It is enabled through cvar "r_DeferredShadingLBuffersFmt = 2".
+ Latest NDK (r20) support.
+ Improvements to Release/Shader Compilation workflow (Remove extra step, Error reporting).
+ Android: Improve Load Times by 40 percent faster when loading assets from the .APK not in .pak files.
+ Support for Android Q - API 29.

## Platform<a name="platform-improvements-changes-v1.22"></a>

+ Achievements/trophies Gem: The Achievement Gem provides an interface for your game to Achievement and Trophy services for console games. It allows for games to unlock, query, and update achievement and trophy data through the services provided for that console. 
+ Add Rich presence to Platform services: The Presence Gem provides an interface for your game to the Presence services for console games. It allows for games to set and query the presence status for a user on that console. Presence is the message that is displayed in friends lists and on a users profile as set by the game, based on the user's activity. 

## PhysX<a name="physx-improvements-changes-v1.22"></a>

#### Improvements

+ Pre and post physics world update events are exposed in script canvas (the behaviour context).
+ Component mode is introduced for PhysX collider components. This allows the modification of shape dimensions, position and rotation offsets for collider components directly in the viewport with manipulators.
+ Force regions are improved to send impulses on post physics world update instead of the rendering tick.
+ Bug fixes.

## Python Support<a name="python-improvements-changes-v1.22"></a>

+ In an upcoming release, Amazon Lumberyard will switch to Python 3.7.5. At that time, we will remove older versions of Python from the Lumberyard install.

## Networking<a name="network-improvements-changes-v1.22"></a>

Network Context has the following improvements and changes:
+ In Lumberyard, Network Context simplifies writing multiplayer components in C++. What can take 100 lines of code in raw GridMate implementation, Network Context accomplishes in less than a dozen lines with the interface.
+ Network Context is part of the context family, along with Serialize Context, Edit Context and Behavior Context. Network Context allows you to tag component member variables as network fields or remote procedure calls and use them in a simpler manner, compared to direct GridMate use.
+ MultiplayerSample has been updated to use Network Context in multiple components, such as HealthBarComponent.

## Twitch Commerce SDK deprecated<a name="Twitch-improvements-changes-v1.22"></a>

+ The Twitch Gem no longer requires the Twitch Commerce SDK. The Twitch Commerce SDK is deprecated. 

## Visual Studio 2017<a name="VS-improvements-changes-v1.22"></a>

Lumberyard 1.22 includes the following Visual Studio support changes:
+ Visual Studio 2017 version 15.9.2 is now the supported version.
+ Visual Studio 2015 is no longer supported.

## Miscellaneous<a name="misc-improvements-changes-v1.22"></a>
+ The Resource Compiler Image tool will be deprecated in an upcoming Lumberyard release, replaced by the ImageProcessing gem.
