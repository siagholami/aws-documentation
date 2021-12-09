.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

###################################
Set Up the AWS Mobile SDK for Unity
###################################

To get started with the AWS Mobile SDK for Unity, you can set up the SDK and start building a new
project, or you can integrate the SDK with an existing project. You can also clone and run the
`samples <https://github.com/awslabs/aws-sdk-unity-samples>`_ to get a sense of how the SDK works.

Prerequisites
=============

Before you can use the AWS Mobile SDK for Unity, you will need the following:

- `An AWS Account <http://aws.amazon.com/>`_

- Unity version 4.x or 5.x (Unity 4.6.4p4 or Unity 5.0.1p3 is required if you want to write
  applications that run on iOS 64-bit)

After completing the prerequisites, you will need to do the following to get started:

#. Download the AWS Mobile SDK for Unity.
#. Configure the AWS Mobile SDK for Unity.
#. Obtain AWS credentials using Amazon Cognito.

Step 1: Download the AWS Mobile SDK for Unity
========================================

First, `download the AWS Mobile SDK for Unity
<http://sdk-for-net.amazonwebservices.com/latest/aws-sdk-unity.zip>`_. Each package in the SDK is
required to consume the corresponding AWS service based on the package's name. For example, the
aws-unity-sdk-dynamodb-2.1.0.0.unitypackage package is used to call the AWS DynamoDB service. You
can import all of the packages or just the ones you intend to use.

#. Open the Unity editor and create a new empty project, use the default settings.

#. Select :guilabel:`Assets` > :guilabel:`Import Package` > :guilabel:`Custom Package`.

#. In the :guilabel:`Import` package dialog, navigate to and select the .unitypackage files you want
   to use.

#. In the :guilabel:`Importing` package dialog, ensure all items are selected and click
   :guilabel:`Import`.

Step 2: Configure the AWS Mobile SDK for Unity
==============================================

Create a Scene
--------------

When working with the AWS Mobile SDK for Unity, you can get started by including the following line
of code in the :code:`Start` or :code:`Awake` method of your mono behavior class::

    UnityInitializer.AttachToGameObject(this.gameObject);

Create your scene by choosing :guilabel:`New Scene` from the :guilabel:`File` menu.

The AWS SDK for Unity contains client classes for each AWS service it supports. These clients are
configured using a file named :guilabel:`awsconfig.xml`. The following section describes the most
commonly used settings in the :guilabel:`awsconfig.xml` file. For more information about these
settings, see the `Unity SDK API Reference
<http://docs.aws.amazon.com/sdkfornet/v3/apidocs/Index.html>`_.

Set the Default AWS Service Region
----------------------------------

To configure the default region for all service clients::

    <aws region="us-west-2" />

This sets the default region for all the service clients in the Unity SDK. This setting can be
overridden by explicitly specifying the region at the time of creating an instance of the service
client, like so::

    IAmazonS3 s3Client = new AmazonS3Client(<credentials>,RegionEndpoint.USEast1);

Set Logging Information
-----------------------

Logging settings are specified as follows::

    <logging logTo="UnityLogger"
             logResponses="Always"
             logMetrics="true"
             logMetricsFormat="JSON" />

This setting is used to configure logging in Unity. When you log to :code:`UnityLogger`, the
framework internally prints the output to the Debug Logs. If you want to log HTTP responses, set the
logResponses flag - the values can be Always, Never, or OnError. You can also log performance
metrics for HTTP requests using the logMetrics property, the log format can be specified using
LogMetricsFormat property, valid values are JSON or standard.

The following example shows the most commonly used settings in the awsconfig.xml file. For more
information about specific service settings, see the service section below::

    <?xml version="1.0" encoding="utf-8"?>
    <aws region="us-west-2"
        <logging logTo="UnityLogger"
                 logResponses="Always"
                 logMetrics="true"
                 logMetricsFormat="JSON" />
    />


Working with the link.xml file
------------------------------

