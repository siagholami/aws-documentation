.. Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

########################
Work with items in |DDB|
########################

.. meta::
   :description: How to retrieve (get), add, and update items in Amazon DynamoDB tables.
   :keywords: AWS for Java SDK code examples, items from DynamoDB tables


In |ddb|, an item is a collection of *attributes*, each of which has a *name* and a *value*. An
attribute value can be a scalar, set, or document type. For more information, see :ddb-dg:`Naming
Rules and Data Types <HowItWorks.NamingRulesDataTypes>` in the |ddb-dg|.


.. _dynamodb-get-item:

Retrieve (get) an item from a table
===================================

Call the |ddbclient|'s :methodname:`getItem` method and pass it a
:aws-java-class:`GetItemRequest <services/dynamodb/model/GetItemRequest>` object with the table
name and primary key value of the item you want. It returns a
:aws-java-class:`GetItemResponse <services/dynamodb/model/GetItemResponse>` object with
all of the attributes for that item. You can specify one or more
:DDB-dg:`projection expressions <Expressions.ProjectionExpressions>`
in the :classname:`GetItemRequest` to retrieve specific attributes.

You can use the returned :classname:`GetItemResponse` object's :methodname:`item()` method to
retrieve a :javase-ref:`Map <java/util/Map>` of key (String) and value
(:aws-java-class:`AttributeValue <services/dynamodb/model/AttributeValue>`) pairs that are associated
with the item.

**Imports**

.. literalinclude:: dynamodb.java2.get_item.import.txt
   :language: java

**Code**

.. literalinclude:: dynamodb.java2.get_item.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-dynamodb:`complete example <GetItem.java>` on GitHub.


.. _dynamodb-get-item:

Retrieve (get) an item from a table using the asynchronous client
=================================================================

Invoke the :methodname:`getItem` method of the |ddbasyncclient| and pass it a
:aws-java-class:`GetItemRequest <services/dynamodb/model/GetItemRequest>` object with the table
name and primary key value of the item you want.

You can return a :javase-ref:`Collection <java/util/Collection>` instance with
all of the attributes for that item (refer to the following example).

**Imports**

.. literalinclude:: dynamoasyn.java2.get_item.import.txt
   :language: java

**Code**

.. literalinclude:: dynamoasyc.java2.get_item.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-dynamodbasync:`complete example <DynamoDBAsyncGetItem.java>` on GitHub.

.. _dynamodb-add-item:

Add a new item to a table
=========================

Create a :javase-ref:`Map <java/util/Map>` of key-value pairs that
represent the item's attributes. These must include values for the table's primary key fields. If the
item identified by the primary key already exists, its fields are *updated* by the request.

.. note:: If the named table doesn't exist for your account and region, a
   :aws-java-class:`ResourceNotFoundException <services/dynamodb/model/ResourceNotFoundException>` is
   thrown.

**Imports**

.. literalinclude:: dynamodb.java2.put_item.import.txt
   :language: java

**Code**

.. literalinclude:: dynamodb.java2.put_item.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-dynamodb:`complete example <PutItem.java>` on GitHub.


.. _dynamodb-update-item:

Update an existing item in a table
==================================

You can update an attribute for an item that already exists in a table by using the |ddbclient|'s
:methodname:`updateItem` method, providing a table name, primary key value, and a map of fields to
update.

.. note:: If the named table doesn't exist for your account and region, or if the item identified by
   the primary key you passed in doesn't exist, a :aws-java-class:`ResourceNotFoundException
   <services/dynamodb/model/ResourceNotFoundException>` is thrown.

**Imports**

.. literalinclude:: dynamodb.java2.update_item.import.txt
   :language: java

**Code**

.. literalinclude:: dynamodb.java2.update_item.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-dynamodb:`complete example <UpdateItem.java>` on GitHub.

.. _dynamodb-delete-item:

Delete an existing item in a table
==================================

You can delete an item that exists in a table by using the |ddbclient|'s
:methodname:`deleteItem` method and providing a table name as well as the primary key value.

.. note:: If the named table doesn't exist for your account and region, or if the item identified by
   the primary key you passed in doesn't exist, a :aws-java-class:`ResourceNotFoundException
   <services/dynamodb/model/ResourceNotFoundException>` is thrown.

**Imports**

.. literalinclude:: dynamodb.java2.delete_item.import.txt
   :language: java

**Code**

.. literalinclude:: dynamodb.java2.delete_item.main.txt
   :dedent: 2
   :language: java

See the :sdk-examples-java-dynamodb:`complete example <DeleteItem.java>` on GitHub.


More information
================

* :ddb-dg:`Guidelines for Working with Items <GuidelinesForItems>` in the |ddb-dg|
* :ddb-dg:`Working with Items in DynamoDB <WorkingWithItems>` in the |ddb-dg|
