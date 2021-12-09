# Links<a name="directory_objects_links"></a>

A link is a directed edge between two objects that define a relationship\. Cloud Directory currently supports the following link types\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/clouddirectory/latest/developerguide/images/objectlinks.png)

## Child Links<a name="directory_objects_links_childlinks"></a>

A child link creates a parent–child relationship between the objects it connects\. For example, in the above illustration child link **b** connects objects `001` and `003`\. Child links define the hierarchy in Cloud Directory\. Child links have names when they participate in defining the path of the object that the link points to\.

## Attachment Links<a name="directory_objects_links_attachmentlinks"></a>

An attachment link applies a leaf node policy object to another leaf node or a node object\. Attachment links do not define the hierarchical structure of Cloud Directory\. For example, in the above illustration, attachment link applies the policy stored in policy leaf node object `006` on node object `002` \. Each object can have multiple policies attached but not more than one policy of any given policy type can be attached\.

## Index Links<a name="directory_objects_links_indexlinks"></a>

Index links provide rich information lookup based on an index object and your defined indexed attributes, thus enabling fast tree traversals and searches within the directory trees\. Conceptually, indexes are similar to nodes with children: The links to the indexed nodes are labeled according to the indexed attributes, rather than being given a label when the child is attached\. However, index links are not parent\-child edges, and have their own set of enumeration API operations\. For more information, see [Indexing and Search](indexing_search.md)\.

## Typed Links<a name="directory_objects_links_typedlink"></a>

Typed Links enable you to establish a relationship between objects within or across hierarchies in Cloud Directory\. You can then use these relationships to query for information, such as *Which users have device ‘xyz’* or *What devices are owned by user ‘abc’*\.

 You can use typed links to model relationships between different objects in your directory\. For example, in the illustration above, consider the relationship between object `004`, which represents a user, and object `005`, which represents a device\. 

We might use a typed link to model an ownership relationship between the two objects\. We could add attributes to the typed link to represent the cost of a purchase, whether the device is rented or purchased\. There are two types of attributes associated with typed links:
+  **Identity\-based attributes – ** An attribute of a typed link that distinguishes it from other links \(For example, Child, Attachment, Index links\)\. Each typed link facet defines an ordered set of identity attributes\. The identity of a typed link is the source object id, a facet identifier \(type\), the values of its identity attributes \(defined by its facet\), and the target object id\. Identifiers must be unique within a single directory\.
+  **Optional attributes \-** An attribute that stores tracking characteristics about the typed link that are unrelated to the identity of the link\. For example, an optional attribute might identify the date the typed link was first established or when it was last modified\.

As with objects, you must create a typed link facet using the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateTypedLinkFacet.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateTypedLinkFacet.html) API to define the typed link structure and its attributes\. Typed link facets require a unique facet name and set of attributes that are associated with the link\. When designing your typed link structure, you can define an ordered set of attributes on the typed link facet\. To view a typed links sample schema, see [Schema Document with Typed Links](schemas_jsonformat.md#schemas_schematyped)\.

Typed link attributes can be used when you need to do any of the following:
+ Allow for filtering of incoming or outgoing typed links\. For more information, see [Typed Link Listing](#directory_objects_links_typedlinklisting)\.
+ Represent the relationship between two objects\.
+ Track administrative data about your typed link, such as the date the link was created\.

Consider the following when deciding if typed links are right for your use case: 
+ Typed links cannot be used in path\-based object specification\. Instead, you must select typed links using the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html) or [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIncomingTypedLinks.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIncomingTypedLinks.html) API operations\.
+ Typed links do not participate in [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_LookupPolicy.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_LookupPolicy.html) or [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListObjectParentPaths.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListObjectParentPaths.html) API operations\. 
+ Typed links between the same two objects and in the same direction may not have the same attribute values\. This can help avoid duplicated typed links between the same objects\.
+ Additional attributes can be used when you want to add optional information\.
+ The combined size of all identity attribute values is limited to 64 bytes\. For more information, see [Amazon Cloud Directory Limits](limits.md)\.

**Related Cloud Directory Blog Article**
+ [Use Amazon Cloud Directory Typed Links to Create and Search Relationships Across Hierarchies](https://aws.amazon.com/blogs/security/new-use-amazon-cloud-directory-typed-links-to-create-and-manage-relationships-in-your-directory/)

### Typed Link Identity<a name="directory_objects_links_typedlinkid"></a>

Identity is what uniquely defines whether a typed link can exist between two objects\. The exception is when you connect two objects in one direction with the exact same attribute values\. Attributes must be configured as `REQUIRED_ALWAYS`\.

Typed links that are created from different typed link facets never conflict with each other\. For example, consider the following diagram:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/clouddirectory/latest/developerguide/images/typedlinks.png)
+ Object `001` has typed links and attributes \(A1 and A2\) with the same attribute values \(x1 and x2\) going to different objects \(`002` and `003`\)\. This operation would succeed\.
+ Objects `002` and `003` have a typed link between them\. This operation would fail because two typed links in the same direction with the same attributes cannot exist between objects\.
+ Objects `001` and `003` have two typed links between them with the same attributes\. However, since the links go in different directions, this operation would succeed\.
+ Objects `002` and `003` have typed links between them with the same value for A1 but different values for A2\. Typed link identity considers all attributes so this operation would succeed\.

### Typed Link Rules<a name="directory_objects_links_typedlinkrules"></a>

You can add rules to typed link attributes when you want to add restrictions to link attributes\. These rules are equivalent to rules on object attributes\. For more information, see [Attribute Rules](schemas_attributerules.md)\.

### Typed Link Listing<a name="directory_objects_links_typedlinklisting"></a>

Cloud Directory provides API operations that you can use to select incoming or outgoing typed links from an object\. You can select a specific subset of typed links rather than iterating over every typed link\. You can also specify a particular typed link facet to filter only typed links of that type\.

You can filter typed links based on the order that the attributes are defined on the typed link facet\. You can provide range filters for multiple attributes\. When providing ranges to a typed link selection, any inexact ranges much be specified at the end\. Any attributes with no range specified are presumed to match the entire range\. Filters are interpreted in the order of the attributes that are defined on the typed link facet, not the order they are supplied to any API calls\.

For example, in the following diagram, consider a Cloud Directory that is used to store information about Employees and their Abilities\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/clouddirectory/latest/developerguide/images/typedlinklisting.png)

