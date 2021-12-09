# Adding AWS Marketplace Products to Your Portfolio<a name="catalogs_marketplace-products"></a>

You can add AWS Marketplace products to your portfolios to make those products available to your AWS Service Catalog end users\.

AWS Marketplace is an online store in which you can find, subscribe to, and immediately start using a large selection of software and services\. The types of products in AWS Marketplace include databases, application servers, testing tools, monitoring tools, content management tools, and business intelligence software\. AWS Marketplace is available at [https://aws.amazon.com/marketplace](https://aws.amazon.com/marketplace)\.

You distribute an AWS Marketplace product to AWS Service Catalog end users by defining the product in an AWS CloudFormation template and adding the template to a portfolio\. Any end user who has access to the portfolio will be able to launch the product from the console\.

AWS Marketplace supports AWS Service Catalog directly or subscribe and add products using the manual option\. We recommend adding products using the functionality specifically designed for AWS Service Catalog\. 

## Managing AWS Marketplace Products Using AWS Service Catalog<a name="catalogs_marketplace-sc"></a>

You can add your subscribed AWS Marketplace products directly to AWS Service Catalog using a custom interface\. In [AWS Marketplace](https://aws.amazon.com/marketplace), choose **Service Catalog**\. For more information, see [Copying Products to AWS Service Catalog](https://aws.amazon.com/marketplace/help/buyer-copy-product-to-SC?ref=help_ln_sibling) in the *AWS Marketplace Help and FAQ*\.

## Managing and Adding AWS Marketplace Products Manually<a name="catalogs_marketplace-manual"></a>

Complete the following steps to subscribe to an AWS Marketplace product, define that product in an AWS CloudFormation template, and add the template to an AWS Service Catalog portfolio\.

**To subscribe to an AWS Marketplace product**

1. Go to AWS Marketplace at [https://aws.amazon.com/marketplace](https://aws.amazon.com/marketplace)\.

1. Browse the products or search to find the product that you want to add to your AWS Service Catalog portfolio\. Choose the product to view the product details page\.

1. Choose **Continue** to view the fulfillment page, and then choose the **Manual Launch** tab\.

   The information on the fulfillment page includes the supported Amazon Elastic Compute Cloud \(Amazon EC2\) instance types, the supported AWS regions, and the Amazon Machine Image \(AMI\) ID that the product uses for each AWS region\. Note that some choices will affect cost\. You will use this information to customize the AWS CloudFormation template in later steps\.

1. Choose **Accept Terms** to subscribe to the product\.

   After you subscribe to a product, you can access the information on the product fulfillment page in AWS Marketplace at any time by choosing **Your Software**, and then choosing the product\.

**To define your AWS Marketplace product in an AWS CloudFormation template**

To complete the following steps, you will use one of the AWS CloudFormation sample templates as a starting point, and you will customize the template so that it represents your AWS Marketplace product\. To access the sample templates, see [Sample Templates](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/cfn-sample-templates.html) in the *AWS CloudFormation User Guide*\.

1. On the Sample Templates page in the* AWS CloudFormation User Guide*, choose a region that your product will be used in\. The region must be supported by your AWS Marketplace product\. You can view the supported regions on the product fulfillment page in AWS Marketplace\.

1. To view a list of service sample templates that are appropriate for the region, choose the **Services** link\. 

1. You can use any of the samples that are appropriate for your needs as a starting point\. The steps in this procedure use the **Amazon EC2 instance in a security group** template\. To view the sample template, choose **View** , and then save a copy of the template locally so that you can edit it\. Your local file must have the `.template` extension\.

1. Open your template file in a text editor\.

1. Customize the description at the top of the template\. Your description might look like the following example:

   `"Description": "Launches a LAMP stack from AWS Marketplace",`

1. Customize the `InstanceType` parameter so that it includes only EC2 instance types that are supported by your product\. If your template includes unsupported EC2 instance types, the product will fail to launch for your end users\.

   1. On the product fulfillment page in AWS Marketplace, view the supported EC2 instance types in the **Pricing Details** section, as in the following example:  
![\[The pricing details section on the product fulfillment page in AWS Marketplace shows the supported EC2 instance types.\]](http://docs.aws.amazon.com/servicecatalog/latest/adminguide/images/sc-marketplace_instance_types-console.png)

   1. In your template, change the default instance type to a supported EC2 instance type of your choice\.

   1. Edit the `AllowedValues` list so that it includes only EC2 instance types that are supported by your product\.

   1. Remove any EC2 instance types that you do not want your end users to use when they launch the product from the `AllowedValues`list \.

   When you are done editing the `InstanceType` parameter, it might look similar to the following example:

   ```
       "InstanceType" : {
         "Description" : "EC2 instance type",
         "Type" : "String",
         "Default" : "m1.small",
         "AllowedValues" : [ "t1.micro", "m1.small", "m1.medium", "m1.large", "m1.xlarge", "m2.xlarge", "m2.2xlarge", "m2.4xlarge", "c1.medium", "c1.xlarge", "c3.large", "c3.large", "c3.xlarge", "c3.xlarge", "c3.4xlarge", "c3.8xlarge" ],
         "ConstraintDescription" : "Must be a valid EC2 instance type."
       },
   ```

1. In the `Mappings` section of your template, edit the `AWSInstanceType2Arch` mappings so that only supported EC2 instance types and architectures are included\.

   1. Edit the list of mappings by removing all EC2 instance types that are not included in the `AllowedValues` list for the `InstanceType` parameter\.

   1. Edit the `Arch` value for each EC2 instance type to be the architecture type that is supported by your product\. Valid values are `PV64`, `HVM64`, and `HVMG2`\. To learn which architecture your product supports, refer to the product details page in AWS Marketplace\. To learn which architectures are supported by EC2 instance families, see [Amazon Linux AMI Instance Type Matrix](https://aws.amazon.com/amazon-linux-ami/instance-type-matrix/)\.

   When you have finished editing the `AWSInstanceType2Arch` mappings, it might look similar to the following example:

   ```
       "AWSInstanceType2Arch" : {
         "t1.micro"    : { "Arch" : "PV64"  },
         "m1.small"    : { "Arch" : "PV64"  },
         "m1.medium"   : { "Arch" : "PV64"  },
         "m1.large"    : { "Arch" : "PV64"  },
         "m1.xlarge"   : { "Arch" : "PV64"  },
         "m2.xlarge"   : { "Arch" : "PV64"  },
         "m2.2xlarge"  : { "Arch" : "PV64"  },
         "m2.4xlarge"  : { "Arch" : "PV64"  },
         "c1.medium"   : { "Arch" : "PV64"  },
         "c1.xlarge"   : { "Arch" : "PV64"  },
         "c3.large"    : { "Arch" : "PV64"  },
         "c3.xlarge"   : { "Arch" : "PV64"  },
         "c3.2xlarge"  : { "Arch" : "PV64"  },
         "c3.4xlarge"  : { "Arch" : "PV64"  },
         "c3.8xlarge"  : { "Arch" : "PV64"  }
       }
   ,
   ```

1. In the `Mappings` section of your template, edit the `AWSRegionArch2AMI` mappings to associate each AWS region with the corresponding architecture and AMI ID for your product\.

   1. On the product fulfillment page in AWS Marketplace, view the AMI ID that your product uses for each AWS region, as in the following example:  
![\[A table of regions and AMI IDs on the product fulfillment page in AWS Marketplace.\]](http://docs.aws.amazon.com/servicecatalog/latest/adminguide/images/sc-marketplace_ami_ids-console.png)

   1. In your template, remove the mappings for any regions that you do not support\.

   1. Edit the mapping for each region to remove the unsupported architectures \(`PV64`, `HVM64`, or `HVMG2`\) and their associated AMI IDs\.

   1. For each remaining region and architecture mapping, specify the corresponding AMI ID from the product details page in AWS Marketplace\.

   When you have finished editing the `AWSRegionArch2AMI` mappings, your code might look similar to the following example:

   ```
       "AWSRegionArch2AMI" : {
         "us-east-1"        : {"PV64" : "ami-nnnnnnnn"},
         "us-west-2"        : {"PV64" : "ami-nnnnnnnn"},
         "us-west-1"        : {"PV64" : "ami-nnnnnnnn"},
         "eu-west-1"        : {"PV64" : "ami-nnnnnnnn"},
         "eu-central-1"     : {"PV64" : "ami-nnnnnnnn"},
         "ap-northeast-1"   : {"PV64" : "ami-nnnnnnnn"},
         "ap-southeast-1"   : {"PV64" : "ami-nnnnnnnn"},
         "ap-southeast-2"   : {"PV64" : "ami-nnnnnnnn"},
         "sa-east-1"        : {"PV64" : "ami-nnnnnnnn"}
       }
   ```

   You can now use the template to add the product to an AWS Service Catalog portfolio\. If you want to make additional changes, see [Working with AWS CloudFormation Templates](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-guide.html) to learn more about templates\. 

**To add your AWS Marketplace product to an AWS Service Catalog portfolio**

1. Sign in to the AWS Management Console and navigate to the AWS Service Catalog administrator console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. On the **Portfolios** page, choose the portfolio that you want to add your AWS Marketplace product to\.

1. On the portfolio details page, choose **Upload new product**\.

1. Type the requested product and support details\.

1. On the **Version details** page, choose **Upload a template file**, choose **Browse**, and then choose your template file\.

1. Type a version title and description\.

1. Choose **Next**\.

1. On the **Review** page, verify that the summary is accurate, and then choose **Confirm and upload**\. The product is added your portfolio\. It is now available to end users who have access to the portfolio\.