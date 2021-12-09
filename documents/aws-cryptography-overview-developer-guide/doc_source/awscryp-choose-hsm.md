# When to use AWS CloudHSM<a name="awscryp-choose-hsm"></a>

[AWS CloudHSM](https://docs.aws.amazon.com/cloudhsm/latest/userguide/) is a service for creating and managing cloud\-based hardware security modules\. A *hardware security module* \(HSM\) is a specialized security device that generates and stores cryptographic keys\. 

**When Do I Use It?**
+ Use AWS CloudHSM when you need to manage the HSMs that generate and store your encryption keys\. In AWS CloudHSM, you create and manage HSMs, including creating users and setting their permissions\. You also create the symmetric keys and asymmetric key pairs that the HSM stores\. 

**When Do I Use Something Else?**
+ If you need to secure your encryption keys in a service backed by FIPS\-validated HSMs, but you do not need to manage the HSM, try [AWS Key Management Service](awscryp-choose-kms.md)\. 