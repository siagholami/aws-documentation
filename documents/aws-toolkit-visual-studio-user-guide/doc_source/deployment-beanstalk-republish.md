# How to Republish Your Application to an Elastic Beanstalk Environment<a name="deployment-beanstalk-republish"></a>

You can iterate on your application by making discrete changes and then republishing a new version to your already launched Elastic Beanstalk environment\.

1. In Solution Explorer, open the context \(right\-click\) menu for the **AEBWebAppDemo** project folder for the project you published in the previous section, and choose **Publish to AWS Elastic Beanstalk**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-publish-to-aws-console.png)

   The **Publish to Elastic Beanstalk** wizard appears\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-aeb-wizard-app-console2.png)

1. Select **Redeploy to an existing environment** and choose the environment you previously published to\. Click **Next**\.

   The **Review** wizard appears\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-aeb-wizard-app-review.png)

1. Click **Deploy**\. The application will redeploy to the same environment\.

You cannot republish if your application is in the process of launching or terminating\.