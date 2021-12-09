--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Automating Your Management Tasks<a name="automate-task"></a>

You can use AWS OpsHub to automate operational tasks that you perform frequently on your Snow Family Devices\. You can create a task for reoccurring actions that you might want to perform on resources, such as restarting virtual servers, stopping Amazon EC2 instances, and so on\. You provide an automation document that safely performs operational tasks and executes the operation on AWS resources in bulk\. You can also schedule common IT workflows\. 

**Note**  
 Automating tasks is not supported on clusters\.

**Topics**
+ [Creating and Starting a Task](#create-task)
+ [Viewing Details of a Task](#view-task)
+ [Deleting a Task](#delete-task)

## Creating and Starting a Task<a name="create-task"></a>

When you create a task, you specify the types of resources that the task should run on, and then provide a task document that contains the instructions that run the task\. The task document is either in YAML or JSON format\. You then provide the required parameters for the task and start the task\.

**To create a task**

1. In the **Launch tasks** section of the dashboard, choose **Get started** to open the Tasks page\. If you have created tasks, they appear under **Tasks**\. 

1. Choose **Create task** and provide details for the task\.

1. For **Name**, enter a unique name for the task\.
**Tip**  
The name must be between 3 and 128 characters\. Valid characters are `a-z`, `A-Z`, `0-9`, `.`, `_`, and `-`\.

1. Optionally, you can choose a target type from the **Target type\-optional** list\. This is the type of resource that you want the task to run on\. 

   For example, you can specify **/AWS::EC2::Instance** for the tasks to run on an Amazon EC2 instance or **/** to run on all resource types\. 

1. In the **Content** section, choose **YAML** or **JSON**, and provide the script that executes the task\. You have two options, YAML or JSON format\. For examples, see [Task Examples](#task-examples)\.

1. Choose **Create**\. The task that you created then appears on the **Tasks** page\.

**To start a task**

1. In the **Launch tasks** section of the dashboard, choose **Get started** to open the **Tasks** page\. Your tasks appear under **Tasks**\.

1. Choose your task to open the **Start task** page\.

1. Choose **Simple execution** to run on targets\. 

   Choose **Rate control** to run safely on multiple targets and define concurrency and error thresholds\. For this option, you provide the additional target and error threshold information in the **Rate control** section\. 

1. Provide the required input parameters, and choose **Start task**\. 

   The status of the task is **Pending**, and changes to **Success** when the task has run successfully\.

### Task Examples<a name="task-examples"></a>

The following example restarts an Amazon EC2 instance\. It requires two input parameters: `endpoint` and `instance ID`\. 

*YAML example*

```
description: Restart EC2 instance
schemaVersion: '0.3'
parameters:
  Endpoint:
    type: String
    description: (Required) EC2 Service Endpoint URL
  Id:
    type: String
    description: (Required) Instance Id
mainSteps:
  - name: restartInstance
    action: aws:executeScript
    description: Restart EC2 instance step
    inputs:
      Runtime: python3.7
      Handler: restart_instance
      InputPayload:
        Endpoint: "{{ Endpoint }}"
        Id: "{{ Id }}"
      TimeoutSeconds: 30
      Script: |-
        import boto3
        import time
        def restart_instance(payload, context):
            ec2_endpoint = payload['Endpoint']
            instance_id = payload['Id']
            ec2 = boto3.resource('ec2', endpoint_url=ec2_endpoint)
            instance = ec2.Instance(instance_id)
            if instance.state['Name'] != 'stopped':
                instance.stop()
                instance.wait_until_stopped()
            instance.start()
            instance.wait_until_running()
            return {'InstanceState': instance.state}
```

*JSON example*

```
{
  "description" : "Restart EC2 instance",
  "schemaVersion" : "0.3",
  "parameters" : {
    "Endpoint" : {
      "type" : "String",
      "description" : "(Required) EC2 Service Endpoint URL"
    },
    "Id" : {
      "type" : "String",
      "description" : "(Required) Instance Id"
    }
  },
  "mainSteps" : [ {
    "name" : "restartInstance",
    "action" : "aws:executeScript",
    "description" : "Restart EC2 instance step",
    "inputs" : {
      "Runtime" : "python3.7",
      "Handler" : "restart_instance",
      "InputPayload" : {
        "Endpoint" : "{{ Endpoint }}",
        "Id" : "{{ Id }}"
      },
      "TimeoutSeconds" : 30,
      "Script" : "import boto3\nimport time\ndef restart_instance(payload, context):\n    
            ec2_endpoint = payload['Endpoint']\n    instance_id = payload['Id']\n    
            ec2 = boto3.resource('ec2', endpoint_url=ec2_endpoint)\n    
            instance = ec2.Instance(instance_id)\n    
            if instance.state['Name'] != 'stopped':\n        
            instance.stop()\n        
            instance.wait_until_stopped()\n    
            instance.start()\n    
            instance.wait_until_running()\n    
            return {'InstanceState': instance.state}"
    }
  } ]
}
```

## Viewing Details of a Task<a name="view-task"></a>

You can view details of a management task, such as the description and the parameters that are required to run the task\.

**To view details of a task**

1. In the **Launch tasks** section of the dashboard, choose **Get started** to open the **Tasks** page\. 

1. On the **Tasks** page, locate and choose the task that you want to see details of\.

1. Choose **View details**, and choose one of the tabs to see the details\. For example, the **Parameters** tab shows you the input parameters in the script\.

## Deleting a Task<a name="delete-task"></a>

Follow these steps to delete a management task\.

**To delete a task**

1. In the **Launch tasks** section of the dashboard, choose** Get started** to open the **Tasks** page\. 

1. Locate the task that you want to delete\. Choose the task, and then choose **Delete**\.