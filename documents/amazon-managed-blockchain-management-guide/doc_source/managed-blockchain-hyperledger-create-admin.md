# Register and Enroll a User as an Administrator<a name="managed-blockchain-hyperledger-create-admin"></a>

When you create a member in a Managed Blockchain network, you specify the first user as an administrator\. Managed Blockchain registers this user automatically with the Hyperledger Fabric CA as a *bootstrap identity*\. You can then use this bootstrap identity to enroll the identity\. Enrolling an identity sends the CA a Certificate Signing Request \(CSR\) so that the CA can validate that the identity is registered and otherwise valid\. The CA then returns a signed certificate if the identity is valid\. For more information, see the [Fabric CA User's Guide](https://hyperledger-fabric-ca.readthedocs.io/en/release-1.2/users-guide.html)\.

To register an identity, you must have the following:
+ The member CA endpoint
+ The user name and password of an identity with permission to register identities with the member CA
+ A valid certificate file and the path to the MSP directory of the identity that will register the new administrator

The following example command uses an existing user admin with a user name of `AdminUser` and a password of `Password123` in a member named org1 to register a new admin with a user name of `AdminUser2` and a password of `Password456`\. The certificate file is saved to `/home/ec2-user/managedblockchain-tls-chain.pem` and the MSP directory for the AdminUser identity is `/home/ec2-user/admin-msp`\.

The command specifies the `--id.attr ‘hf.Admin=true’` option to register the user identity as an admin for the member\.

```
fabric-ca-client register –-url https://AdminUser:Password123@ca.m-K46ICRRXJRCGRNNS4ES4XUUS5A.n-MWY63ZJZU5HGNCMBQER7IN6OIU.managedblockchain.us-east-1.amazonaws.com:30002 \
--id.name AdminUser2 --id.secret Password456 \
–-id.type user --id.affiliation org1 \
--id.attrs ‘hf.Admin=true’ --tls.certfiles /home/ec2-user/managedblockchain-tls-chain.pem \
--mspdir /home/ec2-user/admin-msp
```

After the user identity is registered as an admin, use the `fabric-ca-client enroll` command to enroll the new administrator as shown in the following example:

```
fabric-ca-client enroll \
-u https://AdminUser2:Password456@ca.m-K46ICRRXJRCGRNNS4ES4XUUS5A.n-MWY63ZJZU5HGNCMBQER7IN6OIU.managedblockchain.us-east-1.amazonaws.com:30002 \
--tls.certfiles /home/ec2-user/managedblockchain-tls-chain.pem \
-M /home/ec2-user/admin-msp
```