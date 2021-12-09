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
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/ec2-examples-using-security-groups.html
 *
 *
 *
 */
// snippet-start:[ec2.php.delete_security_group.complete]
// snippet-start:[ec2.php.delete_security_group.import]

require 'vendor/autoload.php';

use Aws\Ec2\Ec2Client;
// snippet-end:[ec2.php.delete_security_group.import]
/**
 * Delete a Security Group
 *
 * This code expects that you have AWS credentials set up per:
 * https://docs.aws.amazon.com/sdk-for-php/v3/developer-guide/guide_credentials.html
 */
 
// snippet-start:[ec2.php.delete_security_group.main]
$ec2Client = new Aws\Ec2\Ec2Client([
    'region' => 'us-west-2',
    'version' => '2016-11-15',
    'profile' => 'default'
]);

$securityGroupId = 'my-security-group-id';

$result = $ec2Client->deleteSecurityGroup(array(
    'GroupId' => $securityGroupId
));

var_dump($result);
 
 
// snippet-end:[ec2.php.delete_security_group.main]
// snippet-end:[ec2.php.delete_security_group.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[DeleteSecurityGroup.php demonstrates how to delete an Amazon EC2 security group.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon EC2]
// snippet-service:[ec2]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-12-27]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

