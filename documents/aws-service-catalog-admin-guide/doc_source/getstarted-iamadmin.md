# Grant Permissions to AWS Service Catalog Administrators<a name="getstarted-iamadmin"></a>

As a catalog administrator, you require access to the AWS Service Catalog administrator console view and IAM permissions that allow you to perform tasks such as the following:
+ Creating and managing portfolios
+ Creating and managing products
+ Adding template constraints to control the options that are available to end users when launching a product
+ Adding launch constraints to define the IAM roles that AWS Service Catalog assumes when end users launch products
+ Granting end users access to your products

You, or an administrator who manages your IAM permissions, must attach policies to your IAM user, group, or role that are required to complete this tutorial\.

**To grant permissions to a catalog administrator**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Users**\. If you have already created an IAM user that you would like to use as the catalog administrator, choose the user name and choose **Add permissions**\. Otherwise, create a user as follows:

   1. Choose **Add user**\.

   1. For **User name**, type **ServiceCatalogAdmin**\.

   1. Select **Programmatic access** and **AWS Management Console access**\.

   1. Choose **Next: Permissions**\.

1. Choose **Attach existing policies directly**\.

1. Choose **Create policy** and do the following:

   1. Choose the **JSON** tab\.

   1. Copy the following example policy and paste it in **Policy Document**:

      ```
      {
          "Version": "2012-10-17",
          "Statement": [
              {
                  "Effect": "Allow",
                  "Action": [
                      "ec2:CreateKeyPair",
                      "iam:AddRoleToInstanceProfile",
                      "iam:AddUserToGroup",
                      "iam:AttachGroupPolicy",
                      "iam:CreateAccessKey",
                      "iam:CreateGroup",
                      "iam:CreateInstanceProfile",
                      "iam:CreateLoginProfile",
                      "iam:CreateRole",
                      "iam:CreateUser",
                      "iam:Get*",
                      "iam:List*",
                      "iam:PutRolePolicy",
                      "iam:UpdateAssumeRolePolicy"
                  ],
                  "Resource": [
                      "*"
                  ]
              }
          ]
      }
      ```

   1. Choose **Review policy**\.

   1. For **Policy Name**, type **ServiceCatalogAdmin\-AdditionalPermissions**\.

   1. You must grant administrators permissions for Amazon S3 so they can access templates stored by AWS Service Catalog in Amazon S3\. For more information, see [User Policy Examples](https://docs.aws.amazon.com/AmazonS3/latest/dev/example-policies-s3.html) in the *Amazon Simple Storage Service Developer Guide*

   1. Choose **Create Policy**\.

1. Return to the browser window with the permissions page and choose **Refresh**\.

1. In the search field, type **ServiceCatalog** to filter the policy list\.

1. Select the checkboxes for the **AWSServiceCatalogAdminFullAccess** and **ServiceCatalogAdmin\-AdditionalPermissions** policies, and then choose **Next: Review**\.

1. If you are updating a user, choose **Add permissions**\.

   If you are creating a user, choose **Create user**\. You can download or copy the credentials and then choose **Close**\.

1. To sign in as the catalog administrator, use your account\-specific URL\. To find this URL, choose **Dashboard** in the navigation pane and choose **Copy Link**\. Paste the link in your browser, and use the name and password of the IAM user you created or updated in this procedure\.