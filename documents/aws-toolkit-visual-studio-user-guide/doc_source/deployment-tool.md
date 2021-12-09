# Standalone Deployment Tool<a name="deployment-tool"></a>

**Note**  
Standalone Deployment Tool options related to AWS CloudFormation deployments and incremental deployments to Elastic Beanstalk are obsolete in the current version and should not be used\.  
For information about using the preferred **Publish to Elastic Beanstalk** wizard, see [Deploying to Elastic Beanstalk](deployment-beanstalk.md#tkv-deploy-beanstalk)\.

The Toolkit for Visual Studio includes a command line tool that provides the same functionality as the deployment wizard\. You can use the standalone deployment tool in your build pipeline or in other scripts to automate deployments to Elastic Beanstalk\.

The deployment tool supports both initial deployments and redeployments\. If you used the deployment tool to deploy your application, you can use the deployment wizard in Visual Studio to redeploy it, and vice versa\.

The deployment tool consumes a configuration file that specifies parameter values for the deployment\. If you used the deployment wizard in Visual Studio to deploy your application, you can generate a configuration file either from AWS Explorer or the last step in the wizard\.

**Note**  
Because the deployment configuration includes the credentials that were used for deployment, you should keep the configuration file in a secure location\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/deploy-save-config-tkv.png)

