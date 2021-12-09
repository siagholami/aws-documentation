# What is AWS IoT Events?<a name="what-is-iotevents"></a>

AWS IoT Events enables you to monitor your equipment or device fleets for failures or changes in operation, and to trigger actions when such events occur\. AWS IoT Events continuously watches IoT sensor data from devices, processes, applications, and other AWS services to identify significant events so you can take action\.

You can use AWS IoT Events to build complex event monitoring applications in the AWS Cloud that you can access through the AWS IoT Events console or APIs\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/iot-events-how-it-works.png)

## Benefits and features<a name="iotevents-benefits"></a>

**Accept Inputs from Multiple Sources**  
AWS IoT Events accepts inputs from many IoT telemetry data sources\. These include sensor devices, management applications, and other AWS IoT services, such as AWS IoT Core and AWS IoT Analytics\. You can push any telemetry data input to AWS IoT Events by using a standard API interface \(`BatchPutMessage` API\)\.

**Use Simple Logical Expressions to Recognize Complex Patterns of Events**  
AWS IoT Events can recognize patterns of events that involve multiple inputs from a single IoT device or application, or from diverse equipment and many independent sensors\. This is especially useful because each sensor and application provides important information\. But only by combining diverse sensor and application data can you get a complete picture of the performance and quality of operations\. You can configure AWS IoT Events detectors to recognize these events using simple logical expressions instead of complex code\.

**Trigger Actions Based on Events**  
AWS IoT Events enables you to directly trigger actions in Amazon Simple Notification Service \(Amazon SNS\), AWS IoT Core, Lambda, Amazon SQS and Amazon Kinesis Firehose\. You can also trigger an AWS Lambda function using the AWS IoT rules engine which makes it possible to take actions using other services, such as Amazon Connect, or your own enterprise resource planning \(ERP\) applications\.  
AWS IoT Events includes a prebuilt library of actions you can take, and also enables you to define your own\.

**Automatically Scale to Meet the Demands of Your Fleet**  
AWS IoT Events scales automatically when you are connecting homogeneous devices\. You can define a detector once for a specific type of device, and the service will automatically scale and manage all instances of that device that connect to AWS IoT Events\.

## Use cases<a name="iotevents-use-cases"></a>

**Monitor and Maintain Remote Devices**  
You need to monitor a fleet of remotely deployed machines\. If one stops functioning, and you have no additional context for what's causing the failure, you might have to immediately replace the entire processing unit or machine\. But this isn't sustainable\. With AWS IoT Events you can receive messages from multiple sensors on each machine and diagnose the exact problem by using the error codes that are sent over time\. Instead of replacing everything, you now have the information you need to send a technician with only the part that needs to be replaced\. With millions of machines, savings can add up to millions of dollars, lowering your total cost of owning or maintaining each machine\.

**Manage Industrial Robots**  
You deploy robots inside your facilities to automate the movement of packages\. To keep the cost of the robots to a minimum, the robots have simple, low\-cost sensors that report information to the cloud\. But your robots have dozens of sensors and hundreds of operating modes, making it difficult to detect problems as they occur\. Using AWS IoT Events, you can build an expert system that processes sensor data in the cloud, and creates alerts to automatically warn technical staff if a failure is imminent\.

**Track Building Automation Systems**  
You operate a large number of data centers that must be monitored for high temperature and low humidity to prevent equipment failures that occur when these environmental thresholds are breached\. The sensors you use are purchased from many manufacturers, and each type comes with its own management software\. However, the management software from different vendors isn't compatible, making it difficult to detect problems\. Using AWS IoT Events, you can set up alerts to notify your operations analysts of issues with your heating and cooling systems well in advance of failures\. In this way, you can prevent an unscheduled data center shutdown that would cost thousands of dollars in equipment replacement and potential lost revenue\.