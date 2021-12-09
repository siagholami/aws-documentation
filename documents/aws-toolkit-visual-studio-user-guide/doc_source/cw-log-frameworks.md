# Tutorial: Using Amazon Logging Frameworks with AWS Lambda to Create Application Logs<a name="cw-log-frameworks"></a>

You can use Amazon CloudWatch Logs to monitor, store, and access your application’s logs\. To get log data into CloudWatch Logs, you can use an AWS SDK or install the CloudWatch Logs agent to monitor certain log folders\. Today, we’ve made it even easier to use CloudWatch Logs with \.NET applications by integrating CloudWatch Logs with several popular \.NET logging frameworks\.

The supported \.NET logging frameworks are [NLog](https://www.nuget.org/packages/AWS.Logger.NLog), [Log4net](https://www.nuget.org/packages/AWS.Logger.Log4net/), and the new built\-in [ASP\.NET Core logging Framework](https://www.nuget.org/packages/AWS.Logger.AspNetCore/)\. For each framework, all you need to do is add the appropriate NuGet package, add CloudWatch Logs as an output source, and then use your logging library as you normally would\.

For example to use CloudWatch Logs with a \.NET application using NLog, add the `AWS.Logger.NLog` NuGet package, and then add the AWS target into your `NLog.config` file\. Here is an example of an `NLog.config` file that enables both CloudWatch Logs and the console as output for the log messages\.

```
<?xml version="1.0" encoding="utf-8" ?>
<nlog xmlns="http://www.nlog-project.org/schemas/NLog.xsd"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      throwExceptions="true">
  <targets>
    <target name="aws" type="AWSTarget" logGroup="NLog.ConfigExample" region="us-east-1"/>
    <target name="logfile" xsi:type="Console" layout="${callsite} ${message}" />
  </targets>
  <rules>
    <logger name="*" minlevel="Info" writeTo="logfile,aws" />
  </rules>
</nlog>
```

After performing these steps, when you run your application the log messages written with NLog are sent to CloudWatch Logs\. Then you can view your application’s log messages in near real time from the CloudWatch Logs console\. You can also set up metrics and alarms from the CloudWatch Logs console, based on your application’s log messages\.

These logging plugins are all built on top of the AWS SDK for \.NET, and use the same behavior used by the SDK to find AWS credentials\. The credentials used by the logging plugins must have the following permissions to access CloudWatch Logs\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "logs:CreateLogGroup",
        "logs:CreateLogStream",
        "logs:PutLogEvents",
        "logs:DescribeLogGroups"
      ],
      "Resource": [
        "arn:aws:logs:*:*:*"
      ]
    }
  ]
}
```

The AWS \.NET logging plugins are a new open source project on [GitHub](https://github.com/aws/aws-logging-dotnet)\. All of the plugins are there, including [samples](https://github.com/aws/aws-logging-dotnet/tree/master/samples) and [instructions](https://github.com/aws/aws-logging-dotnet/blob/master/README.md) on how to configure CloudWatch Logs for each of the supported \.NET logging frameworks\.