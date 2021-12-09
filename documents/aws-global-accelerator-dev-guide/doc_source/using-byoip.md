# Bring your own IP addresses \(BYOIP\) in AWS Global Accelerator<a name="using-byoip"></a>

AWS Global Accelerator uses static IP addresses as entry points for your accelerators\. These IP addresses are anycast from AWS edge locations\. By default, Global Accelerator provides static IP addresses from the [Amazon IP address pool](https://docs.aws.amazon.com/general/latest/gr/aws-ip-ranges.html)\. Instead of using the IP addresses that Global Accelerator provides, you can configure these entry points to be IPv4 addresses from your own address ranges\. This topic explains how to use your own IP address ranges with Global Accelerator\.

You can bring part or all of your public IPv4 address ranges from your on\-premises network to your AWS account to use with Global Accelerator\. You continue to own the address ranges, but AWS advertises them on the internet\. 

You can't use the IP addresses that you bring to AWS for one AWS service with another service\. The steps in this chapter describe how to bring your own IP address range for use in AWS Global Accelerator only\. For steps to bring your own IP address range for use in Amazon EC2, see [Bring your own IP addresses \(BYOIP\)](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-byoip.html) in the Amazon EC2 User Guide\.

**Important**  
You must stop advertising your IP address range from other locations before you advertise it through AWS\. If an IP address range is multihomed \(that is, the range is advertised by multiple service providers at the same time\), we can't guarantee that traffic to the address range will enter our network or that your BYOIP advertising workflow will complete successfully\.

After you bring an address range to AWS, it appears in your account as an address pool\. When you create an accelerator, you can assign one or two of the IP addresses from your range to it\. We recommend that you bring two IP address ranges so that you can choose an IP address from different ranges for each static IP address\. If you choose to assign only one IP address from your IP address range to an accelerator, Global Accelerator assigns a second static IP address for the accelerator from the AWS IP address pool\.

To use your own IP address range with Global Accelerator, review the requirements, and then follow the steps provided in this topic\.

**Topics**
+ [Requirements](#using-byoip.requirements)
+ [Prepare to bring your IP address range to your AWS account: Authorization](#using-byoip.prepare)
+ [Provision the address range for use with AWS Global Accelerator](#using-byoip.provision)
+ [Advertise the address range through AWS](#using-byoip.advertise)
+ [Deprovision the address range](#using-byoip.deprovision)
+ [Create an accelerator with your IP addresses](#using-byoip.create-accelerator)

## Requirements<a name="using-byoip.requirements"></a>

You can bring up to two qualifying IP address ranges to AWS Global Accelerator per AWS account\.

To qualify, your IP address range must meet the following requirements:
+ The IP address range must be registered with one of the following regional internet registries \(RIRs\): the American Registry for Internet Numbers \(ARIN\), Réseaux IP Européens Network Coordination Centre \(RIPE\), or Asia\-Pacific Network Information Centre \(APNIC\)\. The address range must be registered to a business or institutional entity\. It can’t be registered to an individual\.
+ The most specific address range that you can bring is /24\. The first 24 bits of the IP address specify the network number\. For example, 198\.51\.100 is the network number for IP address 198\.51\.100\.0\.
+ The IP addresses in the address range must have a clean history\. That is, they can’t have a poor reputation or be associated with malicious behavior\. We reserve the right to reject the IP address range if we investigate the reputation of the IP address range and find that it contains an IP address that doesn’t have a clean history\. 

Also, we require the following allocation and assignment network types or statuses, depending on where you registered your IP address range:
+ ARIN: `Direct Allocation` and `Direct Assignment` network types
+ RIPE: `ALLOCATED PA`, `LEGACY`, and `ASSIGNED PI` allocation statuses
+ APNIC: `ALLOCATED PORTABLE` and `ASSIGNED PORTABLE` allocation statuses

## Prepare to bring your IP address range to your AWS account: Authorization<a name="using-byoip.prepare"></a>

To ensure that only you can bring your IP address space to Amazon, we require two authorizations:
+ You must authorize Amazon to advertise the IP address range\.
+ You must provide proof that you own the IP address range and so have the authority to bring it to AWS\.
**Note**  
When you use BYOIP to bring an IP address range to AWS, you can't transfer ownership of that address range to a different account or company while we're advertising it\. You also can't directly transfer an IP address range from one AWS account to another account\. To transfer ownership or to transfer between AWS accounts, you must deprovision the address range, and then the new owner must follow the steps to add the address range to their AWS account\.

To authorize Amazon to advertise the IP address range, you provide Amazon with a signed authorization message\. Use a Route Origin Authorization \(ROA\) to provide this authorization\. A ROA is a cryptographic statement about your route announcements that you create through your Regional Internet Registry \(RIR\)\. A ROA contains the IP address range, the Autonomous System Numbers \(ASN\) that are allowed to advertise the IP address range, and an expiration date\. The ROA authorizes Amazon to advertise an IP address range under a specific Autonomous System \(AS\)\. 

A ROA does not authorize your AWS account to bring the IP address range to AWS\. To provide this authorization, you must publish a self\-signed X\.509 certificate in the Registry Data Access Protocol \(RDAP\) remarks for the IP address range\. The certificate contains a public key, which AWS uses to verify the authorization\-context signature that you provide\. Keep your private key secure and use it to sign the authorization\-context message\.

The following sections provide detailed steps for completing these authorization tasks\. The commands in these steps are supported on Linux\. If you use Windows, you can access the [Windows Subsystem for Linux](https://docs.microsoft.com/en-us/windows/wsl/about) to run Linux commands\.

### Steps to provide authorization<a name="using-byoip.prepare-steps"></a>
+ [Step 1: Create a ROA object](#using-byoip.prepare-steps-1)
+ [Step 2: Create a self\-signed X\.509 certificate](#using-byoip.prepare-steps-2)
+ [Step 3: Create a signed authorization message](#using-byoip.prepare-steps-3)

### Step 1: Create a ROA object<a name="using-byoip.prepare-steps-1"></a>

Create a ROA object to authorize Amazon ASN 16509 to advertise your IP address range as well as the ASNs that are currently authorized to advertise the IP address range\. The ROA must contain the /24 IP address that you want to bring to AWS and you must set the maximum length to /24\. 

For more information about creating a ROA request, see the following sections, depending on where you registered your IP address range:
+ ARIN: [ROA Requests ](https://www.arin.net/resources/rpki/roarequest.html)
+ RIPE: [ Managing ROAs](https://www.ripe.net/manage-ips-and-asns/resource-management/certification/resource-certification-roa-management)
+ APNIC: [ Route Management](https://www.apnic.net/wp-content/uploads/2017/01/route-roa-management-guide.pdf)

### Step 2: Create a self\-signed X\.509 certificate<a name="using-byoip.prepare-steps-2"></a>

Create a key pair and a self\-signed X\.509 certificate, and then add the certificate to the RDAP record for your RIR\. The following steps describe how to perform these tasks\.

**Note**  
The `openssl` commands in these steps require OpenSSL version 1\.0\.2 or later\.

### To create and add an X\.509 certificate

1. Generate an RSA 2048\-bit key pair using the following command\.

   ```
   openssl genrsa -out private.key 2048
   ```

1. Create a public X\.509 certificate from the key pair using the following command\.

   ```
   openssl req -new -x509 -key private.key -days 365 | tr -d "\n" > publickey.cer
   ```

   In this example, the certificate expires in 365 days, after which time it can’t be trusted\. When you run the command, make sure that you set the `–days` option to the desired value for the correct expiration\. When you're prompted for other information, you can accept the default values\.

1. Update the RDAP record for your RIR with the X\.509 certificate by using the following steps, depending on your RIR\.

   1. View your certificate using the following command\.

      ```
      cat publickey.cer
      ```

   1. Add the certificate by doing the following:
**Important**  
Make sure to include the `-----BEGIN CERTIFICATE-----` and `-----END CERTIFICATE-----` from the certificate\.
      + For ARIN, add the certificate in the `Public Comments` section for your IP address range\.
      + For RIPE, add the certificate as a new `descr` field for your IP address range\.
      + For APNIC, send the public key in email to `helpdesk@apnic.net`, the APNIC authorized contact for the IP addresses, to request that they manually add it to the `remarks` field\.

### Step 3: Create a signed authorization message<a name="using-byoip.prepare-steps-3"></a>

Create the signed authorization message to allow Amazon to advertise your IP address range\. 

The format of the message is as follows, where the `YYYYMMDD` date is the expiration date of the message\.

```
1|aws|aws-account|address-range|YYYYMMDD|SHA256|RSAPSS
```

### To create the signed authorization message

1. Create a plaintext authorization message and store it in a variable named `text_message`, as the following example shows\. Replace the example account number, IP address range, and expiration date with your own values\.

   ```
   text_message="1|aws|123456789012|203.0.113.0/24|20191201|SHA256|RSAPSS"
   ```

1. Sign the authorization message in `text_message` using the key pair that you created in the previous section\.

1. Store the message in a variable named `signed_message`, as the following example shows\.

   ```
   signed_message=$(echo $text_message | tr -d "\n" | openssl dgst -sha256 -sigopt 
   						rsa_padding_mode:pss -sigopt rsa_pss_saltlen:-1 -sign private.key -keyform PEM | openssl base64 | 
   						tr -- '+=/' '-_~' | tr -d "\n")
   ```

## Provision the address range for use with AWS Global Accelerator<a name="using-byoip.provision"></a>

When you provision an address range for use with AWS, you are confirming that you own the address range and authorize Amazon to advertise it\. We'll verify that you own the address range\.

You must provision your address range using the CLI or Global Accelerator API operations\. This functionality is not available in the AWS console\.

To provision the address range, use the following [ProvisionByoipCidr](https://docs.aws.amazon.com/global-accelerator/latest/api/API_ProvisionByoipCidr.html) command\. The `--cidr-authorization-context` parameter uses the variables that you created in the previous section, not the ROA message\.

```
aws globalaccelerator provision-byoip-cidr --cidr address-range --cidr-authorization-context Message="$text_message",Signature="$signed_message"
```

The following is an example of provisioning an address range\.

```
aws globalaccelerator provision-byoip-cidr 
    --cidr 203.0.113.25/24
    --cidr-authorization-context Message="$text_message",Signature="$signed_message"
```

Provisioning an address range is an asynchronous operation, so the call returns immediately\. However, the address range is not ready to use until its state changes from `PENDING_PROVISIONING` to `READY`\. It can take up to 3 weeks to complete the provisioning process\. To monitor the state of the address ranges that you've provisioned, use the following [ ListByoipCidrs](https://docs.aws.amazon.com/global-accelerator/latest/api/API_ListByoipCidrs.html) command:

```
aws globalaccelerator list-byoip-cidrs
```

To see a list of the states for an IP address range, see [ByoipCidr](https://docs.aws.amazon.com/global-accelerator/latest/api/API_API_ByoipCidr.html)\. 

When your IP address range is provisioned, the `State` returned by `list-byoip-cidrs` is `READY`\. For example:

```
{
    "ByoipCidrs": [
        {
            "Cidr": "203.0.113.0/24",
            "State": "READY"
        }
    ]
}
```

## Advertise the address range through AWS<a name="using-byoip.advertise"></a>

After the address range is provisioned, it's ready to be advertised\. You must advertise the exact address range that you provisioned\. You can't advertise only a portion of the provisioned address range\. In addition, you must stop advertising your IP address range from other locations before you advertise it through AWS\.

You must advertise \(or stop advertising\) your address range using the CLI or Global Accelerator API operations\. This functionality is not available in the AWS console\.

**Important**  
Make sure that your IP address range is advertised by AWS before you use an IP address from your pool with Global Accelerator\.

To advertise the address range, use the following [AdvertiseByoipCidr](https://docs.aws.amazon.com/global-accelerator/latest/api/API_AdvertiseByoipCidr.html) command\.

```
aws globalaccelerator advertise-byoip-cidr --cidr address-range
```

The following is an example of requesting Global Accelerator to advertise an address range\.

```
aws globalaccelerator advertise-byoip-cidr --cidr 203.0.113.0/24
```

To monitor the state of the address ranges that you've advertised, use the following [ListByoipCidrs](https://docs.aws.amazon.com/global-accelerator/latest/api/API_ListByoipCidrs.html) command\.

```
aws globalaccelerator list-byoip-cidrs
```

When your IP address range is advertised, the `State` returned by `list-byoip-cidrs` is `ADVERTISING`\. For example:

```
{
    "ByoipCidrs": [
        {
            "Cidr": "203.0.113.0/24",
            "State": "ADVERTISING"
        }
    ]
}
```

To stop advertising the address range, use the following `withdraw-byoip-cidr` command\.

**Important**  
To stop advertising your address range, you first must remove any accelerators that have static IP addresses that are allocated from the address pool\. To delete an accelerator using the console or using API operations, see [ Deleting an accelerator](about-accelerators.deleting.md)\.

```
aws globalaccelerator withdraw-byoip-cidr --cidr address-range
```

The following is an example of requesting Global Accelerator to withdraw an address range\.

```
aws globalaccelerator withdraw-byoip-cidr 
    --cidr 203.0.113.25/24
```

## Deprovision the address range<a name="using-byoip.deprovision"></a>

To stop using your address range with AWS, you first must remove any accelerators that have static IP addresses that are allocated from the address pool and stop advertising your address range\. After you complete those steps, you can deprovision the address range\.

You must stop advertising and deprovision your address range using the CLI or Global Accelerator API operations\. This functionality is not available in the AWS console\.

**Step 1: Delete any associated accelerators\. **To delete an accelerator using the console or using API operations, see [ Deleting an accelerator](about-accelerators.deleting.md)\.

**Step 2\. Stop advertising the address range\.** To stop advertising the range, use the following [WithdrawByoipCidr](https://docs.aws.amazon.com/global-accelerator/latest/api/API_WithdrawByoipCidr.html) command\.

```
aws globalaccelerator withdraw-byoip-cidr --cidr address-range
```

**Step 3\. Deprovision the address range\.** To deprovision the range, use the following [DeprovisionByoipCidr](https://docs.aws.amazon.com/global-accelerator/latest/api/API_DeprovisionByoipCidr.html) command\.

```
aws globalaccelerator deprovision-byoip-cidr --cidr address-range
```

## Create an accelerator with your IP addresses<a name="using-byoip.create-accelerator"></a>

You have several options for creating an accelerator using your own IP addresses for the static IP addresses: 
+ **Use Global Accelerator console to create an accelerator\.** For more information, see [ Creating or updating an accelerator](about-accelerators.creating-editing.md)\.
+ **Use the Global Accelerator API to create an accelerator\.** For more information, including an example of using the CLI, see [ CreateAccelerator](https://docs.aws.amazon.com/global-accelerator/latest/api/API_CreateAccelerator.html) in the AWS Global Accelerator API Reference\.