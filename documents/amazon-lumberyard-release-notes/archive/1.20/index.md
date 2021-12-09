# Lumberyard Release Notes – Beta 1.20 (July 2019)<a name="lumberyard-v1.20"></a>

Lumberyard Beta 1.20 adds new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-20/).

**Topics**
+ [Highlights](#lumberyard-v1.20-highlights)
+ [Improvements and Changes](lumberyard-v1.20-improvements-changes.md)
+ [Fixes](lumberyard-v1.20-fixes.md)
+ [Known Issues](lumberyard-v1.20-known-issues.md)

## Highlights<a name="lumberyard-v1.20-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.20.

**Topics**
+ [Asset Processor](#asset-processor-highlights-changes-v1.20)
+ [Event Bus (EBus) System](#ebus-highlights-v1.20)
+ [Audio](#lumberyard-v1.20-highlights-audio)
+ [Animation Editor](#lumberyardv1.20-highlights-animation)
+ [Mobile](#lumberyardv1.20-highlights-mobile)
+ [PhysX](#lumberyardv1.20-highlights-physx)

### Asset Processor<a name="asset-processor-highlights-changes-v1.20"></a>
+ Asset Processor [Faster Scanning Mode](https://docs.aws.amazon.com/lumberyard/latest/userguide/asset-processor-faster-scanning.html) significantly reduces the time required to analyze the asset cache on startup. This enables Lumberyard to launch more quickly.   
![\[Faster Scanning Mode in Asset Processor.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-asset-processor-zero-analysis.png)

### Event Bus (EBus) System<a name="ebus-highlights-v1.20"></a>

EBus performance improvements have reduced the overhead of invoking functions through the EBus API by at least 20% in most cases. Using EBuses to send events between different game systems and components now performs closer to that of calling the event as a raw function call, thus reducing update time.

### Audio<a name="lumberyard-v1.20-highlights-audio"></a>

Audio has the following new features:
+ **Wwise External Sources** – You can now use the Wwise external audio source feature to specify a loose collection of audio files to be played back dynamically. 
**Note**  
The Wwise External Sources feature isn't supported in Wwise LTX.
+ **Audio System Component** – You can now perform audio operations at a global scope (as opposed to entity scope).
+ **Input Streaming Support** – You can now stream data from a variety of input sources for playback by the audio system. For example, you can play back the audio stream from a video file.
+ **Sound Duration** – You can now obtain the duration of a sound at runtime by registering with the `AudioTriggerNotificationBus` function and overriding the `ReportDurationInfo` function.
+ **Setting the Panning Mode** – You can now use the Wwise `SetPanningMode` method to shift panning between speaker mode (60 degrees) and headphone mode (180 degrees).

### Animation Editor<a name="lumberyardv1.20-highlights-animation"></a>

The **Animation Editor** has the following new feature:
+ **Interrupting Transitions** – You can now interrupt a transition that is in progress with another transition and smoothly blend into the new state. With this feature, you can quickly blend towards a new state without waiting for a transition to complete. A purple line shows the transition being interrupted. A green line shows the new transition in progress. The ability to interrupt a transition is useful when you want to rapidly interrupt a character attack with another attack, or interrupt a jump with a run forward motion.

### Mobile<a name="lumberyardv1.20-highlights-mobile"></a>

Mobile has the following new feature:
+ **AWS Device Farm Integration** – AWS Device Farm can now be used as a deployment target in the Deployment Tool.

  For more information, see [Using AWS Device Farm in Lumberyard Editor](https://docs.aws.amazon.com/lumberyard/latest/userguide/ios-android-deployment-tool-device-farm-integration.html) in the *Amazon Lumberyard User Guide*.

### PhysX<a name="lumberyardv1.20-highlights-physx"></a>

The PhysX system has the following new features:
+ **PhysX Force Region Component** – You can use the **PhysX Force Region** component to specify a region to apply physical force to entities. The component applies force at each frame to any entity that is in the bounds of the region. For example, if an entity moves into the force region of a sphere, force is applied to the entity.

  For more information, see the **[PhysX Force Region](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-physx-force-region.html)** component in the *Amazon Lumberyard User Guide*.
+ In Script Canvas, you can obtain the value of the net force exerted on an entity by using the **On Calculate Net Force** method of the PhysX Force Region **Generation Notifications** node. This callback is invoked when the force region calculates the net force exerted on an object.