# Step 5: Add a Template Constraint to Limit Instance Size<a name="getstarted-constraint"></a>

Constraints add another layer of control over products at the portfolio level\. Constraints can control the launch context of a product \(launch constraints\), or add rules to the AWS CloudFormation template \(template constraints\)\. For more information, see [Using AWS Service Catalog Constraints](constraints.md)\.

Now add a template constraint to the Linux Desktop product that prevents users from selecting large instance types at launch time\. The development\-environment template allows the user to select from six instance types; this constraint limits valid instance types to the two smallest types, `t2.micro` and `t2.small`\. For more information, see [T2 Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/t2-instances.html) in the *Amazon EC2 User Guide for Linux Instances*\.

**To add a template constraint to the Linux Desktop product**

1. On the portfolio details page, expand the **Constraints** section, and choose **Add constraints**\.

1. In the **Select product and type** window, for **Product**, choose **Linux Desktop**\. Then, for **Constraint type**, choose **Template**\.

1. Choose **Continue**\.

1. For **Description**, type **Small instance sizes**\.

1. Paste the following into the **Template constraint** text box:

   ```
   {
     "Rules": {
       "Rule1": {
         "Assertions": [
           {
             "Assert" : {"Fn::Contains": [["t2.micro", "t2.small"], {"Ref": "InstanceType"}]},
             "AssertDescription": "Instance type should be t2.micro or t2.small"
           }
         ]
       }
     }
   }
   ```

1.  Choose **Submit**\. 