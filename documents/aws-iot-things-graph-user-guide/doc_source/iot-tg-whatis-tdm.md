--------

--------

# What Is the AWS IoT Things Graph Data Model?<a name="iot-tg-whatis-tdm"></a>

The AWS IoT Things Graph Data Model \(TDM\) is a feature of AWS IoT Things Graph that enables users to create abstract representations of IoT devices and concepts\. A concept is a virtual representation of a real\-world measurement or quantity\. For example, temperature and color are concepts\. In TDM, concepts are called [Properties](iot-tg-models-tdm-propertytype.html) and are important building blocks\. Further, a key feature for enabling interoperability among devices is the [Mapping](iot-tg-models-tdm-iot-mapping.html)\. A mapping expresses a conversion between different representations of a property\. This makes it possible for disparate devices from multiple manufacturers to communicate with each other\.

The following snippet from an example discussed in [Mapping](iot-tg-models-tdm-iot-mapping.html) shows how this works\. It creates a simple translation of one way of representing the on/off property of a device \(an enum\) into an alternative way of representing the same concept\.

```
query OnOffEnum_to_OnOffInt @mapping(id:'urn:tdm:aws:Mapping:OnOffEnum_to_OnOffInt',
                         name:'OnOffEnum_to_OnOffInt',
                         from:'urn:tdm:aws:Property:OnOffEnum s',
                         to:'urn:tdm:aws:Property:OnOffInt t')
```

In the following topics, we discuss the syntax at greater length\. For now we can focus just on the `from` and the `to` properties\. A lot of devices can have on/off states, so this property isn't nested deeply in the `property` hierarchy, but it's a basic, granular concept\. Two representations of it can be precisely translated in both directions, and this mapping can be used across all devices that represent the on/off state in one of these two ways\.

## GraphQL Syntax<a name="iot-tg-whatis-tdm-graphql"></a>

TDM is expressed with GraphQL syntax\. TDM constructs are compliant with the GraphQL standard, but TDM uses GraphQL in a distinct and highly specialized way\. 

TDM doesn't use GraphQL as a query language or as a server runtime for executing queries\. Instead, TDM uses GraphQL as a tool for creating a type system consisting of IoT devices and data concepts\. GraphQL provides a powerful and concise way of defining the types and structures common in IoT\. Since Graphs are useful tools for modeling real\-world objects \(such as IoT devices\) and GraphQL models things as graphs, its syntax is a convenient vehicle for modeling the IoT conceptual space\. 

You can look at the [GraphQL documentation](https://graphql.org/learn/) for a thorough understanding of GraphQL and what you can do with it\. However, to understand how it's used in TDM, you need to understand only a handful of core concepts\.

**Types** 

GraphQL uses types to define the structure of objects in a schema\. The given type of an object must define the object's structure\. For example, an employee address book would need to define an object type for `Employee`\. 

The following example shows how you might define an `Employee` in GraphQL\.

```
type Employee {
  id: ID!
  firstname: String!
  middlename: String
  lastname: String!
  location: Building!
  phonenumbers: [PhoneNumber!]!
}
```
+ `Employee` – A GraphQL object type\. This type has six fields\.
+ `id`, `firstname`, `middlename`, `lastname`, `location`, `phonumbers` – Fields on the `Employee` object type\. Any object of type `Employee` must contain these fields\.
+ `String` – A built\-in data type\. The exclamation point \(`!`\) means that the field can't be null\.
+ `Building` – Another GraphQL object type\. Its structure must also be defined in the schema\.
+ `PhoneNumber` – Another GraphQL object type\. Its structure must also be defined in the schema\. The brackets mean that this is an array of `PhoneNumber` objects\. The exclamation point inside the brackets means that no object in the array can be null\. The exclamation point outside the brackets means that the array itself can't be null\. Because an empty array is technically not null, and an empty array contains no elements, an empty array would be valid according to this definition\.

**Queries** 

Queries in GraphQL are typically used to execute queries on objects within a GraphQL schema\. However, TDM uses queries in much the same way as types\. A query in TDM is simply a way of defining objects that have a greater degree of complexity than the type syntax supports\. The original purpose of GraphQL queries is to request fields on objects\. Because a GraphQL schema can contain nested types \(as in the `Employee` example, which contains both `Building` and `PhoneNumber` objects\), queries on GraphQL objects can contain nested structures\. A query requesting the name and address of a particular employee, for example, could look like the following example\.

```
query {
  Employee(id: 1000) {
    name
    building {
      name
      address {
        streetAddress
        zipcode
      }
    }
  }
}
```

In TDM, GraphQL queries aren't used for executing queries on objects that are defined in a GraphQL schema\. In TDM, queries are used for representing complex concepts, such as [Mappings](iot-tg-models-tdm-iot-mapping.html)\.

**Directives** 

A directive is an instruction attached to a field that begins with the `@` symbol\. Directives in GraphQL are generally attached to query fields and are meant to manipulate the results of a query in any way defined by the server runtime\. The GraphQL standard currently defines only two directives: `@include(if: Boolean expression)` and `@skip(if: Boolean expression)`\. You can use these directives to specify the conditions under which a field gets included in a result set\. TDM uses directives in a very different way\.

In TDM, directives play a fundamental role in defining IoT concepts\. Instead of defining query behavior, TDM directives are conceptually the equivalent of statements and type declarations\. 

In the following example, the `@enumType` directive tells AWS IoT Things Graph to create a simple ON/OFF enum\. Notice that this enum is used in the preceding mapping snippet\.

```
enum trueFalse @enumType(id:'urn:tdm:aws:enum:trueFalse')  {
    ON @enumValue(value:0),
    OFF @enumValue(value:1)
}
```

The directive follows the `enum` GraphQL object type specification and name\. In this context, it means "create an enum with the following properties and structure\." The directive takes one or more arguments that specify the properties of the object to create\. In this case, the enum type requires only a [TDM URN](iot-tg-models-tdm-urnscheme.html)\.

As in regular GraphQL objects, the fields inside the curly braces define the structure of the object\. The enum contains only two fields, `ON` and `OFF`\. These fields also have directives attached to them\. In this case, the `@enumValue` directive tells AWS IoT Things Graph to create enum values with the values specified by the arguments inside the parentheses: `value: 0` and `value: 1`\.

TDM combines these three GraphQL concepts—types, queries, and directives—into a rich and expressive tool for defining IoT applications\. 

Now that you have a general understanding of these concepts, see [AWS IoT Things Graph Data Model and GraphQL](iot-tg-models-tdm-graphql.html) for more information about how TDM works\.