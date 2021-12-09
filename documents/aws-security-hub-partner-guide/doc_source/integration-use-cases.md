# Integration use cases and required permissions<a name="integration-use-cases"></a>

AWS Security Hub allows AWS customers to receive findings from APN Partners\. The partner's products might run either inside or outside of the customer's AWS account\. The permission configuration in the customer's account differs based on the model that the partner product uses\.

In Security Hub, the customer always controls which partners can send findings to the customer's account\. Customers can revoke permissions from a partner at any time\.

To enable a partner to send security findings to their account, the customer first subscribes to the partner product in Security Hub\. The subscription step is necessary for all of the use cases that are outlined below\. For details on how customers manage product integrations, see [Managing product integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-integrations-managing.html) in the *AWS Security Hub User Guide*\.

After a customer subscribes to a partner product, Security Hub automatically creates a managed resource policy\. The policy grants the partner product permission to use the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation to send findings to Security Hub for the customer’s account\.

Here are the common cases for partner products that integrate with Security Hub\. The information includes the additional permissions required for each use case\.

## Partner hosted: findings sent from partner account<a name="partner-hosted-from-partner-account"></a>

This use case covers partners who host a product in their own AWS account\. To send security findings for an AWS customer, the partner calls the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation from the partner product account\.

For this use case, the customer account only needs the permissions that are established when the customer subscribes to the partner product\.

In the partner account, the IAM principal that calls the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation must have an IAM policy that allows the principal to call [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html)\.

Enabling a partner product to send findings to the customer in Security Hub is a two\-step process:

1. The customer creates a subscription to a partner product in Security Hub\.

1. Security Hub generates the correct managed resource policy with the customer's confirmation\.

To send security findings related to the customer’s account, the partner product uses their own credentials to call the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation\.

Here is an example of an IAM policy that grants the principal in the partner account the necessary Security Hub permissions\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": "securityhub:BatchImportFindings",
            "Resource": "arn:aws:securityhub:us-west-1:*:product-subscription/company-name/product-name"
        }
    ]
}
```

## Partner hosted: findings sent from the customer account<a name="partner-hosted-from-customer-account"></a>

This use case covers partners who host a product in their own AWS account, but use a cross\-account role to access the customer's account\. They call the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation from the customer’s account\.

For this use case, to call the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation, the partner account assumes a customer managed IAM role in the customer's account\.

This call is made from the customer's account\. Therefore, the managed resource policy must allow the product ARN for the partner product's account to be used in the call\. The Security Hub managed resource policy grants permission for the partner product account and the partner product ARN\. The product ARN is the partner's unique identifier as a provider\. Because the call does not come from the partner product account, the customer must explicitly grant permission for the partner product to send findings to Security Hub\.

The best practice for cross\-account roles between partner and customer accounts is to use an external identifier that the partner provides\. This external identifier is part of the cross\-account policy definition in the customer’s account\. The partner must provide the identifier when it assumes the role\. An external identifier provides an additional layer of security when granting AWS account access to a partner\. The unique identifier ensures that the partner uses the correct customer account\.

Enabling a partner product to send findings to the customer in Security Hub with a cross\-account role happens in four steps:

1. The customer, or partner using cross\-account roles working on behalf of the customer, starts the subscription to a product in Security Hub\.

1. Security Hub generates the correct managed resource policy with the customer's confirmation\.

1. The customer configures the cross\-account role either manually or using AWS CloudFormation\. For information on cross\-account roles, see [Providing access to AWS accounts owned by third parties](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_common-scenarios_third-party.html) in the *IAM User Guide*\.

1. The product securely stores the customer role and external ID\.

Next, the product sends findings to Security Hub:

1. The product calls the AWS Security Token Service \(AWS STS\) to assume the customer role\.

1. The product calls the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation on Security Hub with the assumed role's temporary credentials\.

Here is an example of an IAM policy that grants the necessary Security Hub permissions to the partner's cross\-account role\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": "securityhub:BatchImportFindings",
            "Resource": " arn:aws:securityhub:us-west-1:111122223333:product-subscription/company-name/product-name"
        }
    ]
}
```

The `Resource` section of the policy identifies the specific product subscription\. This ensures that the partner can only send findings for the partner product that the customer is subscribed to\.

## Customer hosted: findings sent from customer account<a name="customer-hosted-from-customer-account"></a>

This use case covers partners that have a product that is deployed in the customer’s AWS account\. The [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API is called from the solution that runs in the customer’s account\.

For this use case, the partner product must be granted additional permissions to call the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API\. How this permission is granted differs based on the partner solution and how it is configured in the customer’s account\.

An example of this approach is a partner product that runs on an EC2 instance in the customer’s account\. This EC2 instance must have an EC2 instance role attached to it that grants that instance the ability to call the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation\. This allows the EC2 instance to send security findings to the customer’s account\.

This use case is functionally equivalent to a scenario where a customer loads findings into their account for a product that they own\.

The customer enables the partner product to send findings from the customer's account to the customer in Security Hub:

1. The customer deploys the partner product into their AWS account manually using AWS CloudFormation, or another deployment tool\.

1. The customer defines the necessary IAM policy for the partner product to use when it sends findings to Security Hub\.

1. The customer attaches the policy to the necessary components of the partner product, such as an EC2 instance, a container, or a Lambda function\.

Now the product can send findings to Security Hub:

1. The partner product uses the AWS SDK or AWS CLI to call the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation in Security Hub\. It makes the call from the component in the customer’s account where the policy is attached\.

1. During the API call, the necessary temporary credentials are generated to allow the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) call to succeed\.

Here is an example of an IAM policy that grants the necessary Security Hub permissions to the partner product in the customer account\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": "securityhub:BatchImportFindings",
            "Resource": "arn:aws:securityhub:us-west-2:111122223333:product-subscription/company-name/product-name"
        }
    ]
}
```