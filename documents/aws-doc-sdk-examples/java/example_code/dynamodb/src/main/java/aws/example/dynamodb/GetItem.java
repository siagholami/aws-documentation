//snippet-sourcedescription:[GetItem.java demonstrates how to get an item from a DynamoDB table.]
//snippet-keyword:[Java]
//snippet-sourcesyntax:[java]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon DynamoDB]
//snippet-service:[dynamodb]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2018-01-15]
//snippet-sourceauthor:[soo-aws]
/*
   Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This file is licensed under the Apache License, Version 2.0 (the "License").
   You may not use this file except in compliance with the License. A copy of
   the License is located at

    http://aws.amazon.com/apache2.0/

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied. See the License for the
   specific language governing permissions and limitations under the License.
*/
package aws.example.dynamodb;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Get an item from a DynamoDB table.
 *
 * Takes the name of the table and the name of the item to retrieve from it.
 *
 * The primary key searched is "DATABASE_NAME", and the value contained by the field
 * "Greeting" will be returned.
 *
 * This code expects that you have AWS credentials set up per:
 * http://docs.aws.amazon.com/java-sdk/latest/developer-guide/setup-credentials.html
 */
public class GetItem
{
    public static void main(String[] args)
    {
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

        String table_name = args[0];
        String name = args[1];
        String projection_expression = null;

        // if a projection expression was included, set it.
        if (args.length == 3) {
            projection_expression = args[2];
        }

        System.out.format("Retrieving item \"%s\" from \"%s\"\n",
                name, table_name);

        HashMap<String,AttributeValue> key_to_get =
            new HashMap<String,AttributeValue>();

        key_to_get.put("DATABASE_NAME", new AttributeValue(name));

        GetItemRequest request = null;
        if (projection_expression != null) {
            request = new GetItemRequest()
                .withKey(key_to_get)
                .withTableName(table_name)
                .withProjectionExpression(projection_expression);
        } else {
            request = new GetItemRequest()
                .withKey(key_to_get)
                .withTableName(table_name);
        }

        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();

        try {
            Map<String,AttributeValue> returned_item =
               ddb.getItem(request).getItem();
            if (returned_item != null) {
                Set<String> keys = returned_item.keySet();
                for (String key : keys) {
                    System.out.format("%s: %s\n",
                            key, returned_item.get(key).toString());
                }
            } else {
                System.out.format("No item found with the key %s!\n", name);
            }
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }
}
