# Adding, editing, or removing an endpoint group<a name="about-endpoint-groups.create-endpoint-group"></a>

You work with endpoint groups on the AWS Global Accelerator console or by using an API operation\. You can add or remove endpoints from an endpoint group at any time\.

This section explains how to work with endpoint groups on the AWS Global Accelerator console\. If you want to use API operations with Global Accelerator, see the[ AWS Global Accelerator API Reference](https://docs.aws.amazon.com/global-accelerator/latest/api/Welcome.html)\.

# To add an endpoint group

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. In the **Listeners** section, for **Listener ID**, choose the ID of the listener that you want to add an endpoint group to\.

1. Choose **Add endpoint group**\.

1. In the section for a listener, specify a Region for the endpoint group by choosing one from the dropdown list\.

1. Optionally, for **Traffic dial**, enter a number from 0 to 100 to set a percentage of traffic for this endpoint group\. The percentage is applied only to the traffic that is already directed to this endpoint group, not all listener traffic\. By default, the traffic dial is set to 100\.

1. Optionally, to specify custom health check values to be applied to EC2 instance and Elastic IP address endpoints, choose **Configure health checks**\. For more information, see [Health check options](about-endpoint-groups-health-check-options.md)\.

1. Optionally, choose **Add endpoint group** to add additional endpoint groups for this listener or other listeners\.

1. Choose **Add endpoint group**\.

# To edit an endpoint group

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. In the **Listeners** section, for **Listener ID**, choose the ID of the listener that the endpoint group is associated with\.

1. Choose **Edit endpoint group**\.

1. On the **Edit endpoint group** page, change the Region, adjust the traffic dial percentage, or choose **Configure health checks** to modify the health check settings\.

1. Choose **Save**\.

# To remove an endpoint group

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. In the **Listeners** section, choose a listener, and then choose **Remove**\.

1. In the **Endpoint groups** section, choose an endpoint group, and then choose **Remove**\.

1. On the confirmation dialog box, choose **Remove**\.