# snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
# snippet-sourceauthor:[Doug-AWS]
# snippet-sourcedescription:[Updates the items in a DynamoDB table with a new attribute.]
# snippet-keyword:[Amazon DynamoDB]
# snippet-keyword:[table method]
# snippet-keyword:[table.scan method]
# snippet-keyword:[table.update_item method]
# snippet-keyword:[Ruby]
# snippet-sourcesyntax:[ruby]
# snippet-service:[dynamodb]
# snippet-keyword:[Code Sample]
# snippet-sourcetype:[full-example]
# snippet-sourcedate:[2018-03-16]
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

require 'aws-sdk-dynamodb'  # v2: require 'aws-sdk'

dynamoDB = Aws::DynamoDB::Resource.new(region: 'us-west-2')

table = dynamoDB.table('Users')

# Get the IDs of all of the users
resp = table.scan({ select: "ALL_ATTRIBUTES" })

resp.items.each do |item|
  id = item['ID']
  
  request = {
    key: { 'ID' => id },
    update_expression: 'set airmiles=:pVal',
    expression_attribute_values: { ':pVal' => '10000' }
  }

  # Update the item in the table:
  table.update_item(request)
end
