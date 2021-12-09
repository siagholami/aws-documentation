# Setting Up Permissions for Amazon CloudWatch<a name="monitoring-permissions"></a>

Use AWS Identity and Access Management \(IAM\) to create a role that gives AWS Elemental MediaTailor access to Amazon CloudWatch\. You must perform these steps for CloudWatch Logs to be published for your account\. CloudWatch automatically publishes metrics for your account\.

**To allow MediaTailor access to CloudWatch**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane of the IAM console, choose **Roles**, and then choose **Create role**\.

1. Choose the **Another AWS account** role type\.

1. For **Account ID**, enter your AWS account ID\.

1. Select **Require external ID** and enter **Midas**\. This option automatically adds a condition to the trust policy that allows the service to assume the role only if the request includes the correct `sts:ExternalID`\.

1. Choose **Next: Permissions**\.

1. Add a permissions policy that specifies what actions this role can complete\. Select from one of the following options, and then choose **Next: Review**:
   + **CloudWatchLogsFullAccess** to provide full access to Amazon CloudWatch Logs
   + **CloudWatchFullAccess** to provide full access to Amazon CloudWatch

1. For **Role name**, enter **MediaTailorLogger**, and then choose **Create role**\.

1. On the **Roles** page, choose the role that you just created\. 

1. To update the principal, edit the trust relationship:

   1. On the role's **Summary** page, choose the **Trust relationship** tab\.

   1. Choose **Edit trust relationship**\.

   1. In the policy document, change the principal to the MediaTailor service\. It should look like this:

      ```
      "Principal": {
         "Service": "mediatailor.amazonaws.com"
      },
      ```

      The entire policy should read as follows:

      ```
      {
        "Version": "2012-10-17",
        "Statement": [
          {
            "Effect": "Allow",
            "Principal": {
              "Service": "mediatailor.amazonaws.com"
            },
            "Action": "sts:AssumeRole",
            "Condition": {
              "StringEquals": {
                "sts:ExternalId": "Midas"
              }
            }
          }
        ]
      }
      ```

   1. Choose **Update Trust Policy**\.