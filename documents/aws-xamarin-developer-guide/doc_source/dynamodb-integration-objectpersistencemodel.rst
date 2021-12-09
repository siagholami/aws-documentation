.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

==================================
Using the Object Persistence Model
==================================

The |sdk-xamarin| provides an Object Persistence model that enables you to map your client-side
classes to a DynamoDB table. Each object instance then maps to an item in the corresponding table.
To save your client-side objects to a table, the Object Persistence model provides the
DynamoDBContext class, an entry point to DynamoDB. This class provides you a connection to DynamoDB
and enables you to access tables, perform various CRUD operations, and execute queries.

The Object Persistence model does not provide an API to create, update, or delete tables. It
provides only data operations. To create, update and delete tables, you must use the low-level API.
For instructions on how to use the low-level API, see :doc:`dynamodb-integration-lowlevelapi`.

Overview
========

The Object Persistence model provides a set of attributes to map client-side classes to tables, and
properties/fields to table attributes. The Object Persistence model supports both the explicit and
default mapping between class properties and table attributes.

- **Explicit mapping**: To map a property to a primary key, you must use the DynamoDBHashKey and
  DynamoDBRangeKey Object Persistence model attributes. Additionally, for the non-primary key
  attributes, if a property name in your class and the corresponding table attribute to which you
  want to map it are not the same, then you must define the mapping by explicitly adding the
  DynamoDBProperty attribute.

- **Default mapping** - By default, the Object Persistence model maps the class properties to the
  attributes with the same name in the table.

You do not have to map every single class property. You identify these properties by adding the
DynamoDBIgnore attribute. Saving and retrieving an instance of an object would omit any property
marked with this attribute.

Supported Data Types
====================

The Object Persistence model supports a set of primitive .NET data types, collections, and arbitrary
data types. The model supports the following primitive data types.

- bool
- byte
- char
- DateTime
- decimal, double, float
- Int16, Int32, Int64
- SByte
- string
- UInt16, UInt32, UInt64

The Object Persistence model also supports the .NET collection types with the following limitations:

- Collection type must implement ICollection interface.
- Collection type must be composed of the supported primitive types. For example, ICollection<string>, ICollection<bool>.
- Collection type must provide a parameter-less constructor.

For more information on the Object Persistence model, see `.NET Object Persistence Model
<https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DotNetSDKHighLevel.html>`_.

Create a DynamoDB Client
========================

To create a DynamoDB client::

  var client = new AmazonDynamoDBClient(credentials,region);
  DynamoDBContext context = new DynamoDBContext(client);

CRUD Operations
===============

Save an Object
--------------

Create an object::

  [DynamoDBTable("Books")]
  public class Book {
    [DynamoDBHashKey] // Hash key.
    public string Id {
      get;
      set;
    }

    [DynamoDBGlobalSecondaryIndexHashKey]
    public string Author {
      get;
      set;
    }

    [DynamoDBGlobalSecondaryIndexRangeKey]
    public string Title {
      get;
      set;
    }
    public string ISBN {
      get;
      set;
    }
    public int Price {
      get;
      set;
    }
    public string PageCount {
      get;
      set;
    }
  }

  Book myBook = new Book
  {
      Id = id,
      Author = "Charles Dickens",
      Title = "Oliver Twist",
      ISBN = "111-1111111001",
      Price = 10,
      PageCount = 300
  };

Save an object to a DynamoDB table::

  context.Save(myBook);

Retrieve an Object
------------------

To retrieve an object::

  Book retrievedBook = context.Load<Book>(1);

Update an Object
----------------

To update an object::

  Book retrievedBook = context.Load<Book>(1);
  retrievedBook.ISBN = "111-1111111001";
  context.Save(retrievedBook);

Delete an Object
----------------

To delete an object::

  Book retrievedBook = context.Load<Book>(1);
  context.Delete(retrievedBook);

Query and Scan
==============

To query and retrieve all books whose author is "Charles Dickens"::

  public async Task QueryAsync(AWSCredentials credentials, RegionEndpoint region) {
    var client = new AmazonDynamoDBClient(credentials, region);
    DynamoDBContext context = new DynamoDBContext(client);

    var search = context.FromQueryAsync < Book > (new Amazon.DynamoDBv2.DocumentModel.QueryOperationConfig() {
      IndexName = "Author-Title-index",
      Filter = new Amazon.DynamoDBv2.DocumentModel.QueryFilter("Author", Amazon.DynamoDBv2.DocumentModel.QueryOperator.Equal, "Charles Dickens")
    });

    Console.WriteLine("items retrieved");

    var searchResponse = await search.GetRemainingAsync();
    searchResponse.ForEach((s) = > {
      Console.WriteLine(s.ToString());
    });
  }

The scan example code below returns all books in our table::

  public async Task ScanAsync(AWSCredentials credentials, RegionEndpoint region) {
    var client = new AmazonDynamoDBClient(credentials, region);
    DynamoDBContext context = new DynamoDBContext(client);

    var search = context.FromScanAsync < Book > (new Amazon.DynamoDBv2.DocumentModel.ScanOperationConfig() {
     ConsistentRead = true
    });

    Console.WriteLine("items retrieved");

    var searchResponse = await search.GetRemainingAsync();
    searchResponse.ForEach((s) = > {
     Console.WriteLine(s.ToString());
    });
  }
