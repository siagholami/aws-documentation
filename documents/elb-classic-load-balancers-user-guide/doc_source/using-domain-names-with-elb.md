# Configure a custom domain name for your Classic Load Balancer<a name="using-domain-names-with-elb"></a>

Each Classic Load Balancer receives a default Domain Name System \(DNS\) name\. This DNS name includes the name of the AWS Region in which the load balancer is created\. For example, if you create a load balancer named `my-loadbalancer` in the US West \(Oregon\) Region, your load balancer receives a DNS name such as `my-loadbalancer-1234567890.us-west-2.elb.amazonaws.com`\. To access the website on your instances, you paste this DNS name into the address field of a web browser\. However, this DNS name is not easy for your customers to remember and use\.

If you'd prefer to use a friendly DNS name for your load balancer, such as `www.example.com`, instead of the default DNS name, you can create a custom domain name and associate it with the DNS name for your load balancer\. When a client makes a request using this custom domain name, the DNS server resolves it to the DNS name for your load balancer\.

**Topics**
+ [Associating your custom domain name with your load balancer name](#dns-associate-custom-elb)
+ [Configure DNS failover for your load balancer](#configure-dns-failover)
+ [Disassociating your custom domain name from your load balancer](#dns-disassociate-custom-elb)

## Associating your custom domain name with your load balancer name<a name="dns-associate-custom-elb"></a>

First, if you haven't already done so, register your domain name\. The Internet Corporation for Assigned Names and Numbers \(ICANN\) manages domain names on the internet\. You register a domain name using a *domain name registrar*, an ICANN\-accredited organization that manages the registry of domain names\. The website for your registrar will provide detailed instructions and pricing information for registering your domain name\. For more information, see the following resources:
+ To use Amazon Route 53 to register a domain name, see [Registering domain names using Route 53](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/registrar.html) in the *Amazon Route 53 Developer Guide*\.
+ For a list of accredited registrars, see the [Accredited Registrar Directory](http://www.internic.net/regist.html)\.

Next, use your DNS service, such as your domain registrar, to create a CNAME record to route queries to your load balancer\. For more information, see the documentation for your DNS service\.

Alternatively, you can use Route 53 as your DNS service\. You create a *hosted zone*, which contains information about how to route traffic on the internet for your domain, and an *alias resource record set*, which routes queries for your domain name to your load balancer\. Route 53 doesn't charge for DNS queries for alias record sets, and you can use alias record sets to route DNS queries to your load balancer for the zone apex of your domain \(for example, `example.com`\)\. For information about transferring DNS services for existing domains to Route 53, see [Configuring Route 53 as your DNS service](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-configuring.html) in the *Amazon Route 53 Developer Guide*\.

Finally, create a hosted zone and an alias record set for your domain using Route 53\. For more information, see [Routing traffic to a load balancer](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/routing-to-elb-load-balancer.html) in the *Amazon Route 53 Developer Guide*\.

## Configure DNS failover for your load balancer<a name="configure-dns-failover"></a>

If you use Route 53 to route DNS queries to your load balancer, you can also configure DNS failover for your load balancer using Route 53\. In a failover configuration, Route 53 checks the health of the registered EC2 instances for the load balancer to determine whether they are available\. If there are no healthy EC2 instances registered with the load balancer, or if the load balancer itself is unhealthy, Route 53 routes traffic to another available resource, such as a healthy load balancer or a static website in Amazon S3\.

For example, suppose that you have a web application for `www.example.com`, and you want redundant instances running behind two load balancers residing in different Regions\. You want the traffic to be primarily routed to the load balancer in one Region, and you want to use the load balancer in the other Region as a backup during failures\. If you configure DNS failover, you can specify your primary and secondary \(backup\) load balancers\. Route 53 directs traffic to the primary load balancer if it is available, or to the secondary load balancer otherwise\.

For more information, see [Configuring DNS failover](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-failover-configuring.html) in the *Amazon Route 53 Developer Guide*\.

## Disassociating your custom domain name from your load balancer<a name="dns-disassociate-custom-elb"></a>

You can disassociate your custom domain name from a load balancer instance by first deleting the resource record sets in your hosted zone and then deleting the hosted zone\. For more information, see [Editing records](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/resource-record-sets-editing.html) and [Deleting a public hosted zone](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/DeleteHostedZone.html) in the *Amazon Route 53 Developer Guide*\.