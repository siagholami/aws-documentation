# IntOptions<a name="API_IntOptions"></a>

## Description<a name="API_IntOptions_Description"></a>

Options for a 64\-bit signed integer field\. Present if `IndexFieldType` specifies the field is of type `int`\. All options are enabled by default\.

## Contents<a name="API_IntOptions_Contents"></a>

 **DefaultValue**   
 A value to use for the field if the field isn't specified for a document\. This can be important if you are using the field in an expression and that field is not present in every document\.   
Type: Long  
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

 **SortEnabled**   
Whether the field can be used to sort the search results\.  
Type: Boolean  
 Required: No 

 **SourceField**   
The name of the source field to map to the field\.   
Type: String  
 Length constraints: Minimum length of 1\. Maximum length of 64\.   
 Required: No 