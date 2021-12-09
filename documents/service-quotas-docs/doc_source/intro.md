# What Is Service Quotas?<a name="intro"></a>

Service Quotas enables you to view and manage your quotas for AWS services from a central location\. Quotas, also referred to as limits, are the maximum values for the resources, actions, and items in your AWS account\. Each AWS service defines its quotas and establishes default values for those quotas\. Depending on your business needs, you might need to increase your service quota values\. Service Quotas makes it easy to quickly look up your available service quotas and to request increases\.

**Topics**
+ [Service Quotas Features](#features)
+ [Introducing the Service Quotas Components](#intro_getting-started)
+ [Accessing Service Quotas](#access)
+ [Key Terms and Concepts in Service Quotas](terms-concepts.md)

## Service Quotas Features<a name="features"></a>

 The following features are available\. 

### View AWS Service Quotas<a name="features_viewquota"></a>

The Service Quotas console provides quick access to the AWS default quota values for your account, across all commercial Regions\. When you select a service in the Service Quotas console, you'll see the quotas and whether the quota is adjustable\. Applied quotas are overrides, or increases for a particular quota, over the AWS default value\. 

### Request a Service Quota Increase<a name="features_requestquota"></a>

For any adjustable service quotas, you can use Service Quotas to request a quota increase\. To request a quota increase, in the console simply select the service and the specific quota, and choose Request quota increase\. You can also use the API or command line interface \(CLI\) tools to request service quota increases\. 

### View Current Utilization<a name="features_viewutilization"></a>

If your account has been active a while and a resource has been used, you can view a graph of your quota utilization\. 

### Set Amazon CloudWatch Alarms for Approaching Quotas<a name="features_alarms"></a>

For supported services, you can manage your quotas by configuring CloudWatch alarms to monitor usage and alert you to approaching quotas\.

### Control Who Manages Service Quotas<a name="features_control-access"></a>

You can attach AWS Identity and Access Management \(IAM\) permission policies to your users, groups, and roles that grant or deny permission to manage the service quotas in your AWS account\. For example, you could create a "quota administrator" who can view, manage, or request increases for any service quotas in your account\. You could also attach one policy to a group whose members need the ability to manage the quotas for a specific service\.

## Introducing the Service Quotas Components<a name="intro_getting-started"></a>

For a list of terms and concepts that you need to understand to make full use of Service Quotas, see [Key Terms and Concepts in Service Quotas](terms-concepts.md)\.

## Accessing Service Quotas<a name="access"></a>

You can work with Service Quotas in the following ways:

**AWS Management Console**  
[The Service Quotas console](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/dashboard) is a browser\-based interface that you can use to view and manage your service quotas\. You can perform almost any task that's related to your service quotas by using the console\. You can access Service Quotas from any AWS console page by choosing on the top navigation bar, or by searching for Service Quotas in the AWS Management Console\. 

**AWS Command Line Tools**  
The AWS command line tools let you issue commands at your system's command line to perform Service Quotas and other AWS tasks\. This can be faster and more convenient than using the console\. The command line tools also are useful if you want to build scripts that perform AWS tasks\.  
AWS provides two sets of command line tools: the [AWS Command Line Interface](https://aws.amazon.com/cli/) \(AWS CLI\) and the [AWS Tools for Windows PowerShell](https://aws.amazon.com/powershell/)\. For information about installing and using the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. For information about installing and using the Tools for Windows PowerShell, see the [AWS Tools for Windows PowerShell User Guide](https://docs.aws.amazon.com/powershell/latest/userguide/)\.

**AWS SDKs**  
The AWS SDKs consist of libraries and sample code for various programming languages and platforms \(for example, [Java](https://aws.amazon.com/sdk-for-java/), [Python](https://aws.amazon.com/sdk-for-python/), [Ruby](https://aws.amazon.com/sdk-for-ruby/), [\.NET](https://aws.amazon.com/sdk-for-net/), [iOS and Android](https://aws.amazon.com/mobile/resources/), and [others](https://aws.amazon.com/tools/#sdk)\)\. The SDKs include tasks such as cryptographically signing requests, managing errors, and retrying requests automatically\. For more information about the AWS SDKs, including how to download and install them, see [Tools for Amazon Web Services](https://aws.amazon.com/tools/#sdk)\.