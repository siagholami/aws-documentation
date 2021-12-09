# What Is AWS RAM?<a name="what-is"></a>

AWS Resource Access Manager \(AWS RAM\) lets you share your resources with any AWS account or through AWS Organizations\. If you have multiple AWS accounts, you can create resources centrally and use AWS RAM to share those resources with other accounts\.

**Topics**
+ [Benefits](#what-is-features)
+ [How Resource Sharing Works](#what-is-how)
+ [Service Limits](#what-is-limits)
+ [Accessing AWS RAM](#what-is-accessing)
+ [Pricing](#what-is-pricing)
+ [Shareable Resources](shareable.md)

## Benefits<a name="what-is-features"></a>

AWS RAM offers the following benefits:
+ **Reduces operational overhead**—Create resources centrally and use AWS RAM to share those resources with other accounts\. This eliminates the need to provision duplicate resources in every account, which reduces operational overhead\.
+ **Provides security and consistency**—Govern consumption of shared resources using existing policies and permissions, to achieve security and control\. AWS RAM offers a consistent experience for sharing different types of AWS resources\.
+ **Provides visibility and auditability**—View usage details for shared resources through integration with Amazon CloudWatch and AWS CloudTrail\. AWS RAM provides comprehensive visibility into shared resources and accounts\.

## How Resource Sharing Works<a name="what-is-how"></a>

When you share a resource with another account, then that account is granted access to the resource\. Any policies and permissions that apply to the account with which you have shared the resource apply to the shared resource\.

### Sharing Your Resources<a name="what-is-how-sharing"></a>

You can share resources that you own by creating a resource share\. When you create a resource share, you specify a name, the resources to share, and the principals with whom to share\. Principals can be AWS accounts, organizational units, or an entire organization from AWS Organizations\. Your account retains full ownership of the resources that you share\.

### Using Shared Resources<a name="what-is-how-shared"></a>

When the owner of a resource shares it with your account, you can access the shared resource just as you would if it was owned by your account\. You can access the resource using the respective service's console, AWS CLI, and API\. The actions that users are allowed to perform vary depending on the resource type\. All IAM policies and service control policies configured in your account apply, which enables you to leverage your existing investments in security and governance controls\.

## Service Limits<a name="what-is-limits"></a>

Your AWS account has the following limits related to AWS RAM\. You can request an increase for some of these limits\. To request a limit increase, contact [AWS Support](https://console.aws.amazon.com/support/home#/)\.


| Resource | Default limit | 
| --- | --- | 
|  Maximum number of resource shares per account  |  5000  | 
|  Maximum number of shared resources per account  |  5000  | 
|  Maximum number of pending invitations per account  |  20  | 

## Accessing AWS RAM<a name="what-is-accessing"></a>

You can work with AWS RAM in any of the following ways:

**AWS RAM Console**  
AWS RAM provides a web\-based user interface, the AWS RAM console\. If you've signed up for an AWS account, you can access the AWS RAM console by signing into the [AWS Management Console](https://console.aws.amazon.com/) and selecting AWS RAM from the console home page\.

**AWS Command Line Interface \(AWS CLI\)**  
The AWS CLI provides direct access to the AWS RAM public API operations\. It is supported on Windows, macOS, and Linux\. For more information about getting started, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. For more information about the commands for AWS RAM, see the [AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/)\.

**AWS Tools for Windows PowerShell**  
AWS provides commands for a broad set of AWS products for those who script in the PowerShell environment\. For more information about getting started, see the [AWS Tools for Windows PowerShell User Guide](https://docs.aws.amazon.com/powershell/latest/userguide/)\. For more information about the cmdlets for AWS RAM, see the [AWS Tools for Windows PowerShell Cmdlet Reference](https://docs.aws.amazon.com/powershell/latest/reference/)\.

**Query API**  
The AWS RAM HTTPS Query API gives you programmatic access to AWS RAM and AWS\. The AWS RAM API lets you issue HTTPS requests directly to the service\. When you use the AWS RAM API, you must include code to digitally sign requests using your credentials\. For more information, see the [AWS RAM API Reference](https://docs.aws.amazon.com/ram/latest/APIReference/Welcome.html)\.

## Pricing<a name="what-is-pricing"></a>

There are no additional charges for creating resource shares and sharing your resources across accounts\. Resource usage charges vary depending on the resource type\. For more information about about how shareable resources are billed, refer to the respective service's documentation\.