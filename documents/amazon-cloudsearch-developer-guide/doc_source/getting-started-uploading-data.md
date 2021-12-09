# Step 2: Upload Data to Amazon CloudSearch for Indexing<a name="getting-started-uploading-data"></a>

You upload the data you want to search to your domain so that Amazon CloudSearch can build and deploy a searchable index\. To be indexed by Amazon CloudSearch, the data must be formatted in either JSON or XML\. The Amazon CloudSearch console can automatically convert the following file types to the required format:
+ Document batches formatted in JSON or XML \(\.json, \.xml\)
+ Comma Separated Value \(\.csv\)
+ Text Documents \(\.txt\)

When you upload a CSV file, Amazon CloudSearch parses each row separately\. The first row defines the document fields, and each subsequent row becomes a separate document\. For all other file types Amazon CloudSearch creates a single document and the contents of the file are mapped to a single text field\. If metadata is available for the file, the metadata is mapped to corresponding document fields—the fields generated from the document metadata vary depending on the file type\.

The sample IMDb movies data is already formatted in JSON\.

This tutorial shows how to submit data through the Amazon CloudSearch console, but you can also [convert](preparing-data.md#processing-source-data) and [upload documents](uploading-data.md) with the command line tools, and upload documents using the `[documents/batch](documents-batch-resource.md)` resource\. \(To upload more than 5 MB of data, you must use the command line tools or API\.\)

**To upload the sample data to your movies domain**

1. Go to the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** panel, click the name of your movies domain to view the domain dashboard\. 

1. At the top of the domain dashboard, click the **Upload Documents** button\. 
**Note**  
The **Upload Documents** button is available once the domain status is ACTIVE\.

1. On the **DOCUMENT SOURCE** step, select **Predefined data**, choose **IMDb movies \(demo\)**, and click **Continue**\.

1. On the **REVIEW DOCUMENTS** step, review the upload summary and click **Upload Documents** to send the data to your domain for indexing\. 
**Note**  
If you'd like to see how the data is formatted, click **Download the generated document batch**\. For more information about preparing your own data, see [Preparing Your Data](preparing-data.md)\.

1. On the **DOCUMENT SUMMARY** step, click **Finish** to return to the domain dashboard\. 

 That's it\! You now have a fully functional Amazon CloudSearch domain that you can start searching\. Updates are applied continuously in the order they are received, so you can start searching your domain right away\. 