# AWS IoT Analytics Commands<a name="api"></a>

## BatchPutMessage<a name="cli-iotanalytics-batchputmessage"></a>

Sends messages to a channel\.

 *CLI Synopsis*:

```
aws iotanalytics  batch-put-message
 --channel-name <value>
 --messages <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "channelName": "string",
  "messages": [
    {
      "messageId": "string",
      "payload": "blob"
    }
  ]
}
```

 *fields*:
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel where the messages are sent\.
+ messages

   *type*: list member: Message

  The list of messages to be sent\. Each message has format: '\{ "messageId": "string", "payload": "string"\}'\. Note that the field names of message payloads \(data\) that you send to AWS IoT Analytics: Must contain only alphanumeric characters and undescores \(\_\); no other special characters are allowed\. Must begin with an alphabetic character or single underscore \(\_\)\. Cannot contain hyphens \(\-\)\. In regular expression terms: "^\[A\-Za\-z\_\]\(\[A\-Za\-z0\-9\]\*\|\[A\-Za\-z0\-9\]\[A\-Za\-z0\-9\_\]\*\)$"\. Cannot be greater than 255 characters\. Are case\-insensitive\. \(Fields named "foo" and "FOO" in the same payload are considered duplicates\.\) For example, \{"temp\_01": 29\} or \{"\_temp\_01": 29\} are valid, but \{"temp\-01": 29\}, \{"01\_temp": 29\} or \{"\_\_temp\_01": 29\} are invalid in message payloads\.
+ messageId

   *type*: string; \(length\- max:128 min:1\)

  The ID you wish to assign to the message\. Each "messageId" must be unique within each batch sent\.
+ payload

   *type*: blob

  The payload of the message\. This may be a JSON string or a Base64\-encoded string representing binary data \(in which case you must decode it by means of a pipeline activity\)\.

Output:

```
{
  "batchPutMessageErrorEntries": [
    {
      "messageId": "string",
      "errorCode": "string",
      "errorMessage": "string"
    }
  ]
}
```

 *fields*:
+ batchPutMessageErrorEntries

   *type*: list member: BatchPutMessageErrorEntry

  A list of any errors encountered when sending the messages to the channel\.
+ messageId

   *type*: string; \(length\- max:128 min:1\)

  The ID of the message that caused the error\. \(See the value corresponding to the "messageId" key in the message object\.\)
+ errorCode

   *type*: string

  The code associated with the error\.
+ errorMessage

   *type*: string

  The message associated with the error\.

Errors:
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## CancelPipelineReprocessing<a name="cli-iotanalytics-cancelpipelinereprocessing"></a>

Cancels the reprocessing of data through the pipeline\.

 *CLI Synopsis*:

```
aws iotanalytics  cancel-pipeline-reprocessing
 --pipeline-name <value>
 --reprocessing-id <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "pipelineName": "string",
  "reprocessingId": "string"
}
```

 *fields*:
+ pipelineName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of pipeline for which data reprocessing is canceled\.
+ reprocessingId

   *type*: string

  The ID of the reprocessing task \(returned by "StartPipelineReprocessing"\)\.

Output:

None

Errors:
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## CreateChannel<a name="cli-iotanalytics-createchannel"></a>

Creates a channel\. A channel collects data from an MQTT topic and archives the raw, unprocessed messages before publishing the data to a pipeline\.

 *CLI Synopsis*:

```
aws iotanalytics  create-channel
 --channel-name <value>
[--channel-storage <value>]
[--retention-period <value>]
[--tags <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "channelName": "string",
  "channelStorage": {
    "serviceManagedS3": {
    },
    "customerManagedS3": {
      "bucket": "string",
      "keyPrefix": "string",
      "roleArn": "string"
    }
  },
  "retentionPeriod": {
    "unlimited": "boolean",
    "numberOfDays": "integer"
  },
  "tags": [
    {
      "key": "string",
      "value": "string"
    }
  ]
}
```

 *fields*:
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel\.
+ channelStorage

   *type*: ChannelStorage

  Where channel data is stored\. You may choose one of "serviceManagedS3" or "customerManagedS3" storage\. If not specified, the default is "serviceManagedS3"\. This cannot be changed after creation of the channel\.
+ serviceManagedS3

   *type*: ServiceManagedChannelS3Storage

  Use this to store channel data in an S3 bucket managed by the AWS IoT Analytics service\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the channel\.
+ customerManagedS3

   *type*: CustomerManagedChannelS3Storage

  Use this to store channel data in an S3 bucket that you manage\. If customer managed storage is selected, the "retentionPeriod" parameter is ignored\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the channel\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket in which channel data is stored\.
+ keyPrefix

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*/$\)

  \[Optional\] The prefix used to create the keys of the channel data objects\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. The prefix must end with a '/'\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 resources\.
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, message data is kept for the channel\. When "customerManagedS3" storage is selected, this parameter is ignored\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.
+ tags

   *type*: list member: Tag

  Metadata which can be used to manage the channel\.
+ key

   *type*: string; \(length\- max:256 min:1\)

  The tag's key\.
+ value

   *type*: string; \(length\- max:256 min:1\)

  The tag's value\.

Output:

```
{
  "channelName": "string",
  "channelArn": "string",
  "retentionPeriod": {
    "unlimited": "boolean",
    "numberOfDays": "integer"
  }
}
```

 *fields*:
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel\.
+ channelArn

   *type*: string

  The ARN of the channel\.
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, message data is kept for the channel\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceAlreadyExistsException

  A resource with the same name already exists\.

  HTTP response code: 409
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429
+ LimitExceededException

  The command caused an internal limit to be exceeded\.

  HTTP response code: 410

## CreateDataset<a name="cli-iotanalytics-createdataset"></a>

Creates a data set\. A data set stores data retrieved from a data store by applying a "queryAction" \(a SQL query\) or a "containerAction" \(executing a containerized application\)\. This operation creates the skeleton of a data set\. The data set can be populated manually by calling "CreateDatasetContent" or automatically according to a "trigger" you specify\.

 *CLI Synopsis*:

```
aws iotanalytics  create-dataset
 --dataset-name <value>
 --actions <value>
[--triggers <value>]
[--content-delivery-rules <value>]
[--retention-period <value>]
[--versioning-configuration <value>]
[--tags <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datasetName": "string",
  "actions": [
    {
      "actionName": "string",
      "queryAction": {
        "sqlQuery": "string",
        "filters": [
          {
            "deltaTime": {
              "offsetSeconds": "integer",
              "timeExpression": "string"
            }
          }
        ]
      },
      "containerAction": {
        "image": "string",
        "executionRoleArn": "string",
        "resourceConfiguration": {
          "computeType": "string",
          "volumeSizeInGB": "integer"
        },
        "variables": [
          {
            "name": "string",
            "stringValue": "string",
            "doubleValue": "double",
            "datasetContentVersionValue": {
              "datasetName": "string"
            },
            "outputFileUriValue": {
              "fileName": "string"
            }
          }
        ]
      }
    }
  ],
  "triggers": [
    {
      "schedule": {
        "expression": "string"
      },
      "dataset": {
        "name": "string"
      }
    }
  ],
  "contentDeliveryRules": [
    {
      "entryName": "string",
      "destination": {
        "iotEventsDestinationConfiguration": {
          "inputName": "string",
          "roleArn": "string"
        },
        "s3DestinationConfiguration": {
          "bucket": "string",
          "key": "string",
          "glueConfiguration": {
            "tableName": "string",
            "databaseName": "string"
          },
          "roleArn": "string"
        }
      }
    }
  ],
  "retentionPeriod": {
    "unlimited": "boolean",
    "numberOfDays": "integer"
  },
  "versioningConfiguration": {
    "unlimited": "boolean",
    "maxVersions": "integer"
  },
  "tags": [
    {
      "key": "string",
      "value": "string"
    }
  ]
}
```

 *fields*:
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set\.
+ actions

   *type*: list member: DatasetAction

  A list of actions that create the data set contents\.
+ actionName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set action by which data set contents are automatically created\.
+ queryAction

   *type*: SqlQueryDatasetAction

  An "SqlQueryDatasetAction" object that uses an SQL query to automatically create data set contents\.
+ sqlQuery

   *type*: string

  A SQL query string\.
+ filters

   *type*: list member: QueryFilter

  Pre\-filters applied to message data\.
+ deltaTime

   *type*: DeltaTime

  Used to limit data to that which has arrived since the last execution of the action\.
+ offsetSeconds

   *type*: integer java class: java\.lang\.Integer

  The number of seconds of estimated "in flight" lag time of message data\. When you create data set contents using message data from a specified time frame, some message data may still be "in flight" when processing begins, and so will not arrive in time to be processed\. Use this field to make allowances for the "in flight" time of your message data, so that data not processed from a previous time frame will be included with the next time frame\. Without this, missed message data would be excluded from processing during the next time frame as well, because its timestamp places it within the previous time frame\.
+ timeExpression

   *type*: string

  An expression by which the time of the message data may be determined\. This may be the name of a timestamp field, or a SQL expression which is used to derive the time the message data was generated\.
+ containerAction

   *type*: ContainerDatasetAction

  Information which allows the system to run a containerized application in order to create the data set contents\. The application must be in a Docker container along with any needed support libraries\.
+ image

   *type*: string; \(length\- max:255\)

  The ARN of the Docker container stored in your account\. The Docker container contains an application and needed support libraries and is used to generate data set contents\.
+ executionRoleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which gives permission to the system to access needed resources in order to run the "containerAction"\. This includes, at minimum, permission to retrieve the data set contents which are the input to the containerized application\.
+ resourceConfiguration

   *type*: ResourceConfiguration

  Configuration of the resource which executes the "containerAction"\.
+ computeType

   *type*: string

  The type of the compute resource used to execute the "containerAction"\. Possible values are: ACU\_1 \(vCPU=4, memory=16GiB\) or ACU\_2 \(vCPU=8, memory=32GiB\)\. enum: ACU\_1 \| ACU\_2
+ volumeSizeInGB

   *type*: integer range\- max:50 min:1

  The size \(in GB\) of the persistent storage available to the resource instance used to execute the "containerAction" \(min: 1, max: 50\)\.
+ variables

   *type*: list member: Variable

  The values of variables used within the context of the execution of the containerized application \(basically, parameters passed to the application\)\. Each variable must have a name and a value given by one of "stringValue", "datasetContentVersionValue", or "outputFileUriValue"\.
+ name

   *type*: string; \(length\- max:256 min:1\)

  The name of the variable\.
+ stringValue

   *type*: string; \(length\- max:1024 min:0\)

  The value of the variable as a string\.
+ datasetContentVersionValue

   *type*: DatasetContentVersionValue

  The value of the variable as a structure that specifies a data set content version\.
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose latest contents are used as input to the notebook or application\.
+ outputFileUriValue

   *type*: OutputFileUriValue

  The value of the variable as a structure that specifies an output file URI\.
+ fileName

   *type*: string; \(pattern: \[w\.\-\]\{1,255\}\)

  The URI of the location where data set contents are stored, usually the URI of a file in an S3 bucket\.
+ triggers

   *type*: list member: DatasetTrigger

  A list of triggers\. A trigger causes data set contents to be populated at a specified time interval or when another data set's contents are created\. The list of triggers can be empty or contain up to five DataSetTrigger objects\.
