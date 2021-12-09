# Limits in Amazon Rekognition Custom Labels<a name="limits"></a>

The following is a list of limits in Amazon Rekognition Custom Labels\. For information about limits you can change, see [AWS Service Limits](https://docs.aws.amazon.com/general/latest/gr/rekognition_region.html)\. To change a limit, see [Create Case](https://console.aws.amazon.com/support/v1#/case/create?issueType=service-limit-increase)\.

## Training<a name="limits-training"></a>
+ Supported file formats are PNG and JPEG image formats\. 
+ Maximum number of training datasets in a version of a model is 1\. 
+ Maximum dataset manifest file size is 1 GB\. 
+ Minimum number of unique labels per manifest is 2\.
+ Maximum number of unique labels per manifest is 250\.
+ Minimum number of images per label is 1\. 
+ Maximum number of images per dataset is 250,000\.
+ Maximum number of labels per image is 50\.
+ Minimum number of bounding boxes in an image is 0\.
+ Maximum number of bounding boxes in an image is 50\.
+ Minimum image dimension of image file in an Amazon S3 bucket is 64 pixels x 64 pixels\.
+ Maximum image dimension of image file in an Amazon S3 bucket is 4096 pixels x 4096 pixels\.
+ Maximum file size for an image in an Amazon S3 bucket is 15 MB\.

## Testing<a name="limits-testing"></a>
+ Maximum number of testing datasets in a version of a model is 1\. 
+ Maximum dataset manifest file size is 1 GB\. 
+ Minimum number of unique labels per manifest is 1\.
+ Maximum number of unique labels per manifest is 250\.
+ Minimum number of images per label is 0\. 
+ Maximum number of images per label is 1000\. 
+ Maximum number of images per dataset is 250,000\.
+ Minimum number of labels per image per manifest is 0\.
+ Maximum number of labels per image per manifest is 50\.
+ Minimum number of bounding boxes in an image per manifest is 0\.
+ Maximum number of bounding boxes in an image per manifest is 50\.
+ Minimum image dimension of an image file in an Amazon S3 bucket is 64 pixels x 64 pixels\.
+ Maximum image dimension of an image file in an Amazon S3 bucket is 4096 pixels x 4096 pixels\.
+ Maximum file size for an image in an Amazon S3 bucket is 15 MB\.
+ Supported file formats are PNG and JPEG image formats\. 

## Detection<a name="limits-detection"></a>
+ Maximum size of images passed as raw bytes is 4 MB\.
+ Maximum file size for an image in an Amazon S3 bucket is 15 MB\.
+ Minimum image dimension of an image file in an Amazon S3 bucket is 64 pixels x 64 pixels\.
+ Maximum image dimension of an image file in an Amazon S3 bucket is 4096 pixels x 4096 pixels\.
+ Supported file formats are PNG and JPEG image formats\. 