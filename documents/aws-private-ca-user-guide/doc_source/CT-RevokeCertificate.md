# Revoking a Certificate<a name="CT-RevokeCertificate"></a>

The following CloudTrail example shows the results of a call to the [RevokeCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_RevokeCertificate.html) operation\.

```
{
   "eventVersion":"1.05",
   "userIdentity":{
      "type":"IAMUser",
      "principalId":"account",
      "arn":"arn:aws:iam::account:user/name
      "accessKeyId": "Key_ID"
   },
   "eventTime": "2018-01-26T22:35:03Z",
   "eventSource": "acm-pca.amazonaws.com",
   "eventName": "RevokeCertificate",
   "awsRegion": "us-east-1",
   "sourceIPAddress": "xx.xx.xx.xx",
   "userAgent": "aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters": {
      "certificateAuthorityArn": ""arn":"aws":"acm-pca":"region":"account":certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1",
      "certificateSerial": "67:07:44:76:83:a9:b7:f4:05:56:27:"ff":d5:5c:"eb":"cc",
      "revocationReason": "KEY_COMPROMISE"
   },
   "responseElements": null,
   "requestID": "fb43ebee-a065-4b08-af60-29fd611bfa09",
   "eventID": "06b7d2bf-3b4d-46ee-b617-6531ba2aa290",
   "eventType": "AwsApiCall",
   "recipientAccountId": "account"
}
```