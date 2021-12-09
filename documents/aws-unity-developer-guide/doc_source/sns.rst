.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp


##################################
Amazon Simple Notification Service
##################################

Using Amazon Simple Notification Service (SNS) and the Unity SDK, you can write iOS and Android apps
that can receive mobile push notifications. For information about SNS, see `Amazon Simple
Notification Service`_.

This topic will walk you through configuring the AWS SDK for Unity sample app, SNSExample.unity, to
receive mobile push notifications through Amazon SNS.

You can create both iOS and Android apps using the SNSExample.unity sample. The configuration steps
are different between iOS and Android please read the appropriate section below for the platform you
are targeting.

Prerequisites
=============

Set Permissions for SNS
-----------------------

When you create a Cognito Identity Pool two IAM roles are generated:

- Cognito/_<Identity-Pool-Name>Auth_DefaultRole - the default IAM role for authenticated users

- Cognito/_<Identity-Pool-Name>Unauth_DefaultRole - the default IAM role for unauthenticated users

You must add permissions to access the Amazon SNS service to these roles. To do this:

#. Browse to the `IAM Console <https://console.aws.amazon.com/iam/home>`_ and select the IAM role to
   configure.

#. Click :guilabel:`Attach Policy`, select the AmazonSNSFullAccess policy and click
   :guilabel:`Attach Policy`.

.. note:: Using AmazonSNSFullAccess is not recommended in a production environment, we use it here
   to allow you to get up and running quickly. For more information about specifying permissions for
   an IAM role, see `Overview of IAM Role Permissions
   <http://docs.aws.amazon.com/IAM/latest/UserGuide/policies_permissions.html>`_.

iOS Prerequisites
-----------------

- Membership in the Apple iOS Developer Program
- Generate a signing identity
- Create a provisioning profile configured for push notifications

You will need to run your app on a physical device to receive push notifications. To run your app on
a device you must have a membership in the `Apple iOS Developer Program Membership
<https://developer.apple.com/programs/ios/>`_. Once you have a membership, you can use Xcode to
generate a signing identity. For more information, see Apple's `App Distribution Quick Start
<https://developer.apple.com/library/mac/documentation/IDEs/Conceptual/AppStoreDistributionTutorial/Introduction/Introduction.html#//apple_ref/doc/uid/TP40013839>`_
documentation. Next you will need a provisioning profile configured for push notifications for more
information, see Apple's `Configuring Push Notifications
<https://developer.apple.com/library/mac/documentation/IDEs/Conceptual/AppDistributionGuide/ConfiguringPushNotifications/ConfiguringPushNotifications.html#//apple_ref/doc/uid/TP40012582-CH32-SW1>`_
documentation.

Android Prerequisites
---------------------

- Install the Android SDK
- Install the JDK
- android-support-v4.jar
- google-play-services.jar

Configuring the Unity Sample App for iOS
========================================

Open the Unity editor and create a new project. Import the AWS SDK for Unity package by selecting
:guilabel:`Assets`/:guilabel:`Import Package`/:guilabel:`Custom Package` and selecting
aws-unity-sdk-sns-2.0.0.1.unitypackage. Ensure all items in the :guilabel:`Importing Package` dialog
are selected and click :guilabel:`Import`.

Unity Configuration
-------------------

Perform the following steps to configure the Unity project:

#. In the :guilabel:`Project` pane, navigate to
   :guilabel:`Assets`/:guilabel:`AWSSDK`/:guilabel:`examples` and open the SNSExample scene.

#. In the :guilabel:`Hierarchy` pane, select SNSExample.

#. In the :guilabel:`Inspector` pane specify your Cognito Identity Pool ID.

#. Notice there is a text box for :guilabel:`iOS Platform Application ARN`, you will generate that
   information later on.

#. Select :guilabel:`File`/:guilabel:`Build Settings`, in the :guilabel:`Build Settings` dialog,
   click the :guilabel:`Add Current` button below the :guilabel:`Scenes in Build` list box to add
   the current scene to the build.

