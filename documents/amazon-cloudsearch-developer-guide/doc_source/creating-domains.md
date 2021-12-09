# Creating an Amazon CloudSearch Domain<a name="creating-domains"></a>

To search your data with Amazon CloudSearch, the first thing you need to do is create a search domain\. If you have multiple collections of data that you want to make searchable, you can create multiple search domains\. Before you can [send search requests](searching.md) to a new domain, you must also [configure access policies](configuring-access.md), [configure index fields](configuring-index-fields.md), and [upload the data you want to search](uploading-data.md)\.

When you create a search domain, you must give it a unique name\. Domain names must start with a letter or number and be at least 3 and no more than 28 characters long\. The allowed characters are: a\-z, 0\-9, and hyphen \(\-\)\. Upper case letters, underscores \(\_\), and other special characters are not allowed in domain names\.

By default, all new domains are created using the 2013\-01\-01 API version\. If you have previously created search domains with the 2011\-02\-01 API version, you can opt to use the old API for your new domain\. However, we recommend using the 2013\-01\-01 API for all new use cases\. All domains will need to migrate to the 2013\-01\-01 API when the 2011\-02\-01 API is retired\.

You can choose the AWS region where you want to create your search domain\. Typically, you should choose the region closest to your operations\. For example, if you reside in Europe, create your search domain in the EU \(Ireland\) region \(eu\-west\-1\)\. For a current list of supported regions and endpoints, see [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html)\. For more information about choosing a region, see [Regions and Endpoints for Amazon CloudSearch](what-is-cloudsearch.md#endpoints)\.

**Note**  
Amazon CloudSearch domains in different regions are entirely independent\. For example, if you create a search domain called *my\-domain* in us\-east\-1, and another domain called *my\-domain* in eu\-west\-1, they are completely independent and do not share any data\.

Each search domain has unique endpoints through which you upload data for indexing and submit search requests\. A domain's document and search endpoints remain the same for the life of the domain\. For example, the endpoints for a domain called imdb\-movies might be: 

```
doc-imdb-movies-nypdffbzrfkoudsurkxvgwbpi4.us-east-1.cloudsearch.amazonaws.com
search-imdb-movies-nypdffbzrfkoudsurkxvgwbpi4.us-east-1.cloudsearch.amazonaws.com
```

**Important**  
By default, access to a new domain's document and search endpoints is blocked for all IP addresses\. You must configure access policies for the domain to be able to submit search requests to the domain's search endpoint and upload data from the command line or through the domain's document endpoint\. You can upload documents and search the domain through the Amazon CloudSearch console without configuring access policies\. 

You can create a search domain from the [Amazon CloudSearch console](#create-domain-console), using the `aws cloudsearch create-domain` command, or using one of the AWS SDKs\. 

**Topics**
+ [Amazon CloudSearch console](#create-domain-console)
+ [create-domain](#create-domain-clt)
+ [Creating an Amazon CloudSearch Domain Using the AWS SDKs](#create-domain-sdk)

## Creating a Domain Using the Amazon CloudSearch Console<a name="create-domain-console"></a>

 The Amazon CloudSearch console enables you to easily create new search domains and provides a variety of options for configuring indexing options\. 

**To create a domain**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. At the top of the **Navigation** pane, click **Create a New Domain**\. \(If you are creating a domain for the first time, click **Create Your First Search Domain** on the Welcome page\.\)

1. In the **NAME YOUR DOMAIN** step, enter a name for your new domain and click **Continue**\. Domain names must start with a letter or number and be at least 3 and no more than 28 characters long\. Domain names can contain the following characters: a\-z \(lower case\), 0\-9, and \- \(hyphen\)\. Upper case letters, underscores \(\_\), and other special characters are not allowed in domain names\.

   Optionally, you can set the **Desired Instance Type** and **Desired Replication Count** to prescale your domain\. For more information, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\.

1. In the **CONFIGURE INDEX** step, select **Manual Configuration** and click **Continue**\. You can configure index fields and access policies when you first create the domain, or simply create a domain and configure it later\. For more information about using the Amazon CloudSearch console to configure the domain, see [Configuring Index Fields](configuring-index-fields.md) and [Configuring Access for Amazon CloudSearch](configuring-access.md)\.

1. In the **REVIEW INDEX CONFIGURATION** step, click **Continue** to configure the index fields later\. For more information about configuring index fields, see [Configuring Index Fields](configuring-index-fields.md)\.

1. In the **SET UP ACCESS POLICIES** step, click **Continue** to set up access policies later\. For more information about configuring access policies, see [Configuring Access for Amazon CloudSearch](configuring-access.md)\. 
**Note**  
Until you configure access policies, you will only be able to upload documents and submit search queries through the console\. By default, the Document and Search endpoints are configured to block all IP addresses\.

1. In the **CONFIRM** step, review the domain configuration and click **Confirm** to create your domain\. 

1. Once the domain has been created, click **OK** to exit the Create New Search Domain wizard and go to the domain's dashboard\. The domain's document and search service endpoints are displayed on the domain dashboard when the domain reaches the ACTIVE state\. At that point, you can upload documents for indexing and start searching your data\.

## Creating a Domain Using the AWS CLI<a name="create-domain-clt"></a>

You use the `aws cloudsearch create-domain` command to create search domains\. For information about installing and setting up the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

**To create a domain**
+ Run the `aws cloudsearch create-domain` command and specify the name of the domain you want to create with the `--domain-name` option\. For example, to create a domain called *movies*:  
**Example**  

  ```
  aws cloudsearch create-domain --domain-name movies
  {
    "DomainStatus": {
        "DomainId": "965407640801/movies", 
        "Created": true, 
        "Deleted": false, 
        "SearchInstanceCount": 0, 
        "DomainName": "movies", 
        "SearchService": {}, 
        "RequiresIndexDocuments": false, 
        "Processing": false, 
        "DocService": {}, 
        "ARN": "arn:aws:cloudsearch:us-east-1:965407640801:domain/movies", 
        "SearchPartitionCount": 0
    }
  }
  ```

The `aws cloudsearch create-domain` command returns immediately\. It takes about ten minutes to create endpoints for a new domain\. You can use the `aws cloudsearch describe-domains` command to view a summary of the domain's status and configuration\. For more information, see [Getting Information About an Amazon CloudSearch Domain](getting-domain-info.md)\. 

**Important**  
Once a domain's endpoints are active, they remain the same for the life of the domain\. You should cache the endpoints—there's no need to query for the endpoint before submitting a document or search service request and doing so is likely to result in your requests being throttled\.

## Creating an Amazon CloudSearch Domain Using the AWS SDKs<a name="create-domain-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[CreateDomain](API_CreateDomain.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.