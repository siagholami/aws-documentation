# API Authentication and Authorization for Amazon MQ<a name="security-api-authentication-authorization"></a>

Amazon MQ uses standard AWS request signing for API authentication\. For more information, see [Signing AWS API Requests](https://docs.aws.amazon.com/general/latest/gr/signing_aws_api_requests.html) in the *AWS General Reference*\.

**Note**  
Currently, Amazon MQ doesn't support IAM authentication using resource\-based permissions or resource\-based policies\.

To authorize AWS users to work with brokers, configurations, and users, you must edit your IAM policy permissions\.

**Topics**
+ [IAM Permissions Required to Create an Amazon MQ Broker](#security-permissions-required-to-create-broker)
+ [Amazon MQ REST API Permissions Reference](#security-api-permissions-reference)
+ [Resource\-Level Permissions for Amazon MQ API Actions](#security-supported-iam-actions-resources)

## IAM Permissions Required to Create an Amazon MQ Broker<a name="security-permissions-required-to-create-broker"></a>

To create a broker, you must either use the `AmazonMQFullAccess` IAM policy or include the following EC2 permissions in your IAM policy\.

The following custom policy is comprised of two statements \(one conditional\) which grant permissions to manipulate the resources which Amazon MQ requires to create an ActiveMQ broker\.

**Important**  
The `ec2:CreateNetworkInterface` action is required to allow Amazon MQ to create an elastic network interface \(ENI\) in your account on your behalf\.
The `ec2:CreateNetworkInterfacePermission` action authorizes Amazon MQ to attach the ENI to an ActiveMQ broker\.
The `ec2:AuthorizedService` condition key ensures that ENI permissions can be granted only to Amazon MQ service accounts\.

```
{
    "Version": "2012-10-17",
    "Statement": [{
        "Action": [
            "mq:*",
            "[ec2:CreateNetworkInterface](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_CreateNetworkInterface.html)",
            "[ec2:DeleteNetworkInterface](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DeleteNetworkInterface.html)",
            "[ec2:DetachNetworkInterface](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DetachNetworkInterface.html)",
            "[ec2:DescribeInternetGateways](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeInternetGateways.html)",
            "[ec2:DescribeNetworkInterfaces](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeNetworkInterfaces.html)",
            "[ec2:DescribeRouteTables](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeRouteTables.html)",
            "[ec2:DescribeSecurityGroups](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroups.html)",
            "[ec2:DescribeSubnets](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSubnets.html)",
            "[ec2:DescribeVpcs](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeVpcs.html)"
        ],
        "Effect": "Allow",
        "Resource": "*"
    },{
        "Action": [
            "[ec2:CreateNetworkInterfacePermission](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_CreateNetworkInterfacePermission.html)",
            "[ec2:DeleteNetworkInterfacePermission](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DeleteNetworkInterfacePermission.html)",
            "[ec2:DescribeNetworkInterfacePermissions](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeNetworkInterfacePermissions.html)"
        ],
        "Effect": "Allow",
        "Resource": "*",
        "Condition": {
            "StringEquals": {
                "[ec2:AuthorizedService](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonec2.html#amazonec2-ec2_AuthorizedService)": "mq.amazonaws.com"
            }
        }
    }]
}
```

For more information, see [Step 2: Create an IAM User and Get Your AWS Credentials](amazon-mq-setting-up.md#create-iam-user) and [Never Modify or Delete the Amazon MQ Elastic Network Interface](connecting-to-amazon-mq.md#never-modify-delete-elastic-network-interface)\.

## Amazon MQ REST API Permissions Reference<a name="security-api-permissions-reference"></a>

The following table lists Amazon MQ REST APIs and the corresponding IAM permissions\.


**Amazon MQ REST APIs and Required Permissions**  

| Amazon MQ REST APIs | Required Permissions | 
| --- | --- | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-brokers.html#CreateBroker](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-brokers.html#CreateBroker) | mq:CreateBroker | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configurations.html#CreateConfiguration](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configurations.html#CreateConfiguration) | mq:CreateConfiguration | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/tags-resource-arn.html#CreateTags](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/tags-resource-arn.html#CreateTags) | mg:CreateTags | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#CreateUser](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#CreateUser) | mq:CreateUser | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#DeleteBroker](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#DeleteBroker) | mq:DeleteBroker | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#DeleteUser](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#DeleteUser) | mq:DeleteUser | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#DescribeBroker](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#DescribeBroker) | mq:DescribeBroker | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration.html#DescribeConfiguration](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration.html#DescribeConfiguration) | mq:DescribeConfiguration | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revision.html#DescribeConfigurationRevision](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revision.html#DescribeConfigurationRevision) | mq:DescribeConfigurationRevision | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/brokers-broker-id-users-username.html#DescribeUser](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/brokers-broker-id-users-username.html#DescribeUser) | mq:DescribeUser | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-brokers.html#ListBrokers](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-brokers.html#ListBrokers) | mq:ListBrokers | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revisions.html#rest-api-configuration-revisions-methods-get](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revisions.html#rest-api-configuration-revisions-methods-get) | mq:ListConfigurationRevisions | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configurations.html#ListConfigurations](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configurations.html#ListConfigurations) | mq:ListConfigurations | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/tags-resource-arn.html#ListTags](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/tags-resource-arn.html#ListTags) | mq:ListTags | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-users.html#ListUsers](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-users.html#ListUsers) | mq:ListUsers | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker-reboot.html#RebootBroker](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker-reboot.html#RebootBroker) | mq:RebootBroker  | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#UpdateBroker](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#UpdateBroker) | mq:UpdateBroker | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration.html#UpdateConfiguration](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration.html#UpdateConfiguration) | mq:UpdateConfiguration | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#UpdateUser](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#UpdateUser) | mq:UpdateUser | 

## Resource\-Level Permissions for Amazon MQ API Actions<a name="security-supported-iam-actions-resources"></a>

The term *resource\-level permissions* refers to the ability to specify the resources on which users are allowed to perform actions\. Amazon MQ has partial support for resource\-level permissions\. For certain Amazon MQ actions, you can control when users are allowed to use those actions based on conditions that have to be fulfilled, or specific resources that users are allowed to use\. 

The following table describes the Amazon MQ API actions that currently support resource\-level permissions, as well as the supported resources, resource ARNs, and condition keys for each action\.

**Important**  
If an Amazon MQ API action is not listed in this table, then it does not support resource\-level permissions\. If an Amazon MQ API action does not support resource\-level permissions, you can grant users permission to use the action, but you have to specify a \* wildcard for the resource element of your policy statement\.


| API Action | Resource Types \(\*required\) | 
| --- | --- | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configurations.html#CreateConfiguration](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configurations.html#CreateConfiguration) | [configurations\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/tags-resource-arn.html#CreateTags](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/tags-resource-arn.html#CreateTags) | [brokers](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies), [configurations](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#CreateUser](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#CreateUser) | [brokers\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#DeleteBroker](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#DeleteBroker) | [brokers\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#DeleteUser](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#DeleteUser) | [brokers\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#DescribeBroker](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#DescribeBroker) | [brokers\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration.html#DescribeConfiguration](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration.html#DescribeConfiguration) | [configurations\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revision.html#DescribeConfigurationRevision](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revision.html#DescribeConfigurationRevision) | [configurations\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/brokers-broker-id-users-username.html#DescribeUser](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/brokers-broker-id-users-username.html#DescribeUser) | [brokers\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revisions.html#ListConfigurationRevisions](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revisions.html#ListConfigurationRevisions) | [configurations\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revisions.html#ListConfigurationRevisions](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration-revisions.html#ListConfigurationRevisions) | [configurations\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/tags-resource-arn.html#ListTags](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/tags-resource-arn.html#ListTags) | [brokers](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies), [configurations](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-users.html#ListUsers](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-users.html#ListUsers) | [brokers\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker-reboot.html#RebootBroker](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker-reboot.html#RebootBroker) | [brokers\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#UpdateBroker](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-broker.html#UpdateBroker) | [brokers\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration.html#UpdateConfiguration](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-configuration.html#UpdateConfiguration) | [configurations\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 
| [https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#UpdateUser](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-user.html#UpdateUser) | [brokers\*](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) | 