#. Under :guilabel:`Platform` select :guilabel:`iOS` and click the :guilabel:`Player Settings...`
   button, in the :guilabel:`Inspector Pane` of the Unity editor, click the iPhone icon and scroll
   down to the :guilabel:`Identification` section and specify a :guilabel:`Bundle Identifier`.


iOS Configuration
-----------------

Perform the following steps to configure the sample to configure iOS specific settings:

#. In a web browser, go to the `Apple Developer Member Center
   <https://developer.apple.com/membercenter/index.action>`_, click :guilabel:`Certificates,
   Identifiers & Profiles`.

#. Click :guilabel:`Identifiers` under :guilabel:`iOS Apps`, click the plus button in the upper
   right-hand corner of the web page to add a new iOS App ID, and enter an App ID description.

#. Scroll down to the :guilabel:`Add ID Suffix` section and select :guilabel:`Explicit App ID` and
   enter your bundle identifier.

#. Scroll down to the :guilabel:`App Services` section and select :guilabel:`Push Notifications`.

#. Click the :guilabel:`Continue` button.

#. Click the :guilabel:`Submit` button.

#. Click the :guilabel:`Done` button.

#. Select the App ID you just created and then click the :guilabel:`Edit` button.

#. Scroll down to the :guilabel:`Push Notifications` section.

#. Click the :guilabel:`Create Certificate` button under :guilabel:`Development SSL Certificate`.

#. Follow the instructions to create a Certificate Signing Request (CSR), upload the request, and
   download an SSL certificate that will be used to communicate with Apple Notification Service
   (APNS).

#. Back in the :guilabel:`Certificates, Identifiers & Profiles` web page, click :guilabel:`All`
   under :guilabel:`Provisioning Profiles`.

#. Click the plus button in the upper right-hand corner to add a new provisioning profile.

#. Select :guilabel:`iOS App Development` and click the :guilabel:`Continue` button.

#. Select your App ID and click the :guilabel:`Continue` button.

#. Select your developer certificate and click the :guilabel:`Continue` button.

#. Select your device and click the :guilabel:`Continue` button.

#. Enter a profile name and click the :guilabel:`Generate` button.

#. Download and double click the provision file to install the provisioning profile.

You may need to refresh the Provisioning Profiles in Xcode after adding a new one. In Xcode:

#. Select the :guilabel:`Xcode`/:guilabel:`Preferences` menu item.

#. Select the :guilabel:`Accounts` tab, select your Apple ID and click :guilabel:`View Details`.

#. Click the refresh button in the lower left-hand corner of the dialog to refresh your provisioning
   profiles and make sure your new profile is displayed.

SNS Configuration
-----------------

#. Run the KeyChain access app, select :guilabel:`My Certificates` on the lower left-hand side of
   the screen, right click the SSL certificate you generated to connect to APNS and select
   :guilabel:`Export`, you will be prompted to specify a name for the file and a password to protect
   the certificate. The certificate will be saved in a P12 file.

#. In a web browser go to the `SNS Console <https://console.aws.amazon.com/sns/v2/home>`_ and click
   :guilabel:`Applications` on the left-hand side of the screen.

#. Click :guilabel:`Create platform application` to create a new SNS platform application.

#. Enter an :guilabel:`Application Name`.

