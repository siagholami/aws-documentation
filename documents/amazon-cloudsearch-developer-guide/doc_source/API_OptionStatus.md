# OptionStatus<a name="API_OptionStatus"></a>

## Description<a name="API_OptionStatus_Description"></a>

The status of domain configuration option\.

## Contents<a name="API_OptionStatus_Contents"></a>

 **CreationDate**   
A timestamp for when this option was created\.  
Type: DateTime  
 Required: Yes 

 **PendingDeletion**   
Indicates that the option will be deleted once processing is complete\.  
Type: Boolean  
 Required: No 

 **State**   
The state of processing a change to an option\. Possible values:  
+ `RequiresIndexDocuments`: the option's latest value will not be deployed until [IndexDocuments](API_IndexDocuments.md) has been called and indexing is complete\.
+ `Processing`: the option's latest value is in the process of being activated\.
+ `Active`: the option's latest value is completely deployed\.
+ `FailedToValidate`: the option value is not compatible with the domain's data and cannot be used to index the data\. You must either modify the option value or update or remove the incompatible documents\.
Type: String  
 Valid Values: `RequiresIndexDocuments | Processing | Active | FailedToValidate`   
 Required: Yes 

 **UpdateDate**   
A timestamp for when this option was last updated\.  
Type: DateTime  
 Required: Yes 

 **UpdateVersion**   
A unique integer that indicates when this option was last updated\.  
Type: Integer  
 Required: No 