.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

#######################################
Store and Retrieve Files with Amazon S3
#######################################

Amazon Simple Storage Service (Amazon S3) provides mobile developers with secure, durable,
highly-scalable object storage. Amazon S3 is easy to use, with a simple web services interface to
store and retrieve any amount of data from anywhere on the web.

The tutorial below explains how to integrate the S3 TransferUtility, a high-level utility for using
S3 with your app. For more information about using S3 from Xamarin applications, see :doc:`s3`.

Project Setup
=============

Prerequisites
-------------

You must complete all of the instructions on the :doc:`setup` before beginning this tutorial.

This tutorial also assumes you have already created an S3 bucket. To create an S3 bucket, visit the
`S3 AWS Console <https://console.aws.amazon.com/s3/home>`_.

Set Permissions for S3
----------------------

The default IAM role policy grants your application access to Amazon Mobile Analytics and Amazon
Cognito Sync. In order for your Cognito identity pool to access Amazon S3, you must modify the
identity pool's roles.

#. Go to the `Identity and Access Management Console`_ and click :guilabel:`Roles` in the left-hand
   pane.

#. Type your identity pool name into the search box. Two roles will be listed: one for
   unauthenticated users and one for authenticated users.

#. Click the role for unauthenticated users (it will have unauth appended to your identity pool name).

#. Click :guilabel:`Create Role Policy`, select :guilabel:`Policy Generator`, and then click
   :guilabel:`Select`.

#. On the **Edit Permissions** page, enter the settings shown in the following image, replacing the
   Amazon Resource Name (ARN) with your own. The ARN of an S3 bucket looks like
   :code:`arn:aws:s3:::examplebucket/*` and is composed of the region in which the bucket is located
   and the name of the bucket. The settings shown below will give your identity pool full to access
   to all actions for the specified bucket.

   .. image:: images/edit-permissions.png

6. Click the :guilabel:`Add Statement` button and then click :guilabel:`Next Step`.

7. The Wizard will show you the configuration that you generated. Click :guilabel:`Apply Policy`.

For more information on granting access to S3, see `Granting Access to an Amazon S3 Bucket`_.

Add NuGet Package for S3 to Your Project
----------------------------------------

Follow Step 4 of the instructions in :doc:`setup` to add the S3 NuGet package to your project.

(optional) Configure the Signature Version for S3 Requests
----------------------------------------------------------

Every interaction with Amazon S3 is either authenticated or anonymous. AWS uses the Signature
Version 4 or Signature Version 2 algorithms to authenticate calls to the service.

All new AWS regions created after January 2014 only support Signature Version 4. However, many older
regions still support Signature Version 4 and Signature Version 2 requests.

If your bucket is in one of the regions that does not support Signature Version 2 requests as listed
on `this page <http://docs.aws.amazon.com/general/latest/gr/signature-version-2.html>`_, you must
set the AWSConfigsS3.UseSignatureVersion4 property to "true" like so::

  AWSConfigsS3.UseSignatureVersion4 = true;

For more information on AWS Signature versions, see `Authenticating Requests (AWS Signature Version
4) <http://docs.aws.amazon.com/AmazonS3/latest/API/sig-v4-authenticating-requests.html>`_.

Initialize the S3 TransferUtility Client
========================================

Create an S3 client, passing it your AWS credentials object, and then pass the S3 client to the
transfer utility, like so::

  var s3Client = new AmazonS3Client(credentials,region);
  var transferUtility = new TransferUtility(s3Client);

Upload a File to Amazon S3
==========================

To upload a file to S3, call :code:`Upload` on the Transfer Utility object, passing the following
parameters:

- :code:`file` - String name of the file that you want to upload
- :code:`bucketName` - String name of the S3 bucket to store the file

::

  transferUtility.Upload(
    Path.Combine(Environment.SpecialFolder.ApplicationData,"file"),
    "bucketName"
  );

The code above assumes that there is a file in the directory
Environment.SpecialFolder.ApplicationData. Uploads automatically use S3's multi-part upload
functionality on large files to enhance throughput.

Download a File from Amazon S3
==============================

To download a file from S3, call :code:`Download` on the Transfer Utility object, passing the
following parameters:

- :code:`file` - String name of the file that you want to download
- :code:`bucketName` - String name of the S3 bucket from which you want to download the file
- :code:`key` - A string representing the name of the S3 object (a file in this case) to download

::

  transferUtility.Download(
    Path.Combine(Environment.SpecialFolder.ApplicationData,"file"),
    "bucketName",
    "key"
  );

For more information on accessing Amazon S3 from an Xamarin application, see :doc:`s3`.

.. _Identity and Access Management Console: https://console.aws.amazon.com/iam/home
.. _Granting Access to an Amazon S3 Bucket: http://blogs.aws.amazon.com/security/post/Tx3VRSWZ6B3SHAV/Writing-IAM-Policies-How-to-grant-access-to-an-Amazon-S3-bucket
