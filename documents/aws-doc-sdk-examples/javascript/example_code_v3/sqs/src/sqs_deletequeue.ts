/* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0

ABOUT THIS NODE.JS EXAMPLE: This example works with Version 3 (V3) of the AWS SDK for JavaScript,
which is scheduled for release later in 2020. The prerelease version of the SDK is available
at https://github.com/aws/aws-sdk-js-v3. The 'SDK for JavaScript Developer Guide' for V3 is also
scheduled for release later in 2020, and the topic containing this example will be hosted at
https://docs.aws.amazon.com/sdk-for-javascript/v3/developer-guide/sqs-examples-using-queues.html.

Purpose:
sqs_deletequeue.ts demonstrates how to delete an Amazon SQS queue.

Inputs (replace in code):
- REGION
- SQS_QUEUE_URl

Running the code:
ts-node sqs_deletequeue.js
*/
// snippet-start:[sqs.JavaScript.queues.deleteQueueV3]
// Import required AWS SDK clients and commands for Node.js
const { SQSClient, DeleteQueueCommand } = require("@aws-sdk/client-sqs");

// Set the AWS Region
const REGION = "region"; //e.g. "us-east-1"

// Set the parameters
const params = { QueueUrl: "SQS_QUEUE_URL" }; //SQS_QUEUE_URL e.g., 'https://sqs.REGION.amazonaws.com/ACCOUNT-ID/QUEUE-NAME'

// Create SQS service object
const sns = new SQSClient(REGION);

const run = async () => {
  try {
    const data = await sns.send(new DeleteQueueCommand(params));
    console.log("Success, queue deleted. RequestID:", data.$metadata.requestId);
  } catch (err) {
    console.error(err, err.stack);
  }
};
run();
// snippet-end:[sqs.JavaScript.queues.deleteQueueV3]
export = { run }; //for unit tests only
