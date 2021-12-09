# Amazon Corretto 8 Installation Instructions for Debian\-Based and RPM\-Based Linux Distributions<a name="generic-linux-install"></a>

This topic describes how to install Amazon Corretto 8 on Debian\-based and RPM\-based Linux distributions\. 

If you need to install Amazon Corretto 8 on Amazon Linux 2, see [Installing on Amazon Linux 2](amazon-linux-install.md)\.

## Install Amazon Corretto 8 on Debian\-Based Linux<a name="debian-install-instruct"></a>

This section describes how to install and uninstall Amazon Corretto 8 on a host or container running a Debian\-based operating system\.

### Using apt<a name="amazon-corretto-yum-verify"></a>

To use the Corretto Apt repositories on Debian\-based systems, such as Ubuntu, import the Corretto public key and then add the repository to the system list by using the following commands: 

**Example**  

```
 wget -O- https://apt.corretto.aws/corretto.key | sudo apt-key add - 
 sudo add-apt-repository 'deb https://apt.corretto.aws stable main'
```

After the repository is added, you can install Corretto 8 by running this command:

**Example**  

```
 sudo apt-get update; sudo apt-get install -y java-1.8.0-amazon-corretto-jdk
```

### Download and Install the Debian Package Manually<a name="debian-deb-install-instruct"></a>

1.  Download the Linux `.deb` file from the [Downloads](downloads-list.md) page\. Before you install the JDK, install the `java-common` package\.   
**Example**  

   ```
   sudo apt-get update && sudo apt-get install java-common
   ```

1.  Install the `.deb` file by using `dpkg --install`\. e\.g\. install x86\_64 deb using the following command:  
**Example**  

   ```
   sudo dpkg --install java-1.8.0-amazon-corretto-jdk_8.232.09-1_amd64.deb
   ```

### Verify Your Installation<a name="debian-deb-verify"></a>

 In the terminal, run the following command to verify the installation\. 

**Example**  

```
java -version
```
For example, expected output for Corretto\-8\.232\.09\.1:   

```
openjdk version "1.8.0_232"
OpenJDK Runtime Environment Corretto-8.232.09.1 (build 1.8.0_232-b09)
OpenJDK 64-Bit Server VM Corretto-8.232.09.1 (build 25.232-b09, mixed mode)
```

 If you see a version string that doesn't mention `Corretto`, run the following command to change the default `java` or `javac` providers\. 

**Example**  

```
sudo update-alternatives --config java
```
If you're using the JDK, you should also run the following\.  

```
sudo update-alternatives --config javac
```

### Uninstall Amazon Corretto 8<a name="debian-deb-uninstall"></a>

You can uninstall Amazon Corretto 8 by using the following command\.

Uninstall JDK:

**Example**  

```
sudo dpkg --remove java-1.8.0-amazon-corretto-jdk
```

## Install Amazon Corretto 8 on RPM\-Based Linux<a name="rpm-linux-install-instruct"></a>

### Using yum<a name="amazon-corretto-yum-install-instruct"></a>

To use Corretto RPM repositories with the yum package manager \(such as Amazon Linux AMI\), import the Corretto public key and then add the repository to the system list\. For most systems, you must run the following commands:

**Example**  

```
 sudo rpm --import https://yum.corretto.aws/corretto.key 
 sudo curl -L -o /etc/yum.repos.d/corretto.repo https://yum.corretto.aws/corretto.repo
```

After the repository is added, you can install Corretto 8 by running this command:

**Example**  

```
sudo yum install -y java-1.8.0-amazon-corretto-devel
```

### Using zypper<a name="w4aab9b9b9b5"></a>

To use Corretto RPM repositories with the zyppr package manager \(such as openSUSE\), import the Corretto public key and then add the repository to the system list by running the following commands: 

**Example**  

```
sudo zypper addrepo https://yum.corretto.aws/corretto.repo; sudo zypper refresh
```

After the repository is added, you can install Corretto 8 by running this command: 

**Example**  

```
sudo zypper install java-1.8.0-amazon-corretto-devel
```

### Download and install RPM package manually<a name="rpm-install-instruct"></a>

1.  Download the Linux `.rpm` file from the [Downloads](downloads-list.md) page\. 

1.  Install the downloaded `.rpm` file using `yum localinstall`\. e\.g\. install x86\_64 rpm using the following command:   
**Example**  

   ```
   sudo yum localinstall java-1.8.0-amazon-corretto-devel-1.8.0_232.b09-1.x86_64.rpm
   ```

### Verify Your Installation<a name="rpm-verify"></a>

 In the terminal, run the following command to verify the installation\. 

**Example**  

```
java -version
```
For example, expected output for Corretto\-8\.232\.09\.1:   

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
If you're using the JDK, you should also run the following\.  

```
sudo alternatives --config javac
```

### Uninstall Amazon Corretto 8<a name="rpm-uninstall"></a>

You can uninstall Amazon Corretto 8 by using the following

Uninstall JDK:

**Example**  

```
sudo yum remove java-1.8.0-amazon-corretto-devel
```