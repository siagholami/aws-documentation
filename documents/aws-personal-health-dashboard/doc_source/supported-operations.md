# Supported operations in AWS Health<a name="supported-operations"></a>

AWS Health supports the following operations for getting information about events that affect an AWS account:
+ The event types supported by AWS Health\.
+ Information about one or more events that match specified filter criteria\.
+ Information about the entities that are affected by one or more events\.
+ Categorized counts of events or entities that match specified filter criteria\.

All operations are non\-mutating\. That is, they retrieve data but do not modify it\. The following sections summarize the AWS Health operations:

**Event types**  
The [DescribeEventTypes](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventTypes.html) operation retrieves event types that match the optional specified filter\. An event type is a template definition of an event's AWS service, event type code, and category\. An event type and event are similar to a class and object in object\-oriented programming\. The number of event types supported by AWS Health grows over time\.

**Events**  
The [DescribeEvents](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEvents.html) operation retrieves summary information about events that are related to an AWS account\. The events can be related to AWS operational issues, scheduled changes to AWS infrastructure, or security and billing notifications\. The [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) operation retrieves detailed information about one or more events, such as the AWS service, Region, Availability Zone, event start and end times, and a text description\.

**Affected entities**  
The [DescribeAffectedEntities](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntities.html) operation retrieves information about entities that are affected by one or more events\. The results can be filtered by additional criteria, such as status, that might be assigned to AWS resources\.

**Aggregation**  
The [DescribeEventAggregates](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventAggregates.html) operation retrieves a count of the events in each event type category, optionally filtered by other criteria\. The [DescribeEntityAggregates](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEntityAggregates.html) operation retrieves a count of the entities \(resources\) that are affected by one or more specified events\.

**AWS Organizations and Organization View**

**DescribeEventsForOrganization**  
[DescribeEventsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventsForOrganization.html) returns summary information about events across the AWS Organizations, meeting the specified filter criteria\. 

**DescribeAffectedAccountsForOrganization**  
[DescribeAffectedAccountsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedAccountsForOrganization.html) returns a list of AWS accounts in the AWS Organizations that are affected by the provided event\.

**DescribeEventDetailsForOrganization**  
[DescribeEventDetailsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetailsForOrganization.html) returns detailed information about one or more specified events for one or more accounts in AWS Organizations\. 

**DescribeAffectedEntitiesForOrganization**  
[DescribeAffectedEntitiesForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntitiesForOrganization.html) returns a list of entities that have been affected by one or more events for one or more accounts in your organization, based on the filter criteria\. 

**EnableHealthServiceAccessForOrganization**  
[EnableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_EnableHealthServiceAccessForOrganization.html) operation grants the AWS Health service permission to interact with AWS Organizations on the customer’s behalf and applies a Service Linked Role to the master account in your organization\. 

**DisableHealthServiceAccessForOrganization**  
[DisableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DisableHealthServiceAccessForOrganization.html) operation revokes permission for the AWS Health service to interact with AWS Organizations on the customer's behalf\.

**DescribeHealthServiceStatusForOrganization**  
[DescribeHealthServiceStatusForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DisableHealthServiceAccessForOrganization.html) operation provides status information on enabling or disabling AWS Health to work with your organization

For more information about these operations, see the [AWS Health API Reference](https://docs.aws.amazon.com/health/latest/APIReference/)\.