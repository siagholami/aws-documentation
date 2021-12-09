/**
 * Copyright 2010-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * This file is licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License. A copy of
 * the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 */

// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[DynamoDBAsyncGetItem.java demonstrates how to get an item by using the DynamoDbAsyncClient object]
// snippet-service:[dynamodb]
// snippet-keyword:[Java]
// snippet-keyword:[Amazon DynamoDB]
// snippet-keyword:[Code Sample]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2019-11-19]
// snippet-sourceauthor:[AWS]

// snippet-start:[dynamodb.Java.DynamoDBAsyncGetItem.complete]
package com.example.dynamodbasync;
// snippet-start:[dynamoasyn.java2.get_item.import]
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

// snippet-end:[dynamoasyn.java2.get_item.import]
public class DynamoDBAsyncGetItem {

    public static void main(String[] args) {

        final String USAGE = "\n" +
                "Usage:\n" +
                "    GetItem <table> <name> [projection_expression]\n\n" +
                "Where:\n" +
                "    table - the table to get an item from.\n" +
                "    name  - the item to get.\n\n" +
                "You can add an optional projection expression (a quote-delimited,\n" +
                "comma-separated list of attributes to retrieve) to limit the\n" +
                "fields returned from the table.\n\n" +
                "Example:\n" +
                "    GetItem HelloTable World\n" +
                "    GetItem SiteColors text \"default, bold\"\n";

        if (args.length < 2) {
            System.out.println(USAGE);
            System.exit(1);
        }

        // snippet-start:[dynamoasyc.java2.get_item.main]
        //Get both input arguments
        String tableName = args[0];
        String name = args[1];
        System.out.format("Retrieving item \"%s\" from \"%s\"\n", name, tableName );

        HashMap<String, AttributeValue> keyToGet =
                new HashMap<String, AttributeValue>();

        keyToGet.put("Name", AttributeValue.builder().s(name).build());

        try {

            DynamoDbAsyncClient client = DynamoDbAsyncClient.create();

            //Create a GetItemRequest instance
            GetItemRequest request = GetItemRequest.builder()
                    .key(keyToGet)
                    .tableName(tableName)
                    .build();

            //Invoke the DynamoDbAsyncClient object's getItem
            java.util.Collection<software.amazon.awssdk.services.dynamodb.model.AttributeValue> returnedItem = client.getItem(request).join().item().values();

            //Convert Set to Map
            Map<String, AttributeValue> map = returnedItem.stream().collect(Collectors.toMap(AttributeValue::s, s->s));
            Set<String> keys = map.keySet();
            for (String key : keys) {
                System.out.format("%s: %s\n", key, map.get(key).toString());
            }

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        // snippet-end:[dynamoasyc.java2.get_item.main]
    }
}

// snippet-end:[dynamodb.Java.DynamoDBAsyncGetItem.complete]
