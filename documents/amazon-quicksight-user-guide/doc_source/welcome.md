# What Is Amazon QuickSight?<a name="welcome"></a>

Amazon QuickSight is a business analytics service you can use to build visualizations, perform ad hoc analysis, and get business insights from your data\. It can automatically discover AWS data sources and also works with your data sources\. Amazon QuickSight enables organizations to scale to hundreds of thousands of users, and delivers responsive performance by using a robust in\-memory engine \(SPICE\)\.

Using Amazon QuickSight, you can do the following:
+ **Get started quickly** – Sign in, choose a data source, and create your first visualization in minutes
+ **Access data from multiple sources ** – Upload files, connect to AWS data sources, or use your own external data sources
+ **Take advantage of dynamic visualizations ** – Smart visualizations are dynamically created based on the fields that you select
+ **Get answers fast ** – Generate fast, interactive visualizations on large data sets
+ **Tell a story with your data** – Create data dashboards and point\-in\-time visuals, share insights and collaborate with others

Amazon QuickSight offers Standard and Enterprise editions\. For more information about Amazon QuickSight editions and pricing, see [Different Editions of Amazon QuickSight](editions.md) and [Amazon QuickSight](https://quicksight.aws.amazon.com/)\.

You can create Amazon QuickSight data sets by using your own data sources or other data sources that are shared with you\. Then you can create [Data Analyses](#analyses), visualize the data, and share it through data dashboards\. To get a first look at how it works, you can explore Amazon QuickSight using the sample data sets we provide\. These can be downloaded from the following links, in case you don't already have them: 
+ [Business overview \(revenue data\)](http://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv)
+ [People overview—human resources \(HR\) data](http://quicksightsampledata.s3.amazonaws.com/HRData_QuickSightSample.csv)
+ [Sales pipeline](http://quicksightsampledata.s3.amazonaws.com/SalesPipeline_QuickSightSample.csv)
+ [Web and social media analytics \(marketing data\)](http://quicksightsampledata.s3.amazonaws.com/MarketingData_QuickSightSample.csv)

There are also a variety of data sets available free online that you can use with Amazon QuickSight, for example:
+ [AWS public datasets](https://aws.amazon.com/public-datasets/)
+ [Eighteen places to find data sets for data science projects](https://www.dataquest.io/blog/free-datasets-for-projects/)
+ [Search for BI sample data](https://www.google.com/search?safe=active&q=bi+sample+data&oq=bi+sample+data)
+ [Search for sample data for visualization](https://www.google.com/search?safe=active&q=sample+data+for+visualization)
+ [Search for Free Sample Databases](https://www.google.com/search?safe=active&q=free+sample+databases)

These data sets come in a variety of formats\. Some may require you to import them into a database engine before you can access their data\.

To learn more about the major components and processes of Amazon QuickSight and the typical workflow for creating data visualizations, see the following sections\.

**Topics**
+ [Data Sources and Data Preparation](#data)
+ [Data Analyses](#analyses)
+ [Dashboards](#dashboards)
+ [Typical Amazon QuickSight Workflow](#workflow)
+ [Next Steps](#next-steps-welcome)
+ [Compliance](#compliance)

## Data Sources and Data Preparation<a name="data"></a>

You can use a variety of sources for data analysis, including files, AWS services, and on\-premises databases\. To learn more about what data sources work with Amazon QuickSight, see [Supported Data Sources](supported-data-sources.md)\.

To get ready to create analyses, you create *data sets* based on your data sources\. A data set identifies the specific fields and rows that you want to use\. In addition to raw data, a data set stores any changes you make, so it's ready the next time you want to analyze the data\. For example, you can rename fields, change data types, and add calculated fields\.

You can create multiple analyses using the same data set\. You can also use multiple data sets in a single analysis\. 

To learn more about creating data sets, see [Creating Data Sets](creating-data-sets.md)\.

### Data Preparation<a name="data-preparation"></a>

Data preparation is the process of transforming raw data for use in an analysis\. This includes making changes like the following: 
+ Filtering out data so you can focus on what's important to you
+ Renaming fields to make them easier to read
+ Changing data types so they are more useful
+ Adding calculated fields to enhance analysis
+ Creating SQL queries to refine data

To learn more about data preparation, see [Preparing Data](preparing-data.md)\.

### SPICE<a name="spice"></a>

*SPICE* is Amazon QuickSight's *Super\-fast, Parallel, In\-memory Calculation Engine*\. SPICE is engineered to rapidly perform advanced calculations and serve data\. The storage and processing capacity available in SPICE speeds up the analytical queries that you run against your imported data\. By using SPICE, you save time because you don't need to retrieve the data every time you change an analysis or update a visual\.

To learn more about using SPICE, see [Managing SPICE Capacity](managing-spice-capacity.md)\.

## Data Analyses<a name="analyses"></a>

A data *analysis* is the basic workspace for creating and interacting with *visuals*, which are graphical representations of your data\. Each analysis contains a collection of visuals that you assemble and arrange for your purposes, such as a sales analysis, cost analysis, or tracking key performance indicators\. Each analysis can contain *stories*, which you can use to save a sequential slide show of different iterations of the analysis\. This is useful if you want to show changes over time or provide visual comparisons of your data\.

To learn more about Amazon QuickSight analyses, see [Working with Analyses](working-with-analyses.md)\.

### Visuals<a name="visuals"></a>

A *visual*, also known as a data visualization, is a graphical representation of a data set using a type of diagram, chart, graph, or table\. All visuals begin in AutoGraph mode, which automatically selects a visualization based on the fields you select\. You can also take control and choose your own visuals\. Amazon QuickSight supports a variety of visuals including combo charts, heat and tree maps, pivot tables, and more\. Or you can enhance your visualizations by applying filters, changing colors, or by arranging several in the workspace, just to name a few options\. 

To learn more about Amazon QuickSight visuals, see [Working with Amazon QuickSight Visuals](working-with-visuals.md)\.

### Sheets<a name="sheets"></a>

A *sheet* is a set of visuals that are all based on the same data source and are all viewed together\. When you create an analysis, you place visuals in the workspace\. After you publish the analysis as a dashboard, the workspace becomes a sheet\. You can imagine this a sheet from a newspaper, except that it is filled with data visualizations\. 

### Stories<a name="stories"></a>

A *story* is a set of one or more *scenes* \(captured visuals\) that you can play like a slideshow\. You can use these to step through different iterations of an analysis\. A scene is a representation of an analysis at a given point in time, or with specific settings\. It shows the visuals that are on the analysis at that time, but the data in those visuals continues to update\. It is not a static snapshot\. You *capture* a scene for use in a story\. 

To learn more about Amazon QuickSight stories, see [Working with Stories](working-with-stories.md)\.

## Dashboards<a name="dashboards"></a>

A *dashboard* is a read\-only snapshot of an analysis that you can share with other Amazon QuickSight users for reporting purposes\. When you create and publish a dashboard, you specify which users have access to it\. They can view and filter the dashboard visuals without changing the underlying data\.

To learn more about Amazon QuickSight dashboards, see [Working with Dashboards](working-with-dashboards.md)\.

## Typical Amazon QuickSight Workflow<a name="workflow"></a>

The first time you create an analysis, the typical workflow looks like this:

1. Add or upload a data source, and use it to create a new data set\.

1. \(Optional\) Prepare the data – get it ready for reports by standardizing field names, or adding calculations, for example\.

1. Visualize \(create\) a new analysis from the data set\.

1. Choose some fields to create the first visual in the analysis\. You can use AutoGraph to dynamically create a visual based on the number and type of fields you choose\. Alternatively, you can choose the visual type you want to use\. 

1. \(Optional\) Make changes to the visual if you want to \(for example, by adding a filter or changing the visual type\)\.

1. \(Optional\) Add more visuals to the analysis\. You can resize and arrange them in the workspace\.

1. \(Optional\) Capture the analysis into a story to create a narrative about some aspect of the data analysis\.

1. \(Optional\) Publish the analysis as a dashboard to share insights with other users\.

After you connect to your data and create a data set, you can create an analysis of it and share it in a dashboard, as shown in the following illustration:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/quicksight-workflow-overview.png)

## Next Steps<a name="next-steps-welcome"></a>

If you are a new to Amazon QuickSight, see [Signing Up for Amazon QuickSight](signing-up.md) to learn more about subscribing\.

If you are an administrator, see [Administration](qsysadmin.md)\.

## Compliance<a name="compliance"></a>

This is a HIPAA Eligible Service\. For more information about AWS, U\.S\. Health Insurance Portability and Accountability Act of 1996 \(HIPAA\), and using AWS services to process, store, and transmit protected health information \(PHI\), see [HIPAA Overview](https://aws.amazon.com/compliance/hipaa-compliance/)\.

For information about this service and ISO 27001, a security management standard that specifies security management best practices, see [ISO 27001 Overview](https://aws.amazon.com/compliance/iso-27001-faqs/)\.

Content delivered to Amazon S3 buckets might contain customer content\. For more information about removing sensitive data, see [How Do I Empty an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/empty-bucket.html) or [How Do I Delete an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/delete-bucket.html)\.