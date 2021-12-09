# Values That You Specify When You Register or Update Instances<a name="instances-values"></a>

When you register a service instance, you specify the following values\.

**Values**
+ [Instance type](#instance-registering-values-type)
+ [Service instance ID](#instance-registering-values-id)
+ [IPv4 address](#instance-registering-values-ipv4-address)
+ [IPv6 address](#instance-registering-values-ipv6-address)
+ [Port](#instance-registering-values-port)
+ [CNAME](#instance-registering-values-cname)
+ [Custom attributes](#instance-registering-values-custom-attributes)

**Instance type**  
Each of the following instance types is available for selected configurations only\.    
**IP address**  
Choose this option when the resource that's associated with the service instance is accessible using an IP address\.  
You can choose this option for all three types of namespaces: HTTP, public DNS, and private DNS\. For public and private DNS namespaces, it's available only when the service doesn't include a CNAME record\.  
**Identifying information for another resource**  
Choose this option when the resource that's associated with the service instance is accessible using values other than an IP address or a domain name \(CNAME\)\. Specify the other values in **Custom attributes**\.  
You can choose this option only for HTTP namespaces\. In addition, it's available only when the service that you're using to register the instance either doesn't include a health check or includes a custom health check\.  
**Identifying information for another resource based on **CNAME****  
Choose this option when the resource that's associated with the service instance is accessible using a domain name \(**CNAME**\)\.  
You can choose this option only for public and private DNS namespaces and only when the service includes a **CNAME** record\.

**Service instance ID**  
An identifier that you want to associate with the instance\. Note the following:  
+ To register a new instance, you must specify a value that is unique among instances that you register by using the same service\.
+ If the service that is specified by **Service instance ID** includes settings for an **SRV** record, the value of **Service instance ID** is automatically included as part of the value for the **SRV** record\. For more information, see **Record type** in the section [Values That You Specify When You Create Services](services-values.md)\.
+ You can update an existing instance programmatically\. Call [RegisterInstance](https://docs.aws.amazon.com/cloud-map/latest/api/API_RegisterInstance.html), specify the value of **Service instance ID** and **Service ID**, and specify the new settings for the service instance\. If AWS Cloud Map created a health check when you registered the instance originally, AWS Cloud Map deletes the old health check and creates a new one\.
**Note**  
The health check isn't deleted immediately, so it will still appear for a while if you submit an Amazon Route 53 `ListHealthChecks` request, for example\.

**IPv4 address**  
The IPv4 IP address, if any, where your applications can access the resource that's associated with this service instance\.

**IPv6 address**  
The IPv6 IP address, if any, where your applications can access the resource that's associated with this service instance\.

**Port**  
The port, if any, that your applications must include to access the resource that's associated with this service instance\. **Port** is required when the service includes an **SRV** record or an Amazon Route 53 health check\.

**CNAME**  
The domain or subdomain name that your applications can use to access the resource that's associated with this service instance\.

**Custom attributes**  
If a resource is accessible using some method other than an IP address or a domain or subdomain name, specify one or more custom attributes that your application can use to access the resource\. You can also use custom attributes for a variety of other purposes\.   
You can add up to 30 custom attributes\. Note the following:  
+ If you don't specify values for any of the following fields, you must specify at least one key\-value pair for **Custom attributes**: **IPv4 address**, **IPv6 address**, **Port**, or **CNAME**\.
+ You must specify both **Key** and **Value**\.
+ **Key** can be up to 255 characters long and can include the characters a\-z, A\-Z, 0\-9 and other printable ASCII characters between 33 and 126 \(Decimal\)\. Spaces, tabs, and other whitespace characters are not allowed\.
+ **Value** can be up to 1,024 characters long and can include the characters a\-z, A\-Z, 0\-9, other printable ASCII characters between 33 and 126 \(Decimal\), space, and tab\.