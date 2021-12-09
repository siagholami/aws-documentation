# Controlling Access<a name="controlling-access"></a>

Your administrative account has all of the permissions needed to manage agreements, but different documents and agreements might require you to delegate permissions differently for various user accounts\. You delegate permissions by using IAM policies\.

To grant non\-administrative access, you must create a policy, attach the policy to a group, and add IAM users to the group\.

1. [Create an IAM Policy](#create-iam-policy)

1. [Create an IAM Group](#create-iam-group)

1. [Create an IAM User and Add Them to a Group](#create-iam-user)

## Create an IAM Policy<a name="create-iam-policy"></a>

Create a permissions policy that grants permissions to IAM users\. The permissions allow the users to access AWS Artifact reports and accept and download agreements on behalf of either a single account or an organization\. The following tables show the permissions that you can assign to IAM users based on the level of access that they need\. 
+ [Report Permissions](#report-permissions)
+ [Agreement Permissions](#agreement-permissions)
+ [Common AWS Artifact IAM Policies](#common-policies)
+ [To create an IAM policy](#create-iam-policy-proc)


**Report Permissions**  

| **Permission Name** | **Permissions Granted** | **Example IAM Policy** | 
| --- | --- | --- | 
|   `Get`  |  Grants the IAM user permission to download all reports that are accessible by the root account\.  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:Get"<br />            ],<br />            "Resource": [<br />                "arn:aws:artifact:::report-package/*"<br />            ]<br />        }<br />    ]<br />}</pre>  | 


**Agreement Permissions**  

| **Permission Name** | **Permissions Granted** | **Example IAM Policy** | 
| --- | --- | --- | 
|  `DownloadAgreement`  |  Grants the IAM user permission to download all agreements that are accessible by the root account\. IAM users must have this permission to accept agreements\.  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:DownloadAgreement"<br />            ],<br />            "Resource": [<br />                "*"<br />            ]<br />        }<br />    ]<br />}</pre>  | 
|  `AcceptAgreement`  | Grants the IAM user permission to accept an agreement on behalf of the root account\.IAM users must also have permission to download agreements in order to accept an agreement\. |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:AcceptAgreement"<br />            ],<br />            "Resource": [<br />                "*"<br />            ]<br />        }<br />    ]<br />}</pre>  | 
|  `TerminateAgreement`  |  Grants the IAM user permission to terminate an agreement on behalf of the root account\.  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:TerminateAgreement"<br />            ],<br />            "Resource": [<br />                "*"<br />            ]<br />        }<br />    ]<br />}</pre>  | 
|   `DescribeOrganization`  |  Grants the IAM user permission to retrieve information about the AWS Organizations organization that the user's account belongs to\. Both master and member accounts need the `DescribeOrganizations` permission to view or use organization agreements\.  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "organizations:DescribeOrganization"<br /><br />            ],<br />            "Resource": "*"<br />        }<br />    ]<br />}</pre>  | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/artifact/latest/ug/controlling-access.html)  |  Grants the IAM user permission to create the IAM role that AWS Artifact uses to integrate with AWS Organizations\. Your organization's master account must have these permissions to get started with organizational agreements\.  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": "iam:ListRoles",<br />            "Resource": "arn:aws:iam::*:role/*"<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": "iam:CreateRole",<br />            "Resource": "arn:aws:iam::*:role/service-role/AWSArtifactAccountSync"<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": "iam:AttachRolePolicy",<br />            "Resource": "arn:aws:iam::*:role/service-role/AWSArtifactAccountSync",<br />            "Condition": {<br />                "ArnEquals": {<br />                    "iam:PolicyARN": "arn:aws:iam::aws:policy/service-role/AWSArtifactAccountSync"<br />                }<br />            }<br />        }<br />    ]<br />}</pre>  | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/artifact/latest/ug/controlling-access.html)  |  Grants the IAM user permission to grant AWS Artifact the permissions to use AWS Organizations\. For more information about AWS Organizations, see [Managing Your Agreements in AWS Artifact](managingagreements.md)\. Your organization's master account must have these permissions to get started with organizational agreements\.  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "organizations:EnableAWSServiceAccess",<br />                "organizations:DescribeOrganization",<br />                "organizations:ListAWSServiceAccessForOrganization"<br />            ],<br />            "Resource": "*"<br />        }<br />    ]<br />}</pre>  | 

Here are policies for seven of the most common use cases\.


**Common AWS Artifact IAM Policies**  

| **Use case** | **Permission names** | **Example policy** | 
| --- | --- | --- | 
|  Full access to download reports and manage agreements  |  `artifact:Get` `artifact:AcceptAgreement` `artifact:DownloadAgreement` `artifact:TerminateAgreement` `organizations:DescribeOrganization` `organizations:EnableAWSServiceAccess` `organizations:ListAccounts` `organizations:ListAWSServiceAccessForOrganization` `iam:CreateRole` `iam:AttachRolePolicy` `iam:ListRoles`  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:Get",<br />                "artifact:AcceptAgreement",<br />                "artifact:DownloadAgreement",<br />                "artifact:TerminateAgreement"<br />            ],<br />            "Resource": [<br />                "arn:aws:artifact::*:customer-agreement/*",<br />                "arn:aws:artifact:::agreement/*",<br />                "arn:aws:artifact:::report-package/*"<br />            ]<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": "iam:ListRoles",<br />            "Resource": "arn:aws:iam::*:role/*"<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": "iam:CreateRole",<br />            "Resource": "arn:aws:iam::*:role/service-role/AWSArtifactAccountSync"<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": "iam:AttachRolePolicy",<br />            "Resource": "arn:aws:iam::*:role/service-role/AWSArtifactAccountSync",<br />            "Condition": {<br />                "ArnEquals": {<br />                    "iam:PolicyARN": "arn:aws:iam::aws:policy/service-role/AWSArtifactAccountSync"<br />                }<br />            }<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "organizations:DescribeOrganization",<br />                "organizations:EnableAWSServiceAccess",<br />                "organizations:ListAccounts",<br />                "organizations:ListAWSServiceAccessForOrganization"<br />            ],<br />            "Resource": "*"<br />        }<br />    ]<br />}</pre>  | 
|  Permission to download reports  |  `artifact:Get`  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:Get"<br />            ],<br />            "Resource": [<br />                "arn:aws:artifact:::report-package/*"<br />            ]<br />        }<br />    ]<br />}</pre>  | 
|  Permissions to get started with and manage organizational agreements Master account only  |  `artifact:AcceptAgreement` `artifact:DownloadAgreement` `artifact:TerminateAgreement` `organizations:DescribeOrganization` `organizations:EnableAWSServiceAccess` `organizations:ListAccounts` `organizations:ListAWSServiceAccessForOrganization` `iam:CreateRole` `iam:AttachRolePolicy` `iam:ListRoles`  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:AcceptAgreement",<br />                "artifact:DownloadAgreement",<br />                "artifact:TerminateAgreement"<br />            ],<br />            "Resource": [<br />                "arn:aws:artifact::*:customer-agreement/*",<br />                "arn:aws:artifact:::agreement/*"<br />            ]<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": "iam:ListRoles",<br />            "Resource": "arn:aws:iam::*:role/*"<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": "iam:CreateRole",<br />            "Resource": "arn:aws:iam::*:role/service-role/AWSArtifactAccountSync"<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": "iam:AttachRolePolicy",<br />            "Resource": "arn:aws:iam::*:role/service-role/AWSArtifactAccountSync",<br />            "Condition": {<br />                "ArnEquals": {<br />                    "iam:PolicyARN": "arn:aws:iam::aws:policy/service-role/AWSArtifactAccountSync"<br />                }<br />            }<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "organizations:DescribeOrganization",<br />                "organizations:EnableAWSServiceAccess",<br />                "organizations:ListAccounts",<br />                "organizations:ListAWSServiceAccessForOrganization"<br />                <br />            ],<br />            "Resource": "*"<br />        }<br />    ]<br />}</pre>  | 
|  Permissions to manage organizational agreements Master account only\. You must set up organizational agreements beforehand\.   |  `artifact:AcceptAgreement` `artifact:DownloadAgreement` `artifact:TerminateAgreement` `organizations:DescribeOrganization`  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:AcceptAgreement",<br />                "artifact:DownloadAgreement",<br />                "artifact:TerminateAgreement"<br />            ],<br />            "Resource": [<br />                "arn:aws:artifact::*:customer-agreement/*",<br />                "arn:aws:artifact:::agreement/*"<br />            ]<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "organizations:DescribeOrganization"<br />            ],<br />            "Resource": "*"<br />        }<br />    ]<br />}</pre>  | 
|  Permissions to view organizational agreements  |  `artifact:DownloadAgreement` `organizations:DescribeOrganization`  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:DownloadAgreement"<br />            ],<br />            "Resource": [<br />                "arn:aws:artifact::*:customer-agreement/*",<br />                "arn:aws:artifact:::agreement/*"<br />            ]<br />        },<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "organizations:DescribeOrganization"<br />            ],<br />            "Resource": "*"<br />        }<br />    ]<br />}</pre>  | 
|  Permissions to view and download agreements  |  `artifact:DownloadAgreement`  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:DownloadAgreement"<br />            ],<br />            "Resource": [<br />                "arn:aws:artifact::*:customer-agreement/*",<br />                "arn:aws:artifact:::agreement/*"<br />            ]<br />        }<br />    ]<br />}</pre>  | 
|  Permissions for a user to manage the agreements of a single account  |  `artifact:AcceptAgreement` `artifact:DownloadAgreement` `artifact:TerminateAgreement`  |  <pre>{<br />    "Version": "2012-10-17",<br />    "Statement": [<br />        {<br />            "Effect": "Allow",<br />            "Action": [<br />                "artifact:AcceptAgreement",<br />                "artifact:TerminateAgreement",<br />                "artifact:DownloadAgreement"<br />            ],<br />            "Resource": [<br />                "arn:aws:artifact::*:customer-agreement/*",<br />                "arn:aws:artifact:::agreement/*"<br />            ]<br />        }<br />    ]<br />}</pre>  | <a name="create-iam-policy-proc"></a>

**To create an IAM policy**

Use the following procedure to create an IAM policy\. You can use your own, or you can use one of the policies from the previous tables\.

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Policies**\.

1. Choose **Create Policy**\.

1. Choose **Create Your Own Policy**\.

1. For **Policy Name**, type a unique name that helps you to remember what your policy is intended to do\.

1. For **Description**, type a description for your policy\.

1. For **Policy Document**, copy and paste one of the policy documents from the [Report Permissions](#report-permissions), [Agreement Permissions](#agreement-permissions), or [Common AWS Artifact IAM Policies](#common-policies) tables, or copy and paste the following policy to grant access to to just the AWS PCI, SOC, and ISO reports in AWS Artifact:

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Effect": "Allow",
               "Action": [
                   "artifact:Get"
               ],
               "Resource": [
                   "arn:aws:artifact:::report-package/Certifications and Attestations/SOC/*",
                   "arn:aws:artifact:::report-package/Certifications and Attestations/PCI/*",
                   "arn:aws:artifact:::report-package/Certifications and Attestations/ISO/*"
               ]
           }
       ]
   }
   ```

   To remove permissions for a specific type of report, remove the line with that report type\. For example, to remove the SOC reports, remove the following line:

   ```
   "arn:aws:artifact:::report-package/Certifications and Attestations/SOC/*",
   ```

1. Choose **Validate Policy**\. 

1. Choose **Create Policy**\.

Now that you have created your policy, you can attach the policy to a group\.

## Create an IAM Group<a name="create-iam-group"></a>

In the preceding procedure, you created a permissions policy\. You can attach the policy to a group and add other IAM users to the group at any time\. 

**To create an IAM group and attach your policy**

1. Use your AWS account email address and password to sign in as the *[AWS account root user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_root-user.html)* to the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane of the console, choose **Groups** and then choose **Create New Group**\.

1. For **Group Name**, type a name for your IAM group and then choose **Next Step**\.

1. In the search box, type the name of the policy that you created\.

1. In the policy list, select the check box for your policy\. Then choose **Next Step**\.

1. Review the group name and policies\. When you are ready to proceed, choose **Create Group**\.

Now that you have created your group and attached your policy to it, you can add a user to the group\.

## Create an IAM User and Add Them to a Group<a name="create-iam-user"></a>

In the preceding procedure, you created an IAM policy, created a group, and attached the policy to the group\. You can add IAM users to the group at any time\. 

**To create an IAM user and add the user to a group**

1. Use your AWS account email address and password to sign in as the *[AWS account root user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_root-user.html)* to the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.
**Note**  
We strongly recommend that you adhere to the best practice of using the **Administrator** IAM user below and securely lock away the root user credentials\. Sign in as the root user only to perform a few [account and service management tasks](https://docs.aws.amazon.com/general/latest/gr/aws_tasks-that-require-root.html)\.

1. In the navigation pane of the console, choose **Users** and then choose **Add user**\.

1. For **User name**, type the name for your user\.

1. Select the check box next to **AWS Management Console access**, select **Custom password**, and type the new user's password in the text box\. You can optionally select **Require password reset** to force the user to create a new password the next time the user signs in\.

1. Choose **Next: Permissions**\.

1. On the **Set permissions for user** page, choose **Add user to group**\.

1. In the list of groups, select the check box for your new group\. Choose **Refresh** if necessary to see the group in the list\.

1. Choose **Next: Review** to see the list of group memberships to be added to the new user\. When you are ready to proceed, choose **Create user**\.

Now that you have created your group, attached your policy to it, and added a user to the group, you can add more users or groups with different permissions using the same procedures\.