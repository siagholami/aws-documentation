# Visualizing AWS IoT Analytics data<a name="data-visualization"></a>

To visualize your AWS IoT Analytics data, you can use the AWS IoT Analytics console or Amazon QuickSight\.

**Topics**
+ [Visualizing AWS IoT Analytics data with the console](#visualization-console)
+ [Visualizing AWS IoT Analytics data with Amazon QuickSight](#visualization-quicksight)

## Visualizing AWS IoT Analytics data with the console<a name="visualization-console"></a>

AWS IoT Analytics can embed the HTML output of your container dataset \(found in the file `output.html`\) on the container dataset content page of the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/)\. For example, if you define a container dataset that runs a Jupyter notebook, and you create a visualization in your Jupyter notebook, your dataset might look like the following\.

![\[Screenshot of a visualization in a Jupyter Notebook\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/console-vis1.png)

Then, after the container dataset content is created, you can view this visualization on the console's **Data Set** content page\.

![\[Screenshot of a dataset visualization.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/console-vis2.png)

For information about creating a container dataset that runs a Jupyter notebook, see [Automating your workflow](https://docs.aws.amazon.com/iotanalytics/latest/userguide/automate.html#aws-iot-analytics-automate)\.

## Visualizing AWS IoT Analytics data with Amazon QuickSight<a name="visualization-quicksight"></a>

AWS IoT Analytics provides direct integration with [Amazon QuickSight](https://aws.amazon.com/quicksight/)\. Amazon QuickSight is a fast business analytics service you can use to build visualizations, perform ad\-hoc analysis, and quickly get business insights from your data\. Amazon QuickSight enables organizations to scale to hundreds of thousands of users, and delivers responsive performance by using a robust in\-memory engine \(SPICE\)\. You can select your AWS IoT Analytics datasets in the Amazon QuickSight console and start creating dashboards and visualizations\. Amazon QuickSight is available in [these Regions](https://docs.aws.amazon.com/general/latest/gr/quicksight.html)\.

To get started with your Amazon QuickSight visualizations, you must create a Amazon QuickSight account\. Make sure you give Amazon QuickSight access to your AWS IoT Analytics data when you set up you account\. If you already have an account, give Amazon QuickSight access your AWS IoT Analytics data by choosing **Admin**, **Manage QuickSight**, **Security & permissions**\. Under **QuickSight access to AWS services**, choose **Add or remove**, then select the check box next to **AWS IoT Analytics** and choose **Update**\.

![\[Screenshot of the Amazon QuickSight console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/qs-security-and-permissions.png)

After your account is set up, from the admin Amazon QuickSight console page choose **New Analysis** and **New data set**, and then choose AWS IoT Analytics as the source\. Enter a name for your data source, choose a dataset to import, and then choose **Create data source**\.

![\[Screenshot of how to create a new data source in Amazon QuickSight.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/SelectQSDataSet.png)

After your data source is created, you can create visualizations in Amazon QuickSight\.

![\[Screenshot of an dashboard in Amazon QuickSight.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/CreateQSVisualization.png)

For information about Amazon QuickSight dashboards and datasets, see the [Amazon QuickSight documentation](https://docs.aws.amazon.com/quicksight/index.html)\.