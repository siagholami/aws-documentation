# Directory Objects<a name="directory_objects"></a>

Developers model directory objects using extensible schemas to enforce data correctness constraints automatically, making it easier to program for\. Amazon Cloud Directory offers rich information lookup based on your defined indexed attributes, thus enabling fast tree traversals and searches within the directory trees\. Cloud Directory data is encrypted at rest and in transit\. 

An object is a basic element of Cloud Directory\. Each object has a globally unique identifier, which is specified by the object Identifier\. An object is a collection of zero or more facets with their attribute keys and values\. An object can be created from one or more facets within a single applied schema or from facets of multiple applied schemas\. During object creation, you must specify all required attribute values\. Objects can have a limited number of facets\. For more information, see [Amazon Cloud Directory Limits](limits.md)\.

An object can be a regular object, a policy object, or an index object\. An object can also be a node object or a leaf node object\. The type of the object is inferred from the object type of the facets attached to it\.

**Topics**
+ [Links](directory_objects_links.md)
+ [Range Filters](directory_objects_range_filters.md)
+ [Access Objects](directory_objects_access_objects.md)
+ [Consistency Levels](directory_objects_consistency_levels.md)