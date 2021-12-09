//snippet-sourcedescription:[GetId.java demonstrates how to retrieve the client ID from an identity provider.]
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

//snippet-start:[cognito.java2.GetId.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentity.CognitoIdentityClient;
import software.amazon.awssdk.services.cognitoidentity.model.GetIdRequest;
import software.amazon.awssdk.services.cognitoidentity.model.GetIdResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;
//snippet-end:[cognito.java2.GetId.import]

public class GetId {

    public static void main(String[] args) {
        final String USAGE = "\n" +
                "Usage:\n" +
                "    GetId <identity_pool_id>\n\n" +
                "Where:\n" +
                "    identityPoolId  - The AWS Region and GUID of your identity pool.\n\n" +
                "Example:\n" +
                "    GetId us-east-1:00eb915b-c521-417b-af0d-ebad008axxxx\n";

        if (args.length != 1) {
             System.out.println(USAGE);
            System.exit(1);
        }

        /* Read the name from command args */
       String identityPoolId = args[0];

       CognitoIdentityClient cognitoclient = CognitoIdentityClient.builder()
                .region(Region.US_EAST_1)
                .build();

        getClientID(cognitoclient, identityPoolId);
    }

    //snippet-start:[cognito.java2.GetID.main]
    public static void getClientID(CognitoIdentityClient cognitoclient, String identityPoolId){
        try {

            GetIdRequest request = GetIdRequest.builder()
                   .identityPoolId(identityPoolId)
                   .build();

            GetIdResponse response = cognitoclient.getId(request);
            System.out.println("Identity ID " + response.identityId());

        } catch (CognitoIdentityProviderException e){
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        //snippet-end:[cognito.java2.GetID.main]
    }
}
