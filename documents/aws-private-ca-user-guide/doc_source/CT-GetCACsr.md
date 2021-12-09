# Retrieving the Certificate Authority Signing Request<a name="CT-GetCACsr"></a>

The following CloudTrail example shows the results of a call to the [GetCertificateAuthorityCsr](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificateAuthorityCsr.html) operation\.

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
   "eventTime":"2018-01-26T21:40:33Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"GetCertificateAuthorityCsr",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters":{
      "certificateAuthorityArn":"arn:aws:acm-pca:region:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1"
   },
   "responseElements":null,
   "requestID":"7ce9f3bc-b459-436b-bac1-61e75fca3c6e",
   "eventID":"93115f0b-d528-447a-9b22-87f868dbfd8e",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```