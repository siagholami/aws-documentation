--------

--------

# Service Modeling 101<a name="iot-tg-models-service101"></a>

This topic describes what you need to think about and plan for when you're creating models for the services that you want to include in your flows\. We use two example services, one that exposes a capability of the Amazon Rekognition service and another that implements an AWS Lambda function\. The approaches that this topic takes to modeling services can be applied to other AWS services and Lambda functions\.

The [ServiceModels101\.zip](samples/ServiceModels101.zip) file contains all of the GraphQL code discussed in this topic\.

**Note**  
The Amazon Rekognition and `getS3Lambda` service models discussed in this topic are available in the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home)\. The example in [Creating a Flow with Lambda Functions](iot-tg-gs-lambda-sample.html) uses the `getS3Lambda` service discussed here\. The example in [Creating a Flow with Devices and a Service](iot-tg-gs-thingdev-sample.html) uses the Amazon Rekognition service discussed in this topic\.

## Modeling an AWS Service<a name="iot-tg-models-service101-aws"></a>

[Amazon Rekognition](https://docs.aws.amazon.com/rekognition/latest/dg/) is a machine learning service that can identify objects, people, text, scenes, and activities\. It supports REST requests to endpoints that expose each of its capabilities\. The example in this topic implements the Amazon Rekognition `DetectFaces` API as an AWS IoT Things Graph service\. 

Before you get started writing your model, you need to understand the requirements of the underlying AWS service\. You can find this information in the [Amazon Rekognition API Reference](https://docs.aws.amazon.com/rekognition/latest/dg/API_Reference.html)\.

### Understand the Underlying Service<a name="iot-tg-models-service101-aws-understand"></a>

The following table from the first page of the *Amazon Rekognition API Reference* contains the headers that you need to add to every HTTP operation in the API\.


| Header | Value | Description | 
| --- | --- | --- | 
|  Content\-Type:  |  application/x\-amz\-json\-1\.1  |  Specifies that the request content is in JavaScript Object Notation \(JSON\)\. Also specifies the JSON version\.  | 
|  X\-Amz\-Date:  |  <Date>  |  The date used to create the signature in the Authorization header\. The format must be ISO 8601 basic in the `YYYYMMDD'T'HHMMSS'Z'` format\. For example, the following date/time `20141123T120000Z` is a valid `x-amz-date` for use with Amazon Rekognition\.   | 
|  X\-Amz\-Target:  |  RekognitionService\.<operation>  |  The target Amazon Rekognition operation\. For example, use `RekognitionService.ListCollections` to call the `ListCollections` operation\.  | 

Your service model must include these parameters in the calls that it makes to the `DetectFaces` API\. The AWS IoT Things Graph runtime adds the `X-Amz-Date` header to your requests automatically, so your model doesn't have to account for that\. Therefore, your HTTP request definition will include the following header parameters\.

```
headerParams {
  param(name:"Accept", property:"urn:tdm:aws:Property:String", value:"application/json")
  param(name:"Content-Type", property:"urn:tdm:aws:Property:String", value:"application/x-amz-json-1.1")
  param(name:"X-Amz-Target", property:"urn:tdm:aws:Property:String", value:"RekognitionService.DetectFaces")
}
```

The `headerParams` block sets the required header parameters of the request\. Amazon Rekognition requires you to specify the `x-amz-json-1.1` content type and the REST endpoint \(`X-Amz-Target`\) for the capability that you want to use \(`RekognitionService.DetectFaces`\)\. In this example, the AWS IoT Things Graph service expects a return value of `json`, so you also include an `Accept` header\.

Next, you need to look at the reference documentation for the [`DetectFaces` API](https://docs.aws.amazon.com/rekognition/latest/dg/API_DetectFaces.html)\. This API requires you to pass an [image](https://docs.aws.amazon.com/rekognition/latest/dg/API_Image.html) as either a BLOB \(a Base64\-encoded binary data object\) or as an [S3Object](https://docs.aws.amazon.com/rekognition/latest/dg/API_S3Object.html)\. This example service passes an Amazon S3 object, so the HTTP request definition includes the following body parameters\.

```
bodyParams {
  param(name:"", property:"urn:tdm:aws:Property:String",
  value:"$macro({\"Image\":{\"S3Object\":{\"Bucket\":\"${bucketName.value}\",\"Name\":\"${itemName.value}\"}}})")
}
```

The `bodyParams` block can define the name\-value pairs separately, or you can pass the name\-value pairs in a JSON object\. This example uses a JSON object, which is why the `name` attribute is an empty string\. The `$macro` function replaces placeholders wrapped inside curly braces and prepended by dollar signs \(`${}`\) with variables whose values are supplied by the service activity\. The service that we're defining requires the Amazon S3 bucket name and item name \(also called the S3 object key name\) to be supplied as parameters to its activity\.

### Define the Action<a name="iot-tg-models-service101-aws-action"></a>

Now that you understand the requirements of the AWS service that you're implementing as an AWS IoT Things Graph service, you can define the action or actions to implement in your service model\. 

The following GraphQL shows how to define the `DetectFaces` [action](iot-tg-models-tdm-iot-action.html)\.

```
type DetectFaces @actionType(id: "urn:tdm:aws/examples:action:DetectFaces") {
    bucketName: String @property(id: "urn:tdm:aws:Property:String")
    itemName: String @property(id: "urn:tdm:aws:Property:String")
    return: RkgnResponseProperty @property(id: "urn:tdm:aws:Property:Json")
}
```

The `@actionType` directive assigns a URN value that uniquely identifies the new action\. The `DetectFaces` action consists of two string properties that set the Amazon S3 bucket and item names\. The `return` keyword assigns a name to the return value \(`RkgnResponseProperty`\) and sets its property type to JSON\.

### Define the Capability<a name="iot-tg-models-service101-aws-capability"></a>

Like a device, an AWS IoT Things Graph service implements a capability\. Your service capability consists of the actions that you defined for it\. The following GraphQL defines an Amazon Rekognition capability that contains the `DetectFaces` action that you just defined\.

```
type RekognitionCap @capabilityType(id: "urn:tdm:aws/examples:capability:RekognitionCap") {
    detectFaces: DetectFaces @action(id: "urn:tdm:aws/examples:action:DetectFaces")
}
```

### Define the Service Model<a name="iot-tg-models-service101-aws-service"></a>

At this point you have the pieces you need to create the full service model\. Your service model implements the `RekognitionCap` capability that you just created\. You enable interaction with the service by specifying `REST` as the communication protocol inside the service definition\. We've already seen the pieces of the service model that set the header and body parameters of the HTTP request to the REST service\. You just need to put all of the pieces together and make sure that the appropriate parameters are passed to the device action\.

```
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

The `REST` keyword inside the `@service` declaration defines this as an HTTP AWS IoT Things Graph service that uses a REST interface to make calls to the underlying AWS service\. The `Action` name corresponds with the name of the action in the `RekognitionCap` capability definition\.

The `HttpPost` block contains the `Request` and `Response` definitions\. We've already seen the `headerParams` and `bodyParams` blocks\. The `$macro` function used to compose the HTTP request URL substitutes the `${systemConfig.awsRegion}` placeholder with the user's AWS Region\. \(You can also use `$systemConfig.accountId` when you need to retrieve the user's account ID\.\)

If the underlying web service is an AWS service, the `Request` block also requires values for `auth` and `awsServiceName`\. Signature Version 4 \(SigV4\) is how AWS authenticates information sent in HTTP requests\. Currently authentication is supported only for AWS services\.

The `Response` block sets the content type of the HTTP response as a JSON object\. This corresponds with the return type that you specified in the `DetectFaces` action definition\.

The `params` block contains the two parameters that must be sent to the service when it's used in a flow\. In [Creating a Flow with Devices and a Service](iot-tg-gs-thingdev-sample.html), the `WebServiceActivity` definition for the Amazon Rekognition service model \(which you add when you're creating the flow\) retrieves these values from the `CameraRkgnExample` device\.

```
{
  WebserviceActivity(webservice: "urn:tdm:aws/examples:service:Rekognition", out: "rekognitionResult") {
    detectFaces(bucketName: "${cameraResult.s3BucketName}", itemName: "${cameraResult.s3ItemName}")
  }
}
```

The `WebServiceActivity` definition expects the camera to send the image as an Amazon S3 bucket\. Your own flow might need to work differently, and your camera might not be able to pass images in this way\. If your camera sends images in another format, your `DetectFaces` action will need to contain other properties to account for the differences\.

The example in [Creating a Flow with Devices and a Service](iot-tg-gs-thingdev-sample.html) doesn't do anything with the Amazon Rekognition response\. It simply passes the image to the screen device\. You could fill in this gap by writing an AWS Lambda function that processes the results and applies logic before sending the image to the screen\. You could include this function in your flow if you implement it as an AWS IoT Things Graph service\. The following section shows you how to do that\.

## Modeling an AWS Lambda Function<a name="iot-tg-models-service101-lambda"></a>

An AWS IoT Things Graph service that implements a Lambda function has most of the same components as one that implements an AWS service\. Because you write the underlying Lambda function, you have more control over what values it can take as inputs and return as outputs\. The `getS3Lambda` service discussed in this example is used by the example in [Creating a Flow with Lambda Functions](iot-tg-gs-lambda-sample.html)\. The code for this function is available for download in the [Lambdas\.zip](samples/Lambdas.zip) file\. You can use the sample code in that file to get started working with Lambda functions as AWS IoT Things Graph services\.

### Model the Lambda Function as an Action<a name="iot-tg-models-service101-lambda-understand"></a>

The `getS3Lambda` service implements a Lambda function with the same name\. Like the Amazon Rekognition service discussed in the preceding section, this function also takes Amazon S3 bucket and object names as parameters\. In this case, the parameters are named `bucket` and `key`, as in the following snippet from the function\.

```
    const params = {
        Bucket: bucket,
        Key: key,
    };
```

The service model definition needs a corresponding `params` section in its action block\.

```
params {
  param(name: "bucket", property:"urn:tdm:aws:property:String")
  param(name: "key", property:"urn:tdm:aws:property:String")
}
```

The `getS3Lambda` code fetches the object from the bucket and returns an object that contains its value as a string and the length of the string\. The following GraphQL shows the corresponding action definition\.

```
type getS3ObjectAsStringAction @actionType(id: "urn:tdm:aws/examples:action:getS3ObjectAsStringAction") {
    bucket: String @property(id: "urn:tdm:aws:property:String"),
    key : String @property(id: "urn:tdm:aws:property:String"),
    return : getS3ObjectAsStringResponse @property(id: "urn:tdm:aws/examples:property:getS3ObjectAsStringResponse")
}
```

The `@actionType` directive assigns a URN value that uniquely identifies the new action\. The `getS3ObjectAsStringAction` action consists of two string properties that set the Amazon S3 bucket and object names\. The `return` keyword assigns a name to the return value \(`getS3ObjectAsStringResponse`\) and sets its property type to `urn:tdm:aws/examples:property:getS3ObjectAsStringResponse`\. This is not a built\-in property type\. It's a complex property that contains both the string and the length\. You need to define this property type\. 

### Define a Complex Property<a name="iot-tg-models-service101-lambda-createprop"></a>

Complex properties are created as instances of states\. States, in turn, consist of the properties that you want to include in your complex property\. 

You begin by creating a state that contains string and `Int32` values that represent the content of the Amazon S3 object and the length of the string\.

```
type S3ObjectDocument @stateType(id : "urn:tdm:aws/examples:State:S3ObjectDocument") {
    message: String @property(id: "urn:tdm:aws:property:String"),
    length: Int @property(id: "urn:tdm:aws:Property:Int32")
}
```

This state consists of a `String` property named `message` and an `Int32` property named `length`\. Now you can create a complex property that is an instance of this state\.

```
type getS3ObjectAsStringResponse @propertyType(id: "urn:tdm:aws/examples:property:getS3ObjectAsStringResponse" instanceOf: "urn:tdm:aws/examples:State:S3ObjectDocument") {ignore:void}
```

### Define the Capability<a name="iot-tg-models-service101-aws-capability"></a>

Like a device, an AWS IoT Things Graph service implements a capability\. Your service capability consists of the actions that you defined for it\. The following GraphQL defines a capability that contains the `getS3ObjectAsStringAction` action that you just created\.

```
type getS3Capability @capabilityType(id: "urn:tdm:aws/examples:capability:getS3Capability") {
    getS3ObjectAsString : getS3ObjectAsStringAction @action(id: "urn:tdm:aws/examples:action:getS3ObjectAsStringAction")
}
```

### Define the Service Model<a name="iot-tg-models-service101-lambda-service"></a>

At this point you have the pieces you need to create the full service model\. Your service model implements the `getS3Capability` capability that you just created\. We've already seen the parts of the service model that send the `bucket` and `key` values to the service\. You just need to put everything together and ensure that the appropriate parameters are passed to the service action\. 

You enable interaction with the Lambda function by specifying `AwsLambda` as the communication protocol inside the service definition\. If your Lambda function runs in a AWS IoT Greengrass group, specify `InvokeGreengrassLambda` inside the `Action` block\. If your Lambda function runs in the cloud, specify `InvokeCloudLambda` instead\.

```
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

The `AwsLambda` keyword inside the `@service` declaration defines this as an AWS IoT Things Graph service that implements an AWS Lambda function\. The `Action` name corresponds with the name of the action in the `getS3Capability` capability definition\. 

The `InvokeGreengrassLambda` block contains the `Request` and `Response` definitions\. The `$macro` function used to compose the ARN of the Lambda function substitutes the `${systemConfig.awsRegion}` and `$systemConfig.accountId` placeholders with the user's AWS Region and account ID\. This example service assumes that the user has created a Lambda function named `GetS3Object`\. It also requires the user to use version 1 of that function\.

You can use a Lambda function that runs in the cloud with the `InvokeCloudLambda` block, which works in the same way\.

The `Response` block sets the content type of the response as the `getS3ObjectAsStringResponse` property that you created\. This corresponds with the return type that you specified in the `getS3ObjectAsStringAction` action definition\.

The `params` block contains the two parameters that must be sent to the service when it's used in a flow\. In [Creating a Flow with Lambda Functions](iot-tg-gs-lambda-sample.html), the `WebServiceActivity` definition for the `getS3Object` service model \(which you add when you're creating the flow\) sets these values\.

```
{
      WebserviceActivity(webservice: "urn:tdm:aws/examples:Service:getS3Lambda", out: "getS3LambdaResult") {
        getS3ObjectAsString(bucket: "tg-test-gg", key: "HelloWorld.txt")
      }
}
```

The [ServiceModels101\.zip](samples/ServiceModels101.zip) file contains all of the GraphQL code discussed in this topic\. Download it to work with it, and then upload it to AWS IoT Things Graph yourself\. 