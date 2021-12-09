# SolutionVersionSummary<a name="API_SolutionVersionSummary"></a>

Provides a summary of the properties of a solution version\. For a complete listing, call the [DescribeSolutionVersion](API_DescribeSolutionVersion.md) API\.

## Contents<a name="API_SolutionVersionSummary_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-SolutionVersionSummary-creationDateTime"></a>
The date and time \(in Unix time\) that this version of a solution was created\.  
Type: Timestamp  
Required: No

 **failureReason**   <a name="personalize-Type-SolutionVersionSummary-failureReason"></a>
If a solution version fails, the reason behind the failure\.  
Type: String  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-SolutionVersionSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the solution version was last updated\.  
Type: Timestamp  
Required: No

 **solutionVersionArn**   <a name="personalize-Type-SolutionVersionSummary-solutionVersionArn"></a>
The Amazon Resource Name \(ARN\) of the solution version\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **status**   <a name="personalize-Type-SolutionVersionSummary-status"></a>
The status of the solution version\.  
A solution version can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_SolutionVersionSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/SolutionVersionSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/SolutionVersionSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/SolutionVersionSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/SolutionVersionSummary) 