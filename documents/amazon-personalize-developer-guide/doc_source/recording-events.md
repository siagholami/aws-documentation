# Recording Events<a name="recording-events"></a>

 Amazon Personalize can make recommendations based on real\-time event data only, historical imported data \(as demonstrated in the [Getting Started](getting-started.md) guides\) only, or a mixture of both\. To import real\-time event data, record user activity \(events\) in real\-time using the AWS SDK, AWS Amplify or AWS CLI\. 

**Note**  
AWS Amplify includes a JavaScript library for recording events from web client applications, and a library for recording events in server code\. For more information, see [Amplify \- Analytics](https://aws-amplify.github.io/docs/js/analytics)

**Requirements for Recording Events**

To record events, you need the following:
+ A dataset group that includes an `Interactions` dataset, which can be empty\. For a Python example that creates a dataset and a dataset group, see [Importing Your Data](data-prep-importing.md)\.
+ An event tracker\.
+ A call to the [PutEvents](API_UBS_PutEvents.md) operation\.

You can start out with an empty Interactions dataset and, when you have recorded enough data, train the model using only new recorded events\. The minimum data requirements to train a model are:
+ 1000 records of combined interaction data \(after filtering by `eventType` and `eventValueThreshold`, if provided\)
+ 25 unique users with at least 2 interactions each

**How Recorded Events Influence Recommendations**

 Once you create a campaign, Amazon Personalize automatically uses new recorded event data for existing items \(items you included in the data you used to train the latest model\) when generating recommendations for the user\. This does not require retraining the model \(unless you are using the SIMS or popularity\-count recipes\)\. 

Instead, the new recorded event data is added to the user's history\. Amazon Personalize then uses the modified data when generating recommendations for the user \(and this user only\)\.

 For recorded events for new items \(items you did not include in the data you used to train the model\), you must re\-train the model for the new records to influence recommendations\. Amazon Personalize stores recorded events for new items and, once you create a new solution version \(train a new model\), this new data will influence Amazon Personalize recommendations for the user\. 

For recorded events for new users \(users that were not included in the data you used to train the model\), recommendations will initially be for popular items only\. Recommendations will be more relevant as you record more events for the user\. Amazon Personalize stores the new user data, so you can also retrain the model for more relevant recommendations\. 

**Topics**
+ [Creating a Dataset Group](#event-dataset-group)
+ [Getting a Tracking ID](#event-get-tracker)
+ [PutEvents Operation](#event-record-api)
+ [Event Metrics](#event-metrics)
+ [Events and Solutions](#event-solutions)
+ [Sample Jupyter Notebook](#recording-events-sample-notebook)

## Creating a Dataset Group<a name="event-dataset-group"></a>

If you went through the [Getting Started](getting-started.md) guide, you can use the same dataset group that you created\. For a Python example that creates a dataset and a dataset group, see [Importing Your Data](data-prep-importing.md)\.

## Getting a Tracking ID<a name="event-get-tracker"></a>

A tracking ID associates an event with a dataset group and authorizes you to send data to Amazon Personalize\. You generate a tracking ID by calling the [CreateEventTracker](API_CreateEventTracker.md) API and supplying the dataset group ARN\.

**Note**  
Only one event tracker can be associated with a dataset group\. You will get an error if you call `CreateEventTracker` using the same dataset group as an existing event tracker\.

------
#### [ Python ]

```
import boto3

personalize = boto3.client('personalize')

response = personalize.create_event_tracker(
    name='MovieClickTracker',
    datasetGroupArn='arn:aws:personalize:us-west-2:acct-id:dataset-group/MovieClickGroup'
)
print(response['eventTrackerArn'])
print(response['trackingId'])
```

------
#### [ AWS CLI ]

```
aws personalize create-event-tracker \
    --name MovieClickTracker \
    --dataset-group-arn arn:aws:personalize:us-west-2:acct-id:dataset-group/MovieClickGroup
```

------

The event tracker ARN and tracking ID display, for example:

```
{
    "eventTrackerArn": "arn:aws:personalize:us-west-2:acct-id:event-tracker/MovieClickTracker",
    "trackingId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx"
}
```

## PutEvents Operation<a name="event-record-api"></a>

To record events, you call the [PutEvents](API_UBS_PutEvents.md) operation\. The following example shows a `PutEvents` call that passes one event that contains the minimum required information\. The corresponding Interactions schema is shown, along with an example row from the Interactions dataset\.

Your application generates the `sessionId` when a user first visits your website or uses your application\. Amazon Personalize uses the `sessionId` to associate events with the user before they log in \(is anonymous\)\. After the user logs in and you send an event including the `userId`, Amazon Personalize associates the previously anonymous historical event data with their `userId` by matching the `sessionId`\. This creates a continuous event history that includes events that occurred when the user was anonymous\.

The event list is an array of [Event](API_UBS_Event.md) objects\. An `eventType` is required for each event, but in this example, `eventType` data is not used in training because it is not included in the schema\. The `properties` key is a string map \(key\-value pairs\) of event\-specific data\. In this case, just the item ID is specified\.

The `userId`, `itemId`, and `sentAt` parameters map to the USER\_ID, ITEM\_ID, and TIMESTAMP fields of a corresponding historical `Interactions` dataset\. For more information, see [Datasets and Schemas](how-it-works-dataset-schema.md)\.

**Corresponding Interactions Schema**

```
Interactions schema: USER_ID, ITEM_ID, TIMESTAMP
Interactions dataset: user123, item-xyz, 1543631760
```

**Code Example**

------
#### [ Python ]

```
import boto3

personalize_events = boto3.client(service_name='personalize-events')

personalize_events.put_events(
    trackingId = 'tracking_id',
    userId= 'USER_ID',
    sessionId = 'session_id',
    eventList = [{
        'sentAt': TIMESTAMP,
        'eventType': 'EVENT_TYPE',
        'properties': "{\"itemId\": \"ITEM_ID\"}"
        }]
)
```

------
#### [ AWS CLI ]

```
aws personalize-events put-events \
    --tracking-id tracking_id \
    --user-id USER_ID \
    --session-id session_id \
    --event-list '[{
        "sentAt": "TIMESTAMP",
        "eventType": "EVENT_TYPE",
        "properties": "{\"itemId\": \"ITEM_ID\"}"
      }]'
```

------

After this example, you would proceed to train a model using only the required properties\. The training would not use the `eventValue` property because it wasn't included in the event\.

The next example shows how to submit data that would train on the event value\. It also demonstrates the passing of multiple events of different types \('like' and 'rating'\)\. In this case, you must specify the event type to train on in the [CreateSolution](API_CreateSolution.md) operation \(see **Events and Solutions** below\)\. The example also shows the recording of an extra property, `numRatings`, that is used as metadata by certain recipes\.

```
Interactions schema: USER_ID, ITEM_ID, TIMESTAMP, EVENT_TYPE, EVENT_VALUE, NUM_RATINGS
Interactions dataset: user123, movie_xyz, 1543531139, rating, 5, 12
                      user321, choc-ghana, 1543531760, like, 4
                      user111, choc-fake, 1543557118, like, 3
```

------
#### [ Python ]

```
import boto3
import json

personalize_events = boto3.client(service_name='personalize-events')

personalize_events.put_events(
    trackingId = 'tracking_id',
    userId= 'user555',
    sessionId = 'session1',
    eventList = [{
        'eventId': 'event1',
        'sentAt': '1553631760',
        'eventType': 'like',
        'properties': json.dumps({
            'itemId': 'choc-panama',
            'eventValue': 4,
            'numRatings': 0    
            })
        }, {
        'eventId': 'event2',
        'sentAt': '1553631782',
        'eventType': 'rating',
        'properties': json.dumps({
            'itemId': 'movie_ten',
            'eventValue': 3,
            'numRatings': 13
            })
        }]
)
```

------
#### [ AWS CLI ]

```
aws personalize-events put-events \
    --tracking-id tracking_id \
    --user-id user555 \
    --session-id session1 \
    --event-list '[{
        "eventId": "event1",
        "sentAt": "1553631760",
        "eventType": "like",
        "properties": "{\"itemId\": \"choc-panama\", \"eventValue\": \"true\"}"
      }, {
        "eventId": "event2",
        "sentAt": "1553631782",
        "eventType": "rating",
        "properties": "{\"itemId\": \"movie_ten\", \"eventValue\": \"4\", \"numRatings\": \"13\"}"
      }]'
```

------

**Note**  
The properties keys use camel case names that match the fields in the Interactions schema\. For example, if the fields 'ITEM\_ID', 'EVENT\_VALUE', and 'NUM\_RATINGS,' are defined in the Interactions schema, the property keys should be `itemId, eventValue, and numRatings`\.

## Event Metrics<a name="event-metrics"></a>

To monitor the type and number of events sent to Amazon Personalize, use Amazon CloudWatch metrics\. For more information, see [Monitoring Amazon Personalize](personalize-monitoring.md)\. 

## Events and Solutions<a name="event-solutions"></a>

When training a model that uses event data, two parameters of the [CreateSolution](API_CreateSolution.md) operation are relevant\. The `eventType` parameter must be specified when multiple event types are recorded\. The `eventType` indicates which type of event Amazon Personalize uses as the label for model training\.

The `eventValueThreshold` parameter of the `SolutionConfig` object creates an event filter\. When this parameter is specified, only events with a value greater than or equal to the threshold are used for training the model\. You must specify the event type when using `eventValueThreshold`\.

## Sample Jupyter Notebook<a name="recording-events-sample-notebook"></a>

For a sample Jupyter notebook that shows how to use Amazon Personalize to react to real\-time behavior of users using an event tracker and the [PutEvents](API_UBS_PutEvents.md) operation, see [2\.View\_Campaign\_And\_Interactions\.ipynb](https://github.com/aws-samples/amazon-personalize-samples/blob/master/getting_started/notebooks/2.View_Campaign_And_Interactions.ipynb) in the **getting\_started** folder of the [amazon\-personalize\-samples](https://github.com/aws-samples/amazon-personalize-samples) GitHub repository\. 