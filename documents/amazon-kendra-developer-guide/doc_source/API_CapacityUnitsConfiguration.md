--------

--------

# CapacityUnitsConfiguration<a name="API_CapacityUnitsConfiguration"></a>

Specifies capacity units configured for your index\. You can add and remove capacity units to tune an index to your requirements\.

## Contents<a name="API_CapacityUnitsConfiguration_Contents"></a>

 **QueryCapacityUnits**   <a name="Kendra-Type-CapacityUnitsConfiguration-QueryCapacityUnits"></a>
The amount of extra query capacity for an index\. Each capacity unit provides 0\.5 queries per second and 40,000 queries per day\.  
Type: Integer  
Valid Range: Minimum value of 0\.  
Required: Yes

 **StorageCapacityUnits**   <a name="Kendra-Type-CapacityUnitsConfiguration-StorageCapacityUnits"></a>
The amount of extra storage capacity for an index\. Each capacity unit provides 150 Gb of storage space or 500,000 documents, whichever is reached first\.  
Type: Integer  
Valid Range: Minimum value of 0\.  
Required: Yes

## See Also<a name="API_CapacityUnitsConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/CapacityUnitsConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/CapacityUnitsConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/CapacityUnitsConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/CapacityUnitsConfiguration) 