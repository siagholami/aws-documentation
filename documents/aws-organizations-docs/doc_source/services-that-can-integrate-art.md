# AWS Artifact and AWS Organizations<a name="services-that-can-integrate-art"></a>

AWS Artifact is a service that allows you to download AWS security compliance reports such as ISO and PCI reports\. Using AWS Artifact, a user in a master account can automatically accept agreements on behalf of all member accounts in an organization, even as new reports and accounts are added\. Member account users can view and download agreements\. For more information about AWS Artifact, see the [AWS Artifact User Guide](https://docs.aws.amazon.com/artifact/latest/ug/)\.

The following list provides information that is useful to know when you want to integrate AWS Artifact and Organizations:
+ **To enable trusted access with AWS Organizations:** You must sign in with your AWS Organizations master account to configure an account within the organization as the AWS Artifact administrator account\. For information, see [Step 1: Create an Admin Group and Add an IAM User](https://docs.aws.amazon.com/artifact/latest/ug/getting-started.html#create-an-admin) in the *AWS Artifact User Guide*\.
+ **To disable trusted access with AWS Organizations:** AWS Artifact requires trusted access with AWS Organizations to work with organization agreements\. If you disable trusted access using AWS Organizations while you are using AWS Artifact for organization agreements, it stops functioning because it cannot access the organization\. Any organization agreements that you accept in AWS Artifact remain, but can't be accessed by AWS Artifact\. The AWS Artifact role that AWS Artifact creates remains\. If you then re\-enable trusted access, AWS Artifact continues to operate as before, without the need for you to reconfigure the service\. 

  A standalone account that is removed from an organization no longer has access to any organization agreements\.
+ **Service principal name for AWS Artifact: ** `aws-artifact-account-sync.amazonaws.com`
+ **Role name created to synchronize with AWS Artifact: ** `AWSArtifactAccountSync`