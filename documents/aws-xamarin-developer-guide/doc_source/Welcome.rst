.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

==========================
What is the |sdk-xamarin|?
==========================

The |sdk-xamarin| provides a set of .NET libraries, code samples, and documentation to help
developers build connected mobile applications for:

* Xamarin iOS
* Xamarin Android
* Windows Phone Silverlight
* Windows RT 8.1
* Windows Phone 8.1

Mobile apps written using the |sdk-xamarin| call native platform APIs so they have the look and feel
of native applications. The .NET libraries in the SDK provide C# wrappers around the AWS REST APIs.

What's included in the |sdk-xamarin|?
=====================================

Supported AWS services currently include, but are not limited to:

* `Amazon Cognito`_
* `Amazon S3`_
* `Amazon DynamoDB`_
* `Amazon Mobile Analytics`_
* `Amazon Simple Notification Service`_

These services enable you to authenticate users, save player and game data, save objects in the
cloud, receive push notifications, and collect and analyze usage data.

The |sdk-xamarin| also allows you to use most of the AWS services supported by the AWS SDK for .NET.
The AWS services specific to mobile development are explained in this developer guide. For more
information about the AWS SDK for .NET, see:

* `AWS SDK for .NET Getting Started Guide <https://docs.aws.amazon.com/AWSSdkDocsNET/latest/DeveloperGuide/net-dg-setup.html>`_
* `AWS SDK for .NET Developer Guide <http://docs.aws.amazon.com/AWSSdkDocsNET/latest/V3/DeveloperGuide/welcome.html>`_
* `AWS SDK for .NET API Reference <http://docs.aws.amazon.com/sdkfornet/latest/apidocs/Index.html>`_

Compatability
=============

The |sdk-xamarin| is shipped as a Portable Class Library (PCL). PCL Support was added in
Xamarin.Android 4.10.1, Xamarin.iOS 7.0.4 and Xamarin Studio 4.2. Portable Library projects are
automatically enabled in Xamarin Studio on OS X, and are built in to Visual Studio 2013.

IDEs
----

- **Windows**: You can use either Visual Studio or Xamarin Studio to develop your application.

- **Mac**: You must use the Xamarin Studio IDE to develop your applications. iOS development using
  Xamarin requires access to a Mac to run your app. For more information, see `Installing
  Xamarin.iOS on Windows
  <http://developer.xamarin.com/guides/ios/getting_started/installation/windows>`_.

How do I get the |sdk-xamarin|?
===============================

To get the |sdk-xamarin|, see :doc:`setup`. The |sdk-xamarin| is distributed as NuGet packages. You
can find a complete list of AWS service packages at `AWS SDK packages on NuGet
<https://www.nuget.org/packages?q=awssdk&page=1>`_ or at the AWS SDK for .NET `Github Repository
<https://github.com/aws/aws-sdk-net#nuget-packages>`_.

About the AWS Mobile Services
=============================

.. _xamarin-welcome-cognito-identity:

Amazon Cognito Identity
-----------------------

All calls made to AWS require AWS credentials. Rather than hard-coding your credentials into your
apps, we recommend that you use `Amazon Cognito Identity
<http://docs.aws.amazon.com/cognito/devguide/identity/>`_ to provide AWS credentials to your
application. Follow the instructions in :doc:`setup` to obtain AWS credentials via Amazon Cognito.

Cognito also allows you to authenticate users using public log-in providers like Amazon, Facebook,
Twitter, and Google as well as providers that support `OpenID Connect`_. Cognito also works with
unauthenticated users. Cognito provides temporary credentials with limited access rights that you
specify with an `Identity and Access Management`_ (IAM) role. Cognito is configured by creating an
identity pool that is associated with an IAM role. The IAM role specifies the resources/services
your app may access.

To get started with Cognito Identity, see :doc:`setup`.

To learn more about Cognito Identity, see :doc:`cognito-identity`.

Amazon Cognito Sync
-------------------

Cognito Sync is an AWS service and client library that enables cross-device syncing of
application-related user data. You can use the Cognito Sync API to synchronize user profile data
across devices and across login providers - Amazon, Facebook, Google, and your own custom identity
provider.

To get started with Cognito Sync, see :doc:`getting-started-sync-data`.

For more information about Cognito Sync, see :doc:`cognito-sync`.

Mobile Analytics
----------------

Amazon Mobile Analytics lets you collect, visualize, and understand app usage for your mobile apps.
Reports are available for metrics on active users, sessions, retention, in-app revenue, and custom
events, and can be filtered by platform and date range. Amazon Mobile Analytics is built to scale
with your business and can collect and process billions of events from many millions of endpoints.

To get started using Mobile Analytics, see :doc:`getting-started-analytics`.

For more information about Mobile Analytics, see :doc:`analytics`.

Dynamo DB
---------

Amazon DynamoDB is a fast, highly scalable, highly available, cost-effective, non-relational
database service. DynamoDB removes traditional scalability limitations on data storage while
maintaining low latency and predictable performance.

To get started using Dynamo DB, see :doc:`getting-started-store-retrieve-data`.

For more information about Dynamo DB, see :doc:`dynamodb`.

Amazon Simple Notification Service
----------------------------------

Amazon Simple Notification Service (SNS) is a fast, flexible, fully managed push notification
service that lets you send individual messages or to fan-out messages to large numbers of
recipients. Amazon Simple Notification Service makes it simple and cost effective to send push
notifications to mobile device users, email recipients or even send messages to other distributed
services.

To get started using SNS for Xamarin iOS, see :doc:`getting-started-sns-ios`.

To get started using SNS for Xamarin Android, see :doc:`getting-started-sns-android`.

For more information about SNS, see :doc:`sns`.

.. _Identity and Access Management: http://aws.amazon.com/iam
.. _Amazon Cognito: http://aws.amazon.com/cognito
.. _AWS Console: https://console.aws.amazon.com
.. _Amazon S3: http://aws.amazon.com/s3/
.. _Amazon DynamoDB: http://aws.amazon.com/dynamodb/
.. _Amazon Mobile Analytics: http://aws.amazon.com/mobileanalytics/
.. _Amazon Simple Notification Service: http://aws.amazon.com/sns/
.. _AWS Mobile SDK: http://aws.amazon.com/mobile/sdk/
.. _Amazon Cognito Developer Guide: http://docs.aws.amazon.com/cognito/devguide/identity/?platform=xamarin
.. _Identity and Access Management: http://aws.amazon.com/iam
.. _OpenID Connect: http://aws.amazon.com/blogs/aws/openid-connect-support/

