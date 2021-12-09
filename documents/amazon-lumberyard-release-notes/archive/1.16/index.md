# Lumberyard Release Notes – Beta 1.16 (November 2018)<a name="lumberyard-v1.16"></a>

Lumberyard Beta 1.16 adds over 250 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community, whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-16/).

**Topics**
+ [Highlights](#lumberyard-v1.16-highlights)
+ [Improvements and Changes](lumberyard-v1.16-improvements-changes.md)
+ [Fixes](lumberyard-v1.16-fixes.md)
+ [Known Issues](lumberyard-v1.16-known-issues.md)

## Highlights<a name="lumberyard-v1.16-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.16.

**Topics**
+ [Track Memory Allocation for Optimization](#lumberyard-v1.16-highlights-memory-allocator-optimization)
+ [Define the Tangent Space for your Actor](#lumberyard-v1.16-highlights-tangent-space-actor-fbx-settings)
+ [Create Character Animations with the Simple Motion Component](#lumberyard-v1.16-highlights-animations-using-simple-motion-component)
+ [Lumberyard Getting Started Guide on GitHub](#lumberyard-v1.16-highlights-documentation-github)
+ [New Amazon GameLift Features](#lumberyard-v1.16-highlights-amazon-gamelift)

### Track Memory Allocation for Optimization<a name="lumberyard-v1.16-highlights-memory-allocator-optimization"></a>

Lumberyard 1.16 includes a refactor of the memory management system that enables you to accurately track where memory is allocated. This makes it easier and quicker to pinpoint memory leaks or optimize your game's memory usage to improve game performance. This improvement is especially important for mobile and console applications, where memory resources are usually more constrained than PC game environments.

For more information, see [Using Memory Allocators in Lumberyard](https://docs.aws.amazon.com/lumberyard/latest/userguide/memory-allocators.html) in the *Amazon Lumberyard User Guide*.

### Define the Tangent Space for your Actor<a name="lumberyard-v1.16-highlights-tangent-space-actor-fbx-settings"></a>

With Lumberyard 1.16, you can import tangent and bitangent information from an `.fbx` file. You can also use MikkT to generate the tangents. This allows you to maintain the tangent rules and settings for your actor when you import the `.fbx` file from a DCC tool into Lumberyard. If you do not specify any tangent rules for your actor, Lumberyard uses the default settings.

Choosing which tangents to use is based on the software that you use to bake your normal maps. This feature also unifies tangent support across all geometry in Lumberyard, rather than providing tangent generation support for each asset type.

You can specify the following settings and more in the **FBX Settings** tool:
+ **Tangent space** – Defines the tangent space that Lumberyard uses for an actor.
+ **MikkT** – Generates the tangents with MikkT. If the `.fbx` file doesn't contain tangents and you select **From FBX**, then MikkT will be used as the default; this is the same behavior used for static meshes with `.cfg` files.
+ **Bitangents** – Defines how to generate or read the bitangents. This can be read from the `.fbx` file or generated orthogonal to the tangent and normal.

For more information, see [Editing the FBX Settings](https://docs.aws.amazon.com/lumberyard/latest/userguide/char-fbx-importer-edit-import-settings.html) in the *Amazon Lumberyard User Guide*.

![\[FBX Settings window in Lumberyard Editor that shows the tangent rules and settings.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/fbx-settings-tangents.png)

### Create Character Animations with the Simple Motion Component<a name="lumberyard-v1.16-highlights-animations-using-simple-motion-component"></a>

You can use the **Simple Motion** component to play a motion without an animation graph. To create character animations with the **Track View** editor, add the **Simple Motion** component and the **Actor** component to an entity. You then add the entity to a track view sequence and specify the motions that you want your character to animate. When you add a motion track to a track view sequence, the **Track View** editor drives animation on the **Simple Motion** component and its properties.

For more information, see [Creating Animations with the Simple Motion Component in the Track View Editor](https://docs.aws.amazon.com/lumberyard/latest/userguide/create-cinematics-with-simple-motion-animations-in-track-view-editor.html) in the *Amazon Lumberyard User Guide*.

![\[Example animation of a single motion in the track view sequence.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-cinematics-track-view-simple-motion-component-6-example.gif)

### Lumberyard Getting Started Guide on GitHub<a name="lumberyard-v1.16-highlights-documentation-github"></a>

The [Amazon Lumberyard Getting Started Guide](https://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/) is now available on GitHub. You can submit changes for fixes, improve examples, and rewrite and submit new content.

**To contribute to our documentation**

1. See the [Open Source at AWS](https://aws.github.io/code-of-conduct) and the contributing guidelines in the [CONTRIBUTING.md](https://github.com/awsdocs/amazon-lumberyard-getting-started-guide/blob/master/CONTRIBUTING.md).

1. Create a GitHub account if you don't already have one.

1. Navigate to the topic to which you want to contribute in the [Amazon Lumberyard Getting Started Guide](https://docs.aws.amazon.com/lumberyard/latest/gettingstartedguide/) and choose the GitHub icon ![\[GitHub\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/githubicon.png).

1. Make your changes. When you are ready to submit your changes, create a pull request.

For more information, see the [AWS blog](https://aws.amazon.com/blogs/aws/aws-documentation-is-now-open-source-and-on-github/).

### New Amazon GameLift Features<a name="lumberyard-v1.16-highlights-amazon-gamelift"></a>

Stay up to date with the latest release information at [AWS Release Notes for Amazon GameLift](https://aws.amazon.com/releasenotes/Amazon-GameLift?browse=1).