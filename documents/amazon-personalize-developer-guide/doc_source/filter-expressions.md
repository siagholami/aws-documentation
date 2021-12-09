# Filter Expressions<a name="filter-expressions"></a>

Use filter expressions to explicitly define which items are included or excluded from your Amazon Personalize recommendations\. To configure filters, you must use a properly formatted *filter expression*\. Filter expressions are composed of dataset and property identifiers in `dataset`\.`property` format, along with logical operators and keywords\.

For a complete list of filter expression elements, see [Filter Expression Elements](#filter-expression-elements)\. For examples of filter expressions, see [Filter Expression Examples](#filter-expression-examples)\. 

**Note**  
Amazon Personalize ignores case only when matching event types\. It recognizes event types and items that were present during solution version training or that are streamed using the [PutEvents](API_UBS_PutEvents.md) operation\. For more information, see [Creating a Solution](training-deploying-solutions.md)\.

## Creating Filter Expressions<a name="creating-filter-expressions"></a>

You can either manually create filter expressions or get help with expression syntax and structure by using the [Expression builder](filter-real-time.md#using-filter-expression-builder) in the console\. You can use filter expressions to filter items that are contained in the following datasets:
+  **Interactions**: Use filter expressions to include or exclude items that a user has interacted with \(for example, user events such as click or stream\)\. Amazon Personalize filters recommendations based on the most recent 200 historical and 100 new interaction events recorded in a user's Interactions dataset\.
+  **Items**: Use filter expressions to include or exclude items based on specific item conditions\. 
+  **Users**: Use filter expressions to include or exclude items based on specific user conditions\. You can add `CurrentUser`, which is part of the User dataset, to any expression regardless of the dataset that is being used in the expression\.

**Note**  
You can't chain Interaction and Item datasets into one expression\. To create a filter that filters by Interaction and then Item datasets \(or the opposite\), you must chain two or more expressions together\. For more information, see [Multiple Expressions Example](#multiple-expression-example)\. 

### Filter Expression Elements<a name="filter-expression-elements"></a>

Use the following elements to create filter expressions:
+ INCLUDE: Use `INCLUDE` to make sure certain items are in recommendations\.
+ EXCLUDE: Use `EXCLUDE` to remove certain items from recommendations\.
+ ItemID: Use `ItemID` as a placeholder following an `INCLUDE` or `EXCLUDE` element\.
+  WHERE: Use `WHERE` to check conditions for items\. You must use the `WHERE` element after the `ItemID`\. 
+  AND/OR: Use `AND` or `OR` to chain multiple conditions together within the same filter expression\. 
+  IF: Use `IF` *only* to check conditions for the `CurrentUser` and only once at the end of an expression\. However, you can extend an `IF` condition using `AND`\. 
+  IN/NOT IN: Use `IN` or `NOT IN` as comparison operators to filter based on matching \(or not matching\) one or more string values\. Amazon Personalize filters only on exact strings\.
+  Use =, <, <=, >, >= operators to test numerical data for equality\.
+  Use `*` only only for filters that use the `EVENT_TYPE` property of the `Interaction` dataset\. 
+  Use the pipe separator \(`|`\) to chain multiple expressions together\. For more information, see [Multiple Expressions Example](#multiple-expression-example)\. 

### Filter Expression Examples<a name="filter-expression-examples"></a>

 Use the following examples to learn how to build your own filter expressions\. They are organized by dataset type\. 

 **Interactions** 

 The following expression excludes items that the user clicked or streamed\. 

```
EXCLUDE ItemID WHERE Interactions.EVENT_TYPE IN ("click", "stream")
```

 The following expression includes items that the user has interacted with in any way\.

```
INCLUDE ItemID WHERE Interactions.EVENT_TYPE IN ("*")
```

 **Items** 

 The following expression excludes items in the `shoe` category that *do not* have a description of `boot`\. 

```
EXCLUDE ItemID WHERE Items.CATEGORY IN ("shoe") AND Items.DESCRIPTION NOT IN ("boot")
```

 The following expression includes items with a `NUMBER_OF_DOWNLOADS` less than `20`\. 

```
INCLUDE ItemID WHERE Items.NUMBER_OF_DOWNLOADS < 20
```

 **Users** 

 The following expression excludes items where the `NUMBER_OF_DOWNLOADS` is less than `20` if the current user's age is over `18`, but less than `30`\. 

```
EXCLUDE ItemID WHERE Items.NUMBER_OF_DOWNLOADS < 20 IF CurrentUser.AGE > 18 AND CurrentUser.AGE < 30
```

 The following expression includes items in the `watch` category, with a description of `luxury`, if the current user's age is over `18`\. 

```
INCLUDE ItemID WHERE Items.CATEGORY IN ("watch") AND Items.DESCRIPTION IN ("luxury") IF CurrentUser.AGE > 18
```

#### Multiple Expressions Example<a name="multiple-expression-example"></a>

You can chain multiple expressions together using a pipe separator\. This allows you pass the results of one expression to an additional expression so you can filter by multiple datasets and use more precise filtering\.

The following example includes two expressions\. The first includes items in the `drama` genre, and the result of this filter is passed to another expression that excludes items that the user has clicked or streamed\.

```
INCLUDE ItemID WHERE Items.GENRE IN ("drama") | EXCLUDE ItemID WHERE Interactions.EVENT_TYPE IN ("click", "stream")
```