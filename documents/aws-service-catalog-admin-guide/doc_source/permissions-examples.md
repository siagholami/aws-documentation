# Example Policies for Managing Provisioned Products<a name="permissions-examples"></a>

You can create custom policies to help meet the security requirements of your organization\. The following examples describe how to customize the access level for each action with support for user, role, and account levels\. You can grant users access to view, update, terminate, and manage provisioned products created only by that user or created by others also under their role or the account to which they are logged in\. This access is hierarchical — granting account level access also grants role level access and user level access, while adding role level access also grants user level access but not account level access\. You can specify these in the policy JSON using a `Condition` block as `accountLevel`, `roleLevel`, or `userLevel`\.

These examples also apply to access levels for AWS Service Catalog API write operations `UpdateProvisionedProduct` and `TerminateProvisionedProduct`, and read operations `DescribeRecord`, `ScanProvisionedProducts`, and `ListRecordHistory`\. The `ScanProvisionedProducts` and `ListRecordHistory` API operations use `AccessLevelFilterKey` as input, and that key's values correspond to the `Condition` block levels discussed here \(`accountLevel` is equivalent to an `AccessLevelFilterKey` value of "Account", `roleLevel` to "Role", and `userLevel` to "User"\)\. For more information, see the [AWS Service Catalog Developer Guide](https://docs.aws.amazon.com/servicecatalog/latest/dg/)\.

**Topics**
+ [Example: Full Admin Access to Provisioned Products](#permissions-examples-full-admin)
+ [Example: End\-user Access to Provisioned Products](#permissions-examples-end-user)
+ [Example: Partial Admin Access to Provisioned Products](#permissions-examples-partial-admin)

## Example: Full Admin Access to Provisioned Products<a name="permissions-examples-full-admin"></a>

The following policy allows full read and write access to provisioned products and records within the catalog at the account level\. 

```
{  
   "Version":"2012-10-17",
   "Statement":[  
      {  
         "Effect":"Allow",
         "Action":[  
            "servicecatalog:*"
         ],
         "Resource":"*",
         "Condition": {
            "StringEquals": {
               "servicecatalog:accountLevel": "self"
            }
         }
      }
   ]
}
```

This policy is functionally equivalent to the following policy:

```
{  
   "Version":"2012-10-17",
   "Statement":[  
      {  
         "Effect":"Allow",
         "Action":[  
            "servicecatalog:*"
         ],
         "Resource":"*"
      }
   ]
}
```

In other words, not specifying a `Condition` block in any policy for AWS Service Catalog is treated as the same as specifying `"servicecatalog:accountLevel"` access\. Note that `accountLevel` access includes `roleLevel` and `userLevel` access\.

## Example: End\-user Access to Provisioned Products<a name="permissions-examples-end-user"></a>

The following policy restricts access to read and write operations to only the provisioned products or associated records that the current user created\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "servicecatalog:DescribeProduct",
                "servicecatalog:DescribeProductView",
                "servicecatalog:DescribeProvisioningParameters",
                "servicecatalog:DescribeRecord",
                "servicecatalog:ListLaunchPaths",
                "servicecatalog:ListRecordHistory",
                "servicecatalog:ProvisionProduct",
                "servicecatalog:ScanProvisionedProducts",
                "servicecatalog:SearchProducts",
                "servicecatalog:TerminateProvisionedProduct",
                "servicecatalog:UpdateProvisionedProduct"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "servicecatalog:userLevel": "self"
                }
            }
        }
    ]
 }
```

## Example: Partial Admin Access to Provisioned Products<a name="permissions-examples-partial-admin"></a>

The two policies below, if both applied to the same user, allow what might be called a type of "partial admin access" by providing full read\-only access and limited write access\. This means the user can see any provisioned product or associated record within the catalog's account but cannot perform any actions on any provisioned products or records that aren't owned by that user\. 

The first policy allows the user access to write operations on the provisioned products that the current user created, but no provisioned products created by others\. The second policy adds full access to read operations on provisioned products created by all \(user, role, or account\)\. 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "servicecatalog:DescribeProduct",
                "servicecatalog:DescribeProductView",
                "servicecatalog:DescribeProvisioningParameters",
                "servicecatalog:ListLaunchPaths",
                "servicecatalog:ProvisionProduct",
                "servicecatalog:SearchProducts",
                "servicecatalog:TerminateProvisionedProduct",
                "servicecatalog:UpdateProvisionedProduct"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "servicecatalog:userLevel": "self"
                }
            }
        }
    ]
 }
```

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "servicecatalog:DescribeRecord",
                "servicecatalog:ListRecordHistory",
                "servicecatalog:ScanProvisionedProducts"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "servicecatalog:accountLevel": "self"
                }
            }
        }
    ]
 }
```