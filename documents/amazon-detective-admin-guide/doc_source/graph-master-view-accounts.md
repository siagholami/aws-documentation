# Viewing the list of accounts in a behavior graph<a name="graph-master-view-accounts"></a>

The master account can use the Detective console or API to view a list of behavior graph accounts\.

The results do not include member accounts that declined the invitation or that were removed from the behavior graph\. It only includes accounts with the following statuses\.

****Verification in progress****  
Detective is verifying the account email address before it sends the invitation\.

****Verification failed****  
The email address verification failed\. The invitation was not sent\.

****Invited****  
The invitation was sent, but the member account has not yet responded\.

****Accepted \(Enabled\)****  
The member account accepted the invitation and is contributing data to the behavior graph\.

****Accepted \(Not enabled\)****  
The member account accepted the invitation, but cannot be enabled\. This status occurs for one of the following reasons\.  
+ The member account has not been an Amazon GuardDuty customer for at least 48 hours\.
+ The member account data would cause the behavior graph data volume to exceed the Detective quota\.

## Listing accounts in the Detective behavior graph \(Console\)<a name="master-view-graph-accounts-console"></a>

You can use the AWS Management Console to see and filter a list of accounts in your behavior graph\.

**To display the list of accounts in the behavior graph \(console\)**

1. Sign in to the AWS Management Console\. Then open the Detective console at [https://console\.aws\.amazon\.com/detective/](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, choose **Account management**\.

   **My member accounts** lists your account and the member accounts that you invited to contribute data to the behavior graph\. For each account, the list displays the following information:
   + The AWS account identifier\.
   + For member accounts only, the account root user email address\.
   + The account status\.
   + The data volume for the account\. This is the percentage of data volume for the account relative to the maximum allowed data volume for a behavior graph\. Detective cannot retrieve the data volume for member accounts that have not accepted the behavior graph invitation\.
   + The date when the account status was last updated\.

**To add a filter to the list of accounts in the behavior graph \(console\)**

1. Choose the filter box\.

1. Choose the column that you want to use to filter the list\.

1. For the specified column, choose the value to use for the filter\.

1. To remove a filter, choose the **x** icon at the top right\.

1. To update the list with the most recent status information, choose the refresh icon at the top right\.

## Listing the accounts in the Detective behavior graph \(Detective API, AWS CLI\)<a name="master-view-graph-accounts-api"></a>

You can use an API call or the AWS Command Line Interface to view a list of all invited and monitored member accounts in your behavior graph\.

**To retrieve a list of all of the invited and monitored member accounts \(Detective API, AWS CLI\)**
+ **Detective API:** Use the [https://docs.aws.amazon.com/detective/latest/APIReference/API_ListMembers.html](https://docs.aws.amazon.com/detective/latest/APIReference/API_ListMembers.html) operation\. To identify the intended behavior graph, specify the behavior graph ARN\.
+ **AWS CLI:** At the command line, run the `list-members` command\.

  ```
  aws detective list-members --graph-arn <graph ARN>
  ```

  Example:

  ```
  aws detective list-members --graph-arn arn:aws:detective:us-east-1:111122223333:graph:123412341234
  ```

**To retrieve details about specific member accounts in your behavior graph \(Detective API, AWS CLI\)**
+ **Detective API:** Use the [https://docs.aws.amazon.com/detective/latest/APIReference/API_GetMembers](https://docs.aws.amazon.com/detective/latest/APIReference/API_GetMembers) operation\. Specify the behavior graph ARN and the list of account identifiers for the member accounts\.
+ **AWS CLI:** At the command line, run the `get-members` command\.

  ```
  aws detective get-members --account-ids <member account IDs> --graph-arn <behavior graph ARN>
  ```

  Example:

  ```
  aws detective get-members --account-ids 444455556666 123456789012 --graph-arn arn:aws:detective:us-east-1:111122223333:graph:123412341234
  ```