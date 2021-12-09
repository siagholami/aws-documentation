.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

.. _dynamodb:

===============
Amazon DynamoDB
===============

What is Amazon DynamoDB?
========================

`Amazon DynamoDB <http://aws.amazon.com/dynamodb/>`_ is a fast, highly scalable non-relational
database service. DynamoDB removes traditional scalability limitations on data storage while
maintaining low latency and predictable performance.

Key Concepts
============

The DynamoDB data model concepts include tables, items, and attributes.

Tables
------

In Amazon DynamoDB, a database is a collection of tables. A table is a collection of items and each
item is a collection of attributes.

In a relational database, a table has a predefined schema such as the table name, primary key, list
of its column names and their data types. All records stored in the table must have the same set of
columns. In contrast, DynamoDB only requires that a table has a primary key, but does not require
you to define all of the attribute names and data types in advance.

To learn more about working with tables, see `Working with Tables in DynamoDB
<http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithTables.html>`_.

Items and Attributes
--------------------

Individual items in a DynamoDB table can have any number of attributes, although there is a limit of
400 KB on the item size. An item size is the sum of lengths of its attribute names and values
(binary and UTF-8 lengths).

Each attribute in an item is a name-value pair. An attribute can be single-valued or multi-valued
set. For example, a book item can have title and authors attributes. Each book has one title but can
have many authors. The multi-valued attribute is a set; duplicate values are not allowed.

For example, consider storing a catalog of products in DynamoDB. You can create a table,
ProductCatalog, with the Id attribute as its primary key. The primary key uniquely identifies each
item, so that no two products in the table can have the same ID.

To learn more about working with items, see `Working with Items in DynamoDB
<http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/WorkingWithItems.html>`_.

Data Types
----------

Amazon DynamoDB supports the following data types:

* **Scalar types** – Number, String, Binary, Boolean, and Null.
* **Multi-valued types** – String Set, Number Set, and Binary Set.
* **Document types** – List and Map.

For more information about Scalar Data Types, Multi-Valued Data Types, and Document Data Types, see
`DynamoDB Data Types
<http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModel.DataTypes>`_.

Primary Key
-----------

When you create a table, in addition to the table name, you must specify the primary key of the
table. The primary key uniquely identifies each item in the table, so that no two items can have the
same key. DynamoDB supports the following two types of primary keys:

- **Hash Key**: The primary key is made of one attribute, a hash attribute. DynamoDB builds an
  unordered hash index on this primary key attribute. Each item in the table is uniquely identified
  by its hash key value.

- **Hash and Range Key**: The primary key is made of two attributes. The first attribute is the hash
  attribute and the second one is the range attribute. DynamoDB builds an unordered hash index on
  the hash primary key attribute, and a sorted range index on the range primary key attribute. Each
  item in the table is uniquely identified by the combination of its hash and range key values. It
  is possible for two items to have the same hash key value, but those two items must have different
  range key values.

Secondary Indexes
-----------------

When you create a table with a hash and range key, you can optionally define one or more secondary
indexes on that table. A secondary index lets you query the data in the table using an alternate
key, in addition to queries against the primary key.

DynamoDB supports two kinds of secondary indexes: local secondary indexes and global secondary
indexes.

- **Local secondary index**: An index that has the same hash key as the table, but a different range
  key.

- **Global secondary index**: An index with a hash and range key that can be different from those on
  the table.

You can define up to 5 global secondary indexes and 5 local secondary indexes per table. For more
information, see `Improving Data Access with Secondary Indexes in DynamoDB
<http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/SecondaryIndexes.html>`_ in the
DynamoDB Developer Guide.

Query and Scan
--------------

In addition to using primary keys to access items, Amazon DynamoDB also provides two APIs for
searching the data: Query and Scan. We recommend that you read `Guidelines for Query and Scan
<http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScanGuidelines.html>`_ in
the DynamoDB Developer Guide to familiarize yourself with some best practices.

Query
~~~~~

A Query operation finds items in a table or a secondary index using only primary key attribute
values. You must provide a hash key attribute name and a distinct value to search for. You can
optionally provide a range key attribute name and value, and use a comparison operator to refine the
search results.

For sample queries, see:

- :doc:`dynamodb-integration-docmodel`
- :doc:`dynamodb-integration-objectpersistencemodel`
- :doc:`dynamodb-integration-lowlevelapi`

For more information on Query, see `Query
<http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#QueryAndScan.Query>`_
in the DynamoDB Developer Guide.

Scan
~~~~

A Scan operation reads every item in a table or a secondary index. By default, a Scan operation
returns all of the data attributes for every item in the table or index. You can use the
ProjectionExpression parameter so that Scan only returns some of the attributes, rather than all of
them.

For sample scans, see:

