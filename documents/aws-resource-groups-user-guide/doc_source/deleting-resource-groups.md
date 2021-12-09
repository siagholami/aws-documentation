# Delete groups from AWS Resource Groups<a name="deleting-resource-groups"></a>

You can use the Resource Groups console or the AWS CLI to delete resource groups from AWS Resource Groups\. Deleting a resource group does not delete the resources that are members of the group or tags on member resources\. It deletes only the group structure and any group\-level tags\.

**To delete resource groups \(AWS Management Console\)**

1. From the Resource Groups drop\-down menu on the AWS home page, choose **Saved Resource Groups**\.

1. Choose the resource group that you want to delete\.

1. On the group's detail page, choose **Delete**\.  
![\[Delete a resource group.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-delete-group.png)

1. When you are prompted to confirm the deletion, choose **Delete**\.

**To delete resource groups \(AWS CLI\)**

1. Type the following command, replacing *resource\_group\_name* with the name of your group, and then press **Enter**\.

   ```
   $ aws resource-groups delete-group \
       --group-name resource_group_name
   ```

1. When you are prompted to confirm the deletion, type `yes`, and then press **Enter**\.