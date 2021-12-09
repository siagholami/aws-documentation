//snippet-sourcedescription:[DeleteAccessKey.java demonstrates how to delete an access key from an IAM user.]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[AWS IAM]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[03/02/2020]
//snippet-sourceauthor:[scmacdon-aws]
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
package com.example.iam;

// snippet-start:[iam.java2.delete_access_key.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.DeleteAccessKeyRequest;
import software.amazon.awssdk.services.iam.model.IamException;
// snippet-end:[iam.java2.delete_access_key.import]

/**
 * Deletes an access key from an IAM user
 */
public class DeleteAccessKey {
    public static void main(String[] args) {

        final String USAGE =
                "To run this example, supply a username and access key id\n" +
                        "Ex: DeleteAccessKey <username> <access-key-id>\n";

        if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(1);
        }
        String username = args[0];
        String accessKey = args[1];

        Region region = Region.AWS_GLOBAL;
        IamClient iam = IamClient.builder()
                .region(region)
                .build();

        deleteKey(iam , username, accessKey);
    }

    // snippet-start:[iam.java2.delete_access_key.main]
    public static void deleteKey(IamClient iam ,String username, String accessKey ) {

        try {
            DeleteAccessKeyRequest request = DeleteAccessKeyRequest.builder()
                .accessKeyId(accessKey)
                .userName(username).build();

            iam.deleteAccessKey(request);
            System.out.println("Successfully deleted access key " + accessKey +
                " from user " + username);

        } catch (IamException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
    // snippet-end:[iam.java2.delete_access_key.main]
}