+ schedule

   *type*: Schedule

  The "Schedule" when the trigger is initiated\.
+ expression

   *type*: string

  The expression that defines when to trigger an update\. For more information, see Schedule Expressions for Rules in the Amazon CloudWatch Events User Guide\.
+ dataset

   *type*: TriggeringDataset

  The data set whose content creation triggers the creation of this data set's contents\.
+ name

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose content generation triggers the new data set content generation\.
+ contentDeliveryRules

   *type*: list member: DatasetContentDeliveryRule

  When data set contents are created they are delivered to destinations specified here\.
+ entryName

   *type*: string

  The name of the data set content delivery rules entry\.
+ destination

   *type*: DatasetContentDeliveryDestination

  The destination to which data set contents are delivered\.
+ iotEventsDestinationConfiguration

   *type*: IotEventsDestinationConfiguration

  Configuration information for delivery of data set contents to AWS IoT Events\.
+ inputName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z\]\[a\-zA\-Z0\-9\_\]\*$\)

  The name of the AWS IoT Events input to which data set contents are delivered\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to deliver data set contents to an AWS IoT Events input\.
+ s3DestinationConfiguration

   *type*: S3DestinationConfiguration

  Configuration information for delivery of data set contents to Amazon S3\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket to which data set contents are delivered\.
+ key

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*$\)

  The key of the data set contents object\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. To produce a unique key, you can use "\!\{iotanalytics:scheduledTime\}" to insert the time of the scheduled SQL query run, or "\!\{iotanalytics:versioned\} to insert a unique hash identifying the data set, for example: "/DataSet/\!\{iotanalytics:scheduledTime\}/\!\{iotanalytics:versioned\}\.csv"\.
+ glueConfiguration

   *type*: GlueConfiguration

  Configuration information for coordination with the AWS Glue ETL \(extract, transform and load\) service\.
+ tableName

   *type*: string; \(length\- max:150 min:1\); \(pattern: \[u0020\-uD7FFuE000\-uFFFDuD800uDC00\-uDBFFuDFFFt\]\*\)

  The name of the table in your AWS Glue Data Catalog which is used to perform the ETL \(extract, transform and load\) operations\. \(An AWS Glue Data Catalog table contains partitioned data and descriptions of data sources and targets\.\)
