# Tagging Amazon Forecast Resources<a name="tagging-forecast-resources"></a>

A *tag* is a label that you optionally define and associate with AWS resources, including certain types of Amazon Forecast resources\. Tags can help you categorize and manage resources in different ways, such as by purpose, owner, environment, or other criteria\. For example, you can use tags to apply policies or automation, or to identify resources that are subject to certain compliance requirements\. You can add tags to the following types of Forecast resources: 
+ Dataset groups
+ Datasets
+ Dataset import jobs
+ Predictors
+ Forecasts
+ Forecast export jobs

A resource can have as many as 50 tags\.

## Managing Tags<a name="forecast-managing-tags"></a>

Each tag consists of a required tag key and an optional tag value, both of which you define\. A tag key is a general label that acts as a category for more specific tag values\. A tag value acts as a descriptor for a tag key\. For example, if you have two versions of a Forecast dataset import job \(one for internal testing and another for production\), you might assign an `Environment` tag key to both projects\. The value of the `Environment` tag key might be `Test` for one version of the dataset import job and `Production` for the other version\.

A tag key can contain as many as 128 characters\. A tag value can contain as many as 256 characters\. The characters can be Unicode letters, numbers, white space, or one of the following symbols: \_ \. : / = \+ \-\. The following additional restrictions apply to tags:
+ Tag keys and values are case sensitive\.
+ For each associated resource, each tag key must be unique and it can have only one value\.
+ Do not use `aws:`, `AWS:`, or any upper or lowercase combination of such as a prefix for keys, because it is reserved for AWS use\. You cannot edit or delete tag keys with this prefix\. Values can have this prefix\. If a tag value has `aws` as its prefix but the key does not, then Forecast considers it to be a user tag and will count against the limit of 50 tags\. Tags with only the key prefix of `aws` do not count against your tags per resource limit\.
+ You can't update or delete a resource based only on its tags\. You must also specify the Amazon Resource Name \(ARN\) or resource ID, depending on the operation that you use\.
+ You can associate tags with public or shared resources\. However, the tags are available only for your AWS account, not any other accounts that share the resource\. In addition, the tags are available only for resources that are located in the specified AWS Region for your AWS account\.

To add, display, update, and remove tag keys and values from Forecast resources, you can use the AWS Command Line Interface \(AWS CLI\), the Forecast API, or an AWS SDK\.

## Using Tags in IAM Policies<a name="tags-iam"></a>

After you start implementing tags, you can apply tag\-based, resource\-level permissions to AWS Identity and Access Management \(IAM\) policies and API operations\. This includes operations that support adding tags to resources when resources are created\. By using tags in this way, you can implement granular control of which groups and users in your AWS account have permission to create and tag resources, and which groups and users have permission to create, update, and remove tags more generally\.

For example, you can create a policy that allows a user to have full access to all of the Forecast resources where their name is a value in the `Owner` tag for the resource\.

```
{
   "Version": "2012-10-17",
   "Statement": [
      {
         "Sid": "ModifyResourceIfOwner",
         "Effect": "Allow",
         "Action": "forecast:*",
         "Resource": "*",
         "Condition": {
            "StringEqualsIgnoreCase": {
               "aws:ResourceTag/Owner": "${aws:username}"
            }
         }
      }
   ]
}
```

The following example shows how to create a policy to allow creating and deleting a dataset\. These operations are allowed only if the user name is `johndoe`\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "forecast:CreateDataset",
                "forecast:DeleteDataset"
            ],
            "Resource": "arn:aws:forecast:*:*:dataset/*",
            "Condition": {
                "StringEquals": {"aws:username" : "johndoe"}
            }
        },
        {
            "Effect": "Allow",
            "Action": "forecast:DescribeDataset",
            "Resource": "*"
        }
    ]
}
```

If you define tag\-based, resource\-level permissions, the permissions take effect immediately\. This means that your resources are more secure as soon as they're created, and you can quickly start enforcing the use of tags for new resources\. You can also use resource\-level permissions to control which tag keys and values can be associated with new and existing resources\. For more information, see [Controlling Access Using Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_tags.html) in the *AWS IAM User Guide*\.

## Adding Tags to Resources<a name="tags-add"></a>

The following examples show how to add a tag to Forecast resources by using the [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/) and the AWS Management Console\.

------
#### [ AWS CLI ]

To create a new resource and add a tag to it by using the AWS CLI, use the appropriate `create` command for the resource\. Include the `tags` parameter and values\. For example, the following command creates a new dataset named `myDataSet` and adds an `Environment` tag key with a `Test` tag value to the dataset\. In this example, the `schema` is defined in a file called *schema\.json* in the same directory where you are running the command\.

```
C:\> aws forecast create-dataset --dataset-name=myDataSet --dataset-type=RELATED_TIME_SERIES --domain=RETAIL --schema=file://schema.json --tags={Environment=Test}
```

For information about the commands that you can use to create a Forecast resource, see the [Forecast AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/forecast/)\.

To add a tag to an existing resource, use the `tag-resource` command and specify the appropriate values for the required parameters:

```
C:\> aws forecast tag-resource --resource-arn resource-arn --tags-model tags={key=value}
```

Where:
+ *resource\-arn* is the Amazon Resource Name \(ARN\) of the resource that you want to add a tag to\.
+ *key* is the tag key that you want to add to the resource\. The `key` argument is required\.
+ *value* is the optional tag value that you want to add for the specified tag key \(`key`\)\. The `value` argument is required\. If you don’t want the resource to have a specific tag value, don’t specify a value for the `value` argument\. Forecast sets the value to an empty string\.

------
#### [ AWS Management Console ]

When you create a resource in Forecast, you can add optional tags\. The following example adds a tag to a dataset group\.

**To add tags to a new dataset group**

1. Sign in to the AWS Management Console and open the Amazon Forecast console at [https://console\.aws\.amazon\.com/forecast/](https://console.aws.amazon.com/forecast/)\.

1. Choose **Create dataset group**\.

1. For **Dataset group name**, enter a name\.

1.  For **Forecasting domain**, choose a domain\.

1. Choose **Add new tag**\.

1. For **Key** and **Value**, enter appropriate values\.

   For example, **Environment** and **Test**, respectively\.

1. To add more tags, choose **Add new tag**\.

   You can add up to 50 tags to a resource\.

1. Choose **Next** to continue creating your resource\.

------

## Additional Information<a name="tagging-additional-resources-information"></a>

For more information about tagging, see the following resources\.
+ [AWS Tagging Principles](https://docs.aws.amazon.com/general/latest/gr/aws_tagging.html) in the *AWS General Reference*
+ [AWS Tagging Strategies](https://d1.awsstatic.com/whitepapers/aws-tagging-best-practices.pdf) \(downloadable PDF\)
+ [AWS Access Control](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_tags.html) in the *AWS IAM User Guide*
+ [AWS Tagging Policies](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_introduction.html) in the *AWS Organizations User Guide*