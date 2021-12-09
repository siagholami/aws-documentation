# Build queries and groups in AWS Resource Groups<a name="gettingstarted-query"></a>

In AWS Resource Groups, a *query* is the foundation of a group\. You can base a resource group on one of two types of queries\.

**Tag\-based**  
Tag\-based queries include lists of resources that are specified in the following format `AWS::service::resource`, and tags\. *Tags* are keys that help identify and sort your resources in your organization\. Optionally, tags include values for keys\.  
For a tag\-based query, you also specify the tags that are shared by the resources that you want to be members of the group\. For example, if you want to create a resource group that has all of the Amazon EC2 instances and Amazon S3 buckets that you are using to run the testing stage of an application, and you have instances and buckets that are tagged this way, choose the `AWS::EC2::Instance` and `AWS::S3::Bucket` resource types from the drop\-down list, and then specify the tag key **Stage**, with a tag value of **Test**\.

**AWS CloudFormation stack\-based**  
In an AWS CloudFormation stack\-based query, you choose an AWS CloudFormation stack in your account in the current region, and then choose resource types in the stack that you want to be in the group\. You can base your query on only one AWS CloudFormation stack\. Resource Groups supports queries based on AWS CloudFormation stacks that have one of the following statuses\.  
If you create a group based on an AWS CloudFormation stack, and the stack's status changes to one that is no longer supported as a basis for a group query, such as `DELETE_COMPLETE`, the group still exists, but it has no member resources\.  
+ `CREATE_COMPLETE`
+ `CREATE_IN_PROGRESS`
+ `DELETE_IN_PROGRESS`
+ `DELETE_FAILED`
+ `REVIEW_IN_PROGRESS`
+ `ROLLBACK_IN_PROGRESS`
+ `ROLLBACK_FAILED`
+ `UPDATE_IN_PROGRESS`
+ `UPDATE_COMPLETE_CLEANUP_IN_PROGRESS`
+ `UPDATE_COMPLETE`
+ `UPDATE_ROLLBACK_IN_PROGRESS`
+ `UPDATE_ROLLBACK_FAILED`
+ `UPDATE_ROLLBACK_COMPLETE_CLEANUP_IN_PROGRESS`
+ `UPDATE_ROLLBACK_COMPLETE`

After you have created a resource group, you can perform tasks on the resources in the group\.

## Build a query and create a group \(console\)<a name="gettingstarted-query-console"></a>

The following procedures show you how to build a query and create a resource group in the AWS Management Console\.

