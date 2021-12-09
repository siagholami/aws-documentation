// snippet-sourcedescription:[DetectDocumentText.java demonstrates how to detect text in the input document that is retrieved from an Amazon S3 bucket.]
// snippet-service:[Amazon Textract]
// snippet-keyword:[Java]
// snippet-keyword:[Amazon Textract]
// snippet-keyword:[Code Sample]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[7-8-2020]
// snippet-sourceauthor:[scmacdon - AWS]

/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
 */

package com.example.textract;

// snippet-start:[textract.java2._detect_s3_text.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.textract.model.S3Object;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.Document;
import software.amazon.awssdk.services.textract.model.DetectDocumentTextRequest;
import software.amazon.awssdk.services.textract.model.DetectDocumentTextResponse;
import software.amazon.awssdk.services.textract.model.Block;
import software.amazon.awssdk.services.textract.model.DocumentMetadata;
import software.amazon.awssdk.services.textract.model.TextractException;
import java.util.Iterator;
import java.util.List;
// snippet-end:[textract.java2._detect_s3_text.import]

public class DetectDocumentTextS3 {

    public static void main(String[] args) {

        final String USAGE = "\n" +
                "Usage:\n" +
                "    DetectDocumentTextS3 <bucketName> <docName> \n\n" +
                "Where:\n" +
                "    bucketName - The name of the Amazon S3 bucket that contains the document \n\n" +
                "    docName - The document name (must be an image, i.e., book.png) \n";

        if (args.length < 2) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String bucketName = args[0];
        String docName = args[1];

        Region region = Region.US_WEST_2;
        TextractClient textractClient = TextractClient.builder()
                .region(region)
                .build();

        detectDocTextS3(textractClient, bucketName, docName);

    }

    // snippet-start:[textract.java2._detect_s3_text.main]
    public static void detectDocTextS3 (TextractClient textractClient, String bucketName, String docName) {

        try {
            S3Object s3Object = S3Object.builder()
                    .bucket(bucketName)
                    .name(docName)
                    .build();

            // Create a Document object and reference the s3Object instance
            Document myDoc = Document.builder()
                    .s3Object(s3Object)
                    .build();

            // Create a DetectDocumentTextRequest object
            DetectDocumentTextRequest detectDocumentTextRequest = DetectDocumentTextRequest.builder()
                    .document(myDoc)
                    .build();

            // Invoke the detectDocumentText method
            DetectDocumentTextResponse textResponse = textractClient.detectDocumentText(detectDocumentTextRequest);

            List<Block> docInfo = textResponse.blocks();

            Iterator<Block> blockIterator = docInfo.iterator();

            while(blockIterator.hasNext()) {
                Block block = blockIterator.next();
                System.out.println("The block type is " +block.blockType().toString());
            }

            DocumentMetadata documentMetadata = textResponse.documentMetadata();
            System.out.println("The number of pages in the document is " +documentMetadata.pages());

        } catch (TextractException e) {

            System.err.println(e.getMessage());
            System.exit(1);
        }
        // snippet-end:[textract.java2._detect_s3_text.main]
    }
}
