# Troubleshooting AWS Migration Hub<a name="troubleshooting"></a>

Following, you can find information on how to troubleshoot issues for AWS Migration Hub\.

**Topics**
+ [My Migrations Do Not Appear in Migration Hub](#migs-do-not-appear-in-hub)
+ [Updates About My Migrations Don't Appear Inside an Application](#migs-do-not-appear-in-app)
+ [My API Call Failed](#api-call-failed-status)
+ [Errors Enabling Data Collection](#data-collection-errors)

## My Migrations Do Not Appear in Migration Hub<a name="migs-do-not-appear-in-hub"></a>

If you are not seeing your applications' migration status updates on the **Updates** page in Migration Hub, it could be due to one of the following reasons:
+ You have not selected a home region or you are not currently viewing the home region console\.
+ Migration tools are not authorized to communicate with Migration Hub\.
+ You do not have the necessary policies and roles set up in IAM\.
+ Migration status mapping is incorrect or needs to be done manually\.

### Authentication<a name="authentication-ts"></a>

To make sure authentication is occurring correctly:
+ Check whether the migration tools you are using have been authorized to communicate with Migration Hub\. For more information, see [steps to authorize a migration tool](migrate-wt-migrate.md#migrate-wt-migrate-using-tools)\.
+ Check the [Tools page](http://console.aws.amazon.com/migrationhub/migrate/tools) to see the status of connected tools\. Learn more about setting up necessary policies and roles in [Required Managed Policies](new-customer-setup.md#required-managed-policies)\.

### Migration Status Matching When Using AWS Discovery Tools<a name="matching"></a>
+ Check whether a migration update must be manually mapped or was incorrectly mapped to a discovered serve\., See [Tracking Migration Updates](doing-more.md#updates-tracking-wt)\.

## Updates About My Migrations Don't Appear Inside an Application<a name="migs-do-not-appear-in-app"></a>

If you are not seeing your migration updates associated with an application, it could be due to one of the following reasons:
+ Servers not being grouped as an application\.
+ Migration update status not being refreshed\.
+ Migration updates are not mapped or are incorrectly mapped to a server\.

### Servers' Application Grouping<a name="group-as-apps"></a>
+ Check whether all your servers have been grouped into an application\. See [steps to group servers into applications](migrate-wt-migrate.md#migrate-wt-group-as-applications)\.

### Update Status<a name="update-status"></a>
+ The application details page requires you to refresh the page in order to see the latest status\. See [steps to track status of migrations](migrate-wt-track.md#migrate-wt-track-app-status)\.

### Update and Server Mapping<a name="update-mapping"></a>
+ Check whether the update is present on **Updates** page\.
+ If not on the **Updates** page, then check whether the migration tool was authorized by looking on the **Migration Tools** page \- in the navigation pane, under **Migrate**, choose **Tools**\.
+ On the **Updates** page, verify that the update is mapped to the correct server \(it will show "Edit" in "Mapped servers" column\)\.
+ If mapped to a server on the **Updates** page, then verify whether the server is grouped into an application on the **Servers** page with an application name present in the "Applications" column\.

## My API Call Failed<a name="api-call-failed-status"></a>
+ Check whether you called `GetHomeRegion` before your call, if required\.
+ You can use the AWS Migration Hub home region APIs within your home region only\. API calls originating from outside your home region are rejected, except for the ability to register your agents and connectors\.

## Errors Enabling Data Collection<a name="data-collection-errors"></a>

Although you can register discovery agents and connectors outside of your AWS Migration Hub home region, you cannot start data collection outside the home region\. The Application Discovery Service `StartDataCollection` API call prevents you from enabling data collection outside the home region\. 