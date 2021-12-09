# Deploying to Elastic Beanstalk \(Legacy\)<a name="deployment-beanstalk-legacy"></a>

**Note**  
The information in this section refers to the **Publish to Amazon Web Services** wizard, which has been replaced by the **Publish to Elastic Beanstalk** wizard\. The following information is provided for those who prefer to, or must, use the legacy wizard\.  
For information about using the **Publish to Elastic Beanstalk** wizard, see [Deploying to Elastic Beanstalk](deployment-beanstalk.md#tkv-deploy-beanstalk)\.

AWS Elastic Beanstalk is a service that simplifies the process of provisioning AWS resources for your application\. Elastic Beanstalk provides all of the AWS infrastructure required to deploy your application\. This infrastructure includes:
+ Amazon EC2 instances that host the executables and content for your application\.
+ An Auto Scaling group to maintain the appropriate number of Amazon EC2 instances to support your application\.
+ An Elastic Load Balancing load balancer that routes incoming traffic to the Amazon EC2 instance with the most bandwidth\.

For more information about Elastic Beanstalk, go to the [Elastic Beanstalk documentation](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/Welcome.html)\.

## How to Deploy a Web Application Using Elastic Beanstalk \(Legacy\)<a name="tkv-deploy-beanstalk-legacy-howto"></a>

This section describes how to use the legacy **Publish to Amazon Web Services** wizard, provided as part of the Toolkit for Visual Studio, to deploy a web application through Elastic Beanstalk\. To practice, you can use an instance of a web application starter project that is built in to Visual Studio or you can use your own project\.

**Note**  
Before you can use the legacy **Publish to Amazon Web Services** wizard, you must download and install [Web Deploy](http://www.microsoft.com/en-us/download/details.aspx?id=39277)\. The wizard relies on Web Deploy to deploy web applications and websites to Internet Information Services \(IIS\) web servers\.

### To deploy an application by using the legacy Publish to Amazon Web Services wizard<a name="to-deploy-an-application-by-using-the-legacy-publish-to-amazon-web-services-wizard"></a>

**Note**  
If you don't have a project ready to deploy, follow the steps in [To create a sample web application starter project](#tkv-starter-project) and then follow the steps below\.

1. Specify the AWS security credentials for the web application\. For instructions, see [How to Specify the AWS Security Credentials for Your Application](deployment-beanstalk-specify-credentials.md#tkv-deploy-specify-credentials-for-application)\.

   These credentials might be different from the credentials you use to do the deployment\. The credentials for the deployment are specified in the deployment wizard described later\.

1. In Solution Explorer, open the context \(right\-click\) menu for the **AEBWebAppDemo** project folder or for the project folder for your own application, and choose **Publish to AWS**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-publish-to-aws-console.png)

1. On the **Publish to AWS Elastic Beanstalk** page, choose **Use legacy wizard**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-use-legacy-wizard-console.png)

1. On the **Template** page of the wizard, choose the AWS account you want to use for the deployment\. To add a new account, choose the button with the plus sign \(\+\)\.

   There are options to perform an initial deployment of an application or redeploy a previously deployed application\. Previous deployments may have been performed with either the deployment wizard or the [Standalone Deployment Tool](deployment-tool.md#tkv-deployment-tool)\. If you choose a redeployment, there may be a delay while the wizard retrieves information from previous deployments that are currently running\.

   For this example, choose **Deploy new application with template**, choose **AWS Elastic Beanstalk**, and then choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-cloudform-aeb-template-dlg.png)

1. On the **Application** page, the Toolkit has already provided a default name for the application\. You can change the default name\. You can also provide an optional description in the **Application Details** area\.

   The Toolkit also provides a deployment version label, which is based on the current date and time\. You can change this version label, but the Toolkit checks it for uniqueness\.

   If you are using incremental deployment, **Deployment version label** is unavailable\. For incremental deployments, the version label is formed from the Git commit ID\. In this case, the version label is unique because the commit ID is derived from a SHA\-1 cryptographic hash\.

   With incremental deployment, the first time that you deploy your application, all application files are copied to the server\. If you later update some of your application files and redeploy, only the changed files are copied, which potentially reduces the amount of time required for redeployment\. Without incremental deployment, all of your application files, whether they were changed or not, are copied to the server with each redeployment\.

   Select **Deploy application incrementally** and then choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-aeb-application-dlg.png)

1. On the **Environment** page, type a name and description for your Elastic Beanstalk environment\. In this context, *environment* refers to the infrastructure Elastic Beanstalk provisions for your application\. The Toolkit has already provided a default name, which you can change\. The environment name cannot be longer than 23 characters\. In **Description**, type any text you choose\.

   You can also provide a subdomain of `.elasticbeanstalk.com` that will be the URL for your application\. The Toolkit provides a default subdomain based on the environment name\.

