# `denseRank`<a name="denseRank-function"></a>

`denseRank` calculates the rank of a measure or a dimension in comparison to the specified partitions\. It counts each item only once, ignoring duplicates, and assigns a rank "without holes" so that duplicate values share the same rank\. 

`denseRank` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="denseRank-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
denseRank
(
     [ sort_order_field ASC_or_DESC, ... ] 
     ,[ partition_field, ... ] 
)
```

### Arguments<a name="denseRank-function-arguments"></a>

 *sort order field*   
One or more aggregated fields, either measures or dimensions or both, that you want to sort the data by, separated by commas\. You can either specify ascending \(**ASC**\) or descending \(**DESC**\) sort order\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="denseRank-function-example"></a>

The following example densely ranks `max(Sales)`, based on a descending sort order, by `State` and `City`\. Any cities with the same `max(Sales)` are assigned the same rank, and the next city is ranked consecutively after them\. For example, if three cities share the same ranking, the fourth city is ranked as second\. 

```
denseRank
(
     [max(Sales) DESC], 
     [State, City]
)
```

The following example densely ranks `max(Sales)`, based on a descending sort order, by `State`\. Any states with the same `max(Sales)` are assigned the same rank, and the next is ranked consecutively after them\. For example, if three states share the same ranking, the fourth state is ranked as second\. 

```
denseRank
(
     [max(Sales) DESC], 
     [State]
)
```