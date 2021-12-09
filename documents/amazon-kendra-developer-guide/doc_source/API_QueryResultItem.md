--------

--------

# QueryResultItem<a name="API_QueryResultItem"></a>

A single query result\.

A query result contains information about a document returned by the query\. This includes the original location of the document, a list of attributes assigned to the document, and relevant text from the document that satisfies the query\.

## Contents<a name="API_QueryResultItem_Contents"></a>

 **AdditionalAttributes**   <a name="Kendra-Type-QueryResultItem-AdditionalAttributes"></a>
One or more additional attributes associated with the query result\.  
Type: Array of [AdditionalResultAttribute](API_AdditionalResultAttribute.md) objects  
Required: No

 **DocumentAttributes**   <a name="Kendra-Type-QueryResultItem-DocumentAttributes"></a>
An array of document attributes for the document that the query result maps to\. For example, the document author \(Author\) or the source URI \(SourceUri\) of the document\.  
Type: Array of [DocumentAttribute](API_DocumentAttribute.md) objects  
Required: No

 **DocumentExcerpt**   <a name="Kendra-Type-QueryResultItem-DocumentExcerpt"></a>
An extract of the text in the document\. Contains information about highlighting the relevant terms in the excerpt\.  
Type: [TextWithHighlights](API_TextWithHighlights.md) object  
Required: No

 **DocumentId**   <a name="Kendra-Type-QueryResultItem-DocumentId"></a>
The unique identifier for the document\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Required: No

 **DocumentTitle**   <a name="Kendra-Type-QueryResultItem-DocumentTitle"></a>
The title of the document\. Contains the text of the title and information for highlighting the relevant terms in the title\.  
Type: [TextWithHighlights](API_TextWithHighlights.md) object  
Required: No

 **DocumentURI**   <a name="Kendra-Type-QueryResultItem-DocumentURI"></a>
The URI of the original location of the document\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `^(https?|ftp|file):\/\/([^\s]*)`   
Required: No

 **Id**   <a name="Kendra-Type-QueryResultItem-Id"></a>
The unique identifier for the query result\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 73\.  
Required: No

 **ScoreAttributes**   <a name="Kendra-Type-QueryResultItem-ScoreAttributes"></a>
Indicates the confidence that Amazon Kendra has that a result matches the query that you provided\. Each result is placed into a bin that indicates the confidence, `VERY_HIGH`, `HIGH`, and `MEDIUM`\. You can use the score to determine if a response meets the confidence needed for your application\.  
Confidence scores are only returned for results with the `Type` field set to `QUESTION_ANSWER` or `ANSWER`\. This field is not returned if the `Type` field is set to `DOCUMENT`\.  
Type: [ScoreAttributes](API_ScoreAttributes.md) object  
Required: No

 **Type**   <a name="Kendra-Type-QueryResultItem-Type"></a>
The type of document\.   
Type: String  
Valid Values:` DOCUMENT | QUESTION_ANSWER | ANSWER`   
Required: No

## See Also<a name="API_QueryResultItem_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/QueryResultItem) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/QueryResultItem) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/QueryResultItem) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/QueryResultItem) 