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
 * If you need more information about configurations or implementing the sample code, visit the AWS docs:
 * https://aws.amazon.com/developers/getting-started/php/
 *
 */
// snippet-start:[secretsmanager.php.get_secret_value.complete]
// snippet-start:[secretsmanager.php.get_secret_value.import]

require 'vendor/autoload.php';

use Aws\SecretsManager\SecretsManagerClient; 
use Aws\Exception\AwsException;
// snippet-end:[secretsmanager.php.get_secret_value.import]

/**
 * In this sample we only handle the specific exceptions for the 'GetSecretValue' API.
 * See https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
 * We rethrow the exception by default.
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */

// Create a Secrets Manager Client 
// snippet-start:[secretsmanager.php.get_secret_value.main]
$client = new SecretsManagerClient([
    'profile' => 'default',
    'version' => '2017-10-17',
    'region' => '<<{{MyRegionName}}>>',
]);

$secretName = '<<{{MySecretName}}>>';

try {
    $result = $client->getSecretValue([
        'SecretId' => $secretName,
    ]);

} catch (AwsException $e) {
    $error = $e->getAwsErrorCode();
    if ($error == 'DecryptionFailureException') {
        // Secrets Manager can't decrypt the protected secret text using the provided AWS KMS key.
        // Handle the exception here, and/or rethrow as needed.
        throw $e;
    }
    if ($error == 'InternalServiceErrorException') {
        // An error occurred on the server side.
        // Handle the exception here, and/or rethrow as needed.
        throw $e;
    }
    if ($error == 'InvalidParameterException') {
        // You provided an invalid value for a parameter.
        // Handle the exception here, and/or rethrow as needed.
        throw $e;
    }
    if ($error == 'InvalidRequestException') {
        // You provided a parameter value that is not valid for the current state of the resource.
        // Handle the exception here, and/or rethrow as needed.
        throw $e;
    }
    if ($error == 'ResourceNotFoundException') {
        // We can't find the resource that you asked for.
        // Handle the exception here, and/or rethrow as needed.
        throw $e;
    }
}
// Decrypts secret using the associated KMS CMK.
// Depending on whether the secret is a string or binary, one of these fields will be populated.
if (isset($result['SecretString'])) {
    $secret = $result['SecretString'];
} else {
    $secret = base64_decode($result['SecretBinary']);
}

// Your code goes here; 
 
// snippet-end:[secretsmanager.php.get_secret_value.main]
// snippet-end:[secretsmanager.php.get_secret_value.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[GetSecretValue demonstrates how to retrieve a secret from AWS Secrets Manager]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[AWS Secrets Manager]
// snippet-service:[secretsmanager]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-09-25]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

