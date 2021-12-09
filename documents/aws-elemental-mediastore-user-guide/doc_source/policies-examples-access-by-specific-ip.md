# Example container policy: Access restricted to specific IP addresses<a name="policies-examples-access-by-specific-ip"></a>

This example policy allows access to all AWS Elemental MediaStore operations on objects in the specified container\. However, the request must originate from the range of IP addresses specified in the condition\.

The condition in this statement identifies the 198\.51\.100\.\* range of allowed Internet Protocol version 4 \(IPv4\) IP addresses, with one exception: 198\.51\.100\.188\.

The `Condition` block uses the `IpAddress` and `NotIpAddress` conditions and the `aws:SourceIp` condition key, which is an AWS\-wide condition key\. The `aws:sourceIp` IPv4 values use the standard CIDR notation\. For more information, see [IP Address Condition Operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#Conditions_IPAddress) in the IAM User Guide\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "AccessBySpecificIPAddress",
            "Effect": "Allow",
            "Action": [
                "mediastore:GetObject",
                "mediastore:DescribeObject"
            ],
            "Principal": "*",
            "Resource": "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/*",
            "Condition": {
                "IpAddress": {
                    "aws:SourceIp": [
                        "192.0.2.0/24",
                        "203.0.113.0/24"
                    ]
                },
                "NotIpAddress": {
                    "aws:SourceIp": "198.51.100.0/24"
                }
            }
        }
    ]
}
```