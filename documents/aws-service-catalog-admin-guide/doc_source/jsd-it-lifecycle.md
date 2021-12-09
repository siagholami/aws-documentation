# IT Lifecycle Management Setup and Use Case<a name="jsd-it-lifecycle"></a>

 The AWS Service Management Connector for Jira Service Desk allows Jira Service Desk end\-users to provision, manage and operate AWS resources natively via Atlassian’s Jira Service Desk\. To enable the IT Lifecycle Management scenario, you need to configure: 
+ AWS Config Linked Resources 
+ Suggested AWS Systems Manager Remediations for an Issue
+ Sample Use Case: Automatically Creating Jira Issues for IT Lifecycle Management, Rremediating non\-compliant public S3 buckets

## AWS Config and suggested AWS Systems Manager remediations for any Jira issue<a name="jsd-config-sys-remediations"></a>

The Connector provides two fields that can be used and displayed for any issue\.
+ *AWS Config Linked Resources*: this field allows any resource with an entry in AWS Config to have its AWS Config information displayed on the issue in Jira\. The information can be expanded and information on relations also displayed\. Multiple AWS resources can be linked to an issue\. 
+ *AWS Systems Manager Automation Suggested Remediation*: this field allows SSM automation documents to be recorded against an issue\. These are then displayed as suggested ways to correct the issue\. When a Jira user views the issue, they can see these suggested remediations and click to apply them\. Multiple suggested remediations can be attached to an issue\.

 The two fields can be used individually but they work very well together: when an incident is detected on an AWS resource or set of resources, setting both allows a Jira user to see the Config information to confirm or better understand the problem, apply remediations which fix common problems, and then confirm in the AWS Config information that the problem has been fixed\. 

**To add AWS fields to an existing issue**

1.  The project or projects must be enabled for the Connector\. This is done in **Connector Settings** under **Admin \-> Manage Add\-Ons**, as described elsewhere in the Connector setup guide\. 

1.  Go to **Admin**, then **Projects**, and open the project you wish to use these fields with\. 

1.  Choose the issue type you wish to use in the menu at left\. 

1.  Select to view "Fields" in the top right \(if not already selected\)\. It should then show a list of fields enabled for the screen\. 

1.  Scroll to the bottom where there should be a textbox where you can type additional fields\. Start typing "AWS" then select the AWS field you want to use\. 

1.  Choose **Add** to apply\. 

1.  Repeat the previous step for the other field if you wish to use it\. 

1.  Repeat these steps for each issue type you wish you use these fields with\. Some issue types may share screens so the field may already be added for some\. 

 It is important also to make a note of the field ID for the field or fields you are using\. This can be done by going to** Admin \-> Issues \-> Custom fields** and selecting **Configure** on each such field\. 

 Inspect the URL that is opened to see the numeric field ID\. It should be a 5\-digit number\. Alternatively, for any issue in a project where you’ve added the field \(following the instructions above\), the REST API at `/rest/api/2/issue/PRJ-1/editmeta` \(for example, `http://localhost:2990/jira/rest/api/2/issue/PRJ-1/editmeta`\) will include information on the fields and should contain an entry `customfield_#####: { ..., name: "AWS Config Linked Resources", ... }`, where `#####` is the numeric field ID\. 

 Once these fields are enabled for projects and issue types, use the Jira REST API to create or update issues with values for these fields\. This can be used from tools such as CloudWatch or AppDynamics or Jenkins or a Systems Manager Automation Document \(provided in the next section\)\. The REST API endpoint to update an issue is `/rest/api/2/issue/issue-key` and the general schema to pass to set a value is: 

