# Retrieving a Certificate Authority Certificate<a name="CT-GetCACertificate"></a>

The following CloudTrail example shows the results of a call to the [GetCertificateAuthorityCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificateAuthorityCertificate.html) operation\.

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
   "eventTime":"2018-01-26T22:03:52Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"GetCertificateAuthorityCertificate",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters":{
      "certificateAuthorityArn":"arn:aws:acm-pca:region:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1"
   },
   "responseElements":null,
   "requestID":"94cee046-bf52-4a69-b95c-eae662818410",
   "eventID":"7dd83274-8c5f-4b9a-b9b6-371b53771ce9",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```