#. Select :guilabel:`Apple Push Notification Service Sandbox (APNS_SANDBOX)` for :guilabel:`Push
   notification platform`.

#. Click :guilabel:`Choose File` and select the P12 file you created when you exported your SSL
   certificate.

#. Enter the password you specified when you exported the SSL certificate and click :guilabel:`Load
   Credentials From File`.

#. Click :guilabel:`Create platform application`.

#. Select the Platform Application you just created and copy the Application ARN.

#. Go back to your project in the Unity Editor, select :guilabel:`SNSExample` in the
   :guilabel:`Hierarchy` pane, in the :guilabel:`Inspector` pane and paste the Platform Application
   ARN into the text box labeled :guilabel:`iOS Platform Application ARN`.

#. Select :guilabel:`File`/:guilabel:`Build Settings` and click the :guilabel:`Build` button this
   will create an Xcode project.

Using Xcode
-----------

#. Open the Xcode project, and select the project in the Project Navigator.

#. Verify the bundle identifier is set correctly

#. Verify your Apple Developer Account is specified in the :guilabel:`Team` - this is required for
   your Provisioning Profile to take effect.

#. Build the project and run it on your device.

#. Tap the :guilabel:`Register for Notification`, tap :guilabel:`OK` to allow notifications, the app
   will display your device token

In the `SNS Console <https://console.aws.amazon.com/sns/v2/home>`_, click :guilabel:`Applications`,
select your platform application and click :guilabel:`Create Platform Endpoint`, and enter the
device token displayed by the app.

At this point your app, APNS, and NSN are fully configured. You can select your platform
application, select your endpoint, and click :guilabel:`Publish to endpoint` to send a push
notification to your device.

Unity Sample (iOS)
------------------

The sample creates an CognitoAWSCredentials instance to generate temporary limited-scope credentials
that allows the app to call AWS services. It also creates an instance of
AmazonSimpleNotificationServiceClient to communicate with SNS. The app displays two buttons labeled
:guilabel:`Register for Notification` and :guilabel:`Unregister`.

When the :guilabel:`Register for Notifications` button is tapped, the :code:`RegisterDevice()`
method is called. :code:`RegisterDevice()` calls
:code:`UnityEngine.iOS.NotificationServices.RegisterForNotifications`, which specifies which
notification types (alert, sound, or badge) will be used. It also makes an asynchronous call to APNS
to get a device token. Because there is no callback defined, :code:`CheckForDeviceToken` is called
repeatedly (up to 10 times) to check for the device token.

When a token is retrieved
:code:`AmazonSimpleNotificationServiceClient.CreatePlatformEndpointAsync()` is called to create an
endpoint for the SNS platform application.

The sample is now configured to receive push notifications. You can browse to the `SNS Console
<https://console.aws.amazon.com/sns/v2/home>`_, click :guilabel:`Applications` on the left-hand side
of the page, select your platform application, select an endpoint, and click :guilabel:`Publish to
endpoint`. Select the endpoint to use and click :guilabel:`Publish to Endpoint`. Type in a text
message in the text box and click :guilabel:`Publish message` to publish a message.

Configuring the Unity Sample App for Android
============================================

Open the Unity editor and create a new project. Import the AWS SDK for Unity package by selecting
:guilabel:`Assets`/:guilabel:`Import Package`/:guilabel:`Custom Package` and selecting
aws-unity-sdk-sns-2.0.0.1.unitypackage. Ensure all items in the :guilabel:`Importing Package` dialog
are selected and click :guilabel:`Import`.

Unity Configuration
-------------------

Perform the following steps to configure the Unity project:

#. In the :guilabel:`Project` pane, navigate to
   :guilabel:`Assets`/:guilabel:`AWSSDK`/:guilabel:`examples` and open the SNSExample scene.

#. In the :guilabel:`Hierarchy` pane, select SNSExample.

#. In the :guilabel:`Inspector` pane specify your Cognito Identity Pool ID.

#. Notice there is a text box for :guilabel:`Android Platform Application ARN` and :guilabel:`Google
   Console Project ID`, you will generate that information later on.

#. Select :guilabel:`File`/:guilabel:`Build Settings`, in the :guilabel:`Build Settings` dialog,
   click the :guilabel:`Add Current` button below the :guilabel:`Scenes in Build` list box to add
   the current scene to the build.

#. Under :guilabel:`Platform` select :guilabel:`Android` and click the :guilabel:`Player
   Settings...` button, in the :guilabel:`Inspector Pane` of the Unity editor, click the Android
   icon and scroll down to the :guilabel:`Identification` section and specify a :guilabel:`Bundle
   Identifier`.

#. Copy android-support-v4.jar and google-play-services.jar into the
   :guilabel:`Assets`/:guilabel:`Plugins`/:guilabel:`Android` directory in the :guilabel:`Project`
   pane.

For more information about where to find android-support-v4.jar, see `Android Support Library Setup
<https://developer.android.com/tools/support-library/setup.html>`_. For more information about how
to find google-play-services.jar, see `Google APIs for Android Setup
<https://developers.google.com/android/guides/setup>`_.

