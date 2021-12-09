# Creating an Offer for AWS Data Exchange Products<a name="prepare-offers"></a>

To make a product available, you must create an offer in the AWS Data Exchange console\. Oﬀers deﬁne the terms that subscribers are agreeing to when they subscribe to a product\. Each product must have a public oﬀer available to all subscribers\. You can also create custom oﬀers for selected subscribers\. When you create an offer for your product, you define:
+ The data subscription agreement, which defines the terms that a prospective subscriber must agree to before purchasing a subscription for your product\.
+ Available pricing and duration combinations\.
+ Whether US sales tax is collected\.
+ The Terms and Conditions for the refund policy, if any\.
+ Whether the subscriber must fill out a questionnaire to request a subscription using subscription verification\.

You can also create custom offers that you extend to a select AWS account\. The custom offer makes it possible for you to set specific terms and pricing for your product\. For more information, see [Creating Custom Offers](create-custom-offers.md)\.

## Offer Pricing<a name="offer-pricing"></a>

When you define the pricing information, you define the total price and duration of the subscription\. Durations are 1 to 36 months\. You can specify up to 5 different durations in a single offer\.

We recommend that you choose durations that you plan to support for the long run\. If you discontinue a duration, AWS cancels the subscription renewal for those affected subscribers who opted into an auto\-renewal policy\.

The only supported currency for pricing is US dollars \(USD\)\. You must specify a price for each duration\. For example, you can specify different prices for durations of 1 month, 6 months, 12 months, 24 months, and 36 months in a single offer\. All options are available to prospective subscribers\. They must choose a single price and duration when they subscribe to your offer, and they must agree to your offer terms and pay upfront for the purchase charges\.

## US Sales and Use Tax<a name="offer-pricing-us-sales-tax"></a>

You can enable US sales tax collection for the offer, based on your tax nexus settings\. For more information, see [U\.S\. Sales and Use Tax](provider-financials.md#taxation)\.

## Data Subscription Agreement<a name="offer-data-subscription-agreement"></a>

The data subscription agreement \(DSA\) describes the Terms and Conditions for the data product\. As a provider, you control the legal terms and usage rights\. These terms are part of each offer you create for your product\.

AWS Data Exchange provides a default DSA template\. You can download the default DSA template and edit it to add your own Terms and Conditions\. Or, you can specify your own custom terms by uploading the DSA of your choice\. AWS Data Exchange associates the DSA that you specify for the product's offer without any further modiﬁcations\.

## Refund Policy<a name="offer-refund-policy"></a>

As a provider, you control the refund policy for your product's subscribers\. Although AWS Data Exchange doesn't require you to offer refunds, you must clearly specify your refund policy in the offer details\. We encourage you to provide these details in a clear and concise manner so that subscribers can contact you in case of any questions or requests\. AWS can process refunds that you authorize on your behalf, but as the provider, you must authorize the refunds\.

For AWS to process authorized refunds, [submit a refund approval form](http://aws.amazon.com/marketplace/management/support/refund-request?#) to AWS Support through the AWS Marketplace Management Portal\. Your refund request is processed and the refund is issued to the subscriber\. You can view all refunds that AWS processed on your behalf in the monthly billed revenue report\.

## Subscription Verification<a name="offer-subscription-verification"></a>

As a provider, you have the option to enable subscription veriﬁcation for your data products on AWS Data Exchange\. For more information, see [Subscription Verification for Providers](subscription-verification-pro.md)\.