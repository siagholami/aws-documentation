# Amazon Cloud Directory Limits<a name="limits"></a>

The following are the default limits for Cloud Directory\. Each limit is per region unless otherwise noted\.

## Amazon Cloud Directory<a name="limits_default"></a>


**Schema and Directory Limits**  

| Limit/Concept | Quantity | 
| --- | --- | 
| Number of attributes per facet \(including required\) | 1000 | 
| Number of facets per object | 5 | 
| Number of unique indexes an object is attached | 3 | 
| Number of facets per schema | 30 | 
| Number of rules per attribute | 5 | 
| Number of attributes with default values per facet | 10 | 
| Number of required attributes per facet | 30 | 
| Number of development schemas | 20 | 
| Number of published schemas | 20 | 
| Number of applied schemas | 5 | 
| Number of directories | 100 | 
| Max page elements | 30  | 
| Max input size \(all inputs combined\) | 200 KB | 
| Max response size \(all outputs combined\) | 1 MB | 
| Schema JSON file size limit | 200 KB | 
| Facet name length | 64 UTF\-8 encoded bytes | 
| Directory name length | 64 UTF\-8 encoded bytes | 
| Schema name length | 64 UTF\-8 encoded bytes | 


**Object Limits**  

| Limit/Concept | Quantity | 
| --- | --- | 
| Number of written objects | 20 per API call  | 
| Number of read objects | 200 per API call | 
| Number of written attribute values | 1000 per API call | 
| Number of read attribute values | 1000 per API call | 
| Path depth | 15 | 
| Max input size \(all inputs combined\) | 200 KB | 
| Max response size \(all outputs combined\) | 1 MB | 
| Policy size limit | 10 KB | 
| Number of attributes that can be deleted during object deletion | 30 | 
| Aggregate value length for typed link identity attributes | 64 UTF\-8 encoded bytes | 
| Edge or link name length | 64 UTF\-8 encoded bytes | 
| Value length for indexed attributes | 512 UTF\-8 encoded bytes | 
| Value length for non\-indexed attributes | 2KB | 
| Number of policies attached to an object | 4 | 

### Limits on batch operations<a name="limits_onbatchops"></a>

There are no limits on the number of operations you can call inside a batch\. For more information, see [Limits on Batch operations](transaction_support.md#transaction_support_batchlimits)\.

### Limits that cannot be modified<a name="limits_cantbemodified"></a>

Amazon Cloud Directory limits that cannot be changed or increased, include:
+ Facet name length
+ Directory name length
+ Schema name length
+ Max page elements
+ Edge or link name length
+ Value length for indexed attributes