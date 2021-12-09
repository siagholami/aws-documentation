.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

.._cognito-identity:

=======================
Amazon Cognito Identity
=======================

What is Amazon Cognito Identity?
================================

Amazon Cognito Identity enables you to create unique identities for your users and authenticate them
with identity providers. With an identity, you can obtain temporary, limited-privilege AWS
credentials to synchronize data with Amazon Cognito Sync, or directly access other AWS services.
Amazon Cognito Identity supports public identity providers—Amazon, Facebook, and Google—as well as
unauthenticated identities. It also supports developer authenticated identities, which let you
register and authenticate users via your own backend authentication process.

For more information on Cognito Identity, see the `Amazon Cognito Developer Guide
<https://docs.aws.amazon.com/cognito/devguide/identity/>`_.

For information about Cognito Authentication Region availability, see `AWS Service Region
Availability <http://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/>`_.

Using a Public Provider to Authenticate Users
---------------------------------------------

Using Amazon Cognito Identity, you can create unique identities for your users and authenticate them
for secure access to your AWS resources like Amazon S3 or Amazon DynamoDB. Amazon Cognito Identity
supports public identity providers |mdash| Amazon, Facebook, Twitter/Digits, Google, or any OpenID
Connect-compatible provider |mdash| as well as unauthenticated identities.

For information on using public identity providers like Amazon, Facebook, Twitter/Digits, or Google
to authenticate users, see the `External Providers
<http://docs.aws.amazon.com/cognito/devguide/identity/external-providers/>`_ in the Amazon Cognito
Developer Guide.

Using Developer Authenticated Identities
----------------------------------------

Amazon Cognito supports developer authenticated identities, in addition to web identity federation
through Facebook, Google, and Amazon. With developer authenticated identities, you can register and
authenticate users via your own existing authentication process, while still using
:doc:`cognito-sync` to synchronize user data and access AWS resources. Using developer authenticated
identities involves interaction between the end user device, your backend for authentication, and
Amazon Cognito.

For information on developer authenticated identities, see the `Developer Authenticated Identities
<https://docs.aws.amazon.com/cognito/devguide/identity/developer-authenticated-identities/>`_ in the
Amazon Cognito Developer Guide.

