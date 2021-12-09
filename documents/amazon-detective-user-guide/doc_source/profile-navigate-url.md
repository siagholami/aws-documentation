# Navigating to a profile using a URL<a name="profile-navigate-url"></a>

To navigate to a finding or entity profile in Amazon Detective, you can use a URL that provides a direct link to it\. The URL identifies the finding or entity\. It can also specify the scope time to use on the profile\.

## Format of a profile URL<a name="profile-url-format"></a>

The format of the URL is as follows:

https://console\.aws\.amazon\.com/detective/home?region=*Region*\#*type*/*namespace*/*instanceID*?*parameters*

The URL requires the following values\.

***Region***  
The Region that you want to use\.

***type***  
The type of item for the profile that you are navigating to\.  
+ `findings` \- Indicates that you are navigating to a finding profile
+ `entities` \- Indicates that you are navigating to an entity profile

***namespace***  
Used to identify the type of finding or entity\.  
For findings, the namespace identifies the finding provider\. For example, for Amazon GuardDuty findings, the namespace is `GuardDuty`\.  
For entities, the namespace is the name of the entity type\.  
+ `AwsAccount`
+ `AwsRole`
+ `AwsRoleSession`
+ `AwsUser`
+ `Ec2Instance`
+ `FederatedUser`
+ `IpAddress`
+ `UserAgent`

***instanceID***  
The instance identifier of the finding or entity\.  
+ For a GuardDuty finding, the GuardDuty finding identifier\.
+ For an AWS account, the account ID\.
+ For AWS roles and users, the principal ID of the role or of the user\.
+ For federated users, the principal ID of the federated user\. The principal ID is either `<identityProvider>:<username>` or `<identityProvider>:<audience>:<username>`\.
+ For IP addresses, the IP address\.
+ For user agents, the user agent name\.
+ For role sessions, the session identifier\. The session identifier uses the format` <rolePrincipalID>:<sessionName>`\.
The finding or entity must be associated with an enabled account in your behavior graph\.

The URL can also include the following optional parameters, which are used to set the scope time\. For more information about scope time and how it is used on profiles, see [Managing the scope time used on finding and entity profiles](scope-time-managing.md)\.

**`scopeStart`**  
Start time for the scope time to use on the profile\.  
The value is the epoch timestamp\.  
If you provide a start time but no end time, then the scope time ends at the current time\.

**`scopeEnd`**  
End time for the scope time to use on the profile\.  
The value is the epoch timestamp\.  
If you provide an end time, but no start time, then the scope time includes all time before the end time\.

If you don't specify the scope time, then the default scope time is used\.
+ For findings, the default scope time uses the first and last times that the finding activity was observed\.
+ For entities, the default scope time is the previous 24 hours\.

Here is an example of a Detective URL:

`https://console.aws.amazon.com/detective/home?region=us-east-1#entities/IpAddress/192.168.1.1?scopeStart=1552867200&scopeEnd=1552910400`

This example URL provides the following instructions\.
+ Display the entity profile for the IP address 192\.168\.1\.
+ Use a scope time that starts Monday, March 18, 2019 12:00:00 AM GMT and that ends Monday, March 18, 2019 12:00:00 PM GMT\.

## Troubleshooting a URL<a name="profile-url-troubleshooting"></a>

If the URL does not display the expected profile, first check that the URL uses the correct format and that you have provided the correct values\.
+ Did you specify the correct type \(`findings` or `entities`\)? 
+ Did you specify the correct namespace?
+ Did you provide the correct identifier?

If the values are correct, then you can also check the following\.
+ **Does the finding or entity belong to an enabled member account in your behavior graph?** If the associated account was not invited to the behavior graph as a member account, then the behavior graph does not contain data for that account\.

  If an invited member account did not accept the invitation, then the behavior graph does not contain data for that account\.
+ **For a finding, does Detective support that finding type?** If the finding type is not one of the types listed in [Supported finding types](supported-finding-types.md), then the behavior graph does not contain data for it\.
+ **For a finding, is the finding archived?** Detective does not receive archived findings from Amazon GuardDuty\.
+ **Did the finding or entity occur before Detective began to ingest data into your behavior graph?** If the finding or entity is not present in the data that Detective ingests, then the behavior graph does not contain data for it\.
+ **Is the finding or entity from the correct Region?** Each behavior graph is specific to a Region\. A behavior graph does not contain data from other Regions\.