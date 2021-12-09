.. Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

######
|SDKM| 
######

|SDKMlong| (|SDKM|\) enables Enterprise customers to collect metrics from AWS SDKs on their hosts and clients shared with 
AWS Enterprise Support. SDK Metrics provides information that helps speed up detection and diagnosis of issues occurring in connections 
to AWS services for AWS Enterprise Support customers. 

As telemetry is collected on each host, it is relayed via UDP to 127.0.0.1 (AKA localhost), where the |CW| Agent aggregates the data and sends it 
to the |SDKM| service. Therefore, to receive metrics, the |CW| Agent is required to be added to your instance.

The following steps to set up |SDKM| pertain to an |EC2| instance running Amazon Linux for a client application that is using the |sdk-cpp|.
|SDKM| is also available for your production environments if you enable it while configuring the |sdk-cpp|. 

To utilize |SDKM|, run the latest version of the |CW| agent. Learn how to 
:CW-dg:`Configure the CloudWatch Agent for SDK Metrics<Configure-CloudWatch-Agent-SDK-Metrics>` in the |CW-dg|.

To set up |SDKM| with the |sdk-cpp|, follow these instructions:

#. Install the latest version of the |sdk-cpp|.
#. Host your project on an |EC2| instance or in your local environment.
#. Create an application with an |sdk-cpp| client to use an AWS service.
#. Install and configure a |CW| agent on an EC2 instance or in your local environment.
#. Authorize |SDKM| to Collect and Send Metrics 
#. :ref:`csm-enable-agent`

For more information, see the following:

* :ref:`csm-update-agent`
* :ref:`csm-disable-agent`


.. _csm-enable-agent:

Enable |SDKM| for the |sdk-cpp|
====================================

By default, |SDKM| uses port 31000 and is disabled.

.. code-block:: ini

    //default values
     [
         'enabled' => false,
         'port' => 31000,
     ]

Enabling |SDKM| is independent of configuring your credentials to use an AWS service.

You can enable |SDKM| by setting environment variables or by using the AWS Shared config file.

Option 1: Set Environment Variables
------------------------------------

If :code:`AWS_CSM_ENABLED` is not set, the SDK checks the profile specified in the environment variable under :code:`AWS_PROFILE` to determine if SDK Metrics is enabled. By default this is set to ``false``.

To turn on |SDKM|, add the following to your environmental variables.

.. code-block:: ini

    export AWS_CSM_ENABLED=true

:ref:`Other configuration settings<csm-update-agent>` are available. 

Note: Enabling |SDKM| does not configure your credentials to use an AWS service. 


Option 2: AWS Shared Config File
---------------------------------

If no CSM configuration is found in the environment variables, the SDK looks for your default AWS profile field. If :code:`AWS_DEFAULT_PROFILE` is set to something other than default, update that profile. To enable SDK Metrics, add :code:`csm_enabled` to the shared config file located at :file:`~/.aws/config`.

.. code-block:: ini

    [default]
    csm_enabled = true

    [profile aws_csm]
    csm_enabled = true

:ref:`Other configuration settings<csm-update-agent>` are available. 

Note: Enabling SDK Metrics is independent from configuring your credentials to use an AWS service. You can use a different profile to authenticate. 

.. _csm-update-agent:

Update a |CW| Agent
===================

To make changes to the port, you need to set the values and then restart any AWS jobs that are currently active.

Option 1: Set Environment Variables
------------------------------------

Most services use
the default port. But if your service requires a unique port ID, add `AWS_CSM_PORT=[port_number]`, to the host's environment variables.

.. code-block:: shell

    export AWS_CSM_ENABLED=true
    export AWS_CSM_PORT=1234


Option 2: AWS Shared Config File
---------------------------------

Most services use the default port. But if your service requires a
unique port ID, add `csm_port = [port_number]` to `~/.aws/config`.

.. code-block:: ini

    [default]
    csm_enabled = false
    csm_port = 1234

    [profile aws_csm]
    csm_enabled = false
    csm_port = 1234

