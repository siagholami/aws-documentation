# Analyzing finding details<a name="finding-profiles"></a>

A finding is a possible instance of malicious activity or other risk that was detected by Amazon GuardDuty\. Findings are loaded into Amazon Detective so that you can use Detective to investigate them\. Detective ingests and provides profiles for a selected set of GuardDuty finding types\. See [Supported finding types](supported-finding-types.md)\.

A Detective finding profile is a single page that provides a collection of data visualizations plus supporting guidance\. Finding profiles assist with the triage and scoping phases of an investigation\.

## How to display a finding profile<a name="finding-profile-display"></a>

A finding profile appears when you perform one of the following actions:
+ For findings that are loaded into Detective, pivot to Detective from the finding details in GuardDuty or Security Hub\. 

  See [Pivoting to a finding profile from Amazon GuardDuty or AWS Security Hub](profile-pivot-from-service.md)\.
+ Navigate to the Detective URL for the finding profile\. 

  See [Navigating to a profile using a URL](profile-navigate-url.md)\.
+ Use the Detective search to look up a finding\. 

  See [Searching for a finding or entity](detective-search.md)\.
+ Choose a link to the finding profile from another entity or finding profile\.

## Scope time used for the finding profile<a name="finding-profile-scope-time"></a>

When you navigate directly to a finding profile without providing a scope time, the scope time is set to the finding time window\. The finding time window reflects the first and last time that the finding activity was observed\.

When you navigate to a finding profile from another profile, the currently selected scope time remains in place\.

All times are in UTC\.

If the current scope time does not match the finding time window, a warning is displayed\.

For information on setting the scope time, see [Managing the scope time used on finding and entity profiles](scope-time-managing.md)\. When you edit the scope time from a finding profile, you can choose to align the scope time to the finding time window\.

## Finding title and type<a name="finding-profile-id-description"></a>

At the top of the profile are the finding title and the finding type\. The icon next to the title provides a visual cue to the service that detected the finding\.

## Profile panels containing finding details and analytics results<a name="finding-profile-panels"></a>

A finding profile contains a set of one or more tabs\. Each tab contains one or more profile panels\. Each profile panel contains text and visualizations that are generated from the behavior graph data\.

The tabs and profile panels are tailored to the finding type\. The profile panels support the investigation process by providing the critical information that you need to determine how to respond the finding\.

The profile panels focus on answering specific questions that an analyst might want to ask when investigating the finding\. For example, a finding might involve an AWS role or an IP address\. The finding profile panels then highlight the AWS role or IP address activity that contributed to the finding\. Each profile panel provides access to guidance on how to use the information\. For more information, see [Using profile panel guidance during an investigation](profile-panel-guidance.md)\. 

For the involved entity, the profile displays a list of all of the findings that the entity was involved in around the scope time\. See [Viewing a list of findings that involve an entity](profile-panel-finding-list.md)\.

For more details about profile panels, the types of data they contain, and available options for interacting with them, see [Viewing and interacting with profile panels](profile-panels.md)\.