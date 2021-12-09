//snippet-sourcedescription:[PublishTopic.java demonstrates how to send a message to an Amazon SNS topic.]
//snippet-keyword:[Java]
//snippet-sourcesyntax:[java]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon Simple Notification Service]
//snippet-service:[sns]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[4/6/2020]
//snippet-sourceauthor:[scmacdon AWS]
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.example.sns;

//snippet-start:[sns.java2.PublishTopic.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;
//snippet-end:[sns.java2.PublishTopic.import]

public class PublishTopic {

    public static void main(String[] args) {
        final String USAGE = "\n" +
                "PublishTopic - publish an Amazon SNS topic\n" +
                "Usage: PublishTopic <message> <topicArn>\n\n" +
                "Where:\n" +
                "  message - message text to send.\n\n" +
                "  topicArn - the ARN of the topic to look up.\n\n";

        if (args.length < 2) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String message = args[0];
        String topicArn = args[1];

        SnsClient snsClient = SnsClient.builder()
                .region(Region.US_WEST_2)
                .build();

        pubTopic(snsClient, message, topicArn);
    }

    //snippet-start:[sns.java2.PublishTopic.main]
    public static void pubTopic(SnsClient snsClient, String message, String topicArn) {

        try {
            PublishRequest request = PublishRequest.builder()
                .message(message)
                .topicArn(topicArn)
                .build();

            PublishResponse result = snsClient.publish(request);
            System.out.println(result.messageId() + " Message sent. Status was " + result.sdkHttpResponse().statusCode());

         } catch (SnsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
              System.exit(1);
         }
        //snippet-end:[sns.java2.PublishTopic.main]
    }
}
