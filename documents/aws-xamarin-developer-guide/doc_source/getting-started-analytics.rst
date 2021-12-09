.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

====================================================
Tracking App Usage Data with Amazon Mobile Analytics
====================================================

Amazon Mobile Analytics allows you to measure app usage and app revenue. By tracking key trends such
as new vs. returning users, app revenue, user retention, and custom in-app behavior events, you can
make data-driven decisions to increase engagement and monetization for your app.

The tutorial below explains how to integrate Mobile Analytics with your app.

Project Setup
=============

Prerequisites
-------------

You must complete all of the instructions on the :doc:`setup` before beginning this tutorial.

Create an App in the Mobile Analytics Console
---------------------------------------------

Go to the `Amazon Mobile Analytics console <https://console.aws.amazon.com/mobileanalytics/home>`_
and create an app. Note the :code:`appId` value, as you'll need it later. When you are creating an
app in the Mobile Analytics Console you will need to specify your identity pool ID. For instructions
on creating an identity pool, see :doc:`setup`.

To learn more about working in the console, see the `Amazon Mobile Analytics User Guide
<http://docs.aws.amazon.com/mobileanalytics/latest/ug/>`_.

Set Permissions for Mobile Analytics
------------------------------------

The default policy associated with the roles that you created during setup grant your application
access to Mobile Analytics. No further configuration is required.

Add NuGet Package for Mobile Analytics to Your Project
------------------------------------------------------

Follow Step 4 of the instructions in :doc:`setup` to add the Mobile Analytics NuGet package to your
project.

Configure Mobile Analytics Settings
-----------------------------------

Mobile Analytics defines some settings that can be configured in the awsconfig.xml file::

  var config = new MobileAnalyticsManagerConfig();
  config.AllowUseDataNetwork = true;
  config.DBWarningThreshold = 0.9f;
  config.MaxDBSize = 5242880;
  config.MaxRequestSize = 102400;
  config.SessionTimeout = 5;

- AllowUseDataNetwork - A boolean that specifies if the session events are sent on the data network.

- DBWarningThreshold - This is the limit on the size of the database which, once reached, will
  generate warning logs.

- MaxDBSize - This is the size of the SQLIte Database. When the database reaches the maximum size,
  any additional events are dropped.

- MaxRequestSize - This is the maximum size of the request in Bytes that should be transmitted in an
  HTTP request to the mobile analytics service.

- SessionTimeout - This the time interval after an application goes to background and when session
  can be terminated.

The settings shown above are the default values for each configuration item.

Initialize MobileAnalyticsManager
=================================

To initialize your MobileAnalyticsManager, call GetOrCreateInstance on your
:code:`MobileAnalyticsManager`, passing in your AWS credentials, your region, your Mobile Analytics
application ID, and your optional config object::

  var manager = MobileAnalyticsManager.GetOrCreateInstance(
    "APP_ID",
    "Credentials",
    "RegionEndPoint",
    config
  );

Track Session Events
====================

Xamarin Android
---------------

Override the activity’s :code:`OnPause()` and :code:`OnResume()` methods to record session events.

::

  protected override void OnResume()
  {
      manager.ResumeSession();
      base.OnResume();
  }

  protected override void OnPause()
  {
      manager.PauseSession();
      base.OnPause();
  }

This needs to be implemented for each activity in your application.

Xamarin iOS
-----------

In your AppDelegate.cs::

  public override void DidEnterBackground(UIApplication application)
  {
      manager.PauseSession();
  }

  public override void WillEnterForeground(UIApplication application)
  {
      manager.ResumeSession();
  }

For more information on Mobile Analytics, see :doc:`analytics`.

.. _Cognito Console: https://console.aws.amazon.com/cognito/home
