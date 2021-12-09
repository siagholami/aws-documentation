# Getting Started with Amazon Pinpoint<a name="gettingstarted"></a>

To start sending targeted messages in Amazon Pinpoint, you have to complete a few steps\. For example, you have to add customer contact information into Amazon Pinpoint, and then create segments that target certain customers\. Next, you have to create your messages and schedule your campaigns\. Finally, after you send your campaigns, you can use the analytics dashboards that are built into Amazon Pinpoint to see how well the campaigns performed\.

This tutorial includes procedures for all of the steps that are involved in sending an email campaign to a segment of customers by using the Amazon Pinpoint console\.

## About This Tutorial<a name="gettingstarted-about-this-tutorial"></a>

This section contains an overview of this tutorial\.

**Intended Audience**  
This tutorial is designed for marketing and business users\.

If you're a software developer or system administrator, you might also find the [tutorials](https://docs.aws.amazon.com/pinpoint/latest/developerguide/tutorials.html) in the *Amazon Pinpoint Developer Guide* to be useful\.

**Features Used**  
This tutorial shows you how to complete all of the following steps by using the Amazon Pinpoint console:
+ Importing customer data from a file\.
+ Creating a segment that targets specific users based on their attributes\.
+ Creating an email campaign and scheduling it to be sent at a specific time\.
+ Viewing email delivery and response data by using the analytics dashboards that are built into Amazon Pinpoint\.

**Time Required**  
It should take about 30–45 minutes to complete this tutorial\.

**Regional Restrictions**  
There are no regional restrictions associated with using this solution\.

**Resource Usage Costs**  
There's no charge for creating an AWS account\. However, by implementing this solution, you might incur some or all of the costs that are listed in the following table\.


| Description | Cost \(US Dollars\) | 
| --- | --- | 
| Message sending costs | You pay $0\.0001 for each email that you send through Amazon Pinpoint\. | 
| Monthly targeted audience costs | You pay $0 for the first 5,000 endpoints that you target in Amazon Pinpoint each month\. \(An endpoint is a destination that you can send messages to, such as a user's email address or mobile phone number\.\) After that, you pay $0\.0012 per endpoint that you target\. | 

If you use this tutorial to send 5 messages to 5 separate endpoints in one month, you incur charges of $0\.0005\.

For detailed information about the costs that you might incur using Amazon Pinpoint, see [Amazon Pinpoint Pricing](https://aws.amazon.com/pinpoint/pricing/)\.

**Next:** [Create and Configure a Project](gettingstarted-create-project.md)