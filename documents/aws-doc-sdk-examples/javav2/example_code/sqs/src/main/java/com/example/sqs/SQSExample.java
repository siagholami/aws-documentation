//snippet-sourcedescription:[SQSExample.java demonstrates how to create, list, and delete queues.]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[Amazon Simple Queue Service]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2/24/2020]
//snippet-sourceauthor:[scmacdon-aws]

/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sqs;

// snippet-start:[sqs.java2.sqs_example.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.ChangeMessageVisibilityRequest;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.ListQueuesRequest;
import software.amazon.awssdk.services.sqs.model.ListQueuesResponse;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequestEntry;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
// snippet-end:[sqs.java2.sqs_example.import]

import java.util.List;

// snippet-start:[sqs.java2.sqs_example.main]
public class SQSExample {

    public static void main(String[] args) {
        String queueName = "queue" + System.currentTimeMillis();

        SqsClient sqsClient = SqsClient.builder()
                .region(Region.US_WEST_2)
                .build();

        // Create a queue
        String queueUrl= createQueue(sqsClient, queueName );
        listQueues(sqsClient);
        listQueuesFilter(sqsClient, queueUrl);
        List<Message> messages = receiveMessages(sqsClient, queueUrl);
        changeMessages(sqsClient, queueUrl, messages);
        deleteMessages(sqsClient, queueUrl,  messages) ;
    }

    public static String createQueue(SqsClient sqsClient,String queueName ) {

        System.out.println("\nCreate queue");
        // snippet-start:[sqs.java2.sqs_example.create_queue]

        CreateQueueRequest createQueueRequest = CreateQueueRequest.builder()
                .queueName(queueName)
                .build();

        sqsClient.createQueue(createQueueRequest);
        // snippet-end:[sqs.java2.sqs_example.create_queue]

        System.out.println("\nGet queue URL");
        // snippet-start:[sqs.java2.sqs_example.get_queue]
        GetQueueUrlResponse getQueueUrlResponse =
                sqsClient.getQueueUrl(GetQueueUrlRequest.builder().queueName(queueName).build());
        String queueUrl = getQueueUrlResponse.queueUrl();
        return queueUrl;
        // snippet-end:[sqs.java2.sqs_example.get_queue]
    }

    public static void listQueues(SqsClient sqsClient) {

        System.out.println("\nList Queues");
        // snippet-start:[sqs.java2.sqs_example.list_queues]
        String prefix = "que";
        ListQueuesRequest listQueuesRequest = ListQueuesRequest.builder().queueNamePrefix(prefix).build();
        ListQueuesResponse listQueuesResponse = sqsClient.listQueues(listQueuesRequest);
        for (String url : listQueuesResponse.queueUrls()) {
            System.out.println(url);
        }
        // snippet-end:[sqs.java2.sqs_example.list_queues]
    }

    public static void listQueuesFilter(SqsClient sqsClient, String queueUrl ) {
        // List queues with filters
        String namePrefix = "queue";
        ListQueuesRequest filterListRequest = ListQueuesRequest.builder()
                .queueNamePrefix(namePrefix).build();

        ListQueuesResponse listQueuesFilteredResponse = sqsClient.listQueues(filterListRequest);
        System.out.println("Queue URLs with prefix: " + namePrefix);
        for (String url : listQueuesFilteredResponse.queueUrls()) {
            System.out.println(url);
        }

        System.out.println("\nSend message");
        // snippet-start:[sqs.java2.sqs_example.send_message]
        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody("Hello world!")
                .delaySeconds(10)
                .build());
        // snippet-end:[sqs.java2.sqs_example.send_message]
    }

    public static void sendBatchMessages(SqsClient sqsClient, String queueUrl) {

        System.out.println("\nSend multiple messages");
        // snippet-start:[sqs.java2.sqs_example.send__multiple_messages]
        SendMessageBatchRequest sendMessageBatchRequest = SendMessageBatchRequest.builder()
                .queueUrl(queueUrl)
                .entries(SendMessageBatchRequestEntry.builder().id("id1").messageBody("Hello from msg 1").build(),
                        SendMessageBatchRequestEntry.builder().id("id2").messageBody("msg 2").delaySeconds(10).build())
                .build();
        sqsClient.sendMessageBatch(sendMessageBatchRequest);
        // snippet-end:[sqs.java2.sqs_example.send__multiple_messages]
    }

    public static  List<Message> receiveMessages(SqsClient sqsClient, String queueUrl) {


        System.out.println("\nReceive messages");
        // snippet-start:[sqs.java2.sqs_example.retrieve_messages]
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(5)
                .build();
        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();

        return messages;
        // snippet-end:[sqs.java2.sqs_example.retrieve_messages]
    }

    public static void changeMessages(SqsClient sqsClient, String queueUrl, List<Message> messages) {

        System.out.println("\nChange message visibility");
        for (Message message : messages) {
            ChangeMessageVisibilityRequest req = ChangeMessageVisibilityRequest.builder()
                    .queueUrl(queueUrl)
                    .receiptHandle(message.receiptHandle())
                    .visibilityTimeout(100)
                    .build();
            sqsClient.changeMessageVisibility(req);
        }

    }

    public static void deleteMessages(SqsClient sqsClient, String queueUrl,  List<Message> messages) {
        System.out.println("\nDelete messages");
        // snippet-start:[sqs.java2.sqs_example.delete_message]
        for (Message message : messages) {
            DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .receiptHandle(message.receiptHandle())
                    .build();
            sqsClient.deleteMessage(deleteMessageRequest);
        }
        // snippet-end:[sqs.java2.sqs_example.delete_message]
   }
}
// snippet-end:[sqs.java2.sqs_example.main]
