# Asynchronous Batch Processing<a name="async"></a>

To translate large collections of documents \(up to 5 GB in size\), use the Amazon Translate asynchronous batch processing operation, [StartTextTranslationJob](API_StartTextTranslationJob.md)\. This is best for collections of short documents, such as social media postings or user reviews, or any situation in which instantaneous translation is not required\.\.

To perform an asynchronous batch translation, you typically perform the following steps:

1. Store a set of documents in a folder inside of an Amazon S3 bucket\.

1. Provide Amazon Translate with an IAM role that has read access to the input Amazon S3 folder, and read and write acccess to an output Amazon S3 folder\.

1. Start a batch translation job\.

1. Monitor the progress of the batch translation job\.

1. Retrieve the results of the batch translation job from the specified output S3 folder\.

## Region Availability<a name="async-regions"></a>

Batch translation is supported in the following AWS Regions:
+ US East \(Ohio\)
+ US East \(N\. Virginia\)
+ US West \(Oregon\)
+ Asia Pacific \(Seoul\)
+ EU \(Frankfurt\)
+ EU \(Ireland\)

## Prerequisites<a name="async-prereqs"></a>

The following prerequisites must be met in order for Amazon Translate to perform a successful batch translation job:
+ A batch translation job must be requested by an IAM role that has read access to your Amazon S3 input folder, and read and write access for your output folder\. For more information, see [Using Bucket Policies and User Policies](https://docs.aws.amazon.com/AmazonS3/latest/dev/using-iam-policies.html) in the *Amazon S3 Developer Guide*\.
+ The Amazon S3 folders that contain your input and output documents must be in the same AWS Region as the API endpoint you are calling\.
+ Documents must be UTF\-8 formatted `.txt` or `.html` files\.
+ The collection of batch input documents must be 5 GB or less in size\.
+ There can be a maximum of one million documents submitted in a batch translation job\.
+ Each input document must be 1 MB or less in size\.

## Starting a Batch Translation Job<a name="async-start"></a>

To submit a batch translation job, use either the Amazon Translate console or the [StartTextTranslationJob](API_StartTextTranslationJob.md) operation\.

The following example shows how to use the `start-text-translation-job` operation from the AWS CLI to start a batch translation job\. If successful, the operation returns a success message and the `JobId` of the new translation job\.

You must designate the file type of your input documents in the [InputDataConfig](API_InputDataConfig.md) `ContentType` parameter\. If your input is `txt` documents, use `text/plain`\. If your input is `html` documents, use `text/html`\.

**Important**  
Amazon Translate does not automatically detect a source language during batch translation jobs\.

```
aws translate start-text-translation-job --job-name batch-test \ 
    --source-language-code en \
    --target-language-codes fr --input-data-config S3Uri=s3://batchtranslation/input/,ContentType=text/plain \
    --output-data-config S3Uri=s3://batchtranslation/output/ \
    --data-access-role-arn arn:aws:iam::012345678901:role/service-role/AmazonTranslateInputOutputAccess

{
    "JobStatus": "SUBMITTED",
    "JobId": "1c1838f470806ab9c3e0057f14717bed"
}
```

**Note**  
Batch translation jobs are long\-running operations and can take significant time to complete\. For example, batch translation on a small dataset might take a few minutes, while very large datasets may take up to 2 days\. Completion time is also dependant on the availability of resources\.

## Monitoring and Analyzing Batch Translation Jobs<a name="async-monitor"></a>

You can use a job's ID to monitor its progress and get the Amazon S3 location of its output documents\. To monitor a specific job, use the [DescribeTextTranslationJob](API_DescribeTextTranslationJob.md) operation\. You can also use the [ListTextTranslationJobs](API_ListTextTranslationJobs.md) operation to retrieve information on all of the translation jobs in your account\. To restrict results to jobs that match a certain criteria, use the the [ListTextTranslationJobs](API_ListTextTranslationJobs.md) operation's `filter` parameter\. You can filter results by job name, job status, or the date and time that the job was submitted\. 

```
aws translate describe-text-translation-job --job-id 1c1838f470806ab9c3e0057f14717bed

{
    "TextTranslationJobProperties": {
        "InputDataConfig": {
            "ContentType": "text/plain",
            "S3Uri": "s3://batchtranslation/input/"
        },
        "EndTime": 1576551359.483,
        "SourceLanguageCode": "en",
        "DataAccessRoleArn": "arn:aws:iam::012345678901:role/service-role/AmazonTranslateInputOutputAccess",
        "JobId": "1c1838f470806ab9c3e0057f14717bed",
        "TargetLanguageCodes": [
            "fr"
        ],
        "JobName": "batch-test",
        "SubmittedTime": 1576544017.357,
        "JobStatus": "COMPLETED",
        "Message": "Your job has completed successfully.",
        "JobDetails": {
            "InputDocumentsCount": 77,
            "DocumentsWithErrorsCount": 0,
            "TranslatedDocumentsCount": 77
        },
        "OutputDataConfig": {
            "S3Uri": "s3://batchtranslation/output/012345678901-TranslateText-1c1838f470806ab9c3e0057f14717bed/"
        }
    }
}
```

You can stop a batch translation job while its status is `IN_PROGRESS` by using the [StopTextTranslationJob](API_StopTextTranslationJob.md) operation\.

```
aws translate stop-text-translation-job --job-id 5236d36ce5192abdb3e2519f3ab8b065
{
    "TextTranslationJobProperties": {
        "InputDataConfig": {
            "ContentType": "text/plain",
            "S3Uri": "s3://batchtranslation/input/"
        },
        "SourceLanguageCode": "en",
        "DataAccessRoleArn": "arn:aws:iam::012345678901:role/service-role/AmazonTranslateInputOutputAccess",
        "TargetLanguageCodes": [
            "fr"
        ],
        "JobName": "canceled-test",
        "SubmittedTime": 1576558958.167,
        "JobStatus": "STOP_REQUESTED",
        "JobId": "5236d36ce5192abdb3e2519f3ab8b065",
        "OutputDataConfig": {
            "S3Uri": "s3://batchtranslation/output/012345678901-TranslateText-5236d36ce5192abdb3e2519f3ab8b065/"
        }
    }
}
```

## Getting Batch Translation Results<a name="async-results"></a>

Once the job's status is `COMPLETED` or `COMPLETED_WITH_ERROR`, your output documents are available in the Amazon S3 folder you specified\. The output document names match the input document names, with the addition of the target language code as a prefix\. For instance, if you translated a document called `mySourceText.txt` into French, the output document will be called `fr.mySourceText.txt`\.

If the status of a batch translation job is `FAILED`, the [DescribeTextTranslationJob](API_DescribeTextTranslationJob.md) operation response includes a `Message` field that describes the reason why the job didn't complete successfully\.

Each batch translation job also generates an auxiliary file that contains information on the translations performed, such as the total number of characters translated and the number of errors encountered\. This file, called `target-language-code.auxiliary-translation-details.json`, is generated in the `details` subfolder of your output folder\.

The following is an example of a batch translation auxiliary file\.

```
{
   "sourceLanguageCode":"en",
   "targetLanguageCode":"fr",
   "charactersTranslated":"105",
   "documentCountWithCustomerError":"0",
   "documentCountWithServerError":"0",
   "inputDataPrefix":"s3://batchtranslation/input/",
   "outputDataPrefix":"s3://batchtranslation/output/012345678901-TranslateText-1c1838f470806ab9c3e0057f14717bed/",
   "details":[
      {
         "sourceFile":"mySourceText.txt",
         "targetFile":"fr.mySourceText.txt",
         "auxiliaryData":{
            "appliedTerminologies":[
               {
                  "name":"TestTerminology",
                  "terms":[
                     {
                        "sourceText":"Amazon",
                        "targetText":"Amazon"
                     }
                  ]
               }
            ]
         }
      },
      {
         "sourceFile":"batchText.txt",
         "targetFile":"fr.batchText.txt",
         "auxiliaryData":{
            "appliedTerminologies":[
               {
                  "name":"TestTerminology",
                  "terms":[
                     {
                        "sourceText":"Amazon",
                        "targetText":"Amazon"
                     }
                  ]
               }
            ]
         }
      }
   ]
}
```