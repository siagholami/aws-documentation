.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

=======================
Amazon Mobile Analytics
=======================

`Amazon Mobile Analytics <http://aws.amazon.com/mobileanalytics/>`_ is a service for collecting,
visualizing, understanding and extracting app usage data at scale. Mobile Analytics easily captures
both standard device data and custom events and automatically calculates reports on your behalf. In
addition to the aggregated reports listed below, you can also setup your data to be exported to
Redshift and S3 automatically for further analysis.

Using Amazon Mobile Analytics, you can track customer behaviors, aggregate metrics, generate data
visualizations, and identify meaningful patterns.

Key Concepts
============

Report Types
------------

Out of the box, Mobile Analytics provides the following reports in the Mobile Analytics Console:

- Daily Active Users (DAU), Monthly Active Users (MAU), and New Users
- Sticky Factor (DAU divided by MAU)
- Session Count and Average Sessions per Daily Active User
- Average Revenue per Daily Active User (ARPDAU) and Average Revenue per Daily Paying Active User (ARPPDAU)
- Day 1, 3, and 7 Retention and Week 1, 2, and 3 Retention
- Custom Events

These reports are provided via six reporting tabs in the console:

- **Overview** – Track nine preselected reports in a simple-to-review dashboard to get a quick idea
  of engagement: MAU, DAU, New Users, Daily Sessions, Sticky Factor, 1-Day Retention, ARPDAU, Daily
  Paying Users, ARPPDAU.

- **Active Users** – Track how many users engage with your app daily and monthly and monitor sticky
  factor to gauge engagement, appeal, and monetization.

- **Sessions** – Track how often your app is used on a given day and how often each user opens your
  app during a day.

- **Retention** – Track the rate at which customers come back to your app on a daily and weekly basis.

- **Revenue** – Track in-app revenue trends to identify areas for monetization improvement.

- **Custom events** – Track custom defined user actions specific to your app.

To learn more about Mobile Analytics reports and working in the Mobile Analytics console, see the
`Mobile Analytics Console Reports Overview
<https://docs.aws.amazon.com/mobileanalytics/latest/ug/using-the-console.html>`_ in the Mobile
Analytics Developer Guide.

Project Setup
=============

Prerequisites
-------------

To use Mobile Analytics in your application, you'll need to add the SDK to your project. To do so,
follow the instructions in :doc:`setup`.

Configure Mobile Analytics Settings
-----------------------------------

Mobile Analytics defines some settings that can be configured in the awsconfig.xml file::

  var config = new MobileAnalyticsManagerConfig();
  config.AllowUseDataNetwork = true;
  config.DBWarningThreshold = 0.9f;
  config.MaxDBSize = 5242880;
  config.MaxRequestSize = 102400;
  config.SessionTimeout = 5;

- **SessionTimeout** - If the app stays in background for a time greater than the SessionTimeout
  then Mobile Analytics client terminates the current session and a new session is created when the
  app comes back to the foreground. We recommend using values ranging from 5 to 10. The default
  value is 5.

- **MaxDBSize** - The maximum size of the database (in bytes) used for local storage of events. If
  the database size exceeds this value, additional events will be ignored. We recommend using values
  ranging from 1MB to 10MB. The default value is 5242880 (5MB).

- **DBWarningThreashold** - The Warning threshold. Valid values range between 0 - 1. If the values
  exceed the threshold warning logs will be generated. The default value is 0.9.

- **MaxRequestSize** - The maximum size of an HTTP request made to the Mobile Analytics service. The
  value is specified in bytes and can range between 1-512KB. The default value os 102400 (100KB). Do
  not use values larger than 512KB, this may cause the service to reject the HTTP request.

- **AllowUseDataNetwork** - A value indicating whether service call is allowed over a cellular data
  network. Use this option with caution as this may increase customer's data usage.

The settings shown above are the default values for each configuration item.

Integrating Mobile Analytics with Your Application
==================================================

The sections below explain how to integrate Mobile Analytics with your app.

Create an App in the Mobile Analytics Console
---------------------------------------------

Go to the `Amazon Mobile Analytics console <https://console.aws.amazon.com/mobileanalytics/home>`_
and create an app. Note the :code:`appId` value, as you'll need it later. When you are creating an
app in the Mobile Analytics Console you will need to specify your identity pool ID. For instructions
on creating an identity pool, see :doc:`setup`.

