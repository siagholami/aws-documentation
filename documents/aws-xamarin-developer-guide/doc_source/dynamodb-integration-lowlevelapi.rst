.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

=====================================
Using the DynamoDB Service Level APIs
=====================================

The Dynamo Service Level APIs allow you to create, update and delete tables. You can also perform
typical create, read, update, and delete (CRUD) operations on items in a table using this API.

Create a DynamoDB Client
========================

To create a DynamoDB client::

  AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials,region);

CRUD Operations
===============

Save an Item
------------

To save an item to a DynamoDB table::

  // Create a client
  AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials,region);

  // Define item attributes
  Dictionary<string, AttributeValue> attributes = new Dictionary<string, AttributeValue>();

  // Author is hash-key
  attributes["Author"] = new AttributeValue { S = "Mark Twain" };
  attributes["Title"] = new AttributeValue { S = "The Adventures of Tom Sawyer" };
  attributes["PageCount"] = new AttributeValue { N = "275" };
  attributes["Price"] = new AttributeValue{N = "10.00"};
  attributes["Id"] = new AttributeValue{N="10"};
  attributes["ISBN"] = new AttributeValue{S="111-1111111"};

  // Create PutItem request
  PutItemRequest request = new PutItemRequest
  {
      TableName = "Books",
      Item = attributes
  };

  // Issue PutItem request
  var response = await client.PutItemAsync(request);

Retrieve an Item
------------------

To retrieve an item::

  // Create a client
  AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials,region);

  Dictionary<string, AttributeValue> key = new Dictionary<string, AttributeValue>
  {
      { "Id", new AttributeValue { N = "10" } }
  };

  // Create GetItem request
  GetItemRequest request = new GetItemRequest
  {
      TableName = "Books",
      Key = key,
  };

  // Issue request
  var result = await client.GetItemAsync(request);

  // View response
  Console.WriteLine("Item:");
  Dictionary<string, AttributeValue> item = result.Item;
  foreach (var keyValuePair in item)
  {
      Console.WriteLine("Author := {0}", item["Author"]);
      Console.WriteLine("Title := {0}", item["Title"]);
      Console.WriteLine("Price:= {0}", item["Price"]);
      Console.WriteLine("PageCount := {0}", item["PageCount"]);
  }


Update an Item
--------------

To update an item::

  // Create a client
  AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials,region);

  Dictionary<string, AttributeValue> key = new Dictionary<string, AttributeValue>
  {
      { "Id", new AttributeValue { N = "10" } }
  };

  // Define attribute updates
  Dictionary<string, AttributeValueUpdate> updates = new Dictionary<string, AttributeValueUpdate>();
  // Add a new string to the item's Genres SS attribute
  updates["Genres"] = new AttributeValueUpdate()
  {
      Action = AttributeAction.ADD,
      Value = new AttributeValue { SS = new List<string> { "Bildungsroman" } }
  };

  // Create UpdateItem request
  UpdateItemRequest request = new UpdateItemRequest
  {
      TableName = "Books",
      Key = key,
      AttributeUpdates = updates
  };

  // Issue request
  var response = await client.UpdateItemAsync(request);


Delete an Item
--------------

To delete an item::

  // Create a client
  AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials,region);

  Dictionary<string, AttributeValue> key = new Dictionary<string, AttributeValue>
  {
    { "Id", new AttributeValue { N = "10" } }
  };

  // Create DeleteItem request
  DeleteItemRequest request = new DeleteItemRequest
  {
    TableName = "Books",
    Key = key
  };

  // Issue request
  var response = await client.DeleteItemAsync(request);

Query and Scan
==============

To query and retrieve all books whose author is "Mark Twain"::

  public void Query(AWSCredentials credentials, RegionEndpoint region) {
    using(var client = new AmazonDynamoDBClient(credentials, region)) {
      var queryResponse = await client.QueryAsync(new QueryRequest() {
        TableName = "Books",
        IndexName = "Author-Title-index",
        KeyConditionExpression = "Author = :v_Id",
        ExpressionAttributeValues = new Dictionary < string, AttributeValue > {
          {
            ":v_Id", new AttributeValue {
              S = "Mark Twain"
            }
          }
        }
      });
      queryResponse.Items.ForEach((i) = > {
        Console.WriteLine(i["Title"].S);
      });

    }
  }

The scan example code below returns all books in our table::

  public void Scan(AWSCredentials credentials, RegionEndpoint region) {
  	using(var client = new AmazonDynamoDBClient(credentials, region)) {
  		var queryResponse = client.Scan(new ScanRequest() {
  			TableName = "Books"
  		});
  		queryResponse.Items.ForEach((i) = > {
  			Console.WriteLine(i["Title"].S);
  		});
  	}
  }
