# Analyzing entity details<a name="entity-profiles"></a>

An entity is a single object extracted from the source data\. Examples include a specific IP address, Amazon EC2 instance, or AWS account\. For a list of entity types, see [Types of entities in the behavior graph data structure](graph-data-structure-overview.md#entity-types)\.

An Amazon Detective entity profile is a single page that provides detailed information about the entity and its activity\. You might use an entity profile to get supporting details for an investigation into a finding or as part of a general hunt for suspicious activity\.

## How to display an entity profile<a name="entity-profiles-display"></a>

An entity profile appears when you perform one of the following actions:
+ Go to the Detective URL for the entity profile\.

  See [Navigating to a profile using a URL](profile-navigate-url.md)\.
+ Use the Detective search to look up an entity\.

  See [Searching for a finding or entity](detective-search.md)\.
+ Choose a link to the entity profile from another entity or finding profile\.

## Scope time for an entity profile<a name="entity-profile-scope-time"></a>

When you navigate directly to an entity profile without providing the scope time, the scope time is set to the previous 24 hours\.

When you navigate to an entity profile from another profile, the currently selected scope time remains in place\.

All times are displayed in UTC\.

For information on setting the scope time, see [Managing the scope time used on finding and entity profiles](scope-time-managing.md)\.

## Entity identifier and type<a name="entity-identifier-type"></a>

At the top of the profile are the entity identifier and the entity type\. Each entity type has a corresponding icon, to provide a visual indicator of the type of profile\.

## Profile panels containing entity details and analytics results<a name="entity-profile-panels"></a>

Each entity profile contains a set of one or more tabs\. Each tab contains one or more profile panels\. Each profile panel contains text and visualizations that are generated from the behavior graph data\. The specific tabs and profile panels are tailored to the entity type\.

For most entities, the panel at the top of the first tab provides high\-level summary information about the entity\.

Each profile also contains a panel that lists the findings that the entity was involved in around the scope time\. See [Viewing a list of findings that involve an entity](profile-panel-finding-list.md)\.

Other profile panels highlight different types of activity\. For an entity that is involved with a finding, the information on the entity profile panels can provide additional supporting evidence to help complete an investigation\. Each profile panel provides access to guidance on how to use the information\. For more information, see [Using profile panel guidance during an investigation](profile-panel-guidance.md)\. 

For more details about profile panels, the types of data they contain, and available options for interacting with them, see [Viewing and interacting with profile panels](profile-panels.md)\.