--------

--------

# getS3Lambda<a name="iot-tg-examples-gets3lambda"></a>

The following GraphQL shows the definition for the **getS3Lambda** service that is available in the AWS IoT Things Graph console\. This service is used in [Creating a Flow with Lambda Functions](iot-tg-gs-lambda-sample.html)\. 

```
# The getS3ObjectDocument state defines the fields in the response of the getS3ObjectAsString action.
# It contains the contents of a file as a string and the length of the string.
type S3ObjectDocument @stateType(id : "urn:tdm:aws/examples:State:S3ObjectDocument") {
    message: String @property(id: "urn:tdm:aws:property:String"),
    length: Int @property(id: "urn:tdm:aws:Property:Int32")
}

# Property representing the getS3OjbectDocument state.
type getS3ObjectAsStringResponse @propertyType(id: "urn:tdm:aws/examples:property:getS3ObjectAsStringResponse" 
    instanceOf: "urn:tdm:aws/examples:State:S3ObjectDocument") {ignore:void}

# The getS3ObjectAsStringAction takes Amazon S3 bucket and item names as input and returns the 
# contents of the file as a string.
type getS3ObjectAsStringAction @actionType(id: "urn:tdm:aws/examples:action:getS3ObjectAsStringAction") {
    bucket: String @property(id: "urn:tdm:aws:property:String"),
    key : String @property(id: "urn:tdm:aws:property:String"),
    return : getS3ObjectAsStringResponse @property(id: "urn:tdm:aws/examples:property:getS3ObjectAsStringResponse")
}

# The getS3Lambda capability.
type getS3Capability @capabilityType(id: "urn:tdm:aws/examples:capability:getS3Capability") {
    getS3ObjectAsString : getS3ObjectAsStringAction @action(id: "urn:tdm:aws/examples:action:getS3ObjectAsStringAction")
}

# Service definition for getS3Lambda. It's implemented as an AWS IoT Greengrass Lambda function.
query getS3Lambda @service(id: "urn:tdm:aws/examples:Service:getS3Lambda") {
    AwsLambda {
        getS3Capability(id: "urn:tdm:aws/examples:capability:getS3Capability") {
            Action(name: "getS3ObjectAsString") {
                params {
                    param(name: "bucket", property:"urn:tdm:aws:property:String")
                    param(name: "key", property:"urn:tdm:aws:property:String")
                }
                InvokeGreengrassLambda {
                    Request(arn:"$macro(arn:aws:lambda:${systemConfig.awsRegion}:${systemConfig.awsAccountId}:function:GetS3Object:1)") {
                        params {
                            param(name: "bucket", property:"urn:tdm:aws:property:String", value: "${bucket.value}")
                            param(name: "key", property:"urn:tdm:aws:property:String", value: "${key.value}")
                        }
                    }
                    Response {
                        responsePayload(property: "urn:tdm:aws/examples:property:getS3ObjectAsStringResponse")
                    }
                }
            }
        }
    }
}
```