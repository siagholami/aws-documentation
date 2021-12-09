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
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/cw-examples-sending-events.html
 *
 *
 *
 */
// snippet-start:[cloudwatchevents.php.put_rule.complete]
// snippet-start:[cloudwatchevents.php.put_rule.import]

require 'vendor/autoload.php';

use Aws\CloudWatchEvents\CloudWatchEventsClient; 
use Aws\Exception\AwsException;
// snippet-end:[cloudwatchevents.php.put_rule.import]

/**
 * Put Rule
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */
 
// snippet-start:[cloudwatchevents.php.put_rule.main]
$client = new Aws\cloudwatchevents\cloudwatcheventsClient([
    'profile' => 'default',
    'region' => 'us-west-2',
    'version' => '2015-10-07'
]);

try {
    $result = $client->putRule(array(
        'Name' => 'DEMO_EVENT', // REQUIRED
        'RoleArn' => 'IAM_ROLE_ARN',
        'ScheduleExpression' => 'rate(5 minutes)',
        'State' => 'ENABLED',
    ));
    var_dump($result);
} catch (AwsException $e) {
    // output error message if fails
    error_log($e->getMessage());
}
 
 
// snippet-end:[cloudwatchevents.php.put_rule.main]
// snippet-end:[cloudwatchevents.php.put_rule.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[PutRule.php demonstrates how to create or update the specified rule. Rules are enabled by default, or based on value of the state. You can disable a rule using DisableRule.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon CloudWatch Events]
// snippet-service:[events]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-09-20]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

