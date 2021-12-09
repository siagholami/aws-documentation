.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

========================================
Amazon Simple Notification Service (SNS)
========================================

Using SNS and the |sdk-xamarin|, you can write applications that can receive mobile push
notifications. For information about SNS, see `Amazon Simple Notification Service`_.

Key Concepts
============

Amazon SNS allows applications and end-users on different devices to receive notifications via
Mobile Push notification (Apple, Google and Kindle Fire Devices), HTTP/HTTPS, Email/Email-JSON, SMS
or Amazon Simple Queue Service (SQS) queues, or AWS Lambda functions. SNS lets you send individual
messages or to fan-out messages to large numbers of recipients subscribed to a single topic.

Topics
------

A topic is an “access point” for allowing recipients to dynamically subscribe for identical copies
of the same notification. One topic can support deliveries to multiple endpoint types -- for
example, you can group together iOS, Android and SMS recipients.

Subscriptions
-------------

To receive messages published to a topic, you have to subscribe an endpoint to that topic. An
endpoint is a mobile app, web server, email address, or an Amazon SQS queue that can receive
notification messages from Amazon SNS. Once you subscribe an endpoint to a topic and the
subscription is confirmed, the endpoint will receive all messages published to that topic.

Publishing
----------

When you publish to a topic, SNS delivers appropriately formatted copies of your message to each
subscriber of that topic. For Mobile Push Notifications, you can publish directly to the endpoint or
subscribe the endpoint to a topic.

Project Setup
=============

Prerequisites
-------------

To use SNS in your application, you'll need to add the SDK to your project. To do so, follow the
instructions in :doc:`setup`.

Set Permissions for SNS
~~~~~~~~~~~~~~~~~~~~~~~

For information on setting permissions for SNS, see `Managing Access to Your Amazon SNS Topics
<https://docs.aws.amazon.com/sns/latest/dg/AccessPolicyLanguage.html>`_.

Add NuGet Package for SNS to Your Project
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Follow Step 4 of the instructions in :doc:`setup` to add the Amazon Simple Notification Service
NuGet package to your project.

Integrating SNS with Your Application
=====================================

There are many ways to interact with SNS in your Xamarin application:

.. toctree::
  :maxdepth: 1

  sns-send-push-notifications-android
  sns-send-push-notifications-ios
  sns-send-sms
  sns-send-http
  sns-troubleshooting

.. _Amazon Simple Notification Service: http://aws.amazon.com/sns/
