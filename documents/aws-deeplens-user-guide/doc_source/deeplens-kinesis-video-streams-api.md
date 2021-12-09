# DeepLens\_Kinesis\_Video Module for Amazon Kinesis Video Streams Integration<a name="deeplens-kinesis-video-streams-api"></a>

The Amazon Kinesis Video Streams for AWS DeepLens Video library is a Python module that encapsulates [the Kinesis Video Streams Producer SDK](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/producer-sdk.html) for AWS DeepLens devices\. Use this module to send video feeds from an AWS DeepLens device to Kinesis Video Streams,and to control when to start and stop video streaming from the device\. This is useful if you need to train your own deep\-learning model\. In this case, you can send video feeds of given time intervals from your AWS DeepLens device to Kinesis Video Streams and use the data as an input for the training\. 

The module, DeepLens\_Kinesis\_Video, is already installed on your AWS DeepLens device\. You can call this module in a Lambda function that is deployed to your AWS DeepLens device as part of a AWS DeepLens project\. 

The following Python example shows how to use the DeepLens\_Kinesis\_Video module to stream five\-hour video feeds from the caller's AWS DeepLens device to Kinesis Video Streams\. 

```
import time
import os
import DeepLens_Kinesis_Video as dkv
from botocore.session import Session
import greengrasssdk

def greengrass_hello_world_run():
    # Create the green grass client so that we can send messages to IoT console
    client = greengrasssdk.client('iot-data')
    iot_topic = '$aws/things/{}/infer'.format(os.environ['AWS_IOT_THING_NAME'])

    # Stream configuration, name and retention
    # Note that the name will appear as deeplens-myStream
    stream_name = 'myStream'
    retention = 2 #hours

    # Amount of time to stream
    wait_time = 60 * 60 * 5 #seconds

    # Use the boto session API to grab credentials
    session = Session()
    creds = session.get_credentials()

    # Create producer and stream.
    producer = dkv.createProducer(creds.access_key, creds.secret_key, creds.token, "us-east-1")
    client.publish(topic=iot_topic, payload="Producer created")
    kvs_stream = producer.createStream(stream_name, retention)
    client.publish(topic=iot_topic, payload="Stream {} created".format(stream_name))

    # Start putting data into the KVS stream
    kvs_stream.start()
    client.publish(topic=iot_topic, payload="Stream started")
    time.sleep(wait_time)
    # Stop putting data into the KVS stream
    kvs_stream.stop()
    client.publish(topic=iot_topic, payload="Stream stopped")

# Execute the function above
greengrass_hello_world_run()
```

In this example, we call `dkv.createProducer` to instantiate the Kinesis Video Streams Producer SDK client\. We then call the `producer.createStream` to set up streaming from the AWS DeepLens device\. We control the length of video feeds by calling `my_stream.start`, `time.sleep` and `my_stream.stop`\. The stored video is retained in Kinesis Video Streams for two hours because we set the `retention` parameter to `2`\.

**Topics**
+ [DeepLens\_Kinesis\_Video\.createProducer Function](dkv-create-producer-method.md)
+ [Producer Object](dkv-producer-object.md)
+ [Stream Object](dkv-stream-object.md)