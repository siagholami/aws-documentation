# Step 1: Download the AWS CloudFormation Template<a name="getstarted-template"></a>

To provision and configure portfolios and products, you use AWS CloudFormation templates, which are JSON– or YAML\-formatted text files\. For more information, see [Template Formats](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-formats.html) in the *AWS CloudFormation User Guide*\. These templates describe the resources that you want to provision\. You can use the AWS CloudFormation editor or any text editor to create and save templates\. For this tutorial, we've provided a simple template to get you started\. This template launches a single Linux instance configured for SSH access\.

## Template Download<a name="template-download"></a>

The sample template provided for this tutorial, `development-environment.template`, is available at [https://awsdocs\.s3\.amazonaws\.com/servicecatalog/development\-environment\.template](https://awsdocs.s3.amazonaws.com/servicecatalog/development-environment.template)\.

## Template Overview<a name="template-overview"></a>

The text of the sample template follows:

```
{
  "AWSTemplateFormatVersion" : "2010-09-09",

  "Description" : "AWS Service Catalog sample template. Creates an Amazon EC2 instance 
                    running the Amazon Linux AMI. The AMI is chosen based on the region 
                    in which the stack is run. This example creates an EC2 security 
                    group for the instance to give you SSH access. **WARNING** This 
                    template creates an Amazon EC2 instance. You will be billed for the 
                    AWS resources used if you create a stack from this template.",

  "Parameters" : {
    "KeyName": {
      "Description" : "Name of an existing EC2 key pair for SSH access to the EC2 instance.",
      "Type": "AWS::EC2::KeyPair::KeyName"
    },

    "InstanceType" : {
      "Description" : "EC2 instance type.",
      "Type" : "String",
      "Default" : "t2.micro",
      "AllowedValues" : [ "t2.micro", "t2.small", "t2.medium", "m3.medium", "m3.large", 
        "m3.xlarge", "m3.2xlarge" ]
    },

    "SSHLocation" : {
      "Description" : "The IP address range that can SSH to the EC2 instance.",
      "Type": "String",
      "MinLength": "9",
      "MaxLength": "18",
      "Default": "0.0.0.0/0",
      "AllowedPattern": "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,2})",
      "ConstraintDescription": "Must be a valid IP CIDR range of the form x.x.x.x/x."
   }
  },

  "Metadata" : {
    "AWS::CloudFormation::Interface" : {
      "ParameterGroups" : [{
        "Label" : {"default": "Instance configuration"},
        "Parameters" : ["InstanceType"]
      },{
        "Label" : {"default": "Security configuration"},
        "Parameters" : ["KeyName", "SSHLocation"]
      }],
      "ParameterLabels" : {
        "InstanceType": {"default": "Server size:"},
        "KeyName": {"default": "Key pair:"},
        "SSHLocation": {"default": "CIDR range:"}
      }
    }
  },

  "Mappings" : {
    "AWSRegionArch2AMI" : {
      "us-east-1"      : { "HVM64" : "ami-08842d60" },
      "us-west-2"      : { "HVM64" : "ami-8786c6b7" },
      "us-west-1"      : { "HVM64" : "ami-cfa8a18a" },
      "eu-west-1"      : { "HVM64" : "ami-748e2903" },
      "ap-southeast-1" : { "HVM64" : "ami-d6e1c584" },
      "ap-northeast-1" : { "HVM64" : "ami-35072834" },
      "ap-southeast-2" : { "HVM64" : "ami-fd4724c7" },
      "sa-east-1"      : { "HVM64" : "ami-956cc688" },
      "cn-north-1"     : { "HVM64" : "ami-ac57c595" },
      "eu-central-1"   : { "HVM64" : "ami-b43503a9" }
    }

  },

  "Resources" : {
    "EC2Instance" : {
      "Type" : "AWS::EC2::Instance",
      "Properties" : {
        "InstanceType" : { "Ref" : "InstanceType" },
        "SecurityGroups" : [ { "Ref" : "InstanceSecurityGroup" } ],
        "KeyName" : { "Ref" : "KeyName" },
        "ImageId" : { "Fn::FindInMap" : [ "AWSRegionArch2AMI", { "Ref" : "AWS::Region" }, "HVM64" ] }
      }
    },

    "InstanceSecurityGroup" : {
      "Type" : "AWS::EC2::SecurityGroup",
      "Properties" : {
        "GroupDescription" : "Enable SSH access via port 22",
        "SecurityGroupIngress" : [ {
          "IpProtocol" : "tcp",
          "FromPort" : "22",
          "ToPort" : "22",
          "CidrIp" : { "Ref" : "SSHLocation"}
        } ]
      }
    }
  },

  "Outputs" : {
    "PublicDNSName" : {
      "Description" : "Public DNS name of the new EC2 instance",
      "Value" : { "Fn::GetAtt" : [ "EC2Instance", "PublicDnsName" ] }
    },
    "PublicIPAddress" : {
      "Description" : "Public IP address of the new EC2 instance",
      "Value" : { "Fn::GetAtt" : [ "EC2Instance", "PublicIp" ] }
    }
  }
}
```

**Template Resources**

The template declares resources to be created when the product is launched\. It consists of the following sections:
+ **AWSTemplateFormatVersion** – The version of the [ AWS Template Format](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/format-version-structure.html) used to create this template\.
+ **Description** – A description of the template\.
+ **Parameters** – The parameters that your user must specify to launch the product\. For each parameter, the template includes a description and constraints that must be met by the value typed\. For more information about constraints, see [Using AWS Service Catalog Constraints](constraints.md)\.

  The `KeyName` parameter allows you to specify an Amazon Elastic Compute Cloud \(Amazon EC2\) key pair name that end users must provide when they use AWS Service Catalog to launch your product\. You will create the key pair in the next step\.
+ **Metadata** – An optional section that defines details about the template\. The [AWS::CloudFormation::Interface](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-cloudformation-interface.html) key defines how the end user console view displays parameters\. The `ParameterGroups` property defines how parameters are grouped and headings for those groups\. The `ParameterLabels` property defines friendly parameter names\. When a user is specifying parameters to launch a product that is based on this template, the end user console view displays the parameter labeled `Server size:` under the heading `Instance configuration`, and it displays the parameters labeled `Key pair:` and `CIDR range:` under the heading `Security configuration`\.
+ **Mappings** – A list of regions and the Amazon Machine Image \(AMI\) that corresponds to each\. AWS Service Catalog uses the mapping to determine which AMI to use based on the region that the user selects in the AWS Management Console\.
+ **Resources** – An EC2 instance running Amazon Linux and a security group that allows SSH access to the instance\. The `Properties` section of the EC2 instance resource uses the information that the user types to configure the instance type and a key name for SSH access\.

  AWS CloudFormation uses the current region to select the AMI ID from the mappings defined earlier and assigns a security group to it\. The security group is configured to allow inbound access on port 22 from the CIDR IP address range that the user specifies\.
+ **Outputs** – Text that tells the user when the product launch is complete\. The provided template gets the public DNS name of the launched instance and displays it to the user\. The user needs the DNS name to connect to the instance using SSH\.