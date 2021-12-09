# Comparing Expressions in Amazon CloudSearch<a name="comparing-expressions"></a>

 You can use the Amazon CloudSearch console to compare expressions to see how changes to the expression and field weights affect how search results are sorted\.

**To compare expressions**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, select a domain, and then click the domain's **Compare Expressions** link\.

1. In the **Compare Expressions** pane, specify the rank expressions you want to compare\. In each Expression editor, you can add a new expression or select an existing expression from the **Expressions** menu\. New expressions are validated when you submit a search request\. If errors are detected, the expression is highlighted in red and a description of the problem is displayed\.

1. Specify the field weights to use for each expression by adjusting the sliders in the **Field Weights** menu\. You can also edit the field weights directly in the expression\. Field weights must be in the range 0\.0 to 10\.0, inclusive\. By default, the weight for all fields is set to 1\.0\. You can set individual field weights to control how much matches in particular text or literal fields affect a document's relevance \_score\. You can also change the default weight\.
**Note**  
Adjusting field weights only affects result ranking if the expression references the `_score` value\. You can modify the expression to change how the weight relevance `_score` contributes to a document's overall ranking\. For more information, see [Using Relative Field Weighting to Customize Text Relevance](weighting-fields.md)\.

1. Enter the terms you want to search for in the **Search** field and click **GO**\. The results for the search are ranked using the specified expressions and weights\. The results are refreshed whenever you make changes to the expressions or weights\.

   The search results for the two expressions are shown side\-by\-side\. \(If the expression is empty, the results are sorted according to the default relevance `_score`\.\) Four icons highlight the differences:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/images/cloudsearch-console-green-up-arrow.png) Green Up Arrow  
 The document is ranked higher in the search results using the second expression\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/images/cloudsearch-console-red-down-arrow.png) Red Down Arrow  
 The document is ranked lower in the search results using the second expression\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/images/cloudsearch-console-yellow-plus.png) Yellow Plus  
 The document is included in the search results using the second expression, but was omitted from the search results using the first expression\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/images/cloudsearch-console-red-minus.png) Red Minus  
 The document was omitted from the search results using the second expression, but was included in the search results using the first expression\. 

**Note**  
You can save expressions to your domain configuration directly from the **Compare Expressions** pane\. To save either expression, select **Save Expression** from the **Expressions** menu, enter a name for the expression, and click **OK**\. 