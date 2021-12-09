--------

--------

# Submitting feedback<a name="submitting-feedback"></a>

You can provide feedback about query results returned from an Amazon Kendra index\. Amazon Kendra uses this information to improve the underlying search model and provide better search results over time\. To submit feedback, you use the [SubmitFeedback](API_SubmitFeedback.md) operation\. To identify the query, you supply the `IndexID` of the index that the query applies to, and the `QueryId` returned in the response from the [Query](API_Query.md) operation\. Two types of feedback are accepted\.
+ **Clicks**  \- Information about which query results were chosen by the end user\. The feedback includes the result ID \(ResultId\) and the Unix timestamp of the date and time that the search result was chosen\. Your application needs to collect click information from the activities of your end users\.
+ **Relevance**  \- Information about the relevance of a search result\. This is typically information provided by the end user\. The feedback contains the result ID and a relevance indicator \(`RELEVANT` or `NOT_RELEVANT`\)\. Relevance information is determined by your end user\. To submit relevance feedback, your application must provide a feedback mechanism that allows the end user to choose the appropriate relevance for a query result\.

The following example shows how to submit click and relevance feedback\. You can submit multiple sets of feedback through the `ClickFeedbackItems` and `RelevanceFeedbackItems` arrays\. This example submits a single click and a single relevance feedback item\. The current timestamp is used for the timing of the feedback submittal\.

**To submit feedback for a search \(AWS SDK\)**

1. Use the following code and change the following values:

   1. `index id`  \- Change to the ID of the index that the query applies to\.

   1. `query id` \- Change to the query that you want to provide feedback on\.

   1. `result id` \- Change to the ID of the query result that you want to provide feedback on\. The result ID is returned in the query response\.

   1. `relevance value` \- Change to either `RELEVANT` \(the query result is relevant\) or `NOT_RELEVANT` \(the query result is not relevant\)\.

------
#### [ Python ]

   ```
   import boto3
   import time
   
   kendra = boto3.client('kendra')
   
   index_id = '${indexID}'
   query_id = '${queryID}'
   result_id = '${resultID}'
   feedback_item = {'ClickTime': int(time.time()),
       'ResultId':result_id}
   
   
   relevance_value = 'RELEVANT'
   relevance_item = {'RelevanceValue': relevance_value,
       'ResultId':result_id
       }
   
   response=kendra.submit_feedback(
       QueryId = query_id,
       IndexId = index_id,
       ClickFeedbackItems = [feedback_item],
       RelevanceFeedbackItems = [relevance_item]
   )
   
   
   print ('Submitted feedback for query: ' + query_id)
   ```

------
#### [ Java ]

   ```
   package com.amazonaws.kendra;
   
   import java.time.Instant;
   import software.amazon.awssdk.services.kendra.KendraClient;
   import software.amazon.awssdk.services.kendra.model.ClickFeedback;
   import software.amazon.awssdk.services.kendra.model.RelevanceFeedback;
   import software.amazon.awssdk.services.kendra.model.RelevanceType;
   import software.amazon.awssdk.services.kendra.model.SubmitFeedbackRequest;
   import software.amazon.awssdk.services.kendra.model.SubmitFeedbackResponse;
   
   public class SubmitFeedbackExample {
       public static void main(String[] args) {
           KendraClient kendra = KendraClient.builder().build();
   
           SubmitFeedbackRequest submitFeedbackRequest = SubmitFeedbackRequest
               .builder()
               .indexId("anIndexId")
               .queryId("aQueryId")
               .clickFeedbackItems(
                   ClickFeedback
                   .builder()
                   .clickTime(Instant.now())
                   .resultId("aResultId")
                   .build())
               .relevanceFeedbackItems(
                   RelevanceFeedback
                   .builder()
                   .relevanceValue(RelevanceType.RELEVANT)
                   .resultId("aResultId")
                   .build())
               .build();
   
           SubmitFeedbackResponse response = kendra.submitFeedback(submitFeedbackRequest);
   
           System.out.println("Feedback is submitted");
       }
   }
   ```

------

   ```
   import boto3
   import time
   
   kendra = boto3.client('kendra')
   
   index_id = '${indexID}'
   query_id = '${queryID}'
   result_id = '${resultID}'
   feedback_item = {'ClickTime': int(time.time()),
       'ResultId':result_id}
   
   
   relevance_value = 'RELEVANT'
   relevance_item = {'RelevanceValue': relevance_value,
       'ResultId':result_id
       }
   
   response=kendra.submit_feedback(
       QueryId = query_id,
       IndexId = index_id,
       ClickFeedbackItems = [feedback_item],
       RelevanceFeedbackItems = [relevance_item]
   )
   
   
   print ('Submitted feedback for query: ' + query_id)
   ```

1. Run the code\. After the feedback has been submitted, a message is displayed\.