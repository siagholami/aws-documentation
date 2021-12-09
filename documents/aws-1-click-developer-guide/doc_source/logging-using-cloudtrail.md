# Logging AWS IoT 1\-Click API Calls with AWS CloudTrail<a name="logging-using-cloudtrail"></a>

AWS IoT 1\-Click is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in AWS IoT 1\-Click\. CloudTrail captures API calls for AWS IoT 1\-Click as events\. The calls captured include calls from the AWS IoT 1\-Click console and code calls to the AWS IoT 1\-Click API operations\. If you create a trail, you can enable continuous delivery of CloudTrail events to an Amazon S3 bucket, including events for AWS IoT 1\-Click\. If you don't configure a trail, you can still view the most recent events in the CloudTrail console in **Event history**\. Using the information collected by CloudTrail, you can determine the request that was made to AWS IoT 1\-Click, the IP address from which the request was made, who made the request, when it was made, and additional details\. 

To learn more about CloudTrail, including how to configure and enable it, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

## AWS IoT 1\-Click Information in CloudTrail<a name="service-name-info-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When supported event activity occurs in AWS IoT 1\-Click, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\. 

For an ongoing record of events in your AWS account, including events for AWS IoT 1\-Click, create a trail\. A *trail* enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all AWS Regions\. The trail logs events from all Regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see the following: 
+ [Overview for Creating a Trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail Supported Services and Integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS Notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail Log Files from Multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail Log Files from Multiple Accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

The AWS IoT 1\-Click [Devices API](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/) supports logging the following actions as events in CloudTrail log files:
+ [ListDevices](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/devices.html)
+ [DescribeDevice](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/devices-deviceid.html)
+ [GetDeviceMethods](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/devices-deviceid-methods.html)
+ [UpdateDeviceState](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/devices-deviceid-state.html)
+ [InvokeDeviceMethod](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/devices-deviceid-methods.html#devices-deviceid-methodspost)

The AWS IoT 1\-Click [Projects API](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/) supports logging the following actions as events in CloudTrail log files:
+ [CreateProject](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_CreateProject.html)
+ [UpdateProject](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_UpdateProject.html)
+ [DescribeProject](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_DescribeProject.html)
+ [ListProjects](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_ListProjects.html)
+ [DeleteProject](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_DeleteProject.html)
+ [CreatePlacement](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_CreatePlacement.html)
+ [UpdatePlacement](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_UpdatePlacement.html)
+ [DescribePlacement](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_DescribePlacement.html)
+ [ListPlacements](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_ListPlacements.html)
+ [DeletePlacement](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_DeletePlacement.html)
+ [AssociateDeviceWithPlacement](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_AssociateDeviceWithPlacement.html)
+ [DisassociateDeviceFromPlacement](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_DisassociateDeviceFromPlacement.html)
+ [GetDevicesInPlacement](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_GetDevicesInPlacement.html)

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following: 
+ Whether the request was made with root or AWS Identity and Access Management \(IAM\) user credentials\.
+ Whether the request was made with temporary security credentials for a role or federated user\.
+ Whether the request was made by another AWS service\.

For more information, see the [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.

## Example: AWS IoT 1\-Click Log File Entries<a name="understanding-service-name-entries"></a>

 A trail is a configuration that enables delivery of events as log files to an Amazon S3 bucket that you specify\. CloudTrail log files contain one or more log entries\. An event represents a single request from any source and includes information about the requested action, the date and time of the action, request parameters, and so on\. CloudTrail log files aren't an ordered stack trace of the public API calls, so they don't appear in any specific order\.

The following example shows a CloudTrail log entry that demonstrates the `DescribeDevice` action\.

```
{
    "eventVersion": "1.05",
    "userIdentity": {
        "type": "IAMUser",
        "principalId": "EX_PRINCIPAL_ID",
        "arn": "arn:aws:iam::012345678910:user/Alice",
        "accountId": "012345678910",
        "accessKeyId": "EXAMPLE_KEY_ID",
        "userName": "Alice"
    },
    "eventTime": "2018-04-12T18:57:27Z",
    "eventSource": "iot1click.amazonaws.com",
    "eventName": "DescribeDevice",
    "awsRegion": "us-west-2",
    "sourceIPAddress": "127.0.0.1",
    "userAgent": "console.aws.amazon.com",
    "requestParameters": {
        "deviceId": "G030PM12345678"
    },
    "responseElements": null,
    "requestID": "573c5654-3e83-11e8-9eac-c999bd01134e",
    "eventID": "be323b62-082a-4352-929d-085d2a3249b0",
    "readOnly": true,
    "eventType": "AwsApiCall",
    "recipientAccountId": "012345678910"
}
```

The following example shows a CloudTrail log entry that demonstrates the `CreateProject` action\.

```
{
    "eventVersion": "1.05",
    "userIdentity": {
        "type": "IAMUser",
        "principalId": "EX_PRINCIPAL_ID",
        "arn": "arn:aws:iam::012345678910:user/Alice",
        "accountId": "012345678910",
        "accessKeyId": "EXAMPLE_KEY_ID",
        "userName": "Alice"
    },
    "eventTime": "2018-04-12T20:31:02Z",
    "eventSource": "iot1click.amazonaws.com",
    "eventName": "CreateProject",
    "awsRegion": "us-west-2",
    "sourceIPAddress": "127.0.0.1",
    "userAgent": "console.aws.amazon.com",
    "requestParameters": {
        "description": "",
        "placementTemplate": {
            "defaultAttributes": "***",
            "deviceTemplates": {
                "happyId": {
                    "deviceType": "button",
                    "callbackOverrides": {
                        "onClickCallback": "arn:aws:lambda:us-west-2:012345678910:function:rating_buttons_happy"
                    }
                },
                "sadId": {
                    "deviceType": "button",
                    "callbackOverrides": {
                        "onClickCallback": "arn:aws:lambda:us-west-2:012345678910:function:rating_buttons_sad"
                    }
                }
            }
        }
    }
}
```