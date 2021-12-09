# Viewing your list of behavior graph invitations<a name="member-view-graph-invitations"></a>

From the Amazon Detective console, Detective API, or AWS Command Line Interface, a member account can see their behavior graph invitations\.

## Viewing behavior graph invitations \(Console\)<a name="member-view-invitations-console"></a>

You can view behavior graph invitations from the AWS Management Console\.

**To view behavior graph invitations \(console\)**

1. Sign in to the AWS Management Console\. Then open the Detective console at [https://console\.aws\.amazon\.com/detective/](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, choose **Account management**\.

On the **Account management** page, **My master accounts** contains your open and accepted behavior graph invitations in the current Region\.

If your account is currently in the free trial period, the page also displays the number of days remaining in your free trial\.

The list does not contain invitations that you declined, memberships that you resigned, or memberships that the master account removed\.

Each invitation shows the master account number, the date that the invitation was accepted, and the current status of the invitation\.
+ For invitations that you have not responded to, the status is **Invited**\.
+ For invitations that you accepted, the status is either **Accepted \(Enabled\)** or **Accepted \(Not enabled\)**\.

  If the status is **Accepted \(Enabled\)**, then your account contributes data to the behavior graph\.

  If the status is **Accepted \(Not enabled\)**, then your account does not contribute data to the behavior graph because of an issue with your account\. This could occur for one of the following reasons\.
  + When you accepted the invitation, your account was not an Amazon GuardDuty customer for at least 48 hours\.
  + The addition of your account would cause the volume of data for the behavior graph to exceed the Detective quota\.

## Viewing behavior graph invitations \(Detective API, AWS CLI\)<a name="member-view-invitations-api"></a>

You can list behavior graph invitations from the Detective API or the AWS Command Line Interface\.

**To retrieve a list of open and accepted invitations to behavior graphs \(Detective API, AWS CLI\)**
+ **Detective API:** Use the [https://docs.aws.amazon.com/detective/latest/APIReference/API_ListInvitations.html](https://docs.aws.amazon.com/detective/latest/APIReference/API_ListInvitations.html) operation\.
+ **AWS CLI:** At the command line, run the `list-invitations` command\.

  ```
  aws detective list-invitations
  ```