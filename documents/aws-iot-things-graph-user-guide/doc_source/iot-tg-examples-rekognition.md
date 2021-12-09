--------

--------

# Amazon Rekognition DetectFaces API<a name="iot-tg-examples-rekognition"></a>

The following GraphQL shows the service definition for the [Amazon Rekognition](https://docs.aws.amazon.com/rekognition/latest/dg/) `DetectFaces` API that is available in the AWS IoT Things Graph console\. This service is used in [Creating a Flow with Devices and a Service](iot-tg-gs-thingdev-sample.html)\. 

```
# Amazon Rekognition DetectFaces action. This action takes Amazon S3 bucket and item names as input and 
# returns a JSON object that contains the response of the Amazon Rekognition DetectFaces API.
type DetectFaces @actionType(id: "urn:tdm:aws/examples:action:DetectFaces") {
    bucketName: String @property(id: "urn:tdm:aws:Property:String")
    itemName: String @property(id: "urn:tdm:aws:Property:String")
    return: RkgnResponseProperty @property(id: "urn:tdm:aws:Property:Json")
}

# Amazon Rekognition DetectFaces capability.
type RekognitionCap @capabilityType(id: "urn:tdm:aws/examples:capability:RekognitionCap") {
    detectFaces: DetectFaces @action(id: "urn:tdm:aws/examples:action:DetectFaces")
}

# Service definition for the Amazon Rekognition DetectFaces API.
query Rekognition @service(id:"urn:tdm:aws/examples:service:Rekognition") {
    REST {
        RekognitionCap(id:"urn:tdm:aws/examples:capability:RekognitionCap") {
            Action(name:"detectFaces") {
                params {
                    param(name:"bucketName", property:"urn:tdm:aws:Property:String")
                    param(name:"itemName", property:"urn:tdm:aws:Property:String")
                }
                HttpPost {
                    Request(url:"$macro(https://rekognition.${systemConfig.awsRegion}.amazonaws.com)", auth:"SigV4", awsServiceName:"rekognition") {
                        headerParams {
                            param(name:"Accept", property:"urn:tdm:aws:Property:String", value:"application/json")
                            param(name:"Content-Type", property:"urn:tdm:aws:Property:String", value:"application/x-amz-json-1.1")
                            param(name:"X-Amz-Target", property:"urn:tdm:aws:Property:String", value:"RekognitionService.DetectFaces")
                        }
                        bodyParams {
                            param(name:"", property:"urn:tdm:aws:Property:String",
                               value:"$macro({\"Image\":{\"S3Object\":{\"Bucket\":\"${bucketName.value}\",\"Name\":\"${itemName.value}\"}}})")
                        }
                    }
                    Response {
                        responsePayload(property:"urn:tdm:aws:Property:Json")
                    }
                }
            }
        }
    }
}
```