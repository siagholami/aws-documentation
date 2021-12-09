<?php
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
 *
 *  ABOUT THIS PHP SAMPLE: This sample is part of the KMS Developer Guide topic at
 *  https://docs.aws.amazon.com/kms/latest/developerguide/programming-client.html
 *
 *
 *
 */
// snippet-start:[kms.php.create_client.complete]
// snippet-start:[kms.php.create_client.import]

require 'vendor/autoload.php';

use Aws\Kms\KmsClient;
// snippet-end:[kms.php.create_client.import]
/**
 * Creating an Amazon KMS client.
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */

//Create a KmsClient 
// snippet-start:[kms.php.create_client.main]
$KmsClient = new Aws\Kms\KmsClient([
    'profile' => 'default',
    'version' => '2014-11-01',
    'region' => 'us-east-2'
]);

// The same options that can be provided to a specific client constructor can also be supplied to the Aws\Sdk class.
// Use the us-west-2 region and latest version of each client.
$sharedConfig = [
    'region' => 'us-west-2',
    'version' => 'latest'
];

// Create an SDK class used to share configuration across clients.
$sdk = new Aws\Sdk($sharedConfig);

// Create an Amazon Kms client using the shared configuration data.
$client = $sdk->createKms();
 
 
// snippet-end:[kms.php.create_client.main]
// snippet-end:[kms.php.create_client.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[CreateClient.php demonstrates how to create an AWS Key Management Service client in PHP.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[AWS Key Management Service (KMS)]
// snippet-service:[kms]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-12-27]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

