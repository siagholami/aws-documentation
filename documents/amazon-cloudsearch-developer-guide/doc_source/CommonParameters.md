# Common Parameters<a name="CommonParameters"></a>

This section lists the request parameters that all actions use\. Any action\-specific parameters are listed in the topic for the action\.

 **Action**   
The action to be performed\.  
Default: None  
Type: string  
 Required: Yes 

 **AuthParams**   
The parameters that are required to authenticate a Conditional request\. Contains:  
+ AWSAccessKeyID
+ SignatureVersion
+ Timestamp
+ Signature
Default: None  
 Required: Conditional 

 **AWSAccessKeyId**   
The access key ID that corresponds to the secret access key that you used to sign the request\.  
Default: None  
Type: string  
 Required: Yes 

 **Expires**   
The date and time when the request signature expires, expressed in the format YYYY\-MM\-DDThh:mm:ssZ, as specified in the ISO 8601 standard\.  
Condition: Requests must include either *Timestamp* or *Expires*, but not both\.  
Default: None  
Type: string  
 Required: Conditional 

 **SecurityToken**   
The temporary security token that was obtained through a call to AWS Security Token Service\. For a list of services that support AWS Security Token Service, go to [Using Temporary Security Credentials to Access AWS](http://docs.aws.amazon.com/IAM/latest/UsingSTS/UsingTokens.html) in **Using Temporary Security Credentials**\.  
Default: None  
Type: string  
 Required: No 

 **Signature**   
The digital signature that you created for the request\. For information about generating a signature, go to the service's developer documentation\.  
Default: None  
Type: string  
 Required: Yes 

 **SignatureMethod**   
The hash algorithm that you used to create the request signature\.  
Default: None  
Type: string  
 Valid Values: `HmacSHA256 | HmacSHA1`   
 Required: Yes 

 **SignatureVersion**   
The signature version you use to sign the request\. Set this to the value that is recommended for your service\.  
Default: None  
Type: string  
 Required: Yes 

 **Timestamp**   
The date and time when the request was signed, expressed in the format YYYY\-MM\-DDThh:mm:ssZ, as specified in the ISO 8601 standard\.  
Condition: Requests must include either *Timestamp* or *Expires*, but not both\.  
Default: None  
Type: string  
 Required: Conditional 

 **Version**   
The API version that the request is written for, expressed in the format YYYY\-MM\-DD\.  
Default: None  
Type: string  
 Required: Yes 