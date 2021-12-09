.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

########################
Using the Document Model
########################

The Document Model provides wrapper classes around the low-level .NET API. The Table and Document
are the key wrapper classes. You can use the Document Model to create, retrieve, update and delete
items. To create, update and delete tables, you must use the low-level API. For instructions on how
to use the low-level API, see :doc:`dynamodb-integration-lowlevelapi`. The low-level API is
available in the Amazon.DynamoDB.DocumentModel namespace.

To learn more about the Document Model, see `.NET Document Model
<http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DotNetSDKMidLevel.html>`_.

Create a DynamoDB Client
========================

To create a DynamoDB client::

  var client = new AmazonDynamoDBClient(credentials,region);
  DynamoDBContext context = new DynamoDBContext(client);

CRUD Operations
===============

Save an Item
------------

Create an item::

  Table table = Table.LoadTable(client, "Books");
  id = Guid.NewGuid().ToString();
  var books = new Document();
  books["Id"] = id;
  books["Author"] = "Mark Twain";
  books["Title"] = "Adventures of Huckleberry Finn";
  books["ISBN"] = "112-111111";
  books["Price"] = "10";

Save an item to a DynamoDB table::

  var book = await table.PutItemAsync(books);

Retrieve an Item
----------------

To retrieve an item::

  public async Task GetItemAsync(AWSCredentials credentials, RegionEndpoint region)
  {
  	var client = new AmazonDynamoDBClient(credentials, region);
  	Table books = Table.LoadTable(client, "Books");
  	var book = await books.GetItemAsync(id);
  }

Update an Item
--------------

To update an item::

  public async Task UpdateItemAttributesAsync(AWSCredentials credentials, RegionEndpoint region)
  {
  	var book = new Document();
  	book["Id"] = id;
  	book["PageCount"] = "200";
  	var client = new AmazonDynamoDBClient(credentials, region);
  	Table books = Table.LoadTable(client, "Books");
  	Document updatedBook = await books.UpdateItemAsync(book);
  }

To update an item conditionally::

  public async Task UpdateItemConditionallyAsync(AWSCredentials credentials, RegionEndpoint region) {
  	var book = new Document();
  	book["Id"] = id;
  	book["Price"] = "30";

  	// For conditional price update, creating a condition expression.
  	Expression expr = new Expression();
  	expr.ExpressionStatement = "Price = :val";
  	expr.ExpressionAttributeValues[":val"] = 10.00;

  	var client = new AmazonDynamoDBClient(credentials, region);
  	Table books = Table.LoadTable(client, "Books");

  	Document updatedBook = await books.UpdateItemAsync(book);
  }

Delete an Item
--------------

To delete an item::

  public async Task DeleteItemAsync(AWSCredentials credentials, RegionEndpoint region)
  {
    var client = new AmazonDynamoDBClient(credentials, region);
    Table books = Table.LoadTable(client, "Books");
    await books.DeleteItemAsync(id);
  }

Query and Scan
--------------

To query and retrieve all books whose author is "Mark Twain"::

  public async Task QueryAsync(AWSCredentials credentials, RegionEndpoint region) {
    var client = new AmazonDynamoDBClient(credentials, region);
    Table books = Table.LoadTable(client, "Books");
    var search = books.Query(new QueryOperationConfig() {
     IndexName = "Author-Title-index",
     Filter = new QueryFilter("Author", QueryOperator.Equal, "Mark Twain")
    });
    Console.WriteLine("ScanAsync: printing query response");
    var documents = await search.GetRemainingAsync();
    documents.ForEach((d) = > {
     PrintDocument(d);
    });
  }

The scan example code below returns all books in our table::

  public async Task ScanAsync(AWSCredentials credentials, RegionEndpoint region) {
  	var client = new AmazonDynamoDBClient(credentials, region);
  	Table books = Table.LoadTable(client, "Books");
  	var search = books.Scan(new ScanOperationConfig() {
  		ConsistentRead = true
  	});
  	Console.WriteLine("ScanAsync: printing scan response");
  	var documents = await search.GetRemainingAsync();
  	documents.ForEach((d) = > {
  		PrintDocument(d);
  	});
  }
