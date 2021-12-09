# Tagging resources<a name="amazon-mq-tagging"></a>

Amazon MQ supports resource tagging to help track your cost allocation\. You can tag resources when creating them, or by viewing the details of that resource\.

**Topics**
+ [Tagging for Cost Allocation](#tagging-cost)
+ [Managing Tags in the Amazon MQ Console](#tagging-manage-console)
+ [Managing Using Amazon MQ API Actions](#tagging-manage-api)

## Tagging for Cost Allocation<a name="tagging-cost"></a>

To organize and identify your Amazon MQ resources for cost allocation, you can add metadata *tags* that identify the purpose of a broker or configuration\. This is especially useful when you have many brokers\. You can use cost allocation tags to organize your AWS bill to reflect your own cost structure\. To do this, sign up to get your AWS account bill to include the tag keys and values\. For more information, see [Setting Up a Monthly Cost Allocation Report](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/configurecostallocreport.html#allocation-report) in the *AWS Billing and Cost Management User Guide*\.

For instance, you could add tags that represent the cost center and purpose of your Amazon MQ resources:


****  
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/amazon-mq-tagging.html)

This tagging scheme allows you to group two brokers performing related tasks in the same cost center, while tagging an unrelated broker with a different cost allocation tag\.

## Managing Tags in the Amazon MQ Console<a name="tagging-manage-console"></a>

### Adding Tags to New Resources<a name="tagging-add-create"></a>

Amazon MQ lets you to add tags to resources as they are created\. You can quickly add tags to the resources you are creating in the Amazon MQ console\. 

 To add tags as you create a new broker:

1. From the **Create a broker** page, select **Additional settings**\.

1. Under **Tags**, select **Add tag**\.

1. Enter a **Key** and **Value** pair\.  
![\[Add tags when creating resources\]](http://docs.aws.amazon.com/amazon-mq/latest/developer-guide/images/amazon-mq-create-tag.png)

1. \(Optional\) Select **Add tag** to add multiple tags to your broker\.

1. Select **Create broker**\.

To add tags as you create a configuration:

1. From the **Create configuration** page, select **Advanced**\.

1. Under **Tags** on the **Create configuration** page, select **Add tag**\.

1. Enter a **Key** and **Value** pair\.

1. \(Optional\) Select **Add tag** to add multiple tags to your configuration\.

1. Select **Create configuration**\.

### Viewing and Managing Tags for Existing Resources<a name="tagging-manage-existing"></a>

Amazon MQ allows you to view and manage the tags for your resources in the Amazon MQ console\. You can manage tags for an individual resource by editing the tags on the details page for that resource\. To edit tags on Amazon MQ resources:

1. Select either **Brokers** or **Configurations** in the Amazon MQ console\.

   Under the **Tags** section, review the existing tags for that resource\.

1. To add new or manage existing tags, select **Edit** \(or **Create tag** if have no existing tags\)\.

1. Update tags for your resource:
   + To modify existing tags, edit the **Key** and **Value**\.
   + To remove existing tags, select **Remove**\.
   + To add a new tag, select **Add tag** and enter a **Key** and **Value**\.

1. Select **Save**\.

## Managing Using Amazon MQ API Actions<a name="tagging-manage-api"></a>

Amazon MQ allows you to view and manage the tags of your resources using the REST API\. 

 For more information, see the [Amazon MQ REST API Reference](https://docs.aws.amazon.com/amazon-mq/latest/api-reference/rest-api-tag.html)\.