+ databaseName

   *type*: string; \(length\- max:150 min:1\); \(pattern: \[u0020\-uD7FFuE000\-uFFFDuD800uDC00\-uDBFFuDFFFt\]\*\)

  The name of the database in your AWS Glue Data Catalog in which the table is located\. \(An AWS Glue Data Catalog database contains Glue Data tables\.\)
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 and AWS Glue resources\.
+ retentionPeriod

   *type*: RetentionPeriod

  \[Optional\] How long, in days, versions of data set contents are kept for the data set\. If not specified or set to null, versions of data set contents are retained for at most 90 days\. The number of versions of data set contents retained is determined by the versioningConfiguration parameter\. \(For more information, see [https://docs\.aws\.amazon\.com/iotanalytics/latest/userguide/getting\-started\.html\#aws\-iot\-analytics\-dataset\-versions](https://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html#aws-iot-analytics-dataset-versions)\)
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.
+ versioningConfiguration

   *type*: VersioningConfiguration

  \[Optional\] How many versions of data set contents are kept\. If not specified or set to null, only the latest version plus the latest succeeded version \(if they are different\) are kept for the time period specified by the "retentionPeriod" parameter\. \(For more information, see [https://docs\.aws\.amazon\.com/iotanalytics/latest/userguide/getting\-started\.html\#aws\-iot\-analytics\-dataset\-versions](https://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html#aws-iot-analytics-dataset-versions)\)
+ unlimited

   *type*: boolean

  If true, unlimited versions of data set contents will be kept\.
+ maxVersions

   *type*: integer java class: java\.lang\.Integer range\- max:1000 min:1

  How many versions of data set contents will be kept\. The "unlimited" parameter must be false\.
+ tags

   *type*: list member: Tag

  Metadata which can be used to manage the data set\.
+ key

   *type*: string; \(length\- max:256 min:1\)

  The tag's key\.
+ value

   *type*: string; \(length\- max:256 min:1\)

  The tag's value\.

Output:

```
{
  "datasetName": "string",
  "datasetArn": "string",
  "retentionPeriod": {
    "unlimited": "boolean",
    "numberOfDays": "integer"
  }
}
```

 *fields*:
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set\.
+ datasetArn

   *type*: string

  The ARN of the data set\.
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, data set contents are kept for the data set\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceAlreadyExistsException

  A resource with the same name already exists\.

  HTTP response code: 409
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429
+ LimitExceededException

  The command caused an internal limit to be exceeded\.

  HTTP response code: 410

## CreateDatasetContent<a name="cli-iotanalytics-createdatasetcontent"></a>

Creates the content of a data set by applying a "queryAction" \(a SQL query\) or a "containerAction" \(executing a containerized application\)\.

 *CLI Synopsis*:

```
aws iotanalytics  create-dataset-content
 --dataset-name <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datasetName": "string"
}
```

 *fields*:
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set\.

Output:

```
{
  "versionId": "string"
}
```

 *fields*:
+ versionId

   *type*: string; \(length\- max:36 min:7\)

  The version ID of the data set contents which are being created\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## CreateDatastore<a name="cli-iotanalytics-createdatastore"></a>

Creates a data store, which is a repository for messages\.

 *CLI Synopsis*:

```
aws iotanalytics  create-datastore
 --datastore-name <value>
[--datastore-storage <value>]
[--retention-period <value>]
[--tags <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datastoreName": "string",
  "datastoreStorage": {
    "serviceManagedS3": {
    },
    "customerManagedS3": {
      "bucket": "string",
      "keyPrefix": "string",
      "roleArn": "string"
    }
  },
  "retentionPeriod": {
    "unlimited": "boolean",
    "numberOfDays": "integer"
  },
  "tags": [
    {
      "key": "string",
      "value": "string"
    }
  ]
}
```

 *fields*:
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store\.
+ datastoreStorage

   *type*: DatastoreStorage

  Where data store data is stored\. You may choose one of "serviceManagedS3" or "customerManagedS3" storage\. If not specified, the default is "serviceManagedS3"\. This cannot be changed after the data store is created\.
+ serviceManagedS3

   *type*: ServiceManagedDatastoreS3Storage

  Use this to store data store data in an S3 bucket managed by the AWS IoT Analytics service\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the data store\.
+ customerManagedS3

   *type*: CustomerManagedDatastoreS3Storage

  Use this to store data store data in an S3 bucket that you manage\. When customer managed storage is selected, the "retentionPeriod" parameter is ignored\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the data store\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket in which data store data is stored\.
+ keyPrefix

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*/$\)

  \[Optional\] The prefix used to create the keys of the data store data objects\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. The prefix must end with a '/'\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 resources\.
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, message data is kept for the data store\. When "customerManagedS3" storage is selected, this parameter is ignored\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.
+ tags

   *type*: list member: Tag

  Metadata which can be used to manage the data store\.
+ key

   *type*: string; \(length\- max:256 min:1\)

  The tag's key\.
+ value

   *type*: string; \(length\- max:256 min:1\)

  The tag's value\.

Output:

```
{
  "datastoreName": "string",
  "datastoreArn": "string",
  "retentionPeriod": {
    "unlimited": "boolean",
    "numberOfDays": "integer"
  }
}
```

 *fields*:
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store\.
+ datastoreArn

   *type*: string

  The ARN of the data store\.
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, message data is kept for the data store\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceAlreadyExistsException

  A resource with the same name already exists\.

  HTTP response code: 409
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429
+ LimitExceededException

  The command caused an internal limit to be exceeded\.

  HTTP response code: 410

## CreatePipeline<a name="cli-iotanalytics-createpipeline"></a>

Creates a pipeline\. A pipeline consumes messages from a channel and allows you to process the messages before storing them in a data store\. You must specify both a channel and a datastore activity and, optionally, as many as 23 additional activities in the pipelineActivities array\.

 *CLI Synopsis*:

```
aws iotanalytics  create-pipeline
 --pipeline-name <value>
 --pipeline-activities <value>
[--tags <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "pipelineName": "string",
  "pipelineActivities": [
    {
      "channel": {
        "name": "string",
        "channelName": "string",
        "next": "string"
      },
      "lambda": {
        "name": "string",
        "lambdaName": "string",
        "batchSize": "integer",
        "next": "string"
      },
      "datastore": {
        "name": "string",
        "datastoreName": "string"
      },
      "addAttributes": {
        "name": "string",
        "attributes": {
          "string": "string"
        },
        "next": "string"
      },
      "removeAttributes": {
        "name": "string",
        "attributes": [
          "string"
        ],
        "next": "string"
      },
      "selectAttributes": {
        "name": "string",
        "attributes": [
          "string"
        ],
        "next": "string"
      },
      "filter": {
        "name": "string",
        "filter": "string",
        "next": "string"
      },
      "math": {
        "name": "string",
        "attribute": "string",
        "math": "string",
        "next": "string"
      },
      "deviceRegistryEnrich": {
        "name": "string",
        "attribute": "string",
        "thingName": "string",
        "roleArn": "string",
        "next": "string"
      },
      "deviceShadowEnrich": {
        "name": "string",
        "attribute": "string",
        "thingName": "string",
        "roleArn": "string",
        "next": "string"
      }
    }
  ],
  "tags": [
    {
      "key": "string",
      "value": "string"
    }
  ]
}
```

 *fields*:
+ pipelineName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the pipeline\.
+ pipelineActivities

   *type*: list member: PipelineActivity

  A list of "PipelineActivity" objects\. Activities perform transformations on your messages, such as removing, renaming or adding message attributes; filtering messages based on attribute values; invoking your Lambda functions on messages for advanced processing; or performing mathematical transformations to normalize device data\. The list can be 2\-25 PipelineActivity objects and must contain both a channel and a datastore activity\. Each entry in the list must contain only one activity, for example: pipelineActivities = \[ \{ "channel": \{ \.\.\. \} \}, \{ "lambda": \{ \.\.\. \} \}, \.\.\. \]
+ channel

   *type*: ChannelActivity

  Determines the source of the messages to be processed\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'channel' activity\.
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel from which the messages are processed\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ lambda

   *type*: LambdaActivity

  Runs a Lambda function to modify the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'lambda' activity\.
+ lambdaName

   *type*: string; \(length\- max:64 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\-\]\+$\)

  The name of the Lambda function that is run on the message\.
+ batchSize

   *type*: integer java class: java\.lang\.Integer range\- max:1000 min:1

  The number of messages passed to the Lambda function for processing\. The AWS Lambda function must be able to process all of these messages within five minutes, which is the maximum timeout duration for Lambda functions\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ datastore

   *type*: DatastoreActivity

  Specifies where to store the processed message data\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'datastore' activity\.
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store where processed messages are stored\.
+ addAttributes

   *type*: AddAttributesActivity

  Adds other attributes based on existing attributes in the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'addAttributes' activity\.
+ attributes

   *type*: map key: AttributeName value: AttributeName

  A list of 1\-50 "AttributeNameMapping" objects that map an existing attribute to a new attribute\. The existing attributes remain in the message, so if you want to remove the originals, use "RemoveAttributeActivity"\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ removeAttributes

   *type*: RemoveAttributesActivity

  Removes attributes from a message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'removeAttributes' activity\.
+ attributes

   *type*: list member: AttributeName

  A list of 1\-50 attributes to remove from the message\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ selectAttributes

   *type*: SelectAttributesActivity

  Creates a new message using only the specified attributes from the original message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'selectAttributes' activity\.
+ attributes

   *type*: list member: AttributeName

  A list of the attributes to select from the message\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ filter

   *type*: FilterActivity

  Filters a message based on its attributes\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'filter' activity\.
+ filter

   *type*: string; \(length\- max:256 min:1\)

  An expression that looks like a SQL WHERE clause that must return a Boolean value\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ math

   *type*: MathActivity

  Computes an arithmetic expression using the message's attributes and adds it to the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'math' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that contains the result of the math operation\.
+ math

   *type*: string; \(length\- max:256 min:1\)

  An expression that uses one or more existing attributes and must return an integer value\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ deviceRegistryEnrich

   *type*: DeviceRegistryEnrichActivity

  Adds data from the AWS IoT device registry to your message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'deviceRegistryEnrich' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that is added to the message\.
+ thingName

   *type*: string; \(length\- max:256 min:1\)

  The name of the IoT device whose registry information is added to the message\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that allows access to the device's registry information\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ deviceShadowEnrich

   *type*: DeviceShadowEnrichActivity

  Adds information from the AWS IoT Device Shadows service to a message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'deviceShadowEnrich' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that is added to the message\.
+ thingName

   *type*: string; \(length\- max:256 min:1\)

  The name of the IoT device whose shadow information is added to the message\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that allows access to the device's shadow\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ tags

   *type*: list member: Tag

  Metadata which can be used to manage the pipeline\.
+ key

   *type*: string; \(length\- max:256 min:1\)

  The tag's key\.
+ value

   *type*: string; \(length\- max:256 min:1\)

  The tag's value\.

Output:

```
{
  "pipelineName": "string",
  "pipelineArn": "string"
}
```

 *fields*:
+ pipelineName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the pipeline\.
+ pipelineArn

   *type*: string

  The ARN of the pipeline\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceAlreadyExistsException

  A resource with the same name already exists\.

  HTTP response code: 409
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429
+ LimitExceededException

  The command caused an internal limit to be exceeded\.

  HTTP response code: 410

## DeleteChannel<a name="cli-iotanalytics-deletechannel"></a>

Deletes the specified channel\.

 *CLI Synopsis*:

```
aws iotanalytics  delete-channel
 --channel-name <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "channelName": "string"
}
```

 *fields*:
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel to delete\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## DeleteDataset<a name="cli-iotanalytics-deletedataset"></a>

Deletes the specified data set\. You do not have to delete the content of the data set before you perform this operation\.

 *CLI Synopsis*:

```
aws iotanalytics  delete-dataset
 --dataset-name <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datasetName": "string"
}
```

 *fields*:
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set to delete\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## DeleteDatasetContent<a name="cli-iotanalytics-deletedatasetcontent"></a>

Deletes the content of the specified data set\.

 *CLI Synopsis*:

```
aws iotanalytics  delete-dataset-content
 --dataset-name <value>
[--version-id <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datasetName": "string",
  "versionId": "string"
}
```

 *fields*:
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose content is deleted\.
+ versionId

   *type*: string; \(length\- max:36 min:7\)

  The version of the data set whose content is deleted\. You can also use the strings "$LATEST" or "$LATEST\_SUCCEEDED" to delete the latest or latest successfully completed data set\. If not specified, "$LATEST\_SUCCEEDED" is the default\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## DeleteDatastore<a name="cli-iotanalytics-deletedatastore"></a>

Deletes the specified data store\.

 *CLI Synopsis*:

```
aws iotanalytics  delete-datastore
 --datastore-name <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datastoreName": "string"
}
```

 *fields*:
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store to delete\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## DeletePipeline<a name="cli-iotanalytics-deletepipeline"></a>

Deletes the specified pipeline\.

 *CLI Synopsis*:

```
aws iotanalytics  delete-pipeline
 --pipeline-name <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "pipelineName": "string"
}
```

 *fields*:
+ pipelineName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the pipeline to delete\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## DescribeChannel<a name="cli-iotanalytics-describechannel"></a>

Retrieves information about a channel\.

 *CLI Synopsis*:

```
aws iotanalytics  describe-channel
 --channel-name <value>
[--include-statistics | --no-include-statistics]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "channelName": "string",
  "includeStatistics": "boolean"
}
```

 *fields*:
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel whose information is retrieved\.
+ includeStatistics

   *type*: boolean

  If true, additional statistical information about the channel is included in the response\. This feature cannot be used with a channel whose S3 storage is customer\-managed\.

Output:

```
{
  "channel": {
    "name": "string",
    "storage": {
      "serviceManagedS3": {
      },
      "customerManagedS3": {
        "bucket": "string",
        "keyPrefix": "string",
        "roleArn": "string"
      }
    },
    "arn": "string",
    "status": "string",
    "retentionPeriod": {
      "unlimited": "boolean",
      "numberOfDays": "integer"
    },
    "creationTime": "timestamp",
    "lastUpdateTime": "timestamp"
  },
  "statistics": {
    "size": {
      "estimatedSizeInBytes": "double",
      "estimatedOn": "timestamp"
    }
  }
}
```

 *fields*:
+ channel

   *type*: Channel

  An object that contains information about the channel\.
+ name

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel\.
+ storage

   *type*: ChannelStorage

  Where channel data is stored\. You may choose one of "serviceManagedS3" or "customerManagedS3" storage\. If not specified, the default is "serviceManagedS3"\. This cannot be changed after creation of the channel\.
+ serviceManagedS3

   *type*: ServiceManagedChannelS3Storage

  Use this to store channel data in an S3 bucket managed by the AWS IoT Analytics service\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the channel\.
+ customerManagedS3

   *type*: CustomerManagedChannelS3Storage

  Use this to store channel data in an S3 bucket that you manage\. If customer managed storage is selected, the "retentionPeriod" parameter is ignored\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the channel\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket in which channel data is stored\.
+ keyPrefix

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*/$\)

  \[Optional\] The prefix used to create the keys of the channel data objects\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. The prefix must end with a '/'\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 resources\.
+ arn

   *type*: string

  The ARN of the channel\.
+ status

   *type*: string

  The status of the channel\. enum: CREATING \| ACTIVE \| DELETING
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, message data is kept for the channel\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.
+ creationTime

   *type*: timestamp

  When the channel was created\.
+ lastUpdateTime

   *type*: timestamp

  When the channel was last updated\.
+ statistics

   *type*: ChannelStatistics

  Statistics about the channel\. Included if the 'includeStatistics' parameter is set to true in the request\.
+ size

   *type*: EstimatedResourceSize

  The estimated size of the channel\.
+ estimatedOn

   *type*: timestamp

  The time when the estimate of the size of the resource was made\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## DescribeDataset<a name="cli-iotanalytics-describedataset"></a>

Retrieves information about a data set\.

 *CLI Synopsis*:

```
aws iotanalytics  describe-dataset
 --dataset-name <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datasetName": "string"
}
```

 *fields*:
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose information is retrieved\.

Output:

```
{
  "dataset": {
    "name": "string",
    "arn": "string",
    "actions": [
      {
        "actionName": "string",
        "queryAction": {
          "sqlQuery": "string",
          "filters": [
            {
              "deltaTime": {
                "offsetSeconds": "integer",
                "timeExpression": "string"
              }
            }
          ]
        },
        "containerAction": {
          "image": "string",
          "executionRoleArn": "string",
          "resourceConfiguration": {
            "computeType": "string",
            "volumeSizeInGB": "integer"
          },
          "variables": [
            {
              "name": "string",
              "stringValue": "string",
              "doubleValue": "double",
              "datasetContentVersionValue": {
                "datasetName": "string"
              },
              "outputFileUriValue": {
                "fileName": "string"
              }
            }
          ]
        }
      }
    ],
    "triggers": [
      {
        "schedule": {
          "expression": "string"
        },
        "dataset": {
          "name": "string"
        }
      }
    ],
    "contentDeliveryRules": [
      {
        "entryName": "string",
        "destination": {
          "iotEventsDestinationConfiguration": {
            "inputName": "string",
            "roleArn": "string"
          },
          "s3DestinationConfiguration": {
            "bucket": "string",
            "key": "string",
            "glueConfiguration": {
              "tableName": "string",
              "databaseName": "string"
            },
            "roleArn": "string"
          }
        }
      }
    ],
    "status": "string",
    "creationTime": "timestamp",
    "lastUpdateTime": "timestamp",
    "retentionPeriod": {
      "unlimited": "boolean",
      "numberOfDays": "integer"
    },
    "versioningConfiguration": {
      "unlimited": "boolean",
      "maxVersions": "integer"
    }
  }
}
```

 *fields*:
+ dataset

   *type*: Dataset

  An object that contains information about the data set\.
+ name

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set\.
+ arn

   *type*: string

  The ARN of the data set\.
+ actions

   *type*: list member: DatasetAction

  The "DatasetAction" objects that automatically create the data set contents\.
+ actionName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set action by which data set contents are automatically created\.
+ queryAction

   *type*: SqlQueryDatasetAction

  An "SqlQueryDatasetAction" object that uses an SQL query to automatically create data set contents\.
+ sqlQuery

   *type*: string

  A SQL query string\.
+ filters

   *type*: list member: QueryFilter

  Pre\-filters applied to message data\.
+ deltaTime

   *type*: DeltaTime

  Used to limit data to that which has arrived since the last execution of the action\.
+ offsetSeconds

   *type*: integer java class: java\.lang\.Integer

  The number of seconds of estimated "in flight" lag time of message data\. When you create data set contents using message data from a specified time frame, some message data may still be "in flight" when processing begins, and so will not arrive in time to be processed\. Use this field to make allowances for the "in flight" time of your message data, so that data not processed from a previous time frame will be included with the next time frame\. Without this, missed message data would be excluded from processing during the next time frame as well, because its timestamp places it within the previous time frame\.
+ timeExpression

   *type*: string

  An expression by which the time of the message data may be determined\. This may be the name of a timestamp field, or a SQL expression which is used to derive the time the message data was generated\.
+ containerAction

   *type*: ContainerDatasetAction

  Information which allows the system to run a containerized application in order to create the data set contents\. The application must be in a Docker container along with any needed support libraries\.
+ image

   *type*: string; \(length\- max:255\)

  The ARN of the Docker container stored in your account\. The Docker container contains an application and needed support libraries and is used to generate data set contents\.
+ executionRoleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which gives permission to the system to access needed resources in order to run the "containerAction"\. This includes, at minimum, permission to retrieve the data set contents which are the input to the containerized application\.
+ resourceConfiguration

   *type*: ResourceConfiguration

  Configuration of the resource which executes the "containerAction"\.
+ computeType

   *type*: string

  The type of the compute resource used to execute the "containerAction"\. Possible values are: ACU\_1 \(vCPU=4, memory=16GiB\) or ACU\_2 \(vCPU=8, memory=32GiB\)\. enum: ACU\_1 \| ACU\_2
+ volumeSizeInGB

   *type*: integer range\- max:50 min:1

  The size \(in GB\) of the persistent storage available to the resource instance used to execute the "containerAction" \(min: 1, max: 50\)\.
+ variables

   *type*: list member: Variable

  The values of variables used within the context of the execution of the containerized application \(basically, parameters passed to the application\)\. Each variable must have a name and a value given by one of "stringValue", "datasetContentVersionValue", or "outputFileUriValue"\.
+ name

   *type*: string; \(length\- max:256 min:1\)

  The name of the variable\.
+ stringValue

   *type*: string; \(length\- max:1024 min:0\)

  The value of the variable as a string\.
+ datasetContentVersionValue

   *type*: DatasetContentVersionValue

  The value of the variable as a structure that specifies a data set content version\.
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose latest contents are used as input to the notebook or application\.
+ outputFileUriValue

   *type*: OutputFileUriValue

  The value of the variable as a structure that specifies an output file URI\.
+ fileName

   *type*: string; \(pattern: \[w\.\-\]\{1,255\}\)

  The URI of the location where data set contents are stored, usually the URI of a file in an S3 bucket\.
+ triggers

   *type*: list member: DatasetTrigger

  The "DatasetTrigger" objects that specify when the data set is automatically updated\.
+ schedule

   *type*: Schedule

  The "Schedule" when the trigger is initiated\.
+ expression

   *type*: string

  The expression that defines when to trigger an update\. For more information, see Schedule Expressions for Rules in the Amazon CloudWatch Events User Guide\.
+ dataset

   *type*: TriggeringDataset

  The data set whose content creation triggers the creation of this data set's contents\.
+ name

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose content generation triggers the new data set content generation\.
+ contentDeliveryRules

   *type*: list member: DatasetContentDeliveryRule

  When data set contents are created they are delivered to destinations specified here\.
+ entryName

   *type*: string

  The name of the data set content delivery rules entry\.
+ destination

   *type*: DatasetContentDeliveryDestination

  The destination to which data set contents are delivered\.
+ iotEventsDestinationConfiguration

   *type*: IotEventsDestinationConfiguration

  Configuration information for delivery of data set contents to AWS IoT Events\.
+ inputName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z\]\[a\-zA\-Z0\-9\_\]\*$\)

  The name of the AWS IoT Events input to which data set contents are delivered\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to deliver data set contents to an AWS IoT Events input\.
