# Pipeline Activities<a name="pipeline-activities"></a>

The simplest functional pipeline connects a channel to a data store, which makes it a pipeline with two activities: a `channel` activity and a `datastore` activity\. You can achieve more powerful message processing by adding additional activities to your pipeline\.

AWS IoT Analytics provides the [RunPipelineActivity](api.md#cli-iotanalytics-runpipelineactivity) command which allows you to simulate the results of running a pipeline activity on a message payload you provide\. You might find this helpful when you are developing and debugging your pipeline activities\. [RunPipelineActivity Example](#aws-iot-analytics-run-pipeline-activity-eg) demonstrates how it is used\.

## Channel Activity<a name="aws-iot-analytics-pipeline-activities-channel"></a>

The first activity in a pipeline must be the `channel` activity which determines the source of the messages to be processed\.

```
{
    "channel": {
        "name": "MyChannelActivity",
        "channelName": "mychannel",
        "next": "MyLambdaActivity"
    }
}
```

## Datastore Activity<a name="aws-iot-analytics-pipeline-activities-datastore"></a>

The `datastore` activity, which specifies where to store the processed data, is the last activity\.

```
{
    "datastore": {
        "name": "MyDatastoreActivity",
        "datastoreName": "mydatastore"
    }
}
```

## Lambda Activity<a name="aws-iot-analytics-pipeline-activities-lambda"></a>

A `lambda` activity can be used to perform more complex processing on the message\. Examples include enriching the message with data from the output of external APIs or filtering the message based on logic from DynamoDB\. However, you can use this activity to perform any sort of message\-based processing, including filtering which messages are stored in the data store\.

The AWS Lambda function used in this activity *must* receive and return an array of JSON objects\. In the following example, the Lambda function modifies, and then returns, its `event` parameter\.

The `batchSize` determines how many messages your Lambda function receives on each invocation\. When you set it, keep in mind that an AWS Lambda function has a maximum timeout of five minutes\. So the Lambda function must be able to process all messages in the batch in less than five minutes\.

```
{
    "lambda": {
        "name": "MyLambdaActivity",
        "lambdaName": "mylambda",
        "batchSize": 10,
        "next": "MyDatastoreActivity"
    }
}
```

You must add a function policy to allow AWS IoT Analytics to invoke your Lambda function\. Use the following CLI command:

```
aws lambda add-permission --function-name <lambda-function-name> --statement-id <your-statement> --principal iotanalytics.amazonaws.com --action lambda:InvokeFunction
```

### Lambda Function Example 1<a name="aws-iot-analytics-pipeline-activities-lambda-ex1"></a>

In this example, the Lambda function adds additional information based on data in the original message\. Given a device that publishes a message with a payload similar to:

```
{
  "thingid": "00001234abcd",
  "temperature": 26,
  "humidity": 29,
  "location": {
    "lat": 52.4332935,
    "lon": 13.231694
  },
  "ip": "192.168.178.54",
  "datetime": "2018-02-15T07:06:01"
}
```

and the following pipeline definition:

```
{
    "pipeline": {
        "activities": [
            {
                "channel": {
                    "channelName": "foobar_channel",
                    "name": "foobar_channel_activity",
                    "next": "lambda_foobar_activity"
                }
            },
            {
                "lambda": {
                    "lambdaName": "MyAnalyticsLambdaFunction",
                    "batchSize": 5,
                    "name": "lambda_foobar_activity",
                    "next": "foobar_store_activity"
                }
            },
            {
                "datastore": {
                    "datastoreName": "foobar_datastore",
                    "name": "foobar_store_activity"
                }
            }
        ],
        "name": "foobar_pipeline",
        "arn": "arn:aws:iotanalytics:eu-west-1:123456789012:pipeline/foobar_pipeline"
    }
}
```

The following Lambda Python function \(MyAnalyticsLambdaFunction\) adds the GMaps URL and the temperature, in Fahrenheit, to the message:

```
import logging
import sys

# Configure logging
logger = logging.getLogger()
logger.setLevel(logging.INFO)
streamHandler = logging.StreamHandler(stream=sys.stdout)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
streamHandler.setFormatter(formatter)
logger.addHandler(streamHandler)

def c_to_f(c):
    return 9.0/5.0 * c + 32

def lambda_handler(event, context):
    logger.info("event before processing: {}".format(event))
    maps_url = 'N/A'

    for e in event:
        #e['foo'] = 'addedByLambda'
        if 'location' in e:
            lat = e['location']['lat']
            lon = e['location']['lon']
            maps_url = "http://maps.google.com/maps?q={},{}".format(lat,lon)

        if 'temperature' in e:
            e['temperature_f'] = c_to_f(e['temperature'])

        logger.info("maps_url: {}".format(maps_url))
        e['maps_url'] = maps_url

    logger.info("event after processing: {}".format(event))

    return event
```

### Lambda Function Example 2<a name="aws-iot-analytics-pipeline-activities-lambda-ex2"></a>

A useful technique is to compress and serialize message payloads to reduce transport and storage costs\. In this second example, the Lambda function assumes the message payload represents a JSON original which has been compressed and then base64\-encoded \(serialized\) as a string\. It returns the original JSON:

```
import base64
import gzip
import json
import logging
import sys

# Configure logging
logger = logging.getLogger()
logger.setLevel(logging.INFO)
streamHandler = logging.StreamHandler(stream=sys.stdout)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
streamHandler.setFormatter(formatter)
logger.addHandler(streamHandler)

def decode_to_bytes(e):
    return base64.b64decode(e)

def decompress_to_string(binary_data):
    return gzip.decompress(binary_data).decode('utf-8')

def lambda_handler(event, context):
    logger.info("event before processing: {}".format(event))

    decompressed_data = []

    for e in event:
        binary_data = decode_to_bytes(e)
        decompressed_string = decompress_to_string(binary_data)

        decompressed_data.append(json.loads(decompressed_string))

    logger.info("event after processing: {}".format(decompressed_data))

    return decompressed_data
```

## AddAttributes Activity<a name="aws-iot-analytics-pipeline-activities-addattributes"></a>

An `addAttributes` activity adds attributes based on existing attributes in the message\. This lets you alter the shape of the message before it is stored\. For example, you can use `addAttributes` to normalize data coming from different generations of device firmware\.

This is best explained by example\. Consider the input message:

```
{
    "device": {
        "id": "device-123",
        "coord": [ 47.6152543, -122.3354883 ]
    }
}
```

and an `addAttributes` activity that looks like this:

```
{
    "addAttributes": {
        "name": "MyAddAttributesActivity",
        "attributes": {
            "device.id": "id",
            "device.coord[0]": "lat",
            "device.coord[1]": "lon"
        },
        "next": "MyRemoveAttributesActivity"
    }
}
```

This activity moves the device ID to the root level and extracts the values in the `coord` array, promoting them to top\-level attributes called `lat` and `lon`\. As a result of this activity, the input message is transformed to the following:

```
{
    "device": {
        "id": "device-123",
        "coord": [ 47.6, -122.3 ]
    },
    "id": "device-123",
    "lat": 47.6,
    "lon": -122.3
}
```

The original device attribute is still present\. If you want to remove it, you can use the `removeAttributes` activity\.

## RemoveAttributes Activity<a name="aws-iot-analytics-pipeline-activities-removeattributes"></a>

A `removeAttributes` activity removes attributes from a message\. For example, given the message that was the result of the `addAttributes` activity:

```
{
    "device": {
        "id": "device-123",
        "coord": [ 47.6, -122.3 ]
    },
    "id": "device-123",
    "lat": 47.6,
    "lon": -122.3
}
```

To normalize that message so that it includes only the required data at the root level, use the following `removeAttributes` activity:

```
{
    "removeAttributes": {
        "name": "MyRemoveAttributesActivity",
        "attributes": [
            "device"
        ],
        "next": "MyDatastoreActivity"
    }
}
```

This results in the following message flowing along the pipeline:

```
{
    "id": "device-123",
    "lat": 47.6,
    "lon": -122.3
}
```

## SelectAttributes Activity<a name="aws-iot-analytics-pipeline-activities-selectattributes"></a>

The `selectAttributes` activity creates a new message using only the specified attributes from the original message\. Every other attribute is dropped\. `selectAttributes` creates new attributes under the root of the message only\. So given this message:

```
{
    "device": {
        "id": "device-123",
        "coord": [ 47.6152543, -122.3354883 ],
        "temp": 50,
        "hum": 40
    },
    "light": 90
}
```

and this activity:

```
{
    "selectAttributes": {
        "name": "MySelectAttributesActivity",
        "attributes": [
            "device.temp",
            "device.hum",
            "light"
        ],
        "next": "MyDatastoreActivity"
    }
}
```

The result is the following message flowing through the pipeline:

```
{
    "temp": 50,
    "hum": 40,
    "light": 90
}
```

Again, `selectAttributes` can only create root\-level objects\.

## Filter Activity<a name="aws-iot-analytics-pipeline-activities-filter"></a>

A `filter` activity filters a message based on its attributes\. The expression used in this activity looks like an SQL WHERE clause which *must* return a boolean:

```
{
    "filter": {
        "name": "MyFilterActivity",
        "filter": "temp > 40 AND hum < 20",
        "next": "MyDatastoreActivity"
    }
}
```

## DeviceRegistryEnrich Activity<a name="aws-iot-analytics-pipeline-activities-deviceregistryenrich"></a>

The `deviceRegistryEnrich` activity allows you to add data from the AWS IoT device registry to your message payload\. For example, given the following message:

```
{
    "temp": 50,
    "hum": 40,
    "device" {
        "thingName": "my-thing"
    }
}
```

and a `deviceRegistryEnrich` activity that looks like this:

```
{
    "deviceRegistryEnrich": {
        "name": "MyDeviceRegistryEnrichActivity",
        "attribute": "metadata",
        "thingName": "device.thingName",
        "roleArn": "arn:aws:iam::<your-account-number>:role:MyEnrichRole",
        "next": "MyDatastoreActivity"
    }
}
```

The output message now looks like this:

```
{
    "temp" : 50,
    "hum" : 40,
    "device" {
        "thingName" : "my-thing"
    },
    "metadata" : {
        "defaultClientId": "my-thing",
        "thingTypeName": "my-thing",
        "thingArn": "arn:aws:iot:us-east-1:<your-account-number>:thing/my-thing",
        "version": 1,
        "thingName": "my-thing",
        "attributes": {},
        "thingId": "aaabbbccc-dddeeef-gghh-jjkk-llmmnnoopp"
    }
}
```

You must specify a role in the `roleArn` field of the activity definition that has the appropriate permissions attached\. The role must have a permissions policy that looks like:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "iot:DescribeThing"
            ],
            "Resource": [
                "arn:aws:iot:<region>:<account-id>:thing/<thing-name>
            ]
        }
    ]
}
```

and a trust policy that looks like:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "",
            "Effect": "Allow",
            "Principal": {
                "Service": "iotanalytics.amazonaws.com"
            },
            "Action": [
                "sts:AssumeRole"
            ]
        }
    ]
}
```

