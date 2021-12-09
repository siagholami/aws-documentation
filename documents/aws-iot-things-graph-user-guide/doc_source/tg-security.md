--------

--------

# AWS IoT Things Graph Security<a name="tg-security"></a>

AWS IoT Things Graph uses X\.509 certificates, managed subscriptions, AWS IoT policies, and IAM policies and roles to secure the applications that run on devices either in the cloud or in your local AWS IoT Greengrass environment\. AWS IoT Things Graph uses the AWS IoT security features for cloud deployments and the AWS IoT Greengrass security features for AWS IoT Greengrass deployments\. 

For more information about AWS IoT security, see [Security in AWS IoT](https://docs.aws.amazon.com/iot/latest/developerguide/security.html) in the *AWS IoT Developer Guide*\. 

For more information about AWS IoT Greengrass security, see [AWS IoT Greengrass Security](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-sec.html) in the *AWS IoT Greengrass Developer Guide*\.

## IAM Role for Flow Execution in Cloud Deployments<a name="tg-security-cloud"></a>

Cloud deployments require you to use an IAM role to allow AWS IoT Things Graph to execute the flows in the deployments on your behalf\. For more information about creating this role, see [Prepare for Cloud Deployments](iot-tg-gs-environment-cloud.html)\.

The following diagram shows how AWS IoT Things Graph security fits within AWS IoT security\.

![\[Example graphic of how AWS IoT security works with AWS IoT Things Graph security.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/cloud-security-overview.png)

## IAM Role for Flow Execution in AWS IoT Greengrass Deployments<a name="tg-security-gg"></a>

AWS IoT Greengrass deployments require you to use an IAM role to allow AWS IoT Things Graph to execute the flows in the deployments on your behalf\. Your AWS IoT Greengrass service role must also have read and write permissions for Amazon S3\. For more information about creating and setting up these roles, see [Setting Up Your Environment for AWS IoT Greengrass Deployments](iot-tg-gs-environment.html)\.

The following diagram shows how AWS IoT Things Graph security fits within AWS IoT Greengrass security\.

![\[Example graphic of how AWS IoT security works with AWS IoT Greengrass security.\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/gg-security-overview.png)