+ s3DestinationConfiguration

   *type*: S3DestinationConfiguration

  Configuration information for delivery of data set contents to Amazon S3\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket to which data set contents are delivered\.
+ key

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*$\)

  The key of the data set contents object\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. To produce a unique key, you can use "\!\{iotanalytics:scheduledTime\}" to insert the time of the scheduled SQL query run, or "\!\{iotanalytics:versioned\} to insert a unique hash identifying the data set, for example: "/DataSet/\!\{iotanalytics:scheduledTime\}/\!\{iotanalytics:versioned\}\.csv"\.
+ glueConfiguration

   *type*: GlueConfiguration

  Configuration information for coordination with the AWS Glue ETL \(extract, transform and load\) service\.
+ tableName

   *type*: string; \(length\- max:150 min:1\); \(pattern: \[u0020\-uD7FFuE000\-uFFFDuD800uDC00\-uDBFFuDFFFt\]\*\)

  The name of the table in your AWS Glue Data Catalog which is used to perform the ETL \(extract, transform and load\) operations\. \(An AWS Glue Data Catalog table contains partitioned data and descriptions of data sources and targets\.\)
+ databaseName

   *type*: string; \(length\- max:150 min:1\); \(pattern: \[u0020\-uD7FFuE000\-uFFFDuD800uDC00\-uDBFFuDFFFt\]\*\)

  The name of the database in your AWS Glue Data Catalog in which the table is located\. \(An AWS Glue Data Catalog database contains Glue Data tables\.\)
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 and AWS Glue resources\.
+ status

   *type*: string

  The status of the data set\. enum: CREATING \| ACTIVE \| DELETING
+ creationTime

   *type*: timestamp

  When the data set was created\.
+ lastUpdateTime

   *type*: timestamp

  The last time the data set was updated\.
+ retentionPeriod

   *type*: RetentionPeriod

  \[Optional\] How long, in days, message data is kept for the data set\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.
+ versioningConfiguration

   *type*: VersioningConfiguration

  \[Optional\] How many versions of data set contents are kept\. If not specified or set to null, only the latest version plus the latest succeeded version \(if they are different\) are kept for the time period specified by the "retentionPeriod" parameter\. \(For more information, see [https://docs\.aws\.amazon\.com/iotanalytics/latest/userguide/getting\-started\.html\#aws\-iot\-analytics\-dataset\-versions](https://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html#aws-iot-analytics-dataset-versions)\)
+ unlimited

   *type*: boolean

  If true, unlimited versions of data set contents will be kept\.
+ maxVersions

   *type*: integer java class: java\.lang\.Integer range\- max:1000 min:1

  How many versions of data set contents will be kept\. The "unlimited" parameter must be false\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## DescribeDatastore<a name="cli-iotanalytics-describedatastore"></a>

Retrieves information about a data store\.

 *CLI Synopsis*:

```
aws iotanalytics  describe-datastore
 --datastore-name <value>
[--include-statistics | --no-include-statistics]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datastoreName": "string",
  "includeStatistics": "boolean"
}
```

 *fields*:
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store
+ includeStatistics

   *type*: boolean

  If true, additional statistical information about the data store is included in the response\. This feature cannot be used with a data store whose S3 storage is customer\-managed\.

Output:

```
{
  "datastore": {
    "name": "string",
    "storage": {
      "serviceManagedS3": {
      },
      "customerManagedS3": {
        "bucket": "string",
        "keyPrefix": "string",
        "roleArn": "string"
      }
    },
    "arn": "string",
    "status": "string",
    "retentionPeriod": {
      "unlimited": "boolean",
      "numberOfDays": "integer"
    },
    "creationTime": "timestamp",
    "lastUpdateTime": "timestamp"
  },
  "statistics": {
    "size": {
      "estimatedSizeInBytes": "double",
      "estimatedOn": "timestamp"
    }
  }
}
```

 *fields*:
+ datastore

   *type*: Datastore

  Information about the data store\.
+ name

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store\.
+ storage

   *type*: DatastoreStorage

  Where data store data is stored\. You may choose one of "serviceManagedS3" or "customerManagedS3" storage\. If not specified, the default is "serviceManagedS3"\. This cannot be changed after the data store is created\.
+ serviceManagedS3

   *type*: ServiceManagedDatastoreS3Storage

  Use this to store data store data in an S3 bucket managed by the AWS IoT Analytics service\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the data store\.
+ customerManagedS3

   *type*: CustomerManagedDatastoreS3Storage

  Use this to store data store data in an S3 bucket that you manage\. When customer managed storage is selected, the "retentionPeriod" parameter is ignored\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the data store\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket in which data store data is stored\.
+ keyPrefix

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*/$\)

  \[Optional\] The prefix used to create the keys of the data store data objects\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. The prefix must end with a '/'\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 resources\.
+ arn

   *type*: string

  The ARN of the data store\.
+ status

   *type*: string

  The status of a data store: CREATING The data store is being created\. ACTIVE The data store has been created and can be used\. DELETING The data store is being deleted\. enum: CREATING \| ACTIVE \| DELETING
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, message data is kept for the data store\. When "customerManagedS3" storage is selected, this parameter is ignored\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.
+ creationTime

   *type*: timestamp

  When the data store was created\.
+ lastUpdateTime

   *type*: timestamp

  The last time the data store was updated\.
+ statistics

   *type*: DatastoreStatistics

  Additional statistical information about the data store\. Included if the 'includeStatistics' parameter is set to true in the request\.
+ size

   *type*: EstimatedResourceSize

  The estimated size of the data store\.
+ estimatedOn

   *type*: timestamp

  The time when the estimate of the size of the resource was made\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## DescribeLoggingOptions<a name="cli-iotanalytics-describeloggingoptions"></a>

Retrieves the current settings of the AWS IoT Analytics logging options\.

 *CLI Synopsis*:

```
aws iotanalytics  describe-logging-options
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
}
```

 *fields*:

Output:

```
{
  "loggingOptions": {
    "roleArn": "string",
    "level": "string",
    "enabled": "boolean"
  }
}
```

 *fields*:
+ loggingOptions

   *type*: LoggingOptions

  The current settings of the AWS IoT Analytics logging options\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that grants permission to AWS IoT Analytics to perform logging\.
+ level

   *type*: string

  The logging level\. Currently, only "ERROR" is supported\. enum: ERROR
+ enabled

   *type*: boolean

  If true, logging is enabled for AWS IoT Analytics\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## DescribePipeline<a name="cli-iotanalytics-describepipeline"></a>

Retrieves information about a pipeline\.

 *CLI Synopsis*:

```
aws iotanalytics  describe-pipeline
 --pipeline-name <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "pipelineName": "string"
}
```

 *fields*:
+ pipelineName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the pipeline whose information is retrieved\.

Output:

```
{
  "pipeline": {
    "name": "string",
    "arn": "string",
    "activities": [
      {
        "channel": {
          "name": "string",
          "channelName": "string",
          "next": "string"
        },
        "lambda": {
          "name": "string",
          "lambdaName": "string",
          "batchSize": "integer",
          "next": "string"
        },
        "datastore": {
          "name": "string",
          "datastoreName": "string"
        },
        "addAttributes": {
          "name": "string",
          "attributes": {
            "string": "string"
          },
          "next": "string"
        },
        "removeAttributes": {
          "name": "string",
          "attributes": [
            "string"
          ],
          "next": "string"
        },
        "selectAttributes": {
          "name": "string",
          "attributes": [
            "string"
          ],
          "next": "string"
        },
        "filter": {
          "name": "string",
          "filter": "string",
          "next": "string"
        },
        "math": {
          "name": "string",
          "attribute": "string",
          "math": "string",
          "next": "string"
        },
        "deviceRegistryEnrich": {
          "name": "string",
          "attribute": "string",
          "thingName": "string",
          "roleArn": "string",
          "next": "string"
        },
        "deviceShadowEnrich": {
          "name": "string",
          "attribute": "string",
          "thingName": "string",
          "roleArn": "string",
          "next": "string"
        }
      }
    ],
    "reprocessingSummaries": [
      {
        "id": "string",
        "status": "string",
        "creationTime": "timestamp"
      }
    ],
    "creationTime": "timestamp",
    "lastUpdateTime": "timestamp"
  }
}
```

 *fields*:
+ pipeline

   *type*: Pipeline

  A "Pipeline" object that contains information about the pipeline\.
+ name

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the pipeline\.
+ arn

   *type*: string

  The ARN of the pipeline\.
+ activities

   *type*: list member: PipelineActivity

  The activities that perform transformations on the messages\.
+ channel

   *type*: ChannelActivity

  Determines the source of the messages to be processed\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'channel' activity\.
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel from which the messages are processed\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ lambda

   *type*: LambdaActivity

  Runs a Lambda function to modify the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'lambda' activity\.
+ lambdaName

   *type*: string; \(length\- max:64 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\-\]\+$\)

  The name of the Lambda function that is run on the message\.
