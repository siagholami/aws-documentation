# SolutionSummary<a name="API_SolutionSummary"></a>

Provides a summary of the properties of a solution\. For a complete listing, call the [DescribeSolution](API_DescribeSolution.md) API\.

## Contents<a name="API_SolutionSummary_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-SolutionSummary-creationDateTime"></a>
The date and time \(in Unix time\) that the solution was created\.  
Type: Timestamp  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-SolutionSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the solution was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-SolutionSummary-name"></a>
The name of the solution\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **solutionArn**   <a name="personalize-Type-SolutionSummary-solutionArn"></a>
The Amazon Resource Name \(ARN\) of the solution\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **status**   <a name="personalize-Type-SolutionSummary-status"></a>
The status of the solution\.  
A solution can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_SolutionSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/SolutionSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/SolutionSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/SolutionSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/SolutionSummary) 