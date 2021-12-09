# Customizing the AWS CloudFormation Template Used for Deployment<a name="custom-template-tkv"></a>

In addition to modifying a deployment by specifying parameters in the deployment wizard—or in the configuration file for the standalone deployment tool—you can also modify the deployment by providing your own custom AWS CloudFormation template\. By default, the deployment automatically uses one of a set of templates that are stored in Amazon Simple Storage Service \(Amazon S3\)\. This default set of templates includes two templates for each [AWS region](https://docs.aws.amazon.com/general/latest/gr/rande.html#AWS region_region)\. One of these two is for deployment to a single Amazon Elastic Compute Cloud \(Amazon EC2\) instance; the other is for deployment to a load\-balanced set of Amazon EC2 instances\. You can use these templates as a starting point for creating your own\.

## To create your own custom template<a name="to-create-your-own-custom-template"></a>

1. Copy the template that corresponds to your region and the type of deployment that you want to do\. Links to each of the templates is provided below\.
**Note**  
Templates are available only for the regions listed below\.

   US East \(N\. Virginia\)  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/custom-template-tkv.html)

   US West \(Oregon\)  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/custom-template-tkv.html)

   US West \(N\. California\)  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/custom-template-tkv.html)

   Europe \(Ireland\)  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/custom-template-tkv.html)

   Asia Pacific \(Singapore\)  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/custom-template-tkv.html)

   Asia Pacific \(Tokyo\)  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/custom-template-tkv.html)

   Asia Pacific \(Sydney\)  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/custom-template-tkv.html)

   South America \(São Paulo\)  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/custom-template-tkv.html)

If you need to create your own links to the templates, the format for each link is as follows:

```
http://vstoolkit.amazonwebservices.com/CloudFormationTemplates/{template-name}
```

For example, for the single instance template for the US West \(N\. California\) region, the link would be:

```
http://vstoolkit.amazonwebservices.com/CloudFormationTemplates/SingleInstance-us-west-1.template
```

The links in the table show the HTTP protocol\. The HTTPS protocol is also supported\.

1. Edit the template to modify it for your specific needs\. The templates are text files, so you can edit them with any standard text editor\. The deployment information in the templates is represented in [JavaScript Object Notation](http://www.json.org) format\. After editing the file, it's wise to revalidate the JSON formatting using a tool such as [JSONLint](http://jsonlint.com/)\.

   The template file has three sections: [Parameters](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/parameters-section-structure.html), [Resources](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/resources-section-structure.html), and [Outputs](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/outputs-section-structure.html)\.

   To add resources to your deployment, add them to the `Resources` section of the template\. For example, you could add an [Amazon RDS](https://aws.amazon.com/rds) database or an [Amazon SNS](https://aws.amazon.com/sns) topic\. To configure these resources at deployment time, add parameters to the `Parameters` section of the template\. When you add new parameters to the template, the AWS Toolkit adds them to the parameters that are displayed in the deployment wizard\. You can specify values for these parameters either in the deployment wizard or in the config file for the standalone deployment tool\.

   Similarly, data that you specify in the `Output` section of the template is also displayed in the deployment wizard—as well as in the AWS Management Console\. You can use the `Output` section to display post\-deployment information about your resources\. For example, if you add an Amazon S3 bucket to the `Resources` section of the template, you can use the `Outputs` section to display the autogenerated name for the bucket\.

   For more information about editing AWS CloudFormation templates, go to the [CloudFormation User Guide](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/template-guide.html)\.

1. Set the `Template` parameter in the deployment configuration file to the path to your customized template\. The `Template` parameter is located under `General Settings` in the config file\. The path that you specify could be the path to the file on your local hard drive or it could be a URL that points to the location of the configuration file on a remote server\. When you next run a deployment, the tool will use your template\.

### Required Data in the Template File<a name="required-data-in-the-template-file"></a>

The deployment process requires that certain data be specified in the template file\. While editing your version of the template, you must ensure that it continues to provide this data\. The required data is located only in the `Parameters` and `Outputs` sections of the template\.

## Parameters Section of Template<a name="parameters-section-of-template"></a>

The following table shows the required parameters in the [Parameters](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/parameters-section-structure.html) section of the template\.


****  

| Name | Meaning | 
| --- | --- | 
|  InstanceType  |  The "API name" for the type of the Amazon EC2 instances to use for the deployment\. Examples are t1\.micro for Micro instances or m1\.xlarge for Extra Large instances\. For a list of instance types and corresponding API names, see the Amazon EC2 [detail page](https://aws.amazon.com/ec2/instance-types/)\.  | 
|  KeyPair  |  Which of your key pairs to use for the Amazon EC2 instances\.  | 
|  Security Group  |  The security group to use for the Amazon EC2 instances\.  | 
|  BucketName  |  Amazon S3 bucket where the deployment files are uploaded\.  | 
|  ConfigFile  |  Name of the config file that the deployment uses\.  | 
|  AmazonMachineImage  |  The Amazon Machine Image \(AMI\) that is used for the deployment\. For more information about how to create a custom AMI, go to [Using Custom AMIs](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/using-features.customami.html) in the Elastic Beanstalk Developer Guide and [Create an AMI from an Amazon EC2 Instance](tkv-create-ami-from-instance.md)\. Note that the Host Manager software that is installed on AMIs that are used in CloudFormation deployments is now auto\-updating\. Therefore, if you derive a custom AMI from one of the CloudFormation AMIs, you do not need to maintain the Host Manager software\. However, you still need to keep the operating system and application software up to date\.  | 
|  UserData  |  The user data that the deployment provides to the deployed application\.  | 

## Outputs Section of Template<a name="outputs-section-of-template"></a>

The following table shows the required outputs in the [Outputs](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/outputs-section-structure.html) section of the template\.


****  

| Name | Meaning | 
| --- | --- | 
|  Bucket  |  The Amazon S3 bucket to which the deployment files were uploaded\.  | 
|  ConfigFile  |  The name of the configuration file that was used for the deployment\.  | 
|  VSToolkitDeployed  |  Boolean flag set to `true`, which indicates that this stack was created as part of a deployment from the AWS Toolkit for Visual Studio\. This flag is also set to `true` if the deployment is done from the standalone deployment tool\.  | 
|  URL  |  The URL for the deployed application\.  | 