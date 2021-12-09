# Formatting Your Input Data<a name="data-prep-formatting"></a>

The files that you use to import data into Amazon Personalize must map to the schema that you are using\.

Amazon Personalize imports data only from files that are in the comma\-separated values \(CSV\) format\. Amazon Personalize requires the first row of your CSV file to contain column headers\. The column headers in your CSV file need to map to the schema to create the dataset\. Don't enclose headers in quotation marks \("\)\. `TIMESTAMP` and `CREATION_TIMESTAMP` data must be in *Unix epoch* time format\. For more information see [Timestamp Data](#timestamp-data)\. 

**Important**  
If your data includes any non\-ASCII encoded characters, your CSV file must be encoded in UTF\-8 format\.

The following CSV data sample maps to the Interactions schema shown in [Datasets and Schemas](how-it-works-dataset-schema.md)\. This data represents historical user activity from a website that sells movie tickets\. You can use the data to train a model that gives a user movie recommendations based on the activities of other users\.

```
USER_ID,ITEM_ID,EVENT_TYPE,EVENT_VALUE,TIMESTAMP
196,242,click,15,881250949
186,302,click,13,891717742
22,377,click,10,878887116
244,51,click,20,880606923
166,346,click,10,886397596
298,474,click,40,884182806
115,265,click,20,881171488
253,465,click,50,891628467
305,451,click,30,886324817
```

The associated Interactions schema is repeated below\.

```
{
  "type": "record",
  "name": "Interactions",
  "namespace": "com.amazonaws.personalize.schema",
  "fields": [
    {
      "name": "USER_ID",
      "type": "string"
    },
    {
      "name": "ITEM_ID",
      "type": "string"
    },
    { "name": "EVENT_TYPE",
      "type": "string"
    },
    {
      "name": "EVENT_VALUE",
      "type": "float"
    },
    {
      "name": "TIMESTAMP",
      "type": "long"
    }
  ],
  "version": "1.0"
}
```

Amazon Personalize requires the `USER_ID`, `ITEM_ID`, and `TIMESTAMP` fields\. `USER_ID` is the identifier for a user of your application\. `ITEM_ID` is the identifier for a movie\. `EVENT_TYPE` and `EVENT_VALUE` are the identifiers for user activities\. In the sample data, a `click` might represent a movie purchase event and `15` might be the purchase price of the movie\. `TIMESTAMP` represents the Unix epoch time that the movie purchase took place\.

## Timestamp Data<a name="timestamp-data"></a>

 Timestamp data, such as `TIMESTAMP` \(for Interactions datasets\) or `CREATION_TIMESTAMP` \(for Items datasets\) data, must be in Unix epoch time format in seconds\. For example, the Epoch timestamp in seconds for date July 31, 2020 is 1596238243\. To convert dates to Unix epoch timestamps use a [Epoch Converter \- Unix Timestamp Converter](https://www.epochconverter.com)\. 

### Creation Timestamp Data<a name="creation-timestamp-data"></a>

Amazon Personalize uses `CREATION_TIMESTAMP` data \(in Unix epoch time format, in seconds\) to calculate the age of an item and adjust recommendations accordingly\. 

If your schema has a `CREATION_TIMESTAMP` field, but `CREATION_TIMESTAMP` data is missing for one or more items, Amazon Personalize infers this information from interaction data, if any, and uses the timestamp of the item’s oldest interaction data as the item's creation date\. If an item has no interaction data, its creation date is set as the timestamp of the latest interaction in the training set and is considered a new item\. 

 For more information see [Datasets and Schemas](how-it-works-dataset-schema.md)\. For an example of an Items schema, see [Items Schema Example](how-it-works-dataset-schema.md#schema-examples-items)\. 

## Impressions Data<a name="data-prep-impressions-data"></a>

Impressions are lists of items that were visible to a user when they interacted with \(for example, clicked or watched\) a particular item\. Amazon Personalize can model two types of impressions: 
+ *Implicit impressions* are the recommendations, retrieved from Amazon Personalize, that you show the user\. You can integrate them into your recommendation workflow by including the `RecommendationId` \(returned by the [GetRecommendations](API_RS_GetRecommendations.md) and [GetPersonalizedRanking](API_RS_GetPersonalizedRanking.md) operations\) as input for future [PutEvents](API_UBS_PutEvents.md) requests and Amazon Personalize will derive the implicit impressions based on your recommendation data\.
+ *Explicit impressions* are impressions that you manually record and send to Amazon Personalize\. Use explicit impressions to manipulate results from Amazon Personalize\. For example, use explicit impressions to filter out unavailable items and change the order of recommendations based on user interactions\.

### Uploading Explicit Impressions<a name="data-prep-including-explicit-impressions"></a>

To include explicit impressions in your training data, upload them in an interactions dataset \(see [Datasets and Schemas](how-it-works-dataset-schema.md)\) or list them in the [PutEvents](API_UBS_PutEvents.md) command's `impression` input parameter\. The impressions are added to the recommendation that you specify in the `recommendationId` parameter:

```
{
   "eventList": [ 
      { 
         "eventId": "event1",
         "eventType": "Rating",
         "sentAt": 1553631760,
         "itemId": "item id"
         "recommendationId": "id"
         "impression": ["itemId1", "itemId2", "itemId3"]
      }
   ],
   "sessionId": "session1",
   "trackingId": "tracking_id",
   "userId": "1"
}
```

**Important**  
If you provide conflicting implicit and explicit impression data in your `PutEvents` requests, Amazon Personalize uses the explicit impressions by default\.

Impressions data is recorded in Interactions datasets, with each impression separated by a `|` character, or sent in a [PutEvents](API_UBS_PutEvents.md) request \(the `|` character is not required when using the SDK\)\. For more information about datasets in Amazon Personalize, see [Datasets and Schemas](how-it-works-dataset-schema.md)\. 

The following is a short excerpt from an Interactions dataset that includes explicit impressions in the `IMPRESSION` column\.


| EVENT\_TYPE | IMPRESSION | ITEM\_ID | TIMESTAMP | USER\_ID | 
| --- | --- | --- | --- | --- | 
| click |  73\|70\|17\|95\|96  | 73 |  1586731606  | USER\_1 | 
| click |  35\|82\|78\|57\|20\|63\|1\|90\|76\|75\|49\|71\|26\|24\|25\|6  | 35 |  1586735164  | USER\_2 | 
| \.\.\. | \.\.\. | \.\.\. | \.\.\. | \.\.\. | 

The application showed user `USER_1` items `73`, `70`, `17`, `95`, and `96` and the user ultimately chose item `73`\. When you create a new solution version based on this data, items `70`, `17`, `95`, and `96` will be less frequently recommended to user `USER_1`\.

## Categorical Data<a name="data-prep-formatting-categorical"></a>

To include multiple categories for a single item when you use categorical string data, separate the values using the vertical bar, '\|', character\. For example, to match the Items schema from the previous section using two categories, a data row would resemble the following:

```
ITEM_ID,GENRE
item_123,horror|comedy
```

After you format your data, upload it to an Amazon S3 bucket so you can import it into Amazon Personalize\. For more information, see [Uploading to an S3 Bucket](data-prep-upload-s3.md)\.