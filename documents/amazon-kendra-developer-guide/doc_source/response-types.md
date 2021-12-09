--------

--------

# Response types<a name="response-types"></a>

Amazon Kendra returns three types of query response\.
+ Answer
+ Document
+ Question and answer

The type of the response is returned in the `Type` response field of the [QueryResultItem](API_QueryResultItem.md) operation\. 

## Answer<a name="query-answer"></a>

Amazon Kendra detected one or more question answers in the response\. A factoid is the response to a who, what, when, or where question such as *What is the height of the space needle?* Amazon Kendra returns text in the index that best matches the query\. The text is in the `AnswerText` field and contains highlight information for the search term within the response text\. 

```
{
    'AnswerText': {
        'Highlights': [
            {
                'BeginOffset': 271,
                'EndOffset': 279,
                'TopAnswer': False
            },
            {
                'BeginOffset': 481,
                'EndOffset': 489,
                'TopAnswer': False
            },
            {
                'BeginOffset': 547,
                'EndOffset': 555,
                'TopAnswer': False
            },
            {
                'BeginOffset': 764,
                'EndOffset': 772,
                'TopAnswer': False
            }
        ],
        'Text': 'Asynchronousoperationscan\n''alsoprocess\n''documentsthatareinPDF''format.UsingPDFformatfilesallowsyoutoprocess''multi-page\n''documents.\n''Forinformationabouthow''AmazonTextractrepresents\n''documentsasBlockobjects,
        ''seeDocumentsandBlockObjects.\n''\n''\n''\n''Forinformationaboutdocument''limits,
        seeLimitsinAmazonTextract.\n''\n''\n''\n''TheAmazonTextractsynchronous''operationscanprocessdocumentsstoredinanAmazon\n''S3Bucketoryoucanpass''base64encodedimagebytes.\n''Formoreinformation,
        see''CallingAmazonTextractSynchronousOperations.''Asynchronousoperationsrequireinputdocuments\n''tobesuppliedinanAmazon''S3Bucket.'
    },
    'Excerpt': {
        'Highlights': [
            {
                'BeginOffset': 0,
                'EndOffset': 300,
                'TopAnswer': False
            }
        ],
        'Text': 'Asynchronousoperationscan\n''alsoprocess\n''documentsthatareinPDF''format.UsingPDFformatfilesallowsyoutoprocess''multi-page\n''documents.\n''ForinformationabouthowAmazon''Textractrepresents\n'''
    },
    'Type': 'ANSWER'
}
```

## Document<a name="query-document"></a>

Amazon Kendra returns ranked documents for those that match the search term\. The ranking is based on the confidence that Amazon Kendra has in the accuracy of the search result\. Information about the matching document is returned in the [QueryResultItem](API_QueryResultItem.md)\. It includes the title of the document\. The excerpt includes highlight information for search text and the section of matching text in the document\. The URI for matching documents is in the `SourceURI` document attribute\. The following sample JSON shows the document summary for a matching document\.

```
{
    'DocumentTitle': {
        'Highlights': [
            {
                'BeginOffset': 7,
                'EndOffset': 15,
                'TopAnswer': False
            },
            {
                'BeginOffset': 97,
                'EndOffset': 105,
                'TopAnswer': False
            }
        ],
        'Text': 'AmazonTextractAPIPermissions: Actions,
        \n''Permissions,
        andResourcesReference-''AmazonTextract'
    },
    'Excerpt': {
        'Highlights': [
            {
                'BeginOffset': 68,
                'EndOffset': 76,
                'TopAnswer': False
            },
            {
                'BeginOffset': 121,
                'EndOffset': 129,
                'TopAnswer': False
            }
        ],
        'Text': '...LoggingandMonitoring\tMonitoring\n''\tCloudWatchMetricsforAmazonTextract\n''\tLoggingAmazonTextractAPICallswithAWSCloudTrail\n''\tAPIReference\tActions\tAnalyzeDocument\n''\tDetectDocumentText\n''\tGetDocumentAnalysis...'
    },
    'Type': 'DOCUMENT'
}
```

## Question and answer<a name="query-question-answer"></a>

A question and answer response is returned when Amazon Kendra matches a question with one of the frequently asked questions in your index\. The response includes the matching question and answer in the [QueryResultItem](API_QueryResultItem.md) field\. It also includes highlight information for query terms detected in query string\. The following JSON shows a question and answer response\. Note that the response includes the question text\. 

```
{
    'AnswerText': {
        'Highlights': [
            
        ],
        'Text': '605feet'
    },
    'Excerpt': {
        'Highlights': [
            {
                'BeginOffset': 0,
                'EndOffset': 8,
                'TopAnswer': False
            }
        ],
        'Text': '605feet'
    },
    'Type': 'QUESTION_ANSWER',
    'QuestionText': {
        'Highlights': [
            {
                'BeginOffset': 12,
                'EndOffset': 18,
                'TopAnswer': False
            },
            {
                'BeginOffset': 26,
                'EndOffset': 31,
                'TopAnswer': False
            },
            {
                'BeginOffset': 32,
                'EndOffset': 38,
                'TopAnswer': False
            }
        ],
        'Text': 'whatistheheightoftheSpaceNeedle?'
    }
}
```

For information about adding question and answer text to an index, see [Adding questions and answers](in-creating-faq.md)