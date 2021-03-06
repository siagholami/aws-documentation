.. Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0
   International License (the "License"). You may not use this file except in compliance with the
   License. A copy of the License is located at http://creativecommons.org/licenses/by-nc-sa/4.0/.

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
   either express or implied. See the License for the specific language governing permissions and
   limitations under the License.

##############################################
|S3| Transfer Manager with |sdk-php| Version 3
##############################################

.. meta::
   :description: Upload, copy, or download files and directories to an Amazon S3 bucket using the AWS SDK for PHP version 3.
   :keywords: Amazon S3, AWS SDK for PHP version 3 examples, Amazon S3 for PHP code examples, Amazon S3 transfer


The |S3| transfer manager in the |sdk-php| is used to upload entire directories to 
an |S3| bucket and download entire buckets to a local directory.

Uploading a Local Directory to |S3|
===================================

The ``Aws\S3\Transfer`` object is used to perform transfers. The following
example shows how to recursively upload a local directory of files to an
|S3| bucket.

.. code-block:: php

    // Create an S3 client
    $client = new \Aws\S3\S3Client([
        'region'  => 'us-west-2',
        'version' => '2006-03-01',
    ]);

    // Where the files will be source from
    $source = '/path/to/source/files';

    // Where the files will be transferred to
    $dest = 's3://bucket';

    // Create a transfer object
    $manager = new \Aws\S3\Transfer($client, $source, $dest);

    // Perform the transfer synchronously
    $manager->transfer();

In this example, we created an |S3| client, created a ``Transfer`` object,
and performed transfer synchronously. Using the previous example demonstrates the
bare minimum amount of code needed to perform a transfer. The transfer object
can perform transfers asynchronously and has various configuration options you can
use to customize the transfers.

You can upload the local files to a "subfolder" of an |S3| bucket by
providing a key prefix in the ``s3://`` URI. The following example uploads the
local files on disk to the ``bucket`` bucket and stores the files under the
``foo`` key prefix.

.. code-block:: php

    $source = '/path/to/source/files';
    $dest = 's3://bucket/foo';
    $manager = new \Aws\S3\Transfer($client, $source, $dest);
    $manager->transfer();

Downloading an |S3| Bucket
==========================

You can recursively download an |S3| bucket to a local directory on disk
by specifying the ``$source`` argument as an |S3| URI
(e.g., ``s3://bucket``) and the ``$dest`` argument as the path to a local
directory.

.. code-block:: php

    // Where the files will be sourced from
    $source = 's3://bucket';

    // Where the files will be transferred to
    $dest = '/path/to/destination/dir';

    $manager = new \Aws\S3\Transfer($client, $source, $dest);
    $manager->transfer();

.. note::

    The SDK will automatically create any necessary directories when
    downloading the objects in the bucket.

You can include a key prefix in the |S3| URI after the bucket to download
only objects stored under a "pseudo-folder". The following example downloads
only files stored under the "/foo" key prefix of the given bucket.

.. code-block:: php

    $source = 's3://bucket/foo';
    $dest = '/path/to/destination/dir';
    $manager = new \Aws\S3\Transfer($client, $source, $dest);
    $manager->transfer();

Configuration
=============

The ``Transfer`` object constructor accepts the following arguments.

``$client``
    The ``Aws\ClientInterface`` object to use to perform the transfers.

``$source`` (string|``\Iterator``)
    The source data being transferred. This can point
    to a local path on disk (e.g., ``/path/to/files``) or an |S3| bucket
    (e.g., ``s3://bucket``). The ``s3://`` URI may also contain a key prefix
    that can be used to only transfer objects under a common prefix.

    If the ``$source`` argument is an |S3| URI, the ``$dest``
    argument must be a local directory (and vice versa).

    In addition to providing a string value, you can also provide an
    ``\Iterator`` object that yields absolute file names. If you provide an
    iterator, you **must** provide a ``base_dir`` option in the
    ``$options`` associative array.

``$dest``
    The destination where the files will be transferred. If the ``$source``
    argument is a local path on disk, ``$dest`` must be an |S3|
    bucket URI (e.g., ``s3://bucket``). If the ``$source`` argument is an
    |S3| bucket URI, the ``$dest`` argument must be a local path on
    disk.

``$options``
    An associative array of :ref:`transfer options <s3_transfer_options>`.

.. _s3_transfer_options:

Transfer Options
================

``base_dir`` (string)
    Base directory of the source, if ``$source`` is an iterator. If
    the ``$source`` option is not an array, then this option is ignored.

``before`` (callable)
    A callback to invoke before each transfer. The callback should
    have a function signature like ``function (Aws\Command $command) {...}``.
    The provided command will be a ``GetObject``, ``PutObject``,
    ``CreateMultipartUpload``, ``UploadPart``, or ``CompleteMultipartUpload``
    command.

``mup_threshold`` (int)
    Size in bytes in which a multipart upload should be used instead of
    ``PutObject``. Defaults to ``16777216`` (16 MB).

``concurrency`` (int, default=5)
    Number of files to upload concurrently. The ideal
    concurrency value will vary based on the number of files being uploaded and
    the average size of each file. Generally, smaller files benefit
    from a higher concurrency while larger files do not.

``debug`` (bool)
    Set to ``true`` to print out debug information for transfers. Set to
    an ``fopen()`` resource to write to a specific stream instead of writing
    to STDOUT.

Async Transfers
===============

The ``Transfer`` object is an instance of
``GuzzleHttp\Promise\PromisorInterface``. This means that the transfer can
occur asynchronously and is initiated by calling the ``promise`` method of the
object.

.. code-block:: php

    $source = '/path/to/source/files';
    $dest = 's3://bucket';
    $manager = new \Aws\S3\Transfer($client, $source, $dest);

    // Initiate the transfer and get a promise
    $promise = $manager->promise();

    // Do something when the transfer is complete using the then() method
    $promise->then(function () {
        echo 'Done!';
    });

The promise will be rejected if any of the files fail to transfer. You can
handle the failed transfer asynchronously using the ``otherwise`` method of the
promise. The ``otherwise`` function accepts a callback to invoke when an error
occurs. The callback accepts the ``$reason`` for the rejection, which will
typically be an instance of ``Aws\Exception\AwsException`` (although a value of
**any** type can be delivered to the callback).

.. code-block:: php

    $promise->otherwise(function ($reason) {
        echo 'Transfer failed: ';
        var_dump($reason);
    });

Because the ``Transfer`` object returns a promise, these transfers can occur
concurrently with other asynchronous promises.

Customizing the Transfer Manager's Commands
===========================================

Custom options can be set on the operations executed by the transfer manager via
a callback passed to its constructor.

.. code-block:: php

    $uploader = new Transfer($s3Client, $source, $dest, [
        'before' => function (\Aws\Command $command) {
            // Commands can vary for multipart uploads, so check which command
            // is being processed
            if (in_array($command->getName(), ['PutObject', 'CreateMultipartUpload'])) {
                // Set custom cache-control metadata
                $command['CacheControl'] = 'max-age=3600';
                // Apply a canned ACL
                $command['ACL'] = strpos($command['Key'], 'CONFIDENTIAL') ### false
                    ? 'public-read'
                    : 'private';
            }
        },
    ]);
