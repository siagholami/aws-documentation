# Querying the ADS Logs<a name="querying-the-ads-logs"></a>

CloudWatch Logs Insights provides a rich set of options for querying your logs\. For detailed information about querying syntax, see [CloudWatch Logs Insights Query Syntax](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/CWL_QuerySyntax.html)\. This section provides examples of common queries to get you started with your ADS logs queries\. All queries run against the logs for the current time range setting\.

The following query retrieves all information from the ADS logs\. 

```
fields @timestamp, eventType, sessionId, requestId, @message
| sort sessionId, @timestamp asc
```

The following query retrieves all requests to the ADS\. This query shows a way to retrieve the request header contents for MediaTailor logs\. 

```
fields @timestamp, adsRequestUrl, requestHeaders.0.value as @userAgent, requestHeaders.1.value as @xForwardedFor, sessionId, requestId
| filter eventType = "MAKING_ADS_REQUEST"
| sort @timestamp asc
```

The following query retrieves the ads MediaTailor inserted for a given session\.

```
fields @timestamp, sessionId, requestId, @message
| filter eventType = "FILLED_AVAIL"
| sort @timestamp asc
```

The following query retrieves the tracking URLs that MediaTailor called on behalf of the player\.

```
fields @timestamp, beaconInfo.trackingEvent, beaconInfo.beaconUri, beaconInfo.headers.0.value as @userAgent, beaconInfo.headers.1.value as @xForwardedFor, sessionId, requestId
| filter eventType = "BEACON_FIRED"
| sort @timestamp asc
```

The following query retrieves information for a specific playback session, by filtering the results by `sessionId`\. 

```
fields @timestamp, eventType, sessionId, requestId, @message
| filter sessionId = "0aaf6507-c6f9-4884-bfe7-f2f841cb8195"
| sort @timestamp asc
```

The following query retrieves information for a single request, by filtering the results by `requestId`\.

```
fields @timestamp, eventType, sessionId, requestId, @message
| filter requestId = "f5d3cf39-6258-4cf1-b3f6-a34ff8bf641d"
| sort @timestamp asc
```

The following query retrieves a count of log entries for each event type that was logged\.

```
fields eventType
| stats count() as @eventCount by eventType
```

The following query retrieves the avail ID and list of skipped ads for all avails that had skipped ads\.

```
fields avail.availId
| parse @message '"skippedAds":[*]' as @skippedAdsList
| filter ispresent(@skippedAdsList)
```