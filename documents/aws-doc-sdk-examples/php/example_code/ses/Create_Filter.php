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
 * ABOUT THIS PHP SAMPLE => This sample is part of the SDK for PHP Developer Guide topic at
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/ses-filters.html
 *
 */
// snippet-start:[ses.php.create_filter.complete]
// snippet-start:[ses.php.create_filter.import]

require 'vendor/autoload.php';

use Aws\Ses\SesClient; 
use Aws\Exception\AwsException;
// snippet-end:[ses.php.create_filter.import]

//Create a SESClient 
// snippet-start:[ses.php.create_filter.main]
$SesClient = new Aws\Ses\SesClient([
    'profile' => 'default',
    'version' => '2010-12-01',
    'region' => 'us-east-2'
]);

$filter_name = 'FilterName';
$ip_address_range = '10.0.0.1/24';

try {
    $result = $SesClient->createReceiptFilter([
        'Filter' => [
            'IpFilter' => [
                'Cidr' => $ip_address_range,
                'Policy' => 'Block|Allow',
            ],
            'Name' => $filter_name,
        ],
    ]);
    var_dump($result);
} catch (AwsException $e) {
    // output error message if fails
    echo $e->getMessage();
    echo "\n";
}
 
 
// snippet-end:[ses.php.create_filter.main]
// snippet-end:[ses.php.create_filter.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[Create_Filter.php demonstrates how to allow or block emails from a specific IP address.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon Simple Email Service]
// snippet-service:[ses]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-09-20]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

