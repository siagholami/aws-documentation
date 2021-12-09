# What is Amazon Inspector?<a name="inspector_introduction"></a>

Amazon Inspector tests the network accessibility of your Amazon EC2 instances and the security state of your applications that run on those instances\. Amazon Inspector assesses applications for exposure, vulnerabilities, and deviations from best practices\. After performing an assessment, Amazon Inspector produces a detailed list of security findings that is organized by level of severity\. 

With Amazon Inspector, you can automate security vulnerability assessments throughout your development and deployment pipelines or for static production systems\. This allows you to make security testing a regular part of development and IT operations\. 

Amazon Inspector also offers predefined software called an *agent* that you can optionally install in the operating system of the EC2 instances that you want to assess\. The agent monitors the behavior of the EC2 instances, including network, file system, and process activity\. It also collects a wide set of behavior and configuration data \(telemetry\)\.

**Important**  
AWS doesn't guarantee that following the provided recommendations will resolve every potential security issue\. The findings generated by Amazon Inspector depend on your choice of rules packages included in each assessment template, the presence of non\-AWS components in your system, and other factors\. You are responsible for the security of applications, processes, and tools that run on AWS services\. For more information, see the [ AWS Shared Responsibility Model](https://aws.amazon.com/compliance/shared-responsibility-model/) for security\.

**Note**  
AWS is responsible for protecting the global infrastructure that runs the services offered in the AWS Cloud\. This infrastructure consists of the hardware, software, networking, and facilities that run AWS services\. AWS provides several reports from third\-party auditors who have verified our compliance with a variety of computer security standards and regulations\. For more information, see [AWS Cloud Compliance](https://aws.amazon.com/compliance)\. 

For information about Amazon Inspector terminology, see [Amazon Inspector terminology and concepts](inspector_concepts.md)\.

## Benefits of Amazon Inspector<a name="InspectorBenefits"></a>

Here are some of the main benefits of Amazon Inspector:
+ **Integrate automated security checks into your regular deployment and production processes** – Assess the security of your AWS resources for forensics, troubleshooting, or active auditing purposes\. Run the assessments during the development process, or run them in a stable production environment\.
+ **Find application security issues** – Automate the security assessment of your applications and proactively identify vulnerabilities\. This allows you to develop and iterate on new applications quickly, and assess compliance with best practices and policies\.
+ **Gain a deeper understanding of your AWS resources** – Stay informed about the activity and configuration data of your AWS resources by reviewing the findings that Amazon Inspector produces\.

## Features of Amazon Inspector<a name="InspectorFeatures"></a>

Here are some of the main features of Amazon Inspector:
+ **Configuration scanning and activity monitoring engine** – Amazon Inspector provides an agent that analyzes system and resource configuration\. It also monitors activity to determine what an assessment target looks like, how it behaves, and its dependent components\. The combination of this telemetry provides a complete picture of the target and its potential security or compliance issues\. 
+ **Built\-in content library** – Amazon Inspector includes a built\-in library of rules and reports\. These include checks against best practices, common compliance standards, and vulnerabilities\. The checks include detailed recommended steps for resolving potential security issues\. 
+ **Automation through an API** – Amazon Inspector can be fully automated through an API\. This allows you to incorporate security testing into the development and design process, including selecting, executing, and reporting the results of those tests\. 

## Amazon Inspector pricing<a name="InspectorPricing"></a>

Amazon Inspector pricing is based on the number of EC2 instances included in each assessment and the rules packages used in those assessments\. For more information about Amazon Inspector pricing, see [Amazon Inspector Pricing](http://aws.amazon.com/inspector/pricing/)\.

## Accessing Amazon Inspector<a name="AccessingInspector"></a>

You can work with the Amazon Inspector service in any of the following ways:

**Amazon Inspector Console**  
Sign in to the AWS Management Console and open the Amazon Inspector console at [https://console\.aws\.amazon\.com/inspector/](https://console.aws.amazon.com/inspector/)\.  
The console is a browser\-based interface that lets you access and use the Amazon Inspector service\.

**AWS SDKs**  
AWS provides software development kits \(SDKs\) that consist of libraries and sample code for various programming languages and platforms\. These include Java, Python, Ruby, \.NET, iOS, Android, and more\. The SDKs provide a convenient way to create programmatic access to the Amazon Inspector service\. For information about the AWS SDKs, including how to download and install them, see [Tools for Amazon Web Services](https://aws.amazon.com/tools/)\.

**Amazon Inspector HTTPS API**  
You can access Amazon Inspector and AWS programmatically by using the Amazon Inspector HTTPS API, which lets you issue HTTPS requests directly to the service\. For more information, see the [Amazon Inspector API Reference](https://docs.aws.amazon.com/inspector/latest/APIReference/)\.

**AWS Command Line Tools**  
You can use the AWS command line tools to run commands at your system's command line to perform Amazon Inspector tasks\. The command line tools are also useful if you want to build scripts that perform AWS tasks\. For more information, see the [Amazon Inspector AWS Command Line Interface](http://docs.aws.amazon.com/cli/latest/reference/inspector/index.html)\.