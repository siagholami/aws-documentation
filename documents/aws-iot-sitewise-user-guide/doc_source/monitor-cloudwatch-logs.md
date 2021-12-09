# Monitoring AWS IoT SiteWise with Amazon CloudWatch Logs<a name="monitor-cloudwatch-logs"></a>

You can configure AWS IoT SiteWise to log information to CloudWatch Logs to monitor and troubleshoot the service\.

When you use the AWS IoT SiteWise console, AWS IoT SiteWise creates a service\-linked role that allows the service to log information on your behalf\. If you don't use the AWS IoT SiteWise console, you must create a service\-linked role manually to receive logs\. For more information, see [Creating a service\-linked role for AWS IoT SiteWise](using-service-linked-roles.md#create-service-linked-role)\.

By default, AWS IoT SiteWise doesn't log information to CloudWatch Logs\. To enable logging, choose a logging level other than **Disabled** \(`OFF`\)\. AWS IoT SiteWise supports the following logging levels:
+ `OFF` – Logging is disabled\.
+ `ERROR` – Errors are logged\.
+ `INFO` – Errors and informational messages are logged\.

You can also configure gateways to log information to CloudWatch Logs through AWS IoT Greengrass\. For more information, see [Monitoring gateway logs](monitor-gateway-logs.md)\.

You can also configure AWS IoT Core to log information to CloudWatch Logs if you are troubleshooting an AWS IoT SiteWise rule action\. For more information, see [Troubleshooting an AWS IoT SiteWise rule action](troubleshoot-rule.md)\.

**Contents**
+ [Managing logging in AWS IoT SiteWise \(console\)](#manage-cloudwatch-logs-console)
  + [Finding your logging level \(console\)](#find-logging-level-console)
  + [Changing your logging level \(console\)](#change-logging-level-console)
+ [Managing logging in AWS IoT SiteWise \(CLI\)](#manage-cloudwatch-logs-cli)
  + [Finding your logging level \(CLI\)](#find-logging-level-cli)
  + [Changing your logging level \(CLI\)](#change-logging-level-cli)
+ [Example: AWS IoT SiteWise log file entries](#sitewise-log-format)

## Managing logging in AWS IoT SiteWise \(console\)<a name="manage-cloudwatch-logs-console"></a>

You can use the AWS IoT SiteWise console for the following logging configuration tasks\.

**Topics**
+ [Finding your logging level \(console\)](#find-logging-level-console)
+ [Changing your logging level \(console\)](#change-logging-level-console)

### Finding your logging level \(console\)<a name="find-logging-level-console"></a>

Use the following procedure to find your current logging level in the AWS IoT SiteWise console\.

**To find your current AWS IoT SiteWise logging level**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Logging options**\.

   The current logging status appears under **Logging status**\. If logging is enabled, the current logging level appears under **Level of verbosity**\.

### Changing your logging level \(console\)<a name="change-logging-level-console"></a>

Use the following procedure to change your logging level in the AWS IoT SiteWise console\.

**To change your AWS IoT SiteWise logging level**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Logging options**\.

1. Choose **Edit**\.

1. Choose the **Level of verbosity** to enable\.

1. Choose **Save**\.

## Managing logging in AWS IoT SiteWise \(CLI\)<a name="manage-cloudwatch-logs-cli"></a>

You can use the AWS Command Line Interface \(AWS CLI\) for the following logging configuration tasks\.

**Topics**
+ [Finding your logging level \(CLI\)](#find-logging-level-cli)
+ [Changing your logging level \(CLI\)](#change-logging-level-cli)

### Finding your logging level \(CLI\)<a name="find-logging-level-cli"></a>

Run the following command to find your current AWS IoT SiteWise logging level with the AWS CLI\.

```
aws iotsitewise describe-logging-options
```

The operation returns a response that contains your logging level in the following format\.

```
{
  "loggingOptions": {
    "level": "String"
  }
}
```

### Changing your logging level \(CLI\)<a name="change-logging-level-cli"></a>

Run the following AWS CLI command to change your AWS IoT SiteWise logging level\. Replace *logging\-level* with the logging level you want\.

```
aws iotsitewise put-logging-options --logging-options level=logging-level
```

## Example: AWS IoT SiteWise log file entries<a name="sitewise-log-format"></a>

Each AWS IoT SiteWise log entry includes event information and relevant resources for that event, so you can easily understand and analyze log data\.

The following example shows a CloudWatch Logs entry that AWS IoT SiteWise logs when you successfully create an asset model\.

```
{
  "eventTime": "2020-05-05T00:10:22.902Z",
  "logLevel": "INFO",
  "eventType": "AssetModelCreationSuccess",
  "message": "Successfully created asset model.",
  "resources": {
    "assetModelId": "a1b2c3d4-5678-90ab-cdef-11111EXAMPLE"
  }
}
```