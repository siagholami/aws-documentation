# Accessing the AWS Health API<a name="health-api"></a>

AWS Health is a RESTful web service that uses HTTPS as a transport and JavaScript Object Notation \(JSON\) as a message serialization format\. Your application code can make requests directly to the AWS Health web service API\. When using the REST API directly, you must write the necessary code to sign and authenticate your requests\. For more information about the API, see the [AWS Health API Reference](https://docs.aws.amazon.com/health/latest/APIReference/)\.

**Note**  
You must have a [Business or Enterprise support plan](https://aws.amazon.com/premiumsupport/compare-plans/) to use the AWS Health API\.

You can simplify application development by using the AWS SDKs that wrap the AWS Health REST API calls\. You provide your credentials, and then these libraries take care of authentication and request signing\.

AWS Health also provides a [Personal Health Dashboard](https://phd.aws.amazon.com/phd/home#/) in the AWS Management Console that is available to all AWS customers\. You can use the Personal Health Dashboard to view and search for events and affected entities\.

## Endpoints<a name="endpoints"></a>

AWS Health has a single global endpoint: https://health\.us\-east\-1\.amazonaws\.com 

You can view events in specific AWS Regions by using the filters supported by the API\. For more information about AWS endpoints and Regions for all services, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html) in the *AWS General Reference*\.

## Signing AWS Health API requests<a name="signing"></a>

Requests must be signed using an access key ID and a secret access key\. We strongly recommend that you do not use your AWS root account credentials for regular access to AWS Health\. You can use the credentials for an IAM user\.

To sign your API requests, we recommend using AWS Signature Version 4\. For more information, see [Signing AWS API Requests](https://docs.aws.amazon.com/general/latest/gr/signing_aws_api_requests.html) in the *AWS General Reference*\.