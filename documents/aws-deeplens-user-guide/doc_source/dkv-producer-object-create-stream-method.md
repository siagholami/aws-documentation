# Producer\.createStream Method<a name="dkv-producer-object-create-stream-method"></a>

Creates a Kinesis Video Streams stream object to send video feeds from the AWS DeepLens device to\.

**Syntax**

```
stream = [producer](dkv-producer-object.md).createStream(stream_name, retention)
```

**Parameters**
+ `stream_name`

  Type: "string"

  Required: Yes

  The name of a Kinesis stream that your AWS DeepLens device sends video feeds to\. If the stream doesn't exist, Kinesis Video Streams creates it\. Otherwise, it uses the existing stream to receive the video feeds\. You can have multiple streams as long as they have unique  names and handles\.
+ `retention`

  Type: int

  Required: Yes

  The time, in hours, to retain the streamed data\. To view the data in the **Stream Preview** on the Kinesis Video Streams console, set this parameter to greater than or equal to 2 hours\.

**Returns**
+ A [Stream](dkv-stream-object.md) object\.