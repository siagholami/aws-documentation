# Step 4: Set Up Amazon S3 Bucket Permissions for SDK Use<a name="su-sdk-bucket-permssions"></a>

To train models with the SDK, Amazon Rekognition Custom Labels needs access to the Amazon S3 buckets that hold your training and testing images\. If your images are stored in the Amazon S3 bucket that Amazon Rekognition Custom Labels creates on your behalf, when you first open the console, the permissions are already set up\. 

If your images are in different buckets, such as buckets that contain the images for an Amazon SageMaker Ground Truth manifest, you need to add the following policies\. For information about applying permissions policy to an Amazon S3 bucket, see [How Do I Add an S3 Bucket Policy?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/add-bucket-policy.html)\.

**To set up permissions policy**

1. Add the following policy to the input bucket\. Replace *my\-read\-bucket* with the name of your bucket\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Sid": "AWSRekognitionS3AclBucketRead20191011",
               "Effect": "Allow",
               "Principal": {
                   "Service": "rekognition.amazonaws.com"
               },
               "Action": ["s3:GetBucketAcl",
                         "s3:GetBucketLocation"],
               "Resource": "arn:aws:s3:::my-read-bucket"
           },
           {
               "Sid": "AWSRekognitionS3GetBucket20191011",
               "Effect": "Allow",
               "Principal": {
                   "Service": "rekognition.amazonaws.com"
               },
               "Action": ["s3:GetObject",
                          "s3:GetObjectAcl",
                          "s3:GetObjectVersion",
                          "s3:GetObjectTagging"],
               "Resource": "arn:aws:s3:::my-read-bucket/*"
           }
       ]
   }
   ```

1. Add the following policy to the output bucket\. Replace *my\-write\-bucket* and *my\-write\-prefix* with the folder name where output is placed\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [ 
           {
               "Sid": "AWSRekognitionS3ACLBucketWrite20191011",
               "Effect": "Allow",
               "Principal": {
                   "Service": "rekognition.amazonaws.com"
               },
               "Action": "s3:GetBucketAcl",
               "Resource": "arn:aws:s3:::my-write-bucket"
           },
           {
               "Sid": "AWSRekognitionS3PutObject20191011",
               "Effect": "Allow",
               "Principal": {
                   "Service": "rekognition.amazonaws.com"
               },
               "Action": "s3:PutObject",
               "Resource": "arn:aws:s3:::my-write-bucket/my-write-prefix/*",
               "Condition": {
                   "StringEquals": {
                       "s3:x-amz-acl": "bucket-owner-full-control"
                   }
               }
           }
       ]
   }
   ```