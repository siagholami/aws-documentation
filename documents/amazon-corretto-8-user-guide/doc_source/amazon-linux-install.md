# Amazon Corretto 8 Installation Instructions for Amazon Linux 2<a name="amazon-linux-install"></a>

 This topic describes how to install and uninstall Amazon Corretto 8 on a host or container running the Amazon Linux 2 operating system\. 

## Option 1: Use the yum Package Manager on Amazon Linux<a name="amazon-linux-install-instruct"></a>

1.  Enable the yum repository in Amazon Linux 2\.   
**Example**  

   ```
   sudo amazon-linux-extras enable corretto8
   ```

1.  You can install Amazon Corretto 8 as either the runtime environment \(JRE\) or the full development environment \(JDK\)\. The development environment includes the runtime environment\. 

   Install Amazon Corretto 8 as JRE\.  
**Example**  

   ```
   sudo yum install java-1.8.0-amazon-corretto
   ```

   Install Amazon Corretto 8 as JDK\.  
**Example**  

   ```
   sudo yum install java-1.8.0-amazon-corretto-devel
   ```

    The installation location is `/usr/lib/jvm/java-1.8.0-amazon-corretto.<cpu_arch>`\. 

## Option 2: Download and Install RPMs Manually<a name="amazon-linux-rpm-install-instruct"></a>

1.  Download RPMs from the [Downloads](downloads-list.md) page for your CPU architecture\. To install the JDK, you will need to download the RPMs for both the JDK and the JRE\. 

1.  Install using `yum localinstall`\.   
**Example**  

   ```
   sudo yum localinstall java-1.8.0-amazon-corretto*.rpm
   ```

## Verify Your Installation<a name="amazon-linux-verify"></a>

 In the terminal, run the following command to verify the installation\. 

**Example**  

```
java -version
```
Expected output for 8u232:   

```
openjdk version "1.8.0_232"
OpenJDK Runtime Environment Corretto-8.232.09.1 (build 1.8.0_232-b09)
OpenJDK 64-Bit Server VM Corretto-8.232.09.1 (build 25.232-b09, mixed mode)
```

 If you see a version string that doesn't mention `Corretto`, run the following command to change the default `java` or `javac` providers\. 

**Example**  

```
sudo alternatives --config java
```
If using the JDK you should also run:  

```
sudo alternatives --config javac
```

## Uninstall Amazon Corretto 8<a name="amazon-linux-uninstall"></a>

You can uninstall Amazon Corretto 8 with the following commands\.

Uninstall JRE:

**Example**  

```
sudo yum remove java-1.8.0-amazon-corretto
```

Uninstall JDK:

**Example**  

```
sudo yum remove java-1.8.0-amazon-corretto-devel
```