--------

--------

# Getting started with a Microsoft SharePoint Online data source \(Console\)<a name="getting-started-sharepoint"></a>

You can use the Amazon Kendra console to get started indexing a Microsoft SharePoint Online site\. When you use the console you specify the connection information you need to index the contents of the SharePoint Online site\.

Use the following procedure to create a basic SharePoint Online data source using the default configuration\. The procedure assumes you created an index following the steps in step 1 of [Getting started with an S3 bucket \(Console\)](gs-console.md)\.

**To create a SharePoint Online data source using the Amazon Kendra console**

1. Sign into the AWS Management Console and open the Amazon Kendra console at [https://console\.aws\.amazon\.com/kendra/home](https://console.aws.amazon.com/kendra/home)\.

1. From the list of indexes, choose the index that you want to add the data source to\.

1. Choose **Add data sources**\.

1. From the list of data source connectors, choose **SharePoint Online**\.

1. On the **Define attributes** page, give your data source a name and optionally a description\. Leave the **Tags** field blank\. Choose **Next** to continue\.

1. In the **Add SharePoint URLs** section, add the URLs of the SharePoint Online site to index\.

1. In **IAM role** choose **Create a new role** and then type a role name\.

1. In the **Type of authentication** field, choose **New**\. This tells the console to create a new AWS Secrets Manager secret to contain credentials for your SharePoint Online data source\.

1. In the **New secret container name** field enter a name to identify the Secrets Manager secret\.

1. Enter the username and password for your SharePoint Online account, and then choose **Save authentication** to save the new secret\.

1. In the **Set sync run schedule** section, choose **Run on demand** in the **Frequency** field\.

1. Choose **Next** to continue\.

1. On the **Set field mappings \- optional** page, leave the defaults checked and choose **Next** to continue\.

1. On the **Review and create** page review the details of your SharePoint Online data source\. If you want to make changes, choose the **Edit** button next to the item that you want to change\. When you are satisfied with your choices, choose **Create** to create your SharePoint Online data source\.

After you choose **Create**, Amazon Kendra starts creating the data source\. It can take several minutes for the data source to be created\. When it is finished, the status of the data source changes from **Creating** to **Active**\.

After creating the data source, you need to sync the Amazon Kendra index with the data source\. Choose **Sync now** to start the sync process\. It can take several minutes to several hours to synchronize the data source, depending on the number and size of the documents\.