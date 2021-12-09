//snippet-sourcedescription:[CheckOptOut.java demonstrates how to determine whether the user of the phone number has chosen to no longer receive future text messages.]
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

//snippet-start:[sns.java2.CheckOptOut.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.CheckIfPhoneNumberIsOptedOutRequest;
import software.amazon.awssdk.services.sns.model.CheckIfPhoneNumberIsOptedOutResponse;
import software.amazon.awssdk.services.sns.model.SnsException;
//snippet-end:[sns.java2.CheckOptOut.import]

public class CheckOptOut {
    public static void main(String[] args) {
        final String USAGE = "\n" +
                "CheckOptOut - look if phone number owner has opted out of receiving messages\n" +
                "Usage: CheckOptOut <phoneNumber>\n\n" +
                "Where:\n" +
                "  phoneNumber - phone number to look up. Example: +1XXX5550100\n\n";

        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }
        
        String phoneNumber = args[0];

        SnsClient snsClient = SnsClient.builder()
                    .region(Region.US_EAST_1)
                    .build();

        checkPhone(snsClient, phoneNumber);
        }

        //snippet-start:[sns.java2.CheckOptOut.main]
        public static void checkPhone(SnsClient snsClient, String phoneNumber) {

            try {
            CheckIfPhoneNumberIsOptedOutRequest request = CheckIfPhoneNumberIsOptedOutRequest.builder()
                .phoneNumber(phoneNumber)
                .build();

            CheckIfPhoneNumberIsOptedOutResponse result = snsClient.checkIfPhoneNumberIsOptedOut(request);

            System.out.println(result.isOptedOut() + "Phone Number " + phoneNumber + " has Opted Out of receiving sns messages." +
                "\n\nStatus was " + result.sdkHttpResponse().statusCode());

        } catch (SnsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        //snippet-end:[sns.java2.CheckOptOut.main]
    }
}
