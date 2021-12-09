.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

.. highlight:: csharp

===============================
Using the Service Level S3 APIs
===============================

In addition to using the S3 TransferUtility, you can also interact with S3 using the low-level S3
APIs.

Initialize the Amazon S3 Client
===============================

To use Amazon S3, we first need to create an AmazonS3Client instance which takes a reference to the
CognitoAWSCredentials instance you created previously and your region::

  AmazonS3Client S3Client = new AmazonS3Client (credentials,region);

Download a File
===============

To download a file from S3::

  // Create a GetObject request
  GetObjectRequest request = new GetObjectRequest
  {
      BucketName = "SampleBucket",
      Key = "Item1"
  };

  // Issue request and remember to dispose of the response
  using (GetObjectResponse response = client.GetObject(request))
  {
      using (StreamReader reader = new StreamReader(response.ResponseStream))
      {
          string contents = reader.ReadToEnd();
          Console.WriteLine("Object - " + response.Key);
          Console.WriteLine(" Version Id - " + response.VersionId);
          Console.WriteLine(" Contents - " + contents);
      }
  }

Upload a File
=============

To upload a file to S3::

  // Create a client
  AmazonS3Client client = new AmazonS3Client();

  // Create a PutObject request
  PutObjectRequest request = new PutObjectRequest
  {
      BucketName = "SampleBucket",
      Key = "Item1",
      FilePath = "contents.txt"
  };

  // Put object
  PutObjectResponse response = client.PutObject(request);

Delete an Item
==============

To delete an item in S3::

  // Create a client
  AmazonS3Client client = new AmazonS3Client();

  // Create a DeleteObject request
  DeleteObjectRequest request = new DeleteObjectRequest
  {
      BucketName = "SampleBucket",
      Key = "Item1"
  };

  // Issue request
  client.DeleteObject(request);

Delete Multiple Items
=====================

To delete multiple objects from a bucket using a single HTTP request::

  // Create a client
  AmazonS3Client client = new AmazonS3Client();

  // Create a DeleteObject request
  DeleteObjectsRequest request = new DeleteObjectsRequest
  {
      BucketName = "SampleBucket",
      Objects = new List<KeyVersion>
      {
          new KeyVersion() {Key = "Item1"},
          // Versioned item
          new KeyVersion() { Key = "Item2", VersionId = "Rej8CiBxcZKVK81cLr39j27Y5FVXghDK", },
          // Item in subdirectory
          new KeyVersion() { Key = "Logs/error.txt"}
      }
  };

  try
  {
      // Issue request
      DeleteObjectsResponse response = client.DeleteObjects(request);
  }
  catch (DeleteObjectsException doe)
  {
      // Catch error and list error details
      DeleteObjectsResponse errorResponse = doe.Response;

      foreach (DeletedObject deletedObject in errorResponse.DeletedObjects)
      {
          Console.WriteLine("Deleted item " + deletedObject.Key);
      }
      foreach (DeleteError deleteError in errorResponse.DeleteErrors)
      {
          Console.WriteLine("Error deleting item " + deleteError.Key);
          Console.WriteLine(" Code - " + deleteError.Code);
          Console.WriteLine(" Message - " + deleteError.Message);
      }
  }

You may specify up to 1000 keys.

List Buckets
============

To return a list of all buckets owned by the authenticated sender of the request::

  // Create a client
  AmazonS3Client client = new AmazonS3Client();

  // Issue call
  ListBucketsResponse response = client.ListBuckets();

  // View response data
  Console.WriteLine("Buckets owner - {0}", response.Owner.DisplayName);
  foreach (S3Bucket bucket in response.Buckets)
  {
      Console.WriteLine("Bucket {0}, Created on {1}", bucket.BucketName, bucket.CreationDate);
  }

List Objects
============

You can returns some or all (up to 1000) of the objects stored in your S3 bucket. To do so, you must
have read access to the bucket.

::

  // Create a GetObject request
  GetObjectRequest request = new GetObjectRequest
  {
    BucketName = "SampleBucket",
    Key = "Item1"
  };

  // Issue request and remember to dispose of the response
  using (GetObjectResponse response = client.GetObject(request))
  {
    using (StreamReader reader = new StreamReader(response.ResponseStream))
    {
        string contents = reader.ReadToEnd();
        Console.WriteLine("Object - " + response.Key);
        Console.WriteLine(" Version Id - " + response.VersionId);
        Console.WriteLine(" Contents - " + contents);
    }
  }

Get a Bucket's Region
=====================

To obtain the region that a bucket resides in::

  // Create a client
  AmazonS3Client client = new AmazonS3Client();

  // Construct request
  GetBucketLocationRequest request = new GetBucketLocationRequest
  {
      BucketName = "SampleBucket"
  };

  // Issue call
  GetBucketLocationResponse response = client.GetBucketLocation(request);

  // View response data
  Console.WriteLine("Bucket location - {0}", response.Location);

Get a Bucket's Policy
=====================

To get a bucket's policy::

  // Create a client
  AmazonS3Client client = new AmazonS3Client();

  // Construct request
  GetBucketPolicyRequest getRequest = new GetBucketPolicyRequest
  {
     BucketName = "SampleBucket"
  };
  string policy = client.GetBucketPolicy(getRequest).Policy;

  Console.WriteLine(policy);
  Debug.Assert(policy.Contains("BasicPerms"));
