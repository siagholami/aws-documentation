# Disabling access logging for a container<a name="monitoring-cloudwatch-logs-disable"></a>

When you disable access logging on a container, AWS Elemental MediaStore stops sending access logs to Amazon CloudWatch\. These access logs are not saved and are not retrievable\.

**To disable access logging \(AWS CLI\)**
+ In the AWS CLI, use the `stop-access-logging` command:

  ```
  aws mediastore stop-access-logging --container-name LiveEvents
  ```

  This command has no return value\.