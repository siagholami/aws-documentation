# Guidelines for mapping findings into the AWS Security Finding Format \(ASFF\)<a name="guidelines-asff-mapping"></a>

Use the following guidelines to map your findings to the ASFF\. For detailed descriptions of each ASFF field and object, see [AWS Security Finding Format \(ASFF\)](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-format.html) in the *AWS Security Hub User Guide*\.

## Identifying information<a name="asff-identifying-information"></a>

`SchemaVersion` is always `2018-10-08`\.

`ProductArn` is the ARN that AWS Security Hub assigns to you\.

`Id` is the value that Security Hub uses to index findings\. The finding identifier must be unique, to ensure that other findings are not overwritten\. To update a finding, resubmit the finding with the same identifier\.

`GeneratorId` can be the same as `Id` or can refer to a discrete unit of logic, such as an Amazon GuardDuty detector ID, AWS Config recorder ID, or IAM Access Analyzer ID\.

## Title and Description<a name="asff-title-description"></a>

`Title` should contain some information about the affected resource\. `Title` is limited to 256 characters, including spaces\.

Add longer detailed information to `Description`\. `Description` is limited to 1024 characters, including spaces\. You can consider adding truncation to descriptions\. Here's an example:

```
"Title": "Instance i-12345678901 is vulnerable to CVE-2019-1234",
"Description": "Instance i-12345678901 is vulnerable to CVE-2019-1234. This vulnerability affects version 1.0.1 of widget-1 and earlier, and can lead to buffer overflow when someone sends a ping.",
```

## Finding types<a name="asff-finding-types"></a>

