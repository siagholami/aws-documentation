# Playback Errors Returned by AWS Elemental MediaTailor<a name="playback-errors"></a>

This section provides information about the HTTP error codes that you might receive while testing your player software and during the normal processing of player requests\. 

**Note**  
You might also receive errors from the AWS Elemental MediaTailor API, during configuration operations like `PutPlaybackConfiguration` and `GetPlaybackConfiguration`\. For information about those types of errors, see the [AWS Elemental MediaTailor API Reference](https://docs.aws.amazon.com/mediatailor/latest/apireference/)\. 

When your player sends a request to AWS Elemental MediaTailor, either directly or through a CDN, MediaTailor responds with a status code\. If MediaTailor successfully handles the request, it returns the HTTP status code `200 OK`, indicating success, along with the populated manifest\. If the request is unsuccessful, MediaTailor returns an HTTP status code, an exception name, and an error message\. 

AWS Elemental MediaTailor returns two classes of errors:
+ **Client errors** – errors that are usually caused by a problem in the request itself, like an improperly formatted request, an invalid parameter, or a bad URL\. These errors have an HTTP `4xx` response code\.
+ **Server errors** – errors that are usually caused by a problem with MediaTailor or one of its dependencies, like the ad decision server \(ADS\) or the origin server\. These errors have an HTTP `5xx` response code\.

**Topics**
+ [Client Playback Errors Returned by AWS Elemental MediaTailor](playback-errors-client.md)
+ [Server Playback Errors Returned by AWS Elemental MediaTailor](playback-errors-server.md)
+ [Playback Error Examples](playback-errors-examples.md)