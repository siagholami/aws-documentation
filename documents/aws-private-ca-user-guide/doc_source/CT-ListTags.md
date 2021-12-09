# Listing Tags<a name="CT-ListTags"></a>

The following CloudTrail example shows the results of a call to the [ListTags](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListTags.html) operation\.

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
   "eventTime":"2018-02-02T00:21:56Z",
   "eventSource":"acm-pca.amazonaws.com",
   "eventName":"ListTags",
   "awsRegion":"us-east-1",
   "sourceIPAddress":"xx.xx.xx.xx",
   "userAgent":"aws-cli/1.14.28 Python/2.7.9 Windows/8 botocore/1.8.32",
   "requestParameters":{
      "certificateAuthorityArn":"arn:aws:acm-pca:us-east-1:account:certificate-authority/ac5a7c2e-19c8-4258-b74e-351c2b791fe1"
   },
   "responseElements":{
      "tags":[
         {
            "key":"Admin",
            "value":"Alice"
         },
         {
            "key":"User",
            "value":"Bob"
         }
      ]
   },
   "requestID":"72819d8d-c6bc-4921-a944-95bb899ed911",
   "eventID":"a349328f-e3e0-48ee-abc9-00526768080a",
   "eventType":"AwsApiCall",
   "recipientAccountId":"account"
}
```