--------

--------

# Getting started with a Salesforce data source \(Console\)<a name="getting-started-salesforce"></a>

You can use the Amazon Kendra console to get started using a Salesforce data store\. When you use the console you specify the connection information you need to index the contents of a Salesforce instance\. For more information, see [Using a Salesforce data source](data-source-salesforce.md)\.

Use the following procedure to create a basic Salesforce data source using the default configuration\. The procedure assumes you created an index following the steps in step 1 of [Getting started with an S3 bucket \(Console\)](gs-console.md)\.

**To create a Salesforce data source using the Amazon Kendra console**

1. Sign into the AWS Management Console and open the Amazon Kendra console at [https://console\.aws\.amazon\.com/kendra/home](https://console.aws.amazon.com/kendra/home)\.

1. From the list of indexes, choose the index that you want to add the data source to\.

1. Choose **Add data sources**\.

1. From the list of data source connectors, choose **Salesforce**\.

1. On the **Define attributes** page, give your data source a name and optionally a description\. Leave the **Tags** field blank\. Choose **Next** to continue\.

1. On the **Define targets** page, enter the URL of you Salesforce server\.

1. In the **IAM role** field choose **Create a new role\.** Enter a name for the role in the **Role name** field\. Choose **Next** to continue\.

1. In the **Type of authentication** field, choose **New**\. This tells the console to create a new AWS Secrets Manager secret to contain credentials for your Salesforce data source\.

1. In the **New secret container name** field enter a name to identify the Secrets Manager secret\.

1. In the **Username** field, enter the user name for your Salesforce account\.

1. In the **Password** field, enter the password for your Salesforce account\.

1. In the **Security token** field, enter the security token for your Salesforce account\.

1. In the **Consumer key** field, enter the consumer key of the Salesforce connected app that you are using\.

1. In the **Consumer secret** field, enter the secret associated with the consumer key of the Salesforce connected app that you are using\.

1. In the **Authentication URL** field, enter the OAUTH endpoint for Salesforce\.

1. Choose **Save authentication** to save your authentication information\.

1. In the **Crawl settings** section, under **Standard objects**, choose **Document**\.

1. In the **Set sync run schedule** section, choose **Run on demand**\.

1. Choose **Next** to continue\.

1. On the **Set field mappings \- optional** page, leave the defaults and choose **Next**\.

1. On the **Review and create** page review the settings for the data source\. Use the **Edit** buttons to make any changes that you need to make\. When you are satisfied with the settings, choose **Create** to create your Salesforce data source\.

After you choose **Create**, Amazon Kendra starts creating the data source\. It can take several minutes for the data source to be created\. When it is finished, the status changes from **Creating** to **Active**\.

After creating the index, you need to sync the Amazon Kendra index with the data source\. Choose **Sync now** to start the sync process\. It can take several minutes to several hours to synchronize the data source, depending on the number and size of the documents\.