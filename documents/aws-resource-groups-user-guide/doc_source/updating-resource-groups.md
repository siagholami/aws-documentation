# Update groups in AWS Resource Groups<a name="updating-resource-groups"></a>

To update a tag\-based resource group in Resource Groups, you can edit the query and tags that are the basis of your group\. You can add and remove resources from your group only by applying changes to the query or tags\. You cannot select specific resources to add to or remove from your group\. The best way to add or remove a specific resource from a group is to edit the resource's tags\. Then verify that your resource group tag query either includes or omits the tag, depending on whether you want the resource in your group\.

To update an AWS CloudFormation stack\-based resource group, you can choose a different stack\. You can also add or remove resource types from the stack that you want to be part of the group\. To change the resources that are available in the stack, update the AWS CloudFormation template used to create the stack, and then update the stack in AWS CloudFormation\. For more information about how to update an AWS CloudFormation stack, see [AWS CloudFormation stacks updates](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/using-cfn-updating-stacks.html) in the *AWS CloudFormation User Guide\.*

In the AWS CLI, you update groups in two commands\.
+ `update-group`, which you run to update a group's description\.
+ `update-group-query`, which you run to update the resource query and tags that determine the group's member resources\.

In the console, you cannot change an AWS CloudFormation stack\-based group to a tag\-based group, or vice versa\. However, you can do this by using the Resource Groups API, including in the AWS CLI\.

## Update groups \(console\)<a name="updating-resource-groups-console"></a>

