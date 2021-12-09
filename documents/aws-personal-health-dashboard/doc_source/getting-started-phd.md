# Getting started with the AWS Personal Health Dashboard<a name="getting-started-phd"></a>

You can use the AWS Personal Health Dashboard to learn about AWS Health events that can affect your AWS services or account\. The Personal Health Dashboard presents information in two ways: a dashboard that shows recent and upcoming events organized by category, and a full event log that shows all events from the past 90 days\.

**To view your Personal Health Dashboard**

1. Sign in to the AWS Management Console and open the Personal Health Dashboard at [https://phd.aws.amazon.com/phd/home](https://phd.aws.amazon.com/phd/home)\. 

1. Choose **Dashboard** to view recent and upcoming events or **Event log** to view all events for the past 90 days\.

**Topics**
+ [Dashboard](#dashboard)
+ [Event log](#event-log)
+ [Integrations](#service-integrations)
+ [Alerts for AWS Health events](#alert-bell)

## Dashboard<a name="dashboard"></a>

The Personal Health Dashboard organizes issues in three groups: open issues, scheduled changes, and other notifications\. By default, open issues and other notifications are restricted to issues whose start time is within the last seven days\. The scheduled changes group contains items that are ongoing or upcoming\.

When you select an event in the dashboard list, the **Event Details** pane appears with information about the event and resources that are affected by the event\. For more information, see [Event details pane](#event-details)\.

You can filter the items that appear in any group by choosing options from the filter list\. For example, you can narrow the results by Availability Zone, Region, event end time or last update time, AWS service, and so on\.

To see all the events that apply to your account, rather than the recent ones that appear in the dashboard, choose **See all issues** above the list to display the [Event log](#event-log)\.

**Note**  
Currently, you can’t delete notifications for events that appear in the Personal Health Dashboard\. After an AWS service resolves an event, the notification is removed from your dashboard view\.

## Event log<a name="event-log"></a>

The **Event log** page of the Personal Health Dashboard displays all the AWS Health events that apply to your account\. The column layout and behavior is similar to the Dashboard, but the log page includes additional columns and filter options for **Status** and **Event category**\.

When you select an event in the **Event log** list, the **Event details** pane appears with information about the event and resources that are affected by the event\. For more information, see [Event details pane](#event-details)\.

You can filter the items by choosing options from the filter list\. For example, you can narrow the results by status \(closed, open, or upcoming\), event category \(issue, notification, or scheduled change\), Availability Zone, Region, event end time or last update time, AWS service, and so on\.

### Events types<a name="types-of-events"></a>

There are two types of AWS Health events:
+ *Public events* are service events that aren't specific to an AWS account\. For example, if there is an issue with Amazon Elastic Compute Cloud \(Amazon EC2\) in an AWS Region, AWS Health provides information about the event, even if you don't use services or resources in that Region\. 
+ *Account\-specific* events are specific to your AWS account or an account in your organization\. For example, if there's an issue with an Amazon EC2 instance in a Region that you use, AWS Health provides information about the event and the affected resources in the account\.

Use the following options to identify if an event is public or account\-specific:
+ In the Personal Health Dashboard, choose the **Affected resources** tab on the **Event log** page\. Events with resources are specific to your account\. Events without resources are public and are not specific to your account\. 
+ Use the AWS Health API to return the `eventScopeCode` parameter\. Events can have the `PUBLIC`, `ACCOUNT_SPECIFIC`, or `NONE` value\. For more information, see the [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) operation in the *AWS Health API Reference*\. 

### Event details pane<a name="event-details"></a>

The **Event details** pane has two tabs\. The **Details** tab displays a text description of the event and relevant data about the event: the event name, status, Region and Availability Zone, start time, end time, and category\. The **Affected resources** tab displays information about any AWS resources that are affected by the event: 
+ The resource ID \(for example, an Amazon EBS volume ID such as `vol-a1b2c34f`\) or Amazon Resource Name \(ARN\), if available or relevant\.

You can filter the items that appear in the resources list by choosing options from the filter list\. You can narrow the results by resource ID or ARN\.

## Integrations<a name="service-integrations"></a>

In the navigation page, the **Integrations** section lists services that you can enable with AWS Health\. AWS Health integrates with the following services\.

### AWS Organizations<a name="aws-organizations-integration"></a>

You can view AWS Health events for all accounts that are part of your organization\. This provides you a centralized view for events that appear in your organization\. You can use these events to monitor for changes in your resources, services, and applications\.

![\[Screenshot of the Organizational View API page in the AWS Health console.\]](http://docs.aws.amazon.com/health/latest/ug/images/organizational-view-aws-health-console.png)

For more information, see [Aggregating AWS Health events across accounts with organizational view](aggregate-events.md)\.

### Amazon CloudWatch Events<a name="cloud-watch-events-integration"></a>

Use Amazon CloudWatch Events to detect and react to changes for AWS Health events\. You can monitor specific AWS Health events that occur in your AWS account and then set up rules so that you get notified or take action when events change\.

You can choose **Set up CloudWatch Events** to navigate to the CloudWatch Events console\. For more information, see [Monitor for AWS Health events with Amazon CloudWatch Events](cloudwatch-events-health.md)\.

## Alerts for AWS Health events<a name="alert-bell"></a>

The Personal Health Dashboard has a bell icon in the console navigation bar with an **Alerts** menu\. This feature displays the number of recent AWS Health events that appear on the dashboard in each category\. This bell icon appears on several AWS consoles, such as Amazon Elastic Compute Cloud \(Amazon EC2\), Amazon Relational Database Service \(Amazon RDS\), AWS Identity and Access Management \(IAM\), and AWS Trusted Advisor\. 

Choose the bell icon to see whether your account is affected by recent events\. You can then choose an event to navigate to the Personal Health Dashboard for more information\.