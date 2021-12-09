//snippet-sourcedescription:[VisibilityTimeout.java demonstrates how to change the visibility timeout for messages in a queue.]
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

// snippet-start:[sqs.java2.visibility_timeout.import]
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import software.amazon.awssdk.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import software.amazon.awssdk.services.sqs.model.ChangeMessageVisibilityRequest;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.CreateQueueResponse;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.QueueNameExistsException;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
// snippet-end:[sqs.java2.visibility_timeout.import]

// snippet-start:[sqs.java2.visibility_timeout.main]
public class VisibilityTimeout {

    public static void main(String[] args) {
        final String queueName = "testQueue" + new Date().getTime();
        SqsClient sqs = SqsClient.builder().build();

        // First, create a queue (unless it already exists)
        CreateQueueRequest createRequest = CreateQueueRequest.builder()
                .queueName(queueName)
                .build();
        try {
            CreateQueueResponse cqResult = sqs.createQueue(createRequest);
        } catch (QueueNameExistsException e) {
            throw e;
        }

        GetQueueUrlRequest getRequest = GetQueueUrlRequest.builder()
                .queueName(queueName)
                .build();
        final String queue_url = sqs.getQueueUrl(getRequest).queueUrl();

        // Send some messages to the queue
        for (int i = 0; i < 20; i++) {
            SendMessageRequest sendRequest = SendMessageRequest.builder()
                    .queueUrl(queueName)
                    .messageBody("This is message " + i)
                    .build();
            sqs.sendMessage(sendRequest);
        }

        // Change visibility timeout (single)
        changeMessageVisibilitySingle(queueName, 3600);

        // Change visibility timeout (multiple)
        changeMessageVisibilityMultiple(queueName, 2000);
    }

    // Change visibility timeout for a single message
    public static void changeMessageVisibilitySingle(
            String queueName, int timeout) {
        SqsClient sqs = SqsClient.builder().build();

        // Get the receipt handle for the first message in the queue
        ReceiveMessageRequest receiveRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueName)
                .build();
        String receipt = sqs.receiveMessage(receiveRequest)
                .messages()
                .get(0)
                .receiptHandle();

        ChangeMessageVisibilityRequest visibilityRequest = ChangeMessageVisibilityRequest.builder()
                .queueUrl(queueName)
                .receiptHandle(receipt)
                .visibilityTimeout(timeout)
                .build();
        sqs.changeMessageVisibility(visibilityRequest);
    }

    // Change the visibility timeout for multiple messages
    public static void changeMessageVisibilityMultiple(String queue_url, int timeout) {
        SqsClient sqs = SqsClient.builder().build();

        List<ChangeMessageVisibilityBatchRequestEntry> entries =
                new ArrayList<ChangeMessageVisibilityBatchRequestEntry>();

        ReceiveMessageRequest receiveRequest = ReceiveMessageRequest.builder()
                .queueUrl(queue_url)
                .build();

        String receipt = sqs.receiveMessage(receiveRequest)
                .messages()
                .get(0)
                .receiptHandle();

        entries.add(ChangeMessageVisibilityBatchRequestEntry.builder()
                .id("unique_id_msg1")
                .receiptHandle(receipt)
                .visibilityTimeout(timeout)
                .build());

        entries.add(ChangeMessageVisibilityBatchRequestEntry.builder()
                .id("unique_id_msg2")
                .receiptHandle(receipt)
                .visibilityTimeout(timeout + 200)
                .build());

        ChangeMessageVisibilityBatchRequest batchRequest = ChangeMessageVisibilityBatchRequest.builder()
                .queueUrl(queue_url)
                .entries(entries)
                .build();
        sqs.changeMessageVisibilityBatch(batchRequest);
    }

}
// snippet-end:[sqs.java2.visibility_timeout.main]
