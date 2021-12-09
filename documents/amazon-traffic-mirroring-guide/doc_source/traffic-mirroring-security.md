# Traffic Mirroring Authentication and Access Control<a name="traffic-mirroring-security"></a>

## <a name="traffic-mirror-session-policy"></a>

To allow access to traffic mirror resources, you create and attach an IAM policy either to:
+ The IAM user or
+ The group to which the IAM user belongs\.

The IAM user must be given permission to use the specific traffic mirror resources and API actions they need\. When you attach a policy to a user or group of users, it allows or denies permission to perform specified tasks on specified resources\. 

You can also use resource\-level permissions to restrict what resources users can use when they invoke APIs\. For example, the following IAM policy restricts the traffic mirror target `tmt-12345645678` that can be used in a `CreateTrafficMirrorSession` API call by a user\.

**Example Example: CreateTrafficMirrorSession Policy**  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "ec2:CreateTrafficMirrorSession",
            "Resource": [
                "arn:aws:ec2:*:*:traffic-mirror-target/tmt-12345678",
                "arn:aws:ec2:*:*:traffic-mirror-filter/*",
                "arn:aws:ec2:*:*:network-interface/*"
            ]
        }
     ]
}
```