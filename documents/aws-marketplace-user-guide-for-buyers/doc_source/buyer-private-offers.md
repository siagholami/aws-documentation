# Private offers<a name="buyer-private-offers"></a>

 The AWS Marketplace seller private offer feature enables you to receive product pricing from a seller that isn't publicly available\. You negotiate pricing and terms with the seller, and the seller creates a private offer for the AWS account that you designate\. You accept the private offer and start receiving the negotiated price and terms of use\. 

Each private offer has pricing and licensing terms specifically offered to your account\. The seller of the product extends a private offer to you, and the offer has a set expiration date\. If you don't accept the private offer by the expiration date, depending on the type of product the private offer is for, you're either automatically moved to the product's public offer or no longer subscribed to the product\. 

If you're using the consolidated billing feature in AWS Organizations, you can accept the private offer from either the organization's master account or from a member account\. If you accept from the master account, the private offer is shared to all member accounts in the organization\. Member accounts that were previously subscribed to the product automatically accept the private offer's pricing\. Member accounts that weren't previously subscribed to the product must accept the private offer to be able to deploy the product\.

For more information on consolidated billing, see [Consolidated Billing for Organizations](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/consolidated-billing.html) in the *AWS Billing and Cost Management User Guide*\. The following are key points to remember as you start using your private offers\.
+ AWS Marketplace buyers can access third\-party financing services for private offers\. For more information, see [Customer financing is now available in AWS Marketplace](https://s3.us-west-2.amazonaws.com/external-mp-channel-partners/Financing+External+Briefing+Document+Customer+Facing.pdf)\.
+ There is no difference in the software product you purchase using a private offer\. The software that you purchase using a private offer behaves the same as it would if you purchased the software without a private offer\.
+ Products subscriptions you purchase with a private offer show up like any other AWS Marketplace product in your monthly bill\. You can use detailed billing to view your usage for each of your AWS Marketplace\-purchased products\. Each of your private offers has a line item corresponding to each kind of usage\.
+ Subscribing to a private offer doesn't require launching a new instance of the software\. Accepting the private offer modifies the price to correspond to your private offer price\. If a product offers 1\-click launch, you can deploy a new instance of the software\. If a product defaults to 1\-click launch, you can accept a private offer without launching a new instance\. To launch without deploying a new instance, choose **Manual Launch** on the fulfillment page\. You can use the Amazon Elastic Compute Cloud console to deploy additional instances, just as you would for other AWS Marketplace products\.
+ When a seller extends a private offer to you, you receive confirmation on the account the seller included in a private offer\. Private offers are linked to the specific software buyer's account listed\. The software seller creates the private offer for the account that you specify\. Each private offer can be made to up to 25 accounts\. 
+ When you accept a private offer, it becomes an *agreement* \(also known as *contract* or *subscription*\) between you and the seller\. 
+ Sellers may offer to upgrade or renew your purchase of an SaaS contract or SaaS contract with consumption product\. For example, a seller can create a new private offer to grant new entitlements, offer pricing discounts, adjust payment schedules, or change the end user license agreement \(EULA\) to use [standardized license terms](https://docs.aws.amazon.com/marketplace/latest/userguide/standardized-license-terms.html)\.

  These renewals or upgrades are changes to the original private offer that you accepted, and you use the same process for accepting them\. If you accept the new upgrade or renewal private offer, the new agreement terms take effect immediately, without any break in software service\. Any previous terms or remaining scheduled payments are cancelled and replaced by this new agreement's terms\.
+  You can review all of your annual software subscriptions in AWS Marketplace under **Your Software**\. If an annual subscription is purchased by one account using AWS Organizations for consolidated billing, it is shared across the entire linked account family\. If the purchasing account doesn't have any running instances, the annual subscription is counted toward the usage in another linked account running that software\. For more information about annual subscriptions, see [AMI subscriptions](buyer-ami-subscriptions.md)\.
+  When a private offer expires, you can't subscribe to it\. However, you can contact the seller and ask them to create a new private offer for you\. The seller also has the option of authorizing AWS Marketplace to extend the offer\. If you're interested in trying to get the expiration date extended, contact mpcustdesk@amazon\.com\. 

## Product types eligible for private offers<a name="buyer-private-offers-types"></a>

You can get private offers for the following product types\.


| Offer type | Description | 
| --- | --- | 
| Data products | For more information, see [Accepting a Private Offer](https://docs.aws.amazon.com/data-exchange/latest/userguide/subscribe-to-private-offer.html) in the *AWS Data Exchange User Guide*\. | 
|  SaaS contract  |  With a software as a service \(SaaS\) contract, you can commit to upfront payment for your expected usage of a SaaS product, or negotiate a flexible payment schedule with the seller\. Contract durations are one\-month, one\-year, two\-year, or three\-year terms\. If you commit to an upfront payment, you are billed in advance for the use of the product software\. If the seller offers a flexible payment schedule, you are billed along the payment schedule dates at the amounts listed on the private offer\.  | 
|  SaaS contract with a flexible payment schedule  |  Same as a SaaS contract, but with a custom payment schedule where payments can be spread over up to three years\.  | 
|  SaaS contract with pay\-as\-you\-go pricing for additional usage  |  Same as a SaaS contract, but with negotiated pricing for usage beyond what you negotiated in your contract\.  | 
|  SaaS subscription  |  With a SaaS subscription, you agree to a price for use of a product\. The seller tracks and reports your usage to AWS Marketplace, and you're billed for what you use\.   | 
|  AMI hourly  |  With Amazon Machine Image \(AMI\) hourly, you negotiate an hourly rate for using an AMI, rounded up to the nearest hour\.   | 
|  AMI annual  |  With AMI annual, you negotiate the hourly and total contract duration prices with upfront payment, or flexible payment schedule over any custom contract duration of up to three years, and specified number of licenses for the AMI\. If you commit to an upfront payment, you are billed in advance for the use of the AMI\. If the ISV offers a flexible payment schedule, you are billed along the payment schedule dates at the amounts listed on the private offer\.  | 

## Preparing to accept a private offer<a name="buyer-private-offers-prerequsite-steps"></a>

When a typical private offer is negotiated, you pay the entire amount of the offer when you accept it, unless you are using third\-party financing\. With third\-party financing, the financier pays the contract on your behalf and invoices you based on the agreed payment schedule\. Before you accept a private offer, verify the billing structure for your company, your method of payment for AWS billing, and your tax settings\.

### Verifying your AWS Billing and Cost Management preferences<a name="buyer-private-offers-prerequsite-steps-billing"></a>

Billing and Cost Management is the service that you use to pay your AWS bill, monitor your usage, and budget your costs\. You can use the consolidated billing feature in AWS Organizations to consolidate billing and payment for multiple accounts or multiple Amazon Internet Services Pvt\. Ltd \(AISPL\) accounts\. Every organization in AWS Organizations has a master account that pays the charges of all the member accounts\. The master account is called a payer account, and the member account is called a linked account\. Before negotiating a private offer, verify how your company pays their AWS bill and which AWS account the private offer is made to\. 

### Verifying your payment method<a name="buyer-private-offers-prerequsite-steps-payment-method"></a>

Before accepting a private offer, verify that your payment method supports paying the entire cost of the private offer\. To verify your payment method, open the Billing and Cost Management console at [https://console\.aws\.amazon\.com/billing/](https://console.aws.amazon.com/billing/)\.

**Note**  
If the private offer is a SaaS or AMI contract with a flexible payment schedule, you must have invoicing in place before you accept the offer\.

### Verifying your tax settings<a name="buyer-private-offers-prerequsite-steps-tax-settings"></a>

If your company qualifies for a tax exemption, verify your tax settings\. To view or modify your tax settings, sign in to the AWS Management Console and, in your account settings, view the tax settings\. For more information on tax registration, see [How do I add or update my tax registration number or business legal address for my AWS account?](https://aws.amazon.com/premiumsupport/knowledge-center/update-tax-registration-number/)\.

## Viewing and subscribing to a private offer<a name="buyer-private-offers-subscribing"></a>

With all private offers, you view and accept the offer by logging in to AWS Marketplace and navigating to the offer page for the product\. To view the offer page, you can either:
+ **Use the link the seller provided** – The seller might have sent you a link that takes you directly to the private offer\. If so, use that link to directly access the private offer\.
+ **Navigate to the product page** – Sign in to [AWS Marketplace](https://aws.amazon.com/marketplace) and navigate to the product page for the product\. During the subscription process, you see a banner at the top of the page showing the private offer, offer ID, and expiration for the offer\. If you have more than one private offer for that product, each offer appears under **Offer name**\.