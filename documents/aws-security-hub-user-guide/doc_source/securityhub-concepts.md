# Terminology and concepts<a name="securityhub-concepts"></a>

This topic describes the key concepts in AWS Security Hub to help you get started\.

**Account**  
A standard Amazon Web Services \(AWS\) account that contains your AWS resources\. You can sign in to AWS with your account and enable Security Hub\.  
You can also invite other accounts to enable Security Hub and become associated with your account in Security Hub\. If your invitations are accepted, your account is designated as the Security Hub *master* account, and the added accounts are *member* accounts\. As the master account, you can view findings in your member accounts\.  
An account cannot be both a Security Hub master account and a member account at the same time\. An account can accept only one membership invitation\. Accepting a membership invitation is optional\.  
For more information, see [Master and member accounts in AWS Security Hub](securityhub-accounts.md)\.

**Archived finding**  
A finding that has a `RecordState` set to `ARCHIVED`\.  
Finding providers can use the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) operation of the Security Hub API to archive findings that they created\. Security Hub automatically archives findings for controls if the associated resource is deleted, based on one of the following criteria\.  
+ The finding was not updated in three days\.
+ The associated AWS Config evaluation returned `NOT_APPLICABLE`\.
By default, archived findings are excluded from findings lists in the Security Hub console\. You can update the filter to include archived findings\.  
The [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_GetFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_GetFindings.html) operation of the Security Hub API returns both active and archived findings\. You can include a filter for the record state\.  

```
"RecordState": [ 
    { 
        "Comparison": "EQUALS",
        "Value": "ARCHIVED"
    }
],
```

**AWS Security Finding Format**  
A standardized format for the contents of findings that Security Hub aggregates or generates\. The AWS Security Finding Format enables you to use Security Hub to view and analyze findings that are generated by AWS security services, third\-party solutions, or Security Hub itself from running security checks\. For more information, see [AWS Security Finding Format \(ASFF\)](securityhub-findings-format.md)\.

**Control**  
A safeguard or countermeasure prescribed for an information system or an organization designed to protect the confidentiality, integrity, and availability of its information and to meet a set of defined security requirements\. A security standard consists of controls\.

**Custom action**  
A Security Hub mechanism for sending selected findings to CloudWatch Events\. A custom action is created in Security Hub\. It is then linked to a CloudWatch Events rule\. The rule defines a specific action to take when a finding is received that is associated with the custom action ID\. Custom actions can be used, for example, to send a specific finding, or a small set of findings, to a response or remediation workflow\. For more information, see [Creating a custom action \(console\)](securityhub-cwe-custom-actions.md#securityhub-cwe-configure)\.

**Finding**  
The observable record of a security check or security\-related detection\.  
For more information about findings in Security Hub, see [Findings in AWS Security Hub](securityhub-findings.md)\.  
Findings are deleted 90 days after the most recent update or 90 days after the creation date if no update occurs\. To store findings for longer than 90 days, you can configure a rule in CloudWatch Events that routes findings to your Amazon S3 bucket\.

**Insight**  
A collection of related findings defined by an aggregation statement and optional filters\. An insight identifies a security area that requires attention and intervention\. Security Hub offers several managed \(default\) insights that you can't modify\. You can also create custom Security Hub insights to track security issues that are unique to your AWS environment and usage\. For more information, see [Insights in AWS Security Hub](securityhub-insights.md)\.

**Related requirements**  
A set of industry or regulatory requirements that are mapped to a control\.

**Rule**  
A set of automated criteria that is used to assess whether a control is being adhered to\. When a rule is evaluated, it can pass or fail\. If the evaluation cannot determine whether rule passes or fails, then the rule is in a warning state\. If the rule cannot be evaluated, then it is in a not available state\.

**Security check**  
A specific point\-in\-time evaluation of a rule against a single resource resulting in a passed, failed, warning, or not available state\. Running a security check produces a finding\.

**Security standard**  
A published statement on a topic specifying the characteristics, usually measurable and in the form of controls, that must be satisfied or achieved for compliance\. Security standards can be based on regulatory frameworks, best practices, or internal company policies\. To learn more about security standards in Security Hub, see [Security standards and controls in AWS Security Hub](securityhub-standards.md)\.

**Workflow status**  
The status of an investigation into a finding\. Tracked using the `Workflow.Status` attribute\.  
The workflow status is initially `NEW`\. If you notified the resource owner to take action on the finding, you can set the workflow status to `NOTIFIED`\. If the finding is not an issue, and does not require any action, set the workflow status to `SUPPRESSED`\. After you review and remediate a finding, set the workflow status to `RESOLVED`\.  
By default, most finding lists only include findings with a workflow status of `NEW` or `NOTIFIED`\. Finding lists for controls also include `RESOLVED` findings\.  
For the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_GetFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_GetFindings.html) operation, you can include a filter for the workflow status\.  

```
"WorkflowStatus": [ 
    { 
        "Comparison": "EQUALS",
        "Value": "RESOLVED"
    }
],
```
The Security Hub console provides an option to set the workflow status for findings\. Customers \(or SIEM, ticketing, incident management, or SOAR tools working on behalf of a customer to update findings from finding providers\) can also use [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html) to update the workflow status\.