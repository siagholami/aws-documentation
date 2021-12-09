# Using CloudWatch Events<a name="CloudWatchEvents"></a>

You can use [Amazon CloudWatch Events](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/) to automate your AWS services and respond automatically to system events such as application availability issues or resource changes\. Events from AWS services are delivered to CloudWatch Events in near\-real time\. You can write simple rules to indicate which events are of interest to you and the automated actions to take when an event matches a rule\. For more information, see [Creating a CloudWatch Events Rule That Triggers on an Event](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/Create-CloudWatch-Events-Rule.html)\. 

CloudWatch Events are turned into actions using Amazon EventBridge\. With EventBridge, you can use events to trigger targets including AWS Lambda functions, AWS Batch jobs, Amazon SNS topics, and many others\. For more information, see [What Is Amazon EventBridge?](https://docs.aws.amazon.com/eventbridge/latest/userguide/what-is-amazon-eventbridge.html)

## Success or Failure when Creating a Private CA<a name="cwe-issue-CA"></a>

These events are triggered by the [CreateCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreateCertificateAuthority.html) operation\.

**Success**  
On success, the operation returns the ARN of the new CA\.

```
{
   "version":"0",
   "id":"93c0a8a5-3879-ee03-597f-5e2example18",
   "detail-type":"ACM Private CA Creation",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-04T19:14:56Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-west-2:111111111111:certificate-authority/d543408e-0f41-4a3f-a0e0-84dEXAMPL51"
   ],
   "detail":{
      "result":"success"
   }
}
```

**Failure**  
On failure, the operation returns an ARN for the CA\. Using the ARN, you can call [DescribeCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DescribeCertificateAuthority.html) to determine the status of the CA\.

```
{
   "version":"0",
   "id":"93c0a8a5-3879-ee03-597f-5e2example18",
   "detail-type":"ACM Private CA Creation",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-04T19:14:56Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-west-2:111111111111:certificate-authority/d543408e-0f41-4a3f-a0e0-84dEXAMPL51"
   ],
   "detail":{
      "result":"failure"
   }
}
```

## Success or Failure When Issuing a Certificate<a name="cwe-issue-cert"></a>

These events are triggered by the [IssueCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_IssueCertificate.html) operation\.

**Success**  
On success, the operation returns the ARNs of the CA and of the new certificate\.

```
{
   "version":"0",
   "id":"dba9ac68-e917-adb7-b5fa-071examplea7",
   "detail-type":"ACM Private CA Certificate Issuance",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-04T19:57:46Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-west-2:111111111111:certificate-authority/d543408e-0f41-4a3f-a0e0-84dEXAMPL51",
      "arn:aws:acm-pca:us-west-2:111111111111:certificate-authority/d543408e-0f41-4a3f-a0e0-84dEXAMPL51/certificate/b845c374b495cbexamplec4c81cc4043"
   ],
   "detail":{
      "result":"success"
   }
}
```

**Failure**  
On failure, the operation returns a certificate ARN and the ARN of the CA\. With the certificate ARN, you can call [GetCertificate](https://docs.aws.amazon.com/acm/latest/APIReference/API_GetCertificate.html) to view the reason for the failure\.

```
{
   "version":"0",
   "id":"dba9ac68-e917-adb7-b5fa-071examplea7",
   "detail-type":"ACM Private CA Certificate Issuance",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-04T19:57:46Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-west-2:111111111111:certificate-authority/d543408e-0f41-4a3f-a0e0-84dEXAMPL51",
      "arn:aws:acm-pca:us-west-2:111111111111:certificate-authority/d543408e-0f41-4a3f-a0e0-84dEXAMPL51/certificate/b845c374b495cb67dac7ac4c81cc4043"
   ],
   "detail":{
      "result":"failure"
   }
}
```

## Success When Revoking a Certificate<a name="cwe-revocation"></a>

This event is triggered by the [RevokeCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_RevokeCertificate.html) operation\.

No event is sent if the revocation fails or if the certificate has already been revoked\.

****Success****  
On success, the operation returns the ARNs of the CA and of the revoked certificate\.

```
{
   "version":"0",
   "id":"247b9dcb-1f62-b23a-2195-790example7b",
   "detail-type":"ACM Private CA Certificate Revocation",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-05T20:25:19Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-east-1:111111111111:certificate-authority/d87e9a0a-75cb-44ba-bf83-44cEXAMPLE92",
      "arn:aws:acm-pca:us-east-1:111111111111:certificate-authority/d87e9a0a-75cb-44ba-bf83-44cEXAMPLE92/certificate/d2196bfeef09b5b2088b205EXAMPLEd4"
   ],
   "detail":{
      "result":"success"
   }
}
```

## Success or Failure When Generating a CRL<a name="cwe-CRL"></a>

These events are triggered by the [RevokeCertificate](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_RevokeCertificate.html) operation, which should result in the creation of a certificate revocation list \(CRL\)\.

**Success**  
On success, the operation returns the ARN of the CA associated with the CRL\.

```
{
   "version":"0",
   "id":"fefaffcc-9579-8e7b-0565-f11examplead",
   "detail-type":"ACM Private CA CRL Generation",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-04T21:07:08Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:ap-southeast-1:111111111111:certificate-authority/b58e1229-f656-453e-bd11-109EXAMPLE1a"
   ],
   "detail":{
      "result":"success"
   }
}
```

**Failure 1 – CRL could not be saved to Amazon S3 because of a permission error**  
Check your Amazon S3 bucket permissions if this error occurs\. 

```
{
   "version":"0",
   "id":"071f4cb1-2a7b-e70c-ab6d-f56example34",
   "detail-type":"ACM Private CA CRL Generation",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-07T23:01:25Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-east-1:111111111111:certificate-authority/f0192f90-5988-4e90-accc-99dEXAMPLE49"
   ],
   "detail":{
      "result":"failure",
      "reason":"Failed to write CRL to S3. Check your S3 bucket permissions."
   }
}
```

**Failure 2 – CRL could not be saved to Amazon S3 because of an internal error**  
Retry the operation if this error occurs\.

```
{
   "version":"0",
   "id":"071f4cb1-2a7b-e70c-ab6d-f56example34",
   "detail-type":"ACM Private CA CRL Generation",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-07T23:01:25Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-east-1:111111111111:certificate-authority/f0192f90-5988-4e90-accc-99dEXAMPLE49"
   ],
   "detail":{
      "result":"failure",
      "reason":"Failed to write CRL to S3. Internal failure."
   }
}
```

**Failure 3 – ACM PCA failed to create a CRL**  
To troubleshoot this error, check your [CloudWatch metrics](https://docs.aws.amazon.com/acm-pca/latest/APIReference/PcaCloudWatch.html)\.

```
{
   "version":"0",
   "id":"071f4cb1-2a7b-e70c-ab6d-f56example34",
   "detail-type":"ACM Private CA CRL Generation",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-07T23:01:25Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-east-1:111111111111:certificate-authority/f0192f90-5988-4e90-accc-99dEXAMPLE49"
   ],
   "detail":{
      "result":"failure",
      "reason":"Failed to generate CRL. Internal failure."
   }
}
```

## Success or Failure When Creating a CA Audit Report<a name="cwe-audit"></a>

These events are triggered by the [CreateCertificateAuthorityAuditReport](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreateCertificateAuthorityAuditReport.html) operation\.

**Success**  
On success, the operation returns the ARN of the CA and the ID of the audit report\.

```
{
   "version":"0",
   "id":"f4f561f4-c045-e0a3-cb06-bf7exampled8",
   "detail-type":"ACM Private CA Audit Report Generation",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-04T21:54:20Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-west-2:111111111111:certificate-authority/d543408e-0f41-4a3f-a0e0-84dEXAMPLE51",
      "5903194d-0df7-4733-a8a0-cefexampleb9"
   ],
   "detail":{
      "result":"success"
   }
}
```

**Failure**  
An audit report can fail when ACM PCA lacks PUT permissions on your Amazon S3 bucket, when encryption is enabled on the bucket, or for other reasons\.

```
{
   "version":"0",
   "id":"f4f561f4-c045-e0a3-cb06-bf7exampled8",
   "detail-type":"ACM Private CA Audit Report Generation",
   "source":"aws.acm-pca",
   "account":"111111111111",
   "time":"2019-11-04T21:54:20Z",
   "region":"us-east-1",
   "resources":[
      "arn:aws:acm-pca:us-west-2:111111111111:certificate-authority/d543408e-0f41-4a3f-a0e0-84dEXAMPLE51",
      "5903194d-0df7-4733-a8a0-cefexampleb9"
   ],
   "detail":{
      "result":"failure"
   }
}
```