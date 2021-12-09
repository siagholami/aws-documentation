# Issuing a Certificate<a name="CT-IssueCertificate"></a>

The following CloudTrail example shows the results of a call to the [IssueCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_IssueCertificate.html) operation\.

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
   "eventTime":"2018-01-26T22:18:43Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"IssueCertificate",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters":{
      "certificateAuthorityArn":"arn:aws:acm-pca:region:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1",
      "csr":{
         "hb":[
            45,
            45,
            ...10
         ],
         "offset":0,
         "isReadOnly":false,
         "bigEndian":true,
         "nativeByteOrder":false,
         "mark":-1,
         "position":1090,
         "limit":1090,
         "capacity":1090,
         "address":0
      },
      "signingAlgorithm":"SHA256WITHRSA",
      "validity":{
         "value":365,
         "type":"DAYS"
      },
      "idempotencyToken":"1234"
   },
   "responseElements":{
      "certificateArn":"arn:aws:acm-pca:region:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1/certificate/6707447683a9b7f4055627ffd55cebcc"
   },
   "requestID":"0a5808dd-fc92-46f8-ba07-090ef8e9bcb4",
   "eventID":"2816c6f0-184c-4d8b-b4ca-e54ab8dd6f2c",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```