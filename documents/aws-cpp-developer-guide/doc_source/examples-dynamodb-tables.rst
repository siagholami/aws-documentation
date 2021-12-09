.. Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

############################
Working with Tables in |DDB|
############################

.. meta::
   :description: How to create, describe, modify (update) and delete Amazon DynamoDB tables.
   :keywords: AWS SDK for C++ code examples, DynamoDB tables


Tables are the containers for all items in a |DDB| database. Before you can add or remove data from
|DDB|, you must create a table.

For each table, you must define:

* A table *name* that is unique for your account and region.

* A *primary key* for which every value must be unique. No two items in your table can have the
  same primary key value.

  A primary key can be *simple*, consisting of a single partition (HASH) key, or *composite*, consisting
  of a partition and a sort (RANGE) key.

  Each key value has an associated *data type*, enumerated by the
  :aws-cpp-namespace:`ScalarAttributeType <aws_1_1_dynamo_d_b_1_1_model.html#a4b39ae66214e022d3737079d071e4bcb>`
  class. The key value can be binary (B), numeric (N), or a string (S). For more information, see
  :ddb-dg:`Naming Rules and Data Types <HowItWorks.NamingRulesDataTypes>` in the |ddb-dg|.

* *Provisioned throughput* values that define the number of reserved read/write capacity units
  for the table.

  .. tip:: :pricing:`Amazon DynamoDB pricing <dynamodb>` is based on the provisioned throughput
     values that you set on your tables, so reserve only as much capacity as you think
     you'll need for your table.

     Provisioned throughput for a table can be modified at any time, so you can adjust capacity
     if your needs change.

.. _dynamodb-create-table:

Create a Table
==============

Use the :aws-cpp-class:`DynamoDB client <aws_1_1_dynamo_d_b_1_1_dynamo_d_b_client>` :methodname:`CreateTable`
method to create a new |DDB| table. You need to construct table
attributes and a table schema, both of which are used to identify the primary key of your table. You
must also supply initial provisioned throughput values and a table name. :methodname:`CreateTable` is an asynchronous
operation. :methodname:`GetTableStatus` will return CREATING until the table is ACTIVE and ready for use.

.. _dynamodb-create-table-simple:

Create a Table with a Simple Primary Key
----------------------------------------

This code creates a table with a simple primary key ("Name").

**Includes**

.. literalinclude:: dynamodb.cpp.create_table.inc.txt

**Code**

.. literalinclude:: dynamodb.cpp.create_table.code.txt
   :dedent: 8

See the :sdk-examples-cpp:`complete example <dynamodb/create_table.cpp>`.

.. _dynamodb-create-table-composite:

Create a Table with a Composite Primary Key
---------------------------------------------

Add another
:aws-cpp-class:`AttributeDefinition <aws_1_1_dynamo_d_b_1_1_model_1_1_attribute_definition>` and
:aws-cpp-class:`KeySchemaElement <aws_1_1_dynamo_d_b_1_1_model_1_1_key_schema_element>` to
:aws-cpp-class:`CreateTableRequest <aws_1_1_dynamo_d_b_1_1_model_1_1_create_table_request>`.

**Includes**

.. literalinclude:: dynamodb.cpp.create_table_composite_key.inc.txt

**Code**

.. literalinclude:: dynamodb.cpp.create_table_composite_key.code.txt
   :dedent: 8

See the :sdk-examples-cpp:`complete example <dynamodb/create_table_composite_key.cpp>` on GitHub.

.. _dynamodb-list-tables:

List Tables
===========

You can list the tables in a particular region by calling the :aws-cpp-class:`DynamoDB client
<aws_1_1_dynamo_d_b_1_1_dynamo_d_b_client>` :methodname:`ListTables` method.

**Includes**

.. literalinclude:: dynamodb.cpp.list_tables.inc.txt

**Code**

.. literalinclude:: dynamodb.cpp.list_tables.code.txt
   :dedent: 8

By default, up to 100 tables are returned per call. Use
:methodname:`GetExclusiveStartTableName` on the returned :aws-cpp-class:`ListTablesOutcome <aws_1_1_dynamo_d_b_1_1_dynamo_d_b_client>` object
to get the last table that was evaluated. You can use this value to start the
listing after the last returned value of the previous listing.

See the :sdk-examples-cpp:`complete example <dynamodb/list_tables.cpp>`.

.. _dynamodb-describe-table:

Retrieve Information about a Table
==================================

You can find out more about a table by calling the :aws-cpp-class:`DynamoDB client
<aws_1_1_dynamo_d_b_1_1_dynamo_d_b_client>` :methodname:`DescribeTable` method.

**Includes**

.. literalinclude:: dynamodb.cpp.describe_table.inc.txt

**Code**

.. literalinclude:: dynamodb.cpp.describe_table.code.txt
   :dedent: 8

See the :sdk-examples-cpp:`complete example <dynamodb/describe_table.cpp>` on GitHub.

.. _dynamodb-update-table:

Modify a Table
==============

You can modify your table's provisioned throughput values at any time by calling the
:aws-cpp-class:`DynamoDB client <aws_1_1_dynamo_d_b_1_1_dynamo_d_b_client>`
:methodname:`UpdateTable` method.

**Includes**

.. literalinclude:: dynamodb.cpp.update_table.inc.txt

**Code**

.. literalinclude:: dynamodb.cpp.update_table.code.txt
   :dedent: 8

See the :sdk-examples-cpp:`complete example <dynamodb/update_table.cpp>`.

.. _dynamodb-delete-table:

Delete a Table
==============

Call the :aws-cpp-class:`DynamoDB client <aws_1_1_dynamo_d_b_1_1_dynamo_d_b_client>`
:methodname:`DeleteTable` method and pass it the table's name.

**Includes**

.. literalinclude:: dynamodb.cpp.delete_table.inc.txt

**Code**

.. literalinclude:: dynamodb.cpp.delete_table.code.txt
   :dedent: 8

See the :sdk-examples-cpp:`complete example <dynamodb/delete_table.cpp>` on GitHub.

More Info
=========

* :ddb-dg:`Guidelines for Working with Tables <GuidelinesForTables>` in the |ddb-dg|
* :ddb-dg:`Working with Tables in DynamoDB <WorkingWithTables>` in the |ddb-dg|
