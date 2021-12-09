# snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
# snippet-sourceauthor:[Doug-AWS]
# snippet-sourcedescription:[Lists your IAM users, creates an IAM user, updates the user's name, and deletes the user.]
# snippet-keyword:[AWS Identity and Access Management]
# snippet-keyword:[create_user method]
# snippet-keyword:[delete_user method]
# snippet-keyword:[list_users method]
# snippet-keyword:[update_user method]
# snippet-keyword:[Ruby]
# snippet-sourcesyntax:[ruby]
# snippet-service:[iam]
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

# Demonstrates how to:
# 1. Get information about available AWS IAM users.
# 2. Create a user.
# 3. Update the user's name.
# 4. Delete the user.

require 'aws-sdk-iam'  # v2: require 'aws-sdk'

iam = Aws::IAM::Client.new(region: 'us-east-1')

user_name = "my-user"
changed_user_name = "my-changed-user"

# Get information about available AWS IAM users.
def list_user_names(iam)
  list_users_response = iam.list_users
  list_users_response.users.each do |user|
    puts user.user_name
  end
end

puts "User names before creating user..."
list_user_names(iam)

# Create a user.
puts "\nCreating user..."

iam.create_user({ user_name: user_name })

puts "\nUser names after creating user..."
list_user_names(iam)

# Update the user's name.
puts "\nChanging user's name..."

begin
  iam.update_user({
    user_name: user_name,
    new_user_name: changed_user_name
  })

  puts "\nUser names after updating user's name..."
  list_user_names(iam)
rescue Aws::IAM::Errors::EntityAlreadyExists
  puts "User '#{user_name}' already exists."
end

# Delete the user.
puts "\nDeleting user..."
iam.delete_user({ user_name: changed_user_name })

puts "\nUser names after deleting user..."
list_user_names(iam)
