# Listing Certificate Authorities<a name="CT-ListCAs"></a>

The following CloudTrail example shows the results of a call to the [ListCertificateAuthorities](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListCertificateAuthorities.html) operation\.

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
   "eventTime":"2018-01-26T22:09:43Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"ListCertificateAuthorities",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters":{
      "maxResults":10
   },
   "responseElements":null,
   "requestID":"047fb10f-b000-4915-b339-6b6ee8d9c5d6",
   "eventID":"dbf32c79-77d2-4a3d-863b-8bf964e65fda",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```