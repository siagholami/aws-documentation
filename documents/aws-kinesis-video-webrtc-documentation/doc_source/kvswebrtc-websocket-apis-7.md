# Asynchronous Message Reception<a name="kvswebrtc-websocket-apis-7"></a>

All response messages are asynchronously delivered to the recipient as events \(for example, an SDP offer or SDP answer delivery\)\. The following is the event message structure\. 

## Event<a name="kvswebrtc-websocket-apis-7-request"></a>

```
{
    "senderClientId": "string",
    "messageType": "string",
    "messagePayload": "string",
    "statusResponse": {
        "correlationId": "String",
        "errorType": "string",
        "statusCode": "string",
        "description": "String"
    }
}
```
+ **senderClientId** \- A unique identifier for the sender client\.
  + Type: String
  + Length constraints: Minimum length of 1\. Maximum length of 256\.
  + Pattern: \[a\-zA\-Z0\-9\_\.\-\]\+
  + Required: No
+ **messageType** \- Type of the event\.
  + Type: ENUM
  + Valid Types: SDP\_OFFER, SDP\_ANSWER, ICE\_CANDIDATE, GO\_AWAY, RECONNECT\_ICE\_SERVER, STATUS\_RESPONSE
  + Length constraints: Minimum length of 1\. Maximum length of 256\.
  + Pattern: \[a\-zA\-Z0\-9\_\.\-\]\+
  + Required: Yes
+ **messagePayload** \- The base64\-encoded message content\.
  + Type: String
  + Length constraints: Minimum length of 1\. Maximum length of 10K\.
  + Required: No
+ **correlationId** \- An unique identifier of the message for which the status is meant\. This is the same correlationId provided in the client messages \(for example, SDP offer, SDP answer, or ICE candidate\)\.
  + Type: String
  + Length constraints: Minimum length of 1\. Maximum length of 256\.
  + Pattern: \[a\-zA\-Z0\-9\_\.\-\]\+
  + Required: Yes
+ **errorType** \- A name to uniquely identify the error\.
  + Type: String
  + Length constraints: Minimum length of 1\. Maximum length of 256\.
  + Pattern: \[a\-zA\-Z0\-9\_\.\-\]\+
  + Required: No
+ **statusCode** \- HTTP status code corresponding to the nature of the response\.
  + Type: String
  + Length constraints: Minimum length of 1\. Maximum length of 256\.
  + Pattern: \[a\-zA\-Z0\-9\_\.\-\]\+
  + Required: No
+ **description** \- A string description explaining the status\.
  + Type: String
  + Length constraints: Minimum length of 1\. Maximum length of 1K\.
  + Required: No