# AWS Glue API Permissions: Actions and Resources Reference<a name="api-permissions-reference"></a>

Use the following table as a reference when you're setting up [Identity and Access Management in AWS Glue](authentication-and-access-control.md) and writing a permissions policy to attach to an IAM identity \(identity\-based policy\) or to a resource \(resource policy\)\. The table lists each AWS Glue API operation, the corresponding actions for which you can grant permissions to perform the action, and the AWS resource for which you can grant the permissions\. You specify the actions in the policy's `Action` field, and you specify the resource value in the policy's `Resource` field\. 

Actions on some AWS Glue resources require that ancestor and child resource ARNs are also included in the policy's `Resource` field\. For more information, see [Data Catalog ARNs](glue-specifying-resource-arns.md#data-catalog-resource-arns)\. 

Generally, you can replace ARN segments with wildcards\. For more information, see [IAM JSON Policy Elements](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_resource.html) in the *IAM User Guide*\.

Condition keys for IAM policies are listed by API operation\. You can use AWS\-wide condition keys in your AWS Glue policies to express conditions\. For a complete list of AWS\-wide keys, see [AWS Global Condition Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\. 

**Note**  
To specify an action, use the `glue:` prefix followed by the API operation name \(for example, `glue:GetTable`\)\.

If you see an expand arrow \(**↗**\) in the upper\-right corner of the table, you can open the table in a new window\. To close the window, choose the close button \(**X**\) in the lower\-right corner\.


**AWS Glue API and Required Permissions for Actions**  

| AWS Glue API Operations | Required Permissions \(API Actions\) | Resources | Condition Keys | 
| --- | --- | --- | --- | 
| [BatchCreatePartition \(batch\_create\_partition\)](aws-glue-api-catalog-partitions.md#aws-glue-api-catalog-partitions-BatchCreatePartition) | glue:BatchCreatePartition | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [BatchDeleteConnection \(batch\_delete\_connection\)](aws-glue-api-catalog-connections.md#aws-glue-api-catalog-connections-BatchDeleteConnection) | glue:BatchDeleteConnection | <pre><br />arn:aws:glue:region:account-id:connection/connection-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre> All the connection deletions to be performed by the call must be authorized by IAM\. If any of these deletions is not authorized, the call fails and no connections are deleted\.  |  | 
| [BatchDeletePartition \(batch\_delete\_partition\)](aws-glue-api-catalog-partitions.md#aws-glue-api-catalog-partitions-BatchDeletePartition) | glue:BatchDeletePartition | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre> All the partition deletions to be performed by the call must be authorized by IAM\. If any of these deletions is not authorized, the call fails and no partitions are deleted\.  |  | 
| [BatchDeleteTable \(batch\_delete\_table\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-BatchDeleteTable) | glue:BatchDeleteTable | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre> All the table deletions to be performed by the call must be authorized by IAM\. If any of these deletions is not authorized, the call fails and no tables are deleted\.  |  | 
| [BatchDeleteTableVersion \(batch\_delete\_table\_version\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-BatchDeleteTableVersion) | glue:BatchDeleteTableVersion | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [BatchGetCrawlers \(batch\_get\_crawlers\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-BatchGetCrawlers) | glue:BatchGetCrawlers |  arn:aws:glue:region:account\-id:crawler/crawler\-name  | glue:resourceTag | 
| [BatchGetDevEndpoints \(batch\_get\_dev\_endpoints\)](aws-glue-api-dev-endpoint.md#aws-glue-api-dev-endpoint-BatchGetDevEndpoints) | glue:BatchGetDevEndpoints |  arn:aws:glue:region:account\-id:devEndpoint/development\-endpoint\-name  | glue:resourceTag | 
| [BatchGetJobs \(batch\_get\_jobs\)](aws-glue-api-jobs-job.md#aws-glue-api-jobs-job-BatchGetJobs) | glue:BatchGetJobs |  arn:aws:glue:region:account\-id:job/job\-name  | glue:resourceTag | 
| [BatchGetPartition \(batch\_get\_partition\)](aws-glue-api-catalog-partitions.md#aws-glue-api-catalog-partitions-BatchGetPartition) | glue:BatchGetPartition | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [BatchGetTriggers \(batch\_get\_triggers\)](aws-glue-api-jobs-trigger.md#aws-glue-api-jobs-trigger-BatchGetTriggers) | glue:BatchGetTriggers |  arn:aws:glue:region:account\-id:trigger/trigger\-name  | glue:resourceTag | 
| [BatchStopJobRun \(batch\_stop\_job\_run\)](aws-glue-api-jobs-runs.md#aws-glue-api-jobs-runs-BatchStopJobRun) | glue:BatchStopJobRun | \* |  | 
| [CreateClassifier \(create\_classifier\)](aws-glue-api-crawler-classifiers.md#aws-glue-api-crawler-classifiers-CreateClassifier) | glue:CreateClassifier | \* |  | 
| [CreateConnection \(create\_connection\)](aws-glue-api-catalog-connections.md#aws-glue-api-catalog-connections-CreateConnection) | glue:CreateConnection | <pre><br />arn:aws:glue:region:account-id:connection/connection-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [CreateCrawler \(create\_crawler\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-CreateCrawler) | glue:CreateCrawler |  arn:aws:glue:region:account\-id:crawler/crawler\-name or arn:aws:glue:region:account\-id:crawler/\* | aws:RequestTag | 
| [CreateDatabase \(create\_database\)](aws-glue-api-catalog-databases.md#aws-glue-api-catalog-databases-CreateDatabase) | glue:CreateDatabase | <pre><br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [CreateDevEndpoint \(create\_dev\_endpoint\)](aws-glue-api-dev-endpoint.md#aws-glue-api-dev-endpoint-CreateDevEndpoint) | glue:CreateDevEndpoint |  arn:aws:glue:region:account\-id:devEndpoint/development\-endpoint\-name or arn:aws:glue:region:account\-id:devEndpoint/\* | aws:RequestTag | 
| [CreateJob \(create\_job\)](aws-glue-api-jobs-job.md#aws-glue-api-jobs-job-CreateJob) | glue:CreateJob |  arn:aws:glue:region:account\-id:job/job\-name or arn:aws:glue:region:account\-id:job/\* | aws:RequestTag | 
| [CreatePartition \(create\_partition\)](aws-glue-api-catalog-partitions.md#aws-glue-api-catalog-partitions-CreatePartition) | glue:CreatePartition | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [CreateScript \(create\_script\)](aws-glue-api-etl-script-generation.md#aws-glue-api-etl-script-generation-CreateScript) | glue:CreateScript | \*  |  | 
| [CreateSecurityConfiguration \(create\_security\_configuration\)](aws-glue-api-jobs-security.md#aws-glue-api-jobs-security-CreateSecurityConfiguration) | glue:CreateSecurityConfiguration | \*  |  | 
| [CreateTable \(create\_table\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-CreateTable) | glue:CreateTable | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [CreateTrigger \(create\_trigger\)](aws-glue-api-jobs-trigger.md#aws-glue-api-jobs-trigger-CreateTrigger) | glue:CreateTrigger |  arn:aws:glue:region:account\-id:trigger/trigger\-name or arn:aws:glue:region:account\-id:trigger/\* | aws:RequestTag | 
| [CreateUserDefinedFunction \(create\_user\_defined\_function\)](aws-glue-api-catalog-functions.md#aws-glue-api-catalog-functions-CreateUserDefinedFunction) | glue:CreateUserDefinedFunction | ><pre><br />arn:aws:glue:region:account-id:userDefinedFunction/database-name/user-defined-function-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [DeleteClassifier \(delete\_classifier\)](aws-glue-api-crawler-classifiers.md#aws-glue-api-crawler-classifiers-DeleteClassifier) | glue:DeleteClassifier | \* |  | 
| [DeleteConnection \(delete\_connection\)](aws-glue-api-catalog-connections.md#aws-glue-api-catalog-connections-DeleteConnection) | glue:DeleteConnection | <pre><br />arn:aws:glue:region:account-id:connection/connection-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [DeleteCrawler \(delete\_crawler\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-DeleteCrawler) | glue:DeleteCrawler |  arn:aws:glue:region:account\-id:crawler/crawler\-name or arn:aws:glue:region:account\-id:crawler/\* | glue:resourceTag | 
| [DeleteDatabase \(delete\_database\)](aws-glue-api-catalog-databases.md#aws-glue-api-catalog-databases-DeleteDatabase) | glue:DeleteDatabase | <pre><br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:userDefinedFunction/database-name/*<br />arn:aws:glue:region:account-id:table/database-name/*            <br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [DeleteDevEndpoint \(delete\_dev\_endpoint\)](aws-glue-api-dev-endpoint.md#aws-glue-api-dev-endpoint-DeleteDevEndpoint) | glue:DeleteDevEndpoint |  arn:aws:glue:region:account\-id:devEndpoint/development\-endpoint\-name or arn:aws:glue:region:account\-id:devEndpoint/\* | glue:resourceTag | 
| [DeleteJob \(delete\_job\)](aws-glue-api-jobs-job.md#aws-glue-api-jobs-job-DeleteJob) | glue:DeleteJob |  arn:aws:glue:region:account\-id:job/job\-name or arn:aws:glue:region:account\-id:job/\* | glue:resourceTag | 
| [DeletePartition \(delete\_partition\)](aws-glue-api-catalog-partitions.md#aws-glue-api-catalog-partitions-DeletePartition) | glue:DeletePartition | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [DeleteResourcePolicy \(delete\_resource\_policy\)](aws-glue-api-jobs-security.md#aws-glue-api-jobs-security-DeleteResourcePolicy) | glue:DeleteResourcePolicy | \* |  | 
| [DeleteSecurityConfiguration \(delete\_security\_configuration\)](aws-glue-api-jobs-security.md#aws-glue-api-jobs-security-DeleteSecurityConfiguration) | glue:DeleteSecurityConfiguration | \*  |  | 
| [DeleteTable \(delete\_table\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-DeleteTable) | glue:DeleteTable | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [DeleteTableVersion \(delete\_table\_version\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-DeleteTableVersion) | glue:DeleteTableVersion | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [DeleteTrigger \(delete\_trigger\)](aws-glue-api-jobs-trigger.md#aws-glue-api-jobs-trigger-DeleteTrigger) | glue:DeleteTrigger |  arn:aws:glue:region:account\-id:trigger/trigger\-name or arn:aws:glue:region:account\-id:trigger/\* | glue:resourceTag | 
| [DeleteUserDefinedFunction \(delete\_user\_defined\_function\)](aws-glue-api-catalog-functions.md#aws-glue-api-catalog-functions-DeleteUserDefinedFunction) | glue:DeleteUserDefinedFunction | <pre><br />arn:aws:glue:region:account-id:userDefinedFunction/database-name/user-defined-function-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetCatalogImportStatus \(get\_catalog\_import\_status\)](aws-glue-api-catalog-migration.md#aws-glue-api-catalog-migration-GetCatalogImportStatus) | glue:GetCatalogImportStatus | <pre><br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetClassifier \(get\_classifier\)](aws-glue-api-crawler-classifiers.md#aws-glue-api-crawler-classifiers-GetClassifier) | glue:GetClassifier | \* |  | 
| [GetClassifiers \(get\_classifiers\)](aws-glue-api-crawler-classifiers.md#aws-glue-api-crawler-classifiers-GetClassifiers) | glue:GetClassifiers | \* |  | 
| [GetConnection \(get\_connection\)](aws-glue-api-catalog-connections.md#aws-glue-api-catalog-connections-GetConnection) | glue:GetConnection | <pre><br />arn:aws:glue:region:account-id:connection/connection-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetConnections \(get\_connections\)](aws-glue-api-catalog-connections.md#aws-glue-api-catalog-connections-GetConnections) | glue:GetConnections | <pre><br />arn:aws:glue:region:account-id:connection/connection-names<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetCrawler \(get\_crawler\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-GetCrawler) | glue:GetCrawler |  arn:aws:glue:region:account\-id:crawler/crawler\-name or arn:aws:glue:region:account\-id:crawler/\* | glue:resourceTag | 
| [GetCrawlerMetrics \(get\_crawler\_metrics\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-GetCrawlerMetrics) | glue:GetCrawlerMetrics | \* |  | 
| [GetCrawlers \(get\_crawlers\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-GetCrawlers) | glue:GetCrawlers | \* |  | 
| [GetDatabase \(get\_database\)](aws-glue-api-catalog-databases.md#aws-glue-api-catalog-databases-GetDatabase) | glue:GetDatabase | <pre><br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetDatabases \(get\_databases\)](aws-glue-api-catalog-databases.md#aws-glue-api-catalog-databases-GetDatabases) | glue:GetDatabases | <pre><br />arn:aws:glue:region:account-id:database/database-names<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetDataCatalogEncryptionSettings \(get\_data\_catalog\_encryption\_settings\)](aws-glue-api-jobs-security.md#aws-glue-api-jobs-security-GetDataCatalogEncryptionSettings) | glue:GetDataCatalogEncryptionSettings | \* |  | 
| [GetDataflowGraph \(get\_dataflow\_graph\)](aws-glue-api-etl-script-generation.md#aws-glue-api-etl-script-generation-GetDataflowGraph) | glue:GetDataflowGraph | \* |  | 
| [GetDevEndpoint \(get\_dev\_endpoint\)](aws-glue-api-dev-endpoint.md#aws-glue-api-dev-endpoint-GetDevEndpoint) | glue:GetDevEndpoint |  arn:aws:glue:region:account\-id:devEndpoint/development\-endpoint\-name or arn:aws:glue:region:account\-id:devEndpoint/\* | glue:resourceTag | 
| [GetDevEndpoints \(get\_dev\_endpoints\)](aws-glue-api-dev-endpoint.md#aws-glue-api-dev-endpoint-GetDevEndpoints) | glue:GetDevEndpoints | \* |  | 
| [GetJob \(get\_job\)](aws-glue-api-jobs-job.md#aws-glue-api-jobs-job-GetJob) | glue:GetJob |  arn:aws:glue:region:account\-id:job/job\-name or arn:aws:glue:region:account\-id:job/\* | glue:resourceTag | 
| [GetJobRun \(get\_job\_run\)](aws-glue-api-jobs-runs.md#aws-glue-api-jobs-runs-GetJobRun) | glue:GetJobRun | \* |  | 
| [GetJobRuns \(get\_job\_runs\)](aws-glue-api-jobs-runs.md#aws-glue-api-jobs-runs-GetJobRuns) | glue:GetJobRuns | \* |  | 
| [GetJobs \(get\_jobs\)](aws-glue-api-jobs-job.md#aws-glue-api-jobs-job-GetJobs) | glue:GetJobs | \* |  | 
| [GetMapping \(get\_mapping\)](aws-glue-api-etl-script-generation.md#aws-glue-api-etl-script-generation-GetMapping) | glue:GetMapping | \* |  | 
| [GetPartition \(get\_partition\)](aws-glue-api-catalog-partitions.md#aws-glue-api-catalog-partitions-GetPartition) | glue:GetPartition | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetPartitions \(get\_partitions\)](aws-glue-api-catalog-partitions.md#aws-glue-api-catalog-partitions-GetPartitions) | glue:GetPartitions | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetPlan \(get\_plan\)](aws-glue-api-etl-script-generation.md#aws-glue-api-etl-script-generation-GetPlan) | glue:GetPlan | \* |  | 
| [GetResourcePolicy \(get\_resource\_policy\)](aws-glue-api-jobs-security.md#aws-glue-api-jobs-security-GetResourcePolicy) | glue:GetResourcePolicy | \* |  | 
| [GetSecurityConfiguration \(get\_security\_configuration\)](aws-glue-api-jobs-security.md#aws-glue-api-jobs-security-GetSecurityConfiguration) | glue:GetSecurityConfiguration | \*  |  | 
| [GetSecurityConfigurations \(get\_security\_configurations\)](aws-glue-api-jobs-security.md#aws-glue-api-jobs-security-GetSecurityConfigurations) | glue:GetSecurityConfigurations | \*  |  | 
| [GetTable \(get\_table\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-GetTable) | glue:GetTable | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetTables \(get\_tables\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-GetTables) | glue:GetTables | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-names<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetTableVersion \(get\_table\_version\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-GetTableVersion) | glue:GetTableVersion | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetTableVersions \(get\_table\_versions\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-GetTableVersions) | glue:GetTableVersions | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetTags \(get\_tags\)](aws-glue-api-tags.md#aws-glue-api-tags-GetTags) | glue:GetTags | \*  |  | 
| [GetTrigger \(get\_trigger\)](aws-glue-api-jobs-trigger.md#aws-glue-api-jobs-trigger-GetTrigger) | glue:GetTrigger |  arn:aws:glue:region:account\-id:trigger/trigger\-name or arn:aws:glue:region:account\-id:trigger/\* | glue:resourceTag | 
| [GetTriggers \(get\_triggers\)](aws-glue-api-jobs-trigger.md#aws-glue-api-jobs-trigger-GetTriggers) | glue:GetTriggers | \* |  | 
| [GetUserDefinedFunction \(get\_user\_defined\_function\)](aws-glue-api-catalog-functions.md#aws-glue-api-catalog-functions-GetUserDefinedFunction) | glue:GetUserDefinedFunction | <pre><br />arn:aws:glue:region:account-id:userDefinedFunction/database-name/user-defined-function-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [GetUserDefinedFunctions \(get\_user\_defined\_functions\)](aws-glue-api-catalog-functions.md#aws-glue-api-catalog-functions-GetUserDefinedFunctions) | glue:GetUserDefinedFunctions | <pre><br />arn:aws:glue:region:account-id:userDefinedFunction/database-name/user-defined-function-names<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [ImportCatalogToGlue \(import\_catalog\_to\_glue\)](aws-glue-api-catalog-migration.md#aws-glue-api-catalog-migration-ImportCatalogToGlue) | glue:ImportCatalogToGlue | <pre><br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [ListCrawlers \(list\_crawlers\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-ListCrawlers) | glue:ListCrawlers | \* |  | 
| [ListDevEndpoints \(list\_dev\_endpoints\)](aws-glue-api-dev-endpoint.md#aws-glue-api-dev-endpoint-ListDevEndpoints) | glue:ListDevEndpoints | \* |  | 
| [ListJobs \(list\_jobs\)](aws-glue-api-jobs-job.md#aws-glue-api-jobs-job-ListJobs) | glue:ListJobs | \* |  | 
| [ListTriggers \(list\_triggers\)](aws-glue-api-jobs-trigger.md#aws-glue-api-jobs-trigger-ListTriggers) | glue:ListTriggers | \* |  | 
| [PutResourcePolicy \(put\_resource\_policy\)](aws-glue-api-jobs-security.md#aws-glue-api-jobs-security-PutResourcePolicy) | glue:PutResourcePolicy | \* |  | 
| [PutDataCatalogEncryptionSettings \(put\_data\_catalog\_encryption\_settings\)](aws-glue-api-jobs-security.md#aws-glue-api-jobs-security-PutDataCatalogEncryptionSettings) | glue:PutDataCatalogEncryptionSettings | \* |  | 
| [ResetJobBookmark \(reset\_job\_bookmark\)](aws-glue-api-jobs-runs.md#aws-glue-api-jobs-runs-ResetJobBookmark) | glue:ResetJobBookmark | \* |  | 
| [StartCrawler \(start\_crawler\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-StartCrawler) | glue:StartCrawler |  arn:aws:glue:region:account\-id:crawler/crawler\-name or arn:aws:glue:region:account\-id:crawler/\* | glue:resourceTag | 
| [StartCrawlerSchedule \(start\_crawler\_schedule\)](aws-glue-api-crawler-scheduler.md#aws-glue-api-crawler-scheduler-StartCrawlerSchedule) | glue:StartCrawlerSchedule | \* |  | 
| [StartJobRun \(start\_job\_run\)](aws-glue-api-jobs-runs.md#aws-glue-api-jobs-runs-StartJobRun) | glue:StartJobRun | \* |  | 
| [StartTrigger \(start\_trigger\)](aws-glue-api-jobs-trigger.md#aws-glue-api-jobs-trigger-StartTrigger) | glue:StartTrigger |  arn:aws:glue:region:account\-id:trigger/trigger\-name or arn:aws:glue:region:account\-id:trigger/\* | glue:resourceTag | 
| [StopCrawler \(stop\_crawler\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-StopCrawler) | glue:StopCrawler |  arn:aws:glue:region:account\-id:crawler/crawler\-name or arn:aws:glue:region:account\-id:crawler/\* | glue:resourceTag | 
| [StopCrawlerSchedule \(stop\_crawler\_schedule\)](aws-glue-api-crawler-scheduler.md#aws-glue-api-crawler-scheduler-StopCrawlerSchedule) | glue:StopCrawlerSchedule | \* |  | 
| [StopTrigger \(stop\_trigger\)](aws-glue-api-jobs-trigger.md#aws-glue-api-jobs-trigger-StopTrigger) | glue:StopTrigger |  arn:aws:glue:region:account\-id:trigger/trigger\-name or arn:aws:glue:region:account\-id:trigger/\* | glue:resourceTag | 
| [TagResource \(tag\_resource\)](aws-glue-api-tags.md#aws-glue-api-tags-TagResource) | glue:TagResource | \*  | aws:RequestTag | 
| [UntagResource \(untag\_resource\)](aws-glue-api-tags.md#aws-glue-api-tags-UntagResource) | glue:UntagResource | \*  | aws:TagKeys | 
| [UpdateClassifier \(update\_classifier\)](aws-glue-api-crawler-classifiers.md#aws-glue-api-crawler-classifiers-UpdateClassifier) | glue:UpdateClassifier | \* |  | 
| [UpdateConnection \(update\_connection\)](aws-glue-api-catalog-connections.md#aws-glue-api-catalog-connections-UpdateConnection) | glue:UpdateConnection | <pre><br />arn:aws:glue:region:account-id:connection/connection-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [UpdateCrawler \(update\_crawler\)](aws-glue-api-crawler-crawling.md#aws-glue-api-crawler-crawling-UpdateCrawler) | glue:UpdateCrawler |  arn:aws:glue:region:account\-id:crawler/crawler\-name or arn:aws:glue:region:account\-id:crawler/\* | glue:resourceTag | 
| [UpdateCrawlerSchedule \(update\_crawler\_schedule\)](aws-glue-api-crawler-scheduler.md#aws-glue-api-crawler-scheduler-UpdateCrawlerSchedule) | glue:UpdateCrawlerSchedule | \* |  | 
| [UpdateDatabase \(update\_database\)](aws-glue-api-catalog-databases.md#aws-glue-api-catalog-databases-UpdateDatabase) | glue:UpdateDatabase | <pre><br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [UpdateDevEndpoint \(update\_dev\_endpoint\)](aws-glue-api-dev-endpoint.md#aws-glue-api-dev-endpoint-UpdateDevEndpoint) | glue:UpdateDevEndpoint |  arn:aws:glue:region:account\-id:devEndpoint/development\-endpoint\-name or arn:aws:glue:region:account\-id:devEndpoint/\* | glue:resourceTag | 
| [UpdateJob \(update\_job\)](aws-glue-api-jobs-job.md#aws-glue-api-jobs-job-UpdateJob) | glue:UpdateJob |  arn:aws:glue:region:account\-id:job/job\-name or arn:aws:glue:region:account\-id:job/\* | glue:resourceTag | 
| [UpdatePartition \(update\_partition\)](aws-glue-api-catalog-partitions.md#aws-glue-api-catalog-partitions-UpdatePartition) | glue:UpdatePartition | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [UpdateTable \(update\_table\)](aws-glue-api-catalog-tables.md#aws-glue-api-catalog-tables-UpdateTable) | glue:UpdateTable | <pre><br />arn:aws:glue:region:account-id:table/database-name/table-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 
| [UpdateTrigger \(update\_trigger\)](aws-glue-api-jobs-trigger.md#aws-glue-api-jobs-trigger-UpdateTrigger) | glue:UpdateTrigger |  arn:aws:glue:region:account\-id:trigger/trigger\-name or arn:aws:glue:region:account\-id:trigger/\* | glue:resourceTag | 
| [UpdateUserDefinedFunction \(update\_user\_defined\_function\)](aws-glue-api-catalog-functions.md#aws-glue-api-catalog-functions-UpdateUserDefinedFunction) | glue:UpdateUserDefinedFunction | <pre><br />arn:aws:glue:region:account-id:userDefinedFunction/database-name/user-defined-function-name<br />arn:aws:glue:region:account-id:database/database-name<br />arn:aws:glue:region:account-id:catalog               <br />             </pre>  |  | 

## Related Topics<a name="api-permissions-reference-related"></a>
+ [Identity and Access Management](authentication-and-access-control.md)