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
 *  ABOUT THIS PHP SAMPLE: This sample is part of the SDK for PHP Developer Guide topic
 *
 *
 */
// snippet-start:[sns.php.get_topic_attributes.complete]
// snippet-start:[sns.php.get_topic_attributes.import]
require 'vendor/autoload.php';

use Aws\Sns\SnsClient; 
use Aws\Exception\AwsException;
// snippet-end:[sns.php.get_topic_attributes.import]

/**
 * Retrieve the message delivery status attributes for an Amazon SNS Topic.
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */
 
// snippet-start:[sns.php.get_topic_attributes.main]
$SnSclient = new SnsClient([
    'profile' => 'default',
    'region' => 'us-east-1',
    'version' => '2010-03-31'
]);

$topic = 'arn:aws:sns:us-east-1:111122223333:MyTopic';

try {
    $result = $SnSclient->getTopicAttributes([
        'TopicArn' => $topic,
    ]);
    var_dump($result);
} catch (AwsException $e) {
    // output error message if fails
    error_log($e->getMessage());
} 
// snippet-end:[sns.php.get_topic_attributes.main]
// snippet-end:[sns.php.get_topic_attributes.complete]
// snippet-sourcedescription:[GetTopicAttributes.php demonstrates how to retrieve the defaults for an AWS SNS Topic.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon Simple Notification Service]
// snippet-service:[sns]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-09-20]
// snippet-sourceauthor:[jschwarzwalder]