Restart |SDKM|
--------------

To restart a job, run the following commands.

.. code-block:: shell

    amazon-cloudwatch-agent-ctl –a stop;
    amazon-cloudwatch-agent-ctl –a start;


.. _csm-disable-agent:

Disable |SDKM|
==============

To turn off |SDKM|, set `csm_enabled` to `false` in your environment variables, or in your AWS Shared config file located at :file:`~/.aws/config`.
Then restart your |CW| agent so that the changes can take effect.

**Environment Variables**

.. code-block:: shell

    export AWS_CSM_ENABLED=false


**AWS Shared Config File**

Remove `csm_enabled` from the profiles in your AWS Shared config file located at :file:`~/.aws/config`.

.. note:: Environment variables override the AWS Shared config file. If |SDKM| is enabled in the environment variables, the |SDKM| remains enabled.

.. code-block:: ini

    [default]
    csm_enabled = false

    [profile aws_csm]
    csm_enabled = false

To disable |SDKM|, use the following command to stop |CW| Agent. 

.. code-block:: shell

    sudo /opt/aws/amazon-cloudwatch-agent/bin/amazon-cloudwatch-agent-ctl -a stop &&
    echo "Done"
    
If you are using other |CW| features, restart |CW| Agent with the following command.

.. code-block:: shell

    amazon-cloudwatch-agent-ctl –a start;
    

Restart |SDKM|
--------------

To restart a |SDKM| job, run the following commands.

.. code-block:: shell

    amazon-cloudwatch-agent-ctl –a stop;
    amazon-cloudwatch-agent-ctl –a start;

Definitions for |SDKM|
======================

You can use the following descriptions of |SDKM| to interpret your results. In general, these metrics are available for review
with your Technical Account Manager during regular business reviews. AWS Support resources and your Technical Account Manager 
should have access to SDK Metrics data to help you resolve cases, but if you discover data that is confusing or unexpected, but 
doesn’t seem to be negatively impacting your applications’ performance, it is best to review that data during scheduled 
business reviews.

.. list-table:: Metrics
   :header-rows: 1

   * - Metric
     - Definition
     - How to use it
   * - CallCount
     - Total number of successful or failed API calls from your code to AWS services
     - Use it as a baseline to correlate with other metrics like errors or throttling.
   * - ClientErrorCount
     - Number of API calls that fail with client errors (4xx HTTP response codes).
       Examples: Throttling, Access denied, S3 bucket does not exist, and Invalid parameter value.
     - Except in certain cases related to throttling
       (ex. when throttling occurs due to a limit that needs to be increased)
       this metric can indicate something in your application that needs to be fixed.
   * - ConnectionErrorCount
     - Number of API calls that fail because of errors connecting to the service.
       These can be caused by network issues between the customer application
       and AWS services including load balancers, DNS failures, transit providers.
       In some cases, AWS issues may result in this error.
     - Use this metric to determine whether issues are specific to your application
       or are caused by your infrastructure and/or network.
       High ConnectionErrorCount could also indicate short timeout values for API calls.
   * - EndToEndLatency
     - Total time for your application to make a call using the AWS SDK,
       inclusive of retries.
       In other words, regardless of whether it is successful after several attempts,
       or as soon as a call fails due to an unretriable error.
     - Determine how AWS API calls contribute to your application's overall latency.
       Higher than expected latency may be caused by issues with network, firewall,
       or other configuration settings, or by latency that occurs as a result of SDK retries.
   * - ServerErrorCount
     - Number of API calls that fail due to server errors (5xx HTTP response codes) from AWS Services.
       These are typically caused by AWS services.
     - Determine cause of SDK retries or latency.
       This metric will not always indicate that AWS services are at fault,
       as some AWS teams classify latency as an HTTP 503 response.
   * - ThrottleCount
     - Number of API calls that fail due to throttling by AWS services.
     - Use this metric to assess if your application has reached throttle limits,
       as well as to determine the cause of retries and application latency.
       Consider distributing calls over a window instead of batching your calls.
