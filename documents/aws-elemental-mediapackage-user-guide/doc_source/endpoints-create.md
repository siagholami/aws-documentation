# Creating an Endpoint<a name="endpoints-create"></a>

Create an endpoint on a channel to define how AWS Elemental MediaPackage prepares content for delivery\. Content can't be served from a channel until it has an endpoint\. If you're using input redundancy, each endpoint receives content from one input URL at a time\. If MediaPackage performs a failover on the inputs for one input URL, the endpoints automatically start receiving content from the other input URL\. For more information about input redundancy and failover, see [Live Input Redundancy AWS Elemental MediaPackage Processing Flow](what-is-flow-ir.md)\.

When you create an endpoint, AWS Elemental MediaPackage assigns it a public URL that is fixed for the lifetime of the endpoint, regardless of any failures or upgrades that might happen over time\. This URL is how the player or CDN accesses the stream from the endpoint\.

You can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API to create an endpoint\. For information about creating an endpoint through the AWS CLI or MediaPackage API, see the [AWS Elemental MediaPackage API Reference](https://docs.aws.amazon.com/mediapackage/latest/apireference/)\.

AWS Elemental MediaPackage does not require that you supply any customer data\. There are no fields in endpoints where there is an expectation that you will provide customer data\.

**Topics**
+ [Creating an HLS Endpoint](endpoints-hls.md)
+ [Creating a Microsoft Smooth Streaming Endpoint](endpoints-smooth.md)
+ [Creating a Common Media Application Format \(CMAF\) Endpoint](endpoints-cmaf.md)
+ [Creating a DASH Endpoint](endpoints-dash.md)