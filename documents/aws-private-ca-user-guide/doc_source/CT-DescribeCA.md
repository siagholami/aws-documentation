# Describing a Certificate Authority<a name="CT-DescribeCA"></a>

The following CloudTrail example shows the results of a call to the [DescribeCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DescribeCertificateAuthority.html) operation\.

```
{
   "eventVersion":"1.05",
   "userIdentity":{
      "type":"IAMUser",
      "principalId":"account",
      "arn":"arn:aws:iam::account:user/name",
      "accountId":"account>",
      "accessKeyId":"Key_ID"
   },
   "eventTime":"2018-01-26T21:58:18Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"DescribeCertificateAuthority",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters":{
      "certificateAuthorityArn":"arn:aws:acm-pca:region1:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1"
   },
   "responseElements":null,
   "requestID":"289d6bd9-cdca-43d1-a446-62e64a7006a4",
   "eventID":"ff5f55b7-06de-4cb4-8fa1-5d29d3948f7b",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```