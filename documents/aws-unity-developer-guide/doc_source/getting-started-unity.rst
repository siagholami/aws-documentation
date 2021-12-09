.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

.. _getting-started-unity:

#################################################
Getting Started with the AWS Mobile SDK for Unity
#################################################

This page provides you with an overview of each AWS service in the AWS Mobile SDK for Unity, as well
as instructions on how to set up Unity samples. You must complete all of the instructions on the
:doc:`setup-unity` page before you start using the services below.

.. _unity-getting-started-cognito-identity:

Amazon Cognito Identity
=======================

All calls made to AWS require AWS credentials. Rather than hard-coding your credentials into your
apps, we recommend that you use `Amazon Cognito Identity
<http://docs.aws.amazon.com/cognito/devguide/identity/>`_ to provide AWS credentials to your
application. Follow the instructions in :doc:`setup-unity` to obtain AWS credentials via Amazon
Cognito.

Cognito also allows you to authenticate users using public log-in providers like Amazon, Facebook,
Twitter, and Google as well as providers that support `OpenID Connect`_. Cognito also works with
unauthenticated users. Cognito provides temporary credentials with limited access rights that you
specify with an `Identity and Access Management`_ (IAM) role. Cognito is configured by creating a
new Identity Pool that is associated with an IAM role. The IAM role specifies the resources/services
your app may access.

To get started with Cognito Identity, see the `Amazon Cognito Developer Guide`_.

Amazon Cognito Sync
===================

`Cognito Sync <http://docs.aws.amazon.com/cognito/devguide/sync/?platform=unity>`_ makes it easy for
you to save end users data such as user preferences or game state to the AWS Cloud so that it can be
made available to users regardless of the device that they are using. Cognito can also save this
data locally, allowing your apps to work even when an internet connection is not available. When an
internet connection becomes available, your apps can sync their local data to the cloud.

To get started with Cognito Sync, see the `Amazon Cognito Developer Guide`_.

Using the CognitoSyncManager sample
-----------------------------------

In the :guilabel:`Project` pane, navigate to
:guilabel:`Assets`/:guilabel:`AWSSDK`/:guilabel:`examples`/:guilabel:`CognitoSync`, and in the
right-hand side of the pane select the :guilabel:`CognitoSync` scene to open the scene.

To run the sample click the play button at the top of the editor screen. When the app runs it
displays a few text boxes and buttons that allow you to enter some player information. Below this,
there are a series of buttons that save the player info locally, sync the local player info with the
Cognito Cloud, refresh player info from the Cognito Cloud, and delete the local player info. Press
each button to perform an operation. The sample displays feedback on the top of the game screen.

To configure the CognitoSyncManager sample, you must specify a Cognito Identity Pool ID. To specify
this value, in the Unity editor, select :guilabel:`SyncManager` in the :guilabel:`Heirarchy` pane,
and enter it into the :guilabel:`IDENTITY_POOL_ID` text box in the :guilabel:`Inspector Pane`.

.. note:: The CognitoSyncManager sample contains code that illustrates how use the Facebook identity
   Provider, search for the "USE_FACEBOOK_LOGIN" macro. This requires use of the Facebook SDK for
   Unity. For more information, see `Facebook SDK for Unity
   <https://developers.facebook.com/docs/unity/>`_.

Dynamo DB
=========

`Amazon DynamoDB <http://aws.amazon.com/dynamodb/>`_ is a fast, highly scalable, highly available,
cost-effective, non-relational database service. DynamoDB removes traditional scalability
limitations on data storage while maintaining low latency and predictable performance.

The AWS SDK for Unity provides both low-level and high-level libraries for working with DynamoDB.
The high-level library includes the DynamoDB Object Mapper, which lets you map client-side classes
to DynamoDB tables; perform various create, read, update, and delete (CRUD) operations; and execute
queries. Using the DynamoDB Object Mapper, you can write simple, readable code that stores objects
in the cloud.

For more information about DynamoDB, see `DynamoDB Developer Guide
<http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Introduction.html>`_.

For more information about using Dynamo DB from Unity Applications, see :doc:`dynamodb`.

