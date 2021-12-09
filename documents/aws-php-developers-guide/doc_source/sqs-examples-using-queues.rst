.. Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.


####################################################
Using Queues in |SQS| with AWS SDK for PHP version 3 
####################################################

.. meta::
   :description: Create or delete Amazon SQS queues, and return lists and URLs for queues using the AWS SDK for PHP version 3.
   :keywords: Amazon SQS code examples for PHP

To learn about |SQS| queues, see :SQS-dg:`How SQS Queues Work <sqs-how-it-works>`.

The following examples show how to:

* Return a list of your queues using :aws-php-class:`ListQueues <api-sqs-2012-11-05.html#listqueues>`.
* Create a new queue using :aws-php-class:`CreateQueue <api-sqs-2012-11-05.html#createqueue>`.
* Return the URL of an existing queue using :aws-php-class:`GetQueueUrl <api-sqs-2012-11-05.html#getqueueurl>`.
* Delete a specified queue using :aws-php-class:`DeleteQueue <api-sqs-2012-11-05.html#deletequeue>`.

.. include:: text/git-php-examples.txt

Return a List of Queues
=======================

**Imports**

.. literalinclude:: sqs.php.list_queues.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: sqs.php.list_queues.main.txt
   :language: PHP



Create a Queue
==============

**Imports**

.. literalinclude:: sqs.php.create_queue.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: sqs.php.create_queue.main.txt
   :language: PHP


Return the URL of a Queue
=========================

**Imports**

.. literalinclude:: sqs.php.get_queue_url.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: sqs.php.get_queue_url.main.txt
   :language: PHP


Delete a Queue
==============

**Imports**

.. literalinclude:: sqs.php.delete_queue.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: sqs.php.delete_queue.main.txt
   :language: PHP


