//snippet-sourcedescription:[PutMetricData.java demonstrates how to put a sample metric data point for a metric defined for an Amazon CloudWatch alarm.]
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

// snippet-start:[cloudwatch.java2.put_metric_data.import]
package com.example.cloudwatch;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.Dimension;
import software.amazon.awssdk.services.cloudwatch.model.MetricDatum;
import software.amazon.awssdk.services.cloudwatch.model.StandardUnit;
import software.amazon.awssdk.services.cloudwatch.model.PutMetricDataRequest;
import software.amazon.awssdk.services.cloudwatch.model.PutMetricDataResponse;
import software.amazon.awssdk.services.cloudwatch.model.CloudWatchException;
// snippet-end:[cloudwatch.java2.put_metric_data.import]
/**
 * Puts a sample metric data point
 */
public class PutMetricData {
    public static void main(String[] args) {

        final String USAGE =
                "To run this example, supply a data point:\n" +
                        "Example: PutMetricData <data_point>\n";

        if (args.length != 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        Double dataPoint = Double.parseDouble(args[0]);

        Region region = Region.US_WEST_2;
        CloudWatchClient cw = CloudWatchClient.builder()
                .region(region)
                .build();

        putMetData(cw, dataPoint) ;
    }
    // snippet-start:[cloudwatch.java2.put_metric_data.main]
    public static void putMetData(CloudWatchClient cw, Double dataPoint ) {

        try {
            Dimension dimension = Dimension.builder()
                .name("UNIQUE_PAGES")
                .value("URLS").build();

            MetricDatum datum = MetricDatum.builder()
                .metricName("PAGES_VISITED")
                .unit(StandardUnit.NONE)
                .value(dataPoint)
                .dimensions(dimension).build();

            PutMetricDataRequest request = PutMetricDataRequest.builder()
                .namespace("SITE/TRAFFIC")
                .metricData(datum).build();

            PutMetricDataResponse response = cw.putMetricData(request);

        } catch (CloudWatchException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        System.out.printf("Successfully put data point %f", dataPoint);
        // snippet-end:[cloudwatch.java2.put_metric_data.main]
    }
}
