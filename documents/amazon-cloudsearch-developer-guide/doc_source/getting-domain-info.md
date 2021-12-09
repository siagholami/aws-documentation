# Getting Information About an Amazon CloudSearch Domain<a name="getting-domain-info"></a>

You can retrieve the following information about each of your search domains:
+ **Domain Name**—The name of the domain\.
+ **ARN**—The domain's Amazon Resource Name \(ARN\)\.
+ **Document Endpoint**—The endpoint through which you can submit document updates\.
+ **Search Endpoint**—The endpoint through which you can submit search requests\.
+ **Searchable Documents**—The number of documents that have been indexed\.
+ **Access Policies**—The access policies configured for the domain's document and search endpoints\.
+ **Analysis Schemes**—The text analysis schemes that can be applied to the domain's index fields\.
+ **Index Fields**—The name and type of each configured index field\.
+ **Expressions**—The expressions that can be used for sorting search results\.
+ **Suggesters**—The suggesters that can be used to retrieve suggestions for incomplete queries\.

When a domain is first created, the domain status will indicate that the domain is currently being activated and no other information is available\. Once your domain's document and search endpoints are available, the domain status shows the endpoint addresses that you can use to add data and submit search requests\. If you haven't submitted any data for indexing, the number of searchable documents is zero\. 

