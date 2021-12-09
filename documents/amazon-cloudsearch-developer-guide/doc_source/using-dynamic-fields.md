# Using Dynamic Fields in Amazon CloudSearch<a name="using-dynamic-fields"></a>

Dynamic fields provide a way to index documents without knowing in advance exactly what fields they contain\. For example, consider the case where you want to search a set of products\. You might not know the names of all of the possible product attributes across all product categories, but you can structure your data so that all text\-based attributes are stored in fields that end in `_t`, and all integer values are stored in fields that end in `_i`\. With dynamic fields, you can map the attribute fields to the appropriate field type without having to configure a field for every possible attribute\. This reduces the amount of configuration that you need to do up front, and eliminates the need to modify your domain configuration every time a product with a new attribute is added\. You can also use dynamic fields to essentially ignore new fields by mapping them to a field that is not searchable or returnable\.

**Topics**
+ [Configuring Dynamic Fields in Amazon CloudSearch](#configuring-dynamic-fields)
+ [Using a Dynamic Field to Ignore Unrecognized Fields in Amazon CloudSearch](#ignoring-fields)
+ [Searching Dynamic Fields in Amazon CloudSearch](#searching-dynamic-fields)

## Configuring Dynamic Fields in Amazon CloudSearch<a name="configuring-dynamic-fields"></a>

You designate a field as a dynamic field by specifying a wildcard \(\*\) as the first, last, or only character in the field name\. Dynamic field names must either begin or end with a wildcard \(\*\)\. Multiple wildcards and wildcards embedded within a string are not supported\. 

A dynamic field's name defines a pattern\. The wildcard matches zero or more arbitrary characters\. Any unrecognized fields that match that pattern are configured with the dynamic field's indexing options\. Regular index fields take precedence over dynamic fields\. If a document field name matches both a regular index field and a dynamic field pattern, it is mapped to the regular index field\.

**Note**  
The options you can configure for dynamic fields are the same as for [static fields](configuring-index-fields.md)\. Similarly, document field names that match a dynamic field must meet all the same criteria as static field names\.

For example, if you establish the naming convention that `_i` is appended to the name of any new `int` field, you can define a dynamic field with the pattern `*_i` that sets the field type to `int` and configures a set of predefined indexing options for new `int` fields\. When you add a field such as `review_rating_i`, it's configured according to the `*_i` options and indexed automatically\.

If a document field matches more than one dynamic field pattern, the longest matching pattern is used\. If the patterns are the same length, the dynamic field that occurs first when the field names are sorted alphabetically is used\. 

You can define \* as a dynamic field to match any fields that don't map to an explicitly defined field or a longer dynamic field pattern\. This is useful if you want to simply ignore unrecognized fields\. For more information, see [Using a Dynamic Field to Ignore Unrecognized Fields in Amazon CloudSearchIgnoring Unrecognized Document Fields](#ignoring-fields)\.

Dynamic fields count toward the total number of fields defined for a domain\. A domain can have a maximum of 200 field definitions, which includes dynamic fields\. However, the pattern defined by a single dynamic field typically matches multiple document fields, so the total number of fields in your index can exceed 200\. For more information, see [Understanding Amazon CloudSearch Limits](limits.md)\. When using dynamic fields, keep in mind that significantly increasing the number of fields in your index can impact query performance\.

Adding new fields to your domain configuration can affect how fields that were generated dynamically are validated during indexing\. If the validation fails, indexing will fail\. For example, if you define a dynamic field called `*_new` and upload documents that contain a field called `rating_new`, the `rating_new` field will be added to your index\. If you then explicitly configure a field called `rating_new`, that new field configuration will be used to validate the contents of your document's `rating_new` field when you run indexing\. If `*_new` is configured as a `text` field and you configure `rating_new` as an `int` field, validation will fail if the existing `rating_new` fields contain non\-integer data\.

For more information about configuring index fields, see [Configuring Index Fields](configuring-index-fields.md)\.

## Using a Dynamic Field to Ignore Unrecognized Fields in Amazon CloudSearch<a name="ignoring-fields"></a>

Amazon CloudSearch requires that you configure an index field for every field that occurs in the documents you are indexing\. In some cases, however, you want to index a particular set of fields and simply ignore everything else\. You can use dynamic fields to ignore all unrecognized fields by defining a literal field called \* and disabling all indexing options for the field\. Any unrecognized fields will inherit those options and will be added to your domain; however, the field contents won't be searchable or returnable, so they'll have minimal impact on the size of your index\. \(They do, however, count toward the total number of fields configured for the domain\.\) Similarly, you can selectively ignore fields that match a particular pattern, such as `*_n`\. 

**To ignore unrecognized fields**

1. Configure the fields that you want to index, search, or return in the results\.

1. Add a dynamic field that matches any other fields that are found in the documents and disables all indexing options for them:
   + Specify `*` as the name of the field, with no prefix or suffix string\. \(You can also specify a more specific pattern to selectively disable fields\.\)
   + Set the field type to `literal` and disable the `search`, `facet`, and `return` options\. Note that the maximum size of a literal field is 4096 Unicode code points\.

Because longer dynamic field patterns are matched first, you can still use dynamic fields to configure options for fields that you want to use\. Any fields that don't map to a regular index field or a longer dynamic field will match the \* pattern\.

**Note**  
When you create a dynamic field with the name `*`, it means that your index can potentially contain any valid field name\. This also means that you can reference any valid field name in your search requests, whether or not it actually exists in your index\. 

## Searching Dynamic Fields in Amazon CloudSearch<a name="searching-dynamic-fields"></a>

You can reference dynamically generated fields by name in your search requests and expressions, just like any other field\. For example, to search the dynamically generated field `color_t` for the color `red`, you use the structured query parser:

```
q=color_t:’red’&q.parser=structured
```

If you've defined a catch\-all dynamic field \(\*\) to map any fields that don't match regular fields or more specific dynamic field patterns, you can specify *any* valid field name in your search requests, whether or not the field actually exists in your index\.

Wildcards are not supported within field names, so you cannot reference the dynamic field itself\. For example, specifying `q=*_t:’red’` would return an error\.

The options a dynamically generated field inherits from the dynamic field configuration control how you can use the field in your search requests, for example, whether you can search it, get facets or highlights, use it for sorting, or return in it results\. Note that dynamically generated fields must be searched explicitly—dynamic fields are NOT included in the fields that are searched by default when you use the simple query parser or do not specify a field when searching with the structured query parser\. 

You can specify dynamic fields as sources for other fields\. A field's source attribute supports wildcards, which enables you to specify a pattern that matches a group of dynamic fields\. For example, to search all fields generated from the `*_t` dynamic field, you could create a field called `all_t_fields` and set its source attribute to `*_t`\. This copies the contents of all fields whose names end in `_t` into `all_t_fields`\. Note, however, that searching this field will search *all* fields that match the pattern, not only dynamically generated fields\.

For more information about constructing and submitting search requests, see [Searching Your Data with Amazon CloudSearch](searching.md)\.