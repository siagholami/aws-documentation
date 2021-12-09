.. Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.


####################################################
Sending Events to |CWElong| with |sdk-php| Version 3
####################################################

.. meta::
   :description: Create rules and add targets to them, and send custom events to Amazon CloudWatch Events using the AWS SDK for PHP version 3.
   :keywords: Amazon CloudWatch code examples for PHP

|CWE| delivers a near real-time stream of system events that describe changes in |AWSlong| (AWS) resources to any of various targets. Using simple rules, you can match events and route them to one or more target functions or streams.

The following examples show how to:

* Create a rule using :aws-php-class:`PutRule <api-events-2015-10-07.html#putrule>`.
* Add targets to a rule using :aws-php-class:`PutTargets <api-events-2015-10-07.html#puttargets>`.
* Send custom events to |CWE| using :aws-php-class:`PutEvents <api-events-2015-10-07.html#putevents>`.

.. include:: text/git-php-examples.txt

Create a Rule
=============

**Imports**

.. literalinclude:: cloudwatchevents.php.put_rule.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: cloudwatchevents.php.put_rule.main.txt
   :language: PHP

Add Targets to a Rule
=====================

**Imports**

.. literalinclude:: cloudwatchevents.php.put_target.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: cloudwatchevents.php.put_target.main.txt
   :language: PHP

Send Custom Events
==================

**Imports**

.. literalinclude:: cloudwatchevents.php.put_events.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: cloudwatchevents.php.put_events.main.txt
   :language: PHP
