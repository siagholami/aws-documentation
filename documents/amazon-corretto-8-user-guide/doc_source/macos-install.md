# Amazon Corretto 8 Installation Instructions for macOS 10\.10 or later<a name="macos-install"></a>

 This topic describes how to install and uninstall Amazon Corretto 8 on a host running macOS version 10\.10 or later\. You must have administrator privileges to install and uninstall Amazon Corretto 8\. 

## Install Amazon Corretto 8<a name="macos-install-instruct"></a>

1.  Download the Mac `.pkg` file from the [Downloads](downloads-list.md) page\. 

1.  Double click the downloaded file to start the installation wizard\. Follow the steps in the wizard\. 

1.  Once the wizard completes, Amazon Corretto 8 will be installed in `/Library/Java/JavaVirtualMachines/`\. 

    You can run the following command in a terminal to get the complete installation path\.   
**Example**  

   ```
   /usr/libexec/java_home --verbose
   ```

1.  Optionally, run the following commands in the terminal to set the `JAVA_HOME` variable\.   
**Example**  

   ```
   export JAVA_HOME=/Library/Java/JavaVirtualMachines/amazon-corretto-8.jdk/Contents/Home
   ```

## Uninstall Amazon Corretto 8<a name="macos-uninstall"></a>

You can uninstall Amazon Corretto 8 by running the following commands in a terminal\.

**Example**  

```
cd /Library/Java/JavaVirtualMachines/
sudo rm -rf amazon-corretto-8.jdk
```