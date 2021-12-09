# Key management for Amazon Detective<a name="key-management"></a>

Because Detective does not store any personally identifiable customer data, it uses AWS owned customer master keys \(CMKs\)\.

This type of CMK can be used across multiple accounts\. See the [description of AWS owned CMKs in the AWS Key Management Service Developer Guide](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-owned-cmk)\.

This type of CMK rotates automatically every three years \(1095 days\)\. See the [description of key rotation in the AWS Key Management Service Developer Guide](https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html)\.