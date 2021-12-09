# Viewing a list of findings that involve an entity<a name="profile-panel-finding-list"></a>

One indication that an entity has been compromised is its involvement in multiple findings\.

Each finding and entity profile contains an associated findings profile panel\. This profile panel is only populated if you have Amazon GuardDuty enabled\. It also only includes findings that are supported by Detective\. For the list of supported finding types, see [Supported finding types](supported-finding-types.md)\.

For an entity profile, the panel lists findings that involved that entity\.

For a finding profile, the panel lists findings for that finding's involved entity\. For example, if a finding involves an AWS role, the associated findings contains a list of findings that involve that role\. The list includes the finding from the profile\.

The listed findings were observed during the current scope time plus additional peripheral time\. This is the same time window that is displayed on timeline profile panels\.

For each finding, the list includes the following information:
+ The finding title, which is also a link to the finding profile
+ The finding type
+ The earliest time that the finding was observed
+ The most recent time that the finding was observed
+ The finding severity