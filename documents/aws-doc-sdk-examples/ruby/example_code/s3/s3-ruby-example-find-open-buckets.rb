# snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
# snippet-sourceauthor:[Doug-AWS]
# snippet-sourcedescription:[Finds the S3 buckets open to the public.]
# snippet-keyword:[Amazon Simple Storage Service]
# snippet-keyword:[list_account_aliases method]
# snippet-keyword:[Ruby]
# snippet-sourcesyntax:[ruby]
# snippet-service:[s3]
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

require 'aws-sdk-iam'
require 'aws-sdk-s3'

client = Aws::IAM::Client.new()
iam = Aws::IAM::Resource.new(client: client)

resp = client.list_account_aliases({})

arn_parts = iam.current_user.arn.split(':')
account = arn_parts[4]

if resp.account_aliases == nil || resp.account_aliases[0] == nil
  puts 'Open buckets for account ' + account
else
  puts 'Open buckets for account ' + account + ' (' + resp.account_aliases[0] + '):'
end

puts

s3 = Aws::S3::Resource.new(region: 'us-west-2')

bucket_count = 0

s3.buckets.each do |b|
  begin
    grants = b.acl.grants

    grants.each do |g|
      if g.grantee.display_name == nil && g.permission == 'READ'
        puts '  ' + b.name
        bucket_count += 1
        break
      end
    end
  rescue StandardError
    puts 'Got error'
  end
end

puts
puts "Found #{bucket_count} open bucket(s) out of #{s3.buckets.count}"