+ batchSize

   *type*: integer java class: java\.lang\.Integer range\- max:1000 min:1

  The number of messages passed to the Lambda function for processing\. The AWS Lambda function must be able to process all of these messages within five minutes, which is the maximum timeout duration for Lambda functions\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ datastore

   *type*: DatastoreActivity

  Specifies where to store the processed message data\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'datastore' activity\.
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store where processed messages are stored\.
+ addAttributes

   *type*: AddAttributesActivity

  Adds other attributes based on existing attributes in the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'addAttributes' activity\.
+ attributes

   *type*: map key: AttributeName value: AttributeName

  A list of 1\-50 "AttributeNameMapping" objects that map an existing attribute to a new attribute\. The existing attributes remain in the message, so if you want to remove the originals, use "RemoveAttributeActivity"\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ removeAttributes

   *type*: RemoveAttributesActivity

  Removes attributes from a message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'removeAttributes' activity\.
+ attributes

   *type*: list member: AttributeName

  A list of 1\-50 attributes to remove from the message\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ selectAttributes

   *type*: SelectAttributesActivity

  Creates a new message using only the specified attributes from the original message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'selectAttributes' activity\.
+ attributes

   *type*: list member: AttributeName

  A list of the attributes to select from the message\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ filter

   *type*: FilterActivity

  Filters a message based on its attributes\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'filter' activity\.
+ filter

   *type*: string; \(length\- max:256 min:1\)

  An expression that looks like a SQL WHERE clause that must return a Boolean value\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ math

   *type*: MathActivity

  Computes an arithmetic expression using the message's attributes and adds it to the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'math' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that contains the result of the math operation\.
+ math

   *type*: string; \(length\- max:256 min:1\)

  An expression that uses one or more existing attributes and must return an integer value\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ deviceRegistryEnrich

   *type*: DeviceRegistryEnrichActivity

  Adds data from the AWS IoT device registry to your message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'deviceRegistryEnrich' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that is added to the message\.
+ thingName

   *type*: string; \(length\- max:256 min:1\)

  The name of the IoT device whose registry information is added to the message\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that allows access to the device's registry information\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ deviceShadowEnrich

   *type*: DeviceShadowEnrichActivity

  Adds information from the AWS IoT Device Shadows service to a message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'deviceShadowEnrich' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that is added to the message\.
+ thingName

   *type*: string; \(length\- max:256 min:1\)

  The name of the IoT device whose shadow information is added to the message\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that allows access to the device's shadow\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ reprocessingSummaries

   *type*: list member: ReprocessingSummary

  A summary of information about the pipeline reprocessing\.
+ id

   *type*: string

  The 'reprocessingId' returned by "StartPipelineReprocessing"\.
+ status

   *type*: string

  The status of the pipeline reprocessing\. enum: RUNNING \| SUCCEEDED \| CANCELLED \| FAILED
+ creationTime

   *type*: timestamp

  The time the pipeline reprocessing was created\.
+ creationTime

   *type*: timestamp

  When the pipeline was created\.
+ lastUpdateTime

   *type*: timestamp

  The last time the pipeline was updated\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## GetDatasetContent<a name="cli-iotanalytics-getdatasetcontent"></a>

Retrieves the contents of a data set as pre\-signed URIs\.

 *CLI Synopsis*:

```
aws iotanalytics  get-dataset-content
 --dataset-name <value>
[--version-id <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datasetName": "string",
  "versionId": "string"
}
```

 *fields*:
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose contents are retrieved\.
+ versionId

   *type*: string; \(length\- max:36 min:7\)

  The version of the data set whose contents are retrieved\. You can also use the strings "$LATEST" or "$LATEST\_SUCCEEDED" to retrieve the contents of the latest or latest successfully completed data set\. If not specified, "$LATEST\_SUCCEEDED" is the default\.

Output:

```
{
  "entries": [
    {
      "entryName": "string",
      "dataURI": "string"
    }
  ],
  "timestamp": "timestamp",
  "status": {
    "state": "string",
    "reason": "string"
  }
}
```

 *fields*:
+ entries

   *type*: list member: DatasetEntry

  A list of "DatasetEntry" objects\.
+ entryName

   *type*: string

  The name of the data set item\.
+ dataURI

   *type*: string

  The pre\-signed URI of the data set item\.
+ timestamp

   *type*: timestamp

  The time when the request was made\.
+ status

   *type*: DatasetContentStatus

  The status of the data set content\.
+ state

   *type*: string

  The state of the data set contents\. Can be one of "READY", "CREATING", "SUCCEEDED" or "FAILED"\. enum: CREATING \| SUCCEEDED \| FAILED
+ reason

   *type*: string

  The reason the data set contents are in this state\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## ListChannels<a name="cli-iotanalytics-listchannels"></a>

Retrieves a list of channels\.

 *CLI Synopsis*:

```
aws iotanalytics  list-channels
[--next-token <value>]
[--max-results <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "nextToken": "string",
  "maxResults": "integer"
}
```

 *fields*:
+ nextToken

   *type*: string

  The token for the next set of results\.
+ maxResults

   *type*: integer java class: java\.lang\.Integer range\- max:250 min:1

  The maximum number of results to return in this request\. The default value is 100\.

Output:

```
{
  "channelSummaries": [
    {
      "channelName": "string",
      "channelStorage": {
        "serviceManagedS3": {
        },
        "customerManagedS3": {
          "bucket": "string",
          "keyPrefix": "string",
          "roleArn": "string"
        }
      },
      "status": "string",
      "creationTime": "timestamp",
      "lastUpdateTime": "timestamp"
    }
  ],
  "nextToken": "string"
}
```

 *fields*:
+ channelSummaries

   *type*: list member: ChannelSummary

  A list of "ChannelSummary" objects\.
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel\.
+ channelStorage

   *type*: ChannelStorageSummary

  Where channel data is stored\.
+ serviceManagedS3

   *type*: ServiceManagedChannelS3StorageSummary

  Used to store channel data in an S3 bucket managed by the AWS IoT Analytics service\.
+ customerManagedS3

   *type*: CustomerManagedChannelS3StorageSummary

  Used to store channel data in an S3 bucket that you manage\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket in which channel data is stored\.
+ keyPrefix

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*/$\)

  \[Optional\] The prefix used to create the keys of the channel data objects\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. The prefix must end with a '/'\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 resources\.
+ status

   *type*: string

  The status of the channel\. enum: CREATING \| ACTIVE \| DELETING
+ creationTime

   *type*: timestamp

  When the channel was created\.
+ lastUpdateTime

   *type*: timestamp

  The last time the channel was updated\.
+ nextToken

   *type*: string

  The token to retrieve the next set of results, or null if there are no more results\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## ListDatasetContents<a name="cli-iotanalytics-listdatasetcontents"></a>

Lists information about data set contents that have been created\.

 *CLI Synopsis*:

```
aws iotanalytics  list-dataset-contents
 --dataset-name <value>
[--next-token <value>]
[--max-results <value>]
[--scheduled-on-or-after <value>]
[--scheduled-before <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datasetName": "string",
  "nextToken": "string",
  "maxResults": "integer",
  "scheduledOnOrAfter": "timestamp",
  "scheduledBefore": "timestamp"
}
```

 *fields*:
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose contents information you want to list\.
+ nextToken

   *type*: string

  The token for the next set of results\.
+ maxResults

   *type*: integer java class: java\.lang\.Integer range\- max:250 min:1

  The maximum number of results to return in this request\.
+ scheduledOnOrAfter

   *type*: timestamp

  A filter to limit results to those data set contents whose creation is scheduled on or after the given time\. See the field triggers\.schedule in the CreateDataset request\. \(timestamp\)
+ scheduledBefore

   *type*: timestamp

  A filter to limit results to those data set contents whose creation is scheduled before the given time\. See the field triggers\.schedule in the CreateDataset request\. \(timestamp\)

Output:

```
{
  "datasetContentSummaries": [
    {
      "version": "string",
      "status": {
        "state": "string",
        "reason": "string"
      },
      "creationTime": "timestamp",
      "scheduleTime": "timestamp"
    }
  ],
  "nextToken": "string"
}
```

 *fields*:
+ datasetContentSummaries

   *type*: list member: DatasetContentSummary

  Summary information about data set contents that have been created\.
+ version

   *type*: string; \(length\- max:36 min:7\)

  The version of the data set contents\.
+ status

   *type*: DatasetContentStatus

  The status of the data set contents\.
+ state

   *type*: string

  The state of the data set contents\. Can be one of "READY", "CREATING", "SUCCEEDED" or "FAILED"\. enum: CREATING \| SUCCEEDED \| FAILED
+ reason

   *type*: string

  The reason the data set contents are in this state\.
+ creationTime

   *type*: timestamp

  The actual time the creation of the data set contents was started\.
+ scheduleTime

   *type*: timestamp

  The time the creation of the data set contents was scheduled to start\.
+ nextToken

   *type*: string

  The token to retrieve the next set of results, or null if there are no more results\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404

## ListDatasets<a name="cli-iotanalytics-listdatasets"></a>

Retrieves information about data sets\.

 *CLI Synopsis*:

```
aws iotanalytics  list-datasets
[--next-token <value>]
[--max-results <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "nextToken": "string",
  "maxResults": "integer"
}
```

 *fields*:
+ nextToken

   *type*: string

  The token for the next set of results\.
+ maxResults

   *type*: integer java class: java\.lang\.Integer range\- max:250 min:1

  The maximum number of results to return in this request\. The default value is 100\.

Output:

```
{
  "datasetSummaries": [
    {
      "datasetName": "string",
      "status": "string",
      "creationTime": "timestamp",
      "lastUpdateTime": "timestamp",
      "triggers": [
        {
          "schedule": {
            "expression": "string"
          },
          "dataset": {
            "name": "string"
          }
        }
      ],
      "actions": [
        {
          "actionName": "string",
          "actionType": "string"
        }
      ]
    }
  ],
  "nextToken": "string"
}
```

 *fields*:
+ datasetSummaries

   *type*: list member: DatasetSummary

  A list of "DatasetSummary" objects\.
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set\.
+ status

   *type*: string

  The status of the data set\. enum: CREATING \| ACTIVE \| DELETING
+ creationTime

   *type*: timestamp

  The time the data set was created\.
+ lastUpdateTime

   *type*: timestamp

  The last time the data set was updated\.
+ triggers

   *type*: list member: DatasetTrigger

  A list of triggers\. A trigger causes data set content to be populated at a specified time interval or when another data set is populated\. The list of triggers can be empty or contain up to five DataSetTrigger objects
+ schedule

   *type*: Schedule

  The "Schedule" when the trigger is initiated\.
+ expression

   *type*: string

  The expression that defines when to trigger an update\. For more information, see Schedule Expressions for Rules in the Amazon CloudWatch Events User Guide\.
+ dataset

   *type*: TriggeringDataset

  The data set whose content creation triggers the creation of this data set's contents\.
+ name

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose content generation triggers the new data set content generation\.
+ actions

   *type*: list member: DatasetActionSummary

  A list of "DataActionSummary" objects\.
+ actionName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the action which automatically creates the data set's contents\.
+ actionType

   *type*: string

  The type of action by which the data set's contents are automatically created\. enum: QUERY \| CONTAINER
