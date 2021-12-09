# Shareable Resources<a name="shareable"></a>

AWS RAM lets you share resources that are provisioned and managed in other AWS services\. AWS RAM does not let you manage resources, but it does provide the features that let you make resources available across AWS accounts\.

The following sections list the services that integrate with AWS RAM, and the resources that support sharing\.

**Topics**
+ [Amazon Aurora](#shareable-aur)
+ [AWS CodeBuild](#shareable-codebuild)
+ [Amazon EC2](#shareable-ec2)
+ [Amazon EC2 Image Builder](#shareable-imagebuilder)
+ [AWS License Manager](#shareable-byol)
+ [AWS Resource Groups](#shareable-arg)
+ [Amazon Route 53](#shareable-r53)

## Amazon Aurora<a name="shareable-aur"></a>

You can share the following Amazon Aurora resources using AWS RAM\.


| Resource | Use case | 
| --- | --- | 
|  DB clusters  |  Create and manage a DB cluster centrally, and share it with other AWS accounts\. This lets multiple AWS accounts clone a shared, centrally\-managed DB cluster\. For more information, see [ Cross\-Account Aurora DB Cluster Cloning](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/Aurora.Managing.Clone.html#Aurora.Managing.Clone.Cross-Account) in the *Amazon Aurora User Guide*\.  | 

## AWS CodeBuild<a name="shareable-codebuild"></a>

You can share the following AWS CodeBuild resources using AWS RAM\.


| Resource | Use case | 
| --- | --- | 
|  Projects  |  Create a project and use it to run builds\. Share the project with other AWS accounts or users\. This lets multiple AWS accounts and users view information about a project and analyze its builds\. For more information, see [Working with Shared Projects](https://docs.aws.amazon.com/codebuild/latest/userguide/project-sharing.html) in the * AWS CodeBuild User Guide*\.  | 
|  Report groups  |  Create a report group and use it to create reports when you build a project\. Share the report group with other AWS accounts or users\. This lets multiple AWS accounts and users view the report group and its reports, and the test case results for each report\. A report can be viewed for 30 days after it is created, and then it expires and is no longer available to view\. For more information, see [Working with Shared Report Groups](https://docs.aws.amazon.com/codebuild/latest/userguide/project-sharing.html) in the *AWS CodeBuild User Guide*\.  | 

## Amazon EC2<a name="shareable-ec2"></a>

You can share the following Amazon EC2 resources using AWS RAM\.


| Resource | Use case | 
| --- | --- | 
|  Capacity Reservations  |  Create and manage Capacity Reservations centrally, and share the reserved capacity with other AWS accounts\. This lets multiple AWS accounts launch their Amazon EC2 instances into centrally\-managed reserved capacity\. For more information, see [Working with Shared Capacity Reservations](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/capacity-reservation-sharing.html) in the *Amazon EC2 User Guide for Linux Instances*\.  | 
|  Dedicated Hosts  |  Allocate and manage Amazon EC2 Dedicated Hosts centrally, and share the host's instance capacity with other AWS accounts\. This lets multiple AWS accounts launch their Amazon EC2 instances onto centrally\-managed Dedicated Hosts\. For more information, see [ Working with Shared Dedicated Hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dh-sharing.html) in the *Amazon EC2 User Guide for Linux Instances*\.  | 
|  Subnets  |  Create and manage subnets centrally, and share them with other accounts or organizational units that are in the same organization from AWS Organizations\. This lets multiple AWS accounts launch their application resources into centrally\-managed VPCs\. These resources include Amazon EC2 instances, Amazon Relational Database Service \(RDS\) databases, Amazon Redshift clusters, and AWS Lambda functions\. For more information, see [ Working with VPC Sharing](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-sharing.html) in the *Amazon VPC User Guide*\.  | 
|  Traffic mirror targets  |  Create and manage traffic mirror targets centrally, and share them with other AWS accounts\. This lets multiple AWS accounts send mirrored network traffic from traffic mirror sources in their accounts to a shared, centrally\-managed traffic mirror target\. For more information, see [ Cross\-Account Traffic Mirroring Targets](https://docs.aws.amazon.com/vpc/latest/mirroring/cross-account-traffic-mirroring-targets.html) in the *Traffic Mirroring Guide*\.  | 
|  Transit gateways  |  Create and manage transit gateways centrally, and share them with other AWS accounts\. This lets multiple AWS accounts route traffic between their VPCs and on\-premises networks through a shared, centrally\-managed transit gateway\. For more information, see [Sharing a Transit Gateway](https://docs.aws.amazon.com/vpc/latest/tgw/tgw-transit-gateways.html#tgw-sharing) in the *Transit Gateways Guide*\.  | 

## Amazon EC2 Image Builder<a name="shareable-imagebuilder"></a>

You can share the following Amazon EC2 Image Builder resources using AWS RAM\.


| Resource | Use case | 
| --- | --- | 
|  Components  |  Create and manage components centrally, and share them with other AWS accounts or your organization\. Manage who can use predefined build and test components in their image recipes\. For more information, see [ Resource Sharing in EC2 Image Builder](https://docs.aws.amazon.com/imagebuilder/latest/userguide/image-builder-resource-sharing.html) in the *EC2 Image Builder User Guide*\.  | 
|  Images  |  Create and manage your golden images centrally, and share them with other AWS accounts and your organization\. Manage who can use images created with EC2 Image Builder across your organization\.\. For more information, see [ Resource Sharing in EC2 Image Builder](https://docs.aws.amazon.com/imagebuilder/latest/userguide/image-builder-resource-sharing.html) in the *EC2 Image Builder User Guide*\.  | 
|  Image recipes  |  Create and manage your image recipes centrally, and share them with other AWS accounts and your organization\. This allows you to manage who can use predefined documents to automate repeatable image pipelines for a desired configuration\. For more information, see [ Resource Sharing in EC2 Image Builder](https://docs.aws.amazon.com/imagebuilder/latest/userguide/image-builder-resource-sharing.html) in the *EC2 Image Builder User Guide*\.  | 

## AWS License Manager<a name="shareable-byol"></a>

You can share the following AWS License Manager resources using AWS RAM\.


| Resource | Use case | 
| --- | --- | 
|  License configurations  |  Create and manage license configurations centrally, and share them with other AWS accounts\. This lets you enforce centrally\-managed licensing rules that are based on the terms of your enterprise agreements across multiple AWS accounts\. For more information, see [Using License Configurations](https://docs.aws.amazon.com/license-manager/latest/userguide/license-configurations.html) in the *AWS License Manager User Guide*\.  | 

## AWS Resource Groups<a name="shareable-arg"></a>

You can share the following AWS Resource Groups resources using AWS RAM\.


| Resource | Use case | 
| --- | --- | 
|  Resource groups  |  Create and manage a host resource group centrally, and share it with other AWS accounts\. This lets multiple AWS accounts share a group of Amazon EC2 Dedicated Hosts created using AWS License Manager\. For more information, see [ Host Resource Groups in AWS License Manager](https://docs.aws.amazon.com/license-manager/latest/userguide/host-resource-groups.html) in the *AWS License Manager User Guide*\.   | 

## Amazon Route 53<a name="shareable-r53"></a>

You can share the following Amazon Route 53 resources using AWS RAM\.


| Resource | Use case | 
| --- | --- | 
|  Forwarding rules  |  Create and manage forwarding rules centrally, and share them with other AWS accounts\. This lets multiple AWS accounts forward DNS queries from their VPCs to the target IP addresses defined in shared, centrally\-managed resolver rules\. For more information, see [ Sharing Forwarding Rules with Other AWS Accounts and Using Shared Rules](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/resolver-rules-managing.html#resolver-rules-managing-sharing) in the *Amazon Route 53 Developer Guide*\.  | 