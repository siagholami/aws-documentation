# Submitting Search Requests to an Amazon CloudSearch Domain<a name="submitting-search-requests"></a>

We recommend using one of the AWS SDKs or the AWS CLI to submit search requests\. The SDKs and AWS CLI handle request signing for you and provide an easy way to perform all Amazon CloudSearch actions\. You can also use the Search Tester in the Amazon CloudSearch console to search your data, browse the results, and view the generated request URLs and JSON and XML responses\. For more information, see [Searching with the Search Tester](getting-started-search.md#searching-console)\.

**Important**  
Search endpoints don't change: A domain's document and search endpoints remain the same for the life of the domain\. You should cache the endpoints rather than retrieving them before every upload or search request\. Querying the Amazon CloudSearch configuration service by calling `aws cloudsearch describe-domains` or `DescribeDomains` before every request is likely to result in your requests being throttled\.
IP addresses **do** change: Your domain's IP address *can* change over time, so it's important to cache the endpoint as shown in the console and returned by the `aws cloudsearch describe-domains` command rather than the IP address\. You should also re\-resolve the endpoint DNS to an IP address regularly\. For more information, see [Setting the JVM TTL for DNS Name Lookups](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-jvm-ttl.html)\.

For example, the following request submits a simple text search for `wolverine` using the AWS CLI and returns just the IDs of the matching documents\.

```
aws cloudsearchdomain --endpoint-url http://search-movies-y6gelr4lv3jeu4rvoelunxsl2e.us-east-1.cloudsearch.amazonaws.com search --search-query wolverine  --return _no_fields
{
    "status": {
        "rid": "/rnE+e4oCAqfEEs=", 
        "time-ms": 6
    }, 
    "hits": {
        "found": 3, 
        "hit": [
            {
                "id": "tt1430132"
            }, 
            {
                "id": "tt0458525"
            }, 
            {
                "id": "tt1877832"
            }
        ], 
        "start": 0
    }
}
```

By default, Amazon CloudSearch returns the response in JSON\. You can get the results formatted in XML by specifying the `format` parameter\. Setting the response format only affects responses to successful requests\. The format of an error response depends on the origin of the error\. Errors returned by the search service are always returned in JSON\. 5xx errors due to server timeouts and other request routing problems are returned in XML\.

**Note**  
The AWS SDKs return fields as arrays\. Single\-value fields are returned as arrays with one element, such as:  

```
"fields": {
  "plot": ["Katniss Everdeen reluctantly becomes the symbol of a mass rebellion against the autocratic Capitol."]
}
```

For development and testing purposes, you can allow anonymous access to your domain's search service and submit unsigned HTTP GET or POST requests directly to your domain's search endpoint\. In a production environment, restrict access to your domain to specific IAM users, groups, or roles and submit signed requests using the AWS SDKs or AWS CLI\. For information about controlling access for Amazon CloudSearch, see [Configuring Access for Amazon CloudSearch](configuring-access.md)\. For more information about request signing, see [Signing AWS API Requests](https://docs.aws.amazon.com/general/latest/gr/signing_aws_api_requests.html)\. 

You can use any method you want to send HTTP requests directly to your domain's search endpoint—you can enter the request URL directly in a Web browser, use cURL to submit the request, or generate an HTTP call using your favorite HTTP library\. To specify your search criteria, you specify a query string that specifies the constraints for your search and what you want to get back in the response\. The query string must be URL\-encoded\. The maximum size of a search request submitted via GET is 8190 bytes, including the HTTP method, URI, and protocol version\. You can submit larger requests using HTTP POST; however, keep in mind that large, complex requests take longer to process and are more likely to time out\. For more information, see [Tuning Search Request Performance in Amazon CloudSearch](tuning-search.md)\.

For example, the following request submits a structured query to the `search-movies-rr2f34ofg56xneuemujamut52i.us-east-1.cloudsearch.amazonaws.com` domain and gets the contents of the `title` field\.

```
http://search-movies-rr2f34ofg56xneuemujamut52i.us-east-1.cloudsearch.
amazonaws.com/2013-01-01/search?q=(and+(term+field%3Dtitle+'star')
(term+field%3Dyear+1977))&q.parser=structured&return=title
```

**Important**  
Special characters in the query string must be URL\-encoded\. For example, you must encode the `=` operator in a structured query as `%3D`: `(term+field%3Dtitle+'star')`\. If you don't encode the special characters when you submit the search request, you'll get an `InvalidQueryString` error\.