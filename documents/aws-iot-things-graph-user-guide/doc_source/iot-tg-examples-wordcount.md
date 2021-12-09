--------

--------

# wordCount<a name="iot-tg-examples-wordcount"></a>

The following GraphQL shows the definition for the **wordCount** service that is available in the AWS IoT Things Graph console\. This service is used in [Creating a Flow with Lambda Functions](iot-tg-gs-lambda-sample.html)\. 

```
# The wordCountResponseStructure state defines the structure of the wordCountAction response.
type wordCountResponseStructure @stateType(id: "urn:tdm:aws/examples:State:wordCountResponseStructure") {
    uniqueWordsCount: Int @property(id: "urn:tdm:aws:Property:Int32"),
    mostFrequentWord: String @property(id: "urn:tdm:aws:property:String"),
    mostFrequentWordFrequency: Int @property(id: "urn:tdm:aws:Property:Int32")
}

# Property representing the wordCountResponseStructure state. 
type wordCountResponse @propertyType(id: "urn:tdm:aws/examples:property:wordCountResponse" 
    instanceOf: "urn:tdm:aws/examples:State:wordCountResponseStructure") {ignore:void}

# The wordCountAction takes a string as input and returns the number of unique words and the 
# most frequently used word in the string.
type wordCountAction @actionType(id: "urn:tdm:aws/examples:action:wordCountAction") {
    message: String @property(id: "urn:tdm:aws:property:String"),
    return: wordCountResponse @property(id: "urn:tdm:aws/examples:property:wordCountResponse")
}

# The wordCount capability.
type wordCountCapability @capabilityType(id: "urn:tdm:aws/examples:capability:wordCountCapability") {
    wordCount : wordCountAction @action(id: "urn:tdm:aws/examples:action:wordCountAction")
}

# Service definition for wordCount. It's implemented as an AWS IoT Greengrass Lambda function.
query wordCount @service(id: "urn:tdm:aws/examples:Service:wordCountLambda") {
    AwsLambda {
            wordCountCapability(id: "urn:tdm:aws/examples:capability:wordCountCapability") {
                Action(name: "wordCount") {
                    params {
                        param(name: "message", property:"urn:tdm:aws:property:String")
                    }
                    InvokeGreengrassLambda {
                        Request(arn: "$macro(arn:aws:lambda:${systemConfig.awsRegion}:${systemConfig.awsAccountId}:function:WordCount:1)") {
                            params {
                                param(name: "message", property:"urn:tdm:aws:property:String", value: "${message.value}")
                            }
                        }
                        Response {
                            responsePayload(property: "urn:tdm:aws/examples:property:wordCountResponse")
                        }
                    }
                }
            }
        }
}
```