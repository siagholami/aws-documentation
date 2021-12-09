# Filtering Real\-time Recommendations<a name="filter-real-time"></a>

You can filter real\-time recommendations with the Amazon Personalize console or the AWS SDK\.

## Filtering Real\-Time Recommendations \(Console\)<a name="filter-rt-console"></a>

To filter real\-time recommendations using the console, create a filter and then apply it to a recommendation request\.

**Note**  
To filter recommendations using a campaign you deployed before July 30, 2020, you must re\-deploy the campaign by using the [UpdateCampaign](API_UpdateCampaign.md) call or by creating a new campaign\.

**To filter real\-time recommendations \(console\)**

1. Open the Amazon Personalize console at [https://console\.aws\.amazon\.com/personalize/](https://console.aws.amazon.com/personalize/) and sign into your account\. 

1. Choose the dataset group that contains the campaign that you want to filter results for\.

1. In the navigation page, choose **Filters** and then choose **Create new filter**\. The **Create filter** page displays\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/create-filter-page.png)

1. For **Filter name**, enter a name for your filter\. You will choose the filter by this name when you apply it to a recommendation request\.

1. For **Expression**, choose either **Build expression** or **Add expression manually** and build or insert your expression:
   + To use the expression builder, choose **Build expression **\. The expression builder provides structure, fields, and guidelines for building correctly formatted filter expressions\. For more information, see [Using the Filter Expression Builder](#using-filter-expression-builder)\.
   +  To input your own expression, choose **Add expression manually** \. For information, see [Filter Expression Elements](filter-expressions.md#filter-expression-elements)\. 

1. Choose **Finish**\. The filter's overview page shows the filter’s Amazon Resource Name \(ARN\), status, and full filter expression\. To delete the filter, choose **Delete**\. For information about finding and deleting filters after you have left the overview page, see [Deleting a Filter \(Console\)](#delete-filter-console)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/filter-details-page.png)

1. In the navigation pane, choose **Campaigns**\.

1.  On the **Campaigns** page, choose the target campaign\.

1. For comparison, start by getting recommendations for a user without applying a filter\. Under **Test campaign results**, enter the ID of a user that you want to get recommendations for, and choose **Get recommendations**\. A table containing the user’s top recommendations appears\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/Recommendations_no-filter.PNG)

1. From the **Filter name** menu, choose the filter that you created\. 

1. Using the same `User ID` as in the earlier step, choose **Get recommendations**\. The recommendations table appears\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/Recommendations_filter.png)

   If the user already bought a recommended item, the filter removes it from the recommendation list\. In this example, items 2657, 2985 were replaced by the most suitable items that the user had not purchased \(items 2641 and 1573\)\.

### Using the Filter Expression Builder<a name="using-filter-expression-builder"></a>

The **Expression builder** on the **Create filter** page provides structure, fields, and guidelines for building correctly formatted filter expressions\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/expression-builder-empty.png)

To build a filter expression:
+  Use the **Action**, **Property**, **Operator**, and **Value** fields to choose elements and create an expression\. For the **Value** field, separate multiple values with a comma\.
**Note**  
After you choose a **Property** \(in `dataset.property` format\), the **Property** value for any succeeding rows chained by `AND` or `OR` conditions must use the same `dataset`\.
+  Use the **\+** and **X** buttons to add or delete a row from your expression\. You can't delete the first row\. 
+  For new rows, use the `AND`, `IF`, or `OR` operators on the **AND** menu to create a chain of conditions\. 

  For `IF` conditions:
  + Each expression can contain only one `IF` item\. If you remove an IF condition, the Expression builder removes any `AND` conditions following it\.
  + You can use `IF` conditions only for the `CurrentUser`\.
+  Choose the **Add expression** button to add an additional filter expression for more precise filtering, including filtering using Item and Interactions datasets\. The results of the first expression are passed to the added expression\. 
**Note**  
To create a filter that uses both Item and Interaction datasets, you *must* use multiple expressions\.

#### Expression Builder Example<a name="expression-builder-example"></a>

The following example shows how to build a filter that includes items in the `action` or `horror` genres with a `DOWNLOAD_COUNT` of more than `200`, but only if the current user's age is greater than `17`\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/create-filter-expression-builder.png)

### Deleting a Filter \(Console\)<a name="delete-filter-console"></a>

Deleting a filter removes the filter from the list of filters for a dataset group\.

**Important**  
You can't delete a filter while a batch inference job is in progress\.

**To delete a filter \(console\)**

1. Open the Amazon Personalize console at [https://console\.aws\.amazon\.com/personalize/](https://console.aws.amazon.com/personalize/) and sign into your account\. 

1. From the **Dataset groups** list, choose the dataset group that contains the filter that you want to delete\. 

1. In the navigation pane, choose **Filters**\.

1. From the list of filters, choose the filter that you want to delete and choose **View Details**\. The filter details page appears\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/filter-details-page.png)

1. Choose **Delete** and confirm the deletion in the confirmation dialog box\. 

## Filtering Real\-Time Recommendations \(AWS SDK\)<a name="filter-rt-sdk"></a>

For real\-time filtering, you create a filter and then specify it in a [GetRecommendations](API_RS_GetRecommendations.md), [CreateBatchInferenceJob](API_CreateBatchInferenceJob.md), or [GetPersonalizedRanking](API_RS_GetPersonalizedRanking.md) request\.

**Note**  
To filter recommendations using a campaign you deployed before July 30, 2020, you must re\-deploy the campaign by using the [UpdateCampaign](API_UpdateCampaign.md) call or by creating a new campaign\.

**To filter real\-time recommendations \(AWS SDK**\)

Use the [CreateFilter](API_CreateFilter.md) operation to create a filter and specify its filtering properties\. The following example creates a filter that filters previously purchased items out of recommendation responses\. Then, it uses the filter to get filtered recommendations\.

```
import boto3
 
personalize = boto3.client('personalize')
personalize_runtime = boto3.client('personalize-runtime')
 
# Create a filter.
response = personalize.create_filter(
    name = "Filter name",
    datasetGroupArn = "Dataset group ARN",
    filterExpression = "EXCLUDE itemId WHERE INTERACTIONS.EVENT_TYPE in (\"Purchase\")"
) 
filter_arn = response["filterArn"]
print("Filter ARN: " + filter_arn)
 
# Specify the filter in a recommendation request.
print("Getting recommendations")
response = personalize_runtime.get_recommendations(
    campaignArn = "Campaign ARN",
    userId = "User ID",
    filterArn = filter_arn
)        
print("Recommended items")
for item in response['itemList']:
    print (item['itemId'])
```

To verify that the filter is active, use the [DescribeFilter](API_DescribeFilter.md) operation before using the `GetRecommendations` operation\.