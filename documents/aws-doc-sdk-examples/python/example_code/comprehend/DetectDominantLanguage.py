# snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
# snippet-sourcedescription:[DetectDominantLanguage.py demonstrates how to determine the dominant language used in text,.]
# snippet-service:[comprehend]
# snippet-keyword:[Amazon Comprehend]
# snippet-keyword:[Python]
# snippet-sourcesyntax:[python]
# snippet-sourcesyntax:[python]
# snippet-keyword:[Code Sample]
# snippet-sourcetype:[full-example]
# snippet-sourcedate:[2019-01-31]
# snippet-sourceauthor:[AWS]

# Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
#
# This file is licensed under the Apache License, Version 2.0 (the "License").
# You may not use this file except in compliance with the License. A copy of the
# License is located at
#
# http://aws.amazon.com/apache2.0/
#
# This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
# OF ANY KIND, either express or implied. See the License for the specific
# language governing permissions and limitations under the License.

# snippet-start:[comprehend.python.DetectDominantLanguage.complete]

import boto3
import json

comprehend = boto3.client(service_name='comprehend', region_name='region')
text = 'It is raining today in Seattle'

print('Calling DetectDominantLanguage')
print(json.dumps(comprehend.detect_dominant_language(Text=text),
                 sort_keys=True, indent=4))
print('End of DetectDominantLanguage\n')

# snippet-end:[comprehend.python.DetectDominantLanguage.complete]
