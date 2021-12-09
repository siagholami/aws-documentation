# Source data used in a behavior graph<a name="detective-source-data-about"></a>

To populate a behavior graph, Amazon Detective uses source data from the behavior graph master account and member accounts\.

![\[Diagram showing how a behavior graph uses data from the master account and member accounts, and uses the behavior graph data structure.\]](http://docs.aws.amazon.com/detective/latest/adminguide/images/diagram_graph_structure_overview.png)

For details about the behavior graph data structure, see [Overview of the behavior graph data structure](https://docs.aws.amazon.com/detective/latest/userguide/graph-data-structure-overview.html) in *Detective User Guide*\.

**Topics**
+ [Types of Detective source data](#source-data-types)
+ [How Detective ingests and stores source data](#source-data-storage)
+ [How Detective enforces the data volume quota for behavior graphs](#data-volume-enforcement)

## Types of Detective source data<a name="source-data-types"></a>

Detective ingests data from these types of AWS logs:
+ AWS CloudTrail logs 
+ Amazon Virtual Private Cloud \(Amazon VPC\) flow logs 
+ For accounts that are enrolled in GuardDuty, Detective also ingests GuardDuty findings\.

Detective consumes CloudTrail and VPC flow log events using independent and duplicative streams of CloudTrail and VPC flow logs\. These processes do not affect or use your existing CloudTrail and VPC flow log configurations\. They also do not affect the performance of or increase your costs for these services\.

## How Detective ingests and stores source data<a name="source-data-storage"></a>

When Detective is enabled, Detective begins ingesting source data from the behavior graph master account\. As member accounts are added to the behavior graph, Detective also begins using the data from those member accounts\.

Detective source data consists of structured and processed versions of the original feeds\. To support Detective analytics, Detective stores copies of the Detective source data\.

The Detective ingest process feeds data into Amazon Simple Storage Service \(Amazon S3\) buckets in the Detective source data store\. As new source data arrives, other Detective components pick up the data and start the extraction and analytics processes\. For more information, see [How Detective uses source data to populate a behavior graph](https://docs.aws.amazon.com/detective/latest/userguide/behavior-graph-population-about.html) in *Detective User Guide*\.

## How Detective enforces the data volume quota for behavior graphs<a name="data-volume-enforcement"></a>

Detective has a strict quota on the volume of data it allows in each behavior graph\. The data volume is the amount of data per day that flows into the Detective behavior graph\.

Detective enforces this quota when a master account enables Detective, and when a member account accepts an invitation to contribute to a behavior graph\.
+ If the data volume for a master account exceeds the quota, then the master account cannot enable Detective\.
+ If the added data volume from a member account would cause the behavior graph to exceed the quota, the member account cannot be enabled\.

The data volume for a behavior graph also can grow naturally over time\. Detective checks the behavior graph data volume each day to make sure that it does not exceed the quota\.

If the behavior graph data volume is approaching the quota, Detective displays a warning message on the console\. To avoid exceeding the quota, you can remove member accounts\.

If the behavior graph data volume exceeds the quota, then Detective disables the behavior graph\. When the behavior graph is disabled, no new data is ingested into it\. You can still view the existing behavior graph data\. The console displays a message to indicate that the behavior graph is disabled\.

If your behavior graph is disabled, you must work with AWS Support to get it re\-enabled\. If possible, before you contact AWS Support, try to remove member accounts to get the data volume below the quota\. This makes it easier to re\-enable the behavior graph\.