1. Choose **Check availability** to make sure the URL for your web application is okay to use\.

1. Choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-aeb-environment-dlg.png)

1. On the **AWS Options** page, configure the following\.
   + From the **Container type** drop\-down list, choose a container type\. The container type specifies an Amazon Machine Image \(AMI\) for your application and configurations for the Auto Scaling group, the load balancer, and other aspects of the environment in which your application will run\.
   + Optional\. In the **Use custom AMI** field, you can specify a custom AMI\. If you specify a custom AMI, it will override the AMI in **Container type**\. For more information about how to create a custom AMI go to [Using Custom AMIs](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/using-features.customami.html) in the [AWS Elastic Beanstalk Developer Guide](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/) and [Create an AMI from an Amazon EC2 Instance](tkv-create-ami-from-instance.md)\.
   + From the **Instance Type** drop\-down list, choose an Amazon EC2 instance type\. For this application, we recommend you use **Micro** because this will minimize the cost associated with running the instance\. For more information about Amazon EC2 costs, go to the [EC2 Pricing](https://aws.amazon.com/ec2/pricing/) page\.
   + From the **Key pair** drop\-down list, choose a key pair\.
   + The **IAM Role** drop\-down list displays the roles available for your Elastic Beanstalk environment\. If you do not have an IAM role, you can choose **Use the default role** from the list\. In this case, Elastic Beanstalk creates a default IAM role and updates the Amazon S3 bucket policy to allow log rotation\.

     An IAM role provides applications and services access to AWS resources using temporary security credentials\. For example, if your application requires access to DynamoDB, it must use AWS security credentials to make an API request\. The application can use these temporary security credentials so you do not have to store long\-term credentials on an Amazon EC2 instance or update the instance every time the credentials are rotated\. Elastic Beanstalk requires an IAM role to rotate logs to Amazon S3\.

     If you choose not to use the IAM role, you need to grant permissions for Elastic Beanstalk to rotate logs\. For instructions, see [Using a Custom Instance Profile](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/AWSHowTo.iam.roles.logs.html#AWSHowTo.iam.roles.logs-custom)\. For more information about log rotation, see [Configuring Containers with Elastic Beanstalk](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/using-features.managing.container.html)\. For more information about using IAM roles with Elastic Beanstalk, see [Using IAM Roles with Elastic Beanstalk](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/AWSHowTo.iam.roles.aeb.html)\.

     The credentials you use for deployment must have permission to create the default IAM role\.

     Choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-aeb-aws-options.png)

1. The **VPC Options** page provides the option to launch your application to a VPC\. The VPC must have already been created\. You can use the Toolkit for Visual Studio or the [AWS Management Console](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/AWSHowTo-vpc-basic.html) to create a VPC\. If you created the VPC in the Toolkit, the Toolkit will populate this page for you\. If you created the VPC in the console, type information about your VPC into this page\.

## Key considerations for deployment to a VPC<a name="tkv-deploy-beanstalk-legacy-considerations"></a>
+ Your VPC needs at least one public and one private subnet\.
+ In the *ELB Subnet* drop\-down list, specify the public subnet\. The Toolkit for Visual Studio deploys the Elastic Load Balancing load balancer for your application to the public subnet\. The public subnet is associated with a [routing table](https://console.aws.amazon.com/vpc/home) that has an entry that points to an Internet gateway\. You can recognize an Internet gateway because it has an ID that begins with `igw-`(for example, :code:`igw-83cddaea`\)\. Public subnets that you create by using the Toolkit have tag values that identify them as public\.
+ In the *Instances Subnet* drop\-down list, specify the private subnet\. The Toolkit deploys the Amazon EC2 instances for your application to the private subnet\.
+ The Amazon EC2 instances for your application communicate from the private subnet to the Internet through an Amazon EC2 instance in the public subnet that performs network address translation \(NAT\)\. To enable this communication, you will need a [VPC security group](https://console.aws.amazon.com/vpc/home) that allows traffic to flow from the private subnet to the NAT instance\. Specify this VPC security group in the *Security Group* drop\-down list\.

For more information about how to deploy an Elastic Beanstalk application to a VPC, go to the [AWS Elastic Beanstalk Developer Guide](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-aeb-aws-options-vpc.png)

1. On the **Application Options** page, configure the following\.
   + Under **Application Pool Options**, in the **Target framework** drop\-down list, choose the version of the \.NET Framework required by your application \(for example, \.NET Framework 2\.0, \.NET Framework 3\.0, \.NET Framework 3\.5, \.NET Framework 4\.0, \.NET Framework 4\.5\)\.

     For this walkthrough, select **Enable 32\-bit applications**\.
   + Under **Miscellaneous**, in the **Application health\-check URL** box, type a URL for Elastic Beanstalk to check to determine if your application is still responsive\. This URL is relative to the root server URL\. For example, if the full URL is , you would type `/site-is-up.html`\. For this sample application, leave the default setting of a forward slash \(`/`\)\.
   + In **Application Environment**, use the parameter fields \(PARAM1\-5\) to provide input data to your application\. These values are made available to the deployed application through the `appSettings` element in the `Web.config` file\. For more information, go to the [Microsoft MSDN library](http://msdn.microsoft.com/en-us/library/610xe886.aspx)\.
   + In **Application Credentials**, choose the AWS credentials under which the application should run\. These could be different from the credentials used to deploy to Elastic Beanstalk\.
     + To use a different set of credentials, choose **Use these credentials** and type the access key and secret key in the fields provided\.
     + To use the same credentials as those used to deploy to Elastic Beanstalk, choose **Use credentials from profile '<account name>'** where \{<account name>\} is the account selected on the first page of the wizard\.
     + To use the credentials for an AWS Identity and Access Management \(IAM\) user, choose **Use an IAM user** and then specify the user\.

       To use an IAM user, you must have:
       + created the IAM user in the Toolkit for Visual Studio\.
       + stored the secret key for the user with the Toolkit for Visual Studio\.

       For more information, see [Create and Configure an IAM User](tkv-iam.md#tkv-create-an-iam-user) and [Generate Credentials for an IAM User](tkv-iam.md#generate-credentials-for-an-iam-user-tkv)\.

       An IAM user could have more than one set of credentials stored with the Toolkit\. If that is the case, you will need to choose the credentials to use\. The root account could rotate the credentials for the IAM user, which would invalidate the credentials\. In this scenario, you would need to redeploy the application and then manually enter new credentials for the IAM user\.

   Choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-cloudform-pub-creds.png)

1. If you have deployed Amazon RDS instances, a page similar to the following will appear as part of the deployment wizard\. You can use this page to add the Amazon EC2 instances for your deployment to one or more of the Amazon RDS security groups associated with your RDS instances\. If your application needs to access your RDS instances, you will need to enable this access here or by setting the permissions on your RDS security groups\. For more information, see [Amazon RDS Security Groups](rds-security-groups.md#tkv-amazon-rds-security-groups)\.

   If you are deploying to a VPC, this page will not appear because for VPCs, RDS instances are managed by Amazon EC2 security groups\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-aeb-rds-sg.png)

1. On the **Review** page, review the options you configured earlier, and select **Open environment status window when wizard closes**\.

   If everything looks correct, choose **Deploy**\.
**Note**  
When you deploy the application, the active account will incur charges for the AWS resources used by the application\.

   You can save the deployment configuration to a text file to use with standalone deployment tool\. To save the configuration, select **Generate AWSDeploy configuration**\. Choose **Choose File** and then specify a file to which to save the configuration\. You can also save the deployment configuration after the deployment is complete\. In AWS Explorer, open the context \(right\-click\) menu for the deployment and choose **Save Configuration**\.
**Note**  
When you deploy the application, the active account will incur charges for the AWS resources used by the application\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-aeb-review-dlg.png)

1. A status page for the deployment will open\. The deployment may take a few minutes\.

   When the deployment is complete, the Toolkit will display an alert\. This is useful because it allows you to focus on other tasks while the deployment is in progress\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-aeb-launch-toast.png)

   Choose the **Application URL** link to connect to the application\.

1. To delete the deployment, in AWS Explorer, expand the **Elastic Beanstalk** node, open the context \(right\-click\) menu for the subnode for the deployment, and choose **Delete**\. Elastic Beanstalk will begin the deletion process, which might take a few minutes\. If you specified a notification email address in the deployment, Elastic Beanstalk will send status notifications to this address\.

### To create a sample web application starter project<a name="tkv-starter-project"></a>

Follow these steps to create a sample application if you do not have a project ready to deploy\.

1. In Visual Studio, from the **File** menu, choose **New**, and then choose **Project**\.

1. In the **New Project** dialog box, in the navigation pane, expand **Installed**, expand **Templates**, expand **Visual C\#**, and then choose **Web**\.

1. In the list of available web project templates, choose any template containing the words `Web` and `Application` in its description\. For this example, choose **ASP\.NET Web Forms Application**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-new-web-project-console.png)

1. In the **Name** box, type `AEBWebAppDemo`\.

1. In the **Location** box, type the path to a solution folder on your development machine or choose **Browse**, and then browse to and choose a solution folder, and choose **Select Folder**\.

1. Confirm the **Create directory for solution** box is selected\. In the **Solution** drop\-down list, confirm **Create new solution** is selected, and then choose **OK**\. Visual Studio will create a solution and project based on the ASP\.NET Web Forms Application project template\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-web-app-solution-explorer-console.png)

Return to [How to Deploy a Web Application Using Elastic Beanstalk \(Legacy\)](#tkv-deploy-beanstalk-legacy-howto) and complete your deployment\.