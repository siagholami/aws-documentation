--------

--------

# Relevance<a name="API_Relevance"></a>

Provides information for manually tuning the relevance of a field in a search\. When a query includes terms that match the field, the results are given a boost in the response based on these tuning parameters\.

## Contents<a name="API_Relevance_Contents"></a>

 **Duration**   <a name="Kendra-Type-Relevance-Duration"></a>
Specifies the time period that the boost applies to\. For example, to make the boost apply to documents with the field value within the last month, you would use "2628000s"\. Once the field value is beyond the specified range, the effect of the boost drops off\. The higher the importance, the faster the effect drops off\. If you don't specify a value, the default is 3 months\. The value of the field is a numeric string followed by the character "s", for example "86400s" for one day, or "604800s" for one week\.   
Only applies to `DATE` fields\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 10\.  
Pattern: `[0-9]+[s]`   
Required: No

 **Freshness**   <a name="Kendra-Type-Relevance-Freshness"></a>
Indicates that this field determines how "fresh" a document is\. For example, if document 1 was created on November 5, and document 2 was created on October 31, document 1 is "fresher" than document 2\. You can only set the `Freshness` field on one `DATE` type field\. Only applies to `DATE` fields\.  
Type: Boolean  
Required: No

 **Importance**   <a name="Kendra-Type-Relevance-Importance"></a>
The relative importance of the field in the search\. Larger numbers provide more of a boost than smaller numbers\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 10\.  
Required: No

 **RankOrder**   <a name="Kendra-Type-Relevance-RankOrder"></a>
Determines how values should be interpreted\.  
When the `RankOrder` field is `ASCENDING`, higher numbers are better\. For example, a document with a rating score of 10 is higher ranking than a document with a rating score of 1\.  
When the `RankOrder` field is `DESCENDING`, lower numbers are better\. For example, in a task tracking application, a priority 1 task is more important than a priority 5 task\.  
Only applies to `LONG` and `DOUBLE` fields\.  
Type: String  
Valid Values:` ASCENDING | DESCENDING`   
Required: No

 **ValueImportanceMap**   <a name="Kendra-Type-Relevance-ValueImportanceMap"></a>
A list of values that should be given a different boost when they appear in the result list\. For example, if you are boosting a field called "department," query terms that match the department field are boosted in the result\. However, you can add entries from the department field to boost documents with those values higher\.   
For example, you can add entries to the map with names of departments\. If you add "HR",5 and "Legal",3 those departments are given special attention when they appear in the metadata of a document\. When those terms appear they are given the specified importance instead of the regular importance for the boost\.  
Type: String to integer map  
Key Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Valid Range: Minimum value of 1\. Maximum value of 10\.  
Required: No

## See Also<a name="API_Relevance_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/Relevance) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/Relevance) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/Relevance) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/Relevance) 