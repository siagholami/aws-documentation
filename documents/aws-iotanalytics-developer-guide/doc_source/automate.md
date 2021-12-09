# Automating your workflow<a name="automate"></a>

AWS IoT Analytics provides advanced data analysis for AWS IoT\. You can automatically collect IoT data, process it, store it and analyze it using data analysis and machine\-learning tools\. You can execute containers that host your own custom analytical code or Jupyter Notebook or use third party custom code containers so you don't have to recreate existing analytical tools\. You can use the following capabilities to take input data from a data store and feed it into an automated workflow:

**Create dataset content on a recurring schedule**  
Schedule the automatic creation of dataset content by specifying a trigger when you call `CreateDataset` \(`triggers:schedule:expression`\)\. Data that has in a data store is used to create the dataset content\. You select the fields you want by using a SQL query \(`actions:queryAction:sqlQuery`\)\.  
Define a non\-overlapping, contiguous time interval to ensure the new dataset content contains only that data which has arrived since the last time\. Use the `actions:queryAction:filters:deltaTime` and `:offsetSeconds` fields to specify the delta time interval\. Then specify a trigger to create the dataset content when the time interval has elapsed\. See [Example 6 \-\- creating a SQL dataset with a delta window \(CLI\)](https://docs.aws.amazon.com/iotanalytics/latest/userguide/automate.html#aws-iot-analytics-automate-example-createdataset6)\.

**Create dataset content upon completion of another dataset**  
Trigger creation of new dataset content when another dataset's content creation is complete `triggers:dataset:name`\.

**Automatically run your analysis applications**  
Containerize your own, custom data analysis applications and trigger them to run when another dataset's content is created\. This way, you can feed your application with data from a dataset's content that is created on a recurring schedule\. You can automatically tale action on the results of your analysis from within your application\. \(`actions:containerAction`\)