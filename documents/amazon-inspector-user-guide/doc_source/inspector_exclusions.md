# Exclusions in Amazon Inspector<a name="inspector_exclusions"></a>

Exclusions are an output of Amazon Inspector assessment runs\. Exclusions show which of your security checks can't be completed and how to resolve the issues\. For example, issues can be caused by the absence of an agent on the specified target's EC2 instances, the use of an unsupported operating system, or unexpected errors\. 

You can view exclusions on the **Assessment runs** page on the console\. For more information, see [Viewing post\-assessment exclusions](#exclusions-post-assessment)\.

To avoid incurring unnecessary AWS fees, Amazon Inspector allows you to preview exclusions before running an assessment\. You can find the previews on the **Assessment templates** page on the console\. For more information, see [Previewing exclusions](#exclusions-pre-assessment)\.

**Note**  
You can generate post\-assessment exclusions only for runs that occur after June 25, 2018\. That's when exclusions in Amazon Inspector became available\. However, exclusion previews are available for all assessment templates regardless of date\.

**Topics**
+ [Exclusion types](#exclusion_types)
+ [Previewing exclusions](#exclusions-pre-assessment)
+ [Viewing post\-assessment exclusions](#exclusions-post-assessment)

## Exclusion types<a name="exclusion_types"></a>

Amazon Inspector can produce the following exclusion types\.


| Exclusion Type | Description | Recommendation | 
| --- | --- | --- | 
|  No instances in target  |  There are no EC2 instances with the tags specified in the assessment target\.  |  Check that the tags in your assessment target match the tags of your target EC2 instance\.  | 
|  Agent is already running  |  An assessment run is already in progress on the target EC2 instance\.  | Wait until the current assessment run on the target EC2 instance has completed\. | 
|  Agent not found  |   An Amazon Inspector agent was not found on the target EC2 instance\.  |  Install or reinstall an Amazon Inspector agent on the target EC2 instance\. For more information, see [Installing Amazon Inspector agents](inspector_installing-uninstalling-agents.md)\.  | 
|  Agent is unhealthy  |  The Amazon Inspector agent on the target EC2 instance is in an unhealthy state\.  |  Check the status of the Amazon Inspector agent on this instance and take necessary action\. For more information, see [Inspector Agents](                                 https://docs.aws.amazon.com/inspector/latest/userguide/inspector_agents.html)\.  | 
|  Unsupported OS version  | The operating system of the target EC2 instance is not supported for Amazon Inspector assessments\. |  Remove the target EC2 instance from the assessment target, or create a target that doesn't include this instance\. For a list of supported operating systems, see [Amazon Inspector Supported Operating Systems and Regions](https://docs.aws.amazon.com/inspector/latest/userguide/inspector_supported_os_regions.html)\.  | 
|  Deprecated rules package  |  The assessment template includes a deprecated rules package\.  |  Create an assessment template without the deprecated rules package, and use it for future assessment runs\.  | 
|  Rules package not supported by OS  |  The operating system of the target EC2 instance is not supported by a rules package included in the assessment template\.  |  Create an assessment template without the conflicting rules packages or remove the target EC2 instance from the assessment template\. For a list of rules package support by operating system, see [Rules Package Availability Across Supported Operating Systems](https://docs.aws.amazon.com/inspector/latest/userguide/inspector_rule-packages_across_os.html)\.   | 
|  Rules evaluation error for single instance  |  An internal error has caused the rules evaluation to fail for this instance\.  |  Attempt to run your assessment again\. Contact [support](https://aws.amazon.com/premiumsupport/) if the exclusion persists when you rerun the assessment\.  | 
|  Rules evaluation error  |  An internal error has caused the rules evaluation to fail for your assessment\.  | Attempt to run the assessment again\. Contact [support](https://aws.amazon.com/premiumsupport/) if the exclusion persists when you rerun the assessment\. | 
| Network Reachability error –internet |  An internal error has caused a Network Reachability evaluation to fail on checks for ports reachable from the internet\. You might get findings for other Network Reachability types\.  | Attempt to run the assessment again\. Contact [support](https://aws.amazon.com/premiumsupport/) if the exclusion persists when you rerun the assessment\. | 
| Network Reachability error – internet through an Application Load Balancer | An internal error has caused a Network Reachability evaluation to fail on checks for ports reachable from the internet through an Application Load Balancer\. You might get findings for other Network Reachability types\. | Attempt to run the assessment again\. Contact [support](https://aws.amazon.com/premiumsupport/) if the exclusion persists when you rerun the assessment\. | 
| Network Reachability error – internet through an Elastic Load Balancing load balancer | An internal error has caused a Network Reachability evaluation to fail on checks for ports reachable from the internet though an Elastic Load Balancing load balancer\. You might get findings for other Network Reachability types\. | Attempt to run the assessment again\. Contact [support](https://aws.amazon.com/premiumsupport/) if the exclusion persists when you rerun the assessment\. | 
| Network Reachability error –VPN | An internal error has caused a Network Reachability evaluation to fail on checks for ports reachable from VPN\. You might get findings for other Network Reachability types\. | Attempt to run the assessment again\. Contact [support](https://aws.amazon.com/premiumsupport/) if the exclusion persists when you rerun the assessment\. | 
| Network Reachability error – AWS Direct Connect | An internal error has caused a Network Reachability evaluation to fail on checks for ports reachable through AWS Direct Connect\. You might get findings for other Network Reachability types\. | Attempt to run the assessment again\. Contact [support](https://aws.amazon.com/premiumsupport/) if the exclusion persists when you rerun the assessment\. | 
| Network Reachability error – VPC peering | An internal error has caused a Network Reachability evaluation to fail on checks for ports reachable from a peered VPC\. You might get findings for other Network Reachability types\. | Attempt to run the assessment again\. Contact [support](https://aws.amazon.com/premiumsupport/) if the exclusion persists when you rerun the assessment\. | 

## Previewing exclusions<a name="exclusions-pre-assessment"></a>

Amazon Inspector allows you to preview potential exclusions before running an assessment\.

**To preview assessment exclusions**

1. Sign in to the AWS Management Console and open the Amazon Inspector console at [https://console\.aws\.amazon\.com/inspector/](https://console.aws.amazon.com/inspector/)\.

1. In the navigation pane, choose **Assessment templates**\. 

1. Expand a template, and in the **Assessment templates** section, choose **Preview exclusions**\.

1. Review the descriptions of all detected exclusions and the recommendations for addressing them\.

   You can also list and describe exclusions by using the [https://docs.aws.amazon.com/inspector/latest/APIReference/API_ListExclusions.html](https://docs.aws.amazon.com/inspector/latest/APIReference/API_ListExclusions.html) and [https://docs.aws.amazon.com/inspector/latest/APIReference/API_DescribeExclusions.html](https://docs.aws.amazon.com/inspector/latest/APIReference/API_DescribeExclusions.html) operations\.

## Viewing post\-assessment exclusions<a name="exclusions-post-assessment"></a>

After an assessment run, you can view details about any exclusions\.

**To view details about exclusions**

1. Sign in to the AWS Management Console and open the Amazon Inspector console at [https://console\.aws\.amazon\.com/inspector/](https://console.aws.amazon.com/inspector/)\.

1. In the navigation pane, choose **Assessment runs**\.

1.  In the **Exclusions** column, choose the active link that is associated with an assessment run\.

1. Review the descriptions of all detected exclusions and the recommendations for addressing them\.

   You can also list and describe exclusions by using the [https://docs.aws.amazon.com/inspector/latest/APIReference/API_ListExclusions.html](https://docs.aws.amazon.com/inspector/latest/APIReference/API_ListExclusions.html) and [https://docs.aws.amazon.com/inspector/latest/APIReference/API_DescribeExclusions.html](https://docs.aws.amazon.com/inspector/latest/APIReference/API_DescribeExclusions.html) operations\. 