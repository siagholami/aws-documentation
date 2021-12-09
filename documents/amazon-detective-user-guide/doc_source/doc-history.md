# Document history for Detective User Guide<a name="doc-history"></a>

The following table provides a history of the updates to this guide\.


|  Change  |  Description  |  Date  | 
| --- | --- | --- | 
|  [New role session and federated user entities](https://docs.aws.amazon.com/detective/latest/userguide/graph-data-structure-overview.html#entity-types)  |  Detective now allows you to explore and investigate federated authentication\. You can see what resources have assumed each role, and when those authentications occurred\.  |  September 17, 2020  | 
|  [Updates to scope time management](https://docs.aws.amazon.com/detective/latest/userguide/scope-time-managing.html)  |  Removed the option to lock or unlock the scope time\. It is always locked\. On a finding profile, a warning is displayed if the scope time is different from the finding time window\.  |  September 4, 2020  | 
|  [Profile header remains visible as you scroll through a profile](https://docs.aws.amazon.com/detective/latest/userguide/profile-navigating.html)  |  On profiles, the type, identifier, and scope time remain visible as you scroll through the profile panels on a tab\. When the tabs are not visible, you can use the tab dropdown list in the breadcrumbs to navigate to a different tab\.  |  September 4, 2020  | 
|  [Added to the allowed criteria for searches](https://docs.aws.amazon.com/detective/latest/userguide/detective-search.html)  |  The allowed criteria for searches has expanded\. You can search for AWS users and AWS roles by name\. You can use the ARN to search for findings, AWS roles, AWS users, and EC2 instances\.   |  August 27, 2020  | 
|  [Search always displays search results](https://docs.aws.amazon.com/detective/latest/userguide/detective-search.html)  |  When you conduct a search, it now displays the results on the **Search** page\. From the results, you can pivot to a finding or entity profile\.  |  August 27, 2020  | 
|  [Links to other consoles on profile panels](https://docs.aws.amazon.com/detective/latest/userguide/profile-panel-console-links.html)  |  On the **EC2 instance details** profile panel, the EC2 instance identifier is linked to the Amazon EC2 console\. On the **User details**, and **Role details** profile panels, the user name and role name are linked to the IAM console\.  |  August 14, 2020  | 
|  [New activity details for **Overvall VPC flow volume** profile panel](https://docs.aws.amazon.com/detective/latest/userguide/profile-panel-drilldown-overall-vpc-volume.html)  |  From the **Overall VPC flow volume** profile panel, you can now display activity details\. The details show a list of interactions between the EC2 instance and IP addresses\.  |  July 23, 2020  | 
|  Amazon Detective general availability release  |  Detective is now generally available\.  |  March 31, 2020  | 
|  Introducing Amazon Detective \(preview\)  |  Detective uses machine learning and purpose\-built visualizations to help you analyze and investigate security issues across your Amazon Web Services \(AWS\) workloads\. Detective is currently in preview\.  |  December 3, 2019  | 