# Directory<a name="key_concepts_directory"></a>

A directory is a schema\-based data store that contains specific types of objects organized in a multi\-hierarchical structure \(see [Directory Structure](key_concepts_directorystructure.md) for more details\)\. For example, a directory of users may provide a hierarchical view based on reporting structure, location, and project affiliation\. Similarly, a directory of devices may have multiple hierarchical views based on its manufacturer, current owner, and physical location\. 

A directory defines the logical boundary for the data store, completely isolating it from all other directories in the service\. It also defines the boundaries for an individual request\. A single transaction or query executes within the context of a single directory\. A directory cannot be created without a schema and typically has one schema applied to it\. However, you can use the Cloud Directory API operations to apply additional schemas to a directory\. For more information, see [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ApplySchema.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ApplySchema.html) in the *Amazon Cloud Directory API Reference Guide*\. 

## Objects<a name="key_concepts_objects"></a>

Objects are a structured data entity in a directory\. An object in a directory is intended to capture metadata \(or attributes\) about a physical or logical entity usually for the purpose of information discovery and enforcing policies\. For example users, devices, applications, AWS accounts, EC2 instances and Amazon S3 buckets can all be represented as different types of objects in a directory\. 

An object’s structure and type information is expressed as a collection of facets\. You can use `Path` or `ObjectIdentifier` to access objects\. Objects can also have attributes, which are a user\-defined unit of metadata\. For example, the user object can have an attribute called *email\-address*\. Attributes are always associated with an object\. 

## Policies<a name="key_concepts_policies"></a>

Policies are a specialized type of object that are useful for storing permissions or capabilities\. Policies offer the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_LookupPolicy.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_LookupPolicy.html) API action\. The lookup policy action takes a reference to any object as its starting input\. It then walks up the directory all the way to the root\. The action collects any policy objects that it encounters on each path to the root\. Cloud Directory does not interpret any of these policies in any way\. Instead, Cloud Directory users interpret policies using their own specialized business logic\.

For example, imagine a system that stores employee information\. Employees are grouped together by job function\. We want to establish different permissions for members of the Human Resources Group and the Accounting group\. Members of the Human Resources group will have access to payroll information and the Accounting group will have access to ledger information\. To establish these permissions, we attach policy objects to each of these groups\. When it is time to evaluate a user’s permissions, we can use the `LookupPolicy` API action on that user’s object\. The `LookupPolicy` API action walks the tree from the specified policy's object up to the root\. It stops at each node and checks for any attached policies and returns those\.

**Policy Attachments**

Policies can be attached to other objects in two ways: normal parent\-child attachments and special policy attachments\. Using normal parent\-child attachments, a policy can be attached to a parent node\. This is often useful to provide an easy mechanism to locate policies within your data directory\. Policies cannot have children\. Policies attached via parent\-child attachments will not be returned during `LookupPolicy` API calls\. 

Policy objects can also be attached to other objects via policy attachments\. You can manage these policy attachments using the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_AttachPolicy.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_AttachPolicy.html) and [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DetachPolicy.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_DetachPolicy.html) API actions\. Policy attachments allow policy nodes to be located when you use the LookupPolicy API\.

**Policy Schema Specification**

In order to start using policies, you must first add a facet to your schema that support creating policies\. To accomplish this, create a facet setting the `objectType` of the facet to POLICY\. Creating objects using a facet with the type POLICY ensures that the object has policy capabilities\.

Policy facets inherit two attributes in addition to any attributes you add to the definition: 
+ **policy\_type** \(String, Required\) – This is an identifier you can provide to distinguish between different policy uses\. If your policies logically fall into clear categories, we encourage setting the policy type attribute appropriately\. The `LookupPolicy` API returns the policy type of attached policies \(see [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_PolicyAttachment.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_PolicyAttachment.html)\)\. This allows easy filtering of the specific policy type that you are looking for\. It also allows you to use policy\_type to decide how the document should be processed or interpreted\. 
+ **policy\_document** \(Binary, Required\) – You can store application specific data in this attribute, such as permission grants associated with the policy\. You can also store application\-related data in normal attributes on your facet, if you prefer\.

**Policy API Overview**

A variety of specialized API actions are available for working with policies\. For a list of available operations, see [Amazon Cloud Directory Actions](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_Operations.html)\. 

To create a policy object, use the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateObject.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_CreateObject.html) API action with an appropriate facet:
+ To attach or detach a policy from an object, use the actions `AttachPolicy` and `DetachPolicy` respectively\.
+ To find policies that are attached to objects up the tree, use the `LookupPolicy` API action\.
+ To list the policies that are attached to a particular object, use the [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListObjectPolicies.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListObjectPolicies.html) API action\.

For a list of operations and the permissions required to perform each API action, see [Amazon Cloud Directory API Permissions: Actions, Resources, and Conditions Reference](iam_auth_access_usingwith_iam_resourcepermissions.md)\.