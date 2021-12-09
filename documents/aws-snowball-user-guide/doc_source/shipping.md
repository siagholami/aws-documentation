--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Shipping Considerations for AWS Snowball<a name="shipping"></a>

Following, you can find information about how shipping is handled for AWS Snowball, and a list that shows each AWS Region that is supported\. The shipping rate you choose for a job applies to both sending and receiving the Snowball or Snowballs used for that job\. For information on shipping charges, see [AWS Snowball Pricing](http://aws.amazon.com/snowball/pricing)\.

**Topics**
+ [Preparing a Snowball for Shipping](#device-shipping)
+ [Region\-Based Shipping Restrictions](#shipwithinregion)
+ [Shipping an AWS Snowball device](mailing-storage.md)

When you create a job, you specify a shipping address and shipping speed\. This shipping speed doesn’t indicate how soon you can expect to receive the Snowball from the day you created the job\. It only shows the time that the device is in transit between AWS and your shipping address\. That time doesn’t include any time for processing\. Processing time depends on factors including job type \(exports take longer than imports, typically\) and job size \(80\-TB models take longer than 50\-TB models, typically\)\. Also, carriers generally only pick up outgoing Snowballs once a day\. Thus, processing before shipping can take a day or more\.

**Note**  
Snowball devices can only be used to import or export data within the AWS Region where the devices were ordered\.

## Preparing a Snowball for Shipping<a name="device-shipping"></a>

The following explains how to prepare a Snowball appliance and ship it back to AWS\.

**To prepare a Snowball for shipping**

1. Make sure that you've finished transferring all the data for this job to or from the Snowball\.

1. Power off the Snowball by pressing the power button above the digital display\.
**Note**  
If you've powered off and unplugged the Snowball, and your shipping label doesn't appear after about a minute, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.

1. Disconnect and stow the cables the Snowball was sent with\. The back panel of the Snowball has a cable caddie that holds the cables safely during the return trip\.

1. Close the two panels on the back and front of the Snowball, pressing in until you hear and feel them click\.

You don't need to pack the Snowball in a container, because it is its own physically rugged shipping container\. The E Ink display on the front of the Snowball changes to your return shipping label when the Snowball is turned off\.

## Region\-Based Shipping Restrictions<a name="shipwithinregion"></a>

Before you create a job, you should sign in to the console from the AWS Region that your Amazon S3 data is housed in\. A few shipping restrictions apply, as follows:
+ For data transfers in US regions, we don't ship Snowballs outside of the United States\.
+ We don't ship Snowballs between non\-US regions—for example, from EU \(Ireland\) to EU \(Frankfurt\), or from Asia Pacific \(Mumbai\) to Asia Pacific \(Sydney\)\.
+ For data transfers in Asia Pacific \(Sydney\), we only ship Snowballs within Australia\.
+ For data transfers in Asia Pacific \(Mumbai\), we only ship Snowballs within India\.
+ For data transfers in Japan, we only ship Snowballs within Japan\.
+ For data transfers in the EU regions, we only ship Snowballs to EU member countries listed following: Austria, Belgium, Bulgaria, Croatia, Republic of Cyprus, Czech Republic, Denmark, Estonia, Finland, France, Germany, Greece, Hungary, Italy, Ireland, Latvia, Lithuania, Luxembourg, Malta, Netherlands, Poland, Portugal, Romania, Slovakia, Slovenia, Spain, Sweden, and the UK\.
+ For data transfers in the Asia Pacific \(Singapore\) region, we only ship Snowballs to Singapore\.

**Note**  
AWS doesn't ship Snowballs to post office boxes\.