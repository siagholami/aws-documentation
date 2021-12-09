--------

--------

# DescribeDataSource<a name="API_DescribeDataSource"></a>

Gets information about a Amazon Kendra data source\.

## Request Syntax<a name="API_DescribeDataSource_RequestSyntax"></a>

```
{
   "Id": "string",
   "IndexId": "string"
}
```

## Request Parameters<a name="API_DescribeDataSource_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [Id](#API_DescribeDataSource_RequestSyntax) **   <a name="Kendra-DescribeDataSource-request-Id"></a>
The unique identifier of the data source to describe\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: Yes

 ** [IndexId](#API_DescribeDataSource_RequestSyntax) **   <a name="Kendra-DescribeDataSource-request-IndexId"></a>
The identifier of the index that contains the data source\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

## Response Syntax<a name="API_DescribeDataSource_ResponseSyntax"></a>

```
{
   "Configuration": { 
      "DatabaseConfiguration": { 
         "AclConfiguration": { 
            "AllowedGroupsColumnName": "string"
         },
         "ColumnConfiguration": { 
            "ChangeDetectingColumns": [ "string" ],
            "DocumentDataColumnName": "string",
            "DocumentIdColumnName": "string",
            "DocumentTitleColumnName": "string",
            "FieldMappings": [ 
               { 
                  "DataSourceFieldName": "string",
                  "DateFieldFormat": "string",
                  "IndexFieldName": "string"
               }
            ]
         },
         "ConnectionConfiguration": { 
            "DatabaseHost": "string",
            "DatabaseName": "string",
            "DatabasePort": number,
            "SecretArn": "string",
            "TableName": "string"
         },
         "DatabaseEngineType": "string",
         "SqlConfiguration": { 
            "QueryIdentifiersEnclosingOption": "string"
         },
         "VpcConfiguration": { 
            "SecurityGroupIds": [ "string" ],
            "SubnetIds": [ "string" ]
         }
      },
      "OneDriveConfiguration": { 
         "ExclusionPatterns": [ "string" ],
         "FieldMappings": [ 
            { 
               "DataSourceFieldName": "string",
               "DateFieldFormat": "string",
               "IndexFieldName": "string"
            }
         ],
         "InclusionPatterns": [ "string" ],
         "OneDriveUsers": { 
            "OneDriveUserList": [ "string" ],
            "OneDriveUserS3Path": { 
               "Bucket": "string",
               "Key": "string"
            }
         },
         "SecretArn": "string",
         "TenantDomain": "string"
      },
      "S3Configuration": { 
         "AccessControlListConfiguration": { 
            "KeyPath": "string"
         },
         "BucketName": "string",
         "DocumentsMetadataConfiguration": { 
            "S3Prefix": "string"
         },
         "ExclusionPatterns": [ "string" ],
         "InclusionPrefixes": [ "string" ]
      },
      "SalesforceConfiguration": { 
         "ChatterFeedConfiguration": { 
            "DocumentDataFieldName": "string",
            "DocumentTitleFieldName": "string",
            "FieldMappings": [ 
               { 
                  "DataSourceFieldName": "string",
                  "DateFieldFormat": "string",
                  "IndexFieldName": "string"
               }
            ],
            "IncludeFilterTypes": [ "string" ]
         },
         "CrawlAttachments": boolean,
         "ExcludeAttachmentFilePatterns": [ "string" ],
         "IncludeAttachmentFilePatterns": [ "string" ],
         "KnowledgeArticleConfiguration": { 
            "CustomKnowledgeArticleTypeConfigurations": [ 
               { 
                  "DocumentDataFieldName": "string",
                  "DocumentTitleFieldName": "string",
                  "FieldMappings": [ 
                     { 
                        "DataSourceFieldName": "string",
                        "DateFieldFormat": "string",
                        "IndexFieldName": "string"
                     }
                  ],
                  "Name": "string"
               }
            ],
            "IncludedStates": [ "string" ],
            "StandardKnowledgeArticleTypeConfiguration": { 
               "DocumentDataFieldName": "string",
               "DocumentTitleFieldName": "string",
               "FieldMappings": [ 
                  { 
                     "DataSourceFieldName": "string",
                     "DateFieldFormat": "string",
                     "IndexFieldName": "string"
                  }
               ]
            }
         },
         "SecretArn": "string",
         "ServerUrl": "string",
         "StandardObjectAttachmentConfiguration": { 
            "DocumentTitleFieldName": "string",
            "FieldMappings": [ 
               { 
                  "DataSourceFieldName": "string",
                  "DateFieldFormat": "string",
                  "IndexFieldName": "string"
               }
            ]
         },
         "StandardObjectConfigurations": [ 
            { 
               "DocumentDataFieldName": "string",
               "DocumentTitleFieldName": "string",
               "FieldMappings": [ 
                  { 
                     "DataSourceFieldName": "string",
                     "DateFieldFormat": "string",
                     "IndexFieldName": "string"
                  }
               ],
               "Name": "string"
            }
         ]
      },
      "ServiceNowConfiguration": { 
         "HostUrl": "string",
         "KnowledgeArticleConfiguration": { 
            "CrawlAttachments": boolean,
            "DocumentDataFieldName": "string",
            "DocumentTitleFieldName": "string",
            "ExcludeAttachmentFilePatterns": [ "string" ],
            "FieldMappings": [ 
               { 
                  "DataSourceFieldName": "string",
                  "DateFieldFormat": "string",
                  "IndexFieldName": "string"
               }
            ],
            "IncludeAttachmentFilePatterns": [ "string" ]
         },
         "SecretArn": "string",
         "ServiceCatalogConfiguration": { 
            "CrawlAttachments": boolean,
            "DocumentDataFieldName": "string",
            "DocumentTitleFieldName": "string",
            "ExcludeAttachmentFilePatterns": [ "string" ],
            "FieldMappings": [ 
               { 
                  "DataSourceFieldName": "string",
                  "DateFieldFormat": "string",
                  "IndexFieldName": "string"
               }
            ],
            "IncludeAttachmentFilePatterns": [ "string" ]
         },
         "ServiceNowBuildVersion": "string"
      },
      "SharePointConfiguration": { 
         "CrawlAttachments": boolean,
         "DocumentTitleFieldName": "string",
         "ExclusionPatterns": [ "string" ],
         "FieldMappings": [ 
            { 
               "DataSourceFieldName": "string",
               "DateFieldFormat": "string",
               "IndexFieldName": "string"
            }
         ],
         "InclusionPatterns": [ "string" ],
         "SecretArn": "string",
         "SharePointVersion": "string",
         "Urls": [ "string" ],
         "UseChangeLog": boolean,
         "VpcConfiguration": { 
            "SecurityGroupIds": [ "string" ],
            "SubnetIds": [ "string" ]
         }
      }
   },
   "CreatedAt": number,
   "Description": "string",
   "ErrorMessage": "string",
   "Id": "string",
   "IndexId": "string",
   "Name": "string",
   "RoleArn": "string",
   "Schedule": "string",
   "Status": "string",
   "Type": "string",
   "UpdatedAt": number
}
```

## Response Elements<a name="API_DescribeDataSource_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [Configuration](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-Configuration"></a>
Information that describes where the data source is located and how the data source is configured\. The specific information in the description depends on the data source provider\.  
Type: [DataSourceConfiguration](API_DataSourceConfiguration.md) object

 ** [CreatedAt](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-CreatedAt"></a>
The Unix timestamp of when the data source was created\.  
Type: Timestamp

 ** [Description](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-Description"></a>
The description of the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1000\.  
Pattern: `^\P{C}*$` 

 ** [ErrorMessage](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-ErrorMessage"></a>
When the `Status` field value is `FAILED`, the `ErrorMessage` field contains a description of the error that caused the data source to fail\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `^\P{C}*$` 

 ** [Id](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-Id"></a>
The identifier of the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*` 

 ** [IndexId](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-IndexId"></a>
The identifier of the index that contains the data source\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*` 

 ** [Name](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-Name"></a>
The name that you gave the data source when it was created\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1000\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*` 

 ** [RoleArn](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-RoleArn"></a>
The Amazon Resource Name \(ARN\) of the role that enables the data source to access its resources\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}` 

 ** [Schedule](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-Schedule"></a>
The schedule that Amazon Kendra will update the data source\.  
Type: String

 ** [Status](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-Status"></a>
The current status of the data source\. When the status is `ACTIVE` the data source is ready to use\. When the status is `FAILED`, the `ErrorMessage` field contains the reason that the data source failed\.  
Type: String  
Valid Values:` CREATING | DELETING | FAILED | UPDATING | ACTIVE` 

 ** [Type](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-Type"></a>
The type of the data source\.  
Type: String  
Valid Values:` S3 | SHAREPOINT | DATABASE | SALESFORCE | ONEDRIVE | SERVICENOW` 

 ** [UpdatedAt](#API_DescribeDataSource_ResponseSyntax) **   <a name="Kendra-DescribeDataSource-response-UpdatedAt"></a>
The Unix timestamp of when the data source was last updated\.  
Type: Timestamp

## Errors<a name="API_DescribeDataSource_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceNotFoundException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_DescribeDataSource_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/DescribeDataSource) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/DescribeDataSource) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/DescribeDataSource) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/DescribeDataSource) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/DescribeDataSource) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/DescribeDataSource) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/DescribeDataSource) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/DescribeDataSource) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/DescribeDataSource) 