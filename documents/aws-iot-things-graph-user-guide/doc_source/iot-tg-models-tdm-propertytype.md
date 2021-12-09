--------

--------

# Properties<a name="iot-tg-models-tdm-propertytype"></a>

The `PropertyType` construct is used to define the attributes of a device\. For example, a device named `Light Bulb` might have properties like `PowerState`, `Brightness`, and `Color`\.

The following example shows how to create a `PropertyType` using GraphQL\.

```
type imageProperty @propertyType(id:"urn:tdm:aws:property:image/imageUri",  
                                 dataType:"urn:tdm:aws:property:Uri") { ignore:void }
```

**Note**  
The `ignore:void` name\-value pair specifies an empty body payload\.

## PropertyType Facets<a name="iot-tg-models-tdm-propertytype-facets"></a>

The `PropertyType` construct is defined by property facets\. There are two kinds of facets:
+ **Definition** \- These facets help create or define a `PropertyType`\. Example definition facets include `Name`, `DataType`, `Accuracy`, and `Uom`\. You can specify the `Uom` and `Accuracy` facets with instance values\. For example, a `PropertyType` named `Length` that has a `Uom` facet can be assigned an instance value of 10 inches or 10 feet\.
+ **Usage** \- These facets help customize a `PropertyType` within a specific scope\. Example usage facets are calculated values like `Condition` and `Expr`\.

TDM facets are case insensitive\.

### Definition Facets<a name="iot-tg-models-tdm-propertytype-facets-definition"></a>

`SemTypeId`  
Required, multivalued\. A URN or URNs that represent a property's semantic type\.  
The semantic type hierarchical path asserts an "is\-a" relationship contract between parents and children in the path\. This relationship establishes semantic equivalence and doesn't imply structural equivalence\. The subype is a semantically equivalent alternate of its parent type for the purpose of interoperability in an IoT workflow\. For example, a brightness property expressed by a range of numbers between 1 and 100 is semantically equivalent to a brightness property expressed as an enum\.  
Example: `urn:tdm:aws:property:length`

`DataType`  
Required\. A value from the built\-in enum `DataType`\. See [Built\-in Data Types](iot-tg-models-tdm-datatypes.html) for the possible values for this facet\.  
You can also limit the range of an integer property type by using the `minValue` and `maxValue` attributes, as in the following example\. The property type definition creates an on/off property that is represented as a 0 for off and 1 for on\.  

```
type OnOffInt @propertyType(id:'urn:tdm:aws:Property:OnOffInt', dataType:int8, minValue:0, maxValue:1) {
    ignore:void
}
```

`Description`  
Optional\. A string that describes the property\.

`InstanceOf`  
A URN that specifies a complex property's type\. This value is required whenever the property's `DataType` value is not one of the built\-in primitive data types\.

`Uom`  
Optional\. A value from the built\-in enum under the semantic path at this URN: `urn:tdm:aws:enum:uom`\. This value specifies the unit of measure associated with the property's value\.  
Example: `urn:tdm:aws:uom:base/mass`

`Accuracy`  
Optional\. A float32 value that describes the closeness of a measurement's value to the true value\. This value can be expressed as either a \+/\- absolute value or a percentile value\. TDM doesn't process this value\.

`IsAbstract`  
Optional\. A Boolean value that specifies whether the `PropertyType` can be used in a concrete type\. The default value is `false`\. An abstract `PropertyType` is usually the root of a property hierarchy\.

`IsGlobalId`  
Optional\. A Boolean that specifies whether the value of a property is unique across all instances of the type that contains the property\. The default value is `false`\. It applies only to non\-nullable identifier properties\. If the value is `true`, the instances of the type that contains the property can be used by reference\. A `DeviceCatalog` is an example of the kind of type that would have this facet set to `true`\.

`MinLength, MaxLength`  
Optional\. Number values that specify in bytes the minimum and maximum length of a string property\. The default value of `MinLength` is 0\. The default value of `MaxLength` is 4096\. When both values are the same, the property has a fixed length\.

`MinValue, MaxValue`  
Optional\. Number values that specify the minimum and maximum values of a numeric property\. The numeric property can be of any type of int, uint, and float\.

### Usage Facets<a name="iot-tg-models-tdm-propertytype-facets-usage"></a>

`IsRequired`  
Optional\. A Boolean value that specifies whether a property is required for every type that contains the property\. The default value is `false`\.

`Default`  
Applicable only to properties for which the `IsRequired` facet has been set to `true`\. A variant\-typed facet that specifies the default value of a property\.

`Condition`  
Optional\. A Boolean expression that evaluates other properties of the type that contains the property\. If the expression evaluates to `true`, the property value is included\. If the expression evaluates to `false`, the property is excluded \(either `null` or `default`, as applicable\)\. A `PropertyType` with this facet is read\-only\.

`Expr`  
Optional\. An expression that converts a standard property into a computed property\. A `PropertyType` with this facet is read\-only\.

`IsReadOnly`  
Optional\. A Boolean facet that specifies whether the property is read\-only\. The default value is `false`\.

`Multiplicity`  
Optional\. An enum facet that specifies the number of values that a property can have\. The default value is `Multiplicity.Multivalued`\. A value of `Multiplicity.Singlevalued` limits the number of values of a property to 1\.