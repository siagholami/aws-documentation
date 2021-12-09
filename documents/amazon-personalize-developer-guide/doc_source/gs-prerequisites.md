# Getting Started Prerequisites<a name="gs-prerequisites"></a>

The following steps are prerequisites for the getting started exercises\.

1. Create an AWS account and an AWS Identity and Access Management user, as specified in [Sign Up for AWS](setup.md#aws-personalize-set-up-aws-account)\. 

1. Ensure the IAM user that you are using has the [Creating a New IAM Policy](aws-personalize-set-up-permissions.md#set-up-required-permissions)\. 

1. Create an AWS Identity and Access Management \(IAM\) service role, as specified in [Creating an IAM Role for Amazon Personalize](aws-personalize-set-up-permissions.md#set-up-create-role-with-permissions)\. Use the role ARN when you upload the movie training data\. 

1. Prepare your training data and upload the data to your Amazon S3 bucket, as specified in [Creating the Training Data](#gs-upload-to-bucket)\. Use the name of the Amazon S3 bucket when you upload the movie training data\. 

1.  Give your Amazon Personalize service role permission to access your Amazon S3 resources, as specified in [Giving Amazon Personalize Access to Amazon S3 Resources](#granting-personalize-s3-access)\. 

## Creating the Training Data<a name="gs-upload-to-bucket"></a>

To create training data, download, modify, and save the movie ratings data to an Amazon Simple Storage Service \(Amazon S3\) bucket\. Then give Amazon Personalize permission to read from the bucket\.

1. Download the movie ratings zip file, [ml\-latest\-small\.zip](http://files.grouplens.org/datasets/movielens/ml-latest-small.zip) from [MovieLens](https://grouplens.org/datasets/movielens) \(under *recommended for education and development*\)\. Unzip the file\. The user\-interactions data is in the file named `ratings.csv`\.

1. Open the `ratings.csv` file\.

   1. Delete the *rating* column\.

   1. Replace the header row with the following:

      **USER\_ID,ITEM\_ID,TIMESTAMP**

      These headers must be exactly as shown for Amazon Personalize to recognize the data\.

   Save the `ratings.csv` file\.

1. Upload `ratings.csv` to your Amazon S3 bucket\. For more information, see [Uploading Files and Folders by Using Drag and Drop](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/upload-objects.html) in the Amazon Simple Storage Service Console User Guide\.

1. Give Amazon Personalize permission to read the data in the bucket\. For more information, see [Giving Amazon Personalize Access to Amazon S3 Resources](#granting-personalize-s3-access)\.

## Giving Amazon Personalize Access to Amazon S3 Resources<a name="granting-personalize-s3-access"></a>

To give Amazon Personalize access to your Amazon S3 bucket, do the following:

1.  Attach a policy to the Amazon Personalize service role \(see [Creating an IAM Role for Amazon Personalize](aws-personalize-set-up-permissions.md#set-up-create-role-with-permissions)\) that allows access to your Amazon S3 bucket\. For more information, see [Attaching an Amazon S3 Policy to the Amazon Personalize Service Role](#attaching-s3-policy-to-role)\. 

1.  Attach a bucket policy to the Amazon S3 bucket containing your data files so Amazon Personalize can access them\. For more information, see [Uploading to an S3 Bucket](data-prep-upload-s3.md)\. 

**Note**  
Because Amazon Personalize doesn’t communicate with AWS VPCs, Amazon Personalize can't interact with Amazon S3 buckets that allow only VPC access\.

### Attaching an Amazon S3 Policy to the Amazon Personalize Service Role<a name="attaching-s3-policy-to-role"></a>

To attach an Amazon S3 policy to your Amazon Personalize role do the following:

1. Sign in to the IAM console \([https://console\.aws\.amazon\.com/iam](https://console.aws.amazon.com/iam)\)\.

1. In the navigation pane, choose **Policies**, and choose **Create policy**\.

1. Choose the JSON tab, and update the policy as follows\. Replace `bucket-name` with the name of your bucket\. 

   ```
   {
       "Version": "2012-10-17",
       "Id": "PersonalizeS3BucketAccessPolicy",
       "Statement": [
           {
               "Sid": "PersonalizeS3BucketAccessPolicy",
               "Effect": "Allow",
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

1. Choose **Review policy**\.

1. For **Name**, enter `PersonalizeS3BucketAccessPolicy`\.

1. \(Optional\) For **Description**, enter a short sentence describing this policy, for example, **Allow Amazon Personalize to access its S3 bucket\.**

1. Choose **Create policy**\.

1. In the navigation pane, choose **Roles**, and choose \.

1. For **Permissions**, choose **PersonalizeS3BucketAccessPolicy**\.

1. To display the policy in the list, type part of the policy name in the **Filter policies** filter box\.

1. Choose the check box next to **PersonalizeS3BucketAccessPolicy**\.

1. Choose **Attach policy**\.

   Before your role is ready for use with Amazon Personalize you must also attach a bucket policy to the Amazon S3 bucket containing your data\. See [Uploading to an S3 Bucket](data-prep-upload-s3.md)\.