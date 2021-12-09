/* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0

ABOUT THIS NODE.JS EXAMPLE: This example works with Version 3 (V3) of the AWS SDK for JavaScript,
which is scheduled for release later in 2020. The prerelease version of the SDK is available
at https://github.com/aws/aws-sdk-js-v3. The 'SDK for JavaScript Developer Guide' for V3 is also
scheduled for release later in 2020, and the topic containing this example will be hosted at
https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-pre-authentication.html.

Purpose:
lambda-trigger-pre-authentication.js is an example AWS Lambda function that prevents users from a specific user pool app client
from signing in to the user pool.

Running the code:
1. On the AWS Lambda service dashboard, choose Create function.
2. On the Create function page, name the function, and choose Create function.
3. Copy and paste the code into the index.js file in the editor, and save the function.
4. Open the Amazon Cognito service.
5. Choose Manage user pools.
6. Choose the user pool you want to add the trigger to. (If you don't have a user pool, create one.)
7. In General Settings, choose Triggers.
8. In the Pre authentication pane, select the Lambda function.
*/

// snippet-start:[cognito.javascript.lambda-trigger.pre-authenticationV3]
exports.handler = async (event, context) => {
  try {
    if (
      event.callerContext.clientId === "user-pool-app-client-id-to-be-blocked"
    ) {
      const error = new Error(
        "Cannot authenticate users from this user pool app client"
      );
    }
  } catch (err) {
    // Return to Amazon Cognito
    return err;
  }
};
// snippet-end:[cognito.javascript.lambda-trigger.pre-authenticationV3]
