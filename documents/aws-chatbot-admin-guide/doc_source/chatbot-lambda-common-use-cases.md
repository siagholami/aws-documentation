# Using AWS Lambda with AWS Chatbot \- Common use cases<a name="chatbot-lambda-common-use-cases"></a>

Common use cases for using AWS Chatbot in Slack involve invoking Lambda functions\. This topic includes example use cases for using AWS Chatbot in Slack to invoke Lambda functions\. In these use case examples, we use the payload parameter\. When specified in an AWS CLI command, the payload parameter accepts a JSON object\. For a tutorial that walks you through how to use AWS Chatbot with other services, see the [Tutorial: Using AWS Chatbot to run an AWS Lambda function remotely](chatbot-run-lambda-function-remotely-tutorial.md)\. 

**Topics**
+ [Add an IP rule to a security group](#ip-allow-list)
+ [Remove an IP rule from a security group](#ip-remove-list)
+ [Change the capacity of an Amazon EC2 Auto Scaling group](#change-capacity)
+ [Approve an AWS CodePipeline action](#create-pipeline)

## Add an IP rule to a security group<a name="ip-allow-list"></a>

The example in this section uses the AWS CLI and a Lambda function to add an IP rule to an existing Amazon EC2 Security Group\. This allows you to add IP rules from Slack without having to access a console\. When using this function, consider removing the added IP address when it no longer needs access to the security group\. You should also ensure you are being secure by not adding unverified or inappropriate IP addresses\. For more information about security groups, see [Security groups for your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html) in the *Amazon Virtual Private Cloud User Guide*\.

In the following code example, the allowlist\-ip Lambda function accepts the payload specified by the user and adds the IP address by programmatically creating an inbound rule using `authorize_security_group_ingress`\. This gives the specified IP address SSH access\. The Lambda code uses Python 3\.8\. For more information about the `authorize_security_group_ingress` method, see the [Adding rules to a security group](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/working-with-security-groups.html#adding-security-group-rule) in the *Amazon EC2 User Guide for Linux Instances*\.

```
import boto3
 
def lambda_handler(event, context):
    client = boto3.client('ec2')
  
    
    response = client.authorize_security_group_ingress(
        GroupId='sg-0ab290fe68b7139fb',
        IpPermissions=[
            {
                'FromPort': 22,
                'IpProtocol': 'tcp',
                'IpRanges': [
                    {
                        'CidrIp': event['ip'],
                        'Description': 'SSH access from another office',
                    },
                ],
                'ToPort': 22,
            },
        ],
    )
 
    print(response)
```

The following AWS Chatbot command invokes the Lambda method using the specified parameters\.

```
@aws invoke allowlist-ip --payload {"ip": "192.0.2.0/24"}
```

## Remove an IP rule from a security group<a name="ip-remove-list"></a>

The example in this section uses the AWS CLI and a Lambda function to remove an IP rule from an existing Amazon Elastic Compute Cloud Security Group\. This is helpful because it conveniently allows you to remove IP rules from Slack without having to access a console\. For more information about security groups, see [Security groups for your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html) in the *Amazon Virtual Private Cloud User Guide*\.

In the following code example, the remove\-ip Lambda function accepts the payload specified by the user and removes the IP address using revoke\_security\_group\_ingress\. This revokes access from the specified IP address\. The Lambda code uses Python 3\.8\. For more information about the revoke\_security\_group\_ingress method, see the [ EC2 section](https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/ec2.html#EC2.Client.revoke_security_group_ingressp) of the *Boto3 Docs 1\.14\.9 documentation*\.

```
import boto3
 
def lambda_handler(event, context):
    client = boto3.client('ec2')
  
    
    response = client.revoke_security_group_ingress(
        GroupId='sg-0ab290fe68b7139fb',
        IpPermissions=[
            {
                'FromPort': 22,
                'IpProtocol': 'tcp',
                'IpRanges': [
                    {
                        'CidrIp': event['ip'],
                        'Description': 'SSH access from another office',
                    },
                ],
                'ToPort': 22,
            },
        ],
    )
 
    print(response)
```

The following AWS Chatbot command invokes the Lambda method using the specified parameters\.

```
@aws invoke remove-ip --payload {"ip": "192.0.2.0/24"}
```

## Change the capacity of an Amazon EC2 Auto Scaling group<a name="change-capacity"></a>

This code example shows how to change the capacity of an Amazon EC2 Auto Scaling group\. For more information about Auto Scaling groups, see the [Auto Scaling Groups](https://docs.aws.amazon.com/autoscaling/ec2/userguide/AutoScalingGroup.html) section of the *Amazon EC2 Auto Scaling User Guide*\. 

In the following code example, the capacity value is passed into the Lambda function and the desired capacity is programmatically set using the set\_desired\_capacity method\. For more information about this method, see the [AutoScaling](https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/autoscaling.html) section of the *Boto3 Docs 1\.14\.1 documentation*\. The Lambda code uses Python 3\.8\.

```
import boto3
 
def lambda_handler(event, context):
    client = boto3.client('autoscaling')
    
    response = client.set_desired_capacity(
        AutoScalingGroupName='myGroup',
        DesiredCapacity= event['desired-capacity'],
        HonorCooldown=True,
    )
 
    print(response)
```

The following AWS Chatbot command invokes the autoscaling\-lambda Lambda function with a payload that specifies a capacity of 50\.

```
@aws invoke autoscaling-lambda --payload {"desired-capacity": 50}
```

## Approve an AWS CodePipeline action<a name="create-pipeline"></a>

The code example in this section demonstrates how you can use a Lambda function to manually approve a pipeline action\. This function enables you to approve or reject a pipeline action from Slack by entering the status and a summary\. The function gets the required token using the get\_pipeline\_status method\. It then uses the token value when applying the approval decision by using the put\_approval\_result method\. For more information about these methods, see the [CodePipeline section](https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/codepipeline.html) of the *Boto3 docs 1\.14\.10 documentation*\. The Lambda code uses Python 3\.8\.

```
import boto3
 
def lambda_handler(event, context):
    client = boto3.client('codepipeline')
    
    getToken = client.get_pipeline_state(
        name = 'mypipeline1'
    )
    
    myToken=getToken['stageStates']['actionStates']['latestExecution']['token']
    
    response = client.put_approval_result(
        pipelineName='mypipeline1',
        stageName='beta',
        actionName='Approval',
        result={
            'summary': ['summary'],
            'status': ['status']
        },
        token=myToken

    )
```

The following AWS Chatbot command invokes the Lambda function\. For more information about CodePipeline and pipeline actions, see the [https://docs.aws.amazon.com/codepipeline/latest/userguide/welcome.html](https://docs.aws.amazon.com/codepipeline/latest/userguide/welcome.html)\.

```
@aws invoke mypipeline1-beta-Approval --payload {"summary": "the design looks good, ready to release",“status”: "Approved"}
```