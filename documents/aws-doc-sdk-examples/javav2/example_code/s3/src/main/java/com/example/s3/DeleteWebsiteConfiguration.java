//snippet-sourcedescription:[DeleteWebsiteConfiguration.java demonstrates how to delete the website configuration for an Amazon S3 bucket.]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[Amazon S3]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2/6/2020]
//snippet-sourceauthor:[scmacdon-aws]

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   This file is licensed under the Apache License, Version 2.0 (the "License").
   You may not use this file except in compliance with the License. A copy of
   the License is located at
    http://aws.amazon.com/apache2.0/
   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied. See the License for the
   specific language governing permissions and limitations under the License.
*/

package com.example.s3;

// snippet-start:[s3.java2.delete_website_configuration.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteBucketWebsiteRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
// snippet-end:[s3.java2.delete_website_configuration.import]

/**
 * Delete the website configuration for an S3 bucket.
 *
 * This code expects that you have AWS credentials set up, as described here:
 * http://docs.aws.amazon.com/java-sdk/latest/developer-guide/deleteup-credentials.html
 */

public class DeleteWebsiteConfiguration {

    public static void main(String[] args) {
        final String USAGE = "\n" +
                "DeleteWebsiteConfiguration - delete the website configuration for an S3 bucket\n\n" +
                "Usage: DeleteWebsiteConfiguration <bucket>\n\n" +
                "Where:\n" +
                "   bucket   - the bucket to delete the website configuration from\n";

        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        final String bucketName = args[0];

        System.out.format("Deleting website configuration for bucket: %s\n",
                bucketName);

        // Create a S3Client object
        Region region = Region.US_WEST_2;
        S3Client s3 = S3Client.builder().region(region).build();

        deleteBucketWebsiteConfig(s3, bucketName);
    }

    // snippet-start:[s3.java2.delete_website_configuration.main]
    public static void deleteBucketWebsiteConfig(S3Client s3,String bucketName ) {

        //Create a DeleteBucketWebsiteRequest object
        DeleteBucketWebsiteRequest delReq = DeleteBucketWebsiteRequest.builder()
                .bucket(bucketName)
                .build();
        try {
            s3.deleteBucketWebsite(delReq);

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.out.println("Failed to delete website configuration!");
            System.exit(1);
        }
        System.out.println("Done!");
    }
}
// snippet-end:[s3.java2.delete_website_configuration.main]
