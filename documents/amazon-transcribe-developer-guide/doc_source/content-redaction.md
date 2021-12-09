# Automatic Content Redaction<a name="content-redaction"></a>

 Amazon Transcribe's automatic content redaction feature automatically redacts sensitive personally identifiable information \(PII\) from your transcription results\. It replaces each identified instance of PII with a `[PII]` tag in the transcript\. You can use this feature to protect privacy and comply with local laws and regulations\. Automatic content redaction enables you to easily review and share transcripts to improve the customer service experience, coach agents, and discover new business opportunities while protecting sensitive personal information\. You can use this feature for source audio in US English \(en\-US\) with batch API calls\.

Personally Identifiable Information includes:


| PII Entity | Definition | 
| --- | --- | 
|  Bank Account Number  |  A number that uniquely identifies a bank account\.  | 
|  Bank Routing Number  |  A number that identifies the location of a bank account\.  | 
|  Credit Card Number or Debit Card Number  |  A value that uniquely defines a payment card issued by a bank\.  | 
|  Credit Card or Debit Card CVV Code  |  A 3 digit or 4 digit security code on each credit card\.  | 
|  Credit Card or Debit Card Expiration Date  |  The month and year a card expires\.  | 
|  Debit Card PIN or Credit Card PIN  |  A security code issued by a bank or credit union\. This number is used for bank accounts and payment cards\.  | 
| Email address | The unique identifier of an email box where messages are delivered\. | 
| US Mailing address | The U\.S\. mailing address of an individual\. | 
| Name | The first name and last name of a person\. | 
| US phone number | A 10\-digit phone number within the United States\.  | 
| Social Security Number | A 9 digit number or the last 4 digits of that number\. Issued to U\.S\. citizens, permanent residents, and temporary residents with employment\. | 

For each transcription job with automatic content redaction enabled, you generate either:
+ Only the redacted transcript\.
+ Both the redacted transcript and the unredacted transcript\.

Both redacted and unredacted transcripts are stored in the same output S3 bucket\. Amazon Transcribe stores them in either a bucket you specify or in the default S3 bucket managed by the service\. 

To enable content redaction, use the console or the API\. In the console, you enable **Automatic content redaction** in the **Content removal** section\.

 To enable content redaction using the API, complete the request parameters of the `ContentRedaction` object in the **StartTranscriptionJob** operation\. See the request syntax for the [StartTranscriptionJob](API_StartTranscriptionJob.md) action for more information\. To see if content redaction has been enabled for a particular transcription job, use [GetTranscriptionJob](API_GetTranscriptionJob.md)\. To see which jobs have content redaction enabled, use [ListTranscriptionJobs](API_ListTranscriptionJobs.md)\.

A redacted transcript has sensitive PII replaced with the `[PII]` tag, shown in the first truncated JSON output on this page\. Because Amazon Transcribe has redacted this transcript, the `isRedacted` field of this JSON output is `true`\. Each JSON output of a transcription job has a `results` section that contains the transcription results\. Every word, number, punctuation mark, or redaction has a confidence value\.

Transcription jobs using automatic content redaction generate two types of `confidence` values\. The Automatic Speech Recognition \(ASR\) confidence indicates the items that have the `type` of `pronunciation` or `punctuation` is a specific utterance\. In the transcript output below, the word `Good` has a `confidence` of `1.0`\. This confidence value indicates that Amazon Transcribe is 100 percent confident that the word uttered in this transcript is `Good`\. The `confidence` value for a `PII` tag is the confidence that the speech it flagged for redaction is truly PII\. In the transcript output below, the `confidence` of `0.9999` indicates that Amazon Transcribe is 99\.99 percent confident that the entity it redacted in the transcript is PII\.

The following is the redacted JSON output:

```
{
    "jobName": "job id",
    "accountId": "account id",
    "isRedacted": true,
    "results": {
        "transcripts": [
            {
                "transcript": "Good morning, everybody. My name is [PII], and today I feel like sharing a whole lot of personal information with you. Let's start with my Social Security number [PII]. My credit card number is [PII] and my C V V code is [PII]. I hope that Amazon Transcribe is doing a good job at redacting that personal information away. Let's check."
            }
        ],
        "items": [
            {
                "start_time": "2.86",
                "end_time": "3.35",
                "alternatives": [
                    {
                        "confidence": "1.0",
                        "content": "Good"
                    }
                ],
                "type": "pronunciation"
            },
            Items removed for brevity
            {
                "start_time": "5.56",
                "end_time": "6.25",
                "alternatives": [
                    {
                        "content": "[PII]",
                        "redactions": [
                            {
                                "confidence": "0.9999"
                            }
                        ]
                    }
                ],
                "type": "pronunciation"
            },
            Items removed for brevity
        ],
    },
    "status": "COMPLETED"
}
```

If you generate an additional unredacted transcript, its JSON output looks similar to the output of a transcription job with content redaction disabled\. The only difference is the additional `isRedacted` field being set to `false`\.

The following is the unredacted JSON output:

```
{
    "jobName": "job id",
    "accountId": "account id",
    "isRedacted": false,
    "results": {
        "transcripts": [
            {
                "transcript": "Good morning, everybody. My name is Mike, and today I feel like sharing a whole lot of personal information with you. Let's start with my Social Security number 000000000. My credit card number 5555555555555555 is and my C V V code is 000. I hope that Amazon Transcribe is doing a good job at redacting that personal information away. Let's check."
            }
        ],
        "items": [
            {
                "start_time": "2.86",
                "end_time": "3.35",
                "alternatives": [
                    {
                        "confidence": "1.0",
                        "content": "Good"
                    }
                ],
                "type": "pronunciation"
            },
            Items removed for brevity
            {
                "start_time": "5.56",
                "end_time": "6.25",
                "alternatives": [
                    {
                        "confidence": "1.0",
                        "content": "Mike"
                    }
                ],
                "type": "pronunciation"
            },
            Items removed for brevity
        ],
    },
    "status": "COMPLETED"
}
```

Amazon Transcribe throws an error message if you use automatic content redaction in an unsupported region\. Similarly, you receive an error message if you use content redaction with an unsupported language\.