# DomainEndpointOptions<a name="API_DomainEndpointOptions"></a>

## Description<a name="API_DomainEndpointOptions_Description"></a>

Whether to require that all requests to the domain arrive over HTTPS\. We recommend `Policy-Min-TLS-1-2-2019-07` for `TLSSecurityPolicy`\. For compatibility with older clients, the default is `Policy-Min-TLS-1-0-2019-07`\.

## Contents<a name="API_DomainEndpointOptions_Contents"></a>

 **EnforceHTTPS**  
Enables or disables the requirement that all requests to the domain arrive over HTTPS\.  
Type: Boolean  
Valid Values: `true | false`  
Required: No

 **TLSSecurityPolicy**  
The minimum required TLS version\.  
Type: String  
Valid Values: `Policy-Min-TLS-1-2-2019-07 | Policy-Min-TLS-1-0-2019-07`  
Required: No