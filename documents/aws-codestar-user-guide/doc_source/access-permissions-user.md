# IAM User Access to AWS CodeStar<a name="access-permissions-user"></a>

When you add an IAM user to a project and choose a role for the user, AWS CodeStar applies the appropriate policy to the IAM user automatically\. For IAM users, you don't need to directly attach or manage policies or permissions in IAM\. 

## Add an IAM User to Your AWS CodeStar Project<a name="access-permissions-user-add-CodeStar"></a>

After you create your AWS CodeStar project, grant IAM users access to your project\. As an IAM user with the owner role in an AWS CodeStar project or the `AWSCodeStarFullAccess` policy applied to your IAM user, you can add other IAM users to the project team\. When you select the project\-level role for the team member, AWS CodeStar attaches the appropriate managed policy to the IAM user based on the role you choose\.

## Remove an IAM User from Your AWS CodeStar Project<a name="access-permissions-user-remove-CodeStar"></a>

When you delete a project, AWS CodeStar removes the policies that were applied automatically to IAM users that you added as team members\. For IAM users, you don't need to directly detach or manage policies or permissions in IAM\.

## Attach an Inline Policy to an IAM User<a name="access-permissions-user"></a>

When you add a user to a project, AWS CodeStar automatically attaches the managed policy for the project that matches the user's role\. You should not manually attach an AWS CodeStar managed policy for a project to an IAM user\. With the exception of `AWSCodeStarFullAccess`, we do not recommend that you attach policies that change an IAM user's permissions in an AWS CodeStar project\. If you decide to create and attach your own policies, do the following:

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the IAM console, in the navigation pane, choose **Users**, and then choose the user to which you want to attach additional policies\.

1. On the **Permissions** tab, choose **Add permissions**\. Choose **Attach existing policies directly**, select the policy you want to apply, and then choose **Attach Policy**\.

   For example, if you want to add your own customized policy to a user, choose the policy name from the list of policies\.

1. If you do not want to attach an existing policy, but instead want to create your own custom policy, on the **Permissions** tab, choose **Add inline policy**\. Choose **Custom Policy**, and then choose **Select**\.

   In **Policy Name**, enter a name for this policy\. In the **Policy Document** box, enter a policy that follows this format, and then choose **Apply Policy**\.

   ```
   {
     "Version": "2012-10-17",
     "Statement" : [
       {
         "Effect" : "Allow",
         "Action" : [
           "action-statement"
         ],
         "Resource" : [
           "resource-statement"
         ]
       },
       {
         "Effect" : "Allow",
         "Action" : [
           "action-statement"
         ],
         "Resource" : [
           "resource-statement"
         ]
       }
     ]
   }
   ```

   In the preceding statement, for *action\-statement* and *resource\-statement*, specify the AWS CodeStar actions and resources the IAM user is allowed to perform or access\. \(By default, the IAM user does not have permissions unless a corresponding `Allow` statement is explicitly stated\. If you want to specifically deny a permission granted by another policy, such as the policy for an AWS CodeStar role, choose `Deny` instead of `Allow`\.\) You can add statements as needed\. The following sections describe the format of allowed actions and resources for AWS CodeStar\. Syntax examples are provided in these sections\.