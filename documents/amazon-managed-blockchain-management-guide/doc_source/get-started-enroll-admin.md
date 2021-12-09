# Step 4: Enroll an Administrative User<a name="get-started-enroll-admin"></a>

In this step, you use a pre\-configured certificate to enroll a user with administrative permissions to your member's certificate authority \(CA\)\. To do this, you must create a certificate file\. You also need the endpoint for the CA of your member, and the user name and password for the user that you created in [Step 1: Create the Network and First Member](get-started-create-network.md)\.

## Step 4\.1: Create the Certificate File<a name="get-started-enroll-member-create-cert"></a>

Run the following command to copy the `managedblockchain-tls-chain.pem` to the `/home/ec2-user` directory\. Replace `MyRegion` with the AWS Region you are using—for example, `us-east-1`\.

```
aws s3 cp s3://MyRegion.managedblockchain/etc/managedblockchain-tls-chain.pem  /home/ec2-user/managedblockchain-tls-chain.pem
```

Run the following command to test that you copied the contents to the file correctly:

```
openssl x509 -noout -text -in /home/ec2-user/managedblockchain-tls-chain.pem
```

The command should return the contents of the certificate in human\-readable format\.

## Step 4\.2: Enroll the Administrative User<a name="get-started-enroll-member-enroll"></a>

Managed Blockchain registers the user identity that you specified when you created the member as an administrator\. In Hyperledger Fabric, this user is known as the *bootstrap identity* because the identity is used to enroll itself\. To enroll, you need the CA endpoint, as well as the user name and password for the administrator that you created in [Step 1: Create the Network and First Member](get-started-create-network.md)\. For information about registering other user identities as administrators before you enroll them, see [Register and Enroll a User as an Administrator](managed-blockchain-hyperledger-create-admin.md)\.

Use the `get-member` command to get the CA endpoint for your membership as shown in the following example\. Replace the values of `--network-id` and `--member-id` with the values returned in [Step 1: Create the Network and First Member](get-started-create-network.md)\.

```
aws managedblockchain get-member \
--network-id n-MWY63ZJZU5HGNCMBQER7IN6OIU \
--member-id m-K46ICRRXJRCGRNNS4ES4XUUS5A
```

The command returns information about the initial member that you created in the network, as shown in the following example\. Make a note of the `CaEndpoint`\. You also need the `AdminUsername` and password that you created along with the network\.

The command returns output similar to the following:

```
{
    "Member": {
        "NetworkId": "n-MWY63ZJZU5HGNCMBQER7IN6OIU", 
        "Status": "AVAILABLE", 
        "Description": "MyNetDescription", 
        "FrameworkAttributes": {
            "Fabric": {
                "CaEndpoint": "ca.m-K46ICRRXJRCGRNNS4ES4XUUS5A.n-MWY63ZJZU5HGNCMBQER7IN6OIU.managedblockchain.us-east-1.amazonaws.com:30002", 
                "AdminUsername": "AdminUser"
            }
        }, 
        "StatusReason": "Network member created successfully", 
        "CreationDate": 1542255358.74, 
        "Id": "m-K46ICRRXJRCGRNNS4ES4XUUS5A", 
        "Name": "org1"
    }
}
```

Use the CA endpoint, administrator profile, and the certificate file to enroll the member administrator using the `fabric-ca-client enroll` command, as shown in the following example:

```
fabric-ca-client enroll \
-u https://AdminUsername:AdminPassword@SampleCAEndpointAndPort \
--tls.certfiles /home/ec2-user/managedblockchain-tls-chain.pem -M /home/ec2-user/admin-msp
```

An example command with fictitious administrator name, password, and endpoint is shown in the following example:

```
fabric-ca-client enroll \
-u https://AdminUser:Password123@ca.m-K46ICRRXJRCGRNNS4ES4XUUS5A.n-MWY63ZJZU5HGNCMBQER7IN6OIU.managedblockchain.us-east-1.amazonaws.com:30002 \
--tls.certfiles /home/ec2-user/managedblockchain-tls-chain.pem -M /home/ec2-user/admin-msp
```

The command returns output similar to the following:

```
2018/11/16 02:21:40 [INFO] Created a default configuration file at /home/ec2-user/.fabric-ca-client/fabric-ca-client-config.yaml
2018/11/16 02:21:40 [INFO] TLS Enabled
2018/11/16 02:21:40 [INFO] generating key: &{A:ecdsa S:256}
2018/11/16 02:21:40 [INFO] encoded CSR
2018/11/16 02:21:40 [INFO] Stored client certificate at /home/ec2-user/admin-msp/signcerts/cert.pem
2018/11/16 02:21:40 [INFO] Stored root CA certificate at /home/ec2-user/admin-msp/cacerts/ca-abcd1efghijkllmn5op3q52rst-uqz2f2xakfd7vcfewqhckr7q5m-managedblockchain-us-east-1-amazonaws-com-30002.pem
```

## Step 4\.3: Copy Certificates for the MSP<a name="get-started-enroll-member-copy-cert"></a>

In Hyperledger Fabric, the Membership Service Provider \(MSP\) identifies which root CAs and intermediate CAs are trusted to define the members of a trust domain\. Certificates for the administrator's MSP are in `$FABRIC_CA_CLIENT_HOME`, which is `/home/ec2-user/admin-msp` in this tutorial\. Because this MSP is for the member administrator, copy the certificates from `signcerts` to `admincerts` as shown in the following example:

```
cp -r admin-msp/signcerts admin-msp/admincerts
```

**Important**  
It may take a minute or two after you enroll for you to be able to use your administrator certificate to create a channel with the ordering service\.