//snippet-sourcedescription:[S3ObjectOperations.java demonstrates how to create Amazon S3 buckets, upload objects into that bucket, list objects in that bucket and finally delete the bucket.]
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
// snippet-start:[s3.java2.s3_object_operations.complete]
// snippet-start:[s3.java2.s3_object_operations.import]

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.Random;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.CompletedMultipartUpload;
import software.amazon.awssdk.services.s3.model.CompletedPart;
import software.amazon.awssdk.services.s3.model.CreateBucketConfiguration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
// snippet-end:[s3.java2.s3_object_operations.import]

// snippet-start:[s3.java2.s3_object_operations.main]
public class S3ObjectOperations {

    private static S3Client s3;

    public static void main(String[] args) throws IOException {
        // snippet-start:[s3.java2.s3_object_operations.upload]
        Region region = Region.US_WEST_2;
        s3 = S3Client.builder().region(region).build();


        String bucket = "bucket" + System.currentTimeMillis();
        String key = "key";

        createBucket(s3,bucket, region);

        // Put Object
        s3.putObject(PutObjectRequest.builder().bucket(bucket).key(key)
                        .build(),
                RequestBody.fromByteBuffer(getRandomByteBuffer(10_000)));
        // snippet-end:[s3.java2.s3_object_operations.upload]


        // Multipart Upload a file
        String multipartKey = "multiPartKey";
        multipartUpload(bucket, multipartKey);

        // List all objects in bucket

        // snippet-start:[s3.java2.s3_object_operations.pagination]
        // Use manual pagination
        ListObjectsV2Request listObjectsReqManual = ListObjectsV2Request.builder()
                .bucket(bucket)
                .maxKeys(1)
                .build();

        boolean done = false;
        while (!done) {
            ListObjectsV2Response listObjResponse = s3.listObjectsV2(listObjectsReqManual);
            for (S3Object content : listObjResponse.contents()) {
                System.out.println(content.key());
            }

            if (listObjResponse.nextContinuationToken() == null) {
                done = true;
            }

            listObjectsReqManual = listObjectsReqManual.toBuilder()
                    .continuationToken(listObjResponse.nextContinuationToken())
                    .build();
        }
        // snippet-end:[s3.java2.s3_object_operations.pagination]
        // snippet-start:[s3.java2.s3_object_operations.iterative]
        // Build the list objects request
        ListObjectsV2Request listReq = ListObjectsV2Request.builder()
                .bucket(bucket)
                .maxKeys(1)
                .build();

        ListObjectsV2Iterable listRes = s3.listObjectsV2Paginator(listReq);
        // Process response pages
        listRes.stream()
                .flatMap(r -> r.contents().stream())
                .forEach(content -> System.out.println(" Key: " + content.key() + " size = " + content.size()));

        // snippet-end:[s3.java2.s3_object_operations.iterative]
        // snippet-start:[s3.java2.s3_object_operations.stream]
        // Helper method to work with paginated collection of items directly
        listRes.contents().stream()
                .forEach(content -> System.out.println(" Key: " + content.key() + " size = " + content.size()));
        // snippet-end:[s3.java2.s3_object_operations.stream]
        // snippet-start:[s3.java2.s3_object_operations.forloop]
        // Use simple for loop if stream is not necessary
        for (S3Object content : listRes.contents()) {
            System.out.println(" Key: " + content.key() + " size = " + content.size());
        }
        // snippet-end:[s3.java2.s3_object_operations.forloop]

        // Get Object
        // snippet-start:[s3.java2.s3_object_operations.download]
        s3.getObject(GetObjectRequest.builder().bucket(bucket).key(key).build(),
                ResponseTransformer.toFile(Paths.get("multiPartKey")));
        // snippet-end:[s3.java2.s3_object_operations.download]

        // Delete Object
        // snippet-start:[s3.java2.s3_object_operations.delete]
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder().bucket(bucket).key(key).build();
        s3.deleteObject(deleteObjectRequest);
        // snippet-end:[s3.java2.s3_object_operations.delete]

        // Delete Object
        deleteObjectRequest = DeleteObjectRequest.builder().bucket(bucket).key(multipartKey).build();
        s3.deleteObject(deleteObjectRequest);

        deleteBucket(s3,bucket);
    }


    public static void createBucket( S3Client s3Client, String bucketName, Region region) {
        
        try{
            s3Client.createBucket(CreateBucketRequest
                .builder()
                .bucket(bucketName)
                .createBucketConfiguration(
                        CreateBucketConfiguration.builder()
                                .locationConstraint(region.id())
                                .build())
                .build());

            System.out.println(bucketName);
         } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    public static void deleteBucket(S3Client client, String bucket) {
        DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder().bucket(bucket).build();
        client.deleteBucket(deleteBucketRequest);
    }

    /**
     * Uploading an object to S3 in parts
     */
    private static void multipartUpload(String bucketName, String key) throws IOException {

        int MB = 1024 * 1024;
        // snippet-start:[s3.java2.s3_object_operations.upload_multi_part]
        // First create a multipart upload and get upload id
        CreateMultipartUploadRequest createMultipartUploadRequest = CreateMultipartUploadRequest.builder()
                .bucket(bucketName).key(key)
                .build();
        CreateMultipartUploadResponse response = s3.createMultipartUpload(createMultipartUploadRequest);
        String uploadId = response.uploadId();
        System.out.println(uploadId);

        // Upload all the different parts of the object
        UploadPartRequest uploadPartRequest1 = UploadPartRequest.builder().bucket(bucketName).key(key)
                .uploadId(uploadId)
                .partNumber(1).build();
        String etag1 = s3.uploadPart(uploadPartRequest1, RequestBody.fromByteBuffer(getRandomByteBuffer(5 * MB))).eTag();
        CompletedPart part1 = CompletedPart.builder().partNumber(1).eTag(etag1).build();

        UploadPartRequest uploadPartRequest2 = UploadPartRequest.builder().bucket(bucketName).key(key)
                .uploadId(uploadId)
                .partNumber(2).build();
        String etag2 = s3.uploadPart(uploadPartRequest2, RequestBody.fromByteBuffer(getRandomByteBuffer(3 * MB))).eTag();
        CompletedPart part2 = CompletedPart.builder().partNumber(2).eTag(etag2).build();


        // Finally call completeMultipartUpload operation to tell S3 to merge all uploaded
        // parts and finish the multipart operation.
        CompletedMultipartUpload completedMultipartUpload = CompletedMultipartUpload.builder().parts(part1, part2).build();
        CompleteMultipartUploadRequest completeMultipartUploadRequest =
                CompleteMultipartUploadRequest.builder().bucket(bucketName).key(key).uploadId(uploadId)
                        .multipartUpload(completedMultipartUpload).build();
        s3.completeMultipartUpload(completeMultipartUploadRequest);
        // snippet-end:[s3.java2.s3_object_operations.upload_multi_part]
    }

    private static ByteBuffer getRandomByteBuffer(int size) throws IOException {
        byte[] b = new byte[size];
        new Random().nextBytes(b);
        return ByteBuffer.wrap(b);
    }
}

// snippet-end:[s3.java2.s3_object_operations.main]
// snippet-end:[s3.java2.s3_object_operations.complete]
