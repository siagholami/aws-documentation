# Inviting member accounts to a behavior graph<a name="graph-master-add-member-accounts"></a>

The master account can invite up to 1000 member accounts to contribute to a behavior graph\.

At a high level, the process for inviting members to contribute to a behavior graph is as follows\.

1. For each member account to add, the master account provides the AWS account identifier and the root user email address\.

1. Detective validates that the email address is the root user email address for the account\.

1. If the account information is valid, Detective sends the invitation to the member account\.

1. The member account accepts or declines the invitation\.

1. If the member account accepts the invitation, then Detective checks whether the member account has been an Amazon GuardDuty customer for at least 48 hours\.

   If it has, then Detective checks whether the member account data would cause the data rate for the behavior graph to exceed the quota\.

1. If the member account passes both of those checks, then the member account status is **Accepted \(Enabled\)**\. Detective begins to ingest data from the member account into the behavior graph\.

   If it fails either of those checks, then the member account status is **Accepted \(Not enabled\)**\. The member account does not contribute data to the behavior graph\.

## Inviting individual accounts to a behavior graph \(Console\)<a name="graph-master-select-accounts-individual"></a>

You can manually specify which member accounts to invite to contribute their data to a behavior graph\.

**To manually select the member accounts to invite \(console\)**

1. Open the [Detective console](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, choose **Account management**\.

1. Under **My member accounts**, choose **Invite individual accounts**\.

1. Under **Add accounts**, add a member account to the invitation list\.

   1. Choose **Add account**\.

   1. For **AWS Account ID**, enter the AWS account ID\.

   1. For **Email address**, enter the root user email address for the account\.

1. To remove an account from the list, choose **Remove** for that account\.

1. Under **Personalize invitation email**, add customized content to include in the invitation email\.

   For example, you can use this area to provide contact information\. Or use it to remind the member account that they need to attach the required IAM policy to their user or role before they can accept the invitation\.

1. **Member account IAM policy** contains the text of the required IAM policy for member accounts\. The email invitation includes this policy text\. To copy the policy text, choose **Copy**\.

1. Choose **Invite**\.

## Inviting a list of member accounts to a behavior graph \(Console\)<a name="graph-master-select-accounts-csv"></a>

From the Detective console, you can provide a `.csv` file containing a list of member accounts to invite to your behavior graph\.

The first line in the file is the header row\. Each account is then listed on a separate line\. Each member account entry contains the AWS account ID and the account's root user email address\.

Example:

```
Account ID,Email address
111122223333,srodriguez@example.com
444455556666,rroe@example.com
```

When Detective processes the file, it ignores accounts that were already invited, unless the account status is **Verification failed**\. That status indicates that the email address provided for the account did not match the account's root user email address\. In that case, Detective deletes the original invitation and tries again to verify the email address and send the invitation\.

This option also provides a template that you can use to create the list of accounts\.

**To invite member accounts from a \.csv list \(console\)**

1. Open the [Detective console](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, choose **Account management**\.

1. Under **My member accounts**, choose **Invite accounts from \.csv**\.

1. Under **Add accounts**, to download a template file to work from, choose **Download \.csv template**\.

1. To select the file containing the list of accounts, choose **Choose \.csv file**\.

1. Under **Review member accounts**, verify the list of member accounts that Detective found in the file\.

1. Under **Personalize invitation email**, add customized content to include in the invitation email\.

   For example, you can provide contact information, or remind the member account about the required IAM policy\.

1. **Member account IAM policy** contains the text of the required IAM policy for member accounts\. The email invitation includes this policy text\. To copy the policy text, choose **Copy**\.

1. Choose **Invite**\.

## Inviting member accounts to a behavior graph \(Detective API, AWS CLI\)<a name="graph-master-add-account-api"></a>

You can use the Detective API or the AWS Command Line Interface to invite member accounts to contribute their data to a behavior graph\.

**To invite member accounts to a behavior graph \(Detective API, AWS CLI\)**
+ **Detective API:** Use the [https://docs.aws.amazon.com/detective/latest/APIReference/API_CreateMembers.html](https://docs.aws.amazon.com/detective/latest/APIReference/API_CreateMembers.html) operation\. You must provide the graph ARN\. For each account, specify the account identifier and the root user email address\. You can optionally provide custom text to add to the invitation email\.
+ **AWS CLI:** At the command line, run the `create-members` command\.

  ```
  aws detective create-members --accounts AccountId=<AWS account ID>,EmailAddress=<root user email address> --graph-arn <behavior graph ARN> --message "<Custom message text>"
  ```

  Example:

  ```
  aws detective create-members --accounts AccountId=444455556666,EmailAddress=mmajor@example.com AccountId=123456789012,EmailAddress=jstiles@example.com --graph-arn arn:aws:detective:us-east-1:111122223333:graph:123412341234 --message "This is Paul Santos. I need to add your account to the data we use for security investigation in Amazon Detective. If you have any questions, contact me at psantos@example.com."
  ```

## Adding a list of member accounts across Regions \(Python script on GitHub\)<a name="graph-master-add-accounts-github-scripts"></a>

Detective provides an open\-source script in GitHub that allows you to do the following:
+ Add a specified list of member accounts to a master account's behavior graphs across a specified list of Regions\.
+ If the master account does not have a behavior graph in a Region, then the script also enables Detective and creates the behavior graph in that Region\.
+ Sends invitation emails to the member accounts\.
+ Automatically accept the invitations for the member accounts\.

For information on how to configure and use the GitHub scripts, see [Using the Amazon Detective Python scripts](detective-github-scripts.md)\.