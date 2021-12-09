--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Using the Snowball Client<a name="using-client"></a>

Following, you can find an overview of the Snowball client, one of the tools that you can use to transfer data between your on\-premises data center and the Snowball\. The Snowball client supports transferring the following types of data to and from a Snowball\.

**Note**  
Each file or object that is imported must be less than or equal to 5 TB in size\.

Because the computer workstation from which or to which you make the data transfer is considered to be the bottleneck for transferring data, we highly recommend that your workstation be a powerful computer\. It should be able to meet high demands in terms of processing, memory, and networking\. For more information, see [Workstation Specifications](specifications.md#workstationspecs)\.

**Topics**
+ [Testing Your Data Transfer with the Snowball Client](#testing-client)
+ [Authenticating the Snowball Client to Transfer Data](#setting-up-client)
+ [Schemas for Snowball Client](#using-client-schema)

## Testing Your Data Transfer with the Snowball Client<a name="testing-client"></a>

You can use the Snowball client to test your data transfer before it begins\. Testing is useful because it can help you identify the most efficient method of transferring your data\. The first 10 days that the Snowball is on\-site at your facility are free, and you'll want to test your data transfer ahead of time to prevent fees starting on the eleventh day\.

You can download the Snowball client from the tools page at any time, even before you first log in to the AWS Snowball Management Console\. You can also use the Snowball client to test your data transfer job before you create the job, or any time thereafter\. You can test the Snowball client without having a manifest, an unlock code, or a Snowball\.

**To test data transfer using the Snowball client**

1. Download and install the Snowball client from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page\.

1. Ensure that your workstation can communicate with your data source across the local network\. We recommend that you have as few hops as possible between the two\.

1. Run the Snowball client's test command and include the path to the mounted data source in your command as follows\.

   ```
   snowball test [OPTION...] [path/to/data/source]
   ```  
**Example**  

   ```
   snowball test --recursive --time 5 /Logs/2015/August
   ```  
**Example**  

   ```
   snowball test -r -t 5 /Logs/2015/August
   ```

In the preceding example, the first command tells the Snowball client to run the test recursively through all the folders and files found under **/Logs/2015/August** on the data source for 5 minutes\. The second command tells the Snowball client to report real\-time transfer speed data for the duration of the test\.

**Note**  
The longer the test command runs, the more accurate the test data you get back\.

## Authenticating the Snowball Client to Transfer Data<a name="setting-up-client"></a>

Before you can transfer data with your downloaded and installed Snowball client, you must first run the `snowball start` command\. This command authenticates your access to the Snowball\. For you to run this command, the Snowball you use for your job must be on\-site, plugged into power and network, and turned on\. In addition, the E Ink display on the Snowball's front must say **Ready**\.

**To authenticate the Snowball client's access to a Snowball**

1. Obtain your manifest and unlock code\.

   1. Get the manifest from the AWS Snowball Management Console or the job management API\. Your manifest is encrypted so that only the unlock code can decrypt it\. The Snowball client compares the decrypted manifest against the information that was put in the Snowball when it was being prepared\. This comparison verifies that you have the right Snowball for the data transfer job you’re about to begin\. 

   1. Get the unlock code, a 29\-character code that also appears when you download your manifest\. We recommend that you write it down and keep it in a separate location from the manifest that you downloaded, to prevent unauthorized access to the Snowball while it’s at your facility\.

1. Locate the IP address for the Snowball on the Snowball's E Ink display\. When the Snowball is connected to your network for the first time, it automatically creates a DHCP IP address\. If you want to use a different IP address, you can change it from the E Ink display\. For more information, see [Using an AWS Snowball Device](using-device.md)\.

1. Execute the `snowball start` command to authenticate your access to the Snowball with the Snowball's IP address and your credentials, as follows:

   ```
   snowball start -i [IP Address] -m [Path/to/manifest/file] -u [29 character unlock
                 code]
   ```  
**Example**  

   ```
   snowball start -i 192.0.2.0 -m /user/tmp/manifest -u 01234-abcde-01234-ABCDE-01234
   ```

## Schemas for Snowball Client<a name="using-client-schema"></a>

The Snowball client uses schemas to define what kind of data is transferred between your on\-premises data center and a Snowball\. You declare the schemas whenever you issue a command\.

### Sources for the Snowball Client Commands<a name="client-source-schemas"></a>

Transferring file data from a local mounted file system requires that you specify the source path, in the format that works for your OS type\. For example, in the command `snowball ls C:\User\Dan\CatPhotos s3://MyBucket/Photos/Cats`, the source schema specifies that the source data is standard file data\.

### Destinations for the Snowball Client<a name="client-destination-schemas"></a>

In addition to source schemas, there are also destination schemas\. Currently, the only supported destination schema is `s3://`\. For example, in the command `snowball cp -r /Logs/April s3://MyBucket/Logs`, the content in `/Logs/April` is copied recursively to the `MyBucket/Logs` location on the Snowball using the `s3://` schema\. 