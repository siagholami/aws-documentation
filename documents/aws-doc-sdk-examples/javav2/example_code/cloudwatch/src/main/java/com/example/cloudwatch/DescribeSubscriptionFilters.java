//snippet-sourcedescription:[DescribeSubscriptionFilters.java demonstrates how to get a list of Amazon CloudWatch subscription filters that are associated with a log group.]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[Amazon CloudWatch]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[03/02/2020]
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
package com.example.cloudwatch;

// snippet-start:[cloudwatch.java2.describe_subscription_filters.import]
import software.amazon.awssdk.services.cloudwatch.model.CloudWatchException;
import software.amazon.awssdk.services.cloudwatchlogs.CloudWatchLogsClient;
import software.amazon.awssdk.services.cloudwatchlogs.model.DescribeSubscriptionFiltersRequest;
import software.amazon.awssdk.services.cloudwatchlogs.model.DescribeSubscriptionFiltersResponse;
import software.amazon.awssdk.services.cloudwatchlogs.model.SubscriptionFilter;
// snippet-end:[cloudwatch.java2.describe_subscription_filters.import]

/**
 * Lists CloudWatch subscription filters that are associated with a log group.
 */

public class DescribeSubscriptionFilters {

    public static void main(String[] args) {

        final String USAGE =
                "To run this example, supply a log group name\n" +
                        "Ex: DescribeSubscriptionFilters <log-group-name>\n";

        if (args.length != 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String logGroup = args[0];
        CloudWatchLogsClient logs = CloudWatchLogsClient.builder().build();

        describeFilters(logs, logGroup);

    }

    // snippet-start:[cloudwatch.java2.describe_subscription_filters.main]
    public static void describeFilters(CloudWatchLogsClient logs, String logGroup) {

        try {

            boolean done = false;
            String newToken = null;

            while(!done) {

                DescribeSubscriptionFiltersResponse response;

                if (newToken == null) {
                    DescribeSubscriptionFiltersRequest request =
                        DescribeSubscriptionFiltersRequest.builder()
                                .logGroupName(logGroup)
                                .limit(1).build();

                    response = logs.describeSubscriptionFilters(request);
                } else {
                    DescribeSubscriptionFiltersRequest request =
                        DescribeSubscriptionFiltersRequest.builder()
                                .nextToken(newToken)
                                .logGroupName(logGroup)
                                .limit(1).build();

                response = logs.describeSubscriptionFilters(request);
                }

                for(SubscriptionFilter filter : response.subscriptionFilters()) {
                    System.out.printf(
                        "Retrieved filter with name %s, " +
                                "pattern %s " +
                                "and destination arn %s",
                        filter.filterName(),
                        filter.filterPattern(),
                        filter.destinationArn());
                System.out.println("");
            }

            if(response.nextToken() == null) {
                done = true;
            } else {
                newToken = response.nextToken();
            }
            }
        } catch (CloudWatchException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        System.out.printf("Done");
    }
}
// snippet-end:[cloudwatch.java2.describe_subscription_filters.main]
