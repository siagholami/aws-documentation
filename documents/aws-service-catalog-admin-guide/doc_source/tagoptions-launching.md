# Launching a Product with TagOptions<a name="tagoptions-launching"></a>

When a user launches a product that has TagOptions, AWS Service Catalog performs the following actions on your behalf:
+ Collects all TagOptions for the product and the launching portfolio\.
+ Ensures that only TagOptions with unique keys are used in a tag on the provisioned product\. Users get a multiple\-choice value lists for a key\. After the user chooses a value, it becomes a tag on the provisioned product\.
+ Allows users to add non\-conflicting tags to the product during provisioning\.

The following use cases demonstrate how TagOptions work during launch\.

## Example 1: A Unique TagOption Key<a name="tagoptions-ex1"></a>

An administrator creates **TagOption\[Group=Finance\]** and associates it with **Portfolio1**, which has **Product1** with no TagOptions\. When a user launches the provisioned product, the single TagOption becomes **Tag\[Group=Finance\]**, as follows:

![\[TagOptions Example 1: A Unique Key\]](http://docs.aws.amazon.com/servicecatalog/latest/adminguide/images/tagoptions-ex1.png)

## Example 2: A Set of TagOptions with the Same Key on a Portfolio<a name="tagoptions-ex2"></a>

An administrator has placed two TagOptions with the same key on a portfolio, and there are no TagOptions with the same key on any products within that portfolio\. During launch, the user must select one of the two values associated with the key\. The provisioned product is then tagged with the key and the user\-selected value\.

![\[TagOptions Example 2: Same Key on a Portfolio\]](http://docs.aws.amazon.com/servicecatalog/latest/adminguide/images/tagoptions-ex2.png)

## Example 3: A Set of TagOptions with the Same Key on Both the Portfolio and a Product in that Portfolio<a name="tagoptions-ex3"></a>

An administrator has placed several TagOptions with the same key on a portfolio, and there are also several TagOptions with the same key on the product within that portfolio\. AWS Service Catalog creates a set of values from the aggregation \(logical AND operation\) of the TagOptions\. When the user launches the product, he or she sees and selects from this set of values\. The provisioned product is tagged with the key and the user\-selected value\.

![\[TagOptions Example 3: Same Key on a Portfolio and Product in That Portfolio\]](http://docs.aws.amazon.com/servicecatalog/latest/adminguide/images/tagoptions-ex3.png)

## Example 4: Multiple TagOptions with the Same Key and Conflicting Values<a name="tagoptions-ex4"></a>

An administrator has placed several TagOptions with the same key on a portfolio, and there are also several TagOptions with the same key on the product in that portfolio\. AWS Service Catalog creates a set of values from the aggregation \(logical AND operation\) of the TagOptions\. If the aggregation doesn't find values for the key, AWS Service Catalog creates a tag with the same key and a value of `sc-tagconflict-portfolioid-productid`, where `portfolioid` and `productid` are the ARNs of the portfolio and product\. This ensures that the provisioned product is tagged with the correct key and with a value that the administrator can find and correct\.

![\[TagOptions Example 4: Same Key and Conflicting Values\]](http://docs.aws.amazon.com/servicecatalog/latest/adminguide/images/tagoptions-ex4.png)