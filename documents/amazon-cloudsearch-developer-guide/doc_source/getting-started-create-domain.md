# Step 1: Create an Amazon CloudSearch Domain<a name="getting-started-create-domain"></a>

An Amazon CloudSearch domain encapsulates a collection of data you want to search, the search instances that process your search requests, and a configuration that controls how your data is indexed and searched\. You create a separate search domain for each collection of data you want to make searchable\. For each domain, you configure indexing options that describe the fields you want to include in your index and how you want to use them, analysis schemes that specify language\-specific text processing options for individual fields, expressions that you can use to customize how search results are ranked, and access policies that control access to the domain's document and search endpoints\. 

You interact with a search domain to:
+ Configure index and search options
+ Submit data for indexing
+ Perform searches

Each domain has a unique endpoint through which you submit search requests to the domain\. For example, the endpoint for a domain called *movies* created in the US East \(N\. Virginia\) region might be:

**Example**  

```
search-movies-mtshfsu2rje7ywr66uit3dei4m.us-east-1.cloudsearch.amazonaws.com
```

When creating a search domain, you specify a unique name for the domain\. Domain names must start with a letter or number and be at least 3 and no more than 28 characters long\. The allowed characters are: a\-z, 0\-9, and hyphen \(\-\)\. By default, new domains are created in the US East \(N\. Virginia\) region\. To create a domain in another region, you must explicitly specify the region when creating the domain\.

To configure the new domain, you must specify:
+ Indexing options for the data you want to search\. 
+ Access policies for the domain's document service and search service endpoints\. 

This tutorial shows you how to create and interact with a domain using the Amazon CloudSearch console\. To learn more, see [Creating a Search Domain](creating-domains.md)\.

**Important**  
The domain you're about to create will be live and you will incur the standard Amazon CloudSearch usage fees for the domain until you delete it\. For more information about Amazon CloudSearch usage rates, go to the [Amazon CloudSearch detail page](http://aws.amazon.com/cloudsearch/)\.

**To create your movies domain**

1. Go to the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. On the Welcome to Amazon CloudSearch page, click **Create Your First Search Domain**\.

1. In the **NAME YOUR DOMAIN** step, enter a name for your new domain and click **Continue**\. Domain names must start with a letter or number and be at least 3 and no more than 28 characters\. Domain names can contain the following characters: a\-z \(lower case\), 0\-9, and \- \(hyphen\)\. Upper case letters and underscores are not allowed\.

1. In the **CONFIGURE INDEX** step, click **Use a predefined configuration**, select **IMDb movies \(demo\)**, and click **Continue**\. You can also automatically configure a search domain by analyzing a sample of your data\.

1. In the **REVIEW INDEX CONFIGURATION** step, review the index fields being configured\. Eleven fields are configured automatically for the imdb\-movie data: actors, directors, genres, image\_url, plot, rank, rating, release\_date, running\_time\_secs, title, and year\. 
**Note**  
By default, all options are enabled for each field\. While this is convenient for development and testing, fine\-tuning the options configured for each field according to how you use those fields can reduce the size of your index\. If your domain uses more than a single small search instance, tuning can help minimize the cost of running your domain\. 

   When you are finished reviewing the indexing options, click **Continue**\.

1. In the **SET UP ACCESS POLICIES** step, click **Search and Suggester service: Allow all\. Document Service: Account owner only\.** and click **Continue**\. The recommended rules allow access to the search endpoint from all IP addresses, and restrict access to the document service to the IP address you specify\.
**Important**  
If you do not configure access rules for your search domain, you will only be able to interact with the domain through the Amazon CloudSearch console\. By default, the document service and search service endpoints are configured to block all IP addresses\.

   Keep in mind that if you do not have a static IP address, you must re\-authorize your computer whenever your IP address changes\. If your IP address is assigned dynamically, it is also likely that you're sharing that address with other computers on your network\. This means that when you authorize the IP address, all computers that share it will be able to access your search domain's document service endpoint\.

1. In the **CONFIRM** step, review the domain configuration and click **Confirm** to create your domain\. 

1. Once the domain has been created, click **OK** to exit the Create New Search Domain wizard and go to the domain's dashboard\.

When you create a new domain, Amazon CloudSearch initializes resources for the domain, which can take about ten minutes\. During this initialization process, the status of the domain will be LOADING\. Once the status changes to ACTIVE, you can upload your data and start searching\. 