--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Using AWS Security Token Service<a name="using-sts"></a>

The AWS Security Token Service \(AWS STS\) enables you to request temporary, limited\-privilege credentials for IAM users\. 

**Important**  
For AWS services to work properly on a Snowball Edge, you must allow the ports for the services\. For details, see [Ports Required to Use AWS Services on an AWS Snowball Edge Device](port-requirements.md)\.

**Topics**
+ [Using the AWS CLI and API Operations on Snowball Edge](#local-sts-specify-region)
+ [Supported AWS STS AWS CLI Commands on a Snowball Edge](#local-sts-cli-commands)
+ [Supported AWS STS API Operations](#sts-local-supported-apis)

## Using the AWS CLI and API Operations on Snowball Edge<a name="local-sts-specify-region"></a>

When using the AWS CLI or API operations to issue IAM, AWS STS, Amazon S3, and Amazon EC2 commands on Snowball Edge, you must specify the region as "`snow`\." You can do this using `AWS configure` or within the command itself, as in the following examples\.

```
aws configure --profile snowballEdge
AWS Access Key ID [None]: defgh
AWS Secret Access Key [None]: 1234567
Default region name [None]: snow
Default output format [None]: json
```

Or

```
aws sts ls --profile snowballEdge --endpoint http://192.0.2.0:7078 --region snow         
```

**Note**  
The access key ID and access secret key that are use locally on AWS Snowball Edge can't be interchanged with the keys in the AWS Cloud\.

## Supported AWS STS AWS CLI Commands on a Snowball Edge<a name="local-sts-cli-commands"></a>

Only the [assume\-role](https://docs.aws.amazon.com/cli/latest/reference/sts/assume-role.html) command is supported locally\. 

The following parameters are supported for `assume-role`:
+ `role-arn`
+ `role-session-name`
+ `duration-seconds`

### Example Command<a name="local-sts-cli-example"></a>

To assume a role, use the following command\.

```
aws iam list-policies --endpoint http://123.456.1.789:6078 --profile snowballEdge --region snow --role-session-name section-name --duration-seconds 3600
```

For more information about using the `assume-role` command, see [How do I assume an IAM role using the AWS CLI?](https://aws.amazon.com/premiumsupport/knowledge-center/iam-assume-role-cli) 

For more information about using AWS STS, see [Using Temporary Security Credentials](https://docs.aws.amazon.com/STS/latest/UsingSTS/) in the *IAM User Guide*\.

## Supported AWS STS API Operations<a name="sts-local-supported-apis"></a>

Only the [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) API is supported locally\.

The following parameters are supported for `AssumeRole`:
+ `RoleArn`
+ `RoleSessionName`
+ `DurationSeconds`

### Example<a name="local-sts-api-example"></a>

To assume a role, use the following\.

```
https://sts.amazonaws.com/
?Version=2011-06-15
&Action=AssumeRole
&RoleSessionName=session-example
&RoleArn=arn:aws:iam::123456789012:role/demo
&DurationSeconds=3600
```