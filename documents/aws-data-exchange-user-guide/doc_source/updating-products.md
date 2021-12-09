# Updating Products<a name="updating-products"></a>

These sections describe how to update your products\. The instructions are written with the assumption you're a provider who's familiar with [Working with Data Sets](data-sets.md)\. After you publish a product, you can edit the product's details and its public offer\. You can also update the underlying data sets by publishing new revisions to subscribers\.

## Update Product and Offer Details<a name="update-product-details"></a>

After you publish a product, you can use the AWS Data Exchange console to edit the product details\. You can also edit the product's public or custom offers and change the offer terms\. When you update your product's offer terms, subscribers with an active subscription keep their existing offer terms as long as their subscription is active\. Subscribers who have chosen auto\-renewals use the new offer terms\.

Keep the following in mind when you update products:
+ You can't remove or edit a subscription duration in your offers\. This ensures that existing subscribers retain the ability to renew\. If you no longer want to offer a specific subscription duration, you can un\-publish your existing product and then publish a new product\. For more information, see [Unpublish a Product](providing-data-sets.md#unpublish-product)\.
+ You can't remove data sets from a product after it is published, regardless of how many subscribers have subscribed to your product\.

## Publish New Data to Products<a name="dynamically-updated-products"></a>

AWS Data Exchange supports dynamically updated products\. Subscribers subscribe to the product for a certain duration and access all of the published data sets and revisions as long as their subscription is active\. For example, a provider might want to provide a product that contains daily closing stock prices for U\.S equities, which would be updated every day with the day’s closing prices\. You can dynamically publish additional revisions to your product’s data sets, or add new data sets to your product\. 

You can use the AWS Data Exchange console or the AWS Marketplace Catalog API to update your products\. For more information, see [Using AWS Data Exchange with the AWS Marketplace Catalog API](appendices.md)\.

**Important**  
Any revision published to a product is immutable and can't be edited, changed, or deleted\. If you need to remove published content for compliance reasons, contact [AWS Support](http://aws.amazon.com/premiumsupport)\.

### Suggested Approach for Historical Data<a name="historical-data-approach"></a>

Some dynamic products contain historical content that subscribers can access\. For example, if your product includes a 30\-year history of daily closing stock price for U\.S\. equities, subscribers would get access to that data in addition to the dynamic updates every day\.

For these kind of products that contain a historical record of data, a best practice is to publish all historical data in a single revision of the data set\. You can use the optional comment for the revision to indicate that this revision is a single upload of all data history from a specific date\. 

If the single historical revision contains a time series of multiple objects, you might consider labeling your object names to describe the underlying data periodicity\. For example, if your single revision of history contains 200 files each with a week of historical data, you can name each file with a date for the week the data history begins\.

### Suggested Approaches for Updates<a name="update-approach"></a>

You can dynamically update your data sets in a number of ways\. Here are three example approaches, all of which create a new revision for each update, but the content of the new revision is different\.
+ **Use a new revision for each update that contains only the items that have changed since the last revision\.** – Your revision size would be smaller because only those items that have changed are updated\. This approach is suitable for data sets for which the updates affect only a small subset of the data and subscribers are focused only on the items that have changed\.
+ **Use a new revision for each update that contains the updated data\.** – The new revision contains a full updated file\. All items are included in the new revision, including those that have not changed since the last revision\. This approach is convenient for subscribers who want to maintain a single up\-to\-date file for your data\. Subscribers export the latest revision's asset or assets to the same destination and override the previous file or files\.
+ **Use a new revision for each update that contains the full history and updated data\.** – The new revision contains the full history of the data, including the latest state of the data and the history of the previous revisions\. This approach is more storage\-heavy and is suitable for data sets for which subscribers are interested in the latest comprehensive view of the data's history, including any potential past corrections or adjustments\. In this approach, each revision is self\-suﬃcient and provides a full view of the data set history with no dependency on previous revisions\.