```
                        { "update": { 
        "customfield_field-ID": [ {
          "set": "value" 
        } ] 
    } }
```

 See the examples below, or for more information on the REST API, see [JIRA Developer Documentation : Updating an Issue via the JIRA REST APIs](https://developer.atlassian.com/server/jira/platform/updating-an-issue-via-the-jira-rest-apis-6848604/)\. 

## AWS Config Linked Resources<a name="jsd-config-linked-resources"></a>

The **AWS Config Linked Resources** field should be set to the JSON string representation of a list of objects \(maps\) corresponding to the linked resources, each with the following keys:
+  *resourceId*: the ID of the resource in AWS Config 
+  *resourceType*: the type of the resource in AWS Config 
+  *accountName*: the name/alias of the AWS account configured in Jira that should be used to access this resource 
+  *region*: the region where AWS Config should be accessed to get information on this resource 

 For example the following value would show information on the S3 bucket `my-bucket` in `eu-central-1`, using the account and end user credentials specified in Jira for the AWS Account identified in Jira as `MyAccount1`: 

```
                    [ { "resourceId": "my-bucket", 
        "resourceType": "AWS::S3::Bucket", 
        "accountName": "MyAccount1", 
        "region": "eu-central-1" } ]
```

## AWS Systems Manager Automation Suggested Remediation<a name="jsd-sys-remediation"></a>

 The AWS Systems Manager Automation Suggested Remediation field should be set to the JSON string representation of a list of objects \(maps\) corresponding to the automation documents to suggest as remediations, each with the following keys: 
+  *documentName*: the name of the Systems Manager automation document 
+  *description*: a description of the remediation to display in Jira; this may be different to the document description in AWS and might explain why it is a good remediation for the issue where this is being set 
+  *accountName*: the name/alias of the AWS account configured in Jira that should be used to access this resource 
+  *region*: the region where AWS Config should be accessed to get information on this resource 

 For example, the following value would suggest the `AWS-DisableS3BucketPublicReadWrite` automation document, with a nice description to show in Jira, to be applied in `eu-central-1`, using the account and end\-user credentials specified in Jira for the AWS Account identified in Jira as `MyAccount1`: 

```
                               [ { "documentName": "AWS-DisableS3BucketPublicReadWrite", 
        "description": "This will make the bucket private, resolving the issue.", 
        "accountName": "MyAccount1", 
        "region": "eu-central-1" } ]
```

**Scripting Field Creation**  
As an example, the following bash script using curl will link the above\-noted resource to an issue and attach a suggested remediation\. The values used below assume Jira is at `localhost:2990/jira` with login `admin:admin`, the issue is `PRJ\-1`, and the field IDs are 10011 \(AWS Config linked resources\) and 10010 \(suggested remediation\)\. These should be changed to reflect your environment\.

1. Set these corresponding to your environment and issue:

   JIRA\_BASE\_URL=http://localhost:2990/jira

   JIRA\_USER\_PASS=admin:admin

   ISSUE\_KEY=PRJ\-1

1. Set the field ID and edit the JSON record for an AWS Config resource to link

   ```
                           CUSTOM_FIELD_ID=customfield_10011
   cat > value.json  EOF
       [ { "resourceId": "my-bucket", 
           "resourceType": "AWS::S3::Bucket", 
           "accountName": "MyAccount1", 
           "region": "eu-central-1" } ]
   EOF
   ```

1.  Define a helper function to escape the JSON 

   ```
                           json_escape () { 
       printf '%s' "$1" | python -c \
         'import json,sys; print(json.dumps(sys.stdin.read()))'
   }
   ```

1.  Make the REST call to set the AWS Config Linked Resource field 

   ```
                           curl -v -D- -X PUT  -H "Content-Type: application/json" \
     --data '{ "update": { "'${CUSTOM_FIELD_ID}'": [ {"set": '"$(
        json_escape "$(cat value.json)")"' } ] } }' \
     -u admin:admin ${JIRA_BASE_URL}/rest/api/2/issue/${ISSUE_KEY}
   ```

1. Set the field ID and edit the JSON record for a suggested remediation to attach

   ```
                           CUSTOM_FIELD_ID=customfield_10010
   cat > value.json  EOF
       [ { "documentName": "AWS-DisableS3BucketPublicReadWrite", 
           "description": "This will make the bucket private, resolving the issue.", 
           "accountName": "MyAccount1", 
           "region": "eu-central-1" } ]
   EOF
   ```

1.  Make the REST call to set the AWS Systems Manager Automation Suggested Remediations field 

   ```
                           curl -v -D- -X PUT  -H "Content-Type: application/json" \
     --data '{ "update": { "'${CUSTOM_FIELD_ID}'": [ {"set": '"$(
        json_escape "$(cat value.json)")"' } ] } }' \
     -u ${JIRA_USER_PASS} ${JIRA_BASE_URL}/rest/api/2/issue/${ISSUE_KEY}
   ```

The issue should then show AWS Config for the bucket and a suggested remediation to make it private\.

## Creating Issues with Suggestions and a Linked AWS Resource from AWS Systems Manager<a name="jsd-create-issues-linked-resource"></a>

 A Systems Manager Automation Document is provided which can automatically create a Jira issue with the fields set to have a linked AWS resource and up to three suggested remediation documents\. To install this automation document, download and extract the [JSD Connector Create Remediation Issue Automation and IT Lifecycle Demo\.zip](https://servicecatalogconnector.s3.amazonaws.com/JSDConnector-create-remediation-issue-automation-and-it-lifecycle-demo.zip) that contains two files: 
+ JSDConnector\-CreateRemediationIssue\.ssmdoc\.yaml
+ JSDConnector\-function\.zip

**Follow these steps**

1. Upload the file `JSDConnector\-function\.zip` to a bucket\. The following command will do this \(replacing `$\{BUCKET\}` with the appropriate bucket\):

   ```
                               aws s3 cp JSDConnector-function.zip s3://${BUCKET}/function.zip
   ```

1. Create the Systems Manager Automation Document, called **JSDConnector\-CreateRemediationIssue**, with the contents taken from the file **JSDConnector\-CreateRemediationIssue\.ssmdoc\.yaml** and an attachment **Key=SourceUrl,Values=s3://$\{BUCKET\}/**, using the bucket name from the previous step as $\{BUCKET\}\. The following command will do this \(replacing $\{BUCKET\}\):

   ```
                               aws ssm create-document --name "JSDConnector-CreateRemediationIssue" --content "file://JSDConnector-CreateRemediationIssue.ssmdoc.yaml" --document-type "Automation" --document-format "YAML" --attachments "Key=SourceUrl,Values=s3://${BUCKET}/" 
   ```

 Once installed, use it as you would any other Systems Manager automation document, filling out the parameters and running it\. Note this requires many of the same parameters as described previously in order to connect to Jira\. 

 You should then see an issue in Jira with AWS Config information and the suggested remediation shown\. 

## Sample Use Case: Automatically Creating Issues for IT Lifecycle Management \- Remediating non\-compliant public S3 buckets<a name="jsd-sample"></a>

 Once the fields are enabled to an issue and the Systems Manager Automation Document is created, you can set up rules to automatically create Jira issues for common problem categories in AWS and include suggested remediations to make it easy for a Jira agents and end users to see problems and fix them\. 

This demo will create a Config Rule is AWS which detects public S3 buckets and makes it possible for a Jira agents or end users to disable public access directly from Jira\.

You will need to set up prerequisites, roles for the automation and lambda to execute as, and the Jira password as a secure string in Systems Manager Parameter Store\.

**To store the Jira password securely in Parameter Store**

1. Open the AWS Console and go to **Systems Manager \-> Parameter Store**\.

1. Choose **Create parameter**\.

1. Set the name as **jira\_password**\.

1. Set the type as **SecureString**\.

1. Set the value as the password for the Jira user to be used to create issues\.

1. To save, choose **Create parameter**\.

An AWS CloudFormation template is provided to assist setting up the role and config rule: **JSDConnector\-CreateRemediationIssue\-MakePublicBucketsPrivateConfigRule\.cfn\.yaml**

Install the template, setting the following parameters:
+ **JiraURL**: the base URL to your Jira, such that appending `/rest/\.\.\.` after it accesses the REST API
+ **JiraUsername**: the username to use to log in to Jira \(with the password specified in `jira\_password`\) 
+ **SSMParameterName**: `jira\_password` \(the parameter containing the Jira password\)
+ **ProjectKey**: the key of the project \(the token before the `\-` in an issue\), e\.g\. `PRJ` 
+ **IssueTypeName**: this must exactly match the name of the issue type on the project in Jira
+ **JiraAwsAccountName**: the name of the AWS Account as configured in the Connector in Jira
+ **JiraAwsAccountRegion**: the region where this violating resource is found, e\.g\. `us\-east\-1`
+ **JiraAwsResourceFieldId**: enter the field ID of the AWS Config Linked Resources field in Jira, e\.g\. `customfield\_10011` 
+ **JiraRemediationsFieldId**: enter the field ID of the AWS Systems Manager Automation Suggested Remediation field in Jira, e\.g\. `customfield\_10010` 

 The Config Rule will run automatically within the period specified\. To see it in action immediately: 

1. Create a public Amazon S3 bucket\. 

1. Open the Config Rule in AWS Config and choose **Re\-evaluate**\. The rule and the automation may take a short while to run, but within a few minutes you should see a new issue in Jira with AWS Config information for the bucket which is in violation and suggesting the **DisableS3BucketPublicReadWrite** automation document as a remediation\.