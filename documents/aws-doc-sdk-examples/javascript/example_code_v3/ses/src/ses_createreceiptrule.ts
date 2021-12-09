/* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0

ABOUT THIS NODE.JS EXAMPLE: This example works with Version 3 (V3) of the AWS SDK for JavaScript,
which is scheduled for release later in 2020. The prerelease version of the SDK is available
at https://github.com/aws/aws-sdk-js-v3. The 'SDK for JavaScript Developer Guide' for V3 is also
scheduled for release later in 2020, and the topic containing this example will be hosted at
https://docs.aws.amazon.com/sdk-for-javascript/v3/developer-guide/ses-examples-receipt-rules.html.

Purpose:
ses_createreceiptrule.ts demonstrates how to create a receipt rule in Amazon SES to save
received messages in an Amazon S3 bucket.

Inputs (replace in code):
- REGION
- BUCKET_NAME
- EMAIL_ADDRESS | DOMAIN
- RULE_NAME
- RULE_SET_NAME

Running the code:
ts-node ses_createreceiptrule.ts
*/
// snippet-start:[ses.JavaScript.rules.createReceiptRuleV3]
// Import required AWS SDK clients and commands for Node.js
const { SESClient, CreateReceiptRuleCommand } = require("@aws-sdk/client-ses");

// Set the AWS Region
const REGION = "REGION"; //e.g. "us-east-1" // REGION

// Set the parameters
const params = {
  Rule: {
    Actions: [
      {
        S3Action: {
          BucketName: "BUCKET_NAME", // S3_BUCKET_NAME
          ObjectKeyPrefix: "email",
        },
      },
    ],
    Recipients: [
      "EMAIL_ADDRESS", // The email addresses, or domain
      /* more items */
    ],
    Enabled: true | false,
    Name: "RULE_NAME", // RULE_NAME
    ScanEnabled: true | false,
    TlsPolicy: "Optional",
  },
  RuleSetName: "RULE_SET_NAME", // RULE_SET_NAME
};

// Create SES service object
const ses = new SESClient(REGION);

const run = async () => {
  try {
    const data = await ses.send(new CreateReceiptRuleCommand(params));
    console.log("Rule created; requestId:", data.$metadata.requestId);
  } catch (err) {
    console.error(err, err.stack);
  }
};
run();
// snippet-end:[ses.JavaScript.rules.createReceiptRuleV3]
export = { run }; //for unit tests only
