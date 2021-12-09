//snippet-sourcedescription:[GetJobRun.java demonstrates how to get a job run request.]
//snippet-keyword:[Java]
//snippet-keyword:[Code Sample]
//snippet-keyword:[AWS Glue]
//snippet-service:[AWS Glue]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[9/3/2020]
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

package com.example.glue;

//snippet-start:[glue.java2.get_job.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.glue.GlueClient;
import software.amazon.awssdk.services.glue.model.GetJobRunRequest;
import software.amazon.awssdk.services.glue.model.GetJobRunResponse;
import software.amazon.awssdk.services.glue.model.GlueException;
//snippet-end:[glue.java2.get_job.import]

public class GetJobRun {

    public static void main(String[] args) {

        final String USAGE = "\n" +
                "Usage:\n" +
                "    GetJobRun <jobName><runId>\n\n" +
                "Where:\n" +
                "    jobName - The name of the job. \n" +
                "    runId   - The run ID value. \n";

        if (args.length < 2) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String jobName = args[0];
        String runId = args[1];

        Region region = Region.US_EAST_1;
        GlueClient glueClient = GlueClient.builder()
                .region(region)
                .build();

        getGlueJobRun(glueClient, jobName, runId);
    }

    //snippet-start:[glue.java2.get_job.main]
    public static void getGlueJobRun(GlueClient glueClient, String jobName, String runId) {

        try {
              GetJobRunRequest jobRunRequest = GetJobRunRequest.builder()
                .jobName(jobName)
                .runId(runId)
                .build();

              GetJobRunResponse runResponse = glueClient.getJobRun(jobRunRequest);
              System.out.println("Job status is : "+runResponse.jobRun().jobRunStateAsString());
        } catch (GlueException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
    //snippet-end:[glue.java2.get_job.main]
}
