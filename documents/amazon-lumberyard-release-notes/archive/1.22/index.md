# Lumberyard Release Notes – Beta 1.22 (December 2019)

Lumberyard Beta 1.22 continues to add new features, improvements, and fixes. Thank you to everyone in our community whose suggestions help us continue to make Lumberyard better with every release! Send feedback to our [forums](https://forums.awsgametech.com/) as well as the Lumberyard team at lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/).

**Topics**
+ [Highlights](#highlights)
+ [Improvements and Changes](improvements-changes.md)
+ [Fixes](fixes.md)
+ [Known Issues](known-issues.md)

## Highlights<a name="highlights"></a>

Here's a sampling of the new features found in Lumberyard [1.22 link].

**Topics**

+ [Visual Studio Support](#vs-support)
+ [Editor](#highlights-editor)
+ [Asset Pipeline](#highlights-pipeline)
+ [AWS Native SDK](#highlights-SDK)
+ [Memory Stomp Detection Tool](#highlights-overrun)
+ [Asset Memory Analyzer](#highlights-analyzer)
+ [PhysX](#highlights-physx)


### Visual Studio Support<a name="vs-support"></a>

+ **IMPORTANT!** Visual Studio 2015 support has been deprecated starting with Amazon Lumberyard v1.22. References to Visual Studio 2015 and the VC140 binaries have been removed from the documentation for v1.22, as well. If you are on Visual Studio 2015 or an older version, refer to our archived [Amazon Lumberyard documentation for prior versions](https://docs.aws.amazon.com/lumberyard/latest/userguide/lumberyard-documentation-archive.html). The current supported version of Visual Studio is VS 2017 v15.9.2 or later, and the supported VC++ binary version for builds is VC141.

### Python Support<a name="python-support"></a>

+ **IMPORTANT!** In an upcoming release, Amazon Lumberyard will switch to Python 3.7.5. At that time, we will remove older versions of Python from the Lumberyard install.

### Editor

+ Improved the performance of undo operations for entity manipulation. Translating 25 entities and pressing undo used to take ~15 seconds, and now takes ~4.5 seconds.
+ Fixed a performance issue that caused the editor to lag every time a slice was selected in the Entity Outliner. Selection of a 10k slice entity hierarchy used to take ~3 seconds, and now takes ~200ms.


### Asset Pipeline<a name="highlights-pipeline"></a>

Lumberyard’s new asset dependency graph provides the means to determine the set of assets a given asset depends on. By recursively walking the entire dependency graph, we can easily determine the exact set of assets your game needs to run. So when it comes time to release your game, packaging your assets becomes a simple set of steps as opposed to a multi-week development effort. We've added some new tools and features to enable this for you and allow you to generate smaller asset bundles for your releae builds.

**Asset Bundler** 

A command line tool to bundle game assets for release. The following are additional new features that support Asset Bundling:
+ Asset Validation Gem: Use this Gem to run your game exclusively from Asset Bundles.
+ Product Dependency System: Builders now generate product dependencies, including copy jobs. Product dependencies are the backbone of asset bundling and allow the Asset Bundler to evaluate an asset, and determine all other dependent assets.
+ Missing Dependency Scanner: Use this tool to identify potential missing product dependencies.
+ XML Schema System: A framework for defining dependencies for XML files.
+ Asset Tagging System - File Tagging System: This system provides a way to "tag" an asset as a certain type, such as "editor-only", "shader" or "ignore product dependencies." Tags are then used by the Missing Dependency Scanner and other tools.

**Delta Catalogs** 

.pak files (paks) now contain smaller versions of AssetCatalog.xml that live within a .pak and describe only the files within that pak.  At run time when opening a new pak file through CryPak, the system will automatically search for a delta catalog within the pak and, if found, update the asset registry with the information within that pak file layered over the old data (You can add new assets or update old assets).

### AWS Native SDK version update<a name="highlights-SDK"></a>

AWS Native SDK version was updated to 1.7.167. **Note for Linux users:** if your project or a gem depends on AWS Native SDK on Linux (such as Twitch gem) then debug/profile builds requires your Linux configuration to have libssl.so.1.1 and libcrypto.so.1.1 present on your system. Release builds link these libraries staticly, so no changes required for release Linux builds of Lumberyard.

### Memory Stomp Detection Tool (Overrun Detection)<a name="highlights-overrun"></a>
The Memory Stomp Detection tool provides overrun detection, checking for memory corrupted by reads/writes outside the boundaries of allocated memory.   

The primary sign of what might be a memory stomp is a crash with no obvious explanation, frequently in a low-level system or structure (such as an AZStd:: container) or within the memory allocator (but not an out-of-memory error).

### Asset Memory Analyzer<a name="highlights-analyzer"></a>

The Asset Memory Analyzer is an experimental feature that gives you a breakdown of all memory allocated by the various assets loaded into the game. Use it to gain insight into what assets are actually loaded at runtime, and how each asset contributes to memory use.
