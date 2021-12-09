# Automating Amazon Chime with EventBridge<a name="automating-chime-with-cloudwatch-events"></a>

Amazon EventBridge lets you automate your AWS services and respond automatically to system events, such as application availability issues or resource changes\. Events from AWS services are delivered to EventBridge in near real time\. You can write simple rules to specify the events that are of interest to you, and the automated actions to take when any of those events matches a rule\.

## Automating Amazon Chime Voice Connectors with EventBridge<a name="events-cvc"></a>

The actions that can be automatically triggered for Amazon Chime Voice Connectors include the following:
+ Invoking an AWS Lambda function
+ Launching an Amazon Elastic Container Service task
+ Relaying the event to Amazon Kinesis Video Streams
+ Activating an AWS Step Functions state machine
+ Notifying an Amazon SNS topic or an Amazon SQS queue

Some examples of using EventBridge with Amazon Chime Voice Connectors include:
+ Activating a Lambda function to download audio for a call after the call is ended\.
+ Launching an Amazon ECS task to enable real\-time transcription after a call is started\.

For more information, see the [Amazon EventBridge User Guide](https://docs.aws.amazon.com/eventbridge/latest/userguide/)\.

## Amazon Chime Voice Connector streaming events<a name="stream-events-cvc"></a>

Amazon Chime Voice Connectors support sending events to EventBridge when the events discussed in this section occur\.

### Amazon Chime Voice Connector streaming starts<a name="stream-start-cvc"></a>

Amazon Chime Voice Connectors send this event when media streaming to Kinesis Video Streams starts\.

**Example : Event data**  
The following is example data for this event\.  

```
{
    "version": "0",
    "id": "12345678-1234-1234-1234-111122223333",
    "detail-type": "Chime VoiceConnector Streaming Status",
    "source": "aws.chime",
    "account": "111122223333",
    "time": "yyyy-mm-ddThh:mm:ssZ",
    "region": "us-east-1",
    "resources": [],
    "detail": {
        "callId": "1112-2222-4333",
        "direction": "Outbound",
        "fromNumber": "+12065550100",
        "inviteHeaders": {
            "from": "\"John\" <sip:+12065550100@10.24.34.0;tag=abcdefg",
            "to": "<sip:+13605550199@abcdef1ghij2klmno3pqr4.voiceconnector.chime.aws:5060",
            "call-id": "1112-2222-4333",
            "cseq": "101 INVITE",
            "contact": "<sip:user@10.24.34.0:6090",
            "content-type": "application/sdp",
            "content-length": "246"
        },
        "isCaller": false,
        "mediaType": "audio/L16",
        "sdp": {
            "mediaIndex": 0,
            "mediaLabel": "1"
        },
        "siprecMetadata": "<&xml version=\"1.0\" encoding=\"UTF-8\"&\r\n<recording xmlns='urn:ietf:params:xml:ns:recording:1'",
        "startFragmentNumber": "1234567899444",
        "startTime": "yyyy-mm-ddThh:mm:ssZ",
        "streamArn": "arn:aws:kinesisvideo:us-east-1:123456:stream/ChimeVoiceConnector-abcdef1ghij2klmno3pqr4-111aaa-22bb-33cc-44dd-111222/111122223333",
        "toNumber": "+13605550199",
        "transactionId": "12345678-1234-1234",
        "voiceConnectorId": "abcdef1ghij2klmno3pqr4",
        "streamingStatus": "STARTED",
        "version": "0"
    }
}
```

### Amazon Chime Voice Connector streaming ends<a name="stream-end-cvc"></a>

Amazon Chime Voice Connectors send this event when media streaming to Kinesis Video Streams ends\.

**Example : Event data**  
The following is example data for this event\.  

```
{
    "version": "0",
    "id": "12345678-1234-1234-1234-111122223333",
    "detail-type": "Chime VoiceConnector Streaming Status",
    "source": "aws.chime",
    "account": "111122223333",
    "time": "yyyy-mm-ddThh:mm:ssZ",
    "region": "us-east-1",
    "resources": [],
    "detail": {
        "streamingStatus": "ENDED",
        "voiceConnectorId": "abcdef1ghij2klmno3pqr4",
        "transactionId": "12345678-1234-1234",
        "callId": "1112-2222-4333",
        "direction": "Inbound",
        "fromNumber": "+12065550100",
        "inviteHeaders": {
            "from": "\"John\" <sip:+12065550100@10.24.34.0;tag=abcdefg",
            "to": "<sip:+13605550199@abcdef1ghij2klmno3pqr4.voiceconnector.chime.aws:5060",
            "call-id": "1112-2222-4333",
            "cseq": "101 INVITE",
            "contact": "<sip:user@10.24.34.0:6090",
            "content-type": "application/sdp",
            "content-length": "246"
        },
        "isCaller": false,
        "mediaType": "audio/L16",
        "sdp": {
            "mediaIndex": 0,
            "mediaLabel": "1"
        },
        "siprecMetadata": "<&xml version=\"1.0\" encoding=\"UTF-8\"&\r\n<recording xmlns='urn:ietf:params:xml:ns:recording:1'",
        "startFragmentNumber": "1234567899444",
        "startTime": "yyyy-mm-ddThh:mm:ssZ",
        "endTime": "yyyy-mm-ddThh:mm:ssZ",
        "streamArn": "arn:aws:kinesisvideo:us-east-1:123456:stream/ChimeVoiceConnector-abcdef1ghij2klmno3pqr4-111aaa-22bb-33cc-44dd-111222/111122223333",
        "toNumber": "+13605550199",
        "version": "0"
    }
}
```

### Amazon Chime Voice Connector streaming updates<a name="stream-update-cvc"></a>

Amazon Chime Voice Connectors send this event when media streaming to Kinesis Video Streams is updated\.

**Example : Event data**  
The following is example data for this event\.  

```
{
    "version": "0",
    "id": "12345678-1234-1234-1234-111122223333",
    "detail-type": "Chime VoiceConnector Streaming Status",
    "source": "aws.chime",
    "account": "111122223333",
    "time": "yyyy-mm-ddThh:mm:ssZ",
    "region": "us-east-1",
    "resources": [],
    "detail": {
        "callId": "1112-2222-4333",
        "updateHeaders": {
            "from": "\"John\" <sip:+12065550100@10.24.34.0;tag=abcdefg",
            "to": "<sip:+13605550199@abcdef1ghij2klmno3pqr4.voiceconnector.chime.aws:5060",
            "call-id": "1112-2222-4333",
            "cseq": "101 INVITE",
            "contact": "<sip:user@10.24.34.0:6090",
            "content-type": "application/sdp",
            "content-length": "246"
        },
        "siprecMetadata": "<&xml version=\"1.0\" encoding=\"UTF-8\"&\r\n<recording xmlns='urn:ietf:params:xml:ns:recording:1'",
        "streamingStatus": "UPDATED",
        "transactionId": "12345678-1234-1234",
        "version": "0",
        "voiceConnectorId": "abcdef1ghij2klmno3pqr4"
    }
}
```

### Amazon Chime Voice Connector streaming fails<a name="stream-fail-cvc"></a>

Amazon Chime Voice Connectors send this event when media streaming to Kinesis Video Streams fails\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "id": "12345678-1234-1234-1234-111122223333",
  "detail-type": "Chime VoiceConnector Streaming Status",
  "source": "aws.chime",
  "account": "111122223333",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "region": "us-east-1",
  "resources": [],
  "detail": {
       "streamingStatus":"FAILED",
       "voiceConnectorId":"abcdefghi",
       "transactionId":"12345678-1234-1234",
       "callId":"1112-2222-4333",
       "direction":"Inbound",
       "failTime":"yyyy-mm-ddThh:mm:ssZ",
       "failureReason": "Internal failure",
       "version":"0"
  }
}
```

## Automating the Amazon Chime SDK with EventBridge<a name="events-sdk"></a>

Some examples of using EventBridge with the Amazon Chime SDK include:
+ Updating metadata when an attendee joins or leaves an Amazon Chime SDK meeting\.
+ Implementing push notifications or rosters for an Amazon Chime SDK meeting\.

For more information, see the [Amazon EventBridge User Guide](https://docs.aws.amazon.com/eventbridge/latest/userguide/) and [Using the Amazon Chime SDK](https://docs.aws.amazon.com/chime/latest/dg/meetings-sdk.html) in the *Amazon Chime Developer Guide*\.

## Amazon Chime SDK events<a name="sdk-events"></a>

The Amazon Chime SDK supports sending events to EventBridge when the events discussed in this section occur\.

### Amazon Chime SDK meeting starts<a name="sdk-start-mtg"></a>

The Amazon Chime SDK sends this event when a new meeting starts\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:MeetingStarted",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
  }
}
```

