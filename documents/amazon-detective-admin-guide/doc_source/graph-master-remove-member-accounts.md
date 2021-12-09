# Removing member accounts from a behavior graph<a name="graph-master-remove-member-accounts"></a>

The master account can remove member accounts from a behavior graph at any time\. When a member account is removed from a behavior graph, the following occurs\.
+ The member account is removed from **My member accounts**\.
+ Amazon Detective stops ingesting data from the removed account\.

Detective does not remove any existing data from the behavior graph, which aggregates data across member accounts\.

## Removing member accounts from a behavior graph \(Console\)<a name="graph-master-remove-accounts-console"></a>

From your master account, you can use the AWS Management Console to remove member accounts from a behavior graph\.

**To remove member accounts \(console\)**

1. Open the [Detective console](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, choose **Account management**\.

1. Under **My member accounts**, select the check box for each member account to delete\.

   You cannot delete your own account from the list\.

1. Choose **Manage accounts**\. Then choose **Remove account**\.

1. When prompted to confirm, enter **remove**\.

1. Choose **Remove member accounts**\.

## Removing member accounts from a behavior graph \(Detective API, AWS CLI\)<a name="graph-master-remove-accounts-api"></a>

From your master account, you can use the Detective API or the AWS Command Line Interface to remove member accounts from a behavior graph\.

**To use remove member accounts from your behavior graph \(Detective API, AWS CLI\)**
+ **Detective API:** Use the [https://docs.aws.amazon.com/detective/latest/APIReference/API_DeleteMembers.html](https://docs.aws.amazon.com/detective/latest/APIReference/API_DeleteMembers.html) operation\. Specify the graph ARN and the list of account identifiers for the member accounts to remove\.
+ **AWS CLI:** At the command line, run the `delete-members` command\.

  ```
  aws detective delete-members --account-ids <account ID list> --graph-arn <behavior graph ARN>
  ```

  Example:

  ```
  aws detective delete-members --account-ids 444455556666 123456789012 --graph-arn arn:aws:detective:us-east-1:111122223333:graph:123412341234
  ```

## Removing a list of member accounts across Regions \(Python script on GitHub\)<a name="graph-master-remove-accounts-github-scripts"></a>

Detective provides an open\-source script in GitHub\. You can use this script to remove a specified list of member accounts from the master account's behavior graphs across a specified list of Regions\.

For information on how to configure and use the GitHub scripts, see [Using the Amazon Detective Python scripts](detective-github-scripts.md)\.