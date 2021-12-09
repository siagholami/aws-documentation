.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

###############
Troubleshooting
###############

This topic describes some ideas for troubleshooting problems you might encounter when using the
|sdk-xamarin|.

Ensure IAM Role Has Required Permissions
========================================

When calling AWS services, your app should be using an identity from a Cognito identity pool. Each
identity in the pool is associated with an IAM (Identity and Access Management) role.

A role has one or more policy files associated with it that specify what AWS resources the users
assigned to the role have access to. By default, two roles are created per identity pool: one for
authenticated users and one for unauthenticated users.

You will need to either modify the existing policy file or associate a new policy file with the
permisssions required by your app. If your app allows both authenticated and unauthenticated users,
both roles must be granted permissions for accessing the AWS resources your app needs.

The following policy file shows how to grant access to an S3 bucket::

  {
     "Statement":[
        {
           "Action":[
              "s3:AbortMultipartUpload",
              "s3:DeleteObject",
              "s3:GetObject",
              "s3:PutObject"
           ],
           "Effect":"Allow",
           "Resource":"arn:aws:s3:::MYBUCKETNAME/*",
           "Principal":"*"
        }
     ]
  }

The following policy file shows how to grant access to a DynamoDB database::

  {
     "Statement":[
        {
           "Effect":"Allow",
           "Action":[
              "dynamodb:DeleteItem",
              "dynamodb:GetItem",
              "dynamodb:PutItem",
              "dynamodb:Scan",
              "dynamodb:UpdateItem"
           ],
           "Resource":"arn:aws:dynamodb:us-west-2:123456789012:table/MyTable"
        }
     ]
  }

For more information about specifying policies, see `IAM Policies`_.

Using a HTTP Proxy Debugger
===========================

If the AWS service your app is calling has an HTTP or HTTPS endpoint, you can use an HTTP/HTTPS
proxy debugger to view the requests and responsese to gain more insight into what is occuring. There
are a number of HTTP proxy debuggers available such as:

- `Charles`_ - a web debugging proxy for Windows and OSX
- `Fiddler`_ - a web debugging proxyfidd for Windows

Both Charles and Fiddler require some configuration to be able to view SSL encrypted traffic, please
read the documentation for these tools for further information. If you are using a web debugging
proxy that cannot be configured to display encrypted traffic, open the aws_endpoints_json file and
set the HTTP tag for the AWS service you need to debug to true.

.. _IAM Policies: http://docs.aws.amazon.com/IAM/latest/UserGuide/PoliciesOverview.html
.. _Charles: http://www.charlesproxy.com/
.. _Fiddler: http://www.telerik.com/fiddler
