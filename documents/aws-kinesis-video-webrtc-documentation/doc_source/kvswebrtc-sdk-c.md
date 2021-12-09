# WebRTC SDK in C for Embedded Devices<a name="kvswebrtc-sdk-c"></a>

The following step\-by\-step instructions describe how to download, build, and run the Kinesis Video Streams with WebRTC SDK in C for embedded devices and its corresponding samples\.

## Download the Kinesis Video Streams with WebRTC SDK in C<a name="gs-download-sdk"></a>

To download the Kinesis Video Streams with WebRTC SDK in C for embedded devices, run the following command:

```
$ git clone --recursive https://github.com/awslabs/amazon-kinesis-video-streams-webrtc-sdk-c.git
```

## Build the Kinesis Video Streams with WebRTC SDK in C<a name="gs-build-sdk"></a>

Complete the following steps:

****

1. Install cmake:
   + On macOS, run `brew install cmake` 
   + on Ubuntu, run `sudo apt-get install pkg-config cmake libcap2 libcap-dev`

1. Obtain the access key and the secret key of the AWS account that you want to use for this demo\.

1. Run the following command to create a `build` directory in your downloaded WebRTC C SDK, and execute `cmake` from it:

   ```
   mkdir -p amazon-kinesis-video-streams-webrtc-sdk-c/build; cd amazon-kinesis-video-streams-webrtc-sdk-c/build; cmake ..
   ```

1. Navigate to the `build` directory you just created with the step above, and run `make` to build the WebRTC C SDK and its provided samples\.

## Run the Samples for the WebRTC SDK in C<a name="gs-run-c-sample"></a>

After you complete the procedure above, you end up with the following sample applications in your `build` directory:
+ `kvsWebrtcClientMaster` \- This application sends sample H264/Opus frames \(path: /samples/h264SampleFrames and /samples/opusSampleFrames\) via the signaling channel\. It also accepts incoming audio, if enabled in the browser\. When checked in the browser, it prints the metadata of the received audio packets in your terminal\.
+ `kvsWebrtcClientViewer` \- This application accepts sample H264/Opus frames and prints them out\. 
+ `kvsWebrtcClientMasterGstSample` \- This application sends sample H264/Opus frames from a GStreamer pipeline\.

To run either of these samples, complete the following steps:

1. Setup your environment with your AWS account credentials:

   ```
   export AWS_ACCESS_KEY_ID= <Your AWS account access Key>
   export AWS_SECRET_ACCESS_KEY= <AWS account secret key>
   export AWS_KVS_CACERT_PATH= <Full path of your cert.pem file. It is typically available in the certs directory inside
   Kinesis-video-webrtc-native-build/certs/cert.pm>
   ```

1. Run either of the sample applications by passing to it the name that you want to give to your signaling channel\. The application creates the signaling channel using the name you provide\. For example, to create a signaling channel called `myChannel` and to start sending sample H264/Opus frames via this channel, run the following command: 

   ```
   ./kvsWebrtcClientMaster myChannel
   ```

   When the command line application prints `Connection established`, you can proceed to the next step\.

1. Now that your signaling channel is created and the connected master is streaming media to it, you can view this stream\. For example, you can view this live stream in a web application\. To do so, open the WebRTC SDK Test Page using the steps in [Using the Kinesis Video Streams with WebRTC Test Page](kvswebrtc-sdk-js.md#build-sdk-js) and set the following values using the same AWS credentials and the same signaling channel that you specified for the master above:
   + Access key ID
   + Secret access key
   + Signaling channel name
   + Client ID \(optional\)

   Choose **Start viewer** to start live video streaming of the sample H264/Opus frames\.