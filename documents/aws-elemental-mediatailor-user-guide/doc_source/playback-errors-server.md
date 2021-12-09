# Server Playback Errors Returned by AWS Elemental MediaTailor<a name="playback-errors-server"></a>

General guidance: 
+ You can find detailed information for most errors in the headers and body of the response\.
+ For some errors, you need to check your configuration settings\. You can retrieve the settings for your playback configuration from AWS Elemental MediaTailor\. For the API, the resource is `GetPlaybackConfiguration/Name`\. For details, see the [AWS Elemental MediaTailor API Reference](https://docs.aws.amazon.com/mediatailor/latest/apireference/)\. 

The following table lists the server error codes returned by the manifest manipulation activities of AWS Elemental MediaTailor, probable causes, and actions you can take to resolve them\.


| Code | Exception Name | Meaning | What To Do | 
| --- | --- | --- | --- | 
| 500 | InternalServiceError | Unhandled exception\.  | Retry the request\. If the problem persists, check the reported health of MediaTailor for your AWS Region at [https://status.aws.amazon.com/](https://status.aws.amazon.com/)\. | 
| 502 | BadGatewayException | Either the origin server address or the ad decision server \(ADS\) address is invalid\. Examples of invalid addresses are a private IP address and localhost\.  | Make sure that your configuration has the correct settings for your ADS and origin server, and then retry the request\.  | 
| 502 | UnsupportedManifestException | Either the origin manifest has changed so that MediaTailor can't personalize it or MediaTailor doesn't support the origin's manifest format\.  | This might affect only the individual session\. Reinitialize the session\. You can usually accomplish this by refreshing the page in the viewer\. If the problem persists, verify that MediaTailor supports the origin's manifest format\. For information, see [Manifest Handling](manifest.md)\.  | 
| 503 | LoadShed | MediaTailor experienced a resource constraint while servicing your request\. | Retry the request\. If the problem persists, check the reported health of MediaTailor for your AWS Region at [https://status.aws.amazon.com/](https://status.aws.amazon.com/)\. | 
| 503 | ThrottlingException | Your transactions per second have reached your quota, and MediaTailor is throttling your use\.  | Retry the request\. You can also check the reported health of MediaTailor for your AWS Region at [https://status.aws.amazon.com/](https://status.aws.amazon.com/)\. You might want to increase the quota on your transactions per second\. For more information, see [Soft Quotas](limits.md#soft-limits)\.  | 
| 504 | GatewayTimeoutException | A timeout occurred while MediaTailor was contacting the origin server\.  | Retry the request\. If the problem persists, check the health of the origin server and make sure the origin server is responding within the content origin server timeout that is listed at [Hard Quotas](limits.md#hard-limits)\. | 

 If you need further assistance, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.