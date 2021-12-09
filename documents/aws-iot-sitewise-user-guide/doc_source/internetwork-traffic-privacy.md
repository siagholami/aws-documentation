# Internetwork traffic privacy<a name="internetwork-traffic-privacy"></a>

Connections between AWS IoT SiteWise and on\-premise applications, such as gateways, are secured over Transport Layer Security \(TLS\) connections\. For more information, see [Encryption in transit](encryption-in-transit.md)\.

AWS IoT SiteWise doesn't support connections between Availability Zones within a Region or connections between AWS accounts\.

<a name="cross-region-sso"></a>You can configure AWS SSO in only one Region at a time\. SiteWise Monitor connects to the Region that you configured for AWS SSO\. This means that you use one Region for AWS SSO access, but you can create portals in any Region\.