The SDK uses reflection for platform-specific components. If you are using the IL2CPP scripting
backend, :code:`strip bytecode` is always enabled on iOS, so you need to have a :code:`link.xml`
file in your assembly root with the following entries::

    <linker>
    <!-- if you are using AWSConfigs.HttpClient.UnityWebRequest option-->
    <assembly fullname="UnityEngine">
        <type fullname="UnityEngine.Experimental.Networking.UnityWebRequest" preserve="all" />
        <type fullname="UnityEngine.Experimental.Networking.UploadHandlerRaw" preserve="all" />
        <type fullname="UnityEngine.Experimental.Networking.UploadHandler" preserve="all" />
        <type fullname="UnityEngine.Experimental.Networking.DownloadHandler" preserve="all" />
        <type fullname="UnityEngine.Experimental.Networking.DownloadHandlerBuffer" preserve="all" />
    </assembly>
    <assembly fullname="mscorlib">
        <namespace fullname="System.Security.Cryptography" preserve="all"/>
    </assembly>
    <assembly fullname="System">
        <namespace fullname="System.Security.Cryptography" preserve="all"/>
    </assembly>
    <assembly fullname="AWSSDK.Core" preserve="all"/>
    <assembly fullname="AWSSDK.CognitoIdentity" preserve="all"/>
    <assembly fullname="AWSSDK.SecurityToken" preserve="all"/>
    add more services that you need here...
    </linker>


Step 3: Obtain the Identity Pool ID using Amazon Cognito
========================================================

To use AWS services in your mobile application, you must obtain the Identity Pool ID using Amazon
Cognito Identity. Using Amazon Cognito to obtain the Identity Pool ID allows your app to access AWS
services without having to embed your private credentials in your application. This also allows you
to set permissions to control which AWS services your users have access to.

To get started with Amazon Cognito, you must create an identity pool. An identity pool is a store of
user identity data specific to your account. Every identity pool has configurable IAM roles that
allow you to specify which AWS services your application's users can access. Typically, a developer
will use one identity pool per application. For more information on identity pools, see the `Amazon
Cognito Developer Guide
<http://docs.aws.amazon.com/cognito/latest/developerguide/identity-pools.html>`_.

To create an identity pool for your application:

#. Log in to the `Amazon Cognito Console <https://console.aws.amazon.com/cognito/home>`_ and click
   :guilabel:`Create new identity pool`.

#. Enter a name for your Identity Pool and check the checkbox to enable access to unauthenticated
   identities. Click :guilabel:`Create Pool` to create your identity pool.

#. Click :guilabel:`Allow` to create the two default roles associated with your identity pool--one
   for unauthenticated users and one for authenticated users. These default roles provide your
   identity pool access to Cognito Sync and Mobile Analytics.

The next page displays code that creates a credentials provider so you can easily integrate Cognito
Identity with your Unity application. You pass the credentials provider object to the constructor of
the AWS client you are using. The code looks like this::

    CognitoAWSCredentials credentials = new CognitoAWSCredentials (
        "IDENTITY_POOL_ID", // Identity Pool ID
        RegionEndpoint.USEast1 // Region
    );

Next Steps
==========

- **Get Started**: Read :doc:`getting-started-unity` to get a more detailed overview of the services
  included in the SDK.

- **Run the demos**: View our `sample Unity applications
  <https://github.com/awslabs/aws-sdk-unity-samples>`_ that demonstrate common use cases. To run the
  sample apps, set up the SDK for Unity as described above, and then follow the instructions
  contained in the README files of the individual samples.

- **Read the API Reference**: View the `API Reference
  <http://docs.aws.amazon.com/sdkfornet/v3/apidocs/Index.html>`_ for the AWS Mobile SDK for Unity.

- **Ask questions**: Post questions on the `AWS Mobile SDK Forums
  <https://forums.aws.amazon.com/forum.jspa?forumID=88>`_ or `open an issue on Github
  <https://github.com/aws/aws-sdk-unity/issues>`_.

