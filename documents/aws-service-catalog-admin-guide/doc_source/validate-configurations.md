# Validating Configurations<a name="validate-configurations"></a>

 You are now ready to validate the AWS Service Catalog Connector for ServiceNow installation procedures\. 

**To validate the configuration of the Connector**

1.  Log into your ServiceNow instance as the end user \(for example, Abel Tuter\)\. 

1.  Type **Service Catalog** in the navigation filter and choose **Service Catalog**\. 

1.  The user interface view displays the AWS Service Catalog category\. 

**To order a product**

1.  Select the **AWS Service Catalog S3 Storage** product to provision\. 

1.  Fill in the product request details including product name, parameters, and tags\. 

1.  Choose **Order Now** to submit the ServiceNow request and provision the AWS Service Catalog product\. 

1. After approximately one minute, you receive an order status indicating that your request was submitted\.

**To view provisioned products**

End users can view products in two places on the ServiceNow portal through request items \(Requests\) or My AWS Products widgets\.

**To view products in Service Portal Requests**

1. Choose **Requests** in the home page navigation bar\.

1. Select the request item of your choice \(contains the AWS Service Catalog product and request item number\)\.
**Note**  
The request item is updated with AWS product events and outputs\. When the AWS product is terminated, the ServiceNow request item will go into a state of **Closed Complete**\.

**To view products in the My AWS Products widget Service Portal Requests**

1. Go to the My AWS Products widget

1. Choose the AWS Select Product name that you entered into the request form\.

1. View the **Status and Product Events**

1. If you want to perform post\-provisioned operational actions, choose **Request Update**, **Request Self\-Service Action**, or **Terminate**\.