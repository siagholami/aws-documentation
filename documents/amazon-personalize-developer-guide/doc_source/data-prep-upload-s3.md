# Uploading to an S3 Bucket<a name="data-prep-upload-s3"></a>

After you create a CSV file with your data, upload the file to your Amazon Simple Storage Service \( Amazon S3\) bucket\. This is the location that Amazon Personalize imports your data from\.

Amazon Personalize needs permission to access the S3 bucket\. Attach the following policy to your bucket\. For more information, see [How Do I Add an S3 Bucket Policy?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/add-bucket-policy.html)\.

```
{
    "Version": "2012-10-17",
    "Id": "PersonalizeS3BucketAccessPolicy",
    "Statement": [
        {
            "Sid": "PersonalizeS3BucketAccessPolicy",
            "Effect": "Allow",
            "Principal": {
                "Service": "personalize.amazonaws.com"
            },
            "Action": [
                "s3:GetObject",
                "s3:ListBucket"
            ],
            "Resource": [
                "arn:aws:s3:::bucket-name",
                "arn:aws:s3:::bucket-name/*"
            ]
        }
    ]
}
```

**Note**  
Because Amazon Personalize does not communicate with AWS VPCs, Amazon Personalize will be unable to interact with Amazon S3 buckets that only allow VPC access\.

After you upload your data to an S3 bucket, import your data into Amazon Personalize\. For more information, see [Importing Your Data](data-prep-importing.md)\.