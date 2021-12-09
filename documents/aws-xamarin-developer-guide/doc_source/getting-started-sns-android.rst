.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

======================================================
Receive Push Notifications using SNS (Xamarin Android)
======================================================

The tutorial explains how to send push notifications to a Xamarin Android application using  Amazon
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

Enable Push Notifications on Google Cloud
-----------------------------------------

First, add a new Google API project:

#. Go to the `Google Developers Console <https://console.developers.google.com>`_.

#. Click :guilabel:`Create Project`.

#. In the :guilabel:`New Project` box, enter a project name, take note of the project ID (you will
   need it later) and click :guilabel:`Create`.

Next, enable the Google Cloud Messaging (GCM) service for your project:

#. In the `Google Developers Console <https://console.developers.google.com>`_, your new project
   should already be selected. If not, select it in the drop-down at the top of the page.

#. Select :guilabel:`APIs & auth` from the side bar on the left-hand side of the page.

#. In the search box, type "Google Cloud Messaging for Android" and click the :guilabel:`Google
   Cloud Messaging for Android` link.

#. Click :guilabel:`Enable API`.

Finally, obtain an API Key:

#. In the Google Developers Console, select :guilabel:`APIs & auth` > :guilabel:`Credentials`.

#. Under :guilabel:`Public API access`, click :guilabel:`Create new key`.

#. In the :guilabel:`Create a new key` dialog, click :guilabel:`Server key`.

#. In the resulting dialog, click :guilabel:`Create` and copy the API key displayed. You will use
   this API key to perform authentication later on.

Use Project ID to Create a Platform ARN in SNS Console
------------------------------------------------------

#. Go to the `SNS Console <https://console.aws.amazon.com/sns/v2/home>`_.

#. Click :guilabel:`Applications` on the left-hand side of the screen.

#. Click :guilabel:`Create platform application` to create a new SNS platform application.

#. Enter an :guilabel:`Application Name`.

#. Select :guilabel:`Google Cloud Messaging (GCM)` for :guilabel:`Push notification platform`.

#. Paste the API key into the text box labeled :guilabel:`API key`.

#. Click :guilabel:`Create platform application`.

#. Select the Platform Application you just created and copy the Application ARN.

Add NuGet Package for SNS to Your Project
-----------------------------------------

Follow Step 4 of the instructions in :doc:`setup` to add the Amazon Simple Notification Service
NuGet package to your project.

Create an SNS client
====================

::

  var snsClient = new AmazonSimpleNotificationServiceClient(credentials, region);

Register Your Application for Remote Notifications
==================================================

In order to register for remote notifications on Android, you will need to create a
BroadcastReceiver which can receive Google Cloud messages. Change the package name below where
prompted to do so::

  [BroadcastReceiver(Permission = "com.google.android.c2dm.permission.SEND")]
  [IntentFilter(new string[] {
  	"com.google.android.c2dm.intent.RECEIVE"
  }, Categories = new string[] {
  	"com.amazonaws.sns" /* change to match your package */
  })]
  [IntentFilter(new string[] {
  	"com.google.android.c2dm.intent.REGISTRATION"
  }, Categories = new string[] {
  	"com.amazonaws.sns" /* change to match your package */
  })]
  [IntentFilter(new string[] {
  	"com.google.android.gcm.intent.RETRY"
  }, Categories = new string[] {
  	"com.amazonaws.sns" /* change to match your package */
  })]
  public class GCMBroadcastReceiver: BroadcastReceiver {
  	const string TAG = "PushHandlerBroadcastReceiver";
  	public override void OnReceive(Context context, Intent intent) {
  		GCMIntentService.RunIntentInService(context, intent);
  		SetResult(Result.Ok, null, null);
  	}
  }

  [BroadcastReceiver]
  [IntentFilter(new[] {
  	Android.Content.Intent.ActionBootCompleted
  })]
  public class GCMBootReceiver: BroadcastReceiver {
  	public override void OnReceive(Context context, Intent intent) {
  		GCMIntentService.RunIntentInService(context, intent);
  		SetResult(Result.Ok, null, null);
  	}
  }

Below is the service that receives the push notification from the BroadcastReceiver and displays the
notification on the device's notification bar::

  [Service]
   public class GCMIntentService: IntentService {
    static PowerManager.WakeLock sWakeLock;
    static object LOCK = new object();

    public static void RunIntentInService(Context context, Intent intent) {
      lock(LOCK) {
        if (sWakeLock == null) {
          // This is called from BroadcastReceiver, there is no init.
          var pm = PowerManager.FromContext(context);
          sWakeLock = pm.NewWakeLock(
          WakeLockFlags.Partial, "My WakeLock Tag");
        }
      }

      sWakeLock.Acquire();
      intent.SetClass(context, typeof(GCMIntentService));
      context.StartService(intent);
    }

    protected override void OnHandleIntent(Intent intent) {
      try {
        Context context = this.ApplicationContext;
        string action = intent.Action;

        if (action.Equals("com.google.android.c2dm.intent.REGISTRATION")) {
          HandleRegistration(intent);
        } else if (action.Equals("com.google.android.c2dm.intent.RECEIVE")) {
          HandleMessage(intent);
        }
      } finally {
        lock(LOCK) {
          //Sanity check for null as this is a public method
          if (sWakeLock != null) sWakeLock.Release();
        }
      }
    }

    private void HandleRegistration(Intent intent) {
      string registrationId = intent.GetStringExtra("registration_id");
      string error = intent.GetStringExtra("error");
      string unregistration = intent.GetStringExtra("unregistered");

      if (string.IsNullOrEmpty(error)) {
        var response = await SnsClient.CreatePlatformEndpointAsync(new CreatePlatformEndpointRequest {
          Token = registrationId,
          PlatformApplicationArn = "YourPlatformArn" /* insert your platform application ARN here */
        });
      }
    }

    private void HandleMessage(Intent intent) {
      string message = string.Empty;
      Bundle extras = intent.Extras;
      if (!string.IsNullOrEmpty(extras.GetString("message"))) {
        message = extras.GetString("message");
      } else {
        message = extras.GetString("default");
      }

      Log.Info("Messages", "message received = " + message);
      ShowNotification(this, "SNS Push", message);
      //show the message

    }

    public void ShowNotification(string contentTitle,
    string contentText) {
      // Intent
      Notification.Builder builder = new Notification.Builder(this)
        .SetContentTitle(contentTitle)
        .SetContentText(contentText)
        .SetDefaults(NotificationDefaults.Sound | NotificationDefaults.Vibrate)
        .SetSmallIcon(Resource.Drawable.Icon)
        .SetSound(RingtoneManager.GetDefaultUri(RingtoneType.Notification));

      // Get the notification manager:
      NotificationManager notificationManager = this.GetSystemService(Context.NotificationService) as NotificationManager;

      notificationManager.Notify(1001, builder.Build());
    }
  }

Send a Message from the SNS Console to Your Endpoint
====================================================

#. Go to the `SNS Console > Applications <https://console.aws.amazon.com/sns/v2/home>`_.

#. Select your platform application, select an endpoint, and click **Publish to endpoint**.

#. Type in a text message in the text box and click **Publish message** to publish a message.
