--------

--------

# How a Flow Works<a name="iot-tg-whatis-howitworks"></a>

When you deploy a flow configuration, the AWS IoT Things Graph runtime is deployed to the cloud or to an AWS IoT Greengrass core device\. The AWS IoT Things Graph runtime identifies trigger devices and messages and handles communications between the devices and web services to ensure that the flow executes in the expected order\. You can create model and flow definitions using either the AWS IoT Things Graph console or the AWS IoT Things Graph APIs\.

The following diagram shows how an AWS IoT Things Graph flow works when device and flow definitions are deployed and a flow is ready to run\. This is a hypothetical automated door entry workflow for a building's security system, and is an example of a business process represented as a graph\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/tgAutomation.png)

In the diagram, the badge reader is defined by Model A, the validation web service by Model B, the turnstile by Model C, and the camera by Model D\. When a valid badge is scanned, the badge reader triggers an event that causes the next step to execute\. This step is a validation web service\. The step calls the validation API in the service\. In this way, AWS IoT Things Graph coordinates all of the steps in the graph\. 

The nodes in the graph represent *things* \(devices or web services\), and the edges represent *connections* between pairs of nodes\. 

Each thing is described by a *model* \(a device definition\)\. The models define each thing as a set of inputs, outputs, and attributes\. Models also expose interfaces for the rest of the application to use\. Each step \(node\) in a workflow \(flow\) represents an action for a device, service, or built\-in control flow action to take\. A connection between two nodes represents a logical interaction or an order of execution between two nodes\. A flow is one or more steps chained together, and represents business processes\.