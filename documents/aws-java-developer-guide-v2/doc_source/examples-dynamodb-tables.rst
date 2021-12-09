.. Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

#########################
Work with tables in |DDB|
#########################

.. meta::
   :description: How to create, describe, modify (update) and delete Amazon DynamoDB tables.
   :keywords: AWS SDK for Java 2.x code examples, DynamoDB tables


Tables are the containers for all items in a |DDB| database. Before you can add or remove data from
|DDB|, you must create a table.

For each table, you must define:

* A table *name* that is unique for your account and region.

* A *primary key* for which every value must be unique; no two items in your table can have the
  same primary key value.

  A primary key can be *simple*, consisting of a single partition (HASH) key, or *composite*, consisting
  of a partition and a sort (RANGE) key.

  Each key value has an associated *data type*, enumerated by the
  :aws-java-class:`ScalarAttributeType <services/dynamodb/model/ScalarAttributeType>` class. The key
  value can be binary (B), numeric (N), or a string (S). For more information, see
  :ddb-dg:`Naming Rules and Data Types <HowItWorks.NamingRulesDataTypes>` in the |ddb-dg|.

* *Provisioned throughput* are values that define the number of reserved read/write capacity units
  for the table.

  .. tip:: :pricing:`Amazon DynamoDB pricing <dynamodb>` is based on the provisioned throughput
     values that you set on your tables, so reserve only as much capacity as you think
     you'll need for your table.

     Provisioned throughput for a table can be modified at any time, so you can adjust capacity
     as your needs change.

.. _dynamodb-create-table:

Create a table
==============

Use the |ddbclient|'s
:methodname:`createTable` method to create a new |DDB| table. You need to construct table
attributes and a table schema, both of which are used to identify the primary key of your table. You
must also supply initial provisioned throughput values and a table name.

.. note:: If a table with the name you chose already exists, an
   :aws-java-class:`DynamoDbException <services/dynamodb/model/DynamoDbException>` is thrown.

.. These Imports/Code headings are sufficient without the colons


**Imports**

.. literalinclude:: dynamodb.java2.create_table.import.txt
   :language: java


.. _dynamodb-create-table-simple:

Create a table with a simple primary key
----------------------------------------

This code creates a table with a simple primary key ("Name").

**Code**

.. literalinclude:: dynamodb.java2.create_table.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-dynamodb:`complete example <CreateTable.java>` on GitHub.

.. _dynamodb-create-table-composite:

Create a table with a composite primary key
-------------------------------------------

Add another
:aws-java-class:`AttributeDefinition <services/dynamodb/model/AttributeDefinition>` and
:aws-java-class:`KeySchemaElement <services/dynamodb/model/KeySchemaElement>` to
:aws-java-class:`CreateTableRequest <services/dynamodb/model/CreateTableRequest>`.

**Imports**

.. literalinclude:: dynamodb.java2.create_table_composite_key.import.txt
   :language: java

**Code**

.. literalinclude:: dynamodb.java2.create_table_composite_key.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-dynamodb:`complete example <CreateTableCompositeKey.java>` on GitHub.

.. _dynamodb-list-tables:

List tables
===========

You can list the tables in a particular region by calling the |ddbclient|'s
:methodname:`listTables` method.

.. note:: If the named table doesn't exist for your account and region, a
   :aws-java-class:`ResourceNotFoundException <services/dynamodb/model/ResourceNotFoundException>`
   is thrown.

**Imports**

.. literalinclude:: dynamodb.java2.list_tables.import.txt
   :language: java

**Code**

.. literalinclude:: dynamodb.java2.list_tables.main.txt
   :dedent: 4
   :language: java

By default, up to 100 tables are returned per call |mdash| use
:methodname:`lastEvaluatedTableName` on the returned
:aws-java-class:`ListTablesResponse <services/dynamodb/model/ListTablesResponse>` object
to get the last table that was evaluated. You can use this value to start the
listing after the last returned value of the previous listing.

See the :sdk-examples-java-dynamodb:`complete example <ListTables.java>` on GitHub.

.. _dynamodb-describe-table:

Describe (get information about) a table
========================================

Call the |ddbclient|'s :methodname:`describeTable` method.

.. note:: If the named table doesn't exist for your account and region, a
   :aws-java-class:`ResourceNotFoundException <services/dynamodb/model/ResourceNotFoundException>`
   is thrown.

**Imports**

.. literalinclude:: dynamodb.java2.describe_table.import.txt
   :language: java

**Code**

.. literalinclude:: dynamodb.java2.describe_table.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-dynamodb:`complete example <DescribeTable.java>` on GitHub.


.. _dynamodb-update-table:

Modify (update) a table
=======================

You can modify your table's provisioned throughput values at any time by calling the
|ddbclient|'s :methodname:`updateTable`
method.

.. note:: If the named table doesn't exist for your account and region, a
   :aws-java-class:`ResourceNotFoundException <services/dynamodb/model/ResourceNotFoundException>`
   is thrown.

**Imports**

.. literalinclude:: dynamodb.java2.update_table.import.txt
   :language: java

**Code**

.. literalinclude:: dynamodb.java2.update_table.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-dynamodb:`complete example <UpdateTable.java>` on GitHub.


.. _dynamodb-delete-table:

Delete a table
==============

Call the |ddbclient|'s
:methodname:`deleteTable` method and pass it the table's name.

.. note:: If the named table doesn't exist for your account and region, a
   :aws-java-class:`ResourceNotFoundException <services/dynamodb/model/ResourceNotFoundException>`
   is thrown.

**Imports**

.. literalinclude:: dynamodb.java2.delete_table.import.txt
   :language: java

**Code**

.. literalinclude:: dynamodb.java2.delete_table.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-dynamodb:`complete example <DeleteTable.java>` on GitHub.

More information
================

* :ddb-dg:`Guidelines for Working with Tables <GuidelinesForTables>` in the |ddb-dg|
* :ddb-dg:`Working with Tables in DynamoDB <WorkingWithTables>` in the |ddb-dg|
