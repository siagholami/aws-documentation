# Amazon Detective terms and concepts<a name="detective-terms-concepts"></a>

The following terms and concepts are important for understanding Amazon Detective and how it works:

****Behavior graph****  
A linked set of data generated from incoming source data that is associated with one or more AWS accounts\.  
Each behavior graph uses the same structure of findings, entities, and relationships\.

****Detective source data****  
Processed, structured versions of information from the following types of feeds:  
+ AWS logs, such as AWS CloudTrail and Amazon VPC Flow Logs
+ GuardDuty findings
Detective uses the Detective source data to populate the behavior graph\. Detective also stores copies of the Detective source data to support its analytics\.

**Entity**  
An item extracted from the incoming data\.  
Each entity has a type, which identifies the type of object it represents\. Examples of entity types include IP addresses, Amazon EC2 instances, and AWS users\.  
Entities can be AWS resources that you manage, or external IP addresses that have interacted with your resources\.  
For each entity, the source data is also used to populate entity properties\. Property values can be extracted directly from source records or aggregated across multiple records\.

****Finding****  
A security issue detected by Amazon GuardDuty\.

****Investigation****  
The process of performing triage on suspicious or interesting activity, determining the scope, getting to its underlying source or cause, and then determining how to proceed\.

****Master account****  
The AWS account that owns a behavior graph and that uses the behavior graph for investigation\.  
The master account invites member accounts to contribute their data to the behavior graph\. Master accounts can also view data usage for the behavior graph, and remove member accounts from the behavior graph\.

****Member account****  
An AWS account that a master account invited to contribute data to a behavior graph\.  
Member accounts can respond to the behavior graph invitation and remove their account from the behavior graph\.  
They can also view usage information for their account across the behavior graphs that they contribute data to\.  
They have no other access to the behavior graph\.

****Profile****  
For a finding or an entity, a single page that provides a collection of data visualizations plus supporting guidance\.  
For findings, profiles help analysts to determine whether the finding is of genuine concern or a false positive\.  
For entities, profiles provide supporting details for an investigation into a finding or for a general hunt for suspicious activity\.

****Profile panel****  
A single visualization on a profile\. Each profile panel is intended to help answer a specific question or questions to assist an analyst in an investigation\.  
Profile panels can contain simple key\-value pairs, tables, timelines, bar charts, or geolocation charts\.

****Relationship****  
Activity that occurs between individual entities\. Relationships are also extracted from the incoming source data\.  
Similar to an entity, a relationship has a type, which identifies the types of entities involved and the direction of the connection\. An example of a relationship type is an IP address connecting to an Amazon EC2 instance\.

****Scope time****  
The time window that is used to scope the data displayed on finding and entity profiles\.  
The default scope time for a finding profile reflects the first and last times when the suspicious activity was observed\.  
The default scope time for an entity profile is the previous 24 hours\.