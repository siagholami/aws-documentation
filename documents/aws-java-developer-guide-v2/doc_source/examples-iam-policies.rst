.. Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

########################
Work with |IAM| policies
########################

.. meta::
   :description: How to create, attach and detach policies to IAM roles.
   :keywords: AWS SDK for Java 2.x code examples, IAM policies, CreatePolicyRequest,
              GetPolicyRequest, ListAttachedRolePoliciesRequest, DetachRolePolicyRequest


Create a policy
===============

To create a new policy, provide the policy's name and a JSON-formatted policy document in a
:aws-java-class:`CreatePolicyRequest <services/iam/model/CreatePolicyRequest>` to the
|iamclient|'s :methodname:`createPolicy` method.

**Imports**

.. literalinclude:: iam.java2.create_policy.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.create_policy.main.txt
   :dedent: 4
   :language: java
   
See the :sdk-examples-java-iam:`complete example <CreatePolicy.java>` on GitHub.


Get a policy
============

To retrieve an existing policy, call the |iamclient|'s :methodname:`getPolicy` method, providing the
policy's ARN within a :aws-java-class:`GetPolicyRequest
<services/iam/model/GetPolicyRequest>` object.

**Imports**

.. literalinclude:: iam.java2.get_policy.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.get_policy.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <GetPolicy.java>` on GitHub.


Attach a role policy
====================

You can attach a policy to an |IAM| :iam-ug:`role <id_roles>` by calling the |iamclient|'s
:methodname:`attachRolePolicy` method, providing it with the role name and policy ARN in an
:aws-java-class:`AttachRolePolicyRequest
<services/iam/model/AttachRolePolicyRequest>`.

**Imports**

.. literalinclude:: iam.java2.attach_role_policy.import.txt
   :language: java

**Code**
   
.. literalinclude:: iam.java2.attach_role_policy.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <AttachRolePolicy.java>` on GitHub.


List attached role policies
===========================

List attached policies on a role by calling the |iamclient|'s :methodname:`listAttachedRolePolicies`
method. It takes a :aws-java-class:`ListAttachedRolePoliciesRequest
<services/iam/model/ListAttachedRolePoliciesRequest>` object that contains the role
name to list the policies for.

Call :methodname:`getAttachedPolicies` on the returned
:aws-java-class:`ListAttachedRolePoliciesResponse
<services/iam/model/ListAttachedRolePoliciesResponse>` object to get the list of
attached policies. Results may be truncated; if the :classname:`ListAttachedRolePoliciesResponse`
object's :methodname:`isTruncated` method returns :code-java:`true`, call the
:classname:`ListAttachedRolePoliciesResponse` object's :methodname:`marker` method. Use the
marker returned to create a new request and use it to
call :methodname:`listAttachedRolePolicies` again to get the next batch of results.

**Imports**

.. literalinclude:: iam.java2.attach_role_policy.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.attach_role_policy.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <AttachRolePolicy.java>` on GitHub.


Detach a role policy
====================

To detach a policy from a role, call the |iamclient|'s :methodname:`detachRolePolicy` method,
providing it with the role name and policy ARN in a :aws-java-class:`DetachRolePolicyRequest
<services/iam/model/DetachRolePolicyRequest>`.

**Imports**

.. literalinclude:: iam.java2.detach_role_policy.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.detach_role_policy.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <DetachRolePolicy.java>` on GitHub.


More information
================

* :iam-ug:`Overview of IAM Policies <access_policies>` in the |iam-ug|.
* :iam-ug:`AWS IAM Policy Reference <reference_policies>` in the |iam-ug|.
* :iam-api:`CreatePolicy` in the |iam-api|
* :iam-api:`GetPolicy` in the |iam-api|
* :iam-api:`AttachRolePolicy` in the |iam-api|
* :iam-api:`ListAttachedRolePolicies` in the |iam-api|
* :iam-api:`DetachRolePolicy` in the |iam-api|
