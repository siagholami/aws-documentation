# Usage Report Prerequisites<a name="report-prerequisites"></a>

Before you can export your usage reports to S3, complete the following steps\.

**To prepare for report creation**

1. If you don't have one already, create an S3 bucket\. 

   1. Open the [S3 console](https://s3.console.aws.amazon.com/s3) and create an S3 bucket\.

   1. Enter a bucket name\. \(For example, my\-s3\-bucket\-name\.\)

1. Set the S3 bucket policy\.

   1. Select the S3 bucket you created, choose **Permissions**, and then choose **Bucket Policy**\.

   1. In the **Bucket policy editor**, copy and paste the following S3 bucket policy\. Replace "<my\-s3\-bucket\-name>" with your bucket name, and choose **Save**\.

      ```
          {
              "Version": "2012-10-17",
              "Statement": [
                  {
                      "Sid": "Stmt1530229847751",
                      "Effect": "Allow",
                      "Principal": {
                          "AWS": "arn:aws:iam::994698236012:root"
                      },
                      "Action": [
                          "s3:PutObject",
                          "s3:PutObjectAcl",
                          "s3:GetBucketAcl"
                      ],
                      "Resource": [
                          "arn:aws:s3:::<my-s3-bucket-name>",
                          "arn:aws:s3:::<my-s3-bucket-name>/*"
                      ]
                  }
              ]
          }
      ```

1. Verify that you have permissions to write to the S3 bucket location\. Also make sure that the AWS IAM user, which you logged into the Alexa for Business console with, has the same permissions\. 
**Note**  
If your IAM user can't write to the S3 bucket, you can't configure it as an export location\.