# Using Amazon Translate with Amazon DynamoDB<a name="examples-ddb"></a>

This example shows you how to translate a product review and store it in Amazon DynamoDB\. If you request the same review later, DynamoDB returns it without Amazon Translate needing to translate it again\. 

In this example, you:
+ Use AWS CloudFormation to create DynamoDB tables to store the translation and a Lambda function that calls the [TranslateText](API_TranslateText.md) operation\.
+ Test the function using the AWS Lambda console\.

**To run the example**

1.  Copy the contents of `example.py`, which you can find in [Python Lambda Function](#examples-ddb-code-lambda), to a file named `example.py`\. `example.py` is a Lambda function that calls the [TranslateText](API_TranslateText.md) operation\. Compress the file to a zip archive named `example.zip`\. Store it in an S3 bucket in the same AWS Region where you want to run the function\. 

1. Create a new file named `template.yaml`\. Copy the AWS CloudFormation template code, which you can find in [AWS CloudFormation Template](#examples-ddb-code-yaml), into the file\. AWS CloudFormation uses the template to create resources for the sample application\. Change `BUCKET_NAME` to the name of the S3 bucket that contains `example.zip`\. Save the file in a local directory\. 

1. Sign in to the AWS Management Console and open the AWS CloudFormation console at [https://console\.aws\.amazon\.com/cloudformation](https://console.aws.amazon.com/cloudformation/)\.

1. Choose **Create new stack**\.

1. Choose **Upload a template to Amazon S3**, and then choose **Choose file**\. Choose `template.yaml`, that you created in Step 2, then **Next**\.

1. Type a name for the stack, then choose **Next**\. 

1. On the **Options** page, choose **Next**\.

1. Choose **I acknowledge that AWS CloudFormation might create IAM resources** and **I acknowledge that AWS CloudFormation might create IAM resources with custom names**\. For more information, see [Controlling Access with AWS Identity and Access Management](http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/using-iam-template.html) in the *AWS CloudFormation User Guide*\.

1. Choose **Create Change Set**\.

1. After AWS CloudFormation creates the change set, choose **Execute**\. Wait until AWS CloudFormation creates the stack\.

1. Sign in to the AWS Management Console and open the AWS Lambda console at [https://console\.aws\.amazon\.com/lambda/](https://console.aws.amazon.com/lambda/)\.

1. Choose the new function\. Its name starts with `TestTranslate-ReviewTranslate`\.

1. On the function detail page, choose **Test**\.

1. For **Event name**, type **TestTranslate**\. For **Configure test event**, replace the JSON with the following:

   ```
   {
      "review": "hello world",
      "target_language": "es",
      "source_language": "en",
      "review_id": "1"
   }
   ```

   Choose **Create**\.

1. Make sure that **TestTranslate** is selected, then choose **Test**\. When the test finishes, you receive the following message:  
![\[A panel showing the results of the operation, "Hello world" in Spanish.\]](http://docs.aws.amazon.com/translate/latest/dg/images/example-3-results.png)

## Example Code<a name="examples-ddb-code"></a>

Use the following code to create the example\.

### Python Lambda Function<a name="examples-ddb-code-lambda"></a>

The following is the contents of the Python Lambda function\. The Lambda function call the `TranslateText` operation and passes the review, the source language, and the target language to get the translated review\. Save this file as `example.py` and them compress it in a \.zip archive called `example.zip`\. Save the file in an S3 bucket in the same region that you are running the example\.\.

```
import logging
import json
import boto3
import os

translate = boto3.client('translate')
dynamodb = boto3.client('dynamodb')
firehose = boto3.client('firehose')

TABLE_NAME = os.getenv('TABLE_NAME')

logger = logging.getLogger()
logger.setLevel(logging.INFO)

def lambda_handler(event, context):

    logger.info(event)

    if 'source_language' in event and 'target_language' in event and 'review' in event and 'review_id' in event:
        review_id = event['review_id']
        source_language = event['source_language']
        target_language = event['target_language']
        review = event['review']

        try:
            # The Lambda function queries the Amazon DynamoDB table to check whether 
            # the review has already been translated. If the translated review 
            # is already stored in Amazon DynamoDB, the function returns it.
            response = dynamodb.get_item(
                TableName=TABLE_NAME,
                Key={
                    'review_id': {
                        'N': review_id,
                    },
                    'language': {
                        'S': target_language,
                    },
                }
            )
            logger.info(response)
            if 'Item' in response:
                return response['Item']['review']['S']
        except Exception as e:
            logger.error(response)
            raise Exception("[ErrorMessage]: " + str(e))

        try:
            # The Lambda function calls the TranslateText operation and passes the 
            # review, the source language, and the target language to get the 
            # translated review. 
            result = translate.translate_text(Text=review, SourceLanguageCode=source_language, TargetLanguageCode=target_language)
            logging.info("Translation output: " + str(result))
        except Exception as e:
            logger.error(response)
            raise Exception("[ErrorMessage]: " + str(e))

        try:
            # After the review is translated, the function stores it using
            # the Amazon DynamoDB putItem operation. Subsequent requests
            # for this translated review are returned from Amazon DynamoDB.
            response = dynamodb.put_item(
            TableName=TABLE_NAME,
            Item={
                'review_id': {
                    'N': review_id,
                },
                'language': {
                    'S': target_language,
                },
                'review': {
                    'S': result.get('TranslatedText')
                }
                }
            )
            logger.info(response)
        except Exception as e:
                logger.error(e)
                raise Exception("[ErrorMessage]: " + str(e))
        return result.get('TranslatedText')
    else:
        logger.error(e)
        raise Exception("[ErrorMessage]: Invalid input ")
```

### AWS CloudFormation Template<a name="examples-ddb-code-yaml"></a>

The following is the template file that you use with AWS CloudFormation to create and configure the Lambda function and the DynamoDB tables\. Use this file when you create the AWS CloudFormation stack for the example\. Update `BUCKET_NAME` to the name of the S3 bucket that contains the `example.zip` file and then save it to a local directory as `template.yaml`\. 

```
AWSTemplateFormatVersion: '2010-09-09'
Transform: 'AWS::Serverless-2016-10-31'
Resources:  ReviewTranslate:
    Type: 'AWS::Serverless::Function'
    Properties:
        Handler: example.lambda_handler
        Runtime: python2.7
        CodeUri:
          Bucket: BUCKET_NAME
          Key: example.zip
        Policies:
         - AWSLambdaFullAccess
         - TranslateReadOnly
        Environment:
          Variables:
            TABLE_NAME: !Ref ReviewTable  
        Tracing: "Active"
  ReviewTable:
    Type: 'AWS::DynamoDB::Table'
    Properties:
        AttributeDefinitions: 
            - AttributeName: "review_id"
              AttributeType: "N"
            - AttributeName: "language"
              AttributeType: "S"
        KeySchema:
            - AttributeName: "review_id"
              KeyType: "HASH"
            - AttributeName: "language"
              KeyType: "RANGE"
        ProvisionedThroughput: 
            ReadCapacityUnits: 5
            WriteCapacityUnits: 5
```