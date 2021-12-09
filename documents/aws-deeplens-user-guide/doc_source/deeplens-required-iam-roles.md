# Set Up Required Permissions<a name="deeplens-required-iam-roles"></a>

Before you can build and run your AWS DeepLens\-based computer vision application, you must give AWS DeepLens permissions to create the project for your application and deploy it to your device\. Because AWS DeepLens uses Lambda functions to make inference calls and uses AWS IoT Greengrass as the underlying infrastructure to connect your AWS DeepLens device to the AWS Cloud, AWS DeepLens also needs permissions for these dependent AWS services to execute the Lambda functions and manage the device on your behalf\. 

To control access to AWS resources, you use AWS Identity and Access Management \(IAM\)\. With IAM, you control who is authenticated \(signed in\) and authorized \(has permissions\) to use resources with roles and permissions policies\. 

When you register your device using the AWS DeepLens console for the first time, the AWS DeepLens console can create the following required IAM roles with predefined IAM policies, with a single command: 
+  [AWSDeepLensServiceRole](https://console.aws.amazon.com/iam/home?region=us-east-1#/roles/AWSDeepLensServiceRole):—An IAM role that AWS DeepLens uses to access the AWS services that it uses, including AWS IoT, Amazon Simple Storage Service \(Amazon S3\), AWS IoT Greengrass, and AWS Lambda\. The AWS DeepLens console attaches the AWS\-managed policy of [AWSDeepLensServiceRolePolicy](https://console.aws.amazon.com/iam/home?region=us-east-1#/policies/arn:aws:iam::aws:policy/service-role/AWSDeepLensServiceRolePolicy$jsonEditor) to this role\. You don't need to customize it\.
+ [AWSDeepLensLambdaRole](https://console.aws.amazon.com/iam/home?region=us-east-1#/roles/AWSDeepLensLambdaRole):—An IAM role that is passed to AWS Lambda for creating Lambda functions and accessing other AWS services on your behalf\. The AWS DeepLens console attaches the AWS\-managed policy of [AWSLambdaFullAccess](https://console.aws.amazon.com/iam/home?region=us-east-1#/policies/arn:aws:iam::aws:policy/AWSLambdaFullAccess$jsonEditor) to this role\. Customization of this default policy is not necessary\.
+ [AWSDeepLensGreengrassRole](https://console.aws.amazon.com/iam/home?region=us-east-1#/roles/AWSDeepLensGreengrassRole):—An IAM role that is passed to AWS IoT Greengrass to allow AWS IoT Greengrass to create needed AWS resources and to access other required AWS services\. This role allows you to deploy Lambda inference functions to your AWS DeepLens device for on\-device execution\. The AWS DeepLens console attaches the AWS\-managed policy of [AWSGreengrassResourceAccessRolePolicy](https://console.aws.amazon.com/iam/home?region=us-east-1#/policies/arn:aws:iam::aws:policy/service-role/AWSGreengrassResourceAccessRolePolicy$jsonEditor) to this role\. You don't need to customize it\.
+ [AWSDeepLensGreengrassGroupRole](https://console.aws.amazon.com/iam/home?region=us-east-1#/roles/AWSDeepLensGreengrassGroupRole):—An IAM role that is passed to AWS IoT Greengrass device groups, which gives AWS DeepLens administrative Lambda functions to access other AWS services\. The AWS DeepLens console attaches the AWS\-managed policy of [AWSDeepLensLambdaFunctionAccessPolicy](https://console.aws.amazon.com/iam/home?region=us-east-1#/policies/arn:aws:iam::aws:policy/AWSDeepLensLambdaFunctionAccessPolicy$jsonEditor) to this role\. The [AWS IoT Greengrass group](https://docs.aws.amazon.com/greengrass/latest/developerguide/what-is-gg.html#gg-group) defines how your AWS DeepLens device communicates with the AWS IoT Greengrass core devices\.

  The managed **AWSDeepLensLambdaFunctionAccessPolicy** has predefined permissions to allow the project's Lambda function to call certain operations on Amazon S3 objects with the `deeplens` prefixes, It also supports AWS DeepLens logging operations to CloudWatch Logs and permits the function to send video feeds to Kinesis Video Streams\. If your project's Lambda function makes use of other AWS services, you need to customize the **AWSDeepLensLambdaFunctionAccessPolicy** policy to add new policy statements specific to the additional services\. 

  For example, suppose that you have a device installed in a warehouse and another one at your office\. The device in the warehouse needs to access your inventory system built upon DynamoDB, whereas the one in the office does not\. You must then create a new IAM role of the **AWSDeepLensGreengrassGroupRole** type and attach to the new role the **AWSDeepLensLambdaFunctionAccessPolicy** and additional policy statements that permit the Lambda function on the device in the warehouse to access DynamoDB\. 

 Alternatively, you can create these IAM roles yourself\. For information about how to create the required IAM roles and permissions yourself, see [Create IAM Roles for Your AWS DeepLens Project](#deeplens-required-iam-role-create)\. 

## Create IAM Roles for Your AWS DeepLens Project<a name="deeplens-required-iam-role-create"></a>

If your AWS account doesn't already have required IAM roles, you can use the AWS DeepLens console to create them with a single command or use the AWS Identity and Access Management console to create them individually\. 

If you already have these roles, AWS DeepLens uses them when you register your device\. 

In either case, you have the option to customize the [AWSDeepLensGreengrassGroupRole](https://console.aws.amazon.com/iam/home?region=us-east-1#/roles/AWSDeepLensGreengrassGroupRole) to grant different permissions to different devices\. 

**Topics**
+ [Create **AWSDeepLensServiceRole** Using the IAM Console](#deeplens-required-iam-roles-create-deeplens-service)
+ [Create **AWSDeepLensLambdaRole** Using the IAM Console](#deeplens-required-iam-roles-create-lambda-service)
+ [Create **AWSDeepLensGreengrassGroupRole** Using the IAM Console](#deeplens-required-iam-roles-create-greengrass-group)
+ [Create **AWSDeepLensGreengrassRole** Using the IAM Console](#deeplens-required-iam-roles-create-deeplens-service)
+ [Create **AWSDeepLensSagemakerRole** Using the IAM Console](#deeplens-required-iam-roles-create-sagemaker-service)

### Create **AWSDeepLensServiceRole** Using the IAM Console<a name="deeplens-required-iam-roles-create-deeplens-service"></a>

**To create **AWSDeepLensServiceRole** Using the IAM console**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Choose **Create role**\.

1. Under **Select type of trusted entity**, choose **AWS service**\.

1. Under **Choose the service that will use this role**, choose **DeepLens**\. 

1. Under **Select your use case**, choose **DeepLens**

1. Choose **Next: Permissions**\.

1. In the **Create role** page, make sure that the **AWSDeepLensServiceRolePolicy** is listed under **Attached permissions policies** and then choose **Next: Review**\.

1. For **Role name**, type **AWSDeepLensServiceRole** and then choose **Create role**\.

### Create **AWSDeepLensLambdaRole** Using the IAM Console<a name="deeplens-required-iam-roles-create-lambda-service"></a>

**To create **AWSDeepLensLambdaRole**in the IAM console**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Choose **Create role**\.

1. Under **Select type of trusted entity**, choose **AWS service**\.

1. Under **Choose the service that will use this role**, choose **Lambda**\. 

1. Choose **Next: Permissions**\.

1. In the **Create role** page, type **AWSLambdaFullAccess** in the search query input field next to **Filer policies** under **Attached permissions policies**\. Choose the checkmark next to the **AWSLambdaFullAccess** policy entry and then choose **Next: Review**\.

1. For **Role name**, type **AWSDeepLensLambdaRole** and then choose **Create role**\.

### Create **AWSDeepLensGreengrassGroupRole** Using the IAM Console<a name="deeplens-required-iam-roles-create-greengrass-group"></a>

**To create **AWSDeepLensGreengrassGroupRole** in the IAM console**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Choose **Create role**\.

1. Under **Select type of trusted entity**, choose **AWS service**\.

1. Under **Choose the service that will use this role**, choose **DeepLens**\. 

1. Under **Select your use case**, choose **DeepLens \- Greengrass Lambda**

1. Choose **Next: Permissions**\.

1. In the **Create role** page, make sure that the **AWSDeepLensLambdaFunctionAccessPolicy** is listed under **Attached permissions policies** and then choose **Next: Review**\.

1. For **Role name**, type **AWSDeepLensGreengrassGroupRole** and then choose **Create role**\.

### Create **AWSDeepLensGreengrassRole** Using the IAM Console<a name="deeplens-required-iam-roles-create-deeplens-service"></a>

**To create **AWSDeepLensGreengrassRole** in the IAM console**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Choose **Create role**\. 

1. Under **Select type of trusted entity**, choose **AWS service**\.

1. Under **Choose the service that will use this role**, choose **Greengrass**\. 

1. Under **Select your use case**, choose **Greengrass**

1. Choose **Next: Permissions**\.

1. In the **Create role** page, type **AWSGreengrassResourceAccessRolePolicy** in the filter query input field\. Choose the checkmark next to the **AWSGreengrassResourceAccessRolePolicy** listed under **Attached permissions policies** and then choose **Next: Review**\.

1. For **Role name**, type **AWSDeepLensGreengrassRole** and then choose **Create role**\.

### Create **AWSDeepLensSagemakerRole** Using the IAM Console<a name="deeplens-required-iam-roles-create-sagemaker-service"></a>

 If you use Amazon SageMaker to train a custom deep learning model for your AWS DeepLens project, you must also create an IAM role to grant Amazon SageMaker permissions to access required AWS resource on your behalf\. To grant the permissions, follow the step below to create the **AWSDeepLensSagemakerRole** in the IAM console\. 

**To create **AWSDeepLensSagemakerRole** in the IAM console**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Choose **Create role**\. 

1. Under **Select type of trusted entity**, choose **AWS service**\.

1. Under **Choose the service that will use this role**, choose **SageMaker**\. 

1. Under **Select your use case**, choose **SageMaker \- Execution**

1. Choose **Next: Permissions**\.

1. In the **Create role** page, type **AmazonSageMakerFullAccess** in the filter query input field\. Choose the checkmark next to the **AmazonSageMakerFullAccess** listed under **Attached permissions policies** and then choose **Next: Review**\.

1. For **Role name**, type **AWSDeepLensSageMakerRole** and then choose **Create role**\.