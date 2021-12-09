# LiteralArrayOptions<a name="API_LiteralArrayOptions"></a>

## Description<a name="API_LiteralArrayOptions_Description"></a>

Options for a field that contains an array of literal strings\. Present if `IndexFieldType` specifies the field is of type `literal-array`\. All options are enabled by default\.

## Contents<a name="API_LiteralArrayOptions_Contents"></a>

 **DefaultValue**   
 A value to use for the field if the field isn't specified for a document\.   
Type: String  
 Length constraints: Minimum length of 0\. Maximum length of 1024\.   
 Required: No 

 **FacetEnabled**   
Whether facet information can be returned for the field\.  
Type: Boolean  
 Required: No 

 **ReturnEnabled**   
Whether the contents of the field can be returned in the search results\.  
Type: Boolean  
 Required: No 

 **SearchEnabled**   
Whether the contents of the field are searchable\.  
Type: Boolean  
 Required: No 

 **SourceFields**   
A list of source fields to map to the field\.   
Type: String  
 Required: No 