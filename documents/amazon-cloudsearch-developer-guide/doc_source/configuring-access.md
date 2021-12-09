# Configuring Access for Amazon CloudSearch<a name="configuring-access"></a>

You use AWS Identity and Access Management \(IAM\) access policies to control access to the Amazon CloudSearch configuration service and each search domain's document, search, and suggest services\. An IAM access policy is a JSON document that explicitly lists permissions that define what actions people or processes are allowed to perform\. For an introduction to IAM access policies, see [Overview of AWS IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/PoliciesOverview.html)\. 

You control access to the Amazon CloudSearch configuration service APIs and the domain services APIs independently\. For example, you might choose to restrict who can modify the configuration of your production domain, but allow team members to create and manage their own domains for development and testing\. Similarly, you might configure your development and test domains to accept anonymous requests to the upload, search, and suggest services, but lock down your production domain so that it accepts only authenticated requests from your application\. 

When AWS receives a request, it authenticates that the request is from a known AWS user, and then checks relevant policies to determine whether the user is authorized to perform the requested actions using the requested resources\. If a user has not been explicitly granted permission to perform an action, the request is denied\. During policy evaluation, if AWS encounters an explicit deny, the deny effect takes precedence over any explicit allow effects that are in force\.

**Important**  
To enable authentication, Amazon CloudSearch requests must be signed with an access key\. The only exception is if you allow anonymous access to a domain's upload, search, or suggest services\. For more information, see [Signing Requests](what-is-cloudsearch.md#signing-requests)\. 