Using the DynamoDB Sample
-------------------------

In the :guilabel:`Project` pane, navigate to
:guilabel:`Assets`/:guilabel:`AWSSDK/`:guilabel:`examples`/:guilabel:`DynamoDB`. This sample is
composed of the following scenes:

- DynamoDBExample - the initial scene of the app
- LowLevelDynamoDbExample - example using low-level DynamoDBD API
- TableQueryAndScanExample - example showing how to perform queries
- HighLevelExample - example using high-level DynamoDB API

Add these scenes into the build (in the order they appear above) by using the Build Settings dialog
(open by selecting File.Build Settings). This sample create four tables: ProductCatalog, Forum,
Thread, Reply.

To run the sample click the play button at the top of the editor screen. When the app runs it
displays a number of buttons:

- Low Level Table Operations - illustrates how to create, list, update, describe, and delete tables.
- Mid Level Query & Scan Operations - illustrates how to perform queries.
- High Level Object Mapper - illustrates how to create, update, and delete objects.

Mobile Analytics
================

Using `Amazon Mobile Analytics <http://aws.amazon.com/mobileanalytics/>`_, you can track customer
behaviors, aggregate metrics, generate data visualizations, and identify meaningful patterns. The
AWS SDK for Unity provides integration with the Amazon Mobile Analytics service. For information
about Mobile Analytics, see `Mobile Analytics User Guide
<http://docs.aws.amazon.com/mobileanalytics/latest/ug/welcome.html>`_. For more information about
using Mobile Analytics from Unity Applications, see :doc:`analytics`.

Configuring Mobile Analytics
----------------------------

Mobile Analytics defines some settings that can be configured in the awsconfig.xml file::

    <mobileAnalytics sessionTimeout = "5"
                     maxDBSize = "5242880"
                     dbWarningThreshold = "0.9"
                     maxRequestSize = "102400"
                     allowUseDataNetwork = "false"/>

- sessionTimeout - This the time interval after an application goes to background and when session
  can be terminated.

- maxDBSize - This is the size of the SQLIte Database. When the database reaches the maximum size,
  any additional events are dropped.

- dbWarningThreshold - This is the limit on the size of the database which, once reached, will
  generate warning logs.

- maxRequestSize - This is the maximum size of the request in Bytes that should be transmitted in an
  HTTP request to the mobile analytics service.

- allowUseDataNetwork - A boolean that specifies if the session events are sent on the data network.

Using the Mobile Analytics Sample
----------------------------------

In the :guilabel:`Project` pane, navigate to
:guilabel:`Assets`/:guilabel:`AWSSDK/`:guilabel:`examples`/:guilabel:`Mobile Analytics`, and in the
right-hand side of the pane select the :guilabel:`Amazon Mobile Analytics Sample` scene to open the
scene. To use the sample, you need to add your app using the `Amazon Mobile Analytics console
<https://console.aws.amazon.com/mobileanalytics/home>`_. For more information about using the Mobile
Analytics console, see `Amazon Mobile Analytics User Guide
<http://docs.aws.amazon.com/mobileanalytics/latest/ug/set-up.html>`_.

Follow these steps to configure the sample before running:

#. Select the AmazonMobileAnalyticsSample game object.

#. Specify your App Id (created in the `Amazon Mobile Analytics console
   <https://console.aws.amazon.com/mobileanalytics/home>`_) in the "App Id" field.

#. Specify your Cognito Identity Pool Id (created using the `Amazon Cognito console at
   <https://console.aws.amazon.com/cognito/home>`_) in the "Cognito Identity Pool Id" field.

#. Ensure your authenticated and unauthenticated roles have permissions to access the Mobile
   Analytics service. For more information about applying policy to IAM Roles see, `Managing Roles
   <http://docs.aws.amazon.com/IAM/latest/UserGuide/roles-managingrole-editing.html#roles-managingrole-editing-console>`_.

When running the sample application, be aware that events may not be transmitted to the backend
service immediately. A background thread will buffer events locally and send them in batches to the
Amazon Mobile Analytics backend at a regular interval (the default value is 60 seconds) to ensure
your game’s performance is not adversely impacted.  Due to the complex processing Amazon Mobile
Analytics performs on your data, submitted events and corresponding reports may not be visible in
the AWS console until up to 60 minutes after initial submission.

