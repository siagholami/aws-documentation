//snippet-sourcedescription:[ListQueryExecutionsExample.java demonstrates how to obtain a list of query execution IDs.]
//snippet-keyword:[Java]
//snippet-sourcesyntax:[java]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon Athena]
//snippet-service:[Amazon Athena]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[4/30/2020]
//snippet-sourceauthor:[scmacdon - AWS]
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

//snippet-start:[athena.java2.ListNamedQueryExecutionsExample.complete]
//snippet-start:[athena.java.ListNamedQueryExecutionsExample.complete]
package aws.example.athena;

//snippet-start:[athena.java2.ListNamedQueryExecutionsExample.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.athena.AthenaClient;
import software.amazon.awssdk.services.athena.model.AthenaException;
import software.amazon.awssdk.services.athena.model.ListQueryExecutionsRequest;
import software.amazon.awssdk.services.athena.model.ListQueryExecutionsResponse;
import software.amazon.awssdk.services.athena.paginators.ListQueryExecutionsIterable;
import java.util.List;
//snippet-end:[athena.java2.ListNamedQueryExecutionsExample.import]

/**
 * ListQueryExecutionsExample
 * -------------------------------------
 * This code shows how to obtain a list of query execution IDs.
 */
public class ListQueryExecutionsExample {

    public static void main(String[] args) throws Exception {

        // Build an Athena client
        AthenaClient athenaClient = AthenaClient.builder()
                .region(Region.US_WEST_2)
                .build();

        listQueryIds(athenaClient);
    }

    //snippet-start:[athena.java2.ListNamedQueryExecutionsExample.main]
    public static void listQueryIds(AthenaClient athenaClient) {

       try {
           // Build the request
            ListQueryExecutionsRequest listQueryExecutionsRequest = ListQueryExecutionsRequest.builder().build();

            // Get the list results.
            ListQueryExecutionsIterable listQueryExecutionResponses = athenaClient.listQueryExecutionsPaginator(listQueryExecutionsRequest);

            for (ListQueryExecutionsResponse listQueryExecutionResponse : listQueryExecutionResponses) {
                List<String> queryExecutionIds = listQueryExecutionResponse.queryExecutionIds();
                System.out.println("\n" +queryExecutionIds);
        }
    } catch (AthenaException e) {
        e.printStackTrace();
        System.exit(1);
    }
    //snippet-end:[athena.java2.ListNamedQueryExecutionsExample.main]
  }
}
//snippet-end:[athena.java.ListNamedQueryExecutionsExample.complete]
//snippet-end:[athena.java2.ListNamedQueryExecutionsExample.complete]
