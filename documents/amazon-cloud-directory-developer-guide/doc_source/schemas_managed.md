# Managed Schema<a name="schemas_managed"></a>

Cloud Directory makes it easy for you to rapidly develop applications by using a managed schema\. With a managed schema, you can create a directory and start creating and retrieving objects from it at a faster pace\. For more information, see [Create Your Directory](how_to_manage_directory_create.md)\.

Currently, there is one managed schema, called the `QuickStartSchema`\. You can build a rich hierarchical data model and establish relationships across objects by using constructs such as [Typed Links](directory_objects_links.md#directory_objects_links_typedlink)\. You can then query for any information in your data by traversing the hierarchy\. 

The `QuickStartSchema` managed schema is represented by the following JSON: 

```
QuickStartSchema: {
    "facets": {
        "DynamicObjectFacet": {
            "facetStyle": "DYNAMIC"
        },
        "DynamicTypedLinkFacet": {
            "facetAttributes": {
                "DynamicTypedLinkAttribute": {
                    "attributeDefinition": {
                        "attributeRules": {},
                        "attributeType": "VARIANT",
                        "isImmutable": false
                    },
                    "requiredBehavior": "REQUIRED_ALWAYS"
                }
            },
            "identityAttributeOrder": [
                "DynamicAttribute"
            ]
        }
    }
}
```

**QuickStartSchema ARN**

The `QuickStartSchema` managed schema uses the following ARN:

```
String QUICK_START_SCHEMA_ARN = "arn:aws:clouddirectory:::schema/managed/quick_start/1.0/001" ;
```

For example, you could use this ARN to create a directory called `ExampleDirectory` as shown below:

```
CreateDirectoryRequest createDirectoryRequest = new CreateDirectoryRequest()
    .withName("ExampleDirectory") // Directory name
    .withSchemaArn(QUICK_START_SCHEMA_ARN);
```

## Facet Styles<a name="schemas_managed_facet_styles"></a>

There are two different styles that you can define on any given facet, `Static` and `Dynamic`\.

### Static Facets<a name="schemas_managed_static_facets"></a>

Static facets are the best choice when you have all the details of your data model for your directory, such as a list of attributes with their data types, and you also want to define constraints for your attributes such as mandatory or unique fields\. Cloud Directory will enforce the data constraints and rule checking during your object creation or change\.

### Dynamic Facets<a name="schemas_managed_dynamic_facets"></a>

You can use a dynamic facet when you need flexibility to change the number of attributes or change the data values being stored within your attributes\. Cloud Directory does not enforce any data constraints and rule checking during your object creation or change\.

After creating a schema with dynamic facets, you can define any attributes that you need while creating objects\. Cloud Directory will accept the attributes as key\-value pairs and store them on their provided objects\.

You can add a dynamic facet to a new or existing schema\. You can also combine the static and dynamic facets within a single schema to get benefits for each style of facet within your directory\.

When you create any attribute using Dynamic facet, they are created as `Variant` data type\. To store values for the attribute defined as a `Variant` data type, you can use values of any of the primitive data types supported in Cloud Directory, such as `String` or `Binary`\. Over time, you can also change the value of the attribute to another datatype\. There is no enforcement of data validation\.

You can use dynamic facets to define objects of the following type:
+ `NODE`
+ `LEAF_NODE`
+ `POLICY`

For additional details about managed schemas, dynamic facets or variant data types and to see example use cases, see [How to rapidly develop applications on Amazon Cloud Directory using AWS Managed Schema](https://aws.amazon.com/blogs/database/rapidly-develop-applications-on-amazon-cloud-directory-with-managed-schema/) in the Amazon Cloud Directory blog\.