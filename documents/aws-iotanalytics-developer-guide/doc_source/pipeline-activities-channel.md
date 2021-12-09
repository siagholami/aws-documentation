# Channel activity<a name="pipeline-activities-channel"></a>

The first activity in a pipeline must be the `channel` activity which determines the source of the messages to be processed\.

```
{
    "channel": {
        "name": "MyChannelActivity",
        "channelName": "mychannel",
        "next": "MyLambdaActivity"
    }
}
```