### Amazon Chime SDK meeting ends<a name="sdk-end-mtg"></a>

The Amazon Chime SDK sends this event when an active meeting ends\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:MeetingEnded",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
  }
}
```

### Amazon Chime SDK attendee is added<a name="sdk-add-attendee"></a>

The Amazon Chime SDK sends this event when a new attendee is added to an active meeting\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeAdded",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333",
  }
}
```

### Amazon Chime SDK attendee is removed<a name="sdk-remove-attendee"></a>

The Amazon Chime SDK sends this event when an attendee is removed from an active meeting\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeDeleted",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333",
  }
}
```

### Amazon Chime SDK attendee is authorized<a name="sdk-auth-attendee"></a>

The Amazon Chime SDK sends this event when an existing attendee joins a meeting\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeAuthorized",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
  }
}
```

### Amazon Chime SDK attendee joins a meeting<a name="sdk-join-attendee"></a>

The Amazon Chime SDK sends this event when an existing attendee joins an Amazon Chime SDK meeting using the specified network transport\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeJoined",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
    "networkType" "Voip"
  }
}
```

### Amazon Chime SDK attendee leaves a meeting<a name="sdk-leave-attendee"></a>

The Amazon Chime SDK sends this event when an existing attendee leaves an Amazon Chime SDK meeting using the specified network transport\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeLeft",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
    "networkType" "Voip"
  }
}
```

