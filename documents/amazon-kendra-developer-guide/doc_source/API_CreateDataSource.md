--------

--------

# CreateDataSource<a name="API_CreateDataSource"></a>

Creates a data source that you use to with an Amazon Kendra index\. 

You specify a name, connector type and description for your data source\. You can choose between an S3 connector, a SharePoint Online connector, and a database connector\.

You also specify configuration information such as document metadata \(author, source URI, and so on\) and user context information\.

 `CreateDataSource` is a synchronous operation\. The operation returns 200 if the data source was successfully created\. Otherwise, an exception is raised\.

## Request Syntax<a name="API_CreateDataSource_RequestSyntax"></a>

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
   "Description": "string",
   "IndexId": "string",
   "Name": "string",
   "RoleArn": "string",
   "Schedule": "string",
   "Tags": [ 
      { 
         "Key": "string",
         "Value": "string"
      }
   ],
   "Type": "string"
}
```

## Request Parameters<a name="API_CreateDataSource_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [Configuration](#API_CreateDataSource_RequestSyntax) **   <a name="Kendra-CreateDataSource-request-Configuration"></a>
The connector configuration information that is required to access the repository\.  
Type: [DataSourceConfiguration](API_DataSourceConfiguration.md) object  
Required: Yes

 ** [Description](#API_CreateDataSource_RequestSyntax) **   <a name="Kendra-CreateDataSource-request-Description"></a>
A description for the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1000\.  
Pattern: `^\P{C}*$`   
Required: No

 ** [IndexId](#API_CreateDataSource_RequestSyntax) **   <a name="Kendra-CreateDataSource-request-IndexId"></a>
The identifier of the index that should be associated with this data source\.  
Type: String  
Length Constraints: Fixed length of 36\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9-]*`   
Required: Yes

 ** [Name](#API_CreateDataSource_RequestSyntax) **   <a name="Kendra-CreateDataSource-request-Name"></a>
A unique name for the data source\. A data source name can't be changed without deleting and recreating the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1000\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: Yes

 ** [RoleArn](#API_CreateDataSource_RequestSyntax) **   <a name="Kendra-CreateDataSource-request-RoleArn"></a>
The Amazon Resource Name \(ARN\) of a role with permission to access the data source\. For more information, see [IAM Roles for Amazon Kendra](https://docs.aws.amazon.com/kendra/latest/dg/iam-roles.html)\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}`   
Required: Yes

 ** [Schedule](#API_CreateDataSource_RequestSyntax) **   <a name="Kendra-CreateDataSource-request-Schedule"></a>
Sets the frequency that Amazon Kendra will check the documents in your repository and update the index\. If you don't set a schedule Amazon Kendra will not periodically update the index\. You can call the `StartDataSourceSyncJob` operation to update the index\.  
Type: String  
Required: No

 ** [Tags](#API_CreateDataSource_RequestSyntax) **   <a name="Kendra-CreateDataSource-request-Tags"></a>
A list of key\-value pairs that identify the data source\. You can use the tags to identify and organize your resources and to control access to resources\.  
Type: Array of [Tag](API_Tag.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 200 items\.  
Required: No

 ** [Type](#API_CreateDataSource_RequestSyntax) **   <a name="Kendra-CreateDataSource-request-Type"></a>
The type of repository that contains the data source\.  
Type: String  
Valid Values:` S3 | SHAREPOINT | DATABASE | SALESFORCE | ONEDRIVE | SERVICENOW`   
Required: Yes

## Response Syntax<a name="API_CreateDataSource_ResponseSyntax"></a>

```
{
   "Id": "string"
}
```

## Response Elements<a name="API_CreateDataSource_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [Id](#API_CreateDataSource_ResponseSyntax) **   <a name="Kendra-CreateDataSource-response-Id"></a>
A unique identifier for the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*` 

## Errors<a name="API_CreateDataSource_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **ConflictException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceAlreadyExistException**   
HTTP Status Code: 400

 **ResourceNotFoundException**   
HTTP Status Code: 400

 **ServiceQuotaExceededException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_CreateDataSource_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/CreateDataSource) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/CreateDataSource) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/CreateDataSource) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/CreateDataSource) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/CreateDataSource) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/CreateDataSource) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/CreateDataSource) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/CreateDataSource) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/CreateDataSource) 