+ nextToken

   *type*: string

  The token to retrieve the next set of results, or null if there are no more results\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## ListDatastores<a name="cli-iotanalytics-listdatastores"></a>

Retrieves a list of data stores\.

 *CLI Synopsis*:

```
aws iotanalytics  list-datastores
[--next-token <value>]
[--max-results <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "nextToken": "string",
  "maxResults": "integer"
}
```

 *fields*:
+ nextToken

   *type*: string

  The token for the next set of results\.
+ maxResults

   *type*: integer java class: java\.lang\.Integer range\- max:250 min:1

  The maximum number of results to return in this request\. The default value is 100\.

Output:

```
{
  "datastoreSummaries": [
    {
      "datastoreName": "string",
      "datastoreStorage": {
        "serviceManagedS3": {
        },
        "customerManagedS3": {
          "bucket": "string",
          "keyPrefix": "string",
          "roleArn": "string"
        }
      },
      "status": "string",
      "creationTime": "timestamp",
      "lastUpdateTime": "timestamp"
    }
  ],
  "nextToken": "string"
}
```

 *fields*:
+ datastoreSummaries

   *type*: list member: DatastoreSummary

  A list of "DatastoreSummary" objects\.
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store\.
+ datastoreStorage

   *type*: DatastoreStorageSummary

  Where data store data is stored\.
+ serviceManagedS3

   *type*: ServiceManagedDatastoreS3StorageSummary

  Used to store data store data in an S3 bucket managed by the AWS IoT Analytics service\.
+ customerManagedS3

   *type*: CustomerManagedDatastoreS3StorageSummary

  Used to store data store data in an S3 bucket that you manage\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket in which data store data is stored\.
+ keyPrefix

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*/$\)

  \[Optional\] The prefix used to create the keys of the data store data objects\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. The prefix must end with a '/'\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 resources\.
+ status

   *type*: string

  The status of the data store\. enum: CREATING \| ACTIVE \| DELETING
+ creationTime

   *type*: timestamp

  When the data store was created\.
+ lastUpdateTime

   *type*: timestamp

  The last time the data store was updated\.
+ nextToken

   *type*: string

  The token to retrieve the next set of results, or null if there are no more results\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## ListPipelines<a name="cli-iotanalytics-listpipelines"></a>

Retrieves a list of pipelines\.

 *CLI Synopsis*:

```
aws iotanalytics  list-pipelines
[--next-token <value>]
[--max-results <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "nextToken": "string",
  "maxResults": "integer"
}
```

 *fields*:
+ nextToken

   *type*: string

  The token for the next set of results\.
+ maxResults

   *type*: integer java class: java\.lang\.Integer range\- max:250 min:1

  The maximum number of results to return in this request\. The default value is 100\.

Output:

```
{
  "pipelineSummaries": [
    {
      "pipelineName": "string",
      "reprocessingSummaries": [
        {
          "id": "string",
          "status": "string",
          "creationTime": "timestamp"
        }
      ],
      "creationTime": "timestamp",
      "lastUpdateTime": "timestamp"
    }
  ],
  "nextToken": "string"
}
```

 *fields*:
+ pipelineSummaries

   *type*: list member: PipelineSummary

  A list of "PipelineSummary" objects\.
+ pipelineName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the pipeline\.
+ reprocessingSummaries

   *type*: list member: ReprocessingSummary

  A summary of information about the pipeline reprocessing\.
+ id

   *type*: string

  The 'reprocessingId' returned by "StartPipelineReprocessing"\.
+ status

   *type*: string

  The status of the pipeline reprocessing\. enum: RUNNING \| SUCCEEDED \| CANCELLED \| FAILED
+ creationTime

   *type*: timestamp

  The time the pipeline reprocessing was created\.
+ creationTime

   *type*: timestamp

  When the pipeline was created\.
+ lastUpdateTime

   *type*: timestamp

  When the pipeline was last updated\.
+ nextToken

   *type*: string

  The token to retrieve the next set of results, or null if there are no more results\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## ListTagsForResource<a name="cli-iotanalytics-listtagsforresource"></a>

Lists the tags \(metadata\) which you have assigned to the resource\.

 *CLI Synopsis*:

```
aws iotanalytics  list-tags-for-resource
 --resource-arn <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "resourceArn": "string"
}
```

 *fields*:
+ resourceArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the resource whose tags you want to list\.

Output:

```
{
  "tags": [
    {
      "key": "string",
      "value": "string"
    }
  ]
}
```

 *fields*:
+ tags

   *type*: list member: Tag

  The tags \(metadata\) which you have assigned to the resource\.
+ key

   *type*: string; \(length\- max:256 min:1\)

  The tag's key\.
+ value

   *type*: string; \(length\- max:256 min:1\)

  The tag's value\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429
+ LimitExceededException

  The command caused an internal limit to be exceeded\.

  HTTP response code: 410
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404

## PutLoggingOptions<a name="cli-iotanalytics-putloggingoptions"></a>

Sets or updates the AWS IoT Analytics logging options\. Note that if you update the value of any loggingOptions field, it takes up to one minute for the change to take effect\. Also, if you change the policy attached to the role you specified in the roleArn field \(for example, to correct an invalid policy\) it takes up to 5 minutes for that change to take effect\.

 *CLI Synopsis*:

```
aws iotanalytics  put-logging-options
 --logging-options <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "loggingOptions": {
    "roleArn": "string",
    "level": "string",
    "enabled": "boolean"
  }
}
```

 *fields*:
+ loggingOptions

   *type*: LoggingOptions

  The new values of the AWS IoT Analytics logging options\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that grants permission to AWS IoT Analytics to perform logging\.
+ level

   *type*: string

  The logging level\. Currently, only "ERROR" is supported\. enum: ERROR
+ enabled

   *type*: boolean

  If true, logging is enabled for AWS IoT Analytics\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## RunPipelineActivity<a name="cli-iotanalytics-runpipelineactivity"></a>

Simulates the results of running a pipeline activity on a message payload\.

 *CLI Synopsis*:

```
aws iotanalytics  run-pipeline-activity
 --pipeline-activity <value>
 --payloads <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "pipelineActivity": {
    "channel": {
      "name": "string",
      "channelName": "string",
      "next": "string"
    },
    "lambda": {
      "name": "string",
      "lambdaName": "string",
      "batchSize": "integer",
      "next": "string"
    },
    "datastore": {
      "name": "string",
      "datastoreName": "string"
    },
    "addAttributes": {
      "name": "string",
      "attributes": {
        "string": "string"
      },
      "next": "string"
    },
    "removeAttributes": {
      "name": "string",
      "attributes": [
        "string"
      ],
      "next": "string"
    },
    "selectAttributes": {
      "name": "string",
      "attributes": [
        "string"
      ],
      "next": "string"
    },
    "filter": {
      "name": "string",
      "filter": "string",
      "next": "string"
    },
    "math": {
      "name": "string",
      "attribute": "string",
      "math": "string",
      "next": "string"
    },
    "deviceRegistryEnrich": {
      "name": "string",
      "attribute": "string",
      "thingName": "string",
      "roleArn": "string",
      "next": "string"
    },
    "deviceShadowEnrich": {
      "name": "string",
      "attribute": "string",
      "thingName": "string",
      "roleArn": "string",
      "next": "string"
    }
  },
  "payloads": [
    "blob"
  ]
}
```

 *fields*:
+ pipelineActivity

   *type*: PipelineActivity

  The pipeline activity that is run\. This must not be a 'channel' activity or a 'datastore' activity because these activities are used in a pipeline only to load the original message and to store the \(possibly\) transformed message\. If a 'lambda' activity is specified, only short\-running Lambda functions \(those with a timeout of less than 30 seconds or less\) can be used\.
+ channel

   *type*: ChannelActivity

  Determines the source of the messages to be processed\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'channel' activity\.
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel from which the messages are processed\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ lambda

   *type*: LambdaActivity

  Runs a Lambda function to modify the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'lambda' activity\.
+ lambdaName

   *type*: string; \(length\- max:64 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\-\]\+$\)

  The name of the Lambda function that is run on the message\.
+ batchSize

   *type*: integer java class: java\.lang\.Integer range\- max:1000 min:1

  The number of messages passed to the Lambda function for processing\. The AWS Lambda function must be able to process all of these messages within five minutes, which is the maximum timeout duration for Lambda functions\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ datastore

   *type*: DatastoreActivity

  Specifies where to store the processed message data\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'datastore' activity\.
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store where processed messages are stored\.
+ addAttributes

   *type*: AddAttributesActivity

  Adds other attributes based on existing attributes in the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'addAttributes' activity\.
+ attributes

   *type*: map key: AttributeName value: AttributeName

  A list of 1\-50 "AttributeNameMapping" objects that map an existing attribute to a new attribute\. The existing attributes remain in the message, so if you want to remove the originals, use "RemoveAttributeActivity"\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ removeAttributes

   *type*: RemoveAttributesActivity

  Removes attributes from a message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'removeAttributes' activity\.
+ attributes

   *type*: list member: AttributeName

  A list of 1\-50 attributes to remove from the message\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ selectAttributes

   *type*: SelectAttributesActivity

  Creates a new message using only the specified attributes from the original message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'selectAttributes' activity\.
+ attributes

   *type*: list member: AttributeName

  A list of the attributes to select from the message\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ filter

   *type*: FilterActivity

  Filters a message based on its attributes\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'filter' activity\.
+ filter

   *type*: string; \(length\- max:256 min:1\)

  An expression that looks like a SQL WHERE clause that must return a Boolean value\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ math

   *type*: MathActivity

  Computes an arithmetic expression using the message's attributes and adds it to the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'math' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that contains the result of the math operation\.
+ math

   *type*: string; \(length\- max:256 min:1\)

  An expression that uses one or more existing attributes and must return an integer value\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ deviceRegistryEnrich

   *type*: DeviceRegistryEnrichActivity

  Adds data from the AWS IoT device registry to your message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'deviceRegistryEnrich' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that is added to the message\.
+ thingName

   *type*: string; \(length\- max:256 min:1\)

  The name of the IoT device whose registry information is added to the message\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that allows access to the device's registry information\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ deviceShadowEnrich

   *type*: DeviceShadowEnrichActivity

  Adds information from the AWS IoT Device Shadows service to a message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'deviceShadowEnrich' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that is added to the message\.
+ thingName

   *type*: string; \(length\- max:256 min:1\)

  The name of the IoT device whose shadow information is added to the message\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that allows access to the device's shadow\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ payloads

   *type*: list member: MessagePayload

  The sample message payloads on which the pipeline activity is run\.

Output:

```
{
  "payloads": [
    "blob"
  ],
  "logResult": "string"
}
```

 *fields*:
+ payloads

   *type*: list member: MessagePayload

  The enriched or transformed sample message payloads as base64\-encoded strings\. \(The results of running the pipeline activity on each input sample message payload, encoded in base64\.\)
+ logResult

   *type*: string

  In case the pipeline activity fails, the log message that is generated\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## SampleChannelData<a name="cli-iotanalytics-samplechanneldata"></a>

Retrieves a sample of messages from the specified channel ingested during the specified timeframe\. Up to 10 messages can be retrieved\.

 *CLI Synopsis*:

