# Responding to a behavior graph invitation<a name="member-invitation-response"></a>

When you accept an invitation, Detective verifies that your account can be enabled for the behavior graph\.

If it can be enabled, then Detective begins ingesting and extracting data from logs and findings into the behavior graph as of that point in time\. Your account is charged for the data\.

If it cannot be enabled, then the invitation status is **Accepted \(Not enabled\)**\. Your account does not contribute data to the behavior graph\. Unless you remove your account from the behavior graph, the master account can attempt to enable it at any time\.

If you decline the invitation, then it is removed from your list of invitations, and Detective does not use your account data in the behavior graph\.

## Responding to a behavior graph invitation \(Console\)<a name="member-invitation-response-console"></a>

You can use the AWS Management Console to respond to the email invitation, which includes a link to the Detective console\. You can only respond to an invitation that has a status of **Invited**\.

**To respond to a behavior graph invitation \(console\)**

1. Open the [Detective console](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, choose **Account management**\.

1. Under **My master accounts**, to accept the invitation and begin contributing data to the behavior graph, choose **Accept invitation**\.

   To decline the invitation and remove it from the list, choose **Decline**\.

## Responding to a behavior graph invitation \(Detective API, AWS CLI\)<a name="member-invitation-response-api"></a>

You can respond to behavior graph invitations from the Detective API or the AWS Command Line Interface\.

**To accept a behavior graph invitation \(Detective API, AWS CLI\)**
+ **Detective API:** Use the [https://docs.aws.amazon.com/detective/latest/APIReference/API_AcceptInvitation.html](https://docs.aws.amazon.com/detective/latest/APIReference/API_AcceptInvitation.html) operation\. You must specify the graph ARN\.
+ **AWS CLI:** At the command line, run the `accept-invitation` command\.

  ```
  aws detective accept-invitation --graph-arn <behavior graph ARN>
  ```

  Example:

  ```
  aws detective accept-invitation --graph-arn arn:aws:detective:us-east-1:111122223333:graph:123412341234
  ```

**To decline a behavior graph invitation \(Detective API, AWS CLI\)**
+ **Detective API:** Use the [https://docs.aws.amazon.com/detective/latest/APIReference/API_RejectInvitation.html](https://docs.aws.amazon.com/detective/latest/APIReference/API_RejectInvitation.html) operation\. You must specify the graph ARN\.
+ **AWS CLI:** At the command line, run the `reject-invitation` command\.

  ```
  aws detective reject-invitation --graph-arn <behavior graph ARN>
  ```

  Example:

  ```
  aws detective reject-invitation --graph-arn arn:aws:detective:us-east-1:111122223333:graph:123412341234
  ```