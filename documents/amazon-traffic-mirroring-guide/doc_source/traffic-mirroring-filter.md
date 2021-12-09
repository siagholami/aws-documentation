# Traffic Mirror Filters<a name="traffic-mirroring-filter"></a>

Use a traffic mirror filter and its rules to define the traffic that is mirrored\. A traffic mirror filter contains one or more traffic mirror rules, and a set of network services\. 

You can define a set of parameters to apply to the traffic mirror source traffic to determine the traffic to mirror\. The following traffic mirror filter rule parameters are available:
+ Traffic direction: Inbound or outbound
+ Action: The action to take, either to accept or reject the packet
+ Protocol: The L4 protocol
+ Source port range
+ Destination port range
+ Source CIDR block
+ Destination CIDR block

## Create a Traffic Mirror Filter<a name="create-traffic-mirroring-filter"></a>

Create a traffic mirror filter\.

Create a traffic mirror filter and add rules to the filter to define the traffic that is mirrored\. A traffic mirror filter contains one or more traffic mirror rules, and a set of network services\. 

The **Source CIDR block** and **Destination CIDR block** values must both be either an IPv4 range or an IPv6 range\.

**To create a traffic mirror filter using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the VPCs\.

1. On the navigation pane, choose **Traffic Mirroring**, **Mirror Filters**\.

1. Choose **Create traffic mirror filter**\.

1. For **Name tag**, enter a name for the traffic mirror filter\.

1. \(Optional\) For **Description**, enter a description for the traffic mirror filter\.

1. \(Optional\) Mirror network services\.

   \[Mirror Amazon DNS traffic\] Select **amazon\-dns**\.

1. \(Optional\) Add inbound rules\. Choose **Inbound rules**, **Add, rule**, and then specify the following information about the traffic mirror source inbound traffic:
   + **Rule number**: Enter a priority to assign to the rule\.
   + **Rule action**: Choose the action to take for the packet\.
   + **Protocol**: Choose the L4 protocol to assign to the rule\.
   + \(Optional\) **Source port range**: Enter the source port range\.
   + \(Optional\) **Destination port range**: Enter the destination port range\.
   + **Source CIDR block**: Enter a source CIDR block\.
   + **Destination CIDR block**: Enter a destination CIDR block\.
   + \(Optional\) **Description**: Enter a description for the rule\.

    Repeat for each inbound rule that you want to add\.

1. \(Optional\) Add outbound rules\. Choose **Outbound rules**, **Add, rule**, and then specify the following information about the traffic mirror source outbound traffic:
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

**To create a traffic mirror filter using the AWS CLI**  
Use the [create\-traffic\-mirror\-filter](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-traffic-mirror-filter.html) command\.

## Modify Your Traffic Mirror Filter Rules<a name="modify-traffic-mirroring-filter-rules"></a>

Add or remove inbound and outbound traffic mirror filter rules\.

The **Source CIDR block** and **Destination CIDR block** values must both be either an IPv4 range or an IPv6 range\.

**To modify your traffic mirror filter using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the traffic mirror filter\.

1. On the navigation pane, choose **Traffic Mirroring**, **Mirror Filters**\.

1. Select the traffic mirror filter\.

1. Add inbound rules\. Choose **Inbound rules **, **Add inbound rule**, and then specify the following information about the traffic mirror source inbound traffic:
   + **Rule number**: Enter a priority to assign to the rule\.
   + **Rule action**: Choose the action to take for the packet\.
   + **Protocol**: Choose the L4 protocol to assign to the rule\.
   + \(Optional\) **Source port range**: Enter the source port range\.
   + \(Optional\) **Destination port range**: Enter the destination port range\.
   + **Source CIDR block**: Enter a source CIDR block\.
   + **Destination CIDR block**: Enter a destination CIDR block\.
   + \(Optional\) **Description**: Enter a description for the rule\.

    Repeat for each inbound rule that you want to add\.

