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
 *
 */
// snippet-start:[cloudwatchevents.php.test_event_pattern.complete]
// snippet-start:[cloudwatchevents.php.test_event_pattern.import]

require 'vendor/autoload.php';

use Aws\CloudWatchEvents\CloudWatchEventsClient; 
use Aws\Exception\AwsException;
// snippet-end:[cloudwatchevents.php.test_event_pattern.import]

/**
 * Test event pattern
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */
 
// snippet-start:[cloudwatchevents.php.test_event_pattern.main]
$client = new Aws\cloudwatchevents\cloudwatcheventsClient([
    'profile' => 'default',
    'region' => 'us-west-2',
    'version' => '2015-10-07'
]);

$exampleEvent = '{
  "version": "0",
  "id": "6a7e8feb-b491-4cf7-a9f1-bf3703467718",
  "detail-type": "EC2 Instance State-change Notification",
  "source": "aws.ec2",
  "account": "111122223333",
  "time": "2015-12-22T18:43:48Z",
  "region": "us-east-2",
  "resources": [
    "arn:aws:ec2:us-east-2:123456789012:instance/i-12345678"
  ],
  "detail": {
    "instance-id": "i-12345678",
    "state": "terminated"
  }
}';

$exampleEventPattern = '{
  "source": [ "aws.ec2" ],
  "detail-type": [ "EC2 Instance State-change Notification" ],
  "detail": {
    "state": [ "terminated" ]
  }
}';

try {
    $result = $client->testEventPattern([
        'Event' => $exampleEvent,
        'EventPattern' => $exampleEventPattern
    ]);
    var_dump($result);
} catch (AwsException $e) {
    // output error message if fails
    error_log($e->getMessage());
}
 
 
// snippet-end:[cloudwatchevents.php.test_event_pattern.main]
// snippet-end:[cloudwatchevents.php.test_event_pattern.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[TestEventPattern.php demonstrates how to test whether the specified event pattern matches the provided event.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon CloudWatch Events]
// snippet-service:[events]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-12-27]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

