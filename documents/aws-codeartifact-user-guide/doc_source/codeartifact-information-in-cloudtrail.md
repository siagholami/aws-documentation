# Logging CodeArtifact API calls with AWS CloudTrail<a name="codeartifact-information-in-cloudtrail"></a>

CodeArtifact is integrated with [AWS CloudTrail](https://aws.amazon.com/cloudtrail), a service that provides a record of actions taken by a user, role, or an AWS service in CodeArtifact\. CloudTrail captures all API calls for CodeArtifact as events, including calls from the ** `npm` ** client\.

If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon Simple Storage Service \(Amazon S3\) bucket, including events for CodeArtifact\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to CodeArtifact, the IP address from which the request was made, who made the request, when it was made, and additional details\.

To learn more about CloudTrail, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-user-guide.html)\.

## CodeArtifact information in CloudTrail<a name="codeartifact-information-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When activity occurs in CodeArtifact, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\.

For an ongoing record of events in your AWS account, including events for CodeArtifact, create a *trail*\. A trail enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all AWS Regions\. The trail logs events from all Regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. You can also configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see the following topics:
+  [Creating a Trail for Your AWS Account](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html) 
+  [CloudTrail Supported Services and Integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html) 
+  [Configuring Amazon SNS Notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/configure-sns-notifications-for-cloudtrail.html) 

When CloudTrail logging is enabled in your AWS account, API calls made to CodeArtifact actions are tracked in CloudTrail log files, where they are written with other AWS service records\. CloudTrail determines when to create and write to a new file based on a time period and file size\.

All CodeArtifact actions are logged by CloudTrail\. For example, calls to the `ListRepositories` \(in the AWS CLI, `aws codeartifact list-repositories`\), `CreateRepository` \(`aws codeartifact create-repository`\), and `ListPackages` \(`aws codeartifact list-packages`\) actions generate entries in the CloudTrail log files, in addition to `npm` client commands such as `npm install` and `npm publish`\. `npm` client commands typically make more than one HTTP request to the server\. Each request generates a separate CloudTrail log event\.

### Cross\-account delivery of CloudTrail logs<a name="codeartifact-cloudtrail-event-delivery"></a>

Up to three separate accounts receive CloudTrail logs for a single API call:
+ The account that made the request—for example, the account that called `GetAuthorizationToken`\.
+ The repository administrator account—for example, the account that administers the repository that `ListPackages` was called on\.
+ The domain owner's account—for example, the account that owns the domain that contains the repository that an API was called on\.

For APIs like `ListRepositoriesInDomain` that are actions against a domain and not a specific repository, only the calling account and the domain owner's account receive the CloudTrail log\. For APIs like `ListRepositories` that are not authorized against any resource, only the account of the caller receives the CloudTrail log\.

## Understanding CodeArtifact log file entries<a name="understanding-codeartifact-log-file-entries"></a>

CloudTrail log files can contain one or more log entries\. Each entry lists multiple JSON\-formatted events\. A log event represents a single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. Log entries are not an ordered stack trace of the public API calls, so they do not appear in any specific order\.

**Topics**
+ [Example: A log entry for calling the GetAuthorizationToken API](#example-a-log-entry-for-calling-the-getauthorizationtoken-api)
+ [Example: A log entry for fetching an npm package version](#example-a-log-entry-for-fetching-an-npm-package-version)

### Example: A log entry for calling the GetAuthorizationToken API<a name="example-a-log-entry-for-calling-the-getauthorizationtoken-api"></a>

 A log entry created by `[GetAuthorizationToken](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_GetAuthorizationToken.html)` includes the domain name in the `requestParameters` field\. 

```
{
  "eventVersion": "1.05",
  "userIdentity": {
      "type": "AssumedRole",
      "principalId": "AIDACKCEVSQ6C2EXAMPLE",
      "arn": "arn:aws:sts::123456789012:assumed-role/Console/example",
      "accountId": "123456789012",
      "accessKeyId": "AKIAIOSFODNN7EXAMPLE",
      "sessionContext": {
          "attributes": {
              "mfaAuthenticated": "false",
              "creationDate": "2018-12-11T13:31:37Z"
          },
          "sessionIssuer": {
              "type": "Role",
              "principalId": "AIDACKCEVSQ6C2EXAMPLE",
              "arn": "arn:aws:iam::123456789012:role/Console",
              "accountId": "123456789012",
              "userName": "Console"
          }
      }
  },
  "eventTime": "2018-12-11T13:31:37Z",
  "eventSource": "codeartifact.amazonaws.com",
  "eventName": "GetAuthorizationToken",
  "awsRegion": "us-west-2",
  "sourceIPAddress": "205.251.233.50",
  "userAgent": "aws-cli/1.16.37 Python/2.7.10 Darwin/16.7.0 botocore/1.12.27",
  "requestParameters": {
      "domainName": "example-domain"
      "domainOwner": "123456789012"
  },
  "responseElements": {
      "sessionToken": "HIDDEN_DUE_TO_SECURITY_REASONS"
  },
  "requestID": "6b342fc0-5bc8-402b-a7f1-ffffffffffff",
  "eventID": "100fde01-32b8-4c2b-8379-ffffffffffff",
  "readOnly": false,
  "eventType": "AwsApiCall",
  "recipientAccountId": "123456789012"
}
```

### Example: A log entry for fetching an npm package version<a name="example-a-log-entry-for-fetching-an-npm-package-version"></a>

Requests made by the ** `npm` ** client have additional data logged including the domain name, repository name, and package name in the `requestParameters` field\. The URL path and HTTP method are logged in the `additionalEventData` field\.

```
{
   "eventVersion": "1.05",
   "userIdentity": {
       "type": "AssumedRole",
       "principalId": "AIDACKCEVSQ6C2EXAMPLE",
       "arn": "arn:aws:sts::123456789012:assumed-role/Console/example",
       "accountId": "123456789012",
       "accessKeyId": "ASIAIJIOBJIBSREXAMPLE",
       "sessionContext": {
           "attributes": {
               "mfaAuthenticated": "false",
               "creationDate": "2018-12-17T02:05:16Z"
           },
           "sessionIssuer": {
               "type": "Role",
               "principalId": "AIDACKCEVSQ6C2EXAMPLE",
               "arn": "arn:aws:iam::123456789012:role/Console",
               "accountId": "123456789012",
               "userName": "Console"
           }
       }
   },
   "eventTime": "2018-12-17T02:05:46Z",
   "eventSource": "codeartifact.amazonaws.com",
   "eventName": "ReadFromRepository",
   "awsRegion": "us-west-2",
   "sourceIPAddress": "205.251.233.50",
   "userAgent": "AWS Internal",
   "requestParameters": {
       "domainName": "example-domain",
       "domainOwner": "123456789012",
       "repositoryName": "example-repo",
       "packageName": "lodash",
       "packageFormat": "npm",
       "packageVersion": "4.17.11"
   },
   "responseElements": null,
   "additionalEventData": {
       "httpMethod": "GET",
       "requestUri": "/npm/lodash/-/lodash-4.17.11.tgz"
   },
   "requestID": "9f74b4f5-3607-4bb4-9229-ffffffffffff",
   "eventID": "c74e40dd-8847-4058-a14d-ffffffffffff",
   "readOnly": true,
   "eventType": "AwsApiCall",
   "recipientAccountId": "123456789012"
}
```