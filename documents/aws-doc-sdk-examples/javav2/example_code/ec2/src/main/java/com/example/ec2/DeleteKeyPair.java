//snippet-sourcedescription:[DeleteKeyPair.java demonstrates how to delete an Amazon EC2 key pair.]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[Amazon EC2]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2/11/2020]
//snippet-sourceauthor:[scmacdon]

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

package com.example.ec2;

// snippet-start:[ec2.java2.delete_key_pair.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DeleteKeyPairRequest;
import software.amazon.awssdk.services.ec2.model.DeleteKeyPairResponse;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;
// snippet-end:[ec2.java2.delete_key_pair.import]

/**
 * Deletes a key pair.
 */
public class DeleteKeyPair {

    public static void main(String[] args) {
        final String USAGE =
                "To run this example, supply a key pair name\n" +
                        "Ex: DeleteKeyPair <key-pair-name>\n";

        if (args.length != 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String keyName = args[0];

        //Create an Ec2Client object
        Region region = Region.US_WEST_2;
        Ec2Client ec2 = Ec2Client.builder()
                .region(region)
                .build();

        deleteKeys(ec2,keyName);
    }

    // snippet-start:[ec2.java2.delete_key_pair.main]
    public static void deleteKeys(Ec2Client ec2, String keyName) {

       try {

           DeleteKeyPairRequest request = DeleteKeyPairRequest.builder()
                .keyName(keyName)
                .build();

           DeleteKeyPairResponse response = ec2.deleteKeyPair(request);

            // snippet-end:[ec2.java2.delete_key_pair.main]
            System.out.printf(
                "Successfully deleted key pair named %s", keyName);

        } catch (Ec2Exception e) {
           System.err.println(e.awsErrorDetails().errorMessage());
           System.exit(1);
        }
    }
}
