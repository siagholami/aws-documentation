/* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0

ABOUT THIS NODE.JS EXAMPLE: This example works with Version 3 (V3) of the AWS SDK for JavaScript,
which is scheduled for release later in 2020. The prerelease version of the SDK is available
at https://github.com/aws/aws-sdk-js-v3. The 'SDK for JavaScript Developer Guide' for V3 is also
scheduled for release later in 2020, and the topic containing this example will be hosted at
https://docs.aws.amazon.com/sdk-for-javascript/v3/developer-guide/cross-service-example-dataupload.html.

Purpose:
convert-bucket-to-website.ts is part of a tutorial demonstrating how to build and deploy an app to submit
data to an Amazon DynamoDB table. To run the full tutorial, see
https://docs.aws.amazon.com/sdk-for-javascript/v3/developer-guide/cross-service-example-submitting-data.html.
convert-bucket-to-website.ts applies a bucket policy to convert an Amazon S3 bucket into a static web host.

Inputs (replace in code):
- REGION
- BUCKET_NAME

Running the code:
node upload_files_to_s3.ts
 */
// snippet-start:[s3.JavaScript.cross-service.addBucketPolicyV3]
const {
  S3Client,
  CreateBucketCommand,
  PutBucketWebsiteCommand,
  PutBucketPolicyCommand,
} = require("@aws-sdk/client-s3");

// Set the AWS Region
const REGION = "REGION"; //e.g. "us-east-1"

// Create params JSON for S3.createBucket
const bucketName = "BUCKET_NAME"; //BUCKET_NAME

const readOnlyAnonUserPolicy = {
  Version: "2012-10-17",
  Statement: [
    {
      Sid: "AddPerm",
      Effect: "Allow",
      Principal: "*",
      Action: ["s3:GetObject"],
      Resource: [""],
    },
  ],
};

// create selected bucket resource string for bucket policy
var bucketResource = "arn:aws:s3:::" + bucketName + "/*"; //BUCKET_NAME
readOnlyAnonUserPolicy.Statement[0].Resource[0] = bucketResource;

// convert policy JSON into string and assign into params
var bucketPolicyParams = {
  Bucket: bucketName,
  Policy: JSON.stringify(readOnlyAnonUserPolicy),
};

// Instantiate an S3 client
const s3 = new S3Client(REGION);

const run = async () => {
  try {
    const response = await s3.send(
      new PutBucketPolicyCommand(bucketPolicyParams)
    );
    console.log("Success, permissions added to bucket", response);
  } catch (err) {
    console.log("Error", err);
  }
};
run();
// snippet-end:[s3.JavaScript.cross-service.addBucketPolicyV3]
// For unit tests only
exports.run = run();
