.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. _aws-ruby-sdk-s3-example-encrypt-bucket-items

############################
Encrypting |S3| Bucket Items
############################

.. meta::
    :description:
        Encrypt Amazon S3 bucket items using these AWS SDK for Ruby code examples.
    :keywords: AWS SDK for Ruby code examples

Amazon S3 supports encrypting Amazon S3 bucket objects on both the client and the server.
To encrypt objects on the client, you perform the encryption yourself,
either using keys that you create or keys that AWS Key Management Service (AWS KMS) manages for you.

To encrypt objects on the server, you have more options.

* You can have Amazon S3 automatically encrypt objects as you upload
  them to a bucket. Once you configure a bucket with this option,
  every object that you upload--from that point on--is encrypted.

* You can have Amazon S3 encrypt an object when you upload it to a bucket.
  The disadvantage with this approach is that you can still upload objects that
  are not encrypted.

* You can have Amazon S3 encrypt an object when you upload it to a bucket.
  The disadvantage with this approach is that you can still upload objects that
  are not encrypted.

The following examples describe these options,
from the simplest example of specifying that all objects uploaded to a bucket
are automatically encrypted, to the most complex example of using asymmetric
public and private keys on the client.
Don't worry, we'll explain these concepts as we go.
Learn about encryption in |S3| at
`Protecting Data Using Encryption <http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingEncryption.html>`_.

.. toctree::
   :maxdepth: 1

   s3-example-server-encryption
   s3-example-client-encryption
