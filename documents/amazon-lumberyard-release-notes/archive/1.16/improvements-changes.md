# Improvements and Changes<a name="lumberyard-v1.16-improvements-changes"></a>

Lumberyard Beta 1.16 provides improvements and changes to Lumberyard systems and functionality. Choose a topic area to learn more.

**Topics**
+ [Animation Editor](#animation-editor-improvements-changes-v1.16)
+ [Asset Browser](#asset-browser-improvements-changes-v1.16)
+ [Cloud Canvas](#cloud-canvas-improvements-changes-v1.16)
+ [Deployment Tool](#deployment-tool-improvements-changes-v1.16)
+ [HPHA Memory](#hpha-memory-improvements-changes-v1.16)
+ [iOS](#ios-improvements-changes-v1.16)
+ [macOS](#macos-improvements-changes-v1.16)
+ [Mobile Support](#mobile-improvements-changes-v1.16)
+ [Networking](#networking-system-improvements-changes-v1.16)
+ [Per-Platform Graphics Settings](#per-platform-graphics-settings-improvements-changes-v1.16)
+ [SDK Compatibility](#lumberyard-v1.16-highlights-compatible-sdk-versions)
+ [Texture Streaming on Mobile Devices](#texture-streaming-mobile-devices-improvements-changes-v1.16)
+ [UI Editor](#ui-editor-improvements-changes-v1.16)
+ [Visual Studio 2017](#visual-studio-support-improvements-changes-v1.16)
+ [Miscellaneous](#miscellaneous-improvements-changes-v1.16)

## Animation Editor<a name="animation-editor-improvements-changes-v1.16"></a>

The **Animation Editor** has the following improvements and changes:
+ Input lag from tick ordering between the animation, physics, and scripting systems has been reduced.
+ HPHA fragmentation was implemented to reduce the Animation Editor's memory consumption. You can track memory issues by using HPHA memory debugging to do the following:
  + Assert on double deallocations
  + Assert on allocator destruction, if there are allocated memory blocks
  + Assert when you deallocate something that was not allocated
  + Assert when you deallocate a size that differs from what was allocated
  + Place a memory guard at the end of every allocation to assert if the memory guard doesn't match the stored memory guard
  + Produce failures if memory is used after it is deallocated
+ Debug tests for Script Canvas, GridMate, and the Lumberyard sound system now work properly when you enable HPHA memory checks.
+ Actors no longer have a 16-bit vertex limit and rendering animated characters no longer has a 65k vertices limit. You can now use any vertex or triangle count when rendering actors.

## Asset Browser<a name="asset-browser-improvements-changes-v1.16"></a>

The **Asset Browser** has the following improvements and changes:
+ You can now see source (unprocessed) assets and their directory structure.
+ The **Asset Browser** window has been updated to improve the visual design and implement standard icons.
+ You can right-click a file to open it, if a Lumberyard Editor tool exists to support the file type.
+ Asset types are now more modular. You can use gems to describe what happens when double-clicking or right-clicking custom asset types, or when customizing context menus and icons.
+ Operation performance improvements include the property editor and the initial time it takes to populate the **Asset Browser** during Lumberyard Editor startup.
+ Source control delays no longer occur when you load a level. Refreshing the source control now occurs asynchronously after you load a level.

## Cloud Canvas<a name="cloud-canvas-improvements-changes-v1.16"></a>

Cloud Canvas has the following improvements and changes:
+ The Cloud Gem Defect Reporter has added the following features to the Cloud Gem Portal plugin:
  + Save and share queries and reports
  + Filter defects by read status
  + Add comments to existing reports
+ You can now automatically create Jira issues for defects that your QA team or customers find. The Cloud Gem Defect Reporter can authenticate with and submit issues to a Jira instance with the appropriate Jira credentials.
+ AWS resources for cloud gems are now deployed sequentially, which allows you to deploy a large number of cloud gems simultaneously.
+ The Cloud Gem Framework now supports the following languages: Node.js, Java, C\#, and Go. You can now write Lambdas in your preferred language when you create a cloud gem.
+ The Cloud Gem Framework has the following improvements for stability:
  + Gems are now created, updated, and deleted one at a time when you use the `deployment` family of commands. Previously these actions were completed in parallel, which could cause issues with AWS limits when modifying multiple resource groups simultaneously.
  + Custom resources are now locked to the version of the code that you used to create the resources. If the code changes and an existing resource instance is updated or deleted, the updated or deleted event will be processed with the same code that was used to create it. This helps prevent rollback issues when updating or deleting custom resources.

## Deployment Tool<a name="deployment-tool-improvements-changes-v1.16"></a>

The Deployment Tool has the following improvements and changes:
+ The ARMv7 and ARMv8 Android targets are now supported.
+ You can now load the current level.
+ You can now select the target device.
+ Remote logs are now supported.
+ The connection handling for the shader compiler and Asset Processor has been improved.

## HPHA Memory<a name="hpha-memory-improvements-changes-v1.16"></a>

Improvements to the high performance heap allocator (HPHA) were made to implement debugging and optimize performance.

### Debugging<a name="hpha-memory-debugging-improvements-changes-v1.16"></a>

Debugging tools were added to the HPHA allocator to detect common memory problems. For more information, see [HPHA Memory Debugging](https://docs.aws.amazon.com/lumberyard/latest/userguide/memory-management-debugging-hpha.html).

### Optimization<a name="hpha-memory-optimization-improvements-changes-v1.16"></a>

To eliminate excessive memory fragmentation, the following changes were made to the high performance heap allocator (HPHA) (source code location: `lumberyard_version\dev\Code\Framework\AzCore\AzCore\Memory\HphaSchema.cpp`).

1. Removed `mMRFreeBlock` to eliminate fragmentation that frequently occurred in the following scenario:

   1. A large allocation occurs.

   1. The large allocation is increased to page size or a multiple of page size.

   1. `mMRFreeBlock` is assigned to the remainder of the block holding the difference between the size increase and the requested size.

   1. Another, smaller allocation occurs that fits inside the `mMRFreeBlock` area.

   1. The large allocation in Step 1.a. is freed.

   1. The block cannot be freed because the small allocation in Step 1.d. has occupied the `mMRFreeBlock` area.

   Removing `mMRFreeBlock` forces the small allocation to occur in the smallest free block into which the request can fit.
**Note**  
This change could potentially reduce memory locality and allocation performance.

1. Removed `mSmallFreeList` because the blocks in that list were never reused nor freed.

1. Changed the way in which the allocated size is calculated.

   Previously, the allocated size was calculated by getting the size after the block was split for the requested allocation. Now the calculation occurs when the system allocation call happens and when memory is freed. This change provides a more accurate total allocation size.

   As a result, note the following:
   + The allocation size now also accounts for block info size.
   + The allocation size is now the actual size requested by the allocator.
   + If a preallocated block is passed, it is not accounted as allocated size.

1. If the allocation size is bigger than the page size, the allocation is no longer increased to page size. This eliminates the fragmentation that occurred in the following scenario:

   1. A large allocation occurs.

   1. The size of the large allocation is increased to page size.

   1. The remaining unused memory is added to `mFreeList`.

   1. Another, smaller allocation occurs that uses the block that was added in Step 4.c.

   1. The large allocation in Step 4.a is freed.

   1. The block cannot be freed because the small allocation in Step 4.d is using the block.

## iOS<a name="ios-improvements-changes-v1.16"></a>

Compressed (PVRTC) normal maps are now supported by default. This helps with building normal map textures for iOS and improves performance at runtime.

## macOS<a name="macos-improvements-changes-v1.16"></a>

Lumberyard now supports the DirectX Shader Compiler tool version 1.0.1-az. This version includes the following:
+ Bug fixes and stability improvements for compiling Metal shaders.
+ The ability to optimize shaders that contain branching inside loops. This reduces the size of the final shader that is generated.
+ Support for declaring temporary variables individually instead of using arrays. This allows the shader compiler to more easily detect and remove unused variables for each operating system.
+ A DxbcChunks command line executable that prints out the shader's reflection data in the same format that Lumberyard parses the data. This is useful for debugging the shader's DXBC chunks that are generated by dxcGL and dxcMetal.

## Mobile Support<a name="mobile-improvements-changes-v1.16"></a>

Android and iOS have the following improvements and changes:
+ The default geom cache (\~20 MB) has been replaced with a placeholder (500 KB). This reduces the app size for both Android and iOS.
+ iOS version 12 and Xcode version 10 are now supported.

## Networking<a name="networking-system-improvements-changes-v1.16"></a>

The networking system has the following improvements and changes:
+ The GridMate Carrier adds support for the Microsoft Registered I/O (RIO) socket interface. RIO provides a lower latency and higher throughput interface to the Windows kernel for processing network traffic.
+ The `memorytoascii` print utility has been added.
+ Carrier periodic or deferred ACKs have been added.
+ To reduce impact to low rate connections, the default disconnect for packet errors is now disabled.
+ The `SerializerForEmptyClass()` function is deprecated and now removed.
+ The SecureSocketDriver test case setup has been reworked for clarity.

## Per-Platform Graphics Settings<a name="per-platform-graphics-settings-improvements-changes-v1.16"></a>

The per-platform graphics settings have the following improvements and changes:
+ The Android models configuration file now allows regular expressions.
+ You can now override PC console variables on macOS.
+ You can now override console variables on Android, based on the GPU name and the API version.
+ You can use the **Graphics Settings** window to edit up to four custom configurations simultaneously.
+ You can use the **Graphics Settings** window to edit PC console variables.
+ The **Graphics Settings** window includes miscellaneous bug fixes and stability improvements.

## SDK Compatibility<a name="lumberyard-v1.16-highlights-compatible-sdk-versions"></a>

Lumberyard 1.16 is compatible with the following SDK versions:
+ AWS SDK for C\+\+ version 1.4.34
+ Amazon GameLift Server SDK version 3.2.1

## Texture Streaming on Mobile Devices<a name="texture-streaming-mobile-devices-improvements-changes-v1.16"></a>

Texture streaming is now supported on mobile devices. This feature is disabled by default. We recommend that you enable this feature if your device doesn't have sufficient system memory to load all the textures in a level. Depending on the device, you may see an increase in memory usage. You can adjust this increase by setting the `r_TexturesStreamPoolSize` console variable.

**Note**  
You cannot enable texture streaming for Android devices that are missing IMG\_COPY\_EXT or OpenGL3\_2 or newer. You also cannot enable texture streaming for Arm Mali devices.

For more information about streaming, see [Streaming System](https://docs.aws.amazon.com/lumberyard/latest/legacyreference/system-streaming.html) in the *Amazon Lumberyard Legacy Reference*.

**To enable texture streaming**

1. Use your preferred text editor to open any of the configuration files.

1. Set the `r_TexturesStreaming` console variable to **1**.

1. Save the file.

1. Use your preferred text editor to open the `AssetProcessorPlatformConfig.ini` file.

1. Set `mobile=/imagecompressor=CTSquish /streaming=0 to mobile=/imagecompressor=CTSquish /streaming=1`

1. Save the file.

## UI Editor<a name="ui-editor-improvements-changes-v1.16"></a>

UI elements now have a **Start Enabled** check box.

## Visual Studio 2017<a name="visual-studio-support-improvements-changes-v1.16"></a>

Lumberyard 1.16 supports Visual Studio 2017 version 15.8.6.

Beginning with Visual Studio 2017, Microsoft now releases updates on a more frequent cadence (in some cases, weekly). Lumberyard is tested with the latest version of Visual Studio available during the release cycle. 

## Miscellaneous<a name="miscellaneous-improvements-changes-v1.16"></a>

Thanks to the diligent feedback from **Svyatoslav Razmyslov**, we made numerous improvements and updates to the Lumberyard code.