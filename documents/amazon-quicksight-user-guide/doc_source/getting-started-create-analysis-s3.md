# Create an Analysis Using Your Own Amazon S3 Data<a name="getting-started-create-analysis-s3"></a>

To create your first analysis using your own Amazon S3 data, follow these steps:

**Topics**
+ [Step 1: Create an Amazon S3 Data Set and an Analysis](#step-1-create-s3-data-set-and-analysis)
+ [Step 2: Create a Visual](#step-2-create-s3-visual)

## Step 1: Create an Amazon S3 Data Set and an Analysis<a name="step-1-create-s3-data-set-and-analysis"></a>

Complete the following procedure to create a data set and an analysis:

1. Create a manifest file to identify the S3 files you want to import, using one of the formats specified in [Supported Formats for Amazon S3 Manifest Files](supported-manifest-file-format.md)\.

1. Check [Data Source Limits](data-source-limits.md) to make sure your target file set doesn't exceed data source limits\.

1. Either save the manifest file to a local directory or upload it into Amazon S3\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data set** page, choose the Amazon S3 icon\.

1. For **Data source name**, type a name for the data source\.

1. For **Upload a manifest file**, do one of the following options:
   + Choose **URL** and type or paste in a URL for the manifest file\. You can find this in the Amazon S3 console by right\-clicking on the manifest file, choosing **Properties**, and looking at the **Link** field\.
   + Choose **Upload** and then choose **Upload a JSON manifest file**\. In **Open**, browse to a file, select it, and then choose **Open**\.

1. Choose **Connect**\.

1. Choose **Visualize**\.

## Step 2: Create a Visual<a name="step-2-create-s3-visual"></a>

Next, create a visual\.

In the **Fields list** pane of the analysis page, choose the fields you want to use\.

Amazon QuickSight creates the visual, using AutoGraph to determine the most appropriate visual type for the fields you selected\. For more information about AutoGraph, see [Using AutoGraph](autograph.md)\. For more information about modifying the visual, see [Working with Amazon QuickSight Visuals](working-with-visuals.md)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/visual-fields1.png)