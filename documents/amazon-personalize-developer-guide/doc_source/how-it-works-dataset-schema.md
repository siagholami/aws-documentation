# Datasets and Schemas<a name="how-it-works-dataset-schema"></a>

Amazon Personalize recognizes three types of historical datasets\. Each type has an associated schema with a *name* key whose value matches the dataset type\. The three types are:
+ **Users** – This dataset is intended to provide metadata about your users\. This might include information such as age, gender, or loyalty membership, which can be important signals in personalization systems\.
+ **Items** – This dataset is intended to provide metadata about your items\. This might include information such as price, SKU type, or availability\.
+ **Interactions** – This dataset is intended to provide historical interaction data between users and items\. It can also provide metadata on your user's browsing context, such as their location or device \(mobile, tablet, desktop, and so on\)\.

The Users and Items dataset types are known as metadata types and are used only by certain recipes\. For more information, see [Choosing a Recipe](working-with-predefined-recipes.md)\.

If you are using the AWS console, you create a new schema when you create a dataset for your input data\. You can also choose an existing schema\. For more information, see [Step 1: Import Training Data](getting-started-console.md#getting-started-console-import-dataset)\.

If you are using the AWS CLI, see [Step 1: Import Training Data](getting-started-cli.md#gs-create-ds) for an example\.

**Note**  
A dataset group can contain only one of each type of dataset\.

## Dataset Requirements<a name="dataset-requirements"></a>

Each dataset has a set of required fields, reserved keywords, and their required datatypes, as shown in the following table\.


| Dataset Type | Required Fields | Reserved Keywords | 
| --- | --- | --- | 
| Users |  USER\_ID \(`string`\) 1 metadata field  |  | 
| Items |  ITEM\_ID \(`string`\) 1 metadata field  |  CREATION\_TIMESTAMP \(`long`\)  | 
| Interactions |  USER\_ID \(`string`\) ITEM\_ID \(`string`\) TIMESTAMP \(`long`\)  |  EVENT\_TYPE \(`string`\) IMPRESSION \(`string`\) EVENT\_VALUE \(`float`, `null`\)  | 

Before you add a dataset to Amazon Personalize, you must define a schema for that dataset\. Once you define the schema and create the dataset, you can't make changes to the schema\. Schemas in Amazon Personalize are defined in the Avro format\. For more information, see [Apache Avro](https://avro.apache.org/docs/current/)\. 

When you create a schema, you must follow these guidelines:
+ The schema fields can appear in any order, but they must match the order of the corresponding column headers in the data file\.
+ Each dataset type requires specific non\-metadata fields in its schema \(see the preceding table\)\. You must define required fields as their required datatypes\.
+ `EVENT_VALUE` data and Interactions, User, and Item metadata can be a `null` type\. Adding a `null` type to a field in your schema allows you to use imperfect data \(for example, metadata with blank values\), to generate personalized recommendations\.

### Metadata Fields<a name="metadata-fields"></a>

 Metadata includes string or non\-string fields that aren't required or don't use a reserved keyword\. Metadata schemas have the following restrictions: 
+ Users and Items schemas require at least one metadata field,
+ Users and Interactions datasets can contain up to five metadata fields\. An Items dataset can contain up to 50 metadata fields\. 
+ If you add your own metadata field of type `string`, it must include the `categorical` attribute\. Otherwise, Amazon Personalize won't use the field when training a model\. 

### Reserved Keywords<a name="reserved-keywords"></a>

Reserved keywords are optional, non\-metadata fields\. You must define reserved keywords as their required datatype\. The following are reserved keywords:
+ EVENT\_TYPE: Use an `EVENT_TYPE` field for Interactions datasets with one or more event types, such as Click and Download\. You must define an EVENT\_TYPE field as a `string`\.
+ EVENT\_VALUE: Use an `EVENT_VALUE` field for Interactions datasets that include value data for events, such as `perecent_watched`\. You must define an `EVENT_VALUE` field only as a `float` or `null`\.
+  CREATION\_TIMESTAMP: Use a `CREATION_TIMESTAMP` field for Items datasets with a timestamp for each item’s creation date\. Amazon Personalize uses `CREATION_TIMESTAMP` data to calculate the age of an item and adjust recommendations accordingly\. See [Creation Timestamp Data](data-prep-formatting.md#creation-timestamp-data)\. 
+  IMPRESSION: Use an `IMPRESSION` field for Interactions datasets with impressions data\. Impressions are lists of items that were visible to a user when they interacted with \(for example, clicked or watched\) a particular item\. For more information see [Impressions Data](data-prep-formatting.md#data-prep-impressions-data)\. 

## Schema Examples<a name="schema-examples"></a>

The following example schemas are organized by dataset type\.

### Interactions Schema Example<a name="schema-examples-interactions"></a>

The following example shows an Interactions schema\. The `EVENT_TYPE`, `EVENT_VALUE`, and `IMPRESSION` fields are optional reserved keywords recognized by Amazon Personalize\. `LOCATION` and `DEVICE` are optional contextual metadata fields\.

```
{

  "type": "record",
  "name": "Interactions",
  "namespace": "com.amazonaws.personalize.schema",
  "fields": [
      {
          "name": "USER_ID",
          "type": "string"
      },
      {
          "name": "ITEM_ID",
          "type": "string"
      },
      {
          "name": "EVENT_TYPE",
          "type": "string"
      },
      {
          "name": "EVENT_VALUE",
          "type": [
             "float",
             "null"
          ]
      },
      {
          "name": "LOCATION",
          "type": "string",
          "categorical": true
      },
      {
          "name": "DEVICE",
          "type": [
              "string",
              "null"
          ],
          "categorical": true
      },
      {
          "name": "TIMESTAMP",
          "type": "long"
      },
      {
          "name": "IMPRESSION",
          "type": "string"
      }
  ],
  "version": "1.0"
}
```

### Users Schema Example<a name="schema-examples-users"></a>

The following example shows a Users schema in Avro format\. Only the `USER_ID` field is required\. The `AGE` and `GENDER` fields are metadata\.

```
{
  "type": "record",
  "name": "Users",
  "namespace": "com.amazonaws.personalize.schema",
  "fields": [
      {
          "name": "USER_ID",
          "type": "string"
      },
      {
          "name": "AGE",
          "type": "int"
      },
      {
          "name": "GENDER",
          "type": "string",
          "categorical": true
      }
  ],
  "version": "1.0"
}
```

### Items Schema Example<a name="schema-examples-items"></a>

The following example shows an Items schema\. Only the `ITEM_ID` field is required\. The `GENRE` field is metadata\. The `CREATION_TIMESTAMP` is a reserved keyword\.

```
{
  "type": "record",
  "name": "Items",
  "namespace": "com.amazonaws.personalize.schema",
  "fields": [
    {
      "name": "ITEM_ID",
      "type": "string"
    },
    {
      "name": "GENRES",
      "type": [
        "null",
        "string"
      ],
      "categorical": true
    },
    {
      "name": "CREATION_TIMESTAMP",
      "type": "long"
    }
  ],
  "version": "1.0"
}
```

## Create a Schema Using the AWS Python SDK<a name="python-schema-ex"></a>

1. Define the Avro format schema that you want to use\.

1. Save the schema in a JSON file in the default Python folder\.

1. Create the schema using the following code\.

   ```
   import boto3
   
   personalize = boto3.client('personalize')
   
   with open('schema.json') as f:
       createSchemaResponse = personalize.create_schema(
           name = 'YourSchema',
           schema = f.read()
       )
   
   schema_arn = createSchemaResponse['schemaArn']
   
   print('Schema ARN:' + schema_arn )
   ```

1. Amazon Personalize returns the ARN of the new schema\. Store it for later use\.

Amazon Personalize provides operations for managing schemas\. For example, you can use the [ListSchemas](API_ListSchemas.md) API to get a list of the available schemas\.

After you create a schema, use it with datasets that match the schema\. For more information, see [Formatting Your Input Data](data-prep-formatting.md)\.