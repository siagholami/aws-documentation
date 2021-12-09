# AWS Resource Groups document history<a name="doc-history"></a>

| Change | Description | Date | 
| --- |--- |--- |
| [Added chapter on security and compliance\.](#doc-history) | Discusses how Resource Groups protects your information and complies with regulatory standards\. | July 30, 2020 | 
| [Added support for resource groups that are configured for AWS services](#doc-history) | You can now create resource groups that are associated with an AWS service and that configure how the service can interact with the resources that are in the group\. In this first release of the feature, you can create a resource group that contains Amazon EC2 capacity reservations and then launch Amazon EC2 instances into the group\. If there's capacity in one or more of the group's reservations that match your instance, then that instance uses the reservation\. If the instance doesn't match any available reservations in the group, then it launches as an on\-demand instance\. For more information, see [Working with capacity reservation groups](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-capacity-reservations.html) in the *Amazon EC2 User Guide for Linux Instances*\.  | July 29, 2020 | 
| [Added support for AWS IoT Greengrass resources\.](#doc-history) | More resource types are now supported by AWS Resource Groups and Tag Editor\. | March 25, 2020 | 
| [View operations data for AWS Resource Groups](#doc-history) | In the AWS Systems Manager console, the AWS Resource Groups page displays operations data for a selected group on four tabs: **Details**, **Config**, **CloudTrail**, **OpsItems**\. These tabs are not available when viewing a group in the Resource Groups console\. You can use the information on these tabs to help you understand which resources in a group are compliant and working correctly and which resources require action\. If you need to take action on a resource, you can use Systems Manager Automation runbooks to perform common operations maintenance and troubleshooting tasks\. For more information, see [Viewing operations data for AWS Resource Groups](https://docs.aws.amazon.com/systems-manager/latest/userguideviewing-operations-data.html) in the *AWS Systems Manager User Guide*\. | March 16, 2020 | 
| [Check for compliance with tag policies](#doc-history) | After you create and attach tag policies to accounts using AWS Organizations, you can find noncompliant tags on resources in your organization's accounts\.  | November 26, 2019 | 
| [Support for more resource types](#doc-history) | More resource types are now supported by AWS Resource Groups and Tag Editor\. | October 4, 2019 | 
| [New resource types supported by AWS Resource Groups](#doc-history) | More resource types are now supported by AWS Resource Groups, especially for groups based on an AWS CloudFormation stack\. | August 5, 2019 | 
| [New resource types supported by AWS Resource Groups](#doc-history) | AWS API Gateway REST APIs, AWS CloudWatch Events events, and Amazon SNS topics are now supported resource types in AWS Resource Groups\. | June 27, 2019 | 
| [Tag Editor now supports finding untagged resources](#doc-history) | You can now search for resources in Tag Editor that do not have tag values applied for a specific tag key\. | June 18, 2019 | 
| [New resource types supported by AWS Resource Groups and Tag Editor](#doc-history) | Over 50 new resource types have been added to AWS Resource Groups and Tag Editor support\. | June 6, 2019 | 
| [AWS Resource Groups and Tag Editor console moves out of AWS Systems Manager console](#doc-history) | The AWS Resource Groups and Tag Editor console is now independent from the AWS Systems Manager console\. Although you can still find pointers to the AWS Resource Groups console in the Systems Manager left navigation bar, you can open the Resource Groups and Tag Editor console directly from the drop\-down menu at the upper left of the AWS management console\. | June 5, 2019 | 
| [New Resource Groups authorization and access control features](#doc-history) | Resource Groups now supports action\-based policies, resource\-level permissions, and authorization based on tags\. | May 24, 2019 | 
| [Older, legacy Resource Groups and Tag Editor tools are no longer available](#doc-history) | Mentions of older, classic, or legacy Resource Groups and Tag Editor have been removed; these tools are no longer available in AWS\. Use AWS Resource Groups and Tag Editor instead\. | May 14, 2019 | 
| [Tag Editor now supports tagging resources across multiple regions](#doc-history) | Tag Editor now lets you search for and manage tags of resources across multiple regions, with your current region added to resource queries by default\. | May 2, 2019 | 
| [Tag Editor now supports exporting query results to a CSV](#doc-history) | You can export the results of a query on the **Find Resources to tag** page to a CSV\-formatted file\. A new Region column is shown in Tag Editor query results\. Tag Editor now lets you search for resources that have empty values for a specific tag key\. Tag key values auto\-complete as you type a unique value among existing keys\. | April 2, 2019 | 
| [Tag Editor now supports adding all resource types to a query](#doc-history) | You can apply tags to up to 20 individual resource types in a single operation, or you can choose **All resource types** to query all resource types in a region\. Autocompletion has been added to the **Tag key** field of a query to help enable consistent tag keys among resources\. If tag changes fail on some resources, you can retry tag changes on just resources for which tag changes failed\. | March 19, 2019 | 
| [Tag Editor now supports multiple resource types in a search](#doc-history) | You can apply tags to up to 20 resource types in a single operation\. You can also choose the columns that are shown to you in search results, including columns for each unique tag key found in your search results or selected resources from results\. | February 26, 2019 | 
| [Documentation added for new Tag Editor](#doc-history) | The "Working with Tag Editor" section describes how to use the new AWS Tag Editor console experience\. | February 13, 2019 | 
| [New resource types supported for groups in Resource Groups](#doc-history) | Added new resource types that are now supported in Resource Groups\. | February 4, 2019 | 
| [Improved user experience for adding tags to tag\-based Resource Groups queries](#doc-history) | Minor changes to the console user experience for addition of tags in a tag\-based query\. | December 17, 2018 | 
| [AWS CloudFormation stack\-based query support added to Resource Groups](#doc-history) | You can create resource groups where the query is based on an AWS CloudFormation stack\. After you choose a stack, you can choose which resource types from the stack you want to appear in your group's query\. | November 13, 2018 | 
| [Resource Groups and CloudTrail](#doc-history) | Resource Groups now offers AWS CloudTrail support\. You can view and work with logs of all Resource Groups API calls in CloudTrail\. | June 29, 2018 | 
+ **API version:** 2017\-11\-27
+ **Latest documentation update:** September 24, 2019

## Earlier updates<a name="history-older"></a>

The following table describes important changes in each release of the *AWS Resource Groups User Guide* before June 2018\.


****  

| Change | Description | Date | 
| --- | --- | --- | 
| Initial release | Initial release of the next generation of AWS Resource Groups | November 29, 2017 | 