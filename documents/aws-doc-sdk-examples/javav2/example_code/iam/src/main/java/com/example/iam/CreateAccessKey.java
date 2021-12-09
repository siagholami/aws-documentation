//snippet-sourcedescription:[CreateAccessKey.java demonstrates how to create an access key for an IAM user.]
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

// snippet-start:[iam.java2.create_access_key.import]
import software.amazon.awssdk.services.iam.model.CreateAccessKeyRequest;
import software.amazon.awssdk.services.iam.model.CreateAccessKeyResponse;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
// snippet-end:[iam.java2.create_access_key.import]

/**
 * Creates an access key for an IAM user
 */
public class CreateAccessKey {

    public static void main(String[] args) {

        final String USAGE =
                "To run this example, supply an IAM user that you can obtain from the AWS Console\n" +
                        "Ex: CreateAccessKey <user>\n";

        if (args.length != 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String user = args[0];

        Region region = Region.AWS_GLOBAL;
        IamClient iam = IamClient
                .builder()
                .region(region)
                .build();

        String keyId = createIAMAccessKey(iam, user);
        System.out.println("The Key Id is " +keyId);
    }

    // snippet-start:[iam.java2.create_access_key.main]
    public static String createIAMAccessKey(IamClient iam,String user) {

        try {
            CreateAccessKeyRequest request = CreateAccessKeyRequest.builder()
                .userName(user).build();

            CreateAccessKeyResponse response = iam.createAccessKey(request);
           String keyId = response.accessKey().accessKeyId();
           return keyId;

        } catch (IamException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return "";
    }
    // snippet-end:[iam.java2.create_access_key.main]
}
