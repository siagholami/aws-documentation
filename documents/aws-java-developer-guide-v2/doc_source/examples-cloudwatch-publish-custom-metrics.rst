.. Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

##########################
Publish custom metric data
##########################

.. meta::
   :description: How to publish your own custom metric data to Amazon Cloudwatch using the AWS SDK
                 for Java 2.x.
   :keywords: Amazon Cloudwatch, AWS SDK for Java, custom metrics, AWS SDK for Java 2.x, code examples


A number of AWS services publish :cw-ug:`their own metrics <aws-namespaces>` in namespaces beginning
with "AWS/" You can also publish custom metric data using your own namespace (as long as it doesn't
begin with "AWS/").

Publish custom metric data
==========================

To publish your own metric data, call the |cwclient|'s :methodname:`putMetricData` method with a
:aws-java-class:`PutMetricDataRequest <services/cloudwatch/model/PutMetricDataRequest>`. The
:classname:`PutMetricDataRequest` must include the custom namespace to use for the data, and
information about the data point itself in a :aws-java-class:`MetricDatum
<services/cloudwatch/model/MetricDatum>` object.

.. note:: You cannot specify a namespace that begins with "AWS/". Namespaces that begin with
   "AWS/" are reserved for use by Amazon Web Services products.

**Imports**

.. literalinclude:: cloudwatch.java2.put_metric_data.import.txt
   :language: java

**Code**

.. literalinclude:: cloudwatch.java2.put_metric_data.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-cloudwatch:`complete example <PutMetricData.java>` on GitHub.

More information
================

* :cw-ug:`Using Amazon CloudWatch Metrics <working_with_metrics>` in the |cw-ug|.
* :cw-ug:`AWS Namespaces <aws-namespaces>` in the |cw-ug|.
* :cw-api:`PutMetricData <API_PutMetricData>` in the |cw-api|.
