--------

--------

# Deploying and Running AWS IoT Things Graph on AWS IoT Greengrass<a name="iot-tg-greengrass"></a>

This topic explains how AWS IoT Things Graph interacts with your AWS IoT Greengrass group when you deploy your flow configurations to your AWS IoT Greengrass core\. It also describes how you can monitor and debug your flows after they start running in your AWS IoT Greengrass group\.

## AWS IoT Greengrass Deployments<a name="iot-tg-greengrass-deployment"></a>

AWS IoT Things Graph is deployed as an [AWS IoT Greengrass connector](https://docs.aws.amazon.com/greengrass/latest/developerguide/connectors.html) on an AWS IoT Greengrass core device\. You deploy a flow configuration by using the [DeploySystemInstance](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_DeploySystemInstance.html) API\. You must specify an Amazon Simple Storage Service \(Amazon S3\) bucket and an AWS IoT Greengrass group\. 

AWS IoT Things Graph then performs the following actions on these two resources:
+ Generates a deployment artifact containing the dependency closure of the flow configuration, and saves it to the Amazon S3 bucket\. The file name of this artifact is a concatenation of **flow\-*flow name*\.tar\.gz**\. If you delete this file after the deployment is complete, your existing deployment will work, but redeployments won't\.
+ Deploys the AWS IoT Things Graph connector to the AWS IoT Greengrass group and configures it to use the configuration stored in the S3 bucket\.
+ Adds the devices specified in the flow configuration\.
+ Subscribes the AWS IoT Things Graph connector and the devices to the MQTT topics specified in the device definitions\.

**Note**  
You must create a **thingsgraph** directory at the root of your AWS IoT Greengrass core device\. Deployments to your core device won't work if this directory doesn't exist\. Don't modify the files that are put in this directory\. For more information on setting up your AWS IoT Greengrass core, see [Setting Up Your Environment for AWS IoT Greengrass Deployments](iot-tg-gs-environment.html)\.

After your first deployment of a flow configuration to your AWS IoT Greengrass core device, AWS IoT Things Graph deploys the AWS IoT Things Graph connector to your AWS IoT Greengrass core device\. AWS IoT Things Graph also installs a database file named **ThingsGraph\.db** and a directory named **engine** to the **thingsgraph** directory that you created when you set up your AWS IoT Greengrass core\.

The **ThingsGraph\.log** file appears in the **/greengrass/ggc/var/log/user/*Region*/ThingsGraph** directory\. This log file is your primary resource for debugging your AWS IoT Things Graph flows as they run in your group\.

For more information about the steps that are required to deploy AWS IoT Things Graph and flows to an AWS IoT Greengrass group, see [Creating and Deploying Flows](iot-tg-workflows-gs.html)\. For more information about setting up your AWS IoT Greengrass group for AWS IoT Things Graph, see [Setting Up Your Environment](iot-tg-gs-environment.html)\.

## Verifying Flows in Your AWS IoT Greengrass Group<a name="iot-tg-greengrass-debugging"></a>

After you deploy a flow for the first time, AWS IoT Things Graph installs the AWS IoT Things Graph connector in your AWS IoT Greengrass core and creates a log file named **ThingsGraph\.log**\. If the connector installs correctly and starts running, you'll see the following log entries in the **ThingsGraph\.log** file\.

```
[INFO]-bootstrapping DB
[INFO]-bootstrapping entities
[INFO]-bootstrapping entities done
[INFO]-bootstrapping DB done
[INFO]-FlowsBootstrap: registered SDC: urn:tdm:Region/Account ID/default:Deployment:MyExample01_V001
[INFO]-Initialized ThingsGraph Runtime vx.x.x
```

The log entries that begin with `bootstrapping` indicate that the **ThingsGraph\.db** file is being created and populated by entities, as specified by the dependency closure that AWS IoT Things Graph has uploaded to your Amazon S3 bucket\. These entities include the device models, systems, and flow templates that you specified in your system flow configuration \(SDC\)\.

The `FlowsBootstrap` entry indicates that your SDC has been added to your AWS IoT Greengrass group\. The `Initialized ThingsGraph Runtime` entry indicates that AWS IoT Things Graph has successfully installed and is running on your core device\.

Later entries in the log file relate to the execution of the flow\. These two entries indicate that the trigger condition has been met and the flow execution has begun\.

```
[INFO]-Trigger expression condition: [every 10 seconds] met?  true
[INFO]-FlowSchedulerClientGreengrassImpl: StartFlowExecution:
[INFO]-  flowInstanceId:urn:tdm:Region/Account ID/default:Workflow:MyExample02_V001_2019-03-03T20:33:09.339Z_TenSecondTrigger_69aa794d-debc-48b0-a4c3-e0a93e163cf3
[INFO]-  flowType:urn:tdm:Region/Account ID/default:Workflow:MyExample01_V001
[INFO]-  flowParams:{"device1Id":"DeutaBridgeV2"}
```

The bracketed text in the first entry contains the [trigger condition logic](iot-tg-models-tdm-iot-trigger.html) that you specified for your flow \(a time interval in this case\)\. The `FlowSchedulerClientGreengrassImpl: StartFlowExecution:` entry indicates that the flow has begun executing\. The following three entries contain information about this instance of the flow\. The value of `flowInstanceId` is a concatenation of the flow ID \(a [URN](iot-tg-models-tdm-urnscheme.html)\), the timestamp, the name of the trigger, and a universally unique identifier \(UUID\)\. The value of `flowParams` contains the parameters that have been passed to the flow \(the device ID in this case\)\.

After the flow execution begins, a series of `StateTransition` entries appears in the log\. The first occurs at the very beginning, and indicates that the `StartFlowExecutionTask` has been performed\.

```
[INFO]-[StateTransition-urn:tdm:Region/Account ID/default:Workflow:MyExample03_V001_2019-03-12T2
0:55:37.041Z_TenSecondTrigger_2ba7d218-2b9e-4005-ad96-8779d589dac2] ExecutionStarted(super=StateTransitionMessage(super=Message
(super=com.amazonaws.iotflowengine.messages.ExecutionStarted@93227493, messageId=1939, 
flowInstanceId=urn:tdm:Region/Account ID/default:Workflow:MyExample03_V001_2019-03-12T20:55:37.041Z_TenSecondTrigger_2ba7d218-2b9e-4005-ad96-8779d589dac2, 
createdAt=1552424137043)), flowParams={"device1Id":"DeutaBridgeV2"}, templateId=urn:tdm:Region/Account ID/default:Workflow:MyExam
ple03_V001, version=0, accountId=Account ID, additionalContextParams={"SystemTemplateId":"urn:tdm:Region/Account ID/defa
ult:System:MyExample03_V001"})
```

`StateTransition` entries include the same values for `flowInstanceId` and `flowParams` that occur in the preceding entries\.

After each step in the flow is executed, corresponding log entries for `StateTransition` appear in the log file, as in the following example for step 2 of a flow\.

```
[INFO]-[StateTransition-urn:tdm:Region/Account ID/default:Workflow:MyExample03_V001_2019-03-12T21:12:08.661Z_TenSecondTrigger_b190369e-6b44-4d14-8468-7d5c1876893a] 
StepSucceeded(super=StateTransitionMessage(super=Message(super=com.amazonaws.iotflowengine.messages.StepSucceeded@54bcaae5, 
messageId=12053, flowInstanceId=urn:tdm:Region/Account ID/default:Workflow:MyExample03_V001_2019-03-12T21:12:08.661Z_TenSecondTrigger_b190369e-6b44-4d14-8468-7d5c1876893a, createdAt=1552425129450)), 
stepId=step2, result={"__type":"com.aws.iot.tg.core.ast.tdm.PropertyValue",
"property":{"__type":"com.aws.iot.tg.core.ast.tdm.Property","propertyAlias":"_","propertyTypeUrn":{"__type":"com.aws.iot.tg.core.ast.tdm.URN","id":"urn:tdm:aws:Property:Int16"}},"value":0})
```

The log file also contains entries that provide information about the requests being sent to the devices and the responses from the devices\. The requests and responses are represented as JSON payloads\. The following example shows a successful request from AWS IoT Things Graph to a Modbus device, and the response sent by the device\. If the device uses the MQTT protocol, the request and response entries would show the MQTT topics to which the devices are subscribed\. \(AWS IoT Things Graph creates these subscriptions when you deploy the flow\.\)

```
[INFO]-Publishing message on topic modbus/adapter/request with payload {"request":{"address":4,"count":1,"device":1,"operation":"ReadHoldingRegistersRequest"},"id":"44685cb0-98f0-4f81-8bbd-7c8ac5494d6b"}

[2019-03-12T21:12:09.473Z][INFO]-Got work item with invocation id [7601c5b0-3482-4260-4733-e81c96a84486]
[2019-03-12T21:12:09.473Z][INFO]-v0.8.7
[2019-03-12T21:12:09.473Z][INFO]-Lambda input: {response={status=success, device=1, operation=ReadHoldingRegistersRequest, payload={function_code=3, registers=[0], address=4}}, id=937c3d67-36db-4403-9692-d2e8c832e70f}
[2019-03-12T21:12:09.473Z][INFO]-  json payload: {"response":{"status":"success","device":1,"operation":"ReadHoldingRegistersRequest","payload":{"function_code":3,"registers":[0],"address":4}},"id":"937c3d67-36db-4403-9692-d2e8c832e70f"}
[2019-03-12T21:12:09.473Z][INFO]-  src: modbus/adapter/response
```

These request and response entries are where you can verify that your devices are interacting correctly in the flow\. You can use these logs to determine whether any of the devices in your flow are having connectivity issues, or whether their certificates are set up correctly\. In those cases, you'll see in the log file that certain devices in the flow aren't returning responses\.

For more information about troubleshooting AWS IoT Things Graph flows, see [Troubleshooting AWS IoT Things Graph](tg-troubleshooting.html)\.