`Types` should match the [types taxonomy for ASFF](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-format.html#securityhub-findings-format-type-taxonomy)\.

If needed, you can specify a custom classifier \(the third namespace\)\.

## Timestamps<a name="asff-timestamps"></a>

The ASFF format includes a few different timestamps\.

**`CreatedAt` and `UpdatedAt`**  
You must submit `CreatedAt` and `UpdatedAt` every time you call [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) for each finding\.  
The values must match the ISO8601 format in Python 3\.8\.  

```
datetime.datetime.utcnow().replace(tzinfo=datetime.timezone.utc).isoformat()
```

**`FirstObservedAt` and `LastObservedAt`**  
`FirstObservedAt` and `LastObservedAt` must match when your system observed the finding\. If you do not record this information, you do not need to submit these timestamps\.  
The values match the ISO8601 format in Python 3\.8\.  

```
datetime.datetime.utcnow().replace(tzinfo=datetime.timezone.utc).isoformat()
```

## Severity<a name="asff-severity"></a>

For a new finding, you can provide the following values in the `Severity` object\.

**`Original`**  
The severity value from your system\. `Original` can be any string, to accommodate the system that you use\.

**`Label`**  
The required Security Hub indicator of the finding severity\. The allowed values are as follows\.  
+ `INFORMATIONAL` – No issue was found\.
+ `LOW` – The issue does not require action on its own\.
+ `MEDIUM` – The issue must be addressed but not urgently\.
+ `HIGH` – The issue must be addressed as a priority\.
+ `CRITICAL` – The issue must be remediated immediately to prevent further harm\.
You can set `Label` only when you create a new finding\. For existing findings, only customers can change the value of `Label`\.  
Findings that are compliant should always have `Label` set to `INFORMATIONAL`\. Examples of `INFORMATIONAL` findings are findings from security checks that passed and AWS Firewall Manager findings that are remediated\.  
Customers often sort findings by their severity to give their security operations teams a to\-do list\. Be conservative when setting the finding severity to `HIGH` or `CRITICAL`\.

Your integration documentation must include your mapping rationale\.

## Remediation<a name="asff-remediation"></a>

`Remediation` has two elements\. These elements are combined on the Security Hub console\.

`Remediation.Recommendation.Text` appears in the **Remediation** section of the finding details\. It is hyperlinked to the value of `Remediation.Recommendation.Url`\.

Currently, only findings from Security Hub standards, IAM Access Analyzer, and Firewall Manager display hyperlinks to documentation on how to remediate the finding\.

## SourceUrl<a name="asff-sourceurl"></a>

Only use `SourceUrl` if you can provide a deep\-linked URL to your console for that specific finding\. Otherwise, omit it from the mapping\.

Security Hub does not support hyperlinks from this field, but it is exposed on the Security Hub console\.

## Malware, Network, Process, ThreatIntelIndicators<a name="asff-malware-network-process-threatintel"></a>

Where applicable, use `Malware`, `Network`, `Process`, or `ThreatIntelIndicators`\. Each of these objects is exposed in the Security Hub console\. Use these objects in the context of the finding that you are sending\.

For example, if you detect malware that makes an outbound connection to a known command and control node, provide the details for the EC2 instance in `Resource.Details.AwsEc2Instance`\. Provide the relevant `Malware`, `Network`, and `ThreatIntelIndicator` objects for that EC2 instance\.

### Malware<a name="asff-malware"></a>

`Malware` is a list that accepts up to five arrays of malware information\. Make the malware entries relevant to the resource and the finding\.

Each entry has the following fields\.

**`Name`**  
The name of the malware\. The value is a string of up to 64 characters\.  
`Name` should be from a vetted threat intelligence or researcher source\.

**`Path`**  
The path to the malware\. The value is a string of up to 512 characters\. `Path` should be a Linux or Windows system file path, except in the following cases\.  
+ If you scan objects in an S3 bucket or an EFS share against YARA rules, then `Path` is the S3:// or HTTPS object path\.
+ If you scan files in a Git repository, then `Path` is the Git URL or clone path\.

**`State`**  
The status of the malware\. The allowed values are `OBSERVED` \|` REMOVAL_FAILED` \| `REMOVED`\.  
In the finding title and description, make sure that you provide context for what happened with the malware\.  
For example, if `Malware.State` is `REMOVED`, then the finding title and description should reflect that your product removed the malware that is located on the path\.  
If `Malware.State` is `OBSERVED`, then the finding title and description should reflect that your product encountered this malware located on the path\.

**`Type`**  
Indicates the type of malware\. The allowed values are `ADWARE` \| `BLENDED_THREAT` \| `BOTNET_AGENT` \| `COIN_MINER` \| `EXPLOIT_KIT` \| `KEYLOGGER` \| `MACRO` \| `POTENTIALLY_UNWANTED` \| `SPYWARE` \| `RANSOMWARE` \| `REMOTE_ACCESS` \| `ROOTKIT` \| `TROJAN` \| `VIRUS` \| `WORM`\.  
If you need an additional value for `Type`, contact the Security Hub team\.

### Network<a name="asff-network"></a>

`Network` is a single object\. You cannot add multiple network\-related details\. When mapping the fields, use the following guidelines\.

**Destination and source information**  
The destination and source are easy to map TCP or VPC Flow Logs or WAF logs\. They are more difficult to use when you are describing network information for a finding about an attack\.  
Typically, the source is where the attack originated from, but it could have other sources as listed below\. You should explain the source in your documentation and also describe it in the finding title and description\.  
+ For a DDoS attack on an EC2 instance, the source is the attacker, although a real DDoS attack may use millions of hosts\. The destination is the public IPv4 address of the EC2 instance\. `Direction` is IN\.
+ For malware that is observed communicating from an EC2 instance to a known command and control node, the source is the IPV4 address of the EC2 instance\. The destination is the command and control node\. `Direction` is `OUT`\. You would also provide `Malware` and `ThreatIntelIndicators`\.

**`Protocol`**  
`Protocol` always maps to an Internet Assigned Numbers Authority \(IANA\) registered name, unless you can provide a specific protocol\. You should always use this and provide the port information\.  
`Protocol` is independent from the source and destination information\. Only provide it when it makes sense to do so\.

**`Direction`**  
`Direction` is always relative to the AWS network boundaries\.  
+ `IN` means it is entering AWS \(VPC, service\)\.
+ `OUT` means it is exiting the AWS network boundaries\.

### Process<a name="asff-process"></a>

`Process` is a single object\. You cannot add multiple process\-related details\. When mapping the fields, use the following guidelines\.

**`Name`**  
`Name` should match the name of the executable\. It accepts up to 64 characters\.

****`Path`****  
`Path` is the file system path to the process executable\. It accepts up to 512 characters\.

**`Pid`, `ParentPid`**  
`Pid` and `ParentPid` should match the Linux process identifier \(PID\) or the Windows event ID\. To differentiate, use EC2 Amazon Machine Images \(AMI\) to provide the information\. Customers can probably differentiate between Windows and Linux\.

**Timestamps \(`LaunchedAt` and `TerminatedAt`\)**  
If you cannot reliably retrieve this information, and it is not accurate to the millisecond, do not provide it\.  
If a customer relies on timestamps for forensics investigation, then having no timestamp is better than having the wrong timestamp\.

### ThreatIntelIndicators<a name="asff-threatintelindicators"></a>

`ThreatIntelIndicators` accepts an array of up to five threat intelligence objects\.

For each entry, `Type` is in the context of the specific threat\. The allowed values are `DOMAIN` \| `EMAIL_ADDRESS` \| `HASH_MD5` \| `HASH_SHA1` \| `HASH_SHA256` \| `HASH_SHA512` \| `IPV4_ADDRESS` \| `IPV6_ADDRESS` \| `MUTEX` \| `PROCESS` \| `URL`\.

Here are some examples of how to map threat intelligence indicators:
+ You found a process that you know is associated with Cobalt Strike\. You learned this from FireEye’s blog\.

  Set `Type` to `PROCESS`\. Also create a `Process` object for the process\.
+ Your mail filter found someone sending a well\-known hashed package from a known malicious domain\.

  Create two `ThreatIntelIndicator` objects\. One object is for the `DOMAIN`\. The other is for the `HASH_SHA1`\.
+ You found malware with a Yara rule \(Loki, Fenrir, Awss3VirusScan, BinaryAlert\)\.

  Create two `ThreatIntelIndicator` objects\. One is for the malware\. The other is for the `HASH_SHA1`\.

## Resources<a name="asff-resources"></a>

For `Resources`, use our provided resource types and detail fields whenever possible\. Security Hub is constantly adding new resources to the ASFF\. To receive a monthly log of the changes to ASFF, contact securityhub\-partners@amazon\.com\.

If you cannot fit the information in the details fields for a modeled resource type, map the remaining details to `Details.Other`\.

For a resource that is not modeled in ASFF, set `Type` to `Other`\. For the detailed information, use `Details.Other`\.

You can also use the `Other` resource type for non\-AWS findings\.

## ProductFields<a name="asff-productfields"></a>

Only use `ProductFields` if you cannot use another curated field for `Resources` or a descriptive object such as `ThreatIntelIndicators`, `Network`, or `Malware`\.

If you do use `ProductFields`, you must provide a strict rationale for this decision\.

## Compliance<a name="asff-compliance"></a>

Only use `Compliance` if your findings are related to compliance\.

Security Hub uses `Compliance` for the findings it generates based on controls\.

Firewall Manager uses `Compliance` for its findings because they are compliance\-related\.

## Fields that are restricted<a name="asff-restricted-fields"></a>

These fields are intended for customers to keep track of their investigation of a finding\.

Do not map to these fields or objects\.
+ `Note`
+ `UserDefinedFields`
+ `VerificationState`
+ `Workflow`

If you do map to the following fields, you can only populate these fields when you create a new finding in Security Hub\. You cannot use [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) to change the values of these fields and objects in an existing finding\.
+ `Confidence` – Only include a confidence score \(0\-99\) if your service has a similar functionality, or if you stand 100% by your finding\.

  Security Hub does not expose the confidence score on the Security Hub console\. The confidence score is only stored in the finding\.
+ `Criticality` – The criticality score \(0\-99\) is intended to express the importance of the resource associated with the finding\.

  Security Hub does not expose the criticality score on the Security Hub console\. The criticality score is only stored in the finding\.
+ `RelatedFindings` – Only provide related findings if you can keep track of findings related to the same resource or finding type\. To identify a related finding, you must refer to the finding identifier of a finding that is already in Security Hub\.