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
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/kinesis-firehose-example-delivery-stream.html
 */
// snippet-start:[firehose.php.put_record_delivery_stream.complete]
// snippet-start:[firehose.php.put_record_delivery_stream.import]

require 'vendor/autoload.php';

use Aws\Firehose\FirehoseClient; 
use Aws\Exception\AwsException;
// snippet-end:[firehose.php.put_record_delivery_stream.import]

/**
 * Add a data blog to an existing Amazon Kinesis Firehose Delivery Stream.
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */

//Create a KinesisClient 
// snippet-start:[firehose.php.put_record_delivery_stream.main]
$firehoseClient = new Aws\Firehose\FirehoseClient([
    'profile' => 'default',
    'version' => '2015-08-04',
    'region' => 'us-east-2'
]);

$name = "my_stream_name";
$content = '{"ticker_symbol":"QXZ", "sector":"HEALTHCARE", "change":-0.05, "price":84.51}';

try {
    $result = $firehoseClient->putRecord([
        'DeliveryStreamName' => $name,
        'Record' => [
            'Data' => $content,
        ],
    ]);
    var_dump($result);
} catch (AwsException $e) {
    // output error message if fails
    echo $e->getMessage();
    echo "\n";
}
 
 
// snippet-end:[firehose.php.put_record_delivery_stream.main]
// snippet-end:[firehose.php.put_record_delivery_stream.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[PutRecordtoDeliveryStream.php demonstrates how to send data through Amazon Kinesis Data Firehose Delivery Streams to your specified destination. After you create a Delivery Stream, use DescribeDeliveryStream to see if the Delivery Stream is active before sending data to it.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon Kinesis Data Firehose]
// snippet-service:[firehose]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-12-27]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

