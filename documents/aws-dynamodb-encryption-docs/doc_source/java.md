# Amazon DynamoDB Encryption Client for Java<a name="java"></a>

This topic explains how to install and use the Amazon DynamoDB Encryption Client for Java\. For details about programming with the DynamoDB Encryption Client, see the [Java examples](java-examples.md), the [examples](https://github.com/aws/aws-dynamodb-encryption-java/tree/master/examples) in the aws\-dynamodb\-encryption\-java repository on GitHub, and the [Javadoc](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/) for the DynamoDB Encryption Client\.

**Topics**
+ [Prerequisites](#java-prerequisites)
+ [Installation](#java-installation)
+ [Using the DynamoDB Encryption Client for Java](java-using.md)
+ [Java examples](java-examples.md)

## Prerequisites<a name="java-prerequisites"></a>

Before you install the Amazon DynamoDB Encryption Client for Java, be sure you have the following prerequisites\.

**A Java development environment**  
You will need Java 8 or later\. On the Oracle website, go to [Java SE Downloads](https://www.oracle.com/technetwork/java/javase/downloads/index.html), and then download and install the Java SE Development Kit \(JDK\)\.  
If you use the Oracle JDK, you must also download and install the [Java Cryptography Extension \(JCE\) Unlimited Strength Jurisdiction Policy Files](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html)\.

**AWS SDK for Java**  
The DynamoDB Encryption Client requires the DynamoDB module of the AWS SDK for Java even if your application doesn't interact with DynamoDB\. You can install the entire SDK or just this module\. If you are using Maven, add `aws-java-sdk-dynamodb` to your `pom.xml` file\.   
For more information about installing and configuring the AWS SDK for Java, see [AWS SDK for Java](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/getting-started.html)\.

## Installation<a name="java-installation"></a>

You can install the Amazon DynamoDB Encryption Client for Java in the following ways\.

**Manually**  
To install the Amazon DynamoDB Encryption Client for Java, clone or download the [aws\-dynamodb\-encryption\-java](https://github.com/aws/aws-dynamodb-encryption-java/) GitHub repository\.

**Using Apache Maven**  
The Amazon DynamoDB Encryption Client for Java is available through [Apache Maven](https://maven.apache.org/) with the following dependency definition\.  

```
<dependency>
  <groupId>com.amazonaws</groupId>
  <artifactId>aws-dynamodb-encryption-java</artifactId>
  <version>version-number</version>
</dependency>
```

After you install the SDK, get started by looking at the example code in this guide and the [DynamoDB Encryption Client Javadoc](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/) on GitHub\.