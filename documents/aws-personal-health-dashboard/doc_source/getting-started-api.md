# Getting started with the AWS Health API<a name="getting-started-api"></a>

The AWS Health API provides programmatic access to the AWS Health information that is presented in the Personal Health Dashboard\. You can use these API operations to get information about events that affect your AWS resources:
+ [DescribeEvents](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEvents.html): Summary information about events\.
+ [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html): Detailed information about one or more events\.
+ [DescribeAffectedEntities](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntities.html): Information about AWS resources that are affected by one or more events\.

In addition, these operations provide information about event types and summary counts of events or affected entities:
+ [DescribeEventTypes](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventTypes.html): Information about the kinds of events that AWS Health tracks\.
+ [DescribeEventAggregates](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventAggregates.html): A count of the number of events that meet specified criteria\.
+ [DescribeEntityAggregates](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEntityAggregates.html): A count of the number of affected entities that meet specified criteria\.

**Organizational View**

When you enable Organizational View in AWS Health, you can use these API operations to get information about events that affect AWS resources in every account across your organization in AWS Organizations\.
+ [DescribeEventsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventsForOrganization.html): Provides summary information about events across accounts in your organization\.
+ [DescribeAffectedAccountsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedAccountsForOrganization.html): Returns a list of accounts in your organization from AWS Organizations that are affected by the provided event\.
+ [DescribeEventDetailsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetailsForOrganization.html): Returns detailed information about one or more specified events for one or more accounts in your organization\.
+ [DescribeAffectedEntitiesForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntitiesForOrganization.html): Returns a list of entities that have been affected by one or more events for one or more accounts in your organization in AWS Organizations, based on the filter criteria\.
+ [EnableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_EnableHealthServiceAccessForOrganization.html): Calling this operation enables AWS Health to work with AWS Organizations\.
+ [DisableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DisableHealthServiceAccessForOrganization.html): Calling this operation disables AWS Health from working with AWS Organizations\.
+ [DescribeHealthServiceStatusForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeHealthServiceStatusForOrganization.html): This operation provides status information on enabling or disabling AWS Health to work with your organization\.

The Health API requires a [Business](https://aws.amazon.com/premiumsupport/plans/business/) or [Enterprise](https://aws.amazon.com/premiumsupport/plans/enterprise/) support plan from AWS Support\. Calling the Health API from an account that does not have a Business or Enterprise support plan causes a `SubscriptionRequiredException`\.

For detailed descriptions of the AWS Health API, see the [AWS Health API Reference](https://docs.aws.amazon.com/health/latest/APIReference/)\.

**Service endpoint**

The endpoint for the AWS Health API is:
+ https://health\.us\-east\-1\.amazonaws\.com

The AWS Health service has one endpoint, in the US East \(N\. Virginia\) Region, that provides event data for all regions\. You can filter query results to get information about events that affect one or more regions, but the query should always be addressed to the health\.us\-east\-1 endpoint\.

**Java code examples**  
The following [topic](code-sample-java.md) demonstrates using the AWS Health API with the AWS SDK for Java\.