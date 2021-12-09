# DetectText<a name="API_DetectText"></a>

Detects text in the input image and converts it into machine\-readable text\.

Pass the input image as base64\-encoded image bytes or as a reference to an image in an Amazon S3 bucket\. If you use the AWS CLI to call Amazon Rekognition operations, you must pass it as a reference to an image in an Amazon S3 bucket\. For the AWS CLI, passing image bytes is not supported\. The image must be either a \.png or \.jpeg formatted file\. 

The `DetectText` operation returns text in an array of [TextDetection](API_TextDetection.md) elements, `TextDetections`\. Each `TextDetection` element provides information about a single word or line of text that was detected in the image\. 

A word is one or more ISO basic latin script characters that are not separated by spaces\. `DetectText` can detect up to 50 words in an image\.

A line is a string of equally spaced words\. A line isn't necessarily a complete sentence\. For example, a driver's license number is detected as a line\. A line ends when there is no aligned text after it\. Also, a line ends when there is a large gap between words, relative to the length of the words\. This means, depending on the gap between words, Amazon Rekognition may detect multiple lines in text aligned in the same direction\. Periods don't represent the end of a line\. If a sentence spans multiple lines, the `DetectText` operation returns multiple lines\.

To determine whether a `TextDetection` element is a line of text or a word, use the `TextDetection` object `Type` field\. 

To be detected, text must be within \+/\- 90 degrees orientation of the horizontal axis\.

For more information, see [Detecting Text](text-detection.md)\.

## Request Syntax<a name="API_DetectText_RequestSyntax"></a>

```
{
   "[Filters](#rekognition-DetectText-request-Filters)": { 
      "[RegionsOfInterest](API_DetectTextFilters.md#rekognition-Type-DetectTextFilters-RegionsOfInterest)": [ 
         { 
            "[BoundingBox](API_RegionOfInterest.md#rekognition-Type-RegionOfInterest-BoundingBox)": { 
               "[Height](API_BoundingBox.md#rekognition-Type-BoundingBox-Height)": number,
               "[Left](API_BoundingBox.md#rekognition-Type-BoundingBox-Left)": number,
               "[Top](API_BoundingBox.md#rekognition-Type-BoundingBox-Top)": number,
               "[Width](API_BoundingBox.md#rekognition-Type-BoundingBox-Width)": number
            }
         }
      ],
      "[WordFilter](API_DetectTextFilters.md#rekognition-Type-DetectTextFilters-WordFilter)": { 
         "[MinBoundingBoxHeight](API_DetectionFilter.md#rekognition-Type-DetectionFilter-MinBoundingBoxHeight)": number,
         "[MinBoundingBoxWidth](API_DetectionFilter.md#rekognition-Type-DetectionFilter-MinBoundingBoxWidth)": number,
         "[MinConfidence](API_DetectionFilter.md#rekognition-Type-DetectionFilter-MinConfidence)": number
      }
   },
   "[Image](#rekognition-DetectText-request-Image)": { 
      "[Bytes](API_Image.md#rekognition-Type-Image-Bytes)": blob,
      "[S3Object](API_Image.md#rekognition-Type-Image-S3Object)": { 
         "[Bucket](API_S3Object.md#rekognition-Type-S3Object-Bucket)": "string",
         "[Name](API_S3Object.md#rekognition-Type-S3Object-Name)": "string",
         "[Version](API_S3Object.md#rekognition-Type-S3Object-Version)": "string"
      }
   }
}
```

## Request Parameters<a name="API_DetectText_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [Filters](#API_DetectText_RequestSyntax) **   <a name="rekognition-DetectText-request-Filters"></a>
Optional parameters that let you set the criteria that the text must meet to be included in your response\.  
Type: [DetectTextFilters](API_DetectTextFilters.md) object  
Required: No

 ** [Image](#API_DetectText_RequestSyntax) **   <a name="rekognition-DetectText-request-Image"></a>
The input image as base64\-encoded bytes or an Amazon S3 object\. If you use the AWS CLI to call Amazon Rekognition operations, you can't pass image bytes\.   
If you are using an AWS SDK to call Amazon Rekognition, you might not need to base64\-encode image bytes passed using the `Bytes` field\. For more information, see [Images](images-information.md)\.  
Type: [Image](API_Image.md) object  
Required: Yes

## Response Syntax<a name="API_DetectText_ResponseSyntax"></a>

```
{
   "[TextDetections](#rekognition-DetectText-response-TextDetections)": [ 
      { 
         "[Confidence](API_TextDetection.md#rekognition-Type-TextDetection-Confidence)": number,
         "[DetectedText](API_TextDetection.md#rekognition-Type-TextDetection-DetectedText)": "string",
         "[Geometry](API_TextDetection.md#rekognition-Type-TextDetection-Geometry)": { 
            "[BoundingBox](API_Geometry.md#rekognition-Type-Geometry-BoundingBox)": { 
               "[Height](API_BoundingBox.md#rekognition-Type-BoundingBox-Height)": number,
               "[Left](API_BoundingBox.md#rekognition-Type-BoundingBox-Left)": number,
               "[Top](API_BoundingBox.md#rekognition-Type-BoundingBox-Top)": number,
               "[Width](API_BoundingBox.md#rekognition-Type-BoundingBox-Width)": number
            },
            "[Polygon](API_Geometry.md#rekognition-Type-Geometry-Polygon)": [ 
               { 
                  "[X](API_Point.md#rekognition-Type-Point-X)": number,
                  "[Y](API_Point.md#rekognition-Type-Point-Y)": number
               }
            ]
         },
         "[Id](API_TextDetection.md#rekognition-Type-TextDetection-Id)": number,
         "[ParentId](API_TextDetection.md#rekognition-Type-TextDetection-ParentId)": number,
         "[Type](API_TextDetection.md#rekognition-Type-TextDetection-Type)": "string"
      }
   ],
   "[TextModelVersion](#rekognition-DetectText-response-TextModelVersion)": "string"
}
```

## Response Elements<a name="API_DetectText_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [TextDetections](#API_DetectText_ResponseSyntax) **   <a name="rekognition-DetectText-response-TextDetections"></a>
An array of text that was detected in the input image\.  
Type: Array of [TextDetection](API_TextDetection.md) objects

 ** [TextModelVersion](#API_DetectText_ResponseSyntax) **   <a name="rekognition-DetectText-response-TextModelVersion"></a>
The model version used to detect text\.  
Type: String

## Errors<a name="API_DetectText_Errors"></a>

 **AccessDeniedException**   
You are not authorized to perform the action\.  
HTTP Status Code: 400

 **ImageTooLargeException**   
The input image size exceeds the allowed limit\. For more information, see [Limits in Amazon Rekognition](limits.md)\.   
HTTP Status Code: 400

 **InternalServerError**   
Amazon Rekognition experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidImageFormatException**   
The provided image format is not supported\.   
HTTP Status Code: 400

 **InvalidParameterException**   
Input parameter violated a constraint\. Validate your parameter before calling the API operation again\.  
HTTP Status Code: 400

 **InvalidS3ObjectException**   
Amazon Rekognition is unable to access the S3 object specified in the request\.  
HTTP Status Code: 400

 **ProvisionedThroughputExceededException**   
The number of requests exceeded your throughput limit\. If you want to increase this limit, contact Amazon Rekognition\.  
HTTP Status Code: 400

 **ThrottlingException**   
Amazon Rekognition is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 500

## See Also<a name="API_DetectText_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/rekognition-2016-06-27/DetectText) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/rekognition-2016-06-27/DetectText) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/rekognition-2016-06-27/DetectText) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/rekognition-2016-06-27/DetectText) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/rekognition-2016-06-27/DetectText) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/rekognition-2016-06-27/DetectText) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/rekognition-2016-06-27/DetectText) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/rekognition-2016-06-27/DetectText) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/rekognition-2016-06-27/DetectText) 