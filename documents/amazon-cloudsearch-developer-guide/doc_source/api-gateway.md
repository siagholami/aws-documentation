# Integrating Amazon CloudSearch with API Gateway<a name="api-gateway"></a>

This chapter provides information about integrating Amazon CloudSearch with Amazon API Gateway\. API Gateway lets you create and host REST APIs that make calls to other services\. Some use cases for using API Gateway with Amazon CloudSearch include the following:
+ Further securing the Amazon CloudSearch search endpoint using API keys or Amazon Cognito user pools
+ Using CloudWatch to monitor and log search calls to the Amazon CloudSearch domain
+ Restricting users to a more limited subset of the Amazon CloudSearch API
+ Enforcing a rate limit on the number of requests

To learn more about the benefits of API Gateway, see the [API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/)\.

**Topics**
+ [Prerequisites](#api-gateway-pre)
+ [Creating and Configuring an API \(Console\)](#api-gateway-create)
+ [Testing the API \(Console\)](#api-gateway-test)

## Prerequisites<a name="api-gateway-pre"></a>

Before you integrate Amazon CloudSearch with API Gateway, you must have the following resources\.


****  

| Prerequisite  | Description | 
| --- | --- | 
| Amazon CloudSearch Domain |  For testing purposes, the domain should have some searchable data\. The IMDb movies data is an excellent option\. The domain must have the following access policy: <pre>{<br />  "Version": "2012-10-17",<br />  "Statement": [<br />    {<br />      "Effect": "Allow",<br />      "Principal": {<br />        "AWS": "arn:aws:iam::123456789012:role/my-api-gateway-role"<br />      },<br />      "Action": [<br />        "cloudsearch:search",<br />        "cloudsearch:suggest"<br />      ]<br />    }<br />  ]<br />}</pre> This policy configures the Amazon CloudSearch domain so that only API Gateway \(and probably the account owner\) can access it\. To learn more, see [Creating an Amazon CloudSearch Domain](creating-domains.md) and [Configuring Access for Amazon CloudSearch](configuring-access.md)\. If you want to limit the account owner's access, see [Best Practices for Managing AWS Access Keys](https://docs.aws.amazon.com/general/latest/gr/aws-access-keys-best-practices.html) in the *AWS General Reference*\.  | 
| IAM Role |  This role delegates permissions to API Gateway and allows it to make requests to Amazon CloudSearch\. The role is referred to as `my-api-gateway-role` within this chapter and must have the following permissions: <pre>{<br />  "Version": "2012-10-17",<br />  "Statement": [{<br />    "Effect": "Allow",<br />    "Action": [<br />      "logs:CreateLogGroup",<br />      "logs:CreateLogStream",<br />      "logs:DescribeLogGroups",<br />      "logs:DescribeLogStreams",<br />      "logs:PutLogEvents",<br />      "logs:GetLogEvents",<br />      "logs:FilterLogEvents"<br />    ],<br />    "Resource": "*"<br />  }]<br />}</pre> The role must also have the following trust relationship: <pre>{<br />  "Version": "2012-10-17",<br />  "Statement": [{<br />    "Sid": "",<br />    "Effect": "Allow",<br />    "Principal": {<br />      "Service": "apigateway.amazonaws.com"<br />    },<br />    "Action": "sts:AssumeRole"<br />  }]<br />}</pre> To learn more, see [Creating Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create.html) in the *IAM User Guide*\.  | 

## Creating and Configuring an API \(Console\)<a name="api-gateway-create"></a>

The steps involved in creating an API vary depending on whether the request uses parameters, requires a request body, needs specific headers, and many other factors\. The following procedure creates an API that has one function: performing searches on an Amazon CloudSearch domain\. For more complete information about configuring APIs, see [Creating an API in Amazon API Gateway](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-create-api.html)\.

**To create an API \(console\)**

1. Go to [https://aws\.amazon\.com](https://aws.amazon.com), and then choose **Sign In to the Console**\.

1. Under **Networking & Content Delivery**, choose **API Gateway**\.

1. Choose **Create API**\.

   Alternatively, choose **Get Started** if this is your first time using API Gateway\.

1. Choose **New API**, name the API, type an optional description, choose an **Endpoint Type** of **Regional**, and then choose **Create API**\.

1. Choose **Actions**, and then choose **Create Method**\. From the dropdown menu, choose **GET** and confirm\.

1. For **Integration type**, choose **AWS Service**\.

1. For **AWS Region**, choose the region in which your Amazon CloudSearch domain resides\.

1. For **AWS Service**, choose **CloudSearch**\.

1. For **AWS Subdomain**, specify the subdomain for your Amazon CloudSearch domain's search endpoint\.

   For example, if your domain's search endpoint is `search-my-test-asdf5asdfasdfasdfasd5asdfg.us-west-1.cloudsearch.amazonaws.com`, specify `search-my-test-asdf5ambgebbgmmodhhq5asdfg`\.

1. For **HTTP Method**, choose **GET**\.

1. For **Action Type**, choose **Use path override** and specify `/2013-01-01/search`\.

1. For **Execution role**, specify the ARN for `my-api-gateway-role`, such as `arn:aws:iam::123456789012:role/my-api-gateway-role`\.

1. For **Content Handling**, choose **Passthrough**, use the default timeout, and then choose **Save**\.

1. Select the new method, and then choose **Method Request**\.

1. For **URL Query String Parameters**, choose **Add query string**, name the string `q`, mark it as required, and then confirm\.

1. For **Request Validator**, choose **Validate query string parameters and headers**, and then confirm\.

1. Choose **Method Execution** to return to the method summary\.

1. Choose **Integration Request**\.

1. For **URL Query String Parameters**, choose **Add query string**, name the string `q`, provide a mapping of `method.request.querystring.q`, and then confirm\.

## Testing the API \(Console\)<a name="api-gateway-test"></a>

At this point, you've created an API that has one method\. Before deploying the API, you should test it\.

**To test the API \(console\)**

1. Navigate to the **Method Execution** page\.

1. Choose **Test**\.

1. For the **q** field, enter a query string that will match some data in the Amazon CloudSearch domain\. If you are using the IMDb movie data, try `thor`\.

1. Choose **Test**\.

1. Verify that the response body contains search results, such as the following:

   ```
   {
     "status": {
       "rid": "rcWTo8IsviEK+own",
       "time-ms": 1
     },
     "hits": {
       "found": 7,
       "start": 0,
       "hit": [
         {
           "id": "tt0800369",
           "fields": {
             "rating": "7.0",
             "genres": [
               "Action",
               "Adventure",
               "Fantasy"
             ],
             "title": "Thor",
             "release_date": "2011-04-21T00:00:00Z",
             "plot": "The powerful but arrogant god Thor is cast out of Asgard to live amongst humans in Midgard (Earth), where he soon becomes one of their finest defenders.",
             "rank": "135",
             "running_time_secs": "6900",
             "directors": [
               "Kenneth Branagh",
               "Joss Whedon"
             ],
             "image_url": "http://ia.media-imdb.com/images/M/MV5BMTYxMjA5NDMzNV5BMl5BanBnXkFtZTcwOTk2Mjk3NA@@._V1_SX400_.jpg",
             "year": "2011",
             "actors": [
               "Chris Hemsworth",
               "Anthony Hopkins",
               "Natalie Portman"
             ]
           }
         },
         ...
       ]
     }
   }
   ```

At this point, you have a functional API\. You can add methods to enable more robust search requests, deploy the API and configure rate limiting, create and require the use of API keys, add Amazon Cognito user pool authentication, and much more\. For more information, see the [API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/)\.