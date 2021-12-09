# Limitations for Embedded Dashboards in Amazon QuickSight<a name="embedded-dashboards-limitations"></a>

This section provides information regarding limitations and other things you should be aware of when using embedded dashboards\. 
+ Authentication by AD connector is not currently supported\. We encourage users of Active Directory to use reader roles to provide data analysis capabilities\. 
+ The users can't access two embedded dashboards from different Amazon QuickSight accounts within the same browser session\. The user can only be signed in to one account 
+ Users who are signed in to AWS console can encounter an error when opening an embedded dashboard in Amazon QuickSight with a different user account\. 
+ Currently, users of the hosting app have access to the AWS console with limited permissions\.
+ You can't access the full Amazon QuickSight app from the embedded dashboard\. Instead, access Amazon QuickSight separately using the authentication method you normally use to access the dashboard\. 
+ If the underlying dashboard is deleted, users see an Amazon QuickSight error page\. 