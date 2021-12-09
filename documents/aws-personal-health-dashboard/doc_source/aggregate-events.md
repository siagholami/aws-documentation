# Aggregating AWS Health events across accounts with organizational view<a name="aggregate-events"></a>

By default, AWS Health lets you view the AWS Health events of a single AWS account\. If you use AWS Organizations, you can also view AWS Health events centrally across your organization\. This feature provides access to the same information as single account operations\. You can use filters to view events in specific AWS Regions, accounts, and services\. 

You can aggregate AWS Health events in real time to identify accounts in your organization that are affected by an operational event or get notified of security vulnerabilities\. You can also proactively manage and automate resource maintenance events across your organization\. Use this feature to stay informed of upcoming changes to AWS services that might require updates or code changes\. 

You can view organizational events up to 90 days before they're deleted\. If you have a Business or Enterprise support plan, you can use this feature at no extra cost\.

**Topics**
+ [Prerequisites](#prerequisites-organizational-view)
+ [Enabling organizational view](#enable-organizational-view)
+ [Viewing organizational view events](#viewing-organizational-view-events)
+ [AWS Health organizational view API operations](#using-the-organizational-view-apis)
+ [Disabling organizational view](#disabling-organizational-view)

## Prerequisites<a name="prerequisites-organizational-view"></a>

Before you use the AWS Health APIs for organizational view, you must:
+ Be part of an organization with [all features](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_getting-started_concepts.html#feature-set-all) enabled\.
+ Have a [Business](http://aws.amazon.com/premiumsupport/plans/business/) or [Enterprise](http://aws.amazon.com/premiumsupport/plans/enterprise/) support plan\.
+ Sign in as an AWS Identity and Access Management \(IAM\) user, assume an IAM role, or sign in as the root user \(not recommended\) in your organization's master account\. For more information, see [Lock Away Your AWS Account Root User Access Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#lock-away-credentials) in the *IAM User Guide*\.
+ Be sure that the master account IAM policy grants access to the AWS Health API operations\. See [Allow AWS Health organizational API access](security_iam_id-based-policy-examples.md#allow-organizational-api-access)\. 

## Enabling organizational view<a name="enable-organizational-view"></a>

You can only enable organizational view by using the [EnableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_EnableHealthServiceAccessForOrganization.html) API operation\.

You can use the AWS Command Line Interface \(AWS CLI\) or your own code to call this operation\. 

**Note**  
You must use the US East \(N\. Virginia\) Region endpoint\.

**Example**  
The following AWS CLI command enables this feature from your AWS account\. You can use this command from the master account or from an account that can assume the role with the required permissions\.   

```
aws health enable-health-service-access-for-organization --region us-east-1
```

The following code examples call the [EnableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_EnableHealthServiceAccessForOrganization.html) API operation\.

------
#### [ Python ]

```
import boto3

client = boto3.client('health')

response = client.enable_health_service_access_for_organization()

print(response)
```

------
#### [ Java ]

You can use the AWS SDK for version Java 2\.0 for the following example\.

```
import software.amazon.awssdk.services.health.HealthClient;
import software.amazon.awssdk.services.health.HealthClientBuilder;
 
import software.amazon.awssdk.services.health.model.ConcurrentModificationException;
import software.amazon.awssdk.services.health.model.EnableHealthServiceAccessForOrganizationRequest;
import software.amazon.awssdk.services.health.model.EnableHealthServiceAccessForOrganizationResponse;
import software.amazon.awssdk.services.health.model.DescribeHealthServiceStatusForOrganizationRequest;
import software.amazon.awssdk.services.health.model.DescribeHealthServiceStatusForOrganizationResponse;
 
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
 
import software.amazon.awssdk.regions.Region;
 
public class EnableHealthServiceAccessDemo {
    public static void main(String[] args) {
        HealthClient client = HealthClient.builder()
            .region(Region.US_EAST_1)
            .credentialsProvider(
                DefaultCredentialsProvider.builder().build()
            )
            .build();
 
        try {
            DescribeHealthServiceStatusForOrganizationResponse statusResponse = client.describeHealthServiceStatusForOrganization(
                DescribeHealthServiceStatusForOrganizationRequest.builder().build()
            );
 
            String status = statusResponse.healthServiceAccessStatusForOrganization();
            if ("ENABLED".equals(status)) {
                System.out.println("EnableHealthServiceAccessForOrganization already enabled!");
                return;
            }
 
            client.enableHealthServiceAccessForOrganization(
                EnableHealthServiceAccessForOrganizationRequest.builder().build()
            );
 
            System.out.println("EnableHealthServiceAccessForOrganization is in progress");
        } catch (ConcurrentModificationException cme) {
            System.out.println("EnableHealthServiceAccessForOrganization is already in progress. Wait for the action to complete before trying again.");
        } catch (Exception e) {
            System.out.println("EnableHealthServiceAccessForOrganization FAILED: " + e);
        }
    }
}
```

For more information, see the [AWS SDK for Java 2\.0 Developer Guide](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/)\.

------

When you enable this feature, the `AWSServiceRoleForHealth_Organizations` [service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html) \(SLR\) with the `Health_OrganizationsServiceRolePolicy` policy is applied to the master account in the organization\.

**Note**  
Enabling this feature is an asynchronous process and takes time to complete\. You can call the [DescribeHealthServiceStatusForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeHealthServiceStatusForOrganization.html) operation to check the status of the process\.

## Viewing organizational view events<a name="viewing-organizational-view-events"></a>

After you enable this feature, AWS Health starts to record events that affect accounts in the organization\. When an account joins your organization, AWS Health automatically adds the account to organizational view\. When an account leaves your organization, new events from that account are no longer logged to organizational view\. However, existing events remain and you can still query them up to the 90\-day limit\.

**Important**  
AWS Health doesn't record events that occurred in your organization before you enabled organizational view\.

You can use the AWS Health API operations to return events from organizational view\.

**Example : Describe organizational view events**  
The following AWS CLI command returns health events for AWS accounts in your organization\.   

```
aws health describe-events-for-organization --region us-east-1
```

See the following section for other AWS Health API operations\.

## AWS Health organizational view API operations<a name="using-the-organizational-view-apis"></a>

You can use the following AWS Health API operations for organizational view:
+ [DescribeEventsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventsForOrganization.html) – Returns summary information about events across the organization\.
+ [DescribeAffectedAccountsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedAccountsForOrganization.html) – Returns a list of AWS accounts in the organization that are affected by the specified event\.
+ [DescribeEventDetailsForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetailsForOrganization.html) – Returns detailed information about the specified events for one or more accounts in the organization\.
+ [DescribeAffectedEntitiesForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntitiesForOrganization.html) – Returns a list of entities that have been affected by one or more events for one or more accounts in an organization\.

You can use the following operations to enable or disable AWS Health from working with Organizations: 
+ [EnableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_EnableHealthServiceAccessForOrganization.html) – Grants AWS Health permission to interact with Organizations and applies the SLR to the master account in the organization\.
+ [DisableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DisableHealthServiceAccessForOrganization.html) – Revokes permission for AWS Health to interact with Organizations\.
+ [DescribeHealthServiceStatusForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeHealthServiceStatusForOrganization.html) – Returns status information on whether AWS Health is enabled for your organization\.

You must have a Business or Enterprise support plan to call these API operations\. If you call the `DescribeEventForOrganization` and `DescribeAffectedAccountsForOrganization` operations from an account that has at least a Business support plan, you can return information about any account in the organization, regardless of the support level of the individual accounts\. See the following examples\.

**Example: An organization with accounts that have Business and Developer support plans**  
+ You have three accounts in your organization\. The master account has a Business support plan and the other two accounts have a Developer support plan\.
+ You call the `DescribeEventForOrganization` API operation from the master account or from an account that can assume the role with the required permissions\.
+ AWS Health returns information for all three accounts\.

If you call the `DescribeEventDetailsForOrganization` and `DescribeAffectedEntitiesForOrganization` API operations from an account that has at least a Business support plan, you can only return information about accounts in the organization that have a Business or Enterprise support level plan\.

**Example: An organization with accounts that have Enterprise, Business, and Developer support plans**  
+ You have five accounts in your organization\. The master account has an Enterprise support plan, two accounts have a Business support plan, and two accounts have a Developer support plan\.
+ You call the `DescribeEventDetailsForOrganization` API operation from the master account\.
+ AWS Health returns information for only the accounts that have an Enterprise or Business support plan\. The accounts that have a Developer support plan appear in the `failedSet` of the response\.

## Disabling organizational view<a name="disabling-organizational-view"></a>

You can disable organizational view by using the [DisableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DisableHealthServiceAccessForOrganization.html) API operation\.

**Example**  
The following AWS CLI command disables this feature from your account\.  

```
aws health disable-health-service-access-for-organization --region us-east-1
```

**Note**  
You can also disable the organizational feature by using the Organizations [DisableAWSServiceAccess](https://docs.aws.amazon.com/organizations/latest/APIReference/API_DisableAWSServiceAccess.html) API operation\. After you call this operation, AWS Health stops aggregating events for all other accounts in your organization\. If you call the AWS Health API operations for organizational view, AWS Health returns an error\. AWS Health continues to aggregate health events for your AWS account\.

 After you disable this feature, AWS Health no longer aggregates events from your organization\. However, the SLR remains in the master account until you delete it through the IAM console, IAM API, or AWS CLI\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.