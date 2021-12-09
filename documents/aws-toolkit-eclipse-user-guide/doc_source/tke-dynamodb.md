# Using DynamoDB with AWS Explorer<a name="tke-dynamodb"></a>

Amazon DynamoDB is a fast, highly scalable, highly available, cost\-effective, non\-relational database service\. DynamoDB removes traditional scalability limitations on data storage while maintaining low latency and predictable performance\. The AWS Toolkit for Eclipse provides functionality for working with DynamoDB in a development context\. For more information, see [DynamoDB](https://aws.amazon.com/dynamodb/) on the AWS website\.

In the AWS Toolkit for Eclipse, AWS Explorer displays all the DynamoDB tables associated with the active AWS account\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/dynamodb-aws-explorer.png)

## Creating an DynamoDB Table<a name="tkv-dynamodb-create-table"></a>

Using the AWS Toolkit for Eclipse, you can create a new DynamoDB table\.

 **To create a new table in AWS Explorer** 

1. In **AWS Explorer**, right\-click **Amazon DynamoDB**, and then click **Create Table**\. The **Create New DynamoDB Table** wizard appears\.

1. Enter a table name in the **Table name** box\.

1. Enter a primary hash key attribute in the **Hash key attribute** box, and select the hash key type from the **Hash key type** drop\-down list\. DynamoDB builds an unordered hash index using the primary key attribute and an optional sorted range index using the range primary key attribute\. For more information about the primary hash key attribute, see [Partitions and Data Distribution](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.Partitions.html) in the Amazon DynamoDB Developer Guide\.

1. Optionally, specify a range primary key by selecting **Use a range key**\. Enter a range key attribute in the **Range key attribute** box, and select a range key type from the **Range key type** drop\-down list\.

1. Specify the number of read capacity units in the **Read capacity units** box, and specify the number of write capacity units in the **Write capacity units** box\. You must specify a minimum of 3 read capacity units and 5 write capacity units\. For more information about read and write capacity units, see [Provisioned Throughput](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.ProvisionedThroughput.html) in the Amazon DynamoDB Developer Guide\.

1. Click **Finish** to create the table\. Click the refresh button in **AWS Explorer** to view your new table in the table list\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/dynamodb-create-table.png)

## Viewing an DynamoDB Table as a Grid<a name="tke-dynamodb-grid-view"></a>

To open a grid view of one of your DynamoDB tables, double\-click the subnode in **AWS Explorer** that corresponds to the table\. From the grid view, you can view the items, attributes, and values stored in the table\. Each row corresponds to an item in the table\. The table columns correspond to attributes\. Each cell of the table holds the values associated with that attribute for that item\.

An attribute can have a value that is a string or a number\. Some attributes have a value that consists of a *set* of strings or numbers\. Set values are displayed as a comma\-separated list enclosed by square brackets\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/dynamodb-product-catalog.png)

## Editing Attributes and Values<a name="tke-dynamodb-editing"></a>

The table grid view is *editable*; by double\-clicking a cell, you can edit the values for the item’s corresponding attribute\. For set\-value attributes, you can also add or delete individual values from the set\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/dynamodb-single-value-cell-edit.png)

The editing UI enables you not only to change the value of an attribute, but also to change the format of the value for the attribute—with some limitations\. For example, any number value can be converted into a string value\. If you have a string value, the content of which is a number, such as “125”, the editing UI enables you to convert the format of the value from string to number\. Also, the editing UI enables you to convert a single\-value to a set\-value\. However, you cannot generally convert from a set\-value to a single\-value; an exception is when the set\-value has, in fact, only one element in the set\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/dynamodb-set-value-attribute.png)

The **Edit Values** dialog box opens when you are editing a set of values\. After editing the attribute value, click **Save set** to confirm your changes\. If you want to discard your changes, click **Cancel**\.

After confirming your changes, the attribute value is displayed in red\. This indicates that the attribute has been updated, but that the new value has not been written back to the Amazon DynamoDB database\. To write your changes back to DynamoDB, click **File**, and then click **Save**, or press from the keyboard\. To discard your changes, click **Scan Table**, and when the Toolkit asks if you would like to commit your changes before the Scan, click **No**\.

## Scanning an DynamoDB Table<a name="tke-dynamodb-scan"></a>

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/dynamodb-scan.png)

From the Toolkit, you can perform Scans on your DynamoDB tables\. In a Scan, you define a set of criteria and the Scan returns all items from the table that match your criteria\. Scans are expensive operations and should be used with care to avoid disrupting higher\-priority production traffic on the table\. For more recommendations on safely using the Scan operation, go to the *Amazon DynamoDB Developer Guide*\.

 **To perform a Scan on an Amazon DynamoDB table from AWS Explorer** 

1. In the grid view, click **Add scan condition**\. A UI appears that enables you to edit a new Scan clause\.

1. In the Scan clause editor, specify the attribute to match against, how it should be matched \(Begins With, Contains, etc\.\), what literal value it should match, and if the value is a string or a number\.

1. Add more Scan clauses as needed for your search\. The Scan will return only those items that match the criteria from all of your Scan clauses\. Note that the Scan will perform a case\-sensitive comparison when matching against string values\.

1. On the button bar at the top of the grid view, click the green play button to run the scan\.

To remove a Scan clause, click the red X to the left of each clause\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/dynamodb-scan-results.png)

To return to the view of the table that includes all items, double\-click **Amazon DynamoDB** in **AWS Explorer**\.

 *Paginating Scan Results* 

At the top of the view are three buttons\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/dynamodb-paginate-export.png)

The *second* button provides pagination for Scan results\. Clicking the *rightmost* button exports the results from the current scan into a CSV file\.