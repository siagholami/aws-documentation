/**
 * Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

//snippet-sourcedescription:[sns_getsmstype.js demonstrates how to retrieve the settings for sending Amazon SMS messages.]
//snippet-service:[sns]
//snippet-keyword:[JavaScript]
//snippet-sourcesyntax:[javascript]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon Simple Notification Service]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2018-06-02]
//snippet-sourceauthor:[AWS-JSDG]

// ABOUT THIS NODE.JS SAMPLE: This sample is part of the SDK for JavaScript Developer Guide topic at
// https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide//sns-examples-sending-sms.html

// snippet-start:[sns.JavaScript.SMS.getSMSAttributes]
// Load the AWS SDK for Node.js
var AWS = require('aws-sdk');
// Set region
AWS.config.update({region: 'REGION'});

// Create SMS Attribute parameter you want to get
var params = {
  attributes: [
    'DefaultSMSType',
    'ATTRIBUTE_NAME'
    /* more items */
  ]
};

// Create promise and SNS service object
var getSMSTypePromise = new AWS.SNS({apiVersion: '2010-03-31'}).getSMSAttributes(params).promise();

// Handle promise's fulfilled/rejected states
getSMSTypePromise.then(
  function(data) {
    console.log(data);
  }).catch(
    function(err) {
    console.error(err, err.stack);
  });
// snippet-end:[sns.JavaScript.SMS.getSMSAttributes]
