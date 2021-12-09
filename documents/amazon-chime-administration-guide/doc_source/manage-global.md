# Managing global settings in Amazon Chime<a name="manage-global"></a>

Manage call detail record settings from the Amazon Chime console\.

## Configuring call detail records<a name="call-detail"></a>

Before you can configure call detail record settings for your Amazon Chime administrative account, you must first create an Amazon Simple Storage Service bucket\. The Amazon S3 bucket is used as the log destination for your call detail records\. When you configure your call detail record settings, you grant Amazon Chime read and write access to the Amazon S3 bucket in order to save and manage your data\. For more information about creating an Amazon S3 bucket, see [Getting started with Amazon Simple Storage Service](https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) in the *Amazon Simple Storage Service Getting Started Guide*\.

You can configure call detail record settings for Amazon Chime Business Calling and for Amazon Chime Voice Connectors\. For more information about Amazon Chime Business Calling and Amazon Chime Voice Connectors, see [Managing phone numbers in Amazon Chime](phone-numbers.md)\.

**To configure call detail record settings**

1. Create an Amazon S3 bucket by following the steps at [Getting started with Amazon Simple Storage Service](https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) in the *Amazon Simple Storage Service Getting Started Guide*\.

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Global Settings**, choose **Call detail records**\.

1. Choose one or both of the following configurations:
   + **Business Calling Configuration**
   + **Voice Connector Configuration**

1. For **Log destination**, select the Amazon S3 bucket\.

1. Choose **Save**\.

You can stop logging call detail records at any time\.

**To stop logging call detail records**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Global Settings**, choose **Call detail records**\.

1. Choose **Disable logging** for the applicable configuration\.

## Amazon Chime Business Calling call detail records<a name="bc-cdr"></a>

When you choose to receive call detail records for Amazon Chime Business Calling, they are sent to your Amazon S3 bucket\. The following example shows the general format of an Amazon Chime Business Calling call detail record name\.

```
Amazon-Chime-Business-Calling-CDRs/json/111122223333/2019/03/01/123a4567-b890-1234-5678-cd90efgh1234_2019-03-01-17.10.00.020_1a234567-89bc-01d2-3456-e78f9g01234h
```

The following example shows the data that is represented in the call detail record name\.

```
Amazon-Chime-Business-Calling-CDRs/json/awsAccountID/year/month/day/conferenceID_connectionDate-callStartTime-callDetailRecordID
```

The following example shows the general format of an Amazon Chime Business Calling call detail record\.

```
{
    "SchemaVersion": "2.0",
    "CdrId": "1a234567-89bc-01d2-3456-e78f9g01234h",
    "ServiceCode": "AmazonChimeBusinessCalling",
    "ChimeAccountId": "12a3456b-7c89-012d-3456-78901e23fg45",
    "AwsAccountId": "111122223333",
    "ConferenceId": "123a4567-b890-1234-5678-cd90efgh1234",
    "ConferencePin": "XXXXXXXXXX",
    "OrganizerUserId": "1ab2345c-67de-8901-f23g-45h678901j2k",
    "OrganizerEmail": "jdoe@example.com",

    "CallerPhoneNumber": "+12065550100",
    "CallerCountry": "US",

    "DestinationPhoneNumber": "+12065550101",
    "DestinationCountry": "US",

    "ConferenceStartTimeEpochSeconds": "1556009595",
    "ConferenceEndTimeEpochSeconds": "1556009623",
    "StartTimeEpochSeconds": "1556009611",
    "EndTimeEpochSeconds": "1556009623",
    "BillableDurationSeconds": "24",
    "BillableDurationMinutes": ".4",
    "Direction": "Outbound"
}
```

## Amazon Chime Voice Connector call detail records<a name="vc-cdr"></a>

When you choose to receive call detail records for your Amazon Chime Voice Connector, they are sent to your Amazon S3 bucket\. The following example shows the general format of an Amazon Chime Voice Connector call detail record name\.

```
Amazon-Chime-Voice-Connector-CDRs/json/abcdef1ghij2klmno3pqr4/2019/03/01/17.10.00.020_123abc4d-efg5-6789-h012-j3456789k012
```

The following example shows the data that is represented in the call detail record name\.

```
Amazon-Chime-Voice-Connector-CDRs/json/voiceConnectorID/year/month/day/callStartTime-voiceConnectorTransactionID
```

The following example shows the general format of an Amazon Chime Voice Connector call detail record\.

```
{
    "AwsAccountId": "111122223333",
    "TransactionId": "123abc4d-efg5-6789-h012-j3456789k012",
    "CallId": "123a4b567890123c456789012d3456e7@203.0.113.9:8080",
    "VoiceConnectorId": "abcdef1ghij2klmno3pqr4",
    "Status": "Completed",
    "StatusMessage": "OK",
    "SipAuthUser": "XXXX",
    "BillableDurationSeconds": 6,
    "BillableDurationMinutes": 0.1,
    "SchemaVersion": "2.0",
    "SourcePhoneNumber": "+12065550100",
    "SourceCountry": "US",
    "DestinationPhoneNumber": "+12065550101",
    "DestinationCountry": "US",
    "UsageType": "USE1-US-US-outbound-minutes",
    "ServiceCode": "AmazonChimeVoiceConnector",
    "Direction": "Outbound",
    "StartTimeEpochSeconds": 1565399625,
    "EndTimeEpochSeconds": 1565399629,
    "Region": "us-east-1",
    "Streaming": true
}
```

## Amazon Chime Voice Connector streaming detail records<a name="vc-sdr"></a>

When you choose to receive call detail records for your Amazon Chime Voice Connector, and you stream media to Kinesis Video Streams or send SIPREC requests, streaming detail records are sent to your Amazon S3 bucket\. For more information, see [Streaming Amazon Chime Voice Connector media to Kinesis](start-kinesis-vc.md)\.

The following example shows the general format of a streaming detail record name\.

```
Amazon-Chime-Voice-Connector-SDRs/json/abcdef1ghij2klmno3pqr4/2019/03/01/17.10.00.020_123abc4d-efg5-6789-h012-j3456789k012
```

The following example shows the data that is represented in the streaming detail record name\.

```
Amazon-Chime-Voice-Connector-SDRs/json/voiceConnectorID/year/month/day/callStartTime-voiceConnectorTransactionID
```

The following example shows the general format of a streaming detail record\.

```
{
    "SchemaVersion": "1.0",
    "AwsAccountId": "111122223333",
    "TransactionId": "123abc4d-efg5-6789-h012-j3456789k012",
    "CallId": "123a4b567890123c456789012d3456e7@203.0.113.9:8080",
    "VoiceConnectorId": "abcdef1ghij2klmno3pqr4",
    "StartTimeEpochSeconds": 1565399625,
    "EndTimeEpochSeconds": 1565399629,
    "Status": "Completed",
    "StatusMessage": "Streaming succeeded",
    "ServiceCode": "AmazonChime",
    "UsageType": "USE1-VC-kinesis-audio-streaming",
    "BillableDurationSeconds": 6,
    "Region": "us-east-1"
}
```