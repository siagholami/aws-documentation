//snippet-sourcedescription:[S3AsyncOps.java demonstrates how to use the S3 asynchronous client to place an object into a bucket.]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[Amazon S3]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2/6/2020]
//snippet-sourceauthor:[scmacdon-aws]
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.s3;
// snippet-start:[s3.java2.async_ops.complete]
// snippet-start:[s3.java2.async_ops.import]

import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
// snippet-end:[s3.java2.async_ops.import]
// snippet-start:[s3.java2.async_ops.main]
public class S3AsyncOps {

     public static void main(String[] args) {


         final String USAGE = "\n" +
                 "Usage:\n" +
                 "    S3AsyncOps <bucketname> <objectname> <path>\n\n" +
                 "Where:\n" +
                 "    bucketname - the name of the bucket (i.e., bucket1)\n\n" +
                 "    objectname - the name of the object (i.e., book.pdf)\n" +
                 "    path - the local path to the file (i.e., C:\\AWS\\book.pdf)\n" +
                 "Example:\n" +
                 "    bucket1 book.pdf  C:\\AWS\\book.pdf\n";

         if (args.length < 3) {
             System.out.println(USAGE);
             System.exit(1);
         }
                
        String bucketName = args[0];
        String key = args[1];
        String path = args[2];

        Region region = Region.US_WEST_2;
        S3AsyncClient client = S3AsyncClient.builder()
                .region(region)
                .build();

        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        // Put the object into the bucket
        CompletableFuture<PutObjectResponse> future = client.putObject(objectRequest,
                AsyncRequestBody.fromFile(Paths.get(path))
        );
        future.whenComplete((resp, err) -> {
            try {
                if (resp != null) {
                    System.out.println("Object uploaded. Details: " + resp);
                } else {
                    // Handle error
                    err.printStackTrace();
                }
            } finally {
                // Lets the application shut down. Only close the client when you are completely done with it.
                client.close();
            }
        });

        future.join();
    }
}

// snippet-end:[s3.java2.async_ops.main]
// snippet-end:[s3.java2.async_ops.complete]