```
aws iotanalytics  sample-channel-data
 --channel-name <value>
[--max-messages <value>]
[--start-time <value>]
[--end-time <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "channelName": "string",
  "maxMessages": "integer",
  "startTime": "timestamp",
  "endTime": "timestamp"
}
```

 *fields*:
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel whose message samples are retrieved\.
+ maxMessages

   *type*: integer java class: java\.lang\.Integer range\- max:10 min:1

  The number of sample messages to be retrieved\. The limit is 10, the default is also 10\.
+ startTime

   *type*: timestamp

  The start of the time window from which sample messages are retrieved\.
+ endTime

   *type*: timestamp

  The end of the time window from which sample messages are retrieved\.

Output:

```
{
  "payloads": [
    "blob"
  ]
}
```

 *fields*:
+ payloads

   *type*: list member: MessagePayload

  The list of message samples\. Each sample message is returned as a base64\-encoded string\.

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## StartPipelineReprocessing<a name="cli-iotanalytics-startpipelinereprocessing"></a>

Starts the reprocessing of raw message data through the pipeline\.

 *CLI Synopsis*:

```
aws iotanalytics  start-pipeline-reprocessing
 --pipeline-name <value>
[--start-time <value>]
[--end-time <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "pipelineName": "string",
  "startTime": "timestamp",
  "endTime": "timestamp"
}
```

 *fields*:
+ pipelineName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the pipeline on which to start reprocessing\.
+ startTime

   *type*: timestamp

  The start time \(inclusive\) of raw message data that is reprocessed\.
+ endTime

   *type*: timestamp

  The end time \(exclusive\) of raw message data that is reprocessed\.

Output:

```
{
  "reprocessingId": "string"
}
```

 *fields*:
+ reprocessingId

   *type*: string

  The ID of the pipeline reprocessing activity that was started\.

Errors:
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ ResourceAlreadyExistsException

  A resource with the same name already exists\.

  HTTP response code: 409
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## TagResource<a name="cli-iotanalytics-tagresource"></a>

Adds to or modifies the tags of the given resource\. Tags are metadata which can be used to manage a resource\.

 *CLI Synopsis*:

```
aws iotanalytics  tag-resource
 --resource-arn <value>
 --tags <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "resourceArn": "string",
  "tags": [
    {
      "key": "string",
      "value": "string"
    }
  ]
}
```

 *fields*:
+ resourceArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the resource whose tags you want to modify\.
+ tags

   *type*: list member: Tag

  The new or modified tags for the resource\.
+ key

   *type*: string; \(length\- max:256 min:1\)

  The tag's key\.
+ value

   *type*: string; \(length\- max:256 min:1\)

  The tag's value\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429
+ LimitExceededException

  The command caused an internal limit to be exceeded\.

  HTTP response code: 410
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404

## UntagResource<a name="cli-iotanalytics-untagresource"></a>

Removes the given tags \(metadata\) from the resource\.

 *CLI Synopsis*:

```
aws iotanalytics  untag-resource
 --resource-arn <value>
 --tag-keys <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "resourceArn": "string",
  "tagKeys": [
    "string"
  ]
}
```

 *fields*:
+ resourceArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the resource whose tags you want to remove\.
+ tagKeys

   *type*: list member: TagKey

  The keys of those tags which you want to remove\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429
+ LimitExceededException

  The command caused an internal limit to be exceeded\.

  HTTP response code: 410
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404

## UpdateChannel<a name="cli-iotanalytics-updatechannel"></a>

Updates the settings of a channel\.

 *CLI Synopsis*:

```
aws iotanalytics  update-channel
 --channel-name <value>
[--channel-storage <value>]
[--retention-period <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "channelName": "string",
  "channelStorage": {
    "serviceManagedS3": {
    },
    "customerManagedS3": {
      "bucket": "string",
      "keyPrefix": "string",
      "roleArn": "string"
    }
  },
  "retentionPeriod": {
    "unlimited": "boolean",
    "numberOfDays": "integer"
  }
}
```

 *fields*:
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel to be updated\.
+ channelStorage

   *type*: ChannelStorage

  Where channel data is stored\. You may choose one of "serviceManagedS3" or "customerManagedS3" storage\. If not specified, the default is "serviceManagedS3"\. This cannot be changed after creation of the channel\.
+ serviceManagedS3

   *type*: ServiceManagedChannelS3Storage

  Use this to store channel data in an S3 bucket managed by the AWS IoT Analytics service\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the channel\.
+ customerManagedS3

   *type*: CustomerManagedChannelS3Storage

  Use this to store channel data in an S3 bucket that you manage\. If customer managed storage is selected, the "retentionPeriod" parameter is ignored\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the channel\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket in which channel data is stored\.
+ keyPrefix

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*/$\)

  \[Optional\] The prefix used to create the keys of the channel data objects\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. The prefix must end with a '/'\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 resources\.
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, message data is kept for the channel\. The retention period cannot be updated if the channel's S3 storage is customer\-managed\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## UpdateDataset<a name="cli-iotanalytics-updatedataset"></a>

Updates the settings of a data set\.

 *CLI Synopsis*:

```
aws iotanalytics  update-dataset
 --dataset-name <value>
 --actions <value>
[--triggers <value>]
[--content-delivery-rules <value>]
[--retention-period <value>]
[--versioning-configuration <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datasetName": "string",
  "actions": [
    {
      "actionName": "string",
      "queryAction": {
        "sqlQuery": "string",
        "filters": [
          {
            "deltaTime": {
              "offsetSeconds": "integer",
              "timeExpression": "string"
            }
          }
        ]
      },
      "containerAction": {
        "image": "string",
        "executionRoleArn": "string",
        "resourceConfiguration": {
          "computeType": "string",
          "volumeSizeInGB": "integer"
        },
        "variables": [
          {
            "name": "string",
            "stringValue": "string",
            "doubleValue": "double",
            "datasetContentVersionValue": {
              "datasetName": "string"
            },
            "outputFileUriValue": {
              "fileName": "string"
            }
          }
        ]
      }
    }
  ],
  "triggers": [
    {
      "schedule": {
        "expression": "string"
      },
      "dataset": {
        "name": "string"
      }
    }
  ],
  "contentDeliveryRules": [
    {
      "entryName": "string",
      "destination": {
        "iotEventsDestinationConfiguration": {
          "inputName": "string",
          "roleArn": "string"
        },
        "s3DestinationConfiguration": {
          "bucket": "string",
          "key": "string",
          "glueConfiguration": {
            "tableName": "string",
            "databaseName": "string"
          },
          "roleArn": "string"
        }
      }
    }
  ],
  "retentionPeriod": {
    "unlimited": "boolean",
    "numberOfDays": "integer"
  },
  "versioningConfiguration": {
    "unlimited": "boolean",
    "maxVersions": "integer"
  }
}
```

 *fields*:
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set to update\.
+ actions

   *type*: list member: DatasetAction

  A list of "DatasetAction" objects\.
+ actionName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set action by which data set contents are automatically created\.
+ queryAction

   *type*: SqlQueryDatasetAction

  An "SqlQueryDatasetAction" object that uses an SQL query to automatically create data set contents\.
+ sqlQuery

   *type*: string

  A SQL query string\.
+ filters

   *type*: list member: QueryFilter

  Pre\-filters applied to message data\.
+ deltaTime

   *type*: DeltaTime

  Used to limit data to that which has arrived since the last execution of the action\.
+ offsetSeconds

   *type*: integer java class: java\.lang\.Integer

  The number of seconds of estimated "in flight" lag time of message data\. When you create data set contents using message data from a specified time frame, some message data may still be "in flight" when processing begins, and so will not arrive in time to be processed\. Use this field to make allowances for the "in flight" time of your message data, so that data not processed from a previous time frame will be included with the next time frame\. Without this, missed message data would be excluded from processing during the next time frame as well, because its timestamp places it within the previous time frame\.
+ timeExpression

   *type*: string

  An expression by which the time of the message data may be determined\. This may be the name of a timestamp field, or a SQL expression which is used to derive the time the message data was generated\.
+ containerAction

   *type*: ContainerDatasetAction

  Information which allows the system to run a containerized application in order to create the data set contents\. The application must be in a Docker container along with any needed support libraries\.
+ image

   *type*: string; \(length\- max:255\)

  The ARN of the Docker container stored in your account\. The Docker container contains an application and needed support libraries and is used to generate data set contents\.
+ executionRoleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which gives permission to the system to access needed resources in order to run the "containerAction"\. This includes, at minimum, permission to retrieve the data set contents which are the input to the containerized application\.
+ resourceConfiguration

   *type*: ResourceConfiguration

  Configuration of the resource which executes the "containerAction"\.
+ computeType

   *type*: string

  The type of the compute resource used to execute the "containerAction"\. Possible values are: ACU\_1 \(vCPU=4, memory=16GiB\) or ACU\_2 \(vCPU=8, memory=32GiB\)\. enum: ACU\_1 \| ACU\_2
+ volumeSizeInGB

   *type*: integer range\- max:50 min:1

  The size \(in GB\) of the persistent storage available to the resource instance used to execute the "containerAction" \(min: 1, max: 50\)\.
+ variables

   *type*: list member: Variable

  The values of variables used within the context of the execution of the containerized application \(basically, parameters passed to the application\)\. Each variable must have a name and a value given by one of "stringValue", "datasetContentVersionValue", or "outputFileUriValue"\.
+ name

   *type*: string; \(length\- max:256 min:1\)

  The name of the variable\.
+ stringValue

   *type*: string; \(length\- max:1024 min:0\)

  The value of the variable as a string\.
+ datasetContentVersionValue

   *type*: DatasetContentVersionValue

  The value of the variable as a structure that specifies a data set content version\.
+ datasetName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose latest contents are used as input to the notebook or application\.
+ outputFileUriValue

   *type*: OutputFileUriValue

  The value of the variable as a structure that specifies an output file URI\.
+ fileName

   *type*: string; \(pattern: \[w\.\-\]\{1,255\}\)

  The URI of the location where data set contents are stored, usually the URI of a file in an S3 bucket\.
+ triggers

   *type*: list member: DatasetTrigger

  A list of "DatasetTrigger" objects\. The list can be empty or can contain up to five DataSetTrigger objects\.
+ schedule

   *type*: Schedule

  The "Schedule" when the trigger is initiated\.
+ expression

   *type*: string

  The expression that defines when to trigger an update\. For more information, see Schedule Expressions for Rules in the Amazon CloudWatch Events User Guide\.
+ dataset

   *type*: TriggeringDataset

  The data set whose content creation triggers the creation of this data set's contents\.
+ name

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data set whose content generation triggers the new data set content generation\.
+ contentDeliveryRules

   *type*: list member: DatasetContentDeliveryRule

  When data set contents are created they are delivered to destinations specified here\.
+ entryName

   *type*: string

  The name of the data set content delivery rules entry\.
+ destination

   *type*: DatasetContentDeliveryDestination

  The destination to which data set contents are delivered\.
+ iotEventsDestinationConfiguration

   *type*: IotEventsDestinationConfiguration

  Configuration information for delivery of data set contents to AWS IoT Events\.
