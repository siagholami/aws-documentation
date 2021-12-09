# Disable access logs for your Classic Load Balancer<a name="disable-access-logs"></a>

You can disable access logs for your load balancer at any time\. After you disable access logging, your access logs remain in your Amazon S3 until you delete the them\. For information about managing your S3 bucket, see [Working with buckets](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/BucketOperations.html) in the *Amazon Simple Storage Service Console User Guide*\.

**To disable access logging using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Description** tab, choose **Configure Access Logs**\.

1. On the **Configure Access Logs** page, clear **Enable access logs**\.

1. Choose **Save**\.

**To disable access logging using the AWS CLI**  
Use the following [modify\-load\-balancer\-attributes](https://docs.aws.amazon.com/cli/latest/reference/elb/modify-load-balancer-attributes.html) command to disable access logging:

```
aws elb modify-load-balancer-attributes --load-balancer-name my-loadbalancer --load-balancer-attributes "{\"AccessLog\":{\"Enabled\":false}}"
```

The following is an example response:

```
{
    "LoadBalancerName": "my-loadbalancer",
    "LoadBalancerAttributes": {
        "AccessLog": {
            "S3BucketName": "my-loadbalancer-logs",
            "EmitInterval": 60,
            "Enabled": false,
            "S3BucketPrefix": "my-app"
        }
    }
}
```