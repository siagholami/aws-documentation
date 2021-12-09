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
 */
// snippet-start:[ses.php.send_raw_email.complete]
// snippet-start:[ses.php.send_raw_email.import]
require 'vendor/autoload.php';

use PHPMailer\PHPMailer\PHPMailer;
use Aws\Ses\SesClient;
use Aws\Ses\Exception\SesException;
// snippet-end:[ses.php.send_raw_email.import]

// snippet-start:[ses.php.send_raw_email.main]
// Replace sender@example.com with your "From" address.
// This address must be verified with Amazon SES.
$sender = 'sender@example.com';
$sendername = 'Sender Name';

// Replace recipient@example.com with a "To" address. If your account
// is still in the sandbox, this address must be verified.
$recipient = 'recipient@example.com';

// Specify a configuration set.
$configset = 'ConfigSet';

$subject = 'List of customers to contact';

$htmlbody = <<<EOD
<html>
<head></head>
<body>
<h1>Hello!</h1>
<p>Please see the attached file for a list of customers to contact.</p>
</body>
</html>
EOD;

$textbody = <<<EOD
Hello,
Please see the attached file for a list of customers to contact.
EOD;

// The full path to the file that will be attached to the email.
$att = 'path/to/customers-to-contact.xlsx';

// Create an SesClient.
$client = new SesClient([
    'profile' => 'default',
    'region' => 'us-west-2',
    'version' => '2010-12-01'
]);

// Create a new PHPMailer object.
$mail = new PHPMailer;

// Add components to the email.
$mail->setFrom($sender, $sendername);
$mail->addAddress($recipient);
$mail->Subject = $subject;
$mail->Body = $htmlbody;
$mail->AltBody = $textbody;
$mail->addAttachment($att);
$mail->addCustomHeader('X-SES-CONFIGURATION-SET', $configset);

// Attempt to assemble the above components into a MIME message.
if (!$mail->preSend()) {
    echo $mail->ErrorInfo;
} else {
    // Create a new variable that contains the MIME message.
    $message = $mail->getSentMIMEMessage();
}

// Try to send the message.
try {
    $result = $client->sendRawEmail([
        'RawMessage' => [
            'Data' => $message
        ]
    ]);
    // If the message was sent, show the message ID.
    $messageId = $result->get('MessageId');
    echo("Email sent! Message ID: $messageId" . "\n");
} catch (SesException $error) {
    // If the message was not sent, show a message explaining what went wrong.
    echo("The email was not sent. Error message: "
        . $error->getAwsErrorMessage() . "\n");
} 
// snippet-end:[ses.php.send_raw_email.main]
// snippet-end:[ses.php.send_raw_email.complete]
// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourcedescription:[Send_Raw_Email.php demonstrates how to use the Amazon SES SendRawEmail operation to send highly customized messages to your recipients.]
// snippet-keyword:[PHP]
// snippet-sourcesyntax:[php]
// snippet-keyword:[AWS SDK for PHP v3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[Amazon Simple Email Service]
// snippet-service:[ses]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-09-20]
// snippet-sourceauthor:[jschwarzwalder (AWS)]

