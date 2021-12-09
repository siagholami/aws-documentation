# Using Amazon CloudWatch Events and AWS Lambda with AWS SMS<a name="cwe-sms"></a>

You can use Amazon CloudWatch Events with AWS Server Migration Service to automate actions based on your migration workflow\. This requires you to create an IAM policy for Lambda to assume, a Lambda function to handle the event, and a CloudWatch Events rule that matches incoming events and routes them to the Lambda function\.

## Handling CloudWatch Events rules for AWS SMS<a name="using-lambda"></a>

The following procedure uses an AWS Lambda function to monitor AWS SMS job state changes and launches an Amazon EC2 instance whenever an AMI ID has been created\.

**To create a Lambda function that monitors job state changes**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Create an IAM policy to provide permissions to execute an action \(called by Lambda\) and to write to the CloudWatch log when invoked by CloudWatch Events\. The following example provides permissions to execute a `RunInstances` action\. Assign the policy to the IAM role of the user that will handle the CloudWatch event\. 

   ```
   {
      "Version":"2012-10-17",
      "Statement":[
         {
            "Effect":"Allow",
            "Action":[
               "logs:CreateLogGroup",
               "logs:CreateLogStream",
               "logs:PutLogEvents"
            ],
            "Resource":"arn:aws:logs:*:*:*"
         },
         {
            "Effect":"Allow",
            "Action":[
               "ec2:RunInstances"
            ],
            "Resource":"*"
         }
      ]
   }
   ```

1. Open the AWS Lambda console at [https://console\.aws\.amazon\.com/lambda/](https://console.aws.amazon.com/lambda/)\.

1. Choose **Create function**\.

1. To ensure that your Lambda function is available from the CloudWatch console, create it in the region where the CloudWatch event will occur\. For more information, see the [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/)\. Name the function `LaunchInstanceFromAMI` and select **Python 2\.7** as the runtime\.

1. For **Role**, select **Choose an existing role**\. Under **Existing role**, in the list of available roles, choose the role to which you added your policy\. 

1. Choose **Create function** and define a Lambda function similar to the one below\. This sample function, written in Python 2\.7, is invoked by CloudWatch Events when an AWS SMS job completion sends an event with an AMI ID\. When invoked, it launches a `t2.micro` instance in the region of the event\.

   ```
   # Sample Lambda function to launch an EC2 instance from all AMI ID's created from a 
   # Server Migration Service replication job
   
   import boto3
   
   # main function
   def lambda_handler(event, context):
   
       # create an ec2 client
       ec2 = boto3.client('ec2', region_name=event['region'])
       
       # match any event that returns an ami-id	
       if 'ami-id' in event['detail']:
           imageId = event['detail']['ami-id']
   
           # launch instance from the AMI ID
           ec2.run_instances(
               ImageId=imageId,
               MaxCount=123,
               MinCount=1,
               InstanceType='t2.micro'
           )
           print 'launched instance with ami id: ' + imageId
       else:
           print 'did not launch instance'
   ```

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. Choose **Events**, **Create rule**\. For **Service Name**, choose **Server Migration Service \(SMS\)**\. For **Event Type**, choose **Server Migration Job State Change**\.

1. Choose **Target**, **Add Target**\. 

1. For **Lambda function**, select the Lambda function that you previously created and choose **Configure details**\.

1. On the **Configure rule details** page, type values for **Name** and **Description**\. Select the **State** check box to activate the function \(setting it to **Enabled**\)\.

1. Choose **Create rule**\.

Your rule should now appear on the **Rules** tab\. In the example shown, the configured event should launch an EC2 instance each time that you receive an AMI ID\. 