# Facet\-Based Indexing<a name="indexing_search_facet"></a>

With facet\-based indexing and search, you can optimize your directory searches by searching only a subset of your directory\. To do this, you use a schema *facet*\. For example, instead of searching across all the user objects in your directory, you can search only the user objects that contain an employee facet\. This efficiency helps reduce the latency time and amount of data retrieved for the query\. 

With facet\-based indexing, you can use the Cloud Directory index API operations to create and attach an index to the facets of objects\. You can also list the index results and then filter those results based on certain facets\. This can effectively reduce query times and the amount of data by narrowing the search scope to only objects that contain a certain type of facet\.

The `“facets”` attribute that is used with the `[CreateIndex](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateIndex.html)` and `[ListIndex](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIndex.html)` API calls surfaces the collection of facets that are applied to an object\. This attribute is available for use only with the `CreateIndex` and `ListIndex` API calls\. As shown in the following sample code, the schema ARN uses the directory’s region, owner account, and directory ID to reference the Cloud Directory schema\. This service\-provided schema does not appear in listings\.

```
String cloudDirectorySchemaArn = String.format(“arn:aws:clouddirectory:%s:%s:directory/%s/schema/CloudDirectory/1.0", region, ownerAccount, directoryId);
```

For example, the following sample code creates a facet\-based index specific to your AWS account and directory where you could enumerate all objects that are created with the facet `SalesDepartmentFacet`\. 

**Note**  
Make sure to use the “facets” value within the parameters as shown below\. Instances of “facets” shown in the sample code refer to a value that is provided and controlled by the Cloud Directory service\. You can use these for indexing but can have read\-only access\.

```
// Create a facet-based index
String cloudDirectorySchemaArn = String.format(“arn:aws:clouddirectory:%s:%s:directory/%s/schema/CloudDirectory/1.0",
    region, ownerAccount, directoryId);

facetIndexResult = clouddirectoryClient.createIndex(new CreateIndexRequest() 
  .withDirectoryArn(directoryArn) 
  .withOrderedIndexedAttributeList(List(new AttributeKey()     
        .withSchemaArn(cloudDirectorySchemaArn)     
        .withFacetName("facets")     
        .withName("facets"))) 
        .withIsUnique(false) 
        .withParentReference("/") 
        .withLinkName("MyFirstFacetIndex"))
facetIndex = facetIndexResult.getObjectIdentifier()

// Attach objects to the facet-based index
clouddirectoryClient.attachToIndex(new AttachToIndexRequest().withDirectoryArn(directoryArn)
  .withIndexReference(facetIndex).withTargetReference(userObj))

// List all objects
val listResults = clouddirectoryClient.listIndex(new ListIndexRequest()
  .withDirectoryArn(directoryArn)
  .withIndexReference(facetIndex)
  .getIndexAttachments()

// List the index results filtering for a certain facet
val filteredResults = clouddirectoryClient.listIndex(new ListIndexRequest()
  .withDirectoryArn(directoryArn)
  .withIndexReference(facetIndex)
  .withRangesOnIndexedValues(new ObjectAttributeRange()
    .withAttributeKey(new AttributeKey()
      .withFacetName("facets")
      .withName("facets")
      .withSchemaArn(cloudDirectorySchemaArn))
    .withRange(new TypedAttributeValueRange()
      .withStartMode(RangeMode.INCLUSIVE)
      .withStartValue("MySchema/1.0/SalesDepartmentFacet")
      .withEndMode(RangeMode.INCLUSIVE)
      .withEndValue("MySchema/1.0/SalesDepartmentFacet")
    )))
```