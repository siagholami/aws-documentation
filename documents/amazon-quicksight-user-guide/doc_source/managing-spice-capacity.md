# Managing SPICE Capacity<a name="managing-spice-capacity"></a>

You can use the admin page to see how much [SPICE](welcome.md#spice) capacity you have overall, and how much of that you are using\. SPICE capacity is allocated by AWS Region, so the information displayed is for the currently selected AWS Region\.

SPICE stores your data until you choose to delete it\. You can improve performance by importing the data into SPICE instead of using a direct query to the database\. All nondatabase data sets must use SPICE\.

SPICE capacity is pooled across users for the Amazon QuickSight account\. All of your default SPICE capacity is allocated to your home AWS Region\. The other AWS Regions have no SPICE capacity unless you choose to purchase some\.

To free up SPICE capacity, delete unused data sets from SPICE\. For more information about deleting a data set, see [Deleting a Data Set](delete-a-data-set.md)\. 

You can purchase additional SPICE capacity if you want to, up to a limit of 1 TB total capacity per QuickSight account\. If you need an exception to this limit, follow the instructions at [AWS Service Limits](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html) to submit a limit increase request\. You can also release purchased SPICE capacity that you aren't using\. Purchasing or releasing SPICE capacity only affects the capacity for the currently selected AWS Region\. For information about additional SPICE pricing, see [Amazon QuickSight](https://quicksight.aws.amazon.com/)\.

## Capacity Planning for SPICE<a name="capacity-planning-for-spice"></a>

The amount of SPICE capacity a data set uses isn't the same as the size of its source file or table\. The logical size computation occurs after all the data type transformations and calculated columns you define during data preparation\. These fields are materialized in SPICE in a way that enhances query performance\. Any changes you make in an analysis have no effect on the logical size of the data in SPICE\. Only changes that are saved in the data set apply to SPICE capacity\.

In capacity planning for SPICE, consider what data types will be defined in the data set\. For example, the file you want to import may contain all strings \(text\)\. But in order for these to be used in a meaningful way in an analysis, you prepare the data by changing the data types to their proper form\. For example, fields containing prices are changed from strings to decimals, and fields containing dates are changed from strings to dates\. If you create a calculation to make the conversion, you can remove the original field from the data set and substitute the formatted calculated field\. In that case, you don't need to include the size of the original field in your capacity planning\. Only included fields are stored in SPICE\.

**Note**  
Geospatial data types use metadata to interpret the physical data type\. Latitutde and longitude are numeric\. All other geospatial categories are strings\. 

To calculate how much SPICE capacity your data set needs, multiply the number of rows by the number of bytes SPICE uses per row\. Currently, SPICE needs 8 bytes per field for decimal, int, and date fields\. For each string field \(text\), SPICE needs 8 bytes plus the UTF\-8 encoded character length\. The formula looks like this:

```
Total logical row size in bytes =
   (Number of Numeric Fields *  8 bytes per field)
 + (Number of Date Fields    *  8 bytes per field)
 + (Number of Text Fields    * (8 bytes + UTF-8 encoded character length per field) )

Total bytes of data = Number of rows * Total logical row size in bytes

GB of SPICE Capacity Needed = Total bytes of data / 1,073,741,824
```

For example, let's say you have a table with 5,000,000 rows that you want to import into SPICE\. It has 30 numeric fields, 20 date fields, and10 string fields of 100 bytes each\. Your formula looks like this:

```
Total logical row size in bytes = 
1480 bytes =
   (30 * 8)
 + (20 * 8)
 + (10 * (8 + 100) )

Total bytes of data = 
5,000,000 rows * 1480 bytes =
7,400,000,000 bytes

GB of SPICE Capacity Needed = 7,400,000,000 / 1,073,741,824 = 7 GB
```

## View SPICE Capacity and Usage<a name="view-spice-capacity"></a>

Use the following procedure to review your SPICE capacity and usage\.

1. Choose your user name on the application bar, and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)
**Note**  
If you are low on SPICE capacity, you can also choose the **Buy SPICE** alert that appears on the **Your Data Sets** and **Create a Data Set** pages\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/buy-spice.png)

1. Choose **SPICE Capacity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-capacity2.png)

1. Use the **Total SPICE Capacity** meter to see your SPICE capacity, broken out by type\. Capacity types are as follows:
   + Free tier: This is the 1 GB of capacity associated with the free user that you get with every Amazon QuickSight account\.
   + Free bundled: This is the total default capacity associated with your paid users\. You get 10 GB of default SPICE capacity per paid user\.
   + Purchased: This is the additional SPICE capacity you have purchased\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-capacity.png)

   Hover over any section of the meter to see details on that capacity type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-capacity-detail.png)

1. Use the **SPICE Usage** meter to see your SPICE usage, broken out by type\. Usage types are as follows:
   + Used capacity: This is used portion of the default SPICE capacity you get per user\.
   + Unused capacity: This is unused portion of the default SPICE capacity you get per user\.
   + Releasable unused capacity: This is purchased capacity that isn't in use, and so can be released to reduce costs\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-usage.png)

   Hover over any section of the meter to see details on that usage type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-usage-detail.png)

## Purchase SPICE Capacity<a name="purchase-spice-capacity"></a>

Use the following procedure to purchase additional [SPICE](welcome.md#spice) capacity\.

1. Choose your user name on the application bar and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)
**Note**  
If you are low on SPICE capacity, you can also choose the **Buy SPICE** alert that appears on the **Your Data Sets** and **Create a Data Set** pages\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/buy-spice.png)

1. Choose **SPICE Capacity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-capacity2.png)

1. Choose **Purchase more capacity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/more-capacity.png)

1. For **How much SPICE capacity do you need?**, type the number of gigabytes \(GBs\) you want to purchase\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/more-capacity1.png)

1. Choose **Purchase SPICE capacity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/more-capacity2.png)

## Release SPICE Capacity<a name="release-spice-capacity"></a>

Use the following procedure to release unused purchased [SPICE](welcome.md#spice) capacity\.

1. Before you begin, delete data sets that are using the SPICE capacity you want to release\. To learn more about deleting data sets, see [Deleting a Data Set](delete-a-data-set.md)\. 

1. Choose your user name on the application bar and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)

1. Choose **SPICE Capacity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-capacity2.png)

1. Choose **Release unused purchased capacity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/less-capacity.png)

1. For **How much SPICE capacity do you need to release?**, choose **Release all** if you want to release all unused purchased capacity, or choose **Release <amount> GB** and type the number of gigabytes \(GBs\) that you want to release\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/release-capacity.png)

1. Choose **Release SPICE capacity**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/release-capacity2.png)