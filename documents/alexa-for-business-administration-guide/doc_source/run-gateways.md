# Running Multiple Gateways<a name="run-gateways"></a>

You can run multiple gateways to eliminate a single point of failure\. You can also run a gateway in each of your locations to lower the latency between the gateway and your Cisco or Polycom endpoints\. This is also an option if you want to run the gateway on different network subnets\.

The following are two examples of how to set up multiple gateways:

![\[Multiple gateway examples\]](http://docs.aws.amazon.com/a4b/latest/ag/images/multiple-gateways.PNG)

When you register a gateway to your AWS account, the gateway is added to a gateway group\. When you add video conferencing endpoints, you must also assign a gateway group\. The gateways registered to this gateway group will control your endpoint when you ask Alexa to start your meeting\.

**Note**  
You can add a gateway group to run a gateway in a different location, and choose this group when you register new gateway\.

**To add a gateway group**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conferencing settings**, **Alexa for Cisco TelePresence/Polycom Group Series**, **Add gateway group**\.

1. Enter the **Name** and an optional description, and choose **Add gateway group**\.

1. To add a gateway to your group, follow the steps to install and register the gateway\. \(When prompted, select the gateway group that you just created\.\)

If you need to add a gateway to a different group, first remove the gateway, then register it again\.

**To remove a gateway group**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conferencing settings**, **Alexa for Cisco TelePresence/Polycom Group Series**, **Remove gateway group**, and **Remove**\.

1. Alexa for Business can no longer control the conferencing endpoints that were controlled with this group\.