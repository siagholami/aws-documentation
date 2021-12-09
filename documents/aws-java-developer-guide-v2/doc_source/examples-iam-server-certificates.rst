.. Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

###################################
Work with |IAM| server certificates
###################################

.. meta::
   :description: How to get, list, update and delete IAM server certificates.
   :keywords: AWS SDK for Java 2.x code examples, IAM server certificates,
              GetServerCertificateRequest, ListServerCertificatesRequest,
              UpdateServerCertificateRequest


To enable HTTPS connections to your website or application on AWS, you need an SSL/TLS *server
certificate*. You can use a server certificate provided by |acmlong| or one that you obtained from
an external provider.

We recommend that you use |acm| to provision, manage, and deploy your server certificates. With
|acm| you can request a certificate, deploy it to your AWS resources, and let |acm| handle
certificate renewals for you. Certificates provided by |acm| are free. For more information about
|acm| , see the |acm-ug|_.


Get a server certificate
========================

You can retrieve a server certificate by calling the |iamclient|'s
:methodname:`getServerCertificate` method, passing it a :aws-java-class:`GetServerCertificateRequest
<services/iam/model/GetServerCertificateRequest>` with the certificate's name.

**Imports**

.. literalinclude:: iam.java2.get_server_certificate.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.get_server_certificate.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <GetServerCertificate.java>` on GitHub.


List server certificates
========================

To list your server certificates, call the |iamclient|'s :methodname:`listServerCertificates` method
with a :aws-java-class:`ListServerCertificatesRequest
<services/iam/model/ListServerCertificatesRequest>`. It returns a
:aws-java-class:`ListServerCertificatesResponse
<services/iam/model/ListServerCertificatesResponse>`.

Call the returned :classname:`ListServerCertificateResponse` object's
:methodname:`serverCertificateMetadataList` method to get a list of
:aws-java-class:`ServerCertificateMetadata
<services/iam/model/ServerCertificateMetadata>` objects that you can use to get
information about each certificate.

Results may be truncated; if the :classname:`ListServerCertificateResponse` object's
:methodname:`isTruncated` method returns :code-java:`true`, call the
:classname:`ListServerCertificatesResponse` object's :methodname:`marker` method and use
the marker to create a new request. Use the new request to
call :methodname:`listServerCertificates` again to get the next batch of results.

**Imports**

.. literalinclude:: iam.java2.list_server_certificates.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.list_server_certificates.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <ListServerCertificates.java>` on GitHub.


Update a server certificate
===========================

You can update a server certificate's name or path by calling the |iamclient|'s
:methodname:`updateServerCertificate` method. It takes a
:aws-java-class:`UpdateServerCertificateRequest
<services/iam/model/UpdateServerCertificateRequest>` object set with the server
certificate's current name and either a new name or new path to use.

**Imports**

.. literalinclude:: iam.java2.update_server_certificate.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.update_server_certificate.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <UpdateServerCertificate.java>` on GitHub.


Delete a server certificate
===========================

To delete a server certificate, call the |iamclient|'s :methodname:`deleteServerCertificate` method
with a :aws-java-class:`DeleteServerCertificateRequest
<services/iam/model/DeleteServerCertificateRequest>` containing the certificate's
name.

**Imports**

.. literalinclude:: iam.java2.delete_server_certificate.import.txt
   :language: java

**Code**

.. literalinclude:: iam.java2.delete_server_certificate.main.txt
   :dedent: 4
   :language: java

See the :sdk-examples-java-iam:`complete example <DeleteServerCertificate.java>` on GitHub.


More information
================

* :iam-ug:`Working with Server Certificates <id_credentials_server-certs>` in the |iam-ug|
* :iam-api:`GetServerCertificate` in the |iam-api|
* :iam-api:`ListServerCertificates` in the |iam-api|
* :iam-api:`UpdateServerCertificate` in the |iam-api|
* :iam-api:`DeleteServerCertificate` in the |iam-api|
* |acm-ug|_
