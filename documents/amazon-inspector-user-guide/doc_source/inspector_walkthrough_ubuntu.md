# Amazon Inspector tutorial \- Ubuntu Server<a name="inspector_walkthrough_ubuntu"></a>

Before you follow the instructions in this tutorial, we recommend that you get familiar with the [Amazon Inspector terminology and concepts](inspector_concepts.md)\.

This tutorial shows how to use Amazon Inspector to analyze the behavior of an EC2 instance that runs the Ubuntu Server 16\.04 LTS operating system\. It provides step\-by\-step instructions on how to navigate the Amazon Inspector workflow\. This includes preparing an Amazon EC2 instance, to running an assessment template, to performing a recommended security fix generated in the assessment's findings\. 

If you are a first\-time user and would like to set up and run an Amazon Inspector assessment with one click, see [Creating a Basic Assessment](inspector_getting-started.md#inspector_basic-assessment)\.

**Topics**
+ [Step 1: Set up an Amazon EC2 instance to use with Amazon Inspector](#setupinspector_ubuntu)
+ [Step 2: Modify your Amazon EC2 instance](#prepareapplication_ubuntu)
+ [Step 3: Create an assessment target and install an agent on the EC2 instance](#createassessmenttarget_ubuntu)
+ [Step 4: Create and run your assessment template](#createassessmenttemplate_ubuntu)
+ [Step 5: Locate and analyze generated findings](#analyzefinding_ubuntu)
+ [Step 6: Apply the recommended fix to your assessment target](#upgradeapplication_ubuntu)

## Step 1: Set up an Amazon EC2 instance to use with Amazon Inspector<a name="setupinspector_ubuntu"></a>

**To set up an EC2 instance**
+ For this tutorial, create one EC2 instance running Ubuntu Server 16\.04 LTS and tag it using the **Name** key and a value of **InspectorEC2InstanceUbuntu**\.
**Note**  
For more information about tagging EC2 instances, see [ Resources and Tags](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_Resources.html)\.

## Step 2: Modify your Amazon EC2 instance<a name="prepareapplication_ubuntu"></a>

For this tutorial, you modify your target EC2 instance to expose it to the potential security issue CVE\-2017\-6507\. For more information, see [ https://cve\.mitre\.org/cgi\-bin/cvename\.cgi?name=CVE\-2017\-6507](https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2017-6507) and [Common vulnerabilities and exposures](inspector_cves.md)\. 

**To modify your EC2 instance**
+ Connect to your instance **InspectorEC2InstanceUbuntu** that you created in the preceding section, and run the following command:

  `sudo apt-get install apparmor=2.10.95-0ubuntu2.5`

## Step 3: Create an assessment target and install an agent on the EC2 instance<a name="createassessmenttarget_ubuntu"></a>

Amazon Inspector uses assessment targets to designate the AWS resources to evaluate\.

**To create an assessment target and install an agent on the EC2 instance**

1. Sign in to the AWS Management Console and open the Amazon Inspector console at [https://console\.aws\.amazon\.com/inspector/](https://console.aws.amazon.com/inspector/)\.

1. In the navigation pane, choose **Assessment targets**, and then choose **Create**\.

1. For **Name**, enter the name for your assessment target\.

   For this tutorial, type **MyTargetUbuntu**\.

1. For **Use Tags**, choose the EC2 instances that you want to include in this assessment target by entering values for the **Key** and **Value** fields\.

   For this tutorial, choose the EC2 instance that you created in the preceding step by entering **Name** in the **Key** field and **InspectorEC2InstanceUbuntu** in the **Value** field\. 

   To include all EC2 instances in your AWS account and Region in the assessment target, select the **All Instances** box\.

1. Install an Amazon Inspector Agent on your tagged EC2 instance\. To install an agent on all EC2 instances included in an assessment target, select the **Install Agents** box\.
**Note**  
You can also install the Amazon Inspector Agent using the [Systems Manager Run Command](inspector_installing-uninstalling-agents.md#install-run-command)\. To install the agent on all instances in the assessment target, you can specify the same tags used for creating the assessment target\. Or you can install the Amazon Inspector Agent on your EC2 instance manually\. For more information, see [Installing Amazon Inspector agents](inspector_installing-uninstalling-agents.md)\.

1. Choose **Save**\.

**Note**  
At this point, a service\-linked role called `AWSServiceRoleForAmazonInspector` is created to grant Amazon Inspector access to your resources\. For more information, see [Creating a service\-linked role for Amazon Inspector](inspector_slr.md#create-slr)\.

## Step 4: Create and run your assessment template<a name="createassessmenttemplate_ubuntu"></a>

**To create and run your template**

1. If you are using **Advanced setup**, you are directed to the **Define an assessment template** page\. Otherwise, navigate to the **Assessment templates** page, and then choose **Create**\.

1. For **Name**, enter the name for your assessment template\. For this tutorial, enter **MyFirstTemplateUbuntu**\.

1. For **Target name**, choose the assessment target that you created above, **MyTargetUbuntu**\.

1. For **Rules packages**, use the dropdown menu to choose the rules packages that you want to use in this assessment template\.

   For this tutorial, choose **Common Vulnerabilities and Exposures\-1\.1**\.

1. For **Duration**, specify the duration for your assessment template\.

   For this tutorial, choose **15 minutes**\.

1. If you are using **Advanced setup**, choose **Next**\. On the following **Review** page, choose **Create**\. Otherwise, choose **Create and run**\.

## Step 5: Locate and analyze generated findings<a name="analyzefinding_ubuntu"></a>

A completed assessment run produces a set of findings, or potential security issues that Amazon Inspector discovers in your assessment target\. You can review the findings and follow the recommended steps to resolve the potential security issues\.

In this tutorial, if you completed the preceding steps, your assessment run produces a finding against the common vulnerability **CVE\-2017\-6507**\.

1. Navigate to the **Assessment Runs** page\. Verify that the status of the run for the assessment template called **MyFirstTemplateUbuntu** that you created in the preceding step is set to **Collecting data**\. This indicates that the assessment run is currently in progress, and the telemetry data for your target is being collected and analyzed against the selected rules packages\.

1. You can't view the findings generated by the assessment run while it is still in progress\. Let the assessment run complete its entire duration\. 

   The status of **MyFirstTemplateUbuntu** changes first to **Stopping**, then in a few minutes to **Analyzing**, and then finally to **Analysis complete**\. To see this change in status, choose the **Refresh** icon\.

1. Navigate to the **Findings** page\.

   You can see a new finding of **High** severity called **Instance InspectorEC2InstanceUbuntu is vulnerable to CVE\-2017\-6507**\.
**Note**  
If you don't see the new finding, choose the **Refresh** icon\.

   To expand the view and see the details of this finding, choose the arrow to the left of the finding\. The details of the finding include the following:
   + ARN of the finding
   + Name of the assessment run that produced this finding
   + Name of the assessment target that produced this finding
   + Name of the assessment template that produced this finding
   + Assessment run start time
   + Assessment run end time
   + Assessment run status
   + Name of the rules package that includes the rule that triggered this finding
   + Amazon Inspector agent ID
   + Name of the finding
   + Severity of the finding
   + Description of the finding
   + Recommended remediation steps that you can complete to fix the potential security issue described by the finding

## Step 6: Apply the recommended fix to your assessment target<a name="upgradeapplication_ubuntu"></a>

For this tutorial, you modified your assessment target to expose it to a potential security issue **CVE\-2017\-6507**\. In this procedure, you apply the recommended fix for the issue\.

1. Connect to your instance **InspectorEC2InstanceUbuntu**, and run the following command: 

   `sudo apt-get install apparmor=2.10.95-0ubuntu2.6`

1. On the **Assessment templates** page, choose **MyFirstTemplateUbuntu**, and then choose **Run** to start a new run using this template\. 

1. Follow the steps in [Step 5: Locate and analyze generated findings](#analyzefinding_ubuntu) to see the findings that result from this subsequent run of the **MyFirstTemplateUbuntu** template\.

   Because you resolved the **CVE\-2017\-6507** security issue, you should no longer see a finding for it\. 