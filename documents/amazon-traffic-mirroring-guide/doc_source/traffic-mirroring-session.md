# Traffic Mirror Sessions<a name="traffic-mirroring-session"></a>

A traffic mirror session establishes a relationship between a traffic mirror source and a traffic mirror target\.

A traffic mirror session contains the following resources:
+ A traffic mirror source
+ A traffic mirror target 
+ A traffic mirror filter

A given packet is only mirrored one time\. However, you can use multiple traffic mirror sessions on the same source when you want to send a subset of the mirrored traffic from a traffic mirror source to different tools\. For example, you can filter HTTP traffic in a higher priority traffic mirror session and send it to a specific monitoring appliance\. Then you can filter all other TCP traffic in a lower priority traffic mirror session and send it to another monitoring appliance\.

Traffic mirror sessions are evaluated based on the ascending priority that you define when you create the session\. 

## Create a Traffic Mirror Session<a name="create-traffic-mirroring-session"></a>

Create a traffic mirror session\.

Before you create a traffic mirror session, make sure that you have the following information:
+ The source
+ The traffic mirror target
  + To use a target in your account, see [Create a Traffic Mirror Target](traffic-mirroring-target.md#create-traffic-mirroring-target)\.
  + To use a target that is owned by another account and shared with you, accept the shared resource before you create the traffic mirror session\. For more information, see [Accepting a Resource Share](cross-account-traffic-mirroring-targets.md#tm-share-accept)\.
+ The traffic mirror filter \(for more information, see [Create a Traffic Mirror Filter](traffic-mirroring-filter.md#create-traffic-mirroring-filter)\)

**To create a traffic mirror session using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the VPCs\.

1. In the navigation pane, choose **Traffic Mirroring**, **Mirror Sessions**\.

1. Choose **Create traffic mirror session**\.

1. \(Optional\) For **Name tag**, enter a name for the traffic mirror session\.

1. \(Optional\) For **Description**, enter a description for the traffic mirror session\.

1. For **Mirror source**, choose the network interface of the instance that you want to monitor\. 

1. For **Mirror target**, choose the traffic mirror target\.

   To create a target, choose **Create target**\. For more information, see [Create a Traffic Mirror Target](traffic-mirroring-target.md#create-traffic-mirroring-target)\.

1. Under **Additional settings**, do the following:

   1. For **Session number**, enter the session number\.

      The session number determines the order that traffic mirror sessions are evaluated when an interface is used by multiple sessions that have the same interface, but have different traffic mirror targets and traffic mirror filters\. Traffic is only mirrored one time\.

      Use **1** for the highest priority\.

      Valid values are 1\-32766\.

   1. \(Optional\) For **VNI**, enter the VXLAN ID to use for the traffic mirror session\. For more information about the VXLAN protocol, see [RFC 7348](https://tools.ietf.org/html/rfc7348)\.

      If you do not enter a value, we assign a random number\.

   1. \(Optional\) For **Packet Length**, enter the number of bytes in each packet to mirror\.

      If you do not want to mirror the entire packet, set **Packet Length** to the number of bytes in each packet to mirror\. For example, if you set this value to 100, the first 100 bytes after the VXLAN header that meet the filter criteria are copied to the target\.

      To mirror the entire packet, do not enter a value in this field\.

   1. For **Filter**, choose the traffic mirror filter that determines what traffic gets mirrored\.

      To create a filter, choose **Create filter**\. For more information, see [Step 2: Create the Traffic Mirror Filter](traffic-mirroring-getting-started.md#step-create-traffic-mirroing-filters)\.

1. \(Optional\) Add or remove a tag\.

   \[Add a tag\] Choose **Add tag** and do the following:
   + For **Key**, enter the key name\.
   + For **Value**, enter the key value\.

   \[Remove a tag\] Next to the tag, choose **Remove tag**\.

1. Choose **Create**\.

**To create a traffic mirror session using the AWS CLI**  
Use the [create\-traffic\-mirror\-session](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-traffic-mirror-session.html) command\.

## Modify Your Traffic Mirror Session<a name="modify-traffic-mirroring-session"></a>

**To modify your traffic mirror session using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the traffic mirror session\.

1. In the navigation pane, choose **Traffic Mirroring**, **Mirror Sessions**\.

1. Select the traffic mirror session\.

1. Choose **Modify session**\.

1. \(Optional\) For **Description**, enter a description for the traffic mirror session\.

1. For **Mirror target**, choose the traffic mirror target\.

   To create a target, choose **Create target**\. For more information, see [Create a Traffic Mirror Target](traffic-mirroring-target.md#create-traffic-mirroring-target)\.

1. Under **Additional settings**, do the following:

   1. For **Session number**, enter the session number\.

      The session number determines the order that traffic mirror sessions are evaluated when an interface is used by multiple sessions, but that have different traffic mirror targets and traffic mirror filters\. Traffic is only mirrored one time\.

      Use **1** for the highest priority\.

      Valid values are 1\-32766\.

   1. \(Optional\) For **VNI**, enter the VXLAN ID to use for the traffic mirror session\. For more information about the VXLAN protocol, see [RFC 7348](https://tools.ietf.org/html/rfc7348)\.

      If you do not enter a value, we assign a random unused number\.

   1. \(Optional\) For **Packet Length**, enter the number of bytes in each packet to mirror\.

      If you do not want to mirror the entire packet, set **Packet Length** to the number of bytes in each packet to mirror\. For example, if you set this value to 100, the first 100 bytes after the VXLAN header that meet the filter criteria are copied to the target\.

      To mirror the entire packet, do not enter a value in this field\.

   1. For **Filter**, choose the traffic mirror filter that determines what traffic gets mirrored\.

1. Choose **Modify**\.

**To modify your traffic mirror session using the AWS CLI**  
Use the [modify\-traffic\-mirror\-session](https://docs.aws.amazon.com/cli/latest/reference/ec2/modify-traffic-mirror-session.html) command\.

## Modify Traffic Mirror Session Tags<a name="tag-traffic-mirroring-session"></a>

**To modify your traffic mirror session tags using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the traffic mirror session\.

1. In the navigation pane, choose **Traffic Mirroring**, **Mirror Sessions**\.

1. Select the traffic mirror session\.

1. Choose **Tags**, **Manage tags**\.

1. Add or remove a tag\.

   \[Add a tag\] Choose **Add tag**, and then do the following:
   + For **Key**, enter the key name\.
   + For **Value**, enter the key value\.

   \[Remove a tag\] Next to the tag, choose **Remove tag**\.

1. Choose **Modify**\.

**To modify your traffic mirror session using the AWS CLI**  
Use the [modify\-traffic\-mirror\-session](https://docs.aws.amazon.com/cli/latest/reference/ec2/modify-traffic-mirror-session.html) command\.

## View Your Traffic Mirror Sessions<a name="view-traffic-mirroring-session"></a>

**To view your traffic mirror sessions using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the traffic mirror session\.

1. In the navigation pane, choose **Traffic Mirroring**, **Mirror Sessions**\.

1. Select the traffic mirror session\.

**To view your traffic mirror session using the AWS CLI**  
Use the [describe\-traffic\-mirror\-sessions](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-traffic-mirror-sessions.html) command\.

## Delete a Traffic Mirror Session<a name="delete-traffic-mirroring-session"></a>

**To delete your traffic mirror session using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the traffic mirror session\.

1. On the navigation pane, choose **Traffic Mirroring**, **Mirror Sessions**\.

1. Select the traffic mirror session, and then choose **Delete**\.

1. In the **Delete confirmation** dialog box, enter **delete**, and then choose **Delete**\.

**To delete a traffic mirror session using the AWS CLI**  
Use the [delete\-traffic\-mirror\-session](https://docs.aws.amazon.com/cli/latest/reference/ec2/delete-traffic-mirror-session.html) command\.