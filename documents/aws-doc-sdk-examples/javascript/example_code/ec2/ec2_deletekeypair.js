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

//snippet-sourcedescription:[ec2_deletekeypair.js demonstrates how to delete a key pair from an Amazon EC2 instance.]
//snippet-service:[ec2]
//snippet-keyword:[JavaScript]
//snippet-sourcesyntax:[javascript]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon EC2]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2018-06-02]
//snippet-sourceauthor:[AWS-JSDG]

// ABOUT THIS NODE.JS SAMPLE: This sample is part of the SDK for JavaScript Developer Guide topic at
// https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/ec2-example-key-pairs.html

// snippet-start:[ec2.JavaScript.keypairs.deleteKeyPair]
// Load the AWS SDK for Node.js
var AWS = require('aws-sdk');
// Set the region 
AWS.config.update({region: 'REGION'});

// Create EC2 service object
var ec2 = new AWS.EC2({apiVersion: '2016-11-15'});

var params = {
   KeyName: 'KEY_PAIR_NAME'
};

// Delete the key pair
ec2.deleteKeyPair(params, function(err, data) {
   if (err) {
      console.log("Error", err);
   } else {
      console.log("Key Pair Deleted");
   }
});
// snippet-end:[ec2.JavaScript.keypairs.deleteKeyPair]
