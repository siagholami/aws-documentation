--------

--------

# Service<a name="iot-tg-models-tdm-iot-service"></a>

The `Service` construct describes either an AWS Lambda or a RESTful web service that can be called from a [Workflow](iot-tg-models-tdm-iot-workflow.html)\. 

Conceptually a `Service` is analogous to a [Device](iot-tg-models-tdm-iot-device.html), because it can be called inside a workflow step\. The structure of a `Service` is also similar to that of a `Device`\. The primary difference is that the `Action` of a `Service` is a call to the web service or an invocation of a Lambda function\. The `Service` structure contains the input and output parameters of the web service or Lambda call\.

The following example creates a `Service` that invokes a Lambda function\. The Lambda function uses [Amazon Rekognition](https://docs.aws.amazon.com/rekognition/latest/dg/) to match an image passed from the workflow with another image\.

```
query MlLambdas @service(id: "urn:tdm:aws:service:MlLambdas") {                                           # Service URN
AwsLambda {                                                                                                         # Service type
    MlLambdasCap(id: "urn:tdm:aws:capability:MlLambdasCap") {                                             # Name and URN of capability
        Action(name: "matchImage") {                                                                                # Action name and implementation
            InvokeCloudLambda {
                Request(arn: "arn:aws:lambda:us-west-2:567471678322:function:rekognition:1") {                      # Lambda function ARN
                    params {
                        param(name: "imageUri", property: "urn:tdm:aws:property:Uri", value: "url")       # Request parameters
                    }
                }
                Response {                                  
                    responsePayload(property: "urn:tdm:aws:property:Boolean")                                       # Response payload type
                }
            }
        }
    }
}
}
```

This example contains the following key elements:
+ The URN that uniquely identifies the service\.
+ The service type\. Possible values are `AwsLambda` and `REST`\.
+ The name and unique identifier \(URN\) of the capability that the service implements\.
+ The `Action` name and implementation\.
+ The `InvokeCloudLambda` action specification\. In an `AWSLambda` service, possible values are `InvokeCloudLambda` and `InvokeGreengrassLambda`\.
+ The `Request` definition, which specifies the payload that is sent to the Lambda function\. This definition contains the following elements:
  + The Amazon Resource Name \(ARN\) that specifies the Lambda function to call\.
  + The list of parameters to send as the request payload\. This example sends an image URI to the Lambda function to determine whether the image is a match\.
+ The `Response` payload definition\. This specifies the payload type whenever a response is expected\.

The following example creates a `Service` that calls a web service\. The web service creates a queue and then sends a message that contains the queue name\.

```
query Sqs @service(id: "urn:tdm:aws:service:Sqs") {                                                                                   # Service URN
REST {                                                                                                                                          # Service type
    SqsCap(id: "urn:tdm:aws:capability:SqsCap") {                                                                                     # Name and URN of capability
        Action(name: "createQueue") {
            HttpGet {                                                                                                                           # Action specification (REST verb)
                Request(url: "https://sqs.us-west-2.amazonaws.com/", auth: "SigV4") {                                                           # REST endpoint. Authentication type (SigV4)
                    headerParams {                                                                                                              # Header parameters
                        param(name: "host", property: "urn:tdm:aws:property:String", value: "sqs.us-west-2.amazonaws.com")
                        param(name: "x-amz-date", property: "urn:tdm:aws:property:String", value: "${tdm.lib.getDate()")
                    }
                    queryParams {                                                                                                               # Query parameters
                        param(name: "Action", property: "urn:tdm:aws:property:String", value: "CreateQueue")
                        param(name: "QueueName", property: "urn:tdm:aws:property:String", value: "queueName")
                        param(name: "Attribute.1.Name", property: "urn:tdm:aws:property:String", value: "VisibilityTimeout")
                        param(name: "Attribute.1.Value", property: "urn:tdm:aws:property:Integer", value: "40")
                        param(name: "Expires", property: "urn:tdm:aws:property:String", value: "2020-10-18T22:52:43PST")
                        param(name: "Version", property: "urn:tdm:aws:property:String", value: "2012-11-05")
                    }
                }
                Response {
                    responsePayload(property: "urn:tdm:aws:property:Boolean")                                                         # Response payload type
                }
            }
        }
        Action(name: "sendMessage") {
            HttpPost {                                                                                                                          # Action specification (REST verb)
                Request(url: "https://sqs.us-west-2.amazonaws.com/send", auth: "SigV4") {
                    headerParams {                                                                                                              # Header parameters
                        param(name: "host", property: "urn:tdm:aws:property:String", value: "sqs.us-west-2.amazonaws.com")
                        param(name: "x-amz-date", property: "urn:tdm:aws:property:String", value: "${tdm.lib.getDate()")
                    }
                    bodyParams {                                                                                                                # Body paramters
                        param(name: "title", property: "urn:tdm:aws:property:String", value: "title")
                        param(name: "body", property: "urn:tdm:aws:property:String", value: "queueName")
                        param(name: "timestamp", property: "urn:tdm:aws:property:String", value: "${tdm.lib.getTime()")
                    }
                }
                Response {
                    responsePayload(property: "urn:tdm:aws:property:Boolean")                                                         # Response payload type
                }
            }
        }
    }
}
}
```

This example contains the following key elements that differ from the AWS Lambda service\.
+ A `REST` service type\.
+ The action specifications\. These map to the corresponding REST verbs\. Possible values are `HttpGet` and `HttpPost`\.
+ The `Request` definition contains two new arguments:
  + The URL to which the REST request will be sent\.
  + The type of authentication to use when making the REST request\.
+ The `Request` definition contains three kinds of parameter lists:
  + A list of `headerParams` that defines the request headers\.
  + A list of `queryParams` that defines the query string parameters\.
  + A list of `bodyParams` that defines the request body\.
**Note**  
Some of these parameters use path expressions to get the current date and time, as well as macro expressions to interpolate the resulting values into strings\. For more information, see [Expressions](iot-tg-models-tdm-expressions.html)\.

You implement a service in a [Workflow](iot-tg-models-tdm-iot-workflow.html) in a way that is nearly identical to a device implementation\. See the `WebServiceActivity` implementation in [Workflow](iot-tg-models-tdm-iot-workflow.html) for a sample implementation of a `Service`\. 