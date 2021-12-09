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
 */
// snippet-start:[s3.php.put_bucket_lifecycle.complete]
// snippet-start:[s3.php.put_bucket_lifecycle.import]

require 'vendor/autoload.php';

use Aws\S3\S3Client;  
use Aws\Exception\AwsException;
// snippet-end:[s3.php.put_bucket_lifecycle.import]


/**
 * Put bucket lifecycle
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */

$bucketName = 'BUCKET_NAME';

// snippet-start:[s3.php.put_bucket_lifecycle.main]
$client = new S3Client([
    'profile' => 'default',
    'region' => 'us-west-2',
    'version' => '2006-03-01'
]);

try {
    $result = $client->putBucketLifecycle(
        [
            'Bucket' => $bucketName, // REQUIRED
            'LifecycleConfiguration' => [
                'Rules' => [ // REQUIRED
                    [
                        'AbortIncompleteMultipartUpload' => [
                            'DaysAfterInitiation' => 30,
                        ],
                        'ID' => 'unique_id',
                        'Status' => 'Enabled', // REQUIRED
                        'Prefix' => ''
                    ],
                ],
            ],
        ]
    );
    var_dump($result);
} catch (AwsException $e) {
    // output error message if fails
    error_log($e->getMessage());
}
 
 
// snippet-end:[s3.php.put_bucket_lifecycle.main]
// snippet-end:[s3.php.put_bucket_lifecycle.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[PutBucketLifecycle.php demonstrates how to add a Lifecycle Configuration to an Amazon S3 bucket.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon S3]
// snippet-service:[s3]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-09-20]
// snippet-sourceauthor:[jschwarzwalder (AWS)]
