# Step 5: Create Your Aurora MySQL Target Endpoint<a name="CHAP_On-PremOracle2Aurora.Steps.CreateAurora"></a>

Next, you can provide information for the target Amazon Aurora MySQL database by specifying the target endpoint settings\. The following table describes the target settings\.

**To specify a target database endpoints using the AWS Management Console**

1. In the AWS DMS console, choose **Endpoints** on the navigation pane\. 

1. Choose **Create endpoint**\. The **Create database endpoint page** appears, as shown following\.  
![\[Create source and target DB endpoints\]](http://docs.aws.amazon.com/dms/latest/sbs/images/datarep-gs-wizard3.png)

1. Specify your connection information for the target Aurora MySQL database\. The following table describes the target settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_On-PremOracle2Aurora.Steps.CreateAurora.html)

1. Choose the **Advanced** tab to set values for extra connection strings and the encryption key if you need them\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_On-PremOracle2Aurora.Steps.CreateAurora.html)

Prior to saving your endpoint, you have an opportunity to test it\. To do so you’ll need to select a VPC and replication instance from which to perform the test\. 