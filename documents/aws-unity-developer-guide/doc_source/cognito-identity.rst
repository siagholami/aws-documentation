.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

.. _cognito-identity:

#######################
Amazon Cognito Identity
#######################

What is Amazon Cognito Identity?
================================

Using Amazon Cognito Identity, you can create unique identities for your users and authenticate them
for secure access to your AWS resources like Amazon S3 or Amazon DynamoDB. Amazon Cognito Identity
supports public identity providers |mdash| Amazon, Facebook, Twitter/Digits, Google, or any OpenID
Connect-compatible provider |mdash| as well as unauthenticated identities. Cognito also supports
developer authenticated identities, which let you register and authenticate users using your own
backend authentication process, while still using `Amazon Cognito Sync
<http://docs.aws.amazon.com/cognito/latest/developerguide/cognito-sync.html>`_ to synchronize user
data and access AWS resources.

For more information on Cognito Identity, see the `Amazon Cognito Developer Guide
<https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-identity.html>`_.

For information about Cognito Authentication Region availability, see  `Amazon Cognito Identity
Region Availability
<http://docs.aws.amazon.com/general/latest/gr/rande.html#cognito_identity_region>`_.

Using a Public Provider to Authenticate Users
---------------------------------------------

For information on using public identity providers like Amazon, Facebook, Twitter/Digits, or Google
to authenticate users, see the `External Providers
<http://docs.aws.amazon.com/cognito/latest/developerguide/external-identity-providers.html>`_ in the
Amazon Cognito Developer Guide.

Using Developer Authenticated Identities
----------------------------------------

For information on developer authenticated identities, see the `Developer Authenticated Identities
<https://docs.aws.amazon.com/cognito/latest/developerguide/developer-authenticated-identities.html>`_
in the Amazon Cognito Developer Guide.
