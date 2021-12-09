# Configuring Reusable Expressions for a Search Domain in Amazon CloudSearch<a name="configuring-reusable-expressions"></a>

**Topics**
+ [Amazon CloudSearch console](#configuring-expressions-console)
+ [aws cloudsearch define-expression](#configuring-expressions-clt)
+ [DefineRankExpression](#configuring-expressions-sdk)

When you define an expression in a domain's configuration, you can reference the expression in any search request\. Adding an expression to the domain configuration reduces the overhead of specifying it in every request, and helps maximize response times and minimize costs\. 

When you add an expression to your domain configuration, it takes some time for the change to be processed and the new expression to become active\. To quickly test changes to an expression, you can define and use the expression directly in a search request, as described in [Defining Expressions in Search Requests](defining-expressions-in-requests.md)\. After you have finished testing and tuning an expression, you should add it to your domain configuration\. 

## Configuring Expressions Using the Amazon CloudSearch Console<a name="configuring-expressions-console"></a>

**To configure an expression**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain, and then click the domain's **Expressions** link\.

1. In the **Expressions** pane, click the **Add a New Expression** button\. The button is below the list of expressions configured for the domain\.

1. Enter a name for the new expression in the **Name** field\. 

1. Enter the numerical expression you want to evaluate at search time in the **Expression** field\. You can use the **insert\.\.\.** menu to insert special values and mathematical and trigonometric functions\.

1. Click **Add a New Expression** to configure additional expressions\. 

1. Click **Submit** to save your changes\.

## Configuring Amazon CloudSearch Expressions Using the AWS CLI<a name="configuring-expressions-clt"></a>

You use the `aws cloudsearch define-expression` command to define computed expressions for a domain\.

**To configure an expression**
+ Run the `aws cloudsearch define-expression` command to define a new expression\. You specify a name for the expression with the `--name` option, and the numeric expression that you want to evaluate with the `--expression` option\. For example, the following request creates an expression called `popularhits` that takes into account a document's `popularity` and relevance `_score`\.

  ```
  aws cloudsearch define-expression --domain-name movies --name popularhits --expression '((0.3*popularity)/10.0)+(0.7* _score)'
  
  {
      "Expression": {
          "Status": {
              "PendingDeletion": false, 
              "State": "Processing", 
              "CreationDate": "2014-05-01T01:15:18Z", 
              "UpdateVersion": 52, 
              "UpdateDate": "2014-05-01T01:15:18Z"
          }, 
          "Options": {
              "ExpressionName": "popularhits", 
              "ExpressionValue": "((0.3*popularity)/10.0)+(0.7* _score)"
          }
      }
  }
  ```

## Configuring Expressions Using the Amazon CloudSearch Configuration API<a name="configuring-expressions-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[DefineExpression](API_DefineExpression.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.