# snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
# snippet-sourceauthor:[Doug-AWS]
# snippet-sourcedescription:[Creates RSA public and private keys.]
# snippet-keyword:[RSA]
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


require 'openssl'

public_key = 'public_key.pem'
private_key = 'private_key.pem'
pass_phrase = 'Mary had a little lamb'

key = OpenSSL::PKey::RSA.new(1024)

# public key
open public_key, 'w' do |io| io.write key.public_key.to_pem end

cipher = OpenSSL::Cipher.new 'AES-128-CBC'

key_secure = key.export cipher, pass_phrase

# private key protected by pass phrase
open private_key, 'w' do |io|
  io.write key_secure
end

puts 'Saved public key to  ' + public_key
puts 'Saved private key to ' + private_key
