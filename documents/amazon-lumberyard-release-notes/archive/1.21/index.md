# Lumberyard Release Notes – Beta 1.21 and 1.21.1(September and October 2019)<a name="lumberyard-v1.21"></a>

Lumberyard Beta 1.21 and 1.21.1 add new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://gamedev.amazon.com/forums/index.html) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-21/).

**Topics**
+ [Highlights](highlights)
+ [Improvements and Changes](improvements-changes.md)
+ [Fixes](fixes.md)
+ [Known Issues](known-issues.md)

## Highlights<a name="lumberyard-v1.21-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.21.

**Topics**
+ [Animation Editor](#lumberyardv1.21-highlights-animation)
+ [Launcher Projects](#lumberyardv1.21-highlights-launcher-projects)
+ [PhysX](#lumberyardv1.21-highlights-physx)
+ [Systems](#systems-highlights-v1.21)

### Animation Editor<a name="lumberyardv1.21-highlights-animation"></a>

The **Animation Editor** now supports a **Simulated Object** node. Use this node to add secondary motion to a chain of joints in an actor. For example, if your actor has loose costume items such as chains, backpacks or even long hair, you can add simulated objects to your actor to dynamically simulate secondary motion. 

The adjustable node features include stiffness factor, gravity factor, damping factor, simulation update rate, number of iterations and ability to use colliders. 

For each joint in a simulated object, you can adjust joint limit, mass, collision radius, stiffness, damping, gravity and friction. Pick what colliders can collide with a simulated object. On a joint by joint basis, you can pick what colliders to exclude from the collisions.

**Example**  
In the following animation, the tassel attached to the character is the simulated object.  

![\[View the final animation of the actor and the simulated object.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/simulated-objects-23.gif)

For more information, see [Creating Simulated Objects](https://docs.aws.amazon.com/lumberyard/latest/userguide/animation-editor-creating-simulated-objects.html) in the *Amazon Lumberyard User Guide*.

### Launcher Projects<a name="lumberyardv1.21-highlights-launcher-projects"></a>

Prior to Lumberyard version 1.21, Lumberyard had nine different platform-specific Microsoft Visual Studio and Xcode launcher projects, including ones for Windows, Android, iOS, Mac, Apple TV, Linux Server, and Windows Server. When developing and debugging a cross-platform game, this required you to change the StartUp project and debug target platform in Visual Studio for each platform.

#### Unified Launchers<a name="lumberyardv1.21-highlights-launcher-projects-unified-launchers"></a>

Starting in version 1.21, Lumberyard adds a `lumberyard_version\dev\Code\LauncherUnified` directory and consolidates launchers into two unified projects: one for client, and one for server. These two unified launcher projects work across all supported platforms. The unified launchers reduce the amount of platform-specific code required and contribute to Lumberyard's Platform Abstraction Layer (PAL).

Previously, Visual Studio launcher project names had one of the following formats:

```
<ProjectName><Platform>Launcher
<ProjectName>DedicatedLauncher
```

Starting in version 1.21 of Lumberyard, Visual Studio launcher project names are in the following format:

```
<ProjectName>ClientLauncher
<ProjectName>ServerLauncher
```

The following images of launcher projects in Visual Studio show this change. 

Old launcher projects:

![\[Operating system specific launcher projects in Microsoft Visual Studio.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/lumberyardv1.21-highlights-launcher-projects-1.png)

New launcher projects:

![\[Unified client and server launcher projects in Microsoft Visual Studio.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/lumberyardv1.21-highlights-launcher-projects-2.png)

#### Migrating Legacy Launcher Projects<a name="lumberyardv1.21-highlights-launcher-projects-migrating-legacy-launcher-projects"></a>

The legacy launcher projects are planned for removal in a future release. To use the previous launcher projects, you can set the `use_unified_launcher` Waf option to `False` (the default is `True`). If you made custom changes to the previous launcher, please migrate your changes to the new unified launcher.

To compare any changes that might be attributable to the unified launcher, you can temporarily set the attribute `use_unified_launcher=False` in your `user_settings.options` file. This settings change requires a minimal rebuild.

### PhysX<a name="lumberyardv1.21-highlights-physx"></a>

The PhysX system has the following new features:
+ Lumberyard now supports NVIDIA PhysX SDK 4.1 version. All gems that depend on the PhysX SDK now support this version.

  For more information, see the [NVIDIA PhysX SDK 4.1](https://github.com/NVIDIAGameWorks/PhysX) and [Release Notes](https://gameworksdocs.nvidia.com/PhysX/4.1/release_notes.html).

  If you use Visual Studio 2017, you must install version 15.5.1 or newer. Older versions of Visual Studio 2017 contain a compiler bug and aren't compatible with the NVIDIA PhysX SDK.

  For more information, see the [Configuring the PhysX System](https://docs.aws.amazon.com/lumberyard/latest/userguide/physx-configuration.html) in the *Amazon Lumberyard User Guide*.

### Systems<a name="systems-highlights-v1.21"></a>

We refactored the platform-specific code for Lumberyard to simplify its cross-platform architecture. This enables you to develop and maintain cross-platform features more easily. These changes also significantly reduce the effort required to add new platforms to Lumberyard. These changes won't impact most teams as the public APIs are unchanged.

We have removed support for 32-bit platforms because all modern platforms are 64-bit.
