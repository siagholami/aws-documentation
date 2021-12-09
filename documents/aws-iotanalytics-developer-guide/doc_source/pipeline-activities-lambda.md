# AWS Lambda activity<a name="pipeline-activities-lambda"></a>

You can use a `lambda` activity to perform more complex processing on the message\. For example, you can enrich the message with data from the output of external APIs or filter the message based on logic from Amazon DynamoDB\. However, you can use this activity to perform any sort of message\-based processing, including filtering which messages are stored in the data store\. 

The AWS Lambda function used in this activity must receive and return an array of JSON objects\. In the following example, the Lambda function modifies and then returns its `event` parameter\.

The `batchSize` determines how many messages your Lambda function receives on each invocation\. When you set it, keep in mind that a Lambda function has a maximum timeout of 900 seconds\. So the Lambda function must be able to process all messages in the batch in less than 900 seconds\.

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

You must add a policy to grant AWS IoT Analytics permission to invoke your Lambda function\. Run the following command and replace *function\-name* with the name of your Lambda function\.

```
aws lambda add-permission --function-name function-name --action lambda:InvokeFunction 
   --statement-id iotanalytics --principal iotanalytics.amazonaws.com
  
# Output
{
    "Statement": "{\"Sid\":\"iotanalytics\",\"Effect\":\"Allow\",\"Principal\":{\"Service\":\"iotanalytics.amazonaws.com\"},\"Action\":\"lambda:InvokeFunction\",\"Resource\":\"arn:aws:lambda:aws-region:account-id:function:function-name\"}"
}
```

For more information, see [Using resource\-based policies for AWS Lambda](https://docs.aws.amazon.com/lambda/latest/dg/access-control-resource-based.html) in the *AWS Lambda Developer Guide*\.

## Lambda function example 1<a name="pipeline-activities-lambda-ex1"></a>

In this example, the Lambda function adds additional information based on data in the original message\. A device publishes a message with a payload similar to the following example\.

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

And the device has the following pipeline definition\.

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

The following Lambda Python function \(`MyAnalyticsLambdaFunction`\) adds the GMaps URL and the temperature, in Fahrenheit, to the message\.

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

## Lambda function example 2<a name="pipeline-activities-lambda-ex2"></a>

A useful technique is to compress and serialize message payloads to reduce transport and storage costs\. In this second example, the Lambda function assumes the message payload represents a JSON original, which has been compressed and then base64\-encoded \(serialized\) as a string\. It returns the original JSON\.

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