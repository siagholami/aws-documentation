# Creating an Audit Report<a name="CT-CreateAuditReport"></a>

The following CloudTrail example shows the results of a call to the [CreateCertificateAuthorityAuditReport](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreateCertificateAuthorityAuditReport.html) operation\.

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
   "eventTime":"2018-01-26T21:56:00Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"CreateCertificateAuthorityAuditReport",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters":{
      "certificateAuthorityArn":"arn:aws:acm-pca:region:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1",
      s3BucketName:"your-bucket-name",
      "auditReportResponseFormat":"JSON"
   },
   "responseElements":{
      "auditReportId":"2a7d28e7-a835-40a6-b19f-371186c62346",
      s3Key:"audit-report/ac5a7c2e-19c8-4258-b74e-351c2b791fe1/2a7d28e7-a835-40a6-b19f-371186c62346.json"
   },
   "requestID":"3b56d220-1660-4941-8160-b54dcc70592d",
   "eventID":"ea95f673-e7be-411d-bb54-ca1ab844baaf",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```