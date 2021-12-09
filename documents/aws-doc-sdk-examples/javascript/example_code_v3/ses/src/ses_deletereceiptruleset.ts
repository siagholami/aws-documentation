/* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0

ABOUT THIS NODE.JS EXAMPLE: This example works with Version 3 (V3) of the AWS SDK for JavaScript,
which is scheduled for release later in 2020. The prerelease version of the SDK is available
at https://github.com/aws/aws-sdk-js-v3. The 'SDK for JavaScript Developer Guide' for V3 is also
scheduled for release later in 2020, and the topic containing this example will be hosted atic
https://docs.aws.amazon.com/sdk-for-javascript/v3/developer-guide/ses-examples-receipt-rules.html.


Purpose:
ses_deletereceiptruleset.ts demonstrates how to delete an Amazon SES receipt rule set.

Inputs (replace in code):
- REGION
- RULE_SET_NAME

Running the code:
ts-node ses_deletereceiptruleset.ts
 */
// snippet-start:[ses.JavaScript.rules.deleteReceiptRuleSetV3]
// Import required AWS SDK clients and commands for Node.js
const { SESClient, DeleteReceiptRuleSetCommand } = require("@aws-sdk/client-ses");

// Set the AWS Region
const REGION = "REGION"; //e.g. "us-east-1"

// Set the parameters
const params = { RuleSetName: "RULE_SET_NAME" }; //RULE_SET_NAME

// Create SES service object
const ses = new SESClient(REGION);

const run = async () => {
  try {
    const data = await ses.send(new DeleteReceiptRuleSetCommand(params));
    console.log("Success, rule set deleted", data);
  } catch (err) {
    console.error(err, err.stack);
  }
};
run();
// snippet-end:[ses.JavaScript.rules.deleteReceiptRuleSetV3]
export = {run}; //for unit tests only
