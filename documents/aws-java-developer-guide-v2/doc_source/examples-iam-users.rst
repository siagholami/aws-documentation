.. Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

####################
Managing |IAM| Users
####################

.. meta::
   :description: How to create, list, update and delete IAM users.
   :keywords: AWS SDK for Java 2.x code examples, IAM users, CreateUserRequest,
              ListUsersRequest, UpdateUserRequest


Creating a User
===============

Create a new |IAM| user by providing the user name to the |iamclient|'s :methodname:`createUser`
method using a :aws-java-class:`CreateUserRequest
<services/iam/model/CreateUserRequest>` object containing the user name.

**Imports**

.. literalinclude:: iam.java2.create_user.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.create_user.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <CreateUser.java>` on GitHub.


Listing Users
=============

To list the |IAM| users for your account, create a new :aws-java-class:`ListUsersRequest
<services/iam/model/ListUsersRequest>` and pass it to the |iamclient|'s
:methodname:`listUsers` method. You can retrieve the list of users by calling :methodname:`users`
on the returned :aws-java-class:`ListUsersResponse
<services/iam/model/ListUsersResponse>` object.

The list of users returned by :methodname:`listUsers` is paged. You can check to see there are more
results to retrieve by calling the response object's :methodname:`isTruncated` method. If it
returns :code-java:`true`, then call the response object's :methodname:`marker()` method. Use the
marker value to create a new request object. Then call the :methodname:`listUsers` method again with
the new request.

**Imports**

.. literalinclude:: iam.java2.list_users.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.list_users.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <ListUsers.java>` on GitHub.


Updating a User
===============

To update a user, call the |iamclient| object's :methodname:`updateUser` method, which takes a
:aws-java-class:`UpdateUserRequest <services/iam/model/UpdateUserRequest>` object
that you can use to change the user's *name* or *path*.

**Imports**

.. literalinclude:: iam.java2.update_user.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.update_user.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <UpdateUser.java>` on GitHub.


Deleting a User
===============

To delete a user, call the |iamclient|'s :methodname:`deleteUser` request with a
:aws-java-class:`UpdateUserRequest <services/iam/model/UpdateUserRequest>` object set
with the user name to delete.

**Imports**

.. literalinclude:: iam.java2.delete_user.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.delete_user.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <DeleteUser.java>` on GitHub.

More Information
================

* :iam-ug:`IAM Users <id_users>` in the |iam-ug|
* :iam-ug:`Managing IAM Users <id_users_manage>` in the |iam-ug|
* :iam-api:`CreateUser` in the |iam-api|
* :iam-api:`ListUsers` in the |iam-api|
* :iam-api:`UpdateUser` in the |iam-api|
* :iam-api:`DeleteUser` in the |iam-api|
