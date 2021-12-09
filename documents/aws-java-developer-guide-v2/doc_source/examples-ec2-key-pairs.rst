.. Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

#########################
Work with |EC2| key pairs
#########################

.. meta::
   :description: How to create, list and delete EC2 key pairs using the AWS SDK for Java 2.x.
   :keywords: AWS SDK for Java 2.x, code examples, EC2 key pairs, create key pair, list key pairs, delete
              key pair


Create a key pair
=================

To create a key pair, call the |ec2client|'s :methodname:`createKeyPair` method with a
:aws-java-class:`CreateKeyPairRequest <services/ec2/model/CreateKeyPairRequest>` that contains the
key's name.

**Imports**

.. literalinclude:: ec2.java2.create_key_pair.import.txt
   :language: java

**Code**

.. literalinclude:: ec2.java2.create_key_pair.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-ec2:`complete example <CreateKeyPair.java>` on GitHub.


Describe key pairs
==================

To list your key pairs or to get information about them, call the |ec2client|'s
:methodname:`describeKeyPairs` method. It returns a :aws-java-class:`DescribeKeyPairsResponse
<services/ec2/model/DescribeKeyPairsResponse>` that you can use to access the list of key pairs by
calling its :methodname:`keyPairs` method, which returns a list of :aws-java-class:`KeyPairInfo
<services/ec2/model/KeyPairInfo>` objects.

**Imports**

.. literalinclude:: ec2.java2.describe_key_pairs.import.txt
   :language: java

**Code**

.. literalinclude:: ec2.java2.describe_key_pairs.main.txt
   :dedent: 4
   :language: java


See the :sdk-examples-java-ec2:`complete example <DescribeKeyPairs.java>` on GitHub.


Delete a key pair
=================

To delete a key pair, call the |ec2client|'s :methodname:`deleteKeyPair` method, passing it a
:aws-java-class:`DeleteKeyPairRequest <services/ec2/model/DeleteKeyPairRequest>` that contains the
name of the key pair to delete.

**Imports**

.. literalinclude:: ec2.java2.delete_key_pair.import.txt
   :language: java

**Code**

.. literalinclude:: ec2.java2.delete_key_pair.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-ec2:`complete example <DeleteKeyPair.java>` on GitHub.


More information
================

* :ec2-ug:`Amazon EC2 Key Pairs <ec2-key-pairs>` in the |ec2-ug|
* :ec2-api:`CreateKeyPair` in the |ec2-api|
* :ec2-api:`DescribeKeyPairs` in the |ec2-api|
* :ec2-api:`DeleteKeyPair` in the |ec2-api|
