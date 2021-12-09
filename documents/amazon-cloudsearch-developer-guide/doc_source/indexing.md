# Indexing Document Data with Amazon CloudSearch<a name="indexing"></a>

When you send document updates to your domain, Amazon CloudSearch automatically updates the domain's search index with the new data\. You don't have to do anything for the updates to be indexed\. However, if you change the configuration of your domain's index fields or text options, you must explicitly rebuild your search index for those changes to be visible in search results\. Because rebuilding the index can take a significant amount of time if you have a lot of data, you should finish making all of your configuration changes before re\-indexing your documents\.

**Important**  
If you change the type of a field and have documents in your index that contain data that is incompatible with the new field type, all fields being processed are put in the `FailedToValidate` state when you run indexing and the indexing operation fails\. Rolling back the incompatible configuration change will enable you to successfully rebuild your index\. If the change is necessary, you must update or remove the incompatible documents from your index to use the new configuration\.

When you make changes that require re\-indexing, the domain status changes to NEEDS INDEXING\. While the index is being rebuilt, the domain's status is PROCESSING\. You can continue to submit search requests while indexing is in process, but the configuration changes won't be visible in search results until indexing completes and the domain's status changes to ACTIVE\. You can also continue to upload document batches to your domain\. However, if you submit a large volume of updates while your domain is in the PROCESSING state, it can increase the amount of time it takes for the updates to be applied to your search index\. If this becomes an issue, slow your update rate until the domain returns to the ACTIVE state\.

**Note**  
Depending on the volume of data, building a full index can take a considerable amount of compute power\. Amazon CloudSearch automatically manages the resources needed to build the index in a timely fashion\. Most data updates and simple domain configuration changes are built and deployed in minutes\. Indexing large volumes of data and applying configuration changes that require rebuilding the full index will take longer to complete\. 

 You can initiate indexing from the [Amazon CloudSearch console](#indexing-console), using the `aws cloudsearch index-documents` command, or through the AWS SDKs\.

**Topics**
+ [Amazon CloudSearch console](#indexing-console)
+ [Indexing Documents Using the Amazon CloudSearch AWS CLI](#indexing-clt)
+ [Indexing Documents with the AWS SDK](#indexing-sdk)

## Indexing Documents Using the Amazon CloudSearch Console<a name="indexing-console"></a>

 When you make changes that require your domain's index to be rebuilt, the status shown on the domain dashboard changes to NEEDS INDEXING\. The console also displays a message at the top of the configuration pages prompting you to run indexing when you are done making changes\. 

**To run indexing**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain that needs indexing\.

1. On the domain dashboard, click the **Run Indexing** button\.

1. Click **OK** in the **Starting Indexing** dialog box to return to the domain dashboard\.

## Indexing Documents Using the Amazon CloudSearch AWS CLI<a name="indexing-clt"></a>

You use the `aws cloudsearch index-documents` command to rebuild your domain's search index\. For information about installing and setting up the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

**To explicitly index your domain**
+ Run the `aws cloudsearch index-documents` command\. The following example rebuilds the index for a domain called *movies*\.  
**Example**  

  ```
  aws cloudsearch index-documents --domain-name movies
  ```

## Indexing Documents with the AWS SDK<a name="indexing-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[IndexDocuments](API_IndexDocuments.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.