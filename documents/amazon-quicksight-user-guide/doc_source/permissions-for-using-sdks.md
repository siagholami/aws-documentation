# Permissions for Using Amazon QuickSight from the AWS SDKs<a name="permissions-for-using-sdks"></a>

Before you can call the Amazon QuickSight operations, you need the `quicksight:operation-name` permission in a policy attached to your IAM identity\. For example, to call `list-users`, you need the permission `quicksight:ListUsers`\. The same pattern applies to all operations\. 

If you’re not sure what the necessary permission is, you can attempt to make the call and the client tells you what the missing permission is\. You can use asterisk \(`*`\) in the Resource field of your permission policy in lieu of explicit resources, but it is highly recommended that you restrict each permission as much as possible\. You can restrict user access by specifying or excluding resources in the policy, using their Amazon QuickSight Amazon Resource Name \(ARN\) identifier\. 

For more information, see the following:
+ [Setting Your IAM Policy](set-iam-policy.md)
+ [Actions, Resources, and Condition Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazoninspector.html)
+ [IAM JSON Policy Elements](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html)

To retrieve the ARN of a user or a group, use the `Describe` operation on the relevant resource\. You can also add conditions in IAM to further restrict access to an API in some scenarios\. For instance, when adding `User1` to `Group1`, the main resource is `Group1`, so you can allow or deny access to certain groups, but you can also add a condition by using the IAM Amazon QuickSight key `quicksight:UserName` to allow or prevent certain users from being added to that group\. 

Following is an example policy\. It means that the caller with this policy attached, is able to invoke the `CreateGroupMembership` operation on any group, provided that the user name they are adding to the group is not `user1`\. 

```
{
    "Effect": "Allow",
    "Action": "quicksight:CreateGroupMembership",
    "Resource": "arn:aws:quicksight:us-east-1:aws-account-id:group/default/*",
    "Condition": {
        "StringNotEquals": {
            "quicksight:UserName": "user1"
        }
    }
}
```

**Topics**