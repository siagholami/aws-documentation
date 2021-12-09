# Data in a behavior graph<a name="behavior-graph-data-about"></a>

In Detective, you conduct investigations using data from a Detective behavior graph\.

A behavior graph is a linked set of data generated from the Detective source data that is ingested from one or more Amazon Web Services \(AWS\) accounts\.

The behavior graph uses the source data to do the following:
+ Generate an overall picture of your systems, users, and the interactions among them over time
+ Perform more detailed analysis of specific activity to help you answer specific questions that arise as you conduct investigations

Note that all extraction, modeling, and analytics of behavior graph data occurs within the context of each individual behavior graph\.

For information about how a master account manages the member accounts in a behavior graph, see [For master Accounts: Managing the accounts in your behavior graph](https://docs.aws.amazon.com/detective/latest/adminguide/master-account-graph-management.html) in *Detective Administration Guide*\.

**Topics**
+ [How Amazon Detective uses source data to populate a behavior graph](behavior-graph-population-about.md)
+ [Training period for new behavior graphs](detective-data-training-period.md)
+ [Overview of the behavior graph data structure](graph-data-structure-overview.md)
+ [Supported finding types](supported-finding-types.md)