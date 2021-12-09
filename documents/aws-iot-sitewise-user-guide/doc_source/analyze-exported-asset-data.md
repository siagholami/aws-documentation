# Analyzing exported data with Amazon Athena<a name="analyze-exported-asset-data"></a>

After you have your asset property data in Amazon S3, you can use several AWS services to generate reports or analyze and query your data:
+ Run SQL queries on your data using [Amazon Athena](https://docs.aws.amazon.com/athena/latest/ug/)\.
+ Perform big data analysis using [Amazon EMR](https://docs.aws.amazon.com/emr/latest/DeveloperGuide/)\.
+ Search and analyze your data using [Amazon Elasticsearch Service](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/)\.

You can find other AWS services that can interact with your data in Amazon S3 listed under **Analytics** in the [AWS Management Console](https://console.aws.amazon.com/)\.

**Note**  
The stack creates an AWS Glue database to format asset property data\. You can't query this database for asset data\. Follow the steps in this section to create an AWS Glue database that you can query\.

In this tutorial, you learn how to configure the prerequisites to use Amazon Athena and how to use Athena to run SQL queries on your exported AWS IoT SiteWise asset data\. To query data with Athena, you must first populate the AWS Glue Data Catalog with your asset data\. The Data Catalog contains databases and tables, and Athena can access data in the Data Catalog\. You can create an AWS Glue crawler that regularly updates the Data Catalog with your exported asset data\.

**Topics**
+ [Configuring a crawler to populate the AWS Glue Data Catalog](#configure-glue-crawler)
+ [Querying data with Athena](#athena-query-data)

## Configuring a crawler to populate the AWS Glue Data Catalog<a name="configure-glue-crawler"></a>

AWS Glue crawlers crawl data stores to populate tables in the AWS Glue Data Catalog\. In this procedure, you create and run an AWS Glue crawler for your S3 bucket that contains exported asset data\. The crawler creates a table for asset property updates and a table for asset metadata\. Then, you can perform SQL queries on these tables with Athena\. For more information, see [Populating the AWS Glue Data Catalog](https://docs.aws.amazon.com/glue/latest/dg/populate-data-catalog.html) and [Defining crawlers](https://docs.aws.amazon.com/glue/latest/dg/add-crawler.html) in the *AWS Glue Developer Guide*\.

**To create an AWS Glue crawler**

1. Navigate to the [AWS Glue console](https://console.aws.amazon.com/glue/)\.

1. In the navigation pane, choose **Crawlers**\.

1. Choose **Add crawler**\.

1. On the **Add crawler** page, do the following:

   1. Enter a name for your crawler, such as **IoTSiteWiseDataCrawler**, and then choose **Next**\.

   1. For **Crawler source type**, choose **Data stores**, and then choose **Next**\.

   1. On the **Add a data store page**, do the following:

      1. For **Choose a data store**, choose **S3**\.

      1. In **Include path**, enter **s3://*DOC\-EXAMPLE\-BUCKET1*** to add your asset data bucket as a data store\. Replace *DOC\-EXAMPLE\-BUCKET1* with the bucket name that you chose when you created the stack\.

      1. Choose **Next**\.  
![\[AWS Glue crawler "Add a data store" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/glue-crawler-add-data-store-console.png)

   1. On the **Add another data store** page, choose **No**, and then choose **Next**\.

   1. On the **Choose an IAM role** page, do the following:

      1. Choose **Create an IAM role** to create a new service role that allows AWS Glue to access the S3 bucket\.

      1. Enter a suffix for your role's name, such as **IoTSiteWiseDataCrawler**\.

      1. Choose **Next**\.

   1. For **Frequency**, choose **Hourly**, and then choose **Next**\. The crawler updates the tables with new data each time it runs, so you can choose any frequency that fits your use case\.

   1. On the **Configure the crawler's output** page, do the following:

      1. Choose **Add database** to create an AWS Glue database for your asset data\.

      1. Enter a name for the database, such as **iot\_sitewise\_asset\_database**\.

      1. Choose **Create**\.

      1. Choose **Next**\.

   1. Review the crawler details, and then choose **Finish**\.  
![\[AWS Glue crawler "Review crawler details" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/glue-review-crawler-console.png)

By default, your new crawler doesn't immediately run\. You must manually run it or wait until it runs on its configured schedule\.

**To run a crawler**

1. On the **Crawlers** page, select the check box for your new crawler, and then choose **Run crawler**\.  
![\[AWS Glue "Crawlers" screenshot with "Run crawler" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/glue-run-crawler-console.png)

1. Wait until the crawler finishes and has a status of **Ready**\.

   The crawler can take several minutes to run, and its status updates automatically\.

1. In the navigation pane, choose **Tables**\.

   You should see two new tables: **asset\_metadata** and **asset\_property\_updates**\.

## Querying data with Athena<a name="athena-query-data"></a>

Athena automatically discovers your asset data tables in the AWS Glue Data Catalog\. To perform queries on the intersection of these tables, you can create a view, which is a logical data table\. For more information, see [Working with views](https://docs.aws.amazon.com/athena/latest/ug/views.html) in the *Amazon Athena User Guide*\.

After you create a view that combines asset property data and metadata, you can run queries that output property values with asset and property names attached\. For more information, see [Running SQL queries using Amazon Athena](https://docs.aws.amazon.com/athena/latest/ug/querying-athena-tables.html) in the *Amazon Athena User Guide*\.

**To query asset data with Athena**

1. Navigate to the [Athena console](https://console.aws.amazon.com/athena/)\.

   If the **Getting started** page appears, choose **Get Started**\.

1. If you're using Athena for the first time, complete the following steps to configure an S3 bucket for query results\. Athena stores the results of your queries in this bucket\.
**Important**  
Use a different bucket than your asset data bucket, so the crawler that you created earlier doesn't crawl query results\. We recommend that you create a bucket to use only for Athena query results\. For more information, see [How do I create an S3 bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/create-bucket.html) in the *Amazon Simple Storage Service Console User Guide*\.

   1. Choose **Settings**\.

   1. In **Query result location**, enter the S3 bucket for Athena query results\. The bucket must end with `/`\.  
![\[Athena "Settings" screenshot with "Query result location" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/athena-configure-query-result-location-console.png)

   1. Choose **Save**\.

1. The left panel contains the data source to query\. Do the following:

   1. For **Data source**, choose **AwsDataCatalog** to use the AWS Glue Data Catalog\.

   1. For **Database**, choose the AWS Glue database that you created with the crawler\.  
![\[Athena "Query Editor" screenshot with "Database" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/athena-choose-data-source-console.png)

   You should see two tables: **asset\_metadata** and **asset\_property\_updates**\.

1. To create a view from the combination of asset property data and metadata, enter the following query, and then choose **Run query**\.

   ```
   CREATE
           OR REPLACE VIEW iot_sitewise_asset_data AS
   SELECT "from_unixtime"("time_in_seconds" + ("offset_in_nanos" / 1000000000)) "timestamp",
            "metadata"."asset_name",
            "metadata"."asset_property_name",
            "data"."asset_property_value",
            "metadata"."asset_property_unit",
            "metadata"."asset_property_alias"
   FROM ( "iot_sitewise_asset_database".asset_property_updates data
   INNER JOIN "iot_sitewise_asset_database".asset_metadata metadata
       ON ( ("data"."asset_id" = "metadata"."asset_id")
           AND ("data"."asset_property_id" = "metadata"."asset_property_id") ) );
   ```

   This query joins the asset property data and metadata tables on asset ID and property ID to create a view\. You can run this query multiple times because it replaces the existing view if the view already exists\.

1. Choose the **\+** icon to add a new query\.

1. To view a sample of asset data, enter the following query, and then choose **Run query**\. Replace the timestamps with an interval for which your bucket has data\.

   ```
   SELECT *
   FROM "iot_sitewise_asset_database"."iot_sitewise_asset_data"
   WHERE "timestamp"
       BETWEEN TIMESTAMP '2020-05-14 12:00:00.000'
           AND TIMESTAMP '2020-05-14 13:00:00.000'
   ORDER BY  "timestamp" DESC LIMIT 50;
   ```

   This query outputs up to 50 data points between two timestamps, with the most recent entries shown first\.

   Your query output might look similar to the following results\.  
![\[Athena "Query Editor" screenshot with "Run query" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/athena-run-sample-query-console.png)

You can now run queries useful to your AWS IoT SiteWise application\. For more information, see [SQL reference for Amazon Athena](https://docs.aws.amazon.com/athena/latest/ug/ddl-sql-reference.html) in the *Amazon Athena User Guide*\.