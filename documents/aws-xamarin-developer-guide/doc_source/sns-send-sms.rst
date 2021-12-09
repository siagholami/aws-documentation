.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

==================================
Send and Receive SMS Notifications
==================================

You can use Amazon Simple Notification Service (Amazon SNS) to send and receive Short Message
Service (SMS) notifications to SMS-enabled mobile phones and smart phones.

.. note:: SMS notifications are currently supported for phone numbers in the United States. SMS
   messages can be sent only from topics created in the US East (N. Virginia) region. However, you
   can publish messages to topics that you create in the US East (N. Virginia) region from any other
   region.

Create a Topic
==============

To create a topic:

1. In the Amazon SNS console, click **Create new topic**. The Create new topic dialog box appears.

2. In the Topic name box, type a topic name.

3. In the Display name box, type a display name. The topic must have a display name assigned to it
   because the first ten (10) characters of the display name are used as the initial part of the
   text message prefix. The display name you enter will appear in the confirmation message that SNS
   sends to the user (the display name below is "AMZN SMS").

  .. image:: images/sns-display-name.png

4. Click **Create topic**. The new topic appears in the Topics page.

5. Select the new topic and then click the topic ARN. The Topic Details page appears.

6. Copy the topic ARN, as you will need it when you subscribe to a topic in the next step.

   ::

     arn:aws:sns:us-west-2:111122223333:MyTopic

Subscribe to a Topic Using the SMS Protocol
===========================================

Create an SNS client, passing your credentials object and the region of your identity pool::

  var snsClient = new AmazonSimpleNotificationServiceClient(credentials, region);

To subscribe to a topic, invoke :code:`SubscribeAsync` and pass it the ARN of the topic that you
want to subscribe to, the protocol ("sms"), and the phone number::

  var response = await snsClient.SubscribeAsync(topicArn, "sms", "1234567890");

You will receive a subscribe arn in the subscribe response object. Your subscribe arn looks like
this::

  arn:aws:sns:us-west-2:123456789012:MyTopic:6b0e71bd-7e97-4d97-80ce-4a0994e55286

When a device subscribes to a topic, SNS will send a confirmation message to the device, and the
user will have to confirm that they want to receive notifications, as shown below:

.. image:: images/sns-subscribe.png

After the user subscribes to the topic, they will receive SMS messages when you publish them to that
topic.

Publish a Message
=================

To publish a message to a topic:

1. Sign in to the AWS Management Console and open the `Amazon SNS console
   <https://console.aws.amazon.com/sns/>`_.

2. In the left navigation pane, click **Topics** and then select the topic you want to publish to.

3. Click **Publish to topic**.

4. In the Subject box, type a subject.

5. In the Message box, type a message. Amazon SNS sends text that you enter in the Message box to
   SMS subscribers unless you also enter text into the Subject box. Because Amazon SNS includes a
   display name prefix with all SMS messages that you send, the sum of the display name prefix and
   the message payload cannot exceed 140 ASCII characters or 70 Unicode characters. Amazon SNS
   truncates messages that exceed these limits.

6. Click **Publish message**. Amazon SNS displays a confirmation dialog box. The SMS message appears
   on your SMS-enabled device, as shown below.

   .. image:: images/sns-publish.png
