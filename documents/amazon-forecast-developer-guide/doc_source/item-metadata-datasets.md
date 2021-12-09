# Using Item Metadata Datasets<a name="item-metadata-datasets"></a>

An *item metadata dataset* contains categorical data that provides valuable context for the items in a target time\-series dataset when you train a predictor with the [CNN\-QR](aws-forecast-algo-cnnqr.md) or [DeepAR\+](aws-forecast-recipe-deeparplus.md) algorithms\. Unlike related time\-series datasets, item metadata datasets provide information that is static\. That is, the data values remain constant over time, like an item's color or brand\. Item metadata datasets are optional additions to your dataset groups, and are taken into account only when you train a predictor with [CNN\-QR](aws-forecast-algo-cnnqr.md) or [DeepAR\+](aws-forecast-recipe-deeparplus.md) \. You can use an item metadata only if every item in your target time\-series dataset is present in the corresponding item metadata dataset\.

Item metadata might include the brand, color, model, category, place of origin, or other supplemental feature of a particular item\. For example, an item metadata dataset might provide context for some of the demand data found in a target time\-series dataset that represents the sales of black Amazon e\-readers with 32 GB of storage\. Because these characteristics don't change from day\-to\-day or hour\-to\-hour, they belong in an item metadata dataset\.

Item metadata is useful for discovering and tracking descriptive patterns across your time\-series data\. If you include an item metadata dataset in your dataset group, Forecast can train the model to make more accurate predictions based on similarities across items\. For example, you might find that virtual assistant products made by Amazon are more likely to sell out than those created by other companies, and then plan your supply chain accordingly\.

Item metadata is especially useful in coldstart forecasting scenarios, in which you have little direct historical data with which to make predictions, but do have historical data on items with similar metadata attributes\. When you provide context for the little data that you have, your Forecast predictor can make useful, nonobvious inferences about the items in your data that increase prediction accuracy\.

Each row in an item metadata dataset can contain up to 10 metadata fields, one of which must be an identification field to match the metadata to an item in the target time series\. As with all dataset types, the values of each field are designated by a dataset schema\.

## Example: Item Metadata File and Schema<a name="item-metadata-example"></a>

The following table shows a section of a correctly configured item metadata dataset file that describes Amazon e\-readers\. For this example, assume that the header row represents the dataset's schema, and that each listed item is in a corresponding target time\-series dataset\.


| `item_id` | `brand` | `model` | `color` | `waterproof` | 
| --- | --- | --- | --- | --- | 
| 1 | amazon | paperwhite | black | yes | 
| 2 | amazon | paperwhite | blue | yes | 
| 3 | amazon | base\_model | black | no | 
| 4 | amazon | base\_model | white | no | 
| \.\.\. | 

The following is the same information represented in CSV format\.

```
1,amazon,paperwhite,black,yes
2,amazon,paperwhite,blue,yes
3,amazon,base_model,black,no
4,amazon,base_model,white,no
...
```

The following is the schema for this example dataset\.

```
{
     "attributes": [
        {
           "AttributeName": "item_id",
           "AttributeType": "string"
        },
        {
           "AttributeName": "brand",
           "AttributeType": "string"
        },
        {
           "AttributeName": "model",
           "AttributeType": "string"
        },
        {
           "AttributeName": "color",
           "AttributeType": "string"
        },
        {
           "AttributeName": "waterproof",
           "AttributeType": "string"
        }
    ]
}
```

## See Also<a name="item-metadata-see-also"></a>

For an in\-depth walkthrough on using item metadata datasets, see [Incorporating Item Metadata Datasets into Your Predictor](https://github.com/aws-samples/amazon-forecast-samples/blob/master/notebooks/advanced/Incorporating_Item_Metadata_Dataset_to_your_Predictor/Incorporating_Item_Metadata_Dataset_to_your_Predictor.ipynb) in the [Amazon Forecast Samples GitHub Repository](https://github.com/aws-samples/amazon-forecast-samples)\.