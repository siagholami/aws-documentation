//snippet-sourcedescription:[ConfirmSubscription.java demonstrates how to retrieve the defaults for an Amazon SNS topic.]
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

//snippet-start:[sns.java2.ConfirmSubscription.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.ConfirmSubscriptionRequest;
import software.amazon.awssdk.services.sns.model.ConfirmSubscriptionResponse;
import software.amazon.awssdk.services.sns.model.SnsException;
//snippet-end:[sns.java2.ConfirmSubscription.import]

public class ConfirmSubscription {
    public static void main(String[] args) {
        final String USAGE = "\n" +
                "ConfirmSubscription - confirm a subscription to an Amazon SNS topic\n" +
                "Usage: ConfirmSubscription <subscriptionToken> <topicArn>\n\n" +
                "Where:\n" +
                "  subscriptionToken - endpoint token from Subscribe action.\n\n" +
                "  topicArn - the ARN of the topic to delete.\n\n";

        if (args.length < 2) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String subscriptionToken = args[0];
        String topicArn = args[1];

        SnsClient snsClient = SnsClient.builder()
                .region(Region.US_WEST_2)
                .build();

        confirmSub(snsClient, subscriptionToken, topicArn ) ;
    }

    //snippet-start:[sns.java2.ConfirmSubscription.main]
    public static void confirmSub(SnsClient snsClient, String subscriptionToken, String topicArn ) {

        try {
             ConfirmSubscriptionRequest request = ConfirmSubscriptionRequest.builder()
                .token(subscriptionToken)
                .topicArn(topicArn)
                .build();

            ConfirmSubscriptionResponse result = snsClient.confirmSubscription(request);

            System.out.println("\n\nStatus was " + result.sdkHttpResponse().statusCode() + "\n\nSubscription Arn: \n\n" + result.subscriptionArn());
    } catch (SnsException e) {

        System.err.println(e.awsErrorDetails().errorMessage());
        System.exit(1);
    }
        //snippet-end:[sns.java2.ConfirmSubscription.main]
    }
}
