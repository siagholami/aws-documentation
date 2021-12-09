# Searching for a finding or entity<a name="detective-search"></a>

With the Amazon Detective search function, you can search for a finding or entity\. From the search results, you can navigate to a finding or entity profile\.

## Completing the search<a name="detective-search-completing"></a>

To complete the search, you choose the type of entity to search for\. Then provide the identifier to search for\.

For each entity type, the following identifiers are supported\.
+ For AWS accounts, the account ID\.
+ For IP addresses, the address\.
+ For AWS roles and AWS users, either the principal ID, the name, or the ARN\.
+ For federated users, the principal ID or the user name\. The principal ID is either `<identityProvider>:<username>` or `<identityProvider>:<audience>:<username>`\.
+ For user agents, the user agent name\.
+ For EC2 instances, the instance identifier or the ARN\.
+ For a role session, you can use any of the following values to search:
  +  Role session identifier\.

    The role session identifier uses the format `<rolePrincipalID>:<sessionName>`\.

    Here is an example: `AROA12345678910111213:MySession`\.
  + Role session ARN
  + Session name
  + Principal ID of the role that was assumed
  + Name of the role that was assumed
+ For findings, the finding identifier or finding ARN\.

  The finding type must be one that Detective supports\. See [Supported finding types](supported-finding-types.md)\.

**To search for a finding or entity**

1. Sign in to the AWS Management Console\. Then open the Detective console at [https://console\.aws\.amazon\.com/detective/](https://console.aws.amazon.com/detective/)\.

1. In the navigation pane, choose **Search**\.

1. From the **Choose type** menu, choose the type of item you are looking for\.

   Note that when you choose **User**, you can search for either an AWS user or a federated user\.

   **Examples from your data** contains a sample set of identifiers of the selected type that are in your behavior graph data\. To display the profile for one of the examples, choose its identifier\.

1. Enter the identifier to search for\.

   The search is case sensitive\.

1. Choose **Search** or press **Enter**\.

## Using the search results<a name="detective-search-results"></a>

When you complete the search, Detective displays a list of up to 10,000 matching results\. For searches that use a unique identifier, there is only one matching result\.

From the results, to navigate to the profile for the finding or entity, choose the identifier\.

For findings, roles, users, and EC2 instances, the search results include the associated account\. To navigate to the profile for the account, choose the account identifier\.

## Troubleshooting the search<a name="detective-search-troubleshooting"></a>

If Detective does not find the finding or entity, first check that you entered the correct identifier\. If the identifier is correct, you can also check the following\.
+ **Does the finding or entity belong to an enabled member account in your behavior graph?** If the associated account was not invited to the behavior graph as a member account, then the behavior graph does not contain data for that account\.

  If an invited member account did not accept the invitation, then the behavior graph does not contain data for that account\.
+ **For a finding, does Detective support that finding type?** If the finding type is not one of the types listed in [Supported finding types](supported-finding-types.md), then the behavior graph does not contain data for it\.
+ **For a finding, is the finding archived?** Detective does not receive archived findings from Amazon GuardDuty\.
+ **Did the finding or entity occur before Detective began to ingest data into your behavior graph?** If the finding or entity is not present in the data that Detective ingests, then the behavior graph does not contain data for it\.
+ **Is the finding or entity from the correct Region?** Each behavior graph is specific to a Region\. A behavior graph does not contain data from other Regions\.