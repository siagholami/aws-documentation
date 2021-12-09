# snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
# snippet-sourcedescription:[list_findings_with_criteria.py lists Amazon GuardDuty detector findings.]
# snippet-service:[guardduty]
# snippet-keyword:[Amazon GuardDuty]
# snippet-keyword:[Python]
# snippet-sourcesyntax:[python]
# snippet-sourcesyntax:[python]
# snippet-keyword:[Code Sample]
# snippet-sourcetype:[snippet]
# snippet-sourcedate:[2018-12-25]
# snippet-sourceauthor:[walkerk1980]

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

# snippet-start:[guardduty.python.list_findings_with_criteria.complete]

import boto3

# Create GuardDuty client
gd = boto3.client('guardduty')

# Get the GuardDuty Detector for the current AWS Region
detector = gd.list_detectors()
detectorid = detector['DetectorIds'][0]

# Finding Criteria for severity in this example must be greater than or
# equal to the value specified in Gte
fc = {'Criterion': {'severity': {'Gte': 4}}}

# Finding Criteria for type in this example can be equal to either of the
# two values specified in Eq
fc = {'Criterion': {'type': {'Eq': ['Recon:EC2/PortProbeUnprotectedPort',
                                    'Recon:EC2/Portscan']}}}

findings = gd.list_findings(DetectorId=detectorid,FindingCriteria=fc)

# Print out each finding
for finding in findings['FindingIds']:
    find_detail = gd.get_findings(DetectorId=detectorid, FindingIds=[finding])
    print(f'{find_detail}\n')

# snippet-end:[guardduty.python.list_findings_with_criteria.complete]
