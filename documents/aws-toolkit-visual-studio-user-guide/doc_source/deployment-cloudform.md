# Deploying to AWS CloudFormation \(Legacy\)<a name="deployment-cloudform"></a>

**Note**  
The information in this topic refers to the **Publish to Amazon Web Services** wizard, which has been replaced by deploying through Elastic Beanstalk through the use of the **Publish to Elastic Beanstalk** wizard\. The following information is provided for those who prefer to, or must, use the legacy wizard to deploy through AWS CloudFormation\.  
For information about using the preferred **Publish to Elastic Beanstalk** wizard, see [Deploying to Elastic Beanstalk](deployment-beanstalk.md#tkv-deploy-beanstalk)\.

AWS CloudFormation is a service that simplifies the process of provisioning AWS resources for your application\. The AWS resources are described in a template file\. The AWS CloudFormation service consumes this template and automatically provisions the required resources for you\. For more information, go to [AWS CloudFormation](https://aws.amazon.com/cloudformation/)\.

We'll deploy an application to AWS and use AWS CloudFormation to provision the resources for the application\. To practice, you can use an instance of a web application starter project that is built in to Visual Studio or you can use your own project\.

## To create a sample web application starter project<a name="to-create-a-sample-web-application-starter-project"></a>

Follow these steps if you do not have project ready to deploy\.

1. In Visual Studio, from the **File** menu, choose **New**, and then choose **Project**\.

1. In the navigation pane of the **New Project** dialog box, expand **Installed**, expand **Templates**, expand **Visual C\#**, and then choose **Web**\.

1. In the list of available web project templates, select any template containing the words `Web` and `Application` in its description\. For this example, choose **ASP\.NET Web Forms Application**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-new-web-project-console.png)

1. In the **Name** box, type `AEBWebAppDemo`\.

1. In the **Location** box, type the path to a solution folder on your development machine or choose **Browse**, and then browse to and choose a solution folder, and choose **Select Folder**\.

1. Confirm the **Create directory for solution** box is selected\. In the **Solution** drop\-down list, confirm **Create new solution** is selected, and then choose **OK**\. Visual Studio will create a solution and project based on the ASP\.NET Web Forms Application project template\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-web-app-solution-explorer-console.png)

## To deploy an application by using the legacy Publish to Amazon Web Services wizard<a name="to-deploy-an-application-by-using-the-legacy-publish-to-amazon-web-services-wizard"></a>

1. In Solution Explorer, open the context \(right\-click\) menu for the **AEBWebAppDemo** project folder \(or your own project folder\), and then choose **Publish to AWS**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-publish-to-aws-console.png)

1. On the **Publish to AWS Elastic Beanstalk** page, choose **Use legacy wizard**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-use-legacy-wizard-console.png)

1. On the **Template** page of the wizard, choose the profile you will use for the deployment\. To add a new profile, choose **Other**\. For more information about profiles, see creds\.

1. There are options to deploy a new application or redeploy an application that was deployed previously through either the deployment wizard or the standalone deployment tool\. If you choose a redeployment, there may be a delay while the wizard retrieves information from the previous deployment\.

   The **Load Balanced Template** and **Single Instance Template** are included with the Toolkit for Visual Studio\. **Load Balanced Template** provisions an Amazon EC2 instance with an Elastic Load Balancing load balancer and an Auto Scaling group\. **Single Instance Template** provisions just a single Amazon EC2 instance\.

   For this example, choose **Load Balanced Template**, and then choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-cloudform-pub-dlg.png)

1. On the **AWS Options** page, configure the following:
   + From the **Key pair** drop\-down list, choose an Amazon EC2 key pair\.
   + Leave **SNS Topic** blank\. If you specify an SNS topic, AWS CloudFormation will send status notifications during the deployment\.
   + Leave the **Custom AMI** field blank\. The AWS CloudFormation template includes an AMI\.
   + From the **Instance type** drop\-down list, leave the default set to **Micro**\. This will minimize the cost associated with running the instance\. For more information about Amazon EC2 costs, go to the [EC2 Pricing](https://aws.amazon.com/ec2/pricing/) page\.
   + From the **Security group** drop\-down list, choose a security group that has port 80 open\. If you have already configured a security group with port 80 open, then choose it\. The **default** selection in this drop\-down list does not have port 80 open\.

     Applications deployed to AWS CloudFormation must have port 80 open because AWS CloudFormation uses this port to relay information about the deployment\. If the security group you choose does not have port 80 open, the wizard will ask if it should open it\. If you say yes, port 80 will be open for any Amazon EC2 instances that use that security group\. For more information about creating a security group, see [Managing Security Groups from AWS Explorer](tkv-sg-create.md)\.

   Choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-cloudform-pub-options.png)

1. On the **Application Options** page, in the **Application Credentials** section, choose the profile under which the application \(in this example, `PetBoard`\) should run\. It could be different from the profile used to deploy to AWS CloudFormation \(that is, the profile you specified on the first page of the wizard\)\.

   To use a different set of credentials, choose **Use these credentials** and then type the access key and secret key in the fields provided\.

   To use the same credentials, choose **Use credentials from profile profile\_name** where \{profile\_name\} is the profile you specified on the first page of the wizard\.

   To use the credentials for an AWS Identity and Access Management \(IAM\) user, choose **Use an IAM user**, and then specify the user\.

   To use an IAM user, you must have:
   + created the IAM user in the Toolkit for Visual Studio\.
   + stored the secret key for the user with the Toolkit for Visual Studio\.

   For more information, see [Create and Configure an IAM User](tkv-iam.md#tkv-create-an-iam-user) and [Generate Credentials for an IAM User](tkv-iam.md#generate-credentials-for-an-iam-user-tkv)\.

   An IAM user could have more than one set of credentials stored with the Toolkit\. If that is the case, you will need to choose the credentials to use\. The root account could rotate the credentials for the IAM user, which would invalidate the credentials\. In this scenario, you would need to redeploy the application and then manually enter new credentials for the IAM user\.

   The following table describes other options available on the **Application Options** page\. For `PetBoard`, you can leave the defaults\.  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/deployment-cloudform.html)

   Choose **Finish**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-cloudform-pub-creds.png)

1. On the **Review** page, select **Open environment status window when wizard closes**\.

   You can save the deployment configuration to a text file to use with standalone deployment tool\. To save the configuration, select **Generate AWSDeploy configuration**\. Choose **Choose File** and then specify a file to which to save the configuration\. You can also save the deployment configuration after the deployment is complete\. In AWS Explorer, open the context \(right\-click\) menu for the deployment and choose **Save Configuration**\.
**Note**  
Because the deployment configuration includes the credentials that were used for deployment, you should keep the configuration file in a secure location\.

   Choose **Deploy**\.
**Note**  
When you deploy the application, the active account will incur charges for the AWS resources used by the application\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-cloudform-review-dlg.png)

1. A status page for the deployment will open\. The deployment may take a few minutes\.

   When the deployment is complete, the Toolkit will display an alert\. This is useful because it allows you to focus on other tasks while the deployment is in progress\.

   When the deployment is complete, the status displayed in the Toolkit for Visual Studio will be **CREATE\_COMPLETE**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-cloudform-complete-click-link.png)

   Choose the **Application URL** link to connect to the application\.

1. To delete the deployment, in AWS Explorer, expand the **CloudFormation** node and open the context \(right\-click\) menu for the subnode for the deployment and choose **Delete**\. AWS CloudFormation will begin the deletion process, which might take a few minutes\. If you specified an SNS topic for the deployment, AWS CloudFormation will send status notifications to this topic\.