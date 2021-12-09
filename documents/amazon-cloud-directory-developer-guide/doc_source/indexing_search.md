# Indexing and Search<a name="indexing_search"></a>

Amazon Cloud Directory supports two methods of indexing: Value based and type based\. Value\-based indexing is the most common form\. With it you can index and search for objects in the directory based on the values of object attributes\. With type\-based indexing, you can index and search for objects in the directory based on object types\. Facets help define object types\. For more information about schemas and facets, see [Schemas](schemas.md) and [Facets](schemas_whatarefacets.md)\.

Indexes in Cloud Directory enable simple listing of other objects by those objects' attribute or facet values\. Each index is defined at creation to work with a specific named attribute or facet\. For example, an index may be defined on the “email” attribute of the “Person” facet\. Indexes are first\-class objects, which means that clients can create, modify, list, and delete them flexibly according to the application logic’s needs\.

Conceptually, indexes are similar to nodes with children, where the links to the indexed nodes are labeled according to the indexed attributes, rather than being given a label when the child is attached\. However, index links are not parent\-child edges, and have their own set of enumeration API operations\.

It’s important to understand that indexes in Cloud Directory are not automatically populated as they might be in other systems\. Instead, you use API calls to directly attach and detach objects to or from the index\. Although this is a bit more work, it gives you flexibility to define varying index scopes\. For example, you can define an index that tracks only direct children of a specific node\. Or you can define an index that tracks all objects in a given branch under a local root, such as all nodes in a department\. You can also do both at the same time\.

**Topics**
+ [Index Lifecycle](indexing_search_lifecycle.md)
+ [Facet\-Based Indexing](indexing_search_facet.md)
+ [Unique vs Nonunique Indexes](indexing_search_unique.md)