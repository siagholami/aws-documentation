# How to Specify the AWS Security Credentials for Your Application<a name="deployment-beanstalk-specify-credentials"></a>

The AWS account you specify in the **Publish to Elastic Beanstalk** wizard \(or the legacy version of this wizard, **Publish to Amazon Web Services**\) is the AWS account the wizard will use for deployment to Elastic Beanstalk\.

Although not recommended, you may also need to specify AWS account credentials that your application will use to access AWS services after it has been deployed\. The preferred approach is to specify an IAM role\. In the **Publish to Elastic Beanstalk** wizard, you do this through the **Identity and Access Management Role** drop\-down list on the **AWS Options** page\. In the legacy **Publish to Amazon Web Services** wizard, you do this through the **IAM Role** drop\-down list on the **AWS Options** page\.

If you must use AWS account credentials instead of an IAM role, you can specify the AWS account credentials for your application in one of the following ways:
+ Reference a profile corresponding to the AWS account credentials in the `appSettings` element of the project's `Web.config` file\. \(To create a profile, see [Configuring AWS Credentials](https://docs.aws.amazon.com/sdk-for-net/latest/developer-guide/net-dg-config-creds.html)\.\) The following example specifies credentials whose profile name is `myProfile`\.

  ```
  <appSettings>
    <!-- AWS CREDENTIALS -->
    <add key="AWSProfileName" value="myProfile"/>
  </appSettings>
  ```
+ If you're using the **Publish to Elastic Beanstalk** wizard, on the **Application Options** page, in the **Key** row of the **Key** and **Value** area, choose **AWSAccessKey**\. In the **Value** row, type the access key\. Repeat these steps for **AWSSecretKey**\.
+ If you're using the legacy **Publish to Amazon Web Services** wizard, on the **Application Options** page, in the **Application Credentials** area, choose **Use these credentials**, and then type the access key and secret access key into the **Access Key** and **Secret Key** boxes\.