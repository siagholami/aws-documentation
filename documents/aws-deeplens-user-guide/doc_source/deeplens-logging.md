# AWS DeepLens Project Logs<a name="deeplens-logging"></a>

When you create a new project, AWS DeepLens automatically configures [AWS IoT Greengrass Logs](https://docs.aws.amazon.com/greengrass/latest/developerguide/greengrass-logs-overview.html)\. AWS IoT Greengrass Logs writes logs to [Amazon CloudWatch Logs](https://docs.aws.amazon.com/greengrass/latest/developerguide/greengrass-logs-overview.html#gg-logs-cloudwatch) and to the local file system of your device\. When a project is running, AWS DeepLens sends diagnostic messages to CloudWatch Logs as AWS IoT Greengrass log streams and to your AWS DeepLens device as local [file system logs](https://docs.aws.amazon.com/greengrass/latest/developerguide/greengrass-logs-overview.html#gg-logs-local)\. The messages sent to CloudWatch Logs and your local file system logs are identical, except that the crash\.log file is available only in file system logs\. 

**Topics**
+ [CloudWatch Logs Log Groups for AWS DeepLens](#deeplens-logging-cwl)
+ [File System Logs for AWS DeepLens](#deeplens-logging-fs)

## CloudWatch Logs Log Groups for AWS DeepLens<a name="deeplens-logging-cwl"></a>

CloudWatch Logs log events for AWS DeepLens are organized into the following log groups\.


****  

| Log Group | Contents | 
| --- | --- | 
|  aws/greengrass/GreengrassSystem/certmanager  |  Diagnostic logs for certificate management  | 
|  aws/greengrass/GreengrassSystem/connection\_manager  |  Diagnostic logs for device connection management, including Lambda function configuration  | 
|  aws/greengrass/GreengrassSystem/ip\_detector  |  Diagnostic logs for IP address detection  | 
|  aws/greengrass/GreengrassSystem/python\_runtime  |  Diagnostic logs related to the Python runtime  | 
|  aws/greengrass/GreengrassSystem/router  |  Diagnostic logs that are created when the results of inference are forwarded to AWS IoT  | 
|  aws/greengrass/GreengrassSystem/runtime  |  Diagnostic logs related to the AWS IoT Greengrass runtime, for example, for \(Message Queuing Telemetry Transport \(MQTT\) event subscription  | 
|  aws/greengrass/GreengrassSystem/spectre  |  Diagnostic logs related to the local shadow of AWS IoT  | 
|  aws/greengrass/GreengrassSystem/syncmanager  |  Diagnostic logs for the device's AWS IoT topic subscription  | 
|  aws/greengrass/GreengrassSystem/tes  |  Diagnostic logs related to provisioning IAM credentials for calling a Lambda function  | 
|  aws/greengrass/Lambda/*lambda\_function\_name*  |  Diagnostic logs reported by the specified Lambda inference function of your AWS DeepLens project  | 

For more information about CloudWatch Logs, including access role and permissions requirements and limitations, see [ CloudWatch Logs](https://docs.aws.amazon.com/greengrass/latest/developerguide/greengrass-logs-overview.html#gg-logs-cloudwatch) in the *AWS IoT Greengrass Developer Guide*\.

## File System Logs for AWS DeepLens<a name="deeplens-logging-fs"></a>

AWS IoT Greengrass Logs for AWS DeepLens are also stored in the local file system on your AWS DeepLens device\. The local file system logs include the crash log, which is not available in CloudWatch Logs\.

You can find the local file system logs in the following directories on your AWS DeepLens device\.


****  

| Log Directory | Description | 
| --- | --- | 
|  `/opt/awscam/greengrass/ggc/var/log`  |  The top\-level directory for the AWS IoT Greengrass logs for AWS DeepLens\. The crash logs are in the crash\.log file in this directory\.  | 
|  `/opt/awscam/greengrass/ggc/var/log/system`  |  The subdirectory that contains the AWS IoT Greengrass system component logs\.  | 
|  `/opt/awscam/greengrass/ggc/var/log/user`  |  The subdirectory that contains logs for user\-defined Lambda inference functions\.  | 

For more information about AWS IoT Greengrass file system logs for AWS DeepLens, including access requirements, see [File System Logs](https://docs.aws.amazon.com/greengrass/latest/developerguide/greengrass-logs-overview.html#gg-logs-local) in the *AWS IoT Greengrass Developer Guide*\.