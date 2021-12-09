--------

--------

# Getting started with an Amazon S3 data source \(Console\)<a name="getting-started-s3"></a>

You can use the Amazon Kendra console to get started using an Amazon S3 bucket as a data store\. When you use the console you specify all of the connection information you need to index the contents of the bucket\. For more information, see [Using an Amazon S3 data source](data-source-s3.md)\.

Use the following procedure to create a basic S3 bucket data source using the default configuration\. The procedure assumes that you created an index following the steps in step 1 of [Getting started with an S3 bucket \(Console\)](gs-console.md)\.

**To create an S3 bucket data source using the Amazon Kendra console**

1. Sign into the AWS Management Console and open the Amazon Kendra console at [https://console\.aws\.amazon\.com/kendra/home](https://console.aws.amazon.com/kendra/home)\.

1. From the list of indexes, choose the index that you want to add the data source to\.

1. Choose **Add data sources**\.

1. From the list of data source connectors, choose **Amazon S3**\.

1. On the **Define attributes** page, give your data source a name and optionally a description\. Leave the **Tags** field blank\. Choose **Next** to continue\.

1. In the **Enter the data source location** field, enter the name of the S3 bucket that contains your documents\. You can enter the name directly, or you can browse for the name by choosing **Browse**\. The bucket must be in the same Region as the index\.

1. In **IAM role** choose **Create a new role** and then type a role name\.

1. In the **Set sync run schedule** section, choose **Run on demand**\.

1. Choose **Next** to continue\.

1. On the **Review and create** page review the details of your S3 data source\. If you want to make changes, choose the **Edit** button next to the item that you want to change\. When you are satisfied with your choices, choose **Create** to create your S3 data source\.

After you choose **Create**, Amazon Kendra starts creating the data source\. It can take several minutes for the data source to be created\. When it is finished, the status of the data source changes from **Creating** to **Active**\.

After creating the data source, you need to sync the Amazon Kendra index with the data source\. Choose **Sync now** to start the sync process\. It can take several minutes to several hours to synchronize the data source, depending on the number and size of the documents\.