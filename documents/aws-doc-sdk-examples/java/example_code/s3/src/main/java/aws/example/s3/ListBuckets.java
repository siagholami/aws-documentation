//snippet-sourcedescription:[ListBuckets.java demonstrates how to get a list of buckets in your AWS account.]
//snippet-keyword:[Java]
//snippet-sourcesyntax:[java]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon S3]
//snippet-keyword:[listBuckets]
//snippet-service:[s3]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[]
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
package aws.example.s3;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

/**
 * List your Amazon S3 buckets.
 * 
 * This code expects that you have AWS credentials set up per:
 * http://docs.aws.amazon.com/java-sdk/latest/developer-guide/setup-credentials.html
 */
public class ListBuckets {
    public static void main(String[] args) {
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();
        List<Bucket> buckets = s3.listBuckets();
        System.out.println("Your Amazon S3 buckets are:");
        for (Bucket b : buckets) {
            System.out.println("* " + b.getName());
        }
    }
}
