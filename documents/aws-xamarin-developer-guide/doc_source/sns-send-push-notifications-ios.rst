.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

=====================================
Send Push Notifications (Xamarin iOS)
=====================================

This document explains how to send push notifications to a Xamarin iOS application using  Amazon
Simple Notification Service (SNS) and the |sdk-xamarin|.

Project Setup
=============

Prerequisites
-------------

You must complete all of the instructions on the :doc:`setup` before beginning this tutorial.

Set Permissions for SNS
-----------------------

Follow Step 2 in :doc:`setup` to attach the policy mentioned below to your application's roles. This
will give your application the proper permissions to access SNS:

#. Go to the `IAM Console <https://console.aws.amazon.com/iam/home>`_ and select the IAM role that
   you want to configure.

#. Click :guilabel:`Attach Policy`, select the AmazonSNSFullAccess policy and click
   :guilabel:`Attach Policy`.

.. warning:: Using AmazonSNSFullAccess is not recommended in a production environment. We use it
   here to allow you to get up and running quickly. For more information about specifying
   permissions for an IAM role, see `Overview of IAM Role Permissions
   <http://docs.aws.amazon.com/IAM/latest/UserGuide/policies_permissions.html>`_.

Obtain Membership in the Apple iOS Developer Program
----------------------------------------------------

You will need to run your app on a physical device to receive push notifications. To run your app on
a device, you must have a membership in the `Apple iOS Developer Program Membership
<https://developer.apple.com/programs/ios/>`_. Once you have a membership, you can use Xcode to
generate a signing identity. For more information, see Apple's `App Distribution Quick Start
<https://developer.apple.com/library/mac/documentation/IDEs/Conceptual/AppStoreDistributionTutorial/Introduction/Introduction.html#//apple_ref/doc/uid/TP40013839>`_
documentation.

Create an iOS Certificate
-------------------------

First, you need to create an iOS Certificate. Then, you need to create a provisioning profile
configured for push notifications. To do so:

#. Go to the `Apple Developer Member Center
   <https://developer.apple.com/membercenter/index.action>`_, click :guilabel:`Certificates,
   Identifiers & Profiles`.

#. Click :guilabel:`Identifiers` under :guilabel:`iOS Apps`, click the plus button in the upper
   right-hand corner of the web page to add a new iOS App ID, and enter an App ID description.

#. Scroll down to the :guilabel:`Add ID Suffix` section and select :guilabel:`Explicit App ID` and
   enter your bundle identifier.

#. Scroll down to the :guilabel:`App Services` section and select :guilabel:`Push Notifications`.

#. Click :guilabel:`Continue`.

#. Click :guilabel:`Submit`.

#. Click :guilabel:`Done`.

#. Select the App ID you just created and then click :guilabel:`Edit`.

#. Scroll down to the :guilabel:`Push Notifications` section. Click :guilabel:`Create Certificate`
   under :guilabel:`Development SSL Certificate`.

#. Follow the instructions to create a Certificate Signing Request (CSR), upload the request, and
   download an SSL certificate that will be used to communicate with Apple Notification Service
   (APNS).

#. Return to the :guilabel:`Certificates, Identifiers & Profiles` page. Click :guilabel:`All` under
   :guilabel:`Provisioning Profiles`.

#. Click the plus button in the upper right-hand corner to add a new provisioning profile.

#. Select :guilabel:`iOS App Development`, and then click :guilabel:`Continue`.

#. Select your App ID, and then click :guilabel:`Continue`.

#. Select your developer certificate, and then click :guilabel:`Continue`.

#. Select your device, and then click :guilabel:`Continue`.

#. Enter a profile name, and then click :guilabel:`Generate`.

#. Download and double-click the provision file to install the provisioning profile.

For more information on provisioning a profile configured for push notifications, see Apple's
`Configuring Push Notifications
<https://developer.apple.com/library/mac/documentation/IDEs/Conceptual/AppDistributionGuide/ConfiguringPushNotifications/ConfiguringPushNotifications.html#//apple_ref/doc/uid/TP40012582-CH32-SW1>`_
documentation.

Use Certificate to Create Platform ARN in SNS Console
-----------------------------------------------------

#. Run the KeyChain access app, select :guilabel:`My Certificates` on the lower left-hand side of
   the screen, and then right-click the SSL certificate you generated to connect to APNS and select
   :guilabel:`Export`. You will be prompted to specify a name for the file and a password to protect
   the certificate. The certificate will be saved in a P12 file.

#. Go to the `SNS Console <https://console.aws.amazon.com/sns/v2/home>`_ and click
   :guilabel:`Applications` on the left-hand side of the screen.

#. Click :guilabel:`Create platform application` to create a new SNS platform application.

#. Enter an :guilabel:`Application Name`.

#. Select :guilabel:`Apple Development` for :guilabel:`Push notification platform`.

#. Click :guilabel:`Choose File` and select the P12 file you created when you exported your SSL
   certificate.

#. Enter the password you specified when you exported the SSL certificate and click :guilabel:`Load
   Credentials From File`.

#. Click :guilabel:`Create platform application`.

#. Select the Platform Application you just created and copy the Application ARN. You will need this
   in the upcoming steps.

Add NuGet Package for SNS to Your Project
-----------------------------------------

Follow Step 4 of the instructions in :doc:`setup` to add the Amazon Simple Notification Service
NuGet package to your project.

Create an SNS Client
====================

::

  var snsClient = new AmazonSimpleNotificationServiceClient(credentials, region);

Register Your Application for Remote Notifications
==================================================

To register an application, call RegisterForRemoteNotifications on your UIApplication object, as
shown below. Place the following code in AppDelegate.cs, inserting your platform application ARN
where prompted below::

  public override bool FinishedLaunching(UIApplication app, NSDictionary options) {
  // do something
  var pushSettings = UIUserNotificationSettings.GetSettingsForTypes (
    UIUserNotificationType.Alert |
    UIUserNotificationType.Badge |
    UIUserNotificationType.Sound,
    null
  );
  app.RegisterUserNotifications(pushSettings);
  app.RegisterForRemoteNotifications();
  // do something
    return true;
  }

  public override void RegisteredForRemoteNotifications(UIApplication application, NSData token) {
    var deviceToken = token.Description.Replace("<", "").Replace(">", "").Replace(" ", "");
    if (!string.IsNullOrEmpty(deviceToken)) {
      //register with SNS to create an endpoint ARN
      var response = await SnsClient.CreatePlatformEndpointAsync(
      new CreatePlatformEndpointRequest {
        Token = deviceToken,
        PlatformApplicationArn = "YourPlatformArn" /* insert your platform application ARN here */
      });
    }
  }

Send a Message from the SNS Console to Your Endpoint
====================================================

#. Go to the `SNS Console > Applications <https://console.aws.amazon.com/sns/v2/home>`_.

#. Select your platform application, select an endpoint, and click **Publish to endpoint**.

#. Type in a text message in the text box and click **Publish message** to publish a message.

