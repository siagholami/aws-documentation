# In\-Place Schema Upgrade<a name="schemas_inplaceschemaupgrade"></a>

Cloud Directory offers the updating of existing schema attributes and facets to help integrate your applications with AWS provided services\. Schemas that are in either the published or applied states have versions and cannot be changed\. For more information, see [Schema Lifecycle](schemas_lifecycle.md)\. 

## Schema Versioning<a name="schemas_cdschemaversion"></a>

A schema version indicates a unique identifier for a schema that developers can specify when programming their applications to conform to certain rules and formatting of data\. Two key differentiators in the way versioning works with Cloud Directory are important for developers to understand\. These differentiators—major version and minor version—can determine how future schema upgrades impact your application\.

### Major Version<a name="schemas_majorversion"></a>

*Major version* is the version identifier used for tracking major version changes for a schema\. It can be up to 10 characters in length\. Different versions of the same schema are completely independent\. For example, two schemas with the same name and different versions are treated as completely different schemas, which have their own namespaces\. 

**Backward incompatible changes**

We recommend making changes to the major version only when schemas are incompatible\. For example, when changing the data type of an existing attribute \(such as changing from `string` to `integer`\) or dropping a mandatory attribute from your schema\. Backward\-incompatible changes require directory data migration from a previous schema version to the new schema version\.

### Minor Version<a name="schemas_minorversion"></a>

*Minor version* is the version identifier used for in\-place upgrading of schemas or when you want to make backward\-compatible upgrades such as adding additional attributes or adding facets\. An upgraded schema using a minor version can be applied in place across all directories that use it without breaking any running applications\. This includes directories that are used in production environments\. For an example use case, see [“How to Easily Apply Amazon Cloud Directory Schema Changes with In\-Place Schema Upgrades”](https://aws.amazon.com/blogs/security/how-to-easily-apply-amazon-cloud-directory-schema-changes-with-in-place-schema-upgrades/) in the Cloud Directory Blog\.

The minor version information and history is saved along with the other schema information in the schema metadata repository\. No minor version information is retained in the objects\. The advantage of introducing minor version is that client code works seamlessly as long as the major version is not changed\.

**Minor Version Limits**

Cloud Directory retains and therefore limits up to five minor versions\. However, minor version limits are enforced differently for published and applied schemas in the following ways:
+ **Applied schemas:** Once the minor version limit has been exceeded, Cloud Directory deletes the oldest minor version automatically\.
+ **Published schemas:** Once the minor version limit has been exceeded, Cloud Directory does not delete any of the minor versions but it does inform the user via a `LimitExceededException` that the limit has been exceeded\. Once you exceed the minor version limits, you can either delete the schema by using the [DeleteSchema](https://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DeleteSchema.html) API or request a limit raise\.

## Using the Schema Upgrade API Operations<a name="schemas_usingschemaupgradeapis"></a>

You can use the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpgradePublishedSchema.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpgradePublishedSchema.html) API call to upgrade published schemas\. Schema upgrades are applied in place to the directories that rely on it using the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpgradeAppliedSchema.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_UpgradeAppliedSchema.html) API call\. You can also fetch the major and minor version of an applied schema by calling [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_GetAppliedSchemaVersion.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_GetAppliedSchemaVersion.html)s\. Or view the associated schema ARNs and schema revision history for a directory by calling [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListAppliedSchemaArns.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListAppliedSchemaArns.html)\. Cloud Directory maintains the five most recent versions of applied schema changes\. 

For an illustrative example, see [“How to Easily Apply Amazon Cloud Directory Schema Changes with In\-Place Schema Upgrades”](https://aws.amazon.com/blogs/security/how-to-easily-apply-amazon-cloud-directory-schema-changes-with-in-place-schema-upgrades/) in the Cloud Directory Blog\. The blog post will demonstrate how you perform an in\-place schema upgrade and use schema versions in Cloud Directory\. It covers how to add additional attributes to an existing facet, add a new facet to a schema, publish the new schema, and apply it to running directories to complete the upgrading of a schema in\-place\. It also shows how to view the version history of a directory schema, which helps to ensure the directory fleet is running the same version of the schema and has the correct history of schema changes applied to it\.