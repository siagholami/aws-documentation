.. Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

########################
Manage |IAM| access keys
########################

.. meta::
   :description: How to manage IAM access keys with the AWS SDK for Java 2.x.
   :keywords: AWS SDK for Java 2.x, code examples, IAM access keys, creating, listing, updating,
              deleting, getting last access time, CreateAccessKeyRequest, ListAccessKeysRequest,
              GetAccessKeyLastUsedRequest


Create an access key
====================

To create an |IAM| access key, call the |iamclient|'s :methodname:`createAccessKey` method with a
:aws-java-class:`CreateAccessKeyRequest <services/iam/model/CreateAccessKeyRequest>`
object.

.. note:: You must set the region to :guilabel:`AWS_GLOBAL` for |iamclient| calls to work because
   |IAM| is a global service.

**Imports**

.. literalinclude:: iam.java2.create_access_key.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.create_access_key.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <CreateAccessKey.java>` on GitHub.


List access keys
================

To list the access keys for a given user, create a :aws-java-class:`ListAccessKeysRequest
<services/iam/model/ListAccessKeysRequest>` object that contains the user name to
list keys for, and pass it to the |iamclient|'s :methodname:`listAccessKeys` method.

.. note:: If you do not supply a user name to :methodname:`listAccessKeys`, it will attempt to list
   access keys associated with the AWS account that signed the request.

**Imports**

.. literalinclude:: iam.java2.list_access_keys.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.list_access_keys.main.txt
   :dedent: 4
   :language: java

The results of :methodname:`listAccessKeys` are paged (with a default maximum of 100 records per
call). You can call :methodname:`isTruncated` on the returned
:aws-java-class:`ListAccessKeysResponse <services/iam/model/ListAccessKeysResponse>`
object to see if the query returned fewer results then are available. If so, then call
:methodname:`marker` on the :classname:`ListAccessKeysResponse` and use it when creating
a new request. Use that new request in the next
invocation of :methodname:`listAccessKeys`.

See the :sdk-examples-java-iam:`complete example <ListAccessKeys.java>` on GitHub.


Retrieve an access key's last used time
=======================================

To get the time an access key was last used, call the |iamclient|'s
:methodname:`getAccessKeyLastUsed` method with the access key's ID (which can be passed in using a
:aws-java-class:`GetAccessKeyLastUsedRequest
<services/iam/model/GetAccessKeyLastUsedRequest>` object.

You can then use the returned :aws-java-class:`GetAccessKeyLastUsedResponse
<services/iam/model/GetAccessKeyLastUsedResponse>` object to retrieve the key's last
used time.

**Imports**

.. literalinclude:: iam.java2.access_key_last_used.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.access_key_last_used.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <AccessKeyLastUsed.java>` on GitHub.


.. _iam-access-keys-update:

Activate or deactivate access keys
==================================

You can activate or deactivate an access key by creating an :aws-java-class:`UpdateAccessKeyRequest
<services/iam/model/UpdateAccessKeyRequest>` object, providing the access key ID,
optionally the user name, and the desired :aws-java-class:`status <services/iam/model/StatusType>`,
then passing the request object to the
|iamclient|'s :methodname:`updateAccessKey` method.

**Imports**

.. literalinclude:: iam.java2.update_access_key.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.update_access_key.main.txt
   :dedent: 7
   :language: java

See the :sdk-examples-java-iam:`complete example <UpdateAccessKey.java>` on GitHub.


Delete an access key
====================

To permanently delete an access key, call the |iamclient|'s :methodname:`deleteKey` method,
providing it with a :aws-java-class:`DeleteAccessKeyRequest
<services/iam/model/DeleteAccessKeyRequest>` containing the access key's ID and
username.

.. note:: Once deleted, a key can no longer be retrieved or used. To temporarily deactivate a key so
   that it can be activated again later, use :ref:`updateAccessKey <iam-access-keys-update>` method
   instead.

**Imports**

.. literalinclude:: iam.java2.delete_access_key.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.delete_access_key.main.txt
   :dedent: 4
   :language: java
   
See the :sdk-examples-java-iam:`complete example <DeleteAccessKey.java>` on GitHub.


More information
================

* :iam-api:`CreateAccessKey` in the |iam-api|
* :iam-api:`ListAccessKeys` in the |iam-api|
* :iam-api:`GetAccessKeyLastUsed` in the |iam-api|
* :iam-api:`UpdateAccessKey` in the |iam-api|
* :iam-api:`DeleteAccessKey` in the |iam-api|
