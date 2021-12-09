--------

--------

# Mapping<a name="iot-tg-models-tdm-iot-mapping"></a>

The `Mapping` construct bridges differences across multiple representations of the same concept\. It converts semantically equivalent data from one representation to another\. A `Mapping` creates a single semantic view of data that originates from multiple sources\.

TDM supports directional \(forward and backward\) and symmetrical mappings\. The keywords `Forward`, `Reverse`, and `Symmetric` specify the mapping direction\. TDM validates mappings by identifying duplications and gaps in the mapping space\.

There are two kinds of mappings:
+ Simple property mappings, which map primitive type values\.
+ Complex property mappings, which map properties of complex properties\.

Mappings enable the AWS IoT Things Graph runtime to transform different representations of the equivalent properties\. A relatively simple example of how mappings can work is the on/off status of a device\. One possible representation of a device's on/off status is as an integer \(0/1\)\. The following example uses the built\-in `int` data type to define this kind of on/off property\. 

```
type OnOffInt @propertyType(id:'urn:tdm:aws:Property:OnOffInt', dataType:int8, minValue:0, maxValue:1) {
    ignore:void
}
```

The next example shows how to create an on/off enum and use it to represent the on/off property of a device\.

```
 enum OnOff @enumType(id:'urn:tdm:aws:Enum:OnOff') {
    ON @enumValue(value:0),
    OFF @enumValue(value:1)
}

type OnOffEnum @propertyType(id:'urn:tdm:aws:Property:OnOffEnum',
                             dataType:'urn:tdm:aws:Enum:OnOff') {
    ignore:void
}
```

The properties use different data types, but they represent the same concept\. You can transform these representations in both directions by using the following mapping\.

```
query OnOffEnum_to_OnOffInt @mapping(id:'urn:tdm:aws:Mapping:OnOffEnum_to_OnOffInt',
                                     name:'OnOffEnum_to_OnOffInt',
                                     from:'urn:tdm:aws:Property:OnOffEnum s',
                                     to:'urn:tdm:aws:Property:OnOffInt t') {
    forward {
       map(expr:'s == ON => 1'), # If enum value is ON, map 1 from property s to property t.
       map(expr:'s == OFF => 0') # If enum value is OFF, map 0 from property s to property t.
    }
    reverse {
       map(expr:'t == 1' => ON), # If integer value is 1, map ON from property t to property s.
       map(expr:'t == 0' => OFF) # If integer value is 0, map OFF from propery t to property s.
    }
}
```

This example uses the `@mapping` directive to create the `OnOffEnum_to_OnOffInt` under the mapping metatype\. It assigns the URN of the `OnOffEnum` property to the `from` field and the URN of the `OnOffInt` property to the `to` field\. A `Forward` mapping uses a set of expressions to transform values of the `from` property into values of the `to` property\. A `Reverse` mapping uses a list of expressions to transform values of the `to` property into values of the `from` property\.

The enum property alias is defined as `s`, and the integer property alias is defined as `t`\. The `Forward` mapping transforms the enum property of `ON` into the integer property of 1, and the enum property of `OFF` into the integer property of 0\. The `Reverse` mapping transforms the integer values into the enum values\.

The expressions inside the braces contain the logic that transforms the values back and forth\. For details about how to construct and use TDM expressions, see [Expressions](iot-tg-models-tdm-expressions.html)\. 

## Additional Examples<a name="iot-tg-models-tdm-iot-mapping-examples"></a>

The following example creates a mapping between two simple properties that represent brightness\. The example creates the following constructs:
+ An `enum` representation of brightness
+ A numerical range representation of brightness \(1\-100\)
+ `Forward` and `Reverse` mappings between the two representations

```
# Create abstract property simpleRange
type simpleRangeProperty @propertyType(id: "urn:tdm:aws:property:simpleRange") {
} {ignore:void}

# Create concrete property simpleRangeEnum that assigns SimpleRangeEnum to simpleRangeProperty
type simpleRangeEnumProperty @propertyType(                                
                      id:"urn:tdm:aws:property:simpleRange/simpleRangeEnum",
                      description:"Describes brightness with an enum",
                      dataType:"urn:tdm:aws:property:enum:SimpleRange”) ) {ignore:void}

# Create abstract property brightness 
type brightnessProperty @propertyType(id: "urn:tdm:aws/property/brightness",              
                                      isAbstract:true) {ignore:void}

# Create concrete property brightnessSimpleRange that sets the possible values for the brightness property 
type brightnessSimpleRangeProperty @propertyType(
                    id:"urn:tdm:aws:property:brightness/brightnessSimpleRange",
                    description: "Brightness value: low-medium-high",
                    dataType:"urn:tdm:aws:enum:SimpleRange”){ignore:void}

# Create concrete property brightnessNumber that sets the possible values for the brightness property 
type brightnessNumberProperty @propertyType(       
                    id:"urn:tdm:aws:property:brightness/brightnessNumber",
                    description: "Brightness value from 0-100",
                    dataType:"urn:tdm:aws:dataType:int32”, 
                    min:0, max:100 ) {ignore:void}

# Map Enum(low-medium-high) to integer (1-100) range representation
query brightnessSimpleRangeToBrightnessNumberMap
 @mapping(id:"aws/mapping/brightnessSimpleRangeToBrightnessNumber"
    from:"aws/ property/brightness/brightnessSimpleRange s",
    to:"aws/ property/brightness/brightnessNumber t") {
      forward (
         expr:"s==Low => 20",     # if boolean-expr true, map 20 to target t
         expr:"s==Medium => 45",  # if boolean-expr true, map 45 to target t
         expr:"s==High => 75"     # if boolean-expr true, map 75 to target t
      )
     reverse (
       expr:"t.value >= 0 && t.value <= 33 => Low", #if expr-true, map Low to target s
       expr:"t.value > 33 && t.value <= 66 => Medium", # on true, map Medium to s
       expr:"t.value > 66 && t.value <= 100 => High" # on true, map High to s
    )    
  }
}
```

