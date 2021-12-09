//snippet-sourcedescription:[GetTopicAttributes.java demonstrates how to retrieve the defaults for an Amazon SNS topic.]
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

//snippet-start:[sns.java2.GetTopicAttributes.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.GetTopicAttributesRequest;
import software.amazon.awssdk.services.sns.model.GetTopicAttributesResponse;
import software.amazon.awssdk.services.sns.model.SnsException;
//snippet-end:[sns.java2.GetTopicAttributes.import]

public class GetTopicAttributes {
    public static void main(String[] args) {
        final String USAGE = "\n" +
                "GetTopicAttributes - get attributes for an Amazon SNS topic\n" +
                "Usage: GetTopicAttributes <topicArn>\n\n" +
                "Where:\n" +
                "  topicArn - the ARN of the topic to look up.\n\n";

        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String topicArn = args[0];
        System.out.println("Getting attributes for a topic with name: " + topicArn);

        // Create a SnsClient object
        SnsClient snsClient = SnsClient.builder()
                .region(Region.US_WEST_2)
                .build();

        getSNSTopicAttributes(snsClient, topicArn) ;
    }

    //snippet-start:[sns.java2.GetTopicAttributes.main]
    public static void getSNSTopicAttributes(SnsClient snsClient, String topicArn ) {

        try {
            GetTopicAttributesRequest request = GetTopicAttributesRequest.builder()
                .topicArn(topicArn)
                .build();

            GetTopicAttributesResponse result = snsClient.getTopicAttributes(request);
            System.out.println("\n\nStatus was " + result.sdkHttpResponse().statusCode() + "\n\nAttributes: \n\n" + result.attributes());

        } catch (SnsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        //snippet-end:[sns.java2.GetTopicAttributes.main]
    }
}
