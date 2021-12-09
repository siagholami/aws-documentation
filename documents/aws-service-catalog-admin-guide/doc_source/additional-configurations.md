# ServiceNow Additional Administrator Features<a name="additional-configurations"></a>

 This section provides information about additional administrator features for the AWS Service Catalog Connector for ServiceNow\. 

## Deleting AWS Service Catalog Products<a name="deleting-products"></a>

 The Connector for ServiceNow enables ServiceNow administrators with **x\_126749\_aws\_sc\_account\_admin** permission the ability to delete AWS Service Catalog products that do not have self\-service actions associated\. 

**Note**  
You must disassociate self\-service actions from AWS Service Catalog products within the AWS Management Console before managing products with the ServiceNow platform\. 

**To delete AWS Service Catalog products**

1. In the Connector, go to **AWS Service Catalog \- Products**\. Choose the AWS Service Catalog product to delete\.

1. Choose **Manage Product**\.

1. Choose **Delete Product**\. 

1. A warning appears\. Choose **OK**\.

1. After the deletion is complete, a message appears telling you the product has been deleted\.

## Ordering AWS Service Catalog Products Through the ServiceNow Service Portal<a name="service-portal"></a>

 The Connector for ServiceNow version 1\.6\.7 and above supports ordering AWS Service Catalog products through Service Portal by using the Service Catalog and Order Something views\. The release also includes pages and widgets that you can add to Service Portal that enable users to view their provisioned products\. 

**Note**  
The audience for the Service Portal Features section is a ServiceNow administrator or equivalent\. The ServiceNow user requires permissions to modify the Service Portal\.

### Service Portal Widgets<a name="service-portal-widgets"></a>

 The Connector for ServiceNow includes widgets that you can add to your Service Portal\. It also includes two alternative view Portal Pages for the following: 
+ **My AWS Products** – Provides an overview of all provisioned products owned by the user\.
+ **AWS Product Details** – Provides details of a single provisioned product\.

 To access the new widgets, you need to update the Service Portal Designer\.

**To update the Service Portal Designer**

1. Go to [Create and edit a page using the Service Portal Designer](https://docs.servicenow.com/bundle/kingston-servicenow-platform/page/build/service-portal/task/t_ConfigureAPage.html)\.

1.  Following the instructions, choose the **Service Portal Index** page\. 

1.  Under the **Order Something** container, add the **My AWS Products** widget\. 

1. The new widget appears on your main Service Portal view\.

### Service Portal Pages<a name="service-portal-pages"></a>

 The following section describes the two new pages available in the Service Portal Beta release of the AWS Service Catalog Connector, **My AWS Products** and **AWS Product Details**\. You can add links to these pages on the Service Portal home page or other pages by using the usual page configuration mechanism in Service Portal\. 

**My AWS Products**  
Provides an overview of all provisioned products owned by the user\. Terminated products are displayed separately from current products in a panel that is collapsed on initial page load\. 

 The **My AWS Products** page is available using the following format:

```
http://<insertinstancename>.service-now.com/sp?id=aws_sc_pp
```

**AWS Product Details**  
Provides details of a single provisioned product\.

 The **AWS Product Details** page is available using the following format:

```
http://<insertinstancename>.service-now.com/sp?id=aws_sc_pp_details&sys_id=<provisioned product id>
```