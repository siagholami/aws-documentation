# AWS Application Discovery Service Limits<a name="ads_service_limits"></a>

Application Discovery Service has the following limits per account:
+ **Applications** – 1,000 applications per account\. If you reach this limit, and want to import new applications, you can delete existing applications with the `DeleteApplications` API action\. For more information, see [DeleteApplications](https://docs.aws.amazon.com/application-discovery/latest/APIReference/API_DeleteApplications.html) in the *Application Discovery Service API Reference*\.

Application Discovery Service has the following limits for discovery:
+ **Import** – Each import file can have a maximum file size of 10 MB\.
+ **Agentless discovery** – The service limits you to 10 GB of data per day\. If you reach this limit, the service doesn't process any more data for that day\. If you frequently reach this limit, contact [AWS Support](https://aws.amazon.com/premiumsupport/) about extending the limit\. 
+ **Agent\-based discovery** – currently, the following limits are enforced:
  + 1,000 active agents — agents that are collecting and sending data to Application Discovery Service in the cloud\.
  + 10,000 inactive agents — agents that are responsive but not collecting data\.
  + 10 GB of data per day — collected by all agents associated with a given AWS account\.
  + 90 days of data storage — after which the data is purged\.

## Limits That Can Be Increased<a name="soft-limits"></a>

Following are the limits for Application Discovery Service that can be increased by contacting AWS Support\.

### Import Limits<a name="import-limits"></a>
+ 25,000 imported records per account\.
+ 5,000 imported servers per account\.
+ 25,000 deletions of import records per 24 hour period, starting every day at 00:00 UTC\.
+ 400 servers per application\.

You can take the following steps to request an increase for these limits\. These increases are not granted immediately, so it may take a couple of days for your increase to become effective\.

**To request a limit increase**

1. Open the [AWS Support Center](https://console.aws.amazon.com/support/home#/) page, sign in, if necessary, and then choose **Create Case**\.

1. Under **Regarding**, choose **Service Limit Increase**\.

1. Under **Limit Type**, choose the type of limit to increase, fill in the necessary fields in the form, and then choose your preferred method of contact\.