.. Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

#####################################################
Managing Topics in |SNS| with the |sdk-php| Version 3
#####################################################

.. meta::
   :description: How to  create, list, and delete Amazon SNS topics, and how to handle topic attributes using the AWS SDK for PHP version 3.
   :keywords: Amazon SNS topics for PHP

To send notifications to |SQSlong| (|SQS|), HTTP/HTTPS URLs, email, |SMS|, or |LAMlong|, you must first create a topic that manages the delivery of messages to any subscribers of that topic.

In terms of the observer design pattern, a topic is like the subject. After a topic is created, you add subscribers that are notified automatically when a message is published to the topic.

Learn more about subscribing to topics in :doc:`sns-examples-subscribing-unsubscribing-topics`.


The following examples show how to:

* Create a topic to publish notifications to using :aws-php-class:`CreateTopic <api-sns-2010-03-31.html#createtopic>`.
* Return a list of the requester's topics using :aws-php-class:`ListTopics <api-sns-2010-03-31.html#listtopic>`.
* Delete a topic and all of its subscriptions using :aws-php-class:`DeleteTopic <api-sns-2010-03-31.html#deletetopic>`.
* Return all of the properties of a topic using :aws-php-class:`GetTopicAttributes <api-sns-2010-03-31.html#gettopicattributes>`.
* Allow a topic owner to set an attribute of the topic to a new value using :aws-php-class:`SetTopicAttributes <api-sns-2010-03-31.html#settopicattributes>`.

For more information about using |SNS|, see :SNS-dg:`Amazon SNS Topic Attributes for Message Delivery Status <sns-topic-attributes>`.


.. include:: text/git-php-examples.txt


Create a Topic
==============
To create a topic, use the :SNS-api:`CreateTopic <API_CreateTopic>` operation.

Each topic name in your AWS account must be unique.

**Imports**

.. literalinclude:: sns.php.create_topic.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: sns.php.create_topic.main.txt
   :language: PHP

List Your Topics
================

To list up to 100 existing topics in the current AWS Region, use the :SNS-api:`ListTopics <API_ListTopics>` operation.

**Imports**

.. literalinclude:: sns.php.list_topics.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: sns.php.list_topics.main.txt
   :language: PHP

Delete a Topic
==============

To remove an existing topic and all of its subscriptions, use the :SNS-api:`DeleteTopic <API_DeleteTopic>` operation.

Any messages that have not been delivered yet to subscribers will also be deleted.

**Imports**

.. literalinclude:: sns.php.delete_topic.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: sns.php.delete_topic.main.txt
   :language: PHP
   
Get Topic Attributes
====================

To retrieve properties of a single existing topic, use the :SNS-api:`GetTopicAttributes <API_GetTopicAttributes>` operation.

**Imports**

.. literalinclude:: sns.php.get_topic_attributes.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: sns.php.get_topic_attributes.main.txt
   :language: PHP

Set Topic Attributes
====================

To update properties of a single existing topic, use the :SNS-api:`SetTopicAttributes <API_SetTopicAttributes>` operation.

You can set only the :code:`Policy`, :code:`DisplayName`, and :code:`DeliveryPolicy` attributes.

**Imports**

.. literalinclude:: sns.php.set_topic_attributes.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: sns.php.set_topic_attributes.main.txt
   :language: PHP
