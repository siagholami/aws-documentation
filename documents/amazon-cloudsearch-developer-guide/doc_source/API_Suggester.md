# Suggester<a name="API_Suggester"></a>

## Description<a name="API_Suggester_Description"></a>

Configuration information for a search suggester\. Each suggester has a unique name and specifies the text field you want to use for suggestions\. The following options can be configured for a suggester: `FuzzyMatching`, `SortExpression`\. 

## Contents<a name="API_Suggester_Contents"></a>

 **DocumentSuggesterOptions**   
Options for a search suggester\.  
Type: [DocumentSuggesterOptions](API_DocumentSuggesterOptions.md)   
 Required: Yes 

 **SuggesterName**   
Names must begin with a letter and can contain the following characters: a\-z \(lowercase\), 0\-9, and \_ \(underscore\)\.  
Type: String  
 Length constraints: Minimum length of 1\. Maximum length of 64\.   
 Required: Yes 