# WebRTC SDK in JavaScript for Web Applications<a name="kvswebrtc-sdk-js"></a>

You can find the Kinesis Video Streams with WebRTC SDK in JavaScript for web applications and its corresponding samples at [https://github\.com/awslabs/amazon\-kinesis\-video\-streams\-webrtc\-sdk\-js](https://github.com/awslabs/amazon-kinesis-video-streams-webrtc-sdk-js)\.

## Installing the WebRTC SDK in JavaScript<a name="install-sdk-js"></a>

To use the SDK in the browser, add the following script tag to your HTML pages:

```
<script src="https://unpkg.com/amazon-kinesis-video-streams-webrtc/dist/kvs-webrtc.min.js"></script>
```

The SDK classes are made available in the global window under the `KVSWebRTC` namespace\. For example, `window.KVSWebRTC.SignalingClient`\.

The SDK is also compatible with bundlers like Webpack\. Complete these steps to install the NodeJS module version\.

**To install the NodeJS module version**

1. The preferred way to install the SDK for NodeJS is to use the npm package manager\. Run the following command:

   ```
   npm install amazon-kinesis-video-streams-webrtc
   ```

1. The SDK classes can then be imported like typical NodeJS modules:

   ```
   // JavaScript
   const SignalingClient = require('amazon-kinesis-video-streams-webrtc').SignalingClient;
   
   // TypeScript
   import { SignalingClient } from 'amazon-kinesis-video-streams-webrtc';
   ```

## Using the Kinesis Video Streams with WebRTC Test Page<a name="build-sdk-js"></a>

The [https://github\.com/awslabs/amazon\-kinesis\-video\-streams\-webrtc\-sdk\-js](https://github.com/awslabs/amazon-kinesis-video-streams-webrtc-sdk-js) GitHub repo hosts a Kinesis Video Streams with WebRTC test page that you can use to create a new or connect to an existing signaling channel and use it as a master or viewer\.

The Kinesis Video Streams with WebRTC test page is located at [https://awslabs\.github\.io/amazon\-kinesis\-video\-streams\-webrtc\-sdk\-js/examples/index\.html](https://awslabs.github.io/amazon-kinesis-video-streams-webrtc-sdk-js/examples/index.html)\.

1. Open the [Kinesis Video Streams with WebRTC test page](https://awslabs.github.io/amazon-kinesis-video-streams-webrtc-sdk-js/examples/index.html) and specify the following information that you want to use for this demo:
   + AWS Region
   + The access key and the secret key of the AWS account that you want to use for this demo\.
   + The name of the signaling channel to which you want to connect\.
   + Whether you want to send audio, video, or both\.

1. If it's a new signaling channel, first choose **Create Channel**\. If it's an existing signaling channel, choose either **Start Master** or **Start Viewer** to connect to this channel either as a master or as a viewer\.

From there, refer to the example usage in the `examples` directory for how to write an end\-to\-end WebRTC application that uses the SDK\.

## Run the WebRTC Test Page Locally<a name="run-sdk-js"></a>

The SDK and test page can be edited and run locally by following these instructions\. NodeJS version 8\+ is required\.

1. Download the WebRTC SDK in JavaScript by running the following command:

   ```
   git clone https://github.com/awslabs/amazon-kinesis-video-streams-webrtc-sdk-js.git
   ```

1. Run `npm install` to download dependencies\.

1. Run `npm run develop` to run the webserver\.

You have to provide an AWS region, AWS credentials, and a Channel Name to use the WebRTC test page\.

The source code for the test page is in the `examples` directory\.