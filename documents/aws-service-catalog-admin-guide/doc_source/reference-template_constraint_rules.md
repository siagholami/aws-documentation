# Template Constraint Rules<a name="reference-template_constraint_rules"></a>

The rules that define template constraints in an AWS Service Catalog portfolio describe when end users can use the template and which values they can specify for parameters that are declared in the AWS CloudFormation template used to create the product they are attempting to use\. Rules are useful for preventing end users from inadvertently specifying an incorrect value\. For example, you can add a rule to verify whether end users specified a valid subnet in a given VPC or used `m1.small` instance types for test environments\. AWS CloudFormation uses rules to validate parameter values before it creates the resources for the product\.

Each rule consists of two properties: a rule condition \(optional\) and assertions \(required\)\. The rule condition determines when a rule takes effect\. The assertions describe what values users can specify for a particular parameter\. If you don't define a rule condition, the rule's assertions always take effect\. To define a rule condition and assertions, you use *rule\-specific intrinsic functions*, which are functions that can only be used in the `Rules` section of a template\. You can nest functions, but the final result of a rule condition or assertion must be either true or false\.

As an example, assume that you declared a VPC and a subnet parameter in the `Parameters` section\. You can create a rule that validates that a given subnet is in a particular VPC\. So when a user specifies a VPC, AWS CloudFormation evaluates the assertion to check whether the subnet parameter value is in that VPC before creating or updating the stack\. If the parameter value is invalid, AWS CloudFormation immediately fail to create or update the stack\. If users don't specify a VPC, AWS CloudFormation doesn't check the subnet parameter value\.

## Syntax<a name="template-constraint-rules-syntax"></a>

The `Rules` section of a template consists of the key name `Rules`, followed by a single colon\. Braces enclose all rule declarations\. If you declare multiple rules, they are delimited by commas\. For each rule, you declare a logical name in quotation marks followed by a colon and braces that enclose the rule condition and assertions\.

A rule can include a `RuleCondition` property and must include an `Assertions` property\. For each rule, you can define only one rule condition; you can define one or more asserts within the `Assertions` property\. You define a rule condition and assertions by using rule\-specific intrinsic functions, as shown in the following pseudo template:

```
"Rules" : {
  "Rule01" : {
    "RuleCondition" : { Rule-specific intrinsic function },
    "Assertions" : [
      {
        "Assert" : { Rule-specific intrinsic function },
        "AssertDescription" : "Information about this assert"
      },
      {
        "Assert" : { Rule-specific intrinsic function },
        "AssertDescription" : "Information about this assert"
      }
    ]
  },
  "Rule02" : {
    "Assertions" : [
      {
        "Assert" : { Rule-specific intrinsic function },
        "AssertDescription" : "Information about this assert"
      }
    ]
  }
}
```

The pseudo template shows a `Rules` section containing two rules named `Rule01` and `Rule02`\. `Rule01` includes a rule condition and two assertions\. If the function in the rule condition evaluates to true, both functions in each assert are evaluated and applied\. If the rule condition is false, the rule doesn't take effect\. `Rule02` always takes effect because it doesn't have a rule condition, which means the one assert is always evaluated and applied\.

You can use the following rule\-specific intrinsic functions to define rule conditions and assertions:
+ `Fn::And`
+ `Fn::Contains`
+ `Fn::EachMemberEquals`
+ `Fn::EachMemberIn`
+ `Fn::Equals`
+ `Fn::If`
+ `Fn::Not`
+ `Fn::Or`
+ `Fn::RefAll`
+ `Fn::ValueOf`
+ `Fn::ValueOfAll`

## Example: Conditionally Verify a Parameter Value<a name="template-constraint-rules-example"></a>

The following two rules check the value of the `InstanceType` parameter\. Depending on the value of the Environment parameter \(`test` or `prod`\), the user must specify `m1.small` or `m1.large` for the `InstanceType` parameter\. The `InstanceType` and `Environment` parameters must be declared in the `Parameters` section of the same template\.

```
"Rules" : {
  "testInstanceType" : {
    "RuleCondition" : {"Fn::Equals":[{"Ref":"Environment"}, "test"]},
    "Assertions" : [
      {
        "Assert" :  { "Fn::Contains" : [ ["m1.small"], {"Ref" : "InstanceType"} ] },
        "AssertDescription" : "For the test environment, the instance type must be m1.small"
      }
    ]
  },
  "prodInstanceType" : {
    "RuleCondition" : {"Fn::Equals":[{"Ref":"Environment"}, "prod"]},
    "Assertions" : [
      {
        "Assert" :  { "Fn::Contains" : [ ["m1.large"], {"Ref" : "InstanceType"} ] },
        "AssertDescription" : "For the prod environment, the instance type must be m1.large"
      }
    ]
  }
}
```