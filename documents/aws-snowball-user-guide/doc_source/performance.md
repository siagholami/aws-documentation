--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Performance for AWS Snowball<a name="performance"></a>

Following, you can find information about AWS Snowball performance\. Here, we discuss performance in general terms, because on\-premises environments each have a different way of doing things—different network technologies, different hardware, different operating systems, different procedures, and so on\. 

The following table outlines how your network's transfer rate impacts how long it takes to fill a Snowball with data\. Transferring smaller files without batching them into larger files reduces your transfer speed due to increased overhead\.


| Rate \(MB/s\) | 42\-TB Transfer Time | 72\-TB Transfer Time | 
| --- | --- | --- | 
| 800 | 14 hours | 1 day | 
| 450 | 1\.09 days | 1\.8 days | 
| 400 | 1\.16 days | 2\.03 days | 
| 300 | 1\.54 days | 2\.7 days | 
| 277 | 1\.67 days | 2\.92 days | 
| 200 | 2\.31 days | 4 days | 
| 100 | 4\.63 days | 8\.10 days | 
| 60 | 8 days | 13 days | 
| 30 | 15 days | 27 days | 
| 10 | 46 days | 81 days | 

The following describes how to determine when to use Snowball instead of data transfer over the internet, and how to speed up transfer from your data source to the Snowball\.

## Speeding Up Data Transfer<a name="transferspeed"></a>

In general, you can improve the transfer speed from your data source to the Snowball in the following ways, ordered from largest to smallest positive impact on performance:

1. **Use the latest Mac or Linux Snowball client** – The latest Snowball clients for Mac and Linux both support the Advanced Encryption Standard New Instructions \(AES\-NI\) extension to the x86 instruction set architecture\. This extension offers improved speeds for encrypting or decrypting data during transfers between the Snowball and your Mac or Linux workstations\. For more information on AES\-NI, including supported hardware, see [AES instruction set](https://en.wikipedia.org/wiki/AES_instruction_set#Supporting_x86_CPUs) on Wikipedia\.

1. **Batch small files together** – Each copy operation has some overhead because of encryption\. Therefore, performing many transfers on individual files has slower overall performance than transferring the same data in larger files\. You can significantly improve your transfer speed for small files by batching them in a single `snowball cp` command\. Batching of small files is enabled by default\. During the import process into Amazon S3, these batched files are automatically extracted to their original state\. For more information, see [Options for the snowball cp Command](copy-command-reference.md)\.

1. **Perform multiple copy operations at one time** – If your workstation is powerful enough, you can perform multiple `snowball cp` commands at one time\. You can do this by running each command from a separate terminal window, in separate instances of the Snowball client, all connected to the same Snowball\.

1. **Copy from multiple workstations** – You can connect a single Snowball to multiple workstations\. Each workstation can host a separate instance of the Snowball client\.

1. **Transfer directories, not files** – Because there is overhead for each `snowball cp` command, we don't recommend that you queue a large number of individual copy commands\. Queuing many commands has a significant negative impact on your transfer performance\.

   For example, say that you have a directory called C:\\\\MyFiles that only contains three files, file1\.txt, file2\.txt, and file3\.txt\. Suppose that you issue the following three commands\.

   ```
   snowball cp C:\\MyFiles\file1.txt s3://mybucket
   snowball cp C:\\MyFiles\file2.txt s3://mybucket
   snowball cp C:\\MyFiles\file3.txt s3://mybucket
   ```

   In this scenario, you have three times as much overhead as if you transferred the entire directory with the following copy command\.

   ```
   Snowball cp –r C:\\MyFiles\* s3://mybucket
   ```

1. **Don't perform other operations on files during transfer** – Renaming files during transfer, changing their metadata, or writing data to the files during a copy operation has a significant negative impact on transfer performance\. We recommend that your files remain in a static state while you transfer them\. 

1. **Reduce local network use** – Your Snowball communicates across your local network\. Because of this, reducing other local network traffic between the Snowball, the switch it's connected to, and the workstation that hosts your data source can improve data transfer speeds\.

1. **Eliminate unnecessary hops** – We recommend that you set up your Snowball, your data source, and your workstation so that they're the only machines communicating across a single switch\. Doing so can result in a significant improvement of data transfer speeds\. 

### Experimenting to Get Better Performance<a name="perfex"></a>

Your performance results will vary based on your hardware, your network, how many and how large your files are, and how they're stored\. Therefore, we suggest that you experiment with your performance metrics if you're not getting the performance that you want\.

First, attempt multiple copy operations until you see a reduction in overall transfer performance\. Performing multiple copy operations at once can have a significantly positive impact on your overall transfer performance\. For example, suppose that you have a single `snowball cp` command running in a terminal window, and you note that it's transferring data at 30 MB/second\. You open a second terminal window, and run a second `snowball cp` command on another set of files that you want to transfer\. You see that both commands are performing at 30 MB/second\. In this case, your total transfer performance is 60 MB/second\.

Now, suppose that you connect to the Snowball from a separate workstation\. You run the Snowball client from that workstation to execute a third `snowball cp` command on another set of files that you want to transfer\. Now when you check the performance, you note that all three instances of the `snowball cp` command are operating at a performance of 25 MB/second, with a total performance of 75 MB/second\. Even though the individual performance of each instance has decreased in this example, the overall performance has increased\.

Experimenting in this way, using the techniques listed in [Speeding Up Data Transfer](#transferspeed), can help you optimize your data transfer performance\.