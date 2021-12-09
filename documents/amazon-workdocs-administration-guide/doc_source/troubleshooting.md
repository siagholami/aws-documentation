# Troubleshooting Amazon WorkDocs Issues<a name="troubleshooting"></a>

The following information can help you troubleshoot issues with Amazon WorkDocs\.

**Topics**
+ [Can't set up my Amazon WorkDocs site in a specific AWS Region](#region)
+ [Want to set up my Amazon WorkDocs site in an existing Amazon VPC](#existing-vpc)
+ [User needs to reset their password](#password)
+ [User accidentally shared a sensitive document](#sensitive-share)
+ [User left the organization and didn't transfer document ownership](#user-left)
+ [Need to deploy Amazon WorkDocs Drive or Amazon WorkDocs Companion to multiple users](#deploy-multiple)
+ [Online editing isn't working](#online-editing)

## Can't set up my Amazon WorkDocs site in a specific AWS Region<a name="region"></a>

If you're setting up a new Amazon WorkDocs site, select the AWS Region during setup\. For more information, see the tutorial for your particular use case under [Getting started with Amazon WorkDocs](getting_started.md)\.

## Want to set up my Amazon WorkDocs site in an existing Amazon VPC<a name="existing-vpc"></a>

When setting up your new Amazon WorkDocs site, create a directory using the existing virtual private cloud \(VPC\)\. Amazon WorkDocs uses this directory to authenticate users\.

## User needs to reset their password<a name="password"></a>

Users can reset their passwords by choosing **Forgot password?** on their sign\-in screens\.

## User accidentally shared a sensitive document<a name="sensitive-share"></a>

To revoke access to the document, choose **Share by invite** next to the document, then remove the users who should no longer have access\. If the document was shared using a link, choose **Share a link** and disable the link\.

## User left the organization and didn't transfer document ownership<a name="user-left"></a>

Transfer document ownership to another user in the admin control panel\. For more information, see [Transferring document ownership](transfer-docs.md)\.

## Need to deploy Amazon WorkDocs Drive or Amazon WorkDocs Companion to multiple users<a name="deploy-multiple"></a>

Deploy to multiple users in an enterprise by using group policy\. For more information, see [Identity and access management for Amazon WorkDocs](security-iam.md)\.

## Online editing isn't working<a name="online-editing"></a>

Verify that you have Amazon WorkDocs Companion installed\. To install Amazon WorkDocs Companion, see [Apps & Integrations for Amazon WorkDocs](https://amazonworkdocs.com/apps.html)\.