You can view all of the information about your domain through the [Amazon CloudSearch console](#getting-domain-info-console)\. When you use the `aws cloudsearch describe-domains` command or the AWS SDKs, the domain's ARN is shown within the domain's access policies\.

To get the number of searchable documents, use the console or submit a `matchall` request to your domain's search endpoint\. 

```
q=matchall&q.parser=structured&size=0
```

**Topics**
+ [Amazon CloudSearch console](#getting-domain-info-console)
+ [Getting Amazon CloudSearch Domain Information Using the AWS CLI](#getting-domain-info-clt)
+ [DescribeDomains](#getting-domain-info-sdk)

## Getting Domain Information Using the Amazon CloudSearch Console<a name="getting-domain-info-console"></a>

You can use the Amazon CloudSearch console to view information about all of your domains\. The dashboard of the console shows a summary of each domain that you have created, including the domain name, status, and number of searchable documents\. To update the table with the latest information, click the **Refresh** button at the top of the page\. 

A domain can be in one of five states:
+ **LOADING**—The domain has just been created and is still being initialized\. You must wait until the domain status changes to PROCESSING, NEEDS INDEXING, or ACTIVE before you can start uploading documents\.
+ **ACTIVE**—The domain is running and all configured fields have been indexed\.
+ **NEEDS INDEXING**—You have made changes to the domain configuration that require rebuilding the index\. If you search the domain, these changes won't be reflected in the results\. When you are done making changes, click **Run Indexing** to rebuild your index\.
+ **PROCESSING**—Configuration changes are being applied to your domain\. If you search the domain, the most recent configuration changes might not be reflected in the results\.
+ **BEING DELETED**—You chose to delete the domain and its contents, and the domain and all of its resources are in the process of being removed\. When deletion is complete, the domain will be removed from the list of domains\.

 From the Amazon CloudSearch dashboard, you can do the following:
+ View the status of your search domains
+ Access the dashboard for a particular domain
+ Access the Amazon CloudSearch documentation and other resources

**To view detailed information about a particular domain**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. Click the name of the domain in the **Navigation** pane\. 

<a name="domain-dashboard"></a>The domain dashboard shows the status summary for the selected domain\. From the domain dashboard, you can do the following:
+ View the status of the domain
+ Upload documents to the domain
+ Search the domain
+ Access the domain configuration pages
+ Delete the domain

**To view the access policies configured for the domain**
+ Click the domain's **Access Policies** link in the **Navigation** pane\. For more information about access policies, see [Configuring Access for Amazon CloudSearch](configuring-access.md)\.

**To view the availability options configured for the domain**
+ Click the domain's **Availability Options** link in the **Navigation** pane\. For more information about access policies, see [Configuring Availability Options](configuring-availability-options.md)\.

**To view the index fields configured for the domain**
+ Click the domain's **Indexing Options** link in the **Navigation** pane\. For more information about index fields, see [Configuring Index Fields](configuring-index-fields.md)\.

**To view the scaling options configured for the domain**
+ Click the domain's **Scaling Options** link in the **Navigation** pane\. For more information about index fields, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\.

**To view the suggesters configured for the domain**
+ Click the domain's **Suggesters** link in the **Navigation** pane\. For more information about index fields, see [Configuring Suggesters for Amazon CloudSearch](getting-suggestions.md#configuring-suggesters)\.

**To view the expressions configured for the domain**
+ Click the domain's ** Expressions** link in the **Navigation** pane\. For more information about expressions, see [Configuring Expressions](configuring-expressions.md)\.

**To view the text\-processing options configured for the domain**
+ Click the domain's **Analysis Schemes** link in the **Navigation** pane\. For information about text options, see [Configuring Analysis Schemes](configuring-analysis-schemes.md)\.

## Getting Amazon CloudSearch Domain Information Using the AWS CLI<a name="getting-domain-info-clt"></a>

You use the `aws cloudsearch describe-domains` command to get the status of your search domains\. To get specific information such as the access policies, availability options, and scaling options configured for a domain, you use the separate describe command for each option\. For information about installing and setting up the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

**To get domain status information**
+ Run the `aws cloudsearch describe-domains` command to get information about all of your domains\. To get information about specific domains, use the `--domain-names` option to specify the domains that you are interested in\. For example, the following request gets the status of the `movies` domain:

  ```
  aws cloudsearch describe-domains --domain-names movies
                          
  {
      "DomainStatusList": [
          {
              "SearchInstanceType": "search.m1.small", 
              "DomainId": "965407640801/movies", 
              "Created": true, 
              "Deleted": false, 
              "SearchInstanceCount": 1, 
              "DomainName": "movies", 
              "SearchService": {
                  "Endpoint": "search-movies-m4fcjhuxgj6i76smhyiz7pfxsu.us-east-1.cloudsearch.amazonaws.com"
              }, 
              "RequiresIndexDocuments": false, 
              "Processing": true, 
              "DocService": {
                  "Endpoint": "doc-movies-m4fcjhuxgj6i76smhyiz7pfxsu.us-east-1.cloudsearch.amazonaws.com"
              }, 
              "ARN": "arn:aws:cloudsearch:us-east-1:965407640801:domain/movies", 
              "SearchPartitionCount": 1
          }
      ]
  }
  ```

The `describe-domains` command does not return the number of searchable documents in the domain\. To get the number of searchable documents, use the console or submit a `matchall` request to your domain's search endpoint: 

```
q=matchall&q.parser=structured&size=0
```

**To get the analysis schemes configured for a domain**
+ Run the `aws cloudsearch describe-analysis-schemes` command\. For example, the following request gets the analysis schemes configured for the `movies` domain:

  ```
  aws cloudsearch describe-analysis-schemes --domain-name movies
                  
  {
      "AnalysisSchemes": [
          {
              "Status": {
                  "PendingDeletion": false, 
                  "State": "Active", 
                  "CreationDate": "2014-03-28T19:27:30Z", 
                  "UpdateVersion": 31, 
                  "UpdateDate": "2014-03-28T19:27:30Z"
              }, 
              "Options": {
                  "AnalysisSchemeLanguage": "en", 
                  "AnalysisSchemeName": "samplescheme", 
                  "AnalysisOptions": {
                      "AlgorithmicStemming": "none", 
                      "Synonyms": "{\"aliases\":{\"youth\":[\"young adult\"]},\"groups\":[[\"tool box\",\"toolbox\"],[\"band saw\",\"bandsaw\"],[\"drill press\",\"drillpress\"]]}", 
                      "StemmingDictionary": "{}", 
                      "Stopwords": "[]"
                  }
              }
          }
      ]
  }
  ```

**To get the availability options configured for a domain**
+ Run the `aws cloudsearch describe-availability-options` command\. For example, the following request gets the availability options configured for the `movies` domain\. If Multi\-AZ is enabled for the domain, the `Options` value is set to `true`:

  ```
  aws cloudsearch describe-availability-options --domain-name movies
  
  {
      "AvailabilityOptions": {
          "Status": {
              "PendingDeletion": false, 
              "State": "Processing", 
              "CreationDate": "2014-04-30T20:42:57Z", 
              "UpdateVersion": 13, 
              "UpdateDate": "2014-05-01T00:17:45Z"
          }, 
          "Options": true
      }
  }
  ```

**To get the expressions configured for a domain**
+ Run the `aws cloudsearch describe-expressions` command\. For example, the following request gets the expressions configured for the `movies` domain: 

  ```
  aws cloudsearch describe-expressions --domain-name movies
  
  {
      "Expression": {
          "Status": {
              "PendingDeletion": false, 
              "State": "Processing", 
              "CreationDate": "2014-05-01T01:15:18Z", 
              "UpdateVersion": 52, 
              "UpdateDate": "2014-05-01T01:15:18Z"
          }, 
          "Options": {
              "ExpressionName": "popularhits", 
              "ExpressionValue": "((0.3*popularity)/10.0)+(0.7* _score)"
          }
      }
  }
  ```

## Getting Domain Information Using the AWS SDKs<a name="getting-domain-info-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[DescribeDomains](API_DescribeDomains.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.

The `DescribeDomains` action does not return the number of searchable documents in the domain\. To get the number of searchable documents, use the console or submit a `matchall` request to your domain's search endpoint:

```
q=matchall&q.parser=structured&size=0
```