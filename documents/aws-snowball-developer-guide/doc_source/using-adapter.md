--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Transferring Files Using the Amazon S3 Adapter<a name="using-adapter"></a>

Following is an overview of the Amazon S3 Adapter for Snowball, which you can use to transfer data programmatically to and from the AWS Snowball Edge device using Amazon S3 REST API actions\. This Amazon S3 REST API support is limited to a subset of actions\. You can use this subset of actions with one of the AWS SDKs to transfer data programmatically\. You can also use the subset of supported AWS Command Line Interface \(AWS CLI\) commands for Amazon S3 to transfer data programmatically\.

If your solution uses the AWS SDK for Java version 1\.11\.0 or newer, you must use the following `S3ClientOptions`:
+ `disableChunkedEncoding()` – Indicates that chunked encoding is not supported with the adapter\.
+ `setPathStyleAccess(true)` – Configures the adapter to use path\-style access for all requests\.

For more information, see [Class S3ClientOptions\.Builder](https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/s3/S3ClientOptions.Builder.html) in the Amazon AppStream SDK for Java\.

**Important**  
We recommend that you only use one method of reading and writing data to a local bucket on an AWS Snowball Edge device at a time\. Using both the file interface and the Amazon S3 Adapter for Snowball on the same bucket at the same time can result in read/write conflicts\.  
For AWS services to work properly on a Snowball Edge, you must allow the ports for the services\. For details, see [Ports Required to Use AWS Services on an AWS Snowball Edge Device](port-requirements.md)\.

## Downloading and Installing the AWS CLI Version 1\.16\.14<a name="cli-version"></a>

Currently, Snowball Edge devices support only version 1\.6\.14 and earlier of the AWS CLI\. You can download and install this version of the AWS CLI from GitHub\. Use the following procedure to perform this task\.

**Note**  
Be sure to install version 2\.6\.5\+ or 3\.4\+ of Python before you install version 1\.16\.14 of the AWS CLI\.

**To download and install version 1\.16\.14 of the AWS CLI**