+ inputName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z\]\[a\-zA\-Z0\-9\_\]\*$\)

  The name of the AWS IoT Events input to which data set contents are delivered\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to deliver data set contents to an AWS IoT Events input\.
+ s3DestinationConfiguration

   *type*: S3DestinationConfiguration

  Configuration information for delivery of data set contents to Amazon S3\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket to which data set contents are delivered\.
+ key

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*$\)

  The key of the data set contents object\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. To produce a unique key, you can use "\!\{iotanalytics:scheduledTime\}" to insert the time of the scheduled SQL query run, or "\!\{iotanalytics:versioned\} to insert a unique hash identifying the data set, for example: "/DataSet/\!\{iotanalytics:scheduledTime\}/\!\{iotanalytics:versioned\}\.csv"\.
+ glueConfiguration

   *type*: GlueConfiguration

  Configuration information for coordination with the AWS Glue ETL \(extract, transform and load\) service\.
+ tableName

   *type*: string; \(length\- max:150 min:1\); \(pattern: \[u0020\-uD7FFuE000\-uFFFDuD800uDC00\-uDBFFuDFFFt\]\*\)

  The name of the table in your AWS Glue Data Catalog which is used to perform the ETL \(extract, transform and load\) operations\. \(An AWS Glue Data Catalog table contains partitioned data and descriptions of data sources and targets\.\)
+ databaseName

   *type*: string; \(length\- max:150 min:1\); \(pattern: \[u0020\-uD7FFuE000\-uFFFDuD800uDC00\-uDBFFuDFFFt\]\*\)

  The name of the database in your AWS Glue Data Catalog in which the table is located\. \(An AWS Glue Data Catalog database contains Glue Data tables\.\)
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 and AWS Glue resources\.
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, data set contents are kept for the data set\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.
+ versioningConfiguration

   *type*: VersioningConfiguration

  \[Optional\] How many versions of data set contents are kept\. If not specified or set to null, only the latest version plus the latest succeeded version \(if they are different\) are kept for the time period specified by the "retentionPeriod" parameter\. \(For more information, see [https://docs\.aws\.amazon\.com/iotanalytics/latest/userguide/getting\-started\.html\#aws\-iot\-analytics\-dataset\-versions](https://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html#aws-iot-analytics-dataset-versions)\)
+ unlimited

   *type*: boolean

  If true, unlimited versions of data set contents will be kept\.
+ maxVersions

   *type*: integer java class: java\.lang\.Integer range\- max:1000 min:1

  How many versions of data set contents will be kept\. The "unlimited" parameter must be false\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## UpdateDatastore<a name="cli-iotanalytics-updatedatastore"></a>

Updates the settings of a data store\.

 *CLI Synopsis*:

```
aws iotanalytics  update-datastore
 --datastore-name <value>
[--retention-period <value>]
[--datastore-storage <value>]
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "datastoreName": "string",
  "retentionPeriod": {
    "unlimited": "boolean",
    "numberOfDays": "integer"
  },
  "datastoreStorage": {
    "serviceManagedS3": {
    },
    "customerManagedS3": {
      "bucket": "string",
      "keyPrefix": "string",
      "roleArn": "string"
    }
  }
}
```

 *fields*:
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store to be updated\.
+ retentionPeriod

   *type*: RetentionPeriod

  How long, in days, message data is kept for the data store\. The retention period cannot be updated if the data store's S3 storage is customer\-managed\.
+ unlimited

   *type*: boolean

  If true, message data is kept indefinitely\.
+ numberOfDays

   *type*: integer java class: java\.lang\.Integer range\- min:1

  The number of days that message data is kept\. The "unlimited" parameter must be false\.
+ datastoreStorage

   *type*: DatastoreStorage

  Where data store data is stored\. You may choose one of "serviceManagedS3" or "customerManagedS3" storage\. If not specified, the default is "serviceManagedS3"\. This cannot be changed after the data store is created\.
+ serviceManagedS3

   *type*: ServiceManagedDatastoreS3Storage

  Use this to store data store data in an S3 bucket managed by the AWS IoT Analytics service\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the data store\.
+ customerManagedS3

   *type*: CustomerManagedDatastoreS3Storage

  Use this to store data store data in an S3 bucket that you manage\. When customer managed storage is selected, the "retentionPeriod" parameter is ignored\. The choice of service\-managed or customer\-managed S3 storage cannot be changed after creation of the data store\.
+ bucket

   *type*: string; \(length\- max:255 min:3\); \(pattern: ^\[a\-zA\-Z0\-9\.\-\_\]\*$\)

  The name of the Amazon S3 bucket in which data store data is stored\.
+ keyPrefix

   *type*: string; \(length\- max:255 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\!\_\.\*'\(\)/\{\}:\-\]\*/$\)

  \[Optional\] The prefix used to create the keys of the data store data objects\. Each object in an Amazon S3 bucket has a key that is its unique identifier within the bucket \(each object in a bucket has exactly one key\)\. The prefix must end with a '/'\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role which grants AWS IoT Analytics permission to interact with your Amazon S3 resources\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429

## UpdatePipeline<a name="cli-iotanalytics-updatepipeline"></a>

Updates the settings of a pipeline\. You must specify both a channel and a datastore activity and, optionally, as many as 23 additional activities in the pipelineActivities array\.

 *CLI Synopsis*:

```
aws iotanalytics  update-pipeline
 --pipeline-name <value>
 --pipeline-activities <value>
[--cli-input-json <value>]
[--generate-cli-skeleton]
```

 *cli\-input\-json* format:

```
{
  "pipelineName": "string",
  "pipelineActivities": [
    {
      "channel": {
        "name": "string",
        "channelName": "string",
        "next": "string"
      },
      "lambda": {
        "name": "string",
        "lambdaName": "string",
        "batchSize": "integer",
        "next": "string"
      },
      "datastore": {
        "name": "string",
        "datastoreName": "string"
      },
      "addAttributes": {
        "name": "string",
        "attributes": {
          "string": "string"
        },
        "next": "string"
      },
      "removeAttributes": {
        "name": "string",
        "attributes": [
          "string"
        ],
        "next": "string"
      },
      "selectAttributes": {
        "name": "string",
        "attributes": [
          "string"
        ],
        "next": "string"
      },
      "filter": {
        "name": "string",
        "filter": "string",
        "next": "string"
      },
      "math": {
        "name": "string",
        "attribute": "string",
        "math": "string",
        "next": "string"
      },
      "deviceRegistryEnrich": {
        "name": "string",
        "attribute": "string",
        "thingName": "string",
        "roleArn": "string",
        "next": "string"
      },
      "deviceShadowEnrich": {
        "name": "string",
        "attribute": "string",
        "thingName": "string",
        "roleArn": "string",
        "next": "string"
      }
    }
  ]
}
```

 *fields*:
+ pipelineName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the pipeline to update\.
+ pipelineActivities

   *type*: list member: PipelineActivity

  A list of "PipelineActivity" objects\. Activities perform transformations on your messages, such as removing, renaming or adding message attributes; filtering messages based on attribute values; invoking your Lambda functions on messages for advanced processing; or performing mathematical transformations to normalize device data\. The list can be 2\-25 PipelineActivity objects and must contain both a channel and a datastore activity\. Each entry in the list must contain only one activity, for example: pipelineActivities = \[ \{ "channel": \{ \.\.\. \} \}, \{ "lambda": \{ \.\.\. \} \}, \.\.\. \]
+ channel

   *type*: ChannelActivity

  Determines the source of the messages to be processed\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'channel' activity\.
+ channelName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the channel from which the messages are processed\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ lambda

   *type*: LambdaActivity

  Runs a Lambda function to modify the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'lambda' activity\.
+ lambdaName

   *type*: string; \(length\- max:64 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\-\]\+$\)

  The name of the Lambda function that is run on the message\.
+ batchSize

   *type*: integer java class: java\.lang\.Integer range\- max:1000 min:1

  The number of messages passed to the Lambda function for processing\. The AWS Lambda function must be able to process all of these messages within five minutes, which is the maximum timeout duration for Lambda functions\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ datastore

   *type*: DatastoreActivity

  Specifies where to store the processed message data\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'datastore' activity\.
+ datastoreName

   *type*: string; \(length\- max:128 min:1\); \(pattern: ^\[a\-zA\-Z0\-9\_\]\+$\)

  The name of the data store where processed messages are stored\.
+ addAttributes

   *type*: AddAttributesActivity

  Adds other attributes based on existing attributes in the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'addAttributes' activity\.
+ attributes

   *type*: map key: AttributeName value: AttributeName

  A list of 1\-50 "AttributeNameMapping" objects that map an existing attribute to a new attribute\. The existing attributes remain in the message, so if you want to remove the originals, use "RemoveAttributeActivity"\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ removeAttributes

   *type*: RemoveAttributesActivity

  Removes attributes from a message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'removeAttributes' activity\.
+ attributes

   *type*: list member: AttributeName

  A list of 1\-50 attributes to remove from the message\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ selectAttributes

   *type*: SelectAttributesActivity

  Creates a new message using only the specified attributes from the original message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'selectAttributes' activity\.
+ attributes

   *type*: list member: AttributeName

  A list of the attributes to select from the message\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ filter

   *type*: FilterActivity

  Filters a message based on its attributes\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'filter' activity\.
+ filter

   *type*: string; \(length\- max:256 min:1\)

  An expression that looks like a SQL WHERE clause that must return a Boolean value\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ math

   *type*: MathActivity

  Computes an arithmetic expression using the message's attributes and adds it to the message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'math' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that contains the result of the math operation\.
+ math

   *type*: string; \(length\- max:256 min:1\)

  An expression that uses one or more existing attributes and must return an integer value\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ deviceRegistryEnrich

   *type*: DeviceRegistryEnrichActivity

  Adds data from the AWS IoT device registry to your message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'deviceRegistryEnrich' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that is added to the message\.
+ thingName

   *type*: string; \(length\- max:256 min:1\)

  The name of the IoT device whose registry information is added to the message\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that allows access to the device's registry information\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.
+ deviceShadowEnrich

   *type*: DeviceShadowEnrichActivity

  Adds information from the AWS IoT Device Shadows service to a message\.
+ name

   *type*: string; \(length\- max:128 min:1\)

  The name of the 'deviceShadowEnrich' activity\.
+ attribute

   *type*: string; \(length\- max:256 min:1\)

  The name of the attribute that is added to the message\.
+ thingName

   *type*: string; \(length\- max:256 min:1\)

  The name of the IoT device whose shadow information is added to the message\.
+ roleArn

   *type*: string; \(length\- max:2048 min:20\)

  The ARN of the role that allows access to the device's shadow\.
+ next

   *type*: string; \(length\- max:128 min:1\)

  The next activity in the pipeline\.

Output:

None

Errors:
+ InvalidRequestException

  The request was not valid\.

  HTTP response code: 400
+ ResourceNotFoundException

  A resource with the specified name could not be found\.

  HTTP response code: 404
+ InternalFailureException

  There was an internal failure\.

  HTTP response code: 500
+ ServiceUnavailableException

  The service is temporarily unavailable\.

  HTTP response code: 503
+ ThrottlingException

  The request was denied due to request throttling\.

  HTTP response code: 429
+ LimitExceededException

  The command caused an internal limit to be exceeded\.

  HTTP response code: 410