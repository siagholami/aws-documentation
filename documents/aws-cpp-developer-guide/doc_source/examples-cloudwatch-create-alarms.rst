.. Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: cpp

########################
Working with |CW| Alarms
########################

.. meta::
   :description: How to manage alarms in Amazon CloudWatch using the AWS SDK for C++.
   :keywords: cloudwatch

.. include:: includes/examples-note.txt

Create an Alarm
===============

To create an alarm based on a |cw| metric, call the |cwclient|'s :functionname:`PutMetricAlarm`
function with a :aws-cpp-class:`PutMetricAlarmRequest
<aws_1_1_cloud_watch_1_1_model_1_1_put_metric_alarm_request>` filled with the alarm conditions.

**Includes**

.. literalinclude:: cw.cpp.put_metric_alarm.inc.txt

**Code**

.. literalinclude:: cw.cpp.put_metric_alarm.code.txt
   :dedent: 8

See the :sdk-examples-cpp:`complete example <cloudwatch/put_metric_alarm.cpp>`.


List Alarms
===========

To list the |cw| alarms that you have created, call the |cwclient|'s :functionname:`DescribeAlarms`
function with a :aws-cpp-class:`DescribeAlarmsRequest
<aws_1_1_cloud_watch_1_1_model_1_1_describe_alarms_request>` that you can use to set options for the
result.

**Includes**

.. literalinclude:: cw.cpp.describe_alarms.inc.txt

**Code**

.. literalinclude:: cw.cpp.describe_alarms.code.txt
   :dedent: 8

The list of alarms can be obtained by calling :functionname:`getMetricAlarms` on the
:aws-cpp-class:`DescribeAlarmsResult <aws_1_1_cloud_watch_1_1_model_1_1_describe_alarms_result>`
that is returned by :functionname:`DescribeAlarms`.

The results may be *paged*. To retrieve the next batch of results, call :functionname:`SetNextToken`
on the original request object with the return value of the :classname:`DescribeAlarmsResult`
object's :functionname:`GetNextToken` function, and pass the modified request object back to another
call to :functionname:`DescribeAlarms`.

.. tip:: You can also retrieve alarms for a specific metric by using the |cwclient|'s
   :functionname:`DescribeAlarmsForMetric` function. Its use is similar to
   :functionname:`DescribeAlarms`.

See the :sdk-examples-cpp:`complete example <cloudwatch/describe_alarms.cpp>`.


Delete Alarms
=============

To delete |cw| alarms, call the |cwclient|'s :functionname:`DeleteAlarms` function with a
:aws-cpp-class:`DeleteAlarmsRequest <aws_1_1_cloud_watch_1_1_model_1_1_delete_alarms_request>`
containing one or more names of alarms that you want to delete.

**Includes**

.. literalinclude:: cw.cpp.delete_alarm.inc.txt

**Code**

.. literalinclude:: cw.cpp.delete_alarm.code.txt
   :dedent: 8

See the :sdk-examples-cpp:`complete example <cloudwatch/delete_alarm.cpp>`.


More Information
================

* :cw-ug:`Creating Amazon CloudWatch Alarms <AlarmThatSendsEmail>` in the |cw-ug|
* :cw-api:`PutMetricAlarm` in the |cw-api|
* :cw-api:`DescribeAlarms` in the |cw-api|
* :cw-api:`DeleteAlarms` in the |cw-api|

