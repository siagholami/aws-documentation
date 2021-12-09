# Transit gateway route tables<a name="tgw-route-tables"></a>

Use transit gateway route tables to configure routing for your transit gateway attachments\.

## Create a transit gateway route table<a name="create-tgw-route-table"></a>

**To create a transit gateway route table using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Choose **Create Transit Gateway Route Table**\.

1. \(Optional\) For **Name tag**, type a name for the transit gateway route table\. This creates a tag with the tag key "Name", where the tag value is the name that you specify\.

1. For **Transit Gateway ID**, select the transit gateway for the route table\.

1. Choose **Create Transit Gateway Route Table**\.

**To create a transit gateway route table using the AWS CLI**  
Use the [create\-transit\-gateway\-route\-table](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-transit-gateway-route-table.html) command\.

## Associate a transit gateway route table<a name="associate-tgw-route-table"></a>

You can associate a transit gateway route table with a transit gateway attachment\.

**To associate a transit gateway route table using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table\.

1. In the lower part of the page, choose the **Associations** tab\.

1. Choose **Create association**\.

1. Choose the attachment to associate and then choose **Create association**\.

**To associate a transit gateway route table using the AWS CLI**  
Use the [associate\-transit\-gateway\-route\-table](https://docs.aws.amazon.com/cli/latest/reference/ec2/associate-transit-gateway-route-table.html) command\.

## Delete an association for a transit gateway route table<a name="disassociate-tgw-route-table"></a>

You can disassociate a transit gateway route table from a transit gateway attachment\.

**To disassociate a transit gateway route table using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table\.

1. In the lower part of the page, choose the **Associations** tab\.

1. Choose the attachment to disassociate and then choose **Delete association**\.

1. When prompted for confirmation, choose **Delete association**\.

**To disassociate a transit gateway route table using the AWS CLI**  
Use the [disassociate\-transit\-gateway\-route\-table](https://docs.aws.amazon.com/cli/latest/reference/ec2/disassociate-transit-gateway-route-table.html) command\.

## View transit gateway route tables<a name="view-tgw-route-tables"></a>

**To view transit gateway route tables using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. To find a specific route table or set of tables, enter all or part of the name, keyword, or attribute in the filter field\.

Choose a route table to display the settings for it\.

**To view transit gateway route tables using the AWS CLI**  
Use the [describe\-transit\-gateway\-route\-tables](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-transit-gateway-route-tables.html) command\.

## Propagate a route to a transit gateway route table<a name="enable-tgw-route-propagation"></a>

Use route propagation to add a route from a route table to an attachment\.

**To propagate a route to a transit gateway attachment route table**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table for which to create a propagation\.

1. Choose **Actions**, **Create propagation**\.

1. On the **Create propagation** page, choose the attachment\.

1. Choose **Create propagation**\.

1. Choose **Close**\.

**To enable route propagation using the AWS CLI**  
Use the [enable\-transit\-gateway\-route\-table\-propagation](https://docs.aws.amazon.com/cli/latest/reference/ec2/enable-transit-gateway-route-table-propagation.html) command\.

## Disable route propagation<a name="disable-tgw-route-propagation"></a>

Remove a propagated route from a route table attachment\.

**To disable route propagation using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table to delete the propagation from\.

1. On the lower part of the page, choose the **Propagations** tab\.

1. Select the attachment and then choose **Delete propagation**\.

1. When prompted for confirmation, choose **Delete propagation**\.

**To disable route propagation using the AWS CLI**  
Use the [disable\-transit\-gateway\-route\-table\-propagation](https://docs.aws.amazon.com/cli/latest/reference/ec2/disable-transit-gateway-route-table-propagation.html) command\.

## View route table propagations<a name="view-tgw-route-propagations"></a>

**To view route propagations using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table to view propagations for\.

1. On the lower part of the page, choose the **Propagations** tab\.

**To view route propagations using the AWS CLI**  
Use the [get\-transit\-gateway\-route\-table\-propagations](https://docs.aws.amazon.com/cli/latest/reference/ec2/get-transit-gateway-route-table-propagations.html) command\.

## Create a static route<a name="tgw-create-static-route"></a>

You can create a static route for a VPC, VPN, or transit gateway peering attachment, or you can create a blackhole route that drops traffic that matches the route\.

**To create a static route using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table for which to create a route\.

1. Choose **Actions**, **Create route**\.

1. On the **Create route** page, enter the CIDR block for which to create the route\.

1. Choose the attachment for the route\.

1. Choose **Create route**\.

**To create a blackhole route using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table for which to create a route\.

1. Choose **Actions**, **Create route**\.

1. On the **Create route** page, enter the CIDR block for which to create the route, and then choose **Blackhole**\.

1. Choose **Create route**\.

**To create a static route or blackhole route using the AWS CLI**  
Use the [create\-transit\-gateway\-route](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-transit-gateway-route.html) command\.

## Delete a static route<a name="tgw-delete-static-route"></a>

You can create a static route for an attached VPC or VPN connection, or you can create a blackhole route that drops traffic that matches the route\.

**To delete a static route using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table for which to delete the route, and choose **Routes**\.

1. Choose the route to delete\.

1. Choose **Delete route**\.

1. In the confirmation box, choose **Delete route**\.

**To delete a static route using the AWS CLI**  
Use the [delete\-transit\-gateway\-route](https://docs.aws.amazon.com/cli/latest/reference/ec2/delete-transit-gateway-route.html) command\.

## Export route tables to Amazon S3<a name="tgw-export-route-tables"></a>

You can export the routes in your transit gateway route tables to an Amazon S3 bucket\. The routes are saved to the specified Amazon S3 bucket in a JSON file\.

**To export transit gateway route tables using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Choose the route table that includes the routes to export\.

1. Choose **Actions**, **Export routes**\.

1. On the **Export routes** page, for **S3 bucket name**, type the name of the S3 bucket\.

1. To filter the routes exported, specify filter parameters in the **Filters** section of the page\.

1. Choose **Export routes**\.

To access the exported routes, open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/), and navigate to the bucket that you specified\. The file name includes the AWS account ID, AWS Region, route table ID, and a timestamp\. Select the file and choose **Download**\. The following is an example of a JSON file that contains information about two propagated routes for VPC attachments\.

```
{
  "filter": [
    {
      "name": "route-search.subnet-of-match",
      "values": [
        "0.0.0.0/0",
        "::/0"
      ]
    }
  ],
  "routes": [
    {
      "destinationCidrBlock": "10.0.0.0/16",
      "transitGatewayAttachments": [
        {
          "resourceId": "vpc-0123456abcd123456",
          "transitGatewayAttachmentId": "tgw-attach-1122334455aabbcc1",
          "resourceType": "vpc"
        }
      ],
      "type": "propagated",
      "state": "active"
    },
    {
      "destinationCidrBlock": "10.2.0.0/16",
      "transitGatewayAttachments": [
        {
          "resourceId": "vpc-abcabc123123abca",
          "transitGatewayAttachmentId": "tgw-attach-6677889900aabbcc7",
          "resourceType": "vpc"
        }
      ],
      "type": "propagated",
      "state": "active"
    }
  ]
}
```

## Delete a transit gateway route table<a name="delete-tgw-route-table"></a>

**To delete a transit gateway route table using the console**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. On the navigation pane, choose **Transit Gateway Route Tables**\.

1. Select the route table to delete\.

1. Choose **Actions**, **Delete route table**\.

1. Choose **Delete** again to confirm the deletion\.

**To delete a transit gateway route table using the AWS CLI**  
Use the [delete\-transit\-gateway\-route\-table](https://docs.aws.amazon.com/cli/latest/reference/ec2/delete-transit-gateway-route-table.html) command\.