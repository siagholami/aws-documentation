# Amazon S3 Java code examples

This README discusses how to run and test the Java code examples for Amazon Simple Storage Service (Amazon S3).

## Running the Amazon S3 Java files

**IMPORTANT**

The Java examples perform AWS operations for the account and AWS Region for which you've specified credentials, and you may incur AWS service charges by running them. See the [AWS Pricing page](https://aws.amazon.com/pricing/) for details about the charges you can expect for a given service and operation.   

Some of these examples perform *destructive* operations on AWS resources, such as deleting an Amazon S3 bucket. **Be very careful** when running an operation that deletes or modifies AWS resources in your account. It's best to create separate test-only resources when experimenting with these examples.

To run these examples, you'll need the AWS SDK for Java libraries in your **CLASSPATH**.

	export CLASSPATH=target/sdk-s3-examples-1.0.jar:/path/to/aws-java-sdk/<jar-file-name>.jar

Here **/path/to/aws-java-sdk/<jar-file-name>.jar** is the path to where you extracted or built the AWS SDK for Java JAR file.

For systems with Bash support, once you set the **CLASSPATH**, you can run a particular example as follows.

	java com.example.s3.S3BucketOps


 ## Testing the Amazon S3 Java files

You can test the Amazon S3 Java code examples by running a test file named **AmazonS3ServiceIntegrationTest**. This file uses JUnit 5 to run the JUnit tests and is located in the **src/test/java** folder. For more information, see [https://junit.org/junit5/](https://junit.org/junit5/).

You can execute the JUnit tests from a Java IDE, such as IntelliJ, or from the command line by using Maven. As each test is executed, you can view messages that inform you if the various tests succeed or fail. For example, the following message informs you that Test 3 passed.

	Test 3 passed

**WARNING**: _Running these JUnit tests manipulates real Amazon S3 resources and may incur charges on your account._

 ### Properties file
Before running the Amazon S3 JUnit tests, you must define values in the **config.properties** file located in the **src/main/resources** folder. This file contains values that are required to execute the JUnit tests. For example, you define an object key required for various tests. If you do not define all values, the JUnit tests fail.

Define these values to successfully run the JUnit tests:

- **bucketName** - The name of the bucket to use. For example, **buckettestfeb7**.

- **bucketNamePolicy** - The name of an existing bucket to which a policy is applied (used in the **setBucketPolicy** and **getBucketPolicy** tests). 

- **presignBucket** - The name of the bucket to use in presign operations. For example, **bucketpresign**.

- **objectKey** – The name of the object to use. For example, **book.pdf**.

- **presignKey** – The name of the text object to use in the presign tests. For example, **note.txt**.

- **path** – The path name used in the **GetObjectData** test. For example **/AWS/AdobePDF.pdf**.

- **objectPath** – The path where the object is located. For example, **/AWS/book2.pdf**.

- **toBucket** - The name of another bucket in your account. For example, **febbucket101**.

- **policyText** – The location of a text file that defines a policy. For example, **/AWS/bucketpolicy.txt** (an example of this file is shown below).

- **id**  - The ID of the user who owns the bucket. You can get this value from the AWS Management Console. This value appears as a GUID value (choose the *Permissions* tab, and then the *Access Control List* tab).

- **access** - The access level to test an ACL with. You can specify one of these values: **FULL_CONTROL**, **READ**, **WRITE**, **READ_ACP**, **WRITE_ACP**.

###  Sample policy text

For the purpose of the JUnit tests, you can use the following example content for the policy text. Be sure to specify the correct Amazon Resource Name (ARN) bucket name in the **Resource** section; otherwise, your test is not successful.

	{
   	  "Version":"2012-10-17",
   	  "Statement":[
      	{
         "Sid":"PublicRead",
         "Effect":"Allow",
         "Principal":"*",
         "Action":[
            "s3:GetObject",
            "s3:GetObjectVersion"
         ],
         "Resource":[
            "arn:aws:s3:::<change to an existing bucket>/*"
         ]
      }
   ]
}

### Command line

To execute the JUnit tests from the command line, you can use the following command.

		mvn test

You will see output from the JUnit tests, as shown here.

	[INFO] -------------------------------------------------------
	[INFO]  T E S T S
	[INFO] -------------------------------------------------------
	[INFO] Running AWSS3ServiceIntegrationTest
	Running Amazon S3 Test 1
	Running Amazon S3 Test 2
	...
	Done!
	[INFO] Results:
	[INFO]
	[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
	[INFO]
	INFO] --------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO]--------------------------------------------
	[INFO] Total time:  12.003 s
	[INFO] Finished at: 2020-02-10T14:25:08-05:00
	[INFO] --------------------------------------------

### Unsuccessful tests

If you do not define the correct values in the properties file, your JUnit tests are not successful. You will see an error message such as the following. You need to double-check the values that you set in the properties file and run the tests again. Also, ensure that you specify the correct resource name in the **Sample policy** text file, and the correct owner ID value (you can retrieve this value from the AWS Management Console).

	[INFO]
	[INFO] --------------------------------------
	[INFO] BUILD FAILURE
	[INFO] --------------------------------------
	[INFO] Total time:  19.038 s
	[INFO] Finished at: 2020-02-10T14:41:51-05:00
	[INFO] ---------------------------------------
	[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.22.1:test (default-test) on project S3J2Project:  There are test failures.
	[ERROR];
