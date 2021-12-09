# Values That You Specify When You Create Namespaces<a name="namespaces-values"></a>

When you create an AWS Cloud Map namespace, you specify the following values\.

**Note**  
You can't change any values in a namespace after you create it\.

**Values**
+ [Namespace name](#namespace-creating-values-name)
+ [Namespace description](#namespace-creating-values-description)
+ [Instance discovery](#namespace-creating-values-instance-discovery)
+ [VPC](#namespace-creating-values-vpc)

**Namespace name**  
The name that you specify for a namespace depends on how you want your application to discover instances, which is determined by the option that you choose for **Instance discovery**, later on the current page in the console\.    
**API calls**  
If you choose this option, your application discovers service instances by specifying the namespace name and service name in a `DiscoverInstances` request\. For more information, see [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html) in the *AWS Cloud Map API Reference*\.  
You can specify a name up to 1,024 characters long\. The name can contain the characters a\-z, A\-Z, 0\-9, \_ \(underscore\), and \- \(hyphen\)\.  
**API calls and DNS queries in VPCs**  
Enter the domain name that you want your applications in a VPC to use when they discover instances by submitting DNS queries\. AWS Cloud Map automatically creates an Amazon Route 53 private hosted zone that has this name\. When you register service instances, AWS Cloud Map creates DNS records in the hosted zone that have names in the following format:  
*service\-name*\.*namespace\-name*  
If you choose this option, your application can also discover instances by specifying the namespace name and service name in a `DiscoverInstances` request\. For more information, see [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html) in the *AWS Cloud Map API Reference*\.  
You can specify an internationalized domain name \(IDN\) if you convert the name to Punycode first\. For information about online converters, perform an internet search on "punycode converter"\.   
You can also convert an internationalized domain name to Punycode when you create namespaces programmatically\. For example, if you're using Java, you can convert a Unicode value to Punycode by using the `toASCII` method of the java\.net\.IDN library\.  
**API calls and public DNS queries**  
Enter the domain name that you want your applications to use when they discover instances by submitting public DNS queries\. This must be a domain name that you have registered\. When you create the namespace, AWS Cloud Map automatically creates an Amazon Route 53 public hosted zone that has the same name\. When you register service instances, AWS Cloud Map creates DNS records in the hosted zone that have names in the following format:  
*service\-name*\.*namespace\-name*  
If you choose this option, your application can also discover instances by specifying the namespace name and service name in a `DiscoverInstances` request\. For more information, see [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html) in the *AWS Cloud Map API Reference*\.  
You can specify an internationalized domain name \(IDN\) if you convert the name to Punycode first\. For information about online converters, perform an internet search on "punycode converter"\.   
You can also convert an internationalized domain name to Punycode when you create namespaces programmatically\. For example, if you're using Java, you can convert a Unicode value to Punycode by using the `toASCII` method of the java\.net\.IDN library\.

**Namespace description**  
Enter a description for the namespace\. The value that you enter here appears on the **Namespaces** page and on the detail page for each namespace\.

**Instance discovery**  
Choose how you want your application to discover registered instances:     
**API calls**  
Choose this option if you want your application to use only API calls to discover registered instances\.  
**API calls and DNS queries in VPCs**  
Choose this option if you want your application to be able to discover instances using either API calls or using DNS queries in a VPC\. You aren't required to use both methods\.   
**API calls and public DNS queries**  
Choose this option if you want your application to be able to discover instances using either API calls or using public DNS queries\. You aren't required to use both methods\. 

**VPC**  
When you choose **API calls and DNS queries in VPCs** for the value of **Instance discovery**, AWS Cloud Map creates an Amazon Route 53 private hosted zone that has the same name\. AWS Cloud Map associates the VPC that you choose in the **VPC** list with that private hosted zone\.  
Route 53 Resolver resolves DNS queries that originate in the VPC using records in the private hosted zone\. If the private hosted zone doesn't include a record that matches the domain name in a DNS query, Route 53 responds to the query with `NXDOMAIN` \(non\-existent domain\)\.  
You can associate additional VPCs with the private hosted zone\. For more information, see [AssociateVPCWithHostedZone](https://docs.aws.amazon.com/Route53/latest/APIReference/API_AssociateVPCWithHostedZone.html) in the *Amazon Route 53 API Reference*\.