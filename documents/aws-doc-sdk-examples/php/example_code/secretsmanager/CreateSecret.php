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
 *  https://docs.aws.amazon.com/kms/latest/developerguide/programming-key-policies.html
 *
 */
// snippet-start:[secretsmanager.php.create_secret.complete]
// snippet-start:[secretsmanager.php.create_secret.import]

require 'vendor/autoload.php';

use Aws\SecretsManager\SecretsManagerClient; 
use Aws\Exception\AwsException;
// snippet-end:[secretsmanager.php.create_secret.import]

/**
 * Create a new secret in an AWS Secret Manager Secret. 
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */

//Create a Secrets Manager Client 
// snippet-start:[secretsmanager.php.create_secret.main]
$client = new SecretsManagerClient([
    'profile' => 'default',
    'version' => '2017-10-17',
    'region' => 'us-west-2'
]);

$secretName = '<<{{MySecretName}}>>';
$secret = '{"username":"<<USERNAME>>","password":"<<PASSWORD>>"}';
$description = '<<Description>>';

try {
    $result = $client->createSecret([
        'Description' => $description,
        'Name' => $secretName,
        'SecretString' => $secret,
    ]);
    var_dump($result);
} catch (AwsException $e) {
    // output error message if fails
    echo $e->getMessage();
    echo "\n";
}
 
// snippet-end:[secretsmanager.php.create_secret.main]
// snippet-end:[secretsmanager.php.create_secret.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[CreateSecret.php demonstrates how to create a new secret in AWS Secrets Manager.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[AWS Secrets Manager]
// snippet-service:[secretsmanager]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-11-08]
// snippet-sourceauthor:[jschwarzwalder (AWS)]