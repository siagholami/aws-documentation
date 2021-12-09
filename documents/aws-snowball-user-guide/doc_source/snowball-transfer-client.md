--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Transferring Data with the Snowball Client<a name="snowball-transfer-client"></a>

The Snowball client is a standalone terminal application that you run on your local workstation to do your data transfer\. You don't need any coding knowledge to use the Snowball client\. It provides all the functionality you need to transfer data, including handling errors and writing logs to your local workstation for troubleshooting and auditing\. For information on best practices to improve your data transfer speeds, see [Best Practices for AWS Snowball](BestPractices.md)\.

The Snowball client must be downloaded from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page and installed on a powerful workstation that you own\. Once there, find the installation package for your operating system, and follow the instructions to install the Snowball client\. Running the Snowball client from a terminal in your workstation might require using a specific path, depending on your operating system:
+ **Linux** – The Snowball must be run from the \~/snowball\-client\-linux\-*build\_number*/bin/ directory\.
+ **Mac** – The **install\.sh** script creates symbolic links \(symlinks\) in addition to copying folders from the Snowball client \.tar file to the /usr/local/bin/snowball directory\. If you run this script, you can then run the Snowball client from any directory, as long as the /usr/local/bin is a path in your bash\_profile\. You can verify your path with the `echo $PATH` command\.
+ **Windows** – Once the client has been installed, you can run it from any directory without any additional preparation\.

**Note**  
We recommend that you use the latest version of the Linux or Mac Snowball client, as they both support the Advanced Encryption Standard New Instructions \(AES\-NI\) extension to the x86 instruction set architecture\. This offers improved speeds for encrypting or decrypting data during transfers between the Snowball and your Mac or Linux workstations\. For more information on AES\-NI, including supported hardware, see [AES instruction set](https://en.wikipedia.org/wiki/AES_instruction_set#Supporting_x86_CPUs) on Wikipedia\.

**Topics**
+ [Using the Snowball Client](using-client.md)
+ [Commands for the Snowball Client](using-client-commands.md)
+ [Options for the snowball cp Command](copy-command-reference.md)