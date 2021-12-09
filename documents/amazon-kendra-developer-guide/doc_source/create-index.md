--------

--------

# Creating an index<a name="create-index"></a>

You can create an index using the console, the AWS Command Line Interface \(AWS CLI\) , or by calling the [CreateIndex](API_CreateIndex.md) API operation\. The following procedures show how to create an index\. Once you have created your index, you can add documents directly to your index or you can add them from a data source\.

To create an index, you need to provide the Amazon Resource Name \(ARN\) of an AWS Identity and Access Management \(IAM\) role that has permissions to any Amazon Simple Storage Service \(Amazon S3\) bucket that you use and to perform actions on your behalf\.

**To create an index \(console\)**

1. Sign into the AWS Management Console and open the Amazon Kendra console at [https://console\.aws\.amazon\.com/kendra/](https://console.aws.amazon.com/kendra/)\. 

1. Choose **Create index**\.

1. In **Specify index details**, give your index a name and a description\.

1. In **IAM role** provide an IAM role\. You can either choose from roles in your account that contain the word "kendra" or you can type the name of another role\. For more information about the permissions that the role requires, see [IAM roles for indexes](iam-roles.md#iam-roles-index)\.

1. Choose **Create**\.

1. Creating an index can take some time\. Check the list of indexes to watch the progress of creating your index\. When the status of the index is `ACTIVE`, your index is ready to use\.

**To create an index \(AWS CLI\)**

1. Use the following command to create an index\. The `role-arn` should be the Amazon Resource Name \(ARN\) of a role that can execute Amazon Kendra actions\. For more information, see [IAM access roles for Amazon Kendra](iam-roles.md)\.

   ```
   aws kendra create-index \
    --index-name index name \
    --description "index description" \
    --role-arn arn:aws:iam::account ID:role/role name
   ```

1. Creating an index can take some time\. To check the state of your index, Use the index ID returned by `create-index` with the following command\. When the status of the index is `ACTIVE`, your index is ready to use\.

   ```
   aws kendra describe-index \
    --index-id index ID
   ```

**To create an index \(SDK\)**

1. You need to provide values for the following variables:
   + `description` – A description of the index that you are creating\.
   + `index_name` – The name of the index that you are creating\.
   + `role_arn` – The Amazon Resource Name \(ARN\) of a role that can execute Amazon Kendra operations\. For more information, see [IAM access roles for Amazon Kendra](iam-roles.md)\.

1. The following examples create an index with Amazon Kendra\.

------
#### [ Python ]

   ```
   import boto3
   from botocore.exceptions import ClientError
   import pprint
   import time
   
   kendra = boto3.client("kendra")
   
   print("Create an index")
   
   description = "index description"
   index_name = "index-name"
   role_arn = "arn:aws:iam::${account id}:role/${role name}"
   
   try:
       index_response = kendra.create_index(
           Description = description,
           Name = index_name,
           RoleArn = role_arn
       )
   
       pprint.pprint(index_response)
   
       index_id = index_response["Id"]
   
       print("Wait for Kendra to create the index.")
   
       while True:
           # Get index description
           index_description = kendra.describe_index(
               Id = index_id
           )
           # If status is not CREATING quit
           status = index_description["Status"]
           print("    Creating index. Status: "+status)
           if status != "CREATING":
               break
           time.sleep(60)
   
   except  ClientError as e:
           print("%s" % e)
   
   print("Program ends.")
   ```

------
#### [ Java ]

   ```
   package com.amazonaws.kendra;
   
   import java.util.concurrent.TimeUnit;
   import software.amazon.awssdk.services.kendra.KendraClient;
   import software.amazon.awssdk.services.kendra.model.CreateIndexRequest;
   import software.amazon.awssdk.services.kendra.model.CreateIndexResponse;
   import software.amazon.awssdk.services.kendra.model.DescribeIndexRequest;
   import software.amazon.awssdk.services.kendra.model.DescribeIndexResponse;
   import software.amazon.awssdk.services.kendra.model.IndexStatus;
   
   
   public class CreateIndexExample {
   
       public static void main(String[] args) throws InterruptedException {
   
           String indexDescription = "Getting started index for Kendra";
           String indexName = "java-getting-started-index";
           String indexRoleArn = "arn:aws:iam::<your AWS account ID>:role/KendraRoleForGettingStartedIndex";
   
           System.out.println(String.format("Creating an index named %s", indexName));
           CreateIndexRequest createIndexRequest = CreateIndexRequest
               .builder()
               .description(indexDescription)
               .name(indexName)
               .roleArn(indexRoleArn)
               .build();
           KendraClient kendra = KendraClient.builder().build();
           CreateIndexResponse createIndexResponse = kendra.createIndex(createIndexRequest);
           System.out.println(String.format("Index response %s", createIndexResponse));
   
           String indexId = createIndexResponse.id();
   
           System.out.println(String.format("Waiting until the index with ID %s is created.", indexId));
           while (true) {
               DescribeIndexRequest describeIndexRequest = DescribeIndexRequest.builder().id(indexId).build();
               DescribeIndexResponse describeIndexResponse = kendra.describeIndex(describeIndexRequest);
               IndexStatus status = describeIndexResponse.status();
               if (status != IndexStatus.CREATING) {
                   break;
               }
   
               TimeUnit.SECONDS.sleep(60);
           }
   
           System.out.println("Index creation is complete.");
       }
   }
   ```

------

Once you have created your index, you add documents to it\. You can either add them directly or you can create a data source that automatically updates your index on a regular schedule\.

**Topics**
+ [Adding documents directly to an index](in-adding-documents.md)
+ [Adding documents from a data source](data-source.md)
+ [Deleting data sources](delete-data-source.md)
+ [Creating custom document attributes](custom-attributes.md)
+ [Mapping data source fields](field-mapping.md)
+ [Configuring Amazon Kendra to use a VPC](vpc-configuration.md)