# Setting Up SAML<a name="external-identity-providers-setting-up-saml"></a>

You can use an AWS Identity and Access Management \(IAM\) role and a relay state URL to configure an identity provider \(IdP\) that is compliant with SAML 2\.0\. The role grants users permissions to access Amazon QuickSight\. The relay state is the portal that the user is forwarded to, after successful authentication by AWS\.

**Topics**
+ [Prerequisites](#external-identity-providers-setting-up-prerequisites)
+ [Step 1: Create a SAML Provider in AWS](#external-identity-providers-create-saml-provider)
+ [Step 2: Configure Permissions in AWS for Your Federated Users](#external-identity-providers-grantperms)
+ [Step 3: Configure the SAML IdP](#external-identity-providers-config-idp)
+ [Step 4: Create Assertions for the SAML Authentication Response](#external-identity-providers-create-assertions)
+ [Step 5: Configure the Relay State of Your Federation](#external-identity-providers-relay-state)

## Prerequisites<a name="external-identity-providers-setting-up-prerequisites"></a>

Before configuring your SAML 2\.0 connection, do the following:
+ Configure your IdP to establish a trust relationship with AWS: 
  + Inside your organization's network, configure your identity store, such as Windows Active Directory, to work with a SAML\-based IdP\. SAML\-based IdPs include Microsoft Windows Active Directory Federation Services, Shibboleth, and so on\.
  + Using your IdP, generate a metadata document that describes your organization as an identity provider\.
  + Set up SAML 2\.0 authentication, using the same steps as for the AWS Management Console\. When this process is complete, you can configure your relay state to match the relay state of Amazon QuickSight \(See [Step 5: Configure the Relay State of Your Federation](#external-identity-providers-relay-state)\)\. 
+ Create an Amazon QuickSight account and note the name to use when you configure your IAM policy and IdP\. For more information on creating an Amazon QuickSight account, see [Signing Up for Amazon QuickSight](signing-up.md)\.

After you create the setup to federate to the AWS Management Console as outlined in the tutorial, you can edit the relay state provided in the tutorial\. You do so with the relay state of Amazon QuickSight, described in step 5 following\. For more information about integrating with your IdP or using SSO in AWS, see [Integrating Third\-Party SAML Solution Providers with AWS](https://docs.aws.amazon.com/singlesignon/latest/userguide/) in the *IAM User Guide*\. 

## Step 1: Create a SAML Provider in AWS<a name="external-identity-providers-create-saml-provider"></a>

Your SAML identity provider defines your organization's IdP to AWS\. It does so by using the metadata document you previously generated using your IdP\. 

**To create a SAML provider in AWS**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Create a new SAML provider, which is an entity in IAM that holds information about your organization's identity provider\. For more information, see [Creating SAML Identity Providers](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_create_saml.html) in the *IAM User Guide*\. 

1. As part of this process, upload the metadata document produced by the IdP software in your organization noted in the previous section\. 

## Step 2: Configure Permissions in AWS for Your Federated Users<a name="external-identity-providers-grantperms"></a>

Next, create an IAM role that establishes a trust relationship between IAM and your organization's IdP\. This role identifies your IdP as a principal \(trusted entity\) for the purposes of federation\. The role also defines which users authenticated by your organization's IdP are allowed to access Amazon QuickSight\. For more information about creating a role for a SAML IdP, review [Creating a Role for SAML 2\.0 Federation](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-idp_saml.html) in the *IAM User Guide*\.

After you have created the role, you can limit the role to have permissions only to Amazon QuickSight by attaching an inline policy to the role\. The following sample policy document provides access to Amazon QuickSight\. This policy allows the user access to Amazon QuickSight and allows them to create both author accounts and reader accounts\.

**Note**  
In the following example, replace *<YOUR\_AWS\_ACCOUNT\_ID>* with your 12\-digit AWS account ID \(with no hyphens ‘‐’\)\.

```
{
    "Statement": [
        {
            "Action": [
                "quicksight:CreateUser"
            ],
            "Effect": "Allow",
            "Resource": [
                "arn:aws:quicksight::<YOUR_AWS_ACCOUNT_ID>:user/${aws:userid}"
            ]
        }
    ],
    "Version": "2012-10-17"
}
```

If you want to provide access to Amazon QuickSight and also the ability to create Amazon QuickSight admins, authors \(standard users\), and readers, you can use the following policy example\. 

```
{
    "Statement": [
        {
            "Action": [
                "quicksight:CreateAdmin"
            ],
            "Effect": "Allow",
            "Resource": [
                "arn:aws:quicksight::<YOUR_AWS_ACCOUNT_ID>:user/${aws:userid}"
            ]
        }
    ],
    "Version": "2012-10-17"
}
```

You can view account details in the AWS Management Console\.

Once you have set up SAML and the IAM policy or policies, you don't need to invite users manually\. The first time that users open Amazon QuickSight, they are provisioned automatically, using the highest level permissions in the policy\. For example, if they have permissions to both `quicksight:CreateUser` and `quicksight:CreateReader`, they are provisioned as authors\. If they also have permissions to `quicksight:CreateAdmin`, they are provisioned as admins\. Each permission level includes the ability to create the same level user and below\. For example, an author can add other authors or readers\. 

Users who are invited manually are created in the role assigned by the person who invited them\. They don't need to have policies that grant them permissions\.

## Step 3: Configure the SAML IdP<a name="external-identity-providers-config-idp"></a>

After you create the IAM role, update your SAML IdP about AWS as a service provider\. To do so, install the `saml-metadata.xml` file found at [https://signin\.aws\.amazon\.com/static/saml\-metadata\.xml](https://signin.aws.amazon.com/static/saml-metadata.xml)\. 

To update the IdP metadata, see the instructions provided by your IdP\. Some providers give you the option to type the URL, after which the IdP gets and installs the file for you\. Others require you to download the file from the URL and then provide it as a local file\. 

For more information, see your IdP documentation\.  

## Step 4: Create Assertions for the SAML Authentication Response<a name="external-identity-providers-create-assertions"></a>

Next, configure the information that the IdP passes as SAML attributes to AWS as part of the authentication response\. For more information, see [Configuring SAML Assertions for the Authentication Response](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_create_saml_assertions.html) in the *IAM User Guide*\.

## Step 5: Configure the Relay State of Your Federation<a name="external-identity-providers-relay-state"></a>

Finally, you can configure the relay state of your federation to point to the Amazon QuickSight relay state URL\. After successful authentication by AWS, the user is directed to Amazon QuickSight, defined as the relay state in the SAML authentication response\.

The relay state URL for Amazon QuickSight is:

```
https://quicksight.aws.amazon.com
```