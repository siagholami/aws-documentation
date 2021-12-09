# Removing Tags from a Private Certificate Authority<a name="CT-UntagPCA"></a>

The following CloudTrail example shows the results of a call to the [UntagCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_UntagCertificateAuthority.html) operation\.

```
{
   "eventVersion":"1.05",
   "userIdentity":{
      "type":"IAMUser",
      "principalId":"account",
      "arn":"arn:aws:iam::account:user/namee",
      "accountId":"account",
      "accessKeyId":"Key_ID"
   },
   "eventTime":"2018-02-02T00:21:50Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"UntagCertificateAuthority",
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
   "requestID":"b9b385b4-a721-4018-be15-d679ce5c2d6e",
   "eventID":"e32c054d-bc19-40a7-bef9-194ed6848a3b",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```