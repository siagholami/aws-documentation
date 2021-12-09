# Pipeline activities<a name="pipeline-activities"></a>

The simplest functional pipeline connects a channel to a data store, which makes it a pipeline with two activities: a `channel` activity and a `datastore` activity\. You can achieve more powerful message processing by adding additional activities to your pipeline\. 

You can use the [RunPipelineActivity](https://docs.aws.amazon.com/iotanalytics/latest/APIReference/API_RunPipelineActivity.html) operation to simulate the results of running a pipeline activity on a message payload you provide\. You might find this helpful when you are developing and debugging your pipeline activities\. [RunPipelineActivity example](run-pipeline-activity.md) demonstrates how it is used\.