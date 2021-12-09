# Adding, editing, or removing a listener<a name="about-listeners.creating-listeners"></a>

This section explains how to work with listeners on the AWS Global Accelerator console\. To complete these tasks by using an API operation instead of the console, see [https://docs.aws.amazon.com/global-accelerator/latest/api/API_CreateListener.html](https://docs.aws.amazon.com/global-accelerator/latest/api/API_CreateListener.html), [https://docs.aws.amazon.com/global-accelerator/latest/api/API_UpdateListener.html](https://docs.aws.amazon.com/global-accelerator/latest/api/API_UpdateListener.html), and [https://docs.aws.amazon.com/global-accelerator/latest/api/API_DeleteListener.html](https://docs.aws.amazon.com/global-accelerator/latest/api/API_DeleteListener.html) in the *AWS Global Accelerator API Reference*\.

# To add a listener

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. Choose **Add listener**\.

1. On the **Add listener** page, enter the ports or port ranges that you want to associate with the listener\. Listeners support ports 1\-65535\.

1. Choose the protocol for the ports that you entered\.

1. Optionally, choose to enable client affinity\. Client affinity for a listener means that Global Accelerator ensures that connections from a specific source \(client\) IP address are always routed to the same endpoint\. To enable this behavior, in the dropdown list, choose **Source IP**\.

   The default is **None**, which means that client affinity is not enabled and Global Accelerator distributes traffic equally between the endpoints in the endpoint groups for the listener\.

   For more information, see [Client affinity](about-listeners-client-affinity.md)\.

1. Choose **Add listener**\.

# To edit a listener

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. Choose a listener, and then choose **Edit listener**\.

1. On the **Edit listener** page, change the ports, port ranges, or protocols that you want to associate with the listener\.

1. Optionally, choose to enable client affinity\. Client affinity for a listener means that Global Accelerator ensures that connections from a specific source \(client\) IP address are always routed to the same endpoint\. To enable this behavior, in the dropdown list, choose **Source IP**\.

   The default is **None**, which means that client affinity is not enabled and Global Accelerator distributes traffic equally between the endpoints in the endpoint groups for the listener\.

   For more information, see [Client affinity](about-listeners-client-affinity.md)\.

1. Choose **Save**\.

# To remove a listener

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. Choose a listener, and then choose **Remove**\.

1. In the confirmation dialog box, choose **Remove**\.