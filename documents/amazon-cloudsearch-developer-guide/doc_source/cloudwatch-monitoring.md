# Monitoring an Amazon CloudSearch Domain with Amazon CloudWatch<a name="cloudwatch-monitoring"></a>

Amazon CloudSearch automatically sends metrics to Amazon CloudWatch so that you can gather and analyze performance statistics\. You can monitor these metrics by using the Amazon CloudSearch console, or by using the CloudWatch console, AWS CLI, or AWS SDKs\. Each of your domain's search instances sends metrics to CloudWatch at one\-minute intervals\. The metrics are archived for two weeks; after that period, the data is discarded\. 

There is no charge for the Amazon CloudSearch metrics that are reported through CloudWatch\. If you set alarms on the metrics, you will be billed at standard [CloudWatch rates](http://aws.amazon.com/cloudwatch/pricing/)\. You can use the metrics in all regions supported by Amazon CloudSearch\.

**Topics**
+ [Amazon CloudSearch Metrics](#cloudsearch-metrics)
+ [Dimensions for Amazon CloudSearch Metrics](#cloudsearch-metric-dimensions)
+ [Generating SDK for Java Metrics for Amazon CloudSearch](#java-sdk-metrics)
+ [Viewing CloudWatch Metrics for an Amazon CloudSearch Domain](#viewing-metrics)

Not all statistics, such as *Average* or *Sum*, are applicable for every metric\. However, all of these values are available through the Amazon CloudSearch console, or by using the CloudWatch console, AWS CLI, or AWS SDKs for all metrics\. In the following table, each metric has a list of Valid Statistics that is applicable to that metric\.

## Amazon CloudSearch Metrics<a name="cloudsearch-metrics"></a>

The `AWS/CloudSearch` namespace includes the following metrics\.


| Metric | Description | 
| --- | --- | 
|  `SuccessfulRequests`  |  The number of search requests successfully processed by a search instance\.  Units: Count Valid statistics: Maximum, Sum  | 
|  `SearchableDocuments`  |  The number of searchable documents in the domain's search index\.  Units: Count Valid statistics: Maximum  | 
|  `IndexUtilization`  |  The percentage of the search instance's index capacity that has been used\. The Maximum value indicates the percentage of the domain's index capacity that has been used\. Units: Percent Valid statistics: Average, Maximum  | 
|  `Partitions`  |  The number of partitions the index is distributed across\. Units: Count Valid statistics: Minimum, Maximum  | 

## Dimensions for Amazon CloudSearch Metrics<a name="cloudsearch-metric-dimensions"></a>

Amazon CloudSearch sends the ClientId and DomainName dimensions to CloudWatch\.


| Dimension | Description | 
| --- | --- | 
| `ClientId` |  The AWS account ID\.  | 
| `DomainName` |  The name of the search domain\.  | 

## Generating SDK for Java Metrics for Amazon CloudSearch<a name="java-sdk-metrics"></a>

The AWS SDK for Java can generate performance metrics for your Amazon CloudSearch client and send them to CloudWatch for visualization\. For the Java VM arguments that enable this feature, see [Enabling Metrics for the AWS SDK for Java](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/generating-sdk-metrics.html) in the *AWS SDK for Java Developer Guide*\.

You can use the following code to test metrics generation\. The code creates a new CloudWatch client and performs 2,500 searches\. Because the SDK only sends metrics once per minute, long\-running clients work best\. The code uses the [default credential provider chain](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html#credentials-default)\.

```
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomain;
import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClientBuilder;
import com.amazonaws.services.cloudsearchdomain.model.SearchRequest;

public class Metrics {

  public static void main(String[] args) {

    String search_endpoint = "https://search-domain-id.us-west-1.cloudsearch.amazonaws.com";
    String region = "us-west-1";

    AwsClientBuilder.EndpointConfiguration endpointConfig = new AwsClientBuilder
        .EndpointConfiguration(search_endpoint, region);
        
    AmazonCloudSearchDomainClientBuilder builder = AmazonCloudSearchDomainClientBuilder
        .standard()
        .withEndpointConfiguration(endpointConfig);
        
    AmazonCloudSearchDomain client = builder.build();
        
    String query;
    SearchRequest request = new SearchRequest();
    com.amazonaws.services.cloudsearchdomain.model.SearchResult test = client.search(request);
                
    for (int i = 0; i < 2500; i++) {
      query = "test";
      request.setQuery(query);
      test = client.search(request);
      System.out.println(test.toString());
    }
  }
}
```

To verify that the SDK is sending metrics to CloudWatch, check the **Metrics** page of the CloudWatch console and look for **AWSSDK/Java** under the **Custom Namespaces** section\. The metrics might take several minutes to display\.

## Viewing CloudWatch Metrics for an Amazon CloudSearch Domain<a name="viewing-metrics"></a>

The Amazon CloudSearch console graphs the metrics reported to CloudWatch\. You can also access the metrics through the [CloudWatch console](https://console.aws.amazon.com/cloudwatch), AWS CLI, and AWS SDKs\. For more information, see [Viewing, Graphing, and Publishing Metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/working_with_metrics.html) in the * Amazon CloudWatch Developer Guide*\.

**To view metrics for a search domain using the Amazon CloudSearch console**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch](https://console.aws.amazon.com/cloudsearch)\.

1. In the navigation pane, click the name of the domain, and then click the domain's **Monitoring** link\.