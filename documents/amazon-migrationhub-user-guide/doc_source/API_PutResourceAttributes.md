# PutResourceAttributes<a name="API_PutResourceAttributes"></a>

Provides identifying details of the resource being migrated so that it can be associated in the Application Discovery Service repository\. This association occurs asynchronously after `PutResourceAttributes` returns\.

**Important**  
Keep in mind that subsequent calls to PutResourceAttributes will override previously stored attributes\. For example, if it is first called with a MAC address, but later, it is desired to *add* an IP address, it will then be required to call it with *both* the IP and MAC addresses to prevent overriding the MAC address\.
Note the instructions regarding the special use case of the [ `ResourceAttributeList` ](https://docs.aws.amazon.com/migrationhub/latest/ug/API_PutResourceAttributes.html#migrationhub-PutResourceAttributes-request-ResourceAttributeList) parameter when specifying any "VM" related value\.

**Note**  
Because this is an asynchronous call, it will always return 200, whether an association occurs or not\. To confirm if an association was found based on the provided details, call `ListDiscoveredResources`\.

## Request Syntax<a name="API_PutResourceAttributes_RequestSyntax"></a>

```
{
   "DryRun": boolean,
   "MigrationTaskName": "string",
   "ProgressUpdateStream": "string",
   "ResourceAttributeList": [ 
      { 
         "Type": "string",
         "Value": "string"
      }
   ]
}
```

## Request Parameters<a name="API_PutResourceAttributes_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DryRun](#API_PutResourceAttributes_RequestSyntax) **   <a name="migrationhub-PutResourceAttributes-request-DryRun"></a>
Optional boolean flag to indicate whether any effect should take place\. Used to test if the caller has permission to make the call\.  
Type: Boolean  
Required: No

 ** [MigrationTaskName](#API_PutResourceAttributes_RequestSyntax) **   <a name="migrationhub-PutResourceAttributes-request-MigrationTaskName"></a>
Unique identifier that references the migration task\. *Do not store personal data in this field\.*   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `[^:|]+`   
Required: Yes

 ** [ProgressUpdateStream](#API_PutResourceAttributes_RequestSyntax) **   <a name="migrationhub-PutResourceAttributes-request-ProgressUpdateStream"></a>
The name of the ProgressUpdateStream\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Pattern: `[^/:|\000-\037]+`   
Required: Yes

 ** [ResourceAttributeList](#API_PutResourceAttributes_RequestSyntax) **   <a name="migrationhub-PutResourceAttributes-request-ResourceAttributeList"></a>
Information about the resource that is being migrated\. This data will be used to map the task to a resource in the Application Discovery Service repository\.  
Takes the object array of `ResourceAttribute` where the `Type` field is reserved for the following values: `IPV4_ADDRESS | IPV6_ADDRESS | MAC_ADDRESS | FQDN | VM_MANAGER_ID | VM_MANAGED_OBJECT_REFERENCE | VM_NAME | VM_PATH | BIOS_ID | MOTHERBOARD_SERIAL_NUMBER` where the identifying value can be a string up to 256 characters\.
+ If any "VM" related value is set for a `ResourceAttribute` object, it is required that `VM_MANAGER_ID`, as a minimum, is always set\. If `VM_MANAGER_ID` is not set, then all "VM" fields will be discarded and "VM" fields will not be used for matching the migration task to a server in Application Discovery Service repository\. See the [Example](https://docs.aws.amazon.com/migrationhub/latest/ug/API_PutResourceAttributes.html#API_PutResourceAttributes_Examples) section below for a use case of specifying "VM" related values\.
+  If a server you are trying to match has multiple IP or MAC addresses, you should provide as many as you know in separate type/value pairs passed to the `ResourceAttributeList` parameter to maximize the chances of matching\.
Type: Array of [ResourceAttribute](API_ResourceAttribute.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Required: Yes

## Response Elements<a name="API_PutResourceAttributes_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_PutResourceAttributes_Errors"></a>

 **AccessDeniedException**   
You do not have sufficient access to perform this action\.  
HTTP Status Code: 400

 **DryRunOperation**   
Exception raised to indicate a successfully authorized action when the `DryRun` flag is set to "true"\.  
HTTP Status Code: 400

 **HomeRegionNotSetException**   
The home region is not set\. Set the home region to continue\.  
HTTP Status Code: 400

 **InternalServerError**   
Exception raised when an internal, configuration, or dependency error is encountered\.  
HTTP Status Code: 500

 **InvalidInputException**   
Exception raised when the provided input violates a policy constraint or is entered in the wrong format or data type\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Exception raised when the request references a resource \(Application Discovery Service configuration, update stream, migration task, etc\.\) that does not exist in Application Discovery Service \(Application Discovery Service\) or in Migration Hub's repository\.  
HTTP Status Code: 400

 **ServiceUnavailableException**   
Exception raised when there is an internal, configuration, or dependency error encountered\.  
HTTP Status Code: 500

 **ThrottlingException**   
The request was denied due to request throttling\.  
HTTP Status Code: 400

 **UnauthorizedOperation**   
Exception raised to indicate a request was not authorized when the `DryRun` flag is set to "true"\.  
HTTP Status Code: 400

## Example<a name="API_PutResourceAttributes_Examples"></a>

### Put migration resource attributes to associate with resource in repository<a name="API_PutResourceAttributes_Example_1"></a>

The following example sends identifying details of the resource being migrated so that it can be associated with a resource in the Application Discovery Service's repository using the values passed to the required parameters `MigrationTaskName` and `ProgressUpdateStream` to tag the correct target and its migration tool\.

The `ResourceAttributeList` parameter is also required to define the resource type and its identifying value\. Its `Type` field is reserved for the following values: `IPV4_ADDRESS | IPV6_ADDRESS | MAC_ADDRESS | FQDN | VM_MANAGER_ID | VM_MANAGED_OBJECT_REFERENCE | VM_NAME | VM_PATH | BIOS_ID | MOTHERBOARD_SERIAL_NUMBER` where the identifying value can be a string up to 256 characters\.

In this particular example, the user wants to define the resource type by `VM_NAME`, but also has to set the `VM_MANAGER_ID` field as it is always required when setting any other "VM" related fields\.

#### Sample Request<a name="API_PutResourceAttributes_Example_1_Request"></a>

```
            
{
   "MigrationTaskName":"canary-4c208ae8-9876-5432-1098-b748dd9179d3",
   "ProgressUpdateStream":"canary-017563f9-1234-5678-9de4-cf9d3378d18d",
   "ResourceAttributeList": [ 
      { 
         "Type":"VM_NAME",
         "Value":"v1.1.1.0-cloudfront"
      },
      { 
         "Type":"VM_MANAGER_ID",
         "Value":"a7b4c06d-e12f-1234-9gh7-i5j26k1lm2no"
      }
   ]
}
```

## See Also<a name="API_PutResourceAttributes_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/PutResourceAttributes) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/PutResourceAttributes) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/PutResourceAttributes) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/PutResourceAttributes) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/PutResourceAttributes) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/PutResourceAttributes) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/PutResourceAttributes) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/PutResourceAttributes) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/PutResourceAttributes) 