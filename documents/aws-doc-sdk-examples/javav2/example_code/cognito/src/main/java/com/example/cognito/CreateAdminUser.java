//snippet-sourcedescription:[CreateAdminUser.java demonstrates how to add a new admin to your user pool.]
//snippet-keyword:[Java]
//snippet-sourcesyntax:[java]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon Cognito]
//snippet-service:[cognito]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[8/14/2020]
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

package com.example.cognito;

//snippet-start:[cognito.java2.new_admin_user.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminCreateUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminCreateUserResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;
//snippet-end:[cognito.java2.new_admin_user.import]

public class CreateAdminUser {

    public static void main(String[] args) {
        final String USAGE = "\n" +
                "Usage:\n" +
                "    CreateAdminUser <user_pool_id> <username> <email>\n\n" +
                "Where:\n" +
                "    user_pool_id - The ID for the user pool where the user will be created.\n\n" +
                "    username - The user name for the user.\n\n" +
                "    email  - The email to use for verifying the admin account.\n\n" +
                "Example:\n" +
                "    CreateTable HelloTable\n";

         if (args.length < 3) {
              System.out.println(USAGE);
              System.exit(1);
        }

        /* Read the name from command args */
        String userPoolId = args[0];
        String name = args[1];
        String email = args[2];

        CognitoIdentityProviderClient cognitoclient = CognitoIdentityProviderClient.builder()
                .region(Region.US_EAST_1)
                .build();

        createAdmin(cognitoclient, userPoolId, name, email);
    }

    //snippet-start:[cognito.java2.add_login_provider.main]
    public static void createAdmin(CognitoIdentityProviderClient cognitoclient,
                                   String userPoolId,
                                   String name,
                                   String email){

        try{
            AdminCreateUserResponse response = cognitoclient.adminCreateUser(
                AdminCreateUserRequest.builder()
                        .userPoolId(userPoolId)
                        .username(name)
                        .userAttributes(AttributeType.builder()
                                .name("email")
                                .value(email)
                                .build())
                        .messageAction("SUPPRESS")
                        .build()
        );

            System.out.println("User " + response.user().username() + "is created. Status: " + response.user().userStatus());

        } catch (CognitoIdentityProviderException e){
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        //snippet-end:[cognito.java2.add_login_provider.main]
    }
}
