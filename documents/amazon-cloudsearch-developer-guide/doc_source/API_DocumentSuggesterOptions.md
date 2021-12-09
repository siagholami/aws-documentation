# DocumentSuggesterOptions<a name="API_DocumentSuggesterOptions"></a>

## Description<a name="API_DocumentSuggesterOptions_Description"></a>

Options for a search suggester\.

## Contents<a name="API_DocumentSuggesterOptions_Contents"></a>

 **FuzzyMatching**   
The level of fuzziness allowed when suggesting matches for a string: `none`, `low`, or `high`\. With none, the specified string is treated as an exact prefix\. With low, suggestions must differ from the specified string by no more than one character\. With high, suggestions can differ by up to two characters\. The default is none\.   
Type: String  
 Valid Values: `none | low | high`   
 Required: No 

 **SortExpression**   
An expression that computes a score for each suggestion to control how they are sorted\. The scores are rounded to the nearest integer, with a floor of 0 and a ceiling of 2^31\-1\. A document's relevance score is not computed for suggestions, so sort expressions cannot reference the `_score` value\. To sort suggestions using a numeric field or existing expression, simply specify the name of the field or expression\. If no expression is configured for the suggester, the suggestions are sorted with the closest matches listed first\.  
Type: String  
 Required: No 

 **SourceField**   
The name of the index field you want to use for suggestions\.   
Type: String  
 Length constraints: Minimum length of 1\. Maximum length of 64\.   
 Required: Yes 