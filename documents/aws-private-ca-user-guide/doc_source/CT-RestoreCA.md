# Restoring a Certificate Authority<a name="CT-RestoreCA"></a>

The following CloudTrail example shows the results of a call to the [RestoreCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_RestoreCertificateAuthority.html) operation\. In this example, the certificate authority cannot be restored because it is not in the `DELETED` state\. 

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
   "eventTime":"2018-01-26T22:01:11Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"RestoreCertificateAuthority",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "errorCode":"InvalidStateException",
   "errorMessage":"The certificate authority is not in a valid state for restoration.",
   "requestParameters":{
      "certificateAuthorityArn":"arn:aws:acm-pca:region:account:certificate-authority/09517d62-4f11-4bf8-a2c9-9e863792b675"
   },
   "responseElements":null,
   "requestID":"dae3e14f-62f6-42f3-acf4-630c47a09ee4",
   "eventID":"c40abfac-53f7-420a-9b55-c3f2f2139de8",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```