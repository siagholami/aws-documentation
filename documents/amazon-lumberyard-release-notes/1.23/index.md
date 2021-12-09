# Lumberyard Release Notes – Beta 1.23 (February 2020)

Lumberyard Beta 1.23 continues to add new features, improvements, and fixes. Thank you to everyone in our community whose suggestions help us continue to make Lumberyard better with every release! Send feedback to our [forums](https://forums.awsgametech.com/) as well as the Lumberyard team at lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/).

**Topics**

+ [Highlights](#highlights)
+ [Improvements and Changes](improvements-changes.md)
+ [Fixes](fixes.md)
+ [Known Issues](known-issues.md)

## Highlights<a name="highlights"></a>

### New Tutorials
Before you dive into the new features we've prepared, check out our new tutorials!

+ A four-part video series on EMotionFX, our animation system. It'll guide you through a character's locomotion and over-the-shoulder aiming system are configured, and how you can modify it with the new PhysXSamples Gem. (See the rest of the release notes for more details on this Gem.) [Check them out here](https://docs.aws.amazon.com/lumberyard/latest/tutorials/tutorials-animation-demo-aiming-system.html)!

+ A new written tutorial to accompany the Basics of Motion video tutorials. It'll go over how to work with Cameras, Script Canvas, and PhysX to get a rolling sphere with keyboard-and-mouse controls in a scene. [Read it here](https://docs.aws.amazon.com/lumberyard/latest/tutorials/tutorials-written-basics-of-motion-overview.html).

**Now, here's a sampling of the new features and improvements found in Lumberyard Beta 1.23.**

### NVIDIA Cloth Gem

We're proud to announce the "experimental" release of one of our most requested features: Support for physicalized cloth! NVIDIA Cloth allows designers and artists to quickly and easily create, customize, and iterate on cloth simulations. With the NVIDIA Cloth Gem you will be able to add cloth simulation to your characters and environments, creating more realistic and dynamic scenes. Remember: Everything's cooler with a fancy cape flapping in the wind!

[Read more about this in our documentation](https://docs.aws.amazon.com/lumberyard/latest/userguide/gems-system-gem-nv-physx-cloth.html). Give it a shot and let us know what you think.

### Slice Upgrade Pipeline

The other big request we heard from you is about better slice management. Slices can be hard to manage as your project grows in size and scope—you're making a game, after all—so we created an updated format for slices as well as the Slice Upgrade Pipeline that, once you enable it, allows the Asset Processor to automatically and smartly convert our slices to the new format.

The new slice format extends the slice XML schema to represent data patches as readable data types and values instead of a hexadecimal byte stream.

Some benefits of this new slice format include:

+ An updated XML format that you can directly edit and manage at much more granular level of detail (as opposed to the old ByteStream)
+ Support for better versioning of component serialization, which in turn enables you to use the new TypeChange and NameChange builders
+ A new pipeline that scans for and converts slice component assets to the new format

Read more about [how the new slice format works](https://docs.aws.amazon.com/lumberyard/latest/userguide/dynamic-slices-overview-anatomy.html), [how to use the new format for slice component versioning](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-system-versioning.html), and [details on how to upgrade your project to use it](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-slice-upgrade-process.html). 

Not sure what a "slice" is? [Read up on them here](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-slices.html).

### PhysXSamples Gem

The new PhysXSamples gem houses a collection of sample slices and scripts ranging from introductory feature examples to a fully animated 3rd person character controller (also known as "The Cowboy"). This Gem serves as a library of samples for commonly used Lumberyard features and will be updated regularly with new samples for you to experiment with.

You can start using it by enabling the **PhysXSamples Gems** through the **Project Configurator**.

For more details, read [Amazon Lumberyard Beta 1.23 Improvements and Changes](improvements-changes.md).

### DevTextures Gem

The DevTextures gem is collection of textures used for development and debugging. It includes a variety of grid texture types such as middle grey checker and UV debugging grids, as well as simple shapes like dot and ring. We'll be adding more textures for you to use over time, so keep checking it out as we keep updating the Lumberyard Beta.

You can start using it by enabling the **DevTextures Gems** through the **Project Configurator**.

For more details, read [Amazon Lumberyard Beta 1.23 Improvements and Changes](improvements-changes.md).

## Animation: EMotionFX (EMFX) Optimizations

We've made some key performance improvements to how EMFX works under the hood. These changes will be particularly noticable in scenes that have a lot of animated Actors.

+ **General Optimizations**: We've made optimizations inside of the EMotion FX runtime in a continuous effort to improve its performance. Specifically, we changed from EMotion FX's internal quaternion implementation to a new AZ::Quaternion class, which uses SIMD instructions to achieve faster and more accurate transformations. We've also made performance improvements to the Pose class implementation and to animation graph resolution.

+ **Skeleton Optimization**: We've added a new FBX settings modifier for Actors which looks at the skinning information provided with your mesh data and determines the minimum set of joints that need to be enabled to skin the character correctly. This can lead to improved performance, especially when you have multiple animated Actors in a scene.

For more information about these new and updated features, read [Amazon Lumberyard Beta 1.23 Improvements and Changes](improvements-changes.md).

## Breaking Changes

Lumberyard Beta 1.23 introduces the following breaking changes as part of this release. Please review your projects to determine if these impact you. If you need advisement around these breaking changes, let us know on our [forums](https://gamedev.amazon.com/forums/index.html).

### Lumberyard Development Linux Support

**The minimum supported version of Ubuntu Linux for Amazon Lumberyard development is now Ubuntu 18.04 LTS ('bionic')**. This change aligns our Linux development story around a version that has current long-term support.

This change impacts Linux developers building and running the Lumberyard engine and its tools, including Asset Processor, asset builders, and Gems. Specifically, Lumberyard has been updated to support:

+ Lumberyard engine, asset tools, and Gem compilation on Linux Ubuntu 18.04.

+ Linux builds in C++ 17 / clang 6.0.0.

### GameLift Fleet Deployment Support with Lumberyard

If your title uses Amazon GameLift fleets on Amazon Linux EC2 instances, **Amazon Linux 2 is now the only officially supported platform for Amazon GameLift dedicated servers built with Lumberyard**. Amazon Linux 1 platforms are now considered depreciated for Amazon GameLift.

We're making this change in line with Amazon's deprecation strategy for AL1. Note that the change in Linux development support to Ubuntu 18.04 LTS doesn't guarantee compatibility with Amazon Linux when building software, and that Amazon Linux has been slated for End of Life in December 2020.

+ To see which version of Linux your GameLift fleet EC2 instance is runnning, connect to it and run the following command: `cat /etc/system-release`.

+ For information on migrating from Amazon Linux to Amazon Linux 2, see the [AWS EC2 documentation](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts.html) and the [Amazon Linux 2 FAQ](https://aws.amazon.com/amazon-linux-2/faqs/).

### SSE Support

**Starting with this version, 1.23, client hardware that does not support SSE4.1 will not be able to run key components of Lumberyard**. This change impacts only the Lumberyard Editor and the game clients. Game server builds are not affected by this requirement.

You can confirm that your client hardware supports SSE4.1 by downloading the coreinfo tool for Windows and running the following command: coreinfo -f. If the output line for SSE4.1 contains a "*" SSE4.1 is supported by your hardware, otherwise, if your hardware does not support SSE4.1, the line contains a "-".

SSE 4.1 will be required for all Lumberyard components (including game servers) in the future. Watch this space!

### Visual Studio 2017 Version Support

**The minimum supported version of Visual Studio 2017 is now 15.9.14**. Versions prior to that are not supported by Amazon Lumberyard.

### Java Development Kit and Android Support

**For Android developers, Google Android Studio is now required software, as it wholly replaces the JDK**.

## Coming Changes

The following changes are planned for a forthcoming release of Lumberyard:

### Python Version Support

In an upcoming release, Amazon Lumberyard will switch to Python 3.7.5. At that time, we will remove older versions of Python from the Lumberyard install.

### WAF and CMAKE Support

In an upcoming release, WAF support for Amazon Lumberyard build tools and processes will be removed in favor of CMAKE. We're making this change to support open standards for development and take full advantage of the CMAKE ecosystem. We will provide more details in future Release Notes.
