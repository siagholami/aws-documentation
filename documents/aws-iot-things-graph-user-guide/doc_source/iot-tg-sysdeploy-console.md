--------

--------

# Viewing Flow Configurations and Flow Executions in the AWS IoT Things Graph Console<a name="iot-tg-sysdeploy-console"></a>

The flow configurations pages in the [AWS IoT Things Graph console](https://console.aws.amazon.com/thingsgraph/home) shows you all of the deployments that you've created and their current statuses\. This page also links to more detailed summary information about each deployment\. This includes the date when the deployment was created, and the things assigned to each device or device model in the flow\. 

The deployment details page also provides a list of flow executions\. Each flow execution links to a page that contains the messages that each flow execution sent\. These messages provide information such as the time when each step begins executing, when it completes successfully, and when it fails\.

This topic describes the features of the flow configurations and flow executions pages and how to access them\.

## Flow Configurations<a name="iot-tg-sysdeploy-console-sys-instance"></a>

The main page of the flow configurations section lists all of the flow configurations that you've created\. For each flow configuration, t also lists the ID \(an AWS IoT Things Graph Data Model \[TDM\] URN\), the status, and date created\. For AWS IoT Greengrass deployments, it lists the name of the AWS IoT Greengrass group that is the deployment target of the flow configuration\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGSysInstanceList.png)

To see more detailed summary data about a flow configuration, click its name\. The next page displays general configuration information about the flow configuration\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGSysInstanceDetails.png)

The **Assigned Things** section of this page also displays the things from your AWS IoT registry that you assigned to the devices or device models in the flow\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGSysInstanceThings.png)

## Flow Executions<a name="iot-tg-sysdeploy-console-flow-executions"></a>

To see a list of flow executions for the flow configuration, choose the **Flow executions** tab\. The **Flow executions** page contains a list that shows every execution of the flow after you deployed it\. A flow execution begins every time a trigger starts a flow, and it ends at the successful or unsuccessful completion of the flow\. 

You can use this page to determine when the flow in your flow configuration is failing to complete\. If you're looking for details about flow executions within a specific time frame, you can search for the execution start date and time\.

To view the messages for a specific flow execution, select the flow execution, and then choose **View details** in the upper right of the page\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowExecutions.png)

The **Flow executions messages** page displays messages for each step and activity in the flow\. It indicates when a step is scheduled, when a step starts, and when an activity starts\. It displays the values of the flow parameters and the inputs that AWS IoT Things Graph passed to each step and activity in the flow\. It also indicates when a failure occurred\. You can use this page to troubleshoot flow execution failures\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGFlowMessages.png)