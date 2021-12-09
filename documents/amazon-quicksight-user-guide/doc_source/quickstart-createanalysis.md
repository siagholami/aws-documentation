# Quick Start: Create an Analysis with a Single Visual Using Sample Data<a name="quickstart-createanalysis"></a>

Use the following procedure to use the Web and Social Media Analytics sample data set to create an analysis containing a line chart visual\. This visual shows the count by month of people that have added themselves to the mailing list\. 

1. On the Amazon QuickSight start page, choose **New analysis**\. If you don't have the sample data, you can download it from [http://quicksightsampledata\.s3\.amazonaws\.com/MarketingData\_QuickSightSample\.csv](http://quicksightsampledata.s3.amazonaws.com/MarketingData_QuickSightSample.csv)\. 

   To upload the sample data, use the following steps:

   1. Choose **New data set** from the **New analysis** screen\. \(Or, choose **Manage data** to locate the **New data set** screen\.\)

   1. Choose **Upload a file**\.

   1. Choose the sample file, `MarketingData_QuickSightSample.csv`, from your drive\.

   1. Confirm file upload settings by choosing **Next** on the **Confirm file upload settings** screen\.

   1. Choose **Visualize** on the **Data source details** screen\.

   1. Skip the next step\. Choosing **Visualize** brings you to the same screen as the process in Step 2\.

1. On the **Your data sets** page, choose the **Web and Social Media Analytics** data set, and then choose **Create Analysis**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/quickstart-analysis.png)

1. In the **Fields list** pane, choose **Date**, and then choose **Mailing list adds**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/quickstart-fields.png)

   Amazon QuickSight uses AutoGraph to create the visual, selecting the visual type that it determines is most compatible with those fields\. In this case, it selects a line chart that shows mailing list adds by year, which is the date granularity default\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/quickstart-visual.png)

1. Expand the **Field wells** pane by choosing the expand icon\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/quickstart-expand.png)

1. Choose the **X axis** field well, choose **Aggregate**, and then choose **Month**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/quickstart-date.png)

   The line chart updates to show mailing list adds by month, rather than by the default of by year\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/quickstart-visual2.png)