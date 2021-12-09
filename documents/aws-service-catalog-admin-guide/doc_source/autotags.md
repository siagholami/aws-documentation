# AWS Service Catalog AutoTags<a name="autotags"></a>

 AutoTags are tags that identify information about the origin of a provisioned resource in AWS Service Catalog and are automatically applied by AWS Service Catalog to provisioned resources\. 

 AutoTags include tags for the unique identifiers for portfolio, product, user, product version, and provisioned product\. This provides a set of tags that reflect the AWS Service Catalog structure that customers have configured in the catalog\. AutoTags do not count against the customer's 50\-tag limit\. 

 AWS Service Catalog AutoTags can help provide consistent tagging for your resources, which is useful when setting budgets for a portfolio, product, or user\. You can also use the AutoTags to identify resources for post\-launch operations such as setting AWS Config rules\. AutoTags for your provisioned resources can be viewed in the Tags section of the downstream services used for provisioning, such as AWS CloudFormation, Amazon EC2, and Amazon S3\. 

**AutoTag details**
+ **aws:servicecatalog:portfolioArn** \- The ARN of the portfolio from which the provisioned product was launched\.
+ **aws:servicecatalog:productArn** \- The ARN of the product from which the provisioned product was launched\.
+ **aws:servicecatalog:provisioningPrincipalArn** \- The ARN of the provisioning principal \(user\) who created the provisioned product\.
+ **aws:servicecatalog:provisionedProductArn** \- The provisioned product ARN\.
+ **aws:servicecatalog:provisioningArtifactIdentifier** \- The ID of the original provisioning artifact \(product version\)\.

**Note**  
AWS Service Catalog recently added two new AutoTags, **aws:servicecatalog:provisionedProductArn** and **aws:servicecatalog:provisioningArtifactIdentifier**\. These new AutoTags will be automatically backfilled during updates on provisioned products\.