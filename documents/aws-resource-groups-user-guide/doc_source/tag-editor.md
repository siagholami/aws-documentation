# Tag Editor<a name="tag-editor"></a>

Tags are words or phrases that act as metadata that you can use to identify and organize your AWS resources\. A resource can have up to 50 user\-applied tags\. It can also have read\-only system tags\. Each tag consists of a key and one optional value\. For more information, see [AWS tagging strategies](http://aws.amazon.com/answers/account-management/aws-tagging-strategies/) in *AWS Answers*, and [Using cost allocation tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html#allocation-what) in the *AWS Billing and Cost Management User Guide*\.

**Important**  
Do not store personally identifiable information \(PII\) or other confidential or sensitive information in tags\. We use tags to provide you with billing and administration services\. Tags are not intended to be used for private or sensitive data\.

You can add tags to resources when you create the resource\. You can use the resource's service console or API to add, change, or remove those tags one resource at a time\. To add tags to—or edit or delete tags of—multiple resources at once, use Tag Editor\. With Tag Editor, you search for the resources that you want to tag, and then manage tags for the resources in your search results\.

**To start Tag Editor**

1. Sign in to the [AWS Management Console](https://console.aws.amazon.com/console/home)\.

1. On the navigation bar, choose **Resource Groups**, and then choose **Tag Editor**\.

Not all resources can have tags applied\. For information about which resources Tag Editor supports, see [Resources you can use with AWS Resource Groups](supported-resources.md)\. If a resource type that you want to tag is not supported, be sure to let AWS know by choosing the **Feedback** tool in the lower left corner of the console window\.

For information about permissions and roles that are required to tag resources, see [Set up permissions](gettingstarted-prereqs.md#gettingstarted-prereqs-permissions)\.

**Topics**
+ [Find resources to tag](find-resources-to-tag.md)
+ [Manage tags](tagging-resources.md)
+ [Troubleshooting tag changes](troubleshooting-tags.md)