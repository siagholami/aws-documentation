# What is Lumberyard?<a name="lumberyard-intro"></a>

Amazon Lumberyard is a free, cross\-platform, 3D game engine that allows you to create high\-quality games, connect your games to the compute and storage of the AWS Cloud, and engage fans on Twitch\. With Lumberyard, you can spend more time creating great gameplay and building communities of fans, and less time on the heavy lifting of building a game engine and managing servers\.

Lumberyard offers everything a professional game developer can expect, such as a full\-featured editor, native code performance, and stunning visuals\. It also includes hundreds of other ready\-to\-use features like networking, cinematics, the **Script Canvas** editor, the **Animation Editor**, audio tools, and more\. 

Interested? Want to get started?
+ [Download the latest version of the Lumberyard beta](https://aws.amazon.com/lumberyard/downloads/)
+ [ Kickstart your learning by watching tutorial videos](https://aws.amazon.com/lumberyard/gettingstarted/)
+ [Sign up for and participate in the Amazon Lumberyard forums](https://forums.awsgametech.com/)

![\[Learn more about Lumberyard's systems and features in the Amazon Lumberyard User Guide.\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/starter-game-introduction-1.25.png)

Image from Starter Game\. For more sample projects and levels, see [Using Lumberyard sample projects and levels](sample-projects-levels-intro.md)\.

## Professional\-Grade AAA Engine<a name="lumberyard-aaa-engine"></a>

Lumberyard helps you build rich, engaging, world\-class games through its comprehensive and proven toolset and highly optimized runtime performance\.

### Beautiful Worlds<a name="lumberyard-aaa-engine-worlds"></a>

The visuals technology of Lumberyard can bring to life any virtual environment\. Your artists get a powerful toolbox to create high quality visual elements, such as physically based shaders, dynamic global illumination, particle effects, lifelike vegetation, real\-time dynamic water caustics, and volumetric fog\. They can also produce cinematic features like color grading, motion blur, depth of field, and integrated HDR lens flares\.

For more information, see the following topics: 
+ [Creating levels and adding environment effects](level-intro.md)
+ [Adding particle effects](particle-intro.md)
+ [Create screen effects](rendering-graphics-screen-effects-intro.md)

### Asset Changes<a name="lumberyard-aaa-engine-asset-changes"></a>

With the Lumberyard's Asset Processor, you can quickly get assets into the engine\. Save a file \(for example, from Maya or Photoshop\) into a directory, and the Asset Processor automatically processes that file from source art into game\-ready assets\. If you edit an asset, Lumberyard detects the change and automatically updates it in the background\.

For more information, see [Using Asset Processor](asset-pipeline-processor.md)\.

### Component Entities<a name="lumberyard-aaa-engine-component-entities"></a>

The component entity system helps you compose complex entities out of simpler entities\. Content creators can drag and drop components to build behaviors, edit component settings live in the editor, and create Lua scripts to quickly change or extend an entity's behavior\. To build and iterate for complex scenes, entities can be grouped together into slices\. Those slices can in turn be used to create more complex slices, resulting in a fully cascading prefab system\. If you change a slice, you can share your changes to all the slice instances, or keep your changes exclusive to just that instance\.

For more information, see the following topics:
+ [Working with component entities](component-intro.md)
+ [Working with Slices](component-slices.md)

### Compelling Characters<a name="lumberyard-aaa-engine-characters"></a>

Artists can use Lumberyard to create believable characters and high\-fidelity performances\. Lumberyard's character tool, Geppetto, combines animation, attachments, and physics simulations with blend shape, blend space, and animation layering\. Animators can use Lumberyard's animation tool, Mannequin, to bring characters and creatures to life with features that include animation sequencing, transitions, game logic procedures, ragdoll physics, and more\.

For more information, see [Create and animate characters](char-intro.md)\.

### Robust Networking<a name="lumberyard-aaa-engine-networking"></a>

Lumberyard introduces GridMate, a robust and flexible networking solution designed for efficient bandwidth usage and low\-latency communications\. You can synchronize objects over the network with GridMate's replica framework\. GridMate's session management can be integrated with major online console services and helps you handle peer\-to\-peer and client–server topologies with host migration\.

For more information, see [Using Lumberyard Networking](network-intro.md)\.

### Real\-Time Gameplay Editing<a name="lumberyard-aaa-engine-gameplay"></a>

Real\-time gameplay editing helps you iterate on gameplay and immediately see your results without waiting for builds or leaving the editor\. Lumberyard's Asset Processor automatically converts and optimizes your game assets in real time so that you can import game objects, fine\-tune behavior, and play the game that you created\.

### Modular Gems<a name="lumberyard-aaa-engine-gems"></a>

Lumberyard's Modular Gems system gives you a library of prebuilt features with which you can start new projects or prototype ideas quickly\. Modular Gems offer increased control over which technologies to include in your game project\. Create your own modular Gems or use the Gems included with Lumberyard, such as weather effects, a boids\-based ambient creature system, lightning effects, a camera framework, and more\.

For more information, see [Add modular features and assets with Gems](gems-system-gems.md)\.

### Wwise LTX<a name="lumberyard-aaa-engine-wwise-ltx"></a>

Lumberyard includes a version of Audiokinetic's advanced, feature\-rich sound engine\. Sound designers and composers can author rich soundscapes for your games\.

For more information, see [Adding Audio and Sound Effects](audio-intro.md)\.

## Integrated with AWS<a name="lumberyard-aws-integration"></a>

Lumberyard is deeply integrated with AWS so you can build live and multiplayer games with dramatically less cost, time, and technical risk\. AWS integrations include:

### Amazon GameLift<a name="lumberyard-aws-gamelift"></a>

Amazon GameLift is an AWS service for deploying, operating, and scaling session\-based multiplayer games\. You can scale high\-performance game servers up and down to meet player demand without additional engineering effort\.

For more information, see the [Amazon GameLift Developer Guide](https://docs.aws.amazon.com/gamelift/latest/developerguide/)\.

### Cloud Canvas<a name="lumberyard-aws-cloud-canvas"></a>

Cloud Canvas is Lumberyard's technology for connecting your game to Amazon Web Services\. With Cloud Canvas, you can use AWS to implement cloud\-hosted features and create asynchronous multiplayer games\. Using AWS means you no longer have to acquire, configure, or operate host servers to implement connected gameplay\.

You can build live, online game features, such as a community news feed, daily gifts, or in\-game notifications, in minutes with Lumberyard's Cloud Canvas tool\. Using cloud gems, you can build gameplay that connects to AWS services, such as Amazon DynamoDB, AWS Lambda, and Amazon S3\.

For more information, see [Implementing Connected Features with Cloud Canvas](cloud-canvas-intro.md)\.

### AWS SDK for C\+\+<a name="lumberyard-aws-sdk"></a>

The AWS SDK for C\+\+ provides C\+\+ API operations for numerous AWS services including Amazon S3, Amazon EC2, Amazon DynamoDB, and more, with support for all major native platforms\. You can use the SDK to integrate AWS components into your game\. 

For more information, see the [AWS SDK for C\+\+](https://aws.amazon.com/sdk-for-cpp/)\.

## Integrated with Twitch<a name="lumberyard-aws-twitch"></a>

Lumberyard is integrated with Twitch so that you can build games that engage with more than 1\.7 million monthly broadcasters and more than 100 million monthly viewers on Twitch\.

### Twitch ChatPlay<a name="lumberyard-aws-chatplay"></a>

The Twitch ChatPlay feature within Lumberyard helps you build gameplay that interacts in real time with Twitch viewers\. For example, you can build a game where viewers can vote on game outcomes, gift power\-ups to their favorite players, or change the level based on the number of viewers watching the player\.

For more information, see [Twitch ChatPlay System](chatplay-intro.md)\.

### Twitch JoinIn<a name="lumberyard-aws-joinin"></a>

The Twitch JoinIn feature within Lumberyard helps you build multiplayer games that allow Twitch broadcasters to invite fans to join them side by side in the game\. Once invited, a fan can jump into the broadcaster's game with a single click in the Twitch chat channel, while others continue to watch\.

For more information, see [Twitch JoinIn](chatplay-joinin.md)\.

## Free with Source<a name="lumberyard-aws-source"></a>

Lumberyard is free, including source code\. You can customize Lumberyard for your team and vision for your project today, and for future projects\. There are no seat fees, subscription fees, or requirements to share revenue\. Only pay for the AWS services that you choose to use\.

For more information, see the [Lumberyard Licensing FAQ](https://aws.amazon.com/lumberyard/faq/#licensing)\.