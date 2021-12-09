# Global Tables: How It Works<a name="globaltables_HowItWorks"></a>


****  

|  | 
| --- |
| There are two versions of DynamoDB global tables available: [Version 2019\.11\.21 \(Current\)](globaltables.V2.md) and [Version 2017\.11\.29](globaltables.V1.md)\. To find out which version you are using, see [Determine Version](globaltables.DetermineVersion.md)\. | 

 The following sections help you understand the concepts and behavior of global tables in Amazon DynamoDB\. 

## Global Table Concepts<a name="globaltables_HowItWorks.KeyConcepts"></a>

A *global table* is a collection of one or more replica tables, all owned by a single AWS account\.

A *replica table* \(or *replica*, for short\) is a single DynamoDB table that functions as a part of a global table\. Each replica stores the same set of data items\. Any given global table can only have one replica table per AWS Region\.

The following is a conceptual overview of how a global table is created\.

1. Create an ordinary DynamoDB table, with DynamoDB Streams enabled, in an AWS Region\.

1. Repeat step 1 for every other Region where you want to replicate your data\.

1. Define a DynamoDB global table based on the tables that you have created\.

The AWS Management Console automates these tasks, so you can create a global table more quickly and easily\. For more information, see [Creating a Global Table](globaltables.tutorial.md)\.

The resulting DynamoDB global table consists of multiple replica tables, one per Region, that DynamoDB treats as a single unit\. Every replica has the same table name and the same primary key schema\. When an application writes data to a replica table in one Region, DynamoDB automatically propagates the write to the other replica tables in the other AWS Regions\.

**Important**  
To keep your table data in sync, global tables automatically create the following attributes for every item:   
`aws:rep:deleting` 
`aws:rep:updatetime` 
`aws:rep:updateregion` 
Do not modify these attributes or create attributes with the same name\. 

You can add replica tables to the global table so that it can be available in additional Regions\. \(To do this, the global table must be empty\. In other words, none of the replica tables can have any data in them\.\)

You can also remove a replica table from a global table\. If you do this, the table is completely disassociated from the global table\. This newly independent table no longer interacts with the global table, and data is no longer propagated to or from the global table\.

## Consistency and Conflict Resolution<a name="globaltables_HowItWorks.conflict-resolution"></a>

Any changes made to any item in any replica table are replicated to all the other replicas within the same global table\. In a global table, a newly written item is usually propagated to all replica tables within seconds\.

With a global table, each replica table stores the same set of data items\. DynamoDB does not support partial replication of only some of the items\.

An application can read and write data to any replica table\. If your application only uses eventually consistent reads and only issues reads against one AWS Region, it will work without any modification\. However, if your application requires strongly consistent reads, it must perform all of its strongly consistent reads and writes in the same Region\. DynamoDB does not support strongly consistent reads across Regions\. Therefore, if you write to one Region and read from another Region, the read response might include stale data that doesn't reflect the results of recently completed writes in the other Region\. 

Conflicts can arise if applications update the same item in different Regions at about the same time\. To help ensure eventual consistency, DynamoDB global tables use a *last writer wins* reconciliation between concurrent updates, in which DynamoDB makes a best effort to determine the last writer\. With this conflict resolution mechanism, all the replicas will agree on the latest update and converge toward a state in which they all have identical data\. 

## Availability and Durability<a name="globaltables_HowItWorks.availability-durability"></a>

If a single AWS Region becomes isolated or degraded, your application can redirect to a different Region and perform reads and writes against a different replica table\. You can apply custom business logic to determine when to redirect requests to other Regions\. 

If a Region becomes isolated or degraded, DynamoDB keeps track of any writes that have been performed but have not yet been propagated to all of the replica tables\. When the Region comes back online, DynamoDB resumes propagating any pending writes from that Region to the replica tables in other Regions\. It also resumes propagating writes from other replica tables to the Region that is now back online\.