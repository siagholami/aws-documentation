.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

################################
Sync User Data with Cognito Sync
################################

Amazon Cognito Sync makes it easy to save mobile user data, such as app preferences or game state in
the AWS Cloud without writing any backend code or managing any infrastructure. You can save data
locally on users’ devices allowing your applications to work even when the devices are offline. You
can also synchronize data across a user’s devices so that their app experience will be consistent
regardless of the device they use.

The tutorial below explains how to integrate Sync with your app.

Project Setup
=============

Prerequisites
-------------

You must complete all of the instructions on the :doc:`setup` before beginning this tutorial.

Grant Access to Your Cognito Sync Resources
-------------------------------------------

The default policy associated with the unauthenticated and authenticate roles that you created
during setup grant your application access to Cognito Sync. No further configuration is required.

Add NuGet Package for Cognito Sync to Your Project
--------------------------------------------------

Follow Step 4 of the instructions in :doc:`setup` to add the Cognito SyncManager NuGet package to
your project.

Initialize the CognitoSyncManager
=================================

Pass your initialized Amazon Cognito credentials provider to the :code:`CognitoSyncManager`
constructor::

  CognitoSyncManager syncManager = new CognitoSyncManager (
      credentials,
      new AmazonCognitoSyncConfig {
          RegionEndpoint = RegionEndpoint.USEast1 // Region
      }
  );

Syncing User Data
=================

To sync unauthenticated user data:

#. Create a dataset.
#. Add user data to the dataset.
#. Synchronize the dataset with the cloud.

Create a Dataset
----------------

Create an instance of :code:`Dataset`. The openOrCreateDataset method is used to create a new
dataset or open an existing instance of a dataset stored locally on the device::

  Dataset dataset = syncManager.OpenOrCreateDataset("myDataset");

Add User Data to the Dataset
----------------------------

User data is added in the form of key/value pairs::

  dataset.OnSyncSuccess += SyncSuccessCallback;
  dataset.Put("myKey", "myValue");

Cognito datasets function as dictionaries, with values accessible by key::

  string myValue = dataset.Get("myKey");

Synchronize Dataset
-------------------

To synchronize a dataset, call its synchronize method::

  dataset.SynchronizeAsync();

  void SyncSuccessCallback(object sender, SyncSuccessEventArgs e) {
    // Your handler code here
  }

All data written to datasets will be stored locally until the dataset is synced. The code in this
section assumes you are using an unauthenticated Cognito identity, so when the user data is synced
with the cloud it will be stored per device. The device has a device ID associated with it. When the
user data is synced to the cloud, it will be associated with that device ID.

For more information on Cognito Sync, see :doc:`cognito-sync`.

.. _Cognito Console: https://console.aws.amazon.com/cognito
