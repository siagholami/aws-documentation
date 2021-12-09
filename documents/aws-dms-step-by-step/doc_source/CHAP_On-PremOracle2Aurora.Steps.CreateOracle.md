# Step 4: Create Your Oracle Source Endpoint<a name="CHAP_On-PremOracle2Aurora.Steps.CreateOracle"></a>

While your replication instance is being created, you can specify the Oracle source endpoint using the AWS Management Console\. However, you can only test connectivity after the replication instance has been created, because the replication instance is used to test the connection\.

**To specify source or target database endpoints using the AWS console**

1. In the AWS DMS console, choose **Endpoints** on the navigation pane\. 

1. Choose **Create endpoint**\. The **Create database endpoint page** appears, as shown following\.  
![\[Create source and target DB endpoints\]](http://docs.aws.amazon.com/dms/latest/sbs/images/datarep-gs-wizard3.png)

1. Specify your connection information for the source Oracle database\. The following table describes the source settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_On-PremOracle2Aurora.Steps.CreateOracle.html)

1. Choose the **Advanced** tab to set values for extra connection strings and the encryption key\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_On-PremOracle2Aurora.Steps.CreateOracle.html)

Before you save your endpoint, you can test it\. To do so, select a VPC and replication instance from which to perform the test\. As part of the test AWS DMS refreshes the list of schemas associated with the endpoint\. \(The schemas are presented as source options when creating a task using this source endpoint\.\)