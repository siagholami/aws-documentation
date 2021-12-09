.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

#############
|sdk-xamarin|
#############

Welcome to the |sdk-xamarin| Developer Guide. This guide will help you start developing Xamarin
applications that use Amazon Web Services. The |sdk-xamarin| provides access to many AWS Services.
Supported AWS services currently include, but are not limited to:

* `Amazon Cognito`_
* `Amazon Mobile Analytics`_
* `Amazon S3`_
* `Amazon DynamoDB`_
* `Amazon Simple Notification Service`_

The |sdk-xamarin| also allows you to call AWS services supported by the AWS SDK for .NET. For more
information about the AWS SDK for .NET, see:

* `AWS SDK for .NET Getting Started Guide <https://docs.aws.amazon.com/AWSSdkDocsNET/latest/DeveloperGuide/net-dg-setup.html>`_
* `AWS SDK for .NET Developer Guide <http://docs.aws.amazon.com/AWSSdkDocsNET/latest/V3/DeveloperGuide/welcome.html>`_
* `AWS SDK for .NET API Reference <http://docs.aws.amazon.com/sdkfornet/latest/apidocs/Index.html>`_

About this guide
================

This developer guide explains how to work with the various components of the SDK. The AWS services
that are specific to mobile development are explained in this developer guide, in addition to other
useful services like Amazon S3 and Amazon DynamoDB. To learn more about what comes bundled with the
|sdk-xamarin|, see :doc:`Welcome`.

How do I get the |sdk-xamarin|?
===============================

To get the |sdk-xamarin|, following the instructions in :doc:`setup`. The |sdk-xamarin| is
distributed as NuGet packages. You can find a complete list of AWS service packages at `AWS SDK
packages on NuGet <https://www.nuget.org/packages?q=awssdk&page=1>`_ or at the AWS SDK for .NET
`Github Repository <https://github.com/aws/aws-sdk-net#nuget-packages>`_.

After you set up the SDK, you can view the quick start instructions in
:doc:`getting-started-xamarin` or start working with the individual mobile clients for Amazon Web
Services. The mobile clients are described in the service-specific topics. Additional topics in the
guide include:

.. toctree::
   :maxdepth: 1

   Welcome
   setup
   getting-started-xamarin
   cognito-identity
   cognito-sync
   analytics
   s3
   dynamodb
   sns
   best-practices
   troubleshooting-xamarin
   document-history

Additional Resources
====================

- **API Reference**: The `AWS Mobile SDK for .NET and Xamarin API Reference
  <http://docs.aws.amazon.com/sdkfornet/v3/apidocs/Index.html>`_ includes the ability to browse and
  search code included with the SDK. It provides thorough documentation and usage examples.

- **Questions & Feedback**: Post questions and feedback on the `AWS Mobile Developer Forums
  <https://forums.aws.amazon.com/forum.jspa?forumID=88>`_.

- **Samples**: Samples are available at the `AWS SDK for .NET Github repository
  <https://github.com/awslabs/aws-sdk-net-samples/tree/master/XamarinSamples>`_.

- **Source Code**: Source code is available at the `AWS Mobile SDK for .NET and Xamarin Github
  repository <https://github.com/awslabs/aws-sdk-xamarin>`_.

For more information about the |sdk-xamarin|, including a complete list of supported AWS products,
see the `AWS Mobile SDK product page <http://aws.amazon.com/mobile/sdk>`_.

.. _Amazon Cognito: http://aws.amazon.com/cognito
.. _Amazon S3: http://aws.amazon.com/s3/
.. _Amazon DynamoDB: http://aws.amazon.com/dynamodb/
.. _Amazon Mobile Analytics: http://aws.amazon.com/mobileanalytics/
.. _Amazon Simple Notification Service: http://aws.amazon.com/sns/
