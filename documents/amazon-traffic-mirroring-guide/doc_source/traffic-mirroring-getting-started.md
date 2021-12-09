# Getting Started with Traffic Mirroring<a name="traffic-mirroring-getting-started"></a>

The following tasks help you to become familiar with traffic mirror targets, filters, and sessions\. Follow the instructions to create a traffic mirror target and filter, and then use those resources to create a session\.

**Topics**
+ [Prerequisites](#traffic-mirroring-prerequisites)
+ [Step 1: Create the Traffic Mirror Target](#step-create-traffic-mirroring-target)
+ [Step 2: Create the Traffic Mirror Filter](#step-create-traffic-mirroing-filters)
+ [Step 3: Create the Traffic Mirror Session](#step-create-traffic-mirroing-sessions)

## Prerequisites<a name="traffic-mirroring-prerequisites"></a>
+ Make sure that the traffic mirror source and traffic mirror target are either: 
  + In the same VPC, or
  + In different VPCs that are connected via VPC peering or a transit gateway\.
+ Make sure that the traffic mirror target instance allows traffic to UDP port 4789\.
+ Make sure that the traffic mirror source has a route table entry for the traffic mirror target\.
+ Make sure that there are no security group rules or network ACL rules on the traffic mirror target that drop the mirrored traffic from the traffic mirror source\.
+ Review the Traffic Mirroring considerations\. For more information, see [Traffic Mirroring Service Quotas and Considerations](traffic-mirroring-considerations.md)\.

## Step 1: Create the Traffic Mirror Target<a name="step-create-traffic-mirroring-target"></a>

Create a destination for mirrored traffic\.

**Create a traffic mirror target**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the VPCs\.

1. On the navigation pane, choose **Traffic Mirroring**, **Mirror Targets**\.

1. Choose **Create Traffic Mirror Target**\.

1. For **Name tag**, enter a name for the traffic mirror target\.

1. \(Optional\) For **Description**, enter a description for the traffic mirror target\.

1. For **Target type**, choose the traffic mirror target type\.

1. For **Target**, choose the traffic mirror target\.

1. \(Optional\) Add or remove a tag\.

   \[Add a tag\] Choose **Add tag** and do the following:
   + For **Key**, enter the key name\.
   + For **Value**, enter the key value\.

   \[Remove a tag\] Next to the tag, choose **Remove tag**\.

1. Choose **Create**\.

## Step 2: Create the Traffic Mirror Filter<a name="step-create-traffic-mirroing-filters"></a>

A traffic mirror filter contains one or more traffic mirror rules, and a set of network services\. The filters and rules that you add define the traffic that is mirrored\. 

**To create a traffic mirror filter**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the VPCs\.

1. On the navigation pane, choose **Traffic Mirroring**, **Mirror Filters**\.

1. Choose **Create traffic mirror filter**\.

1. For **Name tag**, enter a name for the traffic mirror filter\.

1. \(Optional\) For **Description**, enter a description for the traffic mirror filter\.

1. \(Optional\) Mirror network services\.

   \[Mirror Amazon DNS traffic\] Select **amazon\-dns**\.

1. \(Optional\) Add inbound rules\. Under **Inbound rules**, choose **Add, rule**, and then specify the following information about the traffic mirror source inbound traffic:
   + **Rule Number**: Enter a priority to assign to the rule\.
   + **Rule action**: Choose the action to take for the packet\.
   + **Protocol**: Choose the L4 protocol to assign to the rule\.
   + \(Optional\) **Source port range**: Enter the source port range\.
   + \(Optional\) **Destination port range**: Enter the destination port range\.
   + **Source CIDR block**: Enter a source CIDR block\.
   + **Destination CIDR block**: Enter a destination CIDR block\.
   + \(Optional\) **Description**: Enter a description for the rule\.

    Repeat for each inbound rule that you want to add\.

1. \(Optional\) Add outbound rules\. Under **Outbound rules**, choose **Add, rule**, and then specify the following information about the traffic mirror source outbound traffic:
   + **Rule number**: Enter a priority to assign to the rule\.
   + **Rule action**: Choose the action to take for the packet\.
   + **Protocol**: Choose the IP protocol to assign to the rule\.
   +  \(Optional\) **Source port range**: Enter the source port range\.
   + \(Optional\) **Destination port range**: Enter the destination port range\.
   +  **Source CIDR block**: Enter a source CIDR block\.
   + **Destination CIDR block**: Enter a destination CIDR block\.
   + \(Optional\) **Description**: Enter a description for the rule\.

    Repeat for each outbound rule that you want to add\.

1. \(Optional\) Add or remove a tag\.

   \[Add a tag\] Choose **Add tag** and do the following:
   + For **Key**, enter the key name\.
   + For **Value**, enter the key value\.

   \[Remove a tag\] Next to the tag, choose **Remove tag**\.

1. Choose **Create**\.

## Step 3: Create the Traffic Mirror Session<a name="step-create-traffic-mirroing-sessions"></a>

Create a traffic mirror session that sends mirrored packets from the source to a target so that you can monitor and analyze traffic\.

**To create a traffic mirror session**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the VPCs\.

1. In the navigation pane, choose **Traffic Mirroring**, **Mirror Sessions**\.

1. Choose **Create traffic mirror session**\.

1. \(Optional\) For **Name tag**, enter a name for the traffic mirror session\.

1. \(Optional\) For **Description**, enter a description for the traffic mirror session\.

1. For **Mirror source**, choose the network interface of the instance that you want to monitor\. 

1. For **Mirror target**, choose the traffic mirror target\.

1. Under **Additional settings**, do the following:

   1. For **Session number**, enter the session number\.

      The session number determines the order that traffic mirror sessions are evaluated in both of the following situations:
      + When an interface is used by multiple sessions\.
      + When an interface is used by different traffic mirror targets and traffic mirror filters\.

      Traffic is only mirrored one time\.

      Use **1** for the highest priority\.

      Valid values are 1\-32766\.

   1. \(Optional\) For **VNI**, enter the VXLAN ID to use for the traffic mirror session\. For more information about the VXLAN protocol, see [RFC 7348](https://tools.ietf.org/html/rfc7348)\.

      If you do not enter a value, we assign a random unused number\.

   1. \(Optional\) For **Packet Length**, enter the number of bytes in each packet to mirror\.

      If you do not want to mirror the entire packet, set **Packet Length** to the number of bytes in each packet to mirror\. For example, if you set this value to 100, the first 100 bytes after the VXLAN header that meet the filter criteria are copied to the target\.

      To mirror the entire packet, do not enter a value in this field\.

   1. For **Filter**, choose the traffic mirror filter that determines what traffic gets mirrored\.

1. \(Optional\) Add or remove a tag\.

   \[Add a tag\] Choose **Add tag** and do the following:
   + For **Key**, enter the key name\.
   + For **Value**, enter the key value\.

   \[Remove a tag\] Next to the tag, choose **Remove tag**\.

1. Choose **Create**\.