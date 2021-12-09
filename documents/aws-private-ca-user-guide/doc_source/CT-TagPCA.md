# Tagging Private Certificate Authorities<a name="CT-TagPCA"></a>

The following CloudTrail example shows the results of a call to the [TagCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_TagCertificateAuthority.html) operation\.

```
{
   "eventVersion":"1.05",
   "userIdentity":{
      "type":"IAMUser",
      "principalId":"account",
      "arn":"arn:aws:iam::account:user/name",
      "accountId":"account",
      "accessKeyId":"Key_ID"
   },
   "eventTime":"2018-02-02T00:18:48Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"TagCertificateAuthority",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters":{
      "certificateAuthorityArn":"arn:aws:acm-pca:us-east-1:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1",
      "tags":[
         {
            "key":"Admin",
            "value":"Alice"
         }
      ]
   },
   "responseElements":null,
   "requestID":"816df59d-5022-47af-aa58-173e5c73c20a",
   "eventID":"8c99648b-3d77-483f-b56b-5aaa85cb6cde",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```