# Sample Code Prerequisites<a name="java-library-sample"></a>

The Java code samples included in this documentation show you how to use the [AWS CloudHSM software library for Java](java-library.md) to perform basic tasks in AWS CloudHSM\. Before running the samples, perform the following steps to set up your environment:
+ Install and configure the [AWS CloudHSM software library for Java](java-library-install.md) and the [AWS CloudHSM client package](install-and-configure-client-linux.md)\. 
+ Set up a valid [HSM user name and password](manage-hsm-users.md)\. Cryptographic user \(CU\) permissions are sufficient for these tasks\. Your application uses these credentials to log in to the HSM in each example\.
+ Decide how to specify the Cavium provider\.