Android Configuration
---------------------

First add a new Google API project:

#. In a web browser, go to the `Google Developers Console <https://console.developers.google.com>`_,
   click :guilabel:`Create Project`.

#. In the :guilabel:`New Project` box, enter a project name, take note of the project number (you
   will need it later) and click :guilabel:`Create`.

Next, enable the Google Cloud Messaging (GCM) service for your project:

#. In the Google Developers Console, your new project should already be selected, if not, select it
   in the drop down at the top of the page.

#. Select :guilabel:`APIs & auth` from the side bar on the left-hand side of the page.

#. In the search box, type "Google Cloud Messaging for Android" and click the :guilabel:`Google
   Cloud Messaging for Android` link below.

#. Click :guilabel:`Enable API`.

Finally obtain an API Key:

#. In the Google Developers Console, select :guilabel:`APIs & auth` > :guilabel:`Credentials`.

#. Under :guilabel:`Public API access`, click :guilabel:`Create new key`.

#. In the :guilabel:`Create a new key` dialog, click :guilabel:`Server key`.

#. In the resulting dialog, click :guilabel:`Create` and copy the API key displayed.

You will use the API key to perform authentication later on.

SNS Configuration
-----------------

#. In a web browser go to the `SNS Console <https://console.aws.amazon.com/sns/v2/home>`_ and click
   :guilabel:`Applications` on the left-hand side of the screen.

#. Click :guilabel:`Create platform application` to create a new SNS platform application.

#. Enter an :guilabel:`Application Name`

#. Select :guilabel:`Google Cloud Messaging (GCM)` for :guilabel:`Push notification platform`

#. Paste the API key into the text box labeled :guilabel:`API key`.

#. Click :guilabel:`Create platform application`

#. Select the Platform Application you just created and copy the Application ARN.

#. Go back to your project in the Unity Editor, select :guilabel:`SNSExample` in the
   :guilabel:`Hierarchy` pane, in the :guilabel:`Inspector` pane and paste the Platform Application
   ARN into the text box labeled :guilabel:`Android Platform Application ARN` and your project
   number into the text box labeled :guilabel:`Google Console Project ID`.

#. Connect your Android device to your computer, select :guilabel:`File`/:guilabel:`Build Settings`
   and click the :guilabel:`Build and Run.`


Unity Sample (Android)
----------------------

The sample creates an CognitoAWSCredentials instance to generate temporary limited-scope credentials
that allows the app to call AWS services. It also creates an instance of
AmazonSimpleNotificationServiceClient to communicate with SNS.

The app displays two buttons labeled :guilabel:`Register for Notification` and
:guilabel:`Unregister`. When the :guilabel:`Register for Notifications` button is tapped, the
:code:`RegisterDevice()` method is called. :code:`RegisterDevice()` calls :code:`GCM.Register`,
which registers the app with GCM. GCM is a class defined within the example code. It makes an
asynchronous call to register the app with GCM.

When the callback is called
:code:`AmazonSimpleNotificationServiceClient.CreatePlatformEndpointAsync` is called to create a
platform endpoint to receive SNS messages.

The sample is now configured to receive push notifications. You can browse to the `SNS Console
<https://console.aws.amazon.com/sns/v2/home>`_, click :guilabel:`Applications` on the left-hand side
of the page, select your platform application, select an endpoint, and click :guilabel:`Publish to
endpoint`. Select the endpoint to use and click :guilabel:`Publish to Endpoint`. Type in a text
message in the text box and click :guilabel:`Publish message` to publish a message.

.. _Amazon Simple Notification Service: http://aws.amazon.com/sns/