**Topics**
+ [Writing Access Policies for Amazon CloudSearch](#cloudsearch-access-policies)
+ [Amazon CloudSearch Policy Examples](#policy-examples)
+ [Amazon CloudSearch console](#configuring-access-console)
+ [Configuring Access for Amazon CloudSearch with the AWS CLI](#configuring-access-clt)
+ [Configuring Access to a Domain's Endpoints Using the AWS SDKs](#configuring-access-sdk)

## Writing Access Policies for Amazon CloudSearch<a name="cloudsearch-access-policies"></a>

Amazon CloudSearch supports both *user\-based policies* and *resource\-based policies*:
+ **User\-based policies** are attached to a particular IAM user, group, or role\. A user\-based policy specifies which of your account's search domains a person or process can access and what actions they can perform\. To attach a user\-based policy to a user, group, or role, you use the IAM console, AWS CLI, or AWS SDKs\. **You must define user\-based policies to control access to the Amazon CloudSearch configuration service actions\.** \(The *user* in this context isn't necessarily a person, it's just an identity with associated permissions\. For example, you might create an IAM user to represent an application that needs to have credentials to submit search requests to your domain\.\)
+ **Resource\-based policies** for Amazon CloudSearch are attached to a particular search domain\. A resource\-based policy specifies who has access to the search domain and which domain services they can use\. Resource\-based policies control access only to a particular domain's document, search, and suggest services; they cannot be used to configure access to the Amazon CloudSearch configuration service actions\. To attach a resource\-based policy to a domain, you use the Amazon CloudSearch console, AWS CLI or AWS SDKs\. 

In general, we recommend managing access to Amazon CloudSearch APIs by configuring user\-based policies\. This enables you to manage all of your permissions in one place and any changes you need to make take effect almost immediately\. However, to allow public access to a domain's search service or restrict access based on IP addresses, you must configure a resource\-based policy for the domain\. \(We recommend replacing your old IP based access policies with user\-based policies at your earliest convenience\.\) You can also use resource\-based policies to easily allow other accounts to access a domain\. Keep in mind that processing changes to a domain's resource\-based policies takes significantly longer than applying changes to user\-based policies\.

You can use the [IAM Policy Generator](http://awspolicygen.s3.amazonaws.com/policygen.html) to write both user\-based and resource\-based policies for Amazon CloudSearch\. For more information, see [Managing IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingPolicies.html)\. 

**Tip**  
As a best practice, we recommend that you configure permissions for a group and assign IAM users to that group instead of defining permissions for individual users\. Similarly, you can assign permissions to roles for applications that run on Amazon EC2 instances rather than passing user credentials to each instance\. For more IAM recommendations for managing access to your AWS resources, see [IAM Best Practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/IAMBestPractices.html)\. 

### Contents of an Access Policy for Amazon CloudSearch<a name="access-policy-contents"></a>

You specify the following information in your access policies for Amazon CloudSearch:
+ `Version` specifies the policy language version that the statement is compatible with\. The version is always set to `2012-10-17`\.
+ `Resource` is the ARN \(Amazon Resource Name\) for the domain to which a user\-based policy applies\. `Resource` is not specified in resource\-based policies configured through the Amazon CloudSearch configuration service, because the policy is attached directly to the resource\. For more information about Amazon CloudSearch ARNs, see [Amazon CloudSearch ARNs](#cloudsearch-arns)\.
+ `Effect` specifies whether the statement authorizes or blocks access to the specified action\(s\)\. It must be `Allow` or `Deny`
+ `Sid` is an optional string that you can use to provide a descriptive name for the policy statement\.
+ `Action` specifies which Amazon CloudSearch actions the statement applies to\. For the supported actions, see [Amazon CloudSearch Actions](#cloudsearch-actions)\. You can use a wildcard \(\*\) as the action to configure access for all actions when you need to grant administrative access to select users\. \(In this case, you might also want to enable multi\-factor authorization for additional security\. For more information, see [Configuring MFA\-Protected API Access](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingMFA.html)\.\) Wildcards are also supported within action names\. For example, `"Action":["cloudsearch:Describe*]` matches all of the configuration service `Describe` actions, such as `DescribeDomains` and `DescribeServiceAccessPolicies`\.
+ `Condition` specifies conditions for when the policy is in effect\. When configuring anonymous, IP\-based access, you would specify the IP addresses that the access rule applies to, for example `"IpAddress": {"aws:SourceIp": ["192.0.2.0/32"]}`\.
+ `Principal` specifies who is allowed access to the domain in a resource\-based policy\. `Principal` is not specified in user\-based policies configured through IAM\. The `Principal` value for a resource\-based policy can specify other AWS accounts or IAM users in your own account\. For example, to grant access to the account 555555555555, you would specify `"Principal":{"AWS":["arn:aws:iam::555555555555:root"]}`\. Specifying a wildcard \(\*\) enables anonymous access to the domain\. Anonymous access is not recommended\. If you enable anonymous access, you should at least specify a condition to restrict which IP addresses can submit requests to the domain\. For more information, see [Granting Access to a Domain from Selected IP Addresses](#ip-based-policy)\.

For examples of access policies for Amazon CloudSearch, see [Amazon CloudSearch Policy Examples](#policy-examples)\.

#### Amazon CloudSearch ARNs<a name="cloudsearch-arns"></a>

A policy's Amazon Resource Name \(ARN\) uniquely specifies the domain that the policy applies to\. The ARN is a standard format that AWS uses to identify resources\. The 12\-digit number in the ARN is your AWS account ID\. Amazon CloudSearch ARNs are of the form `arn:aws:cloudsearch:REGION:ACCOUNT-ID:domain/DOMAIN-NAME`\. 

The following list describes the variable elements in the ARN:
+ `REGION` is the AWS region where the Amazon CloudSearch domain for which you are configuring permissions resides\. You can use a wildcard \(\*\) for the `REGION` for all regions\. 
+ `ACCOUNT-ID` is your AWS account ID with no hyphens; for example, 111122223333\. 
+ `DOMAIN-NAME` identifies a specific search domain\. You can use a wildcard \(\*\) for the `DOMAIN-NAME` for all of your account's domains in the specified region\. If you have multiple domains whose names start with the same prefix, you can use a wildcard to match all of those domains\. For example, `dev-*` matches `dev-test`, `dev-movies`, `dev-sandbox`, and so on\. Note that if you name new domains with the same prefix, the policy also applies to those new domains\.

For example, the following ARN identifies the `movies` domain in the `us-east-1` region owned by account 111122223333:

```
arn:aws:cloudsearch:us-east-1:111122223333:domain/movies
```

The following example shows how the ARN is used to specify the resource in a user\-based policy\.

```
{
  "Version":"2012-10-17",           
  "Statement": [
    {
      "Effect": "Allow",
      "Action": ["cloudsearch:search"],
      "Resource": "arn:aws:cloudsearch:us-east-1:111122223333:domain/movies"
    }
  ]
}
```

A domain's ARN is displayed on the domain dashboard in the Amazon CloudSearch console and is also available by calling `DescribeDomains`\.

**Important**  
When specifying an ARN for a domain created with the 2011\-02\-01 API, you must use the former Amazon CloudSearch service name, `cs`\. For example, `arn:aws:cs:us-east-1:111122223333:domain/movies`\. If you need to define policies that configure access for both 2011 and 2013 domains, make sure to specify the correct ARN format for each domain\. For more information, see [Configuration Service Access Policies Not Working](troubleshooting.md#troubleshooting-configuration-access-policies)\.

#### Amazon CloudSearch Actions<a name="cloudsearch-actions"></a>

The actions you specify control which Amazon CloudSearch APIs the statement applies to\. All Amazon CloudSearch actions are prefixed with `cloudsearch:`, such as `cloudsearch:search`\. The following list shows the supported actions: 
+ `cloudsearch:document` allows access to the document service API\. Permission to use the `document` action is required to upload documents to a search domain for indexing\.
+ `cloudsearch:search` allows access to the search API\. Permission to use the `search` action is required to submit search requests to a domain\.
+ `cloudsearch:suggest` allows access to the suggest API\. Permission to use the `suggest` action is required to get suggestions from a domain\.
+ `cloudsearch:CONFIGURATION-ACTION` allows access to the specified configuration service action\. Permission to use the `DescribeDomains` and `ListDomainNames` configuration actions is required to access the Amazon CloudSearch console\. Configuration actions can be specified only in user\-based policies\. For the complete list of actions, see [Actions](API_Operations.md)\. 

## Amazon CloudSearch Policy Examples<a name="policy-examples"></a>

This section presents a few examples of Amazon CloudSearch access policies\. 

**Topics**
+ [Granting Read\-only Access to the Amazon CloudSearch Configuration Service](#read-only-configuration-policy)
+ [Granting Access to All Amazon CloudSearch Configuration Service Actions](#full-configuration-policy)
+ [Granting Unrestricted Access to All Amazon CloudSearch Services](#universal-policy)
+ [Granting Permission to Upload Documents to an Amazon CloudSearch Domain](#document-upload-policy)
+ [Granting Amazon CloudSearch Access to Another AWS Account](#cross-account-policy)
+ [Granting Access to an Amazon CloudSearch Domain from Selected IP Addresses](#ip-based-policy)
+ [Granting Public Access to an Amazon CloudSearch Domain's Search Service](#public-access-policy)

### Granting Read\-only Access to the Amazon CloudSearch Configuration Service<a name="read-only-configuration-policy"></a>

You can grant read\-only access to the configuration service by allowing only the following actions\. This might be useful if you want to allow users to view the configuration of a production domain without being able to make changes\.
+ `cloudsearch:DescribeAnalysisSchemes`
+ `cloudsearch:DescribeAvailabilityOptions`
+ `cloudsearch:DescribeDomains`
+ `cloudsearch:DescribeExpressions`
+ `cloudsearch:DescribeIndexFields`
+ `cloudsearch:DescribeScalingParameters`
+ `cloudsearch:DescribeServiceAccessPolicies`
+ `cloudsearch:DescribeSuggesters`
+ `cloudsearch:ListDomainNames`

The following user\-based policy grants read\-only access to the configuration service for a `movies` domain owned by the account 555555555555\. The policy uses wildcards for the actions, since it grants access to all actions that begin with *Describe* or *List*\. Note that this will also grant access to any describe or list actions that might be added to the API in the future\.

```
{
  "Version":"2012-10-17",           
  "Statement": [
    {
      "Effect": "Allow",
      "Action": ["cloudsearch:Describe*", 
                 "cloudsearch:List*"],
      "Resource": "arn:aws:cloudsearch:us-east-1:555555555555:domain/movies"
    }
  ]
}
```

### Granting Access to All Amazon CloudSearch Configuration Service Actions<a name="full-configuration-policy"></a>

You can grant access to all Amazon CloudSearch configuration service actions by including an `Allow` statement that grants access to all configuration service actions, but not the domain services actions\. This enables you to grant administrative access without authorizing a user to upload or retrieve data from a domain\. One way to do this is to use a wildcard to grant access to all Amazon CloudSearch actions, and then include a deny statement that blocks access to the domain services actions\. The following user\-based policy grants access to the configuration service for all domains owned by the 111122223333 account in the `us-west-2` region\. 

```
{
  "Version":"2012-10-17",           
  "Statement": [
    {
      "Effect": "Allow",
      "Action": ["cloudsearch:*"],
      "Resource": "arn:aws:cloudsearch:us-west-2:111122223333:domain/*"
    },
    {
      "Effect": "Deny",
      "Action": ["cloudsearch:document", 
                 "cloudsearch:search", 
                 "cloudsearch:suggest"],
      "Resource": "arn:aws:cloudsearch:us-west-2:111122223333:domain/*"
    }
  ]  
}
```

### Granting Unrestricted Access to All Amazon CloudSearch Services<a name="universal-policy"></a>

You can grant unrestricted access to all Amazon CloudSearch services, including all configuration service actions and all domain services with a user\-based policy\. To do this, you specify wildcards for the actions, region, and domain name\. The following policy enables the user to access all Amazon CloudSearch actions for any domain in any region that's owned by the 111122223333 account\. 

**Note**  
We recommend that when you give highly privileged access to IAM users, as illustrated in this policy, that you also enable multi\-factor authorization \(MFA\) for those users\. For more information, see [IAM Best Practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/IAMBestPractices.html) in the IAM User guide\.

```
{
  "Version":"2012-10-17",           
  "Statement": [
    {
      "Effect": "Allow",
      "Action": ["cloudsearch:*"],
      "Resource": "arn:aws:cloudsearch:*:111122223333:domain/*"
    }
  ]
}
```

### Granting Permission to Upload Documents to an Amazon CloudSearch Domain<a name="document-upload-policy"></a>

You can grant an IAM user permission to upload documents to a search domain by specifying the `cloudsearch:document` action\. For example, the following user\-based policy enables the user to upload documents to the `movies` domain in `us-east-1` owned by the 111122223333 account\. 

```
{
  "Version":"2012-10-17",           
  "Statement": [
    {
      "Effect": "Allow",
      "Action": ["cloudsearch:document"],
      "Resource": "arn:aws:cloudsearch:us-east-1:111122223333:domain/movies"
    }
  ]
}
```

### Granting Amazon CloudSearch Access to Another AWS Account<a name="cross-account-policy"></a>

You have two options to configure cross\-account access for a CloudSearch domain:


****  

| Option | Description | 
| --- | --- | 
| Configure an IAM role for cross\-account access\. | Increased security, but requires complex request signing\. For more information, see [Cross\-Account API Access Using IAM Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/cross-acct-access.html) in the IAM documentation\. | 
| Attach a resource\-based policy to the CloudSearch domain and attach a user\-based managed policy to an IAM role\. | Easier to implement\. For more information, see [Creating a Role to Delegate Permissions to an IAM User](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user.html) and [Walkthrough: Delegating Access Across AWS Accounts For Accounts You Own Using IAM Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/walkthru_cross-account-with-roles.html) in the IAM documentation\. | 

This topic provides an example of the second option, adding a resource\-based policy to the CloudSearch domain\. Assume that account \#1 is owned by account id `111111111111` and account \#2 is owned by account id `999999999999`\. Account \#1 wants to grant access to account \#2 to use the search service for the `movies` domain, which requires two steps:

1. Account \#1 attaches a resource\-based policy to the domain using the Amazon CloudSearch console that grants access to account \#2\.

   ```
   {
     "Version":"2012-10-17",
     "Statement":[
       {
         "Sid":"search_only",
         "Effect":"Allow",
         "Action":["cloudsearch:search"],
         "Principal":{"AWS":["arn:aws:iam::999999999999:root"]}
       }
     ]
   }
   ```

1. Account \#2 attaches a user\-based managed policy to an IAM role owned by that account using the IAM console\.

   ```
   {
     "Version":"2012-10-17",           
     "Statement": [
       {
         "Effect": "Allow",
         "Action": ["cloudsearch:search"],
         "Resource": "arn:aws:cloudsearch:us-east-1:111111111111:domain/movies"
       }
     ]
   }
   ```

**Important**  
To configure resource\-based policies for Amazon CloudSearch, you must have permission to use the `cloudsearch:UpdateServiceAccessPolicies` action\.

### Granting Access to an Amazon CloudSearch Domain from Selected IP Addresses<a name="ip-based-policy"></a>

 Resource\-based access policies set through the Amazon CloudSearch configuration service support anonymous access, which enables you to submit unsigned requests to a search domain's services\. To allow anonymous access from selected IP addresses, use a wildcard for the `Principal` value and specify the allowed IP addresses as a `Condition` element in the policy\.

**Important**  
Allowing anonymous access from selected IP addresses is inherently less secure than requiring user credentials to access your search domains\. We recommend against allowing anonymous access even if it is permitted only from select IP addresses\. If you currently allow anonymous access, you should upgrade your applications to submit signed requests and control access by configuring user\-based or resource\-based policies\.

If you are creating a resource\-based policy that grants access to requests coming from an Amazon EC2 instance, you need to specify the instance's public IP address\. 

IP addresses are specified in the standard Classless Inter\-Domain Routing \(CIDR\) format\. For example 10\.24\.34\.0/24 specifies the range 10\.24\.34\.0 \- 10\.24\.34\.255, while 10\.24\.34\.0/32 specifies the single IP address 10\.24\.34\.0\. For more information about CIDR notation, see [RFC 4632](http://www.rfc-editor.org/rfc/rfc4632.txt)\. 

For example, the following policy grants access to the search action for the `movies` domain owned by AWS account 111122223333 from the IP address 192\.0\.2\.0/32\.

```
{
  "Version":"2012-10-17",
  "Statement":[
    {
      "Sid":"search_only",
      "Effect":"Allow",
      "Principal":"*",
      "Action":["cloudsearch:search"],
      "Condition":{"IpAddress":{"aws:SourceIp":"192.0.2.0/32"}}
    }
  ]
}
```

### Granting Public Access to an Amazon CloudSearch Domain's Search Service<a name="public-access-policy"></a>

 If you need to allow public access to your domain's search endpoint, you can configure a resource\-based policy with no conditions\. This enables unsigned requests to be sent from any IP address\. 

**Important**  
Allowing public access to a search domain means you have no control over the volume of requests submitted to the domain\. Malicious users could flood the domain with requests, impacting legitimate users as well as your operating costs\.

For example, the following policy grants public access to the search action for the `movies` domain owned by AWS account 111122223333\.

```
{
  "Version":"2012-10-17",
  "Statement":[
    {
      "Sid":"public_search",
      "Effect":"Allow",
      "Principal":"*",
      "Action":["cloudsearch:search"]
    }
  ]
}
```

## Configuring Access for Amazon CloudSearch Using the AWS Management Console<a name="configuring-access-console"></a>

**To configure user\-based policies**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Configure Amazon CloudSearch permissions by attaching a policy to a user, group, or role\. For more information, see [Managing Policies \(AWS Management Console\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingPolicies.html#AddingPermissions_Console)\. For more information about user\-based policies for Amazon CloudSearch see [Writing Access Policies for Amazon CloudSearch](#cloudsearch-access-policies)\.

**To configure resource\-based policies**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain you want to configure, and then click the domain's **Access Policies** link\.

1. In the domain's **Access Policies** pane, choose one of the shortcuts or enter the IP addresses you want to authorize or block\. To add additional IP addresses or address ranges to the rule, click the add \(\+\) icon in the **IP Ranges** column\. To remove an address or range from the rule, click its delete \(\-\) icon in the **IP Ranges** column\. To add a new rule to the policy, click the **Add a New Rule** button\. To remove a rule from the policy, click the remove \(x\) button in the **Remove** column\.

1. When you are done making changes to your access rules, click **Submit**\. To exit without saving your changes, click **Revert**\.

The Amazon CloudSearch console enables you to easily add access rules to authorize or block particular IP addresses or address ranges\. However, resource\-based policies are not restricted to IP\-based policies\. You can use the AWS CLI or AWS SDKs to configure resource\-based policies that grant access to particular IAM users or AWS accounts\. 

The console provides five shortcuts for specifying access rules: 
+ **Search and Suggester service: Allow all\. Document Service: Account owner only**—this recommended default enables anyone to search your data and get suggestions, but only you can add and delete documents\. Your domain's search endpoint allows anonymous access from any IP address, but only you have access to the document endpoint\.
+ **Only my IP address**—only requests originating from your IP address can search your data and add and delete documents\. These rules can be useful for testing\.
+ **Allow everyone access to all services**—*anyone* can search your data and add and delete documents\. Your domain's endpoints allow anonymous access from any IP address\.
+ **Deny everyone access to all services**—search and document requests must either be submitted through the console or authenticated with your account credentials\. The document and search endpoints do not allow anonymous access or accept requests from other AWS users\.
+ **Copy access policy from another domain**—copy the access policies configured for another of your search domains\. \(This shortcut is only visible if you have more than one domain\.\)

You can start with one of the shortcuts, and add additional rules to fine\-tune access to your domain's endpoints\. Deny rules take precedence over Allow rules\.

Updating resource\-based access policies takes some time to complete\. The state of a domain's policies is displayed on the **Access Policies** pane\. Once the policy has been applied, the state changes from `PROCESSING` to `ACTIVE`\.

## Configuring Access for Amazon CloudSearch with the AWS CLI<a name="configuring-access-clt"></a>

You can configure both user\-based policies and resource\-based policies for Amazon CloudSearch with the AWS CLI\. For information about installing and setting up the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

**To configure user\-based policies**
+ Configure Amazon CloudSearch permissions by attaching a policy to a user, group, or role with the `aws put-user-policy`, `aws put-group-policy`, or `aws put-role-policy` command\. For more information, see [Managing Policies \(AWS Management Console\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingPolicies.html#AddingPermissions_Console)\. For more information about user\-based policies for Amazon CloudSearch see [Writing Access Policies for Amazon CloudSearch](#cloudsearch-access-policies)\.

**To configure resource\-based policies**
+ Run the `aws cloudsearch update-service-access-policies` command and specify an access policy with the `--access-policies` option\. The access policy must be enclosed in quotes and all quotes within the access policy must be escaped with a backslash\. For more information about resource\-based policies for Amazon CloudSearch see [Writing Access Policies for Amazon CloudSearch](#cloudsearch-access-policies)\.

  The following example configures the `movies` domain to accept search requests from the IP address `192.0.2.0`\. 

  ```
  aws cloudsearch update-service-access-policies --domain-name movies 
  --access-policies "{\"Version\":\"2012-10-17\",\"Statement\":[{
    \"Sid\":\"search_only\",
    \"Effect\":\"Allow\",
    \"Principal\": \"*\",
    \"Action\":\"cloudsearch:search\",
    \"Condition\":{\"IpAddress\":{\"aws:SourceIp\":\"192.0.2.0/32\"}}}
  ]}"
  {
    "AccessPolicies": {
      "Status": {
        "PendingDeletion": false, 
        "State": "Processing", 
        "CreationDate": "2014-04-30T22:07:30Z", 
        "UpdateVersion": 9, 
        "UpdateDate": "2014-04-30T22:07:30Z"
      }, 
      "Options":  
        "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Sid\":\"\",
          \"Effect\":\"Allow\",\"Principal\":\"*\",
          \"Action\":\"cloudsearch:search\",
          \"Condition\":{\"IpAddress\":{\"aws:SourceIp\":
          \"192.0.2.0/32\"}}}]}"
      }
  }
  ```

Updating resource\-based access policies takes some time to complete\. You can check the state of the policy with the `aws cloudsearch describe-service-access-policies` command\. Once the policy has been applied, the state of the policy changes to `Active`\.

You can retrieve your domain's policies using the `aws cloudsearch describe-service-access-policies` command\. 

## Configuring Access to a Domain's Endpoints Using the AWS SDKs<a name="configuring-access-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[UpdateServiceAccessPolicies](API_UpdateServiceAccessPolicies.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.