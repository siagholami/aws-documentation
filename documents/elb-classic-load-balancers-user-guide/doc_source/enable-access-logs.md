# Enable access logs for your Classic Load Balancer<a name="enable-access-logs"></a>

To enable access logs for your load balancer, you must specify the name of the Amazon S3 bucket where the load balancer will store the logs\. You must also attach a bucket policy to this bucket that grants Elastic Load Balancing permission to write to the bucket\.

**Important**  
The bucket and your load balancer must be in the same Region\. The bucket can be owned by a different account than the account that owns the load balancer\.

**Topics**
+ [Step 1: Create an S3 bucket](#create-s3-bucket)
+ [Step 2: Attach a policy to your S3 bucket](#attach-bucket-policy)
+ [Step 3: Enable access logs](#enable-access-logs-console)
+ [Step 4: Verify that the load balancer created a test file in the S3 bucket](#verify-access-logs)

## Step 1: Create an S3 bucket<a name="create-s3-bucket"></a>

You can create an S3 bucket using the Amazon S3 console\. If you already have a bucket and want to use it to store the access logs, skip this step and go to [Step 2: Attach a policy to your S3 bucket](#attach-bucket-policy) to grant Elastic Load Balancing permission to write logs to your bucket\.

**Tip**  
If you will use the console to enable access logs, you can skip this step and have Elastic Load Balancing create a bucket with the required permissions for you\. If you will use the AWS CLI to enable access logs, you must create the bucket and grant the required permissions yourself\.

**Requirements**
+ The bucket must be located in the same Region as the load balancer\.
+ Amazon S3\-Managed Encryption Keys \(SSE\-S3\) is required\. No other encryption options are supported\.

**To create an S3 bucket using the Amazon S3 console**

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose **Create bucket**\.

1. On the **Create bucket** page, do the following:

   1. For **Bucket Name**, enter a name for your bucket\. This name must be unique across all existing bucket names in Amazon S3\. In some Regions, there might be additional restrictions on bucket names\. For more information, see [Bucket restrictions and limitations](https://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html) in the *Amazon Simple Storage Service Developer Guide*\.

   1. For **Region**, select the Region where you created your load balancer\.

   1. Choose **Create**\.

## Step 2: Attach a policy to your S3 bucket<a name="attach-bucket-policy"></a>

After you've created or identified your S3 bucket, you must attach a policy to the bucket\. Bucket policies are a collection of JSON statements written in the access policy language to define access permissions for your bucket\. Each statement includes information about a single permission and contains a series of elements\.

If your bucket already has an attached policy, you can add the statements for the Elastic Load Balancing access log to the policy\. If you do so, we recommend that you evaluate the resulting set of permissions to ensure that they are appropriate for the users that need access to the bucket for access logs\.

**Tip**  
If you will use the console to enable access logs, you can skip this step and have Elastic Load Balancing create a bucket with the required permissions for you\.

**To attach a policy statement to your bucket**

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Select the bucket\. Choose **Permissions** and then choose **Bucket Policy**\.

1. If you are creating a new bucket policy, copy this entire policy document to the policy editor, then replace the placeholders with the bucket name and prefix for your bucket, the ID of the AWS account for Elastic Load Balancing \(based on the Region for your load balancer\), and the ID of your own AWS account\. If you are editing an existing bucket policy, copy only the new statement from the policy document \(the text between the \[ and \] of the `Statement` element\)\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "AWS": "arn:aws:iam::elb-account-id:root"
         },
         "Action": "s3:PutObject",
         "Resource": "arn:aws:s3:::bucket-name/prefix/AWSLogs/your-aws-account-id/*"
       },
       {
         "Effect": "Allow",
         "Principal": {
           "Service": "delivery.logs.amazonaws.com"
         },
         "Action": "s3:PutObject",
         "Resource": "arn:aws:s3:::bucket-name/prefix/AWSLogs/your-aws-account-id/*",
         "Condition": {
           "StringEquals": {
             "s3:x-amz-acl": "bucket-owner-full-control"
           }
         }
       },
       {
         "Effect": "Allow",
         "Principal": {
           "Service": "delivery.logs.amazonaws.com"
         },
         "Action": "s3:GetBucketAcl",
         "Resource": "arn:aws:s3:::bucket-name"
       }
     ]
   }
   ```

   The following table contains the account IDs to use in your bucket policy\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/enable-access-logs.html)

   \* These Regions requires a separate account\. For more information, see [AWS GovCloud \(US\-West\)](https://aws.amazon.com/govcloud-us/) and [China \(Beijing\)](http://www.amazonaws.cn/en/)\.

1. Choose **Save**\.

## Step 3: Enable access logs<a name="enable-access-logs-console"></a>

You can enable access logs using the AWS Management Console or the AWS CLI\. Note that when you enable access logs using the console, you can have Elastic Load Balancing create the bucket for you with necessary permissions for the load balancer to write to your bucket\.

Use the following example to capture and deliver logs to your S3 bucket every 60 minutes \(the default interval\)\.

**To enable access logs for your load balancer using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Description** tab, choose **Configure Access Logs**\.

1. On the **Configure Access Logs** page, do the following:

   1. Choose **Enable access logs**\.

   1. Leave **Interval** as the default, `60 minutes`\.

   1. For **S3 location**, type the name of your S3 bucket, including the prefix \(for example, `my-loadbalancer-logs/my-app`\)\. You can specify the name of an existing bucket or a name for a new bucket\.

   1. \(Optional\) If the bucket does not exist, choose **Create this location for me**\. You must specify a name that is unique across all existing bucket names in Amazon S3 and follows the DNS naming conventions\. For more information, see [Rules for bucket naming](https://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html#bucketnamingrules) in the *Amazon Simple Storage Service Developer Guide*\.

   1. Choose **Save**\.

**To enable access logs for your load balancer using the AWS CLI**  
First, create a \.json file that enables Elastic Load Balancing to capture and deliver logs every 60 minutes to the S3 bucket that you created for the logs:

```
{ 
  "AccessLog": {
    "Enabled": true,
    "S3BucketName": "my-loadbalancer-logs",
    "EmitInterval": 60,
    "S3BucketPrefix": "my-app"
  }
}
```

To enable access logs, specify the \.json file in the [modify\-load\-balancer\-attributes](https://docs.aws.amazon.com/cli/latest/reference/elb/modify-load-balancer-attributes.html) command as follows:

```
aws elb modify-load-balancer-attributes --load-balancer-name my-loadbalancer --load-balancer-attributes file://my-json-file.json
```

The following is an example response:

```
{
    "LoadBalancerAttributes": {
        "AccessLog": {
            "Enabled": true,
            "EmitInterval": 60,
            "S3BucketName": "my-loadbalancer-logs",
            "S3BucketPrefix": "my-app"
        }
    },
    "LoadBalancerName": "my-loadbalancer"
}
```

## Step 4: Verify that the load balancer created a test file in the S3 bucket<a name="verify-access-logs"></a>

After the access log is enabled for your load balancer, Elastic Load Balancing validates the S3 bucket and creates a test file\. You can use the S3 console to verify that the test file was created\.

**To verify that Elastic Load Balancing created a test file in your S3 bucket**

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Select your S3 bucket\.

1. Navigate to the bucket that you specified for access logging and look for `ELBAccessLogTestFile`\. For example, if you used the console to create the bucket and bucket policy, the path is as follows:

   ```
   my-bucket/prefix/AWSLogs/123456789012/ELBAccessLogTestFile
   ```

**To manage the S3 bucket for your access logs**  
After you enable access logging, be sure to disable access logging before you delete the bucket with your access logs\. Otherwise, if there is a new bucket with the same name and the required bucket policy created in an AWS account that you don't own, Elastic Load Balancing could write the access logs for your load balancer to this new bucket\.