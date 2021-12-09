# Logging CodeGuru Reviewer API calls with AWS CloudTrail<a name="logging-using-cloudtrail"></a>

Amazon CodeGuru Reviewer is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in CodeGuru Reviewer\. CloudTrail captures API calls for CodeGuru Reviewer as events\. The calls captured include calls from the CodeGuru Reviewer console, the CodeGuru Reviewer AWS CLI, and code calls to the CodeGuru Reviewer API operations\. 

If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon S3 bucket, including events for CodeGuru Reviewer\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to CodeGuru Reviewer, the IP address from which the request was made, who made the request, when it was made, and additional details\. 

To learn more about CloudTrail, including how to configure and enable it, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

## CodeGuru Reviewer information in CloudTrail<a name="codeguru-reviewer-info-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When supported event activity occurs in CodeGuru Reviewer, that activity is recorded in a CloudTrail event with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing events with CloudTrail event history](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\. 

For an ongoing record of events in your AWS account, including events for CodeGuru Reviewer, create a trail\. A trail enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all AWS Regions\. The trail logs events from all Regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act on the event data collected in CloudTrail logs\. For more information, see the following: 
+ [Overview for creating a trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail supported services and integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail log files from multiple regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail log files from multiple accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

CodeGuru Reviewer supports logging the following actions as events in CloudTrail log files:
+ [AssociateRepository](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_AssociateRepository.html)
+ [DescribeCodeReview](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_DescribeCodeReview.html)
+ [DescribeRecommendationFeedback](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_DescribeRecommendationFeedback.html)
+ [DescribeRepositoryAssociation](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_DescribeRepositoryAssociation.html)
+ [DisassociateRepository](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_DisassociateRepository.html)
+ [ListCodeReviews](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListCodeReviews.html)
+ [ListRecommendationFeedback](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListRecommendationFeedback.html)
+ [ListRecommendations](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListRecommendations.html)
+ [ListRepositoryAssociations](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_ListRepositoryAssociations.html)
+ [PutRecommendationFeedback](https://docs.aws.amazon.com/codeguru/latest/reviewer-api/API_PutRecommendationFeedback.html)

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following: 
+ Whether the request was made with root or AWS Identity and Access Management \(IAM\) user credentials
+ Whether the request was made with temporary security credentials for a role or federated user
+ Whether the request was made by another AWS service

For more information, see the [CloudTrail userIdentity element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

## Example: CodeGuru Reviewer log file entries<a name="understanding-codeguru-reviewer-entries"></a>

 A trail is a configuration that enables delivery of events as log files to an Amazon S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents a single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. CloudTrail log files aren't an ordered stack trace of the public API calls, so they don't appear in any specific order\.

The following example shows a CloudTrail log entry that demonstrates the `AssociateRepository` action\.

```
{
    "eventVersion": "1.05",
    "userIdentity": {
        "type": "AssumedRole",
        "principalId": "AAAAAAAAAEXAMPLE:TestSession",
        "arn": "arn:aws:sts::123456789012:assumed-role/TestRole/TestSession",
        "accountId": "123456789012",
        "accessKeyId": "AKIAIOSFODNN7EXAMPLE",
        "sessionContext": {
            "attributes": {
                "mfaAuthenticated": "false",
                "creationDate": "2019-11-27T02:06:30Z"
            },
            "sessionIssuer": {
                "type": "Role",
                "principalId": "AIDACKCEVSQ6C2EXAMPLE",
                "arn": "arn:aws:iam::123456789012:role/TestRole",
                "accountId": "123456789012",
                "userName": "TestRole"
            }
        }
    },
    "eventTime": "2019-11-27T03:46:35Z",
    "eventSource": "codeguru-reviewer.amazonaws.com",
    "eventName": "AssociateRepository",
    "awsRegion": "us-west-2",
    "sourceIPAddress": "52.13.164.128",
    "userAgent": "aws-internal/3 aws-sdk-java/1.11.672 Linux/4.14.138-99.102.amzn2.x86_64 OpenJDK_64-Bit_Server_VM/25.201-b09 java/1.8.0_201 vendor/Oracle_Corporation exec-env/AWS_Lambda_java8",
    "requestParameters": {
        "ClientRequestToken": "7485aa2f-ce15-4bc6-a6cc-2a76d702f15f",
        "Repository": {
            "CodeCommit": {
                "Name": "repository-name"
            }
        }
    },
    "responseElements": {
        "RepositoryAssociation": {
            "AssociationArn": "arn:aws:codeguru-reviewer:us-west-2:123456789012:association:6eda8e7a-319a-4750-bca8-7f73a816fadc",
            "AssociationId": "6eda8e7a-319a-4750-bca8-7f73a816fadc",
            "CreatedTimeStamp": 1574826395.662,
            "LastUpdatedTimeStamp": 1574826395.662,
            "Name": "TestRepository",
            "Owner": "123456789012",
            "ProviderType": "CodeCommit",
            "State": "Associating",
            "StateReason": "Pending Repository Association"
        }
    },
    "requestID": "cb8c167e-EXAMPLE",
    "eventID": "e3c6f4ce-EXAMPLE",
    "readOnly": false,
    "eventType": "AwsApiCall",
    "recipientAccountId": "123456789012"
}
```