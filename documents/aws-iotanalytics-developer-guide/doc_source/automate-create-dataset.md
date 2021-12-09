# Using the CreateDataset API via Java and the AWS CLI<a name="automate-create-dataset"></a>

Creates a dataset\. A dataset stores data retrieved from a data store by applying a `queryAction` \(a SQL query\) or a `containerAction` \(executing a containerized application\)\. This operation creates the skeleton of a dataset\. The dataset can be populated manually by calling `CreateDatasetContent` or automatically according to a `trigger` you specify\. For more information, see [CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/APIReference/API_CreateDataset.html) and [https://docs.aws.amazon.com/iotanalytics/latest/APIReference/API_CreateDatasetContent.html](https://docs.aws.amazon.com/iotanalytics/latest/APIReference/API_CreateDatasetContent.html)\.

**Topics**
+ [Example 1 \-\- creating a SQL dataset \(java\)](#automate-example1)
+ [Example 2 \-\- creating a SQL dataset with a delta window \(java\)](#automate-example2)
+ [Example 3 \-\- creating a container dataset with its own schedule trigger \(java\)](#automate-example3)
+ [Example 4 \-\- creating a container dataset with a SQL dataset as a trigger \(java\)](#automate-example4)
+ [Example 5 \-\- creating a SQL dataset \(CLI\)](#automate-example5)
+ [Example 6 \-\- creating a SQL dataset with a delta window \(CLI\)](#automate-example6)

## Example 1 \-\- creating a SQL dataset \(java\)<a name="automate-example1"></a>

```
CreateDatasetRequest request = new CreateDatasetRequest();
request.setDatasetName(dataSetName);
DatasetAction action = new DatasetAction();

//Create Action
action.setActionName("SQLAction1");
action.setQueryAction(new SqlQueryDatasetAction().withSqlQuery("select * from DataStoreName"));

// Add Action to Actions List
List<DatasetAction> actions = new ArrayList<DatasetAction>();
actions.add(action);

//Create Trigger
DatasetTrigger trigger = new DatasetTrigger();
trigger.setSchedule(new Schedule().withExpression("cron(0 12 * * ? *)"));

//Add Trigger to Triggers List
List<DatasetTrigger> triggers = new ArrayList<DatasetTrigger>();
triggers.add(trigger);

// Add Triggers and Actions to CreateDatasetRequest object
request.setActions(actions);
request.setTriggers(triggers);

// Add RetentionPeriod to CreateDatasetRequest object
request.setRetentionPeriod(new RetentionPeriod().withNumberOfDays(10));
final CreateDatasetResult result = iot.createDataset(request);
```

Output on success:

```
{DatasetName: <datatsetName>, DatasetArn: <datatsetARN>, RetentionPeriod: {unlimited: true} or {numberOfDays: 10, unlimited: false}}
```

## Example 2 \-\- creating a SQL dataset with a delta window \(java\)<a name="automate-example2"></a>

```
CreateDatasetRequest request = new CreateDatasetRequest();
request.setDatasetName(dataSetName);
DatasetAction action = new DatasetAction();

//Create Filter for DeltaTime
QueryFilter deltaTimeFilter = new QueryFilter();
deltaTimeFilter.withDeltaTime(
                new DeltaTime()
                .withOffsetSeconds(-1 * EstimatedDataDelayInSeconds)
                .withTimeExpression("from_unixtime(timestamp)"));

//Create Action
action.setActionName("SQLActionWithDeltaTime");
action.setQueryAction(new SqlQueryDatasetAction()
                .withSqlQuery("SELECT * from DataStoreName")
                .withFilters(deltaTimeFilter));

// Add Action to Actions List
List<DatasetAction> actions = new ArrayList<DatasetAction>();
actions.add(action);

//Create Trigger
DatasetTrigger trigger = new DatasetTrigger();
trigger.setSchedule(new Schedule().withExpression("cron(0 12 * * ? *)"));

//Add Trigger to Triggers List
List<DatasetTrigger> triggers = new ArrayList<DatasetTrigger>();
triggers.add(trigger);

// Add Triggers and Actions to CreateDatasetRequest object
request.setActions(actions);
request.setTriggers(triggers);

// Add RetentionPeriod to CreateDatasetRequest object
request.setRetentionPeriod(new RetentionPeriod().withNumberOfDays(10));
final CreateDatasetResult result = iot.createDataset(request);
```

Output on success:

```
{DatasetName: <datatsetName>, DatasetArn: <datatsetARN>, RetentionPeriod: {unlimited: true} or {numberOfDays: 10, unlimited: false}}
```

## Example 3 \-\- creating a container dataset with its own schedule trigger \(java\)<a name="automate-example3"></a>

```
CreateDatasetRequest request = new CreateDatasetRequest();
request.setDatasetName(dataSetName);
DatasetAction action = new DatasetAction();

//Create Action
action.setActionName("ContainerActionDataset");
action.setContainerAction(new ContainerDatasetAction()
        .withImage(ImageURI)
        .withExecutionRoleArn(ExecutionRoleArn)
        .withResourceConfiguration(
                new ResourceConfiguration()
                .withComputeType(new ComputeType().withAcu(1))
                .withVolumeSizeInGB(1))
        .withVariables(new Variable()
        .withName("VariableName")
        .withStringValue("VariableValue"));

// Add Action to Actions List
List<DatasetAction> actions = new ArrayList<DatasetAction>();
actions.add(action);

//Create Trigger
DatasetTrigger trigger = new DatasetTrigger();
trigger.setSchedule(new Schedule().withExpression("cron(0 12 * * ? *)"));

//Add Trigger to Triggers List
List<DatasetTrigger> triggers = new ArrayList<DatasetTrigger>();
triggers.add(trigger);

// Add Triggers and Actions to CreateDatasetRequest object
request.setActions(actions);
request.setTriggers(triggers);

// Add RetentionPeriod to CreateDatasetRequest object
request.setRetentionPeriod(new RetentionPeriod().withNumberOfDays(10));
final CreateDatasetResult result = iot.createDataset(request);
```

Output on success:

```
{DatasetName: <datatsetName>, DatasetArn: <datatsetARN>, RetentionPeriod: {unlimited: true} or {numberOfDays: 10, unlimited: false}}
```

## Example 4 \-\- creating a container dataset with a SQL dataset as a trigger \(java\)<a name="automate-example4"></a>

```
CreateDatasetRequest request = new CreateDatasetRequest();
request.setDatasetName(dataSetName);
DatasetAction action = new DatasetAction();

//Create Action
action.setActionName("ContainerActionDataset");
action.setContainerAction(new ContainerDatasetAction()
        .withImage(ImageURI)
        .withExecutionRoleArn(ExecutionRoleArn)
        .withResourceConfiguration(
                new ResourceConfiguration()
                .withComputeType(new ComputeType().withAcu(1))
                .withVolumeSizeInGB(1))
        .withVariables(new Variable()
        .withName("VariableName")
        .withStringValue("VariableValue"));

// Add Action to Actions List
List<DatasetAction> actions = new ArrayList<DatasetAction>();
actions.add(action);

//Create Trigger
DatasetTrigger trigger = new DatasetTrigger()
        .withDataset(new TriggeringDataset()
                .withName(TriggeringSQLDataSetName));

//Add Trigger to Triggers List
List<DatasetTrigger> triggers = new ArrayList<DatasetTrigger>();
triggers.add(trigger);

// Add Triggers and Actions to CreateDatasetRequest object
request.setActions(actions);
request.setTriggers(triggers);
final CreateDatasetResult result = iot.createDataset(request);
```

Output on success:

```
{DatasetName: <datatsetName>, DatasetArn: <datatsetARN>}
```

## Example 5 \-\- creating a SQL dataset \(CLI\)<a name="automate-example5"></a>

```
aws iotanalytics --endpoint <EndPoint>  --region <Region> create-dataset --dataset-name="<dataSetName>" --actions="[{\"actionName\":\"<ActionName>\", \"queryAction\":{\"sqlQuery\":\"<SQLQuery>\"}}]" --retentionPeriod numberOfDays=10
```

Output on success:

```
{
    "datasetName": "<datasetName>",
    "datasetArn": "<datatsetARN>",
    "retentionPeriod": {unlimited: true} or {numberOfDays: 10, unlimited: false}
}
```

## Example 6 \-\- creating a SQL dataset with a delta window \(CLI\)<a name="automate-example6"></a>

Delta windows are a series of user\-defined, non\-overlapping and continuous time intervals\. Delta windows enable you to create dataset content with, and perform analysis on, new data that has arrived in the data store since the last analysis\. You create a delta window by setting the `deltaTime` in the `filters` portion of a `queryAction` of a dataset \([CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset)\)\. Usually, you'll want to create the dataset content automatically by also setting up a time interval trigger \(`triggers:schedule:expression`\)\. Basically, this enables you to filter messages that have arrived during a specific time window, so the data contained in messages from previous time windows doesn't get counted twice\.

In this example, we create a new dataset that automatically created new dataset content every 15 minutes using only that data which has arrived since the last time\. We specify a 3 minute \(180 second\) `deltaTime` offset that allows for a delay of 3 minutes for messages to arrive in the specified data store\. So, if dataset content is created at 10:30AM, the data used \(included in the dataset content\) would be that with timestamps between 10:12AM and 10:27AM \(that is 10:\#0AM \- 15 minutes \- 3 minutes to 10:30AM \- 3 minutes\)\.

```
aws iotanalytics --endpoint <EndPoint>  --region <Region> create-dataset --cli-input-json file://delta-window.json
```

Where the file `delta-window.json` contains the following\.

```
{
  "datasetName": "delta_window_example",
  "actions": [
    {
      "actionName": "delta_window_action",
      "queryAction": {
        "sqlQuery": "SELECT temperature, humidity, timestamp FROM my_datastore",
        "filters": [
          {
            "deltaTime": {
              "offsetSeconds": -180,
              "timeExpression": "from_unixtime(timestamp)"
            }
          }
        ]
      }
    }
  ],
  "triggers": [
    {
      "schedule": {
        "expression": "cron(0/15 * * * ? *)"
      }
    }
  ]
}
```

Output on success:

```
{
    "datasetName": "<datasetName>",
    "datasetArn": "<datatsetARN>",
}
```