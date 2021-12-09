# AWS CodeStar Best Practices<a name="best-practices"></a>

AWS CodeStar is integrated with a number of products and services\. The following sections describe best practices for AWS CodeStar and these related products and services\.

**Topics**
+ [Security Best Practices for AWS CodeStar Resources](#best-practices-security)
+ [Best Practices for Setting Versions for Dependencies](#best-practices-dependencies)
+ [Monitoring and Logging Best Practices for AWS CodeStar Resources](#best-practices-monitoring)

## Security Best Practices for AWS CodeStar Resources<a name="best-practices-security"></a>

You should regularly apply patches and review security best practices for the dependencies used by your application\. Use these security best practices to update your sample code and maintain your project in a production environment:
+ Track ongoing security announcements and updates for your framework\.
+ Before you deploy your project, follow the best practices developed for your framework\.
+ Review dependencies for your framework on a regular basis and update as needed\.
+ Each AWS CodeStar template contains configuration instructions for your programming language\. See the `README.md` file in your project's source repository\.

## Best Practices for Setting Versions for Dependencies<a name="best-practices-dependencies"></a>

The sample source code in your AWS CodeStar project uses dependencies that are listed in the `package.json` file in your source repository\. As a best practice, always set your dependencies to point to a specific version\. This is known as pinning the version\. We do not recommend that you set the version to `latest` because that can introduce changes that might break your application without notice\.

## Monitoring and Logging Best Practices for AWS CodeStar Resources<a name="best-practices-monitoring"></a>

You can use logging features in AWS to determine the actions users have taken in your account and the resources that were used\. The log files show:
+ The time and date of actions\.
+ The source IP address for an action\.
+ Which actions failed due to inadequate permissions\.

AWS CloudTrail can be used to log AWS API calls and related events made by or on behalf of an AWS account\. For more information, see [Logging AWS CodeStar API Calls with AWS CloudTrail](logging-using-cloudtrail.md)\.