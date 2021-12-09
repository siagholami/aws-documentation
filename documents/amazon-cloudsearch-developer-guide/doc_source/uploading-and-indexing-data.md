# Uploading and Indexing Data in Amazon CloudSearch<a name="uploading-and-indexing-data"></a>

To make your data searchable, you need to format it in JSON or XML as described in [Preparing Your Data](preparing-data.md) and upload it to your search domain for indexing\. In most cases, Amazon CloudSearch automatically indexes your data and the changes are visible in search results in just a few minutes\. However, certain changes to your domain configuration put the domain in the `NEEDS INDEXING` state\. For those changes to take effect, you must explicitly run indexing to rebuild your index\. Currently, you also need to periodically run indexing so your suggesters reflect the most recent data in your index\. The following sections describe how to upload data to your domain and run indexing when it's needed\. 

**Important**  
Rebuilding your index after data uploads is unnecessary and can cause your domain to incur additional charges\. You only need to rebuild your index after certain configuration changes or after you have deleted documents and want them permanently removed from the service\.

**Topics**
+ [upload documents](uploading-data.md)
+ [rebuild the index](indexing.md)