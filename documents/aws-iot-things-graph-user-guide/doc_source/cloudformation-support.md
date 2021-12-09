--------

--------

# AWS CloudFormation Support for AWS IoT Things Graph<a name="cloudformation-support"></a>

AWS CloudFormation is a service that can help you create, manage, and replicate your AWS resources\. You can use AWS CloudFormation templates to define AWS IoT Things Graph flows \(workflows\) that you want to deploy\.

The resources and infrastructure that you generate from a template is called a *stack*\. You can define all of your resources in one template or refer to resources from other stacks\. For more information about AWS CloudFormation templates and features, see [What Is AWS CloudFormation?](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/Welcome.html) in the *AWS CloudFormation User Guide*\.

## Creating Resources<a name="cloudformation-support-create"></a>

AWS CloudFormation templates are JSON or YAML documents that describe the properties and relationships of AWS resources\. 

The following AWS IoT Things Graph resources are supported:
+ [Flows \(workflows\)](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-iotthingsgraph-flowtemplate.html)

In AWS CloudFormation templates, the structure and syntax of AWS IoT Things Graph resources are based on the AWS IoT Things Graph API\. For example, you [create a flow](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateFlowTemplate.html) by assigning values to the `definition` and `compatibleNamespaceVersion` parameters\. For more information, see [AWS IoT Things Graph API Reference](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/)\.