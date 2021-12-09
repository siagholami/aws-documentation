# Create Your Directory<a name="how_to_manage_directory_create"></a>

Before you can create a directory in Amazon Cloud Directory, AWS Directory Service requires that you first apply a schema to it\. A directory cannot be created without a schema and typically has one schema applied to it\. However, you use Cloud Directory API operations to apply additional schemas to a directory\. For more information, see [ApplySchema](http://docs.aws.amazon.com/amazoncds/latest/APIReference/API_ApplySchema.html) in the *Amazon Cloud Directory API Reference Guide*\.

**To create a Cloud Directory**

1. In the [AWS Directory Service console](https://console.aws.amazon.com/directoryservicev2/) navigation pane, under **Cloud Directory**, choose **Directories**\.

1. Choose **Set up Cloud Directory**\.

1. Under **Choose a schema to apply to your new directory**, type the friendly name of your directory, such as `User Repository`, and then choose one of the following options:
   + **Managed schema**
   + **Sample schema**
   + **Custom schema**

   Sample schemas and custom schemas are placed in the **Development** state, by default\. For more information about schema states, see [Schema Lifecycle](schemas_lifecycle.md)\. Before a schema can be applied to a directory, it must be converted into the **Published** state\. To successfully publish a sample schema using the console, you must have permissions to the following actions:
   +  `clouddirectory:Get*`
   +  `clouddirectory:List*`
   +  `clouddirectory:CreateSchema`
   +  `clouddirectory:CreateDirectory`
   +  `clouddirectory:PutSchemaFromJson`
   +  `clouddirectory:PublishSchema`
   +  `clouddirectory:DeleteSchema`

   Since sample schemas are read\-only templates provided by AWS, they cannot be published directly\. Instead, when you choose to create a directory based on a sample schema, the console creates a temporary copy of the sample schema you selected and places it in the **Development** state\. It then creates a copy of that development schema and places it in the **Published** state\. Once published, the development schema is deleted, which is why the `DeleteSchema` action is necessary when publishing a sample schema\.

1. Choose **Next**\.

1. Review the directory information and make any necessary changes\. When the information is correct, choose **Create**\.