### Amazon Chime SDK attendee drops from a meeting<a name="sdk-drop-attendee"></a>

The Amazon Chime SDK sends this event when an existing attendee drops from an Amazon Chime SDK meeting using the specified network transport\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeDropped",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
    "networkType" "Voip"
  }
}
```

### Amazon Chime SDK attendee starts streaming video<a name="sdk-attendee-video-start"></a>

The Amazon Chime SDK sends this event when an existing attendee starts streaming video\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeVideoStarted",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
  }
}
```

### Amazon Chime SDK attendee stops streaming video<a name="sdk-attendee-video-stop"></a>

The Amazon Chime SDK sends this event when an existing attendee stops streaming video\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeVideoStopped",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
  }
}
```

### Amazon Chime SDK attendee starts sharing screen<a name="sdk-attendee-screenshare-start"></a>

The Amazon Chime SDK sends this event when an existing attendee starts sharing their screen\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeScreenShareStarted",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
  }
}
```

### Amazon Chime SDK attendee stops sharing screen<a name="sdk-attendee-screenshare-stop"></a>

The Amazon Chime SDK sends this event when an existing attendee stops sharing their screen\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeScreenShareStopped",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
  }
}
```

### Amazon Chime SDK attendee content joins a meeting<a name="sdk-content-join"></a>

The Amazon Chime SDK sends this event when a content share joins an Amazon Chime SDK meeting using the specified network transport\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeContentJoined",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
    "networkType" "Voip"
  }
}
```

### Amazon Chime SDK attendee content leaves a meeting<a name="sdk-content-leave"></a>

The Amazon Chime SDK sends this event when a content share leaves an Amazon Chime SDK meeting using the specified network transport\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeContentLeft",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
    "networkType" "Voip"
  }
}
```

### Amazon Chime SDK attendee content drops from a meeting<a name="sdk-content-drop"></a>

The Amazon Chime SDK sends this event when a content share drops from an Amazon Chime SDK meeting using the specified network transport\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeContentDropped",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
    "networkType" "Voip"
  }
}
```

### Amazon Chime SDK attendee content starts streaming video<a name="sdk-content-start-stream"></a>

The Amazon Chime SDK sends this event when a content share starts streaming video\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeContentVideoStarted",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
  }
}
```

### Amazon Chime SDK attendee content stops streaming video<a name="sdk-content-stop-stream"></a>

The Amazon Chime SDK sends this event when a content share stops streaming video\.

**Example : Event data**  
The following is example data for this event\.  

```
{
  "version": "0",
  "source": "aws.chime",
  "account": "111122223333",
  "id": "12345678-1234-1234-1234-111122223333",
  "region": "us-east-1",
  "detail-type": "Chime Meeting State Change",
  "time": "yyyy-mm-ddThh:mm:ssZ",
  "resources": []
  "detail": {
    "version": "0",
    "eventType": "chime:AttendeeContentVideoStopped",
    "timestamp": 12344566754,
    "meetingId": "87654321-4321-4321-1234-111122223333",
    "attendeeId": "87654321-4321-4321-1234-111122223333",
    "externalUserId": "87654321-4321-4321-1234-111122223333"
  }
}
```