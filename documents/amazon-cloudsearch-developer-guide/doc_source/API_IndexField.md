# IndexField<a name="API_IndexField"></a>

## Description<a name="API_IndexField_Description"></a>

Configuration information for a field in the index, including its name, type, and options\. The supported options depend on the ` IndexFieldType `\.

## Contents<a name="API_IndexField_Contents"></a>

 **DateArrayOptions**   
Options for a field that contains an array of dates\. Present if `IndexFieldType` specifies the field is of type `date-array`\. All options are enabled by default\.  
Type: [DateArrayOptions](API_DateArrayOptions.md)   
 Required: No 

 **DateOptions**   
Options for a date field\. Dates and times are specified in UTC \(Coordinated Universal Time\) according to IETF RFC3339: yyyy\-mm\-ddT00:00:00Z\. Present if `IndexFieldType` specifies the field is of type `date`\. All options are enabled by default\.  
Type: [DateOptions](API_DateOptions.md)   
 Required: No 

 **DoubleArrayOptions**   
Options for a field that contains an array of double\-precision 64\-bit floating point values\. Present if `IndexFieldType` specifies the field is of type `double-array`\. All options are enabled by default\.  
Type: [DoubleArrayOptions](API_DoubleArrayOptions.md)   
 Required: No 

 **DoubleOptions**   
Options for a double\-precision 64\-bit floating point field\. Present if `IndexFieldType` specifies the field is of type `double`\. All options are enabled by default\.  
Type: [DoubleOptions](API_DoubleOptions.md)   
 Required: No 

 **IndexFieldName**   
A string that represents the name of an index field\. CloudSearch supports regular index fields as well as dynamic fields\. A dynamic field's name defines a pattern that begins or ends with a wildcard\. Any document fields that don't map to a regular index field but do match a dynamic field's pattern are configured with the dynamic field's indexing options\.   
Regular field names begin with a letter and can contain the following characters: a\-z \(lowercase\), 0\-9, and \_ \(underscore\)\. Dynamic field names must begin or end with a wildcard \(\*\)\. The wildcard can also be the only character in a dynamic field name\. Multiple wildcards, and wildcards embedded within a string are not supported\.   
The name `score` is reserved and cannot be used as a field name\. To reference a document's ID, you can use the name `_id`\.   
Type: String  
 Length constraints: Minimum length of 1\. Maximum length of 64\.   
 Required: Yes 

 **IndexFieldType**   
The type of field\. The valid options for a field depend on the field type\. For more information about the supported field types, see [Configuring Index Fields](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-index-fields.html) in the *Amazon CloudSearch Developer Guide*\.  
Type: String  
 Valid Values: `int | double | literal | text | date | latlon | int-array | double-array | literal-array | text-array | date-array`   
 Required: Yes 

 **IntArrayOptions**   
Options for a field that contains an array of 64\-bit signed integers\. Present if `IndexFieldType` specifies the field is of type `int-array`\. All options are enabled by default\.  
Type: [IntArrayOptions](API_IntArrayOptions.md)   
 Required: No 

 **IntOptions**   
Options for a 64\-bit signed integer field\. Present if `IndexFieldType` specifies the field is of type `int`\. All options are enabled by default\.  
Type: [IntOptions](API_IntOptions.md)   
 Required: No 

 **LatLonOptions**   
Options for a latlon field\. A latlon field contains a location stored as a latitude and longitude value pair\. Present if `IndexFieldType` specifies the field is of type `latlon`\. All options are enabled by default\.  
Type: [LatLonOptions](API_LatLonOptions.md)   
 Required: No 

 **LiteralArrayOptions**   
Options for a field that contains an array of literal strings\. Present if `IndexFieldType` specifies the field is of type `literal-array`\. All options are enabled by default\.  
Type: [LiteralArrayOptions](API_LiteralArrayOptions.md)   
 Required: No 

 **LiteralOptions**   
Options for literal field\. Present if `IndexFieldType` specifies the field is of type `literal`\. All options are enabled by default\.  
Type: [LiteralOptions](API_LiteralOptions.md)   
 Required: No 

 **TextArrayOptions**   
Options for a field that contains an array of text strings\. Present if `IndexFieldType` specifies the field is of type `text-array`\. A `text-array` field is always searchable\. All options are enabled by default\.  
Type: [TextArrayOptions](API_TextArrayOptions.md)   
 Required: No 

 **TextOptions**   
Options for text field\. Present if `IndexFieldType` specifies the field is of type `text`\. A `text` field is always searchable\. All options are enabled by default\.  
Type: [TextOptions](API_TextOptions.md)   
 Required: No 