## DeviceShadowEnrich Activity<a name="aws-iot-analytics-pipeline-activities-deviceshadowenrich"></a>

A `deviceShadowEnrich` activity adds information from the AWS IoT Device Shadows service to a message\. For example, given the message:

```
{
    "temp": 50,
    "hum": 40,
    "device": { "thingName": "my-thing" }
}
```

and the following `deviceShadowEnrich` activity:

```
{
    "deviceShadowEnrich": {
        "name": "MyDeviceShadowEnrichActivity",
        "attribute": "shadow",
        "thingName": "device.thingName",
        "roleArn": "arn:aws:iam::<your-account-number>:role:MyEnrichRole",
        "next": "MyDatastoreActivity"
    }
}
```

the result is a message that looks like this:

```
{
    "temp": 50,
    "hum": 40,
    "device": {
        "thingName": "my-thing"
    },
    "shadow": {
        "state": {
            "desired": {
                "attributeX": valueX, ...
            },
            "reported": {
                "attributeX": valueX, ...
            },
            "delta": {
                "attributeX": valueX, ...
            }
        },
        "metadata": {
            "desired": {
                "attribute1": {
                    "timestamp": timestamp
                }, ...
            },
            "reported": ": {
                "attribute1": {
                    "timestamp": timestamp
                }, ...
            }
        },
        "timestamp": timestamp,
        "clientToken": "token",
        "version": version
    }
}
```