The following example creates a symmetrical mapping between to complex properties that represent color\. It creates the following constructs:
+ Two states that represent RGB and RGBW colors
+ Two complex properties, one composed of the RGB state and another composed of the RGBW state
+ A symmetrical mapping between the two representations

```
# Create state colorRGB
type colorRGBState @stateType(id:”urn:tdm:aws:state:colorRGB”) {
    red   :int32 @property(id:"urn:tdm:aws:property:int32"), # int32 is the alias for the built-in property urn:tdm:aws:property:int32
    blue  :int32 @property(id:"urn:tdm:aws:property:int32"),
    green :int32 @property(id:"urn:tdm:aws:property:int32")
}

# Create state colorRGBW
type colorRGBWState @stateType(id:”urn:tdm:aws:state:colorRGBW”) {
    red   :int32, @property(id:"urn:tdm:aws:property:int32")# int32 is alias for built-in property urn:tdm:aws:property:int32
    blue  :int32, @property(id:"urn:tdm:aws:property:int32")
    green :int32, @property(id:"urn:tdm:aws:property:int32")
    white :int32 @property(id:"urn:tdm:aws:property:int32")
}

# Create abstract property Color
type color @propertyType(id: "urn:tdm:aws:property:color") {ignore:void}

# Create complex property type from colorRGB state
type colorRGBProperty @propertyType(id:”urn:tdm:aws:property:color/colorRGB”,
                                   dataType:”urn:tdm:aws:dataType:EntityType”,
                                   instanceOf:”urn:tdm:aws:state:colorRGB”) {ignore:void}


# Create complex property type from colorRGBW state
type colorRGBWProperty @propertyType(id:”urn:tdm:aws:property:color/colorRGBW”,
                                   dataType:”urn:tdm:aws:dataType:EntityType”,
                                   instanceOf:”urn:tdm:aws:state:colorRGBW”) {ignore:void}


# Create mapping for complex properties colorRGB and colorRGBW
query colorRGBtoRGBWMapping @mapping(id:"urn:tdm:aws:mapping:colorRGBtoRGBW",
            From:"urn:tdm:aws:property:color/colorRGB f", To:"urn:tdm:aws:property:color/colorRGBW t") 
{ 
    symmetric(
        map(expr:"f.red => t.red"),    # For symmetric map, both expressions are property names.
        map(expr:"f.blue => t.blue"),  # The s.blue property is mapped to the t.blue property.
        map(expr:"f.green => t.green)" # The semTypeIds of left and right properties are either in the same
    )                                  # property hierarchy or explicitly mapped.
                            
    forward( # All properties used in Min() must be in same hierarchy or explicitly mapped
        map(expr:"Math.min(f.red, f.blue, f.green) => t.white")
    )
    reverse( # All t.* properties must be mapped; If property has to be skipped, map to NULL. 
        map(expr:"t.white => NULL")
    )
}
```

The following example uses the mappings and properties from the previous two examples to create an additional complex mapping\. It creates the following constructs\.
+ A state that contains the numerical range representation of brightness and the RGB representation of color
+ A state that contains the `enum` representation of brightness and the RGBW representation of color
+ An abstract property named `brightColor`
+ A concrete complex property composed of the first state \(numerical range brightness and RGB color\)
+ A concrete complex property composed of the second state \(`enum` representation of brightness and RGBW color\)
+ A mapping between the two new complex properties

```
# First state containing colorRGB and brightnessNumber properties
type brightColorState @stateType(id: "urn:tdm:aws:state:brightColor") {
  color: colorRGB @property(id: "urn:tdm:aws:property:color/colorRGB"),
  brightness: brightnessNumber @property(id:"urn:tdm:aws:property:brightness/brightnessNumber")
}

# Second state containing colorRGBW and brightnessSimpleRange properties
type brightColorRGBWState @stateType(id: "urn:tdm:aws:state:brightColorRGBW") {
  colorRGBW:colorRGBW @property(id: "urn:tdm:aws:property:color/colorRGBW"),
  brightness:brightnessSimpleRange @property(id::"urn:tdm:aws:property:brightness/brightnessSimpleRange")
}

# Abstract property brightColor
type color @propertyType(id: "urn:tdm:aws:property:brightColor") {ignore:void}

# Complex property brightColor1
type brightColor1Property @propertyType(id:"…:property:brightColor/brightColor1") {
    value:brightColorState
} {ignore:void}

# Complex property brightColorRGBW
type brightColorRGBProperty @propertyType(id:"…:property:brightColor/brightColorRGBW") {
    value:brightColorRGBWState
} {ignore:void}

# Mapping between brightColor1Property <=> brightColorRGBWProperty
query brightColor1toRGBWMApping @mapping(id:"…:mapping:brightColor1toRGBW",
                                         from:"…:property:brightColor/brightColor1 f",
                                         to:"…:property:brightColor/brightColorRGBW t")
{
 symmetric(
    expr:"f.color => t.colorRGBW",      # re-uses mapping colorRGBtoRGBW
    expr:"f.brightness => t.brightness" # re-uses mapping brightnessSimpleRangeToBrightnessNumber 
  )
}
```