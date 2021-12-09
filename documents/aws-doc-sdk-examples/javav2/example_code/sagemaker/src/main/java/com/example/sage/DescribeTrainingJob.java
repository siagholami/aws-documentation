//snippet-sourcedescription:[DescribeTrainingJob.java demonstrates how to obtain information about a training job.]
//snippet-keyword:[Java]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon SageMaker]
//snippet-service:[SageMaker]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[8/18/2020]
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

package com.example.sage;

//snippet-start:[sagemaker.java2.describe_train_job.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sagemaker.SageMakerClient;
import software.amazon.awssdk.services.sagemaker.model.DescribeTrainingJobRequest;
import software.amazon.awssdk.services.sagemaker.model.DescribeTrainingJobResponse;
import software.amazon.awssdk.services.sagemaker.model.SageMakerException;
//snippet-end:[sagemaker.java2.describe_train_job.import]

public class DescribeTrainingJob {

    public static void main(String[] args) {

        final String USAGE = "\n" +
                "Usage:\n" +
                "    DescribeTrainingJob <trainingJobName>\n\n" +
                "Where:\n" +
                "    trainingJobName  - The name of the training job.\n\n";

        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        /* Read the name from command args */
        String trainingJobName = args[0];

        Region region = Region.US_WEST_2;
        SageMakerClient sageMakerClient = SageMakerClient.builder()
                .region(region)
                .build();

        desribeTrainJob(sageMakerClient, trainingJobName);
    }

    //snippet-start:[sagemaker.java2.describe_train_job.main]
    public static void desribeTrainJob(SageMakerClient sageMakerClient, String trainingJobName) {

       try {
            DescribeTrainingJobRequest trainingJobRequest = DescribeTrainingJobRequest.builder()
                .trainingJobName(trainingJobName)
                .build();

            DescribeTrainingJobResponse jobResponse = sageMakerClient.describeTrainingJob(trainingJobRequest);
            System.out.println("The job status is "+ jobResponse.trainingJobStatusAsString());
       } catch (SageMakerException e) {
           System.err.println(e.awsErrorDetails().errorMessage());
           System.exit(1);
       }
    }
    //snippet-end:[sagemaker.java2.describe_train_job.main]
}
