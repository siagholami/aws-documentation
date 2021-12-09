# Maintaining the Gateway<a name="maintain-gateway"></a>

By default, the gateway automatically updates every day during predefined maintenance windows\. These windows are defined in the gateway\.cfg file that the gateway accesses at startup\. To change these maintenance windows, edit the gateway\.cfg file and restart the gateway service\. To manually update the gateway, run the updater binary installed with the gateway as the administrator \(for Windows\) or as the root \(for Linux\)\.

If your Cisco TelePresence or AWS credentials change, use the following steps to update your Alexa for Business gateways to use the new credentials\.

**To update Cisco TelePresence Credentials for Windows**

1. Stop the **AlexaForBusinessGateway** service\.

1. Choose **Start** and type **Command Prompt**\.

1. From the search results, right\-click **Command Prompt** and choose **Run as administrator**\.

1. Run the following command:

   `del <path_to_secrets.cfg_file>` \(for example: `del “C:\Program Files\Amazon\AlexaForBusinessGateway\secrets.cfg”`\)

1. Create a new secrets\.cfg file with the following structure:

   ```
   {
     "CISCO": {
       "USERNAME": "your cisco appliance username here",
       "PASSWORD": "your cisco appliance password here"
     }
   }
   ```

1. Start the **AlexaForBusinessGateway** service\.

**To update Cisco TelePresence Credentials for Linux**

1. Update the credentials in /etc/alexaforbusinessgateway/secrets\.cfg\.

1. Restart the **AlexaForBusinessGateway** service:
   + Sysvinit: `sudo service alexaforbusinessgateway restart`
   + Upstart: `sudo initctl restart alexaforbusinessgateway`
   + Systemd: `sudo systemctl restart alexaforbusinessgateway `

**To update AWS Credentials for Windows**

1. Stop the **AlexaForBusinessGateway** service\.

1. Choose **Start** and type **Command Prompt**\.

1. From the search results, right\-click **Command Prompt** and choose **Run as administrator**\.

1. Run the following command:

   `del <path_to_credentials_file>` \(for example: `del “C:\Program Files\Amazon\AlexaForBusinessGateway\credentials”`\)

1. Create a new credentials file with the following structure:

   ```
   [default]
   aws_access_key_id = YOUR ACCESS KEY ID HERE
   aws_secret_access_key = YOUR SECRET ACCESS KEY HERE
   ```

1. Start the **AlexaForBusinessGateway** service\.

**To update AWS Credentials for Linux**

1. Update the credentials in /etc/alexaforbusinessgateway/credentials\.cfg\.

1. Restart the **AlexaForBusinessGateway** service:
   + Sysvinit: `sudo service alexaforbusinessgateway restart`
   + Upstart: `sudo initctl restart alexaforbusinessgateway`
   + Systemd: `sudo systemctl restart alexaforbusinessgateway `

## Gateway Configuration Options<a name="gateway-options"></a>

The following configuration parameters are available in the gateway\.cfg file\.


**Main Configuration**  

| Parameter | Description | Default Value | Type | 
| --- | --- | --- | --- | 
| a4b | A4B  |  | Object | 
| skipSslVerification | Set to true to ignore SSL validation errors when the gateway is connecting to your video conferencing endpoints | false | Boolean | 
| credentials | Defines which AWS credentials to use |  | Null or object | 
| localLog | Settings to have gateway log to a local file |  | Object | 
| remoteLog | Settings to have gateway log to Amazon CloudWatch |  | Object | 
| maintenance | Maintenance settings for the gateway, such as the update window and service manager |  /path/to/root\-ca/cert\.pem  | Object | 
| rootCAsFile | Maintenance settings for the gateway, such as the update window and service manager |  | String | 
| metrics |  |  | Object | 


**A4B Object**  

| Parameter | Description | Default Value | Type | 
| --- | --- | --- | --- | 
| region | AWS Region where the gateway connects with the Alexa for Business endpoint  | us\-east\-1 | String | 
| endpoint | The Alexa for Business endpoint the gateway connects to | https://a4b\.us\-east\-1\.amazonaws\.com | String | 
| gatewayARN | The ARN of the gateway after it is registered with your Alexa for Business setup |  | String | 


**Shared Credentials**  

| Parameter | Description | Default Value | Type | 
| --- | --- | --- | --- | 
| filename | Path to your AWS credentials |  /path/to/\.aws/credentials/file  | String | 
| profile | The profile to use in your AWS credentials file |  | String | 


**Static Credentials**  

| Parameter | Description | Default Value | Type | 
| --- | --- | --- | --- | 
| accessKeyId | AWS access key |  | String | 
| secretAccessKey | AWS secret key |  | String | 
| sessionToken | AWS session token\. This is required only if you use temporary security credentials |  | String | 


**LocalLog Object**  

| Parameter | Description | Default Value | Type | 
| --- | --- | --- | --- | 
| enable | Boolean to enable logging to a local file | True | Boolean | 
| logDir | Path to the log location |  | String | 


**RemoteLog Object**  

| Parameter | Description | Default Value | Type | 
| --- | --- | --- | --- | 
| enable | Boolean to enable logging to AWS Cloudwatch | False | Boolean | 
| failureDir | Path to the directory for backup when logging to AWS Cloudwatch fails |  | String | 


**Maintenance Object**  

| Parameter | Description | Default Value | Type | 
| --- | --- | --- | --- | 
| serviceName | The service name of the gateway | alexaforbusiness | String | 
| serviceManager | The service manager used on your Linux systems\. Valid values are sysvinit, upstart, or systemd | systemd | String | 
| updateFrequency | Defines how often to check for an update inside a maintenance window | 15m | String | 
| updateBranch |  Defines which branch to update from  | stable | String | 
| windows | Defines the time windows of the gateway checking for updates |  | Object | 
| healthCheckPeriod |  How long to wait after an update for the service to regain health, before the update is considered a failure  |  5m  | String | 


**Maintenance Window Object**  

| Parameter | Description | Default Value | Type | 
| --- | --- | --- | --- | 
| day | Day of the week when the gateway checks for updates |  | String | 
| time | Time of day when the gateway checks for updates |  | String | 
| width | Maximum length of the maintenance window |  | String | 


**Metrics Object**  

| Parameter | Description | Default Value | Type | 
| --- | --- | --- | --- | 
| enable | Boolean to enable logging to AWS Cloudwatch | When this option is enabled, metrics are pushed to AWS Cloudwatch | String | 