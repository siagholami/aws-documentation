# Evaluating organization\-wide compliance<a name="tag-policies-arg-evaluating-org-wide-compliance"></a>

You can generate a report that lists all tagged resources in accounts across your organization and whether each resource is compliant with the effective tag policy\.

**Important**  
Untagged resources don't appear as noncompliant in results\. 

You can generate the report from your organization's master account account in the `us-east-1` Region only, and it must have access to an Amazon S3 bucket in the US East \(N\. Virginia\) Region\. The bucket must have an attached bucket policy as shown in [Amazon S3 Bucket Policy for Storing Report](tag-policies-prereqs.md#bucket-policy)\. 

To generate an organization\-wide compliance report, you must have the following permissions:
+ `organizations:DescribeEffectivePolicy`
+ `tag:StartReportCreation`
+ `tag:DescribeReportCreation`
+ `tag:GetComplianceSummary`

**To generate an organization\-wide compliance report \(console\)**

1. In the AWS Resource Groups navigation pane, choose **Tagging** and then **Tag policies**\.

1. From the **Tag policies** pane, choose the **Organization root** tab\.

1. Near the bottom of the page, choose **Generate report**\.

1. On the **Generate report** screen, specify where to store the report\. 

1. Choose **Start exporting**\.

When the report is complete, you can download it from the **Noncompliance report** section on the **Organization root** tab\. 

The following shows an example report excerpt:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/tag-policy-summary-report.PNG)

**Notes**  
Organization\-wide compliance is evaluated every 48 hours\. This results in the following:  
It can take up to 48 hours for changes to a tag policy or resources to be reflected in the organization\-wide compliance report\. For example, assume that you have a tag policy that defines a new standardized tag for a resource type\. Resources of that type that don't have this tag are shown as compliant in the report for up to 48 hours\.
Although you can generate the report at any time, report results aren't updated until the next evaluation is complete\.
The **NoncompliantKeys** column lists tag keys on the resource that are noncompliant with the effective tag policy\.
The **KeysWithNonCompliantValues** column lists keys defined in the effective policy that are on the resource with either incorrect case treatment or noncompliant values\. 

**To generate an organization\-wide compliance report \(AWS CLI, AWS API\)**  
Use the following commands and operations to generate an organization\-wide compliance report, check on its status, and view the report:
+ AWS CLI:
  + [aws resourcegroupstaggingapi start\-report\-creation](https://docs.aws.amazon.com/cli/latest/reference/resourcegroupstaggingapi/start-report-creation.html)
  + [aws resourcegroupstaggingapi describe\-report\-creation](https://docs.aws.amazon.com/cli/latest/reference/resourcegroupstaggingapi/describe-report-creation.html)
  + [aws resourcegroupstaggingapi get\-compliance\-summary](https://docs.aws.amazon.com/cli/latest/reference/resourcegroupstaggingapi/get-compliance-summary.html)

  For the complete procedure for using tag policies in the AWS CLI, see [Using tag policies in the AWS CLI](https://docs.aws.amazon.com/organizations/latest/userguide/tag-policy-cli.html) in the *AWS Organizations User Guide*\.
+ AWS API:
  + [StartReportCreation](https://docs.aws.amazon.com/resourcegroupstagging/latest/APIReference/API_StartReportCreation.html)
  + [DescribeReportCreation](https://docs.aws.amazon.com/resourcegroupstagging/latest/APIReference/API_DescribeReportCreation.html)
  + [GetComplianceSummary](https://docs.aws.amazon.com/resourcegroupstagging/latest/APIReference/API_GetComplianceSummary.html)