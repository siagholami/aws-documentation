# Range Filters<a name="directory_objects_range_filters"></a>

Several Cloud Directory list APIs allow specifying a filter in the form of a range\. These filters allow you to efficiently select subsets of the links attached to the specified node\.

Ranges are generally supplied as a map \(array of key\-value pairs\) whose keys are attribute identifiers and whose values are the corresponding ranges\. This allows filtering links whose identities consist of one or more attributes\. For example, a TypedLink set up to model a Role relationship for determining permissions might have both RoleType and Authorizer attributes\. A [http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListOutgoingTypedLinks.html) call could then specify ranges to filter the result to RoleType:”Admin” and Authorizer:”Julia”\. The map of ranges used to filter a single list request must contain only attributes that define the link’s identity \(an index’s OrderedIndexedAttributeList or a TypedLink’s IdentityAttributeOrder\), but it need not contain ranges for all of them\. Missing ranges will automatically be filled in with ranges that span all possible values \(from FIRST to LAST\)\.

If you think of each attribute as defining an independent flat domain of values, the range structures define two logical points in that domain — the start and end points — and the range matches all of the possible points in between those points\. The StartValue and EndValue of the range structure define the basis for these two points with the “modes” further refining them to indicating whether each point itself is to be included or excluded from the range\. In the RoleType:”Admin” example above, the values for the RoleType attribute would both be “Admin”, and the modes are both “INCLUSIVE” \(written as \[“Admin” to “Admin”\]\)\. A filter for a ListIndex call where the index is defined on the LastName of a User facet might use StartValue=”D”, StartMode=INCLUSIVE, EndValue:”G”, EndMode:EXCLUSIVE to narrow the listing to names starting with D, E, or F\.

The start point of a range must always precede or be equal to the end point\. Cloud Directory will return an error if EndValue precedes the StartValue\. The values must also be of the same primitive type as the attribute they are filtering, String values for a String attribute, Integer for an Integer attribute, and so on\. StartValue=“D”, StartMode=EXCLUSIVE, EndValue=“D”, EndMode=INCLUSIVE is invalid, for instance, because the end point includes the value while the start point follows the value\.

There are three special modes that can be used by either start or end points\. The following modes do not require the corresponding value field to be specified, as they imply a position on their own\.
+ **FIRST \-** precedes all possible values in the domain\. When used for the start point, this matches all possible values from the beginning of the domain up to the end point\. When used for the end point, no values in the domain will match the range\.
+ **LAST \-** follows all possible values in the domain\. When used for the end point, this matches all possible values that follow the start point, including missing values\. When used for the start point, no values in the domain will match the range\.
+ **LAST\_BEFORE\_MISSING\_VALUES \-** This mode is only useful for optional attributes where the value may be omitted \(see [Missing values](#directory_objects_range_filters_missingvalues)\)\. It corresponds to the point between the missing values and the actual domain values\. When used for the end point, this matches all non\-missing domain values that follow the start point\. When used for the start point, it excludes all non\-missing domain values\. If the attribute is a required one, this mode is equivalent to LAST, as there can be no missing values\.

## Multiple range limitations<a name="directory_objects_range_filters_multiplerangelimits"></a>

Cloud Directory limits patterns where there are multiple attributes in order to guarantee efficient, low\-latency request processing\. Each link with multiple identifying attributes specifies them in a well\-defined order\. For instance, the Role example above defines the RoleType attribute as most significant, and the Authorizer attribute as least significant\. A List request can specify only a single “qualifying” range that is not either 1\) a single value or 2\) spans all possible values \(there can be multiple ranges that match these two requirements\)\. Any ranges for more significant attributes than the qualifying range attribute must specify a single value, and any ranges for less significant ranges must span all possible values\. In the Role example, the filter sets \(RoleType:”Admin”, Authorizer:\[“J” to “L”\]\) \(single value \+ qualifying range\), \(RoleType:\[”Admin” to “User”\]\) \(qualifying range \+ implicit spanning range\), and \(RoleType:\[FIRST to LAST\]\) \(two spanning ranges, one implicit\) are all examples of valid filter sets\. \(RoleType:\[FIRST to LAST\], Authorizer:”Julia”\) is not a valid set, since the spanning range is more significant than the single value range\.

Some useful patterns when filling in the range structures, include:

**Matching a single value**

Specify the value for both StartValue and EndValue, and set both modes to “INCLUSIVE”\.

Example: `StartValue=“Admin”, StartMode=INCLUSIVE, EndValue=“Admin”, EndMode=INCLUSIVE`

**Matching a prefix**

Specify the prefix as the StartValue with INCLUSIVE mode, and the first value after the prefix as EndValue with an EXCLUSIVE mode\.

Example: `StartValue=“Jo”, StartMode=INCLUSIVE, EndValue=“Jp”, EndMode=EXCLUSIVE (“p” is the next character value after “o”)`

**Filtering for Greater Than a value**

Specify the value for StartValue with EXCLUSIVE mode, and LAST as the EndMode \(or LAST\_BEFORE\_MISSING\_VALUES to exclude missing values, if applicable\)\.

Example: `StartValue=127, StartMode=EXCLUSIVE, EndValue=null, EndMode=LAST`

**Filtering for Less Than or equal to a value**

Specify the value for the EndValue with INCLUSIVE mode, and FIRST as the StartMode\. 

## Missing values<a name="directory_objects_range_filters_missingvalues"></a>

When an attribute is marked as Optional in the schema, it’s value may be “missing” since it need not have been supplied when the facet was attached or the attribute could have been subsequently deleted\. If the object with such a missing value is attached to an index, the index link is still present, but moved to the end of the set of links\. A `[ListIndex](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_ListIndex.html)` call will first return any links where the indexed attributes are all present before returning links where one or more are missing\. This is roughly similar to a relational database NULL value, with these values ordered after non\-NULL values\. You can specify whether a range includes these missing values or not by choosing the LAST or LAST\_BEFORE\_MISSING\_VALUES modes\. For example, you provide a filter to a ListIndex call to return just the missing values in an index by filtering with the range \[LAST\_BEFORE\_MISSING\_VALUES to LAST\]\.