**Topics**
+ [Update a tag\-based group](#updating-resource-groups-console-tag)
+ [Update an AWS CloudFormation stack\-based group](#updating-resource-groups-console-stack)

### Update a tag\-based group<a name="updating-resource-groups-console-tag"></a>

Update a tag\-based group by changing the resource types or tags in the query on which the group is based\. You can also add or change the group's description\.

1. Open Resource Groups from the top left of the AWS Management Console\.

1. In the navigation pane, under **Saved resource groups**, choose a group, and then choose **Edit**\.
**Note**  
You can update only resource groups that you own\. The **Owner** column shows account ownership for each resource group\. Any groups with an account owner other than the one you're signed in to were created in AWS License Manager\. For more information, see [Host resource groups in AWS License Manager](https://docs.aws.amazon.com/license-manager/latest/userguide/host-resource-groups.html) in the *License Manager User Guide*\. 

1. On the **Edit group** page, in **Grouping criteria**, add or remove resource types\. You can have a maximum of 20 resource types in a query\. To remove a resource type, choose **X** on the resource type's label\. Choose **View group resources** to see how the changes affect your group's resource members\. In this walkthrough, we add the resource type **AWS::RDS::DBInstance** to the query\.  
![\[Group query\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-update-group-query.png)

1. Edit tags, if necessary\. In this example, we filter for resources that have a tag key of **Stage** and add a tag value of **Test**\. The tag value is optional, but narrows the results of the query further\. To remove a tag, choose **X** on the tag's label\.  
![\[Group tags\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-update-tags.png)

1. In **Additional information**, you can edit the group description\. You cannot edit a group's name after the group has been created\.  
![\[Group name and description\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-groupname-desc.png)

1. In **Group tags**, add or remove tags\. Group tags are metadata about your resource group\. They do not affect member resources\. To change the resources that are returned by the resource group's query, edit tags in **Grouping criteria**\.

   Group tags are useful if you plan to make this group a member of a larger group\. Specifying at least a tag key is required to create a group\. Therefore, be sure to add at least a tag key in **Group tags** to groups that you plan to nest into larger groups\.

1. Choose **View query results** to return the updated list of EC2 instances, S3 buckets, and Amazon RDS database instances in your account that match the specified tag keys\. If you do not see resources in the list that you expect, be sure that the resources are tagged with tags that you specified in**Grouping criteria**\.

1. When you are finished, choose **Save changes**\.

### Update an AWS CloudFormation stack\-based group<a name="updating-resource-groups-console-stack"></a>

You cannot change an AWS CloudFormation stack\-based group to a tag\-based group in the AWS Management Console\. However, you can change the stack on which the group is based, or change the stack resource types that you want to include in the group\. You can also add or change the group's description\.

1. Open Resource Groups from the top left of the AWS Management Console\.

1. In the navigation pane, under **Saved resource groups**, choose an existing group, and then choose **Edit**\.
**Note**  
You can update only resource groups that you own\. The **Owner** column shows account ownership for each resource group\. Any groups with an account owner other than the one you're signed in to were created in AWS License Manager\. For more information, see [Host resource groups in AWS License Manager](https://docs.aws.amazon.com/license-manager/latest/userguide/host-resource-groups.html) in the *License Manager User Guide*\. 

1. On the **Edit group** page, in **Grouping criteria**, to change the stack on which your group is based, choose the stack from the drop\-down list\. A resource group can be based on only one stack\. To filter the list of stacks, start typing the name of the stack\. Only stacks with supported statuses appear in the list\. For a list of supported statuses, see [Build queries and groups in AWS Resource Groups](gettingstarted-query.md) in this guide\.  
![\[Grouping criteria area, no resource types selected, AWS CloudFormation stack-based query.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-groupcriteria-cfnstack.png)

1. Add or remove resource types\. Only resource types that are available in the stack are shown in the drop\-down list\. The default is **All supported resource types**\. You can have a maximum of 20 resource types in a query\. To remove a resource type, choose **X** on the resource type's label\. For more information about which resource types are supported and can be in the group, see [Resources you can use with AWS Resource Groups](supported-resources.md)\.

1. Choose **View group resources** to return the list of resources in the AWS CloudFormation stack that match your selected resource types\.

1. In **Additional information**, you can edit the group description\. You cannot edit a group's name after the group has been created\.  
![\[Group name and description\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-groupname-desc.png)

1. In **Group tags**, add or remove tags\. Group tags are metadata about your resource group\. They do not affect member resources\. To change the resources that are returned by the resource group's query, edit tags in **Grouping criteria**\.

   Group tags are useful if you plan to make this group a member of a larger group\. Specifying at least a tag key is required to create a group\. Therefore, be sure to add at least a tag key in **Group tags** to groups that you plan to nest into larger groups\.

1. When you are finished, choose **Save changes**\.

## Update groups \(AWS CLI\)<a name="updating-resource-groups-cli"></a>

In the AWS CLI, you update a group's query and update a resource group's description by using two different commands\. You cannot edit an existing group's name\. In the AWS CLI, you can change a tag\-based group to a CloudFormation stack\-based group, or vice versa\.

**Topics**
+ [Update a tag\-based group](#updating-resource-groups-cli-tag)
+ [Update an AWS CloudFormation stack\-based group](#updating-resource-groups-cli-stack)

### Update a tag\-based group<a name="updating-resource-groups-cli-tag"></a>

1. If you do not want to change the description of your group, skip this step and go on to the next\. In an AWS CLI session, type the following, and then press **Enter**, replacing the values for group name and description with your own\.

   ```
   $ aws resource-groups update-group \
       --group-name resource-group-name \
       --description "description_text"
   ```

   The following command is an example\.

   ```
   $ aws resource-groups update-group \
       --group-name my-resource-group \
       --description "EC2 instances, S3 buckets, and RDS DBs that we are using for the test stage."
   ```

   The command returns a full, updated description of the group\.

1. To update the query and tags of a group, type the following command\. Replace the values for group name, resource types, tag keys, and tag values with your own\. Then pres **Enter**\. You can have a maximum of 20 resource types in a query\.

   ```
   $ aws resource-groups update-group-query \
       --group-name resource-group-name \
       --resource-query '{"Type":"TAG_FILTERS_1_0","Query":"{\"ResourceTypeFilters\":[\"resource_type1\",\"resource_type2\"],\"TagFilters\":[{\"Key\":\"Key1\",\"Values\":[\"Value1\",\"Value2\"]},{\"Key\":\"Key2\",\"Values\":[\"Value1\",\"Value2\"]}]}"}'
   ```

   The following command is an example\.

   ```
   $ aws resource-groups update-group-query \
       --group-name my-resource-group \
       --resource-query '{"Type":"TAG_FILTERS_1_0","Query":"{\"ResourceTypeFilters\":[\"AWS::EC2::Instance\",\"AWS::S3::Bucket\",\"AWS::RDS::DBInstance\"],\"TagFilters\":[{\"Key\":\"Stage\",\"Values\":[\"Test\"]}]}"}'
   ```

   The command returns the updated query as a result\.

### Update an AWS CloudFormation stack\-based group<a name="updating-resource-groups-cli-stack"></a>

1. If you do not want to change the description of your group, skip this step and go on to the next\. In an AWS CLI session, type the following, and then press **Enter**, replacing the values for group name and description with your own\.

   ```
   $ aws resource-groups update-group \
       --group-name "resource-group-name" \
       --description "description_text"
   ```

   The following command is an example\.

   ```
   $ aws resource-groups update-group \
       --group-name "My-CFN-stack-group" \
       --description "EC2 instances, S3 buckets, and RDS DBs that we are using for the test stage."
   ```

   The command returns a full, updated description of the group\.

1. To update the query and tags of a group, type the following command\. Replace the values for group name, stack identifier, and resource types with your own\. Then press **Enter**\. To add resource types, provide the full list of resource types in the command, not only resource types you are adding\. You can have a maximum of 20 resource types in a query\.

   The *stack\_identifier* is the stack ARN, as shown in the example command\.

   ```
   $ aws resource-groups update-group-query \
       --group-name resource-group-name \
       --description "description" \
       --resource-query '{"Type":"CLOUDFORMATION_STACK_1_0","Query":"{\"StackIdentifier\":\"stack_identifier\",\"ResourceTypeFilters\":[\"resource_type1\",\"resource_type2\"]}"}'
   ```

   The following command is an example\.

   ```
   $ aws resource-groups update-group-query \
       --group-name "my-resource-group" \
       --description "Updated CloudFormation stack-based group" \
       --resource-query '{"Type":"CLOUDFORMATION_STACK_1_0","Query":"{\"StackIdentifier\":\"arn:aws:cloudformation:us-west-2:810000000000:stack\/AWStestuseraccount\/fb0d5000-aba8-00e8-aa9e-50d5cEXAMPLE\",\"ResourceTypeFilters\":[\"AWS::EC2::Instance\",\"AWS::S3::Bucket\"]}"}'
   ```

   The command returns the updated query as a result\.