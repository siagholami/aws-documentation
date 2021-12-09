# What Is AWS Service Catalog?<a name="introduction"></a>

AWS Service Catalog enables organizations to create and manage catalogs of IT services that are approved for use on AWS\. These IT services can include everything from virtual machine images, servers, software, and databases to complete multi\-tier application architectures\. AWS Service Catalog allows organizations to centrally manage commonly deployed IT services, and helps organizations achieve consistent governance and meet compliance requirements\. End users can quickly deploy only the approved IT services they need, following the constraints set by your organization\.

AWS Service Catalog provides the following benefits:
+ ****Standardization****

  Administer and manage approved assets by restricting where the product can be launched, the type of instance that can be used, and many other configuration options\. The result is a standardized landscape for product provisioning for your entire organization\.
+ ****Self\-service discovery and launch****

  Users browse listings of products \(services or applications\) that they have access to, locate the product that they want to use, and launch it all on their own as a provisioned product\.
+ **Fine\-grain access control**

  Administrators assemble portfolios of products from their catalog, add constraints and resource tags to be used at provisioning, and then grant access to the portfolio through AWS Identity and Access Management \(IAM\) users and groups\. 
+ **Extensibility and version control**

  Administrators can add a product to any number of portfolios and restrict it without creating another copy\. Updating the product to a new version propagates the update to all products in every portfolio that references it\. 

For more information, see the [AWS Service Catalog detail page](http://aws.amazon.com/servicecatalog/details)\. 

The AWS Service Catalog API provides programmatic control over all end\-user actions as an alternative to using the AWS Management Console\. For more information, see [AWS Service Catalog Developer Guide](https://docs.aws.amazon.com/servicecatalog/latest/dg/)\.