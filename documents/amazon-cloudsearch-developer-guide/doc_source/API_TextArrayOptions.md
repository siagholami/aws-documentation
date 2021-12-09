# TextArrayOptions<a name="API_TextArrayOptions"></a>

## Description<a name="API_TextArrayOptions_Description"></a>

Options for a field that contains an array of text strings\. Present if `IndexFieldType` specifies the field is of type `text-array`\. A `text-array` field is always searchable\. All options are enabled by default\.

## Contents<a name="API_TextArrayOptions_Contents"></a>

 **AnalysisScheme**   
The name of an analysis scheme for a `text-array` field\.  
Type: String  
 Required: No 

 **DefaultValue**   
 A value to use for the field if the field isn't specified for a document\.   
Type: String  
 Length constraints: Minimum length of 0\. Maximum length of 1024\.   
 Required: No 

 **HighlightEnabled**   
Whether highlights can be returned for the field\.  
Type: Boolean  
 Required: No 

 **ReturnEnabled**   
Whether the contents of the field can be returned in the search results\.  
Type: Boolean  
 Required: No 

 **SourceFields**   
A list of source fields to map to the field\.   
Type: String  
 Required: No 