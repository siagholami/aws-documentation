--------

--------

# Enum Types<a name="iot-tg-models-tdm-enum"></a>

The `EnumType` construct defines an enumeration that associates unique identifiers to integer values within a specified scope\.

**Examples**

```
enum lowMediumHigh @enumType(id:'urn:tdm:aws:enum:lowMediumHigh')  {
            Low @enumValue(value:0),
            Medium @enumValue(value:1),
            High @enumValue(value:2)
        }
        
enum trueFalse @enumType(id:'urn:tdm:aws:enum:trueFalse')  {
                TRUE @enumValue(value:0),
                FALSE @enumValue(value:1)
            }
```