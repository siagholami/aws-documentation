# Subscription Verification for Providers<a name="subscription-verification-pro"></a>

As a provider, you have the option to enable subscription verification for your data product\. When enabled, potential subscribers must complete a form about who they are and what they intend to do with the data before they can subscribe\. You must review and approve each request from prospective subscribers\.

Approving subscription requests to your product can be useful when you have restricted or regulated products, or you have products that you want to limit access to\.

The form requires the following information:
+ Prospective subscriber's contact details, including contact name, company name, and email address\.
+ Prospective subscriber's intended use\-case\.
+ Prospective subscriber's AWS account ID\.

**Important**  
The subscriber must enter information in each field, but AWS Data Exchange doesn't review or validate the information\. You're solely responsible for reviewing and verifying the information the subscriber provides\.

After you receive the subscription request, you have 45 days to approve or reject it\. If you don't approve the request in that period of time, the request expires\. Potential subscribers can resubmit a rejected request at any time, any number of times\.

**Important**  
The subscriber information you collect through subscription verification must be used in accordance with AWS Marketplace Terms and Conditions\.

If you change the product offer terms after a subscriber makes the request, the terms for that subscriber reflect the terms as they were at the time of the request, not the updated terms\. Examples of changes to terms include the price, refund policy, or data subscription agreement\. If you changed the product offer terms after the request was submitted, a message is displayed in the approval pane of the AWS Data Exchange console to indicate there is a difference between current terms and the terms in place when the request was made\. 

The AWS Data Exchange console maintains a history of requests\. You control when you delete the subscriber’s contact details and personally identifiable information \(PII\)\.

 You can view all subscription verification requests for all of your products on the **Subscription Verification** tab of the **Products dashboard**\. 

**Note**  
Each subscription request is uniquely identified using its ID\. The ID is visible to both the provider and the subscriber\. You can use the subscription request ID in your communications with the subscriber\.

## Email Notifications<a name="email-notifications-pro"></a>

You will receive an email notification to your AWS account's email address when a request is received, or when its status has changed to cancelled or expired\. Although most subscription request status changes result in an email notification, the delivery of these emails is on a best\-effort basis\.

**Note**  
You will not receive email notifications for subscription request status changes that you have initiated yourself \(for example, when you approve a subscription\)\.