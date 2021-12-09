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
 *  ABOUT THIS PHP SAMPLE: This sample is part of the AWS SDK for PHP Developer Guide topic at
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/kinesis-example-shard.html
 *
 */
// snippet-start:[kinesis.php.update_data_stream_shards.complete]
// snippet-start:[kinesis.php.update_data_stream_shards.import]
require 'vendor/autoload.php';

use Aws\Kinesis\KinesisClient; 
use Aws\Exception\AwsException;
// snippet-end:[kinesis.php.update_data_stream_shards.import]

/**
 * Updating number of shareds in an Amazon Kinesis Data Stream.
 * Remember you can only increase shareds to be double current shard count.
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */

//Create a KinesisClient 
// snippet-start:[kinesis.php.update_data_stream_shards.main]
$kinesisClient = new Aws\Kinesis\KinesisClient([
    'profile' => 'default',
    'version' => '2013-12-02',
    'region' => 'us-east-2'
]);

$name = "my_stream_name";
$totalshards = 4;


try {
    $result = $kinesisClient->UpdateShardCount([
        'ScalingType' => 'UNIFORM_SCALING',
        'StreamName' => $name,
        'TargetShardCount' => $totalshards
    ]);
    var_dump($result);
} catch (AwsException $e) {
    // output error message if fails
    echo $e->getMessage();
    echo "\n";
}
 
 
// snippet-end:[kinesis.php.update_data_stream_shards.main]
// snippet-end:[kinesis.php.update_data_stream_shards.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[UpdateDataStreamShards.php demonstrates how to update the shards count of a Amazon Kinesis Data Streams stream. Remember you can only double your shard count when increasing. Also you may not scale down to more than half of your current shard count when decreasing. ]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon Kinesis]
// snippet-service:[kinesis]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-12-27]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

