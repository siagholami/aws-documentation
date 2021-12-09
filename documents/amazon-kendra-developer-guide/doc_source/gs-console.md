--------

--------

# Getting started with an S3 bucket \(Console\)<a name="gs-console"></a>

The following procedures show how to create and test an Amazon Kendra index by using the AWS console\. In the procedures you create an index and a data source for an S3 bucket\. Finally, you test your index by making a search request\. 

**Step 1: To create an index \(Console\)**

1. Choose **Create index** to start creating a new index\.

1. In **Specify index details**, give your index a name and a description\.

1. In **IAM role** choose **Create a new role** and then give the role a name\. The IAM role will have the prefix "AmazonKendra\-"\.

1. Leave all of the other fields at their defaults\. Choose **Next**\.

1. **Provisioning details** page, choose **Developer edition**\.

1. Choose **Create** to create your index\.

1. Wait for your index to be created\. Kendra provisions the hardware for your index\. This operation can take some time\.<a name="gs-data-source"></a>

**Step 2: To add a data source to an index \(Console\)**
+ Create a data source that connects the Amazon Kendra index to your documents\. You can choose from one of the following procedures to create a data source\.
  + [Getting started with a Microsoft OneDrive for Business data source \(Console\)](getting-started-onedrive.md)
  + [Getting started with an Amazon S3 data source \(Console\)](getting-started-s3.md)
  + [Getting started with a Salesforce data source \(Console\)](getting-started-salesforce.md)
  + [Getting started with a ServiceNow data source \(Console\)](getting-started-servicenow.md)
  + [Getting started with a Microsoft SharePoint Online data source \(Console\)](getting-started-sharepoint.md)<a name="gs-search"></a>

**Step 3: To search an index \(Console\)**

1. In the navigation pane, choose **Search console**

1. Enter a search term that's appropriate for your index\. The **top results** and **top document** results are shown\.