# How Amazon Detective is used for investigation<a name="detective-investigation-about"></a>

Amazon Detective makes it easy to analyze, investigate, and quickly identify the root cause of security findings or suspicious activities\. If you are new to Detective, see [What is Detective?](https://docs.aws.amazon.com/detective/latest/adminguide/what-is.html) and [Detective terms and concepts](https://docs.aws.amazon.com/detective/latest/adminguide/detective-terms-concepts.html) in the *Detective Administration Guide*\.

Investigations in Detective can have different starting points but have a common flow\.

## Investigation phases<a name="how-detective-enables-investigation.title"></a>

At a high level, any investigation process involves the following phases:

****Triage****  
The investigation process starts when an analyst is notified about a suspected instance of malicious or high\-risk activity\. For example, the analyst is assigned to look into findings or alerts uncovered by services such as Amazon GuardDuty\.  
In the triage phase, the analyst determines whether they believe the activity is a true positive \(genuine malicious activity\) or false positive \(not malicious or high\-risk activity\)\.  
For true positive instances, the analyst continues to the next step\.

****Scoping****  
During the scoping phase, analysts determine the extent of the malicious activity and the underlying cause\.  
Scoping answers the following types of questions:  
+ What systems and users were compromised?
+ Where did the attack originate?
+ How long has the attack going on?
+ Is there other related activity to uncover? For example, if an attacker is exfiltrating data from your system, how did they obtain it?

**Response**  
The final step is to respond to the attack in order to stop the attack, minimize the damage, and prevent a similar attack from happening again\.

## Starting points for a Detective investigation process<a name="investigation-starting-points"></a>

Every investigation in Detective has an essential starting point\. For example, you might be assigned an Amazon GuardDuty finding to investigate\. Or you might have a hunch that there is unusual activity tied to a specific IP address\.

Typical starting points for an investigation include findings detected by GuardDuty and entities extracted from Detective source data\.

### Findings detected by GuardDuty<a name="investigation-findings-detected"></a>

This is the most common starting point for an investigation process in Detective\. GuardDuty uses your log data to uncover suspected instances of malicious or high\-risk activity\. Detective provides resources that help you dig further into these findings\.

Starting with a finding, you can do the following:
+ See what entities, such as IP addresses and AWS accounts, are connected to that finding\.
+ See what other findings might be related to that finding\.
+ See what activity occurred close in time or location to that finding\.

For more information, see [Analyzing finding details](finding-profiles.md)\.

### Entities extracted from Detective source data<a name="investigation-entity-extracted"></a>

From the ingested Detective source data, Detective extracts entities such as IP addresses and AWS users\. You can use one of these as an investigation starting point\. For more information, see [Analyzing entity details](entity-profiles.md)\.

Detective provides general details about the entity, such as the IP address or user name\. It also provides details on activity history\. For example, Detective can report what other IP addresses an entity has connected to, been connected to, or used\.

## Overview of a typical Detective investigation flow<a name="investigation-flow-overview"></a>

At a high level, the following image shows the process for investigating a finding in Detective:

![\[Diagram showing the overall flow of using Detective to triage a finding.\]](http://docs.aws.amazon.com/detective/latest/userguide/images/diagram_investigation_flow.png)

1. The first step is to select a finding to triage\.

   When looking at a finding in GuardDuty or AWS Security Hub, analysts can choose to investigate the finding in Detective\. See [Pivoting to a finding profile from Amazon GuardDuty or AWS Security Hub](profile-pivot-from-service.md)\.

   From within Detective, analysts can use the Detective search function to find and select a finding to triage\. See [Searching for a finding or entity](detective-search.md)\.

   Selecting the finding takes the analyst to the finding profile in Detective\.

1. The finding profile contains a set of visualizations\. The visualizations are generated from the behavior graph\. The behavior graph in turn is created from the log files and other data that are fed into Detective\.

   Most of the visualizations show activity that is related to the entity or entities involved in the finding\. Analysts use these visualizations to answer questions that are critical to completing the triage of the finding\. See [Analyzing finding details](finding-profiles.md)\.

   To help guide the triage, analysts can use the Detective guidance provided for each visualization\. The guidance outlines the displayed information, suggests questions for analysts to ask, and proposes next steps based on the answers\. See [Using profile panel guidance during an investigation](profile-panel-guidance.md)\.

   From the finding profile, analysts can pivot to entity profiles to dive deeper into a specific asset that is involved with the finding\. See [Analyzing entity details](entity-profiles.md)\.

1. Once they determine whether a finding is a true or false positive, analysts update the finding status in the original service\. For GuardDuty findings, Detective provides an option to archive the finding\. See [Archiving an Amazon GuardDuty finding](finding-update-status.md)\.