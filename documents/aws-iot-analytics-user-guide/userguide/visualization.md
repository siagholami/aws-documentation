# Visualizing AWS IoT Analytics Data with QuickSight<a name="visualization"></a>

AWS IoT Analytics provides direct integration with [Amazon QuickSight](https://quicksight.aws)\. Amazon QuickSight is a fast business analytics service you can use to build visualizations, perform ad\-hoc analysis, and quickly get business insights from your data\. Amazon QuickSight enables organizations to scale to hundreds of thousands of users, and delivers responsive performance by using a robust in\-memory engine \(SPICE\)\. You can select your AWS IoT Analytics data sets in the QuickSight console and start creating dashboards and visualizations\. Amazon QuickSight is available in [these regions](https://docs.aws.amazon.com/general/latest/gr/rande.html#quicksight_region)\.

To get started with your QuickSight visualizations, you must create a QuickSight account\. Make sure you give QuickSight access to your AWS IoT Analytics data when you set up your account\. If you already have an account, give QuickSight access to your AWS IoT Analytics data by choosing **Admin**, **Manage QuickSight**, **Account Settings**\. Under **Connected products & services** choose **Add or remove**, then check the box next to **AWS IoT Analytics** and select **Update**\.

After your account is set up, from the main QuickSight console page choose **New Analysis** and **New data set**, and then select AWS IoT Analytics as the source\. Type a name for your data source, select a data set to import, and then choose **Create data source**\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/SelectQSDataSet.png)

After your data source is created, you can create visualizations in QuickSight:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/CreateQSVisualization.png)

For information about QuickSight dashboards and data sets, see the [QuickSight documentation](https://aws.amazon.com/documentation/quicksight/)\.