You must specify a role in the `roleArn` field of the activity definition that has the appropriate permissions attached\. The role must have a permissions policy that looks like:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "iot:GetThingShadow"
            ],
            "Resource": [
                "arn:aws:iot:<region>:<account-id>:thing/<thing-name>
            ]
        }
    ]
}
```

and a trust policy that looks like:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "",
            "Effect": "Allow",
            "Principal": {
                "Service": "iotanalytics.amazonaws.com"
            },
            "Action": [
                "sts:AssumeRole"
            ]
        }
    ]
}
```

## Math Activity<a name="aws-iot-analytics-pipeline-activities-math"></a>

A `math` activity computes an arithmetic expression using the message's attributes\. The expression *must* return a number\. For example, given the following input message:

```
{
    "tempF": 50,
}
```

after processing by the following `math` activity:

```
{
    "math": {
        "name": "MyMathActivity",
        "math": "(tempF - 32) / 2",
        "attribute": "tempC",
        "next": "MyDatastoreActivity"
    }
}
```

the resulting message looks like:

```
{
    "tempF" : 50,
    "tempC": 9
}
```

## Math Activity Operators and Functions<a name="aws-iot-analytics-math-activity-fns"></a>

You can use the following operators in a `math` activity:


****  

|  |  | 
| --- |--- |
|   **\+**   |  addition  | 
|   **\-**   |  subtraction  | 
|   **\***   |  multiplication  | 
|   **/**   |  division  | 
|   **%**   |  modulo  | 

You can use the following functions in a `math` activity:

### abs\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-abs"></a>

Returns the absolute value of a number\.

Example: `abs(-5)` returns 5\.


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Int`, the absolute value of the argument\.  | 
|   `Decimal`   |   `Decimal`, the absolute value of the argument\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal`\. The result is the absolute value of the argument\. If the string cannot be converted, the result is `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### acos\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-acos"></a>

Returns the inverse cosine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Example: `acos(0)` = 1\.5707963267948966


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the inverse cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the inverse cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal`, the inverse cosine of the argument\. If the string cannot be converted, the result is `Undefined`\. Imaginary results are returned as `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### asin\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-asin"></a>

Returns the inverse sine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Example: `asin(0)` = 0\.0


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the inverse sine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the inverse sine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal` \(with double precision\), the inverse sine of the argument\. If the string cannot be converted, the result is `Undefined`\. Imaginary results are returned as `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### atan\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-atan"></a>

Returns the inverse tangent of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Example: `atan(0)` = 0\.0


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the inverse tangent of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the inverse tangent of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal`, the inverse tangent of the argument\. If the string cannot be converted, the result is `Undefined`\. Imaginary results are returned as `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### atan2\(Decimal, Decimal\)<a name="aws-iot-analytics-math-activity-fns-atan2"></a>

Returns the angle, in radians, between the positive x\-axis and the \(x, y\) point defined in the two arguments\.  The angle is positive for counter\-clockwise angles \(upper half\-plane, y > 0\), and negative for clockwise angles \(lower half\-plane, y < 0\)\. `Decimal` arguments are rounded to double precision before function application\.

Example: `atan2(1, 0)` = 1\.5707963267948966


****  

| Argument Type | Argument Type | Result | 
| --- | --- | --- | 
|   `Int` / `Decimal`   |   `Int` / `Decimal`   |   `Decimal` \(with double precision\), the angle between the x\-axis and the specified \(x,y\) point\.  | 
|   `Int` / `Decimal` / `String`   |   `Int` / `Decimal` / `String`   |   `Decimal`, the inverse tangent of the point described\. If a string cannot be converted, the result is `Undefined`\.  | 
|  Other Value  |  Other Value  |   `Undefined`\.  | 

### ceil\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-ceil"></a>

Rounds the given `Decimal` up to the nearest `Int`\.

Examples:

 `ceil(1.2)` = 2

 `ceil(11.2)` = \-1


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Int`, the argument value\.  | 
|   `Decimal`   |   `Int`, the `Decimal` value rounded up to the nearest `Int`\.  | 
|   `String`   |   `Int`\. The string is converted to `Decimal` and rounded up to the nearest `Int`\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Other Value  |   `Undefined`\.  | 

### cos\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-cos"></a>

Returns the cosine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Example:

 `cos(0)` = 1\.


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal` \(with double precision\), the cosine of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\. Imaginary results are returned as `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### cosh\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-cosh"></a>

Returns the hyperbolic cosine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Example: `cosh(2.3)` = 5\.037220649268761\.


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the hyperbolic cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the hyperbolic cosine of the argument\. Imaginary results are returned as `Undefined`\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal` \(with double precision\), the hyperbolic cosine of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\. Imaginary results are returned as `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### exp\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-exp"></a>

Returns e raised to the `Decimal` argument\. `Decimal` arguments are rounded to double precision before function application\.

Example: `exp(1)` = e\.


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), e ^ argument\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), e ^ argument\.  | 
|   `String`   |   `Decimal` \(with double precision\), e ^ argument\. If the `String` cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Other Value  |   `Undefined`\.  | 

### ln\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-ln"></a>

Returns the natural logarithm of the argument\. `Decimal` arguments are rounded to double precision before function application\.

Example: `ln(e)` = 1\.


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the natural log of the argument\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the natural log of the argument\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal` \(with double precision\), the natural log of the argument\. If the string cannot be converted to a `Decimal` the result is `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### log\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-log"></a>

Returns the base 10 logarithm of the argument\. `Decimal` arguments are rounded to double precision before function application\.

Example: `log(100)` = 2\.0\.


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the base 10 log of the argument\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the base 10 log of the argument\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal` \(with double precision\), the base 10 log of the argument\. If the `String` cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### mod\(Decimal, Decimal\)<a name="aws-iot-analytics-math-activity-fns-mod"></a>

Returns the remainder of the division of the first argument by the second argument\. You can also use "%" as an infix operator for the same modulo functionality\.

Example: `mod(8, 3)` = 2\.


****  

| Left Operand | Right Operand | Output | 
| --- | --- | --- | 
|   `Int`   |   `Int`   |   `Int`, the first argument modulo the second argument\.  | 
|   `Int` / `Decimal`   |   `Int` / `Decimal`   |   `Decimal`, the first argument modulo the second operand\.  | 
|   `String` / `Int` / `Decimal`   |   `String` / `Int` / `Decimal`   |  If all strings convert to `Decimal`s, the result is the first argument modulo the second argument\. Otherwise, `Undefined`\.  | 
|  Other Value  |  Other Value  |   `Undefined`\.  | 

### power\(Decimal, Decimal\)<a name="aws-iot-analytics-math-activity-fns-power"></a>

Returns the first argument raised to the second argument\. `Decimal` arguments are rounded to double precision before function application\.

Example: `power(2, 5)` = 32\.0\.


****  

| argument Type 1 | argument Type 2 | Output | 
| --- | --- | --- | 
|   `Int` / `Decimal`   |   `Int` / `Decimal`   |  A `Decimal` \(with double precision\), the first argument raised to the second argument's power\.  | 
|   `Int` / `Decimal` / `String`   |   `Int` / `Decimal` `String`   |  A `Decimal` \(with double precision\), the first argument raised to the second argument's power\. Any strings are converted to `Decimal`s\. If any `String` fails to be converted to `Decimal`, the result is `Undefined`\.  | 
|  Other Value  |  Other Value  |   `Undefined`\.  | 

### round\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-round"></a>

Rounds the given `Decimal` to the nearest `Int`\. If the `Decimal` is equidistant from two `Int` values \(for example, 0\.5\), the `Decimal` is rounded up\.

Example: `Round(1.2)` = 1\.

 `Round(1.5)` = 2\.

 `Round(1.7)` = 2\.

 `Round(-1.1)` = \-1\.

 `Round(-1.5)` = \-2\.


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |  The argument\.  | 
|   `Decimal`   |   `Decimal` is rounded down to the nearest `Int`\.  | 
|   `String`   |   `Decimal` is rounded down to the nearest `Int`\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Other Value  |   `Undefined`\.  | 

### sign\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-sign"></a>

Returns the sign of the given number\. When the sign of the argument is positive, 1 is returned\. When the sign of the argument is negative, \-1 is returned\. If the argument is 0, 0 is returned\.

Examples:

 `sign(-7)` = \-1\.

 `sign(0)` = 0\.

 `sign(13)` = 1\.


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Int`, the sign of the `Int` value\.  | 
|   `Decimal`   |   `Int`, the sign of the `Decimal` value\.  | 
|   `String`   |   `Int`, the sign of the `Decimal` value\. The string is converted to a `Decimal` value, and the sign of the `Decimal` value is returned\. If the `String` cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Other Value  |   `Undefined`\.  | 

### sin\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-sin"></a>

Returns the sine of a number in radians\. `Decimal` arguments are rounded to double precision before function application\.

Example: `sin(0)` = 0\.0


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the sine of the argument\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the sine of the argument\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal` \(with double precision\), the sine of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|   `Undefined`   |   `Undefined`\.  | 

### sinh\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-sinh"></a>

Returns the hyperbolic sine of a number\. `Decimal` values are rounded to double precision before function application\. The result is a `Decimal` value of double precision\.

Example: `sinh(2.3)` = 4\.936961805545957


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the hyperbolic sine of the argument\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the hyperbolic sine of the argument\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal` \(with double precision\), the hyperbolic sine of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### sqrt\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-sqrt"></a>

Returns the square root of a number\. `Decimal` arguments are rounded to double precision before function application\.

Example: `sqrt(9)` = 3\.0\.


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |  The square root of the argument\.  | 
|   `Decimal`   |  The square root of the argument\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |  The square root of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### tan\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-tan"></a>

Returns the tangent of a number in radians\. `Decimal` values are rounded to double precision before function application\.

Example: `tan(3)` = \-0\.1425465430742778


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the tangent of the argument\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the tangent of the argument\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal` \(with double precision\), the tangent of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### tanh\(Decimal\)<a name="aws-iot-analytics-math-activity-fns-tanh"></a>

Returns the hyperbolic tangent of a number in radians\. `Decimal` values are rounded to double precision before function application\.

Example: `tanh(2.3)` = 0\.9800963962661914


****  

| Argument Type | Result | 
| --- | --- | 
|   `Int`   |   `Decimal` \(with double precision\), the hyperbolic tangent of the argument\.  | 
|   `Decimal`   |   `Decimal` \(with double precision\), the hyperbolic tangent of the argument\.  | 
|   `Boolean`   |   `Undefined`\.  | 
|   `String`   |   `Decimal` \(with double precision\), the hyperbolic tangent of the argument\. If the string cannot be converted to a `Decimal`, the result is `Undefined`\.  | 
|  Array  |   `Undefined`\.  | 
|  Object  |   `Undefined`\.  | 
|  Null  |   `Undefined`\.  | 
|  Undefined  |   `Undefined`\.  | 

### trunc\(Decimal, Int\)<a name="aws-iot-analytics-math-activity-fns-trunc"></a>

Truncates the first argument to the number of `Decimal` places specified by the second argument\. If the second argument is less than zero, it will be set to zero\. If the second argument is greater than 34, it will be set to 34\. Trailing zeroes are stripped from the result\.

Examples:

 `trunc(2.3, 0)` = 2\.

 `trunc(2.3123, 2` = 2\.31\.

 `trunc(2.888, 2)` = 2\.88\.

 `(2.00, 5)` = 2\.


****  

| argument Type 1 | argument Type 2 | Result | 
| --- | --- | --- | 
|   `Int`   |   `Int`   |  The source value\.  | 
|   `Int` / `Decimal` / `String`   |   `Int` / `Decimal`   |  The first argument is truncated to the length described by the second argument\. The second argument, if not an `Int`, will be rounded down to the nearest `Int`\. `String`s are converted to `Decimal` values\. If the string conversion fails, the result is `Undefined`\.  | 
|  Other Value  |  |   `Undefined`\.  | 

## RunPipelineActivity Example<a name="aws-iot-analytics-run-pipeline-activity-eg"></a>

Here is an example of how you would use the "RunPipelineActivity" command to test a pipeline activity\. For this example we test a Math activity:

1. Create a file "maths\.json" which contains the definition of the pipeline activity you want to test:

   ```
   {
       "math": {
           "name": "MyMathActivity",
           "math": "((temp - 32) * 5.0) / 9.0",
           "attribute": "tempC"
       }
   }
   ```

1. Create a file "payloads\.json" which contains the example payloads that are used to test the pipeline activity:

   ```
   [
       "{\"humidity\": 52, \"temp\": 68 }",
       "{\"humidity\": 52, \"temp\": 32 }"
   ]
   ```

1. Call "RunPipelineActivities" from the command line:

   ```
   aws iotanalytics run-pipeline-activity  --pipeline-activity file://maths.json  --payloads file://payloads.json
   ```

1. This produces the following results:

   ```
   {
       "logResult": "",
       "payloads": [
           "eyJodW1pZGl0eSI6NTIsInRlbXAiOjY4LCJ0ZW1wQyI6MjB9",
           "eyJodW1pZGl0eSI6NTIsInRlbXAiOjMyLCJ0ZW1wQyI6MH0="
       ]
   }
   ```

1. The "payloads" listed in the results are Base64\-encoded strings\. When these strings are decoded, you get the following results:

   ```
   {"humidity":52,"temp":68,"tempC":20}
   {"humidity":52,"temp":32,"tempC":0}
   ```