1. Add outbound rules\. Choose **Outbound rules **, **Add outbound rule**, and then specify the following information about the traffic mirror source outbound traffic:
   + **Rule number**: Enter a priority to assign to the rule\.
   + **Rule action**: Choose the action to take for the packet\.
   + **Protocol**: Choose the IP protocol to assign to the rule\.
   +  \(Optional\) **Source port range**: Enter the source port range\.
   + \(Optional\) **Destination port range**: Enter the destination port range\.
   +  **Source CIDR block**: Enter a source CIDR block\.
   + **Destination CIDR block**: Enter a destination CIDR block\.
   + \(Optional\) **Description**: Enter a description for the rule\.

    Repeat for each outbound rule that you want to add\.

1. Delete an inbound rule\.

   Choose **Inbound rules**, and then do the following:
   + Select the rule, and then choose **Delete**\.
   + In the **Delete confirmation** dialog box, enter **delete**, and then choose **Delete**\. 

1. Delete an outbound rule\. Choose **Outbound rules**, and then do the following:
   + Select the rule, and then choose **Delete**\.
   + In the **Delete confirmation** dialog box, enter **delete**, and then choose **Delete**\. 

1. Modify a rule\. Choose **Inbound rules**, or **Outbound rules**, and then do the following:
   + Select the rule, and choose **Modify inbound rule** or **Modify outbound rule**\.
   + Make the required changes, and then choose **Modify rule**\. 

## Modify Traffic Mirror Filter Tags<a name="modify-traffic-mirroring-filter-tags"></a>

**To modify your traffic mirror filters using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the traffic mirror filter\.

1. On the navigation pane, choose **Traffic Mirroring**, **Mirror Filters**\.

1. Select the traffic mirror filter\.

1. Choose **Tags**, **Manage tags**\.

1. \[Add a tag\] Choose **Add tag** and do the following:
   + For **Key**, enter the key name\.
   + For **Value**, enter the key value\.

   \[Remove a tag\] Next to the tag, choose **Remove tag**\.

1. Choose **Save changes**\.

**To modify the traffic mirror filter tags using the AWS CLI**  
Use the [tag\-resource](https://docs.aws.amazon.com/cli/latest/reference/directconnect/tag-resource.html) command to add a tag\. Use the [untag\-resource](https://docs.aws.amazon.com/cli/latest/reference/directconnect/untag-resource.html) command to remove a tag\.

## Modify Traffic Mirror Filter Network Services<a name="modify-traffic-mirroring-filter-network-services"></a>

**To modify your traffic mirror filter network services using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the traffic mirror filter\.

1. On the navigation pane, choose **Traffic Mirroring**, **Mirror Filters**\.

1. Select the traffic mirror filter\.

1. Choose modify Network Services\.

1. \[Mirror Amazon DNS traffic\] Select **amazon dns**\.

1. Choose **Modify**\.

**To modify the network services traffic mirror filters using the AWS CLI**  
Use the [modify\-traffic\-mirror\-filter\-network\-services](https://docs.aws.amazon.com/cli/latest/reference/ec2/modify-traffic-mirror-filter-network-services.html) command\.

## View Your Traffic Mirror Filters<a name="view-traffic-mirroring-filter"></a>

**To view your traffic mirror filters using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the traffic mirror filter\.

1. On the navigation pane, choose **Traffic Mirroring**, **Mirror Filters**\.

1. Select the traffic mirror filter\.

**To view your traffic mirror filters using the AWS CLI**  
Use the [describe\-traffic\-mirror\-filters](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-traffic-mirror-filters.html) command\.

## Delete a Traffic Mirror Filter<a name="delete-traffic-mirroring-filter"></a>

**To delete a traffic mirror filter using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the **Region** selector, choose the AWS Region that you used when you created the traffic mirror filter\.

1. On the navigation pane, choose **Traffic Mirroring**, **Mirror Filters**\.

1. Select the traffic mirror filter, and then choose **Delete**\.

1. In the **Delete confirmation** dialog box, enter **delete**, and then choose **Delete**\.

**To delete a traffic mirror filter using the AWS CLI**  
Use the [delete\-traffic\-mirror\-filter](https://docs.aws.amazon.com/cli/latest/reference/ec2/delete-traffic-mirror-filter.html) command\.