1. Uninstall existing installations of the AWS CLI\. This step is optional for Linux installations\.
   + **Windows** – For more information, see [Uninstalling](https://docs.aws.amazon.com/cli/latest/userguide/awscli-install-windows.html#install-msi-uninstall) in the *AWS Command Line Interface User Guide*\.
   + **Linux** – This step is optional for Linux installations\. However, to uninstall an existing installation of the AWS CLI, run the following commands from a terminal\.

     ```
     sudo rm -rf /usr/local/aws
     sudo rm /usr/local/bin/aws
     ```

1. Download the AWS CLI as [a \.zip file](https://github.com/aws/aws-cli/archive/1.16.14.zip) from the AWS GitHub repository where it resides\.

1. Install the AWS CLI version 1\.16\.14 from the `1.16.14.zip` file with one of the following procedures:
   + **Windows**

     1. Extract the archive to a location on your computer, for example: `C:\Users\username\aws_cli\aws-cli-1.6.14`

     1. Open a command prompt, navigate to the folder that you extracted the archive to, and run the setup script with the following command\.

        ```
        py setup.py install
        ```

     1. Add the AWS CLI to your `PATH` environment variable\. 

     Doing this installs version 1\.6\.14 of the AWS CLI\.
   + **Linux**

     1. Extract the archive to a location on your computer, for example: `/home/username/aws_cli/aws-cli-1.6.14`

     1. Open a terminal window, navigate to the directory that you extracted the archive to, and run the setup script with the following command\.

        ```
        python setup.py install
        ```
**Note**  
You might need to run the command with `sudo`\.

        This command installs version 1\.6\.14 of the AWS CLI, and overwrites files created by any previously installed AWS CLI version\.

## Using the AWS CLI and API Operations on Snowball Edge<a name="using-adapter-cli-specify-region"></a>

When using the AWS CLI or API operations to issue IAM, Amazon S3, and Amazon EC2 commands on Snowball Edge, you must specify the Region as "`snowball`\." You can do this using `AWS configure` or within the command itself, as in the following examples\. 

```
aws configure --profile abc
AWS Access Key ID [None]: defgh
AWS Secret Access Key [None]: 1234567
Default region name [None]: snowball
Default output format [None]: json
```

Or

```
aws s3 ls --profile snowballEdge --endpoint http://192.0.2.0:8080 --region snow 
```

### Authorization with the Amazon S3 API Adapter for AWS Snowball<a name="auth-adapter"></a>

When you use the Amazon S3 Adapter for Snowball, every interaction is signed with the AWS Signature Version 4 algorithm by default\. This authorization is used only to verify the data traveling from its source to the adapter\. All encryption and decryption happens on the device\. Unencrypted data is never stored on the device\.

When using the adapter, keep the following in mind:
+ To get the local Amazon S3 credentials to sign your requests to the AWS Snowball Edge device, run the `snowballEdge list-access-keys` and `snowballEdge get-secret-access-keys` Snowball client commands\. For more information, see [Using the Snowball Client](using-client.md)\. These local Amazon S3 credentials include a pair of keys: an access key and a secret key\. These keys are only valid for the devices associated with your job\. They can't be used in the AWS Cloud because they have no AWS Identity and Access Management \(IAM\) counterpart\.
+ The encryption key is not changed by what AWS credentials you use\. Signing with the Signature Version 4 algorithm is only used to verify the data traveling from its source to the adapter\. Thus, this signing never factors into the encryption keys used to encrypt your data on the Snowball\.

## Getting and Using Local Amazon S3 Credentials<a name="adapter-credentials"></a>

Every interaction with a Snowball Edge is signed with the AWS Signature Version 4 algorithm\. For more information about the algorithm, see [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) in the *AWS General Reference*\.

You can get the local Amazon S3 credentials to sign your requests to the Snowball Edge device by running the `snowballEdge list-access-keys` and `snowballEdge get-secret-access-key` Snowball client commands\. For more information, see [Getting Credentials](using-client-commands.md#client-credentials)\. These local Amazon S3 credentials include a pair of keys: an access key ID and a secret key\. These credentials are only valid for the devices that are associated with your job\. They can't be used in the AWS Cloud because they have no IAM counterpart\.

You can add these credentials to the AWS credentials file on your server\. The default credential profiles file is typically located at `~/.aws/credentials`, but the location can vary per platform\. This file is shared by many of the AWS SDKs and by the AWS CLI\. You can save local credentials with a profile name as in the following example\.

```
[snowballEdge]
aws_access_key_id = AKIAIOSFODNN7EXAMPLE
aws_secret_access_key = wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
```

### Specifying the Adapter as the AWS CLI Endpoint<a name="using-adapter-cli-endpoint"></a>

When you use the AWS CLI to issue a command to the AWS Snowball Edge device, you specify that the endpoint is the Amazon S3 Adapter for Snowball\. You have the choice of using the HTTPS endpoint, or an unsecured HTTP endpoint, as shown following\.

**HTTPS secured endpoint**

```
aws s3 ls --profile snowballEdge --endpoint https://192.0.2.0:8443 --ca-bundle path/to/certificate
```

**HTTP unsecured endpoint**

```
aws s3 ls --profile snowballEdge --endpoint http://192.0.2.0:8080
```

If you use the HTTPS endpoint of `8443`, your data is securely transferred from your server to the Snowball Edge\. This encryption is ensured with a certificate that's generated by the Snowball Edge whenever it gets a new IP address\. After you have your certificate, you can save it to a local `ca-bundle.pem` file\. Then you can configure your AWS CLI profile to include the path to your certificate, as described following\.

**To associate your certificate with the adapter endpoint**

1. Connect the Snowball Edge to power and the network, and turn it on\.

1. After the device has finished booting up, make a note of its IP address on your local network\.

1. From a terminal on your network, make sure you can ping the Snowball Edge\.

1. Run the `snowballEdge get-certificate` command in your terminal\. For more information on this command, see [Getting Your Certificate for Transferring Data](using-client-commands.md#snowball-edge-certificates-cli)\.

1. Save the output of the `snowballEdge get-certificate` command to a file, for example `ca-bundle.pem`\.

1. Run the following command from your terminal\.

   ```
   aws configure set profile.snowballEdge.ca_bundle /path/to/ca-bundle.pem
   ```

After you complete the procedure, you can run CLI commands with these local credentials, your certificate, and your specified endpoint, as in the following example\.

```
aws s3 ls --profile snowballEdge --endpoint https://192.0.2.0:8443
```

## Unsupported Amazon S3 Features for Snowball Edge<a name="snowball-edge-s3-unsupported-features"></a>

Using the Amazon S3 Adapter for Snowball, you can programmatically transfer data to and from a Snowball Edge with Amazon S3 API actions\. However, not all Amazon S3 transfer features and API actions are supported for use with a Snowball Edge device\. For more information on the supported features, see the following:
+ [Supported AWS CLI Commands](using-adapter-cli.md)
+ [Supported REST API Actions](using-adapter-supported-api.md)

Any features or actions not explicitly listed in these topics are not supported\. For example, the following features and actions are not supported for use with Snowball Edge:
+ [TransferManager](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/examples-s3-transfermanager.html) – This utility transfers files from a local environment to Amazon S3 with the SDK for Java\. Consider using the supported API actions or AWS CLI commands with the adapter instead\.
+ [GET Bucket \(List Objects\) Version 2](https://docs.aws.amazon.com/AmazonS3/latest/API/v2-RESTBucketGET.html) – This implementation of the GET action returns some or all \(up to 1,000\) of the objects in a bucket\. Consider using the [GET Bucket \(List Objects\) Version 1](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketGET.html) action or the [ls](https://docs.aws.amazon.com/cli/latest/reference/s3/ls.html) AWS CLI command\.