.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

==========================================
Best Practices for Using the |sdk-xamarin|
==========================================

There are only a few fundamentals and best practices that are helpful to know when using the
|sdk-xamarin|.

* Use Amazon Cognito to obtain AWS credentials instead of hardcoding your credentials in your
  application. If you hard code your credentials in your application, you may end up exposing them
  to the public, allowing others to make calls to AWS using your credentials. For instructions on
  how to use Amazon Cognito to obtain AWS credentials, see :doc:`setup`.

* For best practices on using S3, see `this article on the AWS Blog
  <https://aws.amazon.com/articles/1904>`_.

* For best practices on using DynamoDB, see `DynamoDB Best Practices
  <https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/BestPractices.html>`_ in the
  DynamoDB Developer Guide.

We are always looking to help our customers be successful and welcome feedback, so please feel free
to `post on the AWS forums <https://forums.aws.amazon.com/forum.jspa?forumID=88>`_ or `open an issue
on Github <https://github.com/awslabs/aws-sdk-xamarin/issues>`_.

Library of AWS Service Documentation
====================================

Every service in the |sdk-xamarin| has a separate developer guide and service API reference which
provides additional information that you might find helpful.

Amazon Cognito Identity
-----------------------

- `Cognito Developer Guide <https://docs.aws.amazon.com/cognito/devguide/>`_
- `Cognito Identity Service API Reference <https://docs.aws.amazon.com/cognitoidentity/latest/APIReference/Welcome.html>`_

Amazon Cognito Sync
-------------------

- `Cognito Developer Guide <https://docs.aws.amazon.com/cognito/devguide/>`_
- `Cognito Sync Service API Reference <https://docs.aws.amazon.com/cognitosync/latest/APIReference/Welcome.html>`_

Amazon Mobile Analytics
-----------------------

- `Mobile Analytics Developer Guide <https://docs.aws.amazon.com/mobileanalytics/latest/ug/set-up.html>`_
- `Mobile Analytics Service API Reference <https://docs.aws.amazon.com/mobileanalytics/latest/ug/server-reference.html>`_

Amazon S3
---------

- `S3 Developer Guide <https://docs.aws.amazon.com/AmazonS3/latest/dev/Welcome.html>`_
- `S3 Getting Started Guide <https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html>`_
- `S3 Service API Reference <https://docs.aws.amazon.com/AmazonS3/latest/API/Welcome.html>`_

Amazon DynamoDB
---------------

- `DynamoDB Developer Guide <https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html>`_
- `DynamoDB Getting Started Guide <https://docs.aws.amazon.com/amazondynamodb/latest/gettingstartedguide/Welcome.html>`_
- `DynamoDB Service API Reference <https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/Welcome.html>`_

Amazon Simply Notification Service (SNS)
----------------------------------------

- `SNS Developer Guide <https://docs.aws.amazon.com/sns/latest/dg/welcome.html>`_
- `SNS Service API Reference <https://docs.aws.amazon.com/sns/latest/api/Welcome.html>`_

Other Helpful Links
===================

* `AWS Glossary of Terms <https://docs.aws.amazon.com/general/latest/gr/glos-chap.html>`_
* `About AWS Credentials <https://docs.aws.amazon.com/general/latest/gr/aws-security-credentials.html>`_
