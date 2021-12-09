# Refreshing Data<a name="refreshing-imported-data"></a>

You can refresh your [SPICE](welcome.md#spice) data sets at any time\. Refreshing imports the data into SPICE again, so the data includes any changes since the last import\. 

You can refresh SPICE data by taking any of the following approaches: 
+ You can use the options on the **Your Data Sets** page\. 
+ You can refresh a data set during data preparation\.
+ You can schedule refreshes of the data\.

 In the following sections, you can find an explanation of each approach\. 

**Topics**
+ [Refreshing a Data Set from the Your Data Sets Page](#refresh-spice-data)
+ [Refreshing a Data Set During Data Preparation](#refresh-spice-data-prep)
+ [Refreshing a Data Set on a Schedule](#schedule-data-refresh)

For data that is not stored in SPICE, you can do the following:
+  To refresh file\-based data, you must delete and recreate the data set\. 
+  To refresh data from a database, reopen your data set or the visualization you created\. 

## Refreshing a Data Set from the Your Data Sets Page<a name="refresh-spice-data"></a>

Use the following procedure to refresh a [SPICE](welcome.md#spice) data set based on an Amazon S3 or database data source on the **Your Data Sets** page\.

**To refresh SPICE data from the Your Data Sets page**

1. On the **Your Data Sets** page, choose the data set, and then choose **Refresh Now**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/refresh-now.png)

1. Leave the refresh type as **Full refresh**\.

1. If you are refreshing an Amazon S3 data set, choose one of the following options for **S3 Manifest**:
   + To use the same manifest file you last provided to Amazon QuickSight, choose **Existing Manifest**\. If you have changed the manifest file at the file location or URL that you last provided, the data returned reflects those changes\. 
   + To specify a new manifest file by uploading it from your local network, choose **Upload Manifest**, and then choose **Upload manifest file**\. For **Open**, choose a file, and then choose **Open**\.
   + To specify a new manifest file by providing a URL, type the URL of the manifest in **Input manifest URL**\. You can find the manifest file URL in the Amazon S3 console by opening the context \(right\-click\) menu for the manifest file, choosing **Properties**, and looking at the **Link** box\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/s3-refresh.png)

1. Choose **Refresh**\.

1. If you are refreshing an Amazon S3 data set, choose **OK**, then **OK** again\.

   If you are refreshing a database data set, choose **OK**\.

## Refreshing a Data Set During Data Preparation<a name="refresh-spice-data-prep"></a>

Use the following procedure to refresh a [SPICE](welcome.md#spice) data set based on an Amazon S3 or database data source during data preparation\.

**To refresh SPICE data during data preparation**

1. On the **Your Data Sets** page, choose the data set, and then choose **Edit Data Set**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/edit-data-set2.png)

1. On the pane, choose **Refresh now**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/data-prep-refresh.png)

1. Leave the refresh type as **Full refresh**\.

1. If you are refreshing an Amazon S3 data set, choose one of the following options for **S3 Manifest**:
   + To use the same manifest file you last provided to Amazon QuickSight, choose **Existing Manifest**\. If you have changed the manifest file at the file location or URL that you last provided, the data returned reflects those changes\.
   + To specify a new manifest file by uploading it from your local network, choose **Upload Manifest**, and then choose **Upload manifest file**\. For **Open**, choose a file, and then choose **Open**\.
   + To specify a new manifest file by providing a URL, type the URL of the manifest in **Input manifest URL**\. You can find the manifest file URL in the Amazon S3 console by opening the context \(right\-click\) menu for the manifest file, choosing **Properties**, and looking at the **Link** box\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/s3-refresh.png)

1. Choose **Refresh**\.

1. If you are refreshing an Amazon S3 data set, choose **OK**, then **OK** again\.

   If you are refreshing a database data set, choose **OK**\.

## Refreshing a Data Set on a Schedule<a name="schedule-data-refresh"></a>

Use the following procedure to schedule refreshing the data\. If your data set is based on a direct query and not stored in [SPICE](welcome.md#spice), you can refresh your data by opening the data set or refreshing the page in an analysis or dashboard\.

**To refresh [SPICE](welcome.md#spice) data on a schedule**

1. On the **Your Data Sets** page, choose the data set, and then choose **Schedule refresh**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/SchRefresh_ChooseScheduleRefresh.png)

1. For **Schedule Refresh**, choose **Create**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/SchRefresh_ChooseCreate.png)

1. On the **Create a Schedule** screen, choose settings for your schedule\. 

   1. **Time zone**: Choose the time zone that applies to the data refresh\.

   1. For **Repeats**: Choose one of the following:
      + For Standard or Enterprise editions, you can choose **Daily**, **Weekly**, or **Monthly**\. 
        + **Daily**: Repeats every day
        + **Weekly**: Repeats on the same day of each week 
        + **Monthly**: Repeats on the same day number of each month\. To refresh data on the 29th, 30th or 31st day of the month, choose **Last day of month** from the list\. 
      + For Enterprise edition only, you can choose **Hourly**\. This setting refreshes your data set every hour, beginning at the time you choose\. So, if you select 1:05 as the starting time, the data refreshes at five minutes after the hour, every hour\.

        If you decide to use an hourly refresh, you can't also use additional refresh schedules\. To create an hourly schedule you must remove any other existing schedules for that data set; and you must remove any existing hourly schedule before you can create a daily, weekly, or monthly schedule\. 

   1. **Starting**: Choose a date for the refresh to start\.

   1. **At**: Specify the time that the refresh should start\. Use HH:MM and 24\-hour format, for example 13:30\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/SchRefresh_CreateSchedule_day_week_mo.png)

1.  Choose **Create**\. 

You can create five schedules for each data set\. When you have created five, the **Create** button is disabled\. 