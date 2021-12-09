# Retrieving a Certificate<a name="CT-GetCertificate"></a>

The following CloudTrail example shows the results of a call to the [GetCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_GetCertificate.html) operation\.

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
   "eventTime":"2018-01-26T22:22:54Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"GetCertificate",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters":{
      "certificateAuthorityArn":"arn:aws:acm-pca:region:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1",
      "certificateArn":"arn:aws:acm-pca:region:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1/certificate/6707447683a9b7f4055627ffd55cebcc"
   },
   "responseElements":null,
   "requestID":"ec0681a9-6202-496e-985a-adba939311e4",
   "eventID":"89be1a2a-3340-4d74-a633-5582a2fba1d3",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```