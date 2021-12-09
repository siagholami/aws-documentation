# Restricting access to a specific Amazon WorkDocs instance<a name="restrict_access"></a>

If you have multiple Amazon WorkDocs sites on an AWS account and you want to grant API access to a specific site, you can do so by defining a condition element\. The `Condition` element lets you specify conditions for when a policy is in effect\.

The following is an example of a condition element:

```
    "Condition": 
    {
                "StringEquals": {
                    "Resource.OrganizationId": "d-123456789c5"
                }
    }
```

With the above condition in place in a policy, users are allowed to access only the Amazon WorkDocs instance with Id `d-123456789c5`\. Amazon WorkDocs Instance Id is sometimes referred as Organization Id or Directory Id\.

An Organization ID is also referred to as a Directory ID or an Instance ID\. It can be used to restrict access to one or more Amazon WorkDocs sites on an account\. For more information, see [Restricting access to a specific Amazon WorkDocs instance](#restrict_access)\.

You can get a Amazon WorkDocs organization ID from the AWS console using the following steps:

**To get an organization ID**

1. In the [AWS Directory Service console](https://console.aws.amazon.com/directoryservicev2/) navigation pane, select **Directories**\.

1. The **Directory ID** corresponding to your Amazon WorkDocs site is the Organization ID for that site\.