# Viewing Source and Client IP Addresses in AWS Global Accelerator<a name="introduction-how-it-works.client-ip"></a>

Because AWS Global Accelerator serves as a proxy layer between your clients and endpoints, the client IP address is not visible to your endpoints\. Instead, the endpoint sees packets as coming from the source IP address for Global Accelerator\. This means that you can't use IP address filter rules, such as rules for security groups or network ACLs, as mitigations for specific client IP addresses\.

However, you can filter for the source IP addresses that Global Accelerator uses\. For more information, see [IP Address Ranges of Global Accelerator Edge Servers](introduction-ip-ranges.md)\. 

You can see information about the client IP addresses of incoming packets by reviewing your Global Accelerator flows logs\. For more information, see [Flow Logs in AWS Global Accelerator](monitoring-global-accelerator.flow-logs.md)\.