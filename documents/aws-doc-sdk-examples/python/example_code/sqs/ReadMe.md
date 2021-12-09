# Amazon SQS getting started examples

## Purpose

Shows how to use the AWS SDK for Python (Boto3) to get started using queue and 
message operations in Amazon Simple Queue Service (Amazon SQS). Learn how to 
create, get, and remove standard, FIFO, and dead-letter queues. Learn how to 
send, receive, and delete messages from a queue.

## Prerequisites

- You must have an AWS account, and have your default credentials and AWS Region
  configured as described in the [AWS Tools and SDKs Shared Configuration and
  Credentials Reference Guide](https://docs.aws.amazon.com/credref/latest/refdocs/creds-config-files.html).
- Python 3.6 or later
- Boto 3 1.11.10 or later
- PyTest 5.3.5 or later (to run unit tests)

## Cautions

- As an AWS best practice, grant this code least privilege, or only the 
  permissions required to perform a task. For more information, see 
  [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) 
  in the *AWS Identity and Access Management 
  User Guide*.
- This code has not been tested in all AWS Regions. Some AWS services are 
  available only in specific Regions. For more information, see the 
  [AWS Region Table](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/)
  on the AWS website.
- Running this code might result in charges to your AWS account.

## Running the code

Both `queue_wrapper.py` and `message_wrapper.py` contain `usage_demo` functions
that demonstrate ways to use the functions in their respective modules. 
For example, to see the queue demonstration, run the module in a command window.

```
python -m queue_wrapper
``` 

You can also run individual functions in the Python shell to make requests to 
your AWS account. For example, run the following commands to create a queue, 
send a message, receive a message, print the message body, and delete the queue.  

    > python
    >>> import queue_wrapper
    >>> queue = queue_wrapper.create_queue("My-test-queue")
    >>> import message_wrapper
    >>> message_wrapper.send_message(queue, "Test message")
    >>> messages = message_wrapper.receive_messages(queue, 10, 10)
    >>> messages[0].body
    'Test message'
    >>> queue_wrapper.remove_queue(queue)

## Running the tests

The best way to learn how to use this service is to run the tests.
You can run the tests in two modes. By default, tests use the botocore Stubber,
which captures requests before they are sent to AWS and returns a mocked response.
Tests can also be run against your AWS account, in which case they will create and 
manipulate AWS resources, which may incur charges on your account.

To run all of the SQS tests with the botocore Stubber, run the following in
your [GitHub root]/python/example_code/sqs folder.

    python -m pytest -o log_cli=1 --log-cli-level=INFO

The '-o log_cli=1 --log-cli-level=INFO' flags configure pytest to output
logs to stdout during the test run. Without them, pytest captures logs and prints
them only when the test fails.

To run the tests using your AWS account and default shared credentials, include the
'--use-real-aws-may-incur-charges' flag.

    python -m pytest -o log_cli=1 --log-cli-level=INFO --use-real-aws-may-incur-charges

When run in this mode, a best effort is made to clean up any resources created during 
the test. But it's your responsibility to verify that all resources have actually 
been cleaned up.

## Additional information

- [Boto 3 Amazon SQS documentation](https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/sqs.html).

---
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.

SPDX-License-Identifier: Apache-2.0
