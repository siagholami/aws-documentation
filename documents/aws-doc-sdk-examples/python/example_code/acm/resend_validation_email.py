# Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License"). You
# may not use this file except in compliance with the License. A copy of
# the License is located at
#
# http://aws.amazon.com/apache2.0/
#
# or in the "license" file accompanying this file. This file is
# distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF
# ANY KIND, either express or implied. See the License for the specific
# language governing permissions and limitations under the License. 
# snippet-start:[acm.python.resend_validation.complete]

import boto3


# Create ACM client
acm = boto3.client('acm')

# Resend validation email for one of the Subject or SANs of an ACM certificate.
response = acm.resend_validation_email(
    CertificateArn='arn:aws:acm:us-east-1:123456789012:certificate/12345678-1234-1234-1234-123456789012',
    Domain='*.subdomain1.example.com',
    ValidationDomain='example.com'
)

print(response)


 
 
# snippet-end:[acm.python.resend_validation.complete]
# snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
# snippet-sourcedescription:[resend_validation_email.py demonstrates how to resend the email that requests domain ownership validation.]
# snippet-keyword:[Python]
# snippet-sourcesyntax:[python]
# snippet-sourcesyntax:[python]
# snippet-keyword:[AWS SDK for Python (Boto3)]
# snippet-keyword:[Code Sample]
# snippet-keyword:[AWS Certificate Manager]
# snippet-service:[acm]
# snippet-sourcetype:[full-example]
# snippet-sourcedate:[2018-12-26]
# snippet-sourceauthor:[walkerk1980]