For more information on the reports provided by Amazon Mobile Analytics, see `Report and Mobile
Metrics`_.

Amazon S3
=========

Amazon Simple Storage Service (Amazon S3), provides developers and IT teams with secure, durable,
highly-scalable object storage. From Unity you can use S3 to store, list, and retrieve images,
videos, music, and other data used by your games.

For more information about S3, see `Amazon S3`_ and `Getting Started with S3`_.

For more information about using S3 from Unity applications, see :doc:`s3`.

Configuring the S3 Default Signature
------------------------------------

The default S3 signature is configured as follows:
::

    <s3 useSignatureVersion4="true" />

This is used to specify if you should use signature version 4 for S3 requests.

Using the S3 Sample
-------------------

In the :guilabel:`Project` pane, navigate to
:guilabel:`Assets`/:guilabel:`AWSSDK`/:guilabel:`examples`/:guilabel:`S3`, and in the right-hand
side of the pane select the :guilabel:`S3Example` scene to open the scene. The sample illustrates
how to list buckets, list objects within a bucket, post objects to a bucket and download objects
from a bucket. Follow these steps to configure the sample before running:

 #. Select the :guilabel:`S3` game object in the :guilabel:`Hierarchy` pane.

 #. In the :guilabel:`Inspector` pane enter values for :guilabel:`S3BucketName` and
    :guilabel:`SampleFileName`. S3BucketName is the name of the bucket used by the sample and
    S3SampleFileName is the name of the file the sample will upload into the specified S3 bucket.

 #. Ensure your authenticated and unauthenticated roles have permissions to access the S3 buckets in
    your account. For more information about applying policy to IAM Roles see, `Managing Roles
    <http://docs.aws.amazon.com/IAM/latest/UserGuide/roles-managingrole-editing.html#roles-managingrole-editing-console>`_.

To run the sample click the play button at the top of the editor screen. When the app runs it
displays a number of buttons:

- Get Objects - Gets a list of all objects in all buckets in your AWS account.
- Get Buckets - Gets a list of all buckets in your AWS account.
- Post Object - Uploads an object to a specified S3 bucket.
- Delete Object - Deletes all object from a specified S3 bucket.

The sample displays feedback on the top of the game screen.

Amazon Simple Notification Service
==================================

Amazon Simple Notification Service is a fast, flexible, fully managed push notification service that
lets you send individual messages or to fan-out messages to large numbers of recipients. Amazon
Simple Notification Service makes it simple and cost effective to send push notifications to mobile
device users, email recipients or even send messages to other distributed services. To get started
with Amazon Simple Notification Service, see :doc:`sns`.

AWS Lambda
==========

AWS Lambda is a compute service that runs your code in response to requests or events and
automatically manages the compute resources for you, making it easy to build applications that
respond quickly to new information. AWS Lambda functions can be called directly from mobile, IoT,
and Web apps and sends a response back synchronously, making it easy to create scalable, secure, and
highly available backends for your mobile apps without the need to provision or manage
infrastructure.  For more information, see :doc:`lambda`.

.. _Amazon Cognito Developer Guide: http://docs.aws.amazon.com/cognito/devguide/identity/?platform=unity
.. _Identity and Access Management: http://aws.amazon.com/iam
.. _Amazon Cognito: http://aws.amazon.com/cognito
.. _AWS Console: https://console.aws.amazon.com
.. _Cognito Console: https://console.aws.amazon.com/cognito
.. _Amazon S3: http://aws.amazon.com/s3/
.. _OpenID Connect: http://aws.amazon.com/blogs/aws/openid-connect-support/
.. _Facebook SDK for Unity: https://developers.facebook.com/docs/unity/
.. _Getting Started with S3: http://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html
.. _Amazon Mobile Analytics: http://aws.amazon.com/mobileanalytics/
.. _Report and Mobile Metrics: https://aws.amazon.com/mobileanalytics/faqs/#report-and-metric-details