- :doc:`dynamodb-integration-docmodel`
- :doc:`dynamodb-integration-objectpersistencemodel`
- :doc:`dynamodb-integration-lowlevelapi`

For more information on Scan, see `Scan
<http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#QueryAndScan.Scan>`_
in the DynamoDB Developer Guide.

Project Setup
=============

Prerequisites
-------------

To use DynamoDB in your application, you'll need to add the SDK to your project. To do so, follow
the instructions in :doc:`setup`.

Create a DynamoDB Table
-----------------------

To create a table, go to the `DynamoDB console <https://console.aws.amazon.com/dynamodb/home>`_ and
follow these steps:

#. Click :strong:`Create Table`.

#. Enter the name of the table.

#. Select :strong:`Hash` as the primary key type.

#. Select a type and enter a value for the hash attribute name. Click :strong:`Continue`.

#. On the **Add Indexes** page, if you plan to to use global secondary indexes, set **Index Type**
   to "Global Secondary Index" and under **Index Hash Key**, enter a value for the secondary index.
   This will allow you to query and scan using both the primary index and secondary index. Click
   **Add Index To Table**, and then click :strong:`Continue`. To skip using global secondary
   indexes, click :strong:`Continue`.

#. Set the read and write capacity to your desired levels. For more information on configuring
   capacity, see `Provisioned Throughput in Amazon DynamoDB
   <https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html>`_.
   Click :strong:`Continue`.

#. On the next screen, enter a notification email to create throughput alarms, if desired. Click
   :strong:`Continue`.

#. On the summary page, click :strong:`Create`. DynamoDB will create your database.

Set Permissions for DynamoDB
----------------------------

To use DynamoDB in an application, you must set the correct permissions. The following IAM policy
allows the user to delete, get, put, query, scan, and update items in a specific DynamoDB table,
which is identified by `ARN
<http://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html>`_::

  {
    "Statement": [
      {
        "Effect": "Allow",
        "Action": [
          "dynamodb:DeleteItem",
          "dynamodb:GetItem",
          "dynamodb:PutItem",
          "dynamodb:Query",
          "dynamodb:Scan",
          "dynamodb:UpdateItem"
        ],
        "Resource": "arn:aws:dynamodb:us-west-2:123456789012:table/MyTable"
      }
    ]
  }

You can modify policies in the `IAM console <https://console.aws.amazon.com/iam/>`_. You should add
or remove allowed actions based on the needs of your app.

To learn more about IAM policies, see `Using IAM
<http://docs.aws.amazon.com/IAM/latest/UserGuide/IAM_Introduction.html>`_.

To learn more about DynamoDB-specific policies, see `Using IAM to Control Access to DynamoDB
Resources <http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/UsingIAMWithDDB.html>`_
in the DynamoDB Developer Guide.

Integrating DynamoDB with your Application
==========================================

The |sdk-xamarin| provides a high-level library for working with DynamoDB. You can also make
requests directly against the low-level DynamoDB API, but for most use cases the high-level library
is recommended. The AmazonDynamoDBClient is an especially useful part of the high-level library.
Using this class, you can perform various create, read, update, and delete (CRUD) operations and
execute queries.

The |sdk-xamarin| allows you to make calls using APIs from the AWS SDK for .NET to work with
DynamoDB. All of the APIs are available in the AWSSDK.dll. For information about downloading the AWS
SDK for .NET, see `AWS SDK for .NET <https://aws.amazon.com/sdk-for-net/>`_.

There are three ways you can interact with DynamoDB in your Xamarin application:

* **Document Model**: This API provides wrapper classes around the low-level DyanmoDB API to further
  simplify your programming tasks. The Table and Document are the key wrapper classes. You can use
  the document model for the data operations such as create, retrieve, update and delete items. The
  API is available in the Amazon.DynamoDB.DocumentModel namespace.

* **Object Persistence Model**: The Object Persistence API enables you to map your client-side
  classes to the DynamoDB tables. Each object instance then maps to an item in the corresponding
  tables. The DynamoDBContext class in this API provides methods for you to save client-side objects
  to a table, retrieve items as objects and perform query and scan. You can use the Object
  Persistence model for the data operations such as create, retrieve, update and delete items. You
  must first create your tables using the Service Client API and then use the object persistence
  model to map your classes to the tables. The API is available in the Amazon.DynamoDB.DataModel
  namespace.

* **Service Client API**: This is the protocol-level API that maps closely to the DynamoDB API. You
  can use this low-level API for all table and item operations such as create, update, delete table
  and items. You can also query and scan your tables. This API is available in the Amazon.DynamoDB
  namespace.

These three models are explored in-depth in the following topics:

.. toctree::
	:maxdepth: 1

	dynamodb-integration-docmodel
	dynamodb-integration-objectpersistencemodel
	dynamodb-integration-lowlevelapi
