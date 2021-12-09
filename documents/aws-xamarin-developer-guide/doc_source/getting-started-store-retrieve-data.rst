.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

=====================================
Store and Retrieve Data with DynamoDB
=====================================

`Amazon DynamoDB <http://aws.amazon.com/dynamodb/>`_ is a fast, highly scalable, highly available,
cost-effective, non-relational database service. DynamoDB removes traditional scalability
limitations on data storage while maintaining low latency and predictable performance.

The tutorial below explains how to integrate the DynamoDB Object Persistence Model with your app,
which stores objects in DynamoDB.

Project Setup
=============

Prerequisites
-------------

You must complete all of the instructions on the :doc:`setup` before beginning this tutorial.

Create a DynamoDB Table
-----------------------

Before you can read and write data to a DynamoDB database, you must create a table. When creating a
table you must specify the primary key. The primary key is composed of a hash attribute and an
optional range attribute. For more information on how primary and range attributes are used, see
`Working With Tables`_.

#. Go to the `DynamoDB Console`_ and click :guilabel:`Create Table`. The Create Table wizard
   appears.

#. Specify your table name, primary key type (Hash), and hash attribute name ("Id") as shown below,
   and then click :guilabel:`Continue`:

   .. image:: images/create-table.png

#. Leave the edit fields in the next screen empty and click :guilabel:`Continue`.

#. Accept the default values for :guilabel:`Read Capacity Units` and :guilabel:`Write Capacity
   Units` and click :guilabel:`Continue`.

#. On the next screen enter your email address in the :guilabel:`Send notification to:` text box and
   click :guilabel:`Continue`. The review screen appears.

#. Click :guilabel:`Create`. It may take a few minutes for your table to be created.

Set Permissions for DynamoDB
----------------------------

In order for your identity pool to access Amazon DynamoDB, you must modify the identity pool's
roles.

1. Navigate to the `Identity and Access Management Console`_ and click :guilabel:`Roles` in the
   left-hand pane. Search for your identity pool name - two roles will be listed one for
   unauthenticated users and one for authenticated users.

2. Click the role for unauthenticated users (it will have "unauth" appended to your identity pool
   name) and click :guilabel:`Create Role Policy`.

3. Select :guilabel:`Policy Generator` and click :guilabel:`Select`.

4. On the **Edit Permissions** page, enter the settings shown in the following image. The Amazon
   Resource Name (ARN) of a DynamoDB table looks like
   :code:`arn:aws:dynamodb:us-west-2:123456789012:table/Books` and is composed of the region in
   which the table is located, the owner's AWS account number, and the name of the table in the
   format :file:`table/Books`. For more information about specifying ARNs, see `Amazon Resource
   Names for DynamoDB`_.

   .. image:: images/edit-permissions-dynamodb.png

5. Click :guilabel:`Add Statement`, and then click :guilabel:`Next Step`. The Wizard will show you
   the configuration generated.

6. Click :guilabel:`Apply Policy`.

Add NuGet package for DynamoDB to Your Project
----------------------------------------------

Follow Step 4 of the instructions in :doc:`setup` to add the DynamoDB NuGet package to your project.

Initialize AmazonDynamoDBClient
===============================

Pass your initialized Amazon Cognito credentials provider and your region to the
:code:`AmazonDynamoDB` constructor, then pass the client to the DynamoDBContext::

  var client = new AmazonDynamoDBClient(credentials,region);
  DynamoDBContext context = new DynamoDBContext(client);

Create a Class
==============

To write a row to the table, define a class to hold your row data. The class should also contain
properties that hold the attribute data for the row and will be mapped to the DynamoDB Table created
in the console. The following class declaration illustrates such a class::

  [DynamoDBTable("Books")]
  public class Book
  {
      [DynamoDBHashKey]    // Hash key.
      public int Id { get; set; }
      public string Title { get; set; }
      public string ISBN { get; set; }
      public int Price { get; set; }
      public string PageCount { get; set; }
      public string Author{ get; set; }
  }

Save an Item
============

To save an item, first create an object::

  Book songOfIceAndFire = new Book()
  {
      Id=1,
      Title="Game Of Thrones",
      ISBN="978-0553593716",
      Price=4,
      PageCount="819",
      Author="GRRM"
  };

Then save it::

  context.Save(songOfIceAndFire);

To update a row, modify the instance of the :code:`DDTableRow` class and call
:code:`AWSDynamoObjectMapper.save()` as shown above.

Retrieve an Item
================

Retrieve an item using a primary key::

  Book retrievedBook = context.Load<Book>(1);

Update an Item
==============

To update an item::

  Book retrievedBook = context.Load<Book>(1);
  retrievedBook.ISBN = "978-0553593716";
  context.Save(retrievedBook);

Delete an Item
==============

To delete an item::

  Book retrievedBook = context.Load<Book>(1);
  context.Delete(retrievedBook);

For more information on accessing DynamoDB from a Xamarin application, see :doc:`dynamodb`.

.. _DynamoDB Console: https://console.aws.amazon.com/dynamodb/home
.. _Cognito Console: https://console.aws.amazon.com/cognito/home
.. _Identity and Access Management Console: https://console.aws.amazon.com/iam/home
.. _Amazon Resource Names for DynamoDB: http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/UsingIAMWithDDB.html#ARN_Format
.. _Working With Tables: http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithTables.html
