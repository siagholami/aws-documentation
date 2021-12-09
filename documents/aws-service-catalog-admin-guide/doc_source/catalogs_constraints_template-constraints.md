# AWS Service Catalog Template Constraints<a name="catalogs_constraints_template-constraints"></a>

To limit the options that are available to end users when they launch a product, you apply template constraints\. Apply template constraints to ensure that the end users can use products without breaching the compliance requirements of your organization\. You apply template constraints to a product in an AWS Service Catalog portfolio\. A portfolio must contain one or more products before you can define template constraints\.

A template constraint consists of one or more rules that narrow the allowable values for parameters that are defined in the product's underlying AWS CloudFormation template\. The parameters in an AWS CloudFormation template define the set of values that users can specify when creating a stack\. For example, a parameter might define the various instance types that users can choose from when launching a stack that includes EC2 instances\.

If the set of parameter values in a template is too broad for the target audience of your portfolio, you can define template constraints to limit the values that users can choose when launching a product\. For example, if the template parameters include EC2 instance types that are too large for users who should use only small instance types \(such as `t2.micro` or `t2.small`\), then you can add a template constraint to limit the instance types that end users can choose\. For more information about AWS CloudFormation template parameters, see [Parameters](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/parameters-section-structure.html) in the *AWS CloudFormation User Guide*\.

Template constraints are bound within a portfolio\. If you apply template constraints to a product in one portfolio, and if you then include the product in another portfolio, the constraints will not apply to the product in the second portfolio\.

If you apply a template constraint to a product that has already been shared with users, the constraint is active immediately for all subsequent product launches and for all versions of the product in the portfolio\.

You define template constraint rules by using a rule editor or by writing the rules as JSON text in the AWS Service Catalog administrator console\. For more information about rules, including syntax and examples, see [Template Constraint Rules](reference-template_constraint_rules.md)\.

To test a constraint prior to releasing it to users, create a test portfolio that contains the same products and test the constraints with that portfolio\.

**To apply template constraints to a product**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. On the **Portfolios** page, choose the portfolio that contains the product to which you want to apply a template constraint\. 

1. Expand the **Constraints** section and choose **Add constraints**\.

1. In the **Select product and type** window, for **Product** choose the product for which you want to define the template constraints\. Then, for **Constraint type**, choose **Template**\. Choose **Continue**\.

1. On the **Template constraint builder** page, edit the constraint rules by using the JSON editor or the rule builder interface\.
   + To edit the JSON code for the rule, choose the **Constraint Text Editor** tab\. Several samples are provided on this tab to help you get started\.

     To build the rules by using a rule builder interface, choose the **Rule Builder** tab\. On this tab, you can choose any parameter that is specified in the template for the product, and you can specify the allowable values for that parameter\. Depending on the type of parameter, you specify the allowable values by choosing items in a checklist, by specifying a number, or by specifying a set of values in a comma\-separated list\.

     When you have finished building a rule, choose **Add rule**\. The rule appears in the table on the **Rule Builder** tab\. To review and edit the JSON output, choose the **Constraint Text Editor** tab\.

1. When you are done editing the rules for your constraint, choose **Submit**\. To see the constraint, go to the portfolio details page and expand **Constraints**\.