Let’s say we model our employee’s capabilities with a typed link named `EmployeeCapability`, which is configured with three string attributes: `Status`, `Role` and `Created`\. The following filters are supported on [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIncomingTypedLinks.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIncomingTypedLinks.html) and [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html) API operations\.
+ Facet = `EmployeeCapability`, Status = `Active`, Role = `Driver`
  + Selects active employees who are drivers\. This filter includes two exact matches\.
+ Facet = `EmployeeCapability`, Status = `Active`, Role = `Driver`, Created = `05/31/18`
  + Selects active employees who are drivers and who's facets were created on or after May 31st, 2018\.
+ Facet = `EmployeeCapability`, Status = `Active`
  + Selects all active employees\.
+ Facet = `EmployeeCapability`, Status = `Active`, Role = `A` to `M`
  + Selects active employees with roles starting with `A` through `M`\.
+ Facet = `EmployeeCapability`
  + This selects all typed links of the `EmployeeCapability` type\.

The following filters would **NOT** be supported:
+ Facet = `EmployeeCapability`, Status between `A` to `C`, Role = `Driver`
  + This filter is not allowed because any ranges must appear at the end of the filter\.
+ Facet = `EmployeeCapability`, Role = `Driver`
  + This filter is not allowed because the implicit status range is not an exact match and does not appear at the end of the list of ranges\.
+ Status = `Active`
  + This filter is not allowed because the typed link facet is not specified\.

### Typed Link Schema<a name="directory_objects_links_typedlinkschema"></a>

You can create typed link facets in two ways\. You can manage your typed link facets from individual API calls, including [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateTypedLinkFacet.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateTypedLinkFacet.html), [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DeleteTypedLinkFacet.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DeleteTypedLinkFacet.html), and [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpdateTypedLinkFacet.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpdateTypedLinkFacet.html)\. You can also upload a JSON document that represents your schema in a single [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_PutSchemaFromJson.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_PutSchemaFromJson.html) API call\. For more information, see [JSON Schema Format](schemas_jsonformat.md#schemas_json)\. To view a typed links sample schema, see [Schema Document with Typed Links](schemas_jsonformat.md#schemas_schematyped)\.

The types of changes allowed at different phases of the schema development lifecycle are similar to changes that are allowed for object facet manipulation\. Schemas in the development state support any changes\. Schemas in the published state are immutable and no changes are supported\. Only certain changes are allowed to schemas that are applied to a data directory\. Once you set the order and attributes on an applied typed link facet, that order cannot be changed\.

Two other API operations list facets and their attributes:
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListTypedLinkFacetAttributes.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListTypedLinkFacetAttributes.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListTypedLinkFacetNames.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListTypedLinkFacetNames.html)

### Typed Link Interaction<a name="directory_objects_links_typedlinkinteraction"></a>

Once a typed link facet has been created, you are ready to start creating and interacting with typed links\. To attach and detach typed links, use the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_AttachTypedLink.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_AttachTypedLink.html) and [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DetachTypedLink.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DetachTypedLink.html) API operations\.

The `TypedLinkSpecifier` is a structure that contains all the information to uniquely identify a typed link\. Within that structure you can find `TypedLinkFacet`, `SourceObjectID`, `DestinationObjectID`, and `IdentityAttributeValues`\. These are used to uniquely specify the typed link being operated on\. The [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_AttachTypedLink.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_AttachTypedLink.html) API operation returns a typed link specifier while the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DetachTypedLink.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DetachTypedLink.html) API operation accepts one as input\. Similarly, the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIncomingTypedLinks.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIncomingTypedLinks.html) and [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html) API operations provide typed link specifiers as output\. You can construct a typed link specifier from scratch as well\. The full list of typed link\-related API operations, include the following:
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_AttachTypedLink.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_AttachTypedLink.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateTypedLinkFacet.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateTypedLinkFacet.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DeleteTypedLinkFacet.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DeleteTypedLinkFacet.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DetachTypedLink.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DetachTypedLink.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_GetLinkAttributes.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_GetLinkAttributes.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_GetTypedLinkFacetInformation.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_GetTypedLinkFacetInformation.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIncomingTypedLinks.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIncomingTypedLinks.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListTypedLinkFacetNames.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListTypedLinkFacetNames.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListTypedLinkFacetAttributes.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListTypedLinkFacetAttributes.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpdateLinkAttributes.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpdateLinkAttributes.html)
+ [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpdateTypedLinkFacet.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpdateTypedLinkFacet.html)

**Note**  
Attribute references and updating typed links are not supported\. To update a typed link, you must remove it and add the updated version\. 