# Setting Up ACM Private CA<a name="PcaGettingStarted"></a>

Before using ACM Private CA, you might need to complete a couple of tasks\. 

\(Optional\) In addition, you should determine whether your organization prefers to host its private root CA credentials on premises rather than with AWS\. In that case, you need to set up and secure a self\-managed private PKI before using ACM Private CA\. In this scenario, you then create a subordinate CA in ACM Private CA backed by a parent CA outside of ACM Private CA\. For more information, see [Using a Root Authority Outside ACM Private CA](https://docs.aws.amazon.com/acm-pca/latest/userguide/PCACertInstall.html#InstallSubordinateExternal)\.

## Sign Up for AWS<a name="setup-aws"></a>

If you're not already an Amazon Web Services \(AWS\) customer, you must sign up to be able to use ACM Private CA\. Your account automatically has access to all available services, but you are charged only for services that you use\. Also, if you are a new AWS customer, some services are available for free during a limited period\. For more information, see [AWS Free Tier](https://aws.amazon.com/free/)\. 

**Note**  
ACM Private CA is not available in the free tier\.

If you do not have an AWS account, complete the following steps to create one\.

**To sign up for an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

## Install the AWS Command Line Interface \(Optional\)<a name="PcaInstallCLI"></a>

If you have not installed the AWS CLI but want to use it, follow the directions at [AWS Command Line Interface](https://aws.amazon.com/cli/)\. In this guide, we assume you have [configured](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html) your endpoint, region, and authentication details, and we omit these parameters from the sample commands\.