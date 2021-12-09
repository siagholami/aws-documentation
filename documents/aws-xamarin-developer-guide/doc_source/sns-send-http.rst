.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

#####################################
Send Messages to HTTP/HTTPS Endpoints
#####################################

You can use Amazon SNS to send notification messages to one or more HTTP or HTTPS endpoints. The
process is as follows:

1. Configure your endpoint to receive Amazon SNS messages.

2. Subscribe an HTTP/HTTPS endpoint to a topic.

3. Confirm your subscription.

4. Publish a notification to the topic. Amazon SNS then sends an HTTP POST request delivering the
   contents of the notification to the subscribed endpoint.


Configure Your HTTP/HTTPS Endpoint to Receive Amazon SNS Messages
=================================================================

Follow the instructions in Step 1 of `Sending Amazon SNS Messages to HTTP/HTTPS Endpoints
<http://docs.aws.amazon.com/sns/latest/dg/SendMessageToHttp.html#SendMessageToHttp.prepare>`_ to
configure your endpoint.


Subscribe Your HTTP/HTTPS endpoint to Your Amazon SNS Topic
===========================================================

Create an SNS client, passing your credentials object and the region of your identity pool::

  var snsClient = new AmazonSimpleNotificationServiceClient(credentials, region);

To send messages to an HTTP or HTTPS endpoint through a topic, you must subscribe the endpoint to
the Amazon SNS topic. You specify the endpoint using its URL::

  var response = await snsClient.SubscribeAsync(
    "topicArn",
    "http",  /* "http" or "https" */
    "endpointUrl" /* endpoint url beginning with http or https */
  );

Confirm Your Subscription
=========================

After you subscribe to an endpoint, Amazon SNS will send a subscription confirmation message to the
endpoint. The code at the endpoint must retrieve the :code:`SubscribeURL` value from the
subscription confirmation message and either visit the location specified by the
:code:`SubscribeURL` itself or make it available to you so that you can manually visit the
:code:`SubscribeURL` (for example, if using a web browser).

Amazon SNS will not send messages to the endpoint until the subscription is confirmed. When you
visit the :code:`SubscribeURL`, the response will contain an XML document containing an element
:code:`SubscriptionArn` that specifies the ARN for the subscription.

Send Messages to the HTTP/HTTPS Endpoint
========================================

You can send a message to a topic's subscriptions by publishing to the topic. Invoke
:code:`PublishAsync` and pass it the topic ARN and your message.

::

  var response = await snsClient.PublishAsync(topicArn, "This is your message");
