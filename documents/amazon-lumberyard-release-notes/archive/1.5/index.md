# Lumberyard Release Notes – Beta 1.5 (September 2016)<a name="lumberyard-v1.5"></a>

With Lumberyard Beta 1.5, we continue to add new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our developer community. Without your participation in the forums, your messages, and your bug reports, Lumberyard 1.5 wouldn't be as strong as it is. Keep sending your feedback to lumberyard-feedback@amazon.com. If you haven't spoken up on the [forums](https://forums.awsgametech.com/) yet, we would love to have you. You can also keep up with new changes on [our blog](https://aws.amazon.com/blogs/gametech/) and leave comments to let us know what you think.

**Topics**
+ [Highlights](#lumberyard-v1.5-highlights)
+ [Preview Systems and Tools](lumberyard-v1.5-preview-systems.md)
+ [Improvements and Changes](lumberyard-v1.5-changes.md)
+ [Fixes](lumberyard-v1.5-fixes.md)
+ [Known Issues](lumberyard-v1.5-known-issues.md)

## Highlights<a name="lumberyard-v1.5-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.5.

**Topics**
+ [New Sample Level Demonstrates Particle Effects](#lumberyard-v1.5-highlights-particles-sample-level)
+ [Search and Sort Game Sessions](#lumberyard-v1.5-highlights-gamelift)
+ [Updated Functionality for UI Canvases and Elements](#lumberyard-v1.5-highlights-ui-editor)
+ [Cloud Canvas Adds an AWS Resource Importer](#lumberyard-v1.5-highlights-cloud-canvas)
+ [AzTestScanner Supports Integration Tests](#lumberyard-v1.5-highlights-aztestscanner)

### New Sample Level Demonstrates Particle Effects<a name="lumberyard-v1.5-highlights-particles-sample-level"></a>

The Particles Sample level showcases particles from the various Lumberyard systems and demonstrates how to create high quality effects using simple and advanced features in the Particle Editor. Currently the sample level includes a fire effect and a laser effect, with plans to add more particles in the future. For more information, see [Samples Project](https://docs.aws.amazon.com/lumberyard/latest/userguide/sample-project-samples.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-fire-animation-example.gif)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/laser_anim.gif)

### Search and Sort Game Sessions<a name="lumberyard-v1.5-highlights-gamelift"></a>

Use Amazon GameLift's new game session search feature to find best matches for players or populate a game session browser. You can filter results based on session age, player slot availability, current player counts, and other characteristics. For more information, see [Working with Game Sessions](https://docs.aws.amazon.com/gamelift/latest/developerguide/game-sessions-intro.html).

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/gamelift_session_search.jpg)

### Updated Functionality for UI Canvases and Elements<a name="lumberyard-v1.5-highlights-ui-editor"></a>

Lumberyard Beta 1.5 adds a nudging ability to the UI Editor. Press an arrow key to move UI elements one pixel or **Shift**\+any arrow key to move UI elements 10 pixels. In addition, you can now flag UI canvases to render to a texture. This allows you to use the render target as a texture on a material and display a UI canvas on an object in the 3D world. For more information, see [UI System](https://docs.aws.amazon.com/lumberyard/latest/userguide/ui-editor-intro.html).

### Cloud Canvas Adds an AWS Resource Importer<a name="lumberyard-v1.5-highlights-cloud-canvas"></a>

Cloud Canvas provides a new AWS resource importer that allows you to create AWS resources directly from Lumberyard by importing using Amazon resource names or importing from a list.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/cloud_canvas_importer_arn.PNG)

You can import the following resources: 
+ DynamoDB table
+ Amazon S3 bucket
+ Lambda function
+ Amazon SNS topic
+ Amazon SQS queue

For more information, see [Cloud Canvas](https://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-intro.html).

### AzTestScanner Supports Integration Tests<a name="lumberyard-v1.5-highlights-aztestscanner"></a>

The AzTestScanner is a tool that you can use to run tests that are built into Lumberyard libraries and executables. The tool simplifies the process by automatically finding libraries and executables to test while allowing you to focus on testing Lumberyard areas of interest. The AzTestScanner now supports integration tests, which are run in the engine with the active project. For more information, see [Using AzTestScanner](https://docs.aws.amazon.com/lumberyard/latest/userguide/testing-aztestscanner.html).