To deploy your web application with the deployment tool, package the application in a \.zip file\. For more information about how to package your application for deployment, go to [How to: Create a Web Deployment Package in Visual Studio](https://msdn.microsoft.com/en-us/library/dd465323.aspx) on MSDN\.

## Deployment Tool Installation and Invocation<a name="tkv-install-and-invoke"></a>

The deployment tool is typically installed in the following directory:

```
C:\Program Files\AWS Tools\Deployment Tool\awsdeploy.exe
```

Or, on Microsoft Windows 64\-bit system, in the following directory:

```
C:\Program Files (x86)\AWS Tools\Deployment Tool\awsdeploy.exe
```

### Invocation Syntax<a name="invocation-syntax"></a>

```
awsdeploy [options] configFile
```

The configuration file must be the last item specified on the command line\.

Command line options can be specified using a forward slash \(/\) or hyphen \(\-\)\.

Except for the `D` option, each command line option has a long form and a single letter abbreviation\. For example, you can specify silent mode in any of the following ways\.

```
/s
-s
/silent
-silent
```

Other command line options follow a similar form\.

The following table shows the available command line options\.


****  

| Option | Description | 
| --- | --- | 
|  /s, /silent, \-s, \-silent  |  Do not output messages to the console\.  | 
|  /v, /verbose, \-v, \-verbose  |  Send more detailed information about the deployment to the console\.  | 
|  /r, /redeploy, \-r, \-redeploy  |  Do not create stack\. Deploy to existing stack\. This option does not change the AWS CloudFormation configuration\.  | 
|  /u, /updateStack, \-u, \-updateStack  |  Update the AWS CloudFormation configuration for an existing deployment\. Do not redeploy the application\. \*\* \(Obsolete\. Do not use\.\) \*\*  | 
|  /w, /wait, \-w, \-wait  |  Block until deployment is complete\. This option is useful for scripts that need to take some action after the deployment is complete\.  | 
|  /l <logfile>, /log <logfile>, \-l <logfile>, \-log <logfile>  |  Log debugging information to the specified log file\.  | 
|  /D<key>=<value>, \-D<key>=<value>  |  Override a configuration setting from the command line\. For more information, see the section of the configuration file\.  | 

### Output and Exit Codes<a name="output-and-exit-codes"></a>

Warnings and errors are output to the console\. If the log option is specified, additional logging output is sent to the log file\.

The deployment tool uses the following exit codes\.


****  

| Key and Value | Description | 
| --- | --- | 
|  0  |  Success  | 
|  1  |  Invalid argument  | 
|  3  |  Failed deployment  | 

If the deployment is successful, the deployment tool will output the URL for the deployed application\.

### Configuration File Samples<a name="configuration-file-samples"></a>

You use a configuration file to specify the action of the deployment tool\. The Toolkit for Visual Studio includes three sample configuration files:
+ Elastic Beanstalk deployment
+ AWS CloudFormation single instance deployment
+ AWS CloudFormation load\-balanced deployment

### Sample Web App<a name="sample-web-app"></a>

A sample web app \(in a \.zip file archive\) that you can deploy using the deployment tool is also included in the Toolkit for Visual Studio\. You can find these files in the `Samples` subdirectory of the directory where the deployment tool is installed\.

You can use the `D` command line option to override settings in the configuration file:

```
/D<key>=<value>
```

or

```
-D<key>=<value>
```

You can specify the `D` option multiple times to override multiple configuration file settings\. If you repeat the same key with different values on the command line, the deployment tool will use the last value specified\.

## Deployment Tool Configuration File Format<a name="deployment-tool-configuration-file-format"></a>

The configuration files provide the same information you would specify in the deployment wizard\. The formatting of the configuration files divides the configuration into sections that correspond to the pages in the deployment wizard\.

### Elastic Beanstalk Deployment Configuration File<a name="aws-aeb-deployment-configuration-file"></a>

The following configuration parameters are for deployments using Elastic Beanstalk\.

For a walkthrough of the use of the standalone deployment tool to deploy to Elastic Beanstalk, go to the [Developer Guide](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/deploy_NET_standalone_tool.html)\.

#### General Settings<a name="general-settings"></a>

```
/Daws:autoscaling:launchconfiguration.SecurityGroups=RDPOnly,HTTPOnly
```


****  

| Key and Value | Description | 
| --- | --- | 
|  DeploymentPackage = archive\.zip  |  Relative path to the web deployment archive\. This path is relative to your working directory \(that is, the directory from which you invoke the deployment tool\)\.  | 
|  IncrementalPushLocation  |  \(Obsolete: Do not use\) If specified, incremental deployment is enabled\. The value specifies a location \(for example, `C:\Temp\VS2008App1`\) where a Git repository will be created to store the versioned contents of the deployment package\.  | 
|  Template = ElasticBeanstalk  |  Can be `Elastic Beanstalk` or `ElasticBeanstalk`\.  | 
|  Application\.Name  |  Specifies a name for the application\. This value is required\.  | 
|  Application\.Description  |  Specifies an optional description for the application\.  | 
|  Application\.Version  |  Specifies a version string for the application\. If you are using incremental deployment, this value is ignored\. Elastic Beanstalk uses the Git commit ID for the version string\.  | 
|  Region = us\-east\-1  |  Target [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html)\.  | 
|  UploadBucket = awsdeployment\-us\-east\-1\-samples  |  Amazon S3 bucket where the deployment materials will be stored\. If this bucket doesn't exist, it will be created\. If you use the deployment wizard, it generates the bucket name for you\.  | 
|  KeyPair = default  |  Amazon EC2 key pair for signing in to the instance\. The key pair must exist before deployment\. \(The deployment wizard allows you to create the key pair during deployment\.\)  | 
|  AWSAccessKey = DEPLOYMENT\_CREDENTIALS\_HERE AWSSecretKey = DEPLOYMENT\_CREDENTIALS\_HERE  |  AWS access key and secret key used to create the stack and deploy the application to Elastic Beanstalk\. We do not recommend using these parameters to specify credentials\. Instead, create a profile for the credentials and use `AWSProfileName` to reference the profile\. For more information, see creds\.  | 
|  AWSProfileName = \{profile\_name\}  |  The profile used to create the stack and deploy the application to Elastic Beanstalk\.  | 
|  aws:autoscaling:launchconfiguration\.SecurityGroups = default  |  The names of the security groups for the Amazon EC2 instance\. If you specify multiple security groups, separate them with commas\.  `/Daws:autoscaling:launchconfiguration.SecurityGroups=RDPOnly,HTTPOnly`  The security groups must already exist and must allow ingress on port 80 \(HTTP\)\. For information about how to create security groups, see tkv\-sg  | 

#### Environment Settings<a name="environment-settings"></a>


****  

| Key and Value | Description | 
| --- | --- | 
|  Environment\.Name  |  Specifies a name for your Elastic Beanstalk environment\. This value is required\.  | 
|  Environment\.Description  |  Optional\. Specifies a description for your environment\.  | 
|  Environment\.CNAME  |  Optional\. Specifies the URL prefix for your application\. If you do not specify this value, Elastic Beanstalk will derive the prefix from your environment name\.  | 

#### Container Settings<a name="container-settings"></a>


****  

| Key and Value | Description | 
| --- | --- | 
|  Container\.TargetRuntime = 4\.0  |  Specifies the target runtime for the \.NET Framework\. Possible values are 2\.0 or 4\.0\. The following \.NET Framework versions are mapped to a target runtime of 2\.0:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/deployment-tool.html)  The following \.NET Framework versions are mapped to a target runtime of 4\.0:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/deployment-tool.html)  The [deployment wizard](deployment-beanstalk.md#tkv-deploy-beanstalk) in the Toolkit for Visual Studio allows you to specify the \.NET Framework version\. The wizard then maps the \.NET Framework version to the appropriate target runtime version\.  | 
|  Container\.Enable32BitApplications = false  |  If the application is 32\-bit, specify `true`\. If the application is 64\-bit, specify `false`\.  | 
|  Container\.ApplicationHealthcheckPath = /  |  This URL is relative to the root server URL\. For example, if the full URL is `example.com/site-is-up.html`, you would type `/site-is-up.html`\. The setting applies only when you use the load balanced template\. It is ignored when you use the single instance template\. The responsiveness of the application at this URL affects into the actions taken by the load balancer and auto scaler\. If the application is unresponsive or responds slowly, the load balancer will direct incoming network traffic to other Amazon EC2 instances, and the auto scaler may add additional Amazon EC2 instances\.  | 
|  Container\.InstanceType = t1\.micro  |  The [type of Amazon EC2 instance](https://aws.amazon.com/ec2/instance-types/) to use\. The Micro instance shown here is the [EC2 Pricing](https://aws.amazon.com/ec2/pricing/) type of instance\.  | 
|  Container\.AmiID  |  Specifies a custom Amazon Machine Image \(AMI\)\. For more information about how to create a custom AMI, go to [Using Custom AMIs](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/using-features.customami.html) in the [AWS Elastic Beanstalk Developer Guide](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/) and [Create an AMI from an Amazon EC2 Instance](tkv-create-ami-from-instance.md)\.  | 
|  Container\.NotificationEmail  |  Optional\. Specifies an email address for deployment status notifications\.  | 

### AWS CloudFormation Deployment Configuration File<a name="amazon-cloudformation-deployment-configuration-file"></a>

**Note**  
Deployments to AWS CloudFormation using the Standalone Deployment Tool are deprecated\.

The following configuration parameters are taken from the load balanced template\.

 *General Settings* 


****  

| Key and Value | Description | 
| --- | --- | 
|  DeploymentPackage = archive\.zip  |  Relative path to the web deployment archive\. This path is relative to your working directory \(that is, the directory from which you invoke the deployment tool\)\. If you are updating a deployment \(`/updateStack` switch\), this parameter is ignored\.  | 
|  Region = us\-east\-1  |  Target region\.  | 
|  Template = LoadBalanced  |  The value for `Template` can be `SingleInstance` or `LoadBalanced` or a file path to a custom AWS CloudFormation template\. For more information, see [Customizing the AWS CloudFormation Template Used for Deployment](custom-template-tkv.md#tkv-custom-templates)   | 
|  UploadBucket = awsdeployment\-us\-east\-1\-samples  |  Amazon Simple Storage Service \(Amazon S3\) bucket where the deployment materials will be stored\. If the bucket doesn't exist, it will be created\. If you use the deployment wizard, it generates this bucket name for you\. If you used the wizard for a deployment and are redeploying, this parameter will be ignored\. The deployment tool automatically uses the bucket that was used in the original deployment from the wizard\.  | 
|  KeyPair = default  |  Amazon Elastic Compute Cloud \(Amazon EC2\) key pair for signing in to the instance\. The key pair must exist before deployment\. \(The deployment wizard allows you to create the key pair during deployment\.\)  | 
|  AWSAccessKey = DEPLOYMENT\_CREDENTIALS\_HERE AWSSecretKey = DEPLOYMENT\_CREDENTIALS\_HERE  |  The AWS access key and secret key used to create the stack and deploy the application to AWS CloudFormation\. We do not recommend using these parameters to specify credentials\. Instead, create a profile for the credentials and use `AWSProfileName` to reference the profile\. For more information, see creds\.  | 
|  AWSProfileName = \{profile\_name\}  |  The profile used to create the stack and deploy the application to AWS CloudFormation\.  | 

#### Template Parameters<a name="template-parameters"></a>

In addition to the following parameters, the load balanced template supports numerous other parameters to customize load balancing and Auto Scaling behavior\.


****  

| Key and Value | Description | 
| --- | --- | 
|  Template\.InstanceType = t1\.micro  |  The [type of Amazon EC2 instance](https://aws.amazon.com/ec2/instance-types/) to use\. The Micro instance shown here is the [least expensive](https://aws.amazon.com/ec2/pricing/) type of instance\.  | 
|  Template\.SecurityGroup = default  |  The security group for the Amazon EC2 instance\. This security group must have already been created and must allow ingress on port 80 \(HTTP\)\. For information about how to create a security groups, see tkv\-sg\.  | 
|  Environment\.PARAM1 = Environment\.PARAM2 = Environment\.PARAM3 = Environment\.PARAM4 = Environment\.PARAM5 =  |  These values are made available to the deployed application through the `appSettings` in the `Web.config` file\. For more information, go to the [MSDN library](http://msdn.microsoft.com/en-us/library/610xe886.aspx)\.  | 
|  Environment\.AWSAccessKey = APP\_CREDENTIALS\_HERE Environment\.AWSSecretKey = APP\_CREDENTIALS\_HERE  |  The access key and secret key used by the deployed application to access AWS services\. We do not recommend using these parameters to specify credentials\. Instead, create a profile for the credentials and use `AWSProfileName` to reference the profile\. For more information, see creds\.  | 
|  AWSProfileName = \{profile\_name\}  |  The profile used by the deployed application to access AWS services\. \.  | 

#### Container Settings<a name="id3"></a>

```
SolutionStack="64bit Windows Server 2008 R2 running IIS 7.5"
```

```
SolutionStack="64bit Windows Server 2012 running IIS 8"
```


****  

| Key and Value | Description | 
| --- | --- | 
|  SolutionStack="64bit Windows Server 2012 running IIS 8"  |  Specifies the version of Windows Server and Internet Information Services \(IIS\) to which to deploy\. Valid values are: SolutionStack="64bit Windows Server 2008 R2 running IIS 7\.5" or SolutionStack="64bit Windows Server 2012 running IIS 8" If not specified, the default is 64bit Windows Server 2012 running IIS 8\.0\. You can use *Container\.Type* as an alias for SolutionStack\.  | 
|  Container\.TargetRuntime = 4\.0  |  Specifies the target runtime for the \.NET Framework\. Possible values are 2\.0 or 4\.0\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/deployment-tool.html) The [deployment wizard](deployment-cloudform.md#tkv-deploy-cloudform) in the Toolkit for Visual Studio allows you to specify the \.NET Framework version\. The wizard then maps the \.NET Framework version to the appropriate target runtime version\.  | 
|  Container\.Enable32BitApplications = false  |  If the application is 32\-bit, specify `true`\. If the application is 64\-bit, specify `false`\.  | 
|  Container\.ApplicationHealthcheckPath = /  |  This URL is relative to the root server URL\. For example, if the full URL is `example.com/site-is-up.html`, you would type `/site-is-up.html`\. The setting applies only when you use the load balanced template\. It is ignored when you are using the single instance template\. The responsiveness of the application at this URL affects the actions taken by the load balancer and auto scaling\. If the application is unresponsive or responds slowly, the load balancer will direct incoming network traffic to other Amazon EC2 instances, and the auto scaler may add additional Amazon EC2 instances\.  | 

#### Stack Creation Settings<a name="stack-creation-settings"></a>


****  

| Key and Value | Description | 
| --- | --- | 
|  Settings\.SNSTopic  |  SNS topic to use for deployment messages\.  | 
|  Settings\.CreationTimeout = 0  |  The amount of time to allow for the creation of the stack\. A value of zero means there is no time limit\.  | 
|  Settings\.RollbackOnFailure = false  |  If this value is `true`, the deployment tool tears down the stack if the deployment fails\.  | 

## How to Update the Configuration for an Existing Deployment<a name="update-the-configuration-for-an-existing-deployment"></a>

You can use the `updateStack` feature of the deployment tool to modify the AWS CloudFormation configuration of an existing deployment\. This configuration—the application's environment—includes the cloud resources your application runs on and has access to\. The `updateStack` feature does not change or redeploy the application; it only updates the application's environment\. In this way, the `updateStack` feature complements the redeployment feature\. Redeployment provides a way to update your application without changing the environment\.

There are various scenarios in which you might use `updateStack`\. For example, if you develop your application using the single instance template, as the application nears production readiness, you could update its configuration to use a load balanced template, either for public beta testing or live release deployment\. In a related scenario, a deployment using a load\-balanced configuration could be optimized by modifying some of the configuration parameters—for example, by increasing the maximum number of supporting EC2 instances or changing the size of the instances, say from micro to large\. You can use the `updateStack` feature of the deployment tool to implement either of these scenarios\.

There are scenarios in which you might use both the `/updateStack` option and the `/redeploy` option, effectively modifying both the application itself and the environment in which the application is running\. In some cases, this approach is more efficient than just performing a regular deployment\. For example, you might change your environment to add an Amazon S3 bucket and then update your application to use that bucket\. With a combination of `/updateStack` and `/redeploy`, you could implement both changes, but leave any already provisioned Amazon EC2 instances up and running\. A regular deployment would result in all of the environment being taken down and rebuilt\.

The `updateStack` feature is available only through the deployment tool\. It is not available through the deployment wizard in Visual Studio\. You can use `updateStack` to update a deployment that was initially deployed through the deployment wizard, but not vice versa\.

The invocation syntax for updating a deployment is similar to the syntax for a new deployment\.

```
awsdeploy /updateStack [other options] updatedConfigFile
```

Keep the following in mind when you attempt to update a deployment:
+ You cannot update a deployment that is in the process of being created or taken down\.
+ The specified config file must use the same value for the `StackName` parameter as the original deployment\.
+ You cannot use `updateStack` to change the region for your deployment\. However, you can change the Availability Zones for your deployment\.
+ If you use `updateStack` to transition your deployment from single instance to load balanced, the endpoint for your deployment will necessarily change\. In the single instance case, the endpoint refers to an Amazon EC2 instance\. In the load balanced template, the endpoint refers to the Elastic Load Balancing load balancer, a computer that distributes computing load across all EC2 instances\. Therefore, if you are using a CNAME record to associate a domain name with your deployment, you should update the CNAME record so that it points to the load balancer of the load balanced template\.

The deployment tool implements the `updateStack` feature by calling the AWS CloudFormation [UpdateStack](https://docs.aws.amazon.com/AWSCloudFormation/latest/APIReference/UpdateStack.html) API\. For more information about AWS CloudFormation, go to the [AWS CloudFormation User Guide](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/)\.

**Topics**