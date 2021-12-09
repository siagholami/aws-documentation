# Validation Rules<a name="cd-manifest-files-validation-rules"></a>

 When you import a manifest file, Amazon Rekognition Custom Labels applies validation rules for limits, syntax, and semantics\. The Amazon SageMaker Ground Truth schema enforces syntax validation\. For more information, see [Output](https://docs.aws.amazon.com/sagemaker/latest/dg/sms-data-output.html)\. The following are the validation rules for limits and semantics\.

**Note**  
The 20% invalidity rules apply cumulatively across all validation rules\. If the import exceeds the 20% limit due to any combination, such as 15% invalid JSON and 15% invalid images, the import fails\. 
Each dataset object is a line in the manifest\. Blank/invalid lines are also counted as dataset objects\.
Overlaps are \(common labels between test and train\)/\(train labels\)\.

**Topics**
+ [Limits](#validation-rules-limits)
+ [Semantics](#validation-rules-semantics)

## Limits<a name="validation-rules-limits"></a>


| Validation | Limit | Error raised | 
| --- | --- | --- | 
|  Manifest file size  |  Maximum 1 GB  |  Error  | 
|  Maximum line count for a manifest file  |  Maximum of 250,000 dataset objects as lines in a manifest\.   |  Error  | 
|  Lower boundary on total number of valid dataset objects per label   |  >= 1  |  Error  | 
|  Lower boundary on labels  |  >=2  |  Error  | 
|  Upper bound on labels  |  < 250  |  Error  | 
|  Minimum bounding boxes per image  |  0  |  None  | 
|  Maximum bounding boxes per image  |  50  |  None  | 

## Semantics<a name="validation-rules-semantics"></a>


| Validation | Limit | Error raised | 
| --- | --- | --- | 
|  Empty manifest  |   |  Error  | 
|  Missing/in\-accessible source\-ref object  |  Number of objects less than 20%  |  Warning  | 
|  Missing/in\-accessible source\-ref object  |  Number of objects > 20%  |  Error  | 
|  Test labels not present in training dataset   |  At least 50% overlap in the labels  |  Error  | 
|  Mix of label vs\. object examples for same label in a dataset\. Classification and detection for the same class in a dataset object\.   |   |  No error or warning  | 
|  Overlapping assets between test and train   |  There should not be an overlap between test and training datasets\.   |   | 
|  Images in a dataset must be from same bucket   |  Error if the objects are in a different bucket  |  Error  | 