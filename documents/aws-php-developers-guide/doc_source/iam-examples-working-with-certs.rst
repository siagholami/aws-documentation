.. Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

###############################################################
Working with |IAM| Server Certificates with |sdk-php| Version 3
###############################################################

.. meta::
   :description: List, update, and get information about certificates using AWS Identity and Access Management (IAM).
   :keywords: AWS Identity and Access Management (IAM) code examples, AWS SDK for PHP version 3

To enable HTTPS connections to your website or application on AWS, you need an SSL/TLS server certificate. To use a certificate that you obtained from an external provider with your website or application on AWS, you must upload the certificate to |IAM| or import it into |ACMlong|.

The following examples show how to:

* List the certificates stored in |IAM| using :aws-php-class:`ListServerCertificates <api-iam-2010-05-08.html#listservercertificates>`.
* Retrieve information about a certificate using :aws-php-class:`GetServerCertificate <api-iam-2010-05-08.html#getservercertificate>`.
* Update a certificate using :aws-php-class:`UpdateServerCertificate <api-iam-2010-05-08.html#updateservercertificate>`.
* Delete a certificate using :aws-php-class:`DeleteServerCertificate <api-iam-2010-05-08.html#deleteservercertificate>`.

.. include:: text/git-php-examples.txt


List Server Certificates
========================

**Imports**

.. literalinclude::  iam.php.list_server_certificates.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: iam.php.list_server_certificates.main.txt
   :language: PHP


Retrieve a Server Certificate
=============================

**Imports**

.. literalinclude::  iam.php.get_server_certificate.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: iam.php.get_server_certificate.main.txt
   :language: PHP


Update a Server Certificate
===========================

**Imports**

.. literalinclude::  iam.php.update_server_certificate.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: iam.php.update_server_certificate.main.txt
   :language: PHP


Delete a Server Certificate
===========================

**Imports**

.. literalinclude::  iam.php.delete_server_certificate.import.txt
   :language: PHP

**Sample Code**

.. literalinclude:: iam.php.delete_server_certificate.main.txt
   :language: PHP