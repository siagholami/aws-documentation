# Set Up Permissions for Amazon Forecast<a name="aws-forecast-iam-roles"></a>

Amazon Forecast uses Amazon Simple Storage Service \(Amazon S3\) to store the target time\-series data that are used to train predictors that can generate forecasts\. To access Amazon S3 on your behalf, Amazon Forecast needs your permission\. 

To grant Amazon Forecast permission to use Amazon S3 on your behalf, you must have an AWS Identity and Access Management \(IAM\) role and IAM policy in your account\. The IAM policy specifies the required permissions, and must be attached to the IAM role\. 

To create the IAM role and policy and to attach the policy to the role, you can use the IAM console or the AWS Command Line Interface \(AWS CLI\)\.

**Note**  
Forecast does not communicate with AWS VPCs and is unable to support the S3 VPCE gateway\. Using S3 buckets that only allow VPC access will result in an `AccessDenied` error\.

**Topics**
+ [Create an IAM Role for Amazon Forecast \(IAM Console\)](#aws-forecast-create-iam-role-with-console)
+ [Create an IAM for Amazon Forecast \(AWS CLI\)](#aws-forecast-create-iam-role-with-cli)

## Create an IAM Role for Amazon Forecast \(IAM Console\)<a name="aws-forecast-create-iam-role-with-console"></a>

You can use the AWS IAM console to do the following:
+ Create an IAM role with Amazon Forecast as a trusted entity
+ Create an IAM policy with permissions that allows Amazon Forecast to show, read, and write data in an Amazon S3 bucket
+ Attach the IAM policy to the IAM role

**To create an IAM role and policy that allows Amazon Forecast to access Amazon S3 \(IAM console\)**

1.  Sign in to the IAM console \([https://console\.aws\.amazon\.com/iam](https://console.aws.amazon.com/iam)\)\.

1. Choose **Policies** and do the following to create the required policy:

   1. On the **Create policy** page, in the policy editor, choose the **JSON** tab\.

   1. Copy the following policy and replace the text in the editor by pasting the this policy over it\. Be sure to replace `bucket-name` with the name of your S3 bucket, then choose **Review policy**\.

      ```
      {
         "Version":"2012-10-17",
         "Statement":[
            {
               "Effect":"Allow",
               "Action":[
                  "s3:Get*",
                  "s3:List*",
                  "s3:PutObject"
               ],
               "Resource":[
                  "arn:aws:s3:::bucket-name", 
                  "arn:aws:s3:::bucket-name/*" 
               ]
            }
         ]
      }
      ```

   1. In **Review policy**, for **Name**, enter a name for the policy\. For example, `AWSS3BucketAccess`\. Optionally, provide a description for this policy, then choose **Create policy**\.

1. In the navigation pane, choose **Roles**\. Then do the following to create the IAM role:

   1. Choose **Create role**\.

   1. For **Select type of trusted entity**, choose **AWS service**\. 

   1. For **Choose the service that will use this role**, if you don't see **Amazon Forecast** listed, choose **EC2**\. Otherwise, choose **Amazon Forecast**\.

   1. Choose **Next: Permissions**\.

   1. For **Attach permissions policies**, choose the check box next to the policy that you just created\. To display the policy in the list, type part of your policy name in the **Filter policies** query filter\. Then, choose **Next: Tags**\.

   1. You don't need to add tags, so choose **Next: Review**\.

   1. In the **Review** section, for **Role name**, enter a name for the role \(for example, `ForecastRole`\)\. Update the description for the role in **Role description**, then choose **Create role**\.

   1. Choose the new role to open the role's details page\.

   1. In the **Summary**, copy the **Role ARN** value and save it\. You need it to import a dataset into Amazon Forecast\.

   1. If you didn't choose **Amazon Forecast** as the service that will use this role, choose **Trust relationships**, and then choose **Edit trust relationship** to update the trust policy as follows\. 

      ```
      {
        "Version": "2012-10-17",
        "Statement": [
          {
            "Sid": "",
            "Effect": "Allow",
            "Principal": {
              "Service": "forecast.amazonaws.com"
            },
            "Action": "sts:AssumeRole"
          }
        ]
      }
      ```

## Create an IAM for Amazon Forecast \(AWS CLI\)<a name="aws-forecast-create-iam-role-with-cli"></a>

You can use the AWS CLI to do the following:
+ Create an IAM role with Amazon Forecast as a trusted entity
+ Create an IAM policy with permissions that allows Amazon Forecast to show, read, and write data in an Amazon S3 bucket
+ Attach the IAM policy to the IAM role

**To create an IAM role and policy that allows Amazon Forecast to access Amazon S3 \(AWS CLI\)**

1.  Create an IAM role with Amazon Forecast as a trusted entity that can assume the role for you:

   ```
   aws iam create-role \
    --role-name ForecastRole \
    --assume-role-policy-document '{
      "Version":"2012-10-17",
      "Statement":[
         {
            "Effect":"Allow",
            "Principal":{
               "Service":"forecast.amazonaws.com"
            },
            "Action":"sts:AssumeRole"
         }
      ]
   }
   ```

   This command assumes that the default AWS configuration profile is targeted for an AWS Region supported by Amazon Forecast\. If you have configured another profile \(for example, `aws-forecast`\) to target an AWS Region that is not supported by Amazon Forecast, you must explicitly specify that configuration by including the `profile` parameter in the command, for example, `--profile aws-forecast`\. For more information about setting up an AWS CLI configuration profile, see the AWS CLI [configure](https://docs.aws.amazon.com/cli/latest/reference/configure/) command\.

   If the command successfully creates the role, it returns it as output, which should look similar to the following:

   ```
   {
       "Role": {
           "RoleName": "ForecastRole",
           "AssumeRolePolicyDocument": {
               "Version": "2012-10-17",
               "Statement": [
                   {
                       "Action": "sts:AssumeRole",
                       "Principal": {
                           "Service": "forecast.amazonaws.com"
                       },
                       "Effect": "Allow"
                   }
               ]
           },
           "Arn": "arn:aws:iam::your-acct-ID:role/ForecastRole", 
           "CreateDate": "2018-09-12T00:23:06Z",
           "RoleId": "AROAITEGTQ3NN3FYHXNJU",
           "Path": "/"
       }
   }
   ```

   Record the role's ARN\. You need it when you import a dataset to train an Amazon Forecast predictor\.

1. Create an IAM policy with permissions to list, read, and write data in Amazon S3, and attach it to the IAM role that you created in Step 1:

   ```
   aws iam put-role-policy \
     --role-name ForecastRole \
     --policy-name ForecastBucketAccessPolicy \
     --policy-document '{
      "Version":"2012-10-17",
      "Statement":[
         {
            "Effect":"Allow",
            "Action":[
               "s3:Get*",
               "s3:List*",
               "s3:PutObject"
            ],
            "Resource":[
               "arn:aws:s3:::bucket-name", 
               "arn:aws:s3:::bucket-name/*" 
            ]
         }
      ]
   }'
   ```