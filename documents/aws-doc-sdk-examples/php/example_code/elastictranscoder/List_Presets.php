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
 *  ABOUT THIS PHP SAMPLE: This sample is part of the Elastic Transcoder Developer Guide topic at
 *  https://docs.aws.amazon.com/elastictranscoder/latest/developerguide/introduction.html
 *
 */
// snippet-start:[elastictranscoder.php.list_presets.complete] 
// snippet-start:[elastictranscoder.php.list_presets.import] 
// Path to your PHP autoload.  If you are using a phar installation, this is the
// path to your aws.phar file.
require 'vendor/autoload.php';

use Aws\ElasticTranscoder\ElasticTranscoderClient;
use Aws\Exception\AwsException;
// snippet-end:[elastictranscoder.php.list_presets.import]  

/**
 * List preset for an Elastic Transcoder job.
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */
// Create the client for Elastic Transcoder.
// snippet-start:[elastictranscoder.php.list_presets.main] 
$transcoder_client = new ElasticTranscoderClient([
    'profile' => 'default',
    'region' => 'us-east-2',
    'version' => '2012-09-25',
]);

try {
    $result = $transcoder_client -> listPresets([]);
    var_dump($result);
} catch (AwsException $e) {
    // output error message if fails
    echo $e->getMessage() . "\n";
}
// snippet-end:[elastictranscoder.php.list_presets.main]
// snippet-end:[elastictranscoder.php.list_presets.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[List_Presets.php demonstrates how to list available presets for Elastic Transcoder Jobs.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[listPresets]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon Elastic Transcoder]
// snippet-service:[elastictranscoder]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[]
// snippet-sourceauthor:[AWS]

?>
