/* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0

ABOUT THIS NODE.JS EXAMPLE: This example works with Version 3 (V3) of the AWS SDK for JavaScript,
which is scheduled for release later in 2020. The prerelease version of the SDK is available
at https://github.com/aws/aws-sdk-js-v3. The 'SDK for JavaScript Developer Guide' for V3 is also
scheduled for release later in 2020, and the topic containing this example will be hosted at
https://docs.aws.amazon.com/sdk-for-javascript/v3/developer-guide/sns-examples-managing-topics.html.

Purpose:
sns_createtopic.ts demonstrates how to create an Amazom SNS topic to which notifications can be published.

Inputs (replace in code):
- REGION
- TOPIC_NAME

Running the code:
ts-node sns_createtopic.ts
 */
// snippet-start:[sns.JavaScript.topics.createTopicV3]
// Import required AWS SDK clients and commands for Node.js
const { SNSClient, CreateTopicCommand } = require("@aws-sdk/client-sns");

// Set the AWS Region
const REGION = "REGION"; //e.g. "us-east-1"

// Set the parameters
const params = { Name: "TOPIC_NAME" }; //TOPIC_NAME

// Create SNS service object
const sns = new SNS(REGION);

const run = async () => {
  try {
    const data = await sns.send(new CreateTopicCommand(params));
    console.log("Topic ARN is " + data.TopicArn);
  } catch (err) {
    console.error(err, err.stack);
  }
};
run();
// snippet-end:[sns.JavaScript.topics.createTopicV3]
export = { run }; //for unit tests only
