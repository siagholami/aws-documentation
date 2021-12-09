--------

--------

# saveResponse<a name="iot-tg-examples-saveresponse"></a>

The following GraphQL shows the definition for the **saveResponse** service that is available in the AWS IoT Things Graph console\. This service is used in [Creating a Flow with Lambda Functions](iot-tg-gs-lambda-sample.html)\. 

This definition assumes that the **wordCount** service is already defined\. 

```
# The saveResponseAction takes the response of the wordCount service as input and saves it to a location
# in Amazon S3 that is specified in the AWS Lambda function that the service exposes.
type saveResponseAction @actionType(id: "urn:tdm:aws/examples:action:saveResponseAction") {
    response: wordCountResponse @property(id: "urn:tdm:aws/examples:property:wordCountResponse")
}

# The saveResponse capability.
type saveResponseCapability @capabilityType(id: "urn:tdm:aws/examples:capability:saveResponseCapability") {
    save: saveResponseAction @action(id: "urn:tdm:aws/examples:action:saveResponseAction")
}

# Service definition for saveResponse. It's implemented as an AWS IoT Greengrass Lambda function.
query saveResponse @service(id: "urn:tdm:aws/examples:Service:saveResponseLambda") {
    AwsLambda {
                saveResponseCapability(id: "urn:tdm:aws/examples:capability:saveResponseCapability") {
                    Action(name: "save") {
                        params {
                            param(name: "response", property:"urn:tdm:aws/examples:property:wordCountResponse")
                        }
                        InvokeGreengrassLambda {
                            Request(arn: "$macro(arn:aws:lambda:${systemConfig.awsRegion}:${systemConfig.awsAccountId}:function:SaveToS3:1)") {
                                params {
                                    param(name: "response", property:"urn:tdm:aws/examples:property:wordCountResponse", value: "${response.value}")
                                }
                            }
                        }
                    }
                }
            }
}
```