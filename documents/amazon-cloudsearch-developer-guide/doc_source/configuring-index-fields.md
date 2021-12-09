# Configuring Index Fields for an Amazon CloudSearch Domain<a name="configuring-index-fields"></a>

Each document that you add to your search domain has a collection of fields that contain the data that can be searched or returned\. Every document must have a unique document ID and at least one field\. 

In your domain configuration, you define an index field for each of the fields that occur in your documents\. You cannot upload documents that contain unrecognized fields\. However, every document does not have to contain all fields—documents can contain a subset of the fields configured for the domain\.

**Topics**
+ [Configuring Individual Index Fields with the AWS CLI](#configuring-index-fields-individually-clt)
+ [Configuring Index Fields Using the Amazon CloudSearch Console](#configuring-index-fields-console)
+ [DefineIndexField](#configuring-index-fields-sdk)

Amazon CloudSearch supports the following index field types:
+ `date`—contains a timestamp\. Dates and times are specified in UTC \(Coordinated Universal Time\) according to [IETF RFC3339](http://tools.ietf.org/html/rfc3339): `yyyy-mm-ddTHH:mm:ss.SSSZ`\. In UTC, for example, 5:00 PM August 23, 1970 is: `1970-08-23T17:00:00Z`\. Note that you can also specify fractional seconds when specifying times in UTC\. For example, `1967-01-31T23:20:50.650Z.` 
+ `date-array`—a date field that can contain multiple values\. 
+ `double`—contains a double\-precision 64\-bit floating point value\.
+ `double-array`—a double field that can contain multiple values\. 
+ `int`—contains a 64\-bit signed integer value\. 
+ `int-array`—an integer field that can contain multiple values\. 
+ `latlon`—contains a location stored as a latitude and longitude value pair \(`lat, lon`\)\.
+ `literal`—contains an identifier or other data that you want to be able to match exactly\. Literal fields are case\-sensitive\.
+ `literal-array`—a literal field that can contain multiple values\. 
+ `text`—contains arbitrary alphanumeric data\. 
+ `text-array`—a text field that can contain multiple values\. 

Regular index field names must begin with a letter and be at least 3 and no more than 64 characters long\. The allowed characters are: a\-z \(lower\-case letters\), 0\-9, and \_ \(underscore\)\. The name *score* is reserved and cannot be specified as a field name\. All field and expression names must be unique\. 

Dynamic field names must either begin or end with a wildcard \(\*\)\. The string before or after the wildcard can contain the same set of characters as a regular index field\. For more information about dynamic fields, see [Using Dynamic Fields in Amazon CloudSearch](using-dynamic-fields.md)\.

The options you can configure for a field vary according to the field type:
+ `HighlightEnabled`—You can get highlighting information for the search hits in any `HighlightEnabled` text field\. Valid for: `text`, `text-array`\.
+ `FacetEnabled`—You can get facet information for any `FacetEnabled` field\. Text fields cannot be used for faceting\. Valid for: `int`, `int-array`, `date`, `date-array`, `double`, `double-array`, `latlon`, `literal`, `literal-array`\. 
+ `ReturnEnabled`—You can retrieve the value of any `ReturnEnabled` field with your search results\. Note that this increases the size of your index, which can increase the cost of running your domain\. When possible, it's best to retrieve large amounts of data from an external source, rather than embedding it in your index\. Since it can take some time to apply document updates across the domain, critical data such as pricing information should be retrieved from an external source using the returned document IDs\. Valid for: `int`, `int-array`, `date`, `date-array`, `double`, `double-array`, `latlon`, `literal`, `literal-array`, `text`, `text-array`\. 
+ `SearchEnabled`—You can search the contents of any `SearchEnabled` field\. Text fields are always searchable\. Valid for: `int`, `int-array`, `date`, `date-array`, `double`, `double-array`, `latlon`, `literal`, `literal-array`, `text`, `text-array`\. 
+ `SortEnabled`—You can sort the search results alphabetically or numerically using any `SortEnabled` field\. Array\-type fields cannot be `SortEnabled`\. Only sort enabled numeric fields can be used in expressions\. Valid for: `int`, `date`, `latlon`, `double`, `literal`, `text`\.

You can also specify a default value and a source for any field\. Specifying a default value can be important if you are using a numeric field in an expression and that field is not present in every document\. Specifying a source copies data from one field to another, enabling you to use the same source data in different ways by configuring different options for the fields\. You can use a wildcard \(\*\) when specifying the source name to copy data from all fields that match the specified pattern\. 

When you add fields or modify existing fields, you must explicitly issue a request to re\-index your data when you are done making configuration changes\. For more information, see [Indexing Document Data](indexing.md)\.

**Important**  
If you change the type of a field and have documents in your index that contain data that is incompatible with the new field type, all fields being processed are put in the `FailedToValidate` state when you run indexing and the indexing operation fails\. Rolling back the incompatible configuration change will enable you to successfully rebuild your index\. If the change is necessary, you must update or remove the incompatible documents from your index to use the new configuration\.

## Configuring Individual Index Fields with the AWS CLI<a name="configuring-index-fields-individually-clt"></a>

You use the `aws cloudsearch define-index-field` command to configure individual index fields for a search domain\. For information about installing and setting up the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

**To add an index field to your domain**
+ Run the `aws cloudsearch define-index-field` command and specify the name of the new field with the `--name` option, and the field type with the `--type` option\. The following example adds an `int` field called `year` to the movies domain\.  
**Example**  

  ```
  aws cloudsearch define-index-field --domain-name movies --name year --type int
  {
      "IndexField": {
          "Status": {
              "PendingDeletion": false, 
              "State": "RequiresIndexDocuments", 
              "CreationDate": "2014-06-25T23:03:06Z", 
              "UpdateVersion": 15, 
              "UpdateDate": "2014-06-25T23:03:06Z"
          }, 
          "Options": {
              "IndexFieldType": "int", 
              "IndexFieldName": "year"
          }
      }
  }
  ```

**Note**  
When you add fields or modify existing fields, you must explicitly issue a request to re\-index your data when you are done making configuration changes\. For more information, see [Indexing Document Data](indexing.md)\.

## Configuring Index Fields Using the Amazon CloudSearch Console<a name="configuring-index-fields-console"></a>

You can easily [configure individual index fields](#configuring-index-fields-individually-console) for your domain through the **Indexing Options** panel in the Amazon CloudSearch console\. Configuring index fields in the console requires the `DefineIndexFields` action, which the AWS CLI doesn't support\.

### Configuring Individual Fields Using the Amazon CloudSearch Console<a name="configuring-index-fields-individually-console"></a>

**To configure a new index field**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain that you want to configure, and then click the domain's **Indexing Options** link\.

1. To create a new index field, click **Add Index Field** to add a field specification to the list\. \(If you haven't created any fields yet, a blank field specification is shown on the Indexing Options page by default\.\)

1. Specify a unique name for the field and select the field type: `date`, `date-array`, `double`, `double-array`, `int`, `int-array`, `literal`,` literal-array`, `text`, `text-array`\. Field names must begin with a letter and be at least 3 and no more than 64 characters long\. The allowed characters are: a\-z \(lower\-case letters\), 0\-9, and \_ \(underscore\)\. The name *score* is reserved and cannot be used as a field name\.

1. Select the options you want to enable for the field\. For more information about specifying indexing options, see [Configuring Index Fields](#configuring-index-fields) 

1. Specify a default value for the field \(optional\)\. This value is used when no value is specified for the field in the document data\.

1. Select the analysis scheme you want to use for each text field\. The analysis scheme specifies the language\-specific text processing options that are used during indexing\. By default, text fields use the `_en_default_` analysis scheme\. For more information, see [Configuring Analysis Schemes](configuring-analysis-schemes.md)\.

1. To configure additional fields, click **Add Index Field** and repeat these configuration steps\.

1. When you are done configuring fields, click **Submit** to save your changes\. To restore the previous field configurations, click **Revert**\.

**Note**  
When you add fields or modify existing fields, you must explicitly issue a request to re\-index your data when you are done making configuration changes\. For more information, see [Indexing Document Data](indexing.md)\.

## Configuring Amazon CloudSearch Index Fields Using the AWS SDKs<a name="configuring-index-fields-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[DefineIndexField](API_DefineIndexField.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.