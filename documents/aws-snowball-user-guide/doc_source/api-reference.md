--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Job Management API Reference for AWS Snowball<a name="api-reference"></a>

The job management API for AWS Snowball is a network protocol based on HTTP \(RFC 2616\)\. For more information on this RFC, see [HTTP \(RFC 2616\)](https://www.ietf.org/rfc/rfc2616.txt)\. on the IETF website\. For each call to the job management API, you make an HTTP request to the region\-specific job management API endpoint for the AWS Region where you want to manage jobs\. The API uses JSON \(RFC 4627\) documents for HTTP request/response bodies\.

**Note**  
API calls made within the US regions for listing jobs or describing addresses will return all jobs or addresses within the US for that account, respectively\.

The job management API for Snowball is an RPC model, in which there is a fixed set of operations and the syntax for each operation is known to clients without any prior interaction\. Following, you can find a description of each API operation using an abstract RPC notation, with an operation name that does not appear on the wire\. For each operation, the topic specifies the mapping to HTTP request elements\. 

The specific job management operation to which a given request maps is determined by a combination of the request's method \(GET, PUT, POST, or DELETE\) and which of the various patterns its Request\-URI matches\. If the operation is PUT or POST, Snowball extracts call arguments from the Request\-URI path segment, query parameters, and the JSON object in the request body\.

Although the operation name, such as `CreateJob`, doesn't appear on the wire, these operation names are meaningful in AWS Identity and Access Management \(IAM\) policies\. The operation name is also used to name commands in command\-line tools and elements of the AWS SDK APIs\. For example, the AWS Command Line Interface \(AWS CLI\) command `create-job` maps to the `CreateJob` operation\. The operation name also appears in CloudTrail logs for Snowball API calls\.

For information on installing and setting up the AWS CLI, including specifying what regions you want to make AWS CLI calls against, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\.

**Note**  
The job management API provides programmatic access to the same functionality available in the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2), that is to create and manage jobs for Snowball\. To actually transfer data locally with a Snowball appliance, you'll need to use the Snowball client or the Amazon S3 Adapter for Snowball\. For more information, see [Transferring Data with a Snowball](using-device.md#snowball-data-transfer)\.

## API Endpoint<a name="api-reference-endpoint"></a>

The API endpoint is the Domain Name Service \(DNS\) name used as a host in the HTTP URI for the API calls\. These API endpoints are region\-specific and take the following form\.

```
snowball.aws-region.amazonaws.com
```

For example, the Snowball API endpoint for the US West \(Oregon\) Region is the following\.

```
snowball.us-west-2.amazonaws.com
```

For a list of AWS Regions that Snowball supports \(where you can create and manage jobs\), see [AWS Import/Export](https://docs.aws.amazon.com/general/latest/gr/rande.html#ie-region) in the *AWS General Reference*\.

The region\-specific API endpoint defines the scope of the Snowball resources that are accessible when you make an API call\. For example, when you call the `ListJobs` operation using the preceding endpoint, you get a list of jobs in the US West \(Oregon\) Region that have been created in your account\. 

## API Version<a name="api-reference-version"></a>

The version of the API being used for a call is identified by the first path segment of the request URI, and its form is a ISO 8601 date\. The documentation describes API version 2016\-06\-30\.

## API Permission Policy Reference<a name="api-reference-policies"></a>

The following policies are needed for creating jobs with the job management API for Snowball\.

**Role Trust Policy for Creating Jobs**

Using the job management API to create jobs requires the following trust policy\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "",
      "Effect": "Allow",
      "Principal": {
        "Service": "importexport.amazonaws.com"
      },
      "Action": "sts:AssumeRole",
      "Condition": {
        "StringEquals": {
          "sts:ExternalId": "AWSIE"
        }
      }
    }
  ]
}
```

**Note**  
To learn more about trust policies, see [Modifying a Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_manage_modify.html) in the IAM User Guide\.

**Role Policy for Creating Import Jobs**

Creating an import job requires the following role policy\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetBucketLocation",
                "s3:ListBucketMultipartUploads"
            ],
            "Resource": "arn:aws:s3:::*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetBucketPolicy",
                "s3:PutObject",
                "s3:AbortMultipartUpload",
                "s3:ListMultipartUploadParts",
                "s3:PutObjectAcl"
            ],
            "Resource": "arn:aws:s3:::*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "snowball:*"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

**Role Policy for Creating Export Jobs**

Creating an export job requires the following role policy\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "s3:GetBucketLocation",
        "s3:GetObject",
        "s3:ListBucket"
      ],
      "Resource": "arn:aws:s3:::*"
    },
    {
       "Effect": "Allow",
       "Action": [
         "snowball:*"
       ],
       "Resource": [
         "*"
       ]
    }
  ]
}
```

**Amazon S3 Bucket Policy Principal for Creating Jobs**

If the Amazon S3 buckets that you use with Snowball have bucket policies in place that require listing the role session name of the assumed role, then you'll need to specify a principal in those policies that identifies `AWSImportExport-Validation`\. The following Amazon S3 bucket policy example demonstrates how to do so\. 

**Example**  

```
{
	"Version": "2012-10-17",
	"Statement": {
		"Sid": "Allow AWS Snowball To Create Jobs",
		"Effect": "Deny",
		"NotPrincipal": {
			"AWS": [
				"arn:aws:iam::111122223333:role/rolename",
				"arn:aws:sts::111122223333:assumed-role/rolename/AWSImportExport-Validation",
				"arn:aws:iam::111122223333:root"
			]
		},
		"Action": "S3:*",
		"Resource": ["arn:aws:s3:::examplebucket/*"]
	}
}
```
In this policy example, we deny access to all principals except the one named in the `NotPrincipal` element\. For more information on how to use `NotPrincipal`, see [NotPrincipal](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#NotPrincipal) in the *IAM User Guide*\.

## Related Topics<a name="api-reference-related-topics"></a>
+ [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)