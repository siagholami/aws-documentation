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
 *  ABOUT THIS PHP SAMPLE: This sample is part of the SDK for PHP Developer Guide topic at
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/getting-started/basic-usage.html
 *
 */
// snippet-start:[s3.php.create_client.complete]
// snippet-start:[s3.php.create_client.import]
require 'vendor/autoload.php';

use Aws\S3\S3Client;

use Aws\Exception\AwsException;
// snippet-end:[s3.php.create_client.import]
/**
 * Creating an Amazon S3 client.
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */
// snippet-start:[s3.php.create_client.main]
// snippet-start:[s3.php.create_client.client]
//Create a S3Client
$s3 = new Aws\S3\S3Client([
    'version' => 'latest',
    'region' => 'us-east-2'
]);
// snippet-end:[s3.php.create_client.client]

// snippet-start:[s3.php.create_client.sdk]
// The same options that can be provided to a specific client constructor can also be supplied to the Aws\Sdk class.
// Use the us-west-2 region and latest version of each client.
$sharedConfig = [
    'region' => 'us-west-2',
    'version' => 'latest'
];

// Create an SDK class used to share configuration across clients.
$sdk = new Aws\Sdk($sharedConfig);

// Create an Amazon S3 client using the shared configuration data.
$client = $sdk->createS3();
// snippet-end:[s3.php.create_client.sdk] 
// snippet-end:[s3.php.create_client.main]
// snippet-end:[s3.php.create_client.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[CreateBucket.php demonstrates how to create an Amazon S3 Bucket.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon S3]
// snippet-service:[s3]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-09-20]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

