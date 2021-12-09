--------

--------

# Querying an index<a name="searching-example"></a>

When you search your index, Amazon Kendra uses all of the information that you provided about your documents to determine the documents most relevant to the search terms entered\. Some of the items that Amazon Kendra considers are:
+ The text of the document\.
+ The title of the document\.
+ Custom text fields that you have marked searchable\.
+ The date field that you have indicated should be used to determine the "freshness" of a document\.

When a set of relevant documents has been selected from the index, Amazon Kendra filters the response based on any attribute filters that you have requested for the search\. For example, if you have a custom attribute called "department," you can filter the response so that it only contains documents from a department called "legal\." For information about creating custom attributes, see [Creating custom document attributes](custom-attributes.md)\. 

After finding the relevant documents and then filtering based on the attributes that you set, Amazon Kendra returns the results\. The results are sorted by the relevance that Amazon Kendra determined for each doc\. The results are paginated so that you can show a page at a time to your user\.

The following Python example shows how to search an index by using the [Query](API_Query.md) operation\. The example determines the type of the search result \(answer, document, question/answer\) and displays the answer text\. 

For information about the query responses, see [Query responses](query-response.md)\.

**Note**  
You can use this code to filter document attributes\. The topic [Filtering queries](filtering.md) contains examples that you can use to replace the following code\.  

```
response=kendra.query(
        QueryText = query,
        IndexId = index)
```

## Prerequisites<a name="searching-prerequisites"></a>

To run this example, you need to:
+ Set up permissions\. For more information, see [IAM access roles for Amazon Kendra](iam-roles.md)\.
+ Set up the AWS CLI\. For more information, see [Setting up the AWS CLI](aws-kendra-set-up-aws-cli.md)\.
+ Create a data source and index\. For more information, see [Getting started with an S3 bucket \(Console\)](gs-console.md)\.

## Searching an index \(console\)<a name="searching-index-console"></a>

You can use the Amazon Kendra search console to test your index\. You can make queries and see the results\.

**To search an index with the console**

1. Sign in to the AWS Management Console and open the Amazon Kendra console at [http://console\.aws\.amazon\.com/kendra/](https://console.aws.amazon.com/kendra)\.

1. On the navigation pane, choose **Indexes**\.

1. Choose your index\.

1. On the navigation page, choose **Search console**\.

1. Enter a query in the text box and then press enter or choose the magnifying glass icon\. 

1. Amazon Kendra returns the results of the search\.

## Searching an index \(SDK\)<a name="searching-index-sdk"></a>

**To search an index with Python or Java**
+ The following example searches an index\. Change the value of `query` to your search query and `index_id` or `indexId` to the index identifier of the index that you want to search\.

------
#### [ Python ]

  ```
  import boto3
  import pprint
  
  kendra = boto3.client('kendra')
  
  query='${searchString}'
  index_id='${indexID}'
  
  response=kendra.query(
          QueryText = query,
          IndexId = index_id)
  
  print ('\nSearch results for query: ' + query + '\n')        
  
  for query_result in response['ResultItems']:
  
      print('-------------------')
      print('Type: ' + str(query_result['Type']))
          
      if query_result['Type']=='ANSWER':
          answer_text = query_result['DocumentExcerpt']['Text']
          print(answer_text)
  
      if query_result['Type']=='DOCUMENT':
          if 'DocumentTitle' in query_result:
              document_title = query_result['DocumentTitle']['Text']
              print('Title: ' + document_title)
          document_text = query_result['DocumentExcerpt']['Text']
          print(document_text)
  
      print ('------------------\n\n')
  ```

------
#### [ Java ]

  ```
  package com.amazonaws.kendra;
  
  import software.amazon.awssdk.services.kendra.KendraClient;
  import software.amazon.awssdk.services.kendra.model.QueryRequest;
  import software.amazon.awssdk.services.kendra.model.QueryResponse;
  import software.amazon.awssdk.services.kendra.model.QueryResultItem;
  
  public class SearchIndexExample {
      public static void main(String[] args) {
          KendraClient kendra = KendraClient.builder().build();
  
          String query = "some queries";
          String indexId = "anIndexId";
  
          QueryRequest queryRequest = QueryRequest
              .builder()
              .queryText(query)
              .indexId(indexId)
              .build();
  
          QueryResponse queryResponse = kendra.query(queryRequest);
  
          System.out.println(String.format("\nSearch results for query: %s", query));
          for(QueryResultItem item: queryResponse.resultItems()) {
              System.out.println("----------------------");
              System.out.println(String.format("Type: %s", item.type()));
  
              switch(item.type()) {
                  case QUESTION_ANSWER:
                  case ANSWER:
                      String answerText = item.documentExcerpt().text();
                      System.out.println(answerText);
                      break;
                  case DOCUMENT:
                      String documentTitle = item.documentTitle().text();
                      System.out.println(String.format("Title: %s", documentTitle));
                      String documentExcerpt = item.documentExcerpt().text();
                      System.out.println(String.format("Excerpt: %s", documentExcerpt));
                      break;
                  default:
                      System.out.println(String.format("Unknown query result type: %s", item.type()));
  
              }
  
              System.out.println("-----------------------\n");
          }
      }
  }
  ```

------