**Topics**
+ [Create a tag\-based group](#gettingstarted-query-console-tag)
+ [Create an AWS CloudFormation stack\-based group](#gettingstarted-query-console-stack)

### Create a tag\-based group<a name="gettingstarted-query-console-tag"></a>

1. Open Resource Groups from the top left of the AWS Management Console\. Choose **Create a resource group**\.

1. On the **Create query\-based group** page, in **Group type**, choose the **Tag based** group type\.  
![\[Create a group page.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-aramis-home.png)

1. In **Grouping criteria**, choose the resource types that you want to be in your resource group\. You can have a maximum of 20 resource types in a query\. For this walkthrough, choose **AWS::EC2::Instance** and **AWS::S3::Bucket**\.   
![\[Grouping criteria area, EC2 instance and S3 bucket resource types selected in a tag-based query.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-instancebucket-selected.png)

1. In **Tags**, specify a tag key, or a tag key and value pair, to limit the EC2 instances and S3 buckets in your account to only those that are tagged with your specified values\. Choose **Add** or press **Enter** when you've finished your tag\. In this example, filter for resources that have a tag key of **Stage**\. The tag value is optional, but narrows the results of the query further\. You can add multiple values for a tag key by adding an `OR` operator between tag values\. To add more tags, choose **Add**\. Queries assign an `AND` operator to tags, so any resource that matches the specified resource types and all specified tags is returned by the query\.  
![\[Query with tag key specified.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-query-tags.png)

1. Choose **View group resources** to return the list of EC2 instances and S3 buckets in your account that match the specified tag key or keys\.

1. To create a resource group based on your query, enter a name, and optionally, a description\.

   1. In **Group name**, type a name for your resource group\.

      A resource group name can have a maximum of 128 characters, including letters, numbers, hyphens, periods, and underscores\. The name cannot start with `AWS` or `aws`\. These are reserved\. A resource group name must be unique in the current Region in your account\.

   1. \(Optional\) In **Group description**, enter a description of your group\.

   1. \(Optional\) In **Group tags**, add tag key and value pairs that apply only to the resource group, not the member resources in the group\.

      Group tags are useful if you plan to make this group a member of a larger group\. Because specifying at least a tag key is required to create a group, be sure to add at least a tag key in **Group tags** to groups that you plan to nest into larger groups\.

1. When you are finished, choose **Create group**\.

### Create an AWS CloudFormation stack\-based group<a name="gettingstarted-query-console-stack"></a>

1. Open Resource Groups from the top left of the AWS Management Console\.

1. Choose **Create a resource group**\.

1. On **Create query\-based group**, in **Group type**, choose the **CloudFormation stack based** group type\.  
![\[Group type area, CloudFormation stack-based group type selected.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-grouptype-cfnstack.png)

1. Choose the stack that you want to be the basis of your group\. A resource group can be based on only one stack\. To filter the list of stacks, start typing the name of the stack\. Only stacks with supported statuses appear in the list\.  
![\[Create a resource group page, no resource types selected, AWS CloudFormation stack-based query.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-groupcriteria-cfnstack.png)

1. Choose resource types in the stack that you want to include in the group\. For this walkthrough, keep the default, **All supported resource types**\. For more information about which resource types are supported and can be in the group, see [Resources you can use with AWS Resource Groups](supported-resources.md)\.

1. Choose **View group resources** to return the list of resources in the AWS CloudFormation stack that match your selected resource types\.

1. To create a resource group based on your query, enter a name, and optionally, a description\.

   1. In **Group name**, enter a name for your resource group\.

      A resource group name can have a maximum of 128 characters, including letters, numbers, hyphens, periods, and underscores\. The name cannot start with `AWS` or `aws`\. These are reserved\. A resource group name must be unique in the current Region in your account\.

   1. \(Optional\) In **Group description**, enter a description of your group\.

   1. \(Optional\) In **Group tags**, add tag key and value pairs that apply only to the resource group, not the member resources in the group\.

      Group tags are useful if you plan to make this group a member of a larger group\. Because specifying at least a tag key is required to create a group, be sure to add at least a tag key in **Group tags** to groups that you plan to nest into larger groups\.

1. When you are finished, choose **Create group**\.

## Build a query and create a group \(AWS CLI\)<a name="gettingstarted-query-cli"></a>

The following procedure shows you how to build a query and create a resource group in the AWS CLI\.

In the AWS CLI, you build a query and create your resource group in the same command\. The AWS CLI commands shown in this topic create groups\.

**Topics**
+ [Create a tag\-based group in Resource Groups](#gettingstarted-query-cli-tag)
+ [Create an AWS CloudFormation stack\-based group in Resource Groups](#gettingstarted-query-cli-stack)

### Create a tag\-based group in Resource Groups<a name="gettingstarted-query-cli-tag"></a>

A tag\-based group is based on a query of type `TAG_FILTERS_1_0`\.

1. In an AWS CLI session, type the following, and then press **Enter**, replacing the values for group name, description, resource types, tag keys, and tag values with your own\. Descriptions can have a maximum of 512 characters, including letters, numbers, hyphens, underscores, punctuation, and spaces\. You can have a maximum of 20 resource types in a query\. A resource group name can have a maximum of 128 characters, including letters, numbers, hyphens, periods, and underscores\. The name cannot start with `AWS` or `aws`\. These are reserved\. A resource group name must be unique in your account\.

   At least one value for `ResourceTypeFilters` is required\. To specify all resource types, use `AWS::AllSupported` as the `ResourceTypeFilters` value\.

   ```
   $ aws resource-groups create-group \
       --name resource-group-name \
       --resource-query '{"Type":"TAG_FILTERS_1_0","Query":"{\"ResourceTypeFilters\":[\"resource_type1\",\"resource_type2\"],\"TagFilters\":[{\"Key\":\"Key1\",\"Values\":[\"Value1\",\"Value2\"]},{\"Key\":\"Key2\",\"Values\":[\"Value1\",\"Value2\"]}]}"}'
   ```

   The following command is an example\.

   ```
   $ aws resource-groups create-group \
       --name my-resource-group \
       --resource-query '{"Type":"TAG_FILTERS_1_0","Query":"{\"ResourceTypeFilters\":[\"AWS::EC2::Instance\"],\"TagFilters\":[{\"Key\":\"Stage\",\"Values\":[\"Test\"]}]}"}'
   ```

   The following command is an example that includes all supported resource types\.

   ```
   $ aws resource-groups create-group \
       --name my-resource-group \
       --resource-query '{"Type":"TAG_FILTERS_1_0","Query":"{\"ResourceTypeFilters\":[\"AWS::AllSupported\"],\"TagFilters\":[{\"Key\":\"Stage\",\"Values\":[\"Test\"]}]}"}'
   ```

1. The following are returned in the response to the command\.
   + A full description of the group you have created\.
   + The resource query that you used to create the group\.
   + The tags that are associated with the group\.

### Create an AWS CloudFormation stack\-based group in Resource Groups<a name="gettingstarted-query-cli-stack"></a>

An AWS CloudFormation stack\-based group is based on a query of type `CLOUDFORMATION_STACK_1_0`\.

1. In an AWS CLI session, type the following, and then press **Enter**, replacing the values for group name, description, stack identifier, and resource types with your own\. Descriptions can have a maximum of 512 characters, including letters, numbers, hyphens, underscores, punctuation, and spaces\.

   If you do not specify resource types, Resource Groups includes all supported resource types in the stack\. You can have a maximum of 20 resource types in a query\. A resource group name can have a maximum of 128 characters, including letters, numbers, hyphens, periods, and underscores\. The name cannot start with `AWS` or `aws`\. These are reserved\. A resource group name must be unique in your account\.

   The *stack\_identifier* is the stack ARN, as shown in the example command\.

   ```
   $ aws resource-groups create-group \
       --name group_name \
       --description "description" \
       --resource-query '{"Type":"CLOUDFORMATION_STACK_1_0","Query":"{\"StackIdentifier\":\"stack_identifier\",\"ResourceTypeFilters\":[\"resource_type1\",\"resource_type2\"]}"}'
   ```

   The following command is an example\.

   ```
   $ aws resource-groups create-group \
       --name My-CFN-stack-group \
       --description "My first CloudFormation stack-based group" \
       --resource-query '{"Type":"CLOUDFORMATION_STACK_1_0","Query":"{\"StackIdentifier\":\"arn:aws:cloudformation:us-west-2:123456789012:stack\/AWStestuseraccount\/fb0d5000-aba8-00e8-aa9e-50d5cEXAMPLE\",\"ResourceTypeFilters\":[\"AWS::EC2::Instance\",\"AWS::S3::Bucket\"]}"}'
   ```

1. The following are returned in the response to the command\.
   + A full description of the group you have created\.
   + The resource query that you used to create the group\.