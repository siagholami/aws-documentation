# DeepLens\_Kinesis\_Video\.createProducer Function<a name="dkv-create-producer-method"></a>

Creates an instance of the Kinesis Video Streams Producer SDK client object for AWS DeepLens\. Use the instance to connect your AWS DeepLens device to the AWS Cloud and to manage video streams from the device to Kinesis Video Streams\. 

**Syntax**

```
import DeepLens_Kinesis_Video as dkv
producer = dkv.createProducer(aws_access_key, aws_seccrete_key, session_token, aws_region)
```

**Parameters**
+ `aws_access_key`

  Type: "string"

  Required: Yes

  The IAM access key of your AWS account\.
+ `aws_secret_key`

  Type: "string"

  Required: Yes

  The IAM secret key of your AWS account\.
+ `session_token`

  Type: "string"

  Required: No

  A session token, if any\. An empty value means an unspecified token\.
+ `aws_region`

  Type: "string"

  Required: Yes

  The AWS Region to stream data to\. For AWS DeepLens applications, the only valid value is `us-east-1`\.

**Returns**
+ A [`Producer` object\.](dkv-producer-object.md)

**Example**

```
import DeepLens_Kinesis_Video as dkv
producer = dkv.createProducer("ABCDEF...LMNO23PU", "abcDEFGHi...bc8defGxhiJ", "", "us-east-1")
```