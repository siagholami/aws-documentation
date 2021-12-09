--------

--------

# Security in AWS IoT Greengrass Deployments<a name="iot-tg-security-gg"></a>

AWS IoT Things Graph uses the security features of AWS IoT Greengrass for AWS IoT Greengrass deployments\. For more information, see [AWS IoT Greengrass Security](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-sec.html) in the *AWS IoT Greengrass Developer Guide*\.

AWS IoT Things Graph users should have permissions to perform the following actions:
+ `s3:REST.GET.OBJECT`
+ `s3:REST.PUT.OBJECT`
+ `iot:CreateTopicRule`
+ `iot:ListTopicRules`
+ `iot:GetTopicRule`
+ `iot:DescribeThing`
+ `iot:ListThingPrincipals`
+ `iot:UpdateThing`
+ `iot:AddThingToThingGroup`
+ `iot:DescribeThingGroup`
+ `iot:CreateThingGroup`
+ `iot:ListThingsInThingGroup`
+ `iot:DeleteThingGroup`
+ `iot:RemoveThingFromThingGroup`
+ `greengrass:CreateGroupVersion`
+ `greengrass:CreateDeployment`
+ `greengrass:GetDeviceDefinitionVersion`
+ `greengrass:CreateDeviceDefinitionVersion`
+ `greengrass:CreateDeviceDefinition`
+ `greengrass:GetFunctionDefinitionVersion`
+ `greengrass:CreateFunctionDefinitionVersion`
+ `greengrass:CreateFunctionDefinition`
+ `greengrass:GetResourceDefinitionVersion`
+ `greengrass:CreateResourceDefinitionVersion`
+ `greengrass:CreateResourceDefinition`
+ `greengrass:GetSubscriptionDefinitionVersion`
+ `greengrass:CreateSubscriptionDefinitionVersion`
+ `greengrass:CreateSubscriptionDefinition`
+ `greengrass:ListGroups`
+ `greengrass:GetGroupVersion`
+ `greengrass:GetConnectorDefinitionVersion`
+ `greengrass:CreateConnectorDefinition`
+ `greengrass:CreateConnectorDefinitionVersion`
+ `iam:PassRole`

## MQTT Subscriptions<a name="iot-tg-security-data"></a>

AWS IoT Things Graph runs as an AWS Lambda function on the AWS IoT Greengrass core device\. When new workflows are deployed to AWS IoT Greengrass, AWS IoT Things Graph creates entries in the subscription table for communication between the devices in the workflow and the AWS IoT Things Graph Lambda function\. 

AWS IoT Things Graph therefore creates subscriptions to all of the MQTT topics that the devices in your workflow use\. The subscription table is used by the AWS IoT Greengrass core device for authorization of all communications\. The AWS IoT Things Graph Lambda function mediates communications among the devices in the workflow\.