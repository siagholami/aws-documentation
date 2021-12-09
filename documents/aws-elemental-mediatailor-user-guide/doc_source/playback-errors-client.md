# Client Playback Errors Returned by AWS Elemental MediaTailor<a name="playback-errors-client"></a>

General guidance: 
+ You can find detailed information for most errors in the headers and body of the response\.
+ For some errors, you need to check your configuration settings\. You can retrieve the settings for your playback configuration from AWS Elemental MediaTailor\. For the API, the resource is `GetPlaybackConfiguration/Name`\. For details, see the [AWS Elemental MediaTailor API Reference](https://docs.aws.amazon.com/mediatailor/latest/apireference/)\. 

The following table lists the client error codes that are returned by the manifest manipulation activities of AWS Elemental MediaTailor, probable causes, and actions you can take to resolve them\.


| Code  | Exception Name  | Meaning | What To Do | 
| --- | --- | --- | --- | 
| 400 | BadRequestException | MediaTailor is unable to service the request due to one or more errors in formatting or content\. A parameter might be improperly formatted, or the request might contain an invalid playback configuration or session ID\. | Check that your request is properly formatted and contains accurate information\. Make sure that the playback endpoint setting on the player matches the ManifestEndpointPrefix setting returned by GetPlaybackConfiguration\. Retry your request\.  | 
| 403 | AccessDeniedException | The host header provided in the request doesn't match the manifest endpoint prefix that is configured in the MediaTailor playback URL\. Your CDN might be misconfigured\.  | Check your CDN settings and make sure that you are using the correct manifest endpoint prefix for MediaTailor\. Retry your request\.  | 
| 404 | NotFoundException | MediaTailor is unable to find the information specified\. Possible reasons include a URL that doesn't map to anything in the service, a configuration that isn't defined, or a session that is unavailable\. | Check your configuration and the validity of your request, and then reinitialize the session\.  | 
| 409 | ConflictException | A player tried to load multiple playlists simultaneously for a single session\. As a result, MediaTailor detected a session consistency conflict\. This problem occurs for HLS players\. | Make sure that your player requests playlists one at a time\. This is in accordance with the HLS specification\.  | 
| 410 | Gone | An AWS Support operator has blocked a player session or customer configuration\. AWS Support does this in rare circumstances when we detect a very high volume of 4xx requests coming from errant traffic for a single session or configuration\.  | If you think that the request shouldn't be blocked, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\. They can look into it and remove the blocking filter, if appropriate\.  | 

 If you need further assistance, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.