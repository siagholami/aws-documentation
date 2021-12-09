# Tutorial: Create a Prepared Data Set<a name="example-prepared-data-set"></a>

Use the following procedure to prepare the Marketing data set and create an analysis\. If you don't see the Web and Social Media Analytics sample data already in Amazon QuickSight, you can download it from [http://quicksightsampledata\.s3\.amazonaws\.com/MarketingData\_QuickSightSample\.csv](http://quicksightsampledata.s3.amazonaws.com/MarketingData_QuickSightSample.csv)\.

1. On the Amazon QuickSight start page, choose **Manage data**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-manage-data.png)

1. On the **Your data sets** page, choose **New data set**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-new-data-set.png)

1. In the **FROM EXISTING DATA SOURCES** section of the **Create a Data Set** page, choose the **Web and Social Media Analytics** Amazon S3 data source and then choose **Edit/Preview data**\.

   Amazon QuickSight opens the data preparation page\.

1. Name the data set\.

   Highlight **Group 1** in the data set name box, and type **Marketing Sample**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-ds-name.png)

1. Change the field selection to remove some fields we won't be working with\.

   In the **Fields** pane, unselect the **Twitter followers cumulative** and **Mailing list cumulative** fields\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-ds-fields.png)

1. Rename a field\.

   In the data preview pane, scroll to the **Website Pageviews** field and choose the edit icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example3a.png)

   Highlight the field name, type **Website page views**, and then choose **Apply**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example3.png)

1. Add a calculated field that substitutes a text string for any 0\-length string value in the **Events** field\.

   1. On the data preparation page, expand the **Fields** pane, and then choose **New Field**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-field.png)

   1. In the **New calculated field** pane, highlight the value in **Calculated field name**, and then type **populated\_event**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-calc-field1.png)

   1. Choose the **ifelse** function from the **Function list** and then choose **Add**\. This adds the function to the calculated field formula\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-calc-field2.png)

   1. Scroll down in the **Field list**, choose the **Events** field, and then choose **Add**\. This adds the field to the calculated field formula\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-calc-field3.png)

   1. In **Formula**, type the additional functions and parameters required, highlighted following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-calc-field6.png)

   1. Choose **Create**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-calc-field7.png)

      The new calculated field is created, and appears in the **Calculated fields** section at the top of the **Fields** pane\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-calc-field8.png)

1. Choose **Save**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-ds-save.png)

## Next Steps<a name="example-next-step-data-set"></a>

Create an analysis by using the procedure in [Tutorial: Create an Analysis](example-create-an-analysis.md)\.