To learn more about working in the Mobile Analytics Console, see the `Mobile Analytics Console
Reports Overview <https://docs.aws.amazon.com/mobileanalytics/latest/ug/using-the-console.html>`_ in
the Mobile Analytics Developer Guide.

Create a MobileAnalyticsManager Client
--------------------------------------

To initialize your MobileAnalyticsManager, call GetOrCreateInstance on your
:code:`MobileAnalyticsManager`, passing in your AWS credentials, your region, your Mobile Analytics
application ID, and your optional config object::

  // Initialize the MobileAnalyticsManager
  analyticsManager = MobileAnalyticsManager.GetOrCreateInstance(
    cognitoCredentials,
    RegionEndpoint.USEast1,
    APP_ID,
    config
  );

The :code:`APP_ID` is generated for you during the app creation wizard. Both of these values must
match those in the Mobile Analytics Console. The :code:`APP_ID` is used to group your data in the
Mobile Analytics console. To find your app ID after creating the app in the Mobile Analytics
console, browse to the Mobile Analytics Console, click the gear icon in the upper right-hand corner
of the screen. This will display the App Management page which lists all registered apps and their
app IDs.

Record Monetization Events
--------------------------

The |sdk-xamarin| provides the :code:`MonetizationEvent` class, which enables you generate
monetization events to track purchases made within mobile applications. The following code snippet
shows how to create a monetization event::

  // Create the monetization event object
  MonetizationEvent monetizationEvent = new MonetizationEvent();

  // Set the details of the monetization event
  monetizationEvent.Quantity = 3.0;
  monetizationEvent.ItemPrice = 1.99;
  monetizationEvent.ProductId = "ProductId123";
  monetizationEvent.ItemPriceFormatted = "$1.99";
  monetizationEvent.Store = "Your-App-Store";
  monetizationEvent.TransactionId = "TransactionId123";
  monetizationEvent.Currency = "USD";

  // Record the monetiziation event
  analyticsManager.RecordEvent(monetizationEvent);

Record Custom Events
--------------------

Mobile Analytics allows you to define custom events. Custom events are defined entirely by you; they
help you track user actions specific to your app or game. For more information about Custom events,
see `Custom-Events`_.

For this example, we'll say that our app is a game, and that we want to record an event when a user
completes a level. Create a "LevelComplete" event by creating a new
:code:`AmazonMobileAnalyticsEvent` instance::

  CustomEvent customEvent = new CustomEvent("LevelComplete");

  // Add attributes
  customEvent.AddAttribute("LevelName","Level1");
  customEvent.AddAttribute("CharacterClass","Warrior");
  customEvent.AddAttribute("Successful","True");

  // Add metrics
  customEvent.AddMetric("Score",12345);
  customEvent.AddMetric("TimeInLevel",64);

  // Record the event
  analyticsManager.RecordEvent(customEvent);

Recording Sessions
------------------

Xamarin iOS
~~~~~~~~~~~

When the application loses focus you can pause the session. For iOS apps, in the AppDelegate.cs
file, override :code:`DidEnterBackground` and :code:`WillEnterForeground` to call
:code:`MobileAnalyticsManager.PauseSesion` and :code:`MobileAnalyticsManager.ResumeSession` as shown
in the following snippet::

  public override void DidEnterBackground(UIApplication application)
  {
    // ...
    _manager.PauseSesson();
    // ...
  }

  public override void WillEnterForeground(UIApplication application)
  {
    // ...
    _manager.ResumeSession();
    // ...
  }

Xamarin Android
~~~~~~~~~~~~~~~

For Android apps call :code:`MobileAnalyticsManager.PauseSesion` in the OnPause() method and
:code:`MobileAnalyticsManager.ResumeSession` in the OnResume() method as shown in the following code
snippet::

  protected override void OnResume()
  {
    _manager.ResumeSession();
    base.OnResume();
  }

  protected override void OnPause()
  {
    _manager.PauseSession();
    base.OnPause();
  }

By default, if the user switches focus away from the app for less than 5 seconds, and switches back
to the app the session will be resumed. If the user switches focus away from the app for 5 seconds
or longer, a new session will be created. This setting is configurable in the
aws_mobile_analytics.json configuration file by setting the "SESSION_DELTA" property to the number
of seconds to wait before creating a new session.

.. _Custom-Events: https://aws.amazon